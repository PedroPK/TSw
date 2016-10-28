package tsw.teste.t07;

import static org.junit.Assert.assertEquals;
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
	}

}
