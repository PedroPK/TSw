/*
 * Este arquivo é propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informação nele contida pode ser
 * reproduzida, mostrada ou revelada sem permissão escrita da Sefaz-PE.
 */

package tsw.t06;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

/**
 *
 */
public abstract class VOEntidade extends ValueObject {
	//~ Atributos/inicializadores estaticos ----------------------------------------------------------------------------------------

	/**
	 * -
	 */
	public static final String NM_ATR_DhUltimaAlteracao = "SNCTRS_DH_ULT_ALTR";

	/**
	 * -
	 */
	public static final String NM_ATR_CdUsuarioUltimaAlteracao = "USUARIO_CD_ULT_ALTR";

	/**
	 * -
	 */
	public static final String NM_ATR_CdUsuarioInclusao = "USUARIO_CD_INCL";

	/**
	 * -
	 */
	public static final String NM_ATR_CdUsuarioUltimaManutencao = "USUARIO_CD";

	/**
	 * -
	 */
	public static final String DS_ATR_DhUltimaAlteracao = "Data-Hora da Última Alteração";

	/**
	 * -
	 */
	public static final String DS_ATR_CdUsuarioUltimaAlteracao = "Código do Usuário da Última Alteração";

	/**
	 * -
	 */
	public static final String DS_ATR_DhInclusao = "Data-Hora de Inclusão";

	/**
	 * -
	 */
	public static final String DS_ATR_CdUsuarioInclusao = "Código do Usuário da Inclusão";

	/**
	 * -
	 */
	public static final String DS_ATR_CdUsuarioUltimaManutencao = "Código do Usuário da Última Manutenção";

	/**
	 * -
	 */
	public static final String DS_ATR_InExclusaoLogica = "Indicador de Exclusão Lógica";

	//~ Atributos de instancia -----------------------------------------------------------------------------------------------------

	private ArrayList aNmAtributosPersistencia = null;
	private ArrayList aNmAtributosPersistenciaChavePrimaria = null;
	private Boolean aInExclusaoLogica = Boolean.FALSE;
	private Hashtable aAtributosInstancia = new Hashtable();
	private Hashtable aAtributosInstanciaChavePrimaria = new Hashtable();
	private Hashtable aTpAtributosInstancia = new Hashtable();
	private String aCdUsuarioInclusao = null;
	private String aCdUsuarioUltimaAlteracao = null;
	private String aCdUsuarioUltimaManutencao = null;
	private Timestamp aDhInclusao = null;
	private Timestamp aDhUltimaAlteracao = null;
	private boolean aInExclusaoLogicaAlterado = false;
	private boolean aVOAlterado = false;

	//~ Construtores ---------------------------------------------------------------------------------------------------------------

	/**
	 * Cria um novo objeto VOEntidade.
	 *
	 * @param pNmAtributosChavePrimaria
	 * @param pNmAtributos
	 */
	public VOEntidade(String[] pNmAtributosChavePrimaria, String[] pNmAtributos) {
		this.aNmAtributosPersistenciaChavePrimaria = new ArrayList(pNmAtributosChavePrimaria.length);
		this.aNmAtributosPersistencia = new ArrayList(pNmAtributos.length);

		for (int contador = 0; pNmAtributosChavePrimaria.length > contador; contador++) {
			this.aAtributosInstancia.put(pNmAtributosChavePrimaria[contador], Constantes.CD_ATRIBUTO_NULO);
			this.aAtributosInstanciaChavePrimaria.put(pNmAtributosChavePrimaria[contador], Constantes.CD_ATRIBUTO_NULO);

			this.aNmAtributosPersistenciaChavePrimaria.add(pNmAtributosChavePrimaria[contador]);
			this.aNmAtributosPersistencia.add(pNmAtributosChavePrimaria[contador]);
		}

		for (int contador = 0; pNmAtributos.length > contador; contador++) {
			this.aAtributosInstancia.put(pNmAtributos[contador], Constantes.CD_ATRIBUTO_NULO);

			this.aNmAtributosPersistencia.add(pNmAtributos[contador]);
		}
	}

