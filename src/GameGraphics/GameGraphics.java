package GameGraphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGraphics extends JPanel implements ActionListener {  //Main

    JFrame frame;

    public GameGraphics() {
        timer.start();
    }
    public GameGraphics(JFrame frame) {
        timer.start();
        this.frame = frame;
    }

    Timer timer = new Timer(20, this);


    public void paint(Graphics g) {
        //отрисовка всех объектов
        Image background = new ImageIcon("./src/GameGraphics/image/background.png").getImage();
        g.drawImage(background, 0, 0, null);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        repaint();
    }
}
