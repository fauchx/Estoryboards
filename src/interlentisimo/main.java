/*
 * Main
 * Permite el despliege de la app
 * 09/05/2021
 * Copyright Izquierdo José, Moreno Brian, Urrutia Fabián
 */

package interlentisimo;
import java.awt.EventQueue;


/**
 * Launch the application
 * @author Brian Moreno
 *
 */
public class main 
{
	
	public static void main(String[] args) 
	{
			EventQueue.invokeLater(new Runnable() 
			{
				public void run() 
				{
					try 
					{
						login window = new login();
						window.frame.setVisible(true);
						
					} catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			});
	}
}