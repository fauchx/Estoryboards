package interlentisimo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.FlowLayout;

public class regitroUser {

	private JFrame frmRegistro;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					regitroUser window = new regitroUser();
					window.frmRegistro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public regitroUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistro = new JFrame();
		frmRegistro.setTitle("Registro");
		frmRegistro.setResizable(false);
		frmRegistro.setBounds(0, 0, 800, 600);
		frmRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistro.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(249, 52, 296, 34);
		frmRegistro.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Registro de empleados");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(220, 137, 354, 374);
		frmRegistro.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(31, 55, 60, 17);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(169, 19, 153, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombres :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(31, 20, 64, 17);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("No de Identificaci\u00F3n :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(31, 91, 128, 17);
		panel_1.add(lblNewLabel_1_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(169, 55, 153, 20);
		panel_1.add(textField_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(169, 91, 153, 20);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Direcci\u00F3n :");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(31, 127, 65, 17);
		panel_1.add(lblNewLabel_1_2_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(169, 127, 153, 20);
		panel_1.add(textField_2);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tel\u00E9fono :");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(31, 163, 64, 17);
		panel_1.add(lblNewLabel_1_2_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(169, 163, 153, 20);
		panel_1.add(textField_4);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Email :");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1_1.setBounds(31, 199, 45, 17);
		panel_1.add(lblNewLabel_1_2_1_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(169, 199, 153, 20);
		panel_1.add(textField_5);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Cargo :");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1_1_1.setBounds(31, 236, 51, 17);
		panel_1.add(lblNewLabel_1_2_1_1_1_1);
		
		JComboBox<String> tipoCargo = new JComboBox<String>();
		tipoCargo.setBounds(169, 235, 153, 22);
		tipoCargo.addItem("");
		tipoCargo.addItem("Secretaria");
		tipoCargo.addItem("Operador de oficina");
		tipoCargo.addItem("Contador");
		tipoCargo.addItem("Gerente");
		tipoCargo.addItem("Auxiliar de operación");
		panel_1.add(tipoCargo);
		
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(169, 273, 153, 20);
		panel_1.add(textField_6);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Contrase\u00F1a :");
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_2.setBounds(31, 273, 79, 17);
		panel_1.add(lblNewLabel_1_2_1_2);
		
		JButton btnNewButton = new JButton("REGISTRAR");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setBounds(122, 340, 114, 23);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(584, 444, 174, 52);
		frmRegistro.getContentPane().add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_2 = new JLabel("\u2714 Registro Efectivo \u2714");
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(0, 128, 0));
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		JLabel lblNewLabel_2_1 = new JLabel("\u2718 Error en el registro \u2718");
		panel_2.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_2_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		JButton btnNewButton_1_1 = new JButton("VOLVER");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(53, 469, 95, 36);
		frmRegistro.getContentPane().add(btnNewButton_1_1);
	}
}
