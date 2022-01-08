package test.java;




import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import main.banco.*;
	

public class CuentaTest extends TestCase {
	private Cuenta c;

	
	
	public CuentaTest() {
		super();
	}

	@BeforeEach
	public void inicial() {
		c = new Cuenta("Inma");
		
	}

	@Test
	public void testCuentaString() {
		String resultado = "Cuenta [nss=Inma, saldo=0.0, numIngresos=0, numReintegros=0]";
		c = new Cuenta("Inma");
		assertTrue(resultado.equals(c.toString()));
		
	}

	@Test
	public void testGetNss() {
		c = new Cuenta("Inma");
		assertTrue("Inma".equals(c.getNss()));
	}

	@Test
	public void testGetSaldo() {
		c = new Cuenta("Inma");
		assertEquals(0.0, c.getSaldo());
	}

	@Test
	public void testGetNumIngresos() {
		c = new Cuenta("Inma");
		assertEquals(0, c.getNumIngresos());

	}

	@Test
	public void testGetNumReintegros() {
		c = new Cuenta("Inma");
		assertEquals(0, c.getNumReintegros());

	}

	
	
}
