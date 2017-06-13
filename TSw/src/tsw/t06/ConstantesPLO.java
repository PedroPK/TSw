/*
 * Este arquivo � propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informa��o nele contida pode ser
 * reproduzida, mostrada ou revelada sem permiss�o escrita da Sefaz-PE.
 */
package tsw.t06;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 
 */
public class ConstantesPLO extends Constantes {
	
	public static final Short ZERO_SHORT = Short.valueOf( (short) 0);
	public static final Short UM_SHORT = Short.valueOf( (short) 1);
	public static final Short DOIS_SHORT = Short.valueOf( (short) 2);
	public static final Short TRES_SHORT = Short.valueOf( (short) 3);
	public static final Short QUATRO_SHORT = Short.valueOf( (short) 4);
	public static final Short CINCO_SHORT = Short.valueOf( (short) 5);
	public static final Short SEIS_SHORT = Short.valueOf( (short) 6);
	public static final Short SETE_SHORT = Short.valueOf( (short) 7);
	public static final Short OITO_SHORT = Short.valueOf( (short) 8);
	public static final Short NOVE_SHORT = Short.valueOf( (short) 9);
	public static final Short DEZ_SHORT = Short.valueOf( (short) 10);
	public static final Short ONZE_SHORT = Short.valueOf( (short) 11);
	public static final Short DOZE_SHORT = Short.valueOf( (short) 12);
	public static final Short TREZE_SHORT = Short.valueOf( (short) 13);
	public static final Short CATORZE_SHORT = Short.valueOf( (short) 14);
	public static final Short QUINZE_SHORT = Short.valueOf( (short) 15);
	public static final Short DEZESSEIS_SHORT = Short.valueOf( (short) 16);
	public static final Short DEZESSETE_SHORT = Short.valueOf( (short) 17);
	public static final Short DEZOITO_SHORT = Short.valueOf( (short) 18);
	public static final Short DEZENOVE_SHORT = Short.valueOf( (short) 19);
	public static final Short VINTE_SHORT = Short.valueOf( (short) 20);
	public static final Short VINTE_UM_SHORT = Short.valueOf( (short) 21);
	public static final Short VINTE_DOIS_SHORT = Short.valueOf( (short) 22);
	public static final Short VINTE_TRES_SHORT = Short.valueOf( (short) 23);
	public static final Short VINTE_QUATRO_SHORT = Short.valueOf( (short) 24);
	public static final Short VINTE_CINCO_SHORT = Short.valueOf( (short) 25);
	public static final Short VINTE_SEIS_SHORT = Short.valueOf( (short) 26);
	public static final Short VINTE_SETE_SHORT = Short.valueOf( (short) 27);
	public static final Short VINTE_OITO_SHORT = Short.valueOf( (short) 28);
	public static final Short VINTE_NOVE_SHORT = Short.valueOf( (short) 29);
	public static final Short TRINTA_SHORT = Short.valueOf( (short) 30);
	public static final Short TRINTA_UM_SHORT = Short.valueOf( (short) 31);
	public static final Short TRINTA_DOIS_SHORT = Short.valueOf( (short) 32);
	public static final Short TRINTA_TRES_SHORT = Short.valueOf( (short) 33);
	public static final Short TRINTA_QUATRO_SHORT = Short.valueOf( (short) 34);
	public static final Short TRINTA_CINCO_SHORT = Short.valueOf( (short) 35);
	public static final Short TRINTA_SEIS_SHORT = Short.valueOf( (short) 36);
	public static final Short TRINTA_SETE_SHORT = Short.valueOf( (short) 37);
	public static final Short TRINTA_NOVE_SHORT = Short.valueOf( (short) 39);
	public static final Short QUARENTA_SHORT = Short.valueOf( (short) 40);
	public static final Short CINQUENTA_OITO_SHORT = Short.valueOf( (short) 58);
	public static final Short NOVENTA_NOVE_SHORT = Short.valueOf( (short) 99);
	public static final Short TREZENTOS_SHORT = Short.valueOf( (short) 300);
	public static final Short DOIS_MIL_E_OITO_SHORT = Short.valueOf( (short) 2008);
	public static final Short DOIS_MIL_E_NOVE_SHORT = Short.valueOf( (short) 2009);
	public static final Short DOIS_MIL_E_ONZE_SHORT = Short.valueOf( (short) 2011);
	public static final Short MENOS_UM_SHORT = Short.valueOf( (short) -1);
	
	public static final Integer ZERO_INTEGER = Integer.valueOf(0);
	public static final Integer UM_INTEGER = Integer.valueOf(1);
	public static final Integer DOIS_INTEGER = Integer.valueOf(2);
	public static final Integer TRES_INTEGER = Integer.valueOf(3);
	public static final Integer QUATRO_INTEGER = Integer.valueOf(4);
	public static final Integer CINCO_INTEGER = Integer.valueOf(5);
	public static final Integer SEIS_INTEGER = Integer.valueOf(6);
	public static final Integer MENOS_UM_INTEGER = Integer.valueOf(-1);
	
	public static final Double ZERO_DOUBLE = new Double(0);
	
	public static final String ZERO_ZERO_STRING = "00";
	public static final String ZERO_STRING = "0";
	
	public static final String ZERO_VIRGULA_ZERO_ZERO_STRING = "0,00";
	
	public static final BigDecimal UM_BIGDECIMAL = BigDecimal.ONE;
	public static final BigDecimal CEM_BIGDECIMAL = new BigDecimal(100);
	public static final BigInteger CEM_BIGINTEGER= new BigInteger("100");
	
	public static final String CD_IN_BLOQUEIO_INICIAL = "N";
	
	/**
	 * -
	 */
	public static final Short CD_LEI_ORCAMENTARIA_ANUAL_TABELA_PARAMETRO = QUATRO_SHORT;
	public static final Short CD_UGC_MINISTERIO_PUBLICO_TABELA_PARAMETRO = VINTE_SETE_SHORT;
	public static final Short CD_UGC_DEFENSORIA_PUBLICA_TABELA_PARAMETRO = TRINTA_SEIS_SHORT;
	public static final Short INDICADOR_LIBERACAO_SOLICITACOES_RETROATIVAS_CREDITOADICIONAL_REMANEJAMENTOORCAMENTARIO = TRINTA_SETE_SHORT;
	
	public static final String NIVEL_DETALHAMENTO = "5";
	public static final String CD_UG_FINANCEIRA_DO_ESTADO = "150102";
	
	/**
	 * -
	 */
	public static final String CD_OPCAO_VIGENTES = "V";
	public static final String CD_OPCAO_NAO_VIGENTES = "N";
	
	/**
	 * -
	 */
	public static final String CD_INCISO_IV = "4";
	public static final String CD_INCISO_V = "5";
	
	public static final Short ANO_VERIFICACAO_INCISO = DOIS_MIL_E_OITO_SHORT;
	public static final String ANO_INICIO_SOLICITACOES_CREDITOS_ADICIONAIS = "2008";
	
	/**
	 * -
	 */
	public static final String NM_ENT_PLO_OPERACAO = ConstantesPLO.NM_SCHEMA_ORC_PLO + "PLO_OPERACAO";
	
	/**
	 * - Nome da Servlet de Fonte de Recurso, utilizada por componentes Web
	 * dentro do projeto ORC_PLO_JAVA.
	 */
	public static final String NM_SERVLET_PR_MANTER_FONTE_RECURSO_VIGENCIA = "PRManterFonteRecursoVigencia";
	
	/**
	 * - Nome da Servlet de Fonte de Recurso para Opera��o de Cr�dito, utilizada por componentes Web
	 * dentro do projeto ORC_PLO_JAVA.
	 */
	public static final String NM_SERVLET_PR_MANTER_FONTE_RECURSO_PARA_OPERACAO_CREDITO = "PRManterFontesRecursoParaOperacaoCredito";
	/**
	 * - Nome da Servlet de Grupo de Despesa, utilizada por componentes Web
	 * dentro do projeto ORC_PLO_JAVA.
	 */
	public static final String NM_SERVLET_PR_MANTER_GRUPO_DESPESA_VIGENCIA = "PRManterGrupoDespesaVigencia";
	
	/**
	 * - Nome da Servlet de Programa de Trabalho, utilizada por componentes Web
	 * dentro do projeto ORC_PLO_JAVA.
	 */
	public static final String NM_SERVLET_PR_MANTER_PROGRAMA_TRABALHO_VIGENCIA = "PRManterProgramaTrabalhoVigencia";
	
	/**
	 * - Nome da Servlet de PLO �rg�o, utilizada por componentes Web dentro do
	 * projeto ORC_PLO_JAVA.
	 */
	public static final String NM_SERVLET_PR_MANTER_PLO_ORGAO = "PRManterPLOOrgao";
	
