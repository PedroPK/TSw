package tsw.teste.t05;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import tsw.t05.Palindromo;

public class PalindromoTest {
	
	@Test
	public void isPalindromoComHifen() {
		String frase = "Socorram-me subi no onibus em Marrocos";
		
		Palindromo palindromo = new Palindromo();
		
		boolean resultado = palindromo.isPalindromo(frase);
		
		assertTrue(resultado);
	}
	
}