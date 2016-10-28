package tsw.teste.t07;

import static org.junit.Assert.*;
import org.junit.Test;

import tsw.t07.JogoBoliche;

public class JogoBolicheTest {
	
	@Test
	public void testarTodasNaCanaleta() {
		JogoBoliche boliche = new JogoBoliche();
		
		for (byte qtJogadas = 0; qtJogadas < 20; qtJogadas = (byte) (qtJogadas + 1)) {
			boliche.inserirJogada((byte) 0);
		}
		
		assertEquals(0, boliche.getPontuacao());
		assertTrue(boliche.isJogoCompletado());
	}
	
	@Test
	public void testarSparePrimeiraRodadaORestoNaCanaleta() {
		JogoBoliche boliche = new JogoBoliche();
		
		boliche.inserirJogada((byte) 5);
		boliche.inserirJogada((byte) 5);
		for (byte qtJogadas = 0; qtJogadas < 18; qtJogadas = (byte) (qtJogadas + 1)) {
			boliche.inserirJogada((byte) 0);
		}
		
		assertEquals(10, boliche.getPontuacao());
		assertTrue(boliche.isJogoCompletado());
	}

}
