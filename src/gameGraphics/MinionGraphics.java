package gameGraphics;

import java.awt.*;
import javax.swing.ImageIcon;

public class MinionGraphics {
    Image minionIcon = new ImageIcon("./src/GameGraphics/image/minion.png").getImage();

    int minionSpeed = 3;

    int minionMoving = 0;

    public void move() {

        minionMoving += minionSpeed;


    }
}
