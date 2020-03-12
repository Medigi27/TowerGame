package gameGraphics;

import Map.HandlerAdapters;
import Map.MapGame;
import models.Minion;
import models.SmallTower;
import models.Tower;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameGraphics extends JPanel implements ActionListener {
    Timer timer = new Timer(20, this);
    MapGame mp;

    GameGraphics(MapGame mp) {
        this.mp = mp;
    }
    Minion m = new Minion(MapGame.PATH_IMG_MINION);
    SmallTower st = new SmallTower(MapGame.PATH_IMG_TOWER);
    HandlerAdapters ha = new HandlerAdapters();

    Image background = new ImageIcon("./src/GameGraphics/image/background.png").getImage();
    Image heroImage = new ImageIcon("./src/GameGraphics/image/despicableMe.png").getImage();
    Image tower = new ImageIcon("./src/GameGraphics/image/tower.png").getImage();
    ArrayList<Image> towerList = new ArrayList<>();


    public GameGraphics() {
        timer.start();
        addMouseListener(ha);
        setFocusable(true);
    }


    public void paint(Graphics g) {

        g.drawImage(background, 0, 0, 900,700, null);
        g.drawImage(heroImage, 820, 300, 80, 110, null);
        for (SmallTower iter : ha.getTowers()) {
            g.drawImage(iter.getImage(), iter.getCoord().getX(), iter.getCoord().getY(), 80, 120, null);
        }
        g.drawImage(m.getImgMinion(), m.getCoord().getX(), 350, 60,60, null);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        m.move();
        repaint();
    }

}
