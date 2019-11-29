package tsw.t16;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CalculadoraMediasMoveis implements CalculadoraMediasMoveisInterface {
	
	/**
	 * 
	 */
	@Override
	public BigDecimal calcular(List<BigDecimal> pLista, int pQuantidadeValores) {
		List<BigDecimal> lista = new ArrayList<BigDecimal>();
		
		int indiceInicial = pLista.size() - pQuantidadeValores;
		
		while ( indiceInicial < pLista.size() ) {
			lista.add(pLista.get(indiceInicial));
			
			indiceInicial = indiceInicial + 1;
		}
		
		BigDecimal soma = BigDecimal.ZERO;
		
		Iterator<BigDecimal>	iterator	=		lista.iterator();
		while ( iterator.hasNext() ) {
			soma = soma.add(iterator.next());
		}
		
		BigDecimal dividendo	= soma.setScale(3);
		BigDecimal divisor		= new BigDecimal(pQuantidadeValores).setScale(3);
		
		BigDecimal resultado = dividendo.divide(divisor, RoundingMode.HALF_EVEN);
		
		// To Solve the ArithmeticException
		resultado = resultado.setScale(3);
		
		
		return resultado;
	}

}