	/**
	 * Cria um novo objeto VOEntidade.
	 *
	 * @param pNmAtributosChavePrimaria
	 * @param pNmAtributos
	 * @param pTpAtributosChavePrimaria
	 * @param pTpAtributos
	 */
	public VOEntidade(String[] pNmAtributosChavePrimaria, String[] pNmAtributos, Class[] pTpAtributosChavePrimaria,
		Class[] pTpAtributos) {
		this(pNmAtributosChavePrimaria, pNmAtributos);

		for (int contador = 0; pNmAtributosChavePrimaria.length > contador; contador++) {
			this.aTpAtributosInstancia.put(pNmAtributosChavePrimaria[contador], pTpAtributosChavePrimaria[contador]);
		}

		for (int contador = 0; pNmAtributos.length > contador; contador++) {
			this.aTpAtributosInstancia.put(pNmAtributos[contador], pTpAtributos[contador]);
		}
	}

	//~ Metodos --------------------------------------------------------------------------------------------------------------------

	/**
	 * Adiciona atributos no hashtable estático do VO. Utilizado quando ocorre herança entre VOs.
	 *
	 * @param pNmAtributos
	 */
	protected void adicionarAtributos(String[] pNmAtributos) {
		Enumeration keysChavePrimaria;

		this.aNmAtributosPersistencia = new ArrayList(pNmAtributos.length);

		keysChavePrimaria = this.aAtributosInstanciaChavePrimaria.keys();

		while (keysChavePrimaria.hasMoreElements()) {
			this.aNmAtributosPersistencia.add(keysChavePrimaria.nextElement().toString());
		}

		for (int contador = 0; pNmAtributos.length > contador; contador++) {
			this.aAtributosInstancia.put(pNmAtributos[contador], Constantes.CD_ATRIBUTO_NULO);

			this.aNmAtributosPersistencia.add(pNmAtributos[contador]);
		}
	}

	/**
	 * Adiciona atributos no hashtable estático do VO. Utilizado quando ocorre herança entre VOs.
	 *
	 * @param pNmAtributos
	 * @param pTpAtributos
	 */
	protected void adicionarAtributos(String[] pNmAtributos, Class[] pTpAtributos) {
		this.adicionarAtributos(pNmAtributos);

		for (int contador = 0; pNmAtributos.length > contador; contador++) {
			this.aTpAtributosInstancia.put(pNmAtributos[contador], pTpAtributos[contador]);
		}
	}

	/**
	 * Substitui os atributos de persistência do VO. Utilizado pelos Jobs de sincronização do posto fiscal.
	 *
	 * @param pNmAtributosPersistencia
	 */
	public void substituirAtributosPersistencia(String[] pNmAtributosPersistencia) {
		this.aNmAtributosPersistencia = new ArrayList(pNmAtributosPersistencia.length);

		for (int contador = 0; pNmAtributosPersistencia.length > contador; contador++) {
			this.aNmAtributosPersistencia.add(pNmAtributosPersistencia[contador]);
		}
	}

