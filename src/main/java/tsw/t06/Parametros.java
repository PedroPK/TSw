/*
 * Este arquivo � propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informa��o nele contida pode ser
 * reproduzida, mostrada ou revelada sem permiss�o escrita da Sefaz-PE.
 */
package tsw.t06;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 */
public class Parametros {
	//~ Atributos/inicializadores estaticos ----------------------------------------------------------------------------------------
	
	private static final String NM_COL_CdParParametro = "PARMSIS_CD";
	private static final String NM_COL_VlParParametro = "PARMSISCPL_VL";
	
	/**
	 * -
	 */
	public static final int CD_TRACE_TRANSACAO_NIVEL0 = 0;
	public static final int CD_TRACE_TRANSACAO_NIVEL1 = 1;
	public static final int CD_TRACE_TRANSACAO_NIVEL2 = 2;
	public static final int CD_TRACE_TRANSACAO_NIVEL3 = 3;
	
	/**
	 * Para registrar os statements sql
	 */
	public static final int CD_TRACE_TRANSACAO_NIVEL10 = 10;
	
	/**
	 * -
	 */
	public static final int CD_AJUDAONLINE_CASOUSO_ATIVADO = 0;
	
	/**
	 * -
	 */
	public static final int CD_AJUDAONLINE_VERSAO1_ATIVADO = 1;
	public static final int CD_AJUDAONLINE_VERSAO2_ATIVADO = 2;
	
	/**
	 * -
	 */
	private static Parametros aParametros = new Parametros();
	
	//~ Atributos de instancia -----------------------------------------------------------------------------------------------------
	
	private Boolean aVlTraceAtivado;
	private Boolean aVlTraceEJBAtivado;
	private Boolean aVlTraceFachadaAtivado;
	private DAO_TXT aDAOMnemonico;
	private DAO_TXT aDAOParametro;
	private DAO_TXT aDAOParametroDinamico;
	private DAO_TXT aDAOTabela;
	private Integer aVlTraceTransacaoAtivado;
	private final List<String> aNmClassesUtilitariasPadrao = new ArrayList<String>();
	private final Map<String, DAO_TXT> aDAOsParametroSistema = new HashMap<String, DAO_TXT>();
	private Map<String, Object> aCacheParametros;
	private Map<String, Object> aCacheParametrosDinamicos;
	private Set<String> aVlTraceNmClassesUtilitarias;
	private String aVlHTTPHeaderCacheControl;
	
	//~ Construtores ---------------------------------------------------------------------------------------------------------------
	
	
	//~ Metodos --------------------------------------------------------------------------------------------------------------------
	
	/**
	 * -
	 *
	 * @return
	 */
	public static Parametros getInstancia() {
		if (Parametros.aParametros == null) {
			Parametros.aParametros = new Parametros();
		}
		
		return Parametros.aParametros;
	}

	/**
	 * -
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 */
	private DAO_TXT getDAOParametro() throws ExcecaoGenerica {
		DAO_TXT daoParametro = this.aDAOParametro;

		if (daoParametro == null) {
			daoParametro = new DAO_TXT() {
						@Override
						protected void sinalizarCargaPropriedades(Properties pPropriedades) {
							Parametros.this.aCacheParametros = new ConcurrentHashMap<String, Object>(256);

							Parametros.this.aVlHTTPHeaderCacheControl = null;
						}
					};

			daoParametro.setArquivo(new Arquivo(Constantes.NM_PATH_CONFIG + File.separator + "parametros.properties"));

			this.aDAOParametro = daoParametro;
		}

		return daoParametro;
	}

	/**
	 * -
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 */
	private DAO_TXT getDAOParametroDinamico() throws ExcecaoGenerica {
		DAO_TXT daoParametro = this.aDAOParametroDinamico;

		if (daoParametro == null) {
			daoParametro = new DAO_TXT() {
						@Override
						protected void sinalizarCargaPropriedades(Properties pPropriedades) {
							Parametros.this.aCacheParametrosDinamicos = new ConcurrentHashMap<String, Object>(256);

							Parametros.this.aVlTraceAtivado = null;
							Parametros.this.aVlTraceTransacaoAtivado = null;
							Parametros.this.aVlTraceNmClassesUtilitarias = null;
							Parametros.this.aVlTraceFachadaAtivado = null;
							Parametros.this.aVlTraceEJBAtivado = null;

							// Redefine o intervalo (em segundos) de atualiza��o de propriedades padr�o (de todos os DAO_TXT).
							try {
								String strQtSegsAtualizacao = pPropriedades.getProperty("QtSegsAtualizacaoPropriedades");
								int qtSegsAtualizacao;

								if (strQtSegsAtualizacao != null) {
									qtSegsAtualizacao = Integer.valueOf(strQtSegsAtualizacao);
								} else {
									qtSegsAtualizacao = -1;
								}

								DAO_TXT.setQtSegsAtualizacaoPropriedadesPadrao(qtSegsAtualizacao);
							} catch (Exception e) {
							}

							// Redefine o intervalo (em segundos) de atualiza��o de propriedades dos DAO_TXT utilizados nesta classe.
							try {
								String strQtSegsAtualizacao = pPropriedades.getProperty("QtSegsAtualizacaoPropriedadesFMW");
								int qtSegsAtualizacao;

								if (strQtSegsAtualizacao != null) {
									qtSegsAtualizacao = Integer.valueOf(strQtSegsAtualizacao);
								} else {
									qtSegsAtualizacao = -1;
								}

								Parametros.this.aDAOMnemonico.setQtSegsAtualizacaoPropriedades(qtSegsAtualizacao);
								Parametros.this.aDAOParametro.setQtSegsAtualizacaoPropriedades(qtSegsAtualizacao);
								Parametros.this.aDAOParametroDinamico.setQtSegsAtualizacaoPropriedades(qtSegsAtualizacao);
								Parametros.this.aDAOTabela.setQtSegsAtualizacaoPropriedades(qtSegsAtualizacao);
							} catch (Exception e) {
							}
						}
					};

			daoParametro.setArquivo(new Arquivo(Constantes.NM_PATH_CONFIG + File.separator + "parametros_dinamicos.properties"));

			this.aDAOParametroDinamico = daoParametro;
		}

		return daoParametro;
	}

