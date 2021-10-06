package interlentisimo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class usersMenu {


	public JFrame frame;
	private String cargoUser;


	/**
	 * Create the application.
	 */
	public usersMenu(String idUser) {
		initialize(idUser);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String idUser) {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.setBounds(100, 100, 800, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(213, 89, 357, 44);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Gesti\u00F3n de Empleados");
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(183, 180, 417, 201);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAcUsuario = new JButton("Actualizar Usuario");
		btnAcUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				userInfoMod registro = new userInfoMod(idUser);
				registro.frmInformacinUsuario.setVisible(true);
				registro.frmInformacinUsuario.setLocationRelativeTo(null);
			}
		});
		
		btnAcUsuario.setBackground(new Color(255, 69, 0));
		btnAcUsuario.setForeground(new Color(255, 255, 255));
		btnAcUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAcUsuario.setBounds(213, 11, 193, 75);
		panel_1.add(btnAcUsuario);
		
		JButton btnConsultarUsuarios = new JButton("Consultar Usuarios");
		btnConsultarUsuarios.setForeground(new Color(255, 255, 255));
		btnConsultarUsuarios.setBackground(new Color(255, 69, 0));
		btnConsultarUsuarios.setBounds(10, 11, 193, 75);
		panel_1.add(btnConsultarUsuarios);
		btnConsultarUsuarios.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnConsultarUsuarios.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				sedesList listado = new sedesList(idUser, "users");
				listado.setLocationRelativeTo(frame);
				
			}
		});
		
		JButton btnNewButton = new JButton("Crear Usuario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				regitroUser registro = new regitroUser(idUser);
				registro.frmRegistro.setVisible(true);
				registro.frmRegistro.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(129, 97, 158, 75);
		panel_1.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnNewButton_1 = new JButton("VOLVER");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				ControlBase control = new ControlBase();
				try {
					cargoUser = control.getCargo(idUser);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				menu menuf = new menu(idUser);
				menuf.configMenu(cargoUser, frame);
				menuf.frame.setLocationRelativeTo(frame);
				

			}
		});
		btnNewButton_1.setBounds(48, 481, 95, 36);
		frame.getContentPane().add(btnNewButton_1);
		
	}
}
