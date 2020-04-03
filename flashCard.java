/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcardfinal;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Elgacson
 */
public class flashCard extends JFrame implements ActionListener  {
            //buttons
    private JButton back = new JButton("Go Back");
    private JButton next = new JButton("Next");
    private JButton flip = new JButton("Flip card");
    
    private JPanel cardPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    
    private final JTextArea cardText = new JTextArea(20,80);
                 
            

    public flashCard() {
        
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


    
    
    
}
