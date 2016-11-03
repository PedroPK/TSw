/*
 * Este arquivo é propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informação nele contida pode ser
 * reproduzida, mostrada ou revelada sem permissão escrita da Sefaz-PE.
 */

package tsw.t06;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Timestamp;

import javax.transaction.UserTransaction;

/**
 * Classe que representa o contexto do usuário dentro do Sistema.
 */
public class ContextoUsuario implements Serializable {
	//~ Atributos/inicializadores estaticos ----------------------------------------------------------------------------------------
	
	private static final long serialVersionUID = 5000L;

	/**
	 * -
	 */
	public static final String ID_OBJETO = "sfi.contexto_usuario";

	//~ Atributos de instancia -----------------------------------------------------------------------------------------------------

	private transient Connection aConexao;
	private Boolean aInEnderecoDomicilioValido = null;
	private Boolean aInSenhaVaiExpirar = null;
	private Integer aCdFuncao;
	private Integer aCdPessoa;
	private Short aCdTipoUsuario;
	private Short aTpRedeAcessoUsuario;
	private String aCdPropriedadeTransacao;
	private String aCdTransacao;
	private String aCdUsuario;
	private String aEnderecoIP;
	private String aIdLoginRede;
	private String aIdSessao;
	private String aNmDispositivoAcesso;
	private String aTpDispositivoAcesso;
	private String aIdEstacaoTrabalho;
	private String aNmClasseControladorTransacao;
	private String aNmClasseJob;
	private String aNmConexaoJNDI;
	private String aNmEstacao;
	private String aNmHost;
	private String aNmUsuario;
	private String aNmUsuarioSistemaOperacional;
	private Timestamp aDhUltimaAcao;
	private Timestamp aDhUltimoLogin;
	private transient UserTransaction aUserTransaction = null;
	private transient int aTpNivelIsolamentoTransacao = 0;
	private transient short aTpTransacao = Constantes.TP_TRANSACAO_JTA;
	private boolean aInJob = false;
	private boolean aInNaoFecharProximoPreparedStatement = false;
	private boolean aInUtilizarLockExclusivoProximaConsultaPorChavePrimaria = false;
	private int aQtDiasSenhaVaiExpirar;
	private int aQtHorasSenhaVaiExpirar;
	private short aTpPersistencia = Constantes.TP_PERSISTENCIA_EB;
	private Integer aQtMbArquivoTraceTransacao;

	//~ Construtores ---------------------------------------------------------------------------------------------------------------

	/**
	 * Cria um novo objeto ContextoUsuario.
	 *
	 * @param pCdUsuario
	 * @param pCdFuncao
	 */
	public ContextoUsuario(String pCdUsuario, Integer pCdFuncao) {
		this.aCdUsuario = pCdUsuario;
		this.aCdFuncao = pCdFuncao;

		if (this.isUsuarioAnonimo()) {
			this.aNmUsuario = "ANÔNIMO";
		}

		this.aNmUsuarioSistemaOperacional = Constantes.NM_USUARIO_SO;
	}

	/**
	 * Construtor utilizado na classe Job
	 *
	 * @param pCdUsuario
	 * @param pCdFuncao
	 * @param pNmEstacao
	 * @param pEnderecoIP
	 * @param pNmClasseJob
	 */
	public ContextoUsuario(String pCdUsuario, Integer pCdFuncao, String pEnderecoIP, String pNmEstacao, String pNmHost, String pNmClasseJob) {
		this.aCdUsuario = pCdUsuario;
		this.aCdFuncao = pCdFuncao;
		this.aNmEstacao = pNmEstacao;
		this.aEnderecoIP = pEnderecoIP;
		this.aNmHost = pNmHost;

		this.aInJob = true;
		this.aNmClasseJob = pNmClasseJob;

		if (this.isUsuarioAnonimo()) {
			this.aNmUsuario = "ANÔNIMO";
		}

		this.aNmUsuarioSistemaOperacional = Constantes.NM_USUARIO_SO;
	}

