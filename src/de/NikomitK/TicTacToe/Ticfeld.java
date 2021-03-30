package de.NikomitK.TicTacToe;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Ticfeld {
    JButton [] buttons = new JButton[9];

    public Ticfeld(){
        for(int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            buttons[i].addActionListener((ActionEvent e) -> {
                if(buttons[i].getText() != null) buttons[i].setText();
            });
        }
    }
    

}
