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
	
	@Test
	public void testarSparePrimeiraRodadaComPontosNaSegundaRodada() {
		JogoBoliche boliche = new JogoBoliche();
		
		boliche.inserirJogada((byte) 5);
		boliche.inserirJogada((byte) 5);
		boliche.inserirJogada((byte) 5);
		
		assertEquals(20, boliche.getPontuacao());
	}
	
	@Test
	public void testarStrikePrimeiraRodadaComPontosNaSegundaRodada() {
		JogoBoliche boliche = new JogoBoliche();
		
		boliche.inserirJogada((byte) 10);
		boliche.inserirJogada((byte) 5);
		boliche.inserirJogada((byte) 5);
		
		assertEquals(30, boliche.getPontuacao());
	}
	
	@Test
	public void testarDoisStrikesSeguidosETerceiraRodadaComPontos() {
		JogoBoliche boliche = new JogoBoliche();
		
		boliche.inserirJogada((byte) 10); // 10 + 15 = 25
		boliche.inserirJogada((byte) 10); // 10 + 5 = 15
		boliche.inserirJogada((byte) 5); // 5
		
		
		assertEquals(45, boliche.getPontuacao());
	}
	
	@Test
	public void testarSeJogoFoiCompletado() {
		JogoBoliche boliche = new JogoBoliche();
		
		for (byte qtJogadas = 0; qtJogadas < 18; qtJogadas = (byte) (qtJogadas + 1)) {
			boliche.inserirJogada((byte) 1);
		}
		
		assertEquals(18, boliche.getPontuacao());
		assertFalse(boliche.isJogoCompletado());
	}

}
