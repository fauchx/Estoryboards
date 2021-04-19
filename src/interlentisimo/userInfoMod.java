package interlentisimo;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class userInfoMod {

	private JFrame frmInformacinUsuario;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField tfIdSede;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userInfoMod window = new userInfoMod();
					window.frmInformacinUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public userInfoMod() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInformacinUsuario = new JFrame();
		frmInformacinUsuario.setTitle("Informaci\u00F3n Usuario");
		frmInformacinUsuario.setBounds(100, 100, 800, 600);
		frmInformacinUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInformacinUsuario.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(325, 52, 133, 38);
		frmInformacinUsuario.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Editar Usuario");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(215, 137, 354, 370);
		frmInformacinUsuario.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(31, 51, 60, 17);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(171, 11, 153, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombres :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(31, 11, 64, 17);
		panel_1.add(lblNewLabel_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(171, 51, 153, 20);
		panel_1.add(textField_3);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Direcci\u00F3n :");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(31, 91, 65, 17);
		panel_1.add(lblNewLabel_1_2_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(171, 91, 153, 20);
		panel_1.add(textField_2);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tel\u00E9fono :");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(31, 131, 64, 17);
		panel_1.add(lblNewLabel_1_2_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(171, 131, 153, 20);
		panel_1.add(textField_4);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Email :");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1_1.setBounds(31, 171, 45, 17);
		panel_1.add(lblNewLabel_1_2_1_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(171, 171, 153, 20);
		panel_1.add(textField_5);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Cargo :");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1_1_1.setBounds(31, 212, 51, 17);
		panel_1.add(lblNewLabel_1_2_1_1_1_1);
		
		JComboBox<String> tipoCargo = new JComboBox<String>();
		tipoCargo.setBounds(171, 211, 153, 22);
		tipoCargo.addItem("");
		tipoCargo.addItem("Secretaria");
		tipoCargo.addItem("Operador de oficina");
		tipoCargo.addItem("Contador");
		tipoCargo.addItem("Gerente");
		tipoCargo.addItem("Auxiliar de operación");
		panel_1.add(tipoCargo);
		
		JButton btnNewButton = new JButton("ACTUALIZAR");
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(120, 341, 114, 23);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		JLabel lblNewLabel_1_2 = new JLabel("Estado :");
		lblNewLabel_1_2.setBounds(31, 254, 128, 17);
		panel_1.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox<String> estadoUser = new JComboBox<String>();
		estadoUser.setBounds(171, 253, 153, 22);
		estadoUser.addItem("");
		estadoUser.addItem("Activo");
		estadoUser.addItem("Inactivo");
		panel_1.add(estadoUser);
		
		//Sede
		
		JLabel lblIdSede = new JLabel("ID de Sede :");
		lblIdSede.setBounds(31, 291, 128, 17);
		panel_1.add(lblIdSede);
		lblIdSede.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfIdSede = new JTextField();
		tfIdSede.setColumns(10);
		tfIdSede.setBounds(171, 291, 153, 20);
		panel_1.add(tfIdSede);
		
		//Btn VOlVER
		
		JButton btnNewButton_1_1 = new JButton("VOLVER");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(38, 461, 95, 36);
		frmInformacinUsuario.getContentPane().add(btnNewButton_1_1);
	}

}
