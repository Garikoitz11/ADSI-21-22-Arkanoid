package eus.ehu.adsi.arkanoid;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import controlador.GestorArkanoid;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Identificacion extends JFrame {
	private String nombreUsuario;
	private JTextField textField;
	private JTextField textField_1;
	private Boolean activo = true;
	private GestorArkanoid gestorArkanoid;
	public Identificacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 459, 378);
        setResizable(false);
        
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel Titulo = new JPanel();
		getContentPane().add(Titulo, BorderLayout.NORTH);
		
		JLabel lblIdentificacin = new JLabel("IDENTIFICACION");
		lblIdentificacin.setFont(new Font("Dialog", Font.BOLD, 30));
		Titulo.add(lblIdentificacin);
		
		JPanel Abajo = new JPanel();
		getContentPane().add(Abajo, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Recuperar contrasena");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnCambiarContrasea = new JButton("Cambiar contrasena");
		GroupLayout gl_Abajo = new GroupLayout(Abajo);
		gl_Abajo.setHorizontalGroup(
			gl_Abajo.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_Abajo.createSequentialGroup()
					.addContainerGap(36, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCambiarContrasea)
					.addGap(42))
		);
		gl_Abajo.setVerticalGroup(
			gl_Abajo.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_Abajo.createSequentialGroup()
					.addGroup(gl_Abajo.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnCambiarContrasea))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		Abajo.setLayout(gl_Abajo);
		
		JPanel Cuerpo = new JPanel();
		getContentPane().add(Cuerpo, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrasena");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnIniciarSesin = new JButton("Iniciar sesion");
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestorArkanoid GA = new GestorArkanoid();
				if(GA.identificarse(textField.getText(), textField_1.getText())!=null) {
					activo=false;
					nombreUsuario = textField.getText();
				}
				else {
					JOptionPane.showMessageDialog(null, "No ha sido posible iniciar sesion", "ERORR AL INICIAR SESION", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registrarse registrarse = new Registrarse();
				registrarse.setVisible(true);
			}
		});
		GroupLayout gl_Cuerpo = new GroupLayout(Cuerpo);
		gl_Cuerpo.setHorizontalGroup(
			gl_Cuerpo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Cuerpo.createSequentialGroup()
					.addGroup(gl_Cuerpo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Cuerpo.createSequentialGroup()
							.addGap(112)
							.addGroup(gl_Cuerpo.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_Cuerpo.createSequentialGroup()
									.addComponent(lblContrasea)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Cuerpo.createSequentialGroup()
									.addGap(12)
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_Cuerpo.createSequentialGroup()
							.addGap(163)
							.addGroup(gl_Cuerpo.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnRegistrarse, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnIniciarSesin, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(138, Short.MAX_VALUE))
		);
		gl_Cuerpo.setVerticalGroup(
			gl_Cuerpo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Cuerpo.createSequentialGroup()
					.addGap(61)
					.addGroup(gl_Cuerpo.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_Cuerpo.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContrasea)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnIniciarSesin)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRegistrarse)
					.addContainerGap(61, Short.MAX_VALUE))
		);
		Cuerpo.setLayout(gl_Cuerpo);
	}
	
	public boolean getActivo() {
		return activo;
	}
	
	public String nombreUsuario() {
		return nombreUsuario;
	}
}
