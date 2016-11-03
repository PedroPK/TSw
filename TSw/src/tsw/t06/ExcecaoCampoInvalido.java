/*
 * Este arquivo é propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informação nele contida pode ser
 * reproduzida, mostrada ou revelada sem permissão escrita da Sefaz-PE.
 */
package tsw.t06;

/**
 * Exceção lançada quando um campo de um formulário é preenchido de forma errada.
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
