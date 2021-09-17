package interlentisimo;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Classes.TextPrompt;

import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import Classes.verification;


public class registroSede 
{

	public JFrame frmRegistroSedes;
	private JTextField nombre_sede, direccion_sede, id_sede;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel chequeoRegistroLbl, emptyFieldErrorLbl;
	private verification ver = new verification();
	private TextPrompt idPh, direccionPh, nombrePh;



	/**
	 * Create the application.
	 */
	public registroSede(String idUser) 
	{
		initialize(idUser);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String idUser) 
	{
		frmRegistroSedes = new JFrame();
		frmRegistroSedes.setTitle("Registro sedes");
		frmRegistroSedes.setBounds(100, 100, 800, 600);
		frmRegistroSedes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroSedes.getContentPane().setLayout(null);
		
		/* JPanels con distribucion BorderLayout */
		JPanel panelFrame =  new JPanel(new BorderLayout());
		panelFrame.setBounds(0, 0, 450, 400);
		frmRegistroSedes.getContentPane().add(panelFrame);
		//panelFrame.setBackground(Color.yellow);
		panelFrame.setLocation(((frmRegistroSedes.getWidth()/2)-(panelFrame.getWidth()/2)),
							   ((frmRegistroSedes.getHeight()/2)-(panelFrame.getHeight()/2)));
		
		JPanel panelTittle = new JPanel();
		panelTittle.setBounds(124, 11, 192, 35);
		//panelTittle.setBackground(Color.green);
		panelTittle.setVisible(true);
		panelFrame.add(panelTittle,BorderLayout.NORTH);
		
		JPanel panelForm = new JPanel();
		panelForm.setLayout(null);
		panelForm.setBounds(0, 0, 400, 200);
		//panelForm.setBackground(Color.white);
		panelForm.setVisible(true);
		panelFrame.add(panelForm,BorderLayout.CENTER);
		
		JPanel panelBottom = new JPanel();
		panelBottom.setBounds(0, 0, 200, 100);
		//panelBottom.setBackground(Color.blue);
		panelBottom.setVisible(true);
		panelFrame.add(panelBottom,BorderLayout.SOUTH);
		
		/*Label tittle de la interfaz*/
		JLabel lblNewLabel = new JLabel("Registro de sedes");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 69, 0));
		panelTittle.add(lblNewLabel);
		
		/**
		 * Campo Nombre de sede
		 */
		JLabel nombreLbl = new JLabel("Nombre:");
		nombreLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nombreLbl.setBounds(34, 71, 57, 14);
		panelForm.add(nombreLbl);
		
		nombre_sede = new JTextField();
		nombre_sede.setBounds(116, 70, 187, 20);
		nombre_sede.setColumns(10);
		nombrePh = new TextPrompt("ej: Sede Norte",nombre_sede);
		nombrePh.changeAlpha(0.75f);
		panelForm.add(nombre_sede);
		
		/**
		 * Campo Direccion de sede
		 */
		JLabel direccionLbl = new JLabel("Dirección:");
		direccionLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		direccionLbl.setBounds(34, 128, 80, 14);
		panelForm.add(direccionLbl);
		
		direccion_sede = new JTextField();
		direccion_sede.setBounds(116, 128, 187, 20);
		direccion_sede.setColumns(10);
		direccionPh = new TextPrompt("ej. CL 1 # 2 - 3",direccion_sede);
		direccionPh.changeAlpha(0.75f);
		panelForm.add(direccion_sede);
		
		/**
		 * Campo identificador de sede
		 */
		JLabel idSedeLbl = new JLabel("Identificador:");
		idSedeLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idSedeLbl.setBounds(34, 187, 80, 14);
		panelForm.add(idSedeLbl);

		id_sede = new JTextField();
		id_sede.setBounds(116, 186, 187, 20);
		idPh = new TextPrompt("ej. S001",id_sede);
		idPh.changeAlpha(0.75f);
		panelForm.add(id_sede);
		
		JButton idInfo = new JButton();
		idInfo.setIcon(new ImageIcon(menu.class.getResource("/icons/idInfoIcon.png")));
		idInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Un identificador debe empezar por S, seguido de un número de 3 dígitos.");
			}
		});
		idInfo.setBounds(12, 187, 17, 17);
		idInfo.setBorder(null);
		panelForm.add(idInfo);
		
		

		
		/*JLabel Empty fields*/
		emptyFieldErrorLbl = new JLabel("<html>Todos los campos deben de ser llenados</html>");
		emptyFieldErrorLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		emptyFieldErrorLbl.setForeground(Color.red);
		emptyFieldErrorLbl.setBounds(50, 220, 300, 30);
		emptyFieldErrorLbl.setVisible(false);
		panelForm.add(emptyFieldErrorLbl);
		
		/*JLabel Verificado de registro de sede*/
		chequeoRegistroLbl= new JLabel("<html>Sede registrada exitosamente</html>");
		chequeoRegistroLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		chequeoRegistroLbl.setForeground(new Color(255, 69, 0));
		chequeoRegistroLbl.setBounds(50, 220, 300, 30);
		chequeoRegistroLbl.setVisible(false);
		panelForm.add(chequeoRegistroLbl);
		
		
		/**
		 * JButtons Registrar y Volver
		 */
		
		JButton registrarBtn = new JButton("Registrar");
		registrarBtn.setBackground(new Color(255, 69, 0));
		registrarBtn.setForeground(new Color(255, 255, 255));
		registrarBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		registrarBtn.setBounds(330, 256, 89, 23);
		registrarBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				try {
					validarCampos();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panelForm.add(registrarBtn);
		
		JButton volverBtn = new JButton("VOLVER");
		volverBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		volverBtn.setBounds(38, 270, 95, 36);
		volverBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frmRegistroSedes.setVisible(false);
				sedesMenu sedemenu = new sedesMenu(idUser);
			}
		});
		panelBottom.add(volverBtn);
		
	}
	
		
	/*
	 * Este método verifica si los campos fueron correctamente diligenciados, de acuerdo al formato establecido.
	 */
	private void validarCampos() throws SQLException 
	{

		emptyFieldErrorLbl.setVisible(false);
		chequeoRegistroLbl.setVisible(false);


		
		String nombreIngresado = nombre_sede.getText();
		String direccionIngresada = direccion_sede.getText();
		String idIngresado = id_sede.getText();
		
		ArrayList <String>  fields = new ArrayList <String>();
		fields.add(nombreIngresado);
		fields.add(direccionIngresada);
		fields.add(idIngresado);
		
		

		//Verifica que todos los campos hayan sido llenados
		boolean emptyFieldError = !ver.filledFields(fields);
		if (emptyFieldError) {
			emptyFieldErrorLbl.setVisible(true);
		}
		
		/**
		 * Validar nombre de solo letras, de minimo 8 caracteres
		 */
		boolean nombreError = false;
		if(!(ver.contieneSoloLetras(nombreIngresado)
				&& (ver.minimoCaracteres(nombreIngresado, 8)))) 
		{
			nombre_sede.setText("");
			nombrePh.setText("Usar 8 letras como mínimo");
			nombreError = true;
		}
		
		/**
		 * Validar si el identificador  es válido de acuerdo al formato establecido, que es una S seguida de 3 dígitos numéricos
		 * y la verificación de la no existencia en la base de datos para considerar la inserción  de esta sede.
		 */
		boolean idError = false;
		Pattern idPattern = Pattern.compile("^S"+"([0-9]{3,3})$");

		if(ver.idSintax(idPattern, idIngresado)) 
		{
			ControlBase control = new ControlBase();
			if(control.idSedeExist(idIngresado)) //Si la id de sede ya existe retorna true, por lo tanto no se puede registrar esa sede con el id ingresado
			{
				idError=true;
				id_sede.setText("");
				idPh.setText("Id ya registrado");
			}
		}else 
		{
			idError=true;
			id_sede.setText("");
			idPh.setText("Sintaxis incorrecta");	

		}
		
		
		/**
		 * Verificacion de existencia de algún error que no permita la correcta inserción en la base de datos
		 */
		
		if(!(emptyFieldError || nombreError || idError )) 
		{
			//Caso de que no exista ningun error- Se inserta en la base
			System.out.println("No hay error");
			ControlBase control = new ControlBase();
			control.insertarSede(nombreIngresado, direccionIngresada, idIngresado);
			chequeoRegistroLbl.setVisible(true);
			nombre_sede.setText("");
			nombrePh.setText("");
			direccion_sede.setText("");
			direccionPh.setText("");
			id_sede.setText("");
			idPh.setText("");
			
		}
		
	}

}
