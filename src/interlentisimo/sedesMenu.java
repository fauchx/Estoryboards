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

public class sedesMenu {

	 JFrame frame;
	 JButton btnAcUsuario, btnConsultarSedes, crearSedeBtn;
	 private String cargoUser;

	/**
	 * Create the application.
	 */
	public sedesMenu(String idUser) {
		ControlBase control = new ControlBase();
		try {
			cargoUser = control.getCargo(idUser);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		initialize(idUser);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String idUser) {
		frame = new JFrame();
		frame.setTitle("Sedes");
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.setSize(800, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JButton btnNewButton_1 = new JButton("VOLVER");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				menu menuf = new menu(idUser);
				menuf.configMenu(cargoUser, frame);
				menuf.frame.setLocationRelativeTo(frame);
			}
		});
		btnNewButton_1.setBounds(48, 481, 95, 36);
		frame.getContentPane().add(btnNewButton_1);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(149, 103, 496, 301);
		mainPanel.setLayout(null);
		frame.getContentPane().add(mainPanel);

		
		JPanel panel = new JPanel();
		panel.setBounds(117, 5, 261, 49);
		mainPanel.add(panel);
		
		JLabel lblNewLabel = new JLabel("Gesti\u00F3n de Sedes");
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(39, 89, 417, 201);
		mainPanel.add(panel_1);
		panel_1.setBackground(SystemColor.menu);
		panel_1.setLayout(null);
		
		btnAcUsuario = new JButton("Actualizar Sede");
		btnAcUsuario.setBackground(new Color(255, 69, 0));
		btnAcUsuario.setForeground(new Color(255, 255, 255));
		btnAcUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAcUsuario.setBounds(213, 11, 193, 75);
		panel_1.add(btnAcUsuario);
		btnAcUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); 
				SedeInfoMod modSedeFr = new SedeInfoMod(idUser);
				modSedeFr.frame.setLocationRelativeTo(frame);
				modSedeFr.frame.setVisible(true);
			}
		});
		
		btnConsultarSedes = new JButton("Consultar Sedes");
		btnConsultarSedes.setForeground(new Color(255, 255, 255));
		btnConsultarSedes.setBackground(new Color(255, 69, 0));
		btnConsultarSedes.setBounds(10, 11, 193, 75);
		panel_1.add(btnConsultarSedes);
		btnConsultarSedes.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnConsultarSedes.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				sedesList listado = new sedesList(idUser, "sedes");
				listado.setLocationRelativeTo(frame);
				
			}
		});
		
		crearSedeBtn = new JButton("Crear Sede");
		crearSedeBtn.setBackground(new Color(255, 69, 0));
		crearSedeBtn.setForeground(new Color(255, 255, 255));
		crearSedeBtn.setBounds(129, 97, 158, 75);
		panel_1.add(crearSedeBtn);
		crearSedeBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		crearSedeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); 
				registroSede pkg = new registroSede(idUser);
				pkg.frmRegistroSedes.setLocationRelativeTo(frame);
				pkg.frmRegistroSedes.setVisible(true);
			}
		});
		
		if(cargoUser.equals("Secretaria")) 
		{
			this.crearSedeBtn.setEnabled(false);
			this.btnAcUsuario.setEnabled(false);
			
		}

	}
	
}
