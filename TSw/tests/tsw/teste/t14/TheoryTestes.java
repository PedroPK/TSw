package tsw.teste.t14;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TheoryTestes {
	
	@DataPoints
	public static List<Integer> getInteiros() {
		List<Integer> resultado = new ArrayList<Integer>();
		//resultado.add(Integer.valueOf("-1"));
		resultado.add(Integer.valueOf("0"));
		resultado.add(Integer.valueOf("1"));
		resultado.add(Integer.valueOf("2"));
		resultado.add(Integer.valueOf("3"));
		resultado.add(Integer.valueOf("5"));
		resultado.add(Integer.valueOf("8"));
		resultado.add(Integer.valueOf("13"));
		resultado.add(Integer.valueOf("21"));
		//, 0, 1, 2, 3, 5, 8, 13, 21};
		
		return resultado;
	}
	
	@Theory
	public void test(Integer pPrimeiro, Integer pSegundo) {
		Assert.assertTrue(pPrimeiro + pSegundo >= pPrimeiro);
	}
	
}
