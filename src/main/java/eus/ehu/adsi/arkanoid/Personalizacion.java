package eus.ehu.adsi.arkanoid;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class Personalizacion extends JFrame {

	private JPanel contentPane;
	private JPanel Título;
	private JPanel Contenido;
	private JPanel Volver;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private JTextPane txtpnModificaLaDificultad;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Personalizacion() {
		initialize();
	}
		
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getTítulo(), BorderLayout.NORTH);
		contentPane.add(getContenido(), BorderLayout.CENTER);
		contentPane.add(getVolver(), BorderLayout.SOUTH);
		setTitle("Personalizacion");
	}

	private JPanel getTítulo() {
		if (Título == null) {
			Título = new JPanel();
			Título.add(getLblNewLabel());
		}
		return Título;
	}
	private JPanel getContenido() {
		if (Contenido == null) {
			Contenido = new JPanel();
			GroupLayout gl_Contenido = new GroupLayout(Contenido);
			gl_Contenido.setHorizontalGroup(
				gl_Contenido.createParallelGroup(Alignment.TRAILING)
					.addGroup(Alignment.LEADING, gl_Contenido.createSequentialGroup()
						.addGap(70)
						.addComponent(getLblNewLabel_1(), GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
						.addGap(67)
						.addComponent(getComboBox(), 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(84))
					.addGroup(Alignment.LEADING, gl_Contenido.createSequentialGroup()
						.addGap(92)
						.addComponent(getTxtpnModificaLaDificultad(), GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(93, Short.MAX_VALUE))
			);
			gl_Contenido.setVerticalGroup(
				gl_Contenido.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_Contenido.createSequentialGroup()
						.addGap(22)
						.addComponent(getTxtpnModificaLaDificultad(), GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_Contenido.createParallelGroup(Alignment.BASELINE)
							.addComponent(getComboBox(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(getLblNewLabel_1(), GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
						.addContainerGap())
			);
			Contenido.setLayout(gl_Contenido);
		}
		return Contenido;
	}
	private JPanel getVolver() {
		if (Volver == null) {
			Volver = new JPanel();
			GroupLayout gl_Volver = new GroupLayout(Volver);
			gl_Volver.setHorizontalGroup(
				gl_Volver.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_Volver.createSequentialGroup()
						.addGap(170)
						.addComponent(getBtnNewButton(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(184))
			);
			gl_Volver.setVerticalGroup(
				gl_Volver.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_Volver.createSequentialGroup()
						.addComponent(getBtnNewButton(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap())
			);
			Volver.setLayout(gl_Volver);
		}
		return Volver;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Seleccionar Dificultad");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Dificultad");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		}
		return lblNewLabel_1;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"1. Facil", "2. Normal", "3. Dificil"}));
		}
		return comboBox;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Confirmar");
		}
		return btnNewButton;
	}
	private JTextPane getTxtpnModificaLaDificultad() {
		if (txtpnModificaLaDificultad == null) {
			txtpnModificaLaDificultad = new JTextPane();
			txtpnModificaLaDificultad.setBackground(SystemColor.menu);
			txtpnModificaLaDificultad.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtpnModificaLaDificultad.setText("Modifica la dificultad aumentando o disminuyendo la velocidad de la bola y el n\u00FAmero de bricks en pantalla");
		}
		return txtpnModificaLaDificultad;
	}

}
