package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.github.cliftonlabs.json_simple.*;

public class GestorPuntuaciones {
	
	//Metodo para obtener ranking personal de todas las dificultades
	public JsonArray rankingPersonal(String usuario) throws SQLException{
		//Inicializamos donde guardar los datos de la consulta
		ResultSet resultado= null;
				
		//Consulta a realizar en BD y realizar consulta
		String consulta="Select * from R3 where usuario= '"+ usuario +"' ORDER BY puntos DESC";
		GestorBD bd=new GestorBD();
		resultado=bd.execSQL1(consulta);
				
		//JSONArray donde guardar los datos obtenidos en la consulta
		JsonArray rankingPersonal= new JsonArray();
		
		//En caso de que no haya resultado (lo que quiere decir que no esta en tabla) lo saltamos
		if(resultado!=null) {
			//Repetir para cada fila obtenida en el resultado
			while(resultado.next()) {
				//Extraccion de datos y creacion de JSONObject
				int dificultad= resultado.getInt("dificultad");
				int puntos= resultado.getInt("puntos");
					
					
				JsonObject elemRanking= new JsonObject();
					
				//Insercion de datos en el JSONObject
				elemRanking.put("dificultad", dificultad);
				elemRanking.put("puntos", puntos);
					
				//Insercion del JSONObject a la lista JSONArray
				rankingPersonal.add(elemRanking);	
			}
		}
		
		return rankingPersonal;
	}
	
	//Metodo para obtener ranking global de todas las dificultades
	public JsonArray rankingGlobal() throws SQLException{
		//Inicializamos donde guardar los datos de la consulta
		ResultSet resultado= null;
		
		//Consulta a realizar en BD y realizar consulta
		String consulta="Select * from R3 ORDER BY puntos DESC";
		GestorBD bd=new GestorBD();
		resultado=bd.execSQL1(consulta);
		
		//JSONArray donde guardar los datos obtenidos en la consulta
		JsonArray rankingGlobal= new JsonArray();
		
		//En caso de que no haya resultado (lo que quiere decir que no esta en tabla) lo saltamos
		if(resultado!=null) {
			//Repetir para cada fila obtenida en el resultado
			while(resultado.next()) {
				//Extraccion de datos y creacion de JSONObject
				String usuario= resultado.getString("usuario");
				int dificultad= resultado.getInt("dificultad");
				int puntos= resultado.getInt("puntos");
			
				JsonObject elemRanking= new JsonObject();
			
				//Insercion de datos en el JSONObject
				elemRanking.put("usuario", usuario);
				elemRanking.put("dificultad", dificultad);
				elemRanking.put("puntos", puntos);
			
				//Insercion del JSONObject a la lista JSONArray
				rankingGlobal.add(elemRanking);	
			}
		}
		
		return rankingGlobal;
	}
	
	//Metodo para obtener ranking personal dependiendo de dificultad
	public JsonArray rankingPersonal(String pUsuario, int pDificultad) throws SQLException{
		//Inicializamos donde guardar los datos de la consulta
		ResultSet resultado= null;
						
		//Consulta a realizar en BD y realizar consulta
		String consulta="Select * from R3 where usuario= '"+ pUsuario +"' and dificultad="+pDificultad+" ORDER BY puntos DESC";
		GestorBD bd=new GestorBD();
		resultado=bd.execSQL1(consulta);
						
		//JSONArray donde guardar los datos obtenidos en la consulta
		JsonArray rankingPersonal= new JsonArray();
		
		//En caso de que no haya resultado (lo que quiere decir que no esta en tabla) lo saltamos
		if(resultado!=null) {
			//Repetir para cada fila obtenida en el resultado
			while(resultado.next()) {
				//Extraccion de datos y creacion de JSONObject
				int dificultad= resultado.getInt("dificultad");
				int puntos= resultado.getInt("puntos");
				
				JsonObject elemRanking= new JsonObject();
							
				//Insercion de datos en el JSONObject
				elemRanking.put("dificultad", dificultad);
				elemRanking.put("puntos", puntos);
							
				//Insercion del JSONObject a la lista JSONArray
				rankingPersonal.add(elemRanking);	
			}
		}
						
		return rankingPersonal;
	}
	
	//Metodo para obtener ranking global dependiendo de dificultad
	public JsonArray rankingGlobal(int pdificultad) throws SQLException{
		//Inicializamos donde guardar los datos de la consulta
		ResultSet resultado= null;
		
		//Consulta a realizar en BD y realizar consulta
		String consulta="Select * from R3 where dificultad="+ pdificultad +" ORDER BY puntos DESC";
		GestorBD bd=new GestorBD();
		resultado=bd.execSQL1(consulta);
		
		//JSONArray donde guardar los datos obtenidos en la consulta
		JsonArray rankingGlobal= new JsonArray();
		
		//En caso de que no haya resultado (lo que quiere decir que no esta en tabla) lo saltamos
		if(resultado!=null) {
			//Repetir para cada fila obtenida en el resultado
			while(resultado.next()) {
				//Extraccion de datos y creacion de JSONObject
				String usuario= resultado.getString("Usuario");
				int dificultad= resultado.getInt("dificultad");
				int puntos= resultado.getInt("puntos");
			
				JsonObject elemRanking= new JsonObject();
			
				//Insercion de datos en el JSONObject
				elemRanking.put("usuario", usuario);
				elemRanking.put("dificultad", dificultad);
				elemRanking.put("puntos", puntos);
			
				//Insercion del JSONObject a la lista JSONArray
				rankingGlobal.add(elemRanking);	
			}
		}
		
		return rankingGlobal;
	}
	
	//Metodo para añadir filas al ranking (BD)
	public void añadirRanking(int pDificultad, String pUsuario, int pPuntos) {
			//Datos pasados
			int dificultad= pDificultad;
			String usuario= pUsuario;
			int puntos= pPuntos;
			
			//Obtencion de dia
			LocalDateTime dia = LocalDateTime.now();
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			String fechaHora = dia.format(formato);
			
			//Consulta de Insert
			String consulta="Insert into R3 values ('"+ usuario +"', "+ dificultad +", '"+ fechaHora +"', "+ puntos +")";
			GestorBD bd=new GestorBD();
			bd.execSQL2(consulta);
	}
	
}
