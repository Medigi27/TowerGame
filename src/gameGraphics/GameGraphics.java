package gameGraphics;

import models.Minion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameGraphics extends JPanel implements ActionListener {

    Image background = new ImageIcon("./src/GameGraphics/image/background.png").getImage();
    Timer timer = new Timer(20, this);
    JFrame frame;

    public GameGraphics(JFrame frame) {
        this.frame = frame;
        timer.start();
        frame.addKeyListener(new KeyAdapter() {


            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub

            }
        });
    }

    public void paint(Graphics g) {
        //отрисовка всех объектов
        this.frame = frame;
        timer.start();
        g.drawImage(background, 0, 0, null);
        //TODO add another visual objects

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        repaint();
    }



}
