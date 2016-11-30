package tsw.t11;

import java.util.HashMap;
import java.util.Map;

/**
 * Regras
 * 
 * Um dos serviços mais utilizados pelos usuários de aparelhos celulares s�o os SMS (Short Message Service), que permite o envio de mensagens curtas (at� 255 caracteres em redes GSM e 160 caracteres em redes CDMA).
 * Para digitar uma mensagem em um aparelho que n�o possui um teclado QWERTY embutido � necess�rio fazer algumas combina��es das 10 teclas num�ricas do aparelho para conseguir digitar. Cada n�mero � associado a um conjunto de letras como a seguir:
 * Letras  ->  Número
 * 
 *  ABC											->		2
 *  DEF											->		3
 *  GHI											->		4
 *  JKL											->		5
 *  MNO											->		6
 *  PQRS										->		7
 *  TUV											->		8
 *  WXYZ										->		9
 *  Espaco										->		0
 *  Ponto, Virgula, Interrogação e Exclamação	->		1
 *  
 * Desenvolva um programa que, dada uma mensagem de texto limitada a 255 caracteres, retorne a seq��ncia de n�meros que precisa ser digitada. Uma pausa, para ser poss�vel obter duas letras referenciadas pelo mesmo n�mero, deve ser indicada como _.
 * Por exemplo, para digitar "SEMPRE ACESSO O DOJOPUZZLES", voc� precisa digitar:
 * 77773367_7773302_222337777_777766606660366656667889999_9999555337777
 * 
 * Este problema foi baseado em uma sugest�o de Denis Costa

 * @author pedro.f-santos
 *
 */
public class TecladoT9 {
	
	private Map<String, String> aMapeamentoLetrasNumeros = new HashMap<String, String>();
	private Map<String, String> aMapeamentoNumerosLetras = new HashMap<String, String>();
	
	public TecladoT9() {
		inicializarMapeamentoLetrasNumeros();
		inicializarMapeamentoNumerosLetras();
	}

	private void inicializarMapeamentoLetrasNumeros() {
		this.aMapeamentoLetrasNumeros.put("A", "2");
		this.aMapeamentoLetrasNumeros.put("a", "2");
		
		this.aMapeamentoLetrasNumeros.put("B", "22");
		this.aMapeamentoLetrasNumeros.put("b", "22");
		
		this.aMapeamentoLetrasNumeros.put("C", "222");
		this.aMapeamentoLetrasNumeros.put("c", "222");
		
		this.aMapeamentoLetrasNumeros.put("D", "3");
		this.aMapeamentoLetrasNumeros.put("d", "3");
		
		this.aMapeamentoLetrasNumeros.put("E", "33");
		this.aMapeamentoLetrasNumeros.put("e", "33");
		
		this.aMapeamentoLetrasNumeros.put("F", "33");
		this.aMapeamentoLetrasNumeros.put("f", "33");
		
		this.aMapeamentoLetrasNumeros.put("G", "4");
		this.aMapeamentoLetrasNumeros.put("g", "4");
		
		this.aMapeamentoLetrasNumeros.put("H", "44");
		this.aMapeamentoLetrasNumeros.put("h", "44");
		
		this.aMapeamentoLetrasNumeros.put("I", "44");
		this.aMapeamentoLetrasNumeros.put("i", "44");
		
		this.aMapeamentoLetrasNumeros.put("J", "5");
		this.aMapeamentoLetrasNumeros.put("j", "5");
		
		this.aMapeamentoLetrasNumeros.put("K", "55");
		this.aMapeamentoLetrasNumeros.put("k", "55");
		
		this.aMapeamentoLetrasNumeros.put("L", "555");
		this.aMapeamentoLetrasNumeros.put("l", "555");
		
		this.aMapeamentoLetrasNumeros.put("M", "6");
		this.aMapeamentoLetrasNumeros.put("m", "6");
		
		this.aMapeamentoLetrasNumeros.put("N", "66");
		this.aMapeamentoLetrasNumeros.put("n", "66");
		
		this.aMapeamentoLetrasNumeros.put("O", "666");
		this.aMapeamentoLetrasNumeros.put("o", "666");
		
		this.aMapeamentoLetrasNumeros.put("P", "7");
		this.aMapeamentoLetrasNumeros.put("p", "7");
		
		this.aMapeamentoLetrasNumeros.put("Q", "77");
		this.aMapeamentoLetrasNumeros.put("q", "77");
		
		this.aMapeamentoLetrasNumeros.put("R", "777");
		this.aMapeamentoLetrasNumeros.put("r", "777");
		
		this.aMapeamentoLetrasNumeros.put("S", "7777");
		this.aMapeamentoLetrasNumeros.put("s", "7777");
		
		this.aMapeamentoLetrasNumeros.put("T", "8");
		this.aMapeamentoLetrasNumeros.put("t", "8");
		
		this.aMapeamentoLetrasNumeros.put("U", "88");
		this.aMapeamentoLetrasNumeros.put("u", "88");
		
		this.aMapeamentoLetrasNumeros.put("V", "888");
		this.aMapeamentoLetrasNumeros.put("v", "888");
		
		this.aMapeamentoLetrasNumeros.put("W", "9");
		this.aMapeamentoLetrasNumeros.put("w", "9");
		
		this.aMapeamentoLetrasNumeros.put("X", "99");
		this.aMapeamentoLetrasNumeros.put("x", "99");
		
		this.aMapeamentoLetrasNumeros.put("Y", "999");
		this.aMapeamentoLetrasNumeros.put("y", "999");
		
		this.aMapeamentoLetrasNumeros.put("Z", "9999");
		this.aMapeamentoLetrasNumeros.put("z", "9999");
		
		this.aMapeamentoLetrasNumeros.put(" ", "0");
		
		this.aMapeamentoLetrasNumeros.put(".", "1");
		this.aMapeamentoLetrasNumeros.put(",", "11");
		this.aMapeamentoLetrasNumeros.put("?", "111");
		this.aMapeamentoLetrasNumeros.put("!", "1111");
	}
	
