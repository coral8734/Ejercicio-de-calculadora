package PracticaCalculadora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import javax.swing.SwingConstants;

public class Calculadora {

	JFrame frmCalculadoraCientfica;
	JFrame frame2;
	JTextField textN1;
	JTextField textN2;
	JTextField textResultado;
	
	
	private double  resultadoTemp;
	String pantalla;
	
	//boolean pantallaPrincipal = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora window = new Calculadora();
					window.frmCalculadoraCientfica.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculadoraCientfica = new JFrame();
		frmCalculadoraCientfica.getContentPane().setBackground(new Color(148, 0, 211));
		frmCalculadoraCientfica.setBackground(new Color(148, 0, 211));
		frmCalculadoraCientfica.setTitle("Calculadora ");
		frmCalculadoraCientfica.setBounds(100, 100, 466, 472);
		frmCalculadoraCientfica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculadoraCientfica.getContentPane().setLayout(null);
		
		textN1 = new JTextField();
		textN1.setForeground(Color.BLACK);
		textN1.setFont(new Font("Roboto Black", Font.BOLD, 18));
		textN1.setColumns(10);
		textN1.setBackground(new Color(255, 240, 245));
		textN1.setBounds(31, 22, 135, 31);
		frmCalculadoraCientfica.getContentPane().add(textN1);
		
		JLabel lblNewLabel = new JLabel("N\u00FAmero 1");
		lblNewLabel.setFont(new Font("Roboto Black", Font.BOLD, 18));
		lblNewLabel.setBounds(57, 0, 97, 22);
		frmCalculadoraCientfica.getContentPane().add(lblNewLabel);
		
		JLabel lblNmero = new JLabel("N\u00FAmero 2");
		lblNmero.setFont(new Font("Roboto Black", Font.BOLD, 18));
		lblNmero.setBounds(271, 0, 97, 22);
		frmCalculadoraCientfica.getContentPane().add(lblNmero);
		
		textN2 = new JTextField();
		textN2.setFont(new Font("Roboto Black", Font.BOLD, 18));
		textN2.setColumns(10);
		textN2.setBackground(new Color(255, 240, 245));
		textN2.setBounds(258, 22, 135, 31);
		frmCalculadoraCientfica.getContentPane().add(textN2);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Roboto Black", Font.BOLD, 18));
		lblResultado.setBounds(31, 77, 269, 22);
		frmCalculadoraCientfica.getContentPane().add(lblResultado);
		
		textResultado = new JTextField();
		textResultado.setFont(new Font("Roboto Black", Font.BOLD, 18));
		textResultado.setEditable(false);
		textResultado.setColumns(10);
		textResultado.setBackground(new Color(255, 240, 245));
		textResultado.setBounds(31, 109, 269, 31);
		frmCalculadoraCientfica.getContentPane().add(textResultado);
		
