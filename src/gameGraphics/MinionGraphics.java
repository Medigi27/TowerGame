package gameGraphics;

import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class MinionGraphics {
    int zoneClickX; //tower
    int zoneClickY; //tower
    Image minionIcon = new ImageIcon("./src/GameGraphics/image/minion.png").getImage();

    int minionSpeed = 3;

    int minionMoving = 0;

    public void move() {
        minionMoving += minionSpeed;
    }

    //tower
    public void mouseClicked(MouseEvent e) {
        zoneClickX = e.getX();
        zoneClickY = e.getY();
    }
}