	/**
	 * - Nome da Servlet de PLO �rg�o Vigencia, utilizada por componentes Web dentro do
	 * projeto ORC_PLO_JAVA.
	 */
	public static final String NM_SERVLET_PR_CONSULTAR_PLO_ORGAO_VIGENCIA = "PRConsultarPLOOrgaoVigencia";
	
	
	/**
	 * - Nome da Servlet de PLO DetalhamentoClassificacaoEstDespOrc, utilizada por componentes Web dentro do
	 * projeto ORC_PLO_JAVA.
	 */
	public static final String NM_SERVLET_PR_MANTER_PLO_DetalhamentoClassificacaoEstDesOrc = "PRManterDetalhamentoClassificacaoEstDesOrc";

	
	public static final String NM_SERVLET_PR_MANTER_PLO_FuncaoVigencia = "PRManterFuncaoVigencia";
	/**
	 * - Nome da Servlet de Unidade Or�ament�ria, utilizada por componentes Web
	 * dentro do projeto ORC_PLO_JAVA.
	 */
	public static final String NM_SERVLET_PR_MANTER_UNIDADE_ORCAMENTARIA = "PRManterUnidadeOrcamentaria";
	
	/**
	 * - Nome da Servlet de Unidade Or�ament�ria por Vig�ncia, utilizada por componentes Web
	 * dentro do projeto ORC_PLO_JAVA.
	 */
	public static final String NM_SERVLET_PR_MANTER_UNIDADE_ORCAMENTARIA_VIGENCIA = "PRConsultarUnidadeOrcamentariaVigencia";
		
	/**
	 * - Nome da Servlet de Revers�o de Provis�o (pela UGE), utilizada por componentes Web dentro do projeto ORC_PLO_JAVA.
	 */
	public static final String NM_SERVLET_PR_MANTER_REVERSAO_PROVISAO = "PRManterReversaoProvisao";
	
	public static final String NM_SERVLET_PR_MANTER_NATUREZA_RECEITA_VIGENCIA = "PRManterNaturezaReceitaVigencia";
	
	/**
	 * - Nome da Servlet de Consultar Saldos Retroativos, utilizada por componentes Web dentro do projeto ORC_PLO_JAVA.
	 */
	public static final String NM_SERVLET_PR_CONSULTAR_SALDOS_RETROATIVOS = "PRConsultarSaldosRetroativos";
	
	/**
	 * - Evento para o m�todo exibirFiltroConsulta, comum a quase todas as PR's (Servlets) de Cadastro.
	 */
	public static final String EVENTO_EXIBIR_FILTRO_CONSULTA = "exibirFiltroConsulta";
	
	public static final String NM_SERVLET_CONSULTAR_UNIDADE_ORCAMENTARIA_VIGENCIA = "PRConsultarUnidadeOrcamentariaVigencia";
	public static final String NM_SERVLET_CONSULTAR_FUNCAO_VIGENCIA = "PRManterFuncaoVigencia";
	public static final String NM_SERVLET_CONSULTAR_SUB_FUNCAO_VIGENCIA = "PRManterSubFuncaoVigencia";
	public static final String NM_SERVLET_CONSULTAR_NATUREZA_DESPESA = "PRManterNaturezaDespesaVigencia";
	public static final String NM_PATH_SERVLET_CONSULTAR_UNIDADE_ORCAMENTARIA_VIGENCIA = 
		"/" + ConstantesPLO.NM_CONTEXTO_WEB_ORC_PLO + "/" + NM_SERVLET_CONSULTAR_UNIDADE_ORCAMENTARIA_VIGENCIA;
	
	/**
	 * -
	 */
	public static final String NM_ATR_CdOperacaoPLO = "PLOOPERA_SQ";
	public static final String NM_ATR_NmOperacaoPLO = "PLOOPERA_NM";

	public static final Short SQ_OPERACAO_PLO_INCLUSAO = UM_SHORT;
	public static final Short SQ_OPERACAO_PLO_ALTERACAO = DOIS_SHORT;
	public static final Short SQ_OPERACAO_PLO_INATIVACAO = TRES_SHORT;
	public static final Short SQ_OPERACAO_PLO_ATIVACAO = QUATRO_SHORT;

	/**
	 * -
	 */
	public static final String NM_ATR_DtAnoSolicitacaoCreditoAdicional = "SOLCREDADI_DT_ANO";

	public static final String NM_PROPRIEDADE_TRANSACAO_REJEITAR_MES_FECHADO = "REJEITA_DOTACAO_MES_FECHADO";

	/**
	 * -
	 */
	public static final String TP_ADM_PUBL_DIRETA = "D";
	public static final String TP_ADM_PUBL_INDIRETA = "I";

	/**
	 * -
	 */
	public static final String NM_TP_ADM_PUBL_DIRETA = "Direta";
	public static final String NM_TP_ADM_PUBL_INDIRETA = "Indireta";
	
	/**
	 * -
	 */
	public static final String CD_SELECAO_POR_UO = "porUnidadesOrcamentarias";
	public static final String ORCAMENTO_FISCAL = "Or�amento Fiscal ";
	public static final String ORCAMENTO_INVESTIMENTO = "DE INVESTIMENTO DAS EMPRESAS";
	
	/**
	 * -
	 */
	public static final String CD_SELECAO_CONSOLIDADO = "opcao_todos";
	
	/**
	 * - Descri��o para o valor "null"
	 */
	public static final String DS_NULO = "NULO";
	
	/**
	 * -
	 */
	public static final String IN_NATUREZA_ORCAMENTARIA_EMPRESA_PUBLICA = "1";
	public static final String IN_NATUREZA_ORCAMENTARIA_EMPRESA_MISTA = "2";
	public static final String IN_NATUREZA_ORCAMENTARIA_AUTARQUIA = "3";
	public static final String IN_NATUREZA_ORCAMENTARIA_FUNDACAO = "4";
	public static final String IN_NATUREZA_ORCAMENTARIA_FUNDOS = "5";

	/**
	 * -
	 */
	public static final String DS_NATUREZA_ORCAMENTARIA_EMPRESA_PUBLICA = "Empresa P�blica";
	public static final String DS_NATUREZA_ORCAMENTARIA_EMPRESA_MISTA = "Empresa Mista";
	public static final String DS_NATUREZA_ORCAMENTARIA_AUTARQUIA = "Autarquia";
	public static final String DS_NATUREZA_ORCAMENTARIA_FUNDACAO = "Funda��o";
	public static final String DS_NATUREZA_ORCAMENTARIA_FUNDOS = "Fundos";

	/**
	 * -
	 */
	public static final String GRUPO_DESPESA_33 = "Outras Invers�es Financeiras";
	
	/**
	 * - C�digos de Eventos de Contabiliza��o
	 */
	public static final String EVENTO_DESBLOQUEIO_DOTACAO_CRIADA_A_PARTIR_DE_CREDITO_ESPECIAL = "200045";
	public static final String CD_EVENTO_DESBLOQUEIO_REJEICAO_DOTACAO_CREDITO_EXTRAORDINARIO = "200046";
	public static final String EVENTO_BLOQUEIO_DOTACAO_CRIADA_A_PARTIR_DE_CREDITO_ESPECIAL = "200051";
	public static final String CD_EVENTO_BLOQUEIO_DOTACAO_CREDITO_EXTRAORDINARIO = "200061";
	
	/**
	 * C�digos de Eventos de Destaque
	 */
	public static final String CD_EVENTO_DESTAQUE_PROGRAMAR_COTA_UGE2 = "541801";
	public static final String CD_EVENTO_DESTAQUE_PROGRAMAR_COTA_UGC2 = "541802";
	public static final String CD_EVENTO_DESTAQUE_CONTABILIZACAO_NA_UGC_FINANCEIRA = "541805";
	public static final String CD_EVENTO_DESTAQUE_REDUCAO_COTA_UGE1_PARA_UGC1 = "541806";
	public static final String CD_EVENTO_DESTAQUE_CONTABILIZACAO_NA_UGC = "541807";
	
	// N�o utilizado at� o momento (04/07/2011)
	public static final String CD_EVENTO_DESTAQUE_CONTABILIZACAO_PELA_PROPRIA_UGC = "541800";
	
	public static final String CD_EVENTO_DESTAQUE_TRANSFERENCIA_ORCAMENTO_UGC1_PARA_UGC2 = "300061";
	public static final String CD_EVENTO_DESTAQUE_PROVISAO_CREDITO_UGC2_PARA_UGE2 = "300063";
	public static final String CD_EVENTO_DESTAQUE_REVERSAO_PROVISAO_UGE1_UGC1 = "300064";
	
	public static final String CD_EVENTO_PREVISAO_ADICIONAL_RECEITA_SE_HOUVER_CREDITO_ADICIONAL_POR_EXCESSO_ARRECADACAO = "100011";
	
	public static final String CD_EVENTO_BLOQUEIO_RESERVA_DOTACAO_200049 = "200049";
	
	public static final String CD_EVENTO_REDUCAO_ORIGEM = "200170";
	public static final String CD_EVENTO_ACRESCIMO_DESTINO = "200171";
	
	/**
	 * Reserva de Dota��o
	 */
	public static final String CD_EVENTO_DESBLOQUEIO_RESERVA_DOTACAO = "200071";
	


