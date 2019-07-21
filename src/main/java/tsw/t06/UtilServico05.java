/*
 * Este arquivo é propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informação nele contida pode ser
 * reproduzida, mostrada ou revelada sem permissão escrita da Sefaz-PE.
 */
package tsw.t06;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


/**
 * 
 */
public class UtilServico05 extends BibliotecaFuncoesPLO {
	
	public static String getChaveNuExercicioAcaoFonteRecursoCategoriaEconomicaGrupoDespesa(
		Short	pDtAnoExercicioShort, 
		String	pCdAcao, 
		String	pCdFonteRecur, 
		Short	pCdCategoriaEconomica, 
		Short	pCdGrupoDespesa)
	{
		String chaveNuExercicioAcaoFonteRecursoCategoriaEconomicaGrupoDespesa =
			pDtAnoExercicioShort.toString()		+ ConstantesPLOServico05.CD_CAMPO_SEPARADOR +
			pCdAcao								+ ConstantesPLOServico05.CD_CAMPO_SEPARADOR +
			pCdFonteRecur						+ ConstantesPLOServico05.CD_CAMPO_SEPARADOR +
			pCdCategoriaEconomica				+ ConstantesPLOServico05.CD_CAMPO_SEPARADOR +
			pCdGrupoDespesa						+ ConstantesPLOServico05.CD_CAMPO_SEPARADOR;
		
		return chaveNuExercicioAcaoFonteRecursoCategoriaEconomicaGrupoDespesa;
	}
	
