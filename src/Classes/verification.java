package Classes;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;

import Classes.TextPrompt.Show;
import interlentisimo.ControlBase;

public class verification {
	
	public verification() 
	{
		
	}
	
	/**
	 * Metodo para validar campos de solo letras, de minimo n caracteres
	 * Retorna un valor de tipo boolean en el caso de que cumpla o no
	 */
	public boolean minimoCaracteres(String cadena, int min) 
	{
		if(cadena.replace(" ", "").length()>=min) 
		{
			return true;
		}
		return false;
	}
	
	public boolean contieneSoloLetras(String cadena) 
	{
	    for (int x = 0; x < cadena.length(); x++) 
	    {
	        char c = cadena.charAt(x);
	        // Si no está entre a y z, ni entre A y Z, ni es un espacio
	        if (!((c >= 'a' && c <= 'z') 
	        		|| (c >= 'A' && c <= 'Z') 
	        		|| c == ' ')) 
	        {
	            return false;
	        }
	    }
	    return true;
	}
	
	public boolean idSintax(String idIngresado, JTextField idField) throws SQLException
	{
		Pattern idPattern = Pattern.compile("^S"+"([0-9]{3,3})$");

		if(idIngresado.length()>0) 
		{
			Matcher mather = idPattern.matcher(idIngresado);
			
			if(mather.find() == true) 
				
			{
				ControlBase control = new ControlBase();
				if(control.idSedeExist(idIngresado)) 
				{
					return false;
				} else 
				{
					
					idField.setText("");
					TextPrompt 	idNotExistsError = new TextPrompt("Id no registrado",idField, Show.FOCUS_LOST);
					idNotExistsError.setShowPromptOnce(true);
					idNotExistsError.setFont(new Font("Tahoma", Font.PLAIN, 13));
					idNotExistsError.setForeground(Color.red);
					return true;
				}
				
				
			} else 
			{
				idField.setText("");
				TextPrompt 	idSintaxError = new TextPrompt("Formato de id inválido",idField, Show.FOCUS_LOST);
				idSintaxError.setShowPromptOnce(true);
				idSintaxError.setFont(new Font("Tahoma", Font.PLAIN, 13));
				idSintaxError.setForeground(Color.red);
				return true;
			}
		} 
		return false;
	}
}
