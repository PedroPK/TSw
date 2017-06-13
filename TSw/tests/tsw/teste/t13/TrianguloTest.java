package tsw.teste.t13;

import static org.junit.Assert.*;
import org.junit.Test;

import tsw.t13.ExcecaoTamanhoInvalido;
import tsw.t13.Triangulo;

public class TrianguloTest {
	
	@Test(expected=ExcecaoTamanhoInvalido.class)
	public void testarCriacaoTrianguloVazio() {
		Triangulo t = 
			new Triangulo(
				new Double(0),
				new Double(0),
				new Double(0)
			);
	}
	
	@Test(expected=ExcecaoTamanhoInvalido.class)
	public void testarCriacaoTrianguloComLadosNulos() {
		Triangulo t = 
			new Triangulo(
				null,
				null,
				null
			);
	}
	
	@Test
	public void testarCriacaoTrianguloEquilatero() {
		Double lados = new Double(1);
		
		Triangulo t = new Triangulo(lados, lados, lados);
		assertTrue( t.isEquilatero() );
		assertFalse( t.isIsoceles() );
		assertFalse( t.isEscaleno() );
	}
	
	@Test
	public void testarCriacaoTrianguloIsoceles() {
		Double ladosUmDois = new Double(1);
		Double ladoTres = new Double(1.5);
		
		Triangulo t = new Triangulo(ladosUmDois, ladosUmDois, ladoTres);
		assertFalse( t.isEquilatero() );
		assertTrue( t.isIsoceles() );
		assertFalse( t.isEscaleno() );
	}
	
	@Test(expected=ExcecaoTamanhoInvalido.class)
	public void testarCriacaoTrianguloIsocelesInvalido() {
		Double ladosUmDois = new Double(1);
		Double ladoTres = new Double(2);
		
		Triangulo t = new Triangulo(ladosUmDois, ladosUmDois, ladoTres);
		assertFalse( t.isEquilatero() );
		assertFalse( t.isIsoceles() );
		assertFalse( t.isEscaleno() );
	}
	
	@Test
	public void testarCriacaoTrianguloEscaleno() {
		Double ladosUm = new Double(1);
		Double ladosDois = new Double(2);
		Double ladoTres = new Double(2.5);
		
		Triangulo t = new Triangulo(ladosUm, ladosDois, ladoTres);
		assertFalse( t.isEquilatero() );
		assertFalse( t.isIsoceles() );
		assertTrue( t.isEscaleno() );
	}
	
	@Test(expected=ExcecaoTamanhoInvalido.class)
	public void testarCriacaoTrianguloEscalenoInvalido() {
		Double ladosUm = new Double(1);
		Double ladosDois = new Double(2);
		Double ladoTres = new Double(3);
		
		Triangulo t = new Triangulo(ladosUm, ladosDois, ladoTres);
		assertFalse( t.isEquilatero() );
		assertFalse( t.isIsoceles() );
		assertFalse( t.isEscaleno() );
	}

}
