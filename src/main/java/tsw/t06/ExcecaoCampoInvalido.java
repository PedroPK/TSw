/*
 * Este arquivo � propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informa��o nele contida pode ser
 * reproduzida, mostrada ou revelada sem permiss�o escrita da Sefaz-PE.
 */
package tsw.t06;

/**
 * Exce��o lan�ada quando um campo de um formul�rio � preenchido de forma errada.
 */
public class ExcecaoCampoInvalido extends ExcecaoGenerica {
	//~ Construtores ---------------------------------------------------------------------------------------------------------------

/**
         * Cria um novo objeto ExcecaoCampoInvalido.
         *
         * @param pTpDadoCampo  
         * @param pVlCampo  
         * @param pDsDebug  
         */
	public ExcecaoCampoInvalido(String pTpDadoCampo, Object pVlCampo, String pDsDebug) {
		this(pTpDadoCampo, pVlCampo, pDsDebug, null);
	}

/**
         */
	public ExcecaoCampoInvalido(String pTpDadoCampo, Object pVlCampo, String pDsDebug, Exception pExcecaoOrigem) {
		this(pTpDadoCampo, pVlCampo, pDsDebug, (Throwable) pExcecaoOrigem);
	}

/**
         */
	public ExcecaoCampoInvalido(String pTpDadoCampo, Object pVlCampo, String pDsDebug, Throwable pExcecaoOrigem) {
		super(pDsDebug + " | pTpDadoCampo = " + pTpDadoCampo + " | pVlCampo = " + pVlCampo, pExcecaoOrigem);

		this.setCdSistema(Constantes.SG_SISTEMA_COM_UTL);
		this.setCdTelaMensagemUsuario(5);

		this.setCamposSubstituicaoMensagemPrincipal(new String[] {
				pTpDadoCampo
			});
	}
}
