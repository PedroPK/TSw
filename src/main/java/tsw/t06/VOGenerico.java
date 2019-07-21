/*
 * Este arquivo é propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informação nele contida pode ser
 * reproduzida, mostrada ou revelada sem permissão escrita da Sefaz-PE.
 */
package tsw.t06;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Objeto utilizado para armazenar dados de um registro do banco de dados, podendo conter informações de várias entidades,
 * resultantes de uma consulta utilizando join.
 */
public class VOGenerico extends ValueObject {
	//~ Atributos/inicializadores estaticos ----------------------------------------------------------------------------------------

	/**
	 * -
	 */
	public static final String ID_OBJETO = "VOGenerico";

	//~ Atributos de instancia -----------------------------------------------------------------------------------------------------

	private transient HashMap<String, Object> aAtributos;
	private transient int aQtAtribComTipo = 0;

	//~ Construtores ---------------------------------------------------------------------------------------------------------------

/**
         * Cria um novo objeto VOGenerico.
         */
	public VOGenerico() {
		this.aAtributos = new HashMap<String, Object>();
	}

/**
         * Cria um novo objeto VOGenerico.
         *
         * @param pTamanho
         */
	public VOGenerico(int pTamanho) {
		this.aAtributos = new HashMap<String, Object>(pTamanho);
	}

	//~ Metodos --------------------------------------------------------------------------------------------------------------------

	/**
	 * -
	 *
	 * @param pNmAtributo
	 * @param pVlAtributo
	 */
	public void incluirAtributo(String pNmAtributo, Object pVlAtributo) {
		this.incluirAtributo(pNmAtributo, pVlAtributo, null);
	}

	/**
	 * -
	 *
	 * @param pNmAtributo
	 * @param pVlAtributo
	 * @param pTpAtributo
	 */
	public synchronized void incluirAtributo(String pNmAtributo, Object pVlAtributo, Class<?> pTpAtributo) {
		this.incluirAtributoSemSync(pNmAtributo, pVlAtributo, pTpAtributo);
	}

	/**
	 * -
	 *
	 * @param pNmAtributo
	 * @param pVlAtributo
	 * @param pTpAtributo
	 */
	protected void incluirAtributoSemSync(String pNmAtributo, Object pVlAtributo, Class<?> pTpAtributo) {
		if (pVlAtributo == null) {
			pVlAtributo = Constantes.CD_ATRIBUTO_NULO_ALTERADO;
		}

		if (pTpAtributo == null) {
			Object vlAnterior = this.aAtributos.put(pNmAtributo, pVlAtributo);
			
			if (vlAnterior instanceof VlAtributoComTipo) {
				this.aQtAtribComTipo--;
			}
		} else {
			VlAtributoComTipo vlAtributoComTipo = new VlAtributoComTipo();
			vlAtributoComTipo.aVlAtributo = pVlAtributo;
			vlAtributoComTipo.aTpAtributo = pTpAtributo;

			Object vlAnterior = this.aAtributos.put(pNmAtributo, vlAtributoComTipo);

			if (!(vlAnterior instanceof VlAtributoComTipo)) {
				this.aQtAtribComTipo++;
			}
		}
	}

	/**
	 * -
	 *
	 * @param pNmAtributo
	 */
	public synchronized void excluirAtributo(String pNmAtributo) {
		Object vlAtributo = this.aAtributos.remove(pNmAtributo);

		if (vlAtributo instanceof VlAtributoComTipo) {
			this.aQtAtribComTipo--;
		}
	}

