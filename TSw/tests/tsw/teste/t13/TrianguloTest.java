package tsw.teste.t13;

import static org.junit.Assert.*;
import org.junit.Test;

import tsw.t13.ExcecaoTamanhoInvalido;
import tsw.t13.Triangulo;

public class TrianguloTest {
	
	@Test(expected=ExcecaoTamanhoInvalido.class)
	public void testarCT01CriacaoTrianguloVazio() {
		Triangulo t = 
			new Triangulo(	new Double(0),		new Double(0),		new Double(0)	);
		
		assertNotNull(t);
	}
	
	@Test(expected=ExcecaoTamanhoInvalido.class)
	public void testarCT02CriacaoTrianguloComLadosNulos() {
		Triangulo t = 
			new Triangulo(	null,		null,		null	);
		
		assertNotNull(t);
	}
	
	@Test
	public void testarCT03CriacaoTrianguloEquilatero() {
		Double lados = new Double(1);
		
		Triangulo t = new Triangulo(lados, lados, lados);
		
		assertNotNull(t);
		assertTrue( t.isEquilatero() );
		assertFalse( t.isIsosceles() );
		assertFalse( t.isEscaleno() );
	}
	
	@Test
	public void testarCT04CriacaoTrianguloIsoceles() {
		Double ladosUmDois = new Double(1);
		Double ladoTres = new Double(1.5);
		
		Triangulo t = new Triangulo(ladosUmDois, ladosUmDois, ladoTres);
		
		assertNotNull(t);
		assertFalse( t.isEquilatero() );
		assertTrue( t.isIsosceles() );
		assertFalse( t.isEscaleno() );
	}
	
	@Test(expected=ExcecaoTamanhoInvalido.class)
	public void testarCT05CriacaoTrianguloIsocelesInvalido() {
		Double ladosUmDois = new Double(1);
		Double ladoTres = new Double(2);
		
		Triangulo t = new Triangulo(ladosUmDois, ladosUmDois, ladoTres);
		
		assertNotNull(t);
		assertFalse( t.isEquilatero() );
		assertFalse( t.isIsosceles() );
		assertFalse( t.isEscaleno() );
	}
	
	@Test
	public void testarCT06CriacaoTrianguloEscaleno() {
		Double ladosUm = new Double(1);
		Double ladosDois = new Double(2);
		Double ladoTres = new Double(2.5);
		
		Triangulo t = new Triangulo(ladosUm, ladosDois, ladoTres);
		
		assertNotNull(t);
		assertFalse( t.isEquilatero() );
		assertFalse( t.isIsosceles() );
		assertTrue( t.isEscaleno() );
	}
	
	@Test(expected=ExcecaoTamanhoInvalido.class)
	public void testarCT07CriacaoTrianguloEscalenoInvalido() {
		Double ladosUm = new Double(1);
		Double ladosDois = new Double(2);
		Double ladoTres = new Double(3);
		
		Triangulo t = new Triangulo(ladosUm, ladosDois, ladoTres);
		
		assertNotNull(t);
		assertFalse( t.isEquilatero() );
		assertFalse( t.isIsosceles() );
		assertFalse( t.isEscaleno() );
	}
	
}