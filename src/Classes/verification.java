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
	public static Pattern FORMATO_SEDE= Pattern.compile("^S"+"([0-9]{3,3})$");
	public static Pattern FORMATO_EMAIL = Pattern.compile("^(.+)@(.+)$");
	public static Pattern FORMATO_CONTRASEÑA = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");
	public static Pattern FORMATO_TARJETA = Pattern.compile("^(5[1-5][0-9]{14}|2(22[1-9][0-9]{12}|2[3-9][0-9]{13}|[3-6][0-9]{14}|7[0-1][0-9]{13}|720[0-9]{12}))$");
	public static Pattern FORMATO_FECHA= Pattern.compile("^([0-9]{2,2})$");
	public static Pattern FORMATO_CVV= Pattern.compile("^([0-9]{3,4})$");
	
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
	
	public boolean emailSintax(Pattern patron, String text) throws SQLException{
		Matcher mather = patron.matcher(text);
		if ((text.length()>0) && (mather.find() == true))
		{				
			return true;
		}
	return false;
	}
	
	public boolean passwSintax(Pattern patron, String text) throws SQLException{
		Matcher mather = patron.matcher(text);
		if ((text.length()>0) && (mather.find() == true))
		{				
			return true;
		}
	return false;
	}
	
	public boolean cardSintax(Pattern patron, String text) throws SQLException{
		Matcher mather = patron.matcher(text);
		if ((text.length()>0) && (mather.find() == true))
		{				
			return true;
		}
	return false;
	}
	
	public boolean dateSintax(Pattern patron, String text) throws SQLException{
		Matcher mather = patron.matcher(text);
		if ((text.length()>0) && (mather.find() == true))
		{				
			return true;
		}
	return false;
	}
	
	public boolean cvvSintax(Pattern patron, String text) throws SQLException{
		Matcher mather = patron.matcher(text);
		if ((text.length()>0) && (mather.find() == true))
		{				
			return true;
		}
	return false;
	}
}
