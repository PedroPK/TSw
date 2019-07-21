/*
 * Este arquivo é propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informação nele contida pode ser
 * reproduzida, mostrada ou revelada sem permissão escrita da Sefaz-PE.
 */

package tsw.t06;

import java.io.Serializable;

/**
 * 
 */
public abstract class TipoDado implements Serializable {
	//~ Metodos --------------------------------------------------------------------------------------------------------------------

	/**
	 * -
	 *
	 * @return  
	 */
	public abstract String toString();

	/**
	 * -
	 *
	 * @return  
	 */
	public abstract String toStringComMascara();

	/**
	 * -
	 *
	 * @param pObjeto  
	 *
	 * @return  
	 */
	public boolean equals(Object pObjeto) {
		if ((pObjeto != null) && this.toString().equals(pObjeto.toString())) {
			return true;
		} else {
			return false;
		}
	}
}
