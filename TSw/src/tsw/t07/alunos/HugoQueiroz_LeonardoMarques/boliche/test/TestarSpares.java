package tsw.t07.alunos.HugoQueiroz_LeonardoMarques.boliche.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestarSpares {

	private BonusSpares bonusSpares;
	
	@Before
	public void init() {
		this.bonusSpares = new BonusSpares();
	}
	
	@Test
	public void spares() {
		ArrayList<Integer> jogadas = new ArrayList<>();
		jogadas.add(4);
		jogadas.add(6);
		
		assertEquals(true, bonusSpares.check(jogadas));
	}
	
	@Test
	public void sparesUm() {
		ArrayList<Integer> jogadas = new ArrayList<>();
		jogadas.add(1);
		jogadas.add(5);
		
		assertEquals(false, bonusSpares.check(jogadas));
	}

	@Test
	public void primeiraJogada() {
		ArrayList<Integer> jogadas = new ArrayList<>();
		jogadas.add(1);
		
		assertEquals(false, bonusSpares.check(jogadas));
	}
	
	@Test
	public void nulo() {
		assertEquals(false, bonusSpares.check(null));
	}
	
}
