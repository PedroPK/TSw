/*
 * Este arquivo � propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informa��o nele contida pode ser
 * reproduzida, mostrada ou revelada sem permiss�o escrita da Sefaz-PE.
 */
package tsw.t06;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 */
public class Constantes {
	//~ Atributos/inicializadores estaticos ----------------------------------------------------------------------------------------

	private static Constantes aInstancia = new Constantes();

	/**
	 * Nome do servidor local
	 */
	public static final String NM_LOCALHOST;

	/**
	 * Endere�o IP do servidor local
	 */
	public static final String NU_IP_LOCALHOST;

	/**
	 * Endere�o IP do servidor local
	 */
	public static final byte[] NU_IP_RAW_LOCALHOST;

	static {
		InetAddress localHost = null;

		try {
			localHost = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			throw new IllegalStateException("N�o foi poss�vel obter o objeto host local | " + e);
		}

		NM_LOCALHOST = localHost.getHostName();
		NU_IP_LOCALHOST = localHost.getHostAddress();
		NU_IP_RAW_LOCALHOST = localHost.getAddress();
	}

	/**
	 * Constantes que representam os operadores booleanos (utilizados em par�metros do request e no banco de dados)
	 */
	public static final String CD_VERDADEIRO = "S";

	/**
	 * -
	 */
	public static final String CD_FALSO = "N";

	/**
	 * -
	 */
	public static final int CD_IGUAL = 0;

	/**
	 * -
	 */
	public static final int CD_MAIOR = 1;

	/**
	 * -
	 */
	public static final int CD_MENOR = -1;

	/**
	 * Constantes de comparadores matem�ticos
	 */
	public static final String CD_COMPARADOR_IGUAL = "=";

	/**
	 * -
	 */
	public static final String CD_COMPARADOR_MAIOR = ">";

	/**
	 * -
	 */
	public static final String CD_COMPARADOR_MENOR = "<";

	/**
	 * -
	 */
	public static final String CD_COMPARADOR_MAIOR_IGUAL = ">=";

	/**
	 * -
	 */
	public static final String CD_COMPARADOR_MENOR_IGUAL = "<=";

	/**
	 * -
	 */
	public static final String CD_COMPARADOR_DIFERENTE = "<>";

	/**
	 * -
	 */
	public static final String CD_COMPARADOR_ENTRE = "BETWEEN";

	/**
	 * -
	 */
	public static final int QT_REGISTROS_POR_PAGINA_TODOS = 999999;

	/**
	 * Quantidade m�xima de registros que uma transa��o pode manipular envolvendo tabela com CLOB ou BLOB.<BR> � uma
	 * restri��o imposta pelo DB2.
	 */
	public static final int QT_MAX_REGISTROS_POR_TRANSACAO_COM_LOB = 30000;

	/**
	 * Constantes que representam as op��es anal�tico e sint�tico em uma consulta ou relat�rio
	 */
	public static final String CD_OPCAO_ANALITICO = "opcao_analitico";

	/**
	 * -
	 */
	public static final String CD_OPCAO_SINTETICO = "opcao_sintetico";

	/**
	 * Constante que representa o comando javascript window.history.back() nas telas de mensagem ao usu�rio
	 */
	public static final String CD_HISTORY_BACK = "window_history_back";

	/**
	 * Constante que representa o comando javascript window.close() nas telas de mensagem ao usu�rio
	 */
	public static final String CD_CLOSE = "window_close";

	/**
	 * Constantes que representam os atributos nulo e nulo alterado
	 */
	public static final String CD_ATRIBUTO_NULO = "[[**]]atr_nulo[[**]]";

	/**
	 * -
	 */
	public static final String CD_ATRIBUTO_NULO_ALTERADO = "[[**]]atr_nulo_alterado[[**]]";

	/**
	 * Constantes que representam campos separadores de informa��es concatenadas
	 */
	public static final String CD_CAMPO_SEPARADOR = "[[*]]";

	/**
	 * -
	 */
	public static final String CD_CAMPO_SEPARADOR_AUX = "[[**]]";

	/**
	 * -
	 */
	public static final String CD_CAMPO_SEPARADOR_GUI = "_";

	/**
	 * -
	 */
	public static final String CD_CAMPO_SEPARADOR_ARQUIVO_IMPORTACAO = "<#>";

	/**
	 * -
	 */
	public static final String CD_CAMPO_SEPARADOR_ARQUIVO_IMPORTACAO_LOAD = ",";

	/**
	 * -
	 */
	public static final String CD_CAMPO_SEPARADOR_VARCHAR_ARQUIVO_IMPORTACAO_LOAD = "'";

	/**
	 * -
	 */
	public static final String CD_CAMPO_SEPARADOR_ARQUIVO_EXPORTACAO = "<#>";

	/**
	 * Constantes que representam campos utilizados nas mensagens ao usu�rio
	 */
	public static final String CD_CAMPO_SUBSTITUICAO_MSGUSR = "#?#";

	/**
	 * -
	 */
	public static final String CD_CAMPO_INICIO_DESTAQUE_MSGUSR = "#<#";

	/**
	 * -
	 */
	public static final String CD_CAMPO_FIM_DESTAQUE_MSGUSR = "#>#";

	/**
	 * -
	 */
	public static final String CD_CAMPO_QUEBRA_LINHA_MSGUSR = "#/#";

	/**
	 * -
	 */
	public static final String SEPARADOR_LINHA = "-----------------------------------------------";

	/**
	 * Constante que indica que o item de menu deve abrir uma janela auxiliar
	 */
	public static final String IN_MENU_JANELA_AUXILIAR = " (*)";

	/**
	 * Constante que indica que o item de menu deve abrir uma janela auxiliar passando os par�metros do framework
	 * (idSessao, cdUsuario, etc)
	 */
	public static final String IN_MENU_JANELA_AUXILIAR_COM_PARAMETROS_FRAMEWORK = " (#)";

	/**
	 * Constantes que representam os caracteres coringas utilizado em filtros e no acesso ao banco de dados
	 */
	public static final char CD_CARACTERE_CORINGA_USR = '*';

	/**
	 * -
	 */
	public static final char CD_CARACTERE_CORINGA_BD = '%';

	/**
	 * N�o est� sendo utilizada
	 */
	public static final char CD_CARACTERE_CORINGA_SIMPLES_USR = '?';

	/**
	 * N�o est� sendo utilizada
	 */
	public static final char CD_CARACTERE_CORINGA_SIMPLES_BD = '_';

	/**
	 * Constantes que representam as op��es de sele��o 'Todos' e 'Nenhum' em um componente HTML Select
	 */
	public static final String CD_OPCAO_NENHUM = "opcao_nenhum";

	/**
	 * -
	 */
	public static final String CD_OPCAO_TODOS = "opcao_todos";

	/**
	 * -
	 */
	public static final String CD_OPCAO_TODOS_GUI = "Todos";

	/**
	 * Constante que representam o tipo de transa��o JTA
	 */
	public static final short TP_TRANSACAO_JTA = 1;

	/**
	 * Constante que representam o tipo de transa��o JTA com Conex�o e ResultSet Gerenciados pelo Cliente (CRGC).
	 */
	public static final short TP_TRANSACAO_JTA_CRGC = 3;

	/**
	 * Constante que representam o tipo de transa��o JDBC
	 */
	public static final short TP_TRANSACAO_JDBC = 2;

	/**
	 * Constante que representam o tipo de transa��o JDBC, com ResultSet Gerenciado pelo Cliente (RGC)
	 */
	public static final short TP_TRANSACAO_JDBC_RGC = 4;

	/**
	 * Constante que representam o tipo de transa��o JTA com Bean Managed Transaction
	 */
	public static final short TP_TRANSACAO_JTA_BMT = 5;

	/**
	 * Constantes que representam o tipo de mecanismo de persist�ncia
	 */
	public static final short TP_PERSISTENCIA_EB = 1;

	/**
	 * -
	 */
	public static final short TP_PERSISTENCIA_DAO = 2;
	
	/**
	 * Tipo de dispositivo de acesso (cliente): "desktop".
	 */
	public static final String TP_DISPOSITIVO_ACESSO_DESKTOP = "D";
	
	/**
	 * Tipo de dispositivo de acesso (cliente): "tablet".
	 */
	public static final String TP_DISPOSITIVO_ACESSO_TABLET = "T";
	
	/**
	 * Tipo de dispositivo de acesso (cliente): "celular".
	 */
	public static final String TP_DISPOSITIVO_ACESSO_CELULAR = "C";
	
	/**
	 * Constante que identifica que uma mensagem de e-mail � do tipo HTML (text/html).
	 */
	public static final String TP_MENSAGEM_EMAIL_HTML = "text/html";

	/**
	 * Constantes que representam a situa��o de execu��o de um Job
	 */
	public static final String CD_SITUACAO_EXECUCAO_JOB_SOLICITADA = "SL";

	/**
	 * -
	 */
	public static final String CD_SITUACAO_EXECUCAO_JOB_AGENDADA = "AG";

