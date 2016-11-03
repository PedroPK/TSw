/*
 * Este arquivo é propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informação nele contida pode ser
 * reproduzida, mostrada ou revelada sem permissão escrita da Sefaz-PE.
 */
package tsw.t06;

/**
 * 
 */
public class ConstantesPLOServico05 extends ConstantesPLO {
	
	/**
	 * - Códigos identificadores dos tipos de solicitações; usados na PRDirecionarAnaliseCreditoAdicional 
	 */
	public static final String CD_TELA_ANALISE_TITULAR_ORGAO_SOLICITANTE = "01";
	public static final String CD_TELA_ANALISE_SECRETARIO_ESTADO_SOLICITANTE = "02";
	public static final String CD_TELA_ANALISE_TITULAR_ORGAO_CEDENTE = "03";
	public static final String CD_TELA_ANALISE_SECRETARIO_ESTADO_CEDENTE = "04";
	public static final String CD_TELA_ANALISE_SECRETARIO_ESTADO_SEPLAG = "05";
	public static final String CD_TELA_ANALISE_CONTROLADORIA = "06";
	public static final String CD_TELA_ANALISE_SEPLAG_SEPO = "07";
	
	/**
	 * - Códigos identificadores dos casos de uso de Análise de Solicitação de Remanejamento Orçamentário; 
	 */
	public static final String NM_SERVLET_ANALISE_SOLIC_REMANEJAMENTO_GESTOR_CENTRAL = "08";
	public static final String NM_SERVLET_ANALISE_SOLIC_REMANEJAMENTO_SEPLAG_SEPO = "09";
	public static final String NM_SERVLET_ANALISE_SOLIC_REMANEJAMENTO_SECRETARIO_SEPLAG = "PRManterAnaliseSolicRemanCreditoSecretarioSeplag";
	
	/**
	 * - Nome da Servlet de Solicitação de Crédito Adicional, utilizada por componentes Web.
	 */
	public static final String NM_SERVLET_PR_MANTER_SOLICITACAO_CREDITO_ADICIONAL = "PRManterSolicitacaoCreditoAdicional";
	
	/**
	 * Data que representa o início do uso de rtf para o tipo de publicação Lei, essa data vai ser usada
	 * para efeito de comparação, onde se a data de encaminhento de publicação for menor que ela, o anexo será aberto
	 * como pdf, caso contrário será aberto como rtf. 
	 */
	public static final String DATA_REFERENCIA_RTF_PUBLICACAO_LEI = "18/06/2009";
	
	/**
	 * - Descrições das Telas usadas pela PRDirecionarAnaliseCreditoAdicional
	 */
	public static final String DESC_TELA_ANALISE_TITULAR_ORGAO_SOLICITANTE = "Titular Orgão Solicitante";	
	public static final String DESC_TELA_ANALISE_SECRETARIO_ESTADO_SOLICITANTE = "Secretário Estado Solicitante";
	public static final String DESC_TELA_ANALISE_TITULAR_ORGAO_CEDENTE = "Titular Orgão Cedente";
	public static final String DESC_TELA_ANALISE_SECRETARIO_ESTADO_CEDENTE = "Secretário Estado Cedente";
	public static final String DESC_TELA_ANALISE_SECRETARIO_ESTADO_SEPLAG = "Secretário de Estado - SEPLAG";
	public static final String DESC_TELA_ANALISE_CONTROLADORIA = "Controladoria";
	public static final String DESC_TELA_ANALISE_SEPLAG_SEPO = "SEPLAG/SEPO";
	
	/**
	 * - Nomes das Telas usadas pelos casos de uso de Análise de Solicitação de Remanejamento
	 */
	public static final String NM_TELA_ANALISE_SOLIC_REMAN_GESTOR_CENTRAL = "Gestor Central";
	public static final String NM_TELA_ANALISE_SOLIC_REMAN_SEPLAG_SEPO = "SEPLAG / SEPO";
	public static final String NM_TELA_ANALISE_SOLIC_REMAN_SECRETARIO_SEPLAG = DESC_TELA_ANALISE_SECRETARIO_ESTADO_SEPLAG;
	public static final String NM_TELA_EFETIVACAO_SOLIC_REMAN_SEPLAG_SEPO = "Efetivação de Solicitação de Remanejamento";
	
