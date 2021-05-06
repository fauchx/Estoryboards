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
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class menu {

	JFrame frame;
	private login log;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu window = new menu();
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
	public menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		
		JButton magEmpBtn = new JButton("");
		magEmpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		magEmpBtn.setIcon(new ImageIcon(menu.class.getResource("/icons/userBTN.png")));
		magEmpBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_magEmpBtn = new GridBagConstraints();
		//magEmpBtn.setPreferredSize(new Dimension(200,100));
		gbc_magEmpBtn.insets = new Insets(5, 5, 5, 5);//Espacio de separacion entre el objeto
		gbc_magEmpBtn.fill = GridBagConstraints.BOTH;
		gbc_magEmpBtn.gridx = 0;
		gbc_magEmpBtn.gridy = 0;
		panel_1.add(magEmpBtn, gbc_magEmpBtn);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(menu.class.getResource("/icons/sedeBTN.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(5, 0, 5, 5);
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 0;
		panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(menu.class.getResource("/icons/packageBTN.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 5, 5, 5);
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 1;
		panel_1.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(menu.class.getResource("/icons/infoBTN.png")));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 1;
		panel_1.add(btnNewButton_3, gbc_btnNewButton_3);
		
		login log = new login();
		JButton btnNewButton_1_1 = new JButton("Cerrar sesi\u00F3n");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(640, 11, 120, 36);
		frame.getContentPane().add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				log.frame.setVisible(true);
			}
		});
	}
}

