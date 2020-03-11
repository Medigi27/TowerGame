package gameGraphics;

import models.Minion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameGraphics extends JPanel implements ActionListener {
    Timer timer = new Timer(20, this);

    MinionGraphics m = new MinionGraphics();
    //TODO убрать генерацию миньенов в другой класс
    Image background = new ImageIcon("./src/GameGraphics/image/background.png").getImage();
    Image heroImage = new ImageIcon("./src/GameGraphics/image/despicableMe.png").getImage();
    Image tower = new ImageIcon("./src/GameGraphics/image/tower.png").getImage();
    ArrayList<Image> towerList = new ArrayList<>();


    public GameGraphics() {
        timer.start();
        addMouseListener(new MyMouseAdapter());
        setFocusable(true);
    }
//TODO вынести в отдельный файл как паблик класс
    private class MyMouseAdapter extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
            m.mouseClicked(e);

        }
    }

    public void paint(Graphics g) {

        g.drawImage(background, 0, 0, 900,700, null);
        g.drawImage(heroImage, 820, 300, 80, 110, null);
        g.drawImage(tower, m.zoneClickX,m.zoneClickY,80,120, null);
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
