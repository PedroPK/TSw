/*
 * Este arquivo é propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informação nele contida pode ser
 * reproduzida, mostrada ou revelada sem permissão escrita da Sefaz-PE.
 */

package tsw.t06;

/**
 * 
 */
public class DominioMes extends Dominio {
	//~ Atributos/inicializadores estaticos ----------------------------------------------------------------------------------------

	// Instância única da Classe
	private static DominioMes aInstancia = new DominioMes();

	//~ Construtores ---------------------------------------------------------------------------------------------------------------

	/**
	 * Construtor da Classe
	 */
	private DominioMes() {
		this.incluirItem(Constantes.CD_MES_JANEIRO, Constantes.DS_MES_JANEIRO);
		this.incluirItem(Constantes.CD_MES_FEVEREIRO, Constantes.DS_MES_FEVEREIRO);
		this.incluirItem(Constantes.CD_MES_MARCO, Constantes.DS_MES_MARCO);
		this.incluirItem(Constantes.CD_MES_ABRIL, Constantes.DS_MES_ABRIL);
		this.incluirItem(Constantes.CD_MES_MAIO, Constantes.DS_MES_MAIO);
		this.incluirItem(Constantes.CD_MES_JUNHO, Constantes.DS_MES_JUNHO);
		this.incluirItem(Constantes.CD_MES_JULHO, Constantes.DS_MES_JULHO);
		this.incluirItem(Constantes.CD_MES_AGOSTO, Constantes.DS_MES_AGOSTO);
		this.incluirItem(Constantes.CD_MES_SETEMBRO, Constantes.DS_MES_SETEMBRO);
		this.incluirItem(Constantes.CD_MES_OUTUBRO, Constantes.DS_MES_OUTUBRO);
		this.incluirItem(Constantes.CD_MES_NOVEMBRO, Constantes.DS_MES_NOVEMBRO);
		this.incluirItem(Constantes.CD_MES_DEZEMBRO, Constantes.DS_MES_DEZEMBRO);
	}

	//~ Metodos --------------------------------------------------------------------------------------------------------------------

	/**
	 * Retorna a instância única da classe
	 *
	 * @return DominioMes
	 */
	public static DominioMes getInstancia() {
		if (aInstancia == null) {
			aInstancia = new DominioMes();
		}

		return aInstancia;
	}
}
