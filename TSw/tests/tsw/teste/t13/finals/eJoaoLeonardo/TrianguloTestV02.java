package tsw.teste.t13.finals.eJoaoLeonardo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrianguloTestV02 {

	@Test
	public void testarTrianguloEquilateroErrado() {
		Triangulo t1 = new Triangulo(3.0, 2.0, 3.0);
		assertTrue(t1.isEquilatero());
	}

	@Test
	public void testarTrianguloEquilateroCerto() {
		Triangulo t11 = new Triangulo(4.0, 4.0, 4.0);
		assertFalse(t11.isEquilatero());
	}

	@Test
	public void testarTrianguloIsoscelesErrado() {
		Triangulo t2 = new Triangulo(1.0, 1.0, 3.0);
		assertTrue(t2.isIsosceles());
	}

	@Test
	public void testarTrianguloIsoscelesCerto() {
		Triangulo t21 = new Triangulo(6.0, 2.0, 1.0);
		assertFalse(t21.isIsosceles());
	}

	@Test
	public void testarTrianguloEscalenoCerto() {
		Triangulo t3 = new Triangulo(3.0, 4.0, 6.0);
		assertTrue(t3.isEscaleno());
	}

	@Test
	public void testarTrianguloEscalenoErrado() {
		Triangulo t4 = new Triangulo(5.0, 4.0, 5.0);
		assertFalse(t4.isEscaleno());
	}

	@Test
	public void testarRetanguloCerto(){
		Triangulo tr = new Triangulo(3.0, 4.0, 5.0);
		assertTrue(tr.isTrianguloRetangulo());
	}
	
	@Test
	public void testarRetanguloErrado(){
		Triangulo tr = new Triangulo(10.0, 4.0, 10.0);
		assertFalse(tr.isTrianguloRetangulo());
	}
	
	@Test 
	public void testarTamanhoValido(){
		Triangulo t = new Triangulo(3.0, 4.0, 5.0);
		assertTrue(t.isTrianguloValido());

	}
	
	@Test 
	public void testarTamanhoValidoErrado(){
		Triangulo t = new Triangulo(-10.0, 6.0, 9.0);
		assertFalse(t.isTrianguloValido());

	}
	
	@Test
	public void testarValidarTrianguloRetanguloErrado(){
		Triangulo t = new Triangulo(2.0, 5.0, 6.0);
		assertFalse(t.isTrianguloRetangulo());
	}

	@Test
	public void testarValidarTodosOsLados(){
		Triangulo t = new Triangulo(3.0, 4.0, 5.0);
		t.validarTodosOsLados();	

	}
	
	@Test
	public void testValidarTodosOsLadosErrado(){
		Triangulo t = new Triangulo(10.0, 10.0, -5.0);
		t.validarTodosOsLados();	

	}
	
}
