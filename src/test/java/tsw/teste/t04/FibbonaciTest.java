package tsw.teste.t04;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import tsw.excecoes.ParametroInvalidoException;
import tsw.t04.Fibbonaci;

public class FibbonaciTest {
	
	Fibbonaci aFibbonaci;
	
	@Before
	public void inicializarFibbonaci() {
		this.aFibbonaci = new Fibbonaci();
	}
	
	@Test
	public void getNumeroFibbonaciZeroTest() {
		try {
			int resultado = this.aFibbonaci.getFibbonaciNumber(0);
			
			assertEquals(0, resultado);
		} catch ( ParametroInvalidoException pie ) {
			// Exception thrown correctly
		}
	}
	
	@Test
	public void getNumeroFibbonaciNegativoTest() {
		try {
			int resultado = this.aFibbonaci.getFibbonaciNumber(-1);
			
			fail();
		} catch ( ParametroInvalidoException pie ) {
			// Exception thrown correctly
		}
	}
	
	@Test
	public void getQuintoNumeroFibbonaciTest() {
		try {
			int resultado = this.aFibbonaci.getFibbonaciNumber(5);
			
			assertEquals(5, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test
	public void getOitavoNumeroFibbonaciTest() {
		try{
			int resultado = this.aFibbonaci.getFibbonaciNumber(8);
			
			assertEquals(21, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test
	public void getDecimoNumeroFibbonaciTest() {
		try {
			int resultado = this.aFibbonaci.getFibbonaciNumber(10);
			
			assertEquals(55, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test
	public void getVigezimoNumeroFibbonaciTest() {
		try {
			int resultado = this.aFibbonaci.getFibbonaciNumber(20);
			
			assertEquals(6765, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test
	public void getVigezimoQuintoNumeroFibbonaciTest() {
		try {
			// Arrange
			int number = 25;
			
			// Act
			int resultado = this.aFibbonaci.getFibbonaciNumber(number);
			
			// Assert
			assertEquals(75025, resultado);
			
			// Logging
			printNumberAndResult(number, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}

	private void printNumberAndResult(int pNumber, int pResultado) {
		System.out.println(pNumber + ": " + pResultado);
	}
	
	@Test
	public void getTrigezimoNumeroFibbonaciTest() {
		try {
			// Arrange
			int number = 30;
			
			// Act
			int resultado = this.aFibbonaci.getFibbonaciNumber(number);
			
			// Asert
			assertEquals(832040, resultado);
			
			// Logging
			printNumberAndResult(number, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test
	public void getTrigezimoQuintoNumeroFibbonaciTest() {
		try {
			// Arrange
			int number = 35;
			
			// Act
			int resultado = this.aFibbonaci.getFibbonaciNumber(number);
			
			// Assert
			assertEquals(9227465, resultado);
			
			// Logging
			printNumberAndResult(number, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test
	public void getQuadragezimoNumeroFibbonaciTest() {
		try{ 
			// Arrange
			int number = 40;
			
			// Act
			int resultado = this.aFibbonaci.getFibbonaciNumber(number);
			
			// Assert
			assertEquals(102334155, resultado);
			
			// Logging
			printNumberAndResult(number, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test(timeout=1000)
	public void getQuadragezimoQuintoNumeroFibbonaciEmMenosDe1SegundoTest() {
		try {
			// Arrange
			int number = 45;
			
			// Act
			int resultado = this.aFibbonaci.getFibbonaciNumber(number);
			
			// Assert
			assertEquals(1134903170, resultado);
			
			// Logging
			printNumberAndResult(number, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test(timeout=1000)
	public void getQuadragezimoSextoNumeroFibbonaciEmMenosDe1SegundoTest() {
		try {
			// Arrange
			int number = 46;
			
			// Act
			int resultado = this.aFibbonaci.getFibbonaciNumber(number);
			
			// Assert
			assertEquals(1836311903, resultado);
			
			// Logging
			printNumberAndResult(number, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test(timeout=1000)
	public void getQuadragezimoSetimoNumeroFibbonaciEmMenosDe1SegundoTest() {
		try {
			// Arrange
			int number = 47;
			
			// Act
			int resultado = this.aFibbonaci.getFibbonaciNumber(number);
			
			// Assert
			assertTrue(resultado > 0);
			//assertEquals(2971215073, resultado);
			
			// Logging
			printNumberAndResult(number, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test(timeout=1000)
	public void getFitftyFibbonaciNumberTest() {
		try {
			// Arrange
			int number = 50;
			
			// Act
			int resultado = this.aFibbonaci.getFibbonaciNumber(number);
			
			// Assert
			assertTrue(resultado > 0);
			//assertEquals(12586269025, resultado);
			
			// Logging
			printNumberAndResult(number, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test(timeout=1000)
	public void getSixtyFibbonaciNumberTest() {
		try {
			// Arrange
			int number = 60;
			
			// Act
			int resultado = this.aFibbonaci.getFibbonaciNumber(number);
			
			// Assert
			assertTrue(resultado > 0);
			//assertEquals(1548008755920, resultado);
			
			// Logging
			printNumberAndResult(number, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test(timeout=1000)
	public void getSeptagezimoNumeroFibbonaciTest() {
		try {
			// Arrange
			int number = 70;
			
			// Act
			int resultado = this.aFibbonaci.getFibbonaciNumber(number);
			
			// Assert
			assertTrue(resultado > 0);
			//assertEquals(190392490709135, resultado);
			
			// Logging
			printNumberAndResult(number, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test(timeout=1000)
	public void getOctagezimoNumeroFibbonaciTest() {
		try {
			// Arrange
			int number = 80;
			
			// Act
			int resultado = this.aFibbonaci.getFibbonaciNumber(number);
			
			// Assert
			assertTrue(resultado > 0);
			//assertEquals(23416728348467685, resultado);
			
			// Logging
			printNumberAndResult(number, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test(timeout=1000)
	public void getNonagezimoNumeroFibbonaciTest() {
		try {
			// Arrange
			int number = 90;
			
			// Act
			int resultado = this.aFibbonaci.getFibbonaciNumber(number);
			
			// Assert
			assertTrue(resultado > 0);
			//assertEquals(2880067194370816120, resultado);
			
			// Logging
			printNumberAndResult(number, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test(timeout=1000)
	public void getCentezimoNumeroFibbonaciTest() {
		try {
			// Arrange
			int number = 100;
			
			// Act
			int resultado = this.aFibbonaci.getFibbonaciNumber(number);
			
			// Assert
			assertTrue(resultado > 0);
			//assertEquals(354224848179261915075, resultado);
			
			// Logging
			printNumberAndResult(number, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test(timeout=1000)
	public void getTwoHundredAndFiftyFibbonaciNumberTest() {
		try {
			// Arrange
			int number = 250;
			
			// Act
			int resultado = this.aFibbonaci.getFibbonaciNumber(number);
			
			// Assert
			assertTrue(resultado > 0);
			
			// Logging
			printNumberAndResult(number, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test(timeout=1000)
	public void getFiveHundredFibbonaciNumberTest() {
		try {
			// Arrange
			int number = 500;
			
			// Act
			int resultado = this.aFibbonaci.getFibbonaciNumber(number);
			
			// Assert
			assertTrue(resultado > 0);
			
			// Logging
			printNumberAndResult(number, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
}