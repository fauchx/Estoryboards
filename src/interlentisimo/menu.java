package interlentisimo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class menu {

	private JFrame menuFrm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu window = new menu();
					window.menuFrm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		menuFrm = new JFrame();
		menuFrm.setBounds(100, 100, 800, 600);
		menuFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrm.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(282, 89, 220, 44);
		menuFrm.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Men\u00FA principal");
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 69, 0));
		panel_1.setBounds(167, 178, 450, 280);
		menuFrm.getContentPane().add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{50,50};
		gbl_panel_1.rowHeights = new int[]{50,50};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0};
		panel_1.setLayout(gbl_panel_1);
		
		JButton magEmployesBtn = new JButton("");
		magEmployesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regitroUser gestionEmpleadosFrm = new regitroUser(menuFrm);
				menuFrm.setVisible(false);
				
			}
		});
		magEmployesBtn.setIcon(new ImageIcon(menu.class.getResource("/icons/userBTN.png")));
		magEmployesBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_magEmployesBtn = new GridBagConstraints();
		gbc_magEmployesBtn.insets = new Insets(5, 5, 5, 5);//Espacio de separacion entre el objeto
		gbc_magEmployesBtn.fill = GridBagConstraints.BOTH;
		gbc_magEmployesBtn.gridx = 0;
		gbc_magEmployesBtn.gridy = 0;
		panel_1.add(magEmployesBtn, gbc_magEmployesBtn);
		
		JButton magSedesBtn = new JButton("");
		magSedesBtn.setIcon(new ImageIcon(menu.class.getResource("/icons/sedeBTN.png")));
		magSedesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_magSedesBtn = new GridBagConstraints();
		gbc_magSedesBtn.insets = new Insets(5, 0, 5, 5);
		gbc_magSedesBtn.fill = GridBagConstraints.BOTH;
		gbc_magSedesBtn.gridx = 1;
		gbc_magSedesBtn.gridy = 0;
		panel_1.add(magSedesBtn, gbc_magSedesBtn);
		
		JButton regPaqueteBtn = new JButton("");
		regPaqueteBtn.setIcon(new ImageIcon(menu.class.getResource("/icons/packageBTN.png")));
		regPaqueteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_regPaqueteBtn = new GridBagConstraints();
		gbc_regPaqueteBtn.insets = new Insets(0, 5, 5, 5);
		gbc_regPaqueteBtn.fill = GridBagConstraints.BOTH;
		gbc_regPaqueteBtn.gridx = 0;
		gbc_regPaqueteBtn.gridy = 1;
		panel_1.add(regPaqueteBtn, gbc_regPaqueteBtn);
		
		JButton informesBtn = new JButton("");
		informesBtn.setIcon(new ImageIcon(menu.class.getResource("/icons/infoBTN.png")));
		GridBagConstraints gbc_informesBtn = new GridBagConstraints();
		gbc_informesBtn.insets = new Insets(0, 0, 5, 5);
		gbc_informesBtn.fill = GridBagConstraints.BOTH;
		gbc_informesBtn.gridx = 1;
		gbc_informesBtn.gridy = 1;
		panel_1.add(informesBtn, gbc_informesBtn);
		
		JButton logoutBtn = new JButton("Cerrar sesi\u00F3n");
		logoutBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		logoutBtn.setBounds(640, 11, 120, 36);
		menuFrm.getContentPane().add(logoutBtn);
	}
}

