package eus.ehu.adsi.arkanoid;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import controlador.GestorArkanoid;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RecuperarContrasena extends JFrame {
	private JTextField textField;
	public RecuperarContrasena() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 453, 200);
		setResizable(false);
		
		JPanel Arriba = new JPanel();
		Arriba.setBackground(new Color(32, 178, 170));
		getContentPane().add(Arriba, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("RECUPERAR CONTRASENA");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 29));
		Arriba.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblIntroduceTuNombre = new JLabel("Introduce tu Email o nombre de usuario");
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(127)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textField, Alignment.LEADING)
						.addComponent(lblIntroduceTuNombre, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(132, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(lblIntroduceTuNombre)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Volver");
		panel_1.add(btnNewButton);
		
		JButton btnRecuperar = new JButton("Recuperar");
		panel_1.add(btnRecuperar);
		btnRecuperar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestorArkanoid arkanoid = new GestorArkanoid();
				if(arkanoid.obtenerDatos(textField.getText())) {
					JOptionPane.showMessageDialog(null, "Se han enviado los datos a su Email", "DATOS ENVIADOS", JOptionPane.INFORMATION_MESSAGE);
					ocultar();
				}
				else {
					JOptionPane.showMessageDialog(null, "No se han podido enviar los datos a su Email", "DATOS NO ENVIADOS", JOptionPane.ERROR_MESSAGE);
					ocultar();
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ocultar();
			}
		});
	}
	
	public void ocultar() {
		this.setVisible(false);
	}
}

