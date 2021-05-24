package interlentisimo;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.Color;
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


public class registroSede 
{

	public JFrame frmRegistroSedes;
	private JTextField nombre_sede;
	private JTextField direccion_sede;
	private JTextField id_sede;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel chequeoRegistroLbl, emptyFieldErrorLbl, nombreErrorLbl, direccionSintaxErrorLbl, direccionExistErrorLbl, idSedeSintaxErrorLbl, idSedeExistErrorLbl;
	
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
		panelForm.add(nombre_sede);
		
		/*Labels de error en el campo*/
		
		nombreErrorLbl = new JLabel("<html>Usa 8 letras como mínimo para el nombre</html>");
		nombreErrorLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nombreErrorLbl.setForeground(Color.red);
		nombreErrorLbl.setBounds(320, 55, 120, 45);
		nombreErrorLbl.setVisible(false);
		panelForm.add(nombreErrorLbl);
		
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
		TextPrompt direcPlaceholder = new TextPrompt("ej. CL 1 # 2 - 3",direccion_sede);
		direcPlaceholder.changeAlpha(0.75f);
		panelForm.add(direccion_sede);
		
		/*Labels de error en el campo*/
		
		//Error: No es una dirección válida
		direccionSintaxErrorLbl = new JLabel("<html>Dirección no válida</html>");
		direccionSintaxErrorLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		direccionSintaxErrorLbl.setForeground(Color.red);
		direccionSintaxErrorLbl.setBounds(320, 116, 120, 45);
		direccionSintaxErrorLbl.setVisible(false);
		panelForm.add(direccionSintaxErrorLbl);
		
		//Error: La dirección ingresada ya se encuentra registrada en la base
		direccionExistErrorLbl = new JLabel("<html>Dirección ya registrada</html>");
		direccionExistErrorLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		direccionExistErrorLbl.setForeground(Color.red);
		direccionExistErrorLbl.setBounds(320, 116, 120, 45);
		direccionExistErrorLbl.setVisible(false);
		panelForm.add(direccionExistErrorLbl);
		
		/**
		 * Campo identificador de sede
		 */
		JLabel idSedeLbl = new JLabel("Identificador:");
		idSedeLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idSedeLbl.setBounds(34, 187, 80, 14);
		panelForm.add(idSedeLbl);

		id_sede = new JTextField();
		id_sede.setBounds(116, 186, 187, 20);
		TextPrompt idPlaceholder = new TextPrompt("ej. S001",id_sede);
		idPlaceholder.changeAlpha(0.75f);
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
		
		
		/*Labels de error en el campo*/
		
		//Error: EL id ingresado no cumple con el formato
		idSedeSintaxErrorLbl = new JLabel("<html>Identificador inválido</html>");
		idSedeSintaxErrorLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		idSedeSintaxErrorLbl.setForeground(Color.red);
		idSedeSintaxErrorLbl.setBounds(320, 176, 120, 45);
		idSedeSintaxErrorLbl.setVisible(false);
		panelForm.add(idSedeSintaxErrorLbl);
		
		//Error: El identificador ya ha sido registrado
		idSedeExistErrorLbl = new JLabel("<html>Identificador ya registrado</html>");
		idSedeExistErrorLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		idSedeExistErrorLbl.setForeground(Color.red);
		idSedeExistErrorLbl.setBounds(320, 176, 120, 45);
		idSedeExistErrorLbl.setVisible(false);
		panelForm.add(idSedeExistErrorLbl);
		
		
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
			public void actionPerformed(ActionEvent e) {
				frmRegistroSedes.setVisible(false);
				menu menuf = new menu(idUser);
				menuf.configMenu(idUser, frmRegistroSedes);
			}
		});
		panelBottom.add(volverBtn);
		
	}
	
	/*
	 * Este método verifica si los campos fueron correctamente diligenciados, de acuerdo al formato establecido.
	 */
	private void validarCampos() throws SQLException 
	{
		nombreErrorLbl.setVisible(false);
		direccionSintaxErrorLbl.setVisible(false);
		direccionExistErrorLbl.setVisible(false);
		idSedeSintaxErrorLbl.setVisible(false);
		idSedeExistErrorLbl.setVisible(false);
		emptyFieldErrorLbl.setVisible(false);
		chequeoRegistroLbl.setVisible(false);
		
		String nombreIngresado = nombre_sede.getText();
		String direccionIngresada = direccion_sede.getText();
		String idIngresado = id_sede.getText();
		
		
		/**
		 * Validar que todos los campos han sido llenados
		 */
		boolean emptyFieldError = false;
		if ((nombreIngresado.length() == 0)
				|| (direccionIngresada.length() == 0)
				|| (idIngresado.length() == 0)) 
		{
			emptyFieldErrorLbl.setVisible(true);
			emptyFieldError = true;
		}
		
		/**
		 * Validar nombre de solo letras, de minimo 8 caracteres
		 */
		boolean nombreError = false;
		if(!(contieneSoloLetras(nombreIngresado)
				&& (nombreIngresado.replace(" ", "").length()>=8))) 
		{
			nombreErrorLbl.setVisible(true);
			nombreError = true;
		}
		
		/**
		 * Validar si el identificador  es válido de acuerdo al formato establecido, que es una S seguida de 3 dígitos numéricos
		 * y la verificación de la no existencia en la base de datos para considerar la inserción  de esta sede.
		 */
		boolean idError = false;
		Pattern idPattern = Pattern.compile("^S"+"([0-9]{3,3})$");

		if(idIngresado.length()>0) 
		{
			Matcher mather = idPattern.matcher(idIngresado);
			
			if(mather.find() == true) 
				
			{
				idSedeSintaxErrorLbl.setVisible(false);
				ControlBase control = new ControlBase();
				if(!control.idSedeExist(idIngresado)) 
				{
					idError=false;
				} else 
				{
					idError=true;
					idSedeExistErrorLbl.setVisible(true);
				}
				
				
			} else 
			{
				idSedeSintaxErrorLbl.setVisible(true);
				idError=true;
			}
		}
		
		
		/**
		 * Verificacion de existencia de algún error que no permita la correcta inserción en la base de datos
		 */
		
		if(!(emptyFieldError == true
				|| nombreError == true
				|| idError == true)) 
		{
			//Caso de que no exista ningun error- Se inserta en la base
			System.out.println("No hay error");
			ControlBase control = new ControlBase();
			control.insertarSede(nombreIngresado, direccionIngresada, idIngresado);
			chequeoRegistroLbl.setVisible(true);
			nombre_sede.setText("");
			direccion_sede.setText("");
			id_sede.setText("");
			
		}
		
	}
	
	private static boolean contieneSoloLetras(String cadena) 
	{
	    for (int x = 0; x < cadena.length(); x++) 
	    {
	        char c = cadena.charAt(x);
	        // Si no está entre a y z, ni entre A y Z, ni es un espacio
	        if (!((c >= 'a' && c <= 'z') 
	        		|| (c >= 'A' && c <= 'Z') 
	        		|| c == ' ')) 
	        {
	            return false;
	        }
	    }
	    return true;
	}
}
