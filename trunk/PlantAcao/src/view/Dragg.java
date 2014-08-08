package view;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Dragg extends Rectangle {
	
	int posX;
	int posY;
	BufferedImage img;
	
	
	public Dragg(int posX, int posY, BufferedImage img) {
		this.posX = posX;
		this.posY = posY;
		this.img = img;
	}

}
