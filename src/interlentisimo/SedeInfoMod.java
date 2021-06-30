package interlentisimo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Classes.TextPrompt;
import Classes.TextPrompt.Show;
import Classes.verification;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SedeInfoMod {

	public JFrame frame;
	private JTextField nombre_sede, direccion_sede, id_sede;
	private JButton volverBtn, modificarBtn, buscarIdBtn;
	private JComboBox<String> estadoSede;
	private JPanel panelForm, panelBtns;
	private JLabel emptyFieldErrorLbl;

	/**
	 * Create the application.
	 */
	public SedeInfoMod(String idUser) {
		initialize(idUser);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String idUser) {
		
		frame = new JFrame();
		frame.setTitle("Modificar sedes");
		frame.setBounds(0, 0, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);

		
		panelForm = new JPanel();
		panelForm.setBounds(0, 0, 400, 270);
		panelForm.setLocation(((frame.getWidth()/2)-(panelForm.getWidth()/2)),
				              ((int)Math.round((frame.getHeight()/2)-(panelForm.getHeight()/2)*1.6)));
		panelForm.setLayout(null);
		//panelForm.setBackground(Color.green);
		frame.add(panelForm);
		
		JLabel tituloLbl = new JLabel("Actualizaci\u00F3n de sedes\r\n");
		tituloLbl.setFont(new Font("SansSerif", Font.BOLD, 18));
		tituloLbl.setForeground(new Color(255, 69, 0));
		tituloLbl.setSize(205, 15);
		tituloLbl.setLocation((panelForm.getWidth()/2-tituloLbl.getWidth()/2), 10);
		panelForm.add(tituloLbl);
		
		JLabel infoLbl = new JLabel("Inserte el id de la sede a modificar",JLabel.CENTER);
		infoLbl.setFont(new Font("SansSerif", Font.BOLD, 12));
		infoLbl.setForeground(new Color(255, 69, 0));
		infoLbl.setSize(205, 15);
		infoLbl.setLocation((panelForm.getWidth()/2-tituloLbl.getWidth()/2), 32);
		panelForm.add(infoLbl);
		
		/**
		 * Campo identificador de sede
		 */
		
		JLabel idLbl = new JLabel("Identificador:");
		idLbl.setBounds(20, 75, 95, 14);
		idLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelForm.add(idLbl);
		
		id_sede = new JTextField();
		id_sede.setColumns(10);
		id_sede.setBounds(111, 75, 175, 20);
		panelForm.add(id_sede);
		
		buscarIdBtn = new JButton("Buscar");
		buscarIdBtn.setBounds(316, 74, 80, 22);
		buscarIdBtn.setBackground(new Color(255, 69, 0));
		buscarIdBtn.setForeground(new Color(255, 255, 255));
		buscarIdBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelForm.add(buscarIdBtn);
		buscarIdBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ControlBase control = new ControlBase();
				try {
					verification idConsult = new verification();
					if (!idConsult.idSintax(id_sede.getText(), id_sede)) 
					{
						String[] sedeInfo = control.buscarSede(id_sede.getText());
						nombre_sede.setText(sedeInfo[0]);
						direccion_sede.setText(sedeInfo[1]);
						
						if (sedeInfo[2].equals("Activa"))
						{
							estadoSede.setSelectedItem("Activa");
						}
						else 
						{
							estadoSede.setSelectedItem("Inactiva");
						}
					}					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});		
		
		/**
		 * Campo de nombre de sede
		 */
		JLabel nombreLbl = new JLabel("Nombre:");
		nombreLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nombreLbl.setBounds(18, 120, 57, 14);
		panelForm.add(nombreLbl);
		
		nombre_sede = new JTextField();
		nombre_sede.setColumns(10);
		nombre_sede.setBounds(111, 120, 175, 20);
		panelForm.add(nombre_sede);
		//		TextPrompt direcPlaceholder = new TextPrompt("ej. CL 1 # 2 - 3",direccion_sede);

		
		/**
		 * Campo de direccion de sede
		 */
		JLabel lblNewLabel_2 = new JLabel("Direcci\u00F3n :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(18, 165, 80, 14);
		panelForm.add(lblNewLabel_2);
		
		direccion_sede = new JTextField();
		direccion_sede.setColumns(10);
		direccion_sede.setBounds(111, 165, 213, 20);
		panelForm.add(direccion_sede);
		
		/**
		 * Campo de estado de la sede
		 */
		JLabel estadoLbl = new JLabel("Estado :");
		estadoLbl.setBounds(18, 210, 128, 17);
		estadoLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelForm.add(estadoLbl);
		
		estadoSede = new JComboBox<String>();
		estadoSede.setBounds(111, 210, 153, 22);
		estadoSede.addItem("Activa");
		estadoSede.addItem("Inactiva");
		panelForm.add(estadoSede);
		
		/**
		 * Panel de botones enviar y volver
		 */	
		panelBtns = new JPanel();
		panelBtns.setBounds(121, 400, 400, 36);
		//panelBtns.setBackground(Color.BLUE);
		panelBtns.setLayout(null);
		panelBtns.setLocation(panelForm.getLocation().x,
							  panelForm.getLocation().y+panelForm.getHeight()+50);
		frame.add(panelBtns);		
		
		modificarBtn = new JButton("ACTUALIZAR");
		modificarBtn.setBounds(280, 7, 114, 23);
		modificarBtn.setBackground(new Color(255, 69, 0));
		modificarBtn.setForeground(new Color(255, 255, 255));
		modificarBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBtns.add(modificarBtn);
		modificarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					validarCampos();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		volverBtn = new JButton("VOLVER");
		volverBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		volverBtn.setBounds(0, 0, 95, 36);
		panelBtns.add(volverBtn);
		volverBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				sedesMenu sedemenu = new sedesMenu(idUser);
			}
		});
		
		/*Labels de error en el campo*/
		
		/*JLabel Empty fields*/
		emptyFieldErrorLbl = new JLabel("<html>Todos los campos deben de ser llenados</html>");
		emptyFieldErrorLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		emptyFieldErrorLbl.setForeground(Color.red);
		emptyFieldErrorLbl.setBounds(50, 240, 300, 30);
		emptyFieldErrorLbl.setVisible(false);
		panelForm.add(emptyFieldErrorLbl);
		
	}
	
	private void validarCampos() throws SQLException 
	{
		verification ver = new verification();
		
		String idIngresado = id_sede.getText();
		String nombreIngresado = nombre_sede.getText();
		String direccionIngresada = direccion_sede.getText();
		String estadoSeleccionado = String.valueOf(estadoSede.getSelectedItem());
		
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
		 * Validar que el formato de id es correcto y existe
		 */
		boolean idError = false;
		idError= ver.idSintax(idIngresado, id_sede);
		
		/**
		 * Validar nombre de solo letras, de minimo 8 caracteres
		 */
		boolean nombreError = false;
		if(!(ver.contieneSoloLetras(nombreIngresado)
				&& (nombreIngresado.replace(" ", "").length()>=8))) 
		{
			///nombreErrorLbl.setVisible(true);
			nombreError = true;
			nombre_sede.setText("");
			TextPrompt 	nombreSintaxError = new TextPrompt("Solo letras, mayor a 8 caracteres.",nombre_sede,Show.FOCUS_LOST);
			nombreSintaxError.setShowPromptOnce(true);
			nombreSintaxError.setFont(new Font("Tahoma", Font.PLAIN, 13));
			nombreSintaxError.setForeground(Color.red);
			
		}
		
		if(!(emptyFieldError == true
				|| nombreError == true
				|| idError == true)) 
		{
			//Caso de que no exista ningun error- Se inserta en la base
			ControlBase control = new ControlBase();
			control.modificarSede(nombreIngresado, direccionIngresada, idIngresado,estadoSeleccionado);
			JOptionPane.showMessageDialog(null, "Sede modificada correctamente");
			nombre_sede.setText("");
			direccion_sede.setText("");
			id_sede.setText("");
			
		}
		
		
		
	}
	

}
