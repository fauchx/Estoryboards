package interlentisimo;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
	private JComboBox<String> TipoCargos;
	ControlBase control;

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
		panel_1.setBounds(196, 74, 439, 436);
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
					String[] userInfo = control.buscarUsuario(cedulaTxt.getText());
					nombretxt.setText(userInfo[0]);
					apellidostxt.setText(userInfo[1]);
					direcciontxt.setText(userInfo[2]);
					telefonotxt.setText(userInfo[3]);
					emailtxt.setText(userInfo[4]);
					if(userInfo[5].equals("Gerente")) {
						TipoCargos.setSelectedItem("Gerente");
					}
					System.out.println(userInfo[5]);
					tfIdSede.setText(userInfo[6]);
					System.out.println(userInfo[6]);

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
		TipoCargos.addItem("Auxiliar de operación");
		panel_1.add(TipoCargos);
		
		JButton btnNewButton = new JButton("ACTUALIZAR");
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(161, 402, 114, 23);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ControlBase control = new ControlBase();
					if(control.ModificarUsuario(nombretxt.getText(), apellidostxt.getText(), direcciontxt.getText()
						,telefonotxt.getText(), emailtxt.getText(), (String)TipoCargos.getSelectedItem(),
						tfIdSede.getText() ,cedulaTxt.getText() )) {
						JLabel lblNewLabel_2 = new JLabel("\u2714 Registro Efectivo \u2714");
						panel_1.add(lblNewLabel_2);
						lblNewLabel_2.setForeground(new Color(0, 128, 0));
						lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 14));
						nombretxt.setText("");
						apellidostxt.setText("");
						direcciontxt.setText("");
						telefonotxt.setText("");
						emailtxt.setText("");
						TipoCargos.setToolTipText("");
						tfIdSede.setText("");
						cedulaTxt.setText("");
					}
					else {
						JLabel lblNewLabel_2_1 = new JLabel("\u2718 Error en el registro \u2718");
						panel_1.add(lblNewLabel_2_1);
						lblNewLabel_2_1.setForeground(new Color(255, 0, 0));
						lblNewLabel_2_1.setFont(new Font("SansSerif", Font.BOLD, 14));
					}
						
						
						
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
		
		JComboBox<String> estadoUser = new JComboBox<String>();
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
	}
	
	
	private void validarcampos() throws SQLException  {
		
		
	}
}
