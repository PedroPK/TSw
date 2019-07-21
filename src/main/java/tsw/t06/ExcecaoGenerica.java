/*
 * Este arquivo é propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informação nele contida pode ser
 * reproduzida, mostrada ou revelada sem permissão escrita da Sefaz-PE.
 */
package tsw.t06;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Hashtable;

/**
 * Esta classe representa uma exceção genérica com todos os parâmetros necessários para o registro de um LOG de erros claro e
 * bem definido. Esta classe será a superclasse de todas as exceções do sistema.
 */
public abstract class ExcecaoGenerica extends Exception {
	//~ Atributos/inicializadores estaticos ----------------------------------------------------------------------------------------

	private static SecureRandom aSecureRandom;

	static {
		aSecureRandom = new SecureRandom();
	}

	//~ Atributos de instancia -----------------------------------------------------------------------------------------------------

	/**
	 * Representa a data e a hora da ocorrência da Exceção
	 */
	private Date aDhExcecao;

	/**
	 * 
	 */
	private Hashtable aCamposOcultosTelaMensagemUsuario;

	/**
	 * 
	 */
	private String aCdSistema;

	/**
	 * Mensagem de debug da Exceção
	 */
	private String aDsDebug;

	/**
	 * 
	 */
	private String aIdExcecao;

	/**
	 * 
	 */
	private String aNmLocalhost;

	/**
	 * 
	 */
	private String aNuIPLocalhost;

	/**
	 * Utilizado para exibir um detalhamento maior, que vai além das mensagens. Mostra os dados de forma estruturada na
	 * tela.
	 */
	private String aTxHTMLAdicional;

	/**
	 * Utilizado para transferir mensagens da camada de negócio para um cliente (servlet ou job) ao se lançar uma exceção
	 */
	private String aTxMensagem;

	/**
	 * Representa o stacktrace da Exceção origem
	 */
	private String aTxStackTrace;

	/**
	 * Representa a Exceção origem
	 */
	private Throwable aExcecaoOrigem = null;

	/**
	 * 
	 */
	private String[] aCamposSubstituicaoMensagemComplementar;

	/**
	 * 
	 */
	private String[] aCamposSubstituicaoMensagemOrientacao;

	/**
	 * 
	 */
	private String[] aCamposSubstituicaoMensagemPrincipal;

	/**
	 * 
	 */
	private String[] aCamposSubstituicaoMensagemSuporte;

	/**
	 * Utilizado para indicar que não é necessário fazer rollback na transação
	 */
	private boolean aInRollbackTransacao = true;

	/**
	 * Código da mensagem complementar que deve ser exibida no campo suporte da tela de mensagem ao usuário
	 */
	private int aCdMensagemSuporte;

	/**
	 * 
	 */
	private int aCdTelaMensagemUsuario;

	//~ Construtores ---------------------------------------------------------------------------------------------------------------

/**
         * Cria um novo objeto ExcecaoGenerica.
         *
         * @param pDsDebug
         */
	public ExcecaoGenerica(String pDsDebug) {
		this(pDsDebug, null);
	}

/**
         * Construtor
         *
         * @param pDsDebug pDsDebug
         * @param pExcecaoOrigem pExcecaoOrigem Representa a exceção que foi originalmente gerada pela JVM
         */
	public ExcecaoGenerica(String pDsDebug, Throwable pExcecaoOrigem) {
		super(pDsDebug);

		this.aDsDebug = pDsDebug;
		this.aExcecaoOrigem = pExcecaoOrigem;
		this.aDhExcecao = new Date();

		this.aNmLocalhost = BibliotecaFuncoesPrincipal.getNmLocalhost();
		this.aNuIPLocalhost = BibliotecaFuncoesPrincipal.getNuIPLocalhost();

		this.aCdSistema = Constantes.SG_SISTEMA_COM_UTL;
		this.aCdTelaMensagemUsuario = Constantes.CD_TELA_MSGUSR_ERRO;
	}

	//~ Metodos --------------------------------------------------------------------------------------------------------------------

