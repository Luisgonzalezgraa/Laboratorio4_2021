package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import modelo.RedSocial;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RedSocialView {

	JFrame frame;
	private RedSocial red;
	private String name;
	private JTable table;
	private JTable table_1;
	
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
		
		DefaultTableModel tipoM = new DefaultTableModel();
		tipoM.addColumn("ID");
		tipoM.addColumn("CONTENIDO");
		tipoM.addColumn("TIPO");
		tipoM.addColumn("AUTOR");
		tipoM.addColumn("FECHA");
		tipoM.addColumn("USUARIOS");
	
		for(int i = 0; i< red.getListapublicaciones().size(); i++) {
			for(int j = 0; j< red.getListapublicaciones().get(i).size(); j++) {
			String[] Panel = {String.valueOf(red.getListapublicaciones().get(i).get(j).getIdPost()),
					red.getListapublicaciones().get(i).get(j).getContent(),
					String.valueOf(red.getListapublicaciones().get(i).get(j).getTypePost()),
					String.valueOf(red.getListapublicaciones().get(i).get(j).getNamePublisher()),
					String.valueOf(red.getListapublicaciones().get(i).get(j).getDatePost()),
					String.valueOf(red.getListapublicaciones().get(i).get(j).getUsers()),
			};
			tipoM.addRow(Panel);
			}	
		}
		table = new JTable(tipoM);
		table.setBounds(10, 99, 533, 88);
		frame.getContentPane().add(table);
		
		JLabel Reacciones = new JLabel("Reacciones:");
		Reacciones.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Reacciones.setBounds(10, 197, 128, 24);
		frame.getContentPane().add(Reacciones);
		
		
		DefaultTableModel tipoM2 = new DefaultTableModel();
		tipoM2.addColumn("ID");
		tipoM2.addColumn("AUTOR");
		tipoM2.addColumn("FECHA");
		tipoM2.addColumn("CONTENIDO");
		tipoM2.addColumn("TIPO");
		
	
		for(int i = 0; i< red.getListareacciones().size(); i++) {
			for(int j = 0; j< red.getListareacciones().get(i).size(); j++) {
			String[] Panel = {String.valueOf(red.getListareacciones().get(i).get(j).getIdReac()),
					red.getListareacciones().get(i).get(j).getNameUser(),
					String.valueOf(red.getListareacciones().get(i).get(j).getDateReac()),
					String.valueOf(red.getListareacciones().get(i).get(j).getContentReac()),
					String.valueOf(red.getListareacciones().get(i).get(j).getTypeReac()),
				
			};
			tipoM2.addRow(Panel);
			}	
		}
		table_1 = new JTable(tipoM2);
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
		Seguir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FollowView follow = new FollowView(red,name);
				follow.getFrame().setVisible(true);
			}
		});
		Seguir.setBounds(169, 358, 85, 21);
		frame.getContentPane().add(Seguir);
		
		JButton Compartir = new JButton("Compartir");
		Compartir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShareView share = new ShareView(red,name);
				share.getFrame().setVisible(true);
			}
		});
		Compartir.setBounds(295, 358, 85, 21);
		frame.getContentPane().add(Compartir);
		
		JButton Publicar = new JButton("Publicar");
		Publicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PublicacionView publi = new PublicacionView(red,name);
				publi.getFrame().setVisible(true);
			}
		});
		Publicar.setBounds(435, 358, 85, 21);
		frame.getContentPane().add(Publicar);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setBounds(10, 76, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CONTENIDO");
		lblNewLabel_3.setBounds(118, 74, 79, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("TIPO");
		lblNewLabel_4.setBounds(219, 76, 45, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("AUTOR");
		lblNewLabel_5.setBounds(288, 76, 45, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("FECHA");
		lblNewLabel_6.setBounds(369, 76, 45, 13);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("USUARIOS DIRIGIDOS");
		lblNewLabel_7.setBounds(424, 76, 108, 13);
		frame.getContentPane().add(lblNewLabel_7);
	}
}
