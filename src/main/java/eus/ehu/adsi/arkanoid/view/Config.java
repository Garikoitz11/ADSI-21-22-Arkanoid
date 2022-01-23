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
	
	public static final Color BACKGROUND_COLOR = Color.black;
	public static final Color BALL_COLOR = Color.orange;
	public static final Color PADDLE_COLOR = Color.red;
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







}
