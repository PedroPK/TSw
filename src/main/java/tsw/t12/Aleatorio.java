package tsw.t12;

import java.util.Random;

public class Aleatorio {
	
	public static int gerarNumeroInteiroAleatorio() {
		int inteiro = new Random().nextInt(8);
		return inteiro;
	}
	
}