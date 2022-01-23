package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GestorJugadores {
	
	//Comprueba si el usuario y contraseña existe e inicia sesion
	public String identificarse(String usuario, String contrasena) throws SQLException{
		
		ResultSet resultado= null;
		
		String consulta="Select NombreUsuario from Usuario where NombreUsuario= '"+ usuario +"' AND Contrasena= '"+ contrasena +"'";
		GestorBD bd = new GestorBD();
		resultado=bd.execSQL1(consulta);
		String usu = null;
		
		//En caso de que no haya resultado (lo que quiere decir que no esta en tabla) lo saltamos
				if(resultado!=null) {
					//Repetir para cada fila obtenida en el resultado
					while(resultado.next()) {
						//Extraccion de datos y creacion de JSONObject
						usu = resultado.getString("NombreUsuario");
					}
				}
				return usu;
		
	}
	
	//Registra un nuevo usuario
	public void registrarse(String nombre, String correo, String psw) {	
		String consulta="INSERT INTO Usuario VALUES('"+ nombre +"','"+ psw +"','"+ correo +"')";
		GestorBD bd = new GestorBD();
		bd.execSQL2(consulta);
	}
}
