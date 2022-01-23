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

public class CambiarContrasena extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public CambiarContrasena() {
		initialize();
	}
	private void initialize() {
		getContentPane().setBackground(new Color(95, 158, 160));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 406, 244);
		setResizable(false);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel Arriba = new JPanel();
		Arriba.setBackground(new Color(32, 178, 170));
		getContentPane().add(Arriba, BorderLayout.NORTH);
		Arriba.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblRegistrarse = new JLabel("CAMBIAR CONTRASENA");
		lblRegistrarse.setFont(new Font("Dialog", Font.BOLD, 30));
		Arriba.add(lblRegistrarse);
		
		JPanel Abajo = new JPanel();
		Abajo.setBackground(new Color(32, 178, 170));
		getContentPane().add(Abajo, BorderLayout.SOUTH);
		Abajo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_1 = new JButton("Volver");
		Abajo.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Cambiar");
		Abajo.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestorArkanoid GA = new GestorArkanoid();
				if(GA.comprobar(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText())) {
					ocultar();
				}
				else {
					JOptionPane.showMessageDialog(null, "No ha sido posible cambiar la contrasena", "ERORR AL CAMBIAR CONTRASENA", JOptionPane.ERROR_MESSAGE);
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
		
		JLabel lblContrasea = new JLabel("Nueva contrasena");
		
		JLabel lblRepetirContrasea = new JLabel("Repetir N. contrasena");
		
		JLabel lblCorreoEletrnico = new JLabel("Antigua contrasena");
		
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
					.addGap(79)
					.addGroup(gl_Medio.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(lblContrasea)
						.addComponent(lblRepetirContrasea)
						.addComponent(lblCorreoEletrnico))
					.addGap(38)
					.addGroup(gl_Medio.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(textField_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
					.addGap(51))
		);
		gl_Medio.setVerticalGroup(
			gl_Medio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Medio.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Medio.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Medio.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCorreoEletrnico, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Medio.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblContrasea, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textField_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Medio.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRepetirContrasea, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(24))
		);
		Medio.setLayout(gl_Medio);
	}
	
	public void ocultar() {
		this.setVisible(false);
	}
}