/*
 * Este arquivo é propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informação nele contida pode ser
 * reproduzida, mostrada ou revelada sem permissão escrita da Sefaz-PE.
 */
package tsw.t06;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 */
public class BibliotecaFuncoesPLO extends ConstantesPLO {
	
	public static String formatarDataParaDB2(String pDataString) {
		String resultado = "";
		if ( isStringValida(pDataString) ) {
			resultado = pDataString.substring(6, 10) + "-" + pDataString.substring(3, 5) + "-" + pDataString.substring(0, 2);
		}
		
		return resultado;
	}
	
	public static String formatarDataParaDB2(Date pData) {
		String resultado = "";
		if ( pData != null ) {
			String dataString = BibliotecaFuncoesDataHora.getDataComoString(pData);
			resultado = dataString.substring(6, 10) + "-" + dataString.substring(3, 5) + "-" + dataString.substring(0, 2);
		}
		
		return resultado;
	}
	
	public static String getPrimeiroDia(String pMes, String pAno) {
		String resultado = "";
		if ( isStringValida(pMes) && isStringValida(pAno)) {
			resultado = "01/" + pMes + "/" + pAno;
		}
		return resultado;
	}
	
	public static String getPrimeiroDiaAnoFormatoDB2(Short pAnoExercicio) {
		String resultado = "";
		if ( pAnoExercicio != null ) {
			resultado = getPrimeiroDiaAnoFormatoDB2(pAnoExercicio.toString());
		}
		return resultado;
	}
	
	public static String getPrimeiroDiaAnoFormatoDB2(String pAnoExercicio) {
		String resultado = "";
		if ( isStringValida(pAnoExercicio) ) {
			resultado = pAnoExercicio + "-01-01";
		}
		return resultado;
	}
	
	public static String getUltimoDiaAnoFormatoDB2(Short pAnoExercicio) {
		String resultado = "";
		
		if ( pAnoExercicio != null ) {
			resultado = getUltimoDiaAnoFormatoDB2(pAnoExercicio.toString());
		}
		
		return resultado;
	}
	
	public static String getUltimoDiaAnoFormatoDB2(String pAnoExercicio) {
		String resultado = "";
		
		if ( isStringValida(pAnoExercicio) ) {
			resultado = pAnoExercicio + "-12-31";
		}
		
		return resultado;
	}
	
	public static String getPrimeiroDiaFormatoDB2(String pAnoExercicio, String pMes) {
		String resultado = "";
		if ( isStringValida(pAnoExercicio) && isStringValida(pMes)) {
			resultado = pAnoExercicio + "-" + pMes + "-01";
		}
		return resultado;
	}
	
	public static List<String> splitToListStrings( String pToSplit ) {
		List<String> resultado = null;
		if ( isStringValida(pToSplit) ) {
			resultado = BibliotecaFuncoesPrincipal.split(pToSplit, ConstantesPLOServico05.CD_CAMPO_SEPARADOR);
		}
		return resultado;
	}
	
	public static List<String> splitToListStrings( String pToSplit, String pCampoSeparador ) {
		List<String> resultado = null;
		if ( isStringValida(pToSplit) ) {
			resultado = BibliotecaFuncoesPrincipal.split(pToSplit, pCampoSeparador);
		}
		return resultado;
	}
	
	/**
	 * @param pKeysBase
	 * @param vectorChaves
	 * @return
	 */
	public static Enumeration<String> enumerationFromIterator(Iterator<String> pKeysBase) {
		Enumeration<String> keysBaseEnum = null;
		
		if ( pKeysBase != null ) {
			Vector<String> vectorChaves = new Vector<String>();
			while (pKeysBase.hasNext()) {
				String keyBase = pKeysBase.next();
				vectorChaves.add(keyBase);
			}
			keysBaseEnum = vectorChaves.elements();
		}
		
		return keysBaseEnum;
	}
	
	public static boolean isStringValida(String pVariavel) {
		return pVariavel != null && pVariavel.trim().length() > 0 ;
	}
	public static boolean isStringValida(Object pVariavel) {
		return pVariavel != null && pVariavel.toString().trim().length() > 0 ;
	}
	
	public static String getStringValida(String pString) {
		String cdAcaoString = "";
		if ( pString != null ) {
			cdAcaoString = pString.toString();
		}
		return cdAcaoString;
	}
	
	public static String getStringValida(Integer pInteger) {
		String cdSubAcaoString = "";
		if ( pInteger != null ) {
			cdSubAcaoString = pInteger.toString();
		}
		return cdSubAcaoString;
	}
	
	public static String colecaoToStringComCampoSeparador( Collection<?> pColecao ){
		String resposta = "";
		
		if ( pColecao != null && !pColecao.isEmpty() ) {
			String campoSeparador = "";
			Object[] objetosColecao = pColecao.toArray();
			for ( int i = 0; i < objetosColecao.length; i = i + 1 ) {
				if ( objetosColecao[i] != null ) {
					resposta = resposta + campoSeparador + objetosColecao[i].toString();
					campoSeparador = ConstantesPLO.CD_CAMPO_SEPARADOR;
				}
			}
		}
		
		return resposta;
	}
	
	public static String colecaoToStringComVirgulas(Collection<?> pColecao) {
		String resposta = "[";
		
		if ( isColecaoValida(pColecao) ) {
			String campoSeparador = "";
			Iterator<?> iterator = pColecao.iterator();
			while ( iterator.hasNext() ) {
				resposta = resposta + campoSeparador + iterator.next().toString();
				campoSeparador = ConstantesPLO.VIRGULA;
			}
		}
		
		resposta = resposta + "]";
		return resposta;
	}
	
	public static Short getAnoAtualShort() {
		String anoAtualString = getAnoAtualString();
		Short anoAtualShort = Short.valueOf(anoAtualString);
		return anoAtualShort;
	}

	public static String getAnoAtualString() {
		String anoAtualString = BibliotecaFuncoesDataHora.getAnoComoString(BibliotecaFuncoesDataHora.getDataHoje());
		return anoAtualString;
	}
	
	public static String getCdAcao(String pCdProgramaTrabalho) throws ExcecaoParametroInvalido {
		validarCdProgramaTrabalho(pCdProgramaTrabalho);
		
		return pCdProgramaTrabalho.substring(9, 13);
	}
	public static String getCdSubAcao(String pCdProgramaTrabalho) {
		String resposta = "";
		if ( isCdProgramaTrabalhoValido(pCdProgramaTrabalho)) {
			resposta = pCdProgramaTrabalho.substring(13, 17);
		}
		return resposta;
	}

	public static void validarCdProgramaTrabalho(String pCdProgramaTrabalho) throws ExcecaoParametroInvalido {
		if ( pCdProgramaTrabalho == null || pCdProgramaTrabalho.length() != 17 ) {
			throw new ExcecaoParametroInvalido("O Código do Programa de Trabalho não é válido");
		}
	}
	
