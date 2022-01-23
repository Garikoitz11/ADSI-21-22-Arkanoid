package eus.ehu.adsi.arkanoid;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
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
        setBounds(500, 200, 459, 378);
        setResizable(false);
		
		JPanel Arriba = new JPanel();
		getContentPane().add(Arriba, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("RECUPERAR CONTRASENA");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 29));
		Arriba.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblIntroduceTuNombre = new JLabel("Introduce tu Email o nombre de usuario");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ocultar();
			}
		});
		
		JButton btnRecuperar = new JButton("Recuperar");
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
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(164)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(145, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(90, Short.MAX_VALUE)
					.addComponent(lblIntroduceTuNombre)
					.addGap(81))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(74)
					.addComponent(btnNewButton)
					.addGap(49)
					.addComponent(btnRecuperar)
					.addContainerGap(93, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(lblIntroduceTuNombre)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnRecuperar))
					.addContainerGap(103, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
	
	public void ocultar() {
		this.setVisible(false);
	}
}
