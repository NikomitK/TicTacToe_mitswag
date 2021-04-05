package de.NikomitK.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener {

    // Attribute
    private String spieler = "O";
    private int punkteStandX = 0;
    private int punkteStandY = 0;
    final private JButton [] buttons = new JButton[9];
    JLabel punkteX;
    JLabel punkteY;

    // Constructor
    public Gui(){
        JPanel panelFeld = new JPanel();
        JPanel panelBedienung = new JPanel();
        JPanel panelSpielStand = new JPanel();
        JButton neuesSpiel = new JButton("Neues Spiel");
        neuesSpiel.setBackground(Color.white);
        neuesSpiel.setFocusable(false);
        JButton rueckSetzen = new JButton("Zurücksetzen");
        rueckSetzen.setBackground(Color.white);
        rueckSetzen.setFocusable(false);
        JLabel standX = new JLabel("X", SwingConstants.CENTER);
        standX.setOpaque(true);
        standX.setBackground(Color.gray);
        standX.setBorder(BorderFactory.createLineBorder(Color.darkGray, 2));
        JLabel standY = new JLabel("Y", SwingConstants.CENTER);
        standY.setOpaque(true);
        standY.setBackground(Color.gray);
        standY.setBorder(BorderFactory.createLineBorder(Color.darkGray, 2));punkteX = new JLabel("0", SwingConstants.CENTER);
        punkteX.setOpaque(true);
        punkteX.setBackground(Color.lightGray);
        punkteX.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));punkteY = new JLabel("0", SwingConstants.CENTER);
        punkteY.setOpaque(true);
        punkteY.setBackground(Color.lightGray);
        punkteY.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));

        add(panelFeld, BorderLayout.CENTER);
        add(panelBedienung, BorderLayout.EAST);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("TicTacToe!");

        panelFeld.setLayout(new GridLayout(0, 3));
        panelBedienung.setLayout(new GridLayout(0, 1));
        panelSpielStand.setLayout(new GridLayout(2,2));

        for(int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            buttons[i].addActionListener(this);
            buttons[i].setBackground(Color.lightGray);
            buttons[i].setText("");
            buttons[i].setFocusable(false);
            panelFeld.add(buttons[i]);
        }
        neuesSpiel.addActionListener((ActionEvent e) -> {
            for(int i = 0; i<9; i++){
                buttons[i].setText("");
                buttons[i].setEnabled(true);
                buttons[i].setBackground(Color.lightGray);
            }
            setTitle("TicTacToe!");
        });
        rueckSetzen.addActionListener((ActionEvent e) -> {
            for(int i = 0; i<9; i++){
                buttons[i].setText("");
                buttons[i].setEnabled(true);
                buttons[i].setBackground(Color.lightGray);
            }
            setTitle("TicTacToe!");
        });
        panelBedienung.setBackground(Color.darkGray);
        panelBedienung.add(panelSpielStand);
        panelBedienung.add(neuesSpiel);
        panelBedienung.add(rueckSetzen);
        panelSpielStand.add(standX);
        panelSpielStand.add(standY);
        panelSpielStand.add(punkteX);
        panelSpielStand.add(punkteY);

        setVisible(true);
        pack();
        setSize(500, 500);

    }
    private boolean isFull(JButton [] knoepfe){
        for(int i = 0; i<9; i++) if(knoepfe[i].getText() == "") return false;
        return true;
    }
    public boolean istSpielAus(JButton [] knoepfe){
        return  (!knoepfe[0].getText().equals("") && knoepfe[0].getText().equals(knoepfe[1].getText()) && knoepfe[0].getText().equals(knoepfe[2].getText())) ||
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
        else if(spieler.equals("X")) spieler = "O";
        else if(spieler.equals("O")) spieler = "X";
        if(isFull(buttons)) {
            for(int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            setTitle("TicTacToe!  Gleichstand!");
        }
        if(istSpielAus(buttons)) {
            System.out.println("Das Spiel ist aus");
            for(int i = 0; i < 9; i++) {
                if(buttons[i].getText() != spieler) buttons[i].setBackground(Color.gray);
                buttons[i].setEnabled(false);
            }
            setTitle("TicTacToe!  " + spieler + " hat gewonnen!");
            if(spieler.equals("X")) {
                punkteStandX++;
                punkteX.setText("" + punkteStandX);
            }
            else {
                punkteStandY++;
                punkteY.setText("" + punkteStandY);
            }
            if(punkteStandX > punkteStandY) punkteX.setBackground(Color.cyan);
            else if(punkteStandX < punkteStandY) punkteY.setBackground(Color.cyan);
            else {
                punkteX.setBackground(Color.lightGray);
                punkteY.setBackground(Color.lightGray);
            }
        }
    }

}
