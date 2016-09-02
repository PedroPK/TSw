package tsw.t04;

public class Fibbonaci {
	
	public int getNumeroFibbonaci( int pNumero ) {
		int resultado = 1;
		
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
