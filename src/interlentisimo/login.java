package interlentisimo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

public class login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(219, 114, 345, 333);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(77, 5, 191, 48);
		panel_2.add(panel);
		
		JLabel lblNewLabel = new JLabel("Acceso al sistema");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 115, 312, 103);
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(156, 24, 135, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(156, 55, 135, 20);
		panel_1.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("No de Identificaci\u00F3n :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(11, 24, 135, 19);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contrase\u00F1a :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(11, 55, 135, 19);
		panel_1.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("INGRESAR");
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(121, 283, 102, 23);
		panel_2.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}
}
