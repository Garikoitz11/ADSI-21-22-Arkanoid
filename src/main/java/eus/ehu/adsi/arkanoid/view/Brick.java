package eus.ehu.adsi.arkanoid.view;

import java.awt.Color;
import java.awt.Graphics;

public class Brick extends Rectangle {

	public boolean destroyed = false;
	public Color colorBrick = Color.blue;
	public Brick(double x, double y) {
		this.x = x;
		this.y = y;
		this.sizeX = Config.BLOCK_WIDTH;
		this.sizeY = Config.BLOCK_HEIGHT;
	}

	public void draw(Graphics g) {
		g.setColor(colorBrick);
		g.fillRect((int) left(), (int) top(), (int) sizeX, (int) sizeY);
	}
	public void setColorBrick(Color c3) {
		colorBrick = c3;
	}	
}