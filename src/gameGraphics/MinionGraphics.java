package gameGraphics;

import java.awt.*;
import javax.swing.ImageIcon;

public class MinionGraphics {
    Image minionIcon = new ImageIcon("./src/GameGraphics/image/minion.png").getImage();

    int v = 3;
    int dv = 0;
    int s = 10;

    int x = 50;
    int y = 300;

    int layer1 = 0;

    public void move() {
        s += v;
        layer1 += v;


    }
}