	/**
	 * - Códigos de Situação para Solicitações de Crédito Adicional
	 */
	public static final Short CD_SITUACAO_SOLIC_EM_ELABORACAO = UM_SHORT;
	public static final Short CD_SITUACAO_SOLIC_CRED_ADIC_ENCAMINHADO_PARA_UGC_CEDENTE = DOIS_SHORT;
	public static final Short CD_SITUACAO_SOLIC_CRED_ADIC_REJEITADO_PELA_UGC_CEDENTE = TRES_SHORT;
	public static final Short CD_SITUACAO_SOLIC_CRED_ADIC_ENCAMINHADO_PARA_ANALISE_TITULAR_ORGAO_SOLICITANTE = QUATRO_SHORT;
	public static final Short CD_SITUACAO_SOLIC_CRED_ADIC_APROVADO_TITULAR_ORGAO_SOLICITANTE = CINCO_SHORT;
	public static final Short CD_SITUACAO_SOLIC_ENCAMINHADO_PARA_ANALISE_SEPLAG_GESTOR_CENTRAL_GOE = SEIS_SHORT; // TODO Uma das possibilidades para encaminhar para a Análise da Seplag/SEPO
	public static final Short CD_SITUACAO_SOLIC_REJEITADO_PELA_SEPLAG_GESTOR_CENTRAL_GOE = SETE_SHORT;
	public static final Short CD_SITUACAO_SOLIC_CRED_ADIC_ENCAMINHADO_PARA_PUBLICACAO = OITO_SHORT;
	public static final Short CD_SITUACAO_SOLIC_CRED_ADIC_REJEITADO_PELO_TITULAR_ORGAO_SOLICITANTE = NOVE_SHORT;
	public static final Short CD_SITUACAO_SOLIC_APROVADO_TOTAL_SEPLAG_GESTOR_CENTRAL_GOE = ONZE_SHORT;
	public static final Short CD_SITUACAO_SOLIC_CRED_ADIC_PUBLICADO = DOZE_SHORT;
	public static final Short CD_SITUACAO_SOLIC_CRED_ADIC_ENCAMINHADO_PARA_ANALISE_SECRETARIO_SOLICITANTE = TREZE_SHORT;
	public static final Short CD_SITUACAO_SOLIC_CRED_ADIC_APROVADO_PELO_SECRETARIO_SOLICITANTE = CATORZE_SHORT;
	public static final Short CD_SITUACAO_SOLIC_CRED_ADIC_REJEITADO_PELO_SECRETARIO_SOLICITANTE = QUINZE_SHORT;
	public static final Short CD_SITUACAO_SOLIC_CRED_ADIC_APROVADO_PELA_UGC_CEDENTE = DEZESSEIS_SHORT;
	public static final Short CD_SITUACAO_SOLIC_CRED_ADIC_ENCAMINHADO_PARA_ANALISE_TITULAR_ORGAO_CEDENTE = DEZESSETE_SHORT;
	public static final Short CD_SITUACAO_SOLIC_CRED_ADIC_APROVADO_PELO_TITULAR_ORGAO_CEDENTE = DEZOITO_SHORT;
	public static final Short CD_SITUACAO_SOLIC_CRED_ADIC_REJEITADO_PELO_TITULAR_ORGAO_CEDENTE = DEZENOVE_SHORT;
	public static final Short CD_SITUACAO_SOLIC_CRED_ADIC_ENCAMINHADO_PARA_ANALISE_SECRETARIO_CEDENTE = VINTE_SHORT;
	public static final Short CD_SITUACAO_SOLIC_CRED_ADIC_APROVADO_PELO_SECRETARIO_CEDENTE = VINTE_UM_SHORT;
	public static final Short CD_SITUACAO_SOLIC_CRED_ADIC_REJEITADO_PELO_SECRETARIO_CEDENTE = VINTE_DOIS_SHORT;
	public static final Short CD_SITUACAO_SOLIC_ENCAMINHADO_PARA_ANALISE_SECRETARIO_SEPLAG = VINTE_TRES_SHORT;
	public static final Short CD_SITUACAO_SOLIC_ADIC_APROVADO_PELO_SECRETARIO_SEPLAG = VINTE_QUATRO_SHORT;
	public static final Short CD_SITUACAO_SOLIC_REJEITADO_PELO_SECRETARIO_SEPLAG = VINTE_CINCO_SHORT;
	public static final Short CD_SITUACAO_SOLIC_ENCAMINHADO_PARA_ANALISE_SEPLAG_SEPOC = VINTE_SETE_SHORT;
	public static final Short CD_SITUACAO_SOLIC_APROVADO_PELA_SEPLAG_SEPOC = VINTE_OITO_SHORT;
	public static final Short CD_SITUACAO_SOLIC_REJEITADO_PELA_SEPLAG_SEPO = VINTE_NOVE_SHORT;
	public static final Short CD_SITUACAO_SOLIC_CRED_ADIC_ENCAMINHADO_PARA_ANALISE_CONTROLADORIA = TRINTA_SHORT;
	public static final Short CD_SITUACAO_SOLIC_CRED_ADIC_APROVADO_PELA_CONTROLADORIA = TRINTA_UM_SHORT;
	public static final Short CD_SITUACAO_SOLIC_CRED_ADIC_REJEITADO_PELA_CONTROLADORIA = TRINTA_DOIS_SHORT;
	public static final Short CD_SITUACAO_SOLIC_CRED_ADIC_REJEITADA_NA_PUBLICACAO = TRINTA_TRES_SHORT;
	public static final Short CD_SITUACAO_SOLIC_CRED_ADIC_APROVADO_RESTRICAO_GESTOR_CENTRAL = TRINTA_QUATRO_SHORT;
	public static final Short CD_SITUACAO_SOLIC_NAO_APROVADO_GESTOR_CENTRAL = TRINTA_CINCO_SHORT;
	public static final Short CD_SITUACAO_SOLIC_REENCAMINHADA_GESTOR_CENTRAL = TRINTA_SEIS_SHORT;
	public static final Short CD_SITUACAO_SOLIC_MODALIDADE_APLICACAO_INFORMADA = TRINTA_SETE_SHORT;
	public static final Short CD_SITUACAO_SOLIC_PARCIALMENTE_OPERACIONALIZADO = TRINTA_NOVE_SHORT;
	public static final Short CD_SITUACAO_SOLIC_TOTALMENTE_OPERACIONALIZADO = QUARENTA_SHORT;
	
	public static final String CD_SITUACAO_SOLIC_CICLO_EXTRAORDINARIO_PARECER_ELABORADO = "PE";
	public static final String CD_SITUACAO_SOLIC_CICLO_EXTRAORDINARIO_PARECER_APROVADO_SEPLAG_SEPO = "PA";
	
	public static final String CD_TP_PARCIALMENTE_OPERACIONALIZADA = "P";
	public static final String CD_TP_TOTALMENTE_OPERACIONALIZADA = "T";
	 
	public static final String DS_SITUACAO_SOLIC_PARCIALMENTE_OPERACIONALIZADO 							= "Operacionalizado Parcialmente";
	public static final String DS_SITUACAO_SOLIC_TOTALMENTE_OPERACIONALIZADO 							= "Operacionalizado Totalmente";
	public static final String DS_SITUACAO_SOLIC_OPERACIONALIZACAO_MODALIDADE_DE_APLICACAO_INFORMADA 	= "Modalidade(s) de Aplicação informada(s)";
	public static final String DS_SITUACAO_SOLIC_OPERACIONALIZACAO_MODALIDADE_DE_APLICACAO_PENDENTE 	= "Modalidade de Aplicação Pendente";
	public static final String DS_SITUACAO_SOLIC_OPERACIONALIZACAO_NAO_SE_APLICA 						= "Não se Aplica";
	
	/**
	 * - Descrições de Situação para Ciclo Extraordinário
	 */
	public static final String DS_SITUACAO_SOLIC_CICLO_EXTRAORDINARIO_PARECER_ELABORADO = "Parecer em análise";
	public static final String DS_SITUACAO_SOLIC_CICLO_EXTRAORDINARIO_PARECER_APROVADO_SECRETARIO_SEPLAG = "Parecer Aprovado pelo Secretário SEPLAG";
	public static final String DS_SITUACAO_SOLIC_CICLO_EXTRAORDINARIO_PARECER_REENCAMINHADA_GESTOR_CENTRAL = "Parecer Reencaminhado para o Gestor Central";
	
	public static final String DS_SITUACAO_SOLIC_CICLO_EXTRAORDINARIO_PARECER_APROVADO_SEPLAG_SEPO = "Parecer Aprovado pela SEPLAG/SEPOC";
	public static final String DS_SITUACAO_SOLIC_CICLO_EXTRAORDINARIO_PARECER_APROVADO_SEPLAG_SEPO_ANALISE = "Parecer Aprovado pela SEPLAG/SEPOC (Em análise pelo Secretário SEPLAG)";
	
	/**
	 * - Descrições de Situação para Solicitações de Crédito Adicional
	 */
	public static final String DS_SITUACAO_SOLIC_CICLO_EXTRAORDINARIO_PARECER_APROVADO_TOTAL_SEPLAG_GESTOR_CENTRAL_GOE = "Aprovado pelo Gestor Central (Parecer em análise pela SEPLAG/SEPOC)";
	public static final String DS_SITUACAO_SOLIC_APROVADO_TOTAL_SEPLAG_GESTOR_CENTRAL_GOE = "Aprovada Total pelo Gestor Central";
	public static final String DS_SITUACAO_SOLIC_APROVADO_PELA_SEPLAG_SEPO = "Aprovada pela SEPLAG/SEPO";
	public static final String DS_SITUACAO_SOLIC_APROVADO_PELO_SECRETARIO_SEPLAG = "Aprovada pelo Secretário SEPLAG";
	
	public static final String DS_SITUACAO_SOLICITACAO_CICLO_EXTRAORDINARIO_APROVADO_GESTOR_CENTRAL_GOE					= "Aprovado pelo Gestor Central (Parecer em análise pela SEPLAG/SEPOC)";
	public static final String DS_SITUACAO_SOLICITACAO_CICLO_EXTRAORDINARIO_APROVADO_ALTERACAO_GESTOR_CENTRAL_ANALISE	= "Aprovado pelo Gestor Central com Alteração (Parecer em análise pela SEPLAG/SEPOC)";
	public static final String DS_SITUACAO_SOLICITACAO_CICLO_EXTRAORDINARIO_NAO_APROVADO_GESTOR_CENTRAL_ANALISE			= "Solicitação não aprovada (Parecer em análise pela SEPLAG/SEPOC)";
	
