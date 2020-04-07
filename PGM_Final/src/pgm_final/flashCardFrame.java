/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgm_final;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static pgm_final.FlashcardTestingApplication.fs;
import static pgm_final.FlashcardTestingApplication.readFile;
/**
 *
 * @author Elgacson
 */
public class flashCardFrame extends JFrame implements ActionListener  {
            //buttons
    private JButton back = new JButton("Go Back");
    private JButton next = new JButton("Next");
    private JButton flip = new JButton("Flip card");
    private JPanel cardPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private final JTextArea cardText = new JTextArea(20,80);
    public flashCardFrame() {
        setName("flashcards");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,1));
        //creating the button group
        ButtonGroup yn = new ButtonGroup();
        add(cardPanel);
        add(buttonPanel);
        yn.add(back);
        yn.add(next);
        buttonPanel.add(back);
        buttonPanel.add(flip);
        buttonPanel.add(next);
        cardText.setBounds(0, 0, 400, 450);
        cardPanel.add(cardText);   
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object object = ae.getSource();
    } 
    //CODE FOR THE FILE SYSTEM--------------------------------------------------
    //--------------------------------------------------------------------------
    //GLOBAL FILE VARIABLES----------------------------------------------------------
    private FileSystem fs;
    private Path pathToFile;
    private InputStream fileIn=null;
    private BufferedReader fileReader;
    private ArrayList<ArrayList>Decks=new ArrayList<ArrayList>();//CREATE AN ARRAYLIST FOR ALL DECKS(TWO DIMENSIONAL ARRAYLIST)
    //PROGRAM FUNCTIONS---------------------------------------------------------
    public void readFile(){
        long numOfDecks=countDecks();
        System.out.println(numOfDecks);
        fs=FileSystems.getDefault();
        for(int i=0;i<numOfDecks;i++){//LOOP THROUGH FOR EACH INDIVIDUAL FILE AND ADD EACH DECK TO THE allDecks ARRAYLIST
            ArrayList<Flashcard>aDeck=new ArrayList<Flashcard>();//CREATE AN ARRAYLIST FOR A SINGLE DECK
            pathToFile=fs.getPath(System.getProperty("user.dir")+"\\src\\flashcardDecks\\deck"+i+".txt");
            Flashcard aCard;//GENERATE A FILE PATH THAT BUILDS FROM THE ROOT DIRECTORY OF THE JAVA PROJECT ITSELF AND ACCOUNTS FOR 
            String line;//WHICH DECK IT IS CURRENTLY ON
            try{
               fileIn=Files.newInputStream(pathToFile);
               fileReader=new BufferedReader(new InputStreamReader(fileIn));
               //READ THE FIEL
               while((line=fileReader.readLine())!=null){
                   String records[]=line.split(",");
                   aCard=new Flashcard();
                   try{
                       aCard.setSide1(records[0]);
                       aCard.setSide2(records[1]);
                       aDeck.add(aCard);
                   }catch(NumberFormatException numberFormatException){
                       System.out.println("Error parsing through file");
                   }
               }
               fileIn.close();
               System.out.println("Records read = "+aDeck.size());
               Decks.add(aDeck);
            }catch(IOException ex){
                System.out.println("Cannot open "+pathToFile.getFileName());
                System.exit(1);
            }
        }
    }
    public void displayDeck(int deckNum){//DISPLAY THE CONTENTS OF THE DECK REQUESTED BY THE INT
        System.out.println("Contents of deck "+deckNum+": ");
        for(int i=0;i<Decks.get(deckNum).size();i++){
            System.out.println(Decks.get(deckNum).get(i).toString());
        }
        System.out.println("");
    }
    private long countDecks(){
        try(Stream<Path>files=Files.list(Paths.get(System.getProperty("user.dir")+"\\src\\flashcardDecks\\"))){
            return (files.count()-1);//OPEN UP A STREAM TO THE DECKS FOLDER, COUNTS EACH FILE AND DIRECTORY INSIDE -1(IGNORES BACKUP)
        }catch(IOException ex){//THROWS AN EXCEPTION IN THE OFF CHANCE IT CANT OPEN THE FILE
            System.out.println("Cannot open "+pathToFile.getFileName());//DISPLAY AN ERROR MESSAGE, AND RETURN ONE SO THAT AT LEAST
            return 1;//THE DEFAULT DECK CAN BE READ FROM FILE
        }
    }
}