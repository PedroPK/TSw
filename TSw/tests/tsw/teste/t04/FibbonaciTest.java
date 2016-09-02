package tsw.teste.t04;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import tsw.t04.Fibbonaci;

public class FibbonaciTest {
	
	@Test
	public void getQuintoNumeroFibbonaciTest() {
		Fibbonaci fib = new Fibbonaci();
		int resultado = fib.getNumeroFibbonaci(5);
		
		Assert.assertEquals(8, resultado);
	}
	
	@Test
	public void getOitavoNumeroFibbonaciTest() {
		Fibbonaci fib = new Fibbonaci();
		int resultado = fib.getNumeroFibbonaci(8);
		
		Assert.assertEquals(34, resultado);
	}
	
	@Test
	public void getDecimoNumeroFibbonaciTest() {
		Fibbonaci fib = new Fibbonaci();
		int resultado = fib.getNumeroFibbonaci(10);
		
		Assert.assertEquals(resultado, resultado);
	}
	
	@Test
	public void getVigezimoQuintoNumeroFibbonaciTest() {
		Fibbonaci fib = new Fibbonaci();
		int resultado = fib.getNumeroFibbonaci(25);
		
		Assert.assertEquals(resultado, resultado);
	}
	
	@Test
	public void getTrigezimoNumeroFibbonaciTest() {
		Fibbonaci fib = new Fibbonaci();
		int resultado = fib.getNumeroFibbonaci(30);
		
		Assert.assertEquals(resultado, resultado);
	}
	
	@Test
	public void getTrigezimoQuintoNumeroFibbonaciTest() {
		Fibbonaci fib = new Fibbonaci();
		int resultado = fib.getNumeroFibbonaci(35);
		
		Assert.assertEquals(resultado, resultado);
	}
	
	@Test
	public void getQuadragezimoNumeroFibbonaciTest() {
		Fibbonaci fib = new Fibbonaci();
		int resultado = fib.getNumeroFibbonaci(40);
		
		Assert.assertEquals(resultado, resultado);
	}
	
	@Test(timeout=1000)
	public void getQuadragezimoQuintoNumeroFibbonaciTest() {
		Fibbonaci fib = new Fibbonaci();
		int resultado = fib.getNumeroFibbonaci(45);
		
		Assert.assertEquals(resultado, resultado);
	}
	
	@Ignore
	@Test
	public void getCentezimoNumeroFibbonaciTest() {
		Fibbonaci fib = new Fibbonaci();
		int resultado = fib.getNumeroFibbonaci(100);
		
		System.out.println(resultado);
		
		Assert.assertEquals(resultado, resultado);
	}
	
}