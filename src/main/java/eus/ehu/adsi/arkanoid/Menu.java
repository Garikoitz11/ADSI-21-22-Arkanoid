package eus.ehu.adsi.arkanoid;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame implements PropertyChangeListener {

	private JPanel contentPane;
	private JButton btnJugar;
	private JButton btnRanking;
	private JButton btnDificultad;
	private JButton btnPersonalizacion;
	private Boolean activo= false; //comprobador para App
	public static int dificultad = 0;
	public static Color colorFondo = Color.black;
	public static Color colorBola = Color.green;
	public static Color colorPaddle = Color.white;
	public static Color colorBrick = Color.blue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, BorderLayout.CENTER);
		panel_5.add(getBtnJugar());
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		
		panel_2.add(getBtnDificultad());
		
		panel_2.add(getBtnPersonalizacion());
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7, BorderLayout.SOUTH);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9, BorderLayout.NORTH);
		
		JPanel panel_8 = new JPanel();
		panel_3.add(panel_8, BorderLayout.CENTER);
		
		panel_8.add(getBtnRanking());
		
		JButton btnPremios = new JButton("Consultar Premios");
		panel_8.add(btnPremios);
		
		JPanel panel_10 = new JPanel();
		panel_3.add(panel_10, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6, BorderLayout.NORTH);
	}
	
	private JButton getBtnJugar() {
		if (btnJugar == null) {
			btnJugar = new JButton("JUGAR");
			btnJugar.setFont(new Font("Tahoma", Font.PLAIN, 30));
			btnJugar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					activo=true;
				}
			});
		}
		return btnJugar;
	}
	
	private JButton getBtnDificultad() {
		if (btnDificultad == null) {
			btnDificultad = new JButton("Elegir Dificultad");
			btnDificultad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirDificultad();
					setVisible(false);
				}
			});
		}
		return btnDificultad;
	}
	
	public void abrirDificultad() {
		Dificultad dificultad=new Dificultad();
		dificultad.addObserver(this);
		this.setVisible(false);
		dificultad.setVisible(true);
		
	}


	
	private JButton getBtnPersonalizacion() {
		if (btnPersonalizacion == null) {
			btnPersonalizacion = new JButton("Personalizar");
			btnPersonalizacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirPersonalizacion();
					setVisible(false);
				}
			});
		}
		return btnPersonalizacion;
	}
	
	public void abrirPersonalizacion() {
		Personalizacion personalizacion=new Personalizacion();
		personalizacion.addObserver(this);
		this.setVisible(false);
		personalizacion.setVisible(true);
		
	}


	private JButton getBtnRanking() {
		if (btnRanking == null) {
			btnRanking = new JButton("Consultar Ranking");
			btnRanking.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirRanking();
				}
			});
		}
		return btnRanking;
	}
	
	public void abrirRanking() {
		Ranking ranking=new Ranking();
		ranking.setVisible(true);
		
	}
	
	public boolean getActivo() {
		return activo;
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
        if(evt != null) {
            if(evt.getPropertyName().equals("Dificultad")) {
                this.setVisible(true);
				String vdificultad = evt.getNewValue().toString();
				if (vdificultad.equals("0")){
					dificultad = 0;
				} else if (vdificultad.equals("1")) {
					dificultad = 1;
				} else {
					dificultad = 3;
				}
            } else if(evt.getPropertyName().equals("colorFondo")) {
                this.setVisible(true);
                String vcolorFondo = evt.getNewValue().toString();
                if(vcolorFondo.equals("0")) {
                	colorFondo = Color.red;
                }else if(vcolorFondo.equals("1")) {
                	colorFondo = Color.blue;
                }else if(vcolorFondo.equals("2")) {
                	colorFondo = Color.green;
                }else if(vcolorFondo.equals("3")) {
                	colorFondo = Color.yellow;
                }else if(vcolorFondo.equals("4")) {
                	colorFondo = Color.white;
                }else{
                	colorFondo = Color.black;
        }
            }else if(evt.getPropertyName().equals("colorBola")) {
                this.setVisible(true);
                String vcolorBola = evt.getNewValue().toString();
                if(vcolorBola.equals("0")) {
                	colorBola = Color.red;
                }else if(vcolorBola.equals("1")) {
                	colorBola = Color.blue; 
                }else if(vcolorBola.equals("2")) {
                	colorBola = Color.green;
                }else if(vcolorBola.equals("3")) {
                	colorBola = Color.yellow;
                }else if(vcolorBola.equals("4")) {
                	colorBola = Color.white;
                }else{
                	colorBola = Color.black;
        }
            }else if(evt.getPropertyName().equals("colorPaddle")) {
                this.setVisible(true);
                String vcolorPaddle = evt.getNewValue().toString();
                if(vcolorPaddle.equals("0")) {
                	colorPaddle = Color.red;
                }else if(vcolorPaddle.equals("1")) {
                	colorPaddle = Color.blue;
                }else if(vcolorPaddle.equals("2")) {
                	colorPaddle = Color.green;
                }else if(vcolorPaddle.equals("3")) {
                	colorPaddle = Color.yellow;
                }else if(vcolorPaddle.equals("4")) {
                	colorPaddle = Color.white;
                }else{
                	colorPaddle = Color.black;
        }System.out.println(colorBola);
                
            }else if(evt.getPropertyName().equals("colorBrick")) {
                this.setVisible(true);
                String vcolorBrick = evt.getNewValue().toString();
                if(vcolorBrick.equals("0")) {
                	colorBrick = Color.red;
                }else if(vcolorBrick.equals("1")) {
                	colorBrick = Color.blue;
                }else if(vcolorBrick.equals("2")) {
                	colorBrick = Color.green;
                }else if(vcolorBrick.equals("3")) {
                	colorBrick = Color.yellow;
                }else if(vcolorBrick.equals("4")) {
                	colorBrick = Color.white;
                }else{
                	colorBrick = Color.black;
        } 
            }
            }
    }

	public int getDificultad() {
		return dificultad;
	}
	
	public Color getColorFondo() {
		return colorFondo;
	}
	
	public Color getColorBola() {
		return colorBola;
	}

	public Color getColorPaddle() {
		return colorPaddle;
	}
	
	public Color getColorBrick() {
		return colorBrick;
	}
}