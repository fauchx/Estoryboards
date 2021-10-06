package interlentisimo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
 //fauchx el bicho
//kk
import javax.swing.table.DefaultTableModel;

import com.sun.net.httpserver.Authenticator.Result;

public class ControlBase {
	JFrame frame;
	private Connection conexion = null;
	private final String SQL_SELECT_SEDE = "select * from sede";
	private final String SQL_SELECT_USERS = "select * from usuarios";
	private final String SQL_SELECT_SHIPMENT = "select E.id_envio, "
			+ "R.identificacion_r, "
			+ "R.nombres_r || R.apellidos_r as nombre_remitente, "
			+ "R.telefono_r, "
			+ "R.direccion_r, "
			+ "D.identificacion_d,"
			+ "D.nombres_d || D.apellidos_d as nombre_destinatario, "
			+ "D.telefono_d, "
			+ "D.direccion_d "
			+ "from destinatario as D "
			+ "join envio as E "
			+ "on D.identificacion_d = E.id_destinatario "
			+ "join remitente as R "
			+ "on R.identificacion_r=E.id_remitente";
	private final String SQL_SELECT_SEDE_ID = "select * from sede where identificador_sede=?";
	private final String SQL_SELECT_USERS_ID = "select * from usuarios where identificación_u=?";
	private final String SQL_SELECT_SHIPMENT_ID = "select E.id_envio, "
			+ "R.identificacion_r, "
			+ "R.nombres_r || R.apellidos_r as nombre_remitente, "
			+ "R.telefono_r, "
			+ "R.direccion_r, "
			+ "D.identificacion_d,"
			+ "D.nombres_d || D.apellidos_d as nombre_destinatario, "
			+ "D.telefono_d, "
			+ "D.direccion_d "
			+ "from destinatario as D "
			+ "join envio as E "
			+ "on D.identificacion_d = E.id_destinatario "
			+ "join remitente as R "
			+ "on R.identificacion_r=E.id_remitente"
			+ "where E.id_envio =?";
	private String pass = "ziRtszHrvfZ8rEAaY_PVNQ2LpmUeQF50";
	private String user = "qhqysnst";
	private String comprobarlogin , consultaCargo;
	private DefaultTableModel DT;
	
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

//	public String getEstado(String id) throws SQLException {
//		PreparedStatement pst = null;
//		ResultSet result = null;
//		conectarme();
//		try 
//		{
//			pst = conexion.prepareStatement("SELECT estado_u FROM usuarios WHERE identificación_u =?");
//			pst.setString(1, id);
//			result = pst.executeQuery();
//			String estado = null;
//			while(result.next()){
//				estado = result.getString("estado_u");
//			}
//			return estado;
//		}
//		finally 
//		{
//			if (result != null) try { result.close(); } catch (SQLException logOrIgnore) {}
//			if (conexion != null) try { conexion.close(); } catch (SQLException logOrIgnore) {}
//		
//		}
//		
//	}
	
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
	public boolean idUsuarioExist(String idIngresado) throws SQLException 
	{
		PreparedStatement pst = null;
		ResultSet result = null;
		conectarme();
		try 
		{
			pst = conexion.prepareStatement("SELECT identificación_u FROM usuarios WHERE identificación_u = ?",
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
	
	private DefaultTableModel setTitulos(String categoria) 
	{
		DT = new DefaultTableModel();
		switch(categoria) 
		{
		case "Usuarios":
			DT.addColumn("Nombres");
			DT.addColumn("Apellidos");
			DT.addColumn("Id");
			DT.addColumn("Dirección");
			DT.addColumn("Teléfono");
			DT.addColumn("Email");
			DT.addColumn("Cargo");
			DT.addColumn("Contraseña");
			DT.addColumn("Sede");
			DT.addColumn("Estado");
			break;
		case "Sedes":
			DT.addColumn("Id");
			DT.addColumn("Nombre");
			DT.addColumn("Estado");
			DT.addColumn("Dirección");
			break;
		case "Órdenes":
			//FALTA AGREGAR NOMBRES DE COLUMNAS
			DT.addColumn("ID_envío");
			DT.addColumn("ID_Remitente");
			DT.addColumn("Remitente");
			DT.addColumn("Teléfono R");
			DT.addColumn("Dirección_R");
			DT.addColumn("ID_Destinatario");
			DT.addColumn("Destinatario");
			DT.addColumn("Teléfono D");
			DT.addColumn("Dirección D");
			break;
		}
		return DT;
	}
	
	/**
	 * getDatosFactura 
	 * @param idEnvio recibe el id del envío del cual se generará la factura
	 * @return datos los datos consultados en la base
	 * @throws SQLException
	 */ 
	public String[] getDatosFactura(String idEnvio) throws SQLException 
	{
		String [] datos= new String[13];;
		try {
			PreparedStatement pst = null;
			ResultSet result = null;
			conectarme();
			String queryConsulta = "select E.id_envio, R.identificacion_r, R.nombres_r || R.apellidos_r as nombre_r, R.telefono_r,R.direccion_R,R.email_r,"
					+ "D.identificacion_d,D.nombres_d || D.apellidos_d as nombre_d, D.telefono_d,D.direccion_d,D.email_d,"
					+ "P.subtotal,P.seguro "
					+ "from envio as E "
					+ "join remitente as R "
					+ "on E.id_remitente=R.identificacion_r "
					+ "join destinatario as D "
					+ "on E.id_destinatario=D.identificacion_d "
					+ "join precio as P "
					+ "on P.id_envio=E.id_envio"
					+ "where E.id_envio=?";
			pst = conexion.prepareStatement(queryConsulta);
			pst.setString(1, idEnvio);
			result = pst.executeQuery();
			while(result.next()) {
				datos[0]=result.getString(1);
				datos[1]=result.getString(2);
				datos[2]=result.getString(3);
				datos[3]=result.getString(4);
				datos[4]=result.getString(5);
				datos[5]=result.getString(6);
				datos[6]=result.getString(7);
				datos[7]=result.getString(8);
				datos[8]=result.getString(9);
				datos[9]=result.getString(10);
				datos[10]=result.getString(11);
				datos[11]=result.getString(12);
				datos[12]=result.getString(13);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datos;
	}
	
	/**
	 * getDatosPaqs Este método lista todos los paquetes asociados a un id de un envío 
	 * @param idEnvio identificador del envío 
	 * @return paquetes Retorna una lista de vectores de Strings
	 */
	
	public ArrayList <String[]> getDatosPaqs(String idEnvio) 
	{
		String [] datos= new String[2];;
		ArrayList <String[]> paquetes = new ArrayList <String[]>(); 
 		try {
			PreparedStatement pst = null;
			ResultSet result = null;
			conectarme();
			String queryConsulta = "select peso,volumen from paquete where id_envio=?";
			pst = conexion.prepareStatement(queryConsulta);
			pst.setString(1, idEnvio);
			result = pst.executeQuery();
			while(result.next()) {
				datos[0]=result.getString(1);
				datos[1]=result.getString(2);
				paquetes.add(datos);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paquetes;
	}
	
	
	
	private PreparedStatement setQuery(PreparedStatement pst,String categoria)
	{
		try
		{
			switch(categoria) 
			{
			case "Usuarios":
				pst = conexion.prepareStatement(SQL_SELECT_USERS);
				break;
			case "Sedes":
				pst = conexion.prepareStatement(SQL_SELECT_SEDE);
				break;
			case "Órdenes":
				pst = conexion.prepareStatement(SQL_SELECT_SHIPMENT);
				break;
			}
			return pst;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return pst;
	}
	
	private PreparedStatement setQuery (PreparedStatement pst,String categoria, String identificador)
	{
		try
		{
			switch(categoria) 
			{
			case "Usuarios":
				pst = conexion.prepareStatement(SQL_SELECT_USERS_ID);
				pst.setString(1, identificador);
				break;
			case "Sedes":
				pst = conexion.prepareStatement(SQL_SELECT_SEDE_ID);
				pst.setString(1, identificador);
				break;
			case "Órdenes":
				pst = conexion.prepareStatement(SQL_SELECT_SHIPMENT_ID);
				pst.setString(1, identificador);
				break;
			}
			return pst;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return pst;
	}
	
	public DefaultTableModel getDatos(String categoria,String identificador) 
	{
		PreparedStatement pst = null;
		ResultSet result = null;
		try 
		{
			setTitulos(categoria);
			conectarme();
			if (identificador.equals(""))
			{
				pst=setQuery(pst, categoria);
			} else
			{
				pst=setQuery(pst, categoria, identificador);
			}
			result = pst.executeQuery();
			Object [] fila;
			switch(categoria) 
			{
			case "Usuarios":
				fila = new Object[10];
				while(result.next()) 
				{
					fila[0]=result.getString(1);
					fila[1]=result.getString(2);
					fila[2]=result.getString(3);
					fila[3]=result.getString(4);
					fila[4]=result.getString(5);
					fila[5]=result.getString(6);
					fila[6]=result.getString(7);
					fila[7]=result.getString(8);
					fila[8]=result.getString(9);
					fila[9]=result.getString(10);
					DT.addRow(fila);
				}
				break;
			case "Sedes":
				fila = new Object[4];
				while(result.next()) 
				{
					fila[0]=result.getString(1);
					fila[1]=result.getString(2);
					fila[2]=result.getString(3);
					fila[3]=result.getString(4);
					DT.addRow(fila);
				}
				break;
			case "Órdenes":
				//FALTA AGREGAR NOMBRES DE COLUMNAS
				fila = new Object[9];
				while(result.next()) 
				{
					fila[0]=result.getString(1);
					fila[1]=result.getString(2);
					fila[2]=result.getString(3);
					fila[3]=result.getString(4);
					fila[4]=result.getString(5);
					fila[5]=result.getString(6);
					fila[6]=result.getString(7);
					fila[7]=result.getString(8);
					fila[8]=result.getString(9);
				}
				break;
			}
			
		}catch (Exception e)
		{
			System.out.println("Error al listar");
			e.printStackTrace();
		}finally 
		{
			result = null;
			pst = null;
			if (conexion != null) try { conexion.close(); } catch (SQLException logOrIgnore) {}
		}
		return DT;
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
	
	
	public void actualizarPrecio(float precio_total, float seguro,int id_envio) throws SQLException {
		PreparedStatement pst = null;
		ResultSet result = null;
		conectarme();
		try 
		{
			pst = conexion.prepareStatement("UPDATE precio SET precio_total=?,seguro=? WHERE id_envio=?");
			pst.setFloat(1, precio_total);
			pst.setFloat(2, seguro);
			pst.setInt(3, id_envio);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			if (conexion != null) try { conexion.close(); } catch (SQLException logOrIgnore) {}
		
		}
	}
	
	
	public String selectSubtotal(int idEnvio) {
		PreparedStatement pst = null;
		ResultSet result = null;
		conectarme();
		String subtotal;
		try {
			pst = conexion.prepareStatement("select subtotal from precio where id_envio = ?");
			pst.setInt(1, idEnvio);
			result = pst.executeQuery();
			while(result.next()) {
				subtotal = result.getString(1);
				return subtotal;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	  public void cardRegist(String numeroTarjeta, String nombreTarjeta, String codigoSeguridad, String tipoDocumento, String numeroDocumento, String mesExpiracion, String anioExpiracion) {
	        PreparedStatement p = null;
	        conectarme();
	        try {
	            comprobarlogin = "INSERT INTO metodo_pago_tarjeta values ('"+numeroTarjeta+"','"+nombreTarjeta+"','"+codigoSeguridad+"','"+tipoDocumento+"'"
	                    + ",'"+numeroDocumento+"','"+mesExpiracion+"','"+anioExpiracion+"')";
	            p = conexion.prepareStatement(comprobarlogin);
	            p.executeUpdate();
	        
	        } catch(Exception ex) {
	            JOptionPane.showMessageDialog(null, ex);
	        }
	        finally
	        {
	            if (conexion != null) try { conexion.close(); } catch (SQLException logOrIgnore) {}

	        }
	    }
	
	public String selectPreciototal(int idEnvio) {
		PreparedStatement pst = null;
		ResultSet result = null;
		conectarme();
		String subtotal;
		try {
			pst = conexion.prepareStatement("select precio_total from precio where id_envio = ?");
			pst.setInt(1, idEnvio);
			result = pst.executeQuery();
			while(result.next()) {
				subtotal = result.getString(1);
				return subtotal;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void CrearRemitente(String nombre,String apellido,String id,String direccion,String telefono,String email) throws SQLException {
		PreparedStatement pst = null;
		ResultSet result = null;
		conectarme();
		try {
			pst = conexion.prepareStatement("INSERT INTO remitente VALUES (?,?,?,?,?,?)");
			pst.setString(1, id);
			pst.setString(2, telefono);
			pst.setString(3, direccion);
			pst.setString(4, nombre);
			pst.setString(5, apellido);
			pst.setString(6, email);
			pst.executeUpdate();
		}finally {
			if (conexion != null) try { conexion.close(); } catch (SQLException logOrIgnore) {}
		}
	}
	
	public String crearEnvio(String id_desti, String id_remit) throws SQLException {
		PreparedStatement pst = null;
		ResultSet result = null;
		conectarme();
		try {
			pst = conexion.prepareStatement("INSERT INTO envio(id_destinatario,id_remitente) VALUES (?,?) returning id_envio");
			pst.setString(1, id_desti);
			pst.setString(2, id_remit);
			result = pst.executeQuery();
			while(result.next()) {
				String id_envio = result.getString(1);
				System.out.print(id_envio);
				return id_envio;
			}
			
		}finally {
			if (conexion != null) try { conexion.close(); } catch (SQLException logOrIgnore) {}
		}
		return null;
	}
	
	
	
	public void crearPaquete(int id_envio, float peso, float volumen) throws SQLException {
		PreparedStatement pst = null;
		ResultSet result = null;
		conectarme();
		try {
			pst = conexion.prepareStatement("INSERT INTO paquetes(id_envio,peso,volumen) VALUES (?,?,?)");
			pst.setInt(1, id_envio);
			pst.setFloat(2, peso);
			pst.setFloat(3, volumen);
			pst.executeUpdate();
		}finally {
			if (conexion != null) try { conexion.close(); } catch (SQLException logOrIgnore) {}
		}
	}
		
	public void crearPrecio(float preciototal, float subtotal, float seguro, int id_envio) throws SQLException {
		PreparedStatement pst = null;
		ResultSet result = null;
		conectarme();
		try {
			pst = conexion.prepareStatement("INSERT INTO precio(precio_total,subtotal,seguro,id_envio) VALUES (?,?,?,?)");
			pst.setFloat(1, preciototal);
			pst.setFloat(2, subtotal);
			pst.setFloat(3, seguro);
			pst.setInt(4, id_envio);
			pst.executeUpdate();
		}finally {
			if (conexion != null) try { conexion.close(); } catch (SQLException logOrIgnore) {}
		}
	}
	 
	public void CrearDestinatario(String nombre,String apellido,String id,String direccion,String telefono,String email) throws SQLException {
		PreparedStatement pst = null;
		ResultSet result = null;
		conectarme();
		try {
			pst = conexion.prepareStatement("INSERT INTO destinatario VALUES (?,?,?,?,?,?)");
			pst.setString(1, id);
			pst.setString(2, telefono);
			pst.setString(3, direccion);
			pst.setString(4, nombre);
			pst.setString(5, apellido);
			pst.setString(6, email);
			pst.executeUpdate();
		}finally {
			if (conexion != null) try { conexion.close(); } catch (SQLException logOrIgnore) {}
		}
	}
	
	
	public void CrearUser(String nombre,String apellido,String id,String direccion,String telefono,String email_u, String cargo, String contraseña, String id_Sede, String estado) {
		PreparedStatement p = null;
		conectarme();
		try {
			comprobarlogin = "INSERT INTO usuarios values ('"+nombre+"','"+apellido+"','"+id+"','"+direccion+"'"
					+ ",'"+telefono+"','"+email_u+"','"+cargo+"','"+contraseña+"','"+id_Sede+"','"+estado+"')";                                      
			p = conexion.prepareStatement(comprobarlogin);
			p.executeUpdate();
				
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		finally 
		{
			if (conexion != null) try { conexion.close(); } catch (SQLException logOrIgnore) {}
		
		}
	}
	

	//public void cardRegist(String numeroTarjeta, String nombreTarjeta, String codigoSeguridad, String tipoDocumento, String numeroDocumento, String mesExpiracion, String anioExpiracion) {
      //  PreparedStatement p = null;
      //  conectarme();
      //  try {
        //    comprobarlogin = "INSERT INTO metodo_pago_tarjeta values ('"+numeroTarjeta+"','"+nombreTarjeta+"','"+codigoSeguridad+"','"+tipoDocumento+"'"
          //          + ",'"+numeroDocumento+"','"+mesExpiracion+"','"+anioExpiracion+"')";
         //   p = conexion.prepareStatement(comprobarlogin);
          //  p.executeUpdate();
        
      //  } catch(Exception ex) {
        //    JOptionPane.showMessageDialog(null, ex);
      // }
     //   finally
      //  {
       //     if (conexion != null) try { conexion.close(); } catch (SQLException logOrIgnore) {}

      //  }
  //  }
	
	
	public void ModificarUsuario(String nombre,String apellido,String direccion,String telefono,String email_u,
			String cargo, String id_Sede,String estado,String id) throws SQLException {
		PreparedStatement pst = null;
		ResultSet result = null;
		conectarme();
		try 
		{
			pst = conexion.prepareStatement("UPDATE usuarios SET nombres_u=?,apellidos_u=?,"
					+ "direccion_u=?,telefono_u=?,email_u=?,cargo_u=?,identificador_sede=?,estado_u=? where identificación_u=?");
			pst.setString(1, nombre);
			pst.setString(2, apellido);
			pst.setString(3, direccion);
			pst.setString(4, telefono);
			pst.setString(5, email_u);
			pst.setString(6, cargo);
			pst.setString(7, id_Sede);
			pst.setString(8, estado);
			pst.setString(9, id);
			pst.executeUpdate();
			
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		finally 
		{
			if (conexion != null) try { conexion.close(); } catch (SQLException logOrIgnore) {}
		
		}
		
	}
	public String[] buscarUsuario(String id) throws SQLException {
		PreparedStatement pst = null;
		ResultSet result = null;
		conectarme();
		try {
			pst = conexion.prepareStatement("Select nombres_u,apellidos_u,direccion_u,telefono_u,"
					+ "email_u,cargo_u,identificador_sede,estado_u from usuarios where identificación_u=?");
			pst.setString(1, id);
			result = pst.executeQuery();
			String[] usuarioInfo = new String[8];
			while(result.next()) {
				usuarioInfo[0] = result.getString(1);
				usuarioInfo[1] = result.getString(2);
				usuarioInfo[2] = result.getString(3);
				usuarioInfo[3] = result.getString(4);
				usuarioInfo[4] = result.getString(5);
				usuarioInfo[5] = result.getString(6);
				usuarioInfo[6] = result.getString(7);
				usuarioInfo[7] = result.getString(8);
			}
			return usuarioInfo;
		}finally {
			if (result != null) try { result.close(); } catch (SQLException logOrIgnore) {}
			if (conexion != null) try { conexion.close(); } catch (SQLException logOrIgnore) {}
		
		}
		
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
