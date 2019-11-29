package tsw.teste.t01;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.swing.JOptionPane;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import tsw.excecoes.ColecaoNulaException;
import tsw.excecoes.ColecaoVaziaException;
import tsw.t01.Ordenador;

public class OrdenadorTest {
	
	Ordenador aOrdenador;
	
	@Before
	public void inicializarOrdenador() {
		this.aOrdenador = Ordenador.getInstancia();
	}
	
	/**
	 * Valores de Entrada
	 * 	- 30.0
	 *	- 40.0
	 *	- 20.0
	 *	- 25.0
	 *	- 22
	 *
	 * Valores de Saída
	 * 	- 20
	 *	- 22
	 * 	- 25
	 * 	- 30
	 * 	- 40
	 */
	@Test
	public void getMaiorValorTest() {
		Collection<Double> colecao = getColecaoSemOrdem();
		
		try {
			List<Double> resultado = this.aOrdenador.getMenorMaiorValor(colecao);
			
			assertEquals(		Double.valueOf(40.0),		resultado.get(1));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testarColecaoNula() {
		Collection<Double> colecao = null;
		
		try {
			this.aOrdenador.getMenorMaiorValor(colecao);
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
			this.aOrdenador.getMenorMaiorValor(colecao);
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
			List<Double> resultado = this.aOrdenador.getMenorMaiorValor(colecao);
			
			Assert.assertEquals(Double.valueOf(40.0), resultado.get(1));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void getMaiorValorColecaoOrdenadaDecrescenteTest() {
		Collection<Double> colecao = getColecaoOrdenadaDecrescente();
		
		try {
			List<Double> resultado = this.aOrdenador.getMenorMaiorValor(colecao);
			
			Assert.assertEquals(Double.valueOf(40.0), resultado.get(1));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void getMenorValorColecaoOrdenadaCrescenteTest() {
		Collection<Double> colecao = getColecaoOrdenadaCrescente();
		
		try {
			List<Double> resultado = this.aOrdenador.getMenorMaiorValor(colecao);
			
			Assert.assertEquals(Double.valueOf(20.0), resultado.get(0));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Ignore
	@Test
	public void getMenorValorColecaoOrdenadaDecrescenteTest() {
		Collection<Double> colecao = getColecaoOrdenadaDecrescente();
		
		try {
			List<Double> resultado = this.aOrdenador.getMenorMaiorValor(colecao);
			
			Assert.assertEquals(Double.valueOf(20.0), resultado.get(0));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Ignore
	@Test
	public void getMenorValorColecaoComNullTest() {
		Collection<Double> colecao = getColecaoComNull();
		
		try {
			List<Double> resultado = this.aOrdenador.getMenorMaiorValor(colecao);
			
			Assert.assertEquals(Double.valueOf(20.0), resultado.get(0));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Ignore
	@Test
	public void testeNonSense() {
		Collection<Double> colecaoDadosEntrada = getColecaoSemOrdem();
		colecaoDadosEntrada.add(Double.valueOf("Vida Loka!"));
		
		try {
			List<Double> resultado = this.aOrdenador.getMenorMaiorValor(colecaoDadosEntrada);
			
			Assert.assertEquals(Double.valueOf(20.0), resultado.get(0));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Ignore
	@Test
	public void testeVariavel(){
		String valor = JOptionPane.showInputDialog("Insira um Valor");
		Double d = Double.valueOf(valor);
		
		Collection<Double> colecaoDadosEntrada = getColecaoSemOrdem();
		colecaoDadosEntrada.add(d);
		
		try {
			List<Double> resultado = this.aOrdenador.getMenorMaiorValor(colecaoDadosEntrada);
			
			Assert.assertEquals(Double.valueOf(20.0), resultado.get(0));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testeImprimindoResultados() {
		Collection<Double> colecao = getColecaoOrdenadaCrescente();
		
		try {
			List<Double> resultado = this.aOrdenador.getMenorMaiorValor(colecao);
			
			String print = "testeImprimindoResultados Falhou";
			if ( Double.valueOf(20.0) == resultado.get(0) ) {
				print = "testeImprimindoResultados Passou!";
			}
			System.out.println(print);
			
			Assert.assertEquals(Double.valueOf(20.0), resultado.get(0));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void getInstanciaTest() {
		Ordenador ord1 = Ordenador.getInstancia();
		Ordenador ord2 = Ordenador.getInstancia();
		
		Assert.assertSame(ord1, ord2);
	}
	
	@Test
	public void getInstanciaNaoNulaTest() {
		Ordenador ord1 = Ordenador.getInstancia();
		Assert.assertNotNull(ord1);
	}
	
	@Test(expected=NullPointerException.class)
	public void lancarExcecaoEmColecaoNulaTest() {
		aOrdenador.lancarExcecaoEmColecaoNula();
	}
	
	//@Test(expected=NullPointerException.class)
	@Test(expected=IndexOutOfBoundsException.class)
	public void lancarExcecaoEmListaVaziaTest() {
		aOrdenador.lancarExcecaoEmListaVazia();
	}
	
	// Métodos privados auxiliares
	
	private Collection<Double> getColecaoOrdenadaCrescente() {
		Collection<Double> colecao = new HashSet<Double>();
		
		colecao.add( Double.valueOf(20.0));
		colecao.add( Double.valueOf(22));
		colecao.add( Double.valueOf(25.0));
		colecao.add( Double.valueOf(30.0));
		colecao.add( Double.valueOf(40.0));
		return colecao;
	}
	
	private Collection<Double> getColecaoOrdenadaDecrescente() {
		Collection<Double> colecao = new HashSet<Double>();
		
		colecao.add( Double.valueOf(40.0));
		colecao.add( Double.valueOf(30.0));
		colecao.add( Double.valueOf(25.0));
		colecao.add( Double.valueOf(22));
		colecao.add( Double.valueOf(20.0));
		
		return colecao;
	}
	
	private Collection<Double> getColecaoComNull() {
		Collection<Double> colecao = new HashSet<Double>();
		
		colecao.add( Double.valueOf(40.0));
		colecao.add( null);
		colecao.add( Double.valueOf(25.0));
		colecao.add( null );
		colecao.add( Double.valueOf(20.0));
		
		return colecao;
	}
	
	private Collection<Double> getColecaoSemOrdem() {
		Collection<Double> colecao = new HashSet<Double>();
		colecao.add( Double.valueOf(30.0));
		colecao.add( Double.valueOf(40.0));
		colecao.add( Double.valueOf(20.0));
		colecao.add( Double.valueOf(25.0));
		colecao.add( Double.valueOf(22));
		return colecao;
	}
	
}