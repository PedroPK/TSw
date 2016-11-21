package tsw.t10;

import java.io.IOException;
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
	
	public BigDecimal subtrairComMinuendoSubtraendoSerializados( BigDecimal pMinuendo, BigDecimal pSubtraendo ) throws IOException, ClassNotFoundException {
		BigDecimal minuendoSerializado = 
			(BigDecimal) BibliotecaFuncoes.clone(pMinuendo);
		BigDecimal subtraendoSerializado = 
			(BigDecimal) BibliotecaFuncoes.clone(pSubtraendo);
		
		BigDecimal diferencaOuResto = 
			minuendoSerializado.subtract(subtraendoSerializado);
		
		return diferencaOuResto;
	}
	
	public BigDecimal subtrairComMinuendoSubtraendoResultadoSerializados( BigDecimal pMinuendo, BigDecimal pSubtraendo ) throws IOException, ClassNotFoundException {
		BigDecimal minuendoSerializado = 
			(BigDecimal) BibliotecaFuncoes.clone(pMinuendo);
		BigDecimal subtraendoSerializado = 
			(BigDecimal) BibliotecaFuncoes.clone(pSubtraendo);
		
		BigDecimal diferencaOuResto = 
			minuendoSerializado.subtract(subtraendoSerializado);
		
		diferencaOuResto = (BigDecimal) BibliotecaFuncoes.clone(diferencaOuResto);
		
		return diferencaOuResto;
	}
	
}