	/**
	 * -
	 */
	public static final String CD_SITUACAO_EXECUCAO_JOB_REJEITADA = "RJ";

	/**
	 * -
	 */
	public static final String CD_SITUACAO_EXECUCAO_JOB_EM_EXECUCAO = "EX";

	/**
	 * -
	 */
	public static final String CD_SITUACAO_EXECUCAO_JOB_CONCLUIDA_COM_SUCESSO = "CS";

	/**
	 * -
	 */
	public static final String CD_SITUACAO_EXECUCAO_JOB_CONCLUIDA_COM_SUCESSO_RESTRICAO = "CR";

	/**
	 * -
	 */
	public static final String CD_SITUACAO_EXECUCAO_JOB_CONCLUIDA_COM_ERRO = "CE";

	/**
	 * Constantes que representam par�metros do UTL
	 */
	public static final String CD_PARAM_JOB_NOME_REMETENTE_ALERTA = "NomeRemetenteAlertaJob";

	/**
	 * -
	 */
	public static final String CD_PARAM_JOB_EMAIL_REMETENTE_ALERTA = "EmailRemetenteAlertaJob";

	/**
	 * -
	 */
	public static final String CD_PARAM_JOB_EMAIL_DESTINATARIO_ALERTA = "EMailDestinatarioAlertaJob";

	/**
	 * -
	 */
	public static final String CD_PARAM_JOB_TIMEOUT_ARQ_IMPORTACAO_SNCR = "TimeoutArqImportacaoSncrJob";

	/**
	 * -
	 */
	public static final String CD_PARAM_TX_MENSAGEM_BROADCAST = "TxMensagemBroadcast";

	/**
	 * -
	 */
	public static final String CD_PARAM_DH_INICIO_VIGENCIA_MENSAGEM_BROADCAST = "DtInicioVigenciaMensagemBroadcast";

	/**
	 * -
	 */
	public static final String CD_PARAM_DH_FIM_VIGENCIA_MENSAGEM_BROADCAST = "DtFimVigenciaMensagemBroadcast";

	/**
	 * -
	 */
	public static final String CD_PARAM_TX_MENSAGEM_BROADCAST_PARADA_AMBIENTE = "TxMensagemBroadcastParadaAmbiente";

	/**
	 * Par�metro que indica o tempo de expira��o dos links favoritos.
	 */
	public static final String CD_PARAM_TEMPO_EXPIRACAO_FAVORITOS = "TempoExpiracaoFavoritos";

	/**
	 * C�digo da propriedade de transa��o que armazena o VOUsuario.
	 */
	public static final String CD_PROPTX_VOUsuario = "com.sca.servico03.VOUsuario";

	/**
	 * C�digo da propriedade de transa��o que armazena o VOFuncao
	 */
	public static final String CD_PROPTX_VOFuncao = "com.sca.servico01.VOFuncao";

	/**
	 * C�digo da propriedade de transa��o que armazena o inLogFuncao
	 */
	public static final String CD_PROPTX_InLogFuncao = "IN_LOG_FUNCAO";

	/**
	 * C�digo da propriedade de transa��o que armazena o inLogConsultaFuncao
	 */
	public static final String CD_PROPTX_InLogConsultaFuncao = "IN_LOG_CONSULTA_FUNCAO";

	/**
	 * C�digo do Tipo de Tela de Mensagem de Sucesso
	 */
	public static final int CD_TIPO_TELA_MSGUSR_SUCESSO = 1;

	/**
	 * C�digo do Tipo de Tela de Mensagem de Confirma��o
	 */
	public static final int CD_TIPO_TELA_MSGUSR_CONFIRMACAO = 4;

	/**
	 * -
	 */
	public static final int CD_MSGUSR_SUPORTE_TRIBUTARIOINTERNET = 8;

	/**
	 * -
	 */
	public static final int CD_MSGUSR_SUPORTE_FINANCEIRO_E_EXTRANET = 9;

	/**
	 * -
	 */
	public static final int CD_MSGUSR_SUPORTE_TRIBUTARIOINTRANET = 10;

	/**
	 * C�digo das Telas de Mensagem aos Usu�rios
	 */
	public static final int CD_TELA_MSGUSR_SUCESSO = 1;

	/**
	 * -
	 */
	public static final int CD_TELA_MSGUSR_ERRO = 2;

	/**
	 * -
	 */
	public static final int CD_TELA_MSGUSR_SUCESSO_COM_LINK_DOCUMENTO = 30;

	/**
	 * -
	 */
	public static final int CD_TELA_MSGUSR_SUCESSO_COM_LINK_DOCUMENTO_SEM_PROXIMO_LINK = 41;

	/**
	 * Tipo de ordena��o
	 */
	public static final String CD_TIPO_ORDENACAO_CRESCENTE = "C";

	/**
	 * -
	 */
	public static final String CD_TIPO_ORDENACAO_DECRESCENTE = "D";

	/**
	 * -
	 */
	public static final String CD_TIPO_OPERACAO_MESTREDETALHE_INCLUSAO = "tipo_operacao_inclusao";

	/**
	 * -
	 */
	public static final String CD_TIPO_OPERACAO_MESTREDETALHE_EXCLUSAO = "tipo_operacao_exclusao";

	/**
	 * -
	 */
	public static final String CD_TIPO_OPERACAO_MESTREDETALHE_ALTERACAO = "tipo_operacao_alteracao";

	/**
	 * -
	 */
	public static final String CD_TIPO_OPERACAO_MESTREDETALHE_DETALHAMENTO = "tipo_operacao_detalhamento";

	/**
	 * C�digo do Usu�rio An�nimo no SCA
	 */
	public static final String CD_USUARIO_ANONIMO = "1";

	/**
	 * C�digo do Usu�rio Monitor Geral 01 no SCA
	 */
	public static final String CD_USUARIO_MONITOR_GERAL_01 = "2";

	/**
	 * C�digo do Usu�rio Monitor Geral 02 no SCA
	 */
	public static final String CD_USUARIO_MONITOR_GERAL_02 = "3";

	/**
	 * C�digo do Usu�rio no legado n�o identificado durante a migra��o
	 */
	public static final String CD_USUARIO_LEGADO_NAO_IDENTIFICADO = "XY9999";

	/**
	 * C�digos dos tipos de rede de acesso
	 */
	public static final short CD_TIPO_REDE_ACESSO_INTRANET = 1;

	/**
	 * -
	 */
	public static final short CD_TIPO_REDE_ACESSO_EXTRANET = 2;

	/**
	 * -
	 */
	public static final short CD_TIPO_REDE_ACESSO_INTERNET = 3;

	/**
	 * -
	 */
	public static final short CD_TIPO_CERTIFICADO_DIGITAL_INEXISTENTE = 0;

	/**
	 * -
	 */
	public static final short CD_TIPO_CERTIFICADO_DIGITAL_A1 = 1;

	/**
	 * -
	 */
	public static final short CD_TIPO_CERTIFICADO_DIGITAL_A3_SEM_BIOMETRIA = 2;

	/**
	 * -
	 */
	public static final short CD_TIPO_CERTIFICADO_DIGITAL_A3_COM_BIOMETRIA = 3;

	/**
	 * Sufixo das propriedades que guardam o nome do host de uma fun��o
	 */
	public static final String NM_SUFIXO_INTRANET_PROPRIEDADE_NM_HOST = "Intranet";

	/**
	 * -
	 */
	public static final String NM_SUFIXO_EXTRANET_PROPRIEDADE_NM_HOST = "Extranet";

	/**
	 * -
	 */
	public static final String NM_SUFIXO_INTERNET_PROPRIEDADE_NM_HOST = "Internet";

	/**
	 * -
	 */
	public static final String NM_SUFIXO_IN_USO_CERTIFICADO_DIGITAL = "ComCertificado";

	/**
	 * -
	 */
	public static final String NM_SUFIXO_IN_USO_LOGIN_COM_SENHA = "ComSenha";

	/**
	 * -
	 */
	public static final String NM_SUFIXO_IN_USO_LOGIN_ANONIMO = "Anonimo";

	/**
	 * Nome do 'path' web base para JSPs
	 */
	public static final String NM_PATH_JSP = "jsp";

	/**
	 * Nomes dos 'paths' web para as JSPs de cada servi�o
	 */
	public static final String NM_PATH_JSP_SERVICO01 = Constantes.NM_PATH_JSP + "/servico01";

	/**
	 * -
	 */
	public static final String NM_PATH_JSP_SERVICO02 = Constantes.NM_PATH_JSP + "/servico02";

	/**
	 * -
	 */
	public static final String NM_PATH_JSP_SERVICO03 = Constantes.NM_PATH_JSP + "/servico03";

	/**
	 * -
	 */
	public static final String NM_PATH_JSP_SERVICO04 = Constantes.NM_PATH_JSP + "/servico04";

	/**
	 * -
	 */
	public static final String NM_PATH_JSP_SERVICO05 = Constantes.NM_PATH_JSP + "/servico05";

	/**
	 * -
	 */
	public static final String NM_PATH_JSP_SERVICO06 = Constantes.NM_PATH_JSP + "/servico06";

