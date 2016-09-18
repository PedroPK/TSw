package tsw.teste.t04;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
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
			int resultado = this.aFibbonaci.getNumeroFibbonaci(0);
			
			Assert.assertEquals(0, resultado);
		} catch ( ParametroInvalidoException pie ) {
			// Exce��o lan�ada corretamente
		}
	}
	
	@Test
	public void getNumeroFibbonaciNegativoTest() {
		try {
			int resultado = this.aFibbonaci.getNumeroFibbonaci(-1);
			
			Assert.fail();
		} catch ( ParametroInvalidoException pie ) {
			// Exce��o lan�ada corretamente
		}
	}
	
	@Test
	public void getQuintoNumeroFibbonaciTest() {
		try {
			int resultado = this.aFibbonaci.getNumeroFibbonaci(5);
			
			Assert.assertEquals(5, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	@Test
	public void getOitavoNumeroFibbonaciTest() {
		try{
			int resultado = this.aFibbonaci.getNumeroFibbonaci(8);
			
			Assert.assertEquals(21, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	@Test
	public void getDecimoNumeroFibbonaciTest() {
		try {
			int resultado = this.aFibbonaci.getNumeroFibbonaci(10);
			
			Assert.assertEquals(55, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	@Test
	public void getVigezimoNumeroFibbonaciTest() {
		try {
			int resultado = this.aFibbonaci.getNumeroFibbonaci(20);
			
			Assert.assertEquals(6765, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	@Test
	public void getVigezimoQuintoNumeroFibbonaciTest() {
		try {
			int resultado = this.aFibbonaci.getNumeroFibbonaci(25);
			
			Assert.assertEquals(75025, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	@Test
	public void getTrigezimoNumeroFibbonaciTest() {
		try {
			int resultado = this.aFibbonaci.getNumeroFibbonaci(30);
			
			Assert.assertEquals(832040, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	@Test
	public void getTrigezimoQuintoNumeroFibbonaciTest() {
		try {
			int resultado = this.aFibbonaci.getNumeroFibbonaci(35);
			
			Assert.assertEquals(9227465, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	@Test
	public void getQuadragezimoNumeroFibbonaciTest() {
		try{ 
			int resultado = this.aFibbonaci.getNumeroFibbonaci(40);
			
			Assert.assertEquals(102334155, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	@Test(timeout=1000)
	public void getQuadragezimoQuintoNumeroFibbonaciEmMenosDe1SegundoTest() {
		try {
			int resultado = this.aFibbonaci.getNumeroFibbonaci(45);
			
			Assert.assertEquals(1134903170, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	@Test(timeout=1000)
	public void getQuadragezimoSextoNumeroFibbonaciEmMenosDe1SegundoTest() {
		try {
			int resultado = this.aFibbonaci.getNumeroFibbonaci(46);
			
			Assert.assertEquals(1836311903, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	@Ignore
	@Test(timeout=1000)
	public void getQuadragezimoSetimoNumeroFibbonaciEmMenosDe1SegundoTest() {
		try {
			int resultado = this.aFibbonaci.getNumeroFibbonaci(47);
			
			//Assert.assertEquals(2971215073, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	@Ignore
	@Test(timeout=1000)
	public void getQuiquagezimoNumeroFibbonaciTest() {
		try {
			int resultado = this.aFibbonaci.getNumeroFibbonaci(50);
			
			System.out.println(resultado);
			
			//Assert.assertEquals(12586269025, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	@Ignore
	@Test(timeout=1000)
	public void getSexaagezimoNumeroFibbonaciTest() {
		try {
			int resultado = this.aFibbonaci.getNumeroFibbonaci(60);
			
			System.out.println(resultado);
			
			//Assert.assertEquals(1548008755920, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	@Ignore
	@Test(timeout=1000)
	public void getSeptagezimoNumeroFibbonaciTest() {
		try {
			int resultado = this.aFibbonaci.getNumeroFibbonaci(70);
			
			System.out.println(resultado);
			
			//Assert.assertEquals(190392490709135, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	@Ignore
	@Test(timeout=1000)
	public void getOctagezimoNumeroFibbonaciTest() {
		try {
			int resultado = this.aFibbonaci.getNumeroFibbonaci(80);
			
			System.out.println(resultado);
			
			//Assert.assertEquals(23416728348467685, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	@Ignore
	@Test(timeout=1000)
	public void getNonagezimoNumeroFibbonaciTest() {
		try {
			int resultado = this.aFibbonaci.getNumeroFibbonaci(90);
			
			System.out.println(resultado);
			
			//Assert.assertEquals(2880067194370816120, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	@Ignore
	@Test(timeout=1000)
	public void getCentezimoNumeroFibbonaciTest() {
		try {
			int resultado = this.aFibbonaci.getNumeroFibbonaci(100);
			
			System.out.println(resultado);
			
			//Assert.assertEquals(354224848179261915075, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
}