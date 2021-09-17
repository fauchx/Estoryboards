package Classes;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ListIterator;
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
	
	/**
	 * Validar que todos los campos han sido llenados
	 */
	public boolean filledFields(ArrayList<String> listFields) 
	{		
		ListIterator<String> iteratorFields = listFields.listIterator();
		while(iteratorFields.hasNext()) {
			String field= iteratorFields.next();
			if (field.length()==0) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 *Validar que un string ingresado cumpla con la regla sintactica del 
	 *patron ingresado 
	 */
	public boolean idSintax(Pattern patron,String text) throws SQLException
	{
			Matcher mather = patron.matcher(text);
			
			if ((text.length()>0) && (mather.find() == true))
			{				
				return true;
			}
		return false;
	}
	
	
}