	/**
	 * -
	 *
	 * @return
	 */
	public String getIdExcecao() {
		if (this.aIdExcecao == null) {
			int rand = aSecureRandom.nextInt();
			String octRand = Integer.toOctalString(rand);

			if (octRand.length() == 16) {
				octRand = octRand + "1";
			}
			
			return this.aIdExcecao = BibliotecaFuncoesDataHora.getDataHoraComoStringInvertida(this.aDhExcecao) + octRand;
		}
		
		return this.aIdExcecao;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmLocalhost() {
		return this.aNmLocalhost;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNuIPLocalHost() {
		return this.aNuIPLocalhost;
	}

	/**
	 * -
	 *
	 * @param pCdSistema
	 */
	protected void setCdSistema(String pCdSistema) {
		this.aCdSistema = pCdSistema;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getCdSistema() {
		return this.aCdSistema;
	}

	/**
	 * -
	 *
	 * @param pCdTelaMensagemUsuario
	 */
	protected void setCdTelaMensagemUsuario(int pCdTelaMensagemUsuario) {
		this.aCdTelaMensagemUsuario = pCdTelaMensagemUsuario;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public int getCdTelaMensagemUsuario() {
		return this.aCdTelaMensagemUsuario;
	}

	/**
	 * -
	 *
	 * @param pCamposSubstituicaoMensagemPrincipal
	 */
	protected void setCamposSubstituicaoMensagemPrincipal(String[] pCamposSubstituicaoMensagemPrincipal) {
		this.aCamposSubstituicaoMensagemPrincipal = pCamposSubstituicaoMensagemPrincipal;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String[] getCamposSubstituicaoMensagemPrincipal() {
		return this.aCamposSubstituicaoMensagemPrincipal;
	}

	/**
	 * -
	 *
	 * @param pCamposSubstituicaoMensagemComplementar
	 */
	protected void setCamposSubstituicaoMensagemComplementar(String[] pCamposSubstituicaoMensagemComplementar) {
		this.aCamposSubstituicaoMensagemComplementar = pCamposSubstituicaoMensagemComplementar;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String[] getCamposSubstituicaoMensagemComplementar() {
		return this.aCamposSubstituicaoMensagemComplementar;
	}

	/**
	 * -
	 *
	 * @param pCamposSubstituicaoMensagemOrientacao
	 */
	protected void setCamposSubstituicaoMensagemOrientacao(String[] pCamposSubstituicaoMensagemOrientacao) {
		this.aCamposSubstituicaoMensagemOrientacao = pCamposSubstituicaoMensagemOrientacao;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String[] getCamposSubstituicaoMensagemOrientacao() {
		return this.aCamposSubstituicaoMensagemOrientacao;
	}

	/**
	 * -
	 *
	 * @param pCamposOcultosTelaMensagemUsuario
	 */
	public void setCamposOcultosTelaMensagemUsuario(Hashtable pCamposOcultosTelaMensagemUsuario) {
		this.aCamposOcultosTelaMensagemUsuario = pCamposOcultosTelaMensagemUsuario;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public Hashtable getCamposOcultosTelaMensagemUsuario() {
		return this.aCamposOcultosTelaMensagemUsuario;
	}

	/**
	 * Retorna a data da Exceção
	 *
	 * @return java.util.Date
	 */
	public Date getDhExcecao() {
		return this.aDhExcecao;
	}

	/**
	 * Retorna a mensagem de debug da Exceção
	 *
	 * @return java.lang.String
	 */
	public String getDsDebug() {
		return this.aDsDebug;
	}

	/**
	 * Adiciona uma String em DsDebug
	 *
	 * @param pDsDebug
	 */
	public void adicionarDsDebug(String pDsDebug) {
		this.aDsDebug = this.aDsDebug + "\r\n" + pDsDebug;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getTxMensagem() {
		return this.aTxMensagem;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getTxHTMLAdicional() {
		return this.aTxHTMLAdicional;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param pTxMensagem
	 */
	public void setTxMensagem(String pTxMensagem) {
		this.aTxMensagem = pTxMensagem;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param pTxHTMLAdicional
	 */
	protected void setTxHTMLAdicional(String pTxHTMLAdicional) {
		this.aTxHTMLAdicional = pTxHTMLAdicional;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public Throwable getExcecaoOrigem() {
		return this.aExcecaoOrigem;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getTxStackTrace() {
		if (this.aTxStackTrace == null && this.aExcecaoOrigem != null) {
			this.aTxStackTrace = BibliotecaFuncoesPrincipal.getStackTrace(this.aExcecaoOrigem);
		}

		return this.aTxStackTrace;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public boolean getInRollbackTransacao() {
		return this.aInRollbackTransacao;
	}

	/**
	 * -
	 *
	 * @param pCdMensagemSuporte
	 */
	protected void setCdMensagemSuporte(int pCdMensagemSuporte) {
		this.aCdMensagemSuporte = pCdMensagemSuporte;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public int getCdMensagemSuporte() {
		return this.aCdMensagemSuporte;
	}

	/**
	 * -
	 *
	 * @param pCamposSubstituicaoMensagemSuporte
	 */
	protected void setCamposSubstituicaoMensagemSuporte(String[] pCamposSubstituicaoMensagemSuporte) {
		this.aCamposSubstituicaoMensagemSuporte = pCamposSubstituicaoMensagemSuporte;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String[] getCamposSubstituicaoMensagemSuporte() {
		return this.aCamposSubstituicaoMensagemSuporte;
	}

	/**
	 * -
	 *
	 * @param pInRollbackTransacao
	 */
	protected void setInRollbackTransacao(boolean pInRollbackTransacao) {
		this.aInRollbackTransacao = pInRollbackTransacao;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public Throwable getExcecaoRaiz() {
		Throwable excecaoRaiz = this;

		if (this.getExcecaoOrigem() != null) {
			excecaoRaiz = this.getExcecaoRaiz(this.getExcecaoOrigem());
		}

		return excecaoRaiz;
	}

	/**
	 * -
	 *
	 * @param pExcecao
	 *
	 * @return
	 */
	private Throwable getExcecaoRaiz(Throwable pExcecao) {
		Throwable excecaoRaiz = pExcecao;

		if (pExcecao instanceof ExcecaoGenerica) {
			ExcecaoGenerica excecao = (ExcecaoGenerica) pExcecao;

			if (excecao.getExcecaoOrigem() != null) {
				excecaoRaiz = this.getExcecaoRaiz(excecao.getExcecaoOrigem());
			}
		}

		return excecaoRaiz;
	}

}
