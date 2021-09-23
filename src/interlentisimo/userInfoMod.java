package interlentisimo;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Classes.TextPrompt;
import Classes.verification;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Color;

public class userInfoMod {

	JFrame frmInformacinUsuario;
	private JTextField nombretxt;
	private JTextField apellidostxt;
	private JTextField direcciontxt;
	private JTextField telefonotxt;
	private JTextField emailtxt;
	private JTextField tfIdSede;
	private JTextField cedulaTxt;
	private JButton buscarIdBtn;
	private JComboBox<String> TipoCargos, estadoUser;
	ControlBase control;
	verification ver;
	private TextPrompt idPh,sedeph;
	private JLabel emptyFieldErrorLbl;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public userInfoMod(String idUser) {
		initialize(idUser);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param idUser 
	 */
	private void initialize(String idUser) {
		frmInformacinUsuario = new JFrame();
		frmInformacinUsuario.setTitle("Informaci\u00F3n Usuario");
		frmInformacinUsuario.setBounds(100, 100, 800, 600);
		frmInformacinUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInformacinUsuario.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(325, 25, 133, 38);
		frmInformacinUsuario.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Editar Usuario");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(196, 74, 439, 476);
		frmInformacinUsuario.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		buscarIdBtn = new JButton("Buscar");
		buscarIdBtn.setBounds(349, 42, 80, 22);
		buscarIdBtn.setBackground(new Color(255, 69, 0));
		buscarIdBtn.setForeground(new Color(255, 255, 255));
		buscarIdBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(buscarIdBtn);
		buscarIdBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ControlBase control = new ControlBase();
				try {
					if(control.idUsuarioExist(cedulaTxt.getText())) {
				
						String[] userInfo = control.buscarUsuario(cedulaTxt.getText());
						System.out.println(userInfo[7]);
						nombretxt.setText(userInfo[0]);
						apellidostxt.setText(userInfo[1]);
						direcciontxt.setText(userInfo[2]);
						telefonotxt.setText(userInfo[3]);
						emailtxt.setText(userInfo[4]);
						TipoCargos.setSelectedItem(userInfo[5]);
						tfIdSede.setText(userInfo[6]);
						if(userInfo[7].equals("Activo")) {
							System.out.println("es igual a activo");
							estadoUser.setSelectedItem("Activo");
						}
						else {
							System.out.println("tetranutra");
							estadoUser.setSelectedItem("Inactivo");
						}
					}
					else {
						cedulaTxt.setText("");
						TextPrompt idPh =  new TextPrompt("Identificación no existente",cedulaTxt);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(27, 113, 60, 17);
		panel_1.add(lblNewLabel_1);
		
		nombretxt = new JTextField();
		nombretxt.setBounds(182, 77, 153, 20);
		panel_1.add(nombretxt);
		nombretxt.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombres :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(27, 77, 64, 17);
		panel_1.add(lblNewLabel_1_1);
		
		apellidostxt = new JTextField();
		apellidostxt.setColumns(10);
		apellidostxt.setBounds(182, 113, 153, 20);
		panel_1.add(apellidostxt);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Direcci\u00F3n :");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(27, 149, 65, 17);
		panel_1.add(lblNewLabel_1_2_1);
		
		direcciontxt = new JTextField();
		direcciontxt.setColumns(10);
		direcciontxt.setBounds(182, 149, 153, 20);
		panel_1.add(direcciontxt);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tel\u00E9fono :");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(27, 187, 64, 17);
		panel_1.add(lblNewLabel_1_2_1_1);
		
		telefonotxt = new JTextField();
		telefonotxt.setColumns(10);
		telefonotxt.setBounds(182, 187, 153, 20);
		panel_1.add(telefonotxt);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Email :");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1_1.setBounds(27, 226, 45, 17);
		panel_1.add(lblNewLabel_1_2_1_1_1);
		
		emailtxt = new JTextField();
		emailtxt.setColumns(10);
		emailtxt.setBounds(182, 226, 153, 20);
		panel_1.add(emailtxt);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Cargo :");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1_1_1.setBounds(27, 266, 51, 17);
		panel_1.add(lblNewLabel_1_2_1_1_1_1);
		
		TipoCargos = new JComboBox<String>();
		
		TipoCargos.setBounds(182, 265, 153, 22);
		TipoCargos.addItem("");
		TipoCargos.addItem("Secretaria");
		TipoCargos.addItem("Operador de oficina");
		TipoCargos.addItem("Contador");
		TipoCargos.addItem("Gerente");
		TipoCargos.addItem("AuxOperación");
		panel_1.add(TipoCargos);
		
		JButton btnNewButton = new JButton("ACTUALIZAR");
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(159, 442, 114, 23);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					validarcampos();	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		JLabel lblNewLabel_1_2 = new JLabel("Estado :");
		lblNewLabel_1_2.setBounds(27, 304, 128, 17);
		panel_1.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		estadoUser = new JComboBox<String>();
		estadoUser.setBounds(182, 303, 153, 22);
		estadoUser.addItem("");
		estadoUser.addItem("Activo");
		estadoUser.addItem("Inactivo");
		panel_1.add(estadoUser);
		
		//Sede
		
		JLabel lblIdSede = new JLabel("ID de Sede :");
		lblIdSede.setBounds(27, 345, 128, 17);
		panel_1.add(lblIdSede);
		lblIdSede.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfIdSede = new JTextField();
		tfIdSede.setColumns(10);
		tfIdSede.setBounds(182, 345, 153, 20);
		panel_1.add(tfIdSede);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Cedula:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(27, 44, 64, 17);
		panel_1.add(lblNewLabel_1_1_1);
		
		cedulaTxt = new JTextField();
		cedulaTxt.setColumns(10);
		cedulaTxt.setBounds(182, 44, 153, 20);
		panel_1.add(cedulaTxt);
		
		//Btn VOlVER
		
		JButton btnNewButton_1_1 = new JButton("VOLVER");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmInformacinUsuario.setVisible(false);
				usersMenu menu_u = new usersMenu(idUser);
				menu_u.frame.setVisible(true);
				menu_u.frame.setLocationRelativeTo(frmInformacinUsuario);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(38, 461, 95, 36);
		frmInformacinUsuario.getContentPane().add(btnNewButton_1_1);
		
		emptyFieldErrorLbl = new JLabel("<html>Todos los campos deben de ser llenados</html>");
		emptyFieldErrorLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		emptyFieldErrorLbl.setForeground(Color.red);
		emptyFieldErrorLbl.setBounds(69, 389, 300, 30);
		emptyFieldErrorLbl.setVisible(false);
		panel_1.add(emptyFieldErrorLbl);
	}
	
		
	
	private void validarcampos() throws SQLException  {
		ControlBase control = new ControlBase();
		verification ver = new verification();
		emptyFieldErrorLbl.setVisible(false);
		
		String nombreingresado = nombretxt.getText();
		String apellidoingresado = apellidostxt.getText();
		String direccioningresada = direcciontxt.getText();
		String telefonoingresado = telefonotxt.getText();
		String emailingresado = emailtxt.getText();
		String cargoingresado = (String)TipoCargos.getSelectedItem();
		String sedeingresada = tfIdSede.getText();
		String estadoingresado = (String)estadoUser.getSelectedItem();
		String cedulaingresada = cedulaTxt.getText();
		
		ArrayList <String> fields = new ArrayList <String>();
		fields.add(nombreingresado);
		fields.add(apellidoingresado);
		fields.add(direccioningresada);
		fields.add(telefonoingresado);
		fields.add(emailingresado);
		fields.add(cargoingresado);
		fields.add(sedeingresada);
		fields.add(estadoingresado);
		fields.add(cedulaingresada);
		
		boolean emptyFieldError = !ver.filledFields(fields);
		if (emptyFieldError)
		{
			emptyFieldErrorLbl.setVisible(true);
		}
		
		
		boolean sedeError = false;
		if(ver.idSintax(ver.FORMATO_SEDE, sedeingresada)) 
		{
			if (!control.idSedeExist(sedeingresada)) {
				tfIdSede.setText("");
				TextPrompt sedeph =  new TextPrompt("Sede no existente",tfIdSede);
				sedeError = true;
			}
		}else 
		{
			tfIdSede.setText("");
			sedeph.setText("Sintaxis incorrecta");
			sedeError = true;
		}
		
		boolean emailError = false;
		if(!ver.emailSintax(ver.FORMATO_EMAIL, emailingresado)) {
			emailtxt.setText("");
			TextPrompt emailph = new TextPrompt("Email mal escrito",emailtxt);
			emailError = true;
		}
		
		if(!(emptyFieldError || sedeError || emailError)) {
			control.ModificarUsuario(nombreingresado, apellidoingresado, direccioningresada,telefonoingresado
			,emailingresado, cargoingresado,sedeingresada,estadoingresado,cedulaingresada);
		    JOptionPane.showMessageDialog(null, "Usuario modificado correctamente");
			nombretxt.setText("");
			apellidostxt.setText("");
			direcciontxt.setText("");
			telefonotxt.setText("");
			emailtxt.setText("");
			TipoCargos.setToolTipText("");
			tfIdSede.setText("");
			cedulaTxt.setText("");
			estadoUser.setToolTipText("");
		}
		
			
		
	}
}
