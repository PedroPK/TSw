package tsw.teste.t04;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

import tsw.excecoes.ParametroInvalidoException;
import tsw.t04.Fibonacci;

public class FibonacciTest {
	
	Fibonacci aFibonacci;
	
	@Before
	public void inicializarFibbonaci() {
		this.aFibonacci = new Fibonacci();
	}
	
	@Test
	public void getNumeroFibbonaciZeroTest() {
		try {
			// Arrange
			int number = 0;
			
			// Act
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Assert
			assertEquals(BigInteger.ZERO, resultado);
			
			// Logging
			printNumberAndResult(number, resultado);
		} catch ( ParametroInvalidoException pie ) {
			// Exception thrown correctly
		}
	}
	
	@Test
	public void getNumeroFibbonaciNegativoTest() {
		try {
			// Arrange
			int number = -1;
			
			// Act
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Assert
			assertTrue( resultado.compareTo(BigInteger.ZERO) >= 0 );
			
			fail();
		} catch ( ParametroInvalidoException pie ) {
			// Exception thrown correctly
		}
	}
	
	@Test
	public void getQuintoNumeroFibbonaciTest() {
		try {
			// Arrange
			int number = 5;
			
			// Act
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Assert
			assertEquals(BigInteger.valueOf(5), resultado);
			
			// Logging
			printNumberAndResult(number, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test
	public void getOitavoNumeroFibbonaciTest() {
		try{
			// Arrange
			int number = 8;
			
			// Act
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Assert
			assertEquals(BigInteger.valueOf(21), resultado);
			
			// Logging
			printNumberAndResult(number, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test
	public void getDecimoNumeroFibbonaciTest() {
		try {
			// Arrange
			int number = 10;
			
			// Act
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Assert
			assertEquals(BigInteger.valueOf(55), resultado);
			
			// Logging
			printNumberAndResult(number, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test
	public void getVigezimoNumeroFibbonaciTest() {
		try {
			// Arrange
			int number = 20;
			
			// Act
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Assert
			assertEquals(BigInteger.valueOf(6765), resultado);
			
			// Logging
			printNumberAndResult(number, resultado);
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
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Assert
			assertEquals(BigInteger.valueOf(75025), resultado);
			
			// Logging
			printNumberAndResult(number, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}

	private void printNumberAndResult(int pNumber, BigInteger pResultado) {
		System.out.println(pNumber + ": " + pResultado);
	}
	
	@Test
	public void getTrigezimoNumeroFibbonaciTest() {
		try {
			// Arrange
			int number = 30;
			
			// Act
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Asert
			assertEquals(BigInteger.valueOf(832040), resultado);
			
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
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Assert
			assertEquals(BigInteger.valueOf(9227465), resultado);
			
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
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Assert
			assertEquals(BigInteger.valueOf(102334155), resultado);
			
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
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Assert
			assertEquals(BigInteger.valueOf(1134903170), resultado);
			
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
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Assert
			assertEquals(BigInteger.valueOf(1836311903), resultado);
			
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
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Assert
			assertTrue(resultado.signum() > 0);
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
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Assert
			assertTrue(resultado.signum() > 0);
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
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Assert
			assertTrue(resultado.signum() > 0);
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
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Assert
			assertTrue(resultado.signum() > 0);
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
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Assert
			assertTrue(resultado.signum() > 0);
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
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Assert
			assertTrue(resultado.signum() > 0);
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
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Assert
			assertTrue(resultado.signum() > 0);
			//assertEquals(354224848179261915075, resultado);
			
			// Logging
			printNumberAndResult(number, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test(timeout=1000)
	public void getOneHundredAndFiftyFibbonaciNumberTest() {
		try {
			// Arrange
			int number = 150;
			
			// Act
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Logging
			printNumberAndResult(number, resultado);
			
			// Assert
			assertTrue(resultado.signum() > 0);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test(timeout=1000)
	public void getOneHundredAndSixtyFibbonaciNumberTest() {
		try {
			// Arrange
			int number = 160;
			
			// Act
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Logging
			printNumberAndResult(number, resultado);
			
			// Assert
			assertTrue(resultado.signum() > 0);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test(timeout=1000)
	public void getOneHundredAndSixtyOneFibbonaciNumberTest() {
		try {
			// Arrange
			int number = 161;
			
			// Act
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Logging
			printNumberAndResult(number, resultado);
			
			// Assert
			assertTrue(resultado.signum() > 0);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test(timeout=1000)
	public void getOneHundredAndSixtyTwoFibbonaciNumberTest() {
		try {
			// Arrange
			int number = 162;
			
			// Act
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Logging
			printNumberAndResult(number, resultado);
			
			// Assert
			assertTrue(resultado.signum() > 0);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test(timeout=1000)
	public void getOneHundredAndSixtyFiveFibbonaciNumberTest() {
		try {
			// Arrange
			int number = 165;
			
			// Act
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Logging
			printNumberAndResult(number, resultado);
			
			// Assert
			assertTrue(resultado.signum() > 0);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
	@Test(timeout=1000)
	public void getOneHundredAndSeventyFiveFibbonaciNumberTest() {
		try {
			// Arrange
			int number = 175;
			
			// Act
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Logging
			printNumberAndResult(number, resultado);
			System.out.println("Max Long Value = " + Long.MAX_VALUE);
			
			// Assert
			assertTrue(resultado.signum() > 0);
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
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Logging
			printNumberAndResult(number, resultado);
			
			// Assert
			assertTrue(resultado.signum() > 0);
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
			BigInteger resultado = this.aFibonacci.getFibbonaciNumber(number);
			
			// Assert
			assertTrue(resultado.signum() > 0);
			
			// Logging
			printNumberAndResult(number, resultado);
		} catch ( ParametroInvalidoException pie ) {
			fail();
		}
	}
	
}