package interlentisimo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;

public class employess_list {

	private JFrame frame;
	private JTextField txtMoreno;
	private JTextField txtBrian;
	private JTextField txtSecretaria;
	private JTextField textField_3;
	private JTextField txtNombredundermifflincom;
	private JTextField txtCll;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField textField_10;
	private JTextField txtNombredundermifflincom_1;
	private JTextField textField_12;
	private JTextField txtGerente;
	private JTextField txtNombre_1;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField txtOperadorDeOficina;
	private JTextField txtNombredundermifflincom_2;
	private JTextField textField_19;
	private JTextField txtApellido_1;
	private JTextField txtApellido_2;
	private JTextField textField_22;
	private JTextField txtNombre_2;
	private JTextField textField_24;
	private JTextField txtNombredundermifflincom_3;
	private JTextField txtContador;
	private JTextField txtApellido_3;
	private JTextField textField;
	private JTextField txtNombre_3;
	private JTextField textField_2;
	private JTextField textField_8;
	private JTextField txtNombredundermifflincom_4;
	private JTextField txtAuxiliarDeOperacin;
	private JTextField textField_14;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employess_list window = new employess_list();
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
	public employess_list() {
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

		
		JButton btnNewButton = new JButton("VOLVER");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(38, 461, 95, 36);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Informaci\u00F3n de los usuarios");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel.setBounds(21, 27, 250, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 97, 753, 346);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(6, 7, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Nombres");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_7 = new JLabel("Apellidos");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBackground(Color.WHITE);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_11 = new JLabel("Identificaci\u00F3n");
		lblNewLabel_11.setBackground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_1 = new JLabel("Direcci\u00F3n");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Cargo");
		lblNewLabel_5.setBackground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3 = new JLabel("Tel\u00E9fono");
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblNewLabel_3);
		
		txtBrian = new JTextField();
		txtBrian.setText("nombre_1");
		panel.add(txtBrian);
		txtBrian.setColumns(10);
		
		txtMoreno = new JTextField();
		txtMoreno.setText("apellido_1");
		panel.add(txtMoreno);
		txtMoreno.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setText("10000000");
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		txtCll = new JTextField();
		panel.add(txtCll);
		txtCll.setColumns(10);
		
		txtNombredundermifflincom = new JTextField();
		txtNombredundermifflincom.setText("nombre_1@dundermifflin.com");
		panel.add(txtNombredundermifflincom);
		txtNombredundermifflincom.setColumns(10);
		
		txtSecretaria = new JTextField();
		txtSecretaria.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtSecretaria.setText("Secretaria");
		panel.add(txtSecretaria);
		txtSecretaria.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setText("300000000");
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setText("nombre_2");
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setText("apellido_2");
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setText("10000001");
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		textField_10 = new JTextField();
		panel.add(textField_10);
		textField_10.setColumns(10);
		
		txtNombredundermifflincom_1 = new JTextField();
		txtNombredundermifflincom_1.setText("nombre_2@dundermifflin.com");
		panel.add(txtNombredundermifflincom_1);
		txtNombredundermifflincom_1.setColumns(10);
		
		txtGerente = new JTextField();
		txtGerente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtGerente.setText("Gerente");
		panel.add(txtGerente);
		txtGerente.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setText("300000001");
		panel.add(textField_12);
		textField_12.setColumns(10);
		
		txtNombre_1 = new JTextField();
		txtNombre_1.setText("nombre_3");
		panel.add(txtNombre_1);
		txtNombre_1.setColumns(10);
		
		txtApellido_1 = new JTextField();
		txtApellido_1.setText("apellido_3");
		panel.add(txtApellido_1);
		txtApellido_1.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setText("10000002");
		panel.add(textField_15);
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		panel.add(textField_16);
		textField_16.setColumns(10);
		
		txtNombredundermifflincom_2 = new JTextField();
		txtNombredundermifflincom_2.setText("nombre_3@dundermifflin.com");
		panel.add(txtNombredundermifflincom_2);
		txtNombredundermifflincom_2.setColumns(10);
		
		txtOperadorDeOficina = new JTextField();
		txtOperadorDeOficina.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtOperadorDeOficina.setText("Operador de oficina");
		panel.add(txtOperadorDeOficina);
		txtOperadorDeOficina.setColumns(10);
		
		textField_19 = new JTextField();
		textField_19.setText("300000002");
		panel.add(textField_19);
		textField_19.setColumns(10);
		
		txtNombre_2 = new JTextField();
		txtNombre_2.setText("nombre_4");
		panel.add(txtNombre_2);
		txtNombre_2.setColumns(10);
		
		txtApellido_2 = new JTextField();
		txtApellido_2.setText("apellido_4");
		panel.add(txtApellido_2);
		txtApellido_2.setColumns(10);
		
		textField_22 = new JTextField();
		textField_22.setText("10000003");
		textField_22.setToolTipText("");
		panel.add(textField_22);
		textField_22.setColumns(10);
		
		textField_24 = new JTextField();
		panel.add(textField_24);
		textField_24.setColumns(10);
		
		txtNombredundermifflincom_3 = new JTextField();
		txtNombredundermifflincom_3.setText("nombre_4@dundermifflin.com");
		panel.add(txtNombredundermifflincom_3);
		txtNombredundermifflincom_3.setColumns(10);
		
		txtContador = new JTextField();
		txtContador.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtContador.setText("Contador");
		panel.add(txtContador);
		txtContador.setColumns(10);
		
		textField = new JTextField();
		textField.setText("300000003");
		panel.add(textField);
		textField.setColumns(10);
		
		txtNombre_3 = new JTextField();
		txtNombre_3.setText("nombre_5");
		panel.add(txtNombre_3);
		txtNombre_3.setColumns(10);
		
		txtApellido_3 = new JTextField();
		txtApellido_3.setText("apellido_5");
		panel.add(txtApellido_3);
		txtApellido_3.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText("10000004");
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_8 = new JTextField();
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		txtNombredundermifflincom_4 = new JTextField();
		txtNombredundermifflincom_4.setText("nombre_5@dundermifflin.com");
		panel.add(txtNombredundermifflincom_4);
		txtNombredundermifflincom_4.setColumns(10);
		
		txtAuxiliarDeOperacin = new JTextField();
		txtAuxiliarDeOperacin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtAuxiliarDeOperacin.setText("Auxiliar de operaci\u00F3n");
		panel.add(txtAuxiliarDeOperacin);
		txtAuxiliarDeOperacin.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setText("300000004");
		panel.add(textField_14);
		textField_14.setColumns(10);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(21, 52, 753, 14);
		frame.getContentPane().add(horizontalStrut);
	}
}