	/**
	 * -
	 */
	public static final String NM_PATH_JSP_SERVICO07 = Constantes.NM_PATH_JSP + "/servico07";

	/**
	 * -
	 */
	public static final String NM_PATH_JSP_SERVICO08 = Constantes.NM_PATH_JSP + "/servico08";

	/**
	 * -
	 */
	public static final String NM_PATH_JSP_SERVICO09 = Constantes.NM_PATH_JSP + "/servico09";

	/**
	 * -
	 */
	public static final String NM_PATH_JSP_SERVICO10 = Constantes.NM_PATH_JSP + "/servico10";

	/**
	 * -
	 */
	public static final String NM_PATH_JSP_SERVICO11 = Constantes.NM_PATH_JSP + "/servico11";

	/**
	 * -
	 */
	public static final String NM_PATH_JSP_SERVICO12 = Constantes.NM_PATH_JSP + "/servico12";

	/**
	 * -
	 */
	public static final String NM_PATH_JSP_SERVICO13 = Constantes.NM_PATH_JSP + "/servico13";

	/**
	 * -
	 */
	public static final String NM_PATH_JSP_SERVICO14 = Constantes.NM_PATH_JSP + "/servico14";

	/**
	 * -
	 */
	public static final String NM_PATH_JSP_SERVICO15 = Constantes.NM_PATH_JSP + "/servico15";

	/**
	 * -
	 */
	public static final String NM_PATH_JSP_SERVICO16 = Constantes.NM_PATH_JSP + "/servico16";

	/**
	 * -
	 */
	public static final String NM_PATH_JSP_SERVICO17 = Constantes.NM_PATH_JSP + "/servico17";

	/**
	 * -
	 */
	public static final String NM_PATH_JSP_SERVICO18 = Constantes.NM_PATH_JSP + "/servico18";

	/**
	 * -
	 */
	public static final String NM_PATH_JSP_SERVICO19 = Constantes.NM_PATH_JSP + "/servico19";

	/**
	 * -
	 */
	public static final String NM_PATH_JSP_SERVICO20 = Constantes.NM_PATH_JSP + "/servico20";

	/**
	 * Sigla das �reas Funcionais
	 */
	public static final String SG_AREA_REFERENCIA = "referencia";

	/**
	 * -
	 */
	public static final String SG_AREA_ADMINISTRATIVA = "adm";

	/**
	 * -
	 */
	public static final String SG_AREA_COMUM = "com";

	/**
	 * -
	 */
	public static final String SG_AREA_FINANCEIRA = "fin";

	/**
	 * -
	 */
	public static final String SG_AREA_ORCAMENTARIA = "orc";

	/**
	 * -
	 */
	public static final String SG_AREA_PLANEJAMENTO = "pln";

	/**
	 * -
	 */
	public static final String SG_AREA_TRIBUTARIA = "trb";

	/**
	 * -
	 */
	public static final String SG_AREA_EXTERNA = "ext";

	/**
	 * -
	 */
	public static final String[] SG_AREAS_FUNCIONAIS = new String[] {
			Constantes.SG_AREA_ADMINISTRATIVA,
			Constantes.SG_AREA_COMUM,
			Constantes.SG_AREA_FINANCEIRA,
			Constantes.SG_AREA_ORCAMENTARIA,
			Constantes.SG_AREA_PLANEJAMENTO,
			Constantes.SG_AREA_TRIBUTARIA,
			Constantes.SG_AREA_EXTERNA
		};

	/**
	 * Sigla dos Sistemas
	 */

	//�rea Comum
	public static final String SG_SISTEMA_COM_ACG = "ACG";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_COM_MSG = "MSG";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_COM_SCA = "SCA";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_COM_TGE = "TGE";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_COM_UTL = "UTL";

	//�rea Administrativa
	/**
	 * -
	 */
	public static final String SG_SISTEMA_ADM_AMA = "AMA";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_ADM_GCE = "GCE";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_ADM_GDL = "GDL";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_ADM_PRT = "PRT";

	//�rea Tribut�ria
	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_AAJ = "AAJ";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_AJU = "AJU";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_ATP = "ATP";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_CMT = "CMT";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_CSN = "CSN";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_DEF = "DEF";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_GAE = "GAE";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_GAF = "GAF";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_GCC = "GCC";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_GCD = "GCD";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_GDF = "GDF";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_GIV = "GIV";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_GCO = "GCO";
	
	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_CMI = "CMI";
	
	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_NFA = "NFA";	
	
	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_GML = "GML";
	
	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_GRS = "GRS";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_SCR = "SCR";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_GMF = "GMF";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_GNA = "GNA";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_GPF = "GPF";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_GRE = "GRE";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_GSN = "GSN";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_SIM = "SIM";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_SPF = "SPF";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_GEA = "GEA";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_CAT = "CAT";
	
	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_GDE = "GDE";
	
	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_MIG = "MIG";
	
	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_DMI = "DMI";
	
	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_GOC = "GOC";
	
	/**
	 * -
	 */
	public static final String SG_SISTEMA_TRB_GIF = "GIF";	

	//�rea Financeira
	/**
	 * -
	 */
	public static final String SG_SISTEMA_FIN_ACO = "ACO";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_FIN_CTB = "CTB";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_FIN_FPI = "FPI";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_FIN_GBP = "GBP";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_FIN_GCT = "GCT";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_FIN_GDP = "GDP";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_FIN_GFE = "GFE";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_FIN_GFU = "GFU";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_FIN_GPA = "GPA";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_FIN_GRC = "GRC";
	
	/**
	 * -
	 */
	public static final String SG_SISTEMA_FIN_PLF = "PLF";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_FIN_SIA = "SIA";
	
	/**
	 * -
	 */
	public static final String SG_SISTEMA_FIN_SIC = "SIC";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_FIN_GPC = "GPC";

	//�rea Or�ament�ria
	/**
	 * -
	 */
	public static final String SG_SISTEMA_ORC_PLO = "PLO";

	//�rea Planejamento
	/**
	 * -
	 */
	public static final String SG_SISTEMA_PLN_GEO = "GEO";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_PLN_GPO = "GPO";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_PLN_GPP = "GPP";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_PLN_PPA = "PPA";

	/**
	 * -
	 */
	public static final String SG_SISTEMA_PLN_SPL = "SPL";
	
	/**
	 * -
	 */
	public static final String SG_SISTEMA_PLN_GCF = "GCF";
	
	/**
	 * -
	 */
	public static final String SG_SISTEMA_PLN_GCR = "GCR";	

	//�rea Externa
	/**
	 * -
	 */
	public static final String SG_SISTEMA_EXT_SGE = "SGE";

	/**
	 * Sigla da �rea Funcional por Sistema
	 */
	public static final Map<String, String> SG_AREAS_FUNCIONAIS_POR_SISTEMA;