	/**
	 * Preenche um atributo da chave primária da entidade no hashtable interno
	 *
	 * @param pNmAtributo
	 * @param pVlAtributo
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	protected void setAtributoChavePrimaria(String pNmAtributo, Object pVlAtributo)
		throws ExcecaoParametroInvalido {
		if (this.aAtributosInstancia.get(pNmAtributo) == null) {
			throw new ExcecaoParametroInvalido("Atributo [" + pNmAtributo + "] da chave primária não inicializado | Classe: " +
				this.getClass().getName() + " | Método: setAtributoChavePrimaria");
		}

		this.aAtributosInstancia.put(pNmAtributo, pVlAtributo);
		this.aAtributosInstanciaChavePrimaria.put(pNmAtributo, pVlAtributo);
	}

	/**
	 * Preenche um atributo da entidade no hashtable interno
	 *
	 * @param pNmAtributo
	 * @param pVlAtributo
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	protected void setAtributo(String pNmAtributo, Object pVlAtributo)
		throws ExcecaoParametroInvalido {
		if (this.aAtributosInstancia.get(pNmAtributo) == null) {
			throw new ExcecaoParametroInvalido("Atributo [" + pNmAtributo + "] não inicializado | Classe: " +
				this.getClass().getName() + " | Método: setAtributo");
		}

		if (pVlAtributo == null) {
			this.aAtributosInstancia.put(pNmAtributo, Constantes.CD_ATRIBUTO_NULO_ALTERADO);
		} else {
			this.aAtributosInstancia.put(pNmAtributo, pVlAtributo);
		}

		if (!pNmAtributo.equals(this.NM_ATR_DhUltimaAlteracao)) {
			this.aVOAlterado = true;
		}
	}

	/**
	 * Preenche o atributo DhInclusao Utilizado dentro do Entity Bean no momento da consulta (getVOEntidade) Na inclusão é
	 * utilizada a data-hora do sistemma
	 *
	 * @param pDhInclusao
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public void setDhInclusao(Timestamp pDhInclusao) throws ExcecaoParametroInvalido {
		String nmAtributo = "Indisponível";

		if (pDhInclusao == null) {
			throw new ExcecaoParametroInvalido("O atributo [pDhInclusao] não pode ser nulo | Classe: " + this.getClass().getName() +
				" | Método: setDhInclusao");
		}

		try {
			nmAtributo = (String) this.getClass().getField("NM_ATR_DhInclusao").get(null);
		} catch (Exception e) {
		}

		this.aDhInclusao = pDhInclusao;
		this.setAtributo(nmAtributo, pDhInclusao);
	}

	/**
	 * Retorna o atributo DhInclusao
	 *
	 * @return
	 */
	public Timestamp getDhInclusao() {
		return this.aDhInclusao;
	}

	/**
	 * Preenche o atributo CdUsuarioInclusao Utilizado dentro do Entity Bean no momento da da consulta (getVOEntidade) Na inclusão
	 * é utilizado o código do usuário disponível no objeto ContextoUsuario
	 *
	 * @param pCdUsuarioInclusao
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public void setCdUsuarioInclusao(String pCdUsuarioInclusao)
		throws ExcecaoParametroInvalido {
		if (pCdUsuarioInclusao == null) {
			throw new ExcecaoParametroInvalido("O atributo [pCdUsuarioInclusao] não pode ser nulo | Classe: " +
				this.getClass().getName() + " | Método: setCdUsuarioInclusao");
		}

		this.aCdUsuarioInclusao = pCdUsuarioInclusao;
		this.setAtributo(this.NM_ATR_CdUsuarioInclusao, pCdUsuarioInclusao);
	}

	/**
	 * Retorna o atributo CdUsuarioInclusao
	 *
	 * @return
	 */
	public String getCdUsuarioInclusao() {
		return this.aCdUsuarioInclusao;
	}

	/**
	 * Preenche o atributo DhUltimaAlteracao Utilizado dentro do Entity Bean no momento da consulta (getVOEntidade) Nos métodos de
	 * alteração (alterar, excluir, cancelarExclusao) é utilizada a data-hora do sistema
	 *
	 * @param pDhUltimaAlteracao
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public void setDhUltimaAlteracao(Timestamp pDhUltimaAlteracao)
		throws ExcecaoParametroInvalido {
		this.aDhUltimaAlteracao = pDhUltimaAlteracao;
		this.setAtributo(this.NM_ATR_DhUltimaAlteracao, pDhUltimaAlteracao);
	}

	/**
	 * Retorna o atributo DhUltimaAlteracao
	 *
	 * @return
	 */
	public Timestamp getDhUltimaAlteracao() {
		return this.aDhUltimaAlteracao;
	}

	/**
	 * Preenche o atributo CdUsuarioUltimaAlteracao Utilizado dentro do Entity Bean no momento da consulta (getVOEntidade) Nos
	 * métodos de alteração (alterar, excluir, cancelarExclusao) é utilizado o código do usuário disponível no objeto
	 * ContextoUsuario
	 *
	 * @param pCdUsuarioUltimaAlteracao
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public void setCdUsuarioUltimaAlteracao(String pCdUsuarioUltimaAlteracao)
		throws ExcecaoParametroInvalido {
		this.aCdUsuarioUltimaAlteracao = pCdUsuarioUltimaAlteracao;
		this.setAtributo(this.NM_ATR_CdUsuarioUltimaAlteracao, pCdUsuarioUltimaAlteracao);
	}

	/**
	 * Retorna o atributo CdUsuarioUltimaManutencao
	 *
	 * @return
	 */
	public String getCdUsuarioUltimaManutencao() {
		return this.aCdUsuarioUltimaManutencao;
	}

