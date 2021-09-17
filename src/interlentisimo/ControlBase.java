package interlentisimo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
 //fauchx el bicho
//kk

public class ControlBase {
	JFrame frame;
	private Connection conexion = null;
	private String pass = "ziRtszHrvfZ8rEAaY_PVNQ2LpmUeQF50";
	private String user = "qhqysnst";
	private String comprobarlogin , consultaCargo;
	
	public void conectarme() {
		try {
		Class.forName("org.postgresql.Driver");
		conexion = DriverManager.getConnection("jdbc:postgresql://queenie.db.elephantsql.com/qhqysnst",user,pass);
	} catch (SQLException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public  boolean buscarusuario(String id, String contraseña) throws SQLException {
		PreparedStatement p = null;
		ResultSet result = null;
		conectarme();
		try {
			comprobarlogin = "SELECT identificación_u,contraseña_u from usuarios where identificación_u = '"+id+"' and contraseña_u = '"+contraseña+"'";
			p = conexion.prepareStatement(comprobarlogin);
			result = p.executeQuery();
			while(result.next()) {
				id = result.getString("identificación_u");
				contraseña = result.getString("contraseña_u");
				return true;
			  }		
			
		} finally {
	        if (result != null) try { result.close(); } catch (SQLException logOrIgnore) {}
	        if (conexion != null) try { conexion.close(); } catch (SQLException logOrIgnore) {}
	    }
		return false;
	}
	
	public String getCargo(String id) throws SQLException {
		PreparedStatement pst = null;
		ResultSet result = null;
		conectarme();
		try 
		{
			pst = conexion.prepareStatement("SELECT cargo_u FROM usuarios WHERE identificación_u =?");
			pst.setString(1, id);
			result = pst.executeQuery();
			String cargo = null;
			while(result.next()){
				cargo = result.getString("cargo_u");
			}
			return cargo;
		}
		finally 
		{
			if (result != null) try { result.close(); } catch (SQLException logOrIgnore) {}
			if (conexion != null) try { conexion.close(); } catch (SQLException logOrIgnore) {}
		
		}
		
	}

	public boolean idSedeExist(String idIngresado) throws SQLException 
	{
		PreparedStatement pst = null;
		ResultSet result = null;
		conectarme();
		try 
		{
			pst = conexion.prepareStatement("SELECT * FROM sede WHERE identificador_sede = ?",
					ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			pst.setString(1, idIngresado);
			result = pst.executeQuery();
			boolean idExiste = result.first();
			return idExiste;
		}
		finally 
		{
			if (result != null) try { result.close(); } catch (SQLException logOrIgnore) {}
			if (conexion != null) try { conexion.close(); } catch (SQLException logOrIgnore) {}
		
		}
	}
	
	public void insertarSede(String nombreIngresado, String direccionIngresada, String idIngresado) throws SQLException 
	{
		PreparedStatement pst = null;
		ResultSet result = null;
		conectarme();
		try 
		{
			pst = conexion.prepareStatement("INSERT INTO sede (identificador_sede, nombre_sede, estado_sede, direccion_sede) VALUES (?,?,'Inactiva',?)");
			pst.setString(1, idIngresado);
			pst.setString(2, nombreIngresado);
			pst.setString(3, direccionIngresada);
			pst.executeUpdate();
		}
		finally 
		{
			if (conexion != null) try { conexion.close(); } catch (SQLException logOrIgnore) {}
			
		}
	}
	
	public String consultarSede(String idIngresado) throws SQLException 
	{
		PreparedStatement pst = null;
		ResultSet result = null;
		String nombreSede = null;
		conectarme();
		try 
		{
			pst = conexion.prepareStatement("SELECT * FROM sede where identificador_sede=?");
			pst.setString(1, idIngresado);
			result = pst.executeQuery();
			while(result.next()) {
				nombreSede = result.getString("nombre_sede");
			}
		} 
		catch (SQLException sqle) 
		{
			System.out.println("Código de Error: " + sqle.getErrorCode() + "\n" +
			  		   "SLQState: " + sqle.getSQLState() + "\n" +
			  		   "Mensaje: " + sqle.getMessage() + "\n");
		}
		finally 
		{
			if (conexion != null) try { conexion.close(); } catch (SQLException logOrIgnore) {}
			if (result != null) try { result.close(); } catch (SQLException logOrIgnore) {}
		}
		return nombreSede;
	}
	
	public void borrarSede(String idIngresado) throws SQLException 
	{
		PreparedStatement pst = null;
		conectarme();
		try 
		{
			pst = conexion.prepareStatement("DELETE FROM sede where identificador_sede=?");
			pst.setString(1, idIngresado);
			pst.executeQuery();
		} 
		catch (SQLException sqle) 
		{
			System.out.println("Código de Error: " + sqle.getErrorCode() + "\n" +
			  		   "SLQState: " + sqle.getSQLState() + "\n" +
			  		   "Mensaje: " + sqle.getMessage() + "\n");
		}
		finally 
		{
			if (conexion != null) try { conexion.close(); } catch (SQLException logOrIgnore) {}
		}
	}
	
	public void modificarSede (String nombreIngresado, String direccionIngresada, String idIngresado, String estado) throws SQLException 
	{
		PreparedStatement pst = null;
		ResultSet result = null;
		conectarme();
		try 
		{
			pst = conexion.prepareStatement("UPDATE sede SET nombre_sede=?,estado_sede=?,direccion_sede=? WHERE identificador_sede=?");
			pst.setString(1, nombreIngresado);
			pst.setString(2, estado);
			pst.setString(3, direccionIngresada);
			pst.setString(4, idIngresado);
			pst.executeUpdate();
		}
		finally 
		{
			if (conexion != null) try { conexion.close(); } catch (SQLException logOrIgnore) {}
		
		}
		
	}
	
	
	public boolean CrearUser(String nombre,String apellido,String id,String direccion,String telefono,String email_u, String cargo, String contraseña, String id_Sede) {
		PreparedStatement p = null;
		conectarme();
		try {
			comprobarlogin = "INSERT INTO usuarios values ('"+nombre+"','"+apellido+"','"+id+"','"+direccion+"','"+telefono+"','"+email_u+"','"+cargo+"','"+contraseña+"','"+id_Sede+"')";                                      
			p = conexion.prepareStatement(comprobarlogin);
			p.executeUpdate();
			return true;	
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		finally 
		{
			if (conexion != null) try { conexion.close(); } catch (SQLException logOrIgnore) {}
		
		}
		return false;
	}
	
	public String[] buscarSede(String id) throws SQLException 
	{
		PreparedStatement pst = null;
		ResultSet result = null;
		conectarme();
		try 
		{
			pst = conexion.prepareStatement("SELECT nombre_sede, direccion_sede, estado_sede FROM sede WHERE identificador_sede = ?");
			pst.setString(1, id);
			result = pst.executeQuery();
			String[] sedeInfo = new String[3];
			while(result.next())
			{
				sedeInfo[0]=result.getString(1);
				sedeInfo[1]=result.getString(2);
				sedeInfo[2]=result.getString(3);
			}
			return sedeInfo;
		}
		finally 
		{
			if (result != null) try { result.close(); } catch (SQLException logOrIgnore) {}
			if (conexion != null) try { conexion.close(); } catch (SQLException logOrIgnore) {}
		
		}
	}
}
