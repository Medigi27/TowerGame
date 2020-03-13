package map;

import models.BackObject;

import javax.swing.*;
import java.awt.*;

public class Background {
	public static final Image BackgroundGame = new ImageIcon("src/imagesPolina/imegesGame/backgroundRoad.png").getImage();
	public static final Image BackgroundLooseGame = new ImageIcon("src/imagesPolina/imegesGame/gameOver.png").getImage();
	public static final Image BackgroundWinGame = new ImageIcon("src/imagesPolina/imegesGame/gameWin.png").getImage();
	private Image currentImage;

	public Background() {
		this.currentImage = Background.BackgroundGame;
	}

	public void setBackgroundLooseGame() {
		this.currentImage = Background.BackgroundLooseGame;
	}

	public void setBackgroundWinGame() {
		this.currentImage = BackgroundWinGame;
	}

	public Image getBackground() {
		return (this.currentImage);
	}
}