	public static boolean isCdProgramaTrabalhoValido(String pCdProgramaTrabalho) {
		boolean resposta = false;
		if ( pCdProgramaTrabalho != null && pCdProgramaTrabalho.length() == 17 ) {
			resposta = true;
		}
		return resposta;
	}
	
	public static StringBuffer getImportsBibliotecasJavascriptAjaxDWR() {
		StringBuffer importBibliotecasJavascriptAjaxDWR = new StringBuffer();
		
		importBibliotecasJavascriptAjaxDWR = importBibliotecasJavascriptAjaxDWR.append("<SCRIPT language='JavaScript' type='text/javascript' src='/" + ConstantesPLOServico05.NM_CONTEXTO_WEB_ORC_PLO + "/dwr/engine.js'></script>").append(ConstantesPLO.NEW_LINE);
		importBibliotecasJavascriptAjaxDWR = importBibliotecasJavascriptAjaxDWR.append("<SCRIPT language='JavaScript' type='text/javascript' src='/" + ConstantesPLOServico05.NM_CONTEXTO_WEB_ORC_PLO + "/dwr/util.js'></script>").append(ConstantesPLO.NEW_LINE);
		importBibliotecasJavascriptAjaxDWR = importBibliotecasJavascriptAjaxDWR.append("<SCRIPT language='JavaScript' type='text/javascript' src='" + Parametros.getInstancia().getURLBaseJavaScript() + "/biblioteca_funcoes_ajax_dwr.js'></SCRIPT>").append(ConstantesPLO.NEW_LINE);
		importBibliotecasJavascriptAjaxDWR = importBibliotecasJavascriptAjaxDWR.append("<SCRIPT language='JavaScript' type='text/javascript' src='/" + ConstantesPLOServico05.NM_CONTEXTO_WEB_ORC_PLO + "/dwr/interface/processadorAjaxDwrPLO.js'></script>").append(ConstantesPLO.NEW_LINE);
		importBibliotecasJavascriptAjaxDWR = importBibliotecasJavascriptAjaxDWR.append("<SCRIPT language='JavaScript' type='text/javascript' src='/" + ConstantesPLOServico05.NM_CONTEXTO_WEB_ORC_PLO + "/js/biblioteca_funcoes_ajax_dwr.js'></script>").append(ConstantesPLO.NEW_LINE);
		
		return importBibliotecasJavascriptAjaxDWR;
	}
	
	/**
	 * método responsável de criar script para impedir a funcionalidade do botao f5
	 * 
	 * @param mensagem
	 * @return
	 */
	public static String getScriptImpedirRessubmissao() {
		StringBuilder script = new StringBuilder("\n\n");
		script.append(TAG_SCRIPT_ABERTURA);
		script.append(" window.onkeydown = function (e) {");
		script.append("		if (e.keyCode === 116) {");
		script.append("			alert(\"Função não permitida\");");
		script.append("			e.keyCode = 0;");
		script.append("			e.returnValue = false;");
		script.append("			return false;");
		script.append("	} } ");
		script.append(TAG_SCRIPT_FECHAMENTO);
		return script.toString();
	}
	
	public static void removerStringsVazias( Collection<String> pListaSqsSolicitacoesCreditoAdicional ) {
		Iterator<String> iteratorSqsSolicitacoesCA = pListaSqsSolicitacoesCreditoAdicional.iterator();
		while ( iteratorSqsSolicitacoesCA.hasNext() ) {
			String sqSolicitacaoCreditoAdicional = iteratorSqsSolicitacoesCA.next();
			if ( !BibliotecaFuncoesPLO.isStringValida(sqSolicitacaoCreditoAdicional) ) {
				iteratorSqsSolicitacoesCA.remove();
			}
		}
	}
	
	public static void removerCaracteresBrancos(String[] pArray) {
		if ( isArrayValido(pArray) ) {
			for ( int i = 0; i < pArray.length; i++ ) {
				pArray[i] = pArray[i].replace(" ",""); 	
			}
		}
	}
	
	/**
	 * Verifica se a Coleção passada como parâmetro é válida
	 * 
	 * @param pColecao
	 * 
	 * @return	boolean		Indica se a Coleção passada como parâmetro é válida
	 */
	public static boolean isColecaoValida(Collection pColecao) {
		return pColecao != null && !pColecao.isEmpty();
	}
	
	/**
	 * verifica se a Coleção passada é válida e se a index passada está contida 
	 * na Coleção
	 * 
	 * @param pColecao
	 * @param pIndice
	 * @return boolean
	 */
	public static boolean isColecaoValida(Collection pColecao, int pIndice) {
		return 
			isColecaoValida(pColecao)		&& 
			pColecao.size() > pIndice;
	}
	
	/**
	 * Verifica se o Array passado como parâmetro é válido
	 * 
	 * @param pArray
	 * @return
	 */
	public static boolean isArrayValido(Object[] pArray) {
		return pArray != null && pArray.length > 0;
	}
	
	/**
	 * Verifica se o Array passado como parâmetro é válido, e se o tamanho do Array é compatível com o índice passado.
	 * 
	 * @param pArray
	 * @return
	 */
	public static boolean isArrayValido(Object[] pArray, int pIndice) {
		return isArrayValido(pArray) && pIndice < pArray.length;
	}
	
	/**
	 * Verifica se o Map passado como parâmetro é válido
	 * 
	 * @param pColecao
	 * 
	 * @return	boolean		Indica se o Map passada como parâmetro é válido
	 */
	public static boolean isMapValido(Map pMap) {
		return pMap != null && !pMap.isEmpty();
	}
	
	/**
	 * @param pHashMap
	 * @return
	 */
	public static boolean isHashMapValido(HashMap pHashMap) {
		return pHashMap != null && !pHashMap.isEmpty();
	}
	
	/**
	 * @param pHashtable
	 * @return
	 */
	public static boolean isHashtableValido(Hashtable pHashtable) {
		return pHashtable != null && !pHashtable.isEmpty();
	}
	
	/**
	 * 
	 * @param pConjunto
	 * @return
	 */
	public static boolean isSetValido(Set pConjunto) {
		return pConjunto != null && !pConjunto.isEmpty();
	}
	
	/**
	 * Verifica se a Lista passada como parâmetro é não-nula, não-vazia e se contém elementos não nulos
	 * 
	 * @param 	List		pLista
	 * 
	 * @return	boolean		Indica se a Lista passada como parâmetro é não-nula, não-vazia e se contém elementos não nulos
	 */
	public static boolean isListaElementosNaoNulos( List pLista ) {
		boolean resposta = isColecaoValida(pLista);
		
		if ( resposta ) {
			boolean hasElementoNaoNulo = false;
			for ( Object objeto: pLista ) {
				if ( objeto != null ) {
					hasElementoNaoNulo = true;
					
					break;
				}
			}
			resposta = hasElementoNaoNulo;
		}
		
		return resposta;
	}
	
