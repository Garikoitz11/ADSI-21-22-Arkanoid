package eus.ehu.adsi.arkanoid;

import javax.swing.JFrame;
import java.awt.FlowLayout;
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
import java.awt.Color;

public class Registrarse extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public Registrarse() {
		initialize();
	}
	private void initialize() {
		getContentPane().setBackground(new Color(95, 158, 160));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 371, 247);
		setResizable(false);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel Arriba = new JPanel();
		Arriba.setBackground(new Color(32, 178, 170));
		getContentPane().add(Arriba, BorderLayout.NORTH);
		Arriba.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblRegistrarse = new JLabel("REGISTRARSE");
		lblRegistrarse.setFont(new Font("Dialog", Font.BOLD, 30));
		Arriba.add(lblRegistrarse);
		
		JPanel Abajo = new JPanel();
		Abajo.setBackground(new Color(32, 178, 170));
		getContentPane().add(Abajo, BorderLayout.SOUTH);
		Abajo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_1 = new JButton("Volver");
		Abajo.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Registrarse");
		Abajo.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestorArkanoid GA = new GestorArkanoid();
				if(GA.contrasenaIgual(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText())) {
					ocultar();
				}
				else {
					JOptionPane.showMessageDialog(null, "No ha sido posible registrarse", "ERORR AL REGISTRARSE", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ocultar();
			}
		});
		
		JPanel Medio = new JPanel();
		Medio.setBackground(new Color(32, 178, 170));
		getContentPane().add(Medio, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Nombre de usuario");
		
		JLabel lblContrasea = new JLabel("Contrasena");
		
		JLabel lblRepetirContrasea = new JLabel("Repetir contrasena");
		
		JLabel lblCorreoEletrnico = new JLabel("Correo eletronico");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GroupLayout gl_Medio = new GroupLayout(Medio);
		gl_Medio.setHorizontalGroup(
			gl_Medio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Medio.createSequentialGroup()
					.addGap(67)
					.addGroup(gl_Medio.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_Medio.createSequentialGroup()
							.addGroup(gl_Medio.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCorreoEletrnico)
								.addComponent(lblNewLabel)
								.addComponent(lblContrasea))
							.addGap(18))
						.addGroup(gl_Medio.createSequentialGroup()
							.addComponent(lblRepetirContrasea)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(gl_Medio.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_1, 126, 126, 126)
						.addComponent(textField_3, 126, 126, 126)
						.addGroup(gl_Medio.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_2, 126, 126, 126))
						.addGroup(gl_Medio.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, 126, 126, 126)))
					.addContainerGap())
		);
		gl_Medio.setVerticalGroup(
			gl_Medio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Medio.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_Medio.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Medio.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCorreoEletrnico)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Medio.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContrasea))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Medio.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRepetirContrasea))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		Medio.setLayout(gl_Medio);
	}
	
	public void ocultar() {
		this.setVisible(false);
	}
}