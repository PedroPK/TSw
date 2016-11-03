/*
 * Este arquivo é propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informação nele contida pode ser
 * reproduzida, mostrada ou revelada sem permissão escrita da Sefaz-PE.
 */

package tsw.t06;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 */
public abstract class DataGenerica extends TipoDado {
	//~ Atributos/inicializadores estaticos ----------------------------------------------------------------------------------------

	/**
	 * -
	 */
	public static final int TAMANHO_COM_MASCARA = 10;

	//~ Atributos de instancia -----------------------------------------------------------------------------------------------------

	private Date aData;

	//~ Construtores ---------------------------------------------------------------------------------------------------------------

	/**
	 * Cria um novo objeto DataGenerica.
	 *
	 * @param pData
	 * @param pInValidarLimitesAno
	 *
	 * @throws ExcecaoCampoInvalido
	 */
	public DataGenerica(Object pData, boolean pInValidarLimitesAno)
		throws ExcecaoCampoInvalido {
		try {
			if (pData instanceof Date) {
				this.aData = (Date) pData;
			} else if (pData instanceof Timestamp) {
				this.aData = new Date(((Timestamp) pData).getTime());
			} else if (pData instanceof java.util.Date) {
				this.aData = new Date(((java.util.Date) pData).getTime());
			} else {
				this.aData = BibliotecaFuncoesDataHora.getStringComoData(pData.toString(), pInValidarLimitesAno);
			}
		} catch (Exception e) {
			throw new ExcecaoCampoInvalido("Data", pData, "Erro criando tipo de dado 'Data'", e);
		}
	}

	//~ Metodos --------------------------------------------------------------------------------------------------------------------

	/**
	 * -
	 *
	 * @return
	 */
	public Date toDate() {
		return this.aData;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String toString() {
		return BibliotecaFuncoesDataHora.getDataComoString(this.aData);
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String toStringComMascara() {
		return this.toString();
	}
}