	/**
	 * -
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 */
	private DAO_TXT getDAOTabela() throws ExcecaoGenerica {
		if (this.aDAOTabela == null) {
			this.aDAOTabela = new DAO_TXT();
			this.aDAOTabela.setArquivo(new Arquivo(Constantes.NM_PATH_CONFIG + File.separator + "tabelas.properties"));
		}

		return this.aDAOTabela;
	}

	/**
	 * -
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 */
	private DAO_TXT getDAOMnemonico() throws ExcecaoGenerica {
		if (this.aDAOMnemonico == null) {
			this.aDAOMnemonico = new DAO_TXT();
			this.aDAOMnemonico.setArquivo(new Arquivo(Constantes.NM_PATH_CONFIG + File.separator + "mnemonicos.properties"));
		}

		return this.aDAOMnemonico;
	}

	/**
	 * -
	 *
	 * @param pNmMnemonico
	 *
	 * @return
	 */
	public String getNmEntidade(String pNmMnemonico) {
		String str = null;

		try {
			str = this.getDAOMnemonico().getPropriedade(pNmMnemonico, true, true);
		} catch (Exception e) {
		}

		if (str == null) {
			str = pNmMnemonico;
		}

		return str;
	}

	/**
	 * -
	 *
	 * @param pNmTabela
	 *
	 * @return
	 */
	public String getNmMnemonico(String pNmTabela) {
		String str = null;

		try {
			str = this.getDAOTabela().getPropriedade(pNmTabela, true, true);
		} catch (Exception e) {
		}

		if (str == null) {
			str = pNmTabela;
		}

		return str;
	}

	/**
	 * -
	 *
	 * @param pSgArea
	 * @param pSgSistema
	 * @param pNmParametro
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 * @throws ExcecaoSistema
	 */
	public String getParametroPropriedade(String pSgArea, String pSgSistema, String pNmParametro)
		throws ExcecaoGenerica {
		String str = "";
		DAO_TXT daoParametroSistema;
		String nmDAOParametroSistema = "parametros_" + pSgArea.toLowerCase() + "_" + pSgSistema.toLowerCase() + ".properties";

		try {
			daoParametroSistema = (DAO_TXT) this.aDAOsParametroSistema.get(nmDAOParametroSistema);

			if (daoParametroSistema == null) {
				daoParametroSistema = new DAO_TXT();
				daoParametroSistema.setArquivo(new Arquivo(BibliotecaFuncoesPrincipal.getNmPathConfigSistema(pSgArea, pSgSistema) +
						File.separator + nmDAOParametroSistema));
				this.aDAOsParametroSistema.put(nmDAOParametroSistema, daoParametroSistema);
			}

			str = daoParametroSistema.getPropriedade(pNmParametro);
		} catch (Exception e) {
			if (e instanceof ExcecaoGenerica) {
				throw (ExcecaoGenerica) e;
			} else {
				throw new ExcecaoSistema("Erro consultando par�metro (pSgSistema = " + pSgSistema + " | pNmParametro = " +
					pNmParametro + ")", e);
			}
		}

		return str;
	}

	/**
	 * -
	 *
	 * @param pSgArea
	 * @param pSgSistema
	 * @param pNmParametro
	 * @param pNmSufixoArquivo
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 * @throws ExcecaoSistema
	 */
	public String getParametroPropriedade(String pSgArea, String pSgSistema, String pNmParametro, String pNmSufixoArquivo)
		throws ExcecaoGenerica {
		String str = "";
		String nmDAOParametroSistema = "parametros_" + pSgArea.toLowerCase() + "_" + pSgSistema.toLowerCase() + pNmSufixoArquivo +
			".properties";

		try {
			DAO_TXT daoParametroSistema = (DAO_TXT) this.aDAOsParametroSistema.get(nmDAOParametroSistema);

			if (daoParametroSistema == null) {
				daoParametroSistema = new DAO_TXT();
				daoParametroSistema.setArquivo(new Arquivo(BibliotecaFuncoesPrincipal.getNmPathConfigSistema(pSgArea, pSgSistema) +
						File.separator + nmDAOParametroSistema));
				this.aDAOsParametroSistema.put(nmDAOParametroSistema, daoParametroSistema);
			}

			str = daoParametroSistema.getPropriedade(pNmParametro);
		} catch (Exception e) {
			if (e instanceof ExcecaoGenerica) {
				throw (ExcecaoGenerica) e;
			} else {
				throw new ExcecaoSistema("Erro consultando par�metro (pSgSistema = " + pSgSistema + " | pNmParametro = " +
					pNmParametro + " | pNmSufixoArquivo = " + pNmSufixoArquivo + ")", e);
			}
		}
		
		return str;
	}
	
	/**
	 * -
	 *
	 * @param <T>
	 * @param pDAO
	 * @param pCache
	 * @param pNmPropriedade
	 * @param pConversor
	 *
	 * @return
	 *
	 * @throws RuntimeException
	 */
	@SuppressWarnings("unchecked")
	private <T> T consultarDAOComCache(DAO_TXT pDAO, Map<String, Object> pCache, String pNmPropriedade,
		ConversorPropriedade<T> pConversor) {
		T vlCache = (T) pCache.get(pNmPropriedade);

		if (vlCache != null) {
			// Utiliza a classe privada "ConversorPropriedade" como indicador de valor nulo em cache. 
			if (vlCache.equals(ConversorPropriedade.class)) {
				return null;
			}

			return pConversor.clonar(vlCache);
		}

		String vlPropriedade = null;

		if (pDAO != null) {
			try {
				// A atualiza��o j� foi verificada no in�cio, n�o � necess�ria no "getPropriedade".
				vlPropriedade = pDAO.getPropriedade(pNmPropriedade, false, true);
			} catch (Exception e) {
			}
		}

		T vlParametro;

		try {
			vlParametro = pConversor.converter(vlPropriedade);
		} catch (Exception e) {
			throw new RuntimeException("Erro convertendo valor do par�metro [" + pNmPropriedade + "] do arquivo " +
				pDAO.getArquivo().getNmArquivo() + ".", e);
		}

		if (vlParametro == null) {
			// Utiliza a classe privada "ConversorPropriedade" como indicador de valor nulo em cache. 
			pCache.put(pNmPropriedade, ConversorPropriedade.class);
		} else {
			pCache.put(pNmPropriedade, vlParametro);
		}

		return vlParametro;
	}

