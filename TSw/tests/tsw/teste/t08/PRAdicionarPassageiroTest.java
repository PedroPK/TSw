package tsw.teste.t08;

import org.junit.Test;

import tsw.t08.servlet.PRAdicionarPassageiro;

public class PRAdicionarPassageiroTest {

	@Test
	public void testarServletAdicionarPassageiro() {
		PRAdicionarPassageiro servlet = new PRAdicionarPassageiro();
		
		servlet.inserirPassageiro();
	}
	
}