	/**
	 * Preenche o atributo CdUsuarioUltimaManutencao Utilizado dentro do Entity Bean no momento da consulta (getVOEntidade) Nos
	 * métodos de alteração (alterar, excluir, cancelarExclusao) é utilizado o código do usuário disponível no objeto
	 * ContextoUsuario
	 *
	 * @param pCdUsuarioUltimaManutencao
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public void setCdUsuarioUltimaManutencao(String pCdUsuarioUltimaManutencao)
		throws ExcecaoParametroInvalido {
		this.aCdUsuarioUltimaManutencao = pCdUsuarioUltimaManutencao;
		this.setAtributo(this.NM_ATR_CdUsuarioUltimaManutencao, pCdUsuarioUltimaManutencao);
	}

	/**
	 * Retorna o atributo CdUsuarioUltimaAlteracao
	 *
	 * @return
	 */
	public String getCdUsuarioUltimaAlteracao() {
		return this.aCdUsuarioUltimaAlteracao;
	}

	/**
	 * Preenche o atributo InExclusaoLogica Utilizado dentro do Entity Bean no momento da consulta (getVOEntidade) Nos métodos de
	 * alteração (alterar, excluir, cancelarExclusao) é utilizada a constante CD_FALSO
	 *
	 * @param pInExclusaoLogica
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public void setInExclusaoLogica(String pInExclusaoLogica)
		throws ExcecaoParametroInvalido {
		String nmAtributo = "InExclusaoLogica";

		if (pInExclusaoLogica == null) {
			throw new ExcecaoParametroInvalido("O atributo [pInExclusaoLogica] não pode ser nulo | Classe: " +
				this.getClass().getName() + " | Método: setInExclusaoLogica");
		}

		try {
			nmAtributo = (String) this.getClass().getField("NM_ATR_InExclusaoLogica").get(null);
		} catch (Exception e) {
		}

		if (pInExclusaoLogica.equals(Constantes.CD_VERDADEIRO)) {
			this.aInExclusaoLogica = Boolean.TRUE;
		} else {
			this.aInExclusaoLogica = Boolean.FALSE;
		}
		this.aInExclusaoLogicaAlterado = true;
		this.setAtributo(nmAtributo, this.aInExclusaoLogica);
	}

	/**
	 * -
	 *
	 * @return
	 */
	public boolean isInExclusaoLogicaAlterado() {
		return this.aInExclusaoLogicaAlterado;
	}

	/**
	 * Retorna o atributo InExclusaoLogica
	 *
	 * @return
	 */
	public String getInExclusaoLogica() {
		if (this.aInExclusaoLogica.booleanValue()) {
			return Constantes.CD_VERDADEIRO;
		} else {
			return Constantes.CD_FALSO;
		}
	}

	/**
	 * Indica se algum atributo do VO foi preenchido após a sua construção com a chave primária
	 *
	 * @return
	 */
	public boolean isVOAlterado() {
		return this.aVOAlterado;
	}

	/**
	 * Retorna o nome da entidade
	 *
	 * @return
	 */
	public String getNmEntidade() {
		return this.getNmEntidade(this.getClass());
	}

	/**
	 * Retorna o nome da entidade
	 *
	 * @param pClasse
	 *
	 * @return
	 */
	public static String getNmEntidade(Class pClasse) {
		try {
			return (String) pClasse.getField("NM_ENTIDADE").get(null);
		} catch (Exception e) {
			return "Indisponível";
		}
	}

	/**
	 * Retorna a descrição da entidade
	 *
	 * @return
	 */
	public String getDsEntidade() {
		return this.getDsEntidade(this.getClass());
	}

