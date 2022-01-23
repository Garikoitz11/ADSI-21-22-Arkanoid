package controlador;

import java.sql.SQLException;

import com.github.cliftonlabs.json_simple.*;

public class GestorArkanoid {
	
	//Comprueba que la contraseña sea igual. Si es igual añade el registro
	public boolean contrasenaIgual(String nombre, String correo, String psw1, String psw2) {
		if(psw1.equals(psw2)==false || nombre==null || correo==null || psw1==null || psw2==null) {
			return false;
		}
		else {
			GestorJugadores GJ = new GestorJugadores();
			GJ.registrarse(nombre,correo,psw1);
			return true;
		}
	}
	
	//Comprueba si el inicio de sesion es correcto
	public String identificarse(String usuario,String contrasena) {
		GestorJugadores GJ = new GestorJugadores();
		String nombreUsuario = null;
		try {
			nombreUsuario = GJ.identificarse(usuario,contrasena);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nombreUsuario;
	}
	
	
	
	//Metodo para anadir datos a la BD de ranking
	public void anadirRanking(int pDificultad, String pUsuario, int pPuntos) throws SQLException {
		GestorPuntuaciones GP= new GestorPuntuaciones();
			
		GP.anadirRanking(pDificultad, pUsuario, pPuntos);
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
