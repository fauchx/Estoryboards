package interlentisimo;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;

//import com.sun.java.swing.plaf.motif.MotifComboBoxUI.ComboBoxLayoutManager;

import Classes.TextPrompt;
import Classes.verification;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class Pago_Credito {

	JFrame frmPagoConTarjeta;
	private JTextField tfcard_num;
	private JTextField tfcard_name;
	private JTextField tfexp_datem;
	private JTextField tfexp_datey;
	private JTextField tfsec_code;
	private JTextField tfid_num;
	private JComboBox cBox_kid;
	
	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public Pago_Credito(int idEnvio) {
		initialize(idEnvio);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int idEnvio) {
		frmPagoConTarjeta = new JFrame();
		frmPagoConTarjeta.setTitle("Pago con tarjeta\r\n");
		frmPagoConTarjeta.setBounds(100, 100, 600, 400);
		frmPagoConTarjeta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPagoConTarjeta.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PAGO CON TARJETA\r\n");
		lblNewLabel.setForeground(new Color(255,69,0));
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel.setBounds(215, 11, 157, 27);
		frmPagoConTarjeta.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero de tarjeta:\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(40, 90, 134, 14);
		frmPagoConTarjeta.getContentPane().add(lblNewLabel_1);
		
		tfcard_num = new JTextField();
		tfcard_num.setBounds(184, 87, 200, 20);
		frmPagoConTarjeta.getContentPane().add(tfcard_num);
		tfcard_num.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre y apellido:\r\n");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(40, 154, 134, 14);
		frmPagoConTarjeta.getContentPane().add(lblNewLabel_1_1);
		
		tfcard_name = new JTextField();
		tfcard_name.setColumns(10);
		tfcard_name.setBounds(184, 152, 232, 20);
		frmPagoConTarjeta.getContentPane().add(tfcard_name);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Fecha expiracion:\r\n");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(40, 227, 134, 14);
		frmPagoConTarjeta.getContentPane().add(lblNewLabel_1_1_1);
		
		tfexp_datem = new JTextField();
		tfexp_datem.setBounds(184, 225, 43, 20);
		frmPagoConTarjeta.getContentPane().add(tfexp_datem);
		tfexp_datem.setColumns(10);
		
		tfexp_datey = new JTextField();
		tfexp_datey.setBounds(232, 225, 43, 20);
		frmPagoConTarjeta.getContentPane().add(tfexp_datey);
		tfexp_datey.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Codigo seguridad\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(305, 228, 111, 17);
		frmPagoConTarjeta.getContentPane().add(lblNewLabel_2);
		
		tfsec_code = new JTextField();
		tfsec_code.setBounds(426, 225, 86, 20);
		frmPagoConTarjeta.getContentPane().add(tfsec_code);
		tfsec_code.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo documento\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(39, 291, 111, 14);
		frmPagoConTarjeta.getContentPane().add(lblNewLabel_3);
		
		cBox_kid = new JComboBox();
		cBox_kid.setModel(new DefaultComboBoxModel(new String[] {"", "C.C", "T.I", "C.E"}));
		cBox_kid.setToolTipText("");
		cBox_kid.setBounds(184, 288, 86, 22);
		frmPagoConTarjeta.getContentPane().add(cBox_kid);
		
		JLabel lblNewLabel_4 = new JLabel("Numero\r\n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(305, 292, 79, 14);
		frmPagoConTarjeta.getContentPane().add(lblNewLabel_4);
		
		tfid_num = new JTextField();
		tfid_num.setBounds(394, 289, 118, 20);
		frmPagoConTarjeta.getContentPane().add(tfid_num);
		tfid_num.setColumns(10);
		
		JButton btnNewButton_1_1 = new JButton("VOLVER");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(470, 11, 95, 36);
		frmPagoConTarjeta.getContentPane().add(btnNewButton_1_1);
		
		JButton okButton = new JButton("OK");
		okButton.setBackground(new Color(255, 69, 0));
		okButton.setForeground(new Color(255, 255, 255));
		okButton.setBounds(470, 315, 95, 36);
		frmPagoConTarjeta.getContentPane().add(okButton);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					validarcampos();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
	
	}
	
	private void validarcampos() throws SQLException
	{
		ControlBase control = new ControlBase();
		verification ver = new verification();
//-----------------------------------------
		String card_num = tfcard_num.getText();
		String card_name = tfcard_name.getText();
		String exp_datem = tfexp_datem.getText();
		String exp_datey = tfexp_datey.getText();
		String sec_code = tfsec_code.getText();
		String id_num = tfid_num.getText();
		String  k_id= cBox_kid.getSelectedItem().toString();
		
//---------------------------------------------		
		ArrayList <String> fields = new ArrayList <String>();
		fields.add(card_num);
		fields.add(card_name);
		fields.add(exp_datem);
		fields.add(exp_datey);
		fields.add(sec_code);
		fields.add(id_num);
		fields.add(k_id);
		
//--------------------------------------------------
		boolean emptyFieldError = !ver.filledFields(fields);
			if (emptyFieldError)
			{
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
			}
			
//--------------------------------------------
		boolean cardError = false;
			if(!ver.cardSintax(ver.FORMATO_TARJETA, card_num)) {
				tfcard_num.setText("");
				TextPrompt cardph = new TextPrompt("Número de tarjeta incorrecto",tfcard_num);
				cardError = true;
			}
			
//--------------------------------------------
		boolean datemError = false;
			if(!ver.dateSintax(ver.FORMATO_FECHA, exp_datem)) {
				tfexp_datem.setText("");
				TextPrompt datemph = new TextPrompt("MM",tfexp_datem);
				datemError = true;
			}
			
//--------------------------------------------
		boolean dateyError = false;
			if(!ver.dateSintax(ver.FORMATO_FECHA, exp_datey)) {
				tfexp_datey.setText("");
				TextPrompt dateyph = new TextPrompt("YY",tfexp_datey);
				dateyError = true;
			}
	
//--------------------------------------------
		boolean cvvError = false;
			if(!ver.dateSintax(ver.FORMATO_CVV, sec_code)) {
				tfsec_code.setText("");
				TextPrompt cvvph = new TextPrompt("CVV",tfsec_code);
				cvvError = true;
			}
			
//----------------------------------------------
		boolean idError = false;
			if(!ver.minimoCaracteres(id_num, 6)){
				tfid_num.setText("");
				TextPrompt idph = new TextPrompt("Número de digitos insuficientes",tfid_num);
				idError = true;
			}
			
			
		if(!(emptyFieldError || cardError || datemError || dateyError || cvvError || idError)) {
				control.cardRegist(card_num, card_name, sec_code, 
				k_id, id_num, exp_datem, exp_datey);	    
				tfcard_num.setText("");
				tfcard_name.setText("");
				tfexp_datem.setText("");
				tfexp_datey.setText("");
				tfsec_code.setText("");
				tfid_num.setText("");
				JOptionPane.showMessageDialog(null, "Registro efectivo");
				//lblNewLabel_2.setVisible(true);
		  }
		
			
			
	}
	
	
}
