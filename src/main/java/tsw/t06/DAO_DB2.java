/*
 * Este arquivo é propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informação nele contida pode ser
 * reproduzida, mostrada ou revelada sem permissão escrita da Sefaz-PE.
 */
package tsw.t06;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 
 */
public class DAO_DB2 extends DAO_BD {
	//~ Atributos/inicializadores estaticos ----------------------------------------------------------------------------------------

	private static String aNmBD = null;

	private static Boolean aInBDProducao;

	//~ Construtores ---------------------------------------------------------------------------------------------------------------

/**
         * Cria um novo objeto DAO_DB2.
         */
	public DAO_DB2() {
		super();
	}

/**
         * Cria um novo objeto DAO_DB2.
         *
         * @param pNmConexaoJNDI
         */
	public DAO_DB2(String pNmConexaoJNDI) {
		super(pNmConexaoJNDI);
	}

	//~ Metodos --------------------------------------------------------------------------------------------------------------------

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
		Connection conexao = null;
		String vlPropriedadeConexao = "";
		ArrayList paramConexao = null;

		if (System.getProperty("conexao") == null) {
			conexao = DAO_BD.getConexao(pNmConexaoJNDI);
		} else {
			try {
				vlPropriedadeConexao = System.getProperty("conexao");
				paramConexao = BibliotecaFuncoesPrincipal.split(vlPropriedadeConexao, "|");
				BibliotecaFuncoesPrincipal.registrarLogTrace(DAO_BD.class.getName(),
					"[DAO_DB2.getConexao] vlPropriedadeConexao = " + paramConexao.get(0) + "|" + paramConexao.get(1));

				Class.forName("com.ibm.db2.jcc.DB2Driver");
				conexao = DriverManager.getConnection("jdbc:db2:" + paramConexao.get(0), paramConexao.get(1).toString(),
						paramConexao.get(2).toString());
			} catch (ClassNotFoundException e) {
				throw new ExcecaoSistema("Classe 'com.ibm.db2.jcc.DB2Driver' não localizada (vlPropriedadeConexao = " +
					paramConexao.get(0) + "|" + paramConexao.get(1) + ")", e);
			} catch (Exception e) {
				throw new ExcecaoSistema("Erro obtendo conexão (vlPropriedadeConexao = " + paramConexao.get(0) + "|" +
					paramConexao.get(1) + ")", e);
			}
		}

