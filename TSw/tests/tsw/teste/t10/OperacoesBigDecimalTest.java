package tsw.teste.t10;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import org.junit.Test;

import tsw.t10.OperacoesBigDecimal;

public class OperacoesBigDecimalTest {
	
	@Test
	public void testarSubtracaoSemSerializacao() {
		BigDecimal minuendo = new BigDecimal("2000000");
		BigDecimal subtraendo = new BigDecimal("500");
		
		OperacoesBigDecimal operacoes = new OperacoesBigDecimal();
		
		BigDecimal resultado = operacoes.subtrairSemSerializacao(minuendo, subtraendo);
		BigDecimal resultadoEsperado = new BigDecimal("1999500");
		
		assertEquals(resultadoEsperado, resultado);
	}
	
	@Test
	public void testarSubtracaoComSerializacao() {
		BigDecimal minuendo = new BigDecimal("2000000");
		BigDecimal subtraendo = new BigDecimal("500");
		
		OperacoesBigDecimal operacoes = new OperacoesBigDecimal();
		
		BigDecimal resultado = operacoes.subtrairComSerializacao(minuendo, subtraendo);
		BigDecimal resultadoEsperado = new BigDecimal("1999500");
		
		assertEquals(resultadoEsperado, resultado);
	}
	
}