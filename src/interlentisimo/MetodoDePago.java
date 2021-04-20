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

	private JFrame frmSeleccionMetodoDe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MetodoDePago window = new MetodoDePago();
					window.frmSeleccionMetodoDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MetodoDePago() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
