package tsw.t11;

import java.util.HashMap;
import java.util.Map;

/**
 * Regras
 * 
 * Um dos servi�os mais utilizados pelos usu�rios de aparelhos celulares s�o os SMS (Short Message Service), que permite o envio de mensagens curtas (at� 255 caracteres em redes GSM e 160 caracteres em redes CDMA).
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
 *  Espa�o -> 0
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
	
	private Map<String, String> aMapeamentoTeclas = new HashMap<String, String>();
	
	public TecladoT9() {
		this.aMapeamentoTeclas.put("A", "2");
		this.aMapeamentoTeclas.put("a", "2");
		
		this.aMapeamentoTeclas.put("B", "22");
		this.aMapeamentoTeclas.put("b", "22");
		
		this.aMapeamentoTeclas.put("C", "222");
		this.aMapeamentoTeclas.put("c", "222");
		
		this.aMapeamentoTeclas.put("D", "3");
		this.aMapeamentoTeclas.put("d", "3");
		
		this.aMapeamentoTeclas.put("E", "33");
		this.aMapeamentoTeclas.put("e", "33");
		
		this.aMapeamentoTeclas.put("F", "33");
		this.aMapeamentoTeclas.put("f", "33");
		
		this.aMapeamentoTeclas.put("G", "4");
		this.aMapeamentoTeclas.put("g", "4");
		
		this.aMapeamentoTeclas.put("H", "44");
		this.aMapeamentoTeclas.put("h", "44");
		
		this.aMapeamentoTeclas.put("I", "44");
		this.aMapeamentoTeclas.put("i", "44");
		
		this.aMapeamentoTeclas.put("J", "5");
		this.aMapeamentoTeclas.put("j", "5");
		
		this.aMapeamentoTeclas.put("K", "55");
		this.aMapeamentoTeclas.put("k", "55");
		
		this.aMapeamentoTeclas.put("L", "55");
		this.aMapeamentoTeclas.put("l", "55");
		
		this.aMapeamentoTeclas.put("M", "6");
		this.aMapeamentoTeclas.put("m", "6");
		
		this.aMapeamentoTeclas.put("N", "66");
		this.aMapeamentoTeclas.put("n", "66");
		
		this.aMapeamentoTeclas.put("O", "666");
		this.aMapeamentoTeclas.put("o", "666");
		
		this.aMapeamentoTeclas.put("P", "7");
		this.aMapeamentoTeclas.put("p", "7");
		
		this.aMapeamentoTeclas.put("Q", "77");
		this.aMapeamentoTeclas.put("q", "77");
		
		this.aMapeamentoTeclas.put("R", "777");
		this.aMapeamentoTeclas.put("r", "777");
		
		this.aMapeamentoTeclas.put("S", "7777");
		this.aMapeamentoTeclas.put("s", "7777");
		
		this.aMapeamentoTeclas.put("T", "8");
		this.aMapeamentoTeclas.put("t", "8");
		
		this.aMapeamentoTeclas.put("U", "88");
		this.aMapeamentoTeclas.put("u", "88");
		
		this.aMapeamentoTeclas.put("V", "888");
		this.aMapeamentoTeclas.put("v", "888");
		
		this.aMapeamentoTeclas.put("W", "9");
		this.aMapeamentoTeclas.put("w", "9");
		
		this.aMapeamentoTeclas.put("X", "99");
		this.aMapeamentoTeclas.put("x", "99");
		
		this.aMapeamentoTeclas.put("Y", "999");
		this.aMapeamentoTeclas.put("y", "999");
		
		this.aMapeamentoTeclas.put("Z", "9999");
		this.aMapeamentoTeclas.put("0", "9999");
		
		this.aMapeamentoTeclas.put(" ", "0");
		this.aMapeamentoTeclas.put(".", "0");
		this.aMapeamentoTeclas.put(",", "0");
	}
	
	public String converterTextoParaTecladoNumerico( String pTexto ) {
		String resposta = null;
		
		if ( pTexto != null ) {
			resposta = "";
			
			for ( int i = 0; i < pTexto.length(); i = i + 1 ) {
				String caracterChave = String.valueOf( pTexto.charAt(i) );
				String numeroValor = this.aMapeamentoTeclas.get( caracterChave ); 
				resposta = resposta + numeroValor;
			}
		}
		
		return resposta;
	}
	
}
