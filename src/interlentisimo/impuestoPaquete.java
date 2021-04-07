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

public class impuestoPaquete {

	private JFrame frmCheckout;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					impuestoPaquete window = new impuestoPaquete();
					window.frmCheckout.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public impuestoPaquete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCheckout = new JFrame();
		frmCheckout.setTitle("Checkout");
		frmCheckout.setBounds(100, 100, 800, 600);
		frmCheckout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCheckout.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(290, 52, 204, 34);
		frmCheckout.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Resumen del env\u00EDo");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(234, 129, 316, 123);
		frmCheckout.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Subtotal \r\n\r\n excluyendo IVA  :");
		lblNewLabel_1.setBounds(10, 16, 195, 33);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(220, 24, 86, 20);
		textField.setEditable(false);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Costo env\u00EDo :");
		lblNewLabel_1_1.setBounds(10, 50, 94, 20);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(220, 52, 86, 20);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("IVA  :");
		lblNewLabel_1_1_1.setBounds(10, 81, 77, 20);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(220, 83, 86, 20);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		panel_1.add(textField_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(308, 447, 184, 34);
		frmCheckout.getContentPane().add(panel_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Total  :");
		panel_2.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_3 = new JTextField();
		panel_2.add(textField_3);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(267, 285, 249, 133);
		frmCheckout.getContentPane().add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Valor declarado  :");
		lblNewLabel_1_1_1_1_1.setBounds(16, 5, 126, 20);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2_1.add(lblNewLabel_1_1_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(147, 5, 86, 20);
		textField_4.setColumns(10);
		panel_2_1.add(textField_4);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalGlue.setBounds(117, 41, 0, 0);
		panel_2_1.add(verticalGlue);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Costo seguro :");
		lblNewLabel_1_1_2.setBounds(17, 70, 104, 20);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2_1.add(lblNewLabel_1_1_2);
		
		textField_5 = new JTextField();
		textField_5.setBounds(148, 72, 86, 20);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		panel_2_1.add(textField_5);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Adquirir seguro  :");
		lblNewLabel_1_1_1_1_1_1.setBounds(16, 102, 127, 20);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2_1.add(lblNewLabel_1_1_1_1_1_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("S\u00ED");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton.setBounds(148, 99, 46, 23);
		panel_2_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
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
		
		JButton btnNewButton_1_1 = new JButton("VOLVER");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(52, 499, 95, 36);
		frmCheckout.getContentPane().add(btnNewButton_1_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
