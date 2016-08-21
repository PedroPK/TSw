package tsw.teste;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import tsw.Ordenador;
import tsw.excecoes.ColecaoNulaException;
import tsw.excecoes.ColecaoVaziaException;

public class OrdenadorTest {
	
	@Test
	public void getMaiorValorTest() {
		Collection<Double> colecao = new HashSet<Double>();
		colecao.add( new Double(30.0));
		colecao.add( new Double(40.0));
		colecao.add( new Double(20.0));
		colecao.add( new Double(25.0));
		colecao.add( new Double(22));
		
		try {
			List<Double> resultado = Ordenador.getMaiorValor(colecao);
			
			Assert.assertEquals(new Double(40.0), resultado.get(1));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testarColecaoNula() {
		Collection<Double> colecao = null;
		
		try {
			List<Double> resultado = Ordenador.getMaiorValor(colecao);
		} catch ( ColecaoNulaException cne) {
			// Teste realizado com Sucesso!
		} catch ( ColecaoVaziaException cve ) {
			Assert.fail();
		}
	}
	
	@Test
	public void testarColecaoVazia() {
		Collection<Double> colecao = new HashSet<Double>();
		
		try {
			List<Double> resultado = Ordenador.getMaiorValor(colecao);
		} catch ( ColecaoVaziaException cve) {
			// Teste realizado com Sucesso!
		} catch ( ColecaoNulaException cne ) {
			Assert.fail();
		}
	}
}
