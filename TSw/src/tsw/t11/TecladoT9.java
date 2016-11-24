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
		aMapeamentoTeclas.put("A", "2");
		aMapeamentoTeclas.put("B", "22");
		aMapeamentoTeclas.put("C", "222");
		
		aMapeamentoTeclas.put("D", "3");
		aMapeamentoTeclas.put("E", "33");
		aMapeamentoTeclas.put("F", "33");
		
		aMapeamentoTeclas.put("G", "4");
		aMapeamentoTeclas.put("H", "44");
		aMapeamentoTeclas.put("I", "44");
		
		aMapeamentoTeclas.put("J", "5");
		aMapeamentoTeclas.put("K", "55");
		aMapeamentoTeclas.put("L", "55");
		
		aMapeamentoTeclas.put("M", "6");
		aMapeamentoTeclas.put("N", "66");
		aMapeamentoTeclas.put("O", "666");
		
		aMapeamentoTeclas.put("P", "7");
		aMapeamentoTeclas.put("Q", "77");
		aMapeamentoTeclas.put("R", "777");
		aMapeamentoTeclas.put("S", "7777");
		
		aMapeamentoTeclas.put("T", "8");
		aMapeamentoTeclas.put("U", "88");
		aMapeamentoTeclas.put("V", "888");
		
		aMapeamentoTeclas.put("W", "9");
		aMapeamentoTeclas.put("X", "99");
		aMapeamentoTeclas.put("Y", "999");
		aMapeamentoTeclas.put("Z", "9999");
		
		aMapeamentoTeclas.put(" ", "0");
	}
	
	public String converterTextoParaTecladoNumerico( String pTexto ) {
		String resposta = null;
		
		if ( pTexto != null ) {
			resposta = "";
			
			for ( int i = 0; i < pTexto.length(); i = i + 1 ) {
				resposta = resposta + aMapeamentoTeclas.get(pTexto.charAt(i));
			}
		}
		
		return resposta;
	}
	
}
