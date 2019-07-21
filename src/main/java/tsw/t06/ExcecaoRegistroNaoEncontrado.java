/*
 * Este arquivo � propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informa��o nele contida pode ser
 * reproduzida, mostrada ou revelada sem permiss�o escrita da Sefaz-PE.
 */

package tsw.t06;

/**
 * Exce��o lan�ada quando um registro n�o � encontrado em um cadastro.
 */
public class ExcecaoRegistroNaoEncontrado extends ExcecaoGenerica {
	//~ Construtores ---------------------------------------------------------------------------------------------------------------

	/**
	 * Cria um novo objeto ExcecaoRegistroNaoEncontrado.
	 *
	 * @param pNmEntidade  
	 * @param pDsDebug  
	 */
	public ExcecaoRegistroNaoEncontrado(String pNmEntidade, String pDsDebug) {
		this(pNmEntidade, pDsDebug, null);
	}

	/**
	 * Cria um novo objeto ExcecaoRegistroNaoEncontrado.
	 *
	 * @param pNmEntidade  
	 * @param pDsDebug  
	 * @param pExcecaoOrigem  
	 */
	public ExcecaoRegistroNaoEncontrado(String pNmEntidade, String pDsDebug, Exception pExcecaoOrigem) {
		super("Registro n�o encontrado | pNmEntidade = " + pNmEntidade + " | " + pDsDebug, pExcecaoOrigem);

		this.setCdSistema(Constantes.SG_SISTEMA_COM_UTL);
		this.setCdTelaMensagemUsuario(9);

		this.setCamposSubstituicaoMensagemPrincipal(new String[] {
				pNmEntidade
			});
	}

	//~ Metodos --------------------------------------------------------------------------------------------------------------------

	/**
	 * -
	 *
	 * @param pInRollbackTransacao
	 */
	public void setInRollbackTransacao(boolean pInRollbackTransacao) {
		super.setInRollbackTransacao(pInRollbackTransacao);
	}
}
