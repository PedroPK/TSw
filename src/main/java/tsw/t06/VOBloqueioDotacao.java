package tsw.t06;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Value Object da Entidade BloqueioDotacao
 */
public class VOBloqueioDotacao extends VOEntidade {
	
	public static final String ID_OBJETO = "orc.plo.servico06.VOBloqueioDotacao";
	
	public static final String DS_ENTIDADE = "Bloqueio de Dotação";
	public static final String NM_ENTIDADE = ConstantesPLO.NM_SCHEMA_ORC_PLO
			+ "PLO_BLOQUEIO_DOTACAO";
	public static final String NM_ATR_CtbDtAnoExercicio = "CTBEXERC_DT_ANO";
	public static final String NM_ATR_NuBloqueioDotacao = "PLOBLOQDOT_NU";
	public static final String NM_ATR_CdUnidadeGestora = "UG_CD";
	public static final String NM_ATR_CdUnidadeGestoraGestao = "GFUGESTAO_CD";
	public static final String NM_ATR_SqUnidadeGestoraGestao = "UGGESTAO_SQ";
	public static final String NM_ATR_DtBloqueioDotacao = "PLOBLOQDOT_DT_INCLUSAO";
	public static final String NM_ATR_DtBloqueioDotacaoRefCtb = "PLOBLOQDOT_DT_REF_CTB";
	
	public static final String DS_ATR_CtbDtAnoExercicio = "CtbDtAnoExercicio";
	public static final String DS_ATR_NuBloqueioDotacao = "Número Bloqueio Dotacao";
	public static final String DS_ATR_CdUnidadeGestora = "Unidade Gestora";
	public static final String DS_ATR_CdUnidadeGestoraGestao = "CdUnidadeGestoraGestao";
	public static final String DS_ATR_SqUnidadeGestoraGestao = "Número";
	public static final String DS_ATR_DtBloqueioDotacao = "Data BloqueioDotacao";
	public static final String DS_ATR_DtBloqueioDotacaoRefCtb = "Data BloqueioDotacaoRefCtb";
	
	private static final String[] aNmAtributosChavePrimaria = new String[] {
		VOBloqueioDotacao.NM_ATR_CtbDtAnoExercicio,
		VOBloqueioDotacao.NM_ATR_NuBloqueioDotacao
	};
	
	private static final Class[] aTpAtributosChavePrimaria = new Class[] {
		Short.class, 
		Integer.class
	};
	
	private static final String[] aNmAtributos = new String[] {
		VOBloqueioDotacao.NM_ATR_CdUnidadeGestora,
		VOBloqueioDotacao.NM_ATR_CdUnidadeGestoraGestao,
		VOBloqueioDotacao.NM_ATR_SqUnidadeGestoraGestao,
		VOBloqueioDotacao.NM_ATR_DtBloqueioDotacao,
		VOBloqueioDotacao.NM_ATR_DtBloqueioDotacaoRefCtb,
		VOBloqueioDotacao.NM_ATR_CdUsuarioUltimaAlteracao,
		VOBloqueioDotacao.NM_ATR_DhUltimaAlteracao
	};
	
	private static final Class[] aTpAtributos = new Class[] { 
		String.class,
		String.class, 
		Short.class, 
		Date.class, 
		Date.class, 
		String.class,
		String.class, 
		Timestamp.class
	};
	
	private Short aCtbDtAnoExercicio;
	private boolean aCtbDtAnoExercicioAlterado = false;
	
	private Integer aNuBloqueioDotacao;
	private boolean aNuBloqueioDotacaoAlterado = false;
	
	private TextoCaixaAlta aCdUnidadeGestora;
	private boolean aCdUnidadeGestoraAlterado = false;
	
	private TextoCaixaAlta aCdUnidadeGestoraGestao;
	private boolean aCdUnidadeGestoraGestaoAlterado = false;
	
	private Short aSqUnidadeGestoraGestao;
	private boolean aSqUnidadeGestoraGestaoAlterado = false;
	
