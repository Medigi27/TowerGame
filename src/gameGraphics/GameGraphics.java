package gameGraphics;

import models.Minion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameGraphics extends JPanel implements ActionListener {
    Timer timer = new Timer(20, this);

    MinionGraphics m = new MinionGraphics();
    //TODO убрать генерацию миньенов в другой класс
    Image background = new ImageIcon("./src/GameGraphics/image/background.png").getImage();
    Image heroImage = new ImageIcon("./src/GameGraphics/image/despicableMe.png").getImage();


    public GameGraphics() {
        timer.start();
    }

    public void paint(Graphics g) {

        g.drawImage(background, 0, 0, 900,700, null);
        g.drawImage(heroImage, 820, 300, 80, 110, null);
        //TODO add another visual objects


        g.drawImage(m.minionIcon, m.minionMoving, 350, 60,60, null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        m.move();
        if(m.minionMoving > 900){
            m.minionMoving = 0;
        }
        repaint();
    }



}
