package tsw.t04;

import java.util.HashMap;
import java.util.Map;

import tsw.excecoes.ParametroInvalidoException;

public class Fibbonaci {
	
	private Map<Integer, Integer> aNumerosFibonacci;
	
	public int getNumeroFibbonaci( int pNumero ) throws ParametroInvalidoException {
		int resultado = 0;
		
		if ( pNumero < 0 ) {
			throw new ParametroInvalidoException();
		}
		
		if ( pNumero == 0 || pNumero == 1 ) {
			resultado = pNumero;
		} else {
			if ( 
					this.aNumerosFibonacci != null					&&
					!this.aNumerosFibonacci.isEmpty()				&&
					this.aNumerosFibonacci.containsKey(pNumero)
			) {
				resultado = this.aNumerosFibonacci.get(pNumero);
			} else {
				resultado = 
					getNumeroFibbonaci(pNumero - 1) +
					getNumeroFibbonaci(pNumero - 2);
				
				if ( this.aNumerosFibonacci == null ) {
					this.aNumerosFibonacci = new HashMap<Integer, Integer>();
				}
				
				this.aNumerosFibonacci.put(pNumero, resultado);
			}
		}
		
		return resultado;
	}
	
}