	/**
	 * Valida se a Lista passada como parâmetro é não-nula, não-vazia e se contém elementos não nulos
	 * 
	 * @param 	List		pLista
	 * 
	 * @throws ExcecaoListaNulaVaziaOuElementosTodosNulos
	 */
	public static void validarListaElementosNaoNulos(List pLista) throws ExcecaoListaNulaVaziaOuElementosTodosNulos {
		if ( !isListaElementosNaoNulos(pLista) ) {
			String name = "";
			if (pLista != null) {
				name = pLista.getClass().getName();
			}
			throw new ExcecaoListaNulaVaziaOuElementosTodosNulos(name);
		}
	}
	
	/**
	 * Verifica se as Listas passadas como parâmetro são do mesmo tamanho
	 * 
	 * @param pFirstList
	 * @param pSecondList
	 * 
	 * @return	boolean
	 * 
	 * @throws ExcecaoListaNulaVaziaOuElementosTodosNulos 
	 */
	public static boolean isListasMesmoTamanho(List pFirstList, List pSecondList) throws ExcecaoListaNulaVaziaOuElementosTodosNulos {
		boolean resposta = false;
		
		validarListaElementosNaoNulos(pFirstList);
		validarListaElementosNaoNulos(pSecondList);
		
		if (  pFirstList.size() == pSecondList.size() ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	/**
	 * Valida se as Listas passadas como parâmetro são do mesmo tamanho
	 * 
	 * @param pFirstList
	 * @param pSecondList
	 * 
	 * @throws ExcecaoListaNulaVaziaOuElementosTodosNulos
	 * @throws ExcecaoListasComTamanhosDiferentes
	 */
	public static void validarListasMesmoTamanho(List pFirstList, List pSecondList) throws ExcecaoListaNulaVaziaOuElementosTodosNulos, ExcecaoListasComTamanhosDiferentes {
		validarListaElementosNaoNulos(pFirstList);
		validarListaElementosNaoNulos(pSecondList);
		
		if ( pFirstList.size() != pSecondList.size() ) {
			throw new ExcecaoListasComTamanhosDiferentes(pFirstList, pSecondList);
		}
	}
	
	public static boolean isMenorQueZero(BigDecimal pVlReferencia) {
		boolean resposta = false;
		
		if ( pVlReferencia != null && pVlReferencia.compareTo(BigDecimal.ZERO) < 0 ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isMenorIgualZero(BigDecimal pVlReferencia) {
		boolean resposta = false;
		
		if ( pVlReferencia != null && pVlReferencia.compareTo(BigDecimal.ZERO) <= 0 ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isMenor(BigDecimal pVlReferencia, BigDecimal pVlComparado) {
		boolean resposta = false;
		
		if ( pVlReferencia != null && pVlComparado != null && pVlReferencia.compareTo(pVlComparado) < 0 ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isIgualAZero(Short pVlReferencia) {
		boolean resposta = false;
		
		if ( pVlReferencia != null && pVlReferencia.compareTo(ConstantesPLO.ZERO_SHORT) == 0 ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isIgualAZero(Integer pVlReferencia) {
		boolean resposta = false;
		
		if ( pVlReferencia != null && pVlReferencia.compareTo(ConstantesPLO.ZERO_INTEGER) == 0 ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isIgualAZero(BigDecimal pVlReferencia) {
		boolean resposta = false;
		
		if ( pVlReferencia != null && pVlReferencia.compareTo(BigDecimal.ZERO) == 0 ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isDiferenteDeZero(BigDecimal pVlReferencia) {
		boolean resposta = false;
		
		if ( pVlReferencia != null && pVlReferencia.compareTo(BigDecimal.ZERO) != 0 ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isIgual(BigDecimal pVlReferencia, BigDecimal pVlComparado) {
		boolean resposta = false;
		
		if ( pVlReferencia != null && pVlComparado != null && pVlReferencia.compareTo(pVlComparado) == 0 ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isIgual(Short pVlReferencia, Short pVlComparado) {
		boolean resposta = false;
		
		if ( pVlReferencia != null && pVlComparado != null && pVlReferencia.compareTo(pVlComparado) == 0 ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isMaiorQueZero(BigDecimal pVlReferencia) {
		boolean resposta = false;
		
		if ( pVlReferencia != null && pVlReferencia.compareTo(BigDecimal.ZERO) > 0 ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isMaiorOuIgualZero(BigDecimal pVlReferencia) {
		boolean resposta = false;
		
		if ( pVlReferencia != null && pVlReferencia.compareTo(BigDecimal.ZERO) >= 0 ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isMaiorIgualZero(BigDecimal pVlReferencia) {
		boolean resposta = false;
		
		if ( pVlReferencia != null && pVlReferencia.compareTo(BigDecimal.ZERO) >= 0 ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isMaior(BigDecimal pVlReferencia, BigDecimal pVlComparado) {
		boolean resposta = false;
		
		if ( pVlReferencia != null && pVlComparado != null && pVlReferencia.compareTo(pVlComparado) > 0 ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isBigDecimalValido(BigDecimal pValor) {
		return 
			pValor != null			&&
			isIgualAZero(pValor)
		;
	}
	
	public static BigDecimal somar(BigDecimal pValor1, BigDecimal pValor2) {
		BigDecimal resultado = BigDecimal.ZERO;
		if ( isMaiorQueZero(pValor1) ) {
			resultado = pValor1;
		}
		if ( pValor1 != null && isMaiorQueZero(pValor2) ) {
			resultado = pValor1.add(pValor2);
		}
		return resultado;
	}
	
	public static String getStatementVigenciaGenerico(
		String pDtInicioVigencia, 
		String pDtFimVigencia,
		String pNmEntidade, 
		String pNmAtributoInicioVigencia,
		String pNmAtributoFimVigencia
	) {
		String statementVigenciaProgramaTrabalhoGPO = 
			pNmEntidade + "." + pNmAtributoInicioVigencia + " <= " + ASPA_SIMPLES + pDtInicioVigencia + ASPA_SIMPLES + AND + NEW_LINE + TAB +
			"(" + pNmEntidade + "." + pNmAtributoFimVigencia + IS_NULL + OR + NEW_LINE + TAB + TAB +
				  pNmEntidade + "." + pNmAtributoFimVigencia + " >= " + ASPA_SIMPLES + pDtFimVigencia + ASPA_SIMPLES + NEW_LINE + TAB +
			")";
		return statementVigenciaProgramaTrabalhoGPO;
	}
	
	public static String getFuncaoJavascriptAbrirJanelaAuxiliarExecucaoOrcamentariaOuConsultarSaldosRetroativos (
		String pNmFuncaoJavascript,
		String pIdReqCampoDataContabil, 
		String pIdReqCampoDataContabilParaSaldoRetroativo, 
		String pIdReqCampoTipoDocumento,
		String pValorTipoDocumento,
		String pIdReqCampoIndicadorOpcaoFiltroTipoFonteRecurso,
		String pIdReqCampoIndicadorCheckbox,
		String pIdReqCampoIndicadorNaoUtilizarIdContextoSessao,
		String pIdReqCampoNaoUtilizarIdContextoSessao,
		String pIdReqCampoContextoSessao)
	throws ExcecaoGenerica {
		StringBuffer funcaoJavascript = new StringBuffer(NEW_LINE);
		
		funcaoJavascript = funcaoJavascript.append("function ").append(pNmFuncaoJavascript).append("() {").append(NEW_LINE);
		
		funcaoJavascript = funcaoJavascript.append(TAB).append("//Validar se a data é retroativa").append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append("if ( isDataMaior(").append(getDocumentFrmPrincipalPontoIdReqCampo(pIdReqCampoDataContabil)).append(".value, getDataHoje(), true) ) {").append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append("// RETROATIVO").append(NEW_LINE).append(NEW_LINE);
		
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append("// Tipo do documento Contábil").append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append(getDocumentFrmPrincipalPontoIdReqCampo(pIdReqCampoTipoDocumento)).append(".value = '").append(pValorTipoDocumento).append("';").append(NEW_LINE).append(NEW_LINE);
		
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append("// Data Contábil (Referência)").append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append(getDocumentFrmPrincipalPontoIdReqCampo(pIdReqCampoDataContabilParaSaldoRetroativo)).append(".value = ").append(getDocumentFrmPrincipalPontoIdReqCampo(pIdReqCampoDataContabil)).append(".value;").append(NEW_LINE).append(NEW_LINE);
		
		funcaoJavascript = funcaoJavascript.append(TAB).append("if ( ").append(getDocumentFrmPrincipalPontoIdReqCampo(pIdReqCampoIndicadorOpcaoFiltroTipoFonteRecurso)).append(" != undefined ) {").append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append("// Contém códigos dos tipos de fonte de recurso que deve ser feito o filtro na consutla de execução orçamentária").append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append(getDocumentFrmPrincipalPontoIdReqCampo(pIdReqCampoIndicadorOpcaoFiltroTipoFonteRecurso)).append(".value = '").append(ConstantesPLO.STRING_SQL_TIPOS_FONTE_RECURSO_NAO_DETALHAVEL_CASO_PROVISAO).append("';").append(NEW_LINE).append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append("}").append(NEW_LINE);
		
		
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append("//Faz com que a PRConsultarSaldosRetroativos do PLO só consulte Execuções Orçamentárias que não sejam provenientes de Destaque de Crédito").append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append("linkConsultarSaldosRetroativos = linkConsultarSaldosRetroativos + '?' + 'InExecucaoOrcamentaria=N';").append(NEW_LINE).append(NEW_LINE);
		
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append("submeterFormularioJanelaAuxiliar(linkConsultarSaldosRetroativos,'").append(ConstantesPLO.EVENTO_EXIBIR_FILTRO_CONSULTA).append("', false);").append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append("} else {").append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append("//NÃO-RETROATIVO").append(NEW_LINE).append(NEW_LINE);
		
		funcaoJavascript = funcaoJavascript.append(TAB).append("if ( ").append(getDocumentFrmPrincipalPontoIdReqCampo(pIdReqCampoIndicadorCheckbox)).append(" != undefined ) {").append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append("//Indicador que vai utilizar checkbox na tela de Cadastro de Execução Orçamentária, se o mesmo não for passado exibe radioButton").append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append(getDocumentFrmPrincipalPontoIdReqCampo(pIdReqCampoIndicadorCheckbox)).append(".value = '").append(ConstantesPLO.CD_VERDADEIRO).append("';").append(NEW_LINE).append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append("}").append(NEW_LINE);
		
		funcaoJavascript = funcaoJavascript.append(TAB).append("if ( ").append(getDocumentFrmPrincipalPontoIdReqCampo(pIdReqCampoIndicadorNaoUtilizarIdContextoSessao)).append(" != undefined ) {").append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append("// Indicador para exibir UGs (que será utilizado no componente de UG) sem verificar o contexto do usuário").append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append(getDocumentFrmPrincipalPontoIdReqCampo(pIdReqCampoIndicadorNaoUtilizarIdContextoSessao)).append(".value = '").append(ConstantesPLO.CD_VERDADEIRO).append("';").append(NEW_LINE).append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append("}").append(NEW_LINE);
		
		funcaoJavascript = funcaoJavascript.append(TAB).append("if ( ").append(getDocumentFrmPrincipalPontoIdReqCampo(pIdReqCampoNaoUtilizarIdContextoSessao)).append(" != undefined ) {").append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append("// Contém códigos dos tipos de fonte de recurso que deve ser feito o filtro na consulta de execução orçamentária").append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append(getDocumentFrmPrincipalPontoIdReqCampo(pIdReqCampoNaoUtilizarIdContextoSessao)).append(".value = '").append(ConstantesPLO.CD_VERDADEIRO).append("';").append(NEW_LINE).append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append("}").append(NEW_LINE);
		
		funcaoJavascript = funcaoJavascript.append(TAB).append("if ( ").append(getDocumentFrmPrincipalPontoIdReqCampo(pIdReqCampoIndicadorOpcaoFiltroTipoFonteRecurso)).append(" != undefined ) {").append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append("// Contém códigos dos tipos de fonte de recurso que deve ser feito o filtro na consutla de execução orçamentária").append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append(getDocumentFrmPrincipalPontoIdReqCampo(pIdReqCampoIndicadorOpcaoFiltroTipoFonteRecurso)).append(".value = '").append(ConstantesPLO.STRING_SQL_TIPOS_FONTE_RECURSO_NAO_DETALHAVEL_CASO_PROVISAO).append("';").append(NEW_LINE).append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append("}").append(NEW_LINE);
		
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append("// guardando o id do contexto de sessao atual em uma variavel temporaria").append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append("var idContextoSessaoAtual = ").append(getDocumentFrmPrincipalPontoIdReqCampo(pIdReqCampoContextoSessao)).append(".value;").append(NEW_LINE).append(NEW_LINE);
		
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append("// limpando o contexto sessao atual").append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append(getDocumentFrmPrincipalPontoIdReqCampo(pIdReqCampoContextoSessao)).append(".value = '';").append(NEW_LINE).append(NEW_LINE);
		
		
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append("// restaurando o id de contexto da sessao").append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append(TAB).append(getDocumentFrmPrincipalPontoIdReqCampo(pIdReqCampoContextoSessao)).append(".value = idContextoSessaoAtual;").append(NEW_LINE);
		funcaoJavascript = funcaoJavascript.append(TAB).append("}").append(NEW_LINE).append(NEW_LINE);
		
		funcaoJavascript = funcaoJavascript.append("}").append(NEW_LINE);
		
		return funcaoJavascript.toString();
	}
	
	private static StringBuffer getDocumentFrmPrincipalPontoIdReqCampo(String pIdReqCampoTipoDocumento) {
		StringBuffer documentFrmPrincipalPontoIdReqCampo = new StringBuffer();
			documentFrmPrincipalPontoIdReqCampo = documentFrmPrincipalPontoIdReqCampo.append("document.frm_principal.").append(pIdReqCampoTipoDocumento);
		return documentFrmPrincipalPontoIdReqCampo;
	}
	
	/**
	 * Verifica se a string passada só contém numeros.
	 * 
	 * @param pNumero
	 * 
	 * @return
	 */
	public static boolean isStringNumerica(String pNumero) {
		boolean valido = true;
		try {
			if ( UtilServico05.isStringValida(pNumero) ) {
				Integer.parseInt(pNumero);
			} else {
				valido = false;
			}
		} catch(NumberFormatException nfe) {
			valido = false;
		}		
		return valido;
	}
	
	/**
	 * Se for Acumulado, a Data Inicial vai ser o 1º dia do Exercicio
	 * Caso contrário, vai ser o 1º dia do Mes passado para o Filtro.
	 *  
	 * @param pInAcumulado
	 * @param pMesReferencia
	 * @param pDtAnoExercicio
	 * 
	 * @return
	 * 
	 * @throws ParseException
	 */
	public static Date getDtInicio(Boolean pInAcumulado, String pMesReferencia, Short pDtAnoExercicio) throws ParseException {
		String mes = "";
		if ( pInAcumulado.booleanValue() ) {
			mes = ConstantesPLOServico05.CD_MES_JANEIRO;
		} else {
			mes = pMesReferencia;			
		}
		
		Date dataInicio = BibliotecaFuncoesDataHora.getStringComoPrimeiraDataMes(mes + "/" + pDtAnoExercicio);
		return dataInicio;
	}
	
	/**
	 * Atribui um Zero no começo de uma String.	 
	 * 
	 * @param pShort
	 * 
	 * @return
	 */
	public static String atribuirZeroStringShort(Short pShort) {
		String stringRetorno = "";
		if(pShort.toString().length() == 1) {
			stringRetorno = "0"+pShort.toString();
		} else {
			stringRetorno = pShort.toString();
		}
		
		return stringRetorno;
	}
	
	/**
	 * Verifica se uma string é valida e retorna o seu valor em Boleano.
	 * 
	 * @param pValor
	 * 
	 * @return
	 */
	public static Boolean getValorBoleano(String pValor) {
		Boolean retorno = Boolean.TRUE;
		if(isStringValida(pValor)
				&& pValor.equalsIgnoreCase(ConstantesPLO.CD_FALSO)) {
			retorno = Boolean.FALSE;
		}		
		
		return retorno;
	}
	
	/**
	 * 
	 * @param pListaVOsGenericos
	 * @return
	 */
	public static Iterator<VOGenerico> getIterator(List<VOGenerico> pListaVOsGenericos) {
		Iterator<VOGenerico> resultado = new ArrayList<VOGenerico>().iterator();
		
		if ( isColecaoValida(pListaVOsGenericos) ) {
			resultado = pListaVOsGenericos.iterator();
		}
		return resultado;
	}
	
	/**
	 * Testa se o Iterator é diferente de nulo, e se for, testa se há mais elementos para a Iteração
	 * 
	 * @param pIteratorExcesso
	 * 
	 * @return		boolean			Tem próximo elemento
	 */
	public static boolean hasNext(Iterator<VOGenerico> pIteratorExcesso) {
		return 
			pIteratorExcesso != null && 
			pIteratorExcesso.hasNext();
	}
	
	public static VOGenerico getPrimeiroObjetoComoVOGenerico(Collection<VOGenerico> pColecao) {
		VOGenerico resposta = null;
		if ( BibliotecaFuncoesPLO.isColecaoValida(pColecao) ) {
			Iterator<VOGenerico> iterator = pColecao.iterator();
			resposta = iterator.next();
		}
		
		return resposta;
	}
	
	/**
	 * Ao receber um parâmetro que deveria ter o Código e o Sequencial de uma Fonte de Recurso, separados pelo Campo Separador,
	 * este método irá testar se realmente existe neste parâmetro o Campo Separador e o Sequencial.
	 * 
	 * Caso existam, irá obter o Sequencial após o campo separador.
	 * Caso contrário, irá retornar a constante 1.
	 * 
	 * 
	 * @param pCdNaturezaDespesaConsolidado
	 * @return
	 */
	public static Integer getSqFromCdSqNaturezaDespesa( String pCdNaturezaDespesaConsolidado) {
		Integer sqNaturezaDespesa = UM_INTEGER;
		if ( pCdNaturezaDespesaConsolidado.contains(CD_CAMPO_SEPARADOR) ) {
			sqNaturezaDespesa = Integer.valueOf( pCdNaturezaDespesaConsolidado.substring(13) );
		}
		return sqNaturezaDespesa;
	}
	
	/**
	 * Ao receber um parâmetro que deveria ter o Código e o Sequencial de uma Natureza de Despesa, separados pelo Campo Separador,
	 * este método irá testar se realmente existe neste parâmetro o Campo Separador e o Sequencial.
	 * 
	 * Caso existam, irá obter o Sequencial após o campo separador.
	 * Caso contrário, irá retornar a constante 1.
	 * 
	 * @param pCdFonteRecurso
	 * @return
	 */
	public static Integer getSqFromCdSqFonteRecurso(String pCdFonteRecurso) {
		Integer sqFonteRecurso = UM_INTEGER;
		if (pCdFonteRecurso.contains(CD_CAMPO_SEPARADOR)) {
			sqFonteRecurso = Integer.valueOf( pCdFonteRecurso.substring(15) );
		}
		return sqFonteRecurso;
	}
	
	public static boolean isDtInicialIgualOuAnterior(
		Date	pDtReferencia,
		Date	pDtComparacao)
	throws ExcecaoParametroInvalido {
		boolean isDtInicialIgualOuAnterior =
			BibliotecaFuncoesDataHora.compararDatasSemHoras(
				pDtReferencia, 
				pDtComparacao)
			>= 0;
		return isDtInicialIgualOuAnterior;
	}
	
	public static boolean isDtFinalIgualOuPosterior(
		Date	pDtReferencia,
		Date	pDtComparacao)
	throws ExcecaoParametroInvalido {
		boolean isDtFinalIgualOuPosterior = 
			BibliotecaFuncoesDataHora.compararDatasSemHoras(
					pDtReferencia, 
					pDtComparacao)
			<= 0;
		return isDtFinalIgualOuPosterior;
	}
	
	public static String getLinkParaAbrirJanelaAuxiliarExecucaoOrcamentariaOuConsultarSaldosRetroativos(
		String						pNmContextoWeb,
		String						pNmPR,
		TreeMap<String, String>		pMapaParametroIdCampoQueContemValor,
		String						pValorInExecucaoOrcamentaria)
	throws ExcecaoGenerica{
		StringBuilder funcaoJS = new StringBuilder("");
		String parametroJuncao = "";
		String conectorSinalAdicaoAspasSimples = "";
		
		String parametroInterrogacao = "?";
		String concatenadorAspasSimples = "\'" ;
		String igual = "=";
		String igualComAspasSimples = igual + concatenadorAspasSimples;
		
		String concatenadorSinalAdicao = ConstantesPLO.NEW_LINE +
										 ConstantesPLO.TAB +
										 ConstantesPLO.TAB + 
										 ConstantesPLO.TAB + 
										 ConstantesPLO.TAB + 
										 ConstantesPLO.TAB + 
										 ConstantesPLO.TAB + 
										 " + " ;
		
		if ( isStringValida(pNmContextoWeb) && isStringValida(pNmPR) ) {
			funcaoJS.append(concatenadorAspasSimples);
			
			
			if ( isMapValido(pMapaParametroIdCampoQueContemValor) ){
				funcaoJS.append(parametroInterrogacao);
				
				for ( Entry<String, String> mapaParametroIdCampoValor : pMapaParametroIdCampoQueContemValor.entrySet()){
					String parametroDaTela = mapaParametroIdCampoValor.getKey();
					String idDoCampo = mapaParametroIdCampoValor.getValue();
					
					funcaoJS.append(conectorSinalAdicaoAspasSimples)
						.append(parametroJuncao)
						.append(parametroDaTela)
						.append(igualComAspasSimples)
						.append(concatenadorSinalAdicao)
						.append(getDocumentFrmPrincipalPontoIdReqCampo(idDoCampo))
						.append(".value");
						
					conectorSinalAdicaoAspasSimples = concatenadorSinalAdicao + "\'";
					parametroJuncao = "&";
				}
			}
			
			if( isStringValida(pValorInExecucaoOrcamentaria) ){
				funcaoJS.append(conectorSinalAdicaoAspasSimples)
					.append(parametroJuncao)
					.append(ID_REQ_InExecucaoOrcamentaria)
					.append(igual)
					.append(pValorInExecucaoOrcamentaria)
					.append(concatenadorAspasSimples);
			}
			
			if ( !isStringValida(pValorInExecucaoOrcamentaria) && !isMapValido(pMapaParametroIdCampoQueContemValor) ){
				funcaoJS.append(concatenadorAspasSimples);
			}
		}
		
		return funcaoJS.toString();
	}
	
	public static String getCdNaturezaReceitaPai(String pCdNaturezaReceita) {
		String inicio = pCdNaturezaReceita.substring(0, 6);
		String nivel = pCdNaturezaReceita.substring(6, 8);
		
		if (!nivel.equals(NATUREZA_RECEITA_ZEROS_DIREITA_NIVEL_6)) {
			return inicio + NATUREZA_RECEITA_ZEROS_DIREITA_NIVEL_6;
		}
		
		inicio = pCdNaturezaReceita.substring(0, 4);
		nivel = pCdNaturezaReceita.substring(4, 6);
		
		if (!nivel.equals(NATUREZA_RECEITA_ZEROS_DIREITA_NIVEL_6)) {
			return inicio + NATUREZA_RECEITA_ZEROS_DIREITA_NIVEL_4;
		}
		
		inicio = pCdNaturezaReceita.substring(0, 3);
		nivel = pCdNaturezaReceita.substring(3, 4);
		
		if (!nivel.equals(NATUREZA_RECEITA_ZEROS_DIREITA_NIVEL_7)) {
			return inicio + NATUREZA_RECEITA_ZEROS_DIREITA_NIVEL_3;
		}
		
		inicio = pCdNaturezaReceita.substring(0, 2);
		nivel = pCdNaturezaReceita.substring(2, 3);
		
		if (!nivel.equals(NATUREZA_RECEITA_ZEROS_DIREITA_NIVEL_7)) {
			return inicio + NATUREZA_RECEITA_ZEROS_DIREITA_NIVEL_2;
		}
		
		inicio = pCdNaturezaReceita.substring(0, 1);
		nivel = pCdNaturezaReceita.substring(1, 2);
		
		if (!nivel.equals(NATUREZA_RECEITA_ZEROS_DIREITA_NIVEL_7)) {
			return inicio + NATUREZA_RECEITA_ZEROS_DIREITA_NIVEL_1;
		}
		
		return CD_NATUREZA_RECEITA_SEM_PAI;
	}
	
	public static boolean verificaSeEscrituracaoNivelSubalineaNaturezaReceitaPodeSerNaoEscriturada(
		String	pValorAValidar,
		String	pNmAtributo)
	throws ExcecaoValorNuloNaoPermitido{
		boolean isExpressaoValida = false;
		
		if ( isStringValida(pValorAValidar) ) {
			Pattern expressaoRegular = Pattern.compile("[0-9]{4}\\.[0-9]{2}\\.0{2}");
			
			Matcher valorNaExpressaoRegular = expressaoRegular.matcher(pValorAValidar);
			
			if ( valorNaExpressaoRegular.find() ) {
				isExpressaoValida = true;
			}
		} else {
			throw new ExcecaoValorNuloNaoPermitido(pNmAtributo, pValorAValidar);
		}
		
		return isExpressaoValida;
	}
	
	public static String getChavePrimariaSolicitacaoCicloExtraordinario(
		String	pDtAnoExercicio,
		String	pSqSolicitacaoCicloExtraordinario,
		String	pCdSolicitacaoSituacao,
		String	pCdUnidadeGestora,
		String	pSqUnidadeGestoraGestao,
		String	pCdGestao
	) {
		StringBuilder chavePrimaria = new StringBuilder("");
		
		chavePrimaria
			.append(pDtAnoExercicio)					.append(ConstantesPLO.CD_CAMPO_SEPARADOR)
			.append(pSqSolicitacaoCicloExtraordinario)	.append(ConstantesPLO.CD_CAMPO_SEPARADOR)
			.append(pCdSolicitacaoSituacao)				.append(ConstantesPLO.CD_CAMPO_SEPARADOR)
			.append(pCdUnidadeGestora)					.append(ConstantesPLO.CD_CAMPO_SEPARADOR)
			.append(pSqUnidadeGestoraGestao)			.append(ConstantesPLO.CD_CAMPO_SEPARADOR)
			.append(pCdGestao);
		
		return chavePrimaria.toString();
	}
	
	public static String getChavePrimariaSolicitacaoCicloExtraordinario(
		String	pDtAnoExercicio,
		String	pSqSolicitacaoCicloExtraordinario,
		String	pCdSolicitacaoSituacao,
		String	pCdUnidadeGestora,
		String	pSqUnidadeGestoraGestao,
		String	pCdGestao, 
		String	pValorAprovado
	) {
		StringBuilder chavePrimaria = new StringBuilder("");
		
		chavePrimaria.append(
				getChavePrimariaSolicitacaoCicloExtraordinario(
						pDtAnoExercicio,
						pSqSolicitacaoCicloExtraordinario,
						pCdSolicitacaoSituacao,
						pCdUnidadeGestora,
						pSqUnidadeGestoraGestao,
						pCdGestao))
					.append(ConstantesPLO.CD_CAMPO_SEPARADOR)
					.append(pValorAprovado);
		
		return chavePrimaria.toString();
	}
	
	public static String getComponenteUnicaUGCedente(
		String	pIdCampoCdUGCedente,
		String	pIdCampoDsUGCedente,
		String	pCdUGCedente,
		String	pDsUGCedente,
		boolean	pComNomenclaturaHiddenNoFim
	) {
		StringBuilder campoUGCedente = new StringBuilder("");
		
		campoUGCedente.append(montarComponente(HIDDEN, pComNomenclaturaHiddenNoFim, pIdCampoCdUGCedente, null, null, 0, 0, pCdUGCedente, false));
		campoUGCedente.append(montarComponente(HIDDEN, pComNomenclaturaHiddenNoFim, pIdCampoDsUGCedente, null, null, 0, 0, pDsUGCedente, false));
		
		campoUGCedente.append(montarComponente(TEXT, pComNomenclaturaHiddenNoFim, pIdCampoCdUGCedente, pIdCampoCdUGCedente, CLASS_CAMPO_READ_ONLY, 6, 6, pCdUGCedente, true));
		campoUGCedente.append(montarComponente(TEXT, pComNomenclaturaHiddenNoFim, pIdCampoDsUGCedente, pIdCampoDsUGCedente, CLASS_CAMPO_READ_ONLY, 100, 25, pDsUGCedente, true));
		
		return campoUGCedente.toString();
	}
	
	public static String montarComponente(
		String	pTipo,
		boolean	pInNomenclaturaHiddenNoFim,
		String	pIdCampo,
		String	pNameCampo,
		String	pClassCampo,
		int		pMaxLengthCampo,
		int		pSizeCampo,
		String	pValueCampo,
		boolean	pIsReadOnly
	) {
		StringBuilder componente = new StringBuilder();
		
		return componente.append(
				montarComponenteComFuncoesJavaScript(
						pTipo,
						pInNomenclaturaHiddenNoFim,
						pIdCampo,
						pNameCampo,
						pClassCampo,
						pMaxLengthCampo,
						pSizeCampo,
						pValueCampo,
						pIsReadOnly,
						null)
				).toString();
	}
	
	public static String montarComponenteComFuncoesJavaScript(
		String	pTipo,
		boolean	pInNomenclaturaHiddenNoFim,
		String	pIdCampo,
		String	pNameCampo,
		String	pClassCampo,
		int		pMaxLengthCampo,
		int		pSizeCampo,
		String	pValueCampo,
		boolean	pIsReadOnly,
		String	pJavaScript
	) {
		StringBuilder componente = new StringBuilder();
		
		String tagAberturaInput = TAG_ABERTURA_INPUT;
		String tagFechamento = TAG_FECHAMENTO;
		componente.append(tagAberturaInput);
		
		if ( isStringValida(pTipo) ) {
			componente.append(ATRIBUTO_TYPE).append(pTipo).append(ASPA_ESPACO);
		}
		
		if ( isStringValida(pIdCampo) ) {
			componente.append(ATRIBUTO_ID).append(pIdCampo);
			if ( pTipo.equalsIgnoreCase(HIDDEN) ) {
				if ( pInNomenclaturaHiddenNoFim ) {
					componente.append(HIDDEN);
				} else {
					pIdCampo = UNDERLINE + pIdCampo;
					componente.append(pIdCampo);
				}
			}
			componente.append(ASPA_ESPACO);
		}
		
		if ( isStringValida(pNameCampo) ) {
			componente.append(ATRIBUTO_NAME).append(pNameCampo).append(ASPA_ESPACO);
		}
		
		if ( isStringValida(pClassCampo) ) {
			componente.append(ATRIBUTO_CLASS).append(pClassCampo).append(ASPA_ESPACO);
		}
		
		if ( pMaxLengthCampo != 0 ) {
			componente.append(ATRIBUTO_MAX_LENGTH).append(pMaxLengthCampo).append(ASPA_ESPACO);
		}
		
		if ( pSizeCampo != 0 ) {
			componente.append(ATRIBUTO_SIZE).append(pSizeCampo).append(ASPA_ESPACO);
		}
		
		if ( isStringValida(pValueCampo) ) {
			componente.append(ATRIBUTO_VALUE).append(pValueCampo).append(ASPA_ESPACO);
		}
		
		if ( pIsReadOnly ) {
			componente.append(READ_ONLY);
		}
		
		if ( isStringValida(pJavaScript) ) {
			componente.append(pJavaScript);
		}
		
		componente.append(tagFechamento).append(QUEBRA_LINHA);
		
		return componente.toString();
	}
	
	/**
	 * 
	 * @param pDataAValidar
	 * @return
	 */
	public static boolean isDataValida(String pDataAValidar) {
		return isDataValida(pDataAValidar, null);
	}
	
	/**
	 * 
	 * @param pDataAValidar
	 * @return
	 */
	public static boolean isMesAnoValido(String pMesAnoAValidar) {
		String expressaoRegular = "^(0[1-9]|1[012])/(19[0-9]{2}|2[0-9]{3})$";
		
		return isDataValida(pMesAnoAValidar,expressaoRegular);
	}
	
	/**
	 * 
	 * @param pAnoAValidar
	 * @return
	 */
	public static boolean isAnoValido(String pAnoAValidar) {
		String expressaoRegular = "^(19[0-9]{2}|2[0-9]{3})$";
		
		return isDataValida(pAnoAValidar, expressaoRegular);
	}
	
	/**
	 * 
	 * @param pDataAValidar
	 * @param pExpressaoRegular
	 * @return
	 */
	public static boolean isDataValida(String pDataAValidar, String pExpressaoRegular) {
		String expressao = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19[0-9]{2}|2[0-9]{3})$";
		if ( isStringValida(pExpressaoRegular) ) {
			expressao = pExpressaoRegular;
		}
		
		return isExpressaoRegularValida(pDataAValidar, expressao);
	}

	/**
	 * 
	 * @param pDataAValidar
	 * @param pExpressaoRegular
	 * @return
	 */
	public static boolean isExpressaoRegularValida(String pValor, String pExpressaoRegular) {
		boolean isExpressaoValida = false;
		if ( isStringValida(pValor) && isStringValida(pExpressaoRegular) ) {
			Pattern expressaoRegular = Pattern.compile(pExpressaoRegular);
			
			Matcher valorNaExpressaoRegular = expressaoRegular.matcher(pValor);
			
			if ( valorNaExpressaoRegular.find() ) {
				isExpressaoValida = true;
			}
		}
		
		return isExpressaoValida;
	}
	
	public static String removerPontos(String pString) throws ExcecaoAtributoInvalido {
		String retorno = "";
		if ( isStringValida(pString) ) {
			retorno = pString.replace(".", "");
		} else {
			throw new ExcecaoAtributoInvalido(retorno);
		}
		return retorno;
	}
	
	public static String substituirVirgulaPorPonto(String pString) {
		String retorno = "";
		
		if ( isStringValida(pString) ) {
			retorno = BibliotecaFuncoesPrincipal.substituir(pString, ",", ".");
		}
		
		return retorno;
	}
	
	public static StringBuilder getImportJavaScript(String pSource, String pNomeArquivoJs) {
		StringBuilder script = new StringBuilder("");
		script.
			append(TAG_SCRIPT_ABERTURA).
			append(LANGUAGE).
			append(" = \"JavaScript\"").
			append("type = \"text/javascript\"").
			append("src = \"").
			append(pSource).
			append("/").
			append(pNomeArquivoJs).
			append("\"").
			append(TAG_SCRIPT_FECHAMENTO);
			
		return script;
	}
	
	public static boolean isTpAdmPublicaDireta( String pTpAdministracaoPublica ) {
		boolean resposta = false;
		
		if (
				BibliotecaFuncoesPLO.isStringValida(pTpAdministracaoPublica)		&&
				!pTpAdministracaoPublica.equalsIgnoreCase(ConstantesPLO.TP_ADM_PUBL_DIRETA)
		) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isTpAdmPublicaIndireta( String pTpAdministracaoPublica ) {
		boolean resposta = false;
		
		if (
				BibliotecaFuncoesPLO.isStringValida(pTpAdministracaoPublica)		&&
				!pTpAdministracaoPublica.equalsIgnoreCase(ConstantesPLO.TP_ADM_PUBL_INDIRETA)
		) {
			resposta = true;
		}
		
		return resposta;
	}
	
	/**
	 * -
	 *
	 * @param pCdUGCedente  
	 *
	 * @return  
	 */
	public static boolean isCdUGValido(String pCdUGCedente) {
		return 
			isStringValida(pCdUGCedente)			&&
			pCdUGCedente.length() == 6				&&
			!pCdUGCedente.equals(ConstantesPLO.CD_OPCAO_TODOS)
		;
	}
	
	/**
	 * Este método irá separar a String passada como parâmetro, utilizando o Campo Separador padrão do e-Fisco.
	 * A lista de valores resultantes será ordenada Lexicograficamente.
	 * Esta lista será convertida de volta em uma String, utilizando o Campo Separador padrão do e-Fisco e retornada pelo método.
	 * 
	 * @param pValor
	 * 
	 * @return
	 */
	public static String ordenarStringComCampoSeparador(String pValor){
		String valor = "";
		
		if ( isStringValida(pValor) ) {
			List<String> lista = splitToListStrings(pValor);
			if ( isColecaoValida(lista) ) {
				Collections.sort(lista);
				for( String valorAtual : lista ){
					if ( isStringValida(valorAtual) ) {
						valor += valorAtual + ConstantesPLO.CD_CAMPO_SEPARADOR;
					}
				}
			}
		}
		
		return valor;
	}
	
	public static StringBuilder montarParametrizacaoSimples(
		String 			pConector,
		String 			pNomeEntidade,
		String 			pNomeAtributo
	) {
		return montarCondicaoParaWHERE(pConector, pNomeEntidade, pNomeAtributo, null, false, false, false);
	}
	
	public static StringBuilder montarParametrizacaoLike(
		String 			pConector,
		String 			pNomeEntidade,
		String 			pNomeAtributo
	) {
		return montarCondicaoParaWHERE(pConector, pNomeEntidade, pNomeAtributo, null, true, false, false);
	}
	
	public static StringBuilder montarParametrizacaoILike(
		String 			pConector,
		String 			pNomeEntidade,
		String 			pNomeAtributo
	) {
		return montarCondicaoParaWHERE(pConector, pNomeEntidade, pNomeAtributo, null, false, true, false);
	}
	
	public static StringBuilder montarParametrizacaoComparacaoInicioFim(
			String 			pConector,
			String 			pNomeEntidade,
			String 			pNomeAtributo,
			String 			pNomeAtributo2){
		return montarCondicaoParaWHERE(pConector, pNomeEntidade, pNomeAtributo, pNomeAtributo2, false, false, true);
	}
	
	private static StringBuilder montarCondicaoParaWHERE(
		String 			pConector,
		String 			pNomeEntidade,
		String 			pNomeAtributo,
		String 			pNomeAtributo2,
		boolean 		pIsCondicaoLIKE,
		boolean 		pIdCondicaoILIKE,
		boolean 		pIsComparacaoInicioFim
	) {
		
		String espaco = " ";
		String like = " LIKE ";
		String ilike = " ILIKE ";
		String igual = " = ";
		String parametrizacao = "? ";
		
		StringBuilder sql = new StringBuilder();
		
		if ( isStringValida(pConector) ) {
			sql.append(espaco).append(pConector).append(espaco);
		}
		
		if ( isStringValida(pNomeEntidade) ) {
			sql.append(espaco).append(pNomeEntidade).append(".");
		}
		
		if ( isStringValida(pNomeAtributo) ) {
			sql.append(pNomeAtributo).append(espaco);
			
			if ( pIsCondicaoLIKE ){
				sql.append(like).append(parametrizacao);
			} else if (pIdCondicaoILIKE) {
				sql.append(ilike).append(parametrizacao);
			} else if ( pIsComparacaoInicioFim ){
				if ( isStringValida(pNomeAtributo) && isStringValida(pNomeAtributo2) ) {
					sql.append(MENOR_IGUAL).append(parametrizacao).
						append(AND).
							append(" (").
								append(espaco).append(pNomeEntidade).append(".").append(pNomeAtributo2).
									append(MAIOR_IGUAL).append(parametrizacao).
								append(OR).
								append(espaco).append(pNomeEntidade).append(".").append(pNomeAtributo2).append(IS_NULL).append(" )");
				}
			} else {
				sql.append(igual).append(parametrizacao);
			}
		}
		
		return sql;
	}
	
	public static StringBuilder getInstrucaoDeleteCompleta(String pStatementSql, String pNomeEntidade, Object pSqlFiltro){
		String sqlFiltro = "";
		StringBuilder instrucaoDelete = new StringBuilder("");
		
		if ( isStringValida(pSqlFiltro) ){
			if( pSqlFiltro instanceof StringBuilder || pSqlFiltro instanceof StringBuffer || pSqlFiltro instanceof String ){
				sqlFiltro = pSqlFiltro.toString();
			}
			instrucaoDelete.append(pStatementSql).
				append(QUEBRA_LINHA).
				append(pNomeEntidade).
				append(QUEBRA_LINHA).
				append(WHERE).
				append(QUEBRA_LINHA).
				append(sqlFiltro);
		}
		
		return instrucaoDelete;	
	}
	
	public static <T> boolean isValorMonetarioValido(T pValor, int pQuantidadeCasasDecimais){
		return isExpressaoRegularValida(pValor.toString(), "^-{0,1}[0-9]+(\\.[0-9]{0," + pQuantidadeCasasDecimais + "})?$");
	}
	
}