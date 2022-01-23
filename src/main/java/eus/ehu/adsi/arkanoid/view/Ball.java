package eus.ehu.adsi.arkanoid.view;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject {

	public double x;
	public double y;
	double radius = Config.BALL_RADIUS;
	public int d;
  
	public int colorBola;
	public double velocityX = Config.getVelocidadBola(d);
	public double velocityY = Config.getVelocidadBola(d);
	public Color color1 = Config.getColorBola(colorBola);

	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics g) {
		g.setColor( color1);
		g.fillOval((int) left(), (int) top(), (int) radius * 2,
				(int) radius * 2);
	}

	public void update(ScoreBoard scoreBoard, Paddle paddle, int d) {
		x += velocityX * Config.FT_STEP;
		y += velocityY * Config.FT_STEP;

		if (left() < 0)
			velocityX = Config.getVelocidadBola(d);
		else if (right() > Config.SCREEN_WIDTH)
			velocityX = -Config.getVelocidadBola(d);
		if (top() < 0) {
			velocityY = Config.getVelocidadBola(d);
		} else if (bottom() > Config.SCREEN_HEIGHT) {
			velocityY = -Config.getVelocidadBola(d);
			x = paddle.x;
			y = paddle.y - 50;
			scoreBoard.die();
		}
	}

	public double left() {
		return x - radius;
	}

	public double right() {
		return x + radius;
	}

	public double top() {
		return y - radius;
	}

	public double bottom() {
		return y + radius;
	}
	/*public void setColorBola(Color colorBola) {
		colorBola = c1;
	}*/
}
