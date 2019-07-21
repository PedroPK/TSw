/*
 * Este arquivo é propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informação nele contida pode ser
 * reproduzida, mostrada ou revelada sem permissão escrita da Sefaz-PE.
 */
package tsw.t06;

/**
 * 
  */
public interface IntfObjetoSessao {
	//~ Metodos --------------------------------------------------------------------------------------------------------------------

	/**
	 * Realiza operações de limpeza ou manutenção no objeto que irá ser excluído do gerenciador de contexto de sessão
	 *
	 * @throws ExcecaoGerenciadorSessao
	 */
	public void limparObjeto() throws ExcecaoGerenciadorSessao;
}
