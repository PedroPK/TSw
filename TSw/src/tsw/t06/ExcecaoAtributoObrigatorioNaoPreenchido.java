package tsw.t06;

/**
 * Exceção lançada quando se tenta colocar um valor nulo em um atributo de uma entidade que não aceita nulo 
 */
public class ExcecaoAtributoObrigatorioNaoPreenchido extends ExcecaoAtributoInvalido {

	/**
	 * Construtor da Exceção
	 * 
	 * @param	String	pNmAtributo	Nome do atributo
	 * @param	String	pDsDebug	Informação para debug
	 */
	public ExcecaoAtributoObrigatorioNaoPreenchido(String pNmAtributo, String pDsDebug) {
		this(null, pNmAtributo, pDsDebug);
	}

	/**
	 * Construtor da Exceção
	 * 
	 * @param	String	pNmEntidade	Nome da entidade
	 * @param	String	pNmAtributo	Nome do atributo
	 * @param	String	pDsDebug	Informação para debug
	 */
	public ExcecaoAtributoObrigatorioNaoPreenchido(String pNmEntidade, String pNmAtributo, String pDsDebug) {
		super("pNmEntidade = " + pNmEntidade + " | pNmAtributo = " + pNmAtributo + " | " + pDsDebug);
		
		this.setCdSistema(Constantes.SG_SISTEMA_COM_UTL);
		this.setCdTelaMensagemUsuario(4);
		
		this.setCamposSubstituicaoMensagemPrincipal(new String[] {pNmAtributo});
	}
}