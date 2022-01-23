package controlador;

import java.sql.SQLException;

import com.github.cliftonlabs.json_simple.*;

public class GestorArkanoid {
	
	
	//Metodo para añadir datos a la BD de ranking
	public void añadirRanking(int pDificultad, String pUsuario, int pPuntos) throws SQLException {
		GestorPuntuaciones GP= new GestorPuntuaciones();
			
		GP.añadirRanking(pDificultad, pUsuario, pPuntos);
	}
	
	//Metodo para obtener ranking personal de todas las dificultades, a GestorPuntuaciones
	public JsonArray rankingPersonal(String pUsuario) throws SQLException {
		GestorPuntuaciones GP= new GestorPuntuaciones();
		
		return GP.rankingPersonal(pUsuario);
	}
	
	//Metodo para obtener ranking global de todas las dificultades, a GestorPuntuaciones
	public JsonArray rankingGlobal() throws SQLException {
		GestorPuntuaciones GP= new GestorPuntuaciones();
		
		return GP.rankingGlobal();
	}
	
	//Metodo para obtener ranking personal dependiendo de dificultad, a GestorPuntuaciones
	public JsonArray rankingPersonal(String pUsuario, int pDificultad) throws SQLException {
		GestorPuntuaciones GP= new GestorPuntuaciones();
		
		return GP.rankingPersonal(pUsuario, pDificultad);
	}
	
	//Metodo para obtener ranking global dependiendo de dificultad, a GestorPuntuaciones
	public JsonArray rankingGlobal(int pDificultad) throws SQLException {
		GestorPuntuaciones GP= new GestorPuntuaciones();
		
		return GP.rankingGlobal(pDificultad);
	}
	
}
