package interlentisimo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

public class registroSede {

	private JFrame frmRegistroSedes;
	private JTextField nombre_sede;
	private JTextField direccion_sede;
	private JTextField id_sede, ciudad_sede;
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registroSede window = new registroSede();
					window.frmRegistroSedes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public registroSede() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistroSedes = new JFrame();
		frmRegistroSedes.setTitle("Registro sedes");
		frmRegistroSedes.setBounds(100, 100, 469, 359);
		frmRegistroSedes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroSedes.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(34, 71, 57, 14);
		frmRegistroSedes.getContentPane().add(lblNewLabel_1);
		
		nombre_sede = new JTextField();
		nombre_sede.setBounds(116, 70, 132, 20);
		frmRegistroSedes.getContentPane().add(nombre_sede);
		nombre_sede.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Direccion");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(34, 128, 80, 14);
		frmRegistroSedes.getContentPane().add(lblNewLabel_2);
		
		direccion_sede = new JTextField();
		direccion_sede.setBounds(116, 127, 245, 20);
		frmRegistroSedes.getContentPane().add(direccion_sede);
		direccion_sede.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Identificador\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(34, 187, 80, 14);
		frmRegistroSedes.getContentPane().add(lblNewLabel_3);
		
		id_sede = new JTextField();
		id_sede.setBounds(116, 186, 132, 20);
		frmRegistroSedes.getContentPane().add(id_sede);
		
		id_sede.setColumns(10);
		JLabel lblNewLabel_4 = new JLabel("Ciudad:\r\n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(34, 237, 80, 14);
		frmRegistroSedes.getContentPane().add(lblNewLabel_4);
		
		ciudad_sede = new JTextField();
		ciudad_sede.setBounds(116, 237, 132, 20);
		frmRegistroSedes.getContentPane().add(ciudad_sede);
		ciudad_sede.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(330, 256, 89, 23);
		frmRegistroSedes.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(124, 11, 192, 34);
		frmRegistroSedes.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Registro de sedes");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 69, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 56, 359, 187);
		frmRegistroSedes.getContentPane().add(panel_1);
	}
}
