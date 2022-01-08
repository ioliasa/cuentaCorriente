package banco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaText {
	private Cuenta c;
	
	@BeforeEach
	void inicial() {
		c = new Cuenta("Inma");
		
	}

	@Test
	void testCuentaString() {
		String resultado = "Cuenta [nss=Inma, saldo=0.0, numIngresos=0, numReintegros=0]";
		assertTrue(resultado.equals(c.toString()));
		
	}

	@Test
	void testGetNss() {
		assertTrue("Inma".equals(c.getNss()));
	}

	@Test
	void testGetSaldo() {
		assertEquals(0.0, c.getSaldo());
	}

	@Test
	void testGetNumIngresos() {
		assertEquals(0.0, c.getNumIngresos());

	}

	@Test
	void testGetNumReintegros() {
		assertEquals(0.0, c.getNumReintegros());

	}

	
	
}
