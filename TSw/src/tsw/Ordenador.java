package tsw;

import java.util.Collection;
import java.util.Iterator;

import tsw.excecoes.ColecaoNulaException;
import tsw.excecoes.ColecaoVaziaException;

public class Ordenador {
	
	public static Double getMaiorValor(Collection<Double> pColecao) throws ColecaoNulaException, ColecaoVaziaException {
		Iterator<Double> iterator = pColecao.iterator();
		Double maior = iterator.next();
		
		while ( iterator.hasNext() ) {
			Double vlAtual = iterator.next();
			if ( vlAtual > maior ) {
				maior = vlAtual;
			}
		}
		
		return maior;
	}
}