/*
 * Este arquivo é propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informação nele contida pode ser
 * reproduzida, mostrada ou revelada sem permissão escrita da Sefaz-PE.
 */

package tsw.t06;

import java.sql.Date;

/**
 *
 */
public class Data extends DataGenerica {
	//~ Atributos de instancia -----------------------------------------------------------------------------------------------------

	private Date aData;

	//~ Construtores ---------------------------------------------------------------------------------------------------------------

	/**
	 * Cria um novo objeto Data.
	 *
	 * @param pData
	 *
	 * @throws ExcecaoCampoInvalido
	 */
	public Data(Object pData) throws ExcecaoCampoInvalido {
		super(pData, true);
	}

	//~ Metodos --------------------------------------------------------------------------------------------------------------------

	/**
	 * -
	 *
	 * @param pData
	 *
	 * @return
	 *
	 * @throws ExcecaoCampoInvalido
	 */
	public static Data fromDate(Date pData) throws ExcecaoCampoInvalido {
		if (pData == null) {
			return null;
		} else {
			return new Data(pData);
		}
	}

	/**
	 * -
	 *
	 * @param pData
	 *
	 * @return
	 */
	public static Date toDate(Data pData) {
		if (pData == null) {
			return null;
		} else {
			return pData.toDate();
		}
	}

	/**
	 * Utilizado dentro da JSP
	 *
	 * @param pObjeto
	 * @param pIsTable
	 *
	 * @return String    HTML
	 *
	 * @throws ExcecaoCampoInvalido
	 */
	public static String toHTMLComMascara(Object pObjeto, boolean pIsTable)
		throws ExcecaoCampoInvalido {
		if ((pObjeto == null) || pObjeto.toString().trim().equals("")) {
			if (pIsTable) {
				return "&nbsp;";
			} else {
				return "";
			}
		} else {
			Data tipo = new Data(pObjeto);

			return tipo.toStringComMascara();
		}
	}
}
