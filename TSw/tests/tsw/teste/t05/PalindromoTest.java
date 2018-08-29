package tsw.teste.t05;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tsw.t05.Palindromo;

public class PalindromoTest {
	
	@Test
	public void isPalindromoMarrocos() {
		String frase = "Socorram-me subi no onibus em Marrocos";
		
		boolean resultado = Palindromo.isPalindromo(frase);
		
		assertTrue(resultado);
	}
	
	@Test
	public void isPalindromoFalsoMarrocos() {
		String frase = "Socorram-me subi no onibus lá em Marrocos";
		
		boolean resultado = Palindromo.isPalindromo(frase);
		
		assertFalse(resultado);
	}
	
	@Test
	public void isPalindromoMaratona() {
		String frase = "Anotaram a data da maratona";
		
		boolean resultado = Palindromo.isPalindromo(frase);
		
		assertTrue(resultado);
	}
	
	@Test
	public void isPalindromoFalsoMaratona() {
		String frase = "Anotara a data da maratona";
		
		boolean resultado = Palindromo.isPalindromo(frase);
		
		assertFalse(resultado);
	}
	
}