	public static final String DS_SITUACAO_SOLICITACAO_CICLO_EXTRAORDINARIO_NAO_APROVADA_GESTOR_CENTRAL_ANALISE			= "Solicitação não aprovada";
	
	public static final String DS_SITUACAO_SOLICITACAO_CICLO_EXTRAORDINARIO_APROVADO_ALTERACAO_GESTOR_CENTRAL = "Aprovado pelo Gestor Central com Alteração";
	public static final String DS_SITUACAO_SOLICITACAO_CICLO_EXTRAORDINARIO_NAO_APROVADO_GESTOR_CENTRAL = "Não Aprovado pelo Gestor Central";
	
	/**
	 * - Descrições do Dominio de Situação de Solicitação de Remanejamento de Crédito
	 */
	public static final String DS_SITUACAO_SOLIC_EM_ELABORACAO = "Em Elaboração";
	
	// Gestor Central - Orçamento
	public static final String DS_SITUACAO_SOLIC_ENCAMINHADO_ANALISE_GESTOR_CENTRAL_GOE = "Em Análise pelo Gestor Central";
	public static final String DS_SITUACAO_SOLIC_APROVADO_GESTOR_CENTRAL_GOE = "Aprovado pelo Gestor Central";
	public static final String DS_SITUACAO_SOLIC_REJEITADO_GESTOR_CENTRAL_GOE = "Rejeitado pelo Gestor Central";
	
	public static final String DS_SITUACAO_SOLIC_ENCAMINHADO_PUBLICACAO = "Encaminhada para Publicação";
	
	// Seplag / Sepo
	public static final String DS_SITUACAO_SOLIC_ENCAMINHADO_ANALISE_SEPLAG_SEPOC = "Em Análise pela SEPLAG/SEPOC";
	public static final String DS_SITUACAO_SOLIC_APROVADO_SEPLAG_SEPOC = "Aprovado pela SEPLAG/SEPOC";
	public static final String DS_SITUACAO_SOLIC_REJEITADO_SEPLAG_SEPOC = "Rejeitado pela SEPLAG/SEPOC";
	
	// Secretário Seplag
	public static final String DS_SITUACAO_SOLIC_ENCAMINHADO_ANALISE_SECRETARIO_SEPLAG = "Em Análise pelo Secretário SEPLAG";
	public static final String DS_SITUACAO_SOLIC_APROVADO_SECRETARIO_SEPLAG = "Aprovado pelo Secretário SEPLAG";
	public static final String DS_SITUACAO_SOLIC_REJEITADO_SECRETARIO_SEPLAG = "Rejeitado pelo Secretário SEPLAG";
	
	// Publicação
	public static final String DS_SITUACAO_SOLIC_REMAN_CONTABILIZADO = "Contabilizado";
	public static final String DS_SITUACAO_SOLIC_REJEITADO_PUBLICACAO = "Rejeitado na Publicação";
	public static final String DS_SITUACAO_PUBLICACAO_EM_CONFERENCIA = "Em Conferência";
	
	/**
	 * Constantes usadas na RNDirecionarAnaliseCreditoAdicional
	 */
	public static final String ID_REQ_Nm_TituloTela = "NmTituloTela";
	public static final String ID_REQ_CdIdentificadorTipoTela = "CdIdentificadorTipoTela";
	public static final String ID_REQ_InEncaminharGestorCentral = "InEncaminharGestorCentral";
	public static final String ID_REQ_hashParametros = "hashParametros";
	public static final String ID_REQ_CdUnidadeGestoraCedente = "cdUnidadeGestoraCedente";
	
	/**
	 * Constantes para o quadro de superávit
	 */
	public static final String ID_REQ_Total = "Total";
	
	/**
	 * - Código da Meta Prioritária a ser incluida em uma nova Meta Financeira, durante a Publicação de Créditos Adicionais.
	 */
	public static final String CD_META_PRIORITARIA_PARA_META_FINANCEIRA_DEFAULT_0000 = "0000";
	
	/**
	 * - Códigos com os tipos de crédito adicional
	 */
	public static final Short CD_TIPO_CREDITO_ADICIONAL_SUPLEMENTAR = UM_SHORT;
	public static final Short CD_TIPO_CREDITO_ADICIONAL_ESPECIAL = DOIS_SHORT;
	public static final Short CD_TIPO_CREDITO_ADICIONAL_EXTRAORDINARIO = TRES_SHORT;
	public static final Short CD_TIPO_CREDITO_ADICIONAL_REABERTURA_ESPECIAL = QUATRO_SHORT;
	public static final Short CD_TIPO_CREDITO_ADICIONAL_REABERTURA_EXTRAORDINARIO = CINCO_SHORT;

	/**
	 * - Códigos de Eventos de Contabilização
	 */
	public static final Integer EVENTO_DESBLOQUEIO_REJEICAO_DOTACAO_CREDITO_ESPECIAL		= Integer.valueOf("200045");
	public static final Integer EVENTO_DESBLOQUEIO_REJEICAO_DOTACAO_CREDITO_EXTRAORDINARIO	= Integer.valueOf("200046");
	public static final Integer EVENTO_BLOQUEIO_DOTACAO_CREDITO_EXTRAORDINARIO				= Integer.valueOf("200061");
	public static final Integer EVENTO_ANULACAO_DOTACAO_CREDITO_EXTRAORDINARIO				= Integer.valueOf("200062");
	
	public static final Integer EVENTO_PREVISAO_ADICIONAL_RECEITA_SE_HOUVER_CREDITO_ADICIONAL_POR_EXCESSO_ARRECADACAO	= Integer.valueOf("100011");
	public static final Integer EVENTO_ORIGEM_ANULACAO																	= Integer.valueOf("200042");
	
	public static final Integer EVENTO_DESBLOQUEIO_EXECUCAO_ORCAMENTARIA_VALOR_REMANEJAMENTO_CREDITO	= Integer.valueOf("205169");
	public static final Integer EVENTO_BLOQUEIO_EXECUCAO_ORCAMENTARIA_VALOR_REMANEJAMENTO_CREDITO		= Integer.valueOf("200169");
	public static final Integer EVENTO_REDUCAO_ORIGEM													= Integer.valueOf("200170");
	public static final Integer EVENTO_ACRESCIMO_DESTINO												= Integer.valueOf("200171");
	
	public static final Integer EVENTO_ORIGEM_ANULACAO_ABERTO_CREDITO_ESPECIAL											= Integer.valueOf("200052");
	public static final Integer EVENTO_DESTINO_CREDITO_EXTRAORDINARIO_REABERTO_EXERCICIO_ANULACAO_PROPRIA_OU_TERCEIRO	= Integer.valueOf("200054");
	public static final Integer EVENTO_DESTINO_CREDITO_EXTRAORDINARIO_EXERCICIO_ANULACAO_PROPRIA_OU_TERCEIRO			= Integer.valueOf("200055");
	public static final Integer EVENTO_DESTINO_CREDITO_ESPECIAL_REABERTO_EXERCICIO_ANULACAO_PROPRIA_OU_TERCEIRO			= Integer.valueOf("200041");
	public static final Integer EVENTO_DESTINO_CREDITO_ESPECIAL_ANULACAO_PROPRIA_OU_TERCEIRO							= Integer.valueOf("200038");
	public static final Integer EVENTO_DESTINO_CREDITO_SUPLEMENTAR_ANULACAO_PROPRIA_OU_TERCEIRO							= Integer.valueOf("200035");
	public static final Integer EVENTO_DESTINO_CREDITO_SUPLEMENTAR_PARA_ESPECIAL_ANULACAO_PROPRIA_OU_TERCEIRO			= Integer.valueOf("200060");
	
