package tsw.teste.t14;

import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TheoryTestes {
	
	@DataPoints
	public static int[] getInteiros() {
		return new int[] { -1, 0, 1, 2, 3, 5, 8, 13, 21};
	}
	
	@Theory
	public void test(int pPrimeiro, int pSegundo) {
		Assert.assertTrue(pPrimeiro + pSegundo >= pPrimeiro);
	}
	
}
