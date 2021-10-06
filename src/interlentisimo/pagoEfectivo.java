package interlentisimo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class pagoEfectivo extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public pagoEfectivo(int idEnvio) {
		setTitle("Pago en efectivo");
		setBounds(100, 100, 350, 240);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblPagoContraEntrega = new JLabel("PAGO CONTRA ENTREGA");
			lblPagoContraEntrega.setBounds(16, 27, 302, 32);
			contentPanel.add(lblPagoContraEntrega);
			lblPagoContraEntrega.setForeground(new Color(0, 128, 0));
			lblPagoContraEntrega.setFont(new Font("SansSerif", Font.BOLD, 24));
			lblPagoContraEntrega.setBackground(new Color(34, 139, 34));
		}
		{
			JLabel lblNewLabel = new JLabel("<html>El cobro por el env\u00EDo del paquete \r se realizar\u00E1 contra entrega, es decir, \r el destinatario deber\u00E1 hacer el pago de este.</html>");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(65, 70, 203, 72);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(new Color(255, 69, 0));
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBackground(new Color(255, 69, 0));
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
