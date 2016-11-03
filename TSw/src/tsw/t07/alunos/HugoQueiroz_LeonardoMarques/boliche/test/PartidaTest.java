package tsw.t07.alunos.HugoQueiroz_LeonardoMarques.boliche.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tsw.t07.alunos.HugoQueiroz_LeonardoMarques.main.java.com.boliche.Partida;

public class PartidaTest {

	private Partida partida;
	
	@Before
	public void Init() {
		this.partida = new Partida();
	}
	
	@After
	public void End() {
		this.partida = null;
	}
	
	@Test
	public void rodadaUm() {
		partida.addJogo(1, 1);
		partida.addJogo(1, 4);
		
		Integer resultadoEsperado = 5;
		assertEquals(resultadoEsperado, partida.getTotal());
	}
	
	@Test
	public void rodadaOutra() {
		partida.addJogo(1, 1);
		partida.addJogo(1, 5);

		Integer resultadoEsperado = 6;
		assertEquals(resultadoEsperado, partida.getTotal());
	}
	
	@Test
	public void rodadaDois() {
		
		partida.addJogo(1, 1);
		partida.addJogo(1, 4);
		
		
		partida.addJogo(2, 4);
		partida.addJogo(2, 5);
		
		Integer resultadoEsperado = 14;
		assertEquals(resultadoEsperado, partida.getTotal());
	}
	
	@Test
	public void rodadaTres() {
		
		partida.addJogo(1, 1);
		partida.addJogo(1, 4);
		
		
		partida.addJogo(2, 4);
		partida.addJogo(2, 5);
		
		
		partida.addJogo(3, 6);
		partida.addJogo(3, 4);
		
		Integer resultadoEsperado = 24;
		assertEquals(resultadoEsperado, partida.getTotal());
	}

	@Test
	public void rodadaQuatroSpares() {
		
		partida.addJogo(1, 1);
		partida.addJogo(1, 4);
		
		
		partida.addJogo(2, 4);
		partida.addJogo(2, 5);
		
		
		partida.addJogo(3, 6);
		partida.addJogo(3, 4);
		
		
		partida.addJogo(4, 5);
		partida.addJogo(4, 5);
		
		Integer resultadoEsperado = 39;
		assertEquals(resultadoEsperado, partida.getTotal());
	}
	
	@Test
	public void rodadaCincoStrike() {
		
		partida.addJogo(1, 1);
		partida.addJogo(1, 4);
		
		
		partida.addJogo(2, 4);
		partida.addJogo(2, 5);
		
		
		partida.addJogo(3, 6);
		partida.addJogo(3, 4);
		
		
		partida.addJogo(4, 5);
		partida.addJogo(4, 5);
		
		
		partida.addJogo(5, 10);
		
		Integer resultadoEsperado = 59;
		assertEquals(resultadoEsperado, partida.getTotal());
	}

	@Test
	public void rodadaultima() {
		
		partida.addJogo(1, 1);
		partida.addJogo(1, 4);
		
		
		partida.addJogo(2, 4);
		partida.addJogo(2, 5);
		
		
		partida.addJogo(3, 6);
		partida.addJogo(3, 4);
		
		
		partida.addJogo(4, 5);
		partida.addJogo(4, 5);
		
		
		partida.addJogo(5, 10);
		
		partida.addJogo(6, 0);
		partida.addJogo(6, 1);
		
		partida.addJogo(7, 7);
		partida.addJogo(7, 3);
		
		partida.addJogo(8, 6);
		partida.addJogo(8, 4);
		
		partida.addJogo(9, 10);
		
		partida.addJogo(10, 2);
		partida.addJogo(10, 8);
		partida.addJogo(10, 6);
		
		Integer resultadoEsperado = 133;
		assertEquals(resultadoEsperado, partida.getTotal());
	}
}
