package interlentisimo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.Box;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextPane;

public class impuestoPaquete {

	JFrame frmCheckout;
	private JTextField preciototaltxt;
	private JTextField valordeclaradotxt;
	private JTextField costosegurotxt;
	private ControlBase control;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public impuestoPaquete(String idUser,int idEnvio) {
		initialize(idUser,idEnvio);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param idEnvio 
	 * @param idUser 
	 */
	private void initialize(String idUser, int idEnvio) {
		frmCheckout = new JFrame();
		frmCheckout.setTitle("Checkout");
		frmCheckout.setBounds(100, 100, 800, 600);
		frmCheckout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCheckout.getContentPane().setLayout(null);
		
		ControlBase control = new ControlBase();
		JPanel panel = new JPanel();
		panel.setBounds(290, 52, 204, 34);
		frmCheckout.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Resumen del env\u00EDo");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(234, 129, 364, 123);
		frmCheckout.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Subtotal \r\n\r\n excluyendo IVA  :");
		lblNewLabel_1.setBounds(10, 16, 195, 33);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("IVA  :");
		lblNewLabel_1_1_1.setBounds(10, 81, 77, 20);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_1_1_1);
		
		JTextPane subtotaltext = new JTextPane();
		subtotaltext.setBounds(215, 27, 139, 20);
		panel_1.add(subtotaltext);
		subtotaltext.setText(control.selectSubtotal(idEnvio));
		
		JTextPane ivatext = new JTextPane();
		ivatext.setText((String) null);
		ivatext.setBounds(215, 81, 139, 20);
		panel_1.add(ivatext);
		String totaly = control.selectSubtotal(idEnvio);
		int casiiva = Integer.parseInt(totaly);
		int iva = (int) (casiiva*0.19);
		String iva_1 = iva+"";
		ivatext.setText(iva_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(308, 447, 184, 34);
		frmCheckout.getContentPane().add(panel_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Total  :");
		panel_2.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		preciototaltxt = new JTextField();
		preciototaltxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_2.add(preciototaltxt);
		preciototaltxt.setEditable(false);
		preciototaltxt.setColumns(10);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(267, 285, 279, 133);
		frmCheckout.getContentPane().add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Valor declarado  :");
		lblNewLabel_1_1_1_1_1.setBounds(16, 5, 126, 20);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2_1.add(lblNewLabel_1_1_1_1_1);
		
		valordeclaradotxt = new JTextField();
		valordeclaradotxt.setBounds(147, 5, 111, 20);
		valordeclaradotxt.setColumns(10);
		panel_2_1.add(valordeclaradotxt);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalGlue.setBounds(117, 41, 0, 0);
		panel_2_1.add(verticalGlue);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Costo seguro :");
		lblNewLabel_1_1_2.setBounds(17, 70, 104, 20);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2_1.add(lblNewLabel_1_1_2);
		
		costosegurotxt = new JTextField();
		costosegurotxt.setBounds(148, 72, 86, 20);
		costosegurotxt.setEditable(false);
		costosegurotxt.setColumns(10);
		panel_2_1.add(costosegurotxt);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Adquirir seguro  :");
		lblNewLabel_1_1_1_1_1_1.setBounds(16, 102, 127, 20);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2_1.add(lblNewLabel_1_1_1_1_1_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("S\u00ED");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton.setBounds(148, 99, 46, 23);
		panel_2_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rdbtnNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNo.setBounds(196, 99, 47, 23);
		panel_2_1.add(rdbtnNo);
		
		JButton btnNewButton = new JButton("Calcular seguro");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnNewButton.setBounds(50, 36, 148, 23);
		panel_2_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Procesar Compra");
		btnNewButton_1.setBackground(new Color(255, 69, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(314, 501, 156, 34);
		frmCheckout.getContentPane().add(btnNewButton_1);
		
		JButton Volverbutton = new JButton("VOLVER");
		Volverbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registroPaquete registro = new registroPaquete(idUser);
				registro.frame.setLocationRelativeTo(null);
			}
		});
		Volverbutton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Volverbutton.setBounds(52, 499, 95, 36);
		frmCheckout.getContentPane().add(Volverbutton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
