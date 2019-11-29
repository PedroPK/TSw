package tsw.teste.t16;

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
			lista.add( pLista.get(indiceInicial) );
			
			indiceInicial = indiceInicial + 1;
		}
		
		BigDecimal soma = BigDecimal.ZERO;
		
		Iterator<BigDecimal>	iterator	=		lista.iterator();
		while ( iterator.hasNext() ) {
			soma = soma.add( iterator.next() );
		}
		
		// To Solve the ArithmeticException
		BigDecimal resultado =
			// Dividendo
			soma
				.divide(
					// Divisor
					new BigDecimal(pQuantidadeValores),
					
					// Escala / Precis�o / Quantidade de Casos Decimais
					3,
					
					// Modo de Arredondamento
					RoundingMode.HALF_EVEN
		);
		
		return resultado;
	}
	
	public static BigDecimal newBigDecimal(double pDouble) {
		return new BigDecimal(pDouble)		.setScale(3, RoundingMode.HALF_EVEN);
	}
	
}
