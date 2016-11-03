/*
 * Este arquivo � propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informa��o nele contida pode ser
 * reproduzida, mostrada ou revelada sem permiss�o escrita da Sefaz-PE.
 */

package tsw.t06;

/**
 * Exce��o lan�ada quando um atributo String de uma entidade � preenchido com um tamanho errado
 */
public class ExcecaoTamanhoAtributoInvalido extends ExcecaoAtributoInvalido {
	//~ Construtores ---------------------------------------------------------------------------------------------------------------

	/**
	 * Construtor da Exce��o
	 *
	 * @param pNmEntidade pNmEntidade    Nome da entidade
	 * @param pNmAtributo pNmCampo    Nome do atributo
	 * @param pTamanhoMinimoPermitido pTamanhoMinimoPermitido    Valor m�nimo permitido para o atributo
	 * @param pTamanhoMaximoPermitido pTamanhoMaximoPermitido    Valor m�ximo permitido para o atributo
	 * @param pDsDebug pDsDebug    Informa��o para debug
	 */
	public ExcecaoTamanhoAtributoInvalido(String pNmEntidade, String pNmAtributo, String pTamanhoMinimoPermitido,
		String pTamanhoMaximoPermitido, String pDsDebug) {
		super("pNmEntidade = " + pNmEntidade + " | pNmAtributo = " + pNmAtributo + " | pTamanhoMinimoPermitido = " +
			pTamanhoMinimoPermitido + " | pTamanhoMaximoPermitido = " + pTamanhoMaximoPermitido + " | " + pDsDebug);

		this.setCdSistema(Constantes.SG_SISTEMA_COM_UTL);
		this.setCdTelaMensagemUsuario(10);

		this.setCamposSubstituicaoMensagemPrincipal(new String[] {
				pNmAtributo,
				pTamanhoMinimoPermitido,
				pTamanhoMaximoPermitido
			});
	}
}
