package tsw.teste.t13.finals.dVictor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Pontuação: 73%
 * 
 * @author pedro.f-santos
 */
public class TesteTriangulo {
	
	Triangulo triangulo;
	Triangulo triangulo1Equilatero;
	Triangulo triangulo2Isoceles;
	Triangulo triangulo3Escaleno;
	
	@Before
	public void setUp() throws Exception {
		triangulo = new Triangulo();
		triangulo1Equilatero = new Triangulo(10.0,10.0,10.0);
		triangulo2Isoceles = new Triangulo(10.0,10.0,5.0);
		triangulo3Escaleno = new Triangulo(10.0,5.0,4.0);
	}
	
	@Test
	public void testeIsTamanhoLadoValidoMenorZero() throws Exception{
		assertTrue(triangulo.isTamanhoLadoValido(10.0));
	}
	
	/*
	 * Erro
	 */
	@Test
	public void testeIsTamanhoLadoValidoNulo() throws Exception{
		assertTrue(triangulo.isTamanhoLadoValido(null));
	}
	
	/* Equilatero */
	@Test
	public void testeIsEquilatero(){
		assertTrue(triangulo1Equilatero.isEquilatero());
	}
	@Test
	public void testeIsEquilateroVazio(){
		assertTrue(triangulo1Equilatero.isEquilatero());
	}
	public void testeIsEquilateroMaiorZero(){
		assertTrue(triangulo1Equilatero.isEquilatero());
	}
	
	
	
	/* Isosceles */
	@Test
	public void testeIsIsosceles(){
		assertTrue(triangulo2Isoceles.isIsosceles());
	}
	@Test
	public void testeIsIsoscelesVazio(){
		assertTrue(triangulo2Isoceles.isIsosceles());
	}
	@Test
	public void testeIsIsoscelesMaiorZero(){
		assertTrue(triangulo2Isoceles.isIsosceles());
	}
	
	
	
	
	/* Escaleno */
	@Test
	public void testeIsEscaleno(){
		assertTrue(triangulo3Escaleno.isEscaleno());
	}
	@Test
	public void testeIsEscalenoVazio(){
		assertTrue(triangulo3Escaleno.isEscaleno());
	}
	@Test
	public void testeIsEscalenoMaiorZero(){
		assertTrue(triangulo3Escaleno.isEscaleno());
	}
	
	
	
	
	
	@Test
	public void testeiITresLadosValidos(){
		if(triangulo1Equilatero.getA() != null && triangulo1Equilatero.getB() != null && triangulo1Equilatero.getC() != null)
			assertTrue(triangulo1Equilatero.isTresLadosvalidos());
	}
	@Test
	public void testeiITresLadosValidosMaiorZero(){		
		if(triangulo1Equilatero.getA()  > 0.0 && triangulo1Equilatero.getB() > 0.0 && triangulo1Equilatero.getC() > 0.0)
			assertTrue(triangulo1Equilatero.isTresLadosvalidos());
	}

}
