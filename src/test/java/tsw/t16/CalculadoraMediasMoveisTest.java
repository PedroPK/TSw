package tsw.t16;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CalculadoraMediasMoveisTest {
	
	private List<BigDecimal> getLista() {
		List<BigDecimal>	lista = new ArrayList<BigDecimal>();
		
		lista.add(new BigDecimal(11));
		lista.add(new BigDecimal(12));
		lista.add(new BigDecimal(14));
		lista.add(new BigDecimal(18));
		lista.add(new BigDecimal(15));
		lista.add(new BigDecimal(13));
		lista.add(new BigDecimal(12));
		lista.add(new BigDecimal(16));
		
		return lista;
	}
	
	@Test
	public void testCalcularMediaMovel_3UltimosValores() {
		// Arrange
		List<BigDecimal> lista = getLista();
		CalculadoraMediasMoveisInterface calculadora = new CalculadoraMediasMoveis();
		int quantidadeValores = 3;
		
		// Act
		BigDecimal media = calculadora.calcular(lista, quantidadeValores);
		
		//Assert
		assertEquals(new BigDecimal(13.666), media);
	}

}
