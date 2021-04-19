package interlentisimo;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SedeInfoMod {

	private JFrame frmInformacinUsuario;
	private JTextField direccion_sede;
	private JTextField nombre_sede;
	private JTextField ciudad_sede;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SedeInfoMod window = new SedeInfoMod();
					window.frmInformacinUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SedeInfoMod() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInformacinUsuario = new JFrame();
		frmInformacinUsuario.setTitle("Actualizacion de informacion sedes");
		frmInformacinUsuario.setBounds(100, 100, 483, 337);
		frmInformacinUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInformacinUsuario.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(61, 55, 348, 189);
		frmInformacinUsuario.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		direccion_sede = new JTextField();
		direccion_sede.setColumns(10);
		direccion_sede.setBounds(111, 79, 213, 20);
		panel_1.add(direccion_sede);
		
		JComboBox<String> estado_sede = new JComboBox<String>();
		estado_sede.setBounds(111, 139, 153, 22);
		estado_sede.addItem("");
		estado_sede.addItem("Activo");
		estado_sede.addItem("Inactivo");
		panel_1.add(estado_sede);
		
		JLabel lblNewLabel_1_2 = new JLabel("Estado :");
		lblNewLabel_1_2.setBounds(18, 140, 128, 17);
		panel_1.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(18, 30, 57, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Ciudad:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(18, 55, 57, 14);
		panel_1.add(lblNewLabel_3);
		
		nombre_sede = new JTextField();
		nombre_sede.setColumns(10);
		nombre_sede.setBounds(111, 29, 175, 20);
		panel_1.add(nombre_sede);
		
		ciudad_sede = new JTextField();
		ciudad_sede.setColumns(10);
		ciudad_sede.setBounds(111, 55, 175, 20);
		panel_1.add(ciudad_sede);
		
		JLabel lblNewLabel_2 = new JLabel("Direcci\u00F3n :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(18, 80, 80, 14);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(121, 10, 200, 34);
		frmInformacinUsuario.getContentPane().add(panel);
		
		JLabel lblActualizacinDeSedes = new JLabel("Actualizaci\u00F3n de sedes\r\n");
		lblActualizacinDeSedes.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblActualizacinDeSedes.setForeground(new Color(255, 69, 0));
		panel.add(lblActualizacinDeSedes);
		
		JButton btnNewButton = new JButton("ACTUALIZAR");
		btnNewButton.setBounds(324, 255, 114, 23);
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 15));
		frmInformacinUsuario.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}
}