	    JButton btnSumar = new JButton("+");
		btnSumar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				botonSuma();
			}
		});
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSumar.setForeground(Color.BLACK);
		btnSumar.setFont(new Font("Roboto Black", Font.BOLD, 18));
		btnSumar.setBackground(new Color(255, 182, 193));
		btnSumar.setBounds(31, 150, 79, 51);
		frmCalculadoraCientfica.getContentPane().add(btnSumar);
		
		JButton btnRestar = new JButton("-");
		btnRestar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				botonResta();
			}
		});
		btnRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRestar.setForeground(Color.BLACK);
		btnRestar.setFont(new Font("Roboto Black", Font.BOLD, 20));
		btnRestar.setBackground(new Color(255, 182, 193));
		btnRestar.setBounds(130, 149, 79, 51);
		frmCalculadoraCientfica.getContentPane().add(btnRestar);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			     pantalla=textResultado.getText();

			       if(pantalla.length()>0){

			          pantalla=pantalla.substring(0, pantalla.length()-1);

			          textResultado.setText(pantalla);

			       }
				
			}
		});
		btnC.setForeground(Color.BLACK);
		btnC.setFont(new Font("Roboto Black", Font.BOLD, 18));
		btnC.setBackground(new Color(255, 182, 193));
		btnC.setBounds(345, 150, 81, 51);
		frmCalculadoraCientfica.getContentPane().add(btnC);
		
		JButton btnCE = new JButton("CE");
		btnCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textResultado.setText(" ");
				
			}
		});
		btnCE.setForeground(Color.BLACK);
		btnCE.setFont(new Font("Roboto Black", Font.BOLD, 18));
		btnCE.setBackground(new Color(255, 182, 193));
		btnCE.setBounds(345, 228, 81, 51);
		frmCalculadoraCientfica.getContentPane().add(btnCE);
		
		JButton btnDividir = new JButton("/");
		btnDividir.setForeground(Color.BLACK);
		btnDividir.setFont(new Font("Roboto Black", Font.BOLD, 18));
		btnDividir.setBackground(new Color(255, 182, 193));
		btnDividir.setBounds(130, 228, 79, 51);
		frmCalculadoraCientfica.getContentPane().add(btnDividir);
		
		JButton btnMultiplicar = new JButton("x");
		btnMultiplicar.addMouseListener(new MouseAdapter() {
			@Override
			
			
	public void mouseClicked(MouseEvent e) {
				
				botonMultiplicacion();
			}
		});
		btnMultiplicar.setForeground(Color.BLACK);
		btnMultiplicar.setFont(new Font("Roboto Black", Font.BOLD, 18));
		btnMultiplicar.setBackground(new Color(255, 182, 193));
		btnMultiplicar.setBounds(31, 228, 79, 51);
		frmCalculadoraCientfica.getContentPane().add(btnMultiplicar);
		
		JButton btnPorcentaje = new JButton("%");
		btnPorcentaje.setForeground(Color.BLACK);
		btnPorcentaje.setFont(new Font("Roboto Black", Font.BOLD, 18));
		btnPorcentaje.setBackground(new Color(255, 182, 193));
		btnPorcentaje.setBounds(31, 301, 79, 51);
		frmCalculadoraCientfica.getContentPane().add(btnPorcentaje);
		
		JButton btnEquals = new JButton("=");
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 textResultado.setText(String.valueOf(resultadoTemp));	
				
			}
		});
		btnEquals.setForeground(Color.BLACK);
		btnEquals.setFont(new Font("Roboto Black", Font.BOLD, 18));
		btnEquals.setBackground(new Color(255, 182, 193));
		btnEquals.setBounds(345, 301, 81, 51);
		frmCalculadoraCientfica.getContentPane().add(btnEquals);
		
		JButton btnRaiz = new JButton("\u221A");
		btnRaiz.addMouseListener(new MouseAdapter() {
			;
			
			public void mouseClicked(MouseEvent e) {
				
				
				 botonRaiz();
			}
		});
		btnRaiz.setForeground(Color.BLACK);
		btnRaiz.setFont(new Font("Roboto Black", Font.BOLD, 18));
		btnRaiz.setBackground(new Color(255, 182, 193));
		btnRaiz.setBounds(130, 301, 79, 51);
		frmCalculadoraCientfica.getContentPane().add(btnRaiz);
		
		JButton Inverso = new JButton("1/x");
		Inverso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				botonAlaInversa();
			}

		
		});
		Inverso.setForeground(Color.BLACK);
		Inverso.setFont(new Font("Roboto Black", Font.BOLD, 18));
		Inverso.setBackground(new Color(255, 182, 193));
		Inverso.setBounds(240, 150, 80, 51);
		frmCalculadoraCientfica.getContentPane().add(Inverso);
		
		JButton btnPotencia = new JButton("^");
		btnPotencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPotencia.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				botonPotencia();
			}

		});
		btnPotencia.setForeground(Color.BLACK);
		btnPotencia.setFont(new Font("Roboto Black", Font.BOLD, 18));
		btnPotencia.setBackground(new Color(255, 182, 193));
		btnPotencia.setBounds(240, 228, 80, 51);
		frmCalculadoraCientfica.getContentPane().add(btnPotencia);
		
		JButton btnPunto = new JButton(".");
		btnPunto.addMouseListener(new MouseAdapter() {
			
		});
		btnPunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

			     pantalla=textResultado.getText();



			     if(pantalla.length()<=0)

			      {

			         textResultado.setText("o.");

			       }


			      else if(!hayPunto(textResultado.getText().replace(',', '.')))

			      {

			    	  textResultado.setText( textResultado.getText() + ".");

			      }
				
				
				
			}

			private boolean hayPunto(String text) {
				
				boolean rpt;
				rpt= false;
				
				for (int i = 0; i < pantalla.length(); i++) {
					
					if (pantalla.substring(i, i+1).equals(".")) {
						
						rpt = true;
						
						break;
					}
	
						}
				
				return rpt;
				
			}

			
		});
		btnPunto.setForeground(Color.BLACK);
		btnPunto.setFont(new Font("Roboto Black", Font.BOLD, 18));
		btnPunto.setBackground(new Color(255, 182, 193));
		btnPunto.setBounds(240, 301, 80, 51);
		frmCalculadoraCientfica.getContentPane().add(btnPunto);
		
		JButton btnFuncion = new JButton("Funcion");
		btnFuncion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFuncion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			botonFuncion();
			}

			
		});
		btnFuncion.setForeground(Color.BLACK);
		btnFuncion.setFont(new Font("Roboto Black", Font.BOLD, 18));
		btnFuncion.setBackground(new Color(255, 182, 193));
		btnFuncion.setBounds(310, 112, 116, 22);
		frmCalculadoraCientfica.getContentPane().add(btnFuncion);
	}
	
	//TODO: Creo los métodos de la pantalla principal
	public void botonSuma() {
		
		double num1 = 0.0;
		double num2 = 0.0;
		try {
			num1=Double.parseDouble(textN1.getText().replace(',', '.'));
			num2=Double.parseDouble(textN2.getText().replace(',', '.'));
			resultadoTemp = Controlador.Suma(num1,num2);
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error, introduzca un número porfavor.");
		}
		
	
		
	}
	public void botonResta() {
		
		double num1 = 0.0;
		double num2 = 0.0;
		try {
			num1=Double.parseDouble(textN1.getText().replace(',', '.'));
			num2=Double.parseDouble(textN2.getText().replace(',', '.'));
			resultadoTemp = Controlador.Resta(num1, num2);
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error, introduzca un número porfavor.");
		}		
		
	}
	public void botonMultiplicacion() {
	
	double num1 = 0.0;
	double num2 = 0.0;
	try {
		num1=Double.parseDouble(textN1.getText().replace(',', '.'));
		num2=Double.parseDouble(textN2.getText().replace(',', '.'));
		resultadoTemp = Controlador.Multiplicacion(num1, num2);
		
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Error, introduzca un número porfavor.");
	}		
	
}
	
	public void botonRaiz() {
		
		double num1 = 0.0;
		
		
		
		if (textN1.getText().equals(" ")) {
			
			JOptionPane.showMessageDialog(null, "Los Campos estan vacios","Error",JOptionPane.ERROR_MESSAGE);
		}else {
			
			if (num1<=0) {
				try {
					
					
					num1=Double.parseDouble(textN1.getText().replace(',', '.'));
					
					resultadoTemp = Controlador.RaizCuadrada(num1);
					
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error, introduzca un número porfavor.");
				}		
				
				
			}else {
				JOptionPane.showMessageDialog(null, "No existe la raíz negativa.", "Error",JOptionPane.ERROR_MESSAGE);	
			}
			
			
		}
					
		
	}
	
	public void botonPotencia() {
		
		double num1 = 0.0;
		
		double num2= 0.0;
		
		if (textN1.getText().equals(" ")) {
			
			JOptionPane.showMessageDialog(null, "Los Campos estan vacios","Error",JOptionPane.ERROR_MESSAGE);
		}else {
				try {
					
					
					num1=Double.parseDouble(textN1.getText().replace(',', '.'));
					
					num2=Double.parseDouble(textN2.getText().replace(',', '.'));
					
					resultadoTemp = Controlador.Potencia(num1, num2);
					
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error, introduzca un número porfavor.");
				}			
			
		}
							
		
	}
	public void botonAlaInversa() {
		
		double num1 = 0.0;
		
	
		
		if (textN1.getText().equals(" ")) {
			
			JOptionPane.showMessageDialog(null, "Los Campos estan vacios","Error",JOptionPane.ERROR_MESSAGE);
		}else {
				try {
					
					
					num1=Double.parseDouble(textN1.getText().replace(',', '.'));
					
					
					
					resultadoTemp = Controlador.Inversa(num1);
					
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error, introduzca un número porfavor.");
				}			
			
		}
							
		
		
}
	//TODO: Método del botón función que genera la segunda pantalla
	public void botonFuncion() {
		
		frame2 = new JFrame();		
		
		
		
		textN1 = new JTextField();
		textN1.setForeground(Color.BLACK);
		textN1.setFont(new Font("Roboto Black", Font.BOLD, 18));
		textN1.setColumns(10);
		textN1.setBackground(new Color(255, 240, 245));
		textN1.setBounds(31, 22, 135, 31);
		frame2.getContentPane().add(textN1);
		
		JLabel lblNewLabel = new JLabel("N\u00FAmero 1");
		lblNewLabel.setFont(new Font("Roboto Black", Font.BOLD, 18));
		lblNewLabel.setBounds(57, 0, 97, 22);
		frame2.getContentPane().add(lblNewLabel);
		
		JLabel lblNmero = new JLabel("N\u00FAmero 2");
		lblNmero.setFont(new Font("Roboto Black", Font.BOLD, 18));
		lblNmero.setBounds(271, 0, 97, 22);
		frame2.getContentPane().add(lblNmero);
		
		textN2 = new JTextField();
		textN2.setFont(new Font("Roboto Black", Font.BOLD, 18));
		textN2.setColumns(10);
		textN2.setBackground(new Color(255, 240, 245));
		textN2.setBounds(258, 22, 135, 31);
		frame2.getContentPane().add(textN2);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Roboto Black", Font.BOLD, 18));
		lblResultado.setBounds(31, 77, 269, 22);
		frame2.getContentPane().add(lblResultado);
		
		textResultado = new JTextField();
		textResultado.setFont(new Font("Roboto Black", Font.BOLD, 18));
		textResultado.setEditable(false);
		textResultado.setColumns(10);
		textResultado.setBackground(new Color(255, 240, 245));
		textResultado.setBounds(31, 109, 269, 31);
		frame2.getContentPane().add(textResultado);
		
		
		frame2.getContentPane().setBackground(new Color(148, 0, 211));
		frame2.setBackground(new Color(148, 0, 211));
		frame2.setTitle("Calculadora Cientifica");
		frame2.setBounds(100, 100, 466, 472);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		
		JButton btnCos = new JButton("Cos");
		btnCos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				double num1 = 0.0;
				
				
				
				if (textN1.getText().equals(" ")) {
					
					JOptionPane.showMessageDialog(null, "Los Campos estan vacios","Error",JOptionPane.ERROR_MESSAGE);
				}else {
						try {
							
							
							num1=Double.parseDouble(textN1.getText().replace(',', '.'));
							
							
							
							resultadoTemp = Controlador.Coseno(num1);
							
							
						} catch (Exception i) {
							JOptionPane.showMessageDialog(null, "Error, introduzca un número porfavor.");
						}			
					
				}
				
			}
			
		});
		btnCos.setForeground(Color.BLACK);
		btnCos.setFont(new Font("Roboto Black", Font.BOLD, 18));
		btnCos.setBackground(new Color(255, 182, 193));
		btnCos.setBounds(31, 150, 79, 51);
		frame2.getContentPane().add(btnCos);
		
		JButton btnSeno = new JButton("Sen");
		btnSeno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
	double num1 = 0.0;
				
				
				
				if (textN1.getText().equals(" ")) {
					
					JOptionPane.showMessageDialog(null, "Los Campos estan vacios","Error",JOptionPane.ERROR_MESSAGE);
				}else {
						try {
							
							
							num1=Double.parseDouble(textN1.getText().replace(',', '.'));
							
							
							
							resultadoTemp = Controlador.Seno(num1);
							
							
						} catch (Exception i) {
							JOptionPane.showMessageDialog(null, "Error, introduzca un número porfavor.");
						}			
					
				}
				
			}
			
		});
		btnSeno.setForeground(Color.BLACK);
		btnSeno.setFont(new Font("Roboto Black", Font.BOLD, 18));
		btnSeno.setBackground(new Color(255, 182, 193));
		btnSeno.setBounds(31, 228, 79, 51);
		frame2.getContentPane().add(btnSeno);
		
		JButton btnSecante = new JButton("Sec");
		btnSecante.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
	double num1 = 0.0;
	double secante = 0.0;			
				
				
				if (textN1.getText().equals(" ")) {
					
					JOptionPane.showMessageDialog(null, "Los Campos estan vacios","Error",JOptionPane.ERROR_MESSAGE);
				}else {
						try {
							
							
							num1=Double.parseDouble(textN1.getText().replace(',', '.'));
							//secante=Double.parseDouble(textN1.getText().replace(',', '.'));
							
							
							
							resultadoTemp = Controlador.Secante(num1, secante);
							
							
						} catch (Exception i) {
							JOptionPane.showMessageDialog(null, "Error, introduzca un número porfavor.");
						}			
					
				}
				
			}
			
		});
		btnSecante.setForeground(Color.BLACK);
		btnSecante.setFont(new Font("Roboto Black", Font.BOLD, 20));
		btnSecante.setBackground(new Color(255, 182, 193));
		btnSecante.setBounds(130, 149, 79, 51);
		frame2.getContentPane().add(btnSecante);
		
		JButton btnTangente = new JButton("Tan");
		btnTangente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
	double num1 = 0.0;
				
				
				
				if (textN1.getText().equals(" ")) {
					
					JOptionPane.showMessageDialog(null, "Los Campos estan vacios","Error",JOptionPane.ERROR_MESSAGE);
				}else {
						try {
							
							
							num1=Double.parseDouble(textN1.getText().replace(',', '.'));
							
							
							
							resultadoTemp = Controlador.Tangente(num1);
							
							
						} catch (Exception i) {
							JOptionPane.showMessageDialog(null, "Error, introduzca un número porfavor.");
						}			
					
				}
				
			}
			
		});
		btnTangente.setForeground(Color.BLACK);
		btnTangente.setFont(new Font("Roboto Black", Font.BOLD, 18));
		btnTangente.setBackground(new Color(255, 182, 193));
		btnTangente.setBounds(31, 301, 79, 51);
		frame2.getContentPane().add(btnTangente);
		
		JButton btnCotangente = new JButton("Cot");
		btnCotangente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			double num1 = 0.0;
			double cotangente= 0.0;
				
				
				if (textN1.getText().equals(" ")) {
					
					JOptionPane.showMessageDialog(null, "Los Campos estan vacios","Error",JOptionPane.ERROR_MESSAGE);
				}else {
						try {
							
							
							num1=Double.parseDouble(textN1.getText().replace(',', '.'));
							
							
							
							
							resultadoTemp = Controlador.Cotangente(num1, cotangente);
							
							
						} catch (Exception i) {
							JOptionPane.showMessageDialog(null, "Error, introduzca un número porfavor.");
						}			
					
				}
				
				
				
			}
			
		});
		btnCotangente.setForeground(Color.BLACK);
		btnCotangente.setFont(new Font("Roboto Black", Font.BOLD, 18));
		btnCotangente.setBackground(new Color(255, 182, 193));
		btnCotangente.setBounds(130, 228, 79, 51);
		frame2.getContentPane().add(btnCotangente);
		
		JButton btnCosecante = new JButton("Csc");
		btnCosecante.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				double num1 = 0.0;
				double cosecante= 0.0;
					
					
					if (textN1.getText().equals(" ")) {
						
						JOptionPane.showMessageDialog(null, "Los Campos estan vacios","Error",JOptionPane.ERROR_MESSAGE);
					}else {
							try {
								
								
								num1=Double.parseDouble(textN1.getText().replace(',', '.'));
								
								
								
								resultadoTemp = Controlador.Cosecante(num1, cosecante);
								
								
							} catch (Exception i) {
								JOptionPane.showMessageDialog(null, "Error, introduzca un número porfavor.");
							}			
						
					}
				
				
				
			}
			
		});
		btnCosecante.setForeground(Color.BLACK);
		btnCosecante.setFont(new Font("Roboto Black", Font.BOLD, 18));
		btnCosecante.setBackground(new Color(255, 182, 193));
		btnCosecante.setBounds(130, 301, 79, 51);
		frame2.getContentPane().add(btnCosecante);
		
		JButton btnArcseno = new JButton("Asin");
		btnArcseno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double num1 = 0.0;
				
				double arcseno= 0.0;
					
					
					if (textN1.getText().equals(" ")) {
						
						JOptionPane.showMessageDialog(null, "Los Campos estan vacios","Error",JOptionPane.ERROR_MESSAGE);
					}else {
							try {
								
								
								num1=Double.parseDouble(textN1.getText().replace(',', '.'));
								
								
								
								
								resultadoTemp = Controlador.Arcseno(num1, arcseno);
								
								
							} catch (Exception i) {
								JOptionPane.showMessageDialog(null, "Error, introduzca un número porfavor.");
							}			
						
					}
				
			}
			
		});
		btnArcseno.setForeground(Color.BLACK);
		btnArcseno.setFont(new Font("Roboto Black", Font.BOLD, 18));
		btnArcseno.setBackground(new Color(255, 182, 193));
		btnArcseno.setBounds(240, 150, 80, 51);
		frame2.getContentPane().add(btnArcseno);
		
		JButton btnArcos = new JButton("Acos");
		btnArcos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				double num1 = 0.0;
				double arcCos= 0.0;
					
					
					if (textN1.getText().equals(" ")) {
						
						JOptionPane.showMessageDialog(null, "Los Campos estan vacios","Error",JOptionPane.ERROR_MESSAGE);
					}else {
							try {
								
								
								num1=Double.parseDouble(textN1.getText().replace(',', '.'));
								
								
								
								
								resultadoTemp = Controlador.ArcCos(num1,arcCos);
								
								
							} catch (Exception i) {
								JOptionPane.showMessageDialog(null, "Error, introduzca un número porfavor.");
							}			
						
					}
				
				
			}
			
		});
		btnArcos.setForeground(Color.BLACK);
		btnArcos.setFont(new Font("Roboto Black", Font.BOLD, 18));
		btnArcos.setBackground(new Color(255, 182, 193));
		btnArcos.setBounds(240, 228, 80, 51);
		frame2.getContentPane().add(btnArcos);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			     pantalla=textResultado.getText();

			       if(pantalla.length()>0){

			          pantalla=pantalla.substring(0, pantalla.length()-1);

			          textResultado.setText(pantalla);

			       }
				
			}
		});
		btnC.setForeground(Color.BLACK);
		btnC.setFont(new Font("Roboto Black", Font.BOLD, 18));
		btnC.setBackground(new Color(255, 182, 193));
		btnC.setBounds(345, 150, 81, 51);
		frame2.getContentPane().add(btnC);
		
		JButton btnCE = new JButton("CE");
		btnCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textResultado.setText(" ");
				
			}
		});
		btnCE.setForeground(Color.BLACK);
		btnCE.setFont(new Font("Roboto Black", Font.BOLD, 18));
		btnCE.setBackground(new Color(255, 182, 193));
		btnCE.setBounds(345, 228, 81, 51);
		frame2.getContentPane().add(btnCE);
		
		JButton btnEquals = new JButton("=");
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 textResultado.setText(String.valueOf(resultadoTemp));	
				
			}
		});
		btnEquals.setForeground(Color.BLACK);
		btnEquals.setFont(new Font("Roboto Black", Font.BOLD, 18));
		btnEquals.setBackground(new Color(255, 182, 193));
		btnEquals.setBounds(345, 301, 81, 51);
		frame2.getContentPane().add(btnEquals);
		
		JButton btnPunto = new JButton(".");
		btnPunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

			     pantalla=textResultado.getText();



			     if(pantalla.length()<=0)

			      {

			         textResultado.setText("o.");

			       }


			      else if(!hayPunto(textResultado.getText().replace(',', '.')))

			      {

			    	  textResultado.setText( textResultado.getText() + ".");

			      }
				
				
				
			}

			private boolean hayPunto(String text) {
				
				boolean rpt;
				rpt= false;
				
				for (int i = 0; i < pantalla.length(); i++) {
					
					if (pantalla.substring(i, i+1).equals(".")) {
						
						rpt = true;
						
						break;
					}
	
						}
				
				return rpt;
				
			}

			
		});
		btnPunto.setForeground(Color.BLACK);
		btnPunto.setFont(new Font("Roboto Black", Font.BOLD, 18));
		btnPunto.setBackground(new Color(255, 182, 193));
		btnPunto.setBounds(240, 301, 80, 51);
		frame2.getContentPane().add(btnPunto);
		
		JButton btnFuncion = new JButton("Funcion");
		btnFuncion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				botonFun();
			}

			
		});
		btnFuncion.setForeground(Color.BLACK);
		btnFuncion.setFont(new Font("Roboto Black", Font.BOLD, 18));
		btnFuncion.setBackground(new Color(255, 182, 193));
		btnFuncion.setBounds(310, 112, 116, 22);
		frame2.getContentPane().add(btnFuncion);
	
		
		//VISUALIZACIÓN DE LOS PANELES Si se pulsa el boton función el frame principal pasa a no ser visible y se muestra la segunda pantalla con otros botones
		frmCalculadoraCientfica.setVisible(false);
		frame2.setVisible(true);
	}
    
	//TODO: Método para  que la calculadora vuelva a la pantalla principal
	public void botonFun() {
	frmCalculadoraCientfica.setVisible(true);
	frame2.setVisible(false);
	
	
	
	
    }
}


