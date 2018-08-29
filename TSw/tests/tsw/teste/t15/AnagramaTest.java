package tsw.teste.t15;

import org.junit.Assert;
import org.junit.Test;

import tsw.t15.Anagrama;

public class AnagramaTest {
	
	@Test
	public void are_Aand_Aanagramas() {
		boolean response = Anagrama.areAnagramas("A", "A");
		
		Assert.assertTrue(response);
	}
	
	@Test
	public void are_EmptyStrings_Anagramas() {
		boolean response = Anagrama.areAnagramas("", "");
		
		Assert.assertTrue(response);
	}
	
	@Test
	public void are_SpaceStrings_Anagramas() {
		boolean response = Anagrama.areAnagramas(" ", " ");
		
		Assert.assertTrue(response);
	}
	
	@Test
	public void are_AandB_Anagramas() {
		boolean response = Anagrama.areAnagramas("A", "B");
		
		Assert.assertFalse(response);
	}
	
	@Test
	public void are_EmptyAndSpaceStrings_Anagramas() {
		boolean response = Anagrama.areAnagramas("", " ");
		
		Assert.assertFalse(response);
	}
	
	@Test
	public void are_AnaAndNanSpaceStrings_Anagramas() {
		boolean response = Anagrama.areAnagramas("ANA", "NAN");
		
		Assert.assertTrue(response);
	}
	
}