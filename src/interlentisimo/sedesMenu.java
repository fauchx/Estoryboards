package interlentisimo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class sedesMenu {

<<<<<<< HEAD
	 JFrame frmSedes;
	 menu menu;
=======
	 JFrame frame;

>>>>>>> ab610eda804e9950bacd1638ff4cc8d4ee7c94a3
	/**
	 * Launch the application.
	 */
	 /*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sedesMenu window = new sedesMenu();
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
	public sedesMenu(String idUser) {
		initialize(idUser);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String idUser) {
		frame = new JFrame();
		frame.setTitle("Sedes");
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.setBounds(100, 100, 800, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("VOLVER");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
				frmSedes.setVisible(false);
				menu menu = new menu();
				menu.frame.setVisible(true);
				menu.frame.setLocationRelativeTo(null);
=======
				frame.setVisible(false);
				menu menuf = new menu(idUser);
				menuf.configMenu(idUser, frame);
>>>>>>> ab610eda804e9950bacd1638ff4cc8d4ee7c94a3
			}
		});
		btnNewButton_1.setBounds(48, 481, 95, 36);
		frame.getContentPane().add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(149, 103, 496, 301);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(117, 5, 261, 49);
		panel_2.add(panel);
		
		JLabel lblNewLabel = new JLabel("Gesti\u00F3n de Sedes");
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(39, 89, 417, 201);
		panel_2.add(panel_1);
		panel_1.setBackground(SystemColor.menu);
		panel_1.setLayout(null);
		
		JButton btnAcUsuario = new JButton("Actualizar Sede");
		btnAcUsuario.setBackground(new Color(255, 69, 0));
		btnAcUsuario.setForeground(new Color(255, 255, 255));
		btnAcUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAcUsuario.setBounds(213, 11, 193, 75);
		panel_1.add(btnAcUsuario);
		
		JButton btnConsultarUsuarios = new JButton("Consultar Sedes");
		btnConsultarUsuarios.setForeground(new Color(255, 255, 255));
		btnConsultarUsuarios.setBackground(new Color(255, 69, 0));
		btnConsultarUsuarios.setBounds(10, 11, 193, 75);
		panel_1.add(btnConsultarUsuarios);
		btnConsultarUsuarios.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnNewButton = new JButton("Crear Sede");
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(129, 97, 158, 75);
		panel_1.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); 
				registroSede pkg = new registroSede(idUser);
				pkg.frmRegistroSedes.setLocationRelativeTo(frame);
				pkg.frmRegistroSedes.setVisible(true);
			}
		});
	}
}
