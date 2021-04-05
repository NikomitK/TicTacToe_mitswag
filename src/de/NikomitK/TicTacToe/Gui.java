package de.NikomitK.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener {

    // Attribute
    private String spieler;
    private JButton neuesSpiel, rueckSetzen;
    private JButton [] buttons = new JButton[9];
    private JPanel panelFeld, panelBedienung;


    // Constructor
    public Gui(){
        erzeugeFeld();
    }
    // Methoden
    private void erzeugeFeld(){
        panelFeld = new JPanel();
        panelBedienung = new JPanel();
        neuesSpiel = new JButton("Neues Spiel");
        rueckSetzen = new JButton("Zurücksetzen");

        add(panelFeld, BorderLayout.CENTER);
        add(panelBedienung, BorderLayout.EAST);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("PeNiS lMaO moin Justin du keks");

        panelFeld.setLayout(new GridLayout(0, 3));
        panelBedienung.setLayout(new GridLayout(0, 1));

        for(int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            buttons[i].addActionListener(this);
            buttons[i].setBackground(Color.lightGray);
            buttons[i].setText("");
            panelFeld.add(buttons[i]);
        }
        neuesSpiel.addActionListener((ActionEvent e) -> {
            for(int i = 0; i<9; i++){
                buttons[i].setText("");
                buttons[i].setEnabled(true);
            }
        });
        rueckSetzen.addActionListener((ActionEvent e) -> {
            for(int i = 0; i<9; i++){
                buttons[i].setText("");
                buttons[i].setEnabled(true);
            }
        });
        panelBedienung.add(neuesSpiel);
        panelBedienung.add(rueckSetzen);

        setVisible(true);
        pack();
        setSize(500, 500);

    }

    public boolean istSpielAus(JButton [] knoepfe){
        if(
                (buttons[0].getText() != "" &&buttons[0].getText() == buttons[1].getText() && buttons[0].getText() == buttons[2].getText()) ||
                (buttons[3].getText() != "" &&buttons[3].getText() == buttons[4].getText() && buttons[3].getText() == buttons[5].getText()) ||
                (buttons[6].getText() != "" &&buttons[6].getText() == buttons[7].getText() && buttons[6].getText() == buttons[8].getText())||
                (buttons[0].getText() != "" &&buttons[0].getText() == buttons[3].getText() && buttons[0].getText() == buttons[6].getText())||
                (buttons[1].getText() != "" &&buttons[1].getText() == buttons[4].getText() && buttons[1].getText() == buttons[7].getText())||
                (buttons[2].getText() != "" &&buttons[2].getText() == buttons[5].getText() && buttons[2].getText() == buttons[8].getText())||
                (buttons[0].getText() != "" &&buttons[0].getText() == buttons[4].getText() && buttons[0].getText() == buttons[8].getText())||
                (buttons[2].getText() != "" &&buttons[2].getText() == buttons[4].getText() && buttons[2].getText() == buttons[6].getText())
        )
            return true;
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(spieler == "X") spieler = "O";
        else spieler = "X";
        JButton button = (JButton) e.getSource();
        if(button.getText() == "") button.setText(spieler);
        if(istSpielAus(buttons)) {
            System.out.println("Das Spiel ist aus");
            for(int i = 0; i < 9; i++) buttons[i].setEnabled(false);
        }
    }

}
