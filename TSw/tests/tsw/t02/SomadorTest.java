package tsw.t02;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SomadorTest {
	
	private Somador aSomador;
	
	@Before
	public void inicializarSomador() {
		this.aSomador = new SomadorConcreto();
	}
	
	@Test
	public void somarPrecisao16CasasDecimaisTest(){
		double valor01 = 0.1;
		double valor02 = 0.2;
		
		double resultado = this.aSomador.somar(valor01, valor02);
		
		assertEquals(0.3, resultado, 0.0000000000000001);
	}
	
	@Test
	public void somarPrecisao17CasasDecimaisTest(){
		double valor01 = 0.1;
		double valor02 = 0.2;
		
		double resultado = this.aSomador.somar(valor01, valor02);
		
		assertEquals(0.3, resultado, 0.00000000000000001);
	}
	
}
