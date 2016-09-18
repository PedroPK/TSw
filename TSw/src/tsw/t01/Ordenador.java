package tsw.t01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import tsw.excecoes.ColecaoNulaException;
import tsw.excecoes.ColecaoVaziaException;

public class Ordenador {
	
	private static Ordenador aOrdenador;
	
	private Ordenador() {}
	
	public static Ordenador getInstancia() {
		if ( aOrdenador == null ) {
			aOrdenador = new Ordenador();
		}
		
		return aOrdenador;
	}
	
	public List<Double> getMenorMaiorValor(Collection<Double> pColecao) throws ColecaoNulaException, ColecaoVaziaException {
		if ( pColecao == null ) {
			throw new ColecaoNulaException();
		}
		if ( pColecao.isEmpty() ) {
			throw new ColecaoVaziaException();
		}
		
		Iterator<Double> iterator = pColecao.iterator();
		Double maior = Double.NEGATIVE_INFINITY;
		Double menor = Double.POSITIVE_INFINITY;
		
		while ( iterator.hasNext() ) {
			Double vlAtual = iterator.next();
			if ( vlAtual > maior ) {
				maior = vlAtual;
			} else {
				if ( vlAtual < menor ) {
					menor = vlAtual;
				}
			}
		}
		
		List<Double> resultado = new ArrayList<Double>();
		resultado.add(menor);
		resultado.add(maior);
		
		return resultado;
	}
	
	public void lancarExcecaoEmColecaoNula() {
		Collection<Double> colecao = null;
		colecao.add(Double.valueOf(0.0));
	}
	
	public void lancarExcecaoEmListaVazia() {
		List<Double> colecao = new ArrayList<Double>();
		colecao.get(0);
	}
	
	public boolean isColecaoVazia(Collection<Double> pColecao) {
		boolean resposta = false;
		
		return resposta;
	}
	
	public int getTamanhoColecao(Collection<Double> pColecao) {
		int resposta = -1;
		
		return resposta;
	}
	
}