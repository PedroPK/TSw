/*
 * Este arquivo � propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informa��o nele contida pode ser
 * reproduzida, mostrada ou revelada sem permiss�o escrita da Sefaz-PE.
 */

package tsw.t06;

/**
 */
public class ExcecaoGerenciadorSessao extends ExcecaoGenerica {
	//~ Construtores ---------------------------------------------------------------------------------------------------------------

	/**
	 */
	public ExcecaoGerenciadorSessao(String pDsDebug) {
		super(pDsDebug);
	}

	/**
	 */
	public ExcecaoGerenciadorSessao(String pDsDebug, Exception pExcecaoOrigem) {
		super(pDsDebug, pExcecaoOrigem);
	}
}
