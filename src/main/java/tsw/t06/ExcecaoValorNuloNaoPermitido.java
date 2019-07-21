package tsw.t06;

/**
 * Exce��o lan�ada quando um atributo obrigat�rio de uma entidade n�o � preenchido
 */
public class ExcecaoValorNuloNaoPermitido extends ExcecaoAtributoInvalido {

	/**
	 * Construtor da Exce��o
	 * 
	 * @param	String	pNmAtributo	Nome do atributo
	 * @param	String	pDsDebug	Informa��o para debug
	 */
	public ExcecaoValorNuloNaoPermitido(String pNmAtributo, String pDsDebug) {
		super("pNmAtributo = " + pNmAtributo + " | " + pDsDebug);

		this.setCdSistema(Constantes.SG_SISTEMA_COM_UTL);
		this.setCdTelaMensagemUsuario(13);
		
		this.setCamposSubstituicaoMensagemPrincipal(new String[] {pNmAtributo});
	}

	/**
	 * Construtor da Exce��o
	 * 
	 * @param	String	pNmEntidade	Nome da entidade
	 * @param	String	pNmAtributo	Nome do atributo
	 * @param	String	pDsDebug	Informa��o para debug
	 */
	public ExcecaoValorNuloNaoPermitido(String pNmEntidade, String pNmAtributo, String pDsDebug) {
		super("pNmEntidade = " + pNmEntidade + " | pNmAtributo = " + pNmAtributo + " | " + pDsDebug);

		this.setCdSistema(Constantes.SG_SISTEMA_COM_UTL);
		this.setCdTelaMensagemUsuario(13);
		
		this.setCamposSubstituicaoMensagemPrincipal(new String[] {pNmAtributo});
	}
}