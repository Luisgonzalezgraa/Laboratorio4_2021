package vista;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JTextField;

import errores.argumentosInvalidos;
import errores.usuarioRegistrado;

import javax.swing.JPasswordField;
import modelo.RedSocial;

public class Gui {

	private JFrame frame;
	private JTextField NombreU;
	private RedSocial red = new RedSocial();
	
	
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 450, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = NombreU.getText();
				@SuppressWarnings("deprecation")
				String pass = passwordField.getText();
				try {
					red.register(nombre,pass);
				} catch (argumentosInvalidos e1) {
					JOptionPane.showMessageDialog(getContentPane(),e1.getMessage() ,"Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (usuarioRegistrado e1) {
					JOptionPane.showMessageDialog(getContentPane(),e1.getMessage() ,"Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
			}

			private Component getContentPane() {
				return null;
			}
		});
		btnNewButton.setBounds(163, 147, 113, 35);
		frame.getContentPane().add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Ingresar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre2 = NombreU.getText();
				String pass2 = passwordField.getText();
				boolean usuarioL;
				try {
					usuarioL = red.login(nombre2, pass2);
					if (usuarioL == true) {
						RedSocialView redView = new RedSocialView(red,nombre2);
						redView.frame.setVisible(true);
					}
				
				}catch (argumentosInvalidos e1) {
					JOptionPane.showMessageDialog(getContentPane(),e1.getMessage() ,"Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
					
				}
			
				
			}

			private Component getContentPane() {
				return null;
			}
		});
		btnNewButton_1.setBounds(163, 192, 113, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFrame().dispose();
			}
		});
		btnNewButton_2.setBounds(307, 218, 119, 35);
		frame.getContentPane().add(btnNewButton_2);
		
		NombreU = new JTextField();
		NombreU.setBounds(80, 34, 276, 29);
		frame.getContentPane().add(NombreU);
		NombreU.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(80, 10, 79, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(80, 73, 124, 25);
		frame.getContentPane().add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(80, 108, 276, 29);
		frame.getContentPane().add(passwordField);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