	/**********************************************************************************************************
	 * Eventos de Créditos Suplementares para as diferentes fontes de financiamento
	 **********************************************************************************************************/
	// DESTINO
	public static final Integer EVENTO_DESTINO_CREDITO_SUPLEMENTAR_EXCESSO_ARRECADACAO			= Integer.valueOf("200032");
	public static final Integer EVENTO_DESTINO_CREDITO_SUPLEMENTAR_SUPERAVIT_FINANCEIRO			= Integer.valueOf("200033");
	public static final Integer EVENTO_DESTINO_CREDITO_SUPLEMENTAR_OPERACAO_CREDITO				= Integer.valueOf("200036");
	public static final Integer EVENTO_DESTINO_CREDITO_SUPLEMENTAR_CONVENIO						= Integer.valueOf("200059");
	public static final Integer EVENTO_DESTINO_CREDITO_SUPLEMENTAR_REVOGACAO_RENUNCIA_RECEITA	= Integer.valueOf("200072");
	
	/**********************************************************************************************************
	 * Eventos de Créditos Suplementares para Especiais para as diferentes fontes de financiamento
	 **********************************************************************************************************/
	// DESTINO
	public static final Integer EVENTO_DESTINO_CREDITO_SUPLEMENTAR_PARA_ESPECIAL_EXCESSO_ARRECADACAO	= Integer.valueOf("200063");
	public static final Integer EVENTO_DESTINO_CREDITO_SUPLEMENTAR_PARA_ESPECIAL_SUPERAVIT_FINANCEIRO	= Integer.valueOf("200064");
	public static final Integer EVENTO_DESTINO_CREDITO_SUPLEMENTAR_PARA_ESPECIAL_OPERACAO_CREDITO_NOVA	= Integer.valueOf("200066");
	public static final Integer EVENTO_DESTINO_CREDITO_SUPLEMENTAR_PARA_ESPECIAL_CONVENIO_NOVO			= Integer.valueOf("200067");
	
	/**********************************************************************************************************
	 * Eventos de Créditos Especiais para as diferentes fontes de financiamento
	 **********************************************************************************************************/
	// DESTINO
	public static final Integer EVENTO_DESTINO_CREDITO_ESPECIAL_EXCESSO_ARRECADACAO			= Integer.valueOf("200040");
	public static final Integer EVENTO_DESTINO_CREDITO_ESPECIAL_SUPERAVIT_FINANCEIRO		= Integer.valueOf("200037");
	public static final Integer EVENTO_DESTINO_CREDITO_ESPECIAL_OPERACAO_CREDITO_NOVA		= Integer.valueOf("200039");
	public static final Integer EVENTO_DESTINO_CREDITO_ESPECIAL_CONVENIO_NOVO				= Integer.valueOf("200074");
	public static final Integer EVENTO_DESTINO_CREDITO_ESPECIAL_REVOGACAO_RENUNCIA_RECEITA	= Integer.valueOf("200073");
	
	/**********************************************************************************************************
	 * Eventos de Créditos Especiais reabertos no exercício para as diferentes fontes de financiamento
	 **********************************************************************************************************/
	// DESTINO
	public static final Integer EVENTO_DESTINO_CREDITO_ESPECIAL_REABERTO_EXERCICIO_EXCESSO_ARRECADACAO	= Integer.valueOf("200069");
	public static final Integer EVENTO_DESTINO_CREDITO_ESPECIAL_REABERTO_EXERCICIO_SUPERAVIT_FINANCEIRO	= Integer.valueOf("200044");
	
	/**********************************************************************************************************
	 * Eventos de Créditos Extraordinários
	 **********************************************************************************************************/
	// DESTINO
	public static final Integer EVENTO_DESTINO_CREDITO_EXTRAORDINARIO_EXERCICIO_EXCESSO_ARRECADACAO		= Integer.valueOf("200058");
	public static final Integer EVENTO_DESTINO_CREDITO_EXTRAORDINARIO_EXERCICIO_SUPERAVIT_FINANCEIRO	= Integer.valueOf("200053");
	public static final Integer EVENTO_DESTINO_CREDITO_EXTRAORDINARIO_CONVENIO_NOVO						= Integer.valueOf("200056");
	
	/**********************************************************************************************************
	 *Eventos de Créditos Extraordinários Reaberto
	 **********************************************************************************************************/
	// DESTINO
	public static final Integer EVENTO_DESTINO_CREDITO_EXTRAORDINARIO_REABERTO_CONVENIO_NOVO = Integer.valueOf("200057");
	
	/**
	 * - Eventos de bloqueio e desbloqueio de crédito adicional
	 */
	public static final Integer EVENTO_DESBLOQUEIO_DOTACAO_INICIAL										= Integer.valueOf("200043");
	public static final Integer EVENTO_BLOQUEIO_DOTACAO_INICIAL											= Integer.valueOf("200050");
	public static final Integer EVENTO_BLOQUEIO_DOTACAO_CRIADA_A_PARTIR_DE_CREDITO_ESPECIAL_INTEGER		= Integer.valueOf("200051");
	public static final Integer EVENTO_DESBLOQUEIO_DOTACAO_CRIADA_A_PARTIR_DE_CREDITO_ESPECIAL_INTEGER	= Integer.valueOf("200045");
	
	/**
	 * - Fim dos Eventos de Contabilização
	 */
	
	/**
	 * -
	 */
	public static final String CD_TIPO_SOLICITACAO_CREDITO_ADICIONAL_CENTRALIZADA = ConstantesPLOServico05.CD_TIPO_SOLICITACAO_REMANEJAMENTO_CREDITO_CENTRALIZADA;
	public static final String CD_TIPO_SOLICITACAO_CREDITO_ADICIONAL_NAO_CENTRALIZADA = ConstantesPLOServico05.CD_TIPO_SOLICITACAO_REMANEJAMENTO_CREDITO_NAO_CENTRALIZADA;
	
	public static final String CD_INDICADOR_SOLICITACAO_CREDITO_ADICIONAL_RETROATIVA = ConstantesPLOServico05.CD_VERDADEIRO;
	public static final String CD_INDICADOR_SOLICITACAO_CREDITO_ADICIONAL_NAO_RETROATIVA = ConstantesPLOServico05.CD_FALSO;
	
	/**
	 * - Códigos das Situações possíveis de uma Solicitação de Anulação de Dotação de Terceiro
	 */
	public static final String CD_SITUACAO_SOLICITACAO_TERCEIRO_ENCAMINHADO_ANALISE = "E";
	public static final String CD_SITUACAO_SOLICITACAO_TERCEIRO_ACEITA = "A";
	public static final String CD_SITUACAO_SOLICITACAO_TERCEIRO_REJEITADA = "R";
	public static final String CD_SITUACAO_SOLICITACAO_TERCEIRO_CANCELADA = "C";
	public static final String CD_SITUACAO_SOLICITACAO_TERCEIRO_ACEITA_TITULAR_ORGAO_CEDENTE = "T";
	public static final String CD_SITUACAO_SOLICITACAO_TERCEIRO_ACEITA_SECRETARIO_CEDENTE = "S";
	
