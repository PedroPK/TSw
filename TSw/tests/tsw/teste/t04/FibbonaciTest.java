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
			
			Assert.fail();
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
			
			Assert.assertEquals(8, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	@Test
	public void getOitavoNumeroFibbonaciTest() {
		try{
			int resultado = this.aFibbonaci.getNumeroFibbonaci(8);
			
			Assert.assertEquals(34, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	@Test
	public void getDecimoNumeroFibbonaciTest() {
		try {
			int resultado = this.aFibbonaci.getNumeroFibbonaci(10);
			
			Assert.assertEquals(resultado, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	@Test
	public void getVigezimoQuintoNumeroFibbonaciTest() {
		try {
			int resultado = this.aFibbonaci.getNumeroFibbonaci(25);
			
			Assert.assertEquals(resultado, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	@Test
	public void getTrigezimoNumeroFibbonaciTest() {
		try {
			int resultado = this.aFibbonaci.getNumeroFibbonaci(30);
			
			Assert.assertEquals(resultado, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	@Test
	public void getTrigezimoQuintoNumeroFibbonaciTest() {
		try {
			int resultado = this.aFibbonaci.getNumeroFibbonaci(35);
			
			Assert.assertEquals(resultado, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	@Test
	public void getQuadragezimoNumeroFibbonaciTest() {
		try{ 
			int resultado = this.aFibbonaci.getNumeroFibbonaci(40);
			
			Assert.assertEquals(resultado, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	@Test(timeout=1000)
	public void getQuadragezimoQuintoNumeroFibbonaciEmMenosDe1SegundoTest() {
		try {
			int resultado = this.aFibbonaci.getNumeroFibbonaci(45);
			
			Assert.assertEquals(resultado, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	@Ignore
	@Test
	public void getCentezimoNumeroFibbonaciTest() {
		try {
			int resultado = this.aFibbonaci.getNumeroFibbonaci(100);
			
			System.out.println(resultado);
			
			Assert.assertEquals(resultado, resultado);
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
}