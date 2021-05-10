package interlentisimo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

public class login {

	JFrame frame;
	private JTextField txtusuariologin;
	private JPasswordField txtcontralogin;
	private ControlBase control;
	menu menu;

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
		
		txtusuariologin = new JTextField();
		txtusuariologin.setBounds(156, 24, 135, 20);
		panel_1.add(txtusuariologin);
		txtusuariologin.setColumns(10);
		
		txtcontralogin = new JPasswordField();
		txtcontralogin.setBounds(156, 55, 135, 20);
		panel_1.add(txtcontralogin);
		
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
		ControlBase control = new ControlBase();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(control.buscarusuario(txtusuariologin.getText(), txtcontralogin.getText())) {
						
						String cargoUser = control.getCargo(txtusuariologin.getText().toString());
						System.out.println(cargoUser);
						
						frame.setVisible(false);
						menu menu= new menu();
						menu.frame.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "NO SE PUDO INICIAR SESION");
						/*setear campos en vacios al final */
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
}
