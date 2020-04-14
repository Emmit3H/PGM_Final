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
import java.util.stream.Stream;
import javax.swing.JOptionPane;
public class FlashCardsFrame extends javax.swing.JFrame{
    //FRAME VARIABLES-----------------------------------------------------------
    protected FileSystem fs;
    protected String state="browse";
    protected int currentViewedDeck=0,currentViewedCard=0,currentViewedSide=2;
    protected Path pathToFile;
    protected InputStream fileIn=null;
    protected BufferedReader fileReader;
    protected ArrayList<Flashcard>newDeck=new ArrayList<Flashcard>();
    protected ArrayList<Flashcard>markedCards=new ArrayList<Flashcard>();
    protected ArrayList<ArrayList<Flashcard>>Decks=new ArrayList<ArrayList<Flashcard>>();//CREATE AN ARRAYLIST FOR ALL DECKS(TWO DIMENSIONAL ARRAYLIST)
    //FRAME CONSTRUCTORS--------------------------------------------------------
    public FlashCardsFrame(){
        initComponents();
        readFile();
        displayDeck(0);
        displayDeck(1);
        cardTextArea.setText(Decks.get(0).get(0).getSide2());
        userTextLabel.setText("Viewing Deck 0, Card 0, Side 2");
    }
    //GENERATED CODE------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        cardTextArea = new javax.swing.JTextArea();
        leftButton = new javax.swing.JButton();
        middleButton = new javax.swing.JButton();
        rightButton = new javax.swing.JButton();
        editDecksButton = new javax.swing.JButton();
        browseDecksButton = new javax.swing.JButton();
        userTextLabel = new javax.swing.JLabel();
        farRightButton = new javax.swing.JButton();
        farLeftButton = new javax.swing.JButton();
        bottomMiddleButton = new javax.swing.JButton();
        reviewButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Project Management Final");
        setMaximumSize(new java.awt.Dimension(506, 330));
        setMinimumSize(new java.awt.Dimension(506, 330));
        setResizable(false);

        cardTextArea.setColumns(20);
        cardTextArea.setRows(5);
        jScrollPane1.setViewportView(cardTextArea);

