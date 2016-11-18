package tsw.t10;

import java.math.BigDecimal;

import tsw.util.BibliotecaFuncoes;

public class OperacoesBigDecimal {
	
	public BigDecimal subtrairSemSerializacao( BigDecimal pMinuendo, BigDecimal pSubtraendo ) {
		BigDecimal diferencaOuResto = 
			pMinuendo.subtract(pSubtraendo);
		
		return diferencaOuResto;
	}
	
	public BigDecimal subtrairComSerializacao( BigDecimal pMinuendo, BigDecimal pSubtraendo ) {
		BigDecimal diferencaOuResto = 
			(BigDecimal) BibliotecaFuncoes.clone(
				pMinuendo.subtract(pSubtraendo)
		);
		
		return diferencaOuResto;
	}
	
}