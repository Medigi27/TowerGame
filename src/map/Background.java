package map;

import other.Config;
import other.Coordinates;

import javax.swing.*;
import java.awt.*;

public class Background {
	public static final Image BackgroundGame = new ImageIcon("src/imagesPolina/imegesGame/backgroundRoad.png").getImage();
	public static final Image BackgroundLooseGame = new ImageIcon("src/imagesPolina/imegesGame/gameOver.png").getImage();
	public static final Image BackgroundWinGame = new ImageIcon("src/imagesPolina/imegesGame/gameWin.png").getImage();
	private Image currentImage;
	private Coordinates coord;
	private int width;
	private int height;
	private Config cfg;

	public Background() {
		this.currentImage = Background.BackgroundGame;
		coord = new Coordinates(0, 0);
		cfg = Config.getInstance();
		this.width = cfg.getCfgValue(Config.WINDOW_WIDTH);
		this.height = cfg.getCfgValue(Config.WINDOW_HEIGHT);
	}

	public Coordinates getCoord() {
		return (this.coord);
	}

	public void setBackgroundLooseGame() {
		this.currentImage = Background.BackgroundLooseGame;
	}

	public int getHeight() {
		return (this.height);
	}

	public int getWidth() {
		return (this.width);
	}

	public void setBackgroundWinGame() {
		this.currentImage = BackgroundWinGame;
	}

	public Image getBackground() {
		return (this.currentImage);
	}
}