	/**
	 * - Descrições das Situações possíveis de uma Solicitação de Anulação de Dotação de Terceiro
	 */
	public static final String DS_SITUACAO_SOLICITACAO_TERCEIRO_ENCAMINHADO_ANALISE = "Encaminhada para Análise";
	public static final String DS_SITUACAO_SOLICITACAO_TERCEIRO_ACEITA = "Aceita";
	public static final String DS_SITUACAO_SOLICITACAO_TERCEIRO_REJEITADA = "Rejeitada";
	public static final String DS_SITUACAO_SOLICITACAO_TERCEIRO_CANCELADA = "Cancelada";
	public static final String DS_SITUACAO_SOLICITACAO_TERCEIRO_ACEITA_TITULAR_ORGAO_CEDENTE = "Aceita Pelo Titular Órgão Cedente";
	public static final String DS_SITUACAO_SOLICITACAO_TERCEIRO_ACEITA_SECRETARIO_CEDENTE = "Aceita Pelo Secretário Cedente";
	
	/**
	 * - Códigos dos tipos de fontes de financiamento
	 */
	public static final Short CD_TIPO_FONTE_FINANC_ANULACAO_DOTACOES_PROPRIAS	= UM_SHORT;
	public static final Short CD_TIPO_FONTE_FINANC_ANULACAO_DOTACOES_TERCEIROS	= DOIS_SHORT;
	public static final Short CD_TIPO_FONTE_FINANC_SUPERAVIT_FINANCEIRO			= TRES_SHORT;
	public static final Short CD_TIPO_FONTE_FINANC_EXCESSO_ARRECADACAO			= QUATRO_SHORT;
	public static final Short CD_TIPO_FONTE_FINANC_OPERACAO_DE_CREDITO			= CINCO_SHORT;
	public static final Short CD_TIPO_FONTE_FINANC_CONVENIO						= SEIS_SHORT;
	public static final Short CD_TIPO_FONTE_FINANC_REVOGACAO_RENUNCIA_RECEITA	= SETE_SHORT;
	public static final Short CD_TIPO_FONTE_FINANC_CESSAO_EXCESSO_ARRECADACAO	= OITO_SHORT;
	public static final Short CD_TIPO_FONTE_FINANC_CESSAO_SUPERAVIT_FINANCEIRO	= NOVE_SHORT;
	/**
	 * - Constante para o novo tipo de Fonte de Financiamento: Cessão de Excesso do Tesouro
	 */
	public static final Short CD_TIPO_FONTE_FINANC_CESSAO_EXCESSO_TESOURO = DEZ_SHORT;
	/**
	 * - Constante para o novo tipo de Fonte de Financiamento: Cessão de Superávit do Tesouro
	 */
	public static final Short CD_TIPO_FONTE_FINANC_CESSAO_SUPERAVIT_TESOURO =  ONZE_SHORT;
	
	/**
	 * - Texto a ser passado para o VO de Solicitação de Crédito Adicional Situação no caso de Retroceder esta solicitação
	 */
	public static final String TEXTO_PARECER_SOLIC_CRED_ADIC_SITUACAO_CONFIRMAR_RETROCEDER = "Ao retroceder esta solicitação, a mesma foi rejeitada (parcialmente aprovada com fontes de financiamento de Anulação de Dotação Própria ou de Terceiros).";
	
	/**
	 * - Nome do Arquivo de relatório de Publicação de Créditos Adicionais
	 */
	public static final String NOME_ARQUIVO_RELATORIO_PUBLICACAO_CREDITOS_ADICIONAIS = "RelatorioPublicacaoCreditosAdicionais.";
	
	/**
	 * - Codigos para as Descrições no Dominio de Situação de Solicitação de Remanejamento de Crédito
	 */
	public static final Short CD_SITUACAO_SOLIC_REMAN_EM_SOLICITACAO = UM_SHORT;
	// Análise do Gestor Central
	public static final Short CD_SITUACAO_SOLIC_REMAN_ENCAMINHADO_ANALISE_GESTOR_CENTRAL_ORCAMENTO = SEIS_SHORT;
	public static final Short CD_SITUACAO_SOLIC_REMAN_REJEITADO_GESTOR_CENTRAL_ORCAMENTO = SETE_SHORT;
	public static final Short CD_SITUACAO_SOLIC_REMAN_APROVADO_GESTOR_CENTRAL_ORCAMENTO = ONZE_SHORT;
	// Análise da Seplag / Sepo
	public static final Short CD_SITUACAO_SOLIC_REMAN_ENCAMINHADO_ANALISE_SEPLAG_SEPO = VINTE_SETE_SHORT;
	public static final Short CD_SITUACAO_SOLIC_REMAN_APROVADO_SEPLAG_SEPO = VINTE_OITO_SHORT;
	public static final Short CD_SITUACAO_SOLIC_REMAN_REJEITADO_SEPLAG_SEPO = VINTE_NOVE_SHORT;
	// Análise do Secretário Seplag
	public static final Short CD_SITUACAO_SOLIC_REMAN_ENCAMINHADO_ANALISE_SECRETARIO_SEPLAG = VINTE_TRES_SHORT;
	public static final Short CD_SITUACAO_SOLIC_REMAN_APROVADO_SECRETARIO_SEPLAG = VINTE_QUATRO_SHORT;
	public static final Short CD_SITUACAO_SOLIC_REMAN_REJEITADO_SECRETARIO_SEPLAG = VINTE_CINCO_SHORT;
	
	// Publicação
	public static final Short CD_SITUACAO_SOLIC_REMAN_ENCAMINHADO_PUBLICACAO = OITO_SHORT;
	public static final Short CD_SITUACAO_SOLIC_REMAN_REJEITADO_PUBLICACAO = TRINTA_TRES_SHORT;
	public static final Short CD_SITUACAO_SOLIC_REMAN_PUBLICADO = DOZE_SHORT;
	
	/**
	 * -
	 */
	public static final String DS_JUSTIFICATIVA_SOLICITACAO_CENTRALIZADA_APROVADA = "Solicitação centralizada aprovada";

	/**
	 * -
	 */
	public static final String CD_TIPO_SOLICITACAO_REMANEJAMENTO_CREDITO_CENTRALIZADA = "C";
	public static final String CD_TIPO_SOLICITACAO_REMANEJAMENTO_CREDITO_NAO_CENTRALIZADA = "N";
	
	/**
	 * -
	 */
	public static final String DS_TIPO_SOLICITACAO_REMANEJAMENTO_CREDITO_CENTRALIZADA = "Centralizada";
	public static final String DS_TIPO_SOLICITACAO_REMANEJAMENTO_CREDITO_NAO_CENTRALIZADA = "Não Centralizada";
	
	/**
	 * - Status para restricoes de limite de credito suplementar
	 */
	public static final String CD_TIPO_RESTRICAO_LIMITE_CRED_SUPL_REJEITAR = "R";
	public static final String CD_TIPO_RESTRICAO_LIMITE_CRED_SUPL_ACATAR = "A";
	public static final String CD_TIPO_PUBLICACAO_CREDITO_ADICIONAL_LEI = "L";
	public static final String CD_TIPO_PUBLICACAO_CREDITO_ADICIONAL_DECRETO = "D";	
	
