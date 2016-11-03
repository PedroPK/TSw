/*
 * Este arquivo é propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informação nele contida pode ser
 * reproduzida, mostrada ou revelada sem permissão escrita da Sefaz-PE.
 */

package tsw.t06;

/**
 * 
 */
public abstract class DAO {
	//~ Construtores ---------------------------------------------------------------------------------------------------------------

	/**
	 * Cria um novo objeto DAO.
	 */
	public DAO() {
	}

	//~ Metodos --------------------------------------------------------------------------------------------------------------------

	/**
	 * -
	 *
	 * @param pNmClasse  
	 * @param pDsDebug  
	 * @param pExcecao  
	 *
	 * @throws ExcecaoGenerica  
	 * @throws ExcecaoSistema  
	 */
	protected static void tratarExcecao(String pNmClasse, String pDsDebug, Exception pExcecao)
		throws ExcecaoGenerica {
		if (pExcecao instanceof ExcecaoGenerica) {
			ExcecaoGenerica excecaoGenerica = (ExcecaoGenerica) pExcecao;
			excecaoGenerica.adicionarDsDebug("[Tratada por: " + pNmClasse + "]");
			throw excecaoGenerica;
		} else {
			throw new ExcecaoSistema(pNmClasse + " | " + pDsDebug, pExcecao);
		}
	}
	
	/**
	 * -
	 *
	 * @param pDsDebug  
	 * @param pExcecao  
	 *
	 * @throws ExcecaoGenerica  
	 */
	protected void tratarExcecao(String pDsDebug, Exception pExcecao)
	throws ExcecaoGenerica {
		this.tratarExcecao(this.getClass().getName(), pDsDebug, pExcecao);
	}
	
}