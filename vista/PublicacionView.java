package vista;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;

import errores.cantidadDeUsuarios;
import errores.argumentosInvalidos;
import errores.usuarioRegistrado;
import modelo.RedSocial;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PublicacionView {

	private JFrame frame;
	private JTextField tipoPublicacion;
	private JTextField publi;
	private JTextField CantidadU;
	private String tipoPubli;
	private String publicacion1;
	private String cUsuarios;
	private Integer cantidadUsuariosR;
	private RedSocial red;
	private String name;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PublicacionView window = new PublicacionView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the application.
	 */
	
	public PublicacionView(RedSocial red, String name) {
		this.red = red;
		this.name = name;
		initialize();
	}

	public Integer getCantidadUsuariosR() {
		return cantidadUsuariosR;
	}

	public void setCantidadUsuariosR(Integer cantidadUsuariosR) {
		this.cantidadUsuariosR = cantidadUsuariosR;
	}

	public String getTipoPubli() {
		return tipoPubli;
	}

	public void setTipoPubli(String tipoPubli) {
		this.tipoPubli = tipoPubli;
	}

	public String getPublicacion1() {
		return publicacion1;
	}

	public void setPublicacion1(String publicacion1) {
		this.publicacion1 = publicacion1;
	}

	public String getcUsuarios() {
		return cUsuarios;
	}

	public void setcUsuarios(String cUsuarios) {
		this.cUsuarios = cUsuarios;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 491, 347);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel publicacion = new JLabel("Ingrese Publicaci\u00F3n:");
		publicacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		publicacion.setBounds(10, 89, 137, 25);
		frame.getContentPane().add(publicacion);
		
		JLabel tipoP = new JLabel("Ingrese Tipo de Publicaci\u00F3n:");
		tipoP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tipoP.setBounds(10, 38, 163, 25);
		frame.getContentPane().add(tipoP);
		
		JLabel cantidadU = new JLabel("Ingrese Cantidad de usuarios Dirigida la Publicaci\u00F3n:");
		cantidadU.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cantidadU.setBounds(10, 149, 282, 25);
		frame.getContentPane().add(cantidadU);
		
		tipoPublicacion = new JTextField();
		tipoPublicacion.setBounds(173, 42, 294, 34);
		frame.getContentPane().add(tipoPublicacion);
		tipoPublicacion.setColumns(10);
		
		publi = new JTextField();
		publi.setBounds(131, 93, 336, 34);
		frame.getContentPane().add(publi);
		publi.setColumns(10);
		
		CantidadU = new JTextField();
		CantidadU.setBounds(302, 153, 165, 34);
		frame.getContentPane().add(CantidadU);
		CantidadU.setColumns(10);
		
		JButton Siguiente = new JButton("Siguiente");
		Siguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTipoPubli(tipoPublicacion.getText());  
				setPublicacion1(publi.getText());
				setcUsuarios(CantidadU.getText());
				setCantidadUsuariosR(Integer.valueOf(cUsuarios));
				red.setAutor(name);
				try {
					if(red.existeCantidadU(cantidadUsuariosR) == true) {
						UsuariosDiri usuariosD = new UsuariosDiri(red,tipoPubli, publicacion1, cantidadUsuariosR, name);
			            usuariosD.getFrame().setVisible(true);
					}
				} catch (argumentosInvalidos | cantidadDeUsuarios e1) {
					JOptionPane.showMessageDialog(getContentPane(),e1.getMessage() ,"Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
	            
				
			}

			private Component getContentPane() {
				// TODO Auto-generated method stub
				return null;
			}

		});
		Siguiente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Siguiente.setBounds(310, 252, 137, 34);
		frame.getContentPane().add(Siguiente);
		
		JButton atras = new JButton("Atras");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFrame().dispose();
			}

			
		});
		atras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		atras.setBounds(21, 252, 137, 34);
		frame.getContentPane().add(atras);
	}
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
