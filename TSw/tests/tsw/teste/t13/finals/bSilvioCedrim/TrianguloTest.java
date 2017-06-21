package tsw.teste.t13.finals.bSilvioCedrim;

import static org.junit.Assert.*;
import org.junit.Test;

import tsw.t13.ExcecaoTamanhoInvalido;
import tsw.t13.Triangulo;

public class TrianguloTest {
	
	@Test(expected=ExcecaoTamanhoInvalido.class)
	public void testarCT01CriacaoTrianguloVazio() {
		Triangulo t = 
			new Triangulo(	0,		0,		0	);
		
		assertNotNull(t);
	}
	
	@Test
	public void testarCT02CriacaoTriangulo() {
		Triangulo t = 
			new Triangulo(	2,		3,		4	);
		
		assertNotNull(t);
	}
	
	@Test(expected=ExcecaoTamanhoInvalido.class)
	public void testarCT03CriacaoTrianguloComLadosNulos() {
		Triangulo t = 
			new Triangulo(	null,		null,		null	);
		
		assertNotNull(t);
	}
	
	@Test
	public void testarCT04CriacaoTrianguloEquilatero() {
		double lados = 1	;
		
		Triangulo t = new Triangulo(lados, lados, lados);
		
		assertNotNull(	t					);
		assertTrue(		t.isEquilatero()	);
		assertTrue(		t.isIsosceles()		);
		assertFalse(	t.isEscaleno()		);
	}
	
	@Test
	public void testarCT05CriacaoTrianguloNaoEquilatero() {
		double lados = 1	;
		
		Triangulo t = new Triangulo(lados, lados + 0.01, lados + 0.001);
		
		assertNotNull(	t					);
		assertFalse(	t.isEquilatero()	);
		assertFalse(	t.isIsosceles()		);
		assertTrue(		t.isEscaleno()		);
	}
	
	@Test
	public void testarCT06CriacaoTrianguloIsoceles() {
		double ladosUmDois =	1		;
		double ladoTres =		1.5		;
		
		Triangulo t = new Triangulo(	ladosUmDois, 	ladosUmDois, 	ladoTres);
		
		assertNotNull(	t					);
		assertFalse(	t.isEquilatero()	);
		assertTrue(		t.isIsosceles()		);
		assertFalse(	t.isEscaleno()		);
	}
	
	@Test
	public void testarCT07CriacaoTrianguloIsocelesEquilatero() {
		double ladosUmDois =	1		;
		double ladoTres =		1		;
		
		Triangulo t = new Triangulo(ladosUmDois, ladosUmDois, ladoTres);
		
		assertNotNull(	t					);
		assertTrue(		t.isEquilatero()	);
		assertTrue(		t.isIsosceles()		);
		assertFalse(	t.isEscaleno()		);
	}
	
	@Test(expected=ExcecaoTamanhoInvalido.class)
	public void testarCT08CriacaoTrianguloIsocelesInvalido() {
		double ladosUmDois =	1	;
		double ladoTres =		2	;
		
		Triangulo t = new Triangulo(ladosUmDois, ladosUmDois, ladoTres);
		
		assertNotNull(	t					);
		assertFalse(	t.isEquilatero()	);
		assertFalse(	t.isIsosceles()		);
		assertFalse(	t.isEscaleno()		);
	}
	
	@Test
	public void testarCT09CriacaoTrianguloEscaleno() {
		double ladosUm =	1	;
		double ladosDois =	2	;
		double ladoTres =	2.5	;
		
		Triangulo t = new Triangulo(ladosUm, ladosDois, ladoTres);
		
		assertNotNull(	t					);
		assertFalse(	t.isEquilatero()	);
		assertFalse(	t.isIsosceles()		);
		assertTrue(		t.isEscaleno()		);
	}
	
	@Test(expected=ExcecaoTamanhoInvalido.class)
	public void testarCT10CriacaoTrianguloEscalenoInvalido() {
		double ladosUm =	1	;
		double ladosDois =	2	;
		double ladoTres =	3	;
		
		Triangulo t = new Triangulo(ladosUm, ladosDois, ladoTres);
		
		assertNotNull(	t					);
		assertFalse(	t.isEquilatero()	);
		assertFalse(	t.isIsosceles()		);
		assertFalse(	t.isEscaleno()		);
	}
	
	@Test
	public void testarCT11CriacaoTrianguloReto() {
		Triangulo t = new Triangulo(	3,		4,		5);
		
		assertNotNull(	t							);
		assertTrue(		t.isTrianguloRetangulo()	);
	}
	
	@Test
	public void testarCT12CriacaoTrianguloNaoReto() {
		Triangulo t = new Triangulo(	3,		4,		5.1);
		
		assertNotNull(	t							);
		assertFalse(	t.isTrianguloRetangulo()	);
	}
	
}