	private Data aDtBloqueioDotacao;
	private boolean aDtBloqueioDotacaoAlterado = false;
	
	private Data aDtBloqueioDotacaoRefCtb;
	private boolean aDtBloqueioDotacaoRefCtbAlterado = false;
	
	public VOBloqueioDotacao() {
		super(aNmAtributosChavePrimaria, aNmAtributos, aTpAtributosChavePrimaria, aTpAtributos);
	}
	
	public VOBloqueioDotacao(
		Short		pCtbDtAnoExercicio, 
		Integer		pNuBloqueioDotacao)
	throws ExcecaoAtributoInvalido, ExcecaoParametroInvalido {
		super(aNmAtributosChavePrimaria, aNmAtributos, aTpAtributosChavePrimaria, aTpAtributos);
		this.setCtbDtAnoExercicio(pCtbDtAnoExercicio);
		this.setNuBloqueioDotacao(pNuBloqueioDotacao);
	}
	
	/**
	 * Constrói um Value Object a partir de um objeto VOGenerico
	 */
	public static VOBloqueioDotacao fromVOGenerico(
		VOGenerico	pVOGenerico,
		boolean		pSomenteChavePrimaria)
	throws ExcecaoParametroInvalido, ExcecaoCampoInvalido, ExcecaoAtributoInvalido {
		VOBloqueioDotacao voBloqueioDotacao = new VOBloqueioDotacao();
		if ( pVOGenerico.isAtributoValidoNaoNulo(VOBloqueioDotacao.NM_ATR_CtbDtAnoExercicio) ) {
			voBloqueioDotacao
				.setCtbDtAnoExercicio(new Short(
					((Number) pVOGenerico
							.getAtributo(VOBloqueioDotacao.NM_ATR_CtbDtAnoExercicio))
							.shortValue()));
		}
		
		if ( pVOGenerico.isAtributoValidoNaoNulo(VOBloqueioDotacao.NM_ATR_NuBloqueioDotacao) ) {
			voBloqueioDotacao.setNuBloqueioDotacao(
				(Integer) pVOGenerico
					.getAtributo(VOBloqueioDotacao.NM_ATR_NuBloqueioDotacao));
		}
		
		if ( !pSomenteChavePrimaria ) {
			if ( pVOGenerico.isAtributoValidoNaoNulo(VOBloqueioDotacao.NM_ATR_CdUnidadeGestora) ) {
				voBloqueioDotacao
					.setCdUnidadeGestora(
						(String) pVOGenerico
							.getAtributo(VOBloqueioDotacao.NM_ATR_CdUnidadeGestora));
			}
			
			if ( pVOGenerico.isAtributoValidoNaoNulo(VOBloqueioDotacao.NM_ATR_CdUnidadeGestoraGestao) ) {
				voBloqueioDotacao
					.setCdUnidadeGestoraGestao(
						(String) pVOGenerico
							.getAtributo(VOBloqueioDotacao.NM_ATR_CdUnidadeGestoraGestao));
			}
			
			if ( pVOGenerico.isAtributoValidoNaoNulo(VOBloqueioDotacao.NM_ATR_SqUnidadeGestoraGestao) ) {
				voBloqueioDotacao
					.setSqUnidadeGestoraGestao(new Short(
						((Number) pVOGenerico
								.getAtributo(VOBloqueioDotacao.NM_ATR_SqUnidadeGestoraGestao))
								.shortValue()));
			}
			
			if ( pVOGenerico.isAtributoValidoNaoNulo(VOBloqueioDotacao.NM_ATR_DtBloqueioDotacao) ) {
				voBloqueioDotacao
					.setDtBloqueioDotacao(
						(Date) pVOGenerico
							.getAtributo(VOBloqueioDotacao.NM_ATR_DtBloqueioDotacao));
			}
			
			if ( pVOGenerico.isAtributoValidoNaoNulo(VOBloqueioDotacao.NM_ATR_DtBloqueioDotacaoRefCtb) ) {
				voBloqueioDotacao
					.setDtBloqueioDotacaoRefCtb(
						(Date) pVOGenerico
							.getAtributo(VOBloqueioDotacao.NM_ATR_DtBloqueioDotacaoRefCtb));
			}
			
			if ( pVOGenerico.isAtributoValidoNaoNulo(VOBloqueioDotacao.NM_ATR_CdUsuarioUltimaAlteracao) ) {
				voBloqueioDotacao
					.setCdUsuarioUltimaAlteracao(
						(String) pVOGenerico.getAtributo(VOBloqueioDotacao.NM_ATR_CdUsuarioUltimaAlteracao));
			}
		}
		
		if ( pVOGenerico.isAtributoValidoNaoNulo(VOBloqueioDotacao.NM_ATR_DhUltimaAlteracao) ) {
			voBloqueioDotacao.setDhUltimaAlteracao(
				(Timestamp) pVOGenerico.getAtributo(VOBloqueioDotacao.NM_ATR_DhUltimaAlteracao));
		}
		
		return voBloqueioDotacao;
	}
	
