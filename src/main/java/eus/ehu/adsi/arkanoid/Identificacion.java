package eus.ehu.adsi.arkanoid;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

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
        setBounds(500, 200, 354, 275);
        setResizable(false);
        
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel Titulo = new JPanel();
		Titulo.setBackground(new Color(32, 178, 170));
		getContentPane().add(Titulo, BorderLayout.NORTH);
		
		JLabel lblIdentificacin = new JLabel("IDENTIFICACION");
		lblIdentificacin.setFont(new Font("Dialog", Font.BOLD, 30));
		Titulo.add(lblIdentificacin);
		
		JPanel Abajo = new JPanel();
		Abajo.setBackground(new Color(32, 178, 170));
		getContentPane().add(Abajo, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Recuperar contrasena");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RecuperarContrasena rc = new RecuperarContrasena();
				rc.setVisible(true);
			}
		});
		
		JButton btnCambiarContrasea = new JButton("Cambiar contrasena");
		btnCambiarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CambiarContrasena cc = new CambiarContrasena();
				cc.setVisible(true);
			}
		});
		Abajo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		Abajo.add(btnNewButton);
		Abajo.add(btnCambiarContrasea);
		
		JPanel Cuerpo = new JPanel();
		Cuerpo.setBackground(new Color(32, 178, 170));
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
					.addContainerGap(64, Short.MAX_VALUE)
					.addGroup(gl_Cuerpo.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(lblContrasea))
					.addGap(18)
					.addGroup(gl_Cuerpo.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
					.addGap(64))
				.addGroup(gl_Cuerpo.createSequentialGroup()
					.addGap(107)
					.addGroup(gl_Cuerpo.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRegistrarse, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnIniciarSesin, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(184, Short.MAX_VALUE))
		);
		gl_Cuerpo.setVerticalGroup(
			gl_Cuerpo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Cuerpo.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Cuerpo.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Cuerpo.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContrasea, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnIniciarSesin, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRegistrarse, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(29))
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