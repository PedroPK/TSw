package tsw.teste.t11;

import static org.junit.Assert.*;
import org.junit.Test;

import tsw.t11.TecladoT9;

/**
 * Regras
 * 
 * Um dos serviços mais utilizados pelos usuários de aparelhos celulares são os SMS (Short Message Service), que permite o envio de mensagens curtas (até 255 caracteres em redes GSM e 160 caracteres em redes CDMA).
 * Para digitar uma mensagem em um aparelho que n�o possui um teclado QWERTY embutido � necess�rio fazer algumas combina��es das 10 teclas num�ricas do aparelho para conseguir digitar. Cada n�mero � associado a um conjunto de letras como a seguir:
 * Letras  ->  N�mero
 * 
 *  ABC    ->  2
 *  DEF    ->  3
 *  GHI    ->  4
 *  JKL    ->  5
 *  MNO    ->  6
 *  PQRS    ->  7
 *  TUV    ->  8
 *  WXYZ   ->  9
 *  Espaco, Ponto, Virgula -> 0
 *  
 * Desenvolva um programa que, dada uma mensagem de texto limitada a 255 caracteres, retorne a seq��ncia de n�meros que precisa ser digitada. Uma pausa, para ser poss�vel obter duas letras referenciadas pelo mesmo n�mero, deve ser indicada como _.
 * Por exemplo, para digitar "SEMPRE ACESSO O DOJOPUZZLES", voc� precisa digitar:
 * 77773367_7773302_222337777_777766606660366656667889999_9999555337777
 * 
 * @author pedro.f-santos
 *
 */
public class TecladoT9Test {
	
	TecladoT9 aT9 = new TecladoT9();
	
	@Test
	public void testeNulo() {
		String numerico = 
			this.aT9.converterTextoParaTecladoNumerico(null);
		assertNull(numerico);
	}
	
	@Test
	public void testeVazio() {
		String numerico = 
			this.aT9.converterTextoParaTecladoNumerico("");
		assertTrue(numerico.isEmpty());
	}
	
	@Test
	public void testeTudoMinusculoPedro() {
		String numerico = 
			this.aT9.converterTextoParaTecladoNumerico("pedro");
		assertEquals("7333777666", numerico);
	}
	
	@Test
	public void testeComMaiusculoEMinusculoPedro() {
		TecladoT9 t9 = new TecladoT9();
		String numerico = 
			t9.converterTextoParaTecladoNumerico("Pedro");
		assertEquals("7333777666", numerico);
	}
	
	@Test
	public void testeTudoMaiusculoPEDRO() {
		TecladoT9 t9 = new TecladoT9();
		String numerico = 
			t9.converterTextoParaTecladoNumerico("PEDRO");
		assertEquals("7333777666", numerico);
	}
	
	public void testeComMaiusculoEMinusculoMaisEspacoPedroCarlos() {
		String numerico = 
			this.aT9.converterTextoParaTecladoNumerico("Pedro Carlos");
		assertEquals("7333777666022227775556667777", numerico);
	}
	
	@Test
	public void testeComMaiusculoEMinusculoMaisEspacoComPontuacaoPedroCarlos() {
		String numerico = 
			this.aT9.converterTextoParaTecladoNumerico("Pedro Carlos.");
		assertEquals("73337776660222277755566677771", numerico);
	}
	
	@Test
	public void testeComMaiusculoEMinusculoMaisEspacoComVirgulaPedroCarlos() {
		String numerico = 
			this.aT9.converterTextoParaTecladoNumerico("Pedro, Carlos.");
		assertEquals("7333777666110222277755566677771", numerico);
	}
	
	@Test
	public void teste12345() {
		String texto = 
			this.aT9.converterTecladoNumericoParaTexto("12345");
		
		assertEquals(".ADGJ", texto);
	}
	
}