	public static ArrayList<String> splitArrayListStrings(String pStringToSplit) {
		ArrayList<String> listaAcoesIncluidas = BibliotecaFuncoesPrincipal.split(pStringToSplit, ConstantesPLOServico05.CD_CAMPO_SEPARADOR);
		return listaAcoesIncluidas;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<String> splitArrayListStringsComRestricao(String pStringToSplit, int pQtCamposChavePrimaria) {
		ArrayList<String> parametros = 
			BibliotecaFuncoesPrincipal.splitComRestricao(pStringToSplit, ConstantesPLOServico05.CD_CAMPO_SEPARADOR, pQtCamposChavePrimaria);
		return parametros;
	}
	
	/**
	 * Método que levanta excecao caso algum parâmetro seja inválido
	 * 	
	 * @param pCdTipoFonteFinanciamento
	 * @param pDtAnoExercicio
	 * @param pDataContabil
	 * 
	 * @throws ExcecaoParametroInvalido
	 */
	public static void validarParametros(Short pCdTipoFonteFinanciamento, Short pDtAnoExercicio, Date pDataContabil) throws ExcecaoParametroInvalido {
		if ( pDtAnoExercicio == null ) {
			throw new ExcecaoParametroInvalido("pDtAnoExercicio");
		}
		
		if ( pDataContabil == null ) {
			throw new ExcecaoParametroInvalido("pDataContabil");
		}
		
		if ( pCdTipoFonteFinanciamento == null ) {
			throw new ExcecaoParametroInvalido("pCdTipoFonteFinanciamento");
		}
	}
	
	/**
	 * 
	 * @param pCdAcao
	 * @param pCdSubAcaoOrigem
	 * @param pTabelaValores
	 * @return
	 */
	public static int getQtLinhasParaRowSpanSubAcaoBigDecimal(String pCdAcao, String pCdSubAcaoOrigem, TreeMap<String, TreeMap<String, TreeMap<String, TreeMap<String, BigDecimal>>>> pTabelaValores) {
		int quantidadeRowSpanSubAcao = 0;
		int quantidadeFontesRecurso = 0;
		
		// Caso o Código da Ação venha com menos de 4 dígitos
		String cdAcao = BibliotecaFuncoesPrincipal.completarNumeroComZerosEsquerda(pCdAcao, 4);
		String cdSubAcaoOrigem = BibliotecaFuncoesPrincipal.completarNumeroComZerosEsquerda(pCdSubAcaoOrigem, 4);
		
		TreeMap<String, TreeMap<String, TreeMap<String, BigDecimal>>> valoresPorAcao = 
			getValoresBigDecimal(cdAcao, pTabelaValores);
		
		TreeMap<String, TreeMap<String, BigDecimal>> valoresPorSubAcao = 
			valoresPorAcao.get(cdSubAcaoOrigem);
		
		Iterator<String> itFontesRecursoOrigemParaRowSpan =
			valoresPorSubAcao.keySet().iterator();
		while ( itFontesRecursoOrigemParaRowSpan.hasNext() ) {
			String cdFonteRecursoOrigemParaRowSpan = 
				itFontesRecursoOrigemParaRowSpan.next();
				
			boolean isPrimeiraVezNestaFonteRecurso = true;
			Iterator<String> itNaturezasDespesaParaRowSpan = 
				valoresPorSubAcao.get(cdFonteRecursoOrigemParaRowSpan).keySet().iterator();
			while ( itNaturezasDespesaParaRowSpan.hasNext() ) {
				// A String com o Código da Natureza de Despesa não é lida, mas precisa ser obtida para incrementar o Iterator
				itNaturezasDespesaParaRowSpan.next();
				quantidadeRowSpanSubAcao = quantidadeRowSpanSubAcao + 1;
				
				if ( isPrimeiraVezNestaFonteRecurso ) {
					quantidadeFontesRecurso = quantidadeFontesRecurso + 1;
					isPrimeiraVezNestaFonteRecurso = false;
				}
			}
		}
		
		return quantidadeRowSpanSubAcao;
	}
	
	/**
	 * Adiciona ação (com seu nome)
	 *
	 * @param pCdAcao
	 * @param nmAcao
	 */
	public static void adicionarSubAcao(String pCdAcao, String pCdSubAcao, Collection<String> pListaAcoesIncluidas, TreeMap<String, List<String>> pTreeMapSubAcoesIncluidasPorAcao) {
		// Caso o Código da Ação venha com menos de 4 dígitos
		String cdAcao = BibliotecaFuncoesPrincipal.completarNumeroComZerosEsquerda(pCdAcao, 4);
		String cdSubAcao = BibliotecaFuncoesPrincipal.completarNumeroComZerosEsquerda(pCdSubAcao, 4);
		
		UtilServico05.adicionarAcao(cdAcao, pListaAcoesIncluidas);
		if ( pTreeMapSubAcoesIncluidasPorAcao != null ) {
			List<String> listaSubAcoesIncluidas = pTreeMapSubAcoesIncluidasPorAcao.get(cdAcao);
			if ( listaSubAcoesIncluidas == null) {
				listaSubAcoesIncluidas = new ArrayList<String>();
			}
			if ( !listaSubAcoesIncluidas.contains(cdSubAcao) ) {
				listaSubAcoesIncluidas.add(cdSubAcao);
			}
			
			pTreeMapSubAcoesIncluidasPorAcao.put(cdAcao, listaSubAcoesIncluidas);
		}
	}
	
	/**
	 * -
	 *
	 * @param pCdAcao  
	 *
	 * @return  
	 */
	public static TreeMap<String, TreeMap<String, TreeMap<String, BigDecimal>>> getValoresBigDecimal(String pCdAcao, TreeMap<String, TreeMap<String, TreeMap<String, TreeMap<String, BigDecimal>>>> pTabelaValores) {
		// Caso o Código da Ação venha com menos de 4 dígitos
		String cdAcao = BibliotecaFuncoesPrincipal.completarNumeroComZerosEsquerda(pCdAcao, 4);
		
		return pTabelaValores.get(cdAcao);
	}
	
	/**
	 * Adiciona ação (com seu nome)
	 *
	 * @param pCdAcao
	 * @param nmAcao
	 */
	public static boolean adicionarAcao(String pCdAcao, Collection<String> pListaAcoesIncluidas) {
		boolean isAcaoNova = false;
		
		// Caso o Código da Ação venha com menos de 4 dígitos
		String cdAcao = BibliotecaFuncoesPrincipal.completarNumeroComZerosEsquerda(pCdAcao, 4);
		if ( pListaAcoesIncluidas != null ) {
			if ( !pListaAcoesIncluidas.contains(cdAcao) ) {
				pListaAcoesIncluidas.add(cdAcao);
				isAcaoNova = true;
			}
		} else {
			isAcaoNova = true;
		}
		
		return isAcaoNova;
	}
	
	/**
	 * 
	 * @param pCdAcao
	 * @param pCdSubAcao
	 * @param pCdFonteRecurso
	 * @param pCdNaturezaDespesa
	 * @param pIdReq
	 * @return
	 */
	public static String getIDcampoValor(String pCdAcao, String pCdSubAcao, String pCdFonteRecurso, String pCdNaturezaDespesa, String pIdReq) {/*?|SM_70139_AndersonBorba_AjusteNovaFuncionalidadeManterSolicitacoesOrcamentariasCicloExtraordinario_v07_2483|anderson.borba|c7|?*/
		return 
			pIdReq						+ ConstantesPLOServico05.CD_CAMPO_SEPARADOR_AUX + 
			pCdAcao						+ ConstantesPLOServico05.CD_CAMPO_SEPARADOR_AUX + 
			pCdSubAcao					+ ConstantesPLOServico05.CD_CAMPO_SEPARADOR_AUX +
			pCdFonteRecurso				+ ConstantesPLOServico05.CD_CAMPO_SEPARADOR_AUX + 
			pCdNaturezaDespesa;
	}
	
	/**
	 * 
	 * @param pCdAcao
	 * @param pCdSubAcao
	 * @param pCdFonteRecurso
	 * @param pCdNaturezaDespesa
	 * @param pIdReq
	 * @return
	 */
	public static String getIDcampoValorDetalhamentoObjeto(String pCdAcao, String pCdSubAcao, String pCdFonteRecurso, String pCdNaturezaDespesa, String pIdReq) {
		return 
			pIdReq						+ ConstantesPLOServico05.CD_CAMPO_SEPARADOR_AUX + 
			pCdAcao						+ ConstantesPLOServico05.CD_CAMPO_SEPARADOR_AUX + 
			pCdSubAcao					+ ConstantesPLOServico05.CD_CAMPO_SEPARADOR_AUX +
			pCdFonteRecurso				+ ConstantesPLOServico05.CD_CAMPO_SEPARADOR_AUX + 
			pCdNaturezaDespesa;
	}
	
	/**
	 * Recupera o id do campo justificativa da célula
	 * 
	 * @param pCdAcao
	 * @param pCdSubAcao
	 * @param pCdFonteRecurso
	 * @param pCdNaturezaDespesa
	 * @param pIdReq
	 * @return
	 */
	public static String getIDcampoTxJustificativa(String pCdAcao, String pCdSubAcao, String pCdFonteRecurso, String pCdNaturezaDespesa, String pIdReq) {
		return 
			pIdReq						+ ConstantesPLOServico05.CD_CAMPO_SEPARADOR_AUX + 
			pCdAcao						+ ConstantesPLOServico05.CD_CAMPO_SEPARADOR_AUX + 
			pCdSubAcao					+ ConstantesPLOServico05.CD_CAMPO_SEPARADOR_AUX +
			pCdFonteRecurso				+ ConstantesPLOServico05.CD_CAMPO_SEPARADOR_AUX + 
			pCdNaturezaDespesa;
	}
	
	/**
	 * 
	 * @param pCdAcao
	 * @param pCdSubAcao
	 * @param pCdFonteRecurso
	 * @param pCdNaturezaDespesa
	 * @param pIdReq
	 * @return
	 */
	public static String getIDcampoTxJustificativaDetalhamentoObjeto(String pCdAcao, String pCdSubAcao, String pCdFonteRecurso, String pCdNaturezaDespesa, String pIdReq) {
		return getIDcampoTxJustificativa(pCdAcao, pCdSubAcao, pCdFonteRecurso, pCdNaturezaDespesa, pIdReq);
	}
	
	/**
	 * @param pSqObjetoDetalhamentoObjeto
	 * @param pCdClassObjetoDetalhamentoObjeto
	 */
	public static String getChaveDetalhamentoObjeto(Integer pSqObjetoDetalhamentoObjeto, String pCdClassObjetoDetalhamentoObjeto) {
		return pSqObjetoDetalhamentoObjeto + ConstantesPLOServico05.CD_CAMPO_SEPARADOR + pCdClassObjetoDetalhamentoObjeto;
	}
	
	public static ArrayList<Short> getColecaoCdSituacaoCicloExtraordinario(boolean pIsAnaliseSolicitacaoCicloExtraordinario){
		ArrayList<Short> cdSituacoesCicloExtraordinario = new ArrayList<Short>();
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_EM_ELABORACAO);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_REJEITADO_PELA_SEPLAG_GESTOR_CENTRAL_GOE);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_REJEITADO_PELA_SEPLAG_SEPO);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_REJEITADO_PELO_SECRETARIO_SEPLAG);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_APROVADO_TOTAL_SEPLAG_GESTOR_CENTRAL_GOE);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_APROVADO_RESTRICAO_GESTOR_CENTRAL);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_NAO_APROVADO_GESTOR_CENTRAL);
		
		if ( pIsAnaliseSolicitacaoCicloExtraordinario ){
			cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_REENCAMINHADA_GESTOR_CENTRAL);
			cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_APROVADO_PELA_SEPLAG_SEPOC);
			cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_ENCAMINHADO_PARA_ANALISE_SEPLAG_SEPOC);
			cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_ENCAMINHADO_PARA_ANALISE_SECRETARIO_SEPLAG);
			cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_ADIC_APROVADO_PELO_SECRETARIO_SEPLAG);
			cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_ENCAMINHADO_PARA_ANALISE_SEPLAG_GESTOR_CENTRAL_GOE);
		}
		
		// Removido devido a pseudo-situação Parecer Elaborado Análise Seplag Sepo
		//cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_REJEITADO_PELA_SEPLAG_SEPO);
		
		return cdSituacoesCicloExtraordinario;
	}
	
	public static ArrayList<Short> getColecaoCdSituacaoCicloOrdinario() {
		ArrayList<Short> cdSituacoesCicloExtraordinario = new ArrayList<Short>();
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_EM_ELABORACAO);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_ENCAMINHADO_PARA_UGC_CEDENTE);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_REJEITADO_PELA_UGC_CEDENTE);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_ENCAMINHADO_PARA_ANALISE_TITULAR_ORGAO_SOLICITANTE);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_APROVADO_TITULAR_ORGAO_SOLICITANTE);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_ENCAMINHADO_PARA_ANALISE_SEPLAG_GESTOR_CENTRAL_GOE);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_REJEITADO_PELA_SEPLAG_GESTOR_CENTRAL_GOE);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_ENCAMINHADO_PARA_PUBLICACAO);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_REJEITADO_PELO_TITULAR_ORGAO_SOLICITANTE);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_APROVADO_TOTAL_SEPLAG_GESTOR_CENTRAL_GOE);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_PUBLICADO);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_ENCAMINHADO_PARA_ANALISE_SECRETARIO_SOLICITANTE);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_APROVADO_PELO_SECRETARIO_SOLICITANTE);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_REJEITADO_PELO_SECRETARIO_SOLICITANTE);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_APROVADO_PELA_UGC_CEDENTE);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_ENCAMINHADO_PARA_ANALISE_TITULAR_ORGAO_CEDENTE);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_APROVADO_PELO_TITULAR_ORGAO_CEDENTE);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_REJEITADO_PELO_TITULAR_ORGAO_CEDENTE);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_ENCAMINHADO_PARA_ANALISE_SECRETARIO_CEDENTE);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_APROVADO_PELO_SECRETARIO_CEDENTE);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_REJEITADO_PELO_SECRETARIO_CEDENTE);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_ENCAMINHADO_PARA_ANALISE_SECRETARIO_SEPLAG);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_ADIC_APROVADO_PELO_SECRETARIO_SEPLAG);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_REJEITADO_PELO_SECRETARIO_SEPLAG);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_ENCAMINHADO_PARA_ANALISE_SEPLAG_SEPOC);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_APROVADO_PELA_SEPLAG_SEPOC);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_REJEITADO_PELA_SEPLAG_SEPO);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_ENCAMINHADO_PARA_ANALISE_CONTROLADORIA);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_APROVADO_PELA_CONTROLADORIA);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_REJEITADO_PELA_CONTROLADORIA);
		cdSituacoesCicloExtraordinario.add(ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_REJEITADA_NA_PUBLICACAO);
		
		return cdSituacoesCicloExtraordinario;
	}
	
	/**
	 * Retorna um objeto de um tipo que Map, composto pelo conjunto de Chaves e Valores passados .
	 * O mapa retornado será a instancia passada no primeiro parametro
	 *  
	 * @param <T>
	 * @param pInstanciaDoMapa
	 * @param pConteudoChave
	 * @param pConteudoValor
	 * 
	 * @return T extends Map
	 * @throws Exception 
	 */
	public static TreeMap<String, String> splitToTreeMap(String pConteudoChave, String pConteudoValor) throws Exception {
		TreeMap<String, String> mapaCodigoNome = new TreeMap<String, String>();
		
		List<String> listaChaves = UtilServico05.splitToListStrings(pConteudoChave);
		List<String> listaValores = UtilServico05.splitToListStrings(pConteudoValor);
		
		if ( !isColecaoValida(listaChaves) ) {
			throw new ExcecaoListaNulaVaziaOuElementosTodosNulos("listaChaves");
		}
		if ( !isColecaoValida(listaValores) ) {
			throw new ExcecaoListaNulaVaziaOuElementosTodosNulos("listaValores");
		}
		
		if ( listaChaves.size() != listaValores.size() ) {
			throw new Exception("listaChaves.size() = " + listaChaves.size() + " e " + "listaValores.size() = " + listaValores.size());
		}
		
		for ( int i = 0; i < listaChaves.size(); i++ ) {
			if ( isStringValida(listaChaves.get(i)) && !mapaCodigoNome.containsKey(listaChaves.get(i).trim()) ) {
				mapaCodigoNome.put(listaChaves.get(i).trim(), listaValores.get(i).trim());
			}
		}
		
		return mapaCodigoNome;
	}
	
	/**
	 * 
	 * @param valor
	 * @param pPrimeiroCaracter
	 * @param segundoCaracter
	 * @return
	 */
	public static String removerCaracteresInicioFim(String valor, String pPrimeiroCaracter, String segundoCaracter){
		return valor.replace(pPrimeiroCaracter, "").replace(segundoCaracter, "");
	}
	
	/**
	 * Este método irá remover os espaços do começo e fim de cada elemento da Lista passada como parâmetro
	 * 
	 * @param pLista
	 * @return
	 */
	public static List<String> removerEspacamento(List<String> pLista) {
		Set<String> conjuntoCdAcoes = new TreeSet<String>();
		Iterator<String> iterator =  pLista.iterator();
		while ( iterator.hasNext() ) {
			String cdCampo = iterator.next();
			cdCampo = cdCampo.trim();
			if ( UtilServico05.isStringValida(cdCampo) ) {
				conjuntoCdAcoes.add(cdCampo);
			}
		}
		
		pLista = new ArrayList<String>(conjuntoCdAcoes);
		
		return pLista;
	}
	
	public static boolean isVerdadeiroOuTrue(String pValor) {
		String valor = pValor.trim();
		boolean resposta = false;
		
		if ( valor.equals(ConstantesPLOServico05.CD_VERDADEIRO) || valor.equalsIgnoreCase(Boolean.TRUE.toString())) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static String getValorValidoNaoNulo(VOGenerico pVOGenerico, String pNomeColuna) throws ExcecaoParametroInvalido{
		String valor = "";
		
		if ( pVOGenerico != null && UtilServico05.isStringValida(pNomeColuna) && pVOGenerico.isAtributoValidoNaoNulo(pNomeColuna) ) {
			valor = (String) pVOGenerico.getAtributo(pNomeColuna);
		}
		
		return valor;
	}
	
	public static String concatenarNovaAcaoToAcoesIncluidas(String pCdAcao, String pAcoesIncluidas) {
		if ( pAcoesIncluidas == null || pAcoesIncluidas.equals("") ) {
			pAcoesIncluidas = pCdAcao;
		} else {
			if ( !pAcoesIncluidas.contains(pCdAcao) ) {
				pAcoesIncluidas = 
					pCdAcao + ConstantesPLOServico05.CD_CAMPO_SEPARADOR + 
					pAcoesIncluidas;
			}
		}
		return pAcoesIncluidas;
	}
	
	public static int setarDatasDeVigencias(
		int					pIndice, 
		PreparedStatement	pPreStmt,
		Short				pAnoExercicio)
	throws SQLException {
		String dtInicialFormatoDB2 = (pAnoExercicio != null ? BibliotecaFuncoesPLO.getPrimeiroDiaAnoFormatoDB2(pAnoExercicio) 	: BibliotecaFuncoesPLO.getPrimeiroDiaAnoFormatoDB2(BibliotecaFuncoesPLO.getAnoAtualString()));
		String dtFinalFormatoDB2   = (pAnoExercicio != null ? BibliotecaFuncoesPLO.getUltimoDiaAnoFormatoDB2(pAnoExercicio) 	: BibliotecaFuncoesPLO.getUltimoDiaAnoFormatoDB2(BibliotecaFuncoesPLO.getAnoAtualString()));
		
		//ORGAO_VIGENCIA
		pIndice++;
		pPreStmt.setObject(pIndice, dtInicialFormatoDB2);
		pIndice++;
		pPreStmt.setObject(pIndice,dtFinalFormatoDB2);
		
		//UNIDADE_ORCAMENTARIA
		pIndice++;
		pPreStmt.setObject(pIndice, dtInicialFormatoDB2);
		pIndice++;
		pPreStmt.setObject(pIndice, dtFinalFormatoDB2);
		
		return pIndice;
	}
	
	/**
	 * Verifica se uma situação é rejeitada
	 * @param cdSituacao
	 * @return
	 */
	public static boolean isSituacaoRejeitada(Short cdSituacao) {
		boolean retorno = false;
		
		if(cdSituacao != null) {
			Short[] situacoesRejeitadas = {
				ConstantesPLOServico05.CD_SITUACAO_SOLIC_REJEITADO_PELA_SEPLAG_GESTOR_CENTRAL_GOE,
				ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_REJEITADO_PELA_UGC_CEDENTE,
				ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_REJEITADO_PELO_TITULAR_ORGAO_SOLICITANTE,
				ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_REJEITADO_PELO_SECRETARIO_SOLICITANTE,
				ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_REJEITADO_PELO_TITULAR_ORGAO_CEDENTE,
				ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_REJEITADO_PELO_SECRETARIO_CEDENTE,
				ConstantesPLOServico05.CD_SITUACAO_SOLIC_REJEITADO_PELO_SECRETARIO_SEPLAG,
				ConstantesPLOServico05.CD_SITUACAO_SOLIC_REJEITADO_PELA_SEPLAG_SEPO,
				ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_REJEITADO_PELA_CONTROLADORIA,
				ConstantesPLOServico05.CD_SITUACAO_SOLIC_CRED_ADIC_REJEITADA_NA_PUBLICACAO	
			};
			
			for(Short cdSituacaoVerifica : situacoesRejeitadas) {
				if(cdSituacao.equals(cdSituacaoVerifica)) {
					retorno = true;
					break;
				}
			}
		}
		
		return retorno;
	}
	
	/**
	 * retorna a operacionalizacao do ciclo extraordinario
	 * 
	 * quem definira a operacionalizacao é a JSP
	 * o mapa de situacao + o valor aprovado 
	 * 
	 * @param pDsOperacionalizacao
	 * @param pValorAprovado
	 * @param pSituacao
	 * @return
	 * @throws Exception
	 */
	public static String retornaOperacionalizacaoCE(
		String		pDsOperacionalizacao,
		String		pValorAprovado,
		String		pSituacao)
	throws Exception{
		
		String retorno = pDsOperacionalizacao;
		String valZero = "0,00";
		
		if (
			pSituacao.toLowerCase().contains("rejeitado")
		) {
			retorno = ConstantesPLOServico05.DS_SITUACAO_SOLIC_OPERACIONALIZACAO_NAO_SE_APLICA;
		} else {
			if (
				pSituacao.toLowerCase().contains("não aprovado")	&&
				pValorAprovado.equals(valZero)
			) {
				retorno = ConstantesPLOServico05.DS_SITUACAO_SOLIC_OPERACIONALIZACAO_NAO_SE_APLICA;
			} else {
				if (
					pValorAprovado.equals(ConstantesPLOServico05.NAO_EXIBIR_VALOR)													&&
					pSituacao.equalsIgnoreCase(ConstantesPLOServico05.DS_SITUACAO_SOLIC_CICLO_EXTRAORDINARIO_PARECER_ELABORADO)
				) {
					retorno = ConstantesPLOServico05.DS_SITUACAO_SOLIC_OPERACIONALIZACAO_MODALIDADE_DE_APLICACAO_PENDENTE;
				}
			}
		}
		
		return retorno;
	}
	
	/**
	 * 
	 * @param pDsOperacionalizacao
	 * @param pVOAtual
	 * @param pCdSituacaoSolicitacao
	 * @param pSituacao
	 * @return
	 * @throws Exception
	 */
	public static String retornaOperacionalizacaoAnaliseCE(
		String		pDsOperacionalizacao,
		String		pValorAprovado,
		String		pSituacao) 
	throws Exception {
		String valorZero = "0,00";
		String retornoDsOperacionalizacao = pDsOperacionalizacao;
		
		if (
			pSituacao.toLowerCase().contains("rejeitado")																				||
			pSituacao.toLowerCase().contains("não aprovada")																			||
			pSituacao.equals(ConstantesPLOServico05.DS_SITUACAO_SOLICITACAO_CICLO_EXTRAORDINARIO_NAO_APROVADO_GESTOR_CENTRAL_ANALISE)	||
			(pSituacao.equals(ConstantesPLOServico05.DS_SITUACAO_SOLIC_CICLO_EXTRAORDINARIO_PARECER_APROVADO_SEPLAG_SEPO_ANALISE)	&& pValorAprovado.equals(valorZero))	||
			(pSituacao.equals(ConstantesPLOServico05.DS_SITUACAO_SOLIC_CICLO_EXTRAORDINARIO_PARECER_APROVADO_SECRETARIO_SEPLAG)		&& pValorAprovado.equals(valorZero))	
		) {
			retornoDsOperacionalizacao = ConstantesPLOServico05.DS_SITUACAO_SOLIC_OPERACIONALIZACAO_NAO_SE_APLICA;
		}
		
		return retornoDsOperacionalizacao;
	}
	
	/**
	 * Conforme acordado com Jayro Neto (05/10/2016) da contabilidade
	 * O Número do Documento de Referência deve ser igual ao Número do Bloqueio de Dotação gerado (Sequencial)
	 *  
	 * @param pVOBloqueioDotacao
	 * 
	 * @return	Número do Documento de Referência
	 */
	public static String getNumeroDocumentoReferencia(VOBloqueioDotacao pVOBloqueioDotacao) {
		String numeroDocumentoReferencia = "";
		if (
			pVOBloqueioDotacao != null 							&&
			pVOBloqueioDotacao.getNuBloqueioDotacao() != null
		) {
			numeroDocumentoReferencia = pVOBloqueioDotacao.getNuBloqueioDotacao().toString();
		}
		return numeroDocumentoReferencia;
	}
	
}