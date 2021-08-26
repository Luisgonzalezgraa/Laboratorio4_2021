package vista;

import java.awt.Component;


import javax.swing.JFrame;
import javax.swing.JTextField;

import errores.argumentosInvalidos;
import modelo.RedSocial;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class UsuariosDiriShare {

	private JFrame frame;
	private JTextField Nombre;
	private String NameUser;
	private Integer CantidadU;
	private Integer Id;
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
	public UsuariosDiriShare(RedSocial red,Integer Id,Integer CantidadU,String NombreA) {
		this.red =  red;
		this.Id = Id;
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
		
		ArrayList<String> ListaU = new ArrayList<>();
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String name1 = Nombre.getText();
				red.setAutor(name);
				
				try {
					if(red.existeUsuario(name1) == true) {
						ListaU.add(name1);
						new UsuarioValido().setVisible(true);
					}
					
				} catch (argumentosInvalidos e1) {
					JOptionPane.showMessageDialog(getContentPane(),e1.getMessage() ,"Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
			}

			private Component getContentPane() {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
		
		btnNewButton.setBounds(154, 133, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Hecho");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CompartidoValido(red,name,Id,ListaU,CantidadU).setVisible(true);
			}
		});
		btnNewButton_1.setBounds(154, 164, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFrame().dispose();
			}
		});
		btnNewButton_2.setBounds(154, 206, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
	}
	public String getNameUser() {
		return NameUser;
	}
}
