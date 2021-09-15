package interlentisimo;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class controlBaseTest {

	public ControlBase base = new ControlBase();
	
	@Test
	public void testCRUD() throws SQLException 
	{
		try {
			base.insertarSede("testSede", "calleTest", "S500");
			
			assertNotNull(base.consultarSede("S500"));
			
			base.modificarSede("updateTest", "calleTest", "S500", "Activa");
			
			assertEquals("updateTest",base.consultarSede("S500"));
			
			base.borrarSede("S500");
			
			assertNull(base.consultarSede("S500"));
		} 
		finally {
			
		}
	}

}
