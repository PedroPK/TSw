package tsw.t16;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
	
	/**
	 * Lista de Valores:
	 * 	-	11		12		14		18		15		13		12		16
	 * 
	 * Quantidade de Valores:
	 *  - 	03
	 *  
	 * Resultado Esperado:
	 *  - 13,667
	 */
	@Test
	public void testCalcularMediaMovel_3UltimosValores() {
		// Arrange
		List<BigDecimal> lista = getLista();
		CalculadoraMediasMoveisInterface calculadora = new CalculadoraMediasMoveis();
		int quantidadeValores = 3;
		
		// Act
		BigDecimal media = calculadora.calcular(lista, quantidadeValores);
		
		//Assert
		BigDecimal expected = new BigDecimal(13.667).setScale(3, RoundingMode.HALF_EVEN);
		assertEquals(expected, media);
	}
	
	/**
	 * Lista de Valores:
	 * 	-	11		12		14		18		15		13		12		16
	 * 
	 * Quantidade de Valores:
	 *  - 	04
	 * 
	 * Resultado Esperado:
	 *  - 14
	 */
	@Test
	public void testCalcularMediaMovel_4UltimosValores() {
		// Arrange
		List<BigDecimal> lista = getLista();
		CalculadoraMediasMoveisInterface calculadora = new CalculadoraMediasMoveis();
		int quantidadeValores = 4;
		
		// Act
		BigDecimal media = calculadora.calcular(lista, quantidadeValores);
		
		//Assert
		BigDecimal expected = new BigDecimal(14).setScale(3);
		assertEquals(expected, media);
	}
	
	/**
	 * Lista de Valores:
	 * 	-	11		12		14		18		15		13		12		16
	 * 
	 * Quantidade de Valores:
	 *  - 	05
	 * 
	 * Resultado Esperado:
	 *  - 14.800
	 */
	@Test
	public void testCalcularMediaMovel_5UltimosValores() {
		// Arrange
		List<BigDecimal> lista = getLista();
		CalculadoraMediasMoveisInterface calculadora = new CalculadoraMediasMoveis();
		int quantidadeValores = 5;
		
		// Act
		BigDecimal media = calculadora.calcular(lista, quantidadeValores);
		
		//Assert
		BigDecimal expected = new BigDecimal(14.8).setScale(3, RoundingMode.HALF_EVEN);
		
		assertEquals(expected, media);
	}

}
