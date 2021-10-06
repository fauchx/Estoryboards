package interlentisimo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class recibo {

	private JFrame frmVerificacin;

	/**
	 * Create the application.
	 */
	public recibo(String idEnvio) {
		initialize(idEnvio);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String idEnvio) {
		frmVerificacin = new JFrame();
		frmVerificacin.setTitle("Verificaci\u00F3n");
		frmVerificacin.setBounds(100, 100, 350, 240);
		frmVerificacin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVerificacin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00A1PAGO EXITOSO!");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblNewLabel.setBackground(new Color(34, 139, 34));
		lblNewLabel.setBounds(38, 31, 258, 48);
		frmVerificacin.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Generar recibo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlBase control = new ControlBase();
				try {
					String [] datos=control.getDatosFactura(idEnvio);
					facturaPdf recibo = new facturaPdf(datos);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(97, 119, 139, 35);
		frmVerificacin.getContentPane().add(btnNewButton);
	}
}
