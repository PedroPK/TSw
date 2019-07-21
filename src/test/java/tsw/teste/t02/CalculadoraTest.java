package tsw.teste.t02;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import tsw.t02.Calculadora;
import tsw.t02.CalculadoraConcreta;

public class CalculadoraTest {
	
	private Calculadora aCalculadora;
	
	@Before
	public void inicializarSomador() {
		this.aCalculadora = new CalculadoraConcreta();
	}
	
	@Test
	public void dividir10por1() {
		double resultado = this.aCalculadora.dividir("10", "1");
		
		assertEquals(10, resultado, 0.1);
	}
	
	@Test
	public void dividir1por10() {
		double resultado = this.aCalculadora.dividir("1", "10");
		
		assertEquals(0.1, resultado, 0.1);
	}
	
	@Test
	public void dividir2ponto57por5ponto29() {
		double resultado = this.aCalculadora.dividir("2.57", "5.29");
		
		assertEquals(0.48582231, resultado, 0.1);
	}
	
	@Test
	public void somarPrecisao16CasasDecimaisTest(){
		String valor01 = "0.1";
		String valor02 = "0.2";
		
		double resultado = this.aCalculadora.somar(valor01, valor02);
		
		assertEquals(0.3, resultado, 0.0000000000000001);
	}
	
	@Test
	public void somarPrecisao17CasasDecimaisTest(){
		String valor01 = "0.1";
		String valor02 = "0.2";
		
		double resultado = this.aCalculadora.somar(valor01, valor02);
		
		assertEquals(0.3, resultado, 0.00000000000000001);
	}
	
	@Test
	public void dividirTest() {
		String dividendo = "1";
		String divisor = "2";
		
		double resultado = this.aCalculadora.dividir(dividendo, divisor);
		
		assertEquals(0.5, resultado, 0.00001);
	}
	
	@Test
	public void dividirPorZeroTest() {
		String dividendo = "1";
		String divisor = "0";
		
		double resultado = this.aCalculadora.dividir(dividendo, divisor);
		System.out.println(resultado);
	}
	
	@Test
	public void dividirZeroPorZeroTest() {
		String dividendo = "0";
		String divisor = "0";
		
		double resultado = this.aCalculadora.dividir(dividendo, divisor);
		System.out.println(resultado);
	}
	
}