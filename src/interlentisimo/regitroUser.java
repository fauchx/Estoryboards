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
	private JTextField tfNombres;
	private JTextField tfApellidos;
	private JTextField tfId;
	private JTextField tfAdress;
	private JTextField tfTelefono;
	private JTextField tfEmail;
	private JTextField tfPassword;
	private JTextField tfIdSede;

	/**
	 * Launch the application.
	 */
        /*
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
        */

	/**
	 * Create the application.
	 */
	public regitroUser(JFrame parent) {
		initialize(parent);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame parent) {
		frmRegistro = new JFrame();
		frmRegistro.setTitle("Registro");
		frmRegistro.setResizable(false);
		frmRegistro.setBounds(0, 0, 800, 600);
		frmRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistro.getContentPane().setLayout(null);
        frmRegistro.setVisible(true);
        frmRegistro.setLocationRelativeTo(parent);
                
		JPanel panel = new JPanel();
		panel.setBounds(249, 52, 296, 34);
		frmRegistro.getContentPane().add(panel);
		
		JLabel lblTitle = new JLabel("Registro de empleados");
		lblTitle.setForeground(new Color(255, 69, 0));
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
		panel.add(lblTitle);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(220, 100, 354, 390);
		frmRegistro.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		//NOMBRES
		
		JLabel lblNombres = new JLabel("Nombres :");
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombres.setBounds(31, 19, 64, 17);
		panel_1.add(lblNombres);
		
		tfNombres = new JTextField();
		tfNombres.setBounds(169, 19, 153, 20);
		panel_1.add(tfNombres);
		tfNombres.setColumns(10);
		
		//APELLIDOS
		
		JLabel lblApellidos = new JLabel("Apellidos :");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setBounds(31, 55, 60, 17);
		panel_1.add(lblApellidos);
		
		tfApellidos = new JTextField();
		tfApellidos.setColumns(10);
		tfApellidos.setBounds(169, 55, 153, 20);
		panel_1.add(tfApellidos);
		
		
		//ID
		
		JLabel lblId = new JLabel("No de Identificaci\u00F3n :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(31, 91, 128, 17);
		panel_1.add(lblId);
		
		tfId = new JTextField();
		tfId.setColumns(10);
		tfId.setBounds(169, 91, 153, 20);
		panel_1.add(tfId);
		
		//DIRECCION
		
		JLabel lblAdress = new JLabel("Direcci\u00F3n :");
		lblAdress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdress.setBounds(31, 127, 65, 17);
		panel_1.add(lblAdress);
		
		tfAdress = new JTextField();
		tfAdress.setColumns(10);
		tfAdress.setBounds(169, 127, 153, 20);
		panel_1.add(tfAdress);
		
		//TELEFONO
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono :");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefono.setBounds(31, 163, 64, 17);
		panel_1.add(lblTelefono);
		
		tfTelefono = new JTextField();
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(169, 163, 153, 20);
		panel_1.add(tfTelefono);
		
		//EMAIL
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(31, 199, 45, 17);
		panel_1.add(lblEmail);
		
		tfEmail= new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(169, 199, 153, 20);
		panel_1.add(tfEmail);
		
		//CARGO
		
		JLabel lblcargo = new JLabel("Cargo :");
		lblcargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblcargo.setBounds(31, 236, 51, 17);
		panel_1.add(lblcargo);
		
		JComboBox<String> tipoCargo = new JComboBox<String>();
		tipoCargo.setBounds(169, 235, 153, 22);
		tipoCargo.addItem("");
		tipoCargo.addItem("Secretaria");
		tipoCargo.addItem("Operador de oficina");
		tipoCargo.addItem("Contador");
		tipoCargo.addItem("Gerente");
		tipoCargo.addItem("Auxiliar de operaci�n");
		panel_1.add(tipoCargo);
		
		//PASSWORD
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(31, 273, 79, 17);
		panel_1.add(lblPassword);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(169, 273, 153, 20);
		panel_1.add(tfPassword);
		
		//SEDE 
		
		JLabel lblSede = new JLabel("ID de Sede :");
		lblSede.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSede.setBounds(31, 310, 79, 17);
		panel_1.add(lblSede);
		
		tfIdSede = new JTextField();
		tfIdSede.setColumns(10);
		tfIdSede.setBounds(169, 310, 153, 20);
		panel_1.add(tfIdSede);
		
		JButton btnNewButton = new JButton("REGISTRAR");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setBounds(122, 360, 114, 23);
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