	/**
	 * Construtor utilizado na classe WebService
	 *
	 * @param pCdFuncao
	 * @param pEnderecoIP
	 * @param pNmEstacao
	 * @param pNmHost
	 */
	public ContextoUsuario(String pCdUsuario, Integer pCdFuncao, String pEnderecoIP, String pNmEstacao, String pNmHost) {
		this.aCdUsuario = pCdUsuario;
		this.aCdFuncao = pCdFuncao;
		this.aNmEstacao = pNmEstacao;
		this.aEnderecoIP = pEnderecoIP;
		this.aNmHost = pNmHost;

		this.aNmUsuarioSistemaOperacional = Constantes.NM_USUARIO_SO;
	}

	//~ Metodos --------------------------------------------------------------------------------------------------------------------

	/**
	 * -
	 *
	 * @return
	 */
	public String getIdSessao() {
		return this.aIdSessao;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getCdUsuario() {
		return this.aCdUsuario;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public Short getCdTipoUsuario() {
		return this.aCdTipoUsuario;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public Integer getCdPessoa() {
		return this.aCdPessoa;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmUsuario() {
		return this.aNmUsuario;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmUsuarioSistemaOperacional() {
		return this.aNmUsuarioSistemaOperacional;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getIdLoginRede() {
		return this.aIdLoginRede;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public Integer getCdFuncao() {
		return this.aCdFuncao;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getEnderecoIP() {
		return this.aEnderecoIP;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmEstacao() {
		return this.aNmEstacao;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmHost() {
		return this.aNmHost;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public Timestamp getDhUltimoLogin() {
		return this.aDhUltimoLogin;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public Timestamp getDhUltimaAcao() {
		return this.aDhUltimaAcao;
	}

	/**
	 * -
	 *
	 * @param pCdPropriedadeTransacao
	 */
	public void setCdPropriedadeTransacao(String pCdPropriedadeTransacao) {
		this.aCdPropriedadeTransacao = pCdPropriedadeTransacao;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getCdPropriedadeTransacao() {
		return this.aCdPropriedadeTransacao;
	}

	/**
	 * -
	 *
	 * @param pCdTransacao
	 */
	public void setCdTransacao(String pCdTransacao) {
		this.aCdTransacao = pCdTransacao;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getCdTransacao() {
		return this.aCdTransacao;
	}

	/**
	 * -
	 *
	 * @param pNmClasseControladorTransacao
	 */
	public void setNmClasseControladorTransacao(String pNmClasseControladorTransacao) {
		this.aNmClasseControladorTransacao = pNmClasseControladorTransacao;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmClasseControladorTransacao() {
		return this.aNmClasseControladorTransacao;
	}

	/**
	 * -
	 * @return
	 */
	public String getNmDispositivoAcesso() {
		return this.aNmDispositivoAcesso;
	}
	
	/**
	 * -
	 * @return
	 */
	public String getTpDispositivoAcesso() {
		return this.aTpDispositivoAcesso;
	}
	
	/**
	 * -
	 * @return
	 */
	public String getIdEstacaoTrabalho() {
		return this.aIdEstacaoTrabalho;
	}
	
	/**
	 * -
	 * @return
	 */
	public boolean isAcessoMovel() {
		String tpDispositivoAcesso = this.getTpDispositivoAcesso();

		return tpDispositivoAcesso != null
				&& tpDispositivoAcesso.length() > 0
				&& (Constantes.TP_DISPOSITIVO_ACESSO_TABLET.equals(tpDispositivoAcesso) || Constantes.TP_DISPOSITIVO_ACESSO_CELULAR
						.equals(tpDispositivoAcesso));
	}
	
	/**
	 * -
	 *
	 * @return
	 */
	public boolean isUsuarioAnonimo() {
		return this.aCdUsuario.equals(Constantes.CD_USUARIO_ANONIMO);
	}

	/**
	 * -
	 *
	 * @param pInEnderecoDomicilioValido
	 */
	public void setInEnderecoDomicilioValido(Boolean pInEnderecoDomicilioValido) {
		this.aInEnderecoDomicilioValido = pInEnderecoDomicilioValido;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public Boolean getInEnderecoDomicilioValido() {
		return this.aInEnderecoDomicilioValido;
	}

	/**
	 * -
	 *
	 * @param pInSenhaVaiExpirar
	 */
	public void setInSenhaVaiExpirar(Boolean pInSenhaVaiExpirar) {
		this.aInSenhaVaiExpirar = pInSenhaVaiExpirar;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public Boolean getInSenhaVaiExpirar() {
		return this.aInSenhaVaiExpirar;
	}

	/**
	 * -
	 *
	 * @param pQtDiasSenhaVaiExpirar
	 */
	public void setQtDiasSenhaVaiExpirar(int pQtDiasSenhaVaiExpirar) {
		this.aQtDiasSenhaVaiExpirar = pQtDiasSenhaVaiExpirar;
	}

	/**
	 * -
	 *
	 * @param pQtHorasSenhaVaiExpirar
	 */
	public void setQtHorasSenhaVaiExpirar(int pQtHorasSenhaVaiExpirar) {
		this.aQtHorasSenhaVaiExpirar = pQtHorasSenhaVaiExpirar;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public int getQtDiasSenhaVaiExpirar() {
		return this.aQtDiasSenhaVaiExpirar;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public int getQtHorasSenhaVaiExpirar() {
		return this.aQtHorasSenhaVaiExpirar;
	}

	/**
	 * -
	 *
	 * @param pTpTransacao
	 */
	public void setTpTransacao(short pTpTransacao) {
		this.aTpTransacao = pTpTransacao;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public short getTpTransacao() {
		if (this.aTpTransacao == 0) {
			// Na serialização este atributo vira 0 pois é transient.
			// É preciso redefinir o valor default
			this.aTpTransacao = Constantes.TP_TRANSACAO_JTA;
		}

		return this.aTpTransacao;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public boolean isTransacaoJTA() {
		return ContextoUsuario.isTransacaoJTA(this.getTpTransacao());
	}

	/**
	 * -
	 *
	 * @return
	 */
	public boolean isTransacaoJDBC() {
		return ContextoUsuario.isTransacaoJDBC(this.getTpTransacao());
	}

	/**
	 * -
	 *
	 * @param pTpTransacao
	 *
	 * @return
	 */
	public static boolean isTransacaoJTA(int pTpTransacao) {
		if ((pTpTransacao == Constantes.TP_TRANSACAO_JTA) ||
				((pTpTransacao == Constantes.TP_TRANSACAO_JTA_CRGC) || (pTpTransacao == Constantes.TP_TRANSACAO_JTA_BMT))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * -
	 *
	 * @param pTpTransacao
	 *
	 * @return
	 */
	public static boolean isTransacaoJDBC(int pTpTransacao) {
		if ((pTpTransacao == Constantes.TP_TRANSACAO_JDBC) || (pTpTransacao == Constantes.TP_TRANSACAO_JDBC_RGC)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * -
	 *
	 * @param pUserTransaction
	 */
	public void setUserTransaction(UserTransaction pUserTransaction) {
		this.aUserTransaction = pUserTransaction;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public UserTransaction getUserTransaction() {
		return this.aUserTransaction;
	}

	/**
	 * Utilizado em transações do tipo JDBC_RGC e JDBC_CRGC para controlar que PreparedStatements devem ser fechados. Deve ser
	 * chamado imediatamente antes do acesso ao DAO que retorna um OTDResultSet. O método DAO_BD.fecharConexao é responsável por
	 * fechar o PreparedStatement e resetar este indicador.
	 *
	 * @param pInNaoFecharProximoPreparedStatement
	 */
	public void setInNaoFecharProximoPreparedStatement(boolean pInNaoFecharProximoPreparedStatement) {
		this.aInNaoFecharProximoPreparedStatement = pInNaoFecharProximoPreparedStatement;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public boolean getInNaoFecharProximoPreparedStatement() {
		return this.aInNaoFecharProximoPreparedStatement;
	}

	/**
	 * Utilizado nos métodos alterar e excluir do Cadastro para garantir comparação correta do timestamp
	 *
	 * @param pInUtilizarLockExclusivoProximaConsultaPorChavePrimaria
	 */
	public void setInUtilizarLockExclusivoProximaConsultaPorChavePrimaria(
		boolean pInUtilizarLockExclusivoProximaConsultaPorChavePrimaria) {
		this.aInUtilizarLockExclusivoProximaConsultaPorChavePrimaria = pInUtilizarLockExclusivoProximaConsultaPorChavePrimaria;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public boolean getInUtilizarLockExclusivoProximaConsultaPorChavePrimaria() {
		return this.aInUtilizarLockExclusivoProximaConsultaPorChavePrimaria;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getDsTpTransacao() {
		String dsTpTransacao;

		if (this.aTpTransacao == Constantes.TP_TRANSACAO_JTA) {
			dsTpTransacao = "JTA";
		} else if (this.aTpTransacao == Constantes.TP_TRANSACAO_JTA_CRGC) {
			dsTpTransacao = "JTA com Conexão e ResultSet Gerenciados pelo Cliente";
		} else if (this.aTpTransacao == Constantes.TP_TRANSACAO_JDBC) {
			dsTpTransacao = "JDBC";
		} else if (this.aTpTransacao == Constantes.TP_TRANSACAO_JDBC_RGC) {
			dsTpTransacao = "JDBC com ResultSet Gerenciado pelo Cliente";
		} else {
			dsTpTransacao = "Não definido";
		}

		return dsTpTransacao;
	}

	/**
	 * -
	 *
	 * @param pTpNivelIsolamentoTransacao
	 */
	public void setTpNivelIsolamentoTransacao(int pTpNivelIsolamentoTransacao) {
		this.aTpNivelIsolamentoTransacao = pTpNivelIsolamentoTransacao;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public int getTpNivelIsolamentoTransacao() {
		return this.aTpNivelIsolamentoTransacao;
	}

	/**
	 * -
	 *
	 * @param pTpPersistencia
	 */
	public void setTpPersistencia(short pTpPersistencia) {
		this.aTpPersistencia = pTpPersistencia;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public Short getTpRedeAcessoUsuario() {
		return this.aTpRedeAcessoUsuario;
	}

	/**
	 * -
	 *
	 * @param pTpRedeAcessoUsuario
	 */
	public void setTpRedeAcessoUsuario(Short pTpRedeAcessoUsuario) {
		this.aTpRedeAcessoUsuario = pTpRedeAcessoUsuario;
	}


	/**
	 * -
	 *
	 * @return
	 */
	public short getTpPersistencia() {
		return this.aTpPersistencia;
	}

	/**
	 * -
	 *
	 * @param pConexao
	 */
	public void setConexao(Connection pConexao) {
		this.aConexao = pConexao;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public Connection getConexao() {
		return this.aConexao;
	}

	/**
	 * -
	 *
	 * @param pNmConexaoJNDI
	 */
	public void setNmConexaoJNDI(String pNmConexaoJNDI) {
		// Após a primeira RN definir o nome da conexão JNDI, outra RN não pode mais mudar, exceto para null
		if ((pNmConexaoJNDI == null) || (this.aNmConexaoJNDI == null)) {
			this.aNmConexaoJNDI = pNmConexaoJNDI;
		}
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmConexaoJNDI() {
		return this.aNmConexaoJNDI;
	}

	/**
	 * -
	 *
	 * @param pInJob
	 */
	protected void setInJob(boolean pInJob) {
		this.aInJob = pInJob;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public boolean isJob() {
		return this.aInJob;
	}

	/**
	 * -
	 *
	 * @param pNmClasseJob
	 */
	protected void setNmClasseJob(String pNmClasseJob) {
		this.aNmClasseJob = pNmClasseJob;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmClasseJob() {
		return this.aNmClasseJob;
	}

	/**
	 * -
	 * 
	 * @return
	 */
	protected Integer getQtMbArquivoTraceTransacao() {
		return this.aQtMbArquivoTraceTransacao;
	}
	
	/**
	 * -
	 * 
	 * @return
	 */
	protected void setQtMbArquivoTraceTransacao(Integer pQtMbArquivoTraceTransacao) {
		this.aQtMbArquivoTraceTransacao = pQtMbArquivoTraceTransacao;
	}

	/**
	 * -
	 *
	 * @param pCdUsuario
	 *
	 * @throws ExcecaoSistema
	 */
	public void forcarCdUsuarioJob(String pCdUsuario) throws ExcecaoSistema {
		if (this.isJob()) {
			this.aCdUsuario = pCdUsuario;
		} else {
			throw new ExcecaoSistema("Só é permitido forçar um CdUsuario dentro do ContextoUsuario de Jobs | " + this.toString());
		}
	}

	/**
	 * -
	 *
	 * @param pArgs
	 */
	public static void main(String[] pArgs) {
		ContextoUsuario contextoUsuario = new ContextoUsuario("1", new Integer("10"));
		contextoUsuario.setNmConexaoJNDI("teste1");
		contextoUsuario.setNmConexaoJNDI("teste2");
	}
}