	static {
		Map<String, String> mapSgAreas = new ConcurrentHashMap<String, String>(128);
		
		mapSgAreas.put(Constantes.SG_SISTEMA_ADM_AMA, Constantes.SG_AREA_ADMINISTRATIVA);
		mapSgAreas.put(Constantes.SG_SISTEMA_ADM_GCE, Constantes.SG_AREA_ADMINISTRATIVA);
		mapSgAreas.put(Constantes.SG_SISTEMA_ADM_GDL, Constantes.SG_AREA_ADMINISTRATIVA);
		mapSgAreas.put(Constantes.SG_SISTEMA_ADM_PRT, Constantes.SG_AREA_ADMINISTRATIVA);
		mapSgAreas.put(Constantes.SG_SISTEMA_COM_ACG, Constantes.SG_AREA_COMUM);
		mapSgAreas.put(Constantes.SG_SISTEMA_COM_MSG, Constantes.SG_AREA_COMUM);
		mapSgAreas.put(Constantes.SG_SISTEMA_COM_SCA, Constantes.SG_AREA_COMUM);
		mapSgAreas.put(Constantes.SG_SISTEMA_COM_TGE, Constantes.SG_AREA_COMUM);
		mapSgAreas.put(Constantes.SG_SISTEMA_COM_UTL, Constantes.SG_AREA_COMUM);
		mapSgAreas.put(Constantes.SG_SISTEMA_FIN_ACO, Constantes.SG_AREA_FINANCEIRA);
		mapSgAreas.put(Constantes.SG_SISTEMA_FIN_CTB, Constantes.SG_AREA_FINANCEIRA);
		mapSgAreas.put(Constantes.SG_SISTEMA_FIN_FPI, Constantes.SG_AREA_FINANCEIRA);
		mapSgAreas.put(Constantes.SG_SISTEMA_FIN_GBP, Constantes.SG_AREA_FINANCEIRA);
		mapSgAreas.put(Constantes.SG_SISTEMA_FIN_GCT, Constantes.SG_AREA_FINANCEIRA);
		mapSgAreas.put(Constantes.SG_SISTEMA_FIN_GDP, Constantes.SG_AREA_FINANCEIRA);
		mapSgAreas.put(Constantes.SG_SISTEMA_FIN_GFE, Constantes.SG_AREA_FINANCEIRA);
		mapSgAreas.put(Constantes.SG_SISTEMA_FIN_GFU, Constantes.SG_AREA_FINANCEIRA);
		mapSgAreas.put(Constantes.SG_SISTEMA_FIN_GPA, Constantes.SG_AREA_FINANCEIRA);
		mapSgAreas.put(Constantes.SG_SISTEMA_FIN_GRC, Constantes.SG_AREA_FINANCEIRA);
		mapSgAreas.put(Constantes.SG_SISTEMA_FIN_PLF, Constantes.SG_AREA_FINANCEIRA);
		mapSgAreas.put(Constantes.SG_SISTEMA_FIN_SIA, Constantes.SG_AREA_FINANCEIRA);
		mapSgAreas.put(Constantes.SG_SISTEMA_FIN_SIC, Constantes.SG_AREA_FINANCEIRA);
		mapSgAreas.put(Constantes.SG_SISTEMA_FIN_GPC, Constantes.SG_AREA_FINANCEIRA);		
		mapSgAreas.put(Constantes.SG_SISTEMA_ORC_PLO, Constantes.SG_AREA_ORCAMENTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_PLN_GEO, Constantes.SG_AREA_PLANEJAMENTO);
		mapSgAreas.put(Constantes.SG_SISTEMA_PLN_GPO, Constantes.SG_AREA_PLANEJAMENTO);
		mapSgAreas.put(Constantes.SG_SISTEMA_PLN_GPP, Constantes.SG_AREA_PLANEJAMENTO);
		mapSgAreas.put(Constantes.SG_SISTEMA_PLN_PPA, Constantes.SG_AREA_PLANEJAMENTO);
		mapSgAreas.put(Constantes.SG_SISTEMA_PLN_SPL, Constantes.SG_AREA_PLANEJAMENTO);
		mapSgAreas.put(Constantes.SG_SISTEMA_PLN_GCF, Constantes.SG_AREA_PLANEJAMENTO);
		mapSgAreas.put(Constantes.SG_SISTEMA_PLN_GCR, Constantes.SG_AREA_PLANEJAMENTO);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_AAJ, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_AJU, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_ATP, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_CMT, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_CSN, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_DEF, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_GAE, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_GAF, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_GCC, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_GCD, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_GDF, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_GIV, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_GCO, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_CMI, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_NFA, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_GML, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_GRS, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_SCR, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_GMF, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_GNA, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_GPF, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_GRE, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_GSN, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_SIM, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_SPF, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_GEA, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_CAT, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_GDE, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_MIG, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_DMI, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_GOC, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_TRB_GIF, Constantes.SG_AREA_TRIBUTARIA);
		mapSgAreas.put(Constantes.SG_SISTEMA_EXT_SGE, Constantes.SG_AREA_EXTERNA);
		
