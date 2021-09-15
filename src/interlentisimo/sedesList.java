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

public class sedesList extends JPanel{

	public JFrame frame;
	private JTextField nombre_sede, direccion_sede, id_sede;
	private JButton volverBtn, buscarIdBtn;
	private JPanel panelForm, panelBtns;
	public JPanel mainPanel;

	/**
	 * Create the application.
	 */
	public sedesList(String idUser) {
		setBounds(0,0,800,600);
		setLayout(null);
		setBackground(Color.red);
		initialize(idUser);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String idUser) {
		
		/*
		frame = new JFrame();
		frame.setTitle("Modificar sedes");
		frame.setBounds(0, 0, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		*/

		
		mainPanel = new JPanel();
		mainPanel.setSize(400, 270);
		mainPanel.setLocation(((frame.getWidth()/2)-(panelForm.getWidth()/2)),
				              ((int)Math.round((frame.getHeight()/2)-(panelForm.getHeight()/2)*1.6)));
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.green);
		mainPanel.setVisible(true);
		this.add(mainPanel);
		
		JLabel tituloLbl = new JLabel("Actualizaci\u00F3n de sedes\r\n");
		tituloLbl.setFont(new Font("SansSerif", Font.BOLD, 18));
		tituloLbl.setForeground(new Color(255, 69, 0));
		tituloLbl.setSize(205, 15);
		tituloLbl.setLocation((panelForm.getWidth()/2-tituloLbl.getWidth()/2), 10);
		mainPanel.add(tituloLbl);
		
		JLabel infoLbl = new JLabel("Inserte el id de la sede a modificar",JLabel.CENTER);
		infoLbl.setFont(new Font("SansSerif", Font.BOLD, 12));
		infoLbl.setForeground(new Color(255, 69, 0));
		infoLbl.setSize(205, 15);
		infoLbl.setLocation((panelForm.getWidth()/2-tituloLbl.getWidth()/2), 32);
		mainPanel.add(infoLbl);
		
		/**
		 * Campo identificador de sede
		 */
		
		JLabel idLbl = new JLabel("Identificador:");
		idLbl.setBounds(20, 75, 95, 14);
		idLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mainPanel.add(idLbl);
		
		id_sede = new JTextField();
		id_sede.setColumns(10);
		id_sede.setBounds(111, 75, 175, 20);
		mainPanel.add(id_sede);
		
		
		
		
		
	}
	
}