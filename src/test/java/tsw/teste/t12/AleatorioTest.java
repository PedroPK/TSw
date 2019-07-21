package tsw.teste.t12;

import static org.junit.Assert.*;
import org.junit.Test;

import tsw.t12.Aleatorio;

public class AleatorioTest {
	
	@Test
	public void testarGeracaoNumeroInteiro() {
		int resultado = Aleatorio.gerarNumeroInteiroAleatorio();
		
		boolean isResultadoMenorQueOito = false;
		if ( resultado < 8 ) {
			isResultadoMenorQueOito = true;
		}
		
		System.out.println(resultado);
		
		assertTrue(isResultadoMenorQueOito);
		
	}
	
}