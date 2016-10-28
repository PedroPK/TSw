package tsw.t07;

import java.util.Collection;

public class Util {
	
	public static boolean isColecaoValida(Collection pColecao) {
		boolean resposta = false;
		
		if ( pColecao != null && !pColecao.isEmpty() ) {
			resposta = true;
		}
		
		return resposta;
	}
	
}