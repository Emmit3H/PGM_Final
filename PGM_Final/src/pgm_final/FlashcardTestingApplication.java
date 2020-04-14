package pgm_final;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;
import javax.swing.JOptionPane;
public class FlashcardTestingApplication{
    //GLOBAL VARIABLES----------------------------------------------------------
    static FileSystem fs;
    static Scanner keyboard=new Scanner(System.in);
    static Path pathToFile;
    static InputStream fileIn=null;
    static BufferedReader fileReader;
    static ArrayList<ArrayList>Decks=new ArrayList<ArrayList>();//CREATE AN ARRAYLIST FOR ALL DECKS(TWO DIMENSIONAL ARRAYLIST)
    //MAIN PROGRAM CODE---------------------------------------------------------
    public static void main(String[]args){
        readFile();
        displayDeck(0);
        displayDeck(1);
        displayDeck(2);
    }
    //PROGRAM FUNCTIONS---------------------------------------------------------
   public static void createDeck(){
       ArrayList<Flashcard>newDeck=new ArrayList<Flashcard>();
       Flashcard newCard;
       System.out.print("How many cards do you want in this deck? ");
       int numOfCards=keyboard.nextInt();
       keyboard.nextLine();
       for(int i=0;i<numOfCards;i++){
           newCard=new Flashcard();
           System.out.print("Enter data for side 1: ");
           newCard.setSide1(keyboard.nextLine());
           System.out.print("Enter data for side 2: ");
           newCard.setSide2(keyboard.nextLine());
           newDeck.add(newCard);
       }
       writeToFile(newDeck);
   }
    public static void readFile(){
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
                   String records[]=line.split("<μετάβαση>");//GREEK WORD FOR TANSITION
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
    public static void writeToFile(ArrayList<Flashcard> aDeck){
        long numOfDecks=countDecks();
        String fileName=System.getProperty("user.dir")+"\\src\\flashcardDecks\\deck"+numOfDecks+".txt";
        String outputLine;
        File file=new File(fileName);
        try{
            FileWriter fileOut=new FileWriter(file);
            for(int i=0;i<aDeck.size();i++){
                    /*%d = integer
                    %f = float or double
                    %s = string
                    %n = newline*/
                outputLine=String.format("%s<μετάβαση>%s\n",
                        aDeck.get(i).getSide1(),
                        aDeck.get(i).getSide2());
                fileOut.write(outputLine);
            }
            fileOut.close();
        } catch (IOException ex){
            JOptionPane.showMessageDialog(null,"Cannot write comapny file\n"+ex.getMessage(),"File IO Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void displayDeck(int deckNum){//DISPLAY THE CONTENTS OF THE DECK REQUESTED BY THE INT
        System.out.println("Contents of deck "+deckNum+": ");
        for(int i=0;i<Decks.get(deckNum).size();i++){
            System.out.println(Decks.get(deckNum).get(i).toString());
        }
        System.out.println("");
    }
    public static long countDecks(){
        try(Stream<Path>files=Files.list(Paths.get(System.getProperty("user.dir")+"\\src\\flashcardDecks\\"))){
            return (files.count()-1);//OPEN UP A STREAM TO THE DECKS FOLDER, COUNTS EACH FILE AND DIRECTORY INSIDE -1(IGNORES BACKUP)
        }catch(IOException ex){//THROWS AN EXCEPTION IN THE OFF CHANCE IT CANT OPEN THE FILE
            System.out.println("Cannot open "+pathToFile.getFileName());//DISPLAY AN ERROR MESSAGE, AND RETURN ONE SO THAT AT LEAST
            return 1;//THE DEFAULT DECK CAN BE READ FROM FILE
        }
    }
}
