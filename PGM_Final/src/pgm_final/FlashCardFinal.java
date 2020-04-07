/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgm_final;
/**
 *
 * @author Elgacson
 */
public class FlashCardFinal{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        flashCardFrame card = new flashCardFrame();
        card.setSize(500,500);
        card.setVisible(true);
        card.readFile();
        card.displayDeck(0);
        card.displayDeck(1);
    }   
}