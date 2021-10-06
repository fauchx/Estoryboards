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
import java.util.ArrayList;

import Classes.TextPrompt;

public class SedeInfoMod {

	public JFrame frame;
	private JTextField nombre_sede, direccion_sede, id_sede;
	private JButton volverBtn, modificarBtn, buscarIdBtn;
	private JComboBox<String> estadoSede;
	private JPanel panelForm, panelBtns;
	private JLabel emptyFieldErrorLbl;
	private TextPrompt idPh, direccionPh, nombrePh;

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
		idPh = new TextPrompt("",id_sede);
		idPh.changeAlpha(0.75f);
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
					verification ver = new verification();
					if (control.idSedeExist(id_sede.getText()))
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
					}else 
					{
						id_sede.setText("");
						idPh=new TextPrompt("Sede no existe",id_sede);
						idPh.changeAlpha(0.75f);
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
		nombrePh = new TextPrompt("",nombre_sede);
		nombrePh.changeAlpha(0.75f);
		panelForm.add(nombre_sede);
		
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
		direccionPh = new TextPrompt("",direccion_sede);
		direccionPh.changeAlpha(0.75f);
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
				sedemenu.frame.setLocationRelativeTo(frame);
			}
		});
		
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
		ControlBase control = new ControlBase();
		
		String idIngresado = id_sede.getText();
		String nombreIngresado = nombre_sede.getText();
		String direccionIngresada = direccion_sede.getText();
		String estadoSeleccionado = String.valueOf(estadoSede.getSelectedItem());
		
		ArrayList <String> fields = new ArrayList <String>();
		fields.add(idIngresado);
		fields.add(nombreIngresado);
		fields.add(direccionIngresada);
		
		/**
		 * Validar que todos los campos han sido llenados
		 */
		boolean emptyFieldError = !ver.filledFields(fields);
		if (emptyFieldError)
		{
			emptyFieldErrorLbl.setVisible(true);
		}
		
	

		/**
		 * Validar que el formato de id es correcto y existe
		 */
		boolean idError = false;
		if(ver.idSintax(ver.FORMATO_SEDE, idIngresado)) 
		{
			if (!control.idSedeExist(idIngresado)) {
				id_sede.setText("");
				idPh.setText("Sede no existe");
				idPh.changeAlpha(0.75f);
				idError = true;
			}
		}else 
		{
			id_sede.setText("");
			idPh.setText("Sintaxis incorrecta");
			idPh.changeAlpha(0.75f);
			idError = true;
		}
		
		/**
		 * Validar nombre de solo letras, de minimo 8 caracteres
		 */
		boolean nombreError = false; 
		int n=3;
		if(!(ver.contieneSoloLetras(nombreIngresado)
				&& (ver.minimoCaracteres(nombreIngresado, n)))) 
		{
			nombre_sede.setText("");
			nombrePh.setText("Usar "+n+" letras como mínimo");
			nombreError = true;
		}
		
		
		if(!(emptyFieldError || nombreError || idError)) 
		{
			//Caso de que no exista ningun error- Se modifica en la base
			control.modificarSede(nombreIngresado, direccionIngresada, idIngresado,estadoSeleccionado);
			JOptionPane.showMessageDialog(null, "Sede modificada correctamente");
			nombre_sede.setText("");
			nombrePh.setText("");
			direccion_sede.setText("");
			direccionPh.setText("");
			id_sede.setText("");
			idPh.setText("");
		}else {
			System.out.println("error "+emptyFieldError+" "+nombreError+" "+idError);;
		}
		
		
		
	}
	

}
