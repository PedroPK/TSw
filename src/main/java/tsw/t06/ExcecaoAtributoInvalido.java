package tsw.t06;

/*
 * Este arquivo eh propriedade da Secretaria da Fazenda do Estado 
 * de Pernambuco (Sefaz-PE). Nenhuma informacao nele contida pode ser 
 * reproduzida, mostrada ou revelada sem permissao escrita da Sefaz-PE.
 */

/**
 * Exceção lançada quando um atributo de uma entidade é preenchido de forma errada.
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