		return conexao;
	}

	/**
	 * -
	 *
	 * @param pContextoUsuario
	 * @param pNmConexaoJNDI
	 *
	 * @return
	 *
	 * @throws ExcecaoSistema
	 */
	public Connection getConexao(ContextoUsuario pContextoUsuario, String pNmConexaoJNDI)
		throws ExcecaoSistema {
		Connection conexao = null;
		String nmConexaoJNDI = null;

		if (pContextoUsuario.isTransacaoJTA()) {
			// Transação JTA => usar JNDI
			if (pContextoUsuario.getConexao() != null) {
				conexao = pContextoUsuario.getConexao();
			} else {
				if (pContextoUsuario.getNmConexaoJNDI() != null) {
					nmConexaoJNDI = pContextoUsuario.getNmConexaoJNDI();
				} else {
					nmConexaoJNDI = pNmConexaoJNDI;
				}
				
				conexao = DAO_DB2.getConexao(nmConexaoJNDI);
			}
			
			if (pContextoUsuario.getTpTransacao() == Constantes.TP_TRANSACAO_JTA_CRGC) {
				pContextoUsuario.setConexao(conexao);
			}
		} else {
			// Transação JDBC => se a Conexão não estiver no ContextoUsuario, pega uma e coloca no ContextoUsuario
			if (pContextoUsuario.getConexao() != null) {
				conexao = pContextoUsuario.getConexao();
			} else {
				if (pContextoUsuario.getNmConexaoJNDI() != null) {
					nmConexaoJNDI = pContextoUsuario.getNmConexaoJNDI();
				} else {
					nmConexaoJNDI = pNmConexaoJNDI;
				}
				
				boolean inJ2EE14Ativado = Parametros.getInstancia().isJ2EE14Ativado();
				
				conexao = DAO_DB2.getConexao(nmConexaoJNDI, inJ2EE14Ativado);
				
				// Define nível de isolamento
				if (pContextoUsuario.getTpNivelIsolamentoTransacao() != 0) {
					try {
						conexao.setTransactionIsolation(pContextoUsuario.getTpNivelIsolamentoTransacao());
					} catch (SQLException e) {
						throw new ExcecaoSistema("Erro definindo TpNivelIsolamentoTransacao para '"
								+ pContextoUsuario.getTpNivelIsolamentoTransacao()
								+ " definido no ContextoUsuario ' | pContextoUsuario = " + pContextoUsuario, e);
					}
				} else {
					if (inJ2EE14Ativado) {
						try {
							if (conexao.getTransactionIsolation() != Connection.TRANSACTION_READ_COMMITTED) {
								conexao.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
							}
						} catch (SQLException e) {
							throw new ExcecaoSistema("Erro definindo TpNivelIsolamentoTransacao para '"
									+ Connection.TRANSACTION_READ_COMMITTED + "' | pContextoUsuario = " + pContextoUsuario, e);
						}
					}
				}
				
				// Configura a conexão e salva no ContextoUsuario
				DAO_DB2.configurarConexaoTransacaoJDBC(conexao);
				pContextoUsuario.setConexao(conexao);
			}
		}
		
		return conexao;
	}

	/**
	 * -
	 *
	 * @param pContextoUsuario
	 * @param pVOEntidade
	 *
	 * @throws ExcecaoGenerica
	 * @throws ExcecaoSistema
	 * @throws ExcecaoChaveDuplicada
	 */
	public void incluir(ContextoUsuario pContextoUsuario, VOEntidade pVOEntidade)
		throws ExcecaoGenerica {
		SQLException excecao = null;

		try {
			super.incluir(pContextoUsuario, pVOEntidade);
		} catch (Exception e) {
			if (e instanceof ExcecaoSistema) {
				if (((ExcecaoSistema) e).getExcecaoOrigem() instanceof SQLException) {
					excecao = (SQLException) ((ExcecaoSistema) e).getExcecaoOrigem();
				} else {
					throw new ExcecaoSistema("Erro no método incluir da classe " + this.getClass().getName() +
						" | pContextoUsuario = " + pContextoUsuario + " | pVOEntidade = " + pVOEntidade + " | excecao = " + e, e);
				}
			} else if (e instanceof ExcecaoGenerica) {
				throw (ExcecaoGenerica) e;
			} else if (e instanceof SQLException) {
				excecao = (SQLException) e;
			}
			
			throw new ExcecaoSistema("Erro no método incluir da classe " + this.getClass().getName() + " | pContextoUsuario = " +
				pContextoUsuario + " | pVOEntidade = " + pVOEntidade + " | excecao = " + e, e);
		}
	}

	/**
	 * -
	 *
	 * @param pContextoUsuario
	 * @param pArrayVOEntidade
	 *
	 * @throws ExcecaoGenerica
	 * @throws ExcecaoSistema
	 * @throws ExcecaoInclusaoBatch
	 */
	public void incluirBatch(ContextoUsuario pContextoUsuario, ArrayList<?extends VOEntidade> pArrayVOEntidade)
		throws ExcecaoGenerica {
		SQLException excecao = null;
		StringBuffer sbExcecao = new StringBuffer();

		try {
			super.incluirBatch(pContextoUsuario, pArrayVOEntidade);
		} catch (Exception e) {
			if (e instanceof ExcecaoSistema) {
				if (((ExcecaoSistema) e).getExcecaoOrigem() instanceof SQLException) {
					excecao = (SQLException) ((ExcecaoSistema) e).getExcecaoOrigem();
				} else {
					throw new ExcecaoSistema("Erro no método incluirBatch da classe " + this.getClass().getName() +
						" | pContextoUsuario = " + pContextoUsuario + " | pArrayVOEntidade.size = " + pArrayVOEntidade.size() +
						" | excecao = " + e, e);
				}
			} else if (e instanceof ExcecaoGenerica) {
				throw (ExcecaoGenerica) e;
			} else if (e instanceof BatchUpdateException) {
				// Obtem o array com o status de execução de cada statement
				int[] updateCounts = ((BatchUpdateException) e).getUpdateCounts();

				for (int i = 0; i < updateCounts.length; i++) {
					if (updateCounts[i] == Statement.EXECUTE_FAILED) {
						// Execução falhou
						sbExcecao.append("[ Falha ao incluir o VOEntidade ");
						sbExcecao.append(pArrayVOEntidade.get(i).toString());
						sbExcecao.append(" - Message: " + ((BatchUpdateException) e).getMessage());
						sbExcecao.append(" - SQLSTATE: " + ((BatchUpdateException) e).getSQLState());
						sbExcecao.append(" - Error code: " + ((BatchUpdateException) e).getErrorCode());
						sbExcecao.append(" - NextException: " + ((BatchUpdateException) e).getNextException());
						sbExcecao.append(" ]");
					}
				}
				
			} else if (e instanceof SQLException) {
				excecao = (SQLException) e;
			}
			
			throw new ExcecaoSistema("Erro no método incluirBatch da classe " + this.getClass().getName() + " | pContextoUsuario = " +
				pContextoUsuario + " | pArrayVOEntidade.size = " + pArrayVOEntidade.size() + " | excecao = " + e, e);
		}
	}

	/**
	 * -
	 *
	 * @param pContextoUsuario
	 * @param pVOEntidade
	 *
	 * @throws ExcecaoGenerica
	 * @throws ExcecaoSistema
	 * @throws ExcecaoChaveDuplicada
	 */
	public void alterar(ContextoUsuario pContextoUsuario, VOEntidade pVOEntidade)
		throws ExcecaoGenerica {
		SQLException excecao = null;

		try {
			super.alterar(pContextoUsuario, pVOEntidade);
		} catch (Exception e) {
			if (e instanceof ExcecaoSistema) {
				if (((ExcecaoSistema) e).getExcecaoOrigem() instanceof SQLException) {
					excecao = (SQLException) ((ExcecaoSistema) e).getExcecaoOrigem();
				} else {
					throw new ExcecaoSistema("Erro no método alterar da classe " + this.getClass().getName() +
						" | pContextoUsuario = " + pContextoUsuario + " | pVOEntidade = " + pVOEntidade + " | excecao = " + e, e);
				}
			} else if (e instanceof ExcecaoGenerica) {
				throw (ExcecaoGenerica) e;
			} else if (e instanceof SQLException) {
				excecao = (SQLException) e;
			}
			
			throw new ExcecaoSistema("Erro no método alterar da classe " + this.getClass().getName() + " | pContextoUsuario = " +
				pContextoUsuario + " | pVOEntidade = " + pVOEntidade + " | excecao = " + e, e);
		}
	}
	
	/**
	 * -
	 *
	 * @param pContextoUsuario
	 * @param pArrayVOEntidade
	 *
	 * @throws ExcecaoGenerica
	 * @throws ExcecaoSistema
	 * @throws ExcecaoInclusaoBatch
	 */
	public void alterarBatch(ContextoUsuario pContextoUsuario, ArrayList<?extends VOEntidade> pArrayVOEntidade)
		throws ExcecaoGenerica {
		SQLException excecao = null;
		StringBuffer sbExcecao = new StringBuffer();

		try {
			super.alterarBatch(pContextoUsuario, pArrayVOEntidade);
		} catch (Exception e) {
			if (e instanceof ExcecaoSistema) {
				if (((ExcecaoSistema) e).getExcecaoOrigem() instanceof SQLException) {
					excecao = (SQLException) ((ExcecaoSistema) e).getExcecaoOrigem();
				} else {
					throw new ExcecaoSistema("Erro no método alterarBatch da classe " + this.getClass().getName() +
						" | pContextoUsuario = " + pContextoUsuario + " | pArrayVOEntidade.size = " + pArrayVOEntidade.size() +
						" | excecao = " + e, e);
				}
			} else if (e instanceof ExcecaoGenerica) {
				throw (ExcecaoGenerica) e;
			} else if (e instanceof BatchUpdateException) {
				// Obtem o array com o status de execução de cada statement
				int[] updateCounts = ((BatchUpdateException) e).getUpdateCounts();

				for (int i = 0; i < updateCounts.length; i++) {
					if (updateCounts[i] == Statement.EXECUTE_FAILED) {
						// Execução falhou
						sbExcecao.append("[ Falha ao alterar o VOEntidade ");
						sbExcecao.append(pArrayVOEntidade.get(i).toString());
						sbExcecao.append(" - Message: " + ((BatchUpdateException) e).getMessage());
						sbExcecao.append(" - SQLSTATE: " + ((BatchUpdateException) e).getSQLState());
						sbExcecao.append(" - Error code: " + ((BatchUpdateException) e).getErrorCode());
						sbExcecao.append(" - NextException: " + ((BatchUpdateException) e).getNextException());
						sbExcecao.append(" ]");
					}
				}
				
			} else if (e instanceof SQLException) {
				excecao = (SQLException) e;
			}
			
			throw new ExcecaoSistema("Erro no método incluirBatch da classe " + this.getClass().getName() + " | pContextoUsuario = " +
				pContextoUsuario + " | pArrayVOEntidade.size = " + pArrayVOEntidade.size() + " | excecao = " + e, e);
		}
	}	
	
	/**
	 * -
	 *
	 * @param pContextoUsuario
	 * @param pVOEntidade
	 *
	 * @throws ExcecaoGenerica
	 * @throws ExcecaoSistema
	 */
	public void excluir(ContextoUsuario pContextoUsuario, VOEntidade pVOEntidade)
		throws ExcecaoGenerica {
		SQLException excecao = null;

		try {
			super.excluir(pContextoUsuario, pVOEntidade);
		} catch (Exception e) {
			if (e instanceof ExcecaoSistema) {
				if (((ExcecaoSistema) e).getExcecaoOrigem() instanceof SQLException) {
					excecao = (SQLException) ((ExcecaoSistema) e).getExcecaoOrigem();
				} else {
					throw new ExcecaoSistema("Erro no método excluir da classe " + this.getClass().getName() +
						" | pContextoUsuario = " + pContextoUsuario + " | pVOEntidade = " + pVOEntidade + " | excecao = " + e, e);
				}
			} else if (e instanceof ExcecaoGenerica) {
				throw (ExcecaoGenerica) e;
			} else if (e instanceof SQLException) {
				excecao = (SQLException) e;
			}
			
			throw new ExcecaoSistema("Erro no método excluir da classe " + this.getClass().getName() + " | " +
				"pContextoUsuario = " + pContextoUsuario + " | pVOEntidade = " + pVOEntidade + " | excecao = " + e, e);
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
	 * @throws ExcecaoGenerica
	 * @throws ExcecaoSistema
	 */
	public VOGenerico consultarPorChavePrimaria(ContextoUsuario pContextoUsuario, VOEntidade pVOEntidade, boolean pInExtrairBLOB,
		boolean pInExtrairBLOBComoArrayBytes) throws ExcecaoGenerica {
		SQLException excecao = null;
		VOGenerico voGenerico = null;
		
		try {
			voGenerico = super.consultarPorChavePrimaria(pContextoUsuario, pVOEntidade, pInExtrairBLOB, pInExtrairBLOBComoArrayBytes);
		} catch (Exception e) {
			if (e instanceof ExcecaoSistema) {
				if (((ExcecaoSistema) e).getExcecaoOrigem() instanceof SQLException) {
					excecao = (SQLException) ((ExcecaoSistema) e).getExcecaoOrigem();
				} else {
					throw new ExcecaoSistema("Erro no método consultarPorChavePrimaria da classe " + this.getClass().getName() +
						" | pContextoUsuario = " + pContextoUsuario + " | pVOEntidade = " + pVOEntidade + " | excecao = " + e, e);
				}
			} else if (e instanceof ExcecaoGenerica) {
				throw (ExcecaoGenerica) e;
			} else if (e instanceof SQLException) {
				excecao = (SQLException) e;
			}
			
			throw new ExcecaoSistema("Erro no método consultarPorChavePrimaria da classe " + this.getClass().getName() +
				" | pContextoUsuario = " + pContextoUsuario + " | pVOEntidade = " + pVOEntidade + " | excecao = " + e, e);
		}
		
		return voGenerico;
	}

	/**
	 * -
	 *
	 * @param pContextoUsuario
	 * @param pVOEntidade
	 * @param pInExtrairBLOB
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 */
	public VOGenerico consultarPorChavePrimaria(ContextoUsuario pContextoUsuario, VOEntidade pVOEntidade, boolean pInExtrairBLOB)
		throws ExcecaoGenerica {
		return this.consultarPorChavePrimaria(pContextoUsuario, pVOEntidade, pInExtrairBLOB, false);
	}

	/**
	 * -
	 *
	 * @param pContextoUsuario
	 * @param pVOEntidade
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 */
	public VOGenerico consultarPorChavePrimaria(ContextoUsuario pContextoUsuario, VOEntidade pVOEntidade)
		throws ExcecaoGenerica {
		return this.consultarPorChavePrimaria(pContextoUsuario, pVOEntidade, false);
	}
	
	/**
	 * -
	 *
	 * @param pExcecao
	 *
	 * @return
	 */
	private String getNmEntidade(Exception pExcecao) {
		String cdErro = null;
		String nmEntidade = null;
		String txMensagemErro = null;
		String nmFK = null;
		String nmTabela = null;
		String nmMnemonico = null;

		if (pExcecao instanceof SQLException) {
			SQLException sqlException = (SQLException) pExcecao;
			cdErro = sqlException.getSQLState();
			txMensagemErro = sqlException.getMessage();

			if (cdErro != null) {
				if (cdErro.equals("23503") || cdErro.equals("23504")) {
					// Inclusão ou alteração
					// Obtem o nome da FK
					try {
						nmFK = (String) BibliotecaFuncoesPrincipal.split(txMensagemErro, ".").get(2);

						if (nmFK.indexOf(",") > -1) {
							nmFK = (String) BibliotecaFuncoesPrincipal.split(nmFK, ",").get(0);
						}
						nmMnemonico = (String) BibliotecaFuncoesPrincipal.split(nmFK, "_").get(1);

						nmEntidade = Parametros.getInstancia().getNmEntidade(nmMnemonico);

						if ((nmEntidade == null) || nmEntidade.equals("")) {
							nmEntidade = txMensagemErro;
						}
					} catch (Exception e) {
						nmEntidade = txMensagemErro;
					}
				} else if (cdErro.equals("23001") || cdErro.equals("23505")) {
					// Exclusão ou chave duplicada
					// Obtem o nome da tabela
					try {
						nmTabela = (String) BibliotecaFuncoesPrincipal.split(txMensagemErro, ".").get(1);

						if (nmTabela.indexOf(",") > -1) {
							nmTabela = (String) BibliotecaFuncoesPrincipal.split(nmTabela, ",").get(0);
						}
						
						nmMnemonico = Parametros.getInstancia().getNmMnemonico(nmTabela);
						
						if ((nmMnemonico == null) || nmMnemonico.equals("")) {
							nmEntidade = nmTabela;
						} else {
							nmEntidade = Parametros.getInstancia().getNmEntidade(nmMnemonico);
							
							if ((nmEntidade == null) || nmEntidade.equals("")) {
								nmEntidade = nmTabela;
							}
						}
					} catch (Exception e) {
						nmEntidade = txMensagemErro;
					}
				}
			}
		}
		
		return nmEntidade;
	}
	
	/**
	 * -
	 *
	 * @return
	 *
	 * @throws Exception
	 */
	public static boolean isBDProducao() {
		Boolean inBDProducao = aInBDProducao;

		if (inBDProducao == null) {
			try {
				String nmBD = DAO_DB2.getNmBD();
				String nmBDProducao = Parametros.getInstancia().getNmBDProducao();

				inBDProducao = nmBD.toLowerCase().equals(nmBDProducao.toLowerCase());
			} catch (Exception e) {
				inBDProducao = Boolean.TRUE;
			}

			aInBDProducao = inBDProducao;
		}

		return inBDProducao;
	}

	/**
	 * -
	 *
	 * @return
	 *
	 * @throws Exception
	 */
	public static String getNmBD() throws Exception {
		String nmBD = DAO_DB2.aNmBD;

		if (nmBD == null) {
			Connection conexao = DAO_DB2.getConexao(Constantes.NM_CONEXAO_JNDI_COM_UTL, true);

			try {
				nmBD = conexao.getMetaData().getURL();
			} finally {
				conexao.close();
			}

			nmBD = nmBD.substring(nmBD.lastIndexOf(':') + 1);
			DAO_DB2.aNmBD = nmBD;
		}

		return nmBD;
	}
}
