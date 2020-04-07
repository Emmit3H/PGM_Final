package pgm_final;
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
public class FlashCardsFrame extends javax.swing.JFrame{
    //FRAME VARIABLES-----------------------------------------------------------
    protected FileSystem fs;
    protected Path pathToFile;
    protected InputStream fileIn=null;
    protected BufferedReader fileReader;
    protected ArrayList<ArrayList<Flashcard>>Decks=new ArrayList<ArrayList<Flashcard>>();//CREATE AN ARRAYLIST FOR ALL DECKS(TWO DIMENSIONAL ARRAYLIST)
    //FRAME CONSTRUCTORS--------------------------------------------------------
    public FlashCardsFrame(){
        initComponents();
        readFile();
        displayDeck(0);
        displayDeck(1);
        cardTextArea.setText(Decks.get(0).get(0).getSide2());
    }
    //GENERATED CODE------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        cardTextArea = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        flipButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));
        setPreferredSize(new java.awt.Dimension(500, 500));

        cardTextArea.setColumns(20);
        cardTextArea.setRows(5);
        jScrollPane1.setViewportView(cardTextArea);

        backButton.setText("Go Back");
        backButton.setMinimumSize(new java.awt.Dimension(100, 30));
        backButton.setPreferredSize(new java.awt.Dimension(100, 30));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        flipButton.setText("Flip Card");
        flipButton.setMinimumSize(new java.awt.Dimension(100, 30));
        flipButton.setPreferredSize(new java.awt.Dimension(100, 30));
        flipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flipButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.setMinimumSize(new java.awt.Dimension(100, 30));
        nextButton.setPreferredSize(new java.awt.Dimension(100, 30));
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(flipButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(flipButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 204, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed
    private void flipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flipButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_flipButtonActionPerformed
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nextButtonActionPerformed
    //MAIN FRAME CODE-----------------------------------------------------------
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FlashCardsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FlashCardsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FlashCardsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlashCardsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FlashCardsFrame().setVisible(true);
            }
        });
    }
    //FRAME FUNCTIONS-----------------------------------------------------------
    //FILE MANAGEMENT
    protected void readFile(){
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
    protected void displayDeck(int deckNum){//DISPLAY THE CONTENTS OF THE DECK REQUESTED BY THE INT
        System.out.println("Contents of deck "+deckNum+": ");
        for(int i=0;i<Decks.get(deckNum).size();i++){
            System.out.println(Decks.get(deckNum).get(i).toString());
        }
        System.out.println("");
    }
    protected long countDecks(){
        try(Stream<Path>files=Files.list(Paths.get(System.getProperty("user.dir")+"\\src\\flashcardDecks\\"))){
            return (files.count()-1);//OPEN UP A STREAM TO THE DECKS FOLDER, COUNTS EACH FILE AND DIRECTORY INSIDE -1(IGNORES BACKUP)
        }catch(IOException ex){//THROWS AN EXCEPTION IN THE OFF CHANCE IT CANT OPEN THE FILE
            System.out.println("Cannot open "+pathToFile.getFileName());//DISPLAY AN ERROR MESSAGE, AND RETURN ONE SO THAT AT LEAST
            return 1;//THE DEFAULT DECK CAN BE READ FROM FILE
        }
    }
    //GENERATED VARIABLES-------------------------------------------------------
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextArea cardTextArea;
    private javax.swing.JButton flipButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextButton;
    // End of variables declaration//GEN-END:variables
}