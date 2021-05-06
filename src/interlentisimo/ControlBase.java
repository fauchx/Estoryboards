package interlentisimo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ControlBase {
	JFrame frame;
	private Connection conexion = null;
	private String pass = "ziRtszHrvfZ8rEAaY_PVNQ2LpmUeQF50";
	private String user = "qhqysnst";
	private String comprobarlogin;
	private menu f;
	
	public void conectarme() {
		try {
		Class.forName("org.postgresql.Driver");
		conexion = DriverManager.getConnection("jdbc:postgresql://queenie.db.elephantsql.com/qhqysnst",user,pass);
	} catch (SQLException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void buscarusuario(String id, String contraseña) throws SQLException {
		PreparedStatement p = null;
		ResultSet result = null;
		conectarme();
		menu f = new menu();
		try {
			comprobarlogin = "SELECT identificación_u,contraseña_u from usuarios where identificación_u = '"+id+"' and contraseña_u = '"+contraseña+"'";
			p = conexion.prepareStatement(comprobarlogin);
			result = p.executeQuery();
			if(result.next()) {
				id = result.getString("identificación_u");
				contraseña = result.getString("contraseña_u");
				f.frame.setVisible(true);				
			}else {
				JOptionPane.showMessageDialog(null, "No se pudo iniciar pa");
			}
		}finally {
	        if (result != null) try { result.close(); } catch (SQLException logOrIgnore) {}
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
