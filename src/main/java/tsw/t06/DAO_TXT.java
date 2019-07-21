/*
 * Este arquivo é propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informação nele contida pode ser
 * reproduzida, mostrada ou revelada sem permissão escrita da Sefaz-PE.
 */
package tsw.t06;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 */
public class DAO_TXT extends DAO {
	//~ Atributos/inicializadores estaticos ----------------------------------------------------------------------------------------

	private static int aQtSegsAtualizacaoPropriedadesPadrao = Constantes.QT_SEGS_ATUALIZACAO_PROPRIEDADES;

	//~ Atributos de instancia -----------------------------------------------------------------------------------------------------

	private Arquivo aArquivo;
	private Arquivo aArquivoControleSincronismo;
	private Properties aPropriedades;
	private transient ReentrantLock aLockAtualizacao;
	private boolean aInQtSegsAtualizacaoPropriedadesPadrao = true;
	private int aQtSegsAtualizacaoPropriedades = DAO_TXT.aQtSegsAtualizacaoPropriedadesPadrao;
	private volatile long aTsAtualizacaoPropriedades;

	//~ Construtores ---------------------------------------------------------------------------------------------------------------

/**
         * Cria um novo objeto DAO_TXT.
         */
	public DAO_TXT() {
		super();
	}

/**
         * Cria um novo objeto DAO_TXT.
         * 
         * @param pArquivo
         * 
         * @throws ExcecaoParametroInvalido
         */
	public DAO_TXT(Arquivo pArquivo) throws ExcecaoParametroInvalido {
		super();
		this.setArquivo(pArquivo);
	}

	//~ Metodos --------------------------------------------------------------------------------------------------------------------

	/**
	 * -
	 *
	 * @param pArquivo
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	protected void setArquivo(Arquivo pArquivo) throws ExcecaoParametroInvalido {
		this.aArquivo = pArquivo;
		this.aArquivoControleSincronismo = new Arquivo(pArquivo.getNmCompletoArquivo() + ".ctl");

		this.aArquivo.inicializarFileInputStream();
		this.aArquivo.inicializarBufferedReader();
	}

	/**
	 * -
	 *
	 * @return
	 */
	protected Arquivo getArquivo() {
		return this.aArquivo;
	}

	/**
	 * -
	 *
	 * @return
	 */
	private ReentrantLock getLockAtualizacao() {
		ReentrantLock lockAtualizacao = this.aLockAtualizacao;

		if (lockAtualizacao == null) {
			synchronized (this) {
				// Double-check para otimizar o uso normal (já inicializado) e evitar problemas de concorrência.
				lockAtualizacao = this.aLockAtualizacao;

				if (lockAtualizacao == null) {
					this.aLockAtualizacao = lockAtualizacao = new ReentrantLock();
				}
			}
		}

		return lockAtualizacao;
	}

	/**
	 * -
	 *
	 * @param pQtSegsAtualizacaoPropriedades
	 */
	public void setQtSegsAtualizacaoPropriedades(int pQtSegsAtualizacaoPropriedades) {
		if (pQtSegsAtualizacaoPropriedades < 0) {
			this.aQtSegsAtualizacaoPropriedades = DAO_TXT.aQtSegsAtualizacaoPropriedadesPadrao;
			this.aInQtSegsAtualizacaoPropriedadesPadrao = true;
			return;
		}
		
		this.aQtSegsAtualizacaoPropriedades = pQtSegsAtualizacaoPropriedades;
		this.aInQtSegsAtualizacaoPropriedadesPadrao = false;
	}
	
	/**
	 * -
	 *
	 * @return
	 */
	public int getQtSegsAtualizacaoPropriedades() {
		if (this.aInQtSegsAtualizacaoPropriedadesPadrao) {
			return DAO_TXT.aQtSegsAtualizacaoPropriedadesPadrao;
		}

		return this.aQtSegsAtualizacaoPropriedades;
	}

	/**
	 * Utilizado apenas pela classe de "Parametros" para redefinir o intervalo padrão (de todos os DAO_TXT)
	 * de acordo com o arquivo de parâmetros.
	 *
	 * @param pQtSegsAtualizacaoPropriedadesPadrao
	 */
	static void setQtSegsAtualizacaoPropriedadesPadrao(int pQtSegsAtualizacaoPropriedadesPadrao) {
		if (pQtSegsAtualizacaoPropriedadesPadrao < 0) {
			pQtSegsAtualizacaoPropriedadesPadrao = Constantes.QT_SEGS_ATUALIZACAO_PROPRIEDADES;
		}
		
		DAO_TXT.aQtSegsAtualizacaoPropriedadesPadrao = pQtSegsAtualizacaoPropriedadesPadrao;
	}

	/**
	 * -
	 *
	 * @throws ExcecaoGenerica
	 */
	protected void carregarPropriedades() throws ExcecaoGenerica {
		ReentrantLock lockAtualizacao = this.getLockAtualizacao();
		lockAtualizacao.lock();

		try {
			carregarPropriedadesSemSync();
		} catch (Exception e) {
			this.tratarExcecao("Erro no método carregarPropriedades | Arquivo = " + this.aArquivo.getNmCompletoArquivo(), e);
		} finally {
			lockAtualizacao.unlock();
		}
	}

	/**
	 * -
	 *
	 * @throws ExcecaoParametroInvalido
	 * @throws IOException
	 */
	private void carregarPropriedadesSemSync() throws ExcecaoParametroInvalido, IOException {
		this.aArquivo.inicializarFileInputStream();

		FileInputStream stream = this.aArquivo.getFileInputStream();

		this.aArquivo.atualizarUltimaModificacao();

		Properties propriedades = new Properties();
		propriedades.load(stream);
		stream.close();

		this.aPropriedades = propriedades;

		this.sinalizarCargaPropriedades(propriedades);
	}

