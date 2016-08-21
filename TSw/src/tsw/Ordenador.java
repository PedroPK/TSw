package tsw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import tsw.excecoes.ColecaoNulaException;
import tsw.excecoes.ColecaoVaziaException;

public class Ordenador {
	
	public static List<Double> getMaiorValor(Collection<Double> pColecao) throws ColecaoNulaException, ColecaoVaziaException {
		if ( pColecao == null ) {
			throw new ColecaoNulaException();
		}
		if ( pColecao.isEmpty() ) {
			throw new ColecaoVaziaException();
		}
		
		Iterator<Double> iterator = pColecao.iterator();
		Double maior = iterator.next();
		Double menor = maior;
		
		while ( iterator.hasNext() ) {
			Double vlAtual = iterator.next();
			if ( vlAtual > maior ) {
				maior = vlAtual;
			}
		}
		
		List<Double> resultado = new ArrayList<Double>();
		resultado.add(menor);
		resultado.add(maior);
		
		return resultado;
	}
}