	public Short getCtbDtAnoExercicio() {
		return this.aCtbDtAnoExercicio;
	}
	
	public Integer getNuBloqueioDotacao() {
		return this.aNuBloqueioDotacao;
	}
	
	public String getCdUnidadeGestora() {
		return TextoCaixaAlta.toString(this.aCdUnidadeGestora);
	}
	
	public String getCdUnidadeGestoraGestao() {
		return TextoCaixaAlta.toString(this.aCdUnidadeGestoraGestao);
	}
	
	public Short getSqUnidadeGestoraGestao() {
		return this.aSqUnidadeGestoraGestao;
	}
	
	public Date getDtBloqueioDotacao() {
		return Data.toDate(this.aDtBloqueioDotacao);
	}
	
	public Date getDtBloqueioDotacaoRefCtb() {
		return Data.toDate(this.aDtBloqueioDotacaoRefCtb);
	}
	
	public boolean isCtbDtAnoExercicioAlterado() {
		return this.aCtbDtAnoExercicioAlterado;
	}
	
	public boolean isNuBloqueioDotacaoAlterado() {
		return this.aNuBloqueioDotacaoAlterado;
	}
	
	public boolean isCdUnidadeGestoraAlterado() {
		return this.aCdUnidadeGestoraAlterado;
	}
	
	public boolean isCdUnidadeGestoraGestaoAlterado() {
		return this.aCdUnidadeGestoraGestaoAlterado;
	}
	
	public boolean isSqUnidadeGestoraGestaoAlterado() {
		return this.aSqUnidadeGestoraGestaoAlterado;
	}
	
	public boolean isDtBloqueioDotacaoAlterado() {
		return this.aDtBloqueioDotacaoAlterado;
	}
	
	public boolean isDtBloqueioDotacaoRefCtbAlterado() {
		return this.aDtBloqueioDotacaoRefCtbAlterado;
	}
	
	public void setCtbDtAnoExercicio(Short pCtbDtAnoExercicio)
	throws ExcecaoValorNuloNaoPermitido, ExcecaoParametroInvalido {
		if (pCtbDtAnoExercicio == null) {
			throw new ExcecaoValorNuloNaoPermitido(
				DS_ENTIDADE,
				DS_ATR_CtbDtAnoExercicio, 
				"Erro construindo VO");
		}
		this.aCtbDtAnoExercicio = pCtbDtAnoExercicio;
		this.aCtbDtAnoExercicioAlterado = true;
		this.setAtributoChavePrimaria(
			VOBloqueioDotacao.NM_ATR_CtbDtAnoExercicio, 
			pCtbDtAnoExercicio);
	}
	
