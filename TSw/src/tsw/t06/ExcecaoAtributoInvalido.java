package tsw.t06;

/*
 * Este arquivo eh propriedade da Secretaria da Fazenda do Estado 
 * de Pernambuco (Sefaz-PE). Nenhuma informacao nele contida pode ser 
 * reproduzida, mostrada ou revelada sem permissao escrita da Sefaz-PE.
 */

/**
 * Exce��o lan�ada quando um atributo de uma entidade � preenchido de forma errada.
 */
public class ExcecaoAtributoInvalido extends ExcecaoGenerica {
	/**
	 */
	public ExcecaoAtributoInvalido(String pDsDebug) {
		super(pDsDebug);
	}

	/**
	 */
	public ExcecaoAtributoInvalido(String pDsDebug, Exception pExcecaoOrigem) {
		this(pDsDebug, (Throwable) pExcecaoOrigem);
	}

	/**
	 */
	public ExcecaoAtributoInvalido(String pDsDebug, Throwable pExcecaoOrigem) {
		super(pDsDebug, pExcecaoOrigem);
	}
}