	/**
	 * -
	 *
	 * @param <T>
	 * @param pNmPropriedade
	 * @param pConversor
	 *
	 * @return
	 */
	private <T> T consultarDAOParametro(String pNmPropriedade, ConversorPropriedade<T> pConversor) {
		DAO_TXT dao = null;

		try {
			dao = this.getDAOParametro();

			// Primeiro tenta atualizar. Pois, caso haja atualiza��o, o cache ser� substitu�do.
			dao.atualizarPropriedadesPorTempo();
		} catch (Exception e) {
		}

		// ATEN��O: o m�todo "getDAOParametro" deve realizar a limpeza da vari�vel "aCacheParametros" a cada recarga das propriedades.
		return this.consultarDAOComCache(dao, this.aCacheParametros, pNmPropriedade, pConversor);
	}

	/**
	 * -
	 *
	 * @param <T>
	 * @param pNmPropriedade
	 * @param pConversor
	 *
	 * @return
	 */
	private <T> T consultarDAOParametroDinamico(String pNmPropriedade, ConversorPropriedade<T> pConversor) {
		DAO_TXT dao = null;

		try {
			dao = this.getDAOParametroDinamico();

			// Primeiro tenta atualizar. Pois, caso haja atualiza��o, o cache ser� substitu�do.
			dao.atualizarPropriedadesPorTempo();
		} catch (Exception e) {
		}

		// ATEN��O: o m�todo "getDAOParametroDinamico" deve realizar a limpeza da vari�vel "aCacheParametrosDinamicos" a cada recarga
		// das propriedades.
		return this.consultarDAOComCache(dao, this.aCacheParametrosDinamicos, pNmPropriedade, pConversor);
	}

	/**
	 * -
	 *
	 * @param pNmPropriedade
	 * @param pNmContextoWeb
	 *
	 * @return
	 */
	private String getNmPropriedadePorContexto(String pNmPropriedade, String pNmContextoWeb) {
		if (pNmContextoWeb == null) {
			pNmContextoWeb = "";
		}

		StringBuilder sbNmParam = new StringBuilder(pNmPropriedade.length() + pNmContextoWeb.length() + 1);
		sbNmParam.append(pNmPropriedade);
		sbNmParam.append('@');
		sbNmParam.append(pNmContextoWeb);

		return sbNmParam.toString();
	}

