/*
 * Este arquivo é propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informação nele contida pode ser
 * reproduzida, mostrada ou revelada sem permissão escrita da Sefaz-PE.
 */
package tsw.t06;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * 
 */
public abstract class DAO_BD extends DAO {
	//~ Atributos/inicializadores estaticos ----------------------------------------------------------------------------------------

	private static final Map<String, DataSource> DATA_SOURCES = new ConcurrentHashMap<String, DataSource>(64);
	private static final Map<String, String> aTbStatementsSQL = new ConcurrentHashMap<String, String>(256);

	//~ Atributos de instancia -----------------------------------------------------------------------------------------------------

	private String aNmConexaoJNDI;

	//~ Construtores ---------------------------------------------------------------------------------------------------------------

/**
         * Cria um novo objeto DAO_BD.
         */
	public DAO_BD() {
	}

/**
         * Cria um novo objeto DAO_BD.
         *
         * @param pNmConexaoJNDI
         */
	public DAO_BD(String pNmConexaoJNDI) {
		this.aNmConexaoJNDI = pNmConexaoJNDI;
	}

	//~ Metodos --------------------------------------------------------------------------------------------------------------------

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmConexaoJNDI() {
		return this.aNmConexaoJNDI;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param pNmConexaoJNDI
	 * @param pInLookupGlobal
	 *
	 * @return
	 *
	 * @throws ExcecaoSistema
	 */
	public static Connection getConexao(String pNmConexaoJNDI, boolean pInLookupGlobal)
		throws ExcecaoSistema {
		DataSource ds = null;
		Connection conexao = null;
		Properties env = null;
		InitialContext contextoInicial;
		String nmPropriedadeProviderURL = null;

		try {
			if (Parametros.getInstancia().isJ2EE14Ativado() && !pInLookupGlobal) {
				pNmConexaoJNDI = "java:comp/env/" + pNmConexaoJNDI + "_rc";
			}

			ds = DATA_SOURCES.get(pNmConexaoJNDI);

			if (ds == null) {
				env = new Properties();
				env.put(Context.INITIAL_CONTEXT_FACTORY, "com.ibm.websphere.naming.WsnInitialContextFactory");

				nmPropriedadeProviderURL = Constantes.NM_PROVIDER_URL_FONTE_DADOS_JDBC;

				if (nmPropriedadeProviderURL != null) {
					env.put(Context.PROVIDER_URL, nmPropriedadeProviderURL);
				} else {
					env.put(Context.PROVIDER_URL, Parametros.getInstancia().getNmProviderURLConexaoBD());
				}

				long tsInicioLookup = 0;

				DATA_SOURCES.put(pNmConexaoJNDI, ds);
			}

			boolean inErro = true;

			try {
				conexao = ds.getConnection();
				inErro = false;
			} finally {
				if (inErro) {
					DATA_SOURCES.remove(pNmConexaoJNDI);
				}
			}
		} catch (SQLException e) {
			throw new ExcecaoSistema("Conexão JNDI não disponível (pNmConexaoJNDI = " + pNmConexaoJNDI + " | NmProviderURL = " +
				Parametros.getInstancia().getNmProviderURLConexaoBD() + ")", e);
		}

		return conexao;
	}

	/**
	 * -
	 *
	 * @param pNmConexaoJNDI
	 *
	 * @return
	 *
	 * @throws ExcecaoSistema
	 */
	public static Connection getConexao(String pNmConexaoJNDI)
		throws ExcecaoSistema {
		return DAO_BD.getConexao(pNmConexaoJNDI, false);
	}

	/**
	 * -
	 *
	 * @param pNmConexaoJNDI
	 *
	 * @return
	 *
	 * @throws ExcecaoSistema
	 */
	public static Connection getConexaoJob(String pNmConexaoJNDI)
		throws ExcecaoSistema {
		return DAO_BD.getConexao(pNmConexaoJNDI, true);
	}

	/**
	 * -
	 *
	 * @param pNmConexaoJNDI
	 * @param pTsInicioLookup
	 * @param pTsFimLookup
	 */
	private static void registrarLogDataSourceLookup(String pNmConexaoJNDI, long pTsInicioLookup, long pTsFimLookup) {
		String txLogParte01 = "[DAO_BD.getConexao] DataSource lookup executado em [";
		String txLogParte02 = Long.toString(pTsFimLookup - pTsInicioLookup);
		String txLogParte03 = "] ms para [";
		String txLogParte05 = "]";
		String txLogParte06 = " | Thread = [";
		String txLogParte07 = Thread.currentThread().getName();
		String txLogParte08 = "]";

		StringBuilder sbTxLog = new StringBuilder(txLogParte01.length() + txLogParte02.length() + txLogParte03.length() +
				pNmConexaoJNDI.length() + txLogParte05.length() + txLogParte06.length() + txLogParte07.length() +
				txLogParte08.length());

		sbTxLog.append(txLogParte01);
		sbTxLog.append(txLogParte02);
		sbTxLog.append(txLogParte03);
		sbTxLog.append(pNmConexaoJNDI);
		sbTxLog.append(txLogParte05);
		sbTxLog.append(txLogParte06);
		sbTxLog.append(txLogParte07);
		sbTxLog.append(txLogParte08);

	}

	/**
	 * -
	 *
	 * @param pContextoUsuario
	 * @param pNmClasse
	 * @param pConexao
	 * @param pPreStmt
	 *
	 * @throws ExcecaoGenerica
	 */
	public static void fecharConexao(ContextoUsuario pContextoUsuario, String pNmClasse, Connection pConexao,
		PreparedStatement pPreStmt) throws ExcecaoGenerica {
		// Se for transação JTA_CRGC ou JDBC_RGC, não fecha nada. Quem deve fechar a conexão e o resultset é o cliente.
		if (((pContextoUsuario.getTpTransacao() != Constantes.TP_TRANSACAO_JTA_CRGC) &&
				(pContextoUsuario.getTpTransacao() != Constantes.TP_TRANSACAO_JDBC_RGC)) ||
				!pContextoUsuario.getInNaoFecharProximoPreparedStatement()) {
			try {
				if (pPreStmt != null) {
					pPreStmt.close();
				}

				if (pContextoUsuario.getTpTransacao() == Constantes.TP_TRANSACAO_JTA) {
					// Se for transação JTA, fecha a conexão devolvendo para o pool
					if (pConexao != null) {
						pConexao.close();
					}
				}
			} catch (SQLException e) {
				DAO.tratarExcecao(pNmClasse, "pContextoUsuario = " + pContextoUsuario + " | Erro fechando conexão", e);
			}
		}

		if (pContextoUsuario.getInNaoFecharProximoPreparedStatement()) {
			// Reseta o indicador de fechamento de PreparedStatements
			pContextoUsuario.setInNaoFecharProximoPreparedStatement(false);
		}
	}

	/**
	 * Transforma o resultset passado como parâmetro em uma coleção de VOGenerico
	 *
	 * @param pResultSet
	 *
	 * @return
	 *
	 * @throws Exception
	 */
	public static ArrayList getResultSetComoColecao(ResultSet pResultSet)
		throws Exception {
		ArrayList colecao = null;

		colecao = DAO_BD.getResultSetComoColecao(pResultSet, false);

		return colecao;
	}

	/**
	 * Transforma o resultset passado como parâmetro em uma coleção de VOGenerico
	 *
	 * @param pResultSet
	 * @param pInExtrairBLOBComoArrBytes
	 *
	 * @return
	 *
	 * @throws Exception
	 */
	public static ArrayList<VOGenerico> getResultSetComoColecao(ResultSet pResultSet, boolean pInExtrairBLOBComoArrBytes)
		throws Exception {
		return getResultSetComoColecao(pResultSet, pInExtrairBLOBComoArrBytes, pInExtrairBLOBComoArrBytes);
	}

	/**
	 * Transforma o resultset passado como parâmetro em uma coleção de VOGenerico
	 *
	 * @param pResultSet
	 * @param pInExtrairBLOB
	 * @param pInExtrairBLOBComoArrBytes
	 *
	 * @return
	 *
	 * @throws Exception
	 * @throws ExcecaoQuantidadeRegistrosConsultaAcimaLimite
	 */
	public static ArrayList<VOGenerico> getResultSetComoColecao(ResultSet pResultSet, boolean pInExtrairBLOB,
		boolean pInExtrairBLOBComoArrBytes) throws Exception {
		ArrayList<VOGenerico> colecao = new ArrayList<VOGenerico>();
		int qtLimiteRegistrosConsulta = Parametros.getInstancia().getQtLimiteRegistrosConsulta();
		int qtRegistrosReferencia = qtLimiteRegistrosConsulta / 2;

		ResultSetMetaData metaData = pResultSet.getMetaData();
		int qtColunas = metaData.getColumnCount();

		String[] arrNmColuna = new String[qtColunas];
		int[] arrTpColuna = new int[qtColunas];
		Class<?>[] arrTpJavaColuna = new Class<?>[qtColunas];

		for (int i = 0; i < qtColunas; i++) {
			int ixColuna = i + 1;

			arrNmColuna[i] = metaData.getColumnName(ixColuna);

			int tpColuna = getTipoColuna(metaData, ixColuna);
			arrTpColuna[i] = tpColuna;

			arrTpJavaColuna[i] = DAO_BD.getTipoJavaColuna(tpColuna);
		}

		while (pResultSet.next()) {
			VOGenerico voGenerico = new VOGenerico(qtColunas);

			for (int i = 0; i < qtColunas; i++) {
				String nmColuna = arrNmColuna[i];
				int tpColuna = arrTpColuna[i];
				Class<?> tpJavaColuna = arrTpJavaColuna[i];
				int ixColuna = i + 1;

				if (tpColuna == Types.CLOB) {
					incluirCLOB(pResultSet, voGenerico, nmColuna);
				} else if (tpColuna == Types.BLOB) {
					if (pInExtrairBLOB) {
						if (pInExtrairBLOBComoArrBytes) {
							incluirBLOBComoArrBytes(pResultSet, voGenerico, ixColuna, nmColuna);
						}
					}
				} else if (tpColuna == Types.SQLXML) {
					incluirSQLXML(pResultSet, voGenerico, ixColuna, nmColuna, tpJavaColuna);
				} else {
					Object vlColuna = pResultSet.getObject(ixColuna);
					voGenerico.incluirAtributoSemSync(nmColuna, vlColuna, tpJavaColuna);
				}
			}

			colecao.add(voGenerico);

			int qtRegistros = colecao.size();

		}

		return colecao;
	}

	/**
	 * Transforma o resultset passado como parâmetro em um VOGenerico
	 *
	 * @param pResultSet
	 *
	 * @return
	 *
	 * @throws Exception
	 */
	public static VOGenerico getResultSetComoVOGenerico(ResultSet pResultSet)
		throws Exception {
		VOGenerico voGenerico = null;

		voGenerico = DAO_BD.getResultSetComoVOGenerico(pResultSet, true);

		return voGenerico;
	}

	/**
	 * Transforma o resultset passado como parâmetro em um VOGenerico
	 *
	 * @param pResultSet
	 * @param pInExtrairBLOBComoArquivo
	 *
	 * @return
	 *
	 * @throws Exception
	 */
	public static VOGenerico getResultSetComoVOGenerico(ResultSet pResultSet, boolean pInExtrairBLOBComoArquivo)
		throws Exception {
		VOGenerico voGenerico = null;

		voGenerico = DAO_BD.getResultSetComoVOGenerico(pResultSet, pInExtrairBLOBComoArquivo, false);

		return voGenerico;
	}

	/**
	 * Transforma o resultset passado como parâmetro em um VOGenerico
	 *
	 * @param pResultSet
	 * @param pInExtrairBLOBComoArquivo
	 * @param pInExtrairBLOBComoArrayBytes
	 *
	 * @return
	 *
	 * @throws Exception
	 */
	public static VOGenerico getResultSetComoVOGenerico(ResultSet pResultSet, boolean pInExtrairBLOBComoArquivo,
		boolean pInExtrairBLOBComoArrayBytes) throws Exception {
		ResultSetMetaData metaData = pResultSet.getMetaData();
		int qtColunas = metaData.getColumnCount();
		VOGenerico voGenerico = new VOGenerico(qtColunas);

		for (int i = 0; i < qtColunas; i++) {
			int ixColuna = i + 1;
			String nmColuna = metaData.getColumnName(ixColuna);
			int tpColuna = getTipoColuna(metaData, ixColuna);

			if (tpColuna == Types.CLOB) {
				incluirCLOB(pResultSet, voGenerico, nmColuna);
			} else {
				Class<?> tpJavaColuna = DAO_BD.getTipoJavaColuna(tpColuna);

				if (tpColuna == Types.BLOB) {
					if (pInExtrairBLOBComoArrayBytes) {
						incluirBLOBComoArrBytes(pResultSet, voGenerico, ixColuna, nmColuna);
					}
				} else if (tpColuna == Types.SQLXML) {
					incluirSQLXML(pResultSet, voGenerico, ixColuna, nmColuna, tpJavaColuna);
				} else {
					Object vlColuna = pResultSet.getObject(ixColuna);
					voGenerico.incluirAtributoSemSync(nmColuna, vlColuna, tpJavaColuna);
				}
			}
		}

		return voGenerico;
	}

	/**
	 * -
	 *
	 * @param pMetaData
	 * @param pIxColuna
	 *
	 * @return
	 *
	 * @throws Exception
	 */
	private static int getTipoColuna(ResultSetMetaData pMetaData, int pIxColuna)
		throws Exception {
		int tpColunaBanco = pMetaData.getColumnType(pIxColuna);

		if (tpColunaBanco == Types.OTHER) {
			String nmClasseColuna = pMetaData.getColumnClassName(pIxColuna);

			if (nmClasseColuna.indexOf("DB2Xml") > -1) {
				tpColunaBanco = Types.SQLXML;
			}
		}

		return tpColunaBanco;
	}

	/**
	 * -
	 *
	 * @param pResultSet
	 * @param pVOGenerico
	 * @param pNmColuna
	 *
	 * @throws Exception
	 */
	private static void incluirCLOB(ResultSet pResultSet, VOGenerico pVOGenerico, String pNmColuna)
		throws Exception {
		StringBuffer clobStringBuffer = DAO_BD.getCLOBComoStringBuffer(pResultSet, pNmColuna);

		pVOGenerico.incluirAtributoSemSync(pNmColuna, clobStringBuffer, StringBuffer.class);
	}

	/**
	 * -
	 *
	 * @param pResultSet
	 * @param pVOGenerico
	 * @param pIxColuna
	 * @param pNmColuna
	 *
	 * @throws Exception
	 */
	private static void incluirBLOBComoArrBytes(ResultSet pResultSet, VOGenerico pVOGenerico, int pIxColuna, String pNmColuna)
		throws Exception {
		byte[] bytesBlob = pResultSet.getBytes(pIxColuna);

	}

	/**
	 * -
	 *
	 * @param pResultSet
	 * @param pVOGenerico
	 * @param pIxColuna
	 * @param pNmColuna
	 * @param pTpJavaColuna
	 *
	 * @throws Exception
	 */
	private static void incluirSQLXML(ResultSet pResultSet, VOGenerico pVOGenerico, int pIxColuna, String pNmColuna,
		Class<?> pTpJavaColuna) throws Exception {

		String strXML = pResultSet.getString(pIxColuna);

	}

	/**
	 * -
	 *
	 * @param pContextoUsuario
	 * @param pExcecao
	 * @param pSql
	 *
	 * @throws ExcecaoGenerica
	 */
	protected void tratarExcecao(ContextoUsuario pContextoUsuario, Exception pExcecao, String pSql)
		throws ExcecaoGenerica {
		super.tratarExcecao("pContextoUsuario = " + pContextoUsuario + " | pSql = " + pSql + " | pExcecao = " + pExcecao + " [" +
			pExcecao.getMessage() + "]", pExcecao);
	}

	/**
	 * -
	 *
	 * @param pContextoUsuario
	 * @param pConexao
	 * @param pPreStmt
	 *
	 * @throws ExcecaoGenerica
	 */
	protected void fecharConexao(ContextoUsuario pContextoUsuario, Connection pConexao, PreparedStatement pPreStmt)
		throws ExcecaoGenerica {
		DAO_BD.fecharConexao(pContextoUsuario, this.getClass().getName(), pConexao, pPreStmt);
	}

	/**
	 * -
	 *
	 * @param pConexao
	 *
	 * @throws ExcecaoSistema
	 */
	public static void configurarConexaoTransacaoJDBC(Connection pConexao)
		throws ExcecaoSistema {
		String sql = "";
		int qtSegundosTimeout = 0;
		PreparedStatement preStmt = null;

		try {
			// Define timeout
			qtSegundosTimeout = Parametros.getInstancia().getVlLockTimeoutTransacaoJDBC();
			sql = "SET CURRENT LOCK TIMEOUT " + qtSegundosTimeout;

			preStmt = pConexao.prepareStatement(sql);
			preStmt.execute();

			// Define autocommit
			pConexao.setAutoCommit(false);
		} catch (Exception e) {
			String nmUsuarioBD = "[não disponível]";

			try {
				nmUsuarioBD = pConexao.getMetaData().getUserName();
			} catch (SQLException sqle) {
			}

			throw new ExcecaoSistema("Erro configurando conexão (Usuário BD: " + nmUsuarioBD + ") | sql = " + sql, e);
		}
	}

	/**
	 * -
	 *
	 * @param pContextoUsuario
	 * @param pVOEntidade
	 *
	 * @throws Exception
	 */
	public void incluir(ContextoUsuario pContextoUsuario, VOEntidade pVOEntidade)
		throws Exception {
		String sql = null;
		StringBuilder sqlBuffer = null;
		Iterator nmAtributosPersistencia = null;
		String atributo = null;
		int tpColunaBanco;
		Class tpAtributo = null;
		Connection conexao = null;
		PreparedStatement preStmt = null;

		StringBuffer clob = null;
		byte[] bytesClob = null;
		byte[] bytesBlob = null;
		InputStream streamClob = null;
		Reader readerClob = null;
		Arquivo blob = null;
		InputStream streamBlob = null;
		ArrayList<Arquivo> blobs = new ArrayList<Arquivo>();
		Iterator itBlobs = null;

		try {
			sql = (String) DAO_BD.aTbStatementsSQL.get("incluir_" + pVOEntidade.getClass().getName());

			if (sql == null) {
				sqlBuffer = new StringBuilder(64);
				sqlBuffer.append("INSERT INTO ");
				sqlBuffer.append(pVOEntidade.getNmEntidade() + " (");

				nmAtributosPersistencia = pVOEntidade.getNmAtributosPersistencia().iterator();

				boolean flgPrimeiroAtributo = true;

				while (nmAtributosPersistencia.hasNext()) {
					atributo = (String) nmAtributosPersistencia.next();

					if (flgPrimeiroAtributo == false) {
						sqlBuffer.append(", ");
					} else {
						flgPrimeiroAtributo = false;
					}

					sqlBuffer.append(atributo);
				}

				sqlBuffer.append(") VALUES (");

				nmAtributosPersistencia = pVOEntidade.getNmAtributosPersistencia().iterator();
				flgPrimeiroAtributo = true;

				while (nmAtributosPersistencia.hasNext()) {
					atributo = (String) nmAtributosPersistencia.next();
					tpAtributo = pVOEntidade.getTipoAtributoInstancia(atributo);

					if (flgPrimeiroAtributo == false) {
						sqlBuffer.append(", ");
					} else {
						flgPrimeiroAtributo = false;
					}

				}

				sqlBuffer.append(")");

				sql = sqlBuffer.toString();

				DAO_BD.aTbStatementsSQL.put("incluir_" + pVOEntidade.getClass().getName(), sql);
			}



			preStmt = conexao.prepareStatement(sql);

			// Substitui parametros
			nmAtributosPersistencia = pVOEntidade.getNmAtributosPersistencia().iterator();

			Object objetoValorAtributo = null;
			int i = 0;

			while (nmAtributosPersistencia.hasNext()) {
				atributo = (String) nmAtributosPersistencia.next();
				objetoValorAtributo = pVOEntidade.getValorAtributoInstancia(atributo);
				tpColunaBanco = this.getTipoColuna(pVOEntidade, atributo);
				i++;

				if (objetoValorAtributo != null) {
					if (tpColunaBanco == Types.BIT) {
						if (((Boolean) objetoValorAtributo).booleanValue() == true) {
							preStmt.setObject(i, Constantes.CD_VERDADEIRO);
						} else {
							preStmt.setObject(i, Constantes.CD_FALSO);
						}
					} else if (tpColunaBanco == Types.CLOB) {
						clob = (StringBuffer) objetoValorAtributo;
						bytesClob = clob.toString().getBytes();
						streamClob = new ByteArrayInputStream(bytesClob);
						readerClob = new BufferedReader(new InputStreamReader(streamClob));

						preStmt.setCharacterStream(i, readerClob, streamClob.available());
					} else if (tpColunaBanco == Types.BLOB) {
						if (objetoValorAtributo instanceof Arquivo) {
							blob = (Arquivo) objetoValorAtributo;
							blobs.add(blob);
							blob.fechar();
							blob.inicializarFileInputStream();
							streamBlob = new BufferedInputStream(blob.getFileInputStream());
						}

						preStmt.setBinaryStream(i, streamBlob, streamBlob.available());
					} else if (tpColunaBanco == Types.SQLXML) {
						preStmt.setObject(i, objetoValorAtributo);
					}
				} else {
					preStmt.setNull(i, tpColunaBanco);
				}
			}
			
			preStmt.execute();
			
			itBlobs = blobs.iterator();
			
			while (itBlobs.hasNext()) {
				blob = (Arquivo) itBlobs.next();
				blob.fechar();
				blob.inicializarFileInputStream();
			}
		} finally {
			this.fecharConexao(pContextoUsuario, conexao, preStmt);
		}
	}

	/**
	 * -
	 *
	 * @param pContextoUsuario
	 * @param pArrayVOEntidade
	 *
	 * @throws Exception
	 */
	public void incluirBatch(ContextoUsuario pContextoUsuario, ArrayList<?extends VOEntidade> pArrayVOEntidade)
		throws Exception {
		String sql = null;
		StringBuilder sqlBuffer = null;
		Iterator nmAtributosPersistencia = null;
		String atributo = null;
		int tpColunaBanco;
		Connection conexao = null;
		PreparedStatement preStmt = null;

		StringBuffer clob = null;
		byte[] bytesClob = null;
		byte[] bytesBlob = null;
		InputStream streamClob = null;
		Reader readerClob = null;
		Arquivo blob = null;
		InputStream streamBlob = null;
		ArrayList<Arquivo> blobs = new ArrayList<Arquivo>();
		Iterator itBlobs = null;
		Iterator arrayVOs = null;
		String nmEntidade = "";
		int[] updateCounts = null;
		boolean isUtilizacaoBatchDesativado = false;

		for (int i = 0; i < pArrayVOEntidade.size(); i++) {
			VOEntidade voEntidade = pArrayVOEntidade.get(i);

			if (i == 0) {
				// Verifica se a inclusão em batch está ativada ou desativada para o sistema em questão
				isUtilizacaoBatchDesativado = Parametros.getInstancia()
						.isUtilizacaoBatchDesativado(BibliotecaFuncoesPrincipal.extrairSgSistema(voEntidade.getClass().getName())
							.toUpperCase());

				if (!isUtilizacaoBatchDesativado) {
					break;
				}
			}
			this.incluir(pContextoUsuario, voEntidade);
		}

		if (!isUtilizacaoBatchDesativado) {
			try {
				// Para cada VOEntidade, preparar o SQL e adicionar no batchupdate
				for (VOEntidade voEntidade : pArrayVOEntidade) {
					sql = (String) DAO_BD.aTbStatementsSQL.get("incluir_" + voEntidade.getClass().getName());

					if (sql == null) {
						sqlBuffer = new StringBuilder(64);
						sqlBuffer.append("INSERT INTO ");
						sqlBuffer.append(voEntidade.getNmEntidade() + " (");

						nmAtributosPersistencia = voEntidade.getNmAtributosPersistencia().iterator();

						boolean flgPrimeiroAtributo = true;

						while (nmAtributosPersistencia.hasNext()) {
							atributo = (String) nmAtributosPersistencia.next();

							if (flgPrimeiroAtributo == false) {
								sqlBuffer.append(", ");
							} else {
								flgPrimeiroAtributo = false;
							}

							sqlBuffer.append(atributo);
						}

						sqlBuffer.append(") VALUES (");

						nmAtributosPersistencia = voEntidade.getNmAtributosPersistencia().iterator();
						flgPrimeiroAtributo = true;

						while (nmAtributosPersistencia.hasNext()) {
							atributo = (String) nmAtributosPersistencia.next();

							if (flgPrimeiroAtributo == false) {
								sqlBuffer.append(", ");
							} else {
								flgPrimeiroAtributo = false;
							}

							sqlBuffer.append("?");
						}

						sqlBuffer.append(")");

						sql = sqlBuffer.toString();

						DAO_BD.aTbStatementsSQL.put("incluir_" + voEntidade.getClass().getName(), sql);
					}

					// Inserindo os sql no objeto batchupdate
					if (conexao == null) {
						// Primeira iteração

						preStmt = conexao.prepareStatement(sql);
						nmEntidade = voEntidade.getNmEntidade();
					}

					// Substitui parametros
					nmAtributosPersistencia = voEntidade.getNmAtributosPersistencia().iterator();

					Object objetoValorAtributo = null;
					int i = 0;

					while (nmAtributosPersistencia.hasNext()) {
						atributo = (String) nmAtributosPersistencia.next();
						objetoValorAtributo = voEntidade.getValorAtributoInstancia(atributo);
						tpColunaBanco = this.getTipoColuna(voEntidade, atributo);
						i++;


						if (objetoValorAtributo != null) {
							if (tpColunaBanco == Types.BIT) {
								if (((Boolean) objetoValorAtributo).booleanValue() == true) {
									preStmt.setObject(i, Constantes.CD_VERDADEIRO);
								} else {
									preStmt.setObject(i, Constantes.CD_FALSO);
								}
							} else if (tpColunaBanco == Types.CLOB) {
								clob = (StringBuffer) objetoValorAtributo;
								bytesClob = clob.toString().getBytes();
								streamClob = new ByteArrayInputStream(bytesClob);
								readerClob = new BufferedReader(new InputStreamReader(streamClob));

								preStmt.setCharacterStream(i, readerClob, streamClob.available());
							} else if (tpColunaBanco == Types.BLOB) {
								if (objetoValorAtributo instanceof Arquivo) {
									blob = (Arquivo) objetoValorAtributo;
									blobs.add(blob);
									blob.fechar();
									blob.inicializarFileInputStream();
									streamBlob = new BufferedInputStream(blob.getFileInputStream());
									streamBlob = new BufferedInputStream(new ByteArrayInputStream(bytesBlob));
								}

								preStmt.setBinaryStream(i, streamBlob, streamBlob.available());
							} else if (tpColunaBanco == Types.SQLXML) {
								preStmt.setObject(i, objetoValorAtributo);
							}
						} else {
							preStmt.setNull(i, tpColunaBanco);
						}
					}

					// Adiciona os valores setados no statement para execução batch
					preStmt.addBatch();

				}

				// Executa o statement batch
				updateCounts = preStmt.executeBatch();


				itBlobs = blobs.iterator();

				while (itBlobs.hasNext()) {
					blob = (Arquivo) itBlobs.next();
					blob.fechar();
					blob.inicializarFileInputStream();
				}
			} finally {
				this.fecharConexao(pContextoUsuario, conexao, preStmt);
			}
		}
	}

	/**
	 * -
	 *
	 * @param pContextoUsuario
	 * @param pVOEntidade
	 *
	 * @throws Exception
	 * @throws ExcecaoRegistroNaoEncontrado
	 */
	public void alterar(ContextoUsuario pContextoUsuario, VOEntidade pVOEntidade)
		throws Exception {
		String sql = null;
		StringBuilder sqlBuffer = null;
		Iterator nmAtributosPersistencia = null;
		Enumeration keysPkAtributos = null;
		Hashtable pkAtributos = null;
		String atributo = null;
		int tpColunaBanco;
		Connection conexao = null;
		PreparedStatement preStmt = null;

		StringBuffer clob = null;
		byte[] bytesClob = null;
		InputStream streamClob = null;
		Reader readerClob = null;
		byte[] bytesBlob = null;
		Arquivo blob = null;
		InputStream streamBlob = null;
		ArrayList<Arquivo> blobs = new ArrayList<Arquivo>();
		Iterator itBlobs = null;

		try {
			if (pVOEntidade.getAtributosInstancia().size() == pVOEntidade.getAtributosInstanciaChavePrimaria().size()) {
				return;
			}

			sqlBuffer = new StringBuilder(64);
			sqlBuffer.append("UPDATE ");
			sqlBuffer.append(pVOEntidade.getNmEntidade() + " SET ");

			nmAtributosPersistencia = pVOEntidade.getNmAtributosPersistencia().iterator();

			boolean flgPrimeiroElemento = true;

			while (nmAtributosPersistencia.hasNext()) {
				atributo = (String) nmAtributosPersistencia.next();

				if (!pVOEntidade.isChavePrimaria(atributo)) {
					if (pVOEntidade.isAtributoAlterado(atributo)) {
						if (!flgPrimeiroElemento) {
							sqlBuffer.append(", ");
						} else {
							flgPrimeiroElemento = false;
						}

						sqlBuffer.append(atributo + " = ?");
					}
				}
			}

			sqlBuffer.append(" WHERE ");

			keysPkAtributos = pVOEntidade.getAtributosInstanciaChavePrimaria().keys();

			while (keysPkAtributos.hasMoreElements()) {
				atributo = (String) keysPkAtributos.nextElement();
				sqlBuffer.append(atributo + " = ?");

				if (keysPkAtributos.hasMoreElements() == true) {
					sqlBuffer.append(" AND ");
				}
			}

			sql = sqlBuffer.toString();

			preStmt = conexao.prepareStatement(sql);

			// Substitui parametros
			nmAtributosPersistencia = pVOEntidade.getNmAtributosPersistencia().iterator();
			keysPkAtributos = pVOEntidade.getAtributosInstanciaChavePrimaria().keys();
			pkAtributos = pVOEntidade.getAtributosInstanciaChavePrimaria();

			Object objetoValorAtributo = null;
			int i = 0;

			while (nmAtributosPersistencia.hasNext()) {
				atributo = (String) nmAtributosPersistencia.next();
				objetoValorAtributo = pVOEntidade.getValorAtributoInstancia(atributo);

				if (!pVOEntidade.isChavePrimaria(atributo)) {
					if (pVOEntidade.isAtributoAlterado(atributo)) {
						tpColunaBanco = this.getTipoColuna(pVOEntidade, atributo);
						i++;

						if (objetoValorAtributo != null) {
							if (tpColunaBanco == Types.BIT) {
								if (((Boolean) objetoValorAtributo).booleanValue() == true) {
									preStmt.setObject(i, Constantes.CD_VERDADEIRO);
								} else {
									preStmt.setObject(i, Constantes.CD_FALSO);
								}
							} else if (tpColunaBanco == Types.CLOB) {
								clob = (StringBuffer) objetoValorAtributo;
								bytesClob = clob.toString().getBytes();
								streamClob = new ByteArrayInputStream(bytesClob);
								readerClob = new BufferedReader(new InputStreamReader(streamClob));

								preStmt.setCharacterStream(i, readerClob, streamClob.available());
							} else if (tpColunaBanco == Types.BLOB) {
								if (objetoValorAtributo instanceof Arquivo) {
									blob = (Arquivo) objetoValorAtributo;
									blobs.add(blob);
									blob.fechar();
									blob.inicializarFileInputStream();
									streamBlob = blob.getFileInputStream();
									streamBlob = new ByteArrayInputStream(bytesBlob);
								}

								preStmt.setBinaryStream(i, streamBlob, streamBlob.available());
							} else if (tpColunaBanco == Types.SQLXML) {
								preStmt.setObject(i, objetoValorAtributo);
							}
						} else {
							preStmt.setNull(i, tpColunaBanco);
						}
					}
				}
			}

			while (keysPkAtributos.hasMoreElements()) {
				atributo = (String) keysPkAtributos.nextElement();
				objetoValorAtributo = pkAtributos.get(atributo);

				i++;
				preStmt.setObject(i, objetoValorAtributo);
			}

			preStmt.execute();

			if (preStmt.getUpdateCount() == 0) {

				throw new ExcecaoRegistroNaoEncontrado(pVOEntidade.getDsEntidade(),
					this.getClass().getName() + " | método = alterar | pContextoUsuario = " + pContextoUsuario +
					" | pVOEntidade = " + pVOEntidade);
			}

			itBlobs = blobs.iterator();

			while (itBlobs.hasNext()) {
				blob = (Arquivo) itBlobs.next();
				blob.fechar();
				blob.inicializarFileInputStream();
			}
		} finally {
			this.fecharConexao(pContextoUsuario, conexao, preStmt);
		}
	}

	/**
	 * -
	 *
	 * @param pContextoUsuario
	 * @param pArrayVOEntidade
	 *
	 * @throws Exception
	 * @throws ExcecaoRegistroNaoEncontrado
	 */
	public void alterarBatch(ContextoUsuario pContextoUsuario, ArrayList<?extends VOEntidade> pArrayVOEntidade)
		throws Exception {
		String sql = null;
		StringBuilder sqlBuffer = null;
		Iterator nmAtributosPersistencia = null;
		Enumeration keysPkAtributos = null;
		String nmEntidade = "";
		String dsEntidade = "";
		Hashtable pkAtributos = null;
		String atributo = null;
		int tpColunaBanco;
		Connection conexao = null;
		PreparedStatement preStmt = null;
		int[] updateCounts = null;
		StringBuffer clob = null;
		byte[] bytesClob = null;
		InputStream streamClob = null;
		Reader readerClob = null;
		byte[] bytesBlob = null;
		Arquivo blob = null;
		InputStream streamBlob = null;
		ArrayList<Arquivo> blobs = new ArrayList<Arquivo>();
		Iterator itBlobs = null;
		boolean isUtilizacaoBatchDesativado = false;

		for (int i = 0; i < pArrayVOEntidade.size(); i++) {
			VOEntidade voEntidade = pArrayVOEntidade.get(i);

			if (i == 0) {
				// Verifica se a utilização de update em batch está ativada ou desativada para o sistema em questão
				isUtilizacaoBatchDesativado = Parametros.getInstancia()
						.isUtilizacaoBatchDesativado(BibliotecaFuncoesPrincipal.extrairSgSistema(voEntidade.getClass().getName())
							.toUpperCase());


				if (!isUtilizacaoBatchDesativado) {
					break;
				}
			}
			this.alterar(pContextoUsuario, voEntidade);
		}

		if (!isUtilizacaoBatchDesativado) {
			try {
				// Armazena o grupo de campos que serão atualizados, cada um com um update em batch.
				Hashtable<String, ArrayList<VOEntidade>> grupoCamposUpdate = new Hashtable<String, ArrayList<VOEntidade>>();

				// Para cada VOEntidade, preparar o SQL e adicionar no batchupdate
				for (VOEntidade voEntidade : pArrayVOEntidade) {
					if (voEntidade.getAtributosInstancia().size() == voEntidade.getAtributosInstanciaChavePrimaria().size()) {
						return;
					}

					nmAtributosPersistencia = voEntidade.getNmAtributosPersistencia().iterator();

					StringBuilder camposAlterados = new StringBuilder();

					while (nmAtributosPersistencia.hasNext()) {
						atributo = (String) nmAtributosPersistencia.next();

						if (!voEntidade.isChavePrimaria(atributo)) {
							if (voEntidade.isAtributoAlterado(atributo)) {
								camposAlterados.append(atributo).append(Constantes.CD_CAMPO_SEPARADOR);
							}
						}
					}

					// Se este grupo já foi adicionado por algum voEntidade anterior...
					if (grupoCamposUpdate.containsKey(camposAlterados.toString())) {
						grupoCamposUpdate.get(camposAlterados.toString()).add(voEntidade);
					} else {
						// Como este grupo ainda não adicionado, adiciona no hashtable
						ArrayList<VOEntidade> vosMesmoGrupo = new ArrayList<VOEntidade>();
						vosMesmoGrupo.add(voEntidade);
						grupoCamposUpdate.put(camposAlterados.toString(), vosMesmoGrupo);
					}
				}

				Enumeration<String> keysCamposUpdate = grupoCamposUpdate.keys();

				while (keysCamposUpdate.hasMoreElements()) {
					String chave = keysCamposUpdate.nextElement();
					ArrayList<VOEntidade> entidades = grupoCamposUpdate.get(chave);
					boolean flgPrimeiraEntidade = true;

					// Varre cada entidade do grupo...
					for (VOEntidade voEntidade : entidades) {
						// Se for a primeira entidade monta o SQL 
						if (flgPrimeiraEntidade) {
							sqlBuffer = new StringBuilder(64);
							sqlBuffer.append("UPDATE ");
							sqlBuffer.append(voEntidade.getNmEntidade() + " SET ");

							nmAtributosPersistencia = voEntidade.getNmAtributosPersistencia().iterator();

							boolean flgPrimeiroElemento = true;

							while (nmAtributosPersistencia.hasNext()) {
								atributo = (String) nmAtributosPersistencia.next();

								if (!voEntidade.isChavePrimaria(atributo)) {
									if (voEntidade.isAtributoAlterado(atributo)) {
										if (!flgPrimeiroElemento) {
											sqlBuffer.append(", ");
										} else {
											flgPrimeiroElemento = false;
										}

										sqlBuffer.append(atributo + " = ?");
									}
								}
							}

							sqlBuffer.append(" WHERE ");

							keysPkAtributos = voEntidade.getAtributosInstanciaChavePrimaria().keys();

							while (keysPkAtributos.hasMoreElements()) {
								atributo = (String) keysPkAtributos.nextElement();
								sqlBuffer.append(atributo + " = ?");

								if (keysPkAtributos.hasMoreElements() == true) {
									sqlBuffer.append(" AND ");
								}
							}

							sql = sqlBuffer.toString();

							// Resgatando a conexão
							if (conexao == null) {
								nmEntidade = voEntidade.getNmEntidade();
								dsEntidade = voEntidade.getDsEntidade();
							}

							// Inserindo os sql no objeto batchupdate
							preStmt = conexao.prepareStatement(sql);

							// Muda a flag da primeira entidade
							flgPrimeiraEntidade = false;
						}

						// Substitui parametros
						nmAtributosPersistencia = voEntidade.getNmAtributosPersistencia().iterator();
						keysPkAtributos = voEntidade.getAtributosInstanciaChavePrimaria().keys();
						pkAtributos = voEntidade.getAtributosInstanciaChavePrimaria();

						Object objetoValorAtributo = null;
						int i = 0;

						while (nmAtributosPersistencia.hasNext()) {
							atributo = (String) nmAtributosPersistencia.next();
							objetoValorAtributo = voEntidade.getValorAtributoInstancia(atributo);

							if (!voEntidade.isChavePrimaria(atributo)) {
								if (voEntidade.isAtributoAlterado(atributo)) {
									tpColunaBanco = this.getTipoColuna(voEntidade, atributo);
									i++;

									if (objetoValorAtributo != null) {
										if (tpColunaBanco == Types.BIT) {
											if (((Boolean) objetoValorAtributo).booleanValue() == true) {
												preStmt.setObject(i, Constantes.CD_VERDADEIRO);
											} else {
												preStmt.setObject(i, Constantes.CD_FALSO);
											}
										} else if (tpColunaBanco == Types.CLOB) {
											clob = (StringBuffer) objetoValorAtributo;
											bytesClob = clob.toString().getBytes();
											streamClob = new ByteArrayInputStream(bytesClob);
											readerClob = new BufferedReader(new InputStreamReader(streamClob));

											preStmt.setCharacterStream(i, readerClob, streamClob.available());
										} else if (tpColunaBanco == Types.BLOB) {
											if (objetoValorAtributo instanceof Arquivo) {
												blob = (Arquivo) objetoValorAtributo;
												blobs.add(blob);
												blob.fechar();
												blob.inicializarFileInputStream();
												streamBlob = blob.getFileInputStream();
												streamBlob = new ByteArrayInputStream(bytesBlob);
											}
											
											preStmt.setBinaryStream(i, streamBlob, streamBlob.available());
										} else if (tpColunaBanco == Types.SQLXML) {
											preStmt.setObject(i, objetoValorAtributo);
										}
									} else {
										preStmt.setNull(i, tpColunaBanco);
									}
								}
							}
						}
						
						while (keysPkAtributos.hasMoreElements()) {
							atributo = (String) keysPkAtributos.nextElement();
							objetoValorAtributo = pkAtributos.get(atributo);
							
							i++;
							preStmt.setObject(i, objetoValorAtributo);
						}
						
						preStmt.addBatch();
					}
					
					// Executa o statement batch
					updateCounts = preStmt.executeBatch();
					
					
					// Se algum dos updates executados em batch não retornou nenhum resultado a ExcecaoRegistroNaoEncontrado é levantada. 
					for (int i = 0; i < updateCounts.length; i++) {
						int updateCount = updateCounts[i];
						
						if (updateCount == 0) {
							
							throw new ExcecaoRegistroNaoEncontrado(dsEntidade,
								this.getClass().getName() + " | método = alterarBatch | pContextoUsuario = " + pContextoUsuario +
								" | voEntidade = " + pArrayVOEntidade.get(i));
						} else {
						}
					}

					itBlobs = blobs.iterator();

					while (itBlobs.hasNext()) {
						blob = (Arquivo) itBlobs.next();
						blob.fechar();
						blob.inicializarFileInputStream();
					}
				}
			} finally {
				this.fecharConexao(pContextoUsuario, conexao, preStmt);
			}
		}
	}

	/**
	 * -
	 *
	 * @param pContextoUsuario
	 * @param pVOEntidade
	 *
	 * @throws Exception
	 * @throws ExcecaoRegistroNaoEncontrado
	 */
	public void excluir(ContextoUsuario pContextoUsuario, VOEntidade pVOEntidade)
		throws Exception {
		String sql = null;
		StringBuilder sqlBuffer = null;
		Iterator nmAtributosPersistenciaPk = null;
		Hashtable pkAtributos = null;
		String atributo = null;
		Connection conexao = null;
		PreparedStatement preStmt = null;

		try {
			sql = (String) DAO_BD.aTbStatementsSQL.get("excluir_" + pVOEntidade.getClass().getName());

			if (sql == null) {
				sqlBuffer = new StringBuilder(64);
				sqlBuffer.append("DELETE FROM ");

				sqlBuffer.append(pVOEntidade.getNmEntidade() + " WHERE ");

				nmAtributosPersistenciaPk = pVOEntidade.getNmAtributosPersistenciaChavePrimaria().iterator();

				while (nmAtributosPersistenciaPk.hasNext()) {
					atributo = (String) nmAtributosPersistenciaPk.next();
					sqlBuffer.append(atributo + " = ?");

					if (nmAtributosPersistenciaPk.hasNext() == true) {
						sqlBuffer.append(" AND ");
					}
				}

				sql = sqlBuffer.toString();

				DAO_BD.aTbStatementsSQL.put("excluir_" + pVOEntidade.getClass().getName(), sql);
			}

			preStmt = conexao.prepareStatement(sql);

			// Substitui parametros
			nmAtributosPersistenciaPk = pVOEntidade.getNmAtributosPersistenciaChavePrimaria().iterator();
			pkAtributos = pVOEntidade.getAtributosInstanciaChavePrimaria();

			Object objetoValorAtributo = null;
			int i = 0;

			while (nmAtributosPersistenciaPk.hasNext()) {
				atributo = (String) nmAtributosPersistenciaPk.next();
				objetoValorAtributo = pkAtributos.get(atributo);

				i++;
				preStmt.setObject(i, objetoValorAtributo);
			}

			preStmt.execute();

			if (preStmt.getUpdateCount() == 0) {

				throw new ExcecaoRegistroNaoEncontrado(pVOEntidade.getDsEntidade(),
					this.getClass().getName() + " | método = excluir | pContextoUsuario = " + pContextoUsuario +
					" | pVOEntidade = " + pVOEntidade);
			}
		} finally {
			this.fecharConexao(pContextoUsuario, conexao, preStmt);
		}
	}

	/**
	 * -
	 *
	 * @param pContextoUsuario
	 * @param pVOEntidade
	 * @param pInExtrairBLOB
	 * @param pInExtrairBLOBComoArrayBytes
	 *
	 * @return
	 *
	 * @throws Exception
	 */
	public VOGenerico consultarPorChavePrimaria(ContextoUsuario pContextoUsuario, VOEntidade pVOEntidade, boolean pInExtrairBLOB,
		boolean pInExtrairBLOBComoArrayBytes) throws Exception {
		VOGenerico resposta = null;

		resposta = this.consultarPorChavePrimaria(pContextoUsuario, pVOEntidade, pInExtrairBLOB, pInExtrairBLOBComoArrayBytes,
				pContextoUsuario.getInUtilizarLockExclusivoProximaConsultaPorChavePrimaria());

		return resposta;
	}

	/**
	 * -
	 *
	 * @param pContextoUsuario
	 * @param pVOEntidade
	 * @param pInExtrairBLOB
	 * @param pInExtrairBLOBComoArrayBytes
	 * @param pInComLockExclusivo
	 *
	 * @return
	 *
	 * @throws Exception
	 * @throws ExcecaoRegistroNaoEncontrado
	 */
	public VOGenerico consultarPorChavePrimaria(ContextoUsuario pContextoUsuario, VOEntidade pVOEntidade, boolean pInExtrairBLOB,
		boolean pInExtrairBLOBComoArrayBytes, boolean pInComLockExclusivo)
		throws Exception {
		String sql = null;
		StringBuilder sqlBuffer = null;
		Iterator nmAtributosPersistenciaPk = null;
		Hashtable pkAtributos = null;
		String atributo = null;
		Connection conexao = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		VOGenerico resposta = null;

		try {
			if (pInComLockExclusivo) {
				sql = (String) DAO_BD.aTbStatementsSQL.get("consultarPKComLockExclusivo_" + pVOEntidade.getClass().getName());
			} else {
				sql = (String) DAO_BD.aTbStatementsSQL.get("consultarPK_" + pVOEntidade.getClass().getName());
			}

			if (sql == null) {
				sqlBuffer = new StringBuilder(64);
				sqlBuffer.append("SELECT * FROM ");
				sqlBuffer.append(pVOEntidade.getNmEntidade() + " WHERE ");

				nmAtributosPersistenciaPk = pVOEntidade.getNmAtributosPersistenciaChavePrimaria().iterator();

				while (nmAtributosPersistenciaPk.hasNext()) {
					atributo = (String) nmAtributosPersistenciaPk.next();
					sqlBuffer.append(atributo + " = ?");

					if (nmAtributosPersistenciaPk.hasNext() == true) {
						sqlBuffer.append(" AND ");
					}
				}

				if (pInComLockExclusivo) {
					sqlBuffer.append(" FOR UPDATE WITH RR ");
				}

				sql = sqlBuffer.toString();

				if (pInComLockExclusivo) {
					DAO_BD.aTbStatementsSQL.put("consultarPKComLockExclusivo_" + pVOEntidade.getClass().getName(), sql);
				} else {
					DAO_BD.aTbStatementsSQL.put("consultarPK_" + pVOEntidade.getClass().getName(), sql);
				}
			}

			preStmt = conexao.prepareStatement(sql);

			// Substitui parametros
			nmAtributosPersistenciaPk = pVOEntidade.getNmAtributosPersistenciaChavePrimaria().iterator();
			pkAtributos = pVOEntidade.getAtributosInstanciaChavePrimaria();

			Object objetoValorAtributo = null;
			int i = 0;

			while (nmAtributosPersistenciaPk.hasNext()) {
				atributo = (String) nmAtributosPersistenciaPk.next();
				objetoValorAtributo = pkAtributos.get(atributo);

				i++;
				preStmt.setObject(i, objetoValorAtributo);
			}

			rs = preStmt.executeQuery();

			if (!rs.next()) {

				throw new ExcecaoRegistroNaoEncontrado(pVOEntidade.getDsEntidade(),
					this.getClass().getName() + " | método = consultarPorChavePrimaria | pContextoUsuario = " + pContextoUsuario +
					" | pVOEntidade = " + pVOEntidade);
			}

			// Transforma o resultset em um VOGenerico
			resposta = DAO_BD.getResultSetComoVOGenerico(rs, pInExtrairBLOB, pInExtrairBLOBComoArrayBytes);
		} finally {
			pContextoUsuario.setInUtilizarLockExclusivoProximaConsultaPorChavePrimaria(false);
			this.fecharConexao(pContextoUsuario, conexao, preStmt);
		}

		return resposta;
	}

	/**
	 * -
	 *
	 * @param pVOEntidade
	 * @param pNmAtributo
	 *
	 * @return
	 *
	 * @throws Exception
	 */
	protected int getTipoColuna(VOEntidade pVOEntidade, String pNmAtributo)
		throws Exception {
		Class tpAtributo;
		int tipoSQL = 0;

		tpAtributo = pVOEntidade.getTipoAtributoInstancia(pNmAtributo);

		if (tpAtributo.equals(String.class)) {
			tipoSQL = Types.VARCHAR;
		} else if (tpAtributo.equals(BigDecimal.class)) {
			tipoSQL = Types.NUMERIC;
		} else if (tpAtributo.equals(Boolean.class)) {
			tipoSQL = Types.BIT;
		} else if (tpAtributo.equals(Integer.class)) {
			tipoSQL = Types.INTEGER;
		} else if (tpAtributo.equals(Short.class)) {
			tipoSQL = Types.SMALLINT;
		} else if (tpAtributo.equals(Long.class)) {
			tipoSQL = Types.BIGINT;
		} else if (tpAtributo.equals(Float.class)) {
			tipoSQL = Types.REAL;
		} else if (tpAtributo.equals(Double.class)) {
			tipoSQL = Types.DOUBLE;
		} else if (tpAtributo.equals(Date.class)) {
			tipoSQL = Types.DATE;
		} else if (tpAtributo.equals(Time.class)) {
			tipoSQL = Types.TIME;
		} else if (tpAtributo.equals(Timestamp.class)) {
			tipoSQL = Types.TIMESTAMP;
		} else if (tpAtributo.equals(StringBuffer.class)) {
			tipoSQL = Types.CLOB;
			tipoSQL = Types.BLOB;
		} else if (tpAtributo.equals(Arquivo.class)) {
			tipoSQL = Types.BLOB;
			tipoSQL = Types.SQLXML;
		}

		return tipoSQL;
	}

	/**
	 * Este método não trata o tipo CLOB. Ele é tratado nos métodos getResultSetComoVOGenerico e getResultSetComoColecao
	 *
	 * @param pTpColuna
	 *
	 * @return
	 *
	 * @throws Exception
	 */
	protected static Class getTipoJavaColuna(int pTpColuna)
		throws Exception {
		Class tpJavaAtributo = null;

		if ((pTpColuna == Types.VARCHAR) || (pTpColuna == Types.CHAR) || (pTpColuna == Types.LONGVARCHAR)) {
			tpJavaAtributo = String.class;
		} else if ((pTpColuna == Types.NUMERIC) || (pTpColuna == Types.DECIMAL)) {
			tpJavaAtributo = BigDecimal.class;
		} else if (pTpColuna == Types.BIT) {
			tpJavaAtributo = Boolean.class;
		} else if (pTpColuna == Types.INTEGER) {
			tpJavaAtributo = Integer.class;
		} else if (pTpColuna == Types.SMALLINT) {
			tpJavaAtributo = Short.class;
		} else if (pTpColuna == Types.BIGINT) {
			tpJavaAtributo = Long.class;
		} else if (pTpColuna == Types.REAL) {
			tpJavaAtributo = Float.class;
		} else if ((pTpColuna == Types.DOUBLE) || (pTpColuna == Types.FLOAT)) {
			tpJavaAtributo = Double.class;
		} else if (pTpColuna == Types.DATE) {
			tpJavaAtributo = Date.class;
		} else if (pTpColuna == Types.TIME) {
			tpJavaAtributo = Time.class;
		} else if (pTpColuna == Types.TIMESTAMP) {
			tpJavaAtributo = Timestamp.class;
		} else if (pTpColuna == Types.BLOB) {
			tpJavaAtributo = Arquivo.class;
		} else if (pTpColuna == Types.SQLXML) {
		}

		return tpJavaAtributo;
	}

	/**
	 * -
	 *
	 * @param pCdNivelIsolamento
	 *
	 * @return
	 */
	protected static String getDsNivelIsolamento(int pCdNivelIsolamento) {
		String nmNivelIsolamento;

		if (pCdNivelIsolamento == Connection.TRANSACTION_NONE) {
			nmNivelIsolamento = "NONE";
		} else if (pCdNivelIsolamento == Connection.TRANSACTION_READ_COMMITTED) {
			nmNivelIsolamento = "READ_COMMITTED";
		} else if (pCdNivelIsolamento == Connection.TRANSACTION_READ_UNCOMMITTED) {
			nmNivelIsolamento = "READ_UNCOMMITTED";
		} else if (pCdNivelIsolamento == Connection.TRANSACTION_REPEATABLE_READ) {
			nmNivelIsolamento = "REPEATABLE_READ";
		} else if (pCdNivelIsolamento == Connection.TRANSACTION_SERIALIZABLE) {
			nmNivelIsolamento = "SERIALIZABLE";
		} else {
			nmNivelIsolamento = "Não indentificado";
		}

		return nmNivelIsolamento;
	}

	/**
	 * -
	 *
	 * @param pString
	 *
	 * @return
	 */
	protected String substituirCaracterCoringa(String pString) {
		return pString.replace(Constantes.CD_CARACTERE_CORINGA_USR, Constantes.CD_CARACTERE_CORINGA_BD);
	}

	/**
	 * -
	 *
	 * @param pString
	 *
	 * @return
	 */
	protected boolean temCaracterCoringa(String pString) {
		if (pString.indexOf(Constantes.CD_CARACTERE_CORINGA_USR) == -1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * -
	 *
	 * @param pColecao
	 *
	 * @return
	 */
	protected String getColecaoComoArgumentoIn(Collection pColecao) {
		String resposta = "(";
		Iterator iterador = pColecao.iterator();

		if (iterador.hasNext()) {
			resposta += iterador.next();
		}

		while (iterador.hasNext()) {
			resposta += (", " + iterador.next());
		}

		resposta += ")";

		return resposta;
	}

	/**
	 * -
	 *
	 * @param pColecao
	 * @param pInComAspas
	 *
	 * @return
	 */
	protected String getColecaoComoArgumentoIn(Collection pColecao, boolean pInComAspas) {
		String resposta = "";
		Iterator iterador;

		if (!pInComAspas) {
			resposta = this.getColecaoComoArgumentoIn(pColecao);
		} else {
			resposta = "(";
			iterador = pColecao.iterator();

			if (iterador.hasNext()) {
				resposta += ("'" + iterador.next() + "'");
			}

			while (iterador.hasNext()) {
				resposta += (", '" + iterador.next() + "'");
			}

			resposta += ")";
		}

		return resposta;
	}

	/**
	 * -
	 *
	 * @param pResultSet
	 * @param pNmColunaCLOB
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 */
	protected static String getCLOBComoString(ResultSet pResultSet, String pNmColunaCLOB)
		throws ExcecaoGenerica {
		String clob = null;
		Reader reader = null;
		int charReaded;
		ByteArrayOutputStream baos = null;
		byte[] bytesClob = null;

		try {
			reader = pResultSet.getCharacterStream(pNmColunaCLOB);
			baos = new ByteArrayOutputStream();

			if (reader != null) {
				while ((charReaded = reader.read()) != -1) {
					baos.write(charReaded);
				}
				bytesClob = baos.toByteArray();

				clob = BibliotecaFuncoesPrincipal.getArrayBytesComoString(bytesClob);
			}
		} catch (Exception e) {
			DAO_BD.tratarExcecao(DAO_BD.class.getName(), "pNmColunaCLOB = " + pNmColunaCLOB, e);
		}

		return clob;
	}

	/**
	 * -
	 *
	 * @param pResultSet
	 * @param pNmColunaCLOB
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 */
	protected static StringBuffer getCLOBComoStringBuffer(ResultSet pResultSet, String pNmColunaCLOB)
		throws ExcecaoGenerica {
		StringBuffer clob = null;

		String str = DAO_BD.getCLOBComoString(pResultSet, pNmColunaCLOB);

		if (str != null) {
			clob = new StringBuffer(str);
		}

		return clob;
	}

	/**
	 * -
	 *
	 * @param pContextoUsuario
	 * @param pResultSet
	 * @param pNmColunaBLOB
	 * @param pNmArquivo
	 * @param pInExtrairBLOB
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 */
	private static Arquivo getBLOBComoArquivo(ContextoUsuario pContextoUsuario, ResultSet pResultSet, String pNmColunaBLOB,
		String pNmArquivo, boolean pInExtrairBLOB) throws ExcecaoGenerica {
		Arquivo arquivo = null;

		try {
			Blob vlBlob = pResultSet.getBlob(pNmColunaBLOB);

			if (vlBlob == null) {
				return null;
			}

			String nmPathArquivo = Constantes.NM_PATH_DOCUMENTOS_ONLINE + File.separator +
				BibliotecaFuncoesDataHora.getDataComoStringInvertida(BibliotecaFuncoesDataHora.getDataHoje()) + File.separator +
				pContextoUsuario.getIdSessao() + File.separator;
			File file = new File(nmPathArquivo);
			file.mkdirs();

			if (pInExtrairBLOB) {
				long tamanho = vlBlob.length();

				byte[] bytes = vlBlob.getBytes(1, (int) tamanho);

				file = new File(nmPathArquivo + File.separator + pNmArquivo);

				FileOutputStream fos = new FileOutputStream(file);
				fos.write(bytes);
				fos.close();

				arquivo = new Arquivo(file);
				arquivo.setInGeradoOnLine(true);
			}
		} catch (Exception e) {
			DAO_BD.tratarExcecao(DAO_BD.class.getName(), "pNmColunaBLOB = " + pNmColunaBLOB + " | pNmArquivo = " + pNmArquivo, e);
		}

		return arquivo;
	}
}
