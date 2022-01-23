package eus.ehu.adsi.arkanoid;

// Adapted from https://gist.github.com/Miretz/f10b18df01f9f9ebfad5

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controlador.GestorArkanoid;
import eus.ehu.adsi.arkanoid.view.Ball;
import eus.ehu.adsi.arkanoid.view.Config;
import eus.ehu.adsi.arkanoid.view.Paddle;
import eus.ehu.adsi.arkanoid.view.ScoreBoard;
import eus.ehu.adsi.arkanoid.view.Brick;
import eus.ehu.adsi.arkanoid.core.Game;

public class Arkanoid extends JFrame implements KeyListener {

	// Housekeeping
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(Arkanoid.class);

	// Game variables
	private Game game;
	private Paddle paddle = new Paddle(Config.SCREEN_WIDTH / 2, Config.SCREEN_HEIGHT - 50);
	private Ball ball = new Ball(Config.SCREEN_WIDTH / 2, Config.SCREEN_HEIGHT / 2);
	private List<Brick> bricks = new ArrayList<Brick>();
	private ScoreBoard scoreboard = new ScoreBoard();

	private double lastFt;
	private double currentSlice;	

	private int d;
    private boolean count=false;
	
	private Color c;
	private Color c1;
	private Color c2;
	private Color c3;


	public Arkanoid() {
		
		game = new Game ();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(false);
		this.setResizable(false);
		this.setSize(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
		this.setTitle("Arkanoid");
		this.setVisible(true);
		this.addKeyListener(this);
		this.setLocationRelativeTo(null);
		this.createBufferStrategy(2);

		//bricks = Game.initializeBricks(bricks, d);

	}
	
	void run() throws SQLException {

		BufferStrategy bf = this.getBufferStrategy();
		Graphics g = bf.getDrawGraphics();
		g.setColor(c);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		game.setRunning(true);
		
		count=false;

		while (game.isRunning()) {

			long time1 = System.currentTimeMillis();

			if (!scoreboard.gameOver && !scoreboard.win) {
				logger.info("Playing");
				game.setTryAgain(false);
				update();
				drawScene(ball, bricks, scoreboard);

				// to simulate low FPS
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					logger.error(e.getMessage());
				}

			} else {
				if (game.isTryAgain()) {
					logger.info("Trying again");
					game.setTryAgain(false);
					bricks = Game.initializeBricks(bricks, d);
					scoreboard.lives = Config.PLAYER_LIVES;
					
					//Registrar puntuacion con usuario y dificultad, si da la casualidad de dar ENTER
					if(count==false) {
						String usu="unai";//DEFINIR
						GestorArkanoid GA= new GestorArkanoid();
						GA.anadirRanking(d+1, usu, scoreboard.score); //FALTA POR DEFINIR usu
					}
					
					scoreboard.score = 0;
					scoreboard.win = false;
					scoreboard.gameOver = false;
					scoreboard.updateScoreboard();
					ball.x = Config.SCREEN_WIDTH / 2;
					ball.y = Config.SCREEN_HEIGHT / 2;
					paddle.x = Config.SCREEN_WIDTH / 2;
					
					count=false;
					
				}else if (count==false) {
					String usu="unai";//DEFINIR
					GestorArkanoid GA= new GestorArkanoid();
					GA.anadirRanking(d+1, usu, scoreboard.score); //FALTA POR DEFINIR usu
					
					count=true;
				}
				
			}

			long time2 = System.currentTimeMillis();
			double elapsedTime = time2 - time1;

			lastFt = elapsedTime;

			double seconds = elapsedTime / 1000.0;
			if (seconds > 0.0) {
				double fps = 1.0 / seconds;
				logger.info("FPS: " + fps);
			}

		}
		
		JOptionPane.showMessageDialog(null, "¿Estas seguro de querer abandonar? \nSe perdera la puntuacion obtenida", "Abandonar", JOptionPane.QUESTION_MESSAGE);
		
		game.setTryAgain(false);
		bricks = Game.initializeBricks(bricks, d);
		scoreboard.lives = Config.PLAYER_LIVES;
		
		scoreboard.score = 0;
		scoreboard.win = false;
		scoreboard.gameOver = false;
		scoreboard.updateScoreboard();
		ball.x = Config.SCREEN_WIDTH / 2;
		ball.y = Config.SCREEN_HEIGHT / 2;
		paddle.x = Config.SCREEN_WIDTH / 2;
		
		this.setVisible(false);

	}

	private void update() {

		currentSlice += lastFt;

		for (; currentSlice >= Config.FT_SLICE; currentSlice -= Config.FT_SLICE) {

			ball.update(scoreboard, paddle, d);
			paddle.update();
			Game.testCollision(paddle, ball, d);

			Iterator<Brick> it = bricks.iterator();
			while (it.hasNext()) {
				Brick brick = it.next();
				Game.testCollision(brick, ball, scoreboard, d);
				if (brick.destroyed) {
					it.remove();
				}
			}
		}
	}

	private void drawScene(Ball ball, List<Brick> bricks, ScoreBoard scoreboard) {

		BufferStrategy bf = this.getBufferStrategy();
		Graphics g = null;

		try {

			g = bf.getDrawGraphics();

			g.setColor(c);
			g.fillRect(0, 0, getWidth(), getHeight());

			ball.draw(g);
			paddle.draw(g);
			for (Brick brick : bricks) {
				brick.draw(g);
			}
			scoreboard.draw(g);

		} finally {
			g.dispose();
		}

		bf.show();

		Toolkit.getDefaultToolkit().sync();

	}

	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
			game.setRunning(false);
		}
		if (event.getKeyCode() == KeyEvent.VK_ENTER) {
			game.setTryAgain(true);
		}
		switch (event.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			paddle.moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			paddle.moveRight();
			break;
		default:
			break;
		}
	}

	public void keyReleased(KeyEvent event) {
		switch (event.getKeyCode()) {
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_RIGHT:
			paddle.stopMove();
			break;
		default:
			break;
		}
	}

	public void keyTyped(KeyEvent arg0) {}

	public void setColorFondo(Color colorFondo) {
		c= colorFondo;
	}
	
	public void setColorBola(Color colorBola) {
		c1 = colorBola;
	}	
	public void setColorPaddle(Color colorPaddle) {
		c2 = colorPaddle;
	}
	public void setColorBrick(Color colorBrick) {
		c3 = colorBrick;
	}	

	public void setDificultad(int dificultad) {
		d = dificultad;
		bricks = Game.initializeBricks(bricks, d);
	}

}
