package tsw.teste.t13.finals.cDiogoRocha;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Pontuação: 66%
 * 
 * @author pedro.f-santos
 *
 */
public class TrianguloTeste {
	Double lado1, lado2, lado3;
	Triangulo t = new Triangulo();
	
	@Test
	public void isToLong() {
		t.setarTamanhos(99999999999.0, -3.0, 5.0);
		assertTrue(t.isToLong());
	}
	
	@Test
	public void pegarLadosNegativos() {
		t.setarTamanhos(4.0, -3.0, 5.0);
		assertTrue(t.pegarLadosNegativos());
	}
	
	@Test
	public void pegarLadosVazios() {
		t.setarTamanhos(5.0, null, 2.0);
		assertTrue(t.pegarLadosVazios());
	}
	
	/*
	 * 4ª Teste errado....
	 */
	@Test
	public void isTamanhoValido() {
		lado1 = -4.0;
		assertTrue(t.istamanhoValido(lado1));
	}
	
	@Test
	public void validarTodosOsLados() {
		lado1 = 4.0;
        lado2 = 4.0;
        lado3 = 6.0;
        
		assertTrue(t.istamanhoValido(lado1));
		assertTrue(t.istamanhoValido(lado2));
		assertTrue(t.istamanhoValido(lado3));
	}
	
	@Test
	public void validarTamanhoLado() {
		lado1 = 4.0;
		
		assertTrue(t.istamanhoValido(lado1));
		}
	
	@Test
	public void isEquilatero() {
		t.setarTamanhos(4.0, 4.0, 4.0);
		assertTrue(t.isEquilatero());
	}
	
	@Test
	public void isIsosceles() {
		t.setarTamanhos(4.0, 4.0, 6.0);
		assertTrue(t.isIsosceles());
	}
	
	@Test
	public void isEscaleno() {
		t.setarTamanhos(3.0, 4.0, 6.0);
		assertTrue(t.isEscaleno());
	}
	
	/*
	 * Teste errado mais uma vez...
	 */
	@Test
	public void isTrianguloRetangulo() {
		t.setarTamanhos(4.0, 6.0, 3.0);
		assertTrue(t.isTrianguloRetangulo());
	}
	
	/*
	 * Teste errado...
	 */
	@Test
	public void isTrianguloValido() {
		t.setarTamanhos(3.0, 0.0, 6.0);
		assertTrue(t.isTrianguloValido());
	}
	
	/*
	 * Teste errado de novo...
	 */
	@Test
	public void isTresLadosValidos() {
		t.setarTamanhos(3.0, null, 6.0);
		assertTrue(t.isTresLadosValidos());
	}
	
}