	public void setNuBloqueioDotacao(Integer pNuBloqueioDotacao)
	throws ExcecaoValorNuloNaoPermitido, ExcecaoParametroInvalido {
		if ( pNuBloqueioDotacao == null ) {
			throw new ExcecaoValorNuloNaoPermitido(
					DS_ENTIDADE,
					DS_ATR_NuBloqueioDotacao, 
					"Erro construindo VO");
		}
		this.aNuBloqueioDotacao = pNuBloqueioDotacao;
		this.aNuBloqueioDotacaoAlterado = true;
		this.setAtributoChavePrimaria(
			VOBloqueioDotacao.NM_ATR_NuBloqueioDotacao, 
			pNuBloqueioDotacao);
	}
	
	public void setCdUnidadeGestora(String pCdUnidadeGestora)
	throws ExcecaoValorNuloNaoPermitido, ExcecaoTamanhoAtributoInvalido, ExcecaoCampoInvalido, ExcecaoParametroInvalido {
		if ( pCdUnidadeGestora == null ) {
			throw new ExcecaoValorNuloNaoPermitido(
					DS_ENTIDADE,
					DS_ATR_CdUnidadeGestora, 
					this.toString());
		}
		if ( pCdUnidadeGestora.length() > 6 ) {
			throw new ExcecaoTamanhoAtributoInvalido(
					DS_ENTIDADE,
					DS_ATR_CdUnidadeGestora, 
					null, 
					"6", 
					this.toString());
		}
		this.aCdUnidadeGestora = TextoCaixaAlta.fromString(pCdUnidadeGestora);
		this.aCdUnidadeGestoraAlterado = true;
		this.setAtributo(
			VOBloqueioDotacao.NM_ATR_CdUnidadeGestora,
			TextoCaixaAlta.toString(this.aCdUnidadeGestora));
	}
	
	public void setCdUnidadeGestoraGestao(String pCdUnidadeGestoraGestao)
	throws ExcecaoValorNuloNaoPermitido, ExcecaoTamanhoAtributoInvalido, ExcecaoCampoInvalido, ExcecaoParametroInvalido {
		if ( pCdUnidadeGestoraGestao == null ) {
			throw new ExcecaoValorNuloNaoPermitido(
					DS_ENTIDADE,
					DS_ATR_CdUnidadeGestoraGestao, 
					this.toString());
		}
		if ( pCdUnidadeGestoraGestao.length() < 5 || pCdUnidadeGestoraGestao.length() > 5 ) {
			throw new ExcecaoTamanhoAtributoInvalido(
					DS_ENTIDADE,
					DS_ATR_CdUnidadeGestoraGestao, 
					"5", 
					"5", 
					this.toString());
		}
		this.aCdUnidadeGestoraGestao = TextoCaixaAlta.fromString(pCdUnidadeGestoraGestao);
		this.aCdUnidadeGestoraGestaoAlterado = true;
		this.setAtributo(
			VOBloqueioDotacao.NM_ATR_CdUnidadeGestoraGestao,
			TextoCaixaAlta.toString(this.aCdUnidadeGestoraGestao));
	}
	
	public void setSqUnidadeGestoraGestao(Short pSqUnidadeGestoraGestao)
	throws ExcecaoValorNuloNaoPermitido, ExcecaoParametroInvalido {
		if ( pSqUnidadeGestoraGestao == null ) {
			throw new ExcecaoValorNuloNaoPermitido(
					DS_ENTIDADE,
					DS_ATR_SqUnidadeGestoraGestao, 
					this.toString());
		}
		this.aSqUnidadeGestoraGestao = pSqUnidadeGestoraGestao;
		this.aSqUnidadeGestoraGestaoAlterado = true;
		this.setAtributo(
			VOBloqueioDotacao.NM_ATR_SqUnidadeGestoraGestao,
			pSqUnidadeGestoraGestao);
	}
	
