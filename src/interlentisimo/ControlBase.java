package interlentisimo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//joputa
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
	
	public void crud(String sql) {
		PreparedStatement p = null;
		conectarme();
		try {
			p = conexion.prepareStatement(sql);
			p.executeUpdate();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
}
