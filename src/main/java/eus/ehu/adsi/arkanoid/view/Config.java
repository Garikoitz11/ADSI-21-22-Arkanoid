package eus.ehu.adsi.arkanoid.view;

import java.awt.Color;

public abstract class Config {
	
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 600;

	public static final double BALL_RADIUS = 10.0;
	public static final double BALL_VELOCITY0 = 0.2;
	public static final double BALL_VELOCITY1 = 0.3;
	public static final double BALL_VELOCITY2 = 0.4;

	public static final double PADDLE_WIDTH = 60.0;
	public static final double PADDLE_HEIGHT = 20.0;
	public static final double PADDLE_VELOCITY = 0.4;

	public static final double BLOCK_WIDTH = 60.0;
	public static final double BLOCK_HEIGHT = 20.0;

	public static final int COUNT_BLOCKS_X0 = 11;
	public static final int COUNT_BLOCKS_Y0 = 3;

	public static final int COUNT_BLOCKS_X1 = 11;
	public static final int COUNT_BLOCKS_Y1 = 5;

	public static final int COUNT_BLOCKS_X2 = 11;
	public static final int COUNT_BLOCKS_Y2 = 7;

	public static final int PLAYER_LIVES = 5;

	public static final double FT_SLICE = 1.0;
	public static final double FT_STEP = 1.0;

	public static final String FONT = "Courier New";
	public static final Color FONT_COLOR = Color.lightGray;
	
	public static final Color BACKGROUND_COLOR_R = Color.red;
	public static final Color BACKGROUND_COLOR_BLUE = Color.blue;
	public static final Color BACKGROUND_COLOR_G = Color.green;
	public static final Color BACKGROUND_COLOR_Y = Color.yellow;
	public static final Color BACKGROUND_COLOR_W = Color.white;
	public static final Color BACKGROUND_COLOR_BLACK = Color.black;
	
	public static final Color BALL_COLOR_R = Color.red;
	public static final Color BALL_COLOR_BLUE = Color.blue;
	public static final Color BALL_COLOR_G = Color.green;
	public static final Color BALL_COLOR_Y = Color.yellow;
	public static final Color BALL_COLOR_W = Color.white;
	public static final Color BALL_COLOR_BLACK = Color.black;

	public static final Color PADDLE_COLOR_R = Color.red;
	public static final Color PADDLE_COLOR_BLUE = Color.blue;
	public static final Color PADDLE_COLOR_G = Color.green;
	public static final Color PADDLE_COLOR_Y = Color.yellow;
	public static final Color PADDLE_COLOR_W = Color.white;
	public static final Color PADDLE_COLOR_BLACK = Color.black;
	
	public static final Color BRICK_COLOR_R = Color.red;
	public static final Color BRICK_COLOR_BLUE = Color.blue;
	public static final Color BRICK_COLOR_G = Color.green;
	public static final Color BRICK_COLOR_Y = Color.yellow;
	public static final Color BRICK_COLOR_W = Color.white;
	public static final Color BRICK_COLOR_BLACK = Color.black;
	public static final Color BRICK_COLOR = Color.blue;

	public static double getVelocidadBola(int d) {
		if (d==0) {
			return BALL_VELOCITY0;
		} else if (d==1) {
			return BALL_VELOCITY1;
		} else {
			return BALL_VELOCITY2;
		}
	}

	public static double getBloquesX(int d){
		if (d==0) {
			return COUNT_BLOCKS_X0;
		} else if (d==1) {
			return COUNT_BLOCKS_X1;
		} else {
			return COUNT_BLOCKS_X2;
		}
	}

	public static double getBloquesY(int d){
		if (d==0) {
			return COUNT_BLOCKS_Y0;
		} else if (d==1) {
			return COUNT_BLOCKS_Y1;
		} else {
			return COUNT_BLOCKS_Y2;
		}
	}
	
	public static Color getColorFondo(int colorFondo) {
		if(colorFondo==0) {
			return BACKGROUND_COLOR_R;
		} else if(colorFondo==1) {
			return BACKGROUND_COLOR_BLUE;
		}else if(colorFondo==2) {
			return BACKGROUND_COLOR_G;
		} else if(colorFondo==3) {
			return BACKGROUND_COLOR_Y;
		}else if(colorFondo==4) {
			return BACKGROUND_COLOR_W;
		}
		else { 
			return BACKGROUND_COLOR_BLACK;
		}
	}
	
	public static Color getColorBola(int c1) {
		if(c1==0) {
			return BALL_COLOR_G;
		} else if(c1==1) {
			return BALL_COLOR_BLUE; 
		}else if(c1==2) {
			return BALL_COLOR_R;
		} else if(c1==3) {
			return BALL_COLOR_Y;
		}else if(c1==4) {
			return BALL_COLOR_W;
		}
		else { 
			return BALL_COLOR_BLACK;
		}
		//return ;
	}
	
	public static Color getColorPaddle(int colorPaddle) {
		if(colorPaddle==0) {
			return PADDLE_COLOR_R;
		} else if(colorPaddle==1) {
			return PADDLE_COLOR_BLUE;
		}else if(colorPaddle==2) {
			return PADDLE_COLOR_G;
		} else if(colorPaddle==3) {
			return PADDLE_COLOR_Y;
		}else if(colorPaddle==4) {
			return PADDLE_COLOR_W;
		}
		else { 
			return PADDLE_COLOR_BLACK;
		}
	}
	
	public static Color getColorBrick(int colorBrick) {
		if(colorBrick==0) {
			return BRICK_COLOR_R;
		} else if(colorBrick==1) {
			return BRICK_COLOR_BLUE;
		}else if(colorBrick==2) {
			return BRICK_COLOR_G;
		} else if(colorBrick==3) {
			return BRICK_COLOR_Y;
		}else if(colorBrick==4) {
			return BRICK_COLOR_W;
		}
		else { 
			return BRICK_COLOR_BLACK;
		}
	}
	
}