	/**
	 * - Tipos de Poder da Administra��o P�blica: - Executivo - Legislativo -
	 * Judici�rio - Essencial para a Justi�a
	 */
	public static final String TP_PODER_ADM_PUBL_EXECUTIVO = "E";
	public static final String TP_PODER_ADM_PUBL_JUDICIARIO = "J";
	public static final String TP_PODER_ADM_PUBL_LEGISLATIVO = "L";
	public static final String TP_PODER_ADM_PUBL_ESSENCIAL_PARA_JUSTICA = "P";

	/**
	 * -
	 */
	public static final String NM_TP_PODER_ADM_PUBL_EXECUTIVO = "Executivo";
	public static final String NM_TP_PODER_ADM_PUBL_JUDICIARIO = "Judici�rio";
	public static final String NM_TP_PODER_ADM_PUBL_LEGISLATIVO = "Legislativo";
	public static final String NM_TP_PODER_ADM_PUBL_ESSENCIAL_PARA_JUSTICA = "Essencial para a Justi�a";
	
	/**
	 * -
	 */
	public static final Short SQ_PLOOPERA_INCLUSAO = UM_SHORT;
	public static final Short SQ_PLOOPERA_ALTERACAO = DOIS_SHORT;
	public static final Short SQ_PLOOPERA_EXCLUSAO = TRES_SHORT;
	public static final Short SQ_PLOOPERA_CANCELAMENTO_EXCLUSAO = QUATRO_SHORT;
	
	/**
	 * -
	 */
	public static final Short SQ_ESTRUTURA_PAINEL_COMPLETA = Short.valueOf( Short.MAX_VALUE);
	
	/**
	 * -
	 */
	public static final String TP_ESFERA_PODER_MUNICIPAL = "M";
	public static final String TP_ESFERA_PODER_ESTADUAL = "E";
	public static final String TP_ESFERA_PODER_FEDERAL = "F";
	public static final String TP_ESFERA_PODER_DISTRITO_FEDERAL = "D";
	
	/**
	 * -
	 */
	public static final Short CONTA_CONTABIL_CTB_REALIZADA_ATE = VINTE_QUATRO_SHORT;
	public static final Short CONTA_CONTABIL_CTB_SUPERAVIT = VINTE_CINCO_SHORT;
	public static final Short CONTA_CONTABIL_CTB_ORCADA = VINTE_SEIS_SHORT;
	public static final String ANO_PRIMEIRO_REVISAO_LOA = "1�. Ano Revis�o";
	public static final String ANO_SEGUNDO_REVISAO_LOA = "2�. Ano Revis�o";
	public static final String ANO_TERCEIRO_REVISAO_LOA = "3�. Ano Revis�o";
	public static final String ANO_QUARTO_REVISAO_LOA = "4�. Ano Revis�o";
	
	/**
	 * - Constante que guarda o tamanho padr�o dos campos selects que devem ser limitados.
	 */
	public static final Integer VL_TAMANHO_CAMPO_SELECT_PADRAO_PLO = Integer.valueOf(110);

	/**
	 * - Contantes que identificao se o relacionamente entre uma Vincula��o Legal e uma Natureza da Receita.
	 *   Pode ser Receita ou Dedu��o
	 */
	public static final String TP_VINC_LEGAL_DEDUCAO = "D";
	public static final String TP_VINC_LEGAL_RECEITA = "R";

	/**
	 * - Utilizadas na interface do Caso de Uso de Vincula��o Legal
	 */
	public static final String CD_OPR_CORRENTE_INCLUSAO = "I";
	public static final String CD_OPR_CORRENTE_ALTERACAO = "A";

	/**
	 * -
	 */
	public static final String IN_ATIVO = "Ativo";
	public static final String IN_INATIVO = "Inativo";
	
	//Inativar esta Unidade Or�ament�ria
	public static final String NM_ACAO = "A��o";
	public static final String NM_PROGRAMA_GOVERNO = "Programa de Governo";
	
	// Codigos de opcao de apresentacao do Painel Estrategico
	public static final String CD_OPCAO_APRESENTACAO_VISUAL_BASICO_ESTADO = "1";
	
	public static final String CD_OPCAO_APRESENTACAO_VISUAL_BASICO_OUTRAS_FONTES = "2";
	
	public static final String CD_OPCAO_APRESENTACAO_VISUAL_BASICO_TODAS_FONTES = "3";
	
	// Codigos de opcao de apresentacao do Relat�rio de Evolu��o da Receita do Painel Estrategico -  23/08/2006
	public static final String CD_OPCAO_EVOLUCAO_RECEITA_DESPESA_TESOURO_ESTADO = "1";
	public static final String CD_OPCAO_EVOLUCAO_RECEITA_DESPESA_OUTRAS_FONTES = "2";
	public static final String CD_OPCAO_EVOLUCAO_RECEITA_DESPESA_TODAS_FONTES = "3";
	
	// IDs para atributos inseridos em Hashtables de vincula��es contitucionais
	public static final String ID_ATRIBUTO_VINCULACAO_NmVinculacaoLegal = "NmVinculacaoLegal ";
	public static final String ID_ATRIBUTO_VINCULACAO_VlVinculacaoLegal = "VlVinculacaoLegal ";
	
	/**
	 * -
	 */
	public static final Short CD_ESFERA_ORCAMENTARIA_FISCAL = UM_SHORT;
	public static final Short CD_ESFERA_ORCAMENTARIA_INVESTIMENTO = TRES_SHORT;
	
	/**
	 * -
	 */
	public static final short CD_GRUPO_FONTE_RECURSO_TESOURO = 1;
	
	public static final short CD_GRUPO_FONTE_RECURSO_OUTRAS_FONTES = 2;
	
	/**
	 * -
	 */
	public static final Short CD_PARAM_EXERCICIO_EM_PLANEJAMENTO = UM_SHORT;
	public static final Short CD_PARAM_UNIDADE_ORCAMENTARIA_CENTRAL = DOIS_SHORT;
	public static final Short CD_PARAM_NIVEL_CONTABILIZACAO_ORCAMENTO = TRES_SHORT;
	public static final Short CD_PARAM_EXERCICIO_TETO_ORCAMENTARIO_FECHADO = TRINTA_QUATRO_SHORT;
	public static final Short CD_PARAM_DESDOBRAMENTO_FONTE_DETALHADA_GESTOR_ORCAMENTARIO = QUARENTA_SHORT;
	
	/**
	 * -
	 */
	public static final String CD_PARAM_NUMERO_LDO = "NumeroLDO";
	
	/**
	 * -
	 */
	public static final Integer NU_DETALHAMENTO_FONTE_NAO_DETALHADA = Integer.valueOf(0);
	
	/**
	 * -
	 */
	public static final String CD_OPCAO_RELATORIO_LOA = "L";
	public static final String CD_OPCAO_RELATORIO_QUADRO = "Q";
	
	/**
	 * -
	 */
	public static final String IN_SITUACAO_FASE_ORCAMENTO_ABERTA = "A";
	
	public static final String IN_SITUACAO_FASE_ORCAMENTO_FECHADA = "F";
	
	/**
	 * -
	 */
		
	public static final String ORIGEM_DADOS  = "origemDosDados";
	public static final String CD_TIPO_RELATORIO_POR_LEI			= "PorLei";
	public static final String CD_TIPO_RELATORIO_POR_PROJETO_LEI			= "PorProjetoLei";
	public static final String CD_TIPO_RELATORIO_POR_PACTUACAO_SUGERIDO   = "PorPactuacaoSugerido";
	public static final String CD_TIPO_RELATORIO_POR_PACTUACAO_REMANEJADO = "PorPactuacaoRemanejado";
	
	/**
	 * -
	 */
	public static final String NM_SITUACAO_FASE_ORCAMENTO_ABERTA = "Aberta";
	public static final String NM_SITUACAO_FASE_ORCAMENTO_FECHADA = "Fechada";
	
	/**
	 * -
	 */
	public static final Short CD_FASE_ORCAMENTO_PROPOSTA = UM_SHORT;
	public static final Short CD_FASE_ORCAMENTO_ANALISE = DOIS_SHORT;
	public static final Short CD_FASE_ORCAMENTO_EMENDA = TRES_SHORT;
	public static final Short CD_FASE_ORCAMENTO_LEI = QUATRO_SHORT;
	
	/**
	 * -
	 */
	public static final String NM_FASE_ORCAMENTO_PROPOSTA = "Proposta";
	public static final String NM_FASE_ORCAMENTO_ANALISE = "An�lise";
	public static final String NM_FASE_ORCAMENTO_EMENDA = "Emenda";
	public static final String NM_FASE_ORCAMENTO_LEI = "Lei";
	
	/**
	 * -
	 */
	public static final String CD_TIPO_RELATORIO_POR_RECEITA_DEDUCAO = "PorReceitaDeducao";
	
	public static final String CD_TIPO_RELATORIO_POR_RECEITA_TOTAL = "PorReceitaTotal";
	
	/**
	 * 
	 */
	public static final String CD_OPCAO_COM_DIFERENCA = "opcao_com_diferenca";
	
