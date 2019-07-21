/*
 * Este arquivo é propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informação nele contida pode ser
 * reproduzida, mostrada ou revelada sem permissão escrita da Sefaz-PE.
 */

package tsw.t06;

/**
 * Exceção lançada quando um atributo String de uma entidade é preenchido com um tamanho errado
 */
public class ExcecaoTamanhoAtributoInvalido extends ExcecaoAtributoInvalido {
	//~ Construtores ---------------------------------------------------------------------------------------------------------------

	/**
	 * Construtor da Exceção
	 *
	 * @param pNmEntidade pNmEntidade    Nome da entidade
	 * @param pNmAtributo pNmCampo    Nome do atributo
	 * @param pTamanhoMinimoPermitido pTamanhoMinimoPermitido    Valor mínimo permitido para o atributo
	 * @param pTamanhoMaximoPermitido pTamanhoMaximoPermitido    Valor máximo permitido para o atributo
	 * @param pDsDebug pDsDebug    Informação para debug
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
