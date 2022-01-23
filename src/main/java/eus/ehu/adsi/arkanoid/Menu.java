package eus.ehu.adsi.arkanoid;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame implements PropertyChangeListener {

	private String nombreUsuario;
	private JPanel contentPane;
	private JButton btnJugar;
	private JButton btnRanking;
	private JButton btnDificultad;
	private JButton btnPersonalizacion;
	private Boolean activo= false; //comprobador para App

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, BorderLayout.CENTER);
		panel_5.add(getBtnJugar());
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		
		panel_2.add(getBtnDificultad());
		
		panel_2.add(getBtnPersonalizacion());
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7, BorderLayout.SOUTH);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9, BorderLayout.NORTH);
		
		JPanel panel_8 = new JPanel();
		panel_3.add(panel_8, BorderLayout.CENTER);
		
		panel_8.add(getBtnRanking());
		
		JButton btnPremios = new JButton("Consultar Premios");
		panel_8.add(btnPremios);
		
		JPanel panel_10 = new JPanel();
		panel_3.add(panel_10, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6, BorderLayout.NORTH);
	}
	
	//BOTON JUGAR
	private JButton getBtnJugar() {
		if (btnJugar == null) {
			btnJugar = new JButton("JUGAR");
			btnJugar.setFont(new Font("Tahoma", Font.PLAIN, 30));
			btnJugar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					activo=true;
				}
			});
		}
		return btnJugar;
	}
	
	private JButton getBtnDificultad() {
		if (btnDificultad == null) {
			btnDificultad = new JButton("Elegir Dificultad");
			btnDificultad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirDificultad();
				}
			});
		}
		return btnDificultad;
	}
	
	public void abrirDificultad() {
		Dificultad dificultad=new Dificultad();
		dificultad.setVisible(true);
		
	}
	
	private JButton getBtnPersonalizacion() {
		if (btnPersonalizacion == null) {
			btnPersonalizacion = new JButton("Personalizar");
			btnPersonalizacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirPersonalizacion();
				}
			});
		}
		return btnPersonalizacion;
	}
	
	public void abrirPersonalizacion() {
		Personalizacion personalizacion=new Personalizacion();
		personalizacion.setVisible(true);
		
	}

	//Boton que genera la pantalla ranking
	private JButton getBtnRanking() {
		if (btnRanking == null) {
			btnRanking = new JButton("Consultar Ranking");
			btnRanking.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirRanking();
				}
			});
		}
		return btnRanking;
	}
	
	//Accion para abrir pantalla ranking
	public void abrirRanking() {
				String nombre="ramon";//DEFINIR
		//Crear la ventana ranking
		Ranking ranking=new Ranking(nombre);
		//Observador para conocer si pulsas volver
		ranking.addObserver(this);
		//Ocultar la pantalla menu
		this.setVisible(false);
		//Activar pantalla ranking
		ranking.setVisible(true);
	}
	
	public boolean getActivo() {
		//Comprobador para conocer si das a JUGAR
		return activo;
	}
	
	public void setActivo(boolean pActivo) {
		//Reiniciar comprobador de jugar
		activo=pActivo;
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt != null) {
			//Evento de ranking, para volver.
			if(evt.getPropertyName().equals("RankingPuntuaciones")) {
				this.setVisible(true);
			}
		}
	}
	
	public void setNombreUsuario(String nom) {
		nombreUsuario=nom;
	}

}

