package eus.ehu.adsi.arkanoid;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class Ranking extends JFrame {

	private JPanel contentPane;
	private JTable tabla;
	private JTable tabla_global;
	private JPanel panelSur;
	private JPanel panelSurCentral;
	private JPanel panelSurSur;
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private JButton btnVolver;
	DefaultTableModel modeloParticular;
	DefaultTableModel modeloGlobal;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Ranking() {
		initialize();
		
		modeloParticular = new DefaultTableModel();
		modeloParticular.addColumn("Dificultad");
		modeloParticular.addColumn("Puntuación");
		getTabla().setModel(modeloParticular);
		
		modeloGlobal = new DefaultTableModel();
		modeloGlobal.addColumn("Usuario");
		modeloGlobal.addColumn("Dificultad");
		modeloGlobal.addColumn("Puntuación");
		getTablaGlobal().setModel(modeloGlobal);
		
	}
		
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getTabla(), BorderLayout.WEST);
		contentPane.add(getTablaGlobal(), BorderLayout.EAST);
		contentPane.add(getPanelSur(), BorderLayout.SOUTH);
		contentPane.add(new JScrollPane(getTabla()), BorderLayout.WEST);
		contentPane.add(new JScrollPane(getTablaGlobal()), BorderLayout.EAST);
		setTitle("Ranking");
	}
	
	private JTable getTabla() {
		if (tabla == null) {
			tabla = new JTable();
		}
		return tabla;
	}
	
	private JTable getTablaGlobal() {
		if (tabla_global == null) {
			tabla_global = new JTable();
		}
		return tabla_global;
	}
	
	private JPanel getPanelSur() {
		if (panelSur == null) {
			panelSur = new JPanel();
			panelSur.setLayout(new BorderLayout(0, 0));	
			panelSur.add(getPanelSurCentral(), BorderLayout.CENTER);
			panelSur.add(getPanelSurSur(), BorderLayout.SOUTH);
		}
		return panelSur;
	}
	
	private JPanel getPanelSurCentral() {
		if (panelSurCentral == null) {
			panelSurCentral = new JPanel();
			panelSurCentral.add(getLblNewLabel());
			panelSurCentral.add(getComboBox());
		}
		return panelSurCentral;
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Filtrar Dificultad :");
		}
		return lblNewLabel;
	}
	
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addItem("Todo");
			comboBox.addItem("1");
			comboBox.addItem("2");
			comboBox.addItem("3");
		}
		return comboBox;
	}
	
	private JPanel getPanelSurSur() {
		if (panelSurSur == null) {
			panelSurSur = new JPanel();
			panelSurSur.add(getBtnVolver());
		}
		return panelSurSur;
	}
	
	private JButton getBtnVolver() {
		if (btnVolver == null) {
			btnVolver = new JButton("Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		}
		return btnVolver;
	}

}
