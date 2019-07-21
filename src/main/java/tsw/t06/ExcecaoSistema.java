/*
 * Este arquivo � propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informa��o nele contida pode ser
 * reproduzida, mostrada ou revelada sem permiss�o escrita da Sefaz-PE.
 */

package tsw.t06;

/**
 * Exce��o lan�ada quando um erro inesperado ocorre dentro da aplica��o. Ex.: NullPointerException, ClassCastException, etc...
 */
public class ExcecaoSistema extends ExcecaoGenerica {
	//~ Construtores ---------------------------------------------------------------------------------------------------------------

	/**
	 */
	public ExcecaoSistema(String pDsDebug) {
		super(pDsDebug);
	}

	/**
	 */
	public ExcecaoSistema(String pDsDebug, Throwable pExcecaoOrigem) {
		super(pDsDebug, pExcecaoOrigem);
	}
}
