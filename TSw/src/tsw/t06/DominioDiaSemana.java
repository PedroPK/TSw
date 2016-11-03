/*
 * Este arquivo � propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informa��o nele contida pode ser
 * reproduzida, mostrada ou revelada sem permiss�o escrita da Sefaz-PE.
 */

package tsw.t06;

/**
 */
public class DominioDiaSemana extends Dominio {
	//~ Atributos/inicializadores estaticos ----------------------------------------------------------------------------------------

	// Inst�ncia �nica da Classe
	private static DominioDiaSemana aInstancia = new DominioDiaSemana();

	//~ Construtores ---------------------------------------------------------------------------------------------------------------

	/**
	 * Construtor da Classe
	 */
	private DominioDiaSemana() {
		this.incluirItem("" + Constantes.CD_DIA_SEMANA_DOMINGO, Constantes.DS_DIA_SEMANA_DOMINGO);
		this.incluirItem("" + Constantes.CD_DIA_SEMANA_SEGUNDA, Constantes.DS_DIA_SEMANA_SEGUNDA);
		this.incluirItem("" + Constantes.CD_DIA_SEMANA_TERCA, Constantes.DS_DIA_SEMANA_TERCA);
		this.incluirItem("" + Constantes.CD_DIA_SEMANA_QUARTA, Constantes.DS_DIA_SEMANA_QUARTA);
		this.incluirItem("" + Constantes.CD_DIA_SEMANA_QUINTA, Constantes.DS_DIA_SEMANA_QUINTA);
		this.incluirItem("" + Constantes.CD_DIA_SEMANA_SEXTA, Constantes.DS_DIA_SEMANA_SEXTA);
		this.incluirItem("" + Constantes.CD_DIA_SEMANA_SABADO, Constantes.DS_DIA_SEMANA_SABADO);
	}

	//~ Metodos --------------------------------------------------------------------------------------------------------------------

	/**
	 * Retorna a inst�ncia �nica da classe
	 *
	 * @return DominioDiaSemana
	 */
	public static DominioDiaSemana getInstancia() {
		if (aInstancia == null) {
			aInstancia = new DominioDiaSemana();
		}

		return aInstancia;
	}
}
