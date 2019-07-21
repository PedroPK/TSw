/*
 * Este arquivo é propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informação nele contida pode ser
 * reproduzida, mostrada ou revelada sem permissão escrita da Sefaz-PE.
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