	/**
	 * - Tipos de Publicação de Créditos Adicionais
	 */
	public static final String DS_TIPO_PUBLICACAO_CREDITO_ADICIONAL_LEI = "Lei";
	public static final String DS_TIPO_PUBLICACAO_CREDITO_ADICIONAL_DECRETO = "Decreto";
	public static final String DS_TIPO_SOLICITACAO_CREDITO_ADICIONAL_SUPLEMENTAR = "Suplementar";
	public static final String DS_TIPO_SOLICITACAO_CREDITO_ADICIONAL_ESPECIAL = "Especial";
	public static final String DS_TIPO_SOLICITACAO_CREDITO_ADICIONAL_EXTRAORDINARIO = "Extraordinário";
	
	/**
	 * - Tipos de Publicação de Créditos Adicionais no Plural
	 */
	public static final String DS_TIPO_PUBLICACAO_CREDITO_ADICIONAL_LEI_PLURAL = "Leis";
	public static final String DS_TIPO_PUBLICACAO_CREDITO_ADICIONAL_DECRETO_PLURAL = "Decretos";
	public static final String DS_TIPO_SOLICITACAO_CREDITO_ADICIONAL_SUPLEMENTAR_PLURAL = "Suplementares";
	public static final String DS_TIPO_SOLICITACAO_CREDITO_ADICIONAL_ESPECIAL_PLURAL = "Especiais";
	public static final String DS_TIPO_SOLICITACAO_CREDITO_ADICIONAL_EXTRAORDINARIO_PLURAL = "Extraordinários";
	
	/**
	 * -
	 */
	public static final String CD_SITUACAO_PUBLICACAO_CREDITO_ADICIONAL_PUBLICADO = "P";
	public static final String CD_SITUACAO_PUBLICACAO_CREDITO_ADICIONAL_ENCAMINHADO_PUBLICACAO = "E";
	public static final String CD_SITUACAO_PUBLICACAO_CREDITO_ADICIONAL_EM_CONFERENCIA = "C";
	public static final String CD_SITUACAO_PUBLICACAO_CREDITO_ADICIONAL_DADOS_INFORMADOS = "I";
	
	/**
	 * - Textos de Descrição para a Situação/Parecer de uma Publicação de
	 * Crédito(s) Adicional(is)
	 */
	public static final String DS_SITUACAO_PUBLICACAO_CREDITO_ADICIONAL_PUBLICADO = "Publicado";
	public static final String DS_SITUACAO_PUBLICACAO_CREDITO_ADICIONAL_ENCAMINHADO_PUBLICACAO = DS_SITUACAO_SOLIC_ENCAMINHADO_PUBLICACAO;
	public static final String DS_SITUACAO_PUBLICACAO_CREDITO_ADICIONAL_ENCAMINHADO_POSTERIOR_ANALISE = "Encaminhada para posterior Análise";
	public static final String DS_SITUACAO_PUBLICACAO_CREDITO_ADICIONAL_EM_CONFERENCIA = "Em Conferência";
	public static final String DS_SITUACAO_PUBLICACAO_CREDITO_ADICIONAL_ALTERADA = "Publicação Alterada";
	public static final String DS_SITUACAO_PUBLICACAO_CREDITO_ADICIONAL_CANCELADA = "Publicação Cancelada";
	public static final String DS_SITUACAO_PUBLICACAO_CREDITO_ADICIONAL_DADOS_INFORMADOS = "Dados da Publicação Informados";
	
	/**
	 * - Textos de Descrição para a Situação/Parecer de uma Solicitação de Crédito(s) Adicional(is)
	 */
	public static final String DS_SITUACAO_SOLICITACAO_CREDITO_ADICIONAL_RETROCEDIDA = "Solicitação Retrocedida";
	public static final String TX_PARECER_SOLICITACAO_CREDITO_ADICIONAL_EXCLUIDA_DA_PUBLICACAO = "Solicitação Excluída da Publicação";
	
	/**
	 * Constante que define o tipo de relatório de créditos
	 */
	public static final String DS_TP_RELATORIO_CREDITOS = "Créditos";
	public static final String TP_RELATORIO_CREDITO  = "C";
	
	/**
	 * Constante que define o tipo de relatório de reduções
	 */
	public static final String DS_TP_RELATORIO_REDUCOES = "Reduções";
	public static final String TP_RELATORIO_REDUCAO  = "R";
	
	/**
	 * Descriçãos das chaves da hashtable de Limite de Crédito
	 * 
	 */
	public static final String DS_NM_CHAVE_LIMITE_CREDITO_PERCENTUAL_LIMITE_UG = "percLimiteUG";
	
	public static final String DS_NM_CHAVE_LIMITE_CREDITO_TIPO_FONTES_FINANCIAMENTO_ESCOLHIDAS_UG = "tipoFonteFinanciamentoEscolhidasUG";
	
	/**
	 * 
	 * Descrição das operações de Limite
	 */
	
	public static final String DS_OPERACAO_ALTERACAO_LIMITE_CREDITO_SUPLEMENTAR = "Alteração";
	
	public static final String DS_OPERACAO_EXCLUSAO_LIMITE_CREDITO_SUPLEMENTAR = "Exclusao";
	
	
	/**
	 *Tipos de Relatório da GOE 
	 */
	public static final String TP_RELATORIO_DEMONSTRATIVO_GOE_RESUMIDO  = "R";
	
	public static final String TP_RELATORIO_DEMONSTRATIVO_GOE_DETALHADO  = "D";
	
	public static final String MENSAGEM_EXCECAO_INFORMADO_SOMENTE_SUBACAO_COM_VALOR_0000 = "Caso seja informada somente a SubAção, ela deve ser diferente de '0000'";
	
	/**
	 * Constantes para o Quadro de Superávit
	 */
	public static final String A_STRING = "A";
	public static final String B_STRING = "B";
	public static final String C_STRING = "C";
	public static final String SOLICITADO = "solicitado";
	
	public static final String TOTAL_A = "totalA";
	public static final String TOTAL_B = "totalB";
	public static final String TOTAL_C = "totalC";
	public static final String TOTAL_SOLICITADO = "totalSolicitado";
	
	/**
	 * Constantes genericas de Valor e Texto de Justificativa, para os Detalhamentos do Objeto, de Ação e/ou Subação
	 */
	// Incluídos na Solicitação Solicitado
	public static final String NM_ATR_VlSolicitadoDetalhamentoObjetoAcaoSubacao = "VlSolicitadoDetalhamentoObjetoAcaoSubacao";
	public static final String NM_ATR_TxJustificativaDetalhamentoObjetoAcaoSubacao = "TxJustificativaDetalhamentoObjetoAcaoSubacao";

	public static final String ID_REQ_TxJustificativaGestorDestinoAnaliseCicloExtraordinario = "TxJustificativaGestorDestinoAnaliseCicloExtraordinario";
	public static final String ID_REQ_TxJustificativaGestorDestinoAnaliseCicloExtraordinarioDetalhamentoObjeto = "TxJustificativaGestorDestinoAnaliseCicloExtraordinarioDetalhamentoObjeto";
	
	// Incluídos na Análise do Gestor Central
	public static final String NM_ATR_VlAprovadoDetalhamentoObjetoAcaoSubacao = "VlAprovadoDetalhamentoObjetoAcaoSubacao";
	public static final String NM_ATR_TxJustificativaGestorDetalhamentoObjetoAcaoSubacao = "TxJustificativaGestorDetalhamentoObjetoAcaoSubacao";
	
