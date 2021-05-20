package interlentisimo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class menu {

	 JFrame frame;
	 JButton magEmpBtn, sedesBtn, paqueteBtn, informeBtn;
	 sedesMenu sedem;
	 usersMenu userm;
<<<<<<< HEAD
	 login logeo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu window = new menu();
					window.frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
=======
>>>>>>> ab610eda804e9950bacd1638ff4cc8d4ee7c94a3

	/**
	 * Create the application.
	 */
	public menu(String idUser) {
		initialize(idUser);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String idUser) {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(282, 89, 220, 44);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Men\u00FA principal");
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 69, 0));
		panel_1.setBounds(167, 178, 450, 280);
		frame.getContentPane().add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{50,50};
		gbl_panel_1.rowHeights = new int[]{50,50};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0};
		panel_1.setLayout(gbl_panel_1);
		
<<<<<<< HEAD
		JButton magEmpBtn = new JButton("");
		magEmpBtn.setIcon(new ImageIcon(menu.class.getResource("/icons/userBTN.png")));
		magEmpBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_magEmpBtn = new GridBagConstraints();
=======
		magEmpBtn = new JButton("");
>>>>>>> ab610eda804e9950bacd1638ff4cc8d4ee7c94a3
		magEmpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				usersMenu userm = new usersMenu();
				userm.frame.setVisible(true);
				userm.frame.setLocationRelativeTo(null);
			}
		});
<<<<<<< HEAD
		gbc_magEmpBtn.insets = new Insets(5, 5, 5, 5);
=======
		magEmpBtn.setIcon(new ImageIcon(menu.class.getResource("/icons/userBTN.png")));
		magEmpBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		magEmpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); 
				usersMenu userm = new usersMenu(idUser);
				userm.frame.setLocationRelativeTo(frame);
				userm.frame.setVisible(true);
			}
		});
		GridBagConstraints gbc_magEmpBtn = new GridBagConstraints();
		gbc_magEmpBtn.insets = new Insets(5, 5, 5, 5);//Espacio de separacion entre el objeto
>>>>>>> ab610eda804e9950bacd1638ff4cc8d4ee7c94a3
		gbc_magEmpBtn.fill = GridBagConstraints.BOTH;
		gbc_magEmpBtn.gridx = 0;
		gbc_magEmpBtn.gridy = 0;
		panel_1.add(magEmpBtn, gbc_magEmpBtn);
		
		sedesBtn = new JButton("");
		sedesBtn.setIcon(new ImageIcon(menu.class.getResource("/icons/sedeBTN.png")));
		sedesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); 
<<<<<<< HEAD
				sedesMenu sedem = new sedesMenu();
				sedem.frmSedes.setVisible(true);
				sedem.frmSedes.setLocationRelativeTo(null);
=======
				sedesMenu sedem = new sedesMenu(idUser);
				sedem.frame.setLocationRelativeTo(frame);
				sedem.frame.setVisible(true);
>>>>>>> ab610eda804e9950bacd1638ff4cc8d4ee7c94a3
			}
		});
		GridBagConstraints gbc_sedesBtn = new GridBagConstraints();
		gbc_sedesBtn.insets = new Insets(5, 0, 5, 5);
		gbc_sedesBtn.fill = GridBagConstraints.BOTH;
		gbc_sedesBtn.gridx = 1;
		gbc_sedesBtn.gridy = 0;
		panel_1.add(sedesBtn, gbc_sedesBtn);
		
		paqueteBtn = new JButton("");
		paqueteBtn.setIcon(new ImageIcon(menu.class.getResource("/icons/packageBTN.png")));
		paqueteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); 
				registroPaquete pkg = new registroPaquete(idUser);
				pkg.frame.setLocationRelativeTo(frame);
				pkg.frame.setVisible(true);
			}
		});
		
		GridBagConstraints gbc_paqueteBtn = new GridBagConstraints();
		gbc_paqueteBtn.insets = new Insets(0, 5, 5, 5);
		gbc_paqueteBtn.fill = GridBagConstraints.BOTH;
		gbc_paqueteBtn.gridx = 0;
		gbc_paqueteBtn.gridy = 1;
		panel_1.add(paqueteBtn, gbc_paqueteBtn);
		
		informeBtn = new JButton("");
		informeBtn.setIcon(new ImageIcon(menu.class.getResource("/icons/infoBTN.png")));
		informeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//activar menu de informes
			}
		});
		GridBagConstraints gbc_informeBtn = new GridBagConstraints();
		gbc_informeBtn.insets = new Insets(0, 0, 5, 5);
		gbc_informeBtn.fill = GridBagConstraints.BOTH;
		gbc_informeBtn.gridx = 1;
		gbc_informeBtn.gridy = 1;
		panel_1.add(informeBtn, gbc_informeBtn);
		
		
		JButton logoutBtn = new JButton("Cerrar sesi\u00F3n");
		logoutBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		logoutBtn.setBounds(640, 11, 120, 36);
		frame.getContentPane().add(logoutBtn);
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
<<<<<<< HEAD
				login logeo = new login();
				logeo.frame.setVisible(true);
				logeo.frame.setLocationRelativeTo(null);
=======
				login log = new login();
				log.frame.setLocationRelativeTo(frame);
				log.frame.setVisible(true);
				
>>>>>>> ab610eda804e9950bacd1638ff4cc8d4ee7c94a3
			}
		});
	}
	
	public void configMenu(String cargoUser, JFrame frame) {
		switch(cargoUser) 
		{
			case "Gerente":
				this.paqueteBtn.setEnabled(false);
				break;
			case "Secretaria":
				this.paqueteBtn.setEnabled(false);
				break;
			case "OperadorOficina":
				this.informeBtn.setEnabled(false);
				this.sedesBtn.setEnabled(false);
				this.magEmpBtn.setEnabled(false);
				break;
			case "Contador":
				this.sedesBtn.setEnabled(false);
				this.magEmpBtn.setEnabled(false);
				this.paqueteBtn.setEnabled(false);
				break;
			case "AuxOperacion":
				this.sedesBtn.setEnabled(false);
				this.magEmpBtn.setEnabled(false);
				this.paqueteBtn.setEnabled(false);
				this.informeBtn.setEnabled(false);
				break;
		}
		this.frame.setLocationRelativeTo(frame);
		this.frame.setVisible(true);
	}
}

