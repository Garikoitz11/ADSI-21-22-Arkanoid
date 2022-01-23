package eus.ehu.adsi.arkanoid;

import java.awt.Color;

public class App {
	
	public static Menu menu;
	public static Arkanoid arkanoid;

	
	public static void main(String[] args) {
		menu=new Menu();
		arkanoid=new Arkanoid();
		
		
		EME(); 
		
	}
	
	public static void EME() { //para futuro
		arkanoid.setVisible(false);
		menu.setVisible(true); 
		
		while(menu.getActivo()==false){
			arkanoid.setVisible(false);
		}
		
		menu.setVisible(false);

		int dificultad = menu.getDificultad();
		arkanoid.setDificultad(dificultad);
		
		Color colorBola = menu.getColorBola();
		arkanoid.setColorBola(colorBola);
		
		Color colorFondo = menu.getColorFondo();
		arkanoid.setColorFondo(colorFondo);
		
		
		Color colorPaddle = menu.getColorPaddle();
		arkanoid.setColorPaddle(colorPaddle);
		
		Color colorBrick = menu.getColorBrick();
		arkanoid.setColorBrick(colorBrick);
		
		
		arkanoid.setVisible(true);
		
		
		arkanoid.run();
	}
}