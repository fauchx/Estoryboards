package interlentisimo;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.border.LineBorder;

import Classes.TextPrompt;
import Classes.verification;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class registroPaquete {

	public JFrame frame;
	private JTextField nombre_r;
	private JTextField apellidos_r;
	private JTextField identificacion_r;
	private JTextField email_r;
	private JTextField telefono_r;
	private JTextField nombre_d;
	private JTextField apellido_d;
	private JTextField identificacion_d;
	private JTextField email_d;
	private JTextField telefono_d;
	private JTextField txtpeso;
	private String cargoUser,getPeso,getAlto,getAncho,getLargo;
	private JTextField direccion_r;
	private JTextField direccion_d;
	private JTextField textAncho;
	private JTextField textAlto;
	private JTextField textLargo;
	private TextPrompt alto,ancho,largo;
	private float vol1,subtotalprecio,peso1,precio_total;
	private ControlBase control;
	private String id_retorno_envio,usuario;
	private verification ver;
	private JLabel emptyFieldErrorLbl;

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
		infoRemitente.setBounds(30, 56, 354, 262);
		frame.getContentPane().add(infoRemitente);
		infoRemitente.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(31, 94, 60, 17);
		infoRemitente.add(lblNewLabel_1);
		
		nombre_r = new JTextField();
		nombre_r.setBounds(169, 58, 153, 20);
		infoRemitente.add(nombre_r);
		nombre_r.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombres :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(31, 59, 64, 17);
		infoRemitente.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("No de Identificaci\u00F3n :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(31, 130, 128, 17);
		infoRemitente.add(lblNewLabel_1_2);
		
		apellidos_r = new JTextField();
		apellidos_r.setColumns(10);
		apellidos_r.setBounds(169, 94, 153, 20);
		infoRemitente.add(apellidos_r);
		
		identificacion_r = new JTextField();
		identificacion_r.setColumns(10);
		identificacion_r.setBounds(169, 130, 153, 20);
		infoRemitente.add(identificacion_r);
		
		email_r = new JTextField();
		email_r.setColumns(10);
		email_r.setBounds(169, 166, 153, 20);
		infoRemitente.add(email_r);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tel\u00E9fono :");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(31, 202, 64, 17);
		infoRemitente.add(lblNewLabel_1_2_1_1);
		
		telefono_r = new JTextField();
		telefono_r.setColumns(10);
		telefono_r.setBounds(169, 202, 153, 20);
		infoRemitente.add(telefono_r);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Email :");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1_1.setBounds(31, 166, 45, 17);
		infoRemitente.add(lblNewLabel_1_2_1_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Informaci\u00F3n Remitente");
		lblNewLabel_1_1_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(97, 11, 160, 25);
		infoRemitente.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_3 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_1_2_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1_3.setBounds(31, 234, 64, 17);
		infoRemitente.add(lblNewLabel_1_2_1_1_3);
		
		direccion_r = new JTextField();
		direccion_r.setColumns(10);
		direccion_r.setBounds(169, 234, 153, 20);
		infoRemitente.add(direccion_r);
		String getDireccion_r = direccion_r.getText();
		
		String usuario = idUser;
		
		JPanel infoDestinatario = new JPanel();
		infoDestinatario.setLayout(null);
		infoDestinatario.setBorder(new LineBorder(new Color(0, 0, 0)));
		infoDestinatario.setBounds(401, 56, 354, 262);
		frame.getContentPane().add(infoDestinatario);
		
		JLabel lblNewLabel_1_3 = new JLabel("Apellidos :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(31, 94, 60, 17);
		infoDestinatario.add(lblNewLabel_1_3);
		
		nombre_d = new JTextField();
		nombre_d.setColumns(10);
		nombre_d.setBounds(169, 58, 153, 20);
		infoDestinatario.add(nombre_d);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Nombres :");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(31, 59, 64, 17);
		infoDestinatario.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("No de Identificaci\u00F3n :");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_2.setBounds(31, 130, 128, 17);
		infoDestinatario.add(lblNewLabel_1_2_2);
		
		apellido_d = new JTextField();
		apellido_d.setColumns(10);
		apellido_d.setBounds(169, 94, 153, 20);
		infoDestinatario.add(apellido_d);
		
		identificacion_d = new JTextField();
		identificacion_d.setColumns(10);
		identificacion_d.setBounds(169, 130, 153, 20);
		infoDestinatario.add(identificacion_d);
		
		email_d = new JTextField();
		email_d.setColumns(10);
		email_d.setBounds(169, 166, 153, 20);
		infoDestinatario.add(email_d);
		
		JLabel lblNewLabel_1_2_1_1_2 = new JLabel("Tel\u00E9fono :");
		lblNewLabel_1_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1_2.setBounds(31, 202, 64, 17);
		infoDestinatario.add(lblNewLabel_1_2_1_1_2);
		
		telefono_d = new JTextField();
		telefono_d.setColumns(10);
		telefono_d.setBounds(169, 202, 153, 20);
		infoDestinatario.add(telefono_d);
		
		JLabel lblNewLabel_1_2_1_1_1_2 = new JLabel("Email :");
		lblNewLabel_1_2_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1_1_2.setBounds(31, 166, 45, 17);
		infoDestinatario.add(lblNewLabel_1_2_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Informaci\u00F3n Destinatario");
		lblNewLabel_1_1_1_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(90, 11, 173, 25);
		infoDestinatario.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_2_1 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_1_2_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1_2_1.setBounds(31, 234, 64, 17);
		infoDestinatario.add(lblNewLabel_1_2_1_1_2_1);
		
		direccion_d = new JTextField();
		direccion_d.setColumns(10);
		direccion_d.setBounds(169, 234, 153, 20);
		infoDestinatario.add(direccion_d);
		
		JPanel infoDestinatario_1 = new JPanel();
		infoDestinatario_1.setBounds(40, 329, 725, 153);
		frame.getContentPane().add(infoDestinatario_1);
		infoDestinatario_1.setLayout(null);
		infoDestinatario_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		txtpeso = new JTextField();
		txtpeso.setColumns(10);
		txtpeso.setBounds(182, 47, 143, 20);
		infoDestinatario_1.add(txtpeso);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Informaci\u00F3n del env\u00EDo");
		lblNewLabel_1_1_1_1_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1.setBounds(282, 11, 160, 25);
		infoDestinatario_1.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Peso :");
		lblNewLabel_1_2_1_1_1_1.setBounds(38, 47, 51, 17);
		infoDestinatario_1.add(lblNewLabel_1_2_1_1_1_1);
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Volumen :\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(363, 47, 108, 20);
		infoDestinatario_1.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(442, 47, 219, 20);
		infoDestinatario_1.add(panel_1);
		panel_1.setLayout(null);
		
		textAncho = new JTextField();
		textAncho.setBounds(0, 0, 62, 20);
		panel_1.add(textAncho);
		textAncho.setColumns(10);
		ancho = new TextPrompt("Ancho",textAncho);
		
		textAlto = new JTextField();
		textAlto.setColumns(10);
		textAlto.setBounds(74, 0, 62, 20);
		panel_1.add(textAlto);
		alto = new TextPrompt("Alto",textAlto);
		
		textLargo = new JTextField();
		textLargo.setBounds(147, 0, 62, 20);
		panel_1.add(textLargo);
		textLargo.setColumns(10);
		largo = new TextPrompt("Largo",textLargo);
		
		JLabel lblNewLabel_3 = new JLabel("(En centimetros)");
		lblNewLabel_3.setBounds(477, 22, 117, 14);
		infoDestinatario_1.add(lblNewLabel_3);
		
		
		JButton btnNewButton = new JButton("CONTINUAR");
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(335, 505, 114, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					registrar_remitente();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				registrar_destinatario();
				registar_envio();
				registrar_precio();
				registrarPaquete();
				JOptionPane.showMessageDialog(null, "total: "+precio_total);
				frame.setVisible(false);
				impuestoPaquete impuesto = new impuestoPaquete(idUser,Integer.parseInt(id_retorno_envio));
				impuesto.frmCheckout.setLocationRelativeTo(frame);
				impuesto.frmCheckout.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		

		JButton volverBtn = new JButton("VOLVER");
		volverBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		volverBtn.setBounds(30, 493, 95, 36);
		volverBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed (ActionEvent e)
			{
				frame.setVisible(false);
				ControlBase control = new ControlBase();
				try {
					cargoUser = control.getCargo(idUser);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				menu menuf = new menu(idUser);
				menuf.configMenu(cargoUser, frame);
				menuf.frame.setLocationRelativeTo(frame);
			}
		});
		frame.getContentPane().add(volverBtn);
		
		emptyFieldErrorLbl = new JLabel("<html>Todos los campos deben de ser llenados</html>");
		emptyFieldErrorLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		emptyFieldErrorLbl.setForeground(Color.red);
		emptyFieldErrorLbl.setBounds(69, 389, 300, 30);
		emptyFieldErrorLbl.setVisible(true);
		infoDestinatario_1.add(emptyFieldErrorLbl);
	}
	public void registrar_remitente() throws SQLException {
		String getNombre_r = nombre_r.getText();
		String getApellidos_r = apellidos_r.getText();
		String getIdentificacion_r =  identificacion_r.getText();
		String getEmail_r = email_r.getText();
		String getTelefono_r = telefono_r.getText();
		String getDireccion_r = direccion_r.getText();
		
		ControlBase control = new ControlBase();
		
		ArrayList <String> fields = new ArrayList <String>();
		fields.add(getNombre_r);
		fields.add(getApellidos_r);
		fields.add(getIdentificacion_r);
		fields.add(getEmail_r);
		fields.add(getTelefono_r);
		fields.add(getDireccion_r);
		
		boolean emptyFieldError = !ver.filledFields(fields);
		if (emptyFieldError)
		{
			emptyFieldErrorLbl.setVisible(true);
		}
		
		
		boolean emailError = false;
		if(!ver.emailSintax(ver.FORMATO_EMAIL, getEmail_r)) {
			email_r.setText("");
			TextPrompt emailph = new TextPrompt("Email mal escrito",email_r);
			emailError = true;
		}
		
		if(!(emailError)) {
		try {
			control.CrearRemitente(getNombre_r, getApellidos_r, getIdentificacion_r, getDireccion_r, getTelefono_r, getEmail_r);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public void registrar_destinatario() {
		
		String getNombre_d = nombre_d.getText();
		String getApellidos_d = apellido_d.getText();
		String getIdentificacion_d =  identificacion_d.getText();
		String getEmail_d = email_d.getText();
		String getTelefono_d = telefono_d.getText();
		String getDireccion_d = direccion_d.getText();
		verification ver = new verification();
		
		ControlBase control = new ControlBase();
		try {
			control.CrearDestinatario(getNombre_d, getApellidos_d, getIdentificacion_d, getDireccion_d, getTelefono_d, getEmail_d);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void registrar_precio() {
		subtotal();
		preciototal();
		ControlBase control = new ControlBase();
		float seguro = (float) 0.0;
		System.out.println("preciototal: "+precio_total);
		try {
			control.crearPrecio(precio_total, subtotalprecio,seguro,Integer.parseInt(id_retorno_envio));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void registrarPaquete() {
		String getAncho = textAncho.getText();
		String getLargo = textLargo.getText();
		String getAlto = textAlto.getText();
		String getPeso = txtpeso.getText();
		peso1 = Float.parseFloat(getPeso);
		vol1 = (Float.parseFloat(getAlto)*Float.parseFloat(getAncho)*Float.parseFloat(getLargo))/6000;
		ControlBase control = new ControlBase();
		try {
			control.crearPaquete(Integer.parseInt(id_retorno_envio), peso1, vol1,usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void registar_envio() {
		String getIdentificacion_r =  identificacion_r.getText();
		String getIdentificacion_d =  identificacion_d.getText();
		
		ControlBase control = new ControlBase();
		try {
			id_retorno_envio = control.crearEnvio(getIdentificacion_d,getIdentificacion_r );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void preciototal() {
		subtotal();
		precio_total = (float) ((subtotalprecio*0.19)+subtotalprecio);
	}
	
	public void subtotal() {
		String getAncho = textAncho.getText();
		String getLargo = textLargo.getText();
		String getAlto = textAlto.getText();
		String getPeso = txtpeso.getText();
		
		peso1 = Float.parseFloat(getPeso);
		vol1 = (Float.parseFloat(getAlto)*Float.parseFloat(getAncho)*Float.parseFloat(getLargo))/6000;
		
		System.out.println("peso"+peso1);
		System.out.println("volumen"+vol1);
		
		if(peso1 > vol1) {
			if(peso1 <=  10) {
				subtotalprecio = 5000+peso1*1000;
			}else {
				subtotalprecio = 7000+peso1*1000;
			}
		}else {
			if(vol1 <=  10) {
				subtotalprecio = 5000+vol1*1000;
			}else {
				subtotalprecio = 7000+vol1*1000;
			}
		}
		
	}
}
