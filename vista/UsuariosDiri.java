package vista;

import java.awt.Component;


import javax.swing.JFrame;
import javax.swing.JTextField;

import errores.argumentosInvalidos;
import errores.cantidadDeUsuarios;
import errores.usuarioRegistrado;
import modelo.RedSocial;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UsuariosDiri {

	private JFrame frame;
	private JTextField Nombre;
	private String NameUser;
	private String tipoPubli;
	private String Publi;
	private Integer CantidadU;
	
	private RedSocial red;
	private String name;
	

	
	public void setNameUser(String nameUser) {
		NameUser = nameUser;
	}

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String Nombre = null;
					UsuariosDiri window = new UsuariosDiri(Nombre);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	/**
	 * Create the application.
	 */
	public UsuariosDiri(RedSocial red,String tipoPubli,String Publi,Integer CantidadU,String NombreA) {
		this.red =  red;
		this.tipoPubli = tipoPubli;
		this.Publi = Publi;
		this.CantidadU = CantidadU;
		this.name = NombreA;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Nombre = new JTextField();
		Nombre.setBounds(120, 91, 168, 32);
		frame.getContentPane().add(Nombre);
		Nombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ingrese Nombre de Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(114, 38, 216, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String name1 = Nombre.getText();
				red.setAutor(name);
				try {
					
					red.post(tipoPubli, Publi, CantidadU,name1);
				} catch (argumentosInvalidos | usuarioRegistrado | cantidadDeUsuarios e1) {
					JOptionPane.showMessageDialog(getContentPane(),e1.getMessage() ,"Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
				getFrame().dispose();	
			}

			private Component getContentPane() {
				// TODO Auto-generated method stub
				return null;
			}

			
		});
		
		btnNewButton.setBounds(157, 182, 85, 21);
		frame.getContentPane().add(btnNewButton);
	}
	public String getNameUser() {
		return NameUser;
	}

}
