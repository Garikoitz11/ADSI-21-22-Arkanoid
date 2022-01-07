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
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class Personalizacion extends JFrame {

	private JPanel contentPane;
	private JPanel Título;
	private JPanel Contenido;
	private JPanel Volver;
	private JLabel Titulillo;
	private JLabel ColordePaddle;
	private JLabel Tamañodebola;
	private JLabel Colordefondo;
	private JLabel Colordebola;
	private JComboBox comboBox;
	private JLabel Colordeladrillo;
	private JLabel Sonidos;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JComboBox comboBox_4;
	private JComboBox comboBox_5;
	private JButton confirmar;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Personalizacion() {
		setBackground(new Color(221, 160, 221));
		initialize();
	}
		
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 459, 378);
		setResizable(false);
		contentPane = new JPanel();
		
		contentPane.setBackground(new Color(238, 130, 238));
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
			Título.setBackground(new Color(255, 218, 185));
			Título.add(getTitulillo());
		}
		return Título;
	}
	private JPanel getContenido() {
		if (Contenido == null) {
			Contenido = new JPanel();
			Contenido.setBackground(new Color(255, 218, 185));
			GroupLayout gl_Contenido = new GroupLayout(Contenido);
			gl_Contenido.setHorizontalGroup(
				gl_Contenido.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_Contenido.createSequentialGroup()
						.addGroup(gl_Contenido.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_Contenido.createSequentialGroup()
								.addComponent(getColordefondo(), GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(getComboBox_1(), GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_Contenido.createSequentialGroup()
								.addComponent(getTamañodebola(), GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(getComboBox_1_2(), GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_Contenido.createSequentialGroup()
								.addComponent(getColordebola(), GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(getComboBox_2_1(), GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_Contenido.createSequentialGroup()
								.addComponent(getColordePaddle(), GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(getComboBox_3_1(), GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_Contenido.createSequentialGroup()
								.addComponent(getSonidos(), GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(getComboBox_4_1(), GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_Contenido.createSequentialGroup()
								.addComponent(getColordeladrillo(), GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(getComboBox_5(), GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
						.addGap(83))
			);
			gl_Contenido.setVerticalGroup(
				gl_Contenido.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_Contenido.createSequentialGroup()
						.addGroup(gl_Contenido.createParallelGroup(Alignment.BASELINE)
							.addComponent(getColordefondo(), GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(getComboBox_1(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_Contenido.createParallelGroup(Alignment.BASELINE)
							.addComponent(getTamañodebola(), GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(getComboBox_1_2(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Contenido.createParallelGroup(Alignment.BASELINE)
							.addComponent(getColordebola(), GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(getComboBox_2_1(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Contenido.createParallelGroup(Alignment.BASELINE)
							.addComponent(getColordePaddle(), GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(getComboBox_3_1(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Contenido.createParallelGroup(Alignment.BASELINE)
							.addComponent(getSonidos(), GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(getComboBox_4_1(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Contenido.createParallelGroup(Alignment.BASELINE)
							.addComponent(getColordeladrillo(), GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(getComboBox_5(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
			);
			Contenido.setLayout(gl_Contenido);
		}
		return Contenido;
	}
	private JPanel getVolver() {
		if (Volver == null) {
			Volver = new JPanel();
			Volver.setBackground(new Color(255, 218, 185));
			GroupLayout gl_Volver = new GroupLayout(Volver);
			gl_Volver.setHorizontalGroup(
				gl_Volver.createParallelGroup(Alignment.TRAILING)
					.addGroup(Alignment.LEADING, gl_Volver.createSequentialGroup()
						.addGap(176)
						.addComponent(getConfirmar(), GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(168, Short.MAX_VALUE))
			);
			gl_Volver.setVerticalGroup(
				gl_Volver.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_Volver.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(getConfirmar())
						.addContainerGap())
			);
			Volver.setLayout(gl_Volver);
		}
		return Volver;
	}
	private JLabel getTitulillo() {
		if (Titulillo == null) {
			Titulillo = new JLabel("PERSONALIZACION");
			Titulillo.setFont(new Font("Tahoma", Font.BOLD, 30));
		}
		return Titulillo;
	}
	private JLabel getColordePaddle() {
		if (ColordePaddle == null) {
			ColordePaddle = new JLabel("Color de Paddle");
			ColordePaddle.setHorizontalAlignment(SwingConstants.RIGHT);
			ColordePaddle.setFont(new Font("Dialog", Font.BOLD, 12));
		}
		return ColordePaddle;
	}
	private JLabel getTamañodebola() {
		if (Tamañodebola == null) {
			Tamañodebola = new JLabel("Tamaño de bola");
			Tamañodebola.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return Tamañodebola;
	}
	private JLabel getColordefondo() {
		if (Colordefondo == null) {
			Colordefondo = new JLabel("Color de fondo");
			Colordefondo.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return Colordefondo;
	}
	private JLabel getColordebola() {
		if (Colordebola == null) {
			Colordebola = new JLabel("Color de bola");
			Colordebola.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return Colordebola;
	}
	private JComboBox getComboBox_1() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Rojo", "Azul", "Verde", "Amarillo", "Blanco", "Negro"}));
		}
		return comboBox;
	}
	private JLabel getColordeladrillo() {
		if (Colordeladrillo == null) {
			Colordeladrillo = new JLabel("Color de ladrillo");
			Colordeladrillo.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return Colordeladrillo;
	}
	private JLabel getSonidos() {
		if (Sonidos == null) {
			Sonidos = new JLabel("Sonidos");
			Sonidos.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return Sonidos;
	}
	private JComboBox getComboBox_1_2() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Pequeña", "Mediana", "Grande"}));
		}
		return comboBox_1;
	}
	private JComboBox getComboBox_2_1() {
		if (comboBox_2 == null) {
			comboBox_2 = new JComboBox();
			comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Rojo", "Verde", "Azul", "AMarillo", "Blanco", "Negro"}));
		}
		return comboBox_2;
	}
	private JComboBox getComboBox_3_1() {
		if (comboBox_3 == null) {
			comboBox_3 = new JComboBox();
			comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Rojo", "Azul", "Verde", "Amarillo", "Blanco", "Negro"}));
		}
		return comboBox_3;
	}
	private JComboBox getComboBox_4_1() {
		if (comboBox_4 == null) {
			comboBox_4 = new JComboBox();
			comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Wii Sport", "Mario Bross"}));
		}
		return comboBox_4;
	}
	private JComboBox getComboBox_5() {
		if (comboBox_5 == null) {
			comboBox_5 = new JComboBox();
			comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Rojo", "Azul", "Verde", "Amarillo", "Blanco", "Negro"}));
		}
		return comboBox_5;
	}
	private JButton getConfirmar() {
		if (confirmar == null) {
			confirmar = new JButton("Confirmar");
			confirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return confirmar;
	}
}
