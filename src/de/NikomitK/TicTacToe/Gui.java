package de.NikomitK.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener {

    // Attribute
    private String spieler = "O";
    final private JButton [] buttons = new JButton[9];


    // Constructor
    public Gui(){
        erzeugeFeld();
    }
    // Methoden
    private void erzeugeFeld(){
        JPanel panelFeld = new JPanel();
        JPanel panelBedienung = new JPanel();
        JButton neuesSpiel = new JButton("Neues Spiel");
        JButton rueckSetzen = new JButton("Zurücksetzen");

        add(panelFeld, BorderLayout.CENTER);
        add(panelBedienung, BorderLayout.EAST);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("TicTacToe!");

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
                setTitle("TicTacToe!");
            }
        });
        rueckSetzen.addActionListener((ActionEvent e) -> {
            for(int i = 0; i<9; i++){
                buttons[i].setText("");
                buttons[i].setEnabled(true);
                setTitle("TicTacToe!");
            }
        });
        panelBedienung.add(neuesSpiel);
        panelBedienung.add(rueckSetzen);

        setVisible(true);
        pack();
        setSize(500, 500);

    }

    public boolean istSpielAus(JButton [] knoepfe){
        return (!knoepfe[0].getText().equals("") && knoepfe[0].getText().equals(knoepfe[1].getText()) && knoepfe[0].getText().equals(knoepfe[2].getText())) ||
                (!knoepfe[3].getText().equals("") && knoepfe[3].getText().equals(knoepfe[4].getText()) && knoepfe[3].getText().equals(knoepfe[5].getText())) ||
                (!knoepfe[6].getText().equals("") && knoepfe[6].getText().equals(knoepfe[7].getText()) && knoepfe[6].getText().equals(knoepfe[8].getText())) ||
                (!knoepfe[0].getText().equals("") && knoepfe[0].getText().equals(knoepfe[3].getText()) && knoepfe[0].getText().equals(knoepfe[6].getText())) ||
                (!knoepfe[1].getText().equals("") && knoepfe[1].getText().equals(knoepfe[4].getText()) && knoepfe[1].getText().equals(knoepfe[7].getText())) ||
                (!knoepfe[2].getText().equals("") && knoepfe[2].getText().equals(knoepfe[5].getText()) && knoepfe[2].getText().equals(knoepfe[8].getText())) ||
                (!knoepfe[0].getText().equals("") && knoepfe[0].getText().equals(knoepfe[4].getText()) && knoepfe[0].getText().equals(knoepfe[8].getText())) ||
                (!knoepfe[2].getText().equals("") && knoepfe[2].getText().equals(knoepfe[4].getText()) && knoepfe[2].getText().equals(knoepfe[6].getText()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(spieler.equals("X")) spieler = "O";
        else spieler = "X";
        JButton button = (JButton) e.getSource();
        if(button.getText().equals("")) button.setText(spieler);
        if(istSpielAus(buttons)) {
            System.out.println("Das Spiel ist aus");
            for(int i = 0; i < 9; i++) buttons[i].setEnabled(false);
            setTitle("TicTacToe!  " + spieler + " hat gewonnen!");
        }
    }

}
