package tsw.teste.t13.finals.bSilvioCedrim;

import org.junit.Assert;
import org.junit.Test;

public class TrianguloTestSilvio {


	@Test
	public void testIsEquilaterio(){
		Triangulo t = new Triangulo(1.0, 1.0, 1.0);
		Assert.assertTrue(t.isEquilatero());
	}

	@Test
	public void testIsNotEquilaterio(){
		Triangulo t = new Triangulo(1.0, 2.0, 1.0);
		Assert.assertFalse(t.isEquilatero());
	}

	@Test
	public void testIsIsosceles(){
		Triangulo t = new Triangulo(2.0, 1.0, 1.0);
		Assert.assertTrue(t.isIsosceles());
	}

	@Test
	public void testIsNotIsosceles(){
		Triangulo t = new Triangulo(3.0, 2.0, 1.0);
		Assert.assertFalse(t.isIsosceles());
	}

	@Test
	public void testIsEscaleno(){
		Triangulo t = new Triangulo(2.0, 1.0, 3.0);
		Assert.assertTrue(t.isEscaleno());
	}

	@Test
	public void testIsNotEscaleno(){
		Triangulo t = new Triangulo(3.0, 2.0, 3.0);
		Assert.assertFalse(t.isEscaleno());
	}

	@Test
	public void testIsRetangulo(){
		Triangulo t = new Triangulo(3.0, 4.0, 5.0);
		Assert.assertTrue(t.isTrianguloRetangulo());
	}

	@Test 
	public void testIsTamanhoValido(){
		Triangulo t = new Triangulo(3.0, 4.0, 5.0);
		Assert.assertTrue(t.isTamanhoLadoValido(t.getTamanhoA()));

	}
	
	@Test 
	public void testTrianguloTamanhoValido(){
		Triangulo t = new Triangulo(3.0, 4.0, 5.0);
		Assert.assertTrue(t.isTrianguloValido());

	}
	
	@Test 
	public void testNotTrianguloTamanhoValido(){
		Triangulo t = new Triangulo(-3.0, 4.0, 5.0);
		Assert.assertFalse(t.isTrianguloValido());

	}

	@Test 
	public void testIsNotTamanhoValido(){
		Triangulo t = new Triangulo(-3.0, 4.0, 5.0);
		Assert.assertFalse(t.isTamanhoLadoValido(t.getTamanhoA()));

	}

	@Test(expected=TamanhoInvalidoException.class)
	public void testValidarTamanhoLado(){
		Triangulo t = new Triangulo(-3.0, 4.0, 5.0);
		t.validarTamanhoLado(t.getTamanhoA());	

	}
	
	@Test
	public void testValidarTamanhoLadoComTryCatch(){
		
		Triangulo t = new Triangulo(-3.0, 4.0, 5.0);
		try{
			t.validarTamanhoLado(t.getTamanhoA());
			Assert.fail("Falha. Lançar Exceção.");
		}catch(TamanhoInvalidoException e){
			Assert.assertEquals(String.format(TamanhoInvalidoException.TAMANHO_INVALIDO_MSG, t.getTamanhoA()),  e.getMessage());
		}

	}

	@Test
	public void testValidarLadoOK(){
		Triangulo t = new Triangulo(-3.0, 4.0, 5.0);
		t.validarTamanhoLado(t.getTamanhoB());	

	}
	
	@Test(expected=TamanhoInvalidoException.class)
	public void testValidarTodosOsLados(){
		Triangulo t = new Triangulo(-3.0, 4.0, 5.0);
		t.validarTodosOsLados();	

	}
	
	@Test
	public void testValidarTodosOsLadosOK(){
		Triangulo t = new Triangulo(3.0, 4.0, 5.0);
		t.validarTodosOsLados();	

	}
	
	@Test
	public void testValidarRetangulo(){
		Triangulo t = new Triangulo(3.0, 4.0, 5.0);
		Assert.assertTrue(t.isTrianguloRetangulo());
	}
	
	@Test
	public void testValidarNotTrianguloRetangulo(){
		Triangulo t = new Triangulo(1.0, 4.0, 5.0);
		Assert.assertFalse(t.isTrianguloRetangulo());
	}


}