	// Identificador utilizado para guardar na sessao as dotaï¿½es orï¿½mentï¿½ias vindas de receitas prï¿½rias, do tipo "Anulaï¿½o de Dotaï¿½es Prï¿½rias"
	public static final String ID_REQ_ID_OBJETO_ANULACAO_DOTACOES_PROPRIAS = "ID_OBJETO_ANULACAO_DOTACOES_PROPRIAS";
	public static final String ID_REQ_ID_OBJETO_ANULACAO_DOTACOES_PROPRIAS_PRE_INCLUIDAS = "ID_OBJETO_ANULACAO_DOTACOES_PROPRIAS_PRE_INCLUIDAS";
	
	// Identificador utilizado para guardar na sessao as dotaï¿½es orï¿½mentï¿½ias vindas de receitas de terceiros, do tipo "Anulaï¿½o de Dotaï¿½es de Terceiros"
	public static final String ID_REQ_ID_OBJETO_ANULACAO_DOTACOES_TERCEIROS = "ID_OBJETO_ANULACAO_DOTACOES_TERCEIROS";
	
	// Identificadores utilizados para o cálculo, armazenamento e exibição de valores nos casos de uso do Ciclo Extraordinário
	public static final String VL_DOTACAO_AUTORIZADA_ANO_CORRENTE__CICLO_EXTRAORDINARIO = "VlDotacaoAutorizadaAnoCorrenteCicloExtraordinario";
	public static final String VL_SALDO_DOTACAO_AUTORIZADA_ANO_CORRENTE__CICLO_EXTRAORDINARIO = "VlSaldoDotacaoAutorizadaAnoCorrenteCicloExtraordinario";
	public static final String VL_SALDO_EMPENHO_ANO_CORRENTE__CICLO_EXTRAORDINARIO = "VlSaldoEmpenhoAnoCorrenteCicloExtraordinario";
	
	// Constante que serve como identificador para exibir uma mensagem para uma ação não vigente
	public static final String ID_REQ_EXIBIR_MENSAGEM_AVISO_NAO_VIGENTE = "isExibirMensagemAvisoNaoVigente";
	
	public static final String ID_REQ_MapaCdNmAcao = "MapaCodigoNomeAcao";	
	public static final String ID_REQ_MapaCdNmSubacao = "MapaCodigoNomeSubacao";	
	public static final String ID_REQ_MapaCdNmFonteRecurso = "MapaCodigoNomeFonteRecurso";	
	public static final String ID_REQ_MapaCdNmNaturezaDespesa = "MapaCodigoNomeNaturezaDespesa";
	
	public static final String DS_OPERACIONALIZACAO_CICLO_EXTRAORDINARIO = "Operacionalização - Ciclo Extraordinário";
	public static final String DS_CONSULTA_ANALISE_SEPLAG_SEPO_CICLO_EXTRAORDINARIO = "Consulta Análise SEPLAG/SEPOC - Ciclo Extraordinário";
	public static final String DS_CONSULTA_ANALISE_SECRETARIO_SEPLAG_CICLO_EXTRAORDINARIO = "Consulta Análise Secretário SEPLAG - Ciclo Extraordinário";
	
	public static final String DS_EXCLUSAO_DE_SOLICITACAO_CICLO_EXTRAORDINARIO = "Exclusão de Solicitação - Ciclo Extraordinário";
	public static final String DS_ENCAMINHAMENTO_DE_SOLICITACAO_CICLO_EXTRAORDINARIO = "Encaminhamento de Solicitação - Ciclo Extraordinário";
	public static final String DS_ENCAMINHAMENTO_DA_ANALISE_CICLO_EXTRAORDINARIO = "Encaminhamento da Análise - Ciclo Extraordinário";
	public static final String DS_ENCAMINHAMENTO_DE_SOLICITACAO_SECRETARIO_SEPLAG_SEPO_CICLO_EXTRAORDINARIO = "Encaminhamento de Solicitação Secretário SEPLAG - Ciclo Extraordinário";
	public static final String DS_DETALHAMENTO_DE_SOLICITACAO_SECRETARIO_SEPLAG_SEPO_CICLO_EXTRAORDINARIO = "Detalhamento de Solicitação Secretário SEPLAG - Ciclo Extraordinário";
	public static final String DS_DETALHAMENTO_DE_SOLICITACAO_SEPLAG_SEPO_CICLO_EXTRAORDINARIO = "Detalhamento de Solicitação SEPLAG/SEPOC - Ciclo Extraordinário";
	public static final String DS_DETALHAMENTO_DE_SOLICITACAO_CICLO_EXTRAORDINARIO = "Detalhamento de Solicitação - Ciclo Extraordinário";
	
	// Situações Relacionadas ao "Análisar Solicitação - Ciclo Extraordinário"
	public static final String DS_TIPO_APROVAR = "Aprovar";
	public static final String DS_TIPO_NAO_APROVAR = "Não Aprovar";
	public static final String DS_TIPO_APROVAR_COM_RESTRIÇÃO = "Aprovar Com Alteração";
	public static final String DS_TIPO_APROVADO_SOLICITACAO_CICLOEXTRAORDINARIO = "Aprovado";
	public static final String DS_TIPO_APROVADO_COM_ALTERACAO_SOLICITACAO_CICLOEXTRAORDINARIO = "Aprovado com Alteração";
	public static final String DS_TIPO_NAO_APROVADO_SOLICITACAO_CICLOEXTRAORDINARIO = "Não Aprovado";
	public static final String DS_TIPO_REJEITAR = "Rejeitar";
	
	public static final String CD_TIPO_APROVAR = "A";
	public static final String CD_TIPO_NAO_APROVAR = "NA";
	public static final String CD_TIPO_APROVAR_COM_RESTRIÇÃO = "AR";
	public static final String CD_TIPO_REJEITAR = "R";
	
	public static final String ID_REQ_HashMapCdNmAcao = "HashMapCdNmAcao";
	public static final String ID_REQ_HashMapCdNmSubacao = "HashMapCdNmSubacao";
	
	public static final String ID_REQ_HashMapaComSituacoesEOperacionalizacoes = "HashMapComSituacoesEOperacionalizacoes";
	
	public static final String ID_REQ_CdSituacaoDoRegistroSelecionado = "CdSituacaoDoRegistroSelecionado";
	public static final String ID_REQ_DsSituacaoDoRegistroSelecionado = "DsSituacaoDoRegistroSelecionado";
	
	public static final String CD_SITUACAO_REJEITADO = "rejeitado";
	public static final String CD_SITUACAO_REENCAMINHAR = "reencaminhar";
	public static final String CD_SITUACAO_APROVADO = "aprovado";
	
	public static final String CONSTANTE_SUBACAO_0000 = "0000";
	
	/**
	 * Identificadores utilizados para o retorno da Regra de Negócio Consultar Excecao Orcamentária ( Fluxo de obtenção de dotações )
	 */
	public static final String ID_REQ_ColecaoDotacoes = "ColecaoDotacoes";
	public static final String ID_REQ_ArvoreCicloExtraordinario = "ArvoreCicloExtraordinario";
	