	/**
	 * -
	 */
	public static final Integer ID_ORGAO_PLO_MINISTERIO_PUBLICO = Integer.valueOf(32000);
	
	/**
	 * -
	 */
	public static final String SG_TP_UNIDADE_GESTORA_COORDENADORA = Constantes.CD_TIPO_UG_COORDENADORA;
	
	/**
	 * -
	 */
	public static final Short CD_FUNCAO_SETOR_OUTROS = NOVENTA_NOVE_SHORT;
	
	/**
	 * -
	 */
	public static final String NM_FUNCAO_SETOR_OUTROS = "Outros";
	
	/**
	 * -
	 */
	public static final String NM_SITUACAO_PAINEL_APROVADO = "Aprovado";
	public static final String NM_SITUACAO_PAINEL_SIMULACAO = "Simula��o";
	
	/**
	 * -
	 */
	public static final String VL_LIMITE_SOMA_LIMITE_DESPESA_PESSOAL = "60.0";
	
	/**
	 * -
	 */
	public static final double PC_PRUDENCIAL_LIMITE_DESPESA_PESSOAL = 0.95;
	
	/**
	 * - Codigo da Despesa Reserva de Risco
	 */
	public static final Short CD_DESPESA_PAINEL_RESERVA_RISCO = TREZENTOS_SHORT;
	
	/**
	 * - Tipos de Despesa no Painel Estrategico
	 */
	public static final String TP_DESPESA_PAINEL_VARIAVEL = "V";
	public static final String TP_DESPESA_PAINEL_FORMULA = "F";
	public static final String TP_DESPESA_PAINEL_SOMATORIO = "S";
	
	/**
	 * - Tipos de valores de Despesas de formula Variavel
	 */
	public static final String TP_PAINEL_DESPESA_VALOR_ORDIN_TESOURO = "1";
	public static final String TP_PAINEL_DESPESA_VALOR_VINC_TESOURO = "2";
	public static final String TP_PAINEL_DESPESA_VALOR_ORDIN_OUTRAS = "3";
	public static final String TP_PAINEL_DESPESA_VALOR_VINC_OUTRAS = "4";
	
	/**
	 * - C�digos e nomes do Domn�nio de Situa��o de Solicita��o de Provis�o
	 */
	public static final String CD_SITUACAO_SOLICITACAO_PROVISAO_ELABORACAO = "E";
	public static final String CD_SITUACAO_SOLICITACAO_PROVISAO_ANALISE = "A";
	public static final String CD_SITUACAO_SOLICITACAO_PROVISAO_APROVADA_TOTAL = "T";
	public static final String CD_SITUACAO_SOLICITACAO_PROVISAO_APROVADA_COM_MODIFICACAO = "M";
	public static final String CD_SITUACAO_SOLICITACAO_PROVISAO_REJEITADA = "R";
	public static final String CD_SITUACAO_SOLICITACAO_DESTAQUE_ELABORACAO = "E";
	public static final String CD_SITUACAO_SOLICITACAO_DESTAQUE_ANALISE = "A";
	public static final String CD_SITUACAO_SOLICITACAO_DESTAQUE_APROVADA = "P";
	public static final String CD_SITUACAO_SOLICITACAO_DESTAQUE_REJEITADA = "R";
	
	/**
	 * -Utilizada em Exerc�cio
	 */
	public static final String CD_SITUACAO_EM_EXECUCAO = "E";
	
	/**
	 * - C�digos com os pos�veis fluxos de execu��o para a inclus�o de uma solicita��o de cr�dito adicional
	 */
	public static final String CD_FLUXO_EXECUCAO_NOVO_PROGRAMA_NOVA_ACAO_NOVA_CATEGORIA = "1";
	public static final String CD_FLUXO_EXECUCAO_PROGRAMA_EXISTENTE_NOVA_ACAO_NOVA_CATEGORIA = "2";
	public static final String CD_FLUXO_EXECUCAO_PROGRAMA_EXISTENTE_ACAO_EXISTENTE_NOVA_CATEGORIA = "3";
	public static final String CD_FLUXO_EXECUCAO_CREDITO_SUPLEMENTAR = "4";
	public static final String CD_FLUXO_EXECUCAO_REABERTURA_CREDITO = "5";
	public static final String CD_FLUXO_EXECUCAO_CREDITO_ADICIONAL_CENTRALIZADO = "6";
	public static final String CD_EXECUCAO_ORCAMENTARIA_VALOR_DOTACAO_INICIAL = "50";
	public static final String CD_EXECUCAO_ORCAMENTARIA_VALOR_DOTACAO_CREDITO_SUPLEMENTAR = "51";
	public static final String CD_EXECUCAO_ORCAMENTARIA_VALOR_CREDITO_ESPECIAL = "52";
	public static final String CD_EXECUCAO_ORCAMENTARIA_VALOR_CREDITO_EXTRAORDINARIO = "53";
	public static final String CD_EXECUCAO_ORCAMENTARIA_VALOR_REDUCAO_CREDITO_SUPLEMENTAR = "54";
	public static final String CD_EXECUCAO_ORCAMENTARIA_VALOR_REDUCAO_CREDITO_ESPECIAL = "55";
	public static final String CD_EXECUCAO_ORCAMENTARIA_VALOR_REDUCAO_CREDITO_EXTRAORINARIO = "56";
	public static final String CD_EXECUCAO_ORCAMENTARIA_VALOR_BLOQUEIO = "57";
	public static final String CD_EXECUCAO_ORCAMENTARIA_TOTAL_REMANEJEMENTO_CONCEDIDO = "116";
	public static final String CD_EXECUCAO_ORCAMENTARIA_TOTAL_REMANEJEMENTO_RECEBIDO = "117";
	public static final String CD_EXECUCAO_ORCAMENTARIA_TOTAL_LIQUIDADO = "15";
	public static final String CD_EXECUCAO_ORCAMENTARIA_TOTAL_ANULADO_LIQUIDACAO = "16";
	
	/**
	 * - C�digos de Resultado para An�lises.
	 * 	 * A Aprova��o Parcial � utilizada para Provis�o
	 */
	public static final String CD_RESULTADO_ANALISE_APROVADA = "A";
	public static final String CD_RESULTADO_ANALISE_APROVADA_PARCIALMENTE = "P";
	public static final String CD_RESULTADO_ANALISE_REJEITADA = "R";
	
	/**
	 * - Nome das opera��es
	 */
	public static final String NM_OPERACAO_PROVISAO = "Provis�o";
	public static final String NM_OPERACAO_REVERSAO_PROVISAO = "Revers�o Provis�o";
	public static final String NM_OPERACAO_INCLUIR_PROVISAO = "Incluir Provis�o";
	public static final String NM_OPERACAO_SOLICITAR_PROVISAO = "Solicita��o de Provis�o";
	public static final String NM_OPERACAO_RESERVA_DOTACAO = "Reserva de Dota��o";
	
	/**
	 * - Identificados do Tipo de Fase do Teto Or�ament�rio 
	 */
	public static final String TP_FASE_PACTUACAO = "Pactuacao";
	public static final String TP_FASE_EMENDADO = "Emendado";
	
	/**
	 * - C�digo da Fonte de Recurso (do Tesouro): -- Recursos Ordinarios da
	 * Administra��o Direta
	 */
	public static final String CD_FONTE_RECURSO__RECURSOS_ORDINARIOS__ADMINISTRACAO_DIRETA = "0101000000";
	
	public static final String TERMINACAO_FONTE_RECURSO_SINTETICA = "000000";
	
	/**
	 * - Codigos do Dom�nio de Tipo de Desdobramento de Fonte Detalhada
	 */
	public static final short CD_TIPO_FONTE_NAO_DETALHAVEL						= UM_SHORT.shortValue();
	public static final short CD_TIPO_FONTE_NAO_DETALHAVEL_SALVO_CONTRAPARTIDA	= DOIS_SHORT.shortValue();
	public static final short CD_TIPO_FONTE_DETALHAVEL_POR_CONVENIO				= TRES_SHORT.shortValue();
	public static final short CD_TIPO_FONTE_DETALHAVEL_POR_CONTRATO				= QUATRO_SHORT.shortValue();
	public static final short CD_TIPO_FONTE_PODE_OU_NAO_SER_DETALHADA			= CINCO_SHORT.shortValue();
	public static final short CD_TIPO_FONTE_DETALHADA_POR_CONVENIO				= SEIS_SHORT.shortValue();
	public static final short CD_TIPO_FONTE_DETALHADA_POR_CONTRATO				= SETE_SHORT.shortValue();
	public static final short CD_TIPO_FONTE_DETALHADA_POR_OUTRAS_FONTES			= OITO_SHORT.shortValue();
	
	/**
	 * -
	 */
	public static final String CD_TIPO_DESDOBRAMENTO_DETALHAMENTO = "D";
	public static final String CD_TIPO_DESDOBRAMENTO_REVERSAO = "R";
	
