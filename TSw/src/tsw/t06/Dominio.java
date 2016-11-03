/*
 * Este arquivo é propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informação nele contida pode ser
 * reproduzida, mostrada ou revelada sem permissão escrita da Sefaz-PE.
 */

package tsw.t06;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Classe que representa um domínio não normalizado. As chaves do domínio devem ser definidas na classe Constantes do sistema. As
 * subclasses devem implementar um construtor sem parâmetros, definindo todos os itens do domínio.
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
	 * Inclui um mapeamanto chave - descrição Deve ser utilizado no construtor, carregendo todos os mapeamentos,  na sequência
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
	 * Retorna a descrição correspondente a um dos ítens do Select dado seu código/chave
	 *
	 * @param pChave pChave
	 *
	 * @return String    Descrição correspondente à chave informada
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
			throw new ExcecaoParametroInvalido("Chave '" + pChave + "' não encontrada no domínio " + this.getClass().getName());
		}

		return resposta;
	}

	/**
	 * Retorna o tamanho da coleção
	 *
	 * @return int    Tamanho
	 */
	public int getTamanho() {
		return colecao.size();
	}

	/**
	 * Retorna chave do índice passado como parâmetro
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
	 * Retorna se a chave passada como parâmetro é válida
	 *
	 * @param pChave pChave
	 *
	 * @return boolean    Chave válida
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
	 * Retorna a descrição do índice passado como parâmetro
	 *
	 * @param pIndice pIndice
	 *
	 * @return String    Valor da descrição
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
	 * Retorna a coleção de VOGenerico definida na Classe, preservando a sua ordem
	 *
	 * @return java.util.Collection
	 */
	public Collection getColecao() {
		return (Collection) this.colecao.clone();
	}

	/**
	 * Retorna a coleção de VOGenerico definida na Classe, preservando a sua ordem, filtrada pelo parametros pChavesFiltro
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
			throw new ExcecaoParametroInvalido("A coleção de Chaves não pode ser nula !");
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
	 * Retorna os nomes dos atributos que compõem a chave primária
	 *
	 * @return String[]
	 */
	public static String[] getNmAtributosChavePrimaria() {
		return new String[] {
			Dominio.NM_COL_CHAVE
		};
	}

	/**
	 * Retorna os nomes dos atributos que compõem a chave primária
	 *
	 * @return String[]
	 */
	public static String getNmAtributoDescricao() {
		return Dominio.NM_COL_DESCRICAO;
	}
}