	/**
	 * Constantes utilizadas no Ciclo Extraordinário (CE) e na geração de 
	 * Solicitações de Crédito Adicional e Remanejamento Orçamentário a partir do CE 
	 */
	public static final String DS_OPERACIONALIZACAO_CREDITO_ADICIONAL = "Crédito Adicional";
	public static final String DS_OPERACIONALIZACAO_REMANEJAMENTO_ORCAMENTARIO = "Remanejamento Orçamentário";
	
	public static final String ID_REQ_MapaCreditoAdicional = "IdReqMapaCreditoAdicional";
	public static final String ID_REQ_MapaRemanejamentoOrcamentario = "IdReqMapaRemanejamentoOrcamentario";
	public static final String ID_REQ_Mapa_CelulasRemanejamentoOrcamentarioCreditoAdicional = "IdReqMapaCelulasRemanejamentoOrcamentarioCreditoAdicional";
	
	public static final String DS_CEDENTE = "Cedente";
	public static final String DS_VL_TOTAL_CEDENTE = "ValorTotal" + DS_CEDENTE;
	public static final String DS_SOLICITADO = "Solicitado";
	public static final String DS_VL_TOTAL_SOLICITADO = "ValorTotal" + DS_SOLICITADO;
	
	public static final String DS_FILTRAR_FONTE_DE_RECURSO = "Filtrar Fonte de Recurso";
	public static final String DS_FILTRAR_SUBACAO = "Filtrar Subação";
	public static final String DS_FILTRAR_ACAO = "Filtrar Ação";
	public static final String DS_FILTRAR_NATUREZA_DE_DESPESA = "Filtrar Natureza de Despesa";
	
	public static final String NM_COL_SQS_CRED_ADIC = "SQS_CRED_ADIC";
	public static final String NM_COL_SQS_REMAN_CRED = "SQS_REMAN_CRED";
	
	/**
	 * - Mudar o nome desta constante.
	 * - Pensar em um local adequadro para colocar.
	 */
	public static final String NM_COL_CELULA_NAO_VIGENTE = "CELULA_NAO_VIGENTE";
		
	/**
	 * Motivações de Solicitação de Alteração Orçamentária
	 */
	public static final String CD_MOTIVACAO_LASTRO_FINANCEIRO			= "01";
	public static final String CD_MOTIVACAO_ESTORNO_LIQUIDACAO			= "02";
	public static final String CD_MOTIVACAO_EMENDAS_PARLAMENTARES		= "03";
	public static final String CD_MOTIVACAO_PLEITOS						= "04";
	public static final String CD_MOTIVACAO_CICLO_ORDINARIO				= "05";
	public static final String CD_MOTIVACAO_CICLO_EXTRAORDINARIO		= "06";
	public static final String CD_MOTIVACAO_REFORMA_ADMINISTRATIVA		= "07";
	public static final String CD_MOTIVACAO_ERRO_OPERACIONALIZACAO		= "08";
	public static final String CD_MOTIVACAO_DECISAO_NUCLEO_GOVERNO		= "09";
	public static final String CD_MOTIVACAO_PACTUACAO					= "10";
	public static final String CD_MOTIVACAO_AJUSTE_FOLHA_PESSOAL		= "11";
	
	public static final String ID_REQ_DS_MOTIVACAO_LASTRO_FINANCEIRO		= "Lastro Financeiro";
	public static final String ID_REQ_DS_MOTIVACAO_ESTORNO_LIQUIDACAO		= "Estorno de Liquidação";
	public static final String ID_REQ_DS_MOTIVACAO_EMENDAS_PARLAMENTARES	= "Emendas Parlamentares";
	public static final String ID_REQ_DS_MOTIVACAO_PLEITOS					= "Pleitos";
	public static final String ID_REQ_DS_MOTIVACAO_CICLO_ORDINARIO			= "Ciclo Ordinário";
	public static final String ID_REQ_DS_MOTIVACAO_CICLO_EXTRAORDINARIO		= "Ciclo Extraordinário";
	public static final String ID_REQ_DS_MOTIVACAO_REFORMA_ADMINISTRATIVA	= "Reforma Administrativa";
	public static final String ID_REQ_DS_MOTIVACAO_ERRO_OPERACIONALIZACAO	= "Erro de Operacionalização";
	public static final String ID_REQ_DS_MOTIVACAO_DECISAO_NUCLEO_GOVERNO	= "Decisão do Núcleo de Governo";
	public static final String ID_REQ_DS_MOTIVACAO_PACTUACAO				= "Pactuação";
	public static final String ID_REQ_DS_MOTIVTACAO_AJUSTE_FOLHA_PESSOAL	= "Ajuste da Folha de Pessoal";
	
	public static final String ID_REQ_NAME_CHECKBOX_MOTIVACOES_ORCAMENTARIAS	= "checkbox_motivacoes_orcamentarias";
	public static final String ID_REQ_ID_CHECKBOX_MOTIVACOES_ORCAMENTARIAS		= "chk_motivacoes_orcamentarias";
	public static final String ID_REQ_MOTIVACOES_ORCAMENTARIAS					= "MotivacoesOrcamentarias";
	public static final String ID_REQ_CD_MOTIVACAO_ORCAMENTARIA					= "CdMotivacaoOrcamentaria";
	public static final String ID_REQ_NM_MOTIVACAO_ORCAMENTARIA					= "NmMotivacaoOrcamentaria";
	public static final String DS_INSERIR_MOTIVACOES_ORCAMENTARIAS				= "Inserir Motivações Orcamentárias";
	public static final String DS_FILTAR_MOTIVACOES_ORCAMENTARIAS				= "Filtrar Motivações Orcamentárias";
	
	public static final String DS_COLECAO_PROGRAMA_TRABALHO						= "ColecaoProgramasDeTrabalho";
	public static final String DS_COLECAO_ACOES									= "ColecaoAcoes";
	public static final String DS_COLECAO_SUBACOES								= "ColecaoSubacoes";
	
	public static final String DS_OTDSolicRemanCredFontesOrigem					= "OTDSolicRemanCredFontesOrigem";
	public static final String ID_REQ_InNaoPossuiFontesOrigem 					= "InNaoPossuiFontesOrigem";
	
	public static final String KEY_NUMERO_DOCUMENTO_REF_CTB						= "KEY_NUMERO_DOCUMENTO_REF_CTB";
	
	public static final String GPO_CD_SUPLEMENTACAO = "SUP";
	public static final String GPO_CD_SUPLEMENTACAO_SUP_S_EXT = "SUPS/EXT";
	public static final String GPO_CD_SUPLEMENTACAO_SUP_S_ESP = "SUPS/ESP";
	public static final String GPO_CD_SUPLEMENTACAO_CRED_ESP = "CREDESP";
	public static final String GPO_CD_SUPLEMENTACAO_CRED_EXT = "CREDEXT";
	
	/**
	 * Tamanho máximo para Arquivos adicionados nas Análises do Ciclo Extraordinário
	 */
	public static final int TAMANHO_MAXIMO_ARQUIVO_CICLO_EXTRAORDINARIO = 2097152;
	
	public static final String NM_COL_IS_NAO_SE_APLICA = "IsOperacionalizacaoNaoSeAplica";
	
	public static final String NAO_EXIBIR_VALOR = " --- ";
	
	public static final String MSG_EXCECAO_INCOMPATILIBILIDADE_ORIGEM_DESTINO = "Existe incompatilidade entre a Origem Capital e o Destino Corrente!";
	
}