	/**
	 * - Constantes da situa��o de uma reserva de dota��o
	 */
	public static final String CD_SITUACAO_RESERVA_DOTACAO_BLOQUEADA = "B";
	public static final String CD_SITUACAO_RESERVA_DOTACAO_DESBLOQUEADA = "D";
	public static final String CD_SITUACAO_RESERVA_DOTACAO_NENHUMA = "N";
	
	/**
	 * - Codigo da base para calculo do limite de credito suplementar
	 */
	public static final Short CD_BASE_LIM_CRED_SUPL_TOTAL_ORCAMENTO		= UM_SHORT;
	public static final Short CD_BASE_LIM_CRED_SUPL_TOTAL_ORGAO			= DOIS_SHORT;
	public static final Short CD_BASE_LIM_CRED_SUPL_TOTAL_PROGRAMA		= TRES_SHORT;
	public static final Short CD_BASE_LIM_CRED_SUPL_TOTAL_ACAO			= QUATRO_SHORT;
	
	/**
	 * -
	 */
	public static final String CD_SITUACAO_PUBLICACAO_REMAN_CREDITO_PUBLICADO = "P";
	public static final String CD_SITUACAO_PUBLICACAO_REMAN_CREDITO_ENCAMINHADO_PUBLICACAO = "E";
	public static final String CD_SITUACAO_PUBLICACAO_REMAN_CREDITO_EM_CONFERENCIA = "C";
	
	/**
	 * -
	 */
	public static final String CD_SITUACAO_AVALIACAO_ACAO_GPP_APROVADA = "AP";
	
	/**
	 * - Constantes para �ndices de reajuste do Painel Estrategico
	 */
	public static final String TP_INDICE_PAINEL_REESTIMADO = "R";
	public static final String TP_INDICE_PAINEL_PROJETADO = "P";
	public static final String TP_INDICE_PAINEL_RECEITA = "R";
	public static final String TP_INDICE_PAINEL_DESPESA = "D";
	
	/**
	 * - Constante que indica nivel em que a despesa � tratada no painel
	 * estrat�gico
	 */
	public static final String TP_NIVEL_DESPESA_PAINEL = ConstantesPLO.NATUREZA_DESPESA_TP_NIVEL_GRUPO_DESPESA;
	
	/**
	 * - Prefixos que designam tipos de naturezas de receita
	 */
	public static final String TP_PREFIXO_RECEITAS_CORRENTES = "1";
	public static final String TP_PREFIXO_RECEITAS_CAPITAL = "2";
	public static final String TP_PREFIXO_RECEITAS_DEDUCOES = "9";
	
	/**
	 * - Tipo de documento interno do PLO
	 */
	public static final String CD_REVERSAO_PROVISAO_CREDITO = "RP";
	
	/**
	 * - C�digo da Conta Cont�bil em PLO Par�metros para obten��o de saldo retroativo
	 */
	public static final String CD_CONTA_CONTABIL_PROVISAO_CREDITO = "11";
	public static final String CD_CONTA_CONTABIL_REVERSAO_PROVISAO_CREDITO = "12";
	public static final String CD_CONTA_CONTABIL_DESTAQUE_DE_CREDITO = "13";
	public static final String CD_CONTA_CONTABIL_REMANEJAMENTO_DE_CREDITO = "14";
	public static final String CD_CONTA_CONTABIL_DESDOBRAMENTO_DE_FONTE = "15";
	public static final String CD_CONTA_CONTABIL_CREDITO_ADICIONAL = "16";
	public static final String CD_CONTA_CONTABIL_PF_UGC = "17";
	
	/**
	 * - Conta Cont�bil da Programa��o Financeira para a UG Central Utilizada
	 * para a Valida��o de Saldo no Destaque de Cr�dito. Usada em conjunto com a
	 * constante: - CD_CONTA_CONTABIL_PF_UGC_FINANCEIRA_GERAL_DEVEDORA = 24
	 */
	public static final String CD_CONTA_CONTABIL_PF_UGC_FINANCEIRA_GERAL = "18";
	public static final String CD_CONTA_CONTABIL_RESERVA_DOTACAO = "19";
	
	/**
	 * - Conta CTB para valida��o de Saldo no Destaque de Cr�dito
	 */
	public static final String CD_CONTA_CONTABIL_PF_UGC_FINANCEIRA_GERAL_DEVEDORA = "29";
	
	/**
	 * - Conjunto de tipos de fonte de recurso a serem filtrados na execu��o
	 * or�ament�ria - String com todos os Tipos de Fonte de Recurso
	 * [Sint�ticas/"M�es"/Detalhaveis]
	 */
	public static final String STRING_SQL_TIPOS_FONTE_RECURSO_DETALHAVEL = 
		CD_TIPO_FONTE_NAO_DETALHAVEL_SALVO_CONTRAPARTIDA + ","
		+ CD_TIPO_FONTE_DETALHAVEL_POR_CONVENIO + ","
		+ CD_TIPO_FONTE_DETALHAVEL_POR_CONTRATO + ","
		+ CD_TIPO_FONTE_PODE_OU_NAO_SER_DETALHADA;
	
	/**
	 * - String com todos os Tipos de Fonte de Recurso
	 * [Anal�ticas/"Filhas"/N�o-Detalhaveis]
	 */
	public static final String STRING_SQL_TIPOS_FONTE_RECURSO_NAO_DETALHAVEL = 
		CD_TIPO_FONTE_DETALHADA_POR_CONVENIO + ","
		+ CD_TIPO_FONTE_DETALHADA_POR_CONTRATO + ","
		+ CD_TIPO_FONTE_DETALHADA_POR_OUTRAS_FONTES;
	
	/**
	 * -
	 */
	public static final String STRING_SQL_TIPOS_FONTE_RECURSO_NAO_DETALHAVEL_CASO_PROVISAO = 
		CD_TIPO_FONTE_NAO_DETALHAVEL + ","
		+ CD_TIPO_FONTE_NAO_DETALHAVEL_SALVO_CONTRAPARTIDA + ","
		+ CD_TIPO_FONTE_PODE_OU_NAO_SER_DETALHADA + ","
		+ CD_TIPO_FONTE_DETALHADA_POR_CONVENIO + ","
		+ CD_TIPO_FONTE_DETALHADA_POR_CONTRATO + ","
		+ CD_TIPO_FONTE_DETALHADA_POR_OUTRAS_FONTES;
	
	/**
	 * -
	 */
	public static final String STRING_SQL_TIPOS_FONTES_NAO_DETALHADAS = 
		CD_TIPO_FONTE_NAO_DETALHAVEL + ","
		+ CD_TIPO_FONTE_NAO_DETALHAVEL_SALVO_CONTRAPARTIDA + ","
		+ CD_TIPO_FONTE_DETALHAVEL_POR_CONVENIO + ","
		+ CD_TIPO_FONTE_DETALHAVEL_POR_CONTRATO + ","
		+ CD_TIPO_FONTE_PODE_OU_NAO_SER_DETALHADA;
	
	/**
	 * - Utilizada nos Creditos Adicionais na montagem do select da fonte de
	 * recurso quando a Origem for Conv�nio
	 */
	public static final String STRING_SQL_TIPOS_FONTES_DET_POR_CONVENIO_DET_POR_CONTRAPARTIDA_DETALHADA_OU_NAO = 
		Short.toString( CD_TIPO_FONTE_DETALHAVEL_POR_CONVENIO );
	
	/**
	 * - Utilizada nos Creditos Adicionais na montagem do select da fonte de
	 * recurso quando a Origem for Opera��o
	 */
	public static final String STRING_SQL_TIPOS_FONTES_DET_POR_CONTRATO_DET_POR_CONTRAPARTIDA_DETALHADA_OU_NAO = 
		Short.toString( CD_TIPO_FONTE_DETALHAVEL_POR_CONTRATO );
	
	/**
	 * -
	 */
	public static final Short CD_TIPO_VFM_RESERVA_DOTACAO = CINQUENTA_OITO_SHORT;
	
	public static final Short CD_MINISTERIO_PUBLICO = VINTE_SETE_SHORT;
	
	/**
	 * -C�digos que representam as fontes de recurso de opera��o de Cr�dito
	 * direta/indireta
	 */
	public static final Short CD_FONTE_RECURSO_OPERACAO_CREDITO_DIRETA = TRINTA_SHORT;
	public static final Short CD_FONTE_RECURSO_OPERACAO_CREDITO_INDIRETA = TRINTA_UM_SHORT;
	public static final Short CD_FONTE_RECURSO_OPERACAO_CREDITO_AMBAS = TRINTA_TRES_SHORT;
	
	/**
	 * -C�digo que representa as naturezas de receita de cess�o de superavit
	 */
	public static final Short CD_NATUREZA_RECEITA_CESSAO_SUPERAVIT = TRINTA_DOIS_SHORT;
	
	/**
	 * - ATENDENDO ISSUE #27012 - Na elementa�ao de despesa, n�o permitir que os
	 * Elementos de Despesas 51 e 61 sejam associados a a��es diferentes de
	 * projetos.
	 */
	public static final String COLECAO_CRITICA_ELEMENTO_DE_DESPESA_EM_CELULA_ORCAMENTARIA_PARA_ACAO_DO_TIPO_PROJETO = 
		"51" + ConstantesPLO.CD_CAMPO_SEPARADOR + 
		"61";
	