	public void setDtBloqueioDotacao(Date pDtBloqueioDotacao)
	throws ExcecaoValorNuloNaoPermitido, ExcecaoCampoInvalido, ExcecaoParametroInvalido {
		if ( pDtBloqueioDotacao == null ) {
			throw new ExcecaoValorNuloNaoPermitido(
					DS_ENTIDADE,
					DS_ATR_DtBloqueioDotacao, 
					this.toString());
		}
		this.aDtBloqueioDotacao = Data.fromDate(pDtBloqueioDotacao);
		this.aDtBloqueioDotacaoAlterado = true;
		this.setAtributo(
			VOBloqueioDotacao.NM_ATR_DtBloqueioDotacao, 
			Data.toDate(this.aDtBloqueioDotacao));
	}
	
	public void setDtBloqueioDotacaoRefCtb(Date pDtBloqueioDotacaoRefCtb)
	throws ExcecaoValorNuloNaoPermitido, ExcecaoCampoInvalido, ExcecaoParametroInvalido {
		if ( pDtBloqueioDotacaoRefCtb == null ) {
			throw new ExcecaoValorNuloNaoPermitido(
					DS_ENTIDADE,
					DS_ATR_DtBloqueioDotacaoRefCtb, 
					this.toString());
		}
		this.aDtBloqueioDotacaoRefCtb = Data.fromDate(pDtBloqueioDotacaoRefCtb);
		this.aDtBloqueioDotacaoRefCtbAlterado = true;
		this.setAtributo(
			VOBloqueioDotacao.NM_ATR_DtBloqueioDotacaoRefCtb, 
			Data.toDate(this.aDtBloqueioDotacaoRefCtb));
	}
	
	/**
	 * Verifica se todos os atributos obrigatórios do Value Object foram
	 * preenchidos
	 */
	@Override
	public void validarInclusao() throws ExcecaoAtributoObrigatorioNaoPreenchido {
		if ( !this.aCtbDtAnoExercicioAlterado ) {
			throw new ExcecaoAtributoObrigatorioNaoPreenchido(
					DS_ENTIDADE,
					DS_ATR_CtbDtAnoExercicio, 
					this.toString());
		}
		if ( !this.aNuBloqueioDotacaoAlterado ) {
			throw new ExcecaoAtributoObrigatorioNaoPreenchido(
					DS_ENTIDADE,
					DS_ATR_NuBloqueioDotacao, 
					this.toString());
		}
		if (!this.aCdUnidadeGestoraAlterado) {
			throw new ExcecaoAtributoObrigatorioNaoPreenchido(
					DS_ENTIDADE,
					DS_ATR_CdUnidadeGestora, 
					this.toString());
		}
		if (!this.aCdUnidadeGestoraGestaoAlterado) {
			throw new ExcecaoAtributoObrigatorioNaoPreenchido(
					DS_ENTIDADE,
					DS_ATR_CdUnidadeGestoraGestao, 
					this.toString());
		}
		if (!this.aSqUnidadeGestoraGestaoAlterado) {
			throw new ExcecaoAtributoObrigatorioNaoPreenchido(
					DS_ENTIDADE,
					DS_ATR_SqUnidadeGestoraGestao, 
					this.toString());
		}
		if (!this.aDtBloqueioDotacaoAlterado) {
			throw new ExcecaoAtributoObrigatorioNaoPreenchido(
					DS_ENTIDADE,
					DS_ATR_DtBloqueioDotacao, 
					this.toString());
		}
		if (!this.aDtBloqueioDotacaoRefCtbAlterado) {
			throw new ExcecaoAtributoObrigatorioNaoPreenchido(
					DS_ENTIDADE,
					DS_ATR_DtBloqueioDotacaoRefCtb, 
					this.toString());
		}
	}
	
	public void preValidarInclusao() throws ExcecaoAtributoObrigatorioNaoPreenchido {
		this.validarInclusao();
	}
	
	public static String[] getNmAtributosChavePrimaria() {
		return aNmAtributosChavePrimaria;
	}
	
	public static String[] getNmAtributos() {
		return aNmAtributos;
	}
	
}