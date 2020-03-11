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

    JFrame frame;

    public GameGraphics() {
        timer.start();
    }

    public void paint(Graphics g) {
        //отрисовка всех объектов
        g = (Graphics2D) g;
        g.drawImage(background, 0, 0, 1000,600, null);
        g.drawLine(0,250, 1000, 250);
        g.drawLine(0,250, 1000, 250);
        //TODO add another visual objects


        g.drawImage(m.minionIcon, m.minionMoving, 250, 80,100, null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        m.move();
        if(m.minionMoving > 950){
            m.minionMoving = 0;
        }
        repaint();
    }



}
