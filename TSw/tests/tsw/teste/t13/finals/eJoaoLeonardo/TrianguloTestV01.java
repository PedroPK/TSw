package tsw.teste.t13.finals.eJoaoLeonardo;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Pontuação: 40%
 * 
 * @author pedro.f-santos
 *
 */
public class TrianguloTestV01 {
	
	@Test
	public void testarTrianguloEquilateroErrado() {
		Triangulo t1 = new Triangulo(1.0, 2.0, 3.0);
		
		boolean resultado = t1.isEquilatero();
		
		assertFalse(resultado);
	}

	@Test
	public void testarTrianguloEquilateroCerto() {
		Triangulo t11 = new Triangulo(4.0, 4.0, 4.0);
		
		assertFalse(t11.isEquilatero());
	}

	@Test
	public void testarTrianguloIsoscelesErrado() {
		Triangulo t2 = new Triangulo(1.0, 2.0, 3.0);
		
		boolean resultado = t2.isIsosceles();
		
		assertFalse( resultado);
	}

	@Test
	public void testarTrianguloIsoscelesCerto() {
		Triangulo t21 = new Triangulo(6.0, 6.0, 2.0);
		
		boolean resultado = t21.isIsosceles();
		
		assertFalse( resultado);
	}
	
	@Test
	public void testarTrianguloEscalenoCerto() {
		Triangulo t3 = new Triangulo(1.0, 2.0, 3.0);
		
		boolean resultado = t3.isEscaleno();
		
		assertEquals(true, resultado);
	}
	
	@Test
	public void testarTrianguloEscalenoErrado() {
		Triangulo t4 = new Triangulo(10.0, 10.0, 10.0);
		
		boolean resultado = t4.isEscaleno();
		
		assertEquals(true, resultado);
	}
	
}