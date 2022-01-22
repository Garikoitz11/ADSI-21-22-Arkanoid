package eus.ehu.adsi.arkanoid;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import com.github.cliftonlabs.json_simple.*;

import controlador.GestorArkanoid;

public class Ranking extends JFrame {

	private JPanel contentPane;
	private JTable tabla;
	private JTable tabla_global;
	private JPanel panelSur;
	private JPanel panelSurCentral;
	private JPanel panelSurSur;
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private JButton btnVolver;
	
	private PropertyChangeSupport support;
	private String nombreUsuario;
	
	//Atributos para las tablas
	DefaultTableModel modeloParticular;
	DefaultTableModel modeloGlobal;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Ranking(String NU) {
		try {
			initialize();
			
			//Recoger nombre de usuario
			nombreUsuario=NU;
		
			//Tabla para ranking personal
			modeloParticular = new DefaultTableModel();
			modeloParticular.addColumn("Dificultad");
			modeloParticular.addColumn("Puntuacion");
			getTabla().setModel(modeloParticular);
		
			//Tabla para ranking global
			modeloGlobal = new DefaultTableModel();
			modeloGlobal.addColumn("Usuario");
			modeloGlobal.addColumn("Dificultad");
			modeloGlobal.addColumn("Puntuacion");
			getTablaGlobal().setModel(modeloGlobal);
		
			//Inicializar ranking con todos los niveles
			actualizarRanking(0);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		support = new PropertyChangeSupport(this);
		
	}
		
	public void initialize() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getTabla(), BorderLayout.WEST);
		contentPane.add(getTablaGlobal(), BorderLayout.EAST);
		contentPane.add(getPanelSur(), BorderLayout.SOUTH);
		contentPane.add(new JScrollPane(getTabla()), BorderLayout.WEST);
		contentPane.add(new JScrollPane(getTablaGlobal()), BorderLayout.EAST);
		setTitle("Ranking");
	}
	
	public void addObserver(PropertyChangeListener pList) {
		support.addPropertyChangeListener(pList);
	}
	
	private JTable getTabla() {
		if (tabla == null) {
			tabla = new JTable();
		}
		return tabla;
	}
	
	private JTable getTablaGlobal() {
		if (tabla_global == null) {
			tabla_global = new JTable();
		}
		return tabla_global;
	}
	
	private JPanel getPanelSur() {
		if (panelSur == null) {
			panelSur = new JPanel();
			panelSur.setLayout(new BorderLayout(0, 0));	
			panelSur.add(getPanelSurCentral(), BorderLayout.CENTER);
			panelSur.add(getPanelSurSur(), BorderLayout.SOUTH);
		}
		return panelSur;
	}
	
	private JPanel getPanelSurCentral() {
		if (panelSurCentral == null) {
			panelSurCentral = new JPanel();
			panelSurCentral.add(getLblNewLabel());
			panelSurCentral.add(getComboBox());
		}
		return panelSurCentral;
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Filtrar Dificultad :");
		}
		return lblNewLabel;
	}
	
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addItem("Todo");
			comboBox.addItem("1");
			comboBox.addItem("2");
			comboBox.addItem("3");
			comboBox.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					int dificultad;
					try {
						//SI selecciona "Todo"
						if(comboBox.getSelectedItem().equals("Todo")) {
							actualizarRanking(0);
						}	//SI seleciona los numeros
						else {
							dificultad = Integer.parseInt((String) comboBox.getSelectedItem());
							actualizarRanking(dificultad);
						}
					} catch (SQLException e1) {
							e1.printStackTrace();
					}
				}
			} );
		}
		return comboBox;
	}
	
	private JPanel getPanelSurSur() {
		if (panelSurSur == null) {
			panelSurSur = new JPanel();
			panelSurSur.add(getBtnVolver());
		}
		return panelSurSur;
	}
	
	//BOTON VOLVER
	private JButton getBtnVolver() {
		if (btnVolver == null) {
			btnVolver = new JButton("Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					volver();
				}
			});
		}
		return btnVolver;
	}
	
	//accion del boton volver
	public void volver() {
		//realiza evento en menu
		support.firePropertyChange("RankingPuntuaciones", false, true);
		//elimina la ventana
		this.dispose();
	}
	
	//Empiece Tablas
	public void actualizarRanking(int pDificultad) throws SQLException {
		//Vaciar tabla de puntuaciones global
		if(modeloGlobal.getRowCount()>0) {
			modeloGlobal.setRowCount(0);
		}
		
		//Vaciar tabla de puntuaciones personales
		if(modeloParticular.getRowCount()>0) {
			modeloParticular.setRowCount(0);
		}
		
		int dificultad=pDificultad;
		
		//Iniciar clase GestorArkanoid y los JSONArray que guardaran los JSONObject donde estan las filas de las tablas
		GestorArkanoid GA= new GestorArkanoid();
		JsonArray rankingGlobal= new JsonArray();
		JsonArray rankingPersonal= new JsonArray();
		
		//SI has seleccionado "TODO"
		if(dificultad == 0) {
			 rankingGlobal = GA.rankingGlobal();
			 rankingPersonal= GA.rankingPersonal(nombreUsuario);
		
		} 
		//SI seleccionas por "dificultad"
		else { 
			rankingGlobal = GA.rankingGlobal(dificultad);
			rankingPersonal= GA.rankingPersonal(nombreUsuario, dificultad);
		}
		
		String Alerta="ERROR al cargar rankings:";
		boolean alert= false;
		
		//Cargar tabla de puntuaciones globales
		if(rankingGlobal.size()!=0) {
			//PARA CADA uno del JSONArray (fila) cargar en tabla
			for(int i = 0; i<rankingGlobal.size(); i++) {	
				modeloGlobal.addRow(crearFilaRankingGlobal((JsonObject) rankingGlobal.get(i)));
			} 
		} else {
			//SI NO quiere decir que ha ocurrido un error a la hora de buscar el BD
			Alerta+=" \n- Global";
			alert=true;
		}
		
		//Cargar tabla de puntuaciones personales
		if(rankingPersonal.size()!=0) {
			for(int i = 0; i<rankingPersonal.size(); i++) {	
				modeloParticular.addRow(crearFilaRankingPersonal((JsonObject) rankingPersonal.get(i)));
			} 
		} else {
			Alerta+=" \n- Personal";
			alert=true;
		}
		
		if(alert==true) {
			JOptionPane.showMessageDialog(null, Alerta, "MENSAJE ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//Obtencion de datos de las filas para ranking global
	private String[] crearFilaRankingGlobal(JsonObject fila) {
		String[] partes = new String[3];
		partes[0] = fila.get("usuario").toString();
		partes[1] = fila.get("dificultad").toString();
		partes[2] = fila.get("puntos").toString();
		
		return partes;
		
	}
	
	//Obtencion de datos de las filas para ranking particular
	private String[] crearFilaRankingPersonal(JsonObject fila) {
		String[] partes = new String[2];
		partes[0] = fila.get("dificultad").toString();
		partes[1] = fila.get("puntos").toString();
		
		return partes;
		
	}

}
