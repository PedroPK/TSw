package tsw.teste.t01;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.swing.JOptionPane;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import tsw.excecoes.ColecaoNulaException;
import tsw.excecoes.ColecaoVaziaException;
import tsw.t01.Ordenador;

public class OrdenadorTest {
	
	@Test
	public void getMaiorValorTest() {
		Collection<Double> colecao = getColecaoSemOrdem();
		
		try {
			List<Double> resultado = Ordenador.getMenorMaiorValor(colecao);
			
			Assert.assertEquals(new Double(40.0), resultado.get(1));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testarColecaoNula() {
		Collection<Double> colecao = null;
		
		try {
			List<Double> resultado = Ordenador.getMenorMaiorValor(colecao);
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
			List<Double> resultado = Ordenador.getMenorMaiorValor(colecao);
		} catch ( ColecaoVaziaException cve) {
			// Teste realizado com Sucesso!
		} catch ( ColecaoNulaException cne ) {
			Assert.fail();
		}
	}
	
	@Test
	public void getMaiorValorColecaoOrdenadaCrescenteTest() {
		Collection<Double> colecao = getColecaoOrdenadaCrescente();
		
		try {
			List<Double> resultado = Ordenador.getMenorMaiorValor(colecao);
			
			Assert.assertEquals(new Double(40.0), resultado.get(1));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void getMaiorValorColecaoOrdenadaDeCrescenteTest() {
		Collection<Double> colecao = getColecaoOrdenadaDecrescente();
		
		try {
			List<Double> resultado = Ordenador.getMenorMaiorValor(colecao);
			
			Assert.assertEquals(new Double(40.0), resultado.get(1));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void getMenorValorColecaoOrdenadaCrescenteTest() {
		Collection<Double> colecao = getColecaoOrdenadaCrescente();
		
		try {
			List<Double> resultado = Ordenador.getMenorMaiorValor(colecao);
			
			Assert.assertEquals(new Double(20.0), resultado.get(0));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Ignore
	@Test
	public void getMenorValorColecaoOrdenadaDecrescenteTest() {
		Collection<Double> colecao = getColecaoOrdenadaDecrescente();
		
		try {
			List<Double> resultado = Ordenador.getMenorMaiorValor(colecao);
			
			Assert.assertEquals(new Double(20.0), resultado.get(0));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Ignore
	@Test
	public void getMenorValorColecaoComNullTest() {
		Collection<Double> colecao = getColecaoComNull();
		
		try {
			List<Double> resultado = Ordenador.getMenorMaiorValor(colecao);
			
			Assert.assertEquals(new Double(20.0), resultado.get(0));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testeNonSense() {
		Collection<Double> colecaoDadosEntrada = getColecaoSemOrdem();
		colecaoDadosEntrada.add(new Double("Vida Loka!"));
		
		try {
			List<Double> resultado = Ordenador.getMenorMaiorValor(colecaoDadosEntrada);
			
			Assert.assertEquals(new Double(20.0), resultado.get(0));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	
	@Test
	public void testeVariavel(){
		String valor = JOptionPane.showInputDialog("Insira um Valor");
		Double d = Double.valueOf(valor);
		
		Collection<Double> colecaoDadosEntrada = getColecaoSemOrdem();
		colecaoDadosEntrada.add(d);
		
		try {
			List<Double> resultado = Ordenador.getMenorMaiorValor(colecaoDadosEntrada);
			
			Assert.assertEquals(new Double(20.0), resultado.get(0));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testeImprimindoResultados() {
		Collection<Double> colecao = getColecaoOrdenadaCrescente();
		
		try {
			List<Double> resultado = Ordenador.getMenorMaiorValor(colecao);
			
			String print = "testeImprimindoResultados Falhou";
			if ( new Double(20.0) == resultado.get(0) ) {
				print = "testeImprimindoResultados Passou!";
			}
			System.out.println(print);
			
			Assert.assertEquals(new Double(20.0), resultado.get(0));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	// M�todos privados auxiliares
	
	private Collection<Double> getColecaoOrdenadaCrescente() {
		Collection<Double> colecao = new HashSet<Double>();
		
		colecao.add( new Double(20.0));
		colecao.add( new Double(22));
		colecao.add( new Double(25.0));
		colecao.add( new Double(30.0));
		colecao.add( new Double(40.0));
		return colecao;
	}
	
	private Collection<Double> getColecaoOrdenadaDecrescente() {
		Collection<Double> colecao = new HashSet<Double>();
		
		colecao.add( new Double(40.0));
		colecao.add( new Double(30.0));
		colecao.add( new Double(25.0));
		colecao.add( new Double(22));
		colecao.add( new Double(20.0));
		
		return colecao;
	}
	
	private Collection<Double> getColecaoComNull() {
		Collection<Double> colecao = new HashSet<Double>();
		
		colecao.add( new Double(40.0));
		colecao.add( null);
		colecao.add( new Double(25.0));
		colecao.add( null );
		colecao.add( new Double(20.0));
		
		return colecao;
	}
	
	private Collection<Double> getColecaoSemOrdem() {
		Collection<Double> colecao = new HashSet<Double>();
		colecao.add( new Double(30.0));
		colecao.add( new Double(40.0));
		colecao.add( new Double(20.0));
		colecao.add( new Double(25.0));
		colecao.add( new Double(22));
		return colecao;
	}
	
}