	/**
	 * Retorna o atributo 'pNmAtributo'. Caso o atributo não seja encontrado, lança a exceção ExcecaoParametroInvalido.
	 *
	 * @param pNmAtributo pNmAtributo    Nome do atributo
	 *
	 * @return Object    Atributo (pode ser nulo)
	 *
	 * @exception ExcecaoParametroInvalido
	 */
	public synchronized Object getAtributo(String pNmAtributo)
		throws ExcecaoParametroInvalido {
		Object vlAtributo = this.aAtributos.get(pNmAtributo);

		if (vlAtributo == null) {
			throw new ExcecaoParametroInvalido("Atributo [" + pNmAtributo + "] não encontrado | Classe: " +
				this.getClass().getName() + " | Método: getAtributo | this.toString() = " + this.toString());
		}

		if (vlAtributo instanceof VlAtributoComTipo) {
			vlAtributo = ((VlAtributoComTipo) vlAtributo).aVlAtributo;
		}

		if (vlAtributo instanceof String) {
			if (vlAtributo.equals(Constantes.CD_ATRIBUTO_NULO_ALTERADO)) {
				return null;
			}

			String strVlAtributo = (String) vlAtributo;
			vlAtributo = strVlAtributo.trim();
		}

		return vlAtributo;
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
	public synchronized Class<?> getTpAtributo(String pNmAtributo)
		throws ExcecaoParametroInvalido {
		Object vlAtributo = this.aAtributos.get(pNmAtributo);

		if (vlAtributo instanceof VlAtributoComTipo) {
			return ((VlAtributoComTipo) vlAtributo).aTpAtributo;
		} else {
			return vlAtributo.getClass();
		}
	}

	/**
	 * -
	 *
	 * @return
	 */
	public synchronized Object[] getValores() {
		HashMap<String, Object> atributos = this.aAtributos;
		Object[] arrValores = new Object[atributos.size()];
		int i = 0;

		for (Object vlAtributo : atributos.values()) {
			if (vlAtributo instanceof VlAtributoComTipo) {
				vlAtributo = ((VlAtributoComTipo) vlAtributo).aVlAtributo;
			}

			if (vlAtributo.equals(Constantes.CD_ATRIBUTO_NULO_ALTERADO)) {
				vlAtributo = null;
			}

			arrValores[i++] = vlAtributo;
		}

		return arrValores;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public synchronized String[] getChaves() {
		HashMap<String, Object> mapAtributos = this.aAtributos;
		String[] arrChaves = new String[mapAtributos.size()];

		int i = 0;

		for (String nmAtributo : mapAtributos.keySet()) {
			arrChaves[i++] = nmAtributo;
		}

		return arrChaves;
	}

	/**
	 * -
	 *
	 * @param pNmAtributo
	 *
	 * @return
	 */
	public synchronized boolean isAtributoValido(String pNmAtributo) {
		return this.aAtributos.containsKey(pNmAtributo);
	}

	/**
	 * -
	 *
	 * @param pNmAtributo
	 *
	 * @return
	 */
	public synchronized boolean isAtributoValidoNaoNulo(String pNmAtributo) {
		Object vlAtributo = this.aAtributos.get(pNmAtributo);

		if (vlAtributo == null) {
			return false;
		}
		
		if (vlAtributo instanceof VlAtributoComTipo) {
			vlAtributo = ((VlAtributoComTipo) vlAtributo).aVlAtributo;
		}
		
		if (vlAtributo.equals(Constantes.CD_ATRIBUTO_NULO_ALTERADO)) {
			return false;
		}

		return true;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public synchronized boolean isVazio() {
		return this.aAtributos.isEmpty();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public synchronized String toString() {
		HashMap<String, Object> mapAtributos = this.aAtributos;
		int qtChaves = mapAtributos.size();

		StringBuilder sbDsVOGenerico = new StringBuilder(qtChaves * 25);

		try {
			int i = 0;
			int ixUltimo = qtChaves - 1;
			
			for (Map.Entry<String, Object> entryAtributo : mapAtributos.entrySet()) {
				String nmAtributo = entryAtributo.getKey();
				Object vlAtributo = entryAtributo.getValue();
				Class<?> tpAtributo = null;

				if (vlAtributo instanceof VlAtributoComTipo) {
					VlAtributoComTipo vlAtributoComTipo = (VlAtributoComTipo) vlAtributo;
					vlAtributo = vlAtributoComTipo.aVlAtributo;
					tpAtributo = vlAtributoComTipo.aTpAtributo;
				}

				sbDsVOGenerico.append(nmAtributo);
				sbDsVOGenerico.append('=');
				sbDsVOGenerico.append(vlAtributo);
				sbDsVOGenerico.append(Constantes.CD_CAMPO_SEPARADOR_AUX);
				sbDsVOGenerico.append(tpAtributo.getName());

				if (i < ixUltimo) {
					sbDsVOGenerico.append(Constantes.CD_CAMPO_SEPARADOR);
				}
			}

			return sbDsVOGenerico.toString();
		} catch (Exception e) {
			return this.aAtributos.toString();
		}
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String toXML() {
		return null;
	}

	/**
	 * -
	 *
	 * @param pStrVOGenerico
	 *
	 * @return
	 *
	 * @throws ExcecaoCampoInvalido
	 */
	public static VOGenerico fromString(String pStrVOGenerico)
		throws ExcecaoCampoInvalido {
		VOGenerico voGenerico = new VOGenerico();
		int posIgual = 0;
		String strVOGenerico = "";
		String strNmAtributo = "";
		String strVlAtributo = "";
		String strTpAtributo = "";
		Class tpAtributo = null;
		Object vlAtributo = null;
		ArrayList arrayStrVOGenerico;
		ArrayList arrayAux;
		Iterator itStrVOGenerico;
		boolean isTpAtributoIdentificado = false;

		arrayStrVOGenerico = BibliotecaFuncoesPrincipal.split(pStrVOGenerico, Constantes.CD_CAMPO_SEPARADOR);
		itStrVOGenerico = arrayStrVOGenerico.iterator();

		// Laço para capturar o nome e o valor de cada atributo e inclui-lo no voGenerico que será retornado.
		while (itStrVOGenerico.hasNext()) {
			strVOGenerico = itStrVOGenerico.next().toString();

			// Obtendo as posicoes do separadores
			posIgual = strVOGenerico.indexOf("=");

			// Obtendo o nome, tipo e valor do atributo.
			strNmAtributo = strVOGenerico.substring(0, posIgual);
			strVlAtributo = strVOGenerico.substring(posIgual + 1, strVOGenerico.length());

			// Quebra a String de valor obtida para separar o valor propriamente dito de seu tipo.
			arrayAux = BibliotecaFuncoesPrincipal.splitComRestricao(strVlAtributo, Constantes.CD_CAMPO_SEPARADOR_AUX, 2);
			strVlAtributo = arrayAux.get(0).toString();
			strTpAtributo = arrayAux.get(1).toString();

			try {
				isTpAtributoIdentificado = true;

				// Verifica qual o tipo do atributo para criar uma instância de acordo com a classe correspondente
				if (strTpAtributo.equals(Integer.class.getName()) || strTpAtributo.equals(Short.class.getName())) {
					vlAtributo = new Integer(strVlAtributo);
				} else if (strTpAtributo.equals(Long.class.getName())) {
					vlAtributo = new Long(strVlAtributo);
				} else if (strTpAtributo.equals(BigDecimal.class.getName())) {
					vlAtributo = new BigDecimal(strVlAtributo);
				} else if (strTpAtributo.equals(Float.class.getName())) {
					vlAtributo = new Float(strVlAtributo);
				} else if (strTpAtributo.equals(Double.class.getName())) {
					vlAtributo = new Double(strVlAtributo);
				} else if (strTpAtributo.equals(Date.class.getName())) {
					vlAtributo = BibliotecaFuncoesDataHora.getStringComoData(strVlAtributo);
				} else if (strTpAtributo.equals(Time.class.getName())) {
					vlAtributo = BibliotecaFuncoesDataHora.getStringComoHora(strVlAtributo);
				} else if (strTpAtributo.equals(Timestamp.class.getName())) {
					vlAtributo = BibliotecaFuncoesDataHora.getStringComoTimestamp(strVlAtributo);
				} else if (strTpAtributo.equals(Data.class.getName())) {
					vlAtributo = new Data(strVlAtributo);
				} else if (strTpAtributo.equals(String.class.getName())) {
					vlAtributo = strVlAtributo;
				} else {
					isTpAtributoIdentificado = false;
				}

				if (isTpAtributoIdentificado) {
					// Obtem o tipo do atributo
					tpAtributo = Class.forName(strTpAtributo);

					// Inclui o atributo no voGenerico
					voGenerico.incluirAtributoSemSync(strNmAtributo, vlAtributo, tpAtributo);
				}
			} catch (ClassNotFoundException e) {
				// Despreza o atributo
			} catch (ParseException e) {
				// Despreza o atributo
			}
		}

		return voGenerico;
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
	public static VOGenerico fromVOEntidade(VOEntidade pVOEntidade)
		throws ExcecaoParametroInvalido {
		VOGenerico voGenerico = new VOGenerico(pVOEntidade.getQtAtributos());

		Enumeration<String> enumChaves = pVOEntidade.getAtributosInstancia().keys();

		while (enumChaves.hasMoreElements()) {
			String chave = enumChaves.nextElement();
			Object valor = pVOEntidade.getValorAtributoInstancia(chave);

			if (valor instanceof Short) {
				valor = ((Short) valor).intValue();
			}

			voGenerico.incluirAtributoSemSync(chave, valor, null);
		}

		return voGenerico;
	}
	
	@Override
	public VOGenerico clone() {
		VOGenerico novoVOGenerico;
		try {
			novoVOGenerico = (VOGenerico) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}

		novoVOGenerico.aAtributos = (HashMap<String, Object>) this.aAtributos.clone();

		return novoVOGenerico;
	}

	/**
	 * -
	 *
	 * @param pStream
	 *
	 * @throws IOException
	 */
	private synchronized void writeObject(ObjectOutputStream pStream)
		throws IOException {
		HashMap<String, Object> atributos = this.aAtributos;
		int qtAtributos = atributos.size();
		int qtAtribComTipo = this.aQtAtribComTipo;

		pStream.writeInt(qtAtributos);
		pStream.writeInt(qtAtribComTipo);

		if (qtAtributos == qtAtribComTipo) {
			for (Map.Entry<String, Object> entAtributo : atributos.entrySet()) {
				pStream.writeObject(entAtributo.getKey());

				VlAtributoComTipo vlAtributoComTipo = (VlAtributoComTipo) entAtributo.getValue();
				pStream.writeObject(vlAtributoComTipo.aVlAtributo);
				pStream.writeObject(vlAtributoComTipo.aTpAtributo);
			}
		} else if (qtAtribComTipo == 0) {
			for (Map.Entry<String, Object> entAtributo : atributos.entrySet()) {
				pStream.writeObject(entAtributo.getKey());
				pStream.writeObject(entAtributo.getValue());
			}
		} else {
			for (Map.Entry<String, Object> entAtributo : atributos.entrySet()) {
				pStream.writeObject(entAtributo.getKey());

				Object vlAtributo = entAtributo.getValue();
				Class<?> tpAtributo = null;

				if (vlAtributo instanceof VlAtributoComTipo) {
					VlAtributoComTipo vlAtributoComTipo = (VlAtributoComTipo) vlAtributo;
					vlAtributo = vlAtributoComTipo.aVlAtributo;
					tpAtributo = vlAtributoComTipo.aTpAtributo;
				}

				pStream.writeObject(vlAtributo);
				pStream.writeObject(tpAtributo);
			}
		}
	}

	/**
	 * -
	 *
	 * @param pStream
	 *
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(ObjectInputStream pStream)
		throws IOException, ClassNotFoundException {
		int qtAtributos = pStream.readInt();
		int qtAtribComTipo = pStream.readInt();

		HashMap<String, Object> atributos = new HashMap<String, Object>(qtAtributos);
		this.aAtributos = atributos;
		this.aQtAtribComTipo = qtAtribComTipo;

		if (qtAtribComTipo > 0) {
			for (int i = 0; i < qtAtributos; i++) {
				String nmAtributo = (String) pStream.readObject();
				Object vlAtributo = pStream.readObject();
				Class<?> tpAtributo = (Class<?>) pStream.readObject();

				if (tpAtributo != null) {
					VlAtributoComTipo vlAtributoComTipo = new VlAtributoComTipo();
					vlAtributoComTipo.aVlAtributo = vlAtributo;
					vlAtributoComTipo.aTpAtributo = tpAtributo;

					vlAtributo = vlAtributoComTipo;
				}

				atributos.put(nmAtributo, vlAtributo);
			}
		} else {
			for (int i = 0; i < qtAtributos; i++) {
				String nmAtributo = (String) pStream.readObject();
				Object vlAtributo = pStream.readObject();

				atributos.put(nmAtributo, vlAtributo);
			}
		}
	}

	//~ Classes Internas -----------------------------------------------------------------------------------------------------------

	/**
	 * 
	  */
	private static final class VlAtributoComTipo {
		//~ Atributos de instancia -------------------------------------------------------------------------------------------------

		protected Class<?> aTpAtributo;
		protected Object aVlAtributo;

		//~ Metodos ----------------------------------------------------------------------------------------------------------------

		/**
		 * -
		 *
		 * @return  
		 */
		@Override
		public String toString() {
			String strValor = this.aVlAtributo.toString();
			String strTipo = this.aTpAtributo.getName();

			StringBuilder sb = new StringBuilder(strValor.length() + Constantes.CD_CAMPO_SEPARADOR_AUX.length() + strTipo.length());
			sb.append(strValor);
			sb.append(Constantes.CD_CAMPO_SEPARADOR_AUX);
			sb.append(strTipo);

			return sb.toString();
		}
	}
}
