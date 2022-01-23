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

public class Registrarse extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public Registrarse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 459, 378);
        setResizable(false);
        
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel Arriba = new JPanel();
		getContentPane().add(Arriba, BorderLayout.NORTH);
		Arriba.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblRegistrarse = new JLabel("REGISTRARSE");
		lblRegistrarse.setFont(new Font("Dialog", Font.BOLD, 30));
		Arriba.add(lblRegistrarse);
		
		JPanel Abajo = new JPanel();
		getContentPane().add(Abajo, BorderLayout.SOUTH);
		Abajo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel Medio = new JPanel();
		getContentPane().add(Medio, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Nombre de usuario");
		
		JLabel lblContrasea = new JLabel("Contraseña");
		
		JLabel lblRepetirContrasea = new JLabel("Repetir contraseña");
		
		JLabel lblCorreoEletrnico = new JLabel("Correo eletrónico");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestorArkanoid GA = new GestorArkanoid();
				if(GA.contraseñaIgual(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText())) {
					ocultar();
				}
				else {
					JOptionPane.showMessageDialog(null, "No ha sido posible registrarse", "ERORR AL REGISTRARSE", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ocultar();
			}
		});
		GroupLayout gl_Medio = new GroupLayout(Medio);
		gl_Medio.setHorizontalGroup(
			gl_Medio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Medio.createSequentialGroup()
					.addContainerGap(77, Short.MAX_VALUE)
					.addGroup(gl_Medio.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_Medio.createSequentialGroup()
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
							.addGap(8))
						.addGroup(gl_Medio.createSequentialGroup()
							.addGroup(gl_Medio.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCorreoEletrnico)
								.addComponent(lblContrasea)
								.addComponent(lblRepetirContrasea)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(30)
					.addGroup(gl_Medio.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(89))
		);
		gl_Medio.setVerticalGroup(
			gl_Medio.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Medio.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_Medio.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Medio.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCorreoEletrnico))
					.addGap(12)
					.addGroup(gl_Medio.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContrasea)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Medio.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRepetirContrasea)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(gl_Medio.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(20))
		);
		Medio.setLayout(gl_Medio);
	}
	
	public void ocultar() {
		this.setVisible(false);
	}
}
