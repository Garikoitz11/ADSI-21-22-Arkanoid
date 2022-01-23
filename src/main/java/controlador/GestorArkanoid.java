package controlador;

import java.sql.SQLException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
	
	public boolean comprobar(String nombre, String psw, String psw1, String psw2) {
		GestorJugadores GJ = new GestorJugadores();
		try {
			if(GJ.identificarse(nombre,psw)!=null && psw1!=null && psw1.equals(psw2)) {
				GJ.cambiar(nombre, psw1);
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean obtenerDatos(String texto) {
		GestorJugadores GJ = new GestorJugadores();
		String[] datos = GJ.obtenerDatos(texto);
		if(datos[0]!=null) {
			enviarCorreo(datos[0], datos[1], datos[2]);
			return true;
		}
		else {
			return false;
		}
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
	
	private void enviarConGMail(String destinatario, String asunto, String cuerpo) {
	    // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
	    String remitente = "amunikeadsi@gmail.com";  //Para la dirección nomcuenta@gmail.com
	    String clave = "amunikeadsi21/22";
	    
	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", clave);    //La clave de la cuenta
	    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
	    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
	    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress(remitente));
	        message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podrían añadir varios de la misma manera
	        message.setSubject(asunto);
	        message.setText(cuerpo);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, clave);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   //Si se produce un error
	    }
	}
	
	public void enviarCorreo(String nombre, String psw, String correo) {
	    String asunto = "Contraseña Arkanoid";
	    String cuerpo = "Su nombre de usuario es " + nombre + ", su contraseña es " + psw + " y su correo es " + correo;

	    enviarConGMail(correo, asunto, cuerpo);
	}
	
}
