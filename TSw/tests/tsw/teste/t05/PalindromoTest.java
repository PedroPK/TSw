package tsw.teste.t05;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Assert;
import org.junit.Test;

import tsw.t05.Palindromo;

public class PalindromoTest {
	
	@Test
	public void isPalindromoMarrocos() {
		String frase = "Socorram-me subi no onibus em Marrocos";
		
		Palindromo palindromo = new Palindromo();
		
		boolean resultado = palindromo.isPalindromo(frase);
		
		assertTrue(resultado);
	}
	
	@Test
	public void isPalindromoFalsoMarrocos() {
		String frase = "Socorram-me subi no onibus lá em Marrocos";
		
		Palindromo palindromo = new Palindromo();
		
		boolean resultado = palindromo.isPalindromo(frase);
		
		assertFalse(resultado);
	}
	
	@Test
	public void isPalindromoMaratona() {
		String frase = "Anotaram a data da maratona";
		
		Palindromo palindromo = new Palindromo();
		
		boolean resultado = palindromo.isPalindromo(frase);
		
		assertTrue(resultado);
	}
	
	@Test
	public void isPalindromoFalsoMaratona() {
		String frase = "Anotara a data da maratona";
		
		Palindromo palindromo = new Palindromo();
		
		boolean resultado = palindromo.isPalindromo(frase);
		
		assertFalse(resultado);
	}
	
}