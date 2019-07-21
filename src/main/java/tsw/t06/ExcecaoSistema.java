/*
 * Este arquivo é propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informação nele contida pode ser
 * reproduzida, mostrada ou revelada sem permissão escrita da Sefaz-PE.
 */

package tsw.t06;

/**
 * Exceção lançada quando um erro inesperado ocorre dentro da aplicação. Ex.: NullPointerException, ClassCastException, etc...
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
