package eus.ehu.adsi.arkanoid;

import java.sql.SQLException;

public class App {
	
	public static Identificacion identificarse;
	public static Menu menu;
	public static Arkanoid arkanoid;
	
	public static void main(String[] args) {
		//Iniciar variables
		identificarse = new Identificacion();
		menu=new Menu();
		arkanoid=new Arkanoid();
		
		//Mostrar pantalla identificacion
		identificarse.setVisible(true);
		arkanoid.setVisible(false);
		
		//Esperar a que la identificacion sea correcta
		while(identificarse.getActivo()==true) {
			menu.setVisible(false);	
		}
		
		//Recoger nombre de identificacion y pasarlo al menu
		String name=identificarse.nombreUsuario();
		menu.setNombreUsuario(name);
		
		//Esconder Pantalla identificacion
		identificarse.setVisible(false);
		
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
		
		//Esperar a que se le de a jugar
		while(menu.getActivo()==false){
			arkanoid.setVisible(false);
		}
		
		//Recoger dificultad del menu y pasarlo al juego
		int dificultad = menu.getDificultad();
		arkanoid.setDificultad(dificultad);
		
		//Esconder Pantalla menu
		menu.setVisible(false);
    
		arkanoid.setVisible(true);
		
		arkanoid.run();
	}

}