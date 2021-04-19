package windowexample;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Pago_Credito {

	private JFrame frmPagoConTarjeta;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pago_Credito window = new Pago_Credito();
					window.frmPagoConTarjeta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pago_Credito() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPagoConTarjeta = new JFrame();
		frmPagoConTarjeta.setTitle("Pago con tarjeta\r\n");
		frmPagoConTarjeta.setBounds(100, 100, 600, 400);
		frmPagoConTarjeta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPagoConTarjeta.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PAGO CON TARJETA\r\n");
		lblNewLabel.setForeground(new Color(255,69,0));
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel.setBounds(215, 11, 157, 27);
		frmPagoConTarjeta.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero de tarjeta:\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(40, 90, 134, 14);
		frmPagoConTarjeta.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(184, 87, 200, 20);
		frmPagoConTarjeta.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre y apellido:\r\n");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(40, 154, 134, 14);
		frmPagoConTarjeta.getContentPane().add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(184, 152, 232, 20);
		frmPagoConTarjeta.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Fecha expiracion:\r\n");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(40, 227, 134, 14);
		frmPagoConTarjeta.getContentPane().add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(184, 225, 86, 20);
		frmPagoConTarjeta.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Codigo seguridad\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(305, 228, 111, 17);
		frmPagoConTarjeta.getContentPane().add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(426, 225, 86, 20);
		frmPagoConTarjeta.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo documento\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(39, 291, 111, 14);
		frmPagoConTarjeta.getContentPane().add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "C.C", "T.I", "C.E"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(184, 288, 86, 22);
		frmPagoConTarjeta.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Numero\r\n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(305, 292, 79, 14);
		frmPagoConTarjeta.getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(394, 289, 118, 20);
		frmPagoConTarjeta.getContentPane().add(textField_4);
		textField_4.setColumns(10);
	}
}
