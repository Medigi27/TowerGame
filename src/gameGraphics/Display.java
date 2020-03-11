package gameGraphics;

import models.Minion;

import javax.swing.*;


public class Display {
    public static void main(String[] args) {

            JFrame frame = new JFrame(/* название нашей игры */);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(900,700);
            frame.setResizable(false);
            frame.add(new GameGraphics());

            frame.setVisible(true);




        }
}

