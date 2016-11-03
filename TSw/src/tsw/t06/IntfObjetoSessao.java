/*
 * Este arquivo � propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informa��o nele contida pode ser
 * reproduzida, mostrada ou revelada sem permiss�o escrita da Sefaz-PE.
 */
package tsw.t06;

/**
 * 
  */
public interface IntfObjetoSessao {
	//~ Metodos --------------------------------------------------------------------------------------------------------------------

	/**
	 * Realiza opera��es de limpeza ou manuten��o no objeto que ir� ser exclu�do do gerenciador de contexto de sess�o
	 *
	 * @throws ExcecaoGerenciadorSessao
	 */
	public void limparObjeto() throws ExcecaoGerenciadorSessao;
}
