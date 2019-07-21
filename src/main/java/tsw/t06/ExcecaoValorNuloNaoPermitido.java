package tsw.t06;

/**
 * Exceção lançada quando um atributo obrigatório de uma entidade não é preenchido
 */
public class ExcecaoValorNuloNaoPermitido extends ExcecaoAtributoInvalido {

	/**
	 * Construtor da Exceção
	 * 
	 * @param	String	pNmAtributo	Nome do atributo
	 * @param	String	pDsDebug	Informação para debug
	 */
	public ExcecaoValorNuloNaoPermitido(String pNmAtributo, String pDsDebug) {
		super("pNmAtributo = " + pNmAtributo + " | " + pDsDebug);

		this.setCdSistema(Constantes.SG_SISTEMA_COM_UTL);
		this.setCdTelaMensagemUsuario(13);
		
		this.setCamposSubstituicaoMensagemPrincipal(new String[] {pNmAtributo});
	}

	/**
	 * Construtor da Exceção
	 * 
	 * @param	String	pNmEntidade	Nome da entidade
	 * @param	String	pNmAtributo	Nome do atributo
	 * @param	String	pDsDebug	Informação para debug
	 */
	public ExcecaoValorNuloNaoPermitido(String pNmEntidade, String pNmAtributo, String pDsDebug) {
		super("pNmEntidade = " + pNmEntidade + " | pNmAtributo = " + pNmAtributo + " | " + pDsDebug);

		this.setCdSistema(Constantes.SG_SISTEMA_COM_UTL);
		this.setCdTelaMensagemUsuario(13);
		
		this.setCamposSubstituicaoMensagemPrincipal(new String[] {pNmAtributo});
	}
}