package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import modelo.RedSocial;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RedSocialView {

	JFrame frame;
	private RedSocial red = new RedSocial();
	private String name;
	private JTable table;
	private JTable table_1;
	private PublicacionView publi = new PublicacionView();
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RedSocial red2 = new RedSocial();
					String name2 = null;
					RedSocialView window = new RedSocialView(red2,name2);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RedSocialView(RedSocial red,String name) {
		this.red = red;
		this.name = name;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 567, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario: ");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 6, 65, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(name);
		lblNewLabel_1.setBounds(74, 6, 96, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel Publicaciones = new JLabel("Publicaciones:");
		Publicaciones.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Publicaciones.setBounds(10, 40, 128, 24);
		frame.getContentPane().add(Publicaciones);
		
		table = new JTable();
		table.setBounds(10, 99, 533, 88);
		frame.getContentPane().add(table);
		
		JLabel Reacciones = new JLabel("Reacciones:");
		Reacciones.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Reacciones.setBounds(10, 197, 128, 24);
		frame.getContentPane().add(Reacciones);
		
		table_1 = new JTable();
		table_1.setBounds(10, 239, 533, 82);
		frame.getContentPane().add(table_1);
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFrame().dispose();
			}

		});
		Volver.setBounds(10, 358, 85, 21);
		frame.getContentPane().add(Volver);
		
		JButton Seguir = new JButton("Seguir");
		Seguir.setBounds(169, 358, 85, 21);
		frame.getContentPane().add(Seguir);
		
		JButton Compartir = new JButton("Compartir");
		Compartir.setBounds(295, 358, 85, 21);
		frame.getContentPane().add(Compartir);
		
		JButton Publicar = new JButton("Publicar");
		Publicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				publi.getFrame().setVisible(true);
			}
		});
		Publicar.setBounds(435, 358, 85, 21);
		frame.getContentPane().add(Publicar);
	}
}
