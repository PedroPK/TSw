/*
 * Este arquivo � propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informa��o nele contida pode ser
 * reproduzida, mostrada ou revelada sem permiss�o escrita da Sefaz-PE.
 */

package tsw.t06;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Classe que representa um dom�nio n�o normalizado. As chaves do dom�nio devem ser definidas na classe Constantes do sistema. As
 * subclasses devem implementar um construtor sem par�metros, definindo todos os itens do dom�nio.
 */
public abstract class Dominio implements Serializable {
	//~ Atributos/inicializadores estaticos ----------------------------------------------------------------------------------------

	/**
	 * -
	 */
	public static final String NM_COL_CHAVE = "chave";

	/**
	 * -
	 */
	public static final String NM_COL_DESCRICAO = "descricao";

	//~ Atributos de instancia -----------------------------------------------------------------------------------------------------

	private ArrayList colecao = new ArrayList();

	//~ Metodos --------------------------------------------------------------------------------------------------------------------

	/**
	 * Inclui um mapeamanto chave - descri��o Deve ser utilizado no construtor, carregendo todos os mapeamentos,  na sequ�ncia
	 *
	 * @param pChave pChave
	 * @param pDescricao pDescricao
	 */
	protected void incluirItem(String pChave, String pDescricao) {
		VOGenerico vo = new VOGenerico();
		vo.incluirAtributo(NM_COL_CHAVE, pChave);
		vo.incluirAtributo(NM_COL_DESCRICAO, pDescricao);
		this.colecao.add(vo);
	}

	/**
	 * Retorna a descri��o correspondente a um dos �tens do Select dado seu c�digo/chave
	 *
	 * @param pChave pChave
	 *
	 * @return String    Descri��o correspondente � chave informada
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public String getDescricaoChave(String pChave) throws ExcecaoParametroInvalido {
		String resposta = null;
		VOGenerico voAtual = null;

		Iterator iterador = this.colecao.iterator();

		while ((resposta == null) && iterador.hasNext()) {
			voAtual = (VOGenerico) iterador.next();

			if (voAtual.getAtributo(NM_COL_CHAVE).equals(pChave)) {
				resposta = (String) voAtual.getAtributo(NM_COL_DESCRICAO);
			}
		}

		if (resposta == null) {
			throw new ExcecaoParametroInvalido("Chave '" + pChave + "' n�o encontrada no dom�nio " + this.getClass().getName());
		}

		return resposta;
	}

	/**
	 * Retorna o tamanho da cole��o
	 *
	 * @return int    Tamanho
	 */
	public int getTamanho() {
		return colecao.size();
	}

	/**
	 * Retorna chave do �ndice passado como par�metro
	 *
	 * @param pIndice pIndice
	 *
	 * @return String    Valor da chave
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public String getChave(int pIndice) throws ExcecaoParametroInvalido {
		String resposta = null;
		VOGenerico voAtual = null;

		voAtual = (VOGenerico) colecao.get(pIndice);
		resposta = (String) voAtual.getAtributo(Dominio.NM_COL_CHAVE);

		return resposta;
	}

	/**
	 * Retorna se a chave passada como par�metro � v�lida
	 *
	 * @param pChave pChave
	 *
	 * @return boolean    Chave v�lida
	 */
	public boolean isChaveValida(String pChave) {
		boolean resposta = true;

		try {
			this.getDescricaoChave(pChave);
		} catch (ExcecaoParametroInvalido e) {
			resposta = false;
		}

		return resposta;
	}

	/**
	 * Retorna a descri��o do �ndice passado como par�metro
	 *
	 * @param pIndice pIndice
	 *
	 * @return String    Valor da descri��o
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public String getDescricao(int pIndice) throws ExcecaoParametroInvalido {
		String resposta = null;
		VOGenerico voAtual = null;

		voAtual = (VOGenerico) colecao.get(pIndice);
		resposta = (String) voAtual.getAtributo(Dominio.NM_COL_DESCRICAO);

		return resposta;
	}

	/**
	 * Retorna a cole��o de VOGenerico definida na Classe, preservando a sua ordem
	 *
	 * @return java.util.Collection
	 */
	public Collection getColecao() {
		return (Collection) this.colecao.clone();
	}

	/**
	 * Retorna a cole��o de VOGenerico definida na Classe, preservando a sua ordem, filtrada pelo parametros pChavesFiltro
	 *
	 * @param pChavesFiltro
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public Collection getColecao(ArrayList pChavesFiltro)
		throws ExcecaoParametroInvalido {
		ArrayList resposta = new ArrayList();
		Iterator iterador = null;
		VOGenerico voAtual = null;

		if (pChavesFiltro == null) {
			throw new ExcecaoParametroInvalido("A cole��o de Chaves n�o pode ser nula !");
		}

		for (int i = 0; i < pChavesFiltro.size(); i++) {
			iterador = this.colecao.iterator();

			while (iterador.hasNext()) {
				voAtual = (VOGenerico) iterador.next();

				if (((String) voAtual.getAtributo(NM_COL_CHAVE)).equals(pChavesFiltro.get(i))) {
					resposta.add(voAtual);

					break;
				}
			}
		}

		return resposta;
	}

	/**
	 * Retorna os nomes dos atributos que comp�em a chave prim�ria
	 *
	 * @return String[]
	 */
	public static String[] getNmAtributosChavePrimaria() {
		return new String[] {
			Dominio.NM_COL_CHAVE
		};
	}

	/**
	 * Retorna os nomes dos atributos que comp�em a chave prim�ria
	 *
	 * @return String[]
	 */
	public static String getNmAtributoDescricao() {
		return Dominio.NM_COL_DESCRICAO;
	}
}
