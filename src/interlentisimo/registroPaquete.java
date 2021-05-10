package interlentisimo;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JRadioButton;

public class registroPaquete {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField txtPeso;
	private JTextField textField_6;
	private JTextField textField_12;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registroPaquete window = new registroPaquete();
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
	public registroPaquete(String idUser) {
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
		
		JPanel panel = new JPanel();
		panel.setBounds(253, 11, 278, 34);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Registro de env\u00EDo de paquetes");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		panel.add(lblNewLabel);
		
		JPanel infoRemitente = new JPanel();
		infoRemitente.setBorder(new LineBorder(new Color(0, 0, 0)));
		infoRemitente.setBounds(30, 70, 354, 248);
		frame.getContentPane().add(infoRemitente);
		infoRemitente.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(31, 94, 60, 17);
		infoRemitente.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(169, 58, 153, 20);
		infoRemitente.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombres :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(31, 59, 64, 17);
		infoRemitente.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("No de Identificaci\u00F3n :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(31, 130, 128, 17);
		infoRemitente.add(lblNewLabel_1_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(169, 94, 153, 20);
		infoRemitente.add(textField_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(169, 130, 153, 20);
		infoRemitente.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(169, 166, 153, 20);
		infoRemitente.add(textField_2);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tel\u00E9fono :");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(31, 202, 64, 17);
		infoRemitente.add(lblNewLabel_1_2_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(169, 202, 153, 20);
		infoRemitente.add(textField_4);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Email :");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1_1.setBounds(31, 166, 45, 17);
		infoRemitente.add(lblNewLabel_1_2_1_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Informaci\u00F3n Remitente");
		lblNewLabel_1_1_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(97, 11, 160, 25);
		infoRemitente.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("CONTINUAR");
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(335, 505, 114, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel infoDestinatario = new JPanel();
		infoDestinatario.setLayout(null);
		infoDestinatario.setBorder(new LineBorder(new Color(0, 0, 0)));
		infoDestinatario.setBounds(401, 70, 354, 248);
		frame.getContentPane().add(infoDestinatario);
		
		JLabel lblNewLabel_1_3 = new JLabel("Apellidos :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(31, 94, 60, 17);
		infoDestinatario.add(lblNewLabel_1_3);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(169, 58, 153, 20);
		infoDestinatario.add(textField_7);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Nombres :");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(31, 59, 64, 17);
		infoDestinatario.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("No de Identificaci\u00F3n :");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_2.setBounds(31, 130, 128, 17);
		infoDestinatario.add(lblNewLabel_1_2_2);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(169, 94, 153, 20);
		infoDestinatario.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(169, 130, 153, 20);
		infoDestinatario.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(169, 166, 153, 20);
		infoDestinatario.add(textField_10);
		
		JLabel lblNewLabel_1_2_1_1_2 = new JLabel("Tel\u00E9fono :");
		lblNewLabel_1_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1_2.setBounds(31, 202, 64, 17);
		infoDestinatario.add(lblNewLabel_1_2_1_1_2);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(169, 202, 153, 20);
		infoDestinatario.add(textField_11);
		
		JLabel lblNewLabel_1_2_1_1_1_2 = new JLabel("Email :");
		lblNewLabel_1_2_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1_1_2.setBounds(31, 166, 45, 17);
		infoDestinatario.add(lblNewLabel_1_2_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Informaci\u00F3n Destinatario");
		lblNewLabel_1_1_1_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(90, 11, 173, 25);
		infoDestinatario.add(lblNewLabel_1_1_1_1);
		
		JPanel infoDestinatario_1 = new JPanel();
		infoDestinatario_1.setBounds(30, 329, 725, 153);
		frame.getContentPane().add(infoDestinatario_1);
		infoDestinatario_1.setLayout(null);
		infoDestinatario_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(182, 47, 143, 20);
		infoDestinatario_1.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(499, 111, 143, 20);
		infoDestinatario_1.add(textField_14);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Informaci\u00F3n del env\u00EDo");
		lblNewLabel_1_1_1_1_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1.setBounds(282, 11, 160, 25);
		infoDestinatario_1.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Peso :");
		lblNewLabel_1_2_1_1_1_1.setBounds(38, 47, 51, 17);
		infoDestinatario_1.add(lblNewLabel_1_2_1_1_1_1);
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Direcci\u00F3n destino :");
		lblNewLabel_1_2_1.setBounds(363, 111, 113, 17);
		infoDestinatario_1.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Ciudad de origen :");
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_2.setBounds(365, 50, 124, 17);
		infoDestinatario_1.add(lblNewLabel_1_2_1_2);
		
		JLabel lblNewLabel_1_2_1_3 = new JLabel("Ciudad de destino :");
		lblNewLabel_1_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_3.setBounds(365, 81, 124, 17);
		infoDestinatario_1.add(lblNewLabel_1_2_1_3);
		
		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPeso.setBounds(499, 47, 143, 20);
		infoDestinatario_1.add(txtPeso);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(499, 78, 143, 20);
		infoDestinatario_1.add(textField_6);
		
		JLabel lblNewLabel_1_2_1_4 = new JLabel("Recolecci\u00F3n :");
		lblNewLabel_1_2_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_4.setBounds(38, 81, 113, 17);
		infoDestinatario_1.add(lblNewLabel_1_2_1_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("S\u00ED");
		rdbtnNewRadioButton.setBounds(182, 80, 51, 23);
		infoDestinatario_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(240, 80, 45, 23);
		infoDestinatario_1.add(rdbtnNo);
		
		JLabel lblNewLabel_1_2_1_5 = new JLabel("Direcci\u00F3n recolecci\u00F3n :");
		lblNewLabel_1_2_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_5.setBounds(38, 111, 137, 17);
		infoDestinatario_1.add(lblNewLabel_1_2_1_5);
		
		textField_12 = new JTextField();
		textField_12.setEnabled(false);
		textField_12.setColumns(10);
		textField_12.setBounds(182, 111, 143, 20);
		infoDestinatario_1.add(textField_12);
		
		JButton volverBtn = new JButton("VOLVER");
		volverBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		volverBtn.setBounds(30, 493, 95, 36);
		volverBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e){
				frame.setVisible(false);
				menu menuf = new menu(idUser);
				menuf.configMenu(idUser, frame);
			}
		});
		frame.getContentPane().add(volverBtn);
	}
}
