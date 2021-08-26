package vista;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.awt.Component;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import errores.argumentosInvalidos;
import modelo.RedSocial;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShareView {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private RedSocial red;
	private String name;
	private JTextField usuariosAcompartir;
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FollowView window = new FollowView();
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
	public ShareView(RedSocial red, String name) {
		this.red = red;
		this.name = name;
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
		
		JLabel lblNewLabel = new JLabel("Ingrese Id ha Compartir:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 169, 215, 25);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(179, 174, 247, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
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
		table.setBounds(10, 57, 416, 102);
		frame.getContentPane().add(table);
		
		JLabel lblNewLabel_1 = new JLabel("Publicaciones:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 34, 98, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tomaID = textField.getText();
				Integer Id = Integer.valueOf(tomaID);
				String tomaUsua = usuariosAcompartir.getText();
				Integer Usua = Integer.valueOf(tomaUsua);
				red.setAutor(name);
				try {
					if(red.existeId(Id) == true) {
						new UsuariosDiriShare(red,Id,Usua,name).getFrame().setVisible(true);
					}
						
				}catch (argumentosInvalidos e1) {
					JOptionPane.showMessageDialog(getContentPane(),e1.getMessage() ,"Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}

			private Component getContentPane() {
				// TODO Auto-generated method stub
				return null;
			}

		});
		btnNewButton.setBounds(341, 232, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFrame().dispose();
			}
		});
		btnNewButton_1.setBounds(10, 232, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblIngreseCantidadDe = new JLabel("Ingrese Cantidad de Usuarios a Compartir:");
		lblIngreseCantidadDe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIngreseCantidadDe.setBounds(10, 197, 281, 25);
		frame.getContentPane().add(lblIngreseCantidadDe);
		
		usuariosAcompartir = new JTextField();
		usuariosAcompartir.setBounds(289, 202, 96, 19);
		frame.getContentPane().add(usuariosAcompartir);
		usuariosAcompartir.setColumns(10);
	}
}
