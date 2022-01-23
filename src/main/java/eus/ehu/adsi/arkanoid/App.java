package eus.ehu.adsi.arkanoid;

import java.sql.SQLException;

public class App {
	
	public static Menu menu;
	public static Arkanoid arkanoid;
	
	public static void main(String[] args) {
		menu=new Menu();
		arkanoid=new Arkanoid();
		
		boolean prueba=true;
		while(prueba==true) {
			try {
				EME();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
		
	}
	
	public static void EME() throws SQLException {
		arkanoid.setVisible(false);
		menu.setVisible(true);
		
		menu.setActivo(false);
		
		while(menu.getActivo()==false){
			arkanoid.setVisible(false);
		}
 
		int dificultad = menu.getDificultad();
		arkanoid.setDificultad(dificultad);
		
		menu.setVisible(false);
    
		arkanoid.setVisible(true);
		
		arkanoid.run();
	}

}