	/**
	 * Retorna a descrição da entidade
	 *
	 * @param pClasse
	 *
	 * @return
	 */
	public static String getDsEntidade(Class pClasse) {
		String nmTabelaComSchema = "";
		ArrayList array = null;
		String nmTabela = "";
		String nmMnemonico = "";
		String dsEntidade = "";

		try {
			nmTabelaComSchema = VOEntidade.getNmEntidade(pClasse);
			array = BibliotecaFuncoesPrincipal.split(nmTabelaComSchema, ".");

			if (array.size() > 1) {
				nmTabela = (String) array.get(1);
			} else {
				nmTabela = (String) array.get(0);
			}

			nmMnemonico = Parametros.getInstancia().getNmMnemonico(nmTabela);

			if ((nmMnemonico == null) || nmMnemonico.equals("")) {
				dsEntidade = nmTabela;
			} else {
				dsEntidade = Parametros.getInstancia().getNmEntidade(nmMnemonico);

				if ((dsEntidade == null) || dsEntidade.equals("")) {
					dsEntidade = nmTabela;
				}
			}
		} catch (Exception e) {
			dsEntidade = VOEntidade.getNmEntidade(pClasse);
		}

		return dsEntidade;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public Hashtable getAtributosInstanciaChavePrimaria() {
		return this.aAtributosInstanciaChavePrimaria;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public Hashtable getAtributosInstancia() {
		return this.aAtributosInstancia;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public Collection getNmAtributosPersistenciaChavePrimaria() {
		return this.aNmAtributosPersistenciaChavePrimaria;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public Collection getNmAtributosPersistencia() {
		return this.aNmAtributosPersistencia;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public Enumeration getValoresAtributosInstancia() {
		return this.aAtributosInstancia.elements();
	}

	/**
	 * -
	 *
	 * @param pNmAtributo
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	private Object getValorAtributo(String pNmAtributo)
		throws ExcecaoParametroInvalido {
		Object atributo = null;
		atributo = this.aAtributosInstancia.get(pNmAtributo);

		if (atributo == null) {
			throw new ExcecaoParametroInvalido("Atributo [" + pNmAtributo + "] inválido | Classe: " + this.getClass().getName() +
				" | Método: getValorAtributo()");
		}

		return atributo;
	}

	/**
	 * -
	 *
	 * @param pNmAtributo
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public Object getValorAtributoInstancia(String pNmAtributo)
		throws ExcecaoParametroInvalido {
		Object atributo = null;
		atributo = this.getValorAtributo(pNmAtributo);

		if (atributo.equals(Constantes.CD_ATRIBUTO_NULO) || atributo.equals(Constantes.CD_ATRIBUTO_NULO_ALTERADO)) {
			return null;
		} else {
			return atributo;
		}
	}

	/**
	 * -
	 *
	 * @param pNmAtributo
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public Class getTipoAtributoInstancia(String pNmAtributo)
		throws ExcecaoParametroInvalido {
		Object tpAtributo = null;
		tpAtributo = this.aTpAtributosInstancia.get(pNmAtributo);

		if (tpAtributo == null) {
			throw new ExcecaoParametroInvalido("Atributo [" + pNmAtributo + "] inválido | Classe: " + this.getClass().getName() +
				" | Método: getTipoAtributoInstancia");
		}

		return (Class) tpAtributo;
	}

	/**
	 * -
	 *
	 * @param pNmAtributo
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public boolean isChavePrimaria(String pNmAtributo)
		throws ExcecaoParametroInvalido {
		Object atributo = null;
		atributo = this.aAtributosInstanciaChavePrimaria.get(pNmAtributo);

		if (atributo == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * -
	 *
	 * @param pNmAtributo
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public boolean isAtributoAlterado(String pNmAtributo)
		throws ExcecaoParametroInvalido {
		Object atributo = null;
		atributo = this.getValorAtributo(pNmAtributo);

		if (atributo.equals(Constantes.CD_ATRIBUTO_NULO)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * -
	 *
	 * @param pNmAtributo
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public boolean isAtributoNulo(String pNmAtributo) throws ExcecaoParametroInvalido {
		Object atributo = null;
		atributo = this.getValorAtributo(pNmAtributo);

		if (atributo.equals(Constantes.CD_ATRIBUTO_NULO) || atributo.equals(Constantes.CD_ATRIBUTO_NULO_ALTERADO)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * -
	 *
	 * @param pNmAtributo
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public boolean isAtributoValido(String pNmAtributo)
		throws ExcecaoParametroInvalido {
		Object atributo = null;
		atributo = this.aAtributosInstancia.get(pNmAtributo);

		if (atributo == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String toString() {
		return this.getClass().getName() + "=" + this.aAtributosInstancia.toString();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String toStringAtributosAlterados() {
		String retorno = "";
		StringBuffer retornoBuffer = new StringBuffer();
		Enumeration nomes = aAtributosInstancia.keys();
		Enumeration valores = aAtributosInstancia.elements();
		Object valor;
		String nome;

		retornoBuffer.append("{");

		while (nomes.hasMoreElements()) {
			nome = (String) nomes.nextElement();
			valor = valores.nextElement();

			if (!(valor.equals(Constantes.CD_ATRIBUTO_NULO))) {
				if (retornoBuffer.length() > 1) {
					retornoBuffer.append(", ");
				}

				retornoBuffer.append(nome + "=" + valor);
			}
		}

		retornoBuffer.append("}");
		retorno = retornoBuffer.toString();

		return retorno;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String toStringAtributosChavePrimaria() {
		Hashtable atributosChavePrimaria = null;
		Collection nomes = null;
		Iterator iterator = null;
		String chavePrimaria = "";

		atributosChavePrimaria = this.getAtributosInstanciaChavePrimaria();

		nomes = this.getNmAtributosPersistenciaChavePrimaria();
		iterator = nomes.iterator();

		while (iterator.hasNext()) {
			chavePrimaria = chavePrimaria + atributosChavePrimaria.get(iterator.next()) + "|";
		}

		return chavePrimaria;
	}

	/**
	 * -
	 *
	 * @param pVOEntidade
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public boolean equalsAtributosChavePrimaria(VOEntidade pVOEntidade)
		throws ExcecaoParametroInvalido {
		boolean retorno = false;
		Hashtable atributosChavePrimaria1 = null;
		Hashtable atributosChavePrimaria2 = null;
		Collection nomes1 = null;
		Collection nomes2 = null;
		Iterator iterator1 = null;
		Iterator iterator2 = null;
		int tamanho1 = 0;
		int tamanho2 = 0;

		atributosChavePrimaria1 = this.getAtributosInstanciaChavePrimaria();
		atributosChavePrimaria2 = pVOEntidade.getAtributosInstanciaChavePrimaria();

		nomes1 = this.getNmAtributosPersistenciaChavePrimaria();
		nomes2 = pVOEntidade.getNmAtributosPersistenciaChavePrimaria();

		tamanho1 = atributosChavePrimaria1.size();
		tamanho2 = atributosChavePrimaria2.size();

		String nmClasse1 = "";
		String nmClasse2 = "";
		String nomeaux1 = "";
		String nomeaux2 = "";
		Object valoraux1 = "";
		Object valoraux2 = "";

		nmClasse1 = this.getClass().getName();
		nmClasse2 = pVOEntidade.getClass().getName();

		iterator1 = nomes1.iterator();
		iterator2 = nomes2.iterator();

		if ((nmClasse1.equals(nmClasse2)) && (tamanho1 == tamanho2)) {
			retorno = true;

			while (iterator1.hasNext()) {
				nomeaux1 = iterator1.next().toString();
				nomeaux2 = iterator2.next().toString();

				valoraux1 = atributosChavePrimaria1.get(nomeaux1).toString();
				valoraux2 = atributosChavePrimaria2.get(nomeaux2).toString();

				if (!(nomeaux1.equals(nomeaux2)) || !(valoraux1.equals(valoraux2)) ||
						!(this.getTipoAtributoInstancia(nomeaux1).equals(pVOEntidade.getTipoAtributoInstancia(nomeaux2)))) {
					break;
				}
				tamanho1--;
			}

			if (tamanho1 > 0) {
				retorno = false;
			}
		}

		return retorno;
	}

	/**
	 * -
	 *
	 * @param pVOEntidade
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public boolean equalsAtributos(VOEntidade pVOEntidade)
		throws ExcecaoParametroInvalido {
		boolean retorno = false;
		boolean valoresIguais = false;
		Hashtable atributos1 = null;
		Hashtable atributos2 = null;
		Collection nomes1 = null;
		Collection nomes2 = null;
		Iterator iterator1 = null;
		Iterator iterator2 = null;
		int tamanho1 = 0;
		int tamanho2 = 0;

		atributos1 = this.getAtributosInstancia();
		atributos2 = pVOEntidade.getAtributosInstancia();

		nomes1 = this.getNmAtributosPersistencia();
		nomes2 = pVOEntidade.getNmAtributosPersistencia();

		tamanho1 = atributos1.size();
		tamanho2 = atributos2.size();

		String nmClasse1 = "";
		String nmClasse2 = "";
		String nomeaux1 = "";
		String nomeaux2 = "";
		Object valoraux1 = "";
		Object valoraux2 = "";

		nmClasse1 = this.getClass().getName();
		nmClasse2 = pVOEntidade.getClass().getName();

		iterator1 = nomes1.iterator();
		iterator2 = nomes2.iterator();

		if ((nmClasse1.equals(nmClasse2)) && (tamanho1 == tamanho2)) {
			retorno = true;

			while (iterator1.hasNext()) {
				nomeaux1 = iterator1.next().toString();
				nomeaux2 = iterator2.next().toString();

				valoraux1 = atributos1.get(nomeaux1).toString();
				valoraux2 = atributos2.get(nomeaux2).toString();

				if ((valoraux1.equals(Constantes.CD_ATRIBUTO_NULO_ALTERADO) && valoraux2.equals(Constantes.CD_ATRIBUTO_NULO)) ||
						(valoraux1.equals(Constantes.CD_ATRIBUTO_NULO) && valoraux2.equals(Constantes.CD_ATRIBUTO_NULO_ALTERADO))) {
					valoresIguais = true;
				} else {
					valoresIguais = valoraux1.equals(valoraux2);
				}

				if (!(nomeaux1.equals(nomeaux2)) || !(valoresIguais) ||
						!(this.getTipoAtributoInstancia(nomeaux1).equals(pVOEntidade.getTipoAtributoInstancia(nomeaux2)))) {
					break;
				}
				tamanho1--;
			}

			if (tamanho1 > 0) {
				retorno = false;
			}
		}

		return retorno;
	}

	/**
	 * -
	 *
	 * @param pVOEntidade
	 * @param pAtributosNaoUtilizadosNaComparacao
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public boolean equalsAtributos(VOEntidade pVOEntidade, ArrayList pAtributosNaoUtilizadosNaComparacao)
		throws ExcecaoParametroInvalido {
		boolean retorno = false;
		boolean valoresIguais = false;
		Hashtable atributos1 = null;
		Hashtable atributos2 = null;
		Collection nomes1 = null;
		Collection nomes2 = null;
		Iterator iterator1 = null;
		Iterator iterator2 = null;
		int tamanho1 = 0;
		int tamanho2 = 0;

		atributos1 = this.getAtributosInstancia();
		atributos2 = pVOEntidade.getAtributosInstancia();

		nomes1 = this.getNmAtributosPersistencia();
		nomes2 = pVOEntidade.getNmAtributosPersistencia();

		tamanho1 = atributos1.size();
		tamanho2 = atributos2.size();

		String nmClasse1 = "";
		String nmClasse2 = "";
		String nomeaux1 = "";
		String nomeaux2 = "";
		Object valoraux1 = "";
		Object valoraux2 = "";

		nmClasse1 = this.getClass().getName();
		nmClasse2 = pVOEntidade.getClass().getName();

		iterator1 = nomes1.iterator();
		iterator2 = nomes2.iterator();

		if ((nmClasse1.equals(nmClasse2)) && (tamanho1 == tamanho2) && nomes1.containsAll(nomes2) && nomes2.containsAll(nomes1)) {
			retorno = true;

			while (iterator1.hasNext()) {
				nomeaux1 = iterator1.next().toString();
				nomeaux2 = iterator2.next().toString();

				valoraux1 = atributos1.get(nomeaux1).toString();
				valoraux2 = atributos2.get(nomeaux2).toString();

				if (pAtributosNaoUtilizadosNaComparacao.indexOf(nomeaux1) == -1) {
					if ((valoraux1.equals(Constantes.CD_ATRIBUTO_NULO_ALTERADO) && valoraux2.equals(Constantes.CD_ATRIBUTO_NULO)) ||
							(valoraux1.equals(Constantes.CD_ATRIBUTO_NULO) &&
							valoraux2.equals(Constantes.CD_ATRIBUTO_NULO_ALTERADO))) {
						valoresIguais = true;
					} else {
						valoresIguais = valoraux1.equals(valoraux2);
					}

					if (!(nomeaux1.equals(nomeaux2)) || !(valoresIguais) ||
							!(this.getTipoAtributoInstancia(nomeaux1).equals(pVOEntidade.getTipoAtributoInstancia(nomeaux2)))) {
						retorno = false;

						break;
					}
				}
			}
		}

		return retorno;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public int getQtAtributos() {
		return this.aAtributosInstancia.size();
	}

	/**
	 * -
	 *
	 * @param pClasseVOEntidade
	 * @param pVOGenerico
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 * @throws ExcecaoAtributoInvalido
	 * @throws ExcecaoParametroInvalido
	 */
	public static VOEntidade fromVOGenerico(Class pClasseVOEntidade, VOGenerico pVOGenerico)
		throws ExcecaoGenerica {
		Method metodo = null;
		VOEntidade voEntidade = null;

		try {
			// Chama método da Entidade via reflection. Cria a nova entidade
			metodo = pClasseVOEntidade.getMethod("fromVOGenerico", new Class[] {
						VOGenerico.class,
						boolean.class
					});

			voEntidade = (VOEntidade) metodo.invoke(null, new Object[] {
						pVOGenerico,
						Boolean.FALSE
					});
		} catch (Exception e) {
			Throwable excecaoOrigem = null;

			if (e instanceof InvocationTargetException) {
				excecaoOrigem = ((InvocationTargetException) e).getTargetException();

				if (excecaoOrigem instanceof ExcecaoGenerica) {
					throw (ExcecaoGenerica) excecaoOrigem;
				} else {
					if (excecaoOrigem instanceof NullPointerException) {
					} else if (excecaoOrigem instanceof ClassCastException) {
						throw new ExcecaoParametroInvalido("Erro ao tratar um objeto do tipo '" + excecaoOrigem.getMessage() +
							"' dentro do método 'fromVOGenerico' do VOEntidade (NmClasseVOEntidade=" + pClasseVOEntidade.getName() +
							")", excecaoOrigem);
					} else {
						throw new ExcecaoParametroInvalido(
							"Erro invocando método 'fromVOGenerico' do VOEntidade (NmClasseVOEntidade=" +
							pClasseVOEntidade.getName() + ")", excecaoOrigem);
					}
				}
			} else {
				throw new ExcecaoParametroInvalido("Erro invocando método 'fromVOGenerico' do VOEntidade (NmClasseVOEntidade=" +
					pClasseVOEntidade.getName() + ")", e);
			}
		}

		return voEntidade;
	}

	/**
	 * -
	 *
	 * @throws ExcecaoAtributoInvalido
	 */
	public abstract void validarInclusao() throws ExcecaoAtributoInvalido;
	
	@Override
	protected VOEntidade clone() {
		VOEntidade novoVOEntidade;
		try {
			novoVOEntidade = (VOEntidade) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}

		novoVOEntidade.aNmAtributosPersistencia = (ArrayList) this.aNmAtributosPersistencia.clone();
		novoVOEntidade.aNmAtributosPersistenciaChavePrimaria = (ArrayList) this.aNmAtributosPersistenciaChavePrimaria.clone();
		novoVOEntidade.aAtributosInstancia = (Hashtable) this.aAtributosInstancia.clone();
		novoVOEntidade.aAtributosInstanciaChavePrimaria = (Hashtable) this.aAtributosInstanciaChavePrimaria.clone();
		novoVOEntidade.aTpAtributosInstancia = (Hashtable) this.aTpAtributosInstancia.clone();

		return novoVOEntidade;
	}
}
