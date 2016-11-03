/*
 * Este arquivo é propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informação nele contida pode ser
 * reproduzida, mostrada ou revelada sem permissão escrita da Sefaz-PE.
 */

package tsw.t06;

/**
 * Exceção lançada quando um parâmetro inválido é passado para uma função
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