	/**
	 * -
	 *
	 * @param pNmPropriedade
	 * @param pCdSistema
	 *
	 * @return
	 */
	private String getNmPropriedadePorSistema(String pNmPropriedade, String pCdSistema) {
		if (pCdSistema == null) {
			pCdSistema = "";
		}

		return this.getNmPropriedadePorContexto(pNmPropriedade, BibliotecaFuncoesPrincipal.getNmContextoWebPorSistema(pCdSistema));
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmPathBase() {
		return Constantes.NM_PATH_BASE;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public int getQtMaximaObjetosCache() {
		return this.consultarDAOParametro("QtMaximaObjetosCache",
			new ConversorPropriedade<Integer>() {
				public Integer converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return 600;
					}

					return Integer.valueOf(pVlPropriedade);
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public int getTempoExpiracaoContextoSessao() {
		return this.consultarDAOParametro("TempoExpiracaoContextoSessao",
			new ConversorPropriedade<Integer>() {
				public Integer converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return 20;
					}

					return Integer.valueOf(pVlPropriedade);
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getCdUsuarioDefault() {
		return this.consultarDAOParametro("CdUsuarioDefault",
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return Constantes.CD_USUARIO_ANONIMO;
					}

					return pVlPropriedade;
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public int getQtLimiteRegistrosConsulta() {
		return this.consultarDAOParametroDinamico("QtLimiteRegistrosConsulta",
			new ConversorPropriedade<Integer>() {
				public Integer converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return 100000;
					}

					int vlParametro = Integer.parseInt(pVlPropriedade);

					// Incrementa caso n�o seja n�mero par.
					if ((vlParametro % 2) != 0) {
						vlParametro += 1;
					}

					return vlParametro;
				}
			});
	}

	/**
	 * -
	 *
	 * @param pCdSistema
	 *
	 * @return
	 */
	public boolean isUtilizacaoBatchDesativado(String pCdSistema) {
		String nmPropriedade = this.getNmPropriedadePorSistema("UtilizacaoBatchDesativado", pCdSistema);

		return this.consultarDAOParametroDinamico(nmPropriedade,
			new ConversorPropriedade<Boolean>() {
				public Boolean converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return false;
					}

					return converterBoolean(pVlPropriedade);
				}
			});
	}

	/**
	 * -
	 *
	 * @param pNmContextoWeb
	 *
	 * @return
	 */
	public String getCdUsuarioDefault(String pNmContextoWeb) {
		String nmPropriedade = this.getNmPropriedadePorContexto("CdUsuarioDefault", pNmContextoWeb);

		return this.consultarDAOParametro(nmPropriedade,
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					return pVlPropriedade;
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public Short getCdTipoUsuarioDefault() {
		return this.consultarDAOParametro("CdTipoUsuarioDefault",
			new ConversorPropriedade<Short>() {
				public Short converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return Constantes.CD_TIPO_USUARIO_SERVIDOR_SEFAZ;
					}

					return Short.valueOf(pVlPropriedade);
				}
			});
	}

	/**
	 * -
	 *
	 * @param pNmContextoWeb
	 *
	 * @return
	 */
	public Short getCdTipoUsuarioDefault(String pNmContextoWeb) {
		String nmPropriedade = this.getNmPropriedadePorContexto("CdTipoUsuarioDefault", pNmContextoWeb);

		return this.consultarDAOParametro(nmPropriedade,
			new ConversorPropriedade<Short>() {
				public Short converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return Constantes.CD_TIPO_USUARIO_SERVIDOR_SEFAZ;
					}

					return Short.valueOf(pVlPropriedade);
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public Integer getCdPessoaDefault() {
		return this.consultarDAOParametro("CdPessoaDefault",
			new ConversorPropriedade<Integer>() {
				public Integer converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return 1;
					}

					return Integer.valueOf(pVlPropriedade);
				}
			});
	}

	/**
	 * -
	 *
	 * @param pNmContextoWeb
	 *
	 * @return
	 */
	public Integer getCdPessoaDefault(String pNmContextoWeb) {
		String nmPropriedade = this.getNmPropriedadePorContexto("CdPessoaDefault", pNmContextoWeb);

		return this.consultarDAOParametro(nmPropriedade,
			new ConversorPropriedade<Integer>() {
				public Integer converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return 1;
					}

					return Integer.valueOf(pVlPropriedade);
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNuCNPFDefault() {
		return this.consultarDAOParametro("NuCNPFDefault",
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return "03326337647";
					}

					return pVlPropriedade;
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public Integer getCdFuncaoDefault() {
		return this.consultarDAOParametro("CdFuncaoDefault",
			new ConversorPropriedade<Integer>() {
				public Integer converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return 1;
					}

					return Integer.valueOf(pVlPropriedade);
				}
			});
	}

	/**
	 * -
	 *
	 * @param pNmContextoWeb
	 *
	 * @return
	 */
	public String getNuCNPFDefault(String pNmContextoWeb) {
		String nmPropriedade = this.getNmPropriedadePorContexto("NuCNPFDefault", pNmContextoWeb);

		return this.consultarDAOParametro(nmPropriedade,
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return "03326337647";
					}

					return pVlPropriedade;
				}
			});
	}
	
	/**
	 * -
	 *
	 * @return
	 */
	public String getURLCSS() {
		return this.consultarDAOParametro("URLCSS",
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						String urlBaseCSS = Parametros.this.getURLBaseCSS();
						String pathArquivo = "/sefaz_pe.css";

						StringBuilder sbUrlCSS = new StringBuilder(urlBaseCSS.length() + pathArquivo.length());
						sbUrlCSS.append(urlBaseCSS);
						sbUrlCSS.append(pathArquivo);

						return sbUrlCSS.toString();
					}

					return pVlPropriedade;
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getURLCSSBase() {
		return this.consultarDAOParametro("URLCSSBase",
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						String urlBaseCSS = Parametros.this.getURLBaseCSS();
						String pathArquivo = "/sefaz_pe_base.css";

						StringBuilder sbUrlCSS = new StringBuilder(urlBaseCSS.length() + pathArquivo.length());
						sbUrlCSS.append(urlBaseCSS);
						sbUrlCSS.append(pathArquivo);

						return sbUrlCSS.toString();
					}

					return pVlPropriedade;
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getURLCSSResponsivo() {
		return this.consultarDAOParametro("URLCSSResponsivo",
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						String urlBaseCSS = Parametros.this.getURLBaseCSS();
						String pathArquivo = "/sefaz_pe_resp.css";

						StringBuilder sbUrlCSS = new StringBuilder(urlBaseCSS.length() + pathArquivo.length());
						sbUrlCSS.append(urlBaseCSS);
						sbUrlCSS.append(pathArquivo);

						return sbUrlCSS.toString();
					}

					return pVlPropriedade;
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getURLBaseCSS() {
		return this.consultarDAOParametro("URLBaseCSS",
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return "/sfi/theme";
					}

					return pVlPropriedade;
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getURLBaseImagens() {
		return this.consultarDAOParametro("URLBaseImagens",
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return "/sfi/imagens/";
					}

					return pVlPropriedade;
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getURLBaseJavaScript() {
		return this.consultarDAOParametro("URLBaseJS",
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return "/sfi/js";
					}

					return pVlPropriedade;
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmServidorEMail() {
		return this.consultarDAOParametro("NmServidorEMail",
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return "localhost";
					}

					return pVlPropriedade;
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmAmbiente() {
		return this.consultarDAOParametro("NmAmbiente",
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return "";
					}

					return pVlPropriedade;
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmProtocoloWeb() {
		return this.consultarDAOParametro("NmProtocoloWeb",
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return "https";
					}

					return pVlPropriedade;
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getPrefixoIPIntranet() {
		return this.consultarDAOParametro("PrefixoIPIntranet",
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return "-";
					}

					return pVlPropriedade;
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getPrefixoIPv6Intranet() {
		return this.consultarDAOParametro("PrefixoIPv6Intranet",
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return "-";
					}

					return pVlPropriedade;
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmServidorWebDesenvolvimento() {
		return this.consultarDAOParametro("NmServidorDesenvolvimento",
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return "";
					}

					return pVlPropriedade;
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getVlHTTPHeaderCacheControl() {
		// Devido a grande quantidade de acessos a este par�metro, � realizado cache est�tico (em vari�vel de classe espec�fica) no
		// lugar do cache din�mico (via "consultarDAOComCache").
		// ATEN��O: o m�todo "getDAOParametro" deve realizar a limpeza da vari�vel "aVlHTTPHeaderCacheControl" a cada recarga
		// das propriedades.
		String vlParametro = this.aVlHTTPHeaderCacheControl;

		if (vlParametro != null) {
			return vlParametro;
		}

		String nmPropriedade = "VlHTTPHeaderCacheControl";

		try {
			vlParametro = this.getDAOParametro().getPropriedade(nmPropriedade, true, true);
		} catch (Exception e) {
		}

		if (vlParametro == null) {
			vlParametro = Constantes.VL_PADRAO_HTTP_HEADER_CACHE_CONTROL;
		}

		this.aVlHTTPHeaderCacheControl = vlParametro;

		return vlParametro;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmDominioWebDesenvolvimento() {
		return this.consultarDAOParametro("NmDominioWebDesenvolvimento",
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return "";
					}

					return pVlPropriedade;
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmProviderURLConexaoBD() {
		return this.consultarDAOParametro("NmProviderURLConexaoBD",
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						pVlPropriedade = "iiop://localhost:900";
					}

					String nmExtensaoProviderURL = Parametros.this.getNmExtensaoProviderURL();

					StringBuilder sbValor = new StringBuilder(pVlPropriedade.length() + nmExtensaoProviderURL.length());
					sbValor.append(pVlPropriedade);
					sbValor.append(nmExtensaoProviderURL);

					return sbValor.toString();
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmProviderURLUserTransactionJob() {
		return this.consultarDAOParametro("NmProviderURLUserTransactionJob",
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						pVlPropriedade = "iiop://localhost:900";
					}

					String nmExtensaoProviderURL = Parametros.this.getNmExtensaoProviderURL();

					StringBuilder sbValor = new StringBuilder(pVlPropriedade.length() + nmExtensaoProviderURL.length());
					sbValor.append(pVlPropriedade);
					sbValor.append(nmExtensaoProviderURL);

					return sbValor.toString();
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmExtensaoProviderURL() {
		return this.consultarDAOParametro("NmExtensaoProviderURL",
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return "";
					}

					return pVlPropriedade;
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmBDProducao() {
		return this.consultarDAOParametro("NmBDProducao",
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return "dbefcp01";
					}

					return pVlPropriedade;
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public int getVlLockTimeoutTransacaoJDBC() {
		return this.consultarDAOParametro("VlLockTimeoutTransacaoJDBC",
			new ConversorPropriedade<Integer>() {
				public Integer converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return 180;
					}

					return Integer.valueOf(pVlPropriedade);
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public int getVlTimeoutTransacaoJTA_BMT() {
		return this.consultarDAOParametro("VlTimeoutTransacaoJTA_BMT",
			new ConversorPropriedade<Integer>() {
				public Integer converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return 1200;
					}

					return Integer.valueOf(pVlPropriedade);
				}
			});
	}

	/**
	 * Utilizado pela classe Sequencial
	 *
	 * @return
	 */
	public String getCdUnidadeOrganizacional() {
		return this.consultarDAOParametro("CdUnidadeOrganizacional",
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return "";
					}

					return pVlPropriedade;
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getQtRegistrosPorPagina() {
		return this.consultarDAOParametro("QtRegistrosPorPagina",
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return "5|10*|20|30|40|50|999999";
					}

					return pVlPropriedade;
				}
			});
	}

	/**
	 * -
	 *
	 * @param pQtRegistrosPorPagina
	 *
	 * @return
	 */
	public String getQtRegistrosPorPaginaDefault(String pQtRegistrosPorPagina) {
		String valorDefault = null;

		try {
			ArrayList<String> valores = BibliotecaFuncoesPrincipal.split(pQtRegistrosPorPagina, "|");
			valorDefault = (String) valores.get(0);

			for (int i = 0; i < valores.size(); i++) {
				String valor = (String) valores.get(i);

				// Remove indicador do valor default
				if (valor.lastIndexOf("*") != -1) {
					valor = BibliotecaFuncoesPrincipal.eliminarCaractere('*', valor);
					valorDefault = valor;
				}
			}
		} catch (Exception e) {
		}

		if (valorDefault == null) {
			return "10";
		}

		return valorDefault;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getQtRegistrosPorPaginaDefault() {
		return this.consultarDAOParametro("QtRegistrosPorPaginaDefault",
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						String qtRegistrosPorPagina = Parametros.this.getQtRegistrosPorPagina();

						return Parametros.this.getQtRegistrosPorPaginaDefault(qtRegistrosPorPagina);
					}

					return pVlPropriedade;
				}
			});
	}

	/**
	 * -
	 *
	 * @param pTpRedeAcesso
	 *
	 * @return
	 */
	public String getQtRegistrosPorPaginaPorTpRedeAcesso(String pTpRedeAcesso) {
		String nmPropriedade = "QtRegistrosPorPagina";

		StringBuilder sbNmPropriedade = new StringBuilder(nmPropriedade.length() + pTpRedeAcesso.length());
		sbNmPropriedade.append(nmPropriedade);
		sbNmPropriedade.append(pTpRedeAcesso);

		nmPropriedade = sbNmPropriedade.toString();

		return this.consultarDAOParametro(nmPropriedade,
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return "";
					}

					return pVlPropriedade;
				}
			});
	}

	/**
	 * -
	 *
	 * @param pRede
	 *
	 * @return
	 */
	public String getQtRegistrosPorPaginaPorRede(String pRede) {
		// N�o realiza cache para este par�metro porque ser� consultado para cada IP. Isto acumularia uma quantidade muito grande de
		// propriedades no cache.
		String nmPropriedade = "QtRegistrosPorPaginaRede_";

		StringBuilder sbNmPropriedade = new StringBuilder(nmPropriedade.length() + pRede.length());
		sbNmPropriedade.append(nmPropriedade);
		sbNmPropriedade.append(pRede);

		nmPropriedade = sbNmPropriedade.toString();

		String str = null;

		try {
			str = this.getDAOParametro().getPropriedade(nmPropriedade, true, true);
		} catch (Exception e) {
		}

		if (str == null) {
			return "";
		}

		return str;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public boolean isLogExcecaoPaginaMensagemUsuarioAtivado() {
		return this.consultarDAOParametro("LogExcecaoPaginaMensagemUsuarioAtivado",
			new ConversorPropriedade<Boolean>() {
				public Boolean converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return true;
					}

					return converterBoolean(pVlPropriedade);
				}
			});
	}

	/**
	 * -
	 *
	 * @param pCdUsuario
	 *
	 * @return
	 */
	public boolean isLogExcecaoPaginaMensagemUsuarioCdUsuarioAtivado(final String pCdUsuario) {
		return this.consultarDAOParametroDinamico("LogExcecaoPaginaMensagemUsuarioCdUsuarioAtivado",
			new ConversorPropriedade<Boolean>() {
				public Boolean converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return false;
					}

					return pVlPropriedade.lastIndexOf("|" + pCdUsuario + "|") > -1;
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public boolean isTraceAtivado() {
		// Devido a grande quantidade de acessos a este par�metro, � realizado cache est�tico (em vari�vel de classe espec�fica) no
		// lugar do cache din�mico (via "consultarDAOComCache").
		// ATEN��O: o m�todo "getDAOParametroDinamico" deve realizar a limpeza da vari�vel "aVlTraceAtivado" a cada recarga
		// das propriedades.
		Boolean vlParametro = this.aVlTraceAtivado;

		if (vlParametro != null) {
			return vlParametro;
		}

		String nmPropriedade = "TraceAtivado";

		try {
			String pVlPropriedade = this.getDAOParametroDinamico().getPropriedade(nmPropriedade, true, true);

			if (pVlPropriedade != null) {
				vlParametro = ConversorPropriedade.converterBoolean(pVlPropriedade);
			}
		} catch (Exception e) {
		}

		if (vlParametro == null) {
			vlParametro = Boolean.FALSE;
		}

		this.aVlTraceAtivado = vlParametro;

		return vlParametro;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public boolean isTraceFachadaAtivado() {
		// Devido a grande quantidade de acessos a este par�metro, � realizado cache est�tico (em vari�vel de classe espec�fica) no
		// lugar do cache din�mico (via "consultarDAOComCache").
		// ATEN��O: o m�todo "getDAOParametroDinamico" deve realizar a limpeza da vari�vel "aVlTraceFachadaAtivado" a cada recarga
		// das propriedades.
		Boolean vlParametro = this.aVlTraceFachadaAtivado;

		if (vlParametro != null) {
			return vlParametro;
		}

		String nmPropriedade = "TraceFachadaAtivado";

		try {
			String pVlPropriedade = this.getDAOParametroDinamico().getPropriedade(nmPropriedade, true, true);

			if (pVlPropriedade != null) {
				vlParametro = ConversorPropriedade.converterBoolean(pVlPropriedade);
			}
		} catch (Exception e) {
		}

		if (vlParametro == null) {
			vlParametro = Boolean.FALSE;
		}

		this.aVlTraceFachadaAtivado = vlParametro;

		return vlParametro;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public boolean isTraceEJBAtivado() {
		// Devido a grande quantidade de acessos a este par�metro, � realizado cache est�tico (em vari�vel de classe espec�fica) no
		// lugar do cache din�mico (via "consultarDAOComCache").
		// ATEN��O: o m�todo "getDAOParametroDinamico" deve realizar a limpeza da vari�vel "aVlTraceEJBAtivado" a cada recarga
		// das propriedades.
		Boolean vlParametro = this.aVlTraceEJBAtivado;

		if (vlParametro != null) {
			return vlParametro;
		}

		String nmPropriedade = "TraceEJBAtivadoParaDESENV";

		try {
			String pVlPropriedade = this.getDAOParametroDinamico().getPropriedade(nmPropriedade, true, true);

			if (pVlPropriedade != null) {
				vlParametro = ConversorPropriedade.converterBoolean(pVlPropriedade);
			}
		} catch (Exception e) {
		}

		if (vlParametro == null) {
			vlParametro = Boolean.FALSE;
		}

		this.aVlTraceEJBAtivado = vlParametro;

		return vlParametro;
	}

	/**
	 * -
	 *
	 * @param pCdSistema
	 *
	 * @return
	 */
	public boolean isTraceAtivado(String pCdSistema) {
		String nmPropriedade = this.getNmPropriedadePorSistema("TraceAtivado", pCdSistema);

		return this.consultarDAOParametroDinamico(nmPropriedade,
			new ConversorPropriedade<Boolean>() {
				public Boolean converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return false;
					}

					return converterBoolean(pVlPropriedade);
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public int getTraceTransacaoAtivado() {
		// Devido a grande quantidade de acessos a este par�metro, � realizado cache est�tico (em vari�vel de classe espec�fica) no
		// lugar do cache din�mico (via "consultarDAOComCache").
		// ATEN��O: o m�todo "getDAOParametroDinamico" deve realizar a limpeza da vari�vel "aVlTraceTransacaoAtivado" a cada recarga
		// das propriedades.
		Integer vlParametro = this.aVlTraceTransacaoAtivado;

		if (vlParametro != null) {
			return vlParametro;
		}

		String nmPropriedade = "TraceDAOBDAtivado";

		try {
			String pVlPropriedade = this.getDAOParametroDinamico().getPropriedade(nmPropriedade, true, true);

			if (pVlPropriedade != null) {
				vlParametro = Integer.valueOf(pVlPropriedade);
			}
		} catch (Exception e) {
		}

		if (vlParametro == null) {
			vlParametro = 0;
		}

		this.aVlTraceTransacaoAtivado = vlParametro;

		return vlParametro;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public Set<String> getTraceNmClassesUtilitarias() {
		// Devido a grande quantidade de acessos a este par�metro, � realizado cache est�tico (em vari�vel de classe espec�fica) no
		// lugar do cache din�mico (via "consultarDAOComCache").
		// ATEN��O: o m�todo "getDAOParametroDinamico" deve realizar a limpeza da vari�vel "aVlTraceNmClassesUtilitarias" a cada recarga
		// das propriedades.
		Set<String> vlParametro = this.aVlTraceNmClassesUtilitarias;

		if (vlParametro != null) {
			return vlParametro;
		}

		String nmPropriedade = "TraceNmClassesUtilitarias";
		boolean inAdicionarClassesPadrao = false;

		try {
			String vlPropriedade = this.getDAOParametroDinamico().getPropriedade(nmPropriedade, true, true);

			if (vlPropriedade != null) {
				String[] nmClasses = vlPropriedade.split("\\|");

				vlParametro = new HashSet<String>();

				for (String nmClasse : nmClasses) {
					if (nmClasse.equalsIgnoreCase("padrao")) {
						inAdicionarClassesPadrao = true;

						continue;
					}

					String inVisivelClassLoader = Constantes.CD_VERDADEIRO;

					try {
						// Se a classe existir, utiliza o objeto "String" do "Class.getName" para agilizar o "contains" do "HashSet".
						nmClasse = Class.forName(nmClasse).getName();
					} catch (ClassNotFoundException e) {
						inVisivelClassLoader = Constantes.CD_FALSO;
					}

					if (this.isTraceAtivado()) {
						String txLogParte01 = "Par�metro 'TraceNmClassesUtilitarias': adicionada classe '";
						String txLogParte02 = "'. Visibilidade no ClassLoader: '";
						String txLogParte03 = "''.";

						StringBuilder sbTxLog = new StringBuilder(txLogParte01.length() + nmClasse.length() +
								txLogParte02.length() + inVisivelClassLoader.length() + txLogParte03.length());
						sbTxLog.append(txLogParte01);
						sbTxLog.append(nmClasse);
						sbTxLog.append(txLogParte02);
						sbTxLog.append(inVisivelClassLoader);
						sbTxLog.append(txLogParte03);

						BibliotecaFuncoesPrincipal.registrarLogTrace(this.getClass().getName(), sbTxLog.toString());
					}

					vlParametro.add(nmClasse);
				}
			}
		} catch (Exception e) {
		}

		if ((vlParametro == null) || inAdicionarClassesPadrao) {
			if (inAdicionarClassesPadrao) {
				vlParametro.addAll(this.aNmClassesUtilitariasPadrao);
			} else {
				vlParametro = new HashSet<String>(this.aNmClassesUtilitariasPadrao);
			}
		}

		this.aVlTraceNmClassesUtilitarias = Collections.unmodifiableSet(vlParametro);

		return vlParametro;
	}

	/**
	 * -
	 *
	 * @param pCdUsuario
	 *
	 * @return
	 */
	public int getTamanhoArquivoLogTraceTransacaoPorUsuario(String pCdUsuario) {
		// N�o realiza cache para este par�metro porque ser� consultado para cada usu�rio. Isto acumularia uma quantidade muito grande
		// de propriedades no cache. Al�m disto, o padr�o � estar desabilitado em produ��o.
		final String nmPrefixoTraceUsuario = "TraceDAOBDCdUsuario_";

		StringBuilder sbNmTraceUsuario = new StringBuilder(nmPrefixoTraceUsuario.length() + pCdUsuario.length());
		sbNmTraceUsuario.append(nmPrefixoTraceUsuario);
		sbNmTraceUsuario.append(pCdUsuario);

		String nmTraceUsuario = sbNmTraceUsuario.toString();

		String strVlTraceUsuario = null;

		try {
			strVlTraceUsuario = this.getDAOParametroDinamico().getPropriedade(nmTraceUsuario, true, true);
		} catch (Exception e) {
		}

		if ((strVlTraceUsuario == null) && !pCdUsuario.equals(Constantes.CD_USUARIO_ANONIMO)) {
			try {
				strVlTraceUsuario = this.getDAOParametroDinamico().getPropriedade("TraceDAOBDCdUsuario_TODOS", false, true);
			} catch (Exception e) {
			}
		}

		int tamanhoArquivoTrace = 0;

		if (strVlTraceUsuario != null) {
			try {
				int vlPropriedadeTrace = Integer.parseInt(strVlTraceUsuario);

				if (vlPropriedadeTrace > Constantes.QT_MAX_MB_ARQUIVO_TRACE_TRANSACAO) {
					tamanhoArquivoTrace = Constantes.QT_MAX_MB_ARQUIVO_TRACE_TRANSACAO;
				}

				tamanhoArquivoTrace = vlPropriedadeTrace * 1048576;
			} catch (Exception e) {
				// Par�metro n�o cr�tico. Pode abafar.
			}
		}

		return tamanhoArquivoTrace;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public boolean isControleRequisicoesConcorrentesAtivado() {
		return this.consultarDAOParametroDinamico("ControleRequisicoesConcorrentesAtivado",
			new ConversorPropriedade<Boolean>() {
				public Boolean converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return true;
					}

					return converterBoolean(pVlPropriedade);
				}
			});
	}

	/**
	 * -
	 *
	 * @param pNmContextoWeb
	 *
	 * @return
	 */
	public boolean isDebugSCAAtivado(String pNmContextoWeb) {
		String nmPropriedade = this.getNmPropriedadePorContexto("DebugSCAAtivado", pNmContextoWeb);

		return this.consultarDAOParametroDinamico(nmPropriedade,
			new ConversorPropriedade<Boolean>() {
				public Boolean converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return false;
					}

					return converterBoolean(pVlPropriedade);
				}
			});
	}

	/**
	 * -
	 *
	 * @param pClasse
	 *
	 * @return
	 */
	public boolean isSCAAtivado(Class<?> pClasse) {
		String nmContextoWeb = null;

		try {
			ArrayList<String> nmClasseSplit = BibliotecaFuncoesPrincipal.split(pClasse.getName(), ".");

			if (nmClasseSplit.size() >= 7) {
				nmContextoWeb = "sfi_" + nmClasseSplit.get(5) + "_" + nmClasseSplit.get(6);
			}
		} catch (Exception e) {
		}

		if (nmContextoWeb == null) {
			return true;
		}

		return this.isSCAAtivado(nmContextoWeb);
	}

	/**
	 * -
	 *
	 * @param pNmContextoWeb
	 *
	 * @return
	 */
	public boolean isSCAAtivado(String pNmContextoWeb) {
		String nmPropriedade = this.getNmPropriedadePorContexto("SCAAtivado", pNmContextoWeb);

		return this.consultarDAOParametro(nmPropriedade,
			new ConversorPropriedade<Boolean>() {
				public Boolean converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return true;
					}

					return converterBoolean(pVlPropriedade);
				}
			});
	}

	/**
	 * -
	 *
	 * @param pNmContextoWeb
	 *
	 * @return
	 */
	public boolean isSCAJanelaAuxiliarAtivado(String pNmContextoWeb) {
		String nmPropriedade = this.getNmPropriedadePorContexto("SCAJanelaAuxiliarAtivado", pNmContextoWeb);

		return this.consultarDAOParametro(nmPropriedade,
			new ConversorPropriedade<Boolean>() {
				public Boolean converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return false;
					}

					return converterBoolean(pVlPropriedade);
				}
			});
	}

	/**
	 * -
	 *
	 * @param pNmContextoWeb
	 *
	 * @return
	 */
	public int getTpAjudaOnlineAtivado(String pNmContextoWeb) {
		String nmPropriedade = this.getNmPropriedadePorContexto("HelpAtivado", pNmContextoWeb);

		return this.consultarDAOParametro(nmPropriedade,
			new ConversorPropriedade<Integer>() {
				public Integer converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return 1;
					}

					return Integer.valueOf(pVlPropriedade);
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public boolean isAjudaCasoUsoAtivado() {
		return this.consultarDAOParametro("HelpCasoUsoAtivado",
			new ConversorPropriedade<Boolean>() {
				public Boolean converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return false;
					}

					return converterBoolean(pVlPropriedade);
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public boolean isEMailLiberado() {
		return this.consultarDAOParametro("EMailLiberado",
			new ConversorPropriedade<Boolean>() {
				public Boolean converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return false;
					}

					return converterBoolean(pVlPropriedade);
				}
			});
	}

	/**
	 * -
	 *
	 * @param pCdSistema
	 *
	 * @return
	 */
	public boolean isEMailLiberado(String pCdSistema) {
		String nmPropriedade = this.getNmPropriedadePorSistema("EMailLiberado", pCdSistema);

		return this.consultarDAOParametro(nmPropriedade,
			new ConversorPropriedade<Boolean>() {
				public Boolean converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return false;
					}

					return converterBoolean(pVlPropriedade);
				}
			});
	}

	/**
	 * -
	 *
	 * @param pCdSistema
	 *
	 * @return
	 */
	public boolean isCdUsuarioJobAtivado(String pCdSistema) {
		String nmPropriedade = this.getNmPropriedadePorSistema("CdUsuarioJobAtivado", pCdSistema);

		return this.consultarDAOParametro(nmPropriedade,
			new ConversorPropriedade<Boolean>() {
				public Boolean converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return true;
					}

					return converterBoolean(pVlPropriedade);
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public boolean isJ2EE14Ativado() {
		// A partir de 23/12/2010, esse p�r�metro ficou ficou definitivamente ativado.
		return true;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public boolean isSimulacaoTipoRedeAtivado() {
		return this.consultarDAOParametro("SimulacaoTipoRedeAtivado",
			new ConversorPropriedade<Boolean>() {
				public Boolean converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return false;
					}

					return converterBoolean(pVlPropriedade);
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	private Boolean isSfiArquivosExclusivoAtivado() {
		return this.consultarDAOParametro("SfiArquivosExclusivoAtivado",
			new ConversorPropriedade<Boolean>() {
				public Boolean converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return null;
					}

					return converterBoolean(pVlPropriedade);
				}
			});
	}

	/**
	 * -
	 *
	 * @param pCdSistema
	 *
	 * @return
	 */
	public boolean isSfiArquivosExclusivoAtivado(String pCdSistema) {
		Boolean inAtivado = isSfiArquivosExclusivoAtivado();

		if (inAtivado == null) {
			String nmPropriedade = this.getNmPropriedadePorSistema("SfiArquivosExclusivoAtivado", pCdSistema);

			return this.consultarDAOParametro(nmPropriedade,
				new ConversorPropriedade<Boolean>() {
					public Boolean converter(String pVlPropriedade)
						throws Exception {
						if (pVlPropriedade == null) {
							return false;
						}

						return converterBoolean(pVlPropriedade);
					}
				});
		}

		return inAtivado;
	}

	/**
	 * -
	 *
	 * @param pCdSistema
	 *
	 * @return
	 */
	public String getEMailDestinatario(String pCdSistema) {
		String nmPropriedade = this.getNmPropriedadePorSistema("EMailDestinatario", pCdSistema);

		return this.consultarDAOParametro(nmPropriedade,
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return "";
					}

					return pVlPropriedade;
				}
			});
	}

	/**
	 * Par�metro que retorna a URL base para referenciar o applet de assintura digital. Ex:
	 * [URLBaseApplet]/applet/AssinadorDigital_e-Fisco-signed.jar
	 *
	 * @return
	 */
	public String getURLBaseApplet() {
		return this.consultarDAOParametro("URLBaseApplet",
			new ConversorPropriedade<String>() {
				public String converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return "";
					}

					return pVlPropriedade;
				}
			});
	}

	/**
	 * -
	 *
	 * @return
	 */
	public int getQtSegsAtualizacaoPropriedades() {
		return this.consultarDAOParametro("QtSegsAtualizacaoPropriedades",
			new ConversorPropriedade<Integer>() {
				public Integer converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return Constantes.QT_SEGS_ATUALIZACAO_PROPRIEDADES;
					}

					return Integer.valueOf(pVlPropriedade);
				}
			});
	}
	
	/**
	 * -
	 *
	 * @return
	 */
	public int getQtMaxMBRequisicaoPost() {
		return this.consultarDAOParametro("QtMaxMBRequisicaoPost",
			new ConversorPropriedade<Integer>() {
				public Integer converter(String pVlPropriedade)
					throws Exception {
					if (pVlPropriedade == null) {
						return Constantes.QT_MAX_MB_REQUISICAO_POST;
					}

					return Integer.valueOf(pVlPropriedade);
				}
			});
	}

	//~ Classes Internas -----------------------------------------------------------------------------------------------------------

	/**
	 * 
	DOCUMENT ME!
	 *
	 * @param <T>
	 */
	private abstract static class ConversorPropriedade<T> {
		//~ Metodos ----------------------------------------------------------------------------------------------------------------

		/**
		 * -
		 *
		 * @param pVlPropriedade
		 *
		 * @return
		 *
		 * @throws Exception
		 * @throws ExcecaoParametroInvalido
		 */
		public static Boolean converterBoolean(String pVlPropriedade)
			throws Exception {
			if (pVlPropriedade.length() > 1) {
				pVlPropriedade = pVlPropriedade.trim();
			}

			if (pVlPropriedade.equals("1")) {
				return Boolean.TRUE;
			} else if (pVlPropriedade.equals("0")) {
				return Boolean.FALSE;
			} else {
				throw new ExcecaoParametroInvalido("Valor de par�metro boleano inv�lido: " + pVlPropriedade);
			}
		}

		/**
		 * -
		 *
		 * @param pVlPropriedade
		 *
		 * @return
		 *
		 * @throws Exception
		 */
		public abstract T converter(String pVlPropriedade)
			throws Exception;

		/**
		 * Deve ser sobreescrito para tratamento de valores mut�veis. O objetivo � realizar uma c�pia do objeto em
		 * cache para que altera��es no objeto retornado n�o afetem o cache.
		 *
		 * @param pVlParametro
		 *
		 * @return
		 */
		public T clonar(T pVlParametro) {
			return pVlParametro;
		}
	}
}
