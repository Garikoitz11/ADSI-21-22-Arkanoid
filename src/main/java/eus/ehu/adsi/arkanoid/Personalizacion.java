package eus.ehu.adsi.arkanoid;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;

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
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Personalizacion extends JFrame {

	private JPanel contentPane;
	private JPanel Título;
	private JPanel Contenido;
	private JPanel Volver;
	private JLabel Titulillo;
	private JLabel ColordePaddle;
	private JLabel Tamanodebola;
	private JLabel Colordefondo;
	private JLabel Colordebola;
	private JComboBox comboBox;
	private JLabel Colordeladrillo;
	private JLabel Sonidos;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JComboBox comboBox_5;
	private JButton confirmar;
	public int colorFondo;
	public int colorBola;
	public int colorPaddle;
	public int colorBrick;
	private PropertyChangeSupport support;
	private JButton btnSonido;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Personalizacion() {
		setBackground(new Color(221, 160, 221));
		initialize();
		support = new PropertyChangeSupport(this);
	}
		
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 459, 378);
		setResizable(false);
		contentPane = new JPanel();
		
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getTítulo(), BorderLayout.NORTH);
		contentPane.add(getContenido(), BorderLayout.CENTER);
		contentPane.add(getVolver(), BorderLayout.SOUTH);
		setTitle("Personalizacion");
	}
	
	public void addObserver(PropertyChangeListener pList) {
		support.addPropertyChangeListener(pList);
	}


	private JPanel getTítulo() {
		if (Título == null) {
			Título = new JPanel();
			Título.setBackground(new Color(32, 178, 170));
			Título.add(getTitulillo());
		}
		return Título;
	}
	private JPanel getContenido() {
		if (Contenido == null) {
			Contenido = new JPanel();
			Contenido.setBackground(new Color(32, 178, 170));
			GroupLayout gl_Contenido = new GroupLayout(Contenido);
			gl_Contenido.setHorizontalGroup(
				gl_Contenido.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_Contenido.createSequentialGroup()
						.addGroup(gl_Contenido.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_Contenido.createSequentialGroup()
								.addComponent(getColordefondo(), GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(getComboBox_1(), GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_Contenido.createSequentialGroup()
								.addComponent(getTamanodebola(), GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
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
								.addComponent(getBtnSonido(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
							.addComponent(getTamanodebola(), GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(getComboBox_1_2(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Contenido.createParallelGroup(Alignment.BASELINE)
							.addComponent(getColordebola(), GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(getComboBox_2_1(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Contenido.createParallelGroup(Alignment.BASELINE)
							.addComponent(getColordePaddle(), GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(getComboBox_3_1(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Contenido.createParallelGroup(Alignment.BASELINE)
							.addComponent(getSonidos(), GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(getBtnSonido()))
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
			Volver.setBackground(new Color(32, 178, 170));
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
	private JLabel getTamanodebola() {
		if (Tamanodebola == null) {
			Tamanodebola = new JLabel("Tamano de bola");
			Tamanodebola.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return Tamanodebola;
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
			comboBox.addItem("red");
			comboBox.addItem("blue");
			comboBox.addItem("green");
			comboBox.addItem("yellow");
			comboBox.addItem("white");
			comboBox.addItem("black");
			comboBox.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
							if(comboBox.getSelectedItem().equals("red")) {
								colorFondo = 0;
							} else if(comboBox.getSelectedItem().equals("blue")) {
								colorFondo = 1;
							} else if(comboBox.getSelectedItem().equals("green")) {
								colorFondo = 2;
							}  else if(comboBox.getSelectedItem().equals("yellow")) {
								colorFondo = 3;
							} else if(comboBox.getSelectedItem().equals("white")) {
								colorFondo = 4;
							}else {
								colorFondo = 5;
							}
                    } 
            } );
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
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Pequena", "Mediana", "Grande"}));
		}
		return comboBox_1;
	}
	private JComboBox getComboBox_2_1() {
		if (comboBox_2 == null) {
			comboBox_2 = new JComboBox();
			comboBox_2.addItem("red");
			comboBox_2.addItem("blue");
			comboBox_2.addItem("green");
			comboBox_2.addItem("yellow");
			comboBox_2.addItem("white");
			comboBox_2.addItem("black");
			comboBox_2.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
							if(comboBox_2.getSelectedItem().equals("red")) {
								colorBola = 0;
							} else if(comboBox_2.getSelectedItem().equals("blue")) {
								colorBola = 1;
							} else if(comboBox_2.getSelectedItem().equals("green")) {
								colorBola = 2;
							}  else if(comboBox_2.getSelectedItem().equals("yellow")) {
								colorBola = 3;
							} else if(comboBox_2.getSelectedItem().equals("white")) {
								colorBola = 4;
							}else {
								colorBola = 5;
							}System.out.println(colorBola);
                    } 
            } );
		}
		return comboBox_2;
	}
	private JComboBox getComboBox_3_1() {
		if (comboBox_3 == null) {
			comboBox_3 = new JComboBox();
			comboBox_3.addItem("red");
			comboBox_3.addItem("blue");
			comboBox_3.addItem("green");
			comboBox_3.addItem("yellow");
			comboBox_3.addItem("white");
			comboBox_3.addItem("black");
			comboBox_3.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
							if(comboBox_3.getSelectedItem().equals("red")) {
								colorPaddle = 0;
							} else if(comboBox_3.getSelectedItem().equals("blue")) {
								colorPaddle = 1;
							} else if(comboBox_3.getSelectedItem().equals("green")) {
								colorPaddle = 2;
							}  else if(comboBox_3.getSelectedItem().equals("yellow")) {
								colorPaddle = 3;
							} else if(comboBox_3.getSelectedItem().equals("white")) {
								colorPaddle = 4;
							}else {
								colorPaddle = 5;
							}
                    } 
            } );
		}
		return comboBox_3;
	}
	private JComboBox getComboBox_5() {
		if (comboBox_5 == null) {
			comboBox_5 = new JComboBox();
			comboBox_5.addItem("red");
			comboBox_5.addItem("blue");
			comboBox_5.addItem("green");
			comboBox_5.addItem("yellow");
			comboBox_5.addItem("white");
			comboBox_5.addItem("black");
			comboBox_5.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
							if(comboBox_5.getSelectedItem().equals("red")) {
								colorBrick = 0;
							} else if(comboBox_5.getSelectedItem().equals("blue")) {
								colorBrick = 1;
							} else if(comboBox_5.getSelectedItem().equals("green")) {
								colorBrick = 2;
							}  else if(comboBox_5.getSelectedItem().equals("yellow")) {
								colorBrick = 3;
							} else if(comboBox_5.getSelectedItem().equals("white")) {
								colorBrick = 4;
							}else {
								colorBrick = 5;
							}
                    } 
            } );
		}
		return comboBox_5;
	}
	private JButton getConfirmar() {
		if (confirmar == null) {
			confirmar = new JButton("Confirmar");
			confirmar.setBackground(new Color(224, 255, 255));
			confirmar.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
                    volver();
                    /*volver1();
                    volver2();
                    volver3();*/
                }
            });
        }
        return confirmar;
    }

	public void volver() {
		support.firePropertyChange("colorFondo", false, colorFondo);
		support.firePropertyChange("colorBola", false, colorBola);
		support.firePropertyChange("colorPaddle", false, colorPaddle);
		support.firePropertyChange("colorBrick", false, colorBrick);
		this.dispose();
	}
	private JButton getBtnSonido() {
		if (btnSonido == null) {
			btnSonido = new JButton("PLAY");
			btnSonido.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e) {
					try {
						Clip sonido = AudioSystem.getClip();
							sonido.open(AudioSystem.getAudioInputStream(new File("scr/main/resources/cancion.mav")));
							sonido.start();
							sonido.stop();
					} catch (LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (UnsupportedAudioFileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
			});
		}
		return btnSonido;
	}
	

}