	/**
	 * - ATENDENDO ISSUE #27435 - Na elementa�ao de despesa, n�o permitir que os
	 * Elementos de Despesas 63, 64, 65 e 66 sejam associados a a��es diferentes
	 * de opera��es especiais.
	 */
	public static final String COLECAO_CRITICA_ELEMENTO_DE_DESPESA_EM_CELULA_ORCAMENTARIA_PARA_ACAO_DO_TIPO_OPERACOES_ESPECIAIS = 
		"63" + ConstantesPLO.CD_CAMPO_SEPARADOR
		+ "64" + ConstantesPLO.CD_CAMPO_SEPARADOR
		+ "65" + ConstantesPLO.CD_CAMPO_SEPARADOR + 
		" 66 ";
	
	/**
	 * -
	 */
	public static final String CD_NATUREZA_DESPESA_DE_ACORDO_COM_LOA_CREDITOS_ADICIONAIS = "31";
	
	/**
	 * - Tipos para Relat�rio Receita Or�ada Desdobrada por Itens e Fontes de
	 * Recursos - LOA
	 */
	public static final String CD_RECEITA_PREVISTA_ANALITICO = "A";
	public static final String CD_RECEITA_PREVISTA_CONSOLIDADO = "C";
	
	/**
	 * -
	 */
	public static final String DS_RECEITA_PREVISTA_ANALITICO = "Anal�tico";
	public static final String DS_RECEITA_PREVISTA_CONSOLIDADO = "Consolidado";
	
	/**
	 * -
	 */
	public static final String CD_RECEITA_PREVISTA_CORRENTES = "10000000";
	public static final String CD_RECEITA_PREVISTA_CAPITAL = "20000000";
	public static final String CD_RECEITA_PREVISTA_CORRENTES2 = "70000000";
	public static final String CD_RECEITA_PREVISTA_CAPITAL2 = "80000000";
	public static final String CD_RECEITA_PREVISTA_DEDUCOES = "90000000";
	
	/**
	 * -
	 */
	public static final String CD_RECEITA_PREVISTA_FONTES_TESOURO = "01";
	public static final String CD_RECEITA_PREVISTA_OUTRAS_FONTES = "02";
	public static final String CD_RECEITA_PREVISTA_RESERVA = "9";
	
	/**
	 * - Utilizado na inclus�o do destino da solicita��o do Cr�dito Adicional - >
	 * Constitui��o ou aumento de capital de empresas (C�digo 4590)
	 */
	public static final String CD_CONSTITUICAO_OU_AUMENTO_DE_CAPITAL_DE_EMPRESAS_NIVEL_MODALIDADE = "4590";
	public static final String CD_NATUREZA_RECEITA_IMPACTA_ORCAMENTO = "4591";
	
	/**
	 * - Utilizado na inclus�o do destino da solicita��o do Cr�dito Adicional - >
	 * Constitui��o ou aumento de capital de empresas (C�digo 4590)
	 */
	public static final String CD_CONSTITUICAO_OU_AUMENTO_DE_CAPITAL_DE_EMPRESAS_NIVEL_ITEM_DE_GASTO = "45906500";
	
	/**
	 * - Utilizado na PRImpactoOrcamentoInvestimento
	 */
	public static final String CD_TIPO_INVESTIMENTO_CREDITO = "C";
	
	/**
	 * - Utilizado na PRImpactoOrcamentoInvestimento
	 */
	public static final String CD_TIPO_INVESTIMENTO_ANULACAO = "A";
	
	/**
	 * - Utilizado na PRImpactoOrcamentoInvestimento quando ocorre a
	 * ExcecaoOrgaoDaUGInformadaNaoESupervisorDoOrgaoDaUGSolicitante
	 */
	public static final String DS_TIPO_UG_SOLICITANTE_DO_CREDITO_ADICIONAL = "Solicitante";
	
	/**
	 * - Utilizado na PRImpactoOrcamentoInvestimento quando ocorre a
	 * ExcecaoOrgaoDaUGInformadaNaoESupervisorDoOrgaoDaUGSolicitante
	 */
	public static final String DS_TIPO_UG_SOLICITADA_DO_CREDITO_ADICIONAL = "Solicitada";
	
	/**
	 * Descri��o, com o nome do campo de C�digo da Natureza de Receita
	 */
	public static final String DS_NOME_CAMPO_CODIGO_NATUREZA_RECEITA = "C�digo da Natureza de Receita";
	
	/**
	 * Descri��o, com o nome do campo de C�digo da Fonte de Recurso
	 */
	public static final String DS_NOME_CAMPO_CODIGO_FONTE_RECURSO = "C�digo da Fonte de Recurso";
	
	/**
	 * Descri��o, com o nome do campo de Seq��ncial da Natureza de Receita
	 */
	public static final String DS_NOME_CAMPO_SEQUENCIAL_NATUREZA_RECEITA = "Seq��ncial da Natureza de Receita";
	
	/**
	 * Descri��o, com o nome do campo de Seq��ncial da Fonte de Recurso
	 */
	public static final String DS_NOME_CAMPO_SEQUENCIAL_FONTE_RECURSO = "Seq��ncial da Fonte de Recurso";
	
	/**
	 * -
	 */
	public static final String CD_SOLIC_CREDITO_ADICIONAL = "C";
	public static final String CD_SOLIC_REMANEJAMENTO_CREDITO = "R";
	public static final String CD_SOLIC_ORGAO = "OR";
	public static final String CD_SOLIC_UNIDADE_ORCAMENTARIA = "UO";
	public static final String CD_SOLIC_UNIDADE_GESTORA = "UG";
	public static final String CD_SOLIC_QUANTIDADE = "Q";
	public static final String CD_SOLIC_VALOR = "V";
	
	/**
	 * -
	 */
	public static final String NM_COL_Codigo = "CODIGO";
	public static final String NM_COL_Descricao = "DESCRICAO";
	public static final String NM_COL_QuantidadeSolicitada = "QTD";
	public static final String NM_COL_ValorSolicitado = "VALOR";
	public static final String NM_COL_ValorOrcado = "CELULA_VALOR";
	
	/**
	 * - Utilizado na Solicita��o do Cr�dito Adicional
	 */
	public static final String DS_NENHUM = "Nenhum";
	public static final String DS_NAO_DEFINIDA = "N�o definida";
	
	/**
	 * - Constantes utilizada na Revers�o de Provis�o da UGC
	 */
	public static final String DS_DA_REVERSAO = "da Revers�o";
	
	/**
	 * - Constante que define o campo separador a ser usado nos jobs de exporta��od e dados do PLO
	 */
	public static final String CD_CAMPO_SEPARADOR_ARQUIVO_EXPORTACAO_PLO = ";";
	
	/**
	 * - Constante que define o c�digo do par�metro que indica quais as UGs que ter�o arquivos individuais gerados pelos jobs de
	 * exporta��o do GFU
	 */
	public static final String CD_PARAM_RELACAO_UGS_EXPORTACAO = "CdRelUGsArquivosGeraisFinanc";
	
	/**
	 * - Constante que define o c�digo do par�metro que indica quantidades de meses retroativos gerados pelos jobs de
	 * exporta��o do GFU
	 */
	public static final String CD_PARAM_QUANTIDADE_MESES_RETROATIVOS = "QtMesesRetroativosExecucaoJob";
	
	/**
	 * Constantes que definem os retornos [em HashTable] das REGRAS DE NEG�CIOS
	 */
	public static final String CHAVE_NUMERO_DOCUMENTO_CTB = "numeroDocumentoRefCTB";
	public static final String CHAVE_OTD_SOLICITACAO_CA = "otdSolicitacaoCreditoAdicional";
	public static final String CD_RECEITA_FUNDEB = "17240100";
	public static final String[] CD_VINCULACOES_QUE_TRATAM_RECEITA_REDUTORA = new String[] {"2"};
	public static final Short DT_ANO_2009 = DOIS_MIL_E_NOVE_SHORT;
	public static final Short DT_ANO_2011 = DOIS_MIL_E_ONZE_SHORT;
	
	/**
	 * Constante para definir o tamanho m�ximo de um arquivo.
	 */
	public static final Long SIZE_1MB_BYTES_LONG = Long.valueOf(1048576);
	
	/**
	 * Ordena��o crescente
	 */
	public static final String CD_ORDEM_CRESCENTE = "C";
	
	/**
	 * Constantes utilizadas na tela Bloqueia/Desbloqueia C�lula da Despesa (Painel)
	 */
	public static final String ACAO_BLOQUEAR_TODAS_CELULAS = "BTC";
	public static final String ACAO_DESBLOQUEAR_TODAS_CELULAS = "DTC";
	public static final String ACAO_BLOQUEIO_DESBLOQUEIO_POR_CELULA = "BDC";
	
