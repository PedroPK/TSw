package tsw.teste.t07;

import static org.junit.Assert.*;
import org.junit.Test;

import tsw.t07.JogoBoliche;

public class JogoBolicheTest {
	
	@Test
	public void testarTodasNaCanaleta() {
		JogoBoliche boliche = new JogoBoliche();
		
		for (int qtJogadas = 0; qtJogadas < 20; qtJogadas = qtJogadas + 1 ) {
			boliche.inserirJogada( 0 );
		}
		
		assertEquals(0, boliche.getPontuacao());
		//assertTrue(boliche.isJogoCompletado());
	}
	
	@Test
	public void testarUmEmTodasJogadas() {
		JogoBoliche boliche = new JogoBoliche();
		
		for (int qtJogadas = 0; qtJogadas < 20; qtJogadas = qtJogadas + 1 ) {
			boliche.inserirJogada( 1 );
		}
		
		assertEquals(20, boliche.getPontuacao());
		//assertTrue(boliche.isJogoCompletado());
	}
	
	@Test
	public void testarSparePrimeiraRodadaTresNaJogadaSeguinte() {
		JogoBoliche boliche = new JogoBoliche();
		
		boliche.inserirJogada((int) 5);
		boliche.inserirJogada((int) 5);
		boliche.inserirJogada((int) 3);
		
		assertEquals(16, boliche.getPontuacao());
	}
	
	@Test
	public void testarStrikePrimeiraRodadaTresQuatroNaRodadaSeguinte() {
		JogoBoliche boliche = new JogoBoliche();
		
		boliche.inserirJogada((int) 10); // 10 + 3+4 = 17
		boliche.inserirJogada((int) 3);
		boliche.inserirJogada((int) 4);
		// Total = 17 + 3 + 4 = 24
		
		assertEquals(24, boliche.getPontuacao());
	}
	
	@Test
	public void testarSparePrimeiraRodadaORestoNaCanaleta() {
		JogoBoliche boliche = new JogoBoliche();
		
		boliche.inserirJogada( 5 );
		boliche.inserirJogada( 5 );
		for ( int qtJogadas = 0; qtJogadas < 18; qtJogadas = qtJogadas + 1 ) {
			boliche.inserirJogada( 0 );
		}
		
		assertEquals(10, boliche.getPontuacao());
		//assertTrue(boliche.isJogoCompletado());
	}
	
	@Test
	public void testarSparePrimeiraRodadaComPontosNaSegundaRodada() {
		JogoBoliche boliche = new JogoBoliche();
		
		boliche.inserirJogada((int) 5);
		boliche.inserirJogada((int) 5);
		boliche.inserirJogada((int) 5);
		
		assertEquals(20, boliche.getPontuacao());
	}
	
	@Test
	public void testarStrikePrimeiraRodadaComPontosNaSegundaRodada() {
		JogoBoliche boliche = new JogoBoliche();
		
		boliche.inserirJogada((int) 10);
		boliche.inserirJogada((int) 5);
		boliche.inserirJogada((int) 5);
		
		assertEquals(30, boliche.getPontuacao());
	}
	
	@Test
	public void testarDoisStrikesSeguidosETerceiraRodadaComPontos() {
		JogoBoliche boliche = new JogoBoliche();
		
		boliche.inserirJogada((int) 10); // 10 + 15 = 25
		boliche.inserirJogada((int) 10); // 10 + 5 = 15
		boliche.inserirJogada((int) 5); // 5
		
		
		assertEquals(45, boliche.getPontuacao());
	}
	
	@Test
	public void testarSeJogoFoiCompletado() {
		JogoBoliche boliche = new JogoBoliche();
		
		for (int qtJogadas = 0; qtJogadas < 18; qtJogadas = qtJogadas + 1 ) {
			boliche.inserirJogada((int) 1);
		}
		
		assertEquals(18, boliche.getPontuacao());
		assertFalse(boliche.isJogoCompletado());
	}
	
	@Test
	public void testarJogoPerfeito() {
		JogoBoliche boliche = new JogoBoliche();
		
		for (int qtJogadas = 0; qtJogadas < 12; qtJogadas = qtJogadas + 1 ) {
			boliche.inserirJogada((int) 10);
		}
		
		assertEquals(300, boliche.getPontuacao());
		//assertFalse(boliche.isJogoCompletado());
	}

}