		SG_AREAS_FUNCIONAIS_POR_SISTEMA = Collections.unmodifiableMap(mapSgAreas);
	}

	/**
	 * Propriedade de ambiente que define o path base
	 */
	public static final String NM_PROPRIEDADE_NM_PATH_BASE = "sfi.NmPathBase";

	/**
	 * Propriedade de ambiente que define o path base de jobs
	 */
	public static final String NM_PROPRIEDADE_NM_PATH_BASEJOBS = "sfi.NmPathBaseJobs";

	/**
	 * Propriedade de ambiente que indica que a JVM � do servidor de aplica��o (n�o � um Job)
	 */
	public static final String NM_PROPRIEDADE_IN_JVM_SERVIDOR_APLICACAO = "sfi.InJVMServidorAplicacao";

	/**
	 * Propriedade de ambiente que define o nome da URL para localiza��o de EJBs
	 */
	public static final String NM_PROPRIEDADE_NM_PROVIDER_URL_EJB = "sfi.NmProviderURLEJB";

	/**
	 * Propriedade de ambiente que define o nome da URL para localiza��o de fontes de dados JDBC
	 */
	public static final String NM_PROPRIEDADE_NM_PROVIDER_URL_FONTE_DADOS_JDBC = "sfi.NmProviderURLFonteDadosJDBC";

	static {
		if ( 
				System.getProperty(Constantes.NM_PROPRIEDADE_NM_PATH_BASE) == null ||
				System.getProperty(Constantes.NM_PROPRIEDADE_NM_PATH_BASE).trim().equals("")
		) {
			BibliotecaFuncoesPrincipal.registrarLogErro(Constantes.class.getName(),
				"ATEN��O: A propriedade de ambiente 'sfi.NmPathBase' n�o est� dispon�vel.");
			throw new IllegalStateException("A propriedade de ambiente 'sfi.NmPathBase' n�o est� dispon�vel.");
		}
		
		if (System.getProperty(Constantes.NM_PROPRIEDADE_NM_PATH_BASEJOBS) == null) {
			System.setProperty(Constantes.NM_PROPRIEDADE_NM_PATH_BASEJOBS,
				System.getProperty(Constantes.NM_PROPRIEDADE_NM_PATH_BASE));
		}
		
		if ( 
				System.getProperty(Constantes.NM_PROPRIEDADE_IN_JVM_SERVIDOR_APLICACAO) != null &&
				System.getProperty(Constantes.NM_PROPRIEDADE_IN_JVM_SERVIDOR_APLICACAO).equals("true")
		) {
			System.setProperty(Constantes.NM_PROPRIEDADE_IN_JVM_SERVIDOR_APLICACAO, Constantes.CD_VERDADEIRO);
		} else {
			System.setProperty(Constantes.NM_PROPRIEDADE_IN_JVM_SERVIDOR_APLICACAO, Constantes.CD_FALSO);
		}
	}

	/**
	 * -
	 */
	public static final String NM_PATH_BASE = BibliotecaFuncoesPrincipal.corrigirPathFileSystem(System.getProperty(
				Constantes.NM_PROPRIEDADE_NM_PATH_BASE));

	/**
	 * -
	 */
	public static final String NM_PATH_BASE_COMO_URL = BibliotecaFuncoesPrincipal.substituir(System.getProperty(
				Constantes.NM_PROPRIEDADE_NM_PATH_BASE), "\\", "/");

	/**
	 * -
	 */
	public static final String NM_PATH_BASEJOBS = BibliotecaFuncoesPrincipal.corrigirPathFileSystem(System.getProperty(
				Constantes.NM_PROPRIEDADE_NM_PATH_BASEJOBS));

	/**
	 * -
	 */
	public static final String NM_PROVIDER_URL_EJB = System.getProperty(Constantes.NM_PROPRIEDADE_NM_PROVIDER_URL_EJB);

	/**
	 * -
	 */
	public static final String NM_PROVIDER_URL_FONTE_DADOS_JDBC = System.getProperty(Constantes.NM_PROPRIEDADE_NM_PROVIDER_URL_FONTE_DADOS_JDBC);

	/**
	 * -
	 */
	public static final String IN_JVM_SERVIDOR_APLICACAO = System.getProperty(Constantes.NM_PROPRIEDADE_IN_JVM_SERVIDOR_APLICACAO);

	/**
	 * Nome dos 'paths' no filesystem
	 */
	public static final String NM_PATH = Constantes.NM_PATH_BASE + File.separator + "sfi_arquivos";

	/**
	 * -
	 */
	public static final String NM_PATH_COMO_URL = Constantes.NM_PATH_BASE_COMO_URL + File.separator + "sfi_arquivos";

	/**
	 * -
	 */
	public static final String NM_PATH_CONFIG = Constantes.NM_PATH + File.separator + "config";

	/**
	 * -
	 */
	public static final String NM_PATH_CONFIG_COMO_URL = Constantes.NM_PATH_COMO_URL + File.separator + "config";

	/**
	 * -
	 */
	public static final String NM_PATH_LOGS = Constantes.NM_PATH + File.separator + "logs";

	/**
	 * -
	 */
	public static final String NM_PATH_LOGS_EXCECAO = Constantes.NM_PATH_LOGS + File.separator + "excecao";

	/**
	 * -
	 */
	public static final String NM_PATH_LOGS_UPLOAD = Constantes.NM_PATH_LOGS + File.separator + "upload";

	/**
	 * -
	 */
	public static final String NM_PATH_TEMPLATES = Constantes.NM_PATH + File.separator + "templates";

	/**
	 * -
	 */
	public static final String NM_PATH_TEMPLATES_IMAGENS = Constantes.NM_PATH_TEMPLATES + File.separator + "imagens";

	/**
	 * -
	 */
	public static final String NM_PATH_DOCUMENTOS = Constantes.NM_PATH + File.separator + "documentos";

	/**
	 * -
	 */
	public static final String NM_PATH_DOCUMENTOS_ONLINE = Constantes.NM_PATH_DOCUMENTOS + File.separator + "online";

	/**
	 * -
	 */
	public static final String NM_PATH_UPLOAD = Constantes.NM_PATH + File.separator + "upload";

	/**
	 * Nome dos 'paths' no filesystem para Jobs
	 */
	public static final String NM_PATHJOBS = Constantes.NM_PATH_BASEJOBS + File.separator + "sfi_arquivos";

	/**
	 * -
	 */
	public static final String NM_PATH_JOBS = Constantes.NM_PATHJOBS + File.separator + "jobs";

	/**
	 * -
	 */
	public static final String NM_PATH_LOGS_JOBS = Constantes.NM_PATHJOBS + File.separator + "logs" + File.separator + "jobs";

	/**
	 * -
	 */
	public static final String NM_PATH_ENTRADA = Constantes.NM_PATHJOBS + File.separator + "entrada";

	/**
	 * -
	 */
	public static final String NM_PATH_COMUM = Constantes.NM_PATHJOBS + File.separator + "comum";

	/**
	 * -
	 */
	public static final String NM_PATH_SAIDA = Constantes.NM_PATHJOBS + File.separator + "saida";

	/**
	 * -
	 */
	public static final String NM_PATH_PROCESSADOS = Constantes.NM_PATHJOBS + File.separator + "processados";

	/**
	 * -
	 */
	public static final String NM_PATH_DOCUMENTOS_BATCH = Constantes.NM_PATHJOBS + File.separator + "documentos" + File.separator +
		"batch";


	/**
	 * Nome das conex�es JNDI dispon�veis
	 */
	public static final String NM_CONEXAO_JNDI_REFERENCIA = "jdbc/sfi_referencia";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_MIGRACAO = "jdbc/sfi_migracao";

	//�rea Comum
	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_COM_ACG = "jdbc/sfi_com_acg";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_COM_MSG = "jdbc/sfi_com_msg";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_COM_SCA = "jdbc/sfi_com_sca";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_COM_SCA_LOG_TRANSACAO = "jdbc/sfi_com_sca_log_transacao";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_COM_TGE = "jdbc/sfi_com_tge";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_COM_UTL = "jdbc/sfi_com_utl";

	//�rea Administrativa
	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_ADM_AMA = "jdbc/sfi_adm_ama";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_ADM_GCE = "jdbc/sfi_adm_gce";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_ADM_GDL = "jdbc/sfi_adm_gdl";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_ADM_PRT = "jdbc/sfi_adm_prt";

	//�rea Tribut�ria
	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_AAJ = "jdbc/sfi_trb_aaj";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_AJU = "jdbc/sfi_trb_aju";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_ATP = "jdbc/sfi_trb_atp";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_CMT = "jdbc/sfi_trb_cmt";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_CSN = "jdbc/sfi_trb_csn";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_DEF = "jdbc/sfi_trb_def";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_GAE = "jdbc/sfi_trb_gae";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_GAF = "jdbc/sfi_trb_gaf";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_GCC = "jdbc/sfi_trb_gcc";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_GCD = "jdbc/sfi_trb_gcd";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_GDF = "jdbc/sfi_trb_gdf";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_GIV = "jdbc/sfi_trb_giv";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_GCO = "jdbc/sfi_trb_gco";
	
	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_CMI = "jdbc/sfi_trb_cmi";
	
	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_NFA = "jdbc/sfi_trb_nfa";	
	
	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_GML = "jdbc/sfi_trb_gml";
	
	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_GRS = "jdbc/sfi_trb_grs";
	
	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_SCR = "jdbc/sfi_trb_scr";	

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_GMF = "jdbc/sfi_trb_gmf";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_GNA = "jdbc/sfi_trb_gna";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_GPF = "jdbc/sfi_trb_gpf";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_GRE = "jdbc/sfi_trb_gre";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_GSN = "jdbc/sfi_trb_gsn";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_SIM = "jdbc/sfi_trb_sim";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_SPF = "jdbc/sfi_trb_spf";
	
	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_GEA = "jdbc/sfi_trb_gea";
	
	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_CAT = "jdbc/sfi_trb_cat";
	
	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_GDE = "jdbc/sfi_trb_gde";
	
	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_MIG = "jdbc/sfi_trb_mig";
	
	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_DMI = "jdbc/sfi_trb_dmi";
	
	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_GOC = "jdbc/sfi_trb_goc";
	
	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_TRB_GIF = "jdbc/sfi_trb_gif";	

	//�rea Financeira
	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_FIN_ACO = "jdbc/sfi_fin_aco";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_FIN_CTB = "jdbc/sfi_fin_ctb";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_FIN_FPI = "jdbc/sfi_fin_fpi";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_FIN_GBP = "jdbc/sfi_fin_gbp";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_FIN_GCT = "jdbc/sfi_fin_gct";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_FIN_GDP = "jdbc/sfi_fin_gdp";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_FIN_GFE = "jdbc/sfi_fin_gfe";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_FIN_GFU = "jdbc/sfi_fin_gfu";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_FIN_GPA = "jdbc/sfi_fin_gpa";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_FIN_GRC = "jdbc/sfi_fin_grc";
	
	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_FIN_PLF = "jdbc/sfi_fin_plf";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_FIN_SIA = "jdbc/sfi_fin_sia";
	
	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_FIN_SIC = "jdbc/sfi_fin_sic";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_FIN_GPC = "jdbc/sfi_fin_gpc";

	//�rea Or�ament�ria
	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_ORC_PLO = "jdbc/sfi_orc_plo";

	//�rea Planejamento
	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_PLN_GEO = "jdbc/sfi_pln_geo";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_PLN_GPO = "jdbc/sfi_pln_gpo";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_PLN_GPP = "jdbc/sfi_pln_gpp";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_PLN_PPA = "jdbc/sfi_pln_ppa";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_PLN_SPL = "jdbc/sfi_pln_spl";
	
	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_PLN_GCF = "jdbc/sfi_pln_gcf";

	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_PLN_GCR = "jdbc/sfi_pln_gcr";
	
	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_INTEGRACAO_DETRAN_ARRECADACAO = "jdbc/int_detran_arrecadacao";
	
	/**
	 * -
	 */
	public static final String NM_CONEXAO_JNDI_INTEGRACAO_DETRAN_VEICULO = "jdbc/int_detran_veiculo";

	/**
	 * Nome dos esquemas
	 */
	public static final String NM_SCHEMA_REFERENCIA = "DBTST.";

	//�rea Comum
	/**
	 * -
	 */
	public static final String NM_SCHEMA_COM_ACG = "ADMTRB.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_COM_MSG = "ADMAPO.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_COM_SCA = "ADMAPO.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_COM_TGE = "ADMAPO.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_COM_UTL = "ADMAPO.";

	//�rea Administrativa
	/**
	 * -
	 */
	public static final String NM_SCHEMA_ADM_AMA = "ADMADM.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_ADM_GCE = "ADMADM.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_ADM_GDL = "ADMADM.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_ADM_PRT = "ADMADM.";

	//�rea Tribut�ria
	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_AAJ = "ADMTRB.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_AJU = "ADMTRB.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_ATP = "ADMTRB.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_CMT = "ADMTRB.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_CSN = "ADMTRB.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_DEF = "ADMTRB.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_GAE = "ADMTRB.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_GAF = "ADMTRB.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_GCC = "ADMTRB.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_GCD = "ADMTRB.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_GDF = "ADMTRB.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_GIV = "ADMTRB.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_GCO = "ADMTRB.";
	
	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_CMI = "ADMTRB.";
	
	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_NFA = "ADMTRB.";
	
	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_GML = "ADMTRB.";
	
	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_GRS = "ADMTRB.";
	
	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_SCR = "ADMTRB.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_GMF = "ADMTRB.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_GNA = "ADMTRB.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_GPF = "ADMTRB.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_GRE = "ADMTRB.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_GSN = "ADMTRB.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_SIM = "ADMTRB.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_SPF = "ADMTRB.";
	
	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_GEA = "ADMTRB.";
	
	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_CAT = "ADMTRB.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_GDE = "ADMTRB.";
	
	/**
	 * -
	 */
	public static final String NM_SCHEMA_TRB_MIG = "ADMTRB.";
	
	/**
	 * -
	 */	
	public static final String NM_SCHEMA_TRB_DMI = "ADMTRB.";
	
	/**
	 * -
	 */	
	public static final String NM_SCHEMA_TRB_GOC = "ADMTRB.";
	
	/**
	 * -
	 */	
	public static final String NM_SCHEMA_TRB_GIF = "ADMTRB.";	

	//�rea Financeira
	/**
	 * -
	 */
	public static final String NM_SCHEMA_FIN_ACO = "ADMFIN.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_FIN_CTB = "ADMFIN.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_FIN_FPI = "ADMFIN.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_FIN_GBP = "ADMFIN.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_FIN_GCT = "ADMFIN.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_FIN_GDP = "ADMFIN.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_FIN_GFE = "ADMFIN.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_FIN_GFU = "ADMFIN.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_FIN_GPA = "ADMFIN.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_FIN_GRC = "ADMFIN.";
	
	/**
	 * -
	 */
	public static final String NM_SCHEMA_FIN_PLF = "ADMFIN.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_FIN_SIA = "ADMFIN.";
	
	/**
	 * -
	 */
	public static final String NM_SCHEMA_FIN_SIC = "ADMFIN.";
	
	/**
	 * -
	 */
	public static final String NM_SCHEMA_FIN_GPC = "ADMFIN.";

	//�rea Or�ament�ria
	/**
	 * -
	 */
	public static final String NM_SCHEMA_ORC_PLO = "ADMPLN.";

	//�rea Planejamento
	/**
	 * -
	 */
	public static final String NM_SCHEMA_PLN_GEO = "ADMPLN.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_PLN_GPO = "ADMPLN.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_PLN_GPP = "ADMPLN.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_PLN_PPA = "ADMPLN.";

	/**
	 * -
	 */
	public static final String NM_SCHEMA_PLN_SPL = "ADMPLN.";
	
	/**
	 * -
	 */
	public static final String NM_SCHEMA_PLN_GCF = "ADMPLN.";
	
	/**
	 * -
	 */
	public static final String NM_SCHEMA_PLN_GCR = "ADMPLN.";	

	/**
	 * Nome dos Contextos Web dos Sistemas
	 */
	public static final String NM_CONTEXTO_WEB = "sfi";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_REFERENCIA = "sfi_referencia";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_AJUDA = "sfi_ajuda";

	//�rea Comum
	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_COM_ACG = "sfi_com_acg";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_COM_MSG = "sfi_com_msg";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_COM_ACG_MANUTENCAOCADASTRAL = "sfi_com_acg_manutencaocadastral";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_COM_SCA = "sfi_com_sca";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_COM_SCA_CONSULTAHISTORICO = "sfi_com_sca_consultahistorico";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_COM_TGE = "sfi_com_tge";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_COM_TGE_MANUTENCAOCNAE = "sfi_com_tge_manutencaocnae";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_COM_UTL = "sfi_com_utl";

	//�rea Administrativa
	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_ADM_AMA = "sfi_adm_ama";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_ADM_GCE = "sfi_adm_gce";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_ADM_GDL = "sfi_adm_gdl";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_ADM_PRT = "sfi_adm_prt";

	//�rea Tribut�ria
	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_AAJ = "sfi_trb_aaj";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_AJU = "sfi_trb_aju";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_ATP = "sfi_trb_atp";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_CMT = "sfi_trb_cmt";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_CSN = "sfi_trb_csn";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_DEF = "sfi_trb_def";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_GAE = "sfi_trb_gae";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_GAF = "sfi_trb_gaf";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_GCC = "sfi_trb_gcc";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_GCD = "sfi_trb_gcd";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_GDF = "sfi_trb_gdf";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_GIV = "sfi_trb_giv";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_GCO = "sfi_trb_gco";
	
	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_CMI = "sfi_trb_cmi";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_NFA = "sfi_trb_nfa";	
	
	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_GML = "sfi_trb_gml";
	
	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_GRS = "sfi_trb_grs";
	
	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_SCR = "sfi_trb_scr";	

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_GMF = "sfi_trb_gmf";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_GNA = "sfi_trb_gna";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_GPF = "sfi_trb_gpf";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_GRE = "sfi_trb_gre";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_GSN = "sfi_trb_gsn";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_SIM = "sfi_trb_sim";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_SPF = "sfi_trb_spf";
	
	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_GEA = "sfi_trb_gea";
	
	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_CAT = "sfi_trb_cat";
	
	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_GDE = "sfi_trb_gde";
	
	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_MIG = "sfi_trb_mig";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_DMI = "sfi_trb_dmi";
	
	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_GOC = "sfi_trb_goc";
	
	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_TRB_GIF = "sfi_trb_gif";	

	//�rea Financeira
	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_FIN_ACO = "sfi_fin_aco";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_FIN_CTB = "sfi_fin_ctb";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_FIN_FPI = "sfi_fin_fpi";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_FIN_GBP = "sfi_fin_gbp";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_FIN_GCT = "sfi_fin_gct";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_FIN_GDP = "sfi_fin_gdp";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_FIN_GFE = "sfi_fin_gfe";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_FIN_GFU = "sfi_fin_gfu";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_FIN_GPA = "sfi_fin_gpa";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_FIN_GRC = "sfi_fin_grc";
	
	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_FIN_PLF = "sfi_fin_plf";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_FIN_SIA = "sfi_fin_sia";
	
	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_FIN_SIC = "sfi_fin_sic";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_FIN_GPC = "sfi_fin_gpc";

	//�rea Or�ament�ria
	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_ORC_PLO = "sfi_orc_plo";

	//�rea Planejamento
	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_PLN_GEO = "sfi_pln_geo";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_PLN_GPO = "sfi_pln_gpo";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_PLN_GPP = "sfi_pln_gpp";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_PLN_PPA = "sfi_pln_ppa";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_PLN_SPL = "sfi_pln_spl";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_PLN_GCF = "sfi_pln_gcf";

	/**
	 * -
	 */
	public static final String NM_CONTEXTO_WEB_PLN_GCR = "sfi_pln_gcr";
	
	/**
	 * Tipos de V�nculos estabelecidos entre Pessoas e a SEFAZ-PE
	 */
	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_CONTRIBUINTE_ICMS = 1;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_FORNECEDOR = 2;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_CREDOR = 3;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_CONTRIBUINTE_OUTRO_ESTADO = 6;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_BANCO = 7;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_ORGAO = 8;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_CONTADOR = 9;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_PROCESSO_FISCAL = 10;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_PROCESSO_FISCAL_CORESPONSAVEL = 11;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_SERVIDOR = 13;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_PESSOA_VINCULADA_EMPRESA = 14;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_PLANEJAMENTO_ORCAMENTARIO = 15;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_ACAO_CONTRA_SEFAZ = 17;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_ACAO_CONTRA_ORDEM_TRIBUTARIA = 18;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_CIRCULACAO_MERCADORIA = 19;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_DOCUMENTOS_FISCAIS = 20;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_EQUIPAMENTOS_ECF = 21;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_PROCESSAMENTO_DADOS = 22;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_CONTRIBUINTE_ICD = 23;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_ESTAGIARIO = 24;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_PRESTADOR_SERVICOS = 26;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_RECOLHIMENTO_EVENTUAL = 28;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_DIVIDA_PUBLICA = 29;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_DEMANDA = 30;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_CONVENIO = 31;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_PESSOA_VINCULADA_EMPRESA_NAO_CONST = 32;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_CLIENTE = 34;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_GESTOR_CONTABIL = 35;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_NOTA_FISCAL_AVULSA = 37;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_DOCUMENTOS_ECONOMICO_FISCAIS = 39;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_EMPRESA_SOB_ACAO_FISCAL = 41;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_DENUNCIADO_VIA_OUVIDORIA = 44;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_ALVO_LAVRATURA_PAT = 45;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_INTERESSADO_PRT = 47;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_PRE_CADASTRAMENTO = 99;

	/**
	 * -
	 */
	public static final short CD_TIPO_VINCULO_TESTE_MANUTENCAO_CADASTRAL = 27;

	/**
	 * Qualificadores dos tipos de V�nculos estabelecidos entre Pessoas e a SEFAZ-PE
	 */
	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_CONTRIBUINTE_ICMS = 1;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_CREDOR = 3;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_FIEL_DEPOSITARIO = 4;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_ENTIDADE_BENEFICIARIA = 5;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_CONTRIBUINTE_OUTRO_ESTADO = 6;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_AGENTE_ARRECADADOR = 7;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_ORGAO_EXTERNO = 8;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_CONTADOR = 9;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_AUTUADO = 10;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_ORGAO_ORCAMENTARIO = 11;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_GERENTE_PROGRAMA_GOVERNO = 12;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_GESTOR_ACAO = 13;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_SOCIO = 14;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_SERVIDOR_SEFAZ = 15;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_UNIDADE_GESTORA = 16;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_AUTOR_ACAO = 17;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_PROCURADOR = 18;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_ADVOGADO = 19;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_JUIZ = 20;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_REU = 21;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_TESTEMUNHA = 22;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_CONTRIBUINTE_ICD = 23;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_ESTAGIARIO = 24;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_GESTOR_CLASSE = 26;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_RECOLHIMENTO_EVENTUAL = 28;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_PROMOTOR = 29;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_DEMANDANTE_SOLICITACAO = 30;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_OUTROS_SERVIDORES = 31;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_AUTOR_EMENDAS = 32;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_REPRESENTANTE_LEGAL = 33;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_ADMINISTRADOR = 34;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_REPRESENTANTE_TECNICO = 35;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_OUTROS_CREDORES = 36;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_PRESTADOR_SERVICOS = 37;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_FORNECEDOR_MATERIAL = 38;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_ORDENADOR_DESPESA = 39;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_RECEBEDOR_REPASSE_FINANCEIRO = 40;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_DEVEDOR_OUTROS_ORGAOS = 41;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_RECEBEDOR_SUPRIMENTO_INSTITUCIONAL = 42;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_RECEBEDOR_SUPRIMENTO_INDIVIDUAL = 43;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_RECEBEDOR_TRANSFERENCIA = 44;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_GESTOR_CONTABIL = 45;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_AUTUANTE = 46;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_AVALISTA = 47;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_FIADOR = 48;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_SOCIO_GERENTE = 49;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_RESPONSAVEL = 50;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_JULGADOR = 51;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_TRANSPORTADORA = 52;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_PROPRIETARIO_EMPRESA_NAO_CONSTITUIDA = 53;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_CREDOR_DIVIDA_PUBLICA = 54;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_MOTORISTA = 55;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_IMPORTADOR = 56;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_DESPACHANTE_ADUANEIRO = 57;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_TOMADOR_EMPRESTIMO = 58;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_TOMADOR = 59;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_GARANTIDOR = 60;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_CONTRATANTE_SERVICO = 61;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_CONCEDENTE_CONVENIO = 64;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_PREFEITURAS = 67;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_BANCO = 71;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_EMPRESA_INTERVENTORA = 73;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_TECNICO_INTERVENTOR = 74;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_FORNECEDOR_PROGRAMA_APLICATIVO = 75;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_FORNECEDOR_SOFTWARE = 76;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_GRAFICA = 79;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_FORNECEDOR_FORMULARIO_SEGURANCA = 80;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_TRANSPORTADOR_AUTONOMO = 81;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_REMETENTE_NFA = 82;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_EXECUTOR = 83;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_REGULADOR = 84;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_GESTOR_FORNECEDORES = 86;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_DESTINATARIO_NFA = 87;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_EM_CADASTRAMENTO = 90;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_UNIDADE_AUDITAVEL = 91;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_ORGAO_CONVENIO_DEBITO_DIVIDA_ATIVA = 92;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_FABRICANTE_DE_SELOS_FISCAIS = 93;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_FUNCIONARIO_DE_PREFEITURA = 94;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_REPRESENTANTE_PERANTE_A_SEFAZ = 95;

	/**
	 * Utilizar CD_QUALIFICADOR_TIPO_VINCULO_RESPONSAVEL_EXTRAVIO
	 *
	 * @deprecated
	 */
	public static final short CD_QUALIFICADOR_RESPONSAVEL_EXTRAVIO = 97;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_RESPONSAVEL_EXTRAVIO = 97;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_PRE_CADASTRAMENTO = 99;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_EMPRESA_EM_OPERACAO_FISCAL = 105;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_RESPONSAVEL_A_DAR_CIENCIA = 109;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_PROCURADOR_A_DAR_CIENCIA = 110;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_FUNCIONARIO_DE_TRANSPORTADORA = 111;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_DENUNCIADO_VIA_OUVIDORIA = 112;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_FUNCIONARIO_DE_DISTRIBUIDORA_FORMULARIO_SEGURANCA = 113;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_FUNCIONARIO_DE_FABRICANTE_FORMULARIO_SEGURANCA = 114;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_REPRESENTANTE_DE_FABRICANTE_FORMULARIO_SEGURANCA = 115;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_DISTRIBUIDOR_FORMULARIO_SEGURANCA = 116;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_ALVO_CIENCIA_PAT = 117;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_PROTOCOLAR_DOCUMENTO = 125;

	/**
	 * -
	 */
	public static final short CD_QUALIFICADOR_TIPO_VINCULO_TESTE_MANUTENCAO_CADASTRAL = 27;

	/**
	 * Poss�veis situa��es para itens de um mestre detalhe
	 */
	public static final String CD_ACAO_DETALHE_SEM_ACAO = "NOP";

	/**
	 * -
	 */
	public static final String CD_ACAO_DETALHE_INCLUSAO = "INCLUSAO";

	/**
	 * -
	 */
	public static final String CD_ACAO_DETALHE_ALTERACAO = "ALTERACAO";

	/**
	 * -
	 */
	public static final String CD_ACAO_DETALHE_EXCLUSAO = "EXCLUSAO";

	/**
	 * Identificador da coluna de a��o sobre detalhes
	 */
	public static final String NM_COL_ACAO_DETALHE = "AcaoDetalhe";

	/**
	 * C�digos dos Tipos de Unidades
	 */
	public static final String CD_TIPO_UNIDADE_ORGANIZACIONAL = "1";

	/**
	 * -
	 */
	public static final String CD_TIPO_UNIDADE_ORGANIZACIONAL_CENTRAL_MALOTE = "1_1";

	/**
	 * -
	 */
	public static final String CD_TIPO_UNIDADE_GESTORA = "2";

	/**
	 * -
	 */
	public static final String CD_TIPO_UNIDADE_ORCAMENTARIA = "3";

	/**
	 * Tipo de Usu�rio Servidor Fazend�rio
	 */
	public static final short CD_TIPO_USUARIO_SERVIDOR_SEFAZ = 1;

	/**
	 * Tipo de Usu�rio Servidor Estadual
	 */
	public static final short CD_TIPO_USUARIO_SERVIDOR_ESTADO = 2;

	/**
	 * Tipo de Usu�rio Contribuinte, S�cio e Contador
	 */
	public static final short CD_TIPO_USUARIO_CONTRIBUINTE = 3;

	/**
	 * Tipo de Usu�rio Prestador de Servi�o
	 */
	public static final short CD_TIPO_USUARIO_PRESTADOR_SERVICO = 4;

	/**
	 * Tipo de Usu�rio de Outros Governos ou Outras Institui��es
	 */
	public static final short CD_TIPO_USUARIO_OUTROS_GOVERNOS = 5;

	/**
	 * Tipo de Usu�rio Funcion�rio de Gr�fica
	 */
	public static final short CD_TIPO_USUARIO_FUNCIONARIO_GRAFICA = 5;

	/**
	 * Tipo de Usu�rio Despachante
	 */
	public static final short CD_TIPO_USUARIO_DESPACHANTE = 6;

	/**
	 * Tipo de Mensagen ao Usuario Principal
	 */
	public static final short CD_TIPO_MENSAGEM_USUARIO_PRINCIPAL = 1;

	/**
	 * Tipo de Mensagen ao Usuario Complementar
	 */
	public static final short CD_TIPO_MENSAGEM_USUARIO_COMPLEMENTAR = 2;

	/**
	 * Tipo de Mensagen ao Usuario de Orienta��o
	 */
	public static final short CD_TIPO_MENSAGEM_USUARIO_ORIENTACAO = 3;

	/**
	 * Tipo de Mensagen ao Usuario de Alerta
	 */
	public static final short CD_TIPO_MENSAGEM_USUARIO_ALERTA = 4;

	/**
	 * Tipo de Mensagen ao Usuario de e-mail
	 */
	public static final short CD_TIPO_MENSAGEM_USUARIO_EMAIL = 5;

	/**
	 * Tipo de Mensagen ao Usuario de texto
	 */
	public static final short CD_TIPO_MENSAGEM_USUARIO_TEXTO = 6;

	/**
	 * C�digos dos Tipos de Unidades Gestoras
	 */
	public static final String CD_TIPO_UG_COORDENADORA = "C";

	/**
	 * -
	 */
	public static final String CD_TIPO_UG_SUB_COORDENADORA = "SC";

	/**
	 * -
	 */
	public static final String CD_TIPO_UG_EXECUTORA = "E";

	/**
	 * -
	 */
	public static final String CD_TIPO_UG_FINANCEIRA = "F";

	/**
	 * -
	 */
	public static final String CD_TIPO_UG_SETORIAL_CONTABIL = "ST";

	/**
	 * -
	 */
	public static final String CD_TIPO_UG_CONTABIL_GERAL = "CT";

	/**
	 * -
	 */
	public static final String CD_TIPO_UG_ORCAMENTARIA = "O";

	/**
	 * -
	 */
	public static final String CD_TIPO_UG_AUDITORIA_GERAL = "A";

	/**
	 * -
	 */
	public static final String CD_TIPO_UG_RESERVA_DE_CONTINGENCIA = "RC";

	/**
	 * C�digos dos Tipos de N�vel de Natureza de Despesa
	 */
	public static final String NATUREZA_DESPESA_TP_NIVEL_CATEGORIA_ECONOMICA = "C";

	/**
	 * -
	 */
	public static final String NATUREZA_DESPESA_TP_NIVEL_GRUPO_DESPESA = "G";

	/**
	 * -
	 */
	public static final String NATUREZA_DESPESA_TP_NIVEL_MODALIDADE_APLICACAO = "M";

	/**
	 * -
	 */
	public static final String NATUREZA_DESPESA_TP_NIVEL_ELEMENTO_DESPESA = "E";

	/**
	 * -
	 */
	public static final String NATUREZA_DESPESA_TP_NIVEL_ITEM_GASTO = "I";

	/**
	 * C�digo e descricao dos Meses do Ano
	 */
	public static final String CD_MES_JANEIRO = "01";

	/**
	 * -
	 */
	public static final String CD_MES_FEVEREIRO = "02";

	/**
	 * -
	 */
	public static final String CD_MES_MARCO = "03";

	/**
	 * -
	 */
	public static final String CD_MES_ABRIL = "04";

	/**
	 * -
	 */
	public static final String CD_MES_MAIO = "05";

	/**
	 * -
	 */
	public static final String CD_MES_JUNHO = "06";

	/**
	 * -
	 */
	public static final String CD_MES_JULHO = "07";

	/**
	 * -
	 */
	public static final String CD_MES_AGOSTO = "08";

	/**
	 * -
	 */
	public static final String CD_MES_SETEMBRO = "09";

	/**
	 * -
	 */
	public static final String CD_MES_OUTUBRO = "10";

	/**
	 * -
	 */
	public static final String CD_MES_NOVEMBRO = "11";

	/**
	 * -
	 */
	public static final String CD_MES_DEZEMBRO = "12";

	/**
	 * -
	 */
	public static final String DS_MES_JANEIRO = "Janeiro";

	/**
	 * -
	 */
	public static final String DS_MES_FEVEREIRO = "Fevereiro";

	/**
	 * -
	 */
	public static final String DS_MES_MARCO = "Mar�o";

	/**
	 * -
	 */
	public static final String DS_MES_ABRIL = "Abril";

	/**
	 * -
	 */
	public static final String DS_MES_MAIO = "Maio";

	/**
	 * -
	 */
	public static final String DS_MES_JUNHO = "Junho";

	/**
	 * -
	 */
	public static final String DS_MES_JULHO = "Julho";

	/**
	 * -
	 */
	public static final String DS_MES_AGOSTO = "Agosto";

	/**
	 * -
	 */
	public static final String DS_MES_SETEMBRO = "Setembro";

	/**
	 * -
	 */
	public static final String DS_MES_OUTUBRO = "Outubro";

	/**
	 * -
	 */
	public static final String DS_MES_NOVEMBRO = "Novembro";

	/**
	 * -
	 */
	public static final String DS_MES_DEZEMBRO = "Dezembro";

	/**
	 * C�digos e Descri��o referentes ao dia da semana
	 *
	 * @see Calendar
	 */
	public static final int CD_DIA_SEMANA_DOMINGO = Calendar.SUNDAY;

	/**
	 * -
	 */
	public static final int CD_DIA_SEMANA_SEGUNDA = Calendar.MONDAY;

	/**
	 * -
	 */
	public static final int CD_DIA_SEMANA_TERCA = Calendar.TUESDAY;

	/**
	 * -
	 */
	public static final int CD_DIA_SEMANA_QUARTA = Calendar.WEDNESDAY;

	/**
	 * -
	 */
	public static final int CD_DIA_SEMANA_QUINTA = Calendar.THURSDAY;

	/**
	 * -
	 */
	public static final int CD_DIA_SEMANA_SEXTA = Calendar.FRIDAY;

	/**
	 * -
	 */
	public static final int CD_DIA_SEMANA_SABADO = Calendar.SATURDAY;

	/**
	 * -
	 */
	public static final String DS_DIA_SEMANA_DOMINGO = "Domingo";

	/**
	 * -
	 */
	public static final String DS_DIA_SEMANA_SEGUNDA = "Segunda-Feira";

	/**
	 * -
	 */
	public static final String DS_DIA_SEMANA_TERCA = "Ter�a-Feira";

	/**
	 * -
	 */
	public static final String DS_DIA_SEMANA_QUARTA = "Quarta-Feira";

	/**
	 * -
	 */
	public static final String DS_DIA_SEMANA_QUINTA = "Quinta-Feira";

	/**
	 * -
	 */
	public static final String DS_DIA_SEMANA_SEXTA = "Sexta-Feira";

	/**
	 * -
	 */
	public static final String DS_DIA_SEMANA_SABADO = "S�bado";

	/**
	 * Nome da PR do SCA respons�vel pelo logout de usu�rios
	 */
	public static final String NM_PR_EFETUAR_LOGOUT = "PREfetuarLogout";

	/**
	 * Nome da PR do SCA respons�vel pela montagem do menu
	 */
	public static final String NM_PR_MONTAR_MENU_ACESSO = "PRMontarMenuAcesso";

	/**
	 * Nome da PR do SCA respons�vel pela manuten��o de favoritos
	 */
	public static final String NM_PR_GERENCIAR_FAVORITOS = "PRGerenciarFavoritos";

	/**
	 * Nome da PR do ACG respons�vel pela atualiza��o de endere�o de domic�lio
	 */
	public static final String NM_PR_ATUALIZAR_ENDERECO_DOMICILIO = "PRSolicitarAtualizacaoEnderecoDomicilio";

	/**
	 * Nome da PR do TGE respons�vel pela consulta de CEP
	 */
	public static final String NM_PR_CONSULTAR_CEP = "PRConsultarCEP";

	/**
	 * Nome da PR do TGE respons�vel pela consulta de se��o logradouro
	 */
	public static final String NM_PR_MANTER_SECAO_LOGRADOURO = "PRManterSecaoLogradouro";

	/**
	 * Nome da PR do TGE respons�vel pela consulta de logradouro
	 */
	public static final String NM_PR_MANTER_LOGRADOURO = "PRManterLogradouro";

	/**
	 * Nome da PR do TGE respons�vel pela consulta de localidade
	 */
	public static final String NM_PR_MANTER_LOCALIDADE = "PRManterLocalidade";

	/**
	 * Nome da PR do TGE respons�vel pela consulta de municipio
	 */
	public static final String NM_PR_MANTER_MUNICIPIO = "PRManterMunicipio";

	/**
	 * Nome padr�o da servlet Ajax do DWR
	 */
	public static final String NM_SERVLET_AJAX_DWR = "ServletAjaxDwr";
	
	/**
	 * Id do HTTP Header "User Agent"
	 */
	public static final String ID_HTTP_HEADER_USER_AGENT = "User-Agent";
	
	/**
	 * Id do HTTP Header "User Agent"
	 */
	public static final String ID_HTTP_HEADER_UA_COMPATIBLE = "X-UA-Compatible";
	
	/**
	 * Id do HTTP Header "Cache-Control"
	 */
	public static final String ID_HTTP_HEADER_CACHE_CONTROL = "Cache-Control";
	
	/**
	 * Valor do header "UA_COMPATIBLE" para IE.
	 */
	public static final String VL_PADRAO_HTTP_HEADER_UA_COMPATIBLE_IE = "IE=9";
	
	/**
	 * Valor do header "Cache-Control" para arquivos est�ticos.
	 */
	public static final String VL_PADRAO_HTTP_HEADER_CACHE_CONTROL = "max-age=43200";
	
	/**
	 * Trecho do HTTP Header "User Agent" quando Internet Explorer
	 */
	public static final String TX_HTTP_HEADER_USER_AGENT_MSIE = "MSIE ";
	
	/**
	 * Trecho do HTTP Header "User Agent" quando Internet Explorer vers�o maior ou igual a 8.
	 */
	public static final String TX_HTTP_HEADER_USER_AGENT_TRIDENT = "Trident/";
	
	/**
	 * Nome do navegador Internet Explorer
	 */
	public static final String DS_NAVEGADOR_MSIE = "Internet Explorer";
	
	/**
	 * Nome da propriedade com a quantidade de segundos padrao  para atualiza��o de arquivos de propriedades.
	 */
	public static final String NM_PROP_QT_SEGS_ATUALIZACAO_PROPRIEDADES = "QtSegsAtualizacaoPropriedades";
	
	/**
	 * Quantidade padrao de segundos para atualiza��o de arquivos de propriedades.
	 */
	public static final int QT_SEGS_ATUALIZACAO_PROPRIEDADES = 2;
	
	/**
	 * Nome do usu�rio do sistema operacional
	 */
	public static final String NM_USUARIO_SO = System.getProperty("user.name");
	
	/**
	 * Quantidade m�xima de megabytes por arquivo de trace transa��o.
	 */
	public static final int QT_MAX_MB_ARQUIVO_TRACE_TRANSACAO = 300;
	
	/**
	 * Quantidade m�xima de megabytes por arquivo de trace transa��o.
	 */
	public static final int QT_MAX_MB_REQUISICAO_POST = 20;

	/**
	 * Utilizado pelo trace transa��o. Representa o nome da classe que realizou a chamada de m�todo quando esta for indeterminada.
	 */
	public static final String NM_CLASSE_CHAMADORA_INDETERMINADA = "?";

	/**
	 * 
	 */
	private static boolean aInBibliotecasInicializadas;

	/**
	 * 
	 */
	private static String aNmClasseConstantesEmInicializacao;

	//~ Construtores ---------------------------------------------------------------------------------------------------------------

/**
         * Cria um novo objeto Constantes.
         */
	public Constantes() {
	}

	//~ Metodos --------------------------------------------------------------------------------------------------------------------

	/**
	 * -
	 *
	 * @return
	 */
	public static Constantes getInstancia() {
		if (Constantes.aInstancia == null) {
			Constantes.aInstancia = new Constantes();
		}

		return Constantes.aInstancia;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static boolean getInBibliotecasInicializadas() {
		return aInBibliotecasInicializadas;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static String getNmClasseConstantesEmInicializacao() {
		return aNmClasseConstantesEmInicializacao;
	}

}