	/**
	 * Constante utilizada na consulta de C�lulas de Teto
	 */
	public static final String IN_COLECAO_ORIGEM = "Origem";
	public static final String IN_COLECAO_DESTINO = "Destino";
	
	/**
	 * Constante com o c�digo da Classicica��o da Despesa n�o Priorit�ria
	 */
	public static final String CD_CLASSIFICACAO_DESPESA_NAO_CLASSIFICADA = "00";
	
	/**
	 * Constante com a conta de Liquidacao da Despesa 
	 */
	public static final String CONTACTB_CD = "292130200";
	
	/**
	 * Constantes de Cargo Pessoa
	 */
	public static final String CD_CARGO_PESSOA_GOVERNADOR = "1";
	public static final String CD_CARGO_PESSOA_VICE_GOVERNADOR = "2";
	public static final String CD_CARGO_PESSOA_PRESIDENTE_ASSEMBLEIA = "3";
	public static final String CD_CARGO_PESSOA_PRESIDENTE_TRIBUNAL = "4";	
	/**
	 * Descri��es de Cargo Pessoa
	 */
	public static final String DS_CARGO_PESSOA_GOVERNADOR = "Governador do Estado de Pernambuco";
	public static final String DS_CARGO_PESSOA_VICE_GOVERNADOR = "Vice-Governador do Estado de Pernambuco";
	public static final String DS_CARGO_PESSOA_PRESIDENTE_ASSEMBLEIA = "Presidente da Assembl�ia Legislativa";
	public static final String DS_CARGO_PESSOA_PRESIDENTE_TRIBUNAL = "Presidente do Tribunal de Justi�a";
	
	/**
	 * -C�digo que representa o governador do estado de pernambuco na tabela de parametro do plo
	 */
	public static final Short CD_GOVERNADOR_ESTADO_PERNAMBUCO = VINTE_TRES_SHORT;
	
	/**
	 * - Identificador no N�mero de Refer�ncia Cont�bil
	 */
	public static final String ID_REQ_NUMERO_REFERENCIA_CONTABIL = "N�mero de Refer�ncia Cont�bil";
	
	public static final String ID_REQ_DT_EXERCICIO_ACAO_GPP = "DtExercicioAcao";
	
	public static final String ID_REQ_DATA_INICIO_VIGENCIA_GPO = "dtInicioVigencia";

	/**
	 * - Identificador do Tipo do Valor do Teto a ser listado no Relat�rio 
	 */
	public static final String DS_TIPO_RELATORIO_SUGERIDO = "VALOR SUGERIDO";
	public static final String DS_TIPO_RELATORIO_SOLICITADO = "VALOR SOLICITADO";
	public static final String DS_TIPO_RELATORIO_APROVADO = "VALOR APROVADO";
	public static final String DS_TIPO_RELATORIO_EMENDADO = "VALOR EMENDADO";	
	
	/**
	 * - Identificador do Caso de Uso Consultar Emendas ao Projeto de Lei 
	 */
	public static final String DS_TIPO_EMENDA_TODOS = "*";
	public static final String DS_TIPO_EMENDA_PPA = "P";
	public static final String DS_TIPO_EMENDA_LOA = "L";
	
	public static final String DS_OBJETO_EMENDA_TODOS = "*";
	public static final String DS_OBJETO_EMENDA_TEXTO = "T";
	public static final String DS_OBJETO_EMENDA_ANEXOS = "V";
	
	public static final String DS_NATUREZA_EMENDA_TODOS = "*";
	public static final String DS_NATUREZA_EMENDA_ADITIVA = "A";
	public static final String DS_NATUREZA_EMENDA_MODIFICADA = "M";
	public static final String DS_NATUREZA_EMENDA_SUPRESSIVA = "S";
	public static final String DS_NATUREZA_EMENDA_SUBSTITUTIVA = "T";
		
	public static final String DS_SITUACAO_EMENDA_TODOS = "*";
	public static final String DS_SITUACAO_EMENDA_SIM = "S";
	public static final String DS_SITUACAO_EMENDA_NAO = "N";
	
	public static final String DS_GRUPO_ORIGEM = "O";
	public static final String DS_GRUPO_DESTINO = "D";
	
	public static final String DS_SITUACAO_ORGAO_REJEITADO = "RJ";
	public static final String DS_SITUACAO_ORGAO_APROVADO = "AP";
	public static final String DS_SITUACAO_ORGAO_APROVADOCOMRESSALVA = "AR";
	public static final String DS_SITUACAO_ORGAO_PEDENTE_AVALIACAO = "PA";
	
	public static final String DS_SITUACAO_DED_ATIVA = "A";
	public static final String DS_SITUACAO_DED_CANCELADA = "X";
	public static final String DS_SITUACAO_DED_DESPRIORIZADA = "D";
	public static final String DS_SITUACAO_DED_CONCLUIDA = "C";
	
	/**
	 * - Utilizado no Relat�rio de Emenda 
	 */
	public static final String VALOR_OBJETO_MUNICIPALIZACAO = "T";
	public static final String VALOR_OBJETO_AOSANEXOS = "V";
	
	public static final String DS_CONTEUDO_RELATORIO_VAZIO = "Nenhum registro encontrado para os par�metros informados!";
	
	// Identificador comum a v�rias PRs de Servi�os diferentes
	public static final String ID_REQ_DataContabil = "Data_Contabil";
	public static final String ID_REQ_DtAnoExercicioCTB = "DtAnoExercicioCTB";
	public static final String ID_REQ_TipoDocumento = "Tipo_Documento";
	public static final String ID_REQ_CdUnidadeGestora = "CdUnidadeGestora";
	public static final String ID_REQ_CdGestao = "CdGestao";
	public static final String ID_REQ_SqFonteRecurso = "_SqFonteRecurso";
	public static final String ID_REQ_CdAcao = "CdAcao";
	public static final String ID_REQ_NmAcao = "NmAcao";
	
	public static final String ID_REQ_IN_MULTIPLA_ESCOLHA = "in_multipla_escolha";
	public static final String ID_REQ_CHECKBOX_SELECIONADOS = "checkbox_selecionados";
	public static final String ID_REQ_CHECKBOX_SELECIONAR_TODOS = "checkbox_selecionar_todos";
	
	public static final String ID_REQ_NmOrgao = "NmOrgao";
	
	public static final String ID_REQ_NmSubacao = "NmSubAcao";
	
	public static final String ID_REQ_NmFuncao = "NmFuncao";
	
	public static final String ID_REQ_InExecucaoOrcamentaria = "InExecucaoOrcamentaria";
	
	/**
	 * - Utilizado na PRManterProgramaTrabalho 
	 */
	public static final String ID_REQ_MetaNaoPrioritaria = "0000";
	
	/**
	 * - Tipo Parametros PLO
	 */
	public static final String PARAMETRO_INCLUSAO = "I";
	
	public static final String PARAMETRO_ALTERACAO = "A";
	
	public static final String DS_PARAMETRO_INCLUSAO = "Inclus�o";
	
	public static final String DS_PARAMETRO_ALTERACAO = "Altera��o";
	
	/**
	 * Vari�veis utilizadas em Consutlas e Componentes Web, para concatena��o em Strings
	 */
	public static final String STRING_VAZIA = "";
	public static final String PONTO = ".";
	public static final String VIRGULA_ESPACO_ESPACO = ",  ";
	public static final String VIRGULA = ",";
	public static final String NEW_LINE = "\n";
	public static final String ASPA = "\"";
	public static final String ASPA_SIMPLES = "'";
	public static final String TAB = "\t";
	public static final String TABULACAO = "	";
	public static final String TAG_SCRIPT_ABERTURA = " <SCRIPT> ";
	public static final String LANGUAGE = " language ";
	public static final String TAG_SCRIPT_FECHAMENTO = " </SCRIPT> ";
	
	public static final String CD_PLO_SIM = Constantes.CD_VERDADEIRO;
	public static final String CD_PLO_NAO = Constantes.CD_FALSO;
	public static final String DS_PLO_SIM = "Sim";
	public static final String DS_PLO_NAO = "N�o";
	
	public static final String NM_SERVLET_COMPONENTE_SUBACAO = "PRManterSubacaoCadastro";
	public static final String NM_SERVLET_COMPONENTE_ACAO = "PRManterAcaoCadastro";
	
	/**
	 * Painel Pactuacao Teto, chamada para o GPO.
	 */ 
	public static final String NM_SERVLET_ELEMENTACAO = "PRManterElementacao";
	
	/**
	 * Constantes para serem usadas no Relat�rio de Publica��o de Cr�ditos Adicionais
	 * Indicam o ano da Revolu��o Republicana Constitucionalista e da Independ�ncia do Brasil respectivamente 
	 */
	public static final int  ANO_REVOLUCAO_REPUBLICANA = 1816;
	public static final int  ANO_INDEPENDENCIA_BRASIL = 1821;
	public static final String PAIS_BRASIL = "Brasil";
	public static final String PRIMEIRO_DIA_MES = "1";
	
	public static final String NATUREZA_DESPESA_POSSUI_VALOR = "PossuiValor";
	public static final String VALOR_NATUREZA_RECEITA = "ValorNaturezaReceita";
	
