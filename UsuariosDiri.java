package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UsuariosDiri {

	private JFrame frame;
	private JTextField Nombre;
	private String NameUser;

	public String getNameUser() {
		return NameUser;
	}

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
	public UsuariosDiri(String Nombre) {
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
		NameUser = Nombre.getText();
		
		JLabel lblNewLabel = new JLabel("Ingrese Nombre de Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(114, 38, 216, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFrame().dispose();
			}

			
		});
		btnNewButton.setBounds(157, 182, 85, 21);
		frame.getContentPane().add(btnNewButton);
	}

}
