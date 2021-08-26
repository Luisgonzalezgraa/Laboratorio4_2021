package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import errores.argumentosInvalidos;
import modelo.RedSocial;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CompartidoValido extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registerInvalid frame = new registerInvalid();
					frame.setVisible(true);
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
	 * Create the frame.
	 * @return 
	 */
	public CompartidoValido(RedSocial red, String Nombre,Integer idPost,ArrayList<String> usuariosCom,Integer cantidadUsuarios) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\luisg\\OneDrive\\Im\u00E1genes\\palomaVerdebien.png"));
		lblNewLabel.setBounds(0, 48, 60, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Publicaci\u00F3n Ingresada Correctamente");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(77, 48, 349, 60);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ACEPTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						red.setAutor(Nombre);
						red.share(idPost, usuariosCom, cantidadUsuarios);
					} catch (argumentosInvalidos e1) {
						JOptionPane.showMessageDialog(getContentPane(),e1.getMessage() ,"Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
					dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(157, 149, 114, 26);
		contentPane.add(btnNewButton);
	}

}
