/*
 * Este arquivo � propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informa��o nele contida pode ser
 * reproduzida, mostrada ou revelada sem permiss�o escrita da Sefaz-PE.
 */

package tsw.t06;

/**
 * Exce��o lan�ada quando um par�metro inv�lido � passado para uma fun��o
 */
public class ExcecaoParametroInvalido extends ExcecaoSistema {
	//~ Construtores ---------------------------------------------------------------------------------------------------------------

	/**
	 * Cria um novo objeto ExcecaoParametroInvalido.
	 *
	 * @param pDsDebug  
	 */
	public ExcecaoParametroInvalido(String pDsDebug) {
		super(pDsDebug);
	}

	/**
	 * Cria um novo objeto ExcecaoParametroInvalido.
	 *
	 * @param pDsDebug  
	 * @param pExcecaoOrigem  
	 */
	public ExcecaoParametroInvalido(String pDsDebug, Exception pExcecaoOrigem) {
		this(pDsDebug, (Throwable) pExcecaoOrigem);
	}

	/**
	 * Cria um novo objeto ExcecaoParametroInvalido.
	 *
	 * @param pDsDebug  
	 * @param pExcecaoOrigem  
	 */
	public ExcecaoParametroInvalido(String pDsDebug, Throwable pExcecaoOrigem) {
		super(pDsDebug, pExcecaoOrigem);
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
