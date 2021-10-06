package interlentisimo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MetodoDePago {

	JFrame frmSeleccionMetodoDe;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public MetodoDePago(int idEnvio) {
		initialize(idEnvio);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int idEnvio) {
		frmSeleccionMetodoDe = new JFrame();
		frmSeleccionMetodoDe.setTitle("Seleccion Metodo de Pago\r\n");
		frmSeleccionMetodoDe.setBounds(100, 100, 480, 300);
		frmSeleccionMetodoDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSeleccionMetodoDe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("METODO DE PAGO");
		lblNewLabel.setForeground(new Color(255,69,0));
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel.setBounds(173, 25, 135, 14);
		frmSeleccionMetodoDe.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("EFECTIVO");
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pago_Credito pago = new Pago_Credito(idEnvio);
				pago.frmPagoConTarjeta.setVisible(true);
				pago.frmPagoConTarjeta.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setBounds(70, 112, 89, 23);
		frmSeleccionMetodoDe.getContentPane().add(btnNewButton);
		
		JButton btnCreditodebito = new JButton("CREDITO/DEBITO");
		btnCreditodebito.setForeground(Color.WHITE);
		btnCreditodebito.setBackground(new Color(255, 69, 0));
		btnCreditodebito.setBounds(262, 112, 135, 23);
		frmSeleccionMetodoDe.getContentPane().add(btnCreditodebito);
	}
}