        leftButton.setText("Last Card");
        leftButton.setMinimumSize(new java.awt.Dimension(100, 30));
        leftButton.setPreferredSize(new java.awt.Dimension(100, 30));
        leftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButtonActionPerformed(evt);
            }
        });

        middleButton.setText("Flip Card");
        middleButton.setMinimumSize(new java.awt.Dimension(100, 30));
        middleButton.setPreferredSize(new java.awt.Dimension(100, 30));
        middleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                middleButtonActionPerformed(evt);
            }
        });

        rightButton.setText("Next Card");
        rightButton.setMinimumSize(new java.awt.Dimension(100, 30));
        rightButton.setPreferredSize(new java.awt.Dimension(100, 30));
        rightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightButtonActionPerformed(evt);
            }
        });

        editDecksButton.setText("Edit Decks");
        editDecksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDecksButtonActionPerformed(evt);
            }
        });

        browseDecksButton.setText("Browse Decks");
        browseDecksButton.setEnabled(false);
        browseDecksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseDecksButtonActionPerformed(evt);
            }
        });

        userTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userTextLabel.setText("important text");

        farRightButton.setText("Next Deck");
        farRightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                farRightButtonActionPerformed(evt);
            }
        });

        farLeftButton.setText("Last Deck");
        farLeftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                farLeftButtonActionPerformed(evt);
            }
        });

        bottomMiddleButton.setText("Mark Card");
        bottomMiddleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bottomMiddleButtonActionPerformed(evt);
            }
        });

        reviewButton.setText("REVIEW MARKED CARDS");
        reviewButton.setEnabled(false);
        reviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(farLeftButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(leftButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(middleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rightButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(farRightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(editDecksButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bottomMiddleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(browseDecksButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(reviewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(userTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(rightButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leftButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(middleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(farRightButton)
                    .addComponent(farLeftButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(browseDecksButton)
                    .addComponent(editDecksButton)
                    .addComponent(bottomMiddleButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reviewButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void leftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButtonActionPerformed
        if(state.equals("browse")){
            currentViewedCard--;
            currentViewedSide=2;
            if(currentViewedCard==-1){
                currentViewedCard=Decks.get(currentViewedDeck).size()-1;
            }
            cardTextArea.setText(Decks.get(currentViewedDeck).get(currentViewedCard).getSide2());
            userTextLabel.setText("Viewing Deck "+currentViewedDeck+", Card "+currentViewedCard+", Side "+currentViewedSide);
        }else if(state.equals("review")){
            currentViewedCard--;
            currentViewedSide=2;
            if(currentViewedCard==-1){
                currentViewedCard=markedCards.size()-1;
            }
            cardTextArea.setText(markedCards.get(currentViewedCard).getSide1());
            userTextLabel.setText("Reviewing Card "+currentViewedCard+", Side "+currentViewedSide);
        }else if(state.equals("edit")){
            currentViewedSide=1;
            newDeck.get(currentViewedCard).setSide2(cardTextArea.getText());
            leftButton.setEnabled(false);
            rightButton.setEnabled(true);
            cardTextArea.setText(newDeck.get(currentViewedCard).getSide1());
            userTextLabel.setText("Editing Card "+currentViewedCard+", Side "+currentViewedSide);
        }
    }//GEN-LAST:event_leftButtonActionPerformed
    private void middleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_middleButtonActionPerformed
        if(state.equals("browse")){
            if(currentViewedSide==1){
                currentViewedSide=2;
                cardTextArea.setText(Decks.get(currentViewedDeck).get(currentViewedCard).getSide2());
            }else if(currentViewedSide==2){
                currentViewedSide=1;
                cardTextArea.setText(Decks.get(currentViewedDeck).get(currentViewedCard).getSide1());
            }
            userTextLabel.setText("Viewing Deck "+currentViewedDeck+", Card "+currentViewedCard+", Side "+currentViewedSide);
        }else if(state.equals("review")){
            if(currentViewedSide==1){
                currentViewedSide=2;
                cardTextArea.setText(markedCards.get(currentViewedCard).getSide2());
            }else if(currentViewedSide==2){
                currentViewedSide=1;
                cardTextArea.setText(markedCards.get(currentViewedCard).getSide1());
            }
            userTextLabel.setText("Reviewing Card "+currentViewedCard+", Side "+currentViewedSide);
        }else if(state.equals("edit")){
            Flashcard aCard=new Flashcard();
            newDeck.add(aCard);
            leftButton.setEnabled(true);
            rightButton.setEnabled(false);
            currentViewedSide=2;
            currentViewedCard=newDeck.size()-1;
            userTextLabel.setText("Editing Card "+currentViewedCard+", Side "+currentViewedSide);
            cardTextArea.setText(newDeck.get(currentViewedCard).getSide2());
        }
    }//GEN-LAST:event_middleButtonActionPerformed
    private void rightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightButtonActionPerformed
        if(state.equals("browse")){
            currentViewedCard++;
            currentViewedSide=2;
            if(currentViewedCard==Decks.get(currentViewedDeck).size()){
                currentViewedCard=0;
            }
            cardTextArea.setText(Decks.get(currentViewedDeck).get(currentViewedCard).getSide2());
            userTextLabel.setText("Viewing Deck "+currentViewedDeck+", Card "+currentViewedCard+", Side "+currentViewedSide);
        }else if(state.equals("review")){
            currentViewedCard++;
            currentViewedSide=2;
            if(currentViewedCard==markedCards.size()){
                currentViewedCard=0;
            }
            cardTextArea.setText(markedCards.get(currentViewedCard).getSide2());
            userTextLabel.setText("Reviewing Card "+currentViewedCard+", Side "+currentViewedSide);
        }else if(state.equals("edit")){
            currentViewedSide=2;
            newDeck.get(currentViewedCard).setSide1(cardTextArea.getText());
            leftButton.setEnabled(true);
            rightButton.setEnabled(false);
            cardTextArea.setText(newDeck.get(currentViewedCard).getSide2());
            userTextLabel.setText("Editing Card "+currentViewedCard+", Side "+currentViewedSide);
        }
    }//GEN-LAST:event_rightButtonActionPerformed
    private void farRightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_farRightButtonActionPerformed
        if(state.equals("browse")){
            currentViewedDeck++;
            currentViewedCard=0;
            currentViewedSide=2;
            if(currentViewedDeck==Decks.size()){
                currentViewedDeck=0;
            }
            cardTextArea.setText(Decks.get(currentViewedDeck).get(currentViewedCard).getSide2());
            userTextLabel.setText("Viewing Deck "+currentViewedDeck+", Card "+currentViewedCard+", Side "+currentViewedSide);
        }else if(state.equals("edit")){
            if(currentViewedSide==1){
                newDeck.get(currentViewedCard).setSide1(cardTextArea.getText());
            }else if(currentViewedSide==2){
                newDeck.get(currentViewedCard).setSide2(cardTextArea.getText());
            }
            leftButton.setEnabled(true);
            rightButton.setEnabled(false);
            currentViewedCard++;
            currentViewedSide=2;
            if(currentViewedCard==newDeck.size()){
                currentViewedCard=0;
            }
            userTextLabel.setText("Editing Card "+currentViewedCard+", Side "+currentViewedSide);
            cardTextArea.setText(newDeck.get(currentViewedCard).getSide2());
        }
    }//GEN-LAST:event_farRightButtonActionPerformed
    private void farLeftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_farLeftButtonActionPerformed
        if(state.equals("browse")){
            currentViewedDeck--;
            currentViewedCard=0;
            currentViewedSide=2;
            if(currentViewedDeck==-1){
                currentViewedDeck=Decks.size()-1;
            }
            cardTextArea.setText(Decks.get(currentViewedDeck).get(currentViewedCard).getSide2());
            userTextLabel.setText("Viewing Deck "+currentViewedDeck+", Card "+currentViewedCard+", Side "+currentViewedSide);
        }else if(state.equals("edit")){
            if(currentViewedSide==1){
                newDeck.get(currentViewedCard).setSide1(cardTextArea.getText());
            }else if(currentViewedSide==2){
                newDeck.get(currentViewedCard).setSide2(cardTextArea.getText());
            }
            leftButton.setEnabled(true);
            rightButton.setEnabled(false);
            currentViewedCard--;
            currentViewedSide=2;
            if(currentViewedCard==-1){
                currentViewedCard=newDeck.size()-1;
            }
            userTextLabel.setText("Editing Card "+currentViewedCard+", Side "+currentViewedSide);
            cardTextArea.setText(newDeck.get(currentViewedCard).getSide2());
        }
    }//GEN-LAST:event_farLeftButtonActionPerformed
    private void editDecksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDecksButtonActionPerformed
        state="edit";
        currentViewedDeck=0;
        currentViewedCard=0;
        currentViewedSide=2;
        userTextLabel.setText("Editing Card "+currentViewedCard+", Side "+currentViewedSide);
        editDecksButton.setEnabled(false);
        browseDecksButton.setEnabled(true);
        bottomMiddleButton.setText("Add Deck");
        middleButton.setText("Make Card");
        leftButton.setText("Edit Side 1");
        rightButton.setText("Edit Side 2");
        leftButton.setEnabled(true);
        rightButton.setEnabled(false);
        farLeftButton.setEnabled(true);
        farRightButton.setEnabled(true);
        farLeftButton.setText("Last Card");
        farRightButton.setText("Next Card");
        if(newDeck.size()==0){
            Flashcard aFlashcard=new Flashcard();
            newDeck.add(aFlashcard);
        }
        cardTextArea.setText(newDeck.get(currentViewedCard).getSide2());
    }//GEN-LAST:event_editDecksButtonActionPerformed
    private void browseDecksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseDecksButtonActionPerformed
        if(state=="edit"){
            if(currentViewedSide==1){
                newDeck.get(currentViewedCard).setSide1(cardTextArea.getText());
            }else if(currentViewedSide==2){
                newDeck.get(currentViewedCard).setSide2(cardTextArea.getText());
            }
        }
        state="browse";
        editDecksButton.setEnabled(true);
        browseDecksButton.setEnabled(false);
        leftButton.setEnabled(true);
        rightButton.setEnabled(true);
        farLeftButton.setEnabled(true);
        farRightButton.setEnabled(true);
        middleButton.setText("Flip Card");
        leftButton.setText("Last Card");
        rightButton.setText("Next Card");
        farLeftButton.setText("Last Deck");
        farRightButton.setText("Next Deck");
        bottomMiddleButton.setText("Mark Card");
        currentViewedDeck=0;
        currentViewedCard=0;
        currentViewedSide=2;
        cardTextArea.setText(Decks.get(currentViewedDeck).get(currentViewedCard).getSide2());
        userTextLabel.setText("Viewing Deck "+currentViewedDeck+", Card "+currentViewedCard+", Side "+currentViewedSide);
    }//GEN-LAST:event_browseDecksButtonActionPerformed
    private void bottomMiddleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottomMiddleButtonActionPerformed
        if(state.equals("browse")){
            markedCards.add(Decks.get(currentViewedDeck).get(currentViewedCard));
            reviewButton.setEnabled(true);
        }else if(state.equals("edit")){
            writeToFile(newDeck);
            newDeck=new ArrayList<Flashcard>();
            Decks=new ArrayList<ArrayList<Flashcard>>();
            readFile();
            state="browse";
            editDecksButton.setEnabled(true);
            browseDecksButton.setEnabled(false);
            leftButton.setEnabled(true);
            rightButton.setEnabled(true);
            middleButton.setText("Flip Card");
            leftButton.setText("Last Card");
            rightButton.setText("Next Card");
            farLeftButton.setText("Last Deck");
            farRightButton.setText("Next Deck");
            bottomMiddleButton.setText("Mark Card");
            currentViewedDeck=0;
            currentViewedCard=0;
            currentViewedSide=2;
            cardTextArea.setText(Decks.get(currentViewedDeck).get(currentViewedCard).getSide2());
            userTextLabel.setText("Viewing Deck "+currentViewedDeck+", Card "+currentViewedCard+", Side "+currentViewedSide);
        }
    }//GEN-LAST:event_bottomMiddleButtonActionPerformed
    private void reviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewButtonActionPerformed
        state="review";
        editDecksButton.setEnabled(true);
        browseDecksButton.setEnabled(true);
        reviewButton.setEnabled(false);
        leftButton.setEnabled(true);
        rightButton.setEnabled(true);
        farLeftButton.setEnabled(false);
        farRightButton.setEnabled(false);
        middleButton.setText("Flip Card");
        leftButton.setText("Last Card");
        rightButton.setText("Next Card");
        farLeftButton.setText("Last Deck");
        farRightButton.setText("Next Deck");
        bottomMiddleButton.setText("Mark Card");
        currentViewedDeck=0;
        currentViewedCard=0;
        currentViewedSide=2;
        cardTextArea.setText(markedCards.get(currentViewedCard).getSide2());
        userTextLabel.setText("Reviewing Card "+currentViewedCard+", Side "+currentViewedSide);
    }//GEN-LAST:event_reviewButtonActionPerformed
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
                   String records[]=line.split("<μετάβαση>");
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
    protected void writeToFile(ArrayList<Flashcard> aDeck){
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
    private javax.swing.JButton bottomMiddleButton;
    private javax.swing.JButton browseDecksButton;
    private javax.swing.JTextArea cardTextArea;
    private javax.swing.JButton editDecksButton;
    private javax.swing.JButton farLeftButton;
    private javax.swing.JButton farRightButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton leftButton;
    private javax.swing.JButton middleButton;
    private javax.swing.JButton reviewButton;
    private javax.swing.JButton rightButton;
    private javax.swing.JLabel userTextLabel;
    // End of variables declaration//GEN-END:variables
}