	public static final String ID_REQ_MENU_SCA_CD_MENU = "cd_menu";
	
	/**
	 * C�digos de Job's
	 */
	public static final Integer CD_SCRIPT_JOB_EXECUCAO_ORCAMENTARIA_ACOES_UG = Integer.valueOf(28000);
	public static final Integer CD_SCRIPT_JOB_EXPORTACAO_CICLO_EXTRAORDINARIO = Integer.valueOf(28016);
	
	/**
	 * Tipo da Unidade Gestora
	 */
	public static final String CD_OPCAO_COORDENADORA = "C";
	
	/**
	 * Constantes para serem usadas na PRManterPeriodoUsoCicloExtra
	 */ 
	public static final String OPERACAO_INCLUSAO = "Inclusao";
	public static final String OPERACAO_ALTERACAO = "Alteracao";
	public static final String OPERACAO_CONSULTA = "Consulta";
	public static final String OPERACAO_INCLUSAO_UNIDADE_GESTORA = "InclusaoUnidadeGestora";
	public static final String OPERACAO_EXCLUSAO_UNIDADE_GESTORA = "ExclusaoUnidadeGestora";
	
	/**
	 * Constante usada para a Formata��o de Data-Hora nos Jobs
	 */
	public static final String FORMATO_DATA_HORA_JOBS_YYYY_M_MDD_H_HMM = "yyyyMMddHHmm";
	
	/**
	 * Utilizado para Conta Patrimonial na Natureza da Receita
	 */
	
	public static final String CD_PLO_NUNCA = "NC";
	public static final String DS_PLO_NUNCA = "Nunca";
	
	/**
	 *  Constantes que identificam o N�vel da natureza
	 */
	public static final String CD_NATUREZA_RECEITA_SEM_PAI				= "00000000";
	public static final String NATUREZA_RECEITA_ZEROS_DIREITA_NIVEL_1	= "0000000";
	public static final String NATUREZA_RECEITA_ZEROS_DIREITA_NIVEL_2	= "000000";
	public static final String NATUREZA_RECEITA_ZEROS_DIREITA_NIVEL_3	= "00000";
	public static final String NATUREZA_RECEITA_ZEROS_DIREITA_NIVEL_4	= "0000";
	public static final String NATUREZA_RECEITA_ZEROS_DIREITA_NIVEL_5	= "000";
	public static final String NATUREZA_RECEITA_ZEROS_DIREITA_NIVEL_6	= "00";
	public static final String NATUREZA_RECEITA_ZEROS_DIREITA_NIVEL_7	= "0";
	
	/**
	 * Constantes que descrevem tipos de opera��o
	 */
	public static final String DS_OPERACAO = "Operacao";
	public static final String DS_OPERACAO_RESUMO = "OperacaoResumo";
	public static final String DS_OPERACAO_INCLUSAO = "OperacaoInclusao";
	public static final String DS_OPERACAO_CONSULTA = "OperacaoConsulta";
	public static final String DS_OPERACAO_ANALISAR = "OperacaoAnalisar";
	public static final String DS_OPERACAO_EXCLUSAO = "OperacaoExclusao";
	public static final String DS_OPERACAO_ALTERACAO = "OperacaoAlteracao";
	public static final String DS_OPERACAO_DETALHAMENTO = "OperacaoDetalhamento";
	public static final String DS_OPERACAO_ENCAMINHAMENTO = "OperacaoEncaminhamento";
	public static final String DS_OPERACAO_ENCAMINHAMENTO_ANALISE_SEPLAG_SEPO = "OperacaoEncaminhamentoAnaliseSeplagSepo";
	public static final String DS_OPERACAO_ENCAMINHAMENTO_ANALISE_SECRETARIO_SEPLAG = "OperacaoEncaminhamentoAnaliseSecretarioSeplag";
	public static final String DS_OPERACAO_TRATAR_REJEICAO = "OperacaoTratarRejeicao";
	public static final String DS_OPERACAO_PREENCHIMENTO_MODALIDADE = "OperacaoPreenchimentoModalidade";
	
	public static final String DS_ANALISAR_SOLICITACAO_CICLO_EXTRAORDINARIO = "An�lise de Solicita��o - Ciclo Extraordin�rio";
	public static final String DS_ANALISAR_SOLICITACAO_SEPLAG_SEPO = "An�lise de Solicita��o - SEPLAG/SEPOC";
	public static final String DS_ANALISAR_SOLICITACAO_SECRETARIO_SEPLAG = "An�lise de Solicita��o - Secret�rio SEPLAG";
	public static final String DS_ANALISAR_SOLICITACAO_GESTOR_CENTRAL_GOE = "An�lise de Solicitac�o de Cr�dito Adicional Pelo Gestor Central GOE";
	
	public static final String ATIVO = " 'Ativo' ";
	public static final String INATIVO = " 'Inativo' ";
	public static final String QUEBRA_LINHA = "\n";
	
	public static final String OR = " OR ";
	public static final String IS_NULL = " IS NULL ";
	public static final String AND = " AND ";
	public static final String MENOR_IGUAL = " <= ";
	public static final String MAIOR_IGUAL = " >= ";
	public static final String AND_QUEBRA_LINHA = " AND " + QUEBRA_LINHA;
	public static final String FROM = " FROM ";
	public static final String TRUE = "TRUE";
	public static final String FALSE = "FALSE";
	public static final String LIKE = " LIKE ";
	public static final String ORDER_BY = " ORDER BY ";
	public static final String WHERE = " WHERE ";
	public static final String AS = " AS ";
	public static final String IN = " IN ";
	public static final String NULL = " NULL ";
	public static final String NOT = " NOT ";
	public static final String IS = " IS ";
	public static final String DISTINCT = " DISTINCT ";
	public static final String SELECT = " SELECT ";
	public static final String DELETE = " DELETE ";
	public static final String ON = " ON ";
	public static final String LEFT_JOIN = " LEFT JOIN ";
	public static final String JOIN = " JOIN ";
	
	public static final String UNDERLINE = "_";
	public static final String ASPA_ESPACO = "\" ";
	public static final String ATRIBUTO_ID = " id=\"";
	public static final String TAG_FECHAMENTO = " />";
	public static final String TAG_ABERTURA_INPUT = "<INPUT ";
	public static final String ATRIBUTO_TYPE = "type=\"";
	public static final String READ_ONLY = " readonly ";
	public static final String ATRIBUTO_VALUE = " value=\"";
	public static final String ATRIBUTO_SIZE = " size=\"";
	public static final String ATRIBUTO_MAX_LENGTH = " maxLength=\"";
	public static final String ATRIBUTO_CLASS = " class=\"";
	public static final String ATRIBUTO_NAME = " name=\"";
	public static final String CLASS_CAMPO_READ_ONLY = " camporeadonly ";
	public static final String TEXT = "text";
	public static final String HIDDEN = "hidden";
	public static final String READONLY = " readonly ";
	public static final String CLASS_CAMPO_OBRIGATORIO = " class='campoobrigatorio' ";
	public static final String CLASS_CAMPO_NAO_OBRIGATORIO = " class='camponaoobrigatorio' ";
	public static final String CLASS_CAMPO_READONLY = " class='camporeadonly' ";
	
	/**
	 * Identificador para o Nome do Identificador da Natureza de Despesa. Ex.: Ficha Financeira
	 */
	public static final String ID_REQ_NmIdentificadorNaturezaDespesa = "NmIdentificadorNaturezaDespesa";
	
	/**
	 * Identificador para defini��o: SelectTipoDetalhamentoFonteRecurso
	 */
	public static final String ID_REQ_FONTERECURSO_VIGENCIA = "FonteRecursoVigencia";
	public static final String ID_REQ_FONTERECURSO_DETALHAMENTO = "FonteRecursoDetalhamento";
	
	public static final String NM_COL_SITUACAO = "SITUACAO_IN_ATIVACAO";
	public static final String NM_COL_TP_CATEGORIA_NATUREZA_RECEITA = "TP_CATEGORIA_NATUREZA_RECEITA";
	
	/**
	 * Constantes utilizadas por Outros Sistemas
	 */
	// Utilizada no CTB
	public static final int CD_MSGALERTUSR_CELULA_ORCAMENTARIA_JA_SELECIONADA = 83;
	
	public static final String ID_REQ_SESSAO_OPCAO_SELECT_GESTAO = "ID_REQ_SESSAO_OPCAO_SELECT_GESTAO";
	
	public static final String TIPO_UNIDADE_GESTORA_COORDENADORA = "C";
	public static final String TIPO_UNIDADE_GESTORA_EXECUTORA = "E";
	
	/**
	 * -
	 */
	public static final String NATUREZA_RECEITA_IN_CATEGORIA_RECEITAS_CORRENTES = "1";
	public static final String NATUREZA_RECEITA_IN_CATEGORIA_RECEITAS_CAPITAL = "2";
	public static final String NATUREZA_RECEITA_IN_CATEGORIA_RECEITAS_REDUTORA = "9";
	
}