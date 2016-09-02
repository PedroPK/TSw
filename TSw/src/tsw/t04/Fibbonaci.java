package tsw.t04;

import tsw.excecoes.ParametroInvalidoException;

public class Fibbonaci {
	
	public int getNumeroFibbonaci( int pNumero ) throws ParametroInvalidoException {
		int resultado = 1;
		
		if ( pNumero <= 0 ) {
			throw new ParametroInvalidoException();
		}
		
		if ( pNumero == 1 || pNumero == 2 ) {
			resultado = pNumero;
		} else {
			resultado = 
				getNumeroFibbonaci(pNumero - 1) +
				getNumeroFibbonaci(pNumero - 2);
		}
		
		return resultado;
	}
	
}