	private void inicializarMapeamentoNumerosLetras() {
		this.aMapeamentoNumerosLetras.put("2", "A");
		
		this.aMapeamentoNumerosLetras.put("22", "B");
		
		this.aMapeamentoNumerosLetras.put("222", "C");
		
		this.aMapeamentoNumerosLetras.put("3", "D");
		
		this.aMapeamentoNumerosLetras.put("33", "E");
		
		this.aMapeamentoNumerosLetras.put("333", "F");
		
		this.aMapeamentoNumerosLetras.put("4", "G");
		
		this.aMapeamentoNumerosLetras.put("44", "H");
		
		this.aMapeamentoNumerosLetras.put("444", "I");
		
		this.aMapeamentoNumerosLetras.put("5", "J");
		
		this.aMapeamentoNumerosLetras.put("55", "K");
		
		this.aMapeamentoNumerosLetras.put("555", "L");
		
		this.aMapeamentoNumerosLetras.put("6", "M");
		
		this.aMapeamentoNumerosLetras.put("66", "N");
		
		this.aMapeamentoNumerosLetras.put("666", "O");
		
		this.aMapeamentoNumerosLetras.put("7", "P");
		
		this.aMapeamentoNumerosLetras.put("77", "Q");
		
		this.aMapeamentoNumerosLetras.put("777", "R");
		
		this.aMapeamentoNumerosLetras.put("7777", "S");
		
		this.aMapeamentoNumerosLetras.put("8", "T");
		
		this.aMapeamentoNumerosLetras.put("88", "U");
		
		this.aMapeamentoNumerosLetras.put("888", "V");
		
		this.aMapeamentoNumerosLetras.put("9", "W");
		
		this.aMapeamentoNumerosLetras.put("99", "X");
		
		this.aMapeamentoNumerosLetras.put("999", "Y");
		
		this.aMapeamentoNumerosLetras.put("9999", "Z");
		
		this.aMapeamentoNumerosLetras.put("0", " ");
		
		this.aMapeamentoNumerosLetras.put("1", ".");
		this.aMapeamentoNumerosLetras.put("11", ",");
		this.aMapeamentoNumerosLetras.put("111", "?");
		this.aMapeamentoNumerosLetras.put("1111", "!");
	}
	
	public String converterTextoParaTecladoNumerico( String pTexto ) {
		String resposta = null;
		
		if ( pTexto != null ) {
			resposta = "";
			
			for ( int i = 0; i < pTexto.length(); i = i + 1 ) {
				String caracterChave = String.valueOf( pTexto.charAt(i) );
				String numeroValor = this.aMapeamentoLetrasNumeros.get( caracterChave ); 
				resposta = resposta + numeroValor;
			}
		}
		
		return resposta;
	}
	
	public String converterTecladoNumericoParaTexto( String pNumeros ) {
		String resposta = null;
		
		if ( pNumeros != null ) {
			resposta = "";
			
			for ( int i = 0; i < pNumeros.length(); i = i + 1 ) {
				String caracterChave = String.valueOf( pNumeros.charAt(i) );
				String numeroValor = this.aMapeamentoNumerosLetras.get( caracterChave ); 
				resposta = resposta + numeroValor;
			}
		}
		
		return resposta;
	}
	
}
