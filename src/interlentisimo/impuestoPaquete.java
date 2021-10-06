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
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextPane;

public class impuestoPaquete {

	JFrame frmCheckout;
	private JTextField valordeclaradotxt;
	private ControlBase control;
	private int getIdEnvio;
	private float enviototal;
	private float iva;

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
		
		getIdEnvio = idEnvio;
		
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
		
		JTextPane ivatext = new JTextPane();
		ivatext.setText((String) null);
		ivatext.setBounds(215, 81, 139, 20);
		panel_1.add(ivatext);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(308, 439, 184, 42);
		frmCheckout.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Total  :");
		lblNewLabel_1_1_1_1.setBounds(10, 11, 52, 20);
		panel_2.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JTextPane costototal = new JTextPane();
		costototal.setBounds(72, 11, 113, 20);
		panel_2.add(costototal);
		//costototal.setText((String) null);
		
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
		
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Adquirir seguro  :");
		lblNewLabel_1_1_1_1_1_1.setBounds(16, 102, 127, 20);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2_1.add(lblNewLabel_1_1_1_1_1_1);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				costototal.setText(control.selectPreciototal(idEnvio));
			}
		});
		rdbtnNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNo.setBounds(196, 99, 47, 23);
		panel_2_1.add(rdbtnNo);
		

	
		
		JTextPane valorseguro = new JTextPane();
		valorseguro.setText((String) null);
		valorseguro.setBounds(145, 70, 113, 20);
		panel_2_1.add(valorseguro);
		
		JButton btnNewButton = new JButton("Calcular seguro");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnNewButton.setBounds(50, 36, 148, 23);
		panel_2_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Float valordeclarado = Float.parseFloat(valordeclaradotxt.getText());
				valorseguro.setText(valordeclarado*0.35+"");
			}
		});
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("S\u00ED");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Float valordeclarado = Float.parseFloat(valordeclaradotxt.getText());
					float valortotal_conseguro = valordeclarado+Integer.parseInt(control.selectSubtotal(idEnvio))+iva;
					control.actualizarPrecio(valortotal_conseguro, (float) (valordeclarado*0.35), idEnvio);
					costototal.setText(valortotal_conseguro+"");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton.setBounds(148, 99, 46, 23);
		panel_2_1.add(rdbtnNewRadioButton);
		
		
		JButton btnNewButton_1 = new JButton("Procesar Compra");
		btnNewButton_1.setBackground(new Color(255, 69, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MetodoDePago pago = new MetodoDePago(idEnvio);
				pago.frmSeleccionMetodoDe.setVisible(true);
				pago.frmSeleccionMetodoDe.setLocationRelativeTo(null);
			}
		});
		btnNewButton_1.setBounds(314, 501, 156, 34);
		frmCheckout.getContentPane().add(btnNewButton_1);
		
		JButton Volverbutton = new JButton("VOLVER");
		Volverbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registroPaquete registro = new registroPaquete(idUser);
				registro.frame.setLocationRelativeTo(null);
				registro.frame.setVisible(true);
			}
		});
		Volverbutton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Volverbutton.setBounds(52, 499, 95, 36);
		frmCheckout.getContentPane().add(Volverbutton);
		
		JButton buscarBtn = new JButton("Buscar:");
		buscarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String totaly = control.selectSubtotal(idEnvio);
				float casiiva = Float.parseFloat(totaly);
				float iva = (float) (casiiva*0.19);
				String iva_1 = iva+"";
				ivatext.setText(iva_1);
				subtotaltext.setText(control.selectSubtotal(idEnvio));
			}
		});
		buscarBtn.setForeground(Color.WHITE);
		buscarBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		buscarBtn.setBackground(new Color(255, 69, 0));
		buscarBtn.setBounds(644, 152, 95, 20);
		frmCheckout.getContentPane().add(buscarBtn);
	
	}
	
	public void costoTotalSeguro(float subtotal, float iva, float seguro) {	
		enviototal = subtotal+iva+seguro;
	}
}
