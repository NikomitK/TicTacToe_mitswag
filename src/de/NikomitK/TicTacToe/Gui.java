package de.NikomitK.TicTacToe;

import javax.swing.*;

public class Gui extends JFrame {

    public static Ticfeld tf;
    private static JPanel knopfFeld;


    private static void erzeugeFeld(){
        tf  = new Ticfeld();


    }

    public static void main(String[] args){
        erzeugeFeld();
    }

}