	/**
	 * Pode ser sobreescrito para atualizar caches ou qualquer outro esquema que faça uso das propriedades.
	 *
	 * @param pPropriedades
	 */
	protected void sinalizarCargaPropriedades(Properties pPropriedades) {
	}

	/**
	 * -
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 */
	protected boolean atualizarPropriedades() throws ExcecaoGenerica {
		boolean inPropsNaoCarregadas = this.aPropriedades == null;
		ReentrantLock lockAtualizacao = this.getLockAtualizacao();

		if (inPropsNaoCarregadas) {
			lockAtualizacao.lock();

			// Double-check por questões de concorrência: não substituir pela variável "inPropsNaoCarregadas"!
			if (this.aPropriedades != null) {
				// Este caso é executado quando o "lock" esperou pela liberação de outra thread (que já estava em processo de
				// carregamento das propriedades).
				lockAtualizacao.unlock();

				return false;
			}
		} else if (!lockAtualizacao.tryLock()) {
			// Neste caso, uma outra thread já está atualizando as propriedades.
			return false;
		}

		try {
			if (inPropsNaoCarregadas || (!this.aArquivoControleSincronismo.existe() && this.aArquivo.isModificadoFileSystem())) {
				this.carregarPropriedadesSemSync();

				return true;
			}
		} catch (Exception e) {
			this.tratarExcecao("Erro no atualizarPropriedades | Arquivo = " + this.aArquivo.getNmCompletoArquivo(), e);
		} finally {
			this.aTsAtualizacaoPropriedades = System.currentTimeMillis();
			lockAtualizacao.unlock();
		}

		return false;
	}

	/**
	 * -
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 */
	protected boolean atualizarPropriedadesPorTempo() throws ExcecaoGenerica {
		// O método "getQtSegsAtualizacaoPropriedades" decidirá entre o valor padrão (estático) ou o valor da instância.
		int qtSegsAtualizacao = this.getQtSegsAtualizacaoPropriedades();

		if (qtSegsAtualizacao > 0) {
			long segsUltAtualizacao = (System.currentTimeMillis() - this.aTsAtualizacaoPropriedades) / 1000;

			if (segsUltAtualizacao < qtSegsAtualizacao) {
				return false;
			}
		}

		return this.atualizarPropriedades();
	}

	/**
	 * -
	 *
	 * @param pNmPropriedade
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 */
	protected String getPropriedade(String pNmPropriedade)
		throws ExcecaoGenerica {
		return this.getPropriedade(pNmPropriedade, true);
	}

	/**
	 * -
	 *
	 * @param pNmPropriedade
	 * @param pInAtualizarPropriedadesArquivo
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 */
	protected String getPropriedade(String pNmPropriedade, boolean pInAtualizarPropriedadesArquivo)
		throws ExcecaoGenerica {
		return this.getPropriedade(pNmPropriedade, pInAtualizarPropriedadesArquivo, false);
	}

	/**
	 * -
	 *
	 * @param pNmPropriedade
	 * @param pInAtualizarPropriedades
	 * @param pInRetornarNulo
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 */
	protected String getPropriedade(String pNmPropriedade, boolean pInAtualizarPropriedades, boolean pInRetornarNulo)
		throws ExcecaoGenerica {
		try {
			Properties propriedades;

			if (pInAtualizarPropriedades || ((propriedades = this.aPropriedades) == null)) {
				this.atualizarPropriedadesPorTempo();
				propriedades = this.aPropriedades;

				if (propriedades == null) {
					if (pInRetornarNulo) {
						return null;
					} else {
						throw criarExcecaoRegistroNaoEncontrado(pNmPropriedade);
					}
				}
			}

			String str = propriedades.getProperty(pNmPropriedade);

			if ((str != null) || pInRetornarNulo) {
				return str;
			}

			throw criarExcecaoRegistroNaoEncontrado(pNmPropriedade);
		} catch (ExcecaoRegistroNaoEncontrado e) {
			throw e;
		} catch (Exception e) {
			this.tratarExcecao("Erro no getPropriedade | Arquivo = " + this.aArquivo.getNmCompletoArquivo() +
				" | pNmPropriedade = " + pNmPropriedade, e);
			return null;
		}
	}

	/**
	 * -
	 *
	 * @param pNmPropriedade
	 *
	 * @return
	 */
	private ExcecaoRegistroNaoEncontrado criarExcecaoRegistroNaoEncontrado(String pNmPropriedade) {
		String dsDbg1 = "pNmPropriedade = ";
		String dsDbg2 = pNmPropriedade;

		StringBuilder dsDebug = new StringBuilder(dsDbg1.length() + dsDbg2.length());
		dsDebug.append(dsDbg1);
		dsDebug.append(dsDbg2);

		return new ExcecaoRegistroNaoEncontrado(this.aArquivo.getNmArquivo(), dsDebug.toString());
	}

	/**
	 * -
	 *
	 * @return
	 *
	 * @throws ExcecaoSistema
	 */
	public Properties getPropriedades() throws ExcecaoSistema {
		Properties propriedades = null;
		
		try {
			this.atualizarPropriedades();
			propriedades = (Properties) BibliotecaFuncoesPrincipal.clone(this.aPropriedades);
		} catch (Exception e) {
			throw new ExcecaoSistema("Erro clonando o objeto Properties", e);
		}
		
		return propriedades;
	}
	
}