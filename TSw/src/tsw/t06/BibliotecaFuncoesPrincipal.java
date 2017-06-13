/*
 * Este arquivo é propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informação nele contida pode ser
 * reproduzida, mostrada ou revelada sem permissão escrita da Sefaz-PE.
 */
package tsw.t06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.swing.text.html.HTML;
import javax.swing.text.html.HTML.Tag;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 
 */
public final class BibliotecaFuncoesPrincipal {
	//~ Atributos/inicializadores estaticos ----------------------------------------------------------------------------------------

	private static final Map<String, String> aNmContextoWebPorSistema = new ConcurrentHashMap<String, String>(128);
	
	private static Object aLockLogPerformance = new Object();
	
	//~ Metodos --------------------------------------------------------------------------------------------------------------------

	/**
	 * Utilizado dentro da JSP
	 *
	 * @param pObjeto pObjeto    Objeto a ser convertido para HTML
	 * @param pIsTable pIsTable    Se 'true' e pObjeto.toString igual a null ou "", retorna &nbsp;
	 *
	 * @return String    HTML
	 */
	public static String toHTML(Object pObjeto, boolean pIsTable) {
		return BibliotecaFuncoesPrincipal.toHTML(pObjeto, pIsTable, Integer.MAX_VALUE, false);
	}
	
	/**
	 * Utilizado dentro da JSP
	 *
	 * @param pObjeto pObjeto    Objeto a ser convertido para HTML
	 * @param pIsTable pIsTable    Se 'true' e pObjeto.toString igual a null ou "", retorna &nbsp;
	 *
	 * @return String    HTML
	 */
	public static String toHTML(Object pObjeto, boolean pIsTable, int pQtMaxCaracteres, boolean pAdicionarReticencias) {
		String html;
		String strObjeto = pObjeto == null ? "" : pObjeto.toString().trim();
		
		if (strObjeto.length() == 0 || strObjeto.equals("null")) {
			if (pIsTable) {
				html = "&nbsp;";
			} else {
				html = "";
			}
		} else {
			int strObjLength = strObjeto.length();
			boolean inQtCharExcedido = strObjLength > pQtMaxCaracteres;

			if (inQtCharExcedido && "&nbsp;".contentEquals(strObjeto)) {
				pQtMaxCaracteres = Integer.MAX_VALUE;
			}

			StringBuilder sbResultado = new StringBuilder(inQtCharExcedido ? (pQtMaxCaracteres + (pAdicionarReticencias ? 3 : 0))
					: strObjLength);

			for (int i = 0; i < strObjLength && sbResultado.length() <= pQtMaxCaracteres; i++) {
				char charAt = strObjeto.charAt(i);
				switch (charAt) {
				case '<':
					sbResultado.append("&lt;");
					break;
				case '>':
					sbResultado.append("&gt;");
					break;
				case '"':
					sbResultado.append("&quot;");
					break;
				case '\'':
					sbResultado.append("&#039;");
					break;
				default:
					sbResultado.append(charAt);
				}
			}

			if (inQtCharExcedido && pAdicionarReticencias) {
				sbResultado.append("...");
			}

			html = sbResultado.toString();
		}

		return html;
	}

	/**
	 * Utilizado dentro da JSP
	 *
	 * @param pObjeto Objeto a ser convertido para HTML
	 * @param pIsTable Se 'true' e pObjeto.toString igual a null ou "", retorna &nbsp;
	 * @param pQtMaxCaracteresLinha N�mero m�ximo de caracteres por linha no HTML
	 *
	 * @return HTML com linhas quebradas
	 */
	public static String toHTMLComQuebraLinha(Object pObjeto, boolean pIsTable, int pQtMaxCaracteresLinha) {
		String retorno = "";
		String str = BibliotecaFuncoesPrincipal.toHTML(pObjeto, pIsTable);

		if (!str.equals("&nbsp;") && (str.length() > pQtMaxCaracteresLinha)) {
			for (int i = 0; i < str.length(); i = i + pQtMaxCaracteresLinha) {
				if ((i + pQtMaxCaracteresLinha) < str.length()) {
					retorno = retorno + str.substring(i, i + pQtMaxCaracteresLinha) + "<br>";
				} else if ((i + pQtMaxCaracteresLinha) == str.length()) {
					retorno = retorno + str.substring(i, i + pQtMaxCaracteresLinha);
				} else {
					retorno = retorno + str.substring(i, str.length());
				}
			}
		} else {
			retorno = str;
		}

		return retorno;
	}

	/**
	 * Retira as tags HTML de um texto e substitui algumas codifica��es.
	 *
	 * @param pTxComHTML
	 *
	 * @return
	 */
	public static String removerHTML(String pTxComHTML) {
		Tag[] tagsHTML = HTML.getAllTags();
		String regexpTagsHTML = "";

		for (int i = 0; i < tagsHTML.length; i++) {
			regexpTagsHTML = regexpTagsHTML + "|" + tagsHTML[i].toString();
		}

		String regexpHTML = "(?i)</?(" + regexpTagsHTML + ")\\b[^>]*>";

		String txSemHTML = pTxComHTML;

		txSemHTML = txSemHTML.replaceAll(regexpHTML, "");
		txSemHTML = txSemHTML.replaceAll("&lt;", "<");
		txSemHTML = txSemHTML.replaceAll("&gt;", ">");
		txSemHTML = txSemHTML.replaceAll("&nbsp;", " ");
		txSemHTML = txSemHTML.replaceAll("&quot;", "\"");
		txSemHTML = txSemHTML.replaceAll("&#039;", "'");

		return txSemHTML;
	}

	/**
	 * -
	 *
	 * @param pObjeto Objeto a ser convertido para String
	 *
	 * @return Objeto convertido para String
	 */
	public static String toString(Object pObjeto) {
		if ((pObjeto == null) || pObjeto.toString().trim().equals("")) {
			return "";
		} else {
			return pObjeto.toString().trim();
		}
	}

	/**
	 * -
	 *
	 * @param pObjeto Objeto a ser convertido para String
	 * @param pQtMaxCaracteres
	 * @param pColocarReticencias
	 *
	 * @return Objeto convertido para String
	 */
	public static String toString(Object pObjeto, int pQtMaxCaracteres, boolean pColocarReticencias) {
		String retorno = BibliotecaFuncoesPrincipal.toString(pObjeto);

		if (!retorno.equals("") && (retorno.length() > pQtMaxCaracteres)) {
			if (pColocarReticencias) {
				retorno = retorno.substring(0, pQtMaxCaracteres) + "...";
			} else {
				retorno = retorno.substring(0, pQtMaxCaracteres);
			}
		}

		return retorno;
	}

	/**
	 * Substitui caracteres especiais pelo c�digo equivalente
	 *
	 * @param pXML XML a ser codificado
	 *
	 * @return String XML
	 */
	public static String codificarXML(String pXML) {
		String xml = "";

		xml = pXML;

		if ((xml == null) || xml.trim().equals("")) {
			return "";
		} else {
			xml = BibliotecaFuncoesPrincipal.substituir(xml, "&", "&amp;");
			xml = BibliotecaFuncoesPrincipal.substituir(xml, "<", "&lt;");
			xml = BibliotecaFuncoesPrincipal.substituir(xml, ">", "&gt;");
			xml = BibliotecaFuncoesPrincipal.substituir(xml, "\r", "&#13;");
			xml = BibliotecaFuncoesPrincipal.substituir(xml, "\t", "&#9;");
			xml = BibliotecaFuncoesPrincipal.substituir(xml, "\"", "&quot;");
			xml = BibliotecaFuncoesPrincipal.substituir(xml, "\\", "&apos;");
			xml = BibliotecaFuncoesPrincipal.substituir(xml, "\'", "&apos;");
			xml = BibliotecaFuncoesPrincipal.removerCaracteresNaoImprimiveis(xml);

			return xml;
		}
	}

	/**
	 * -
	 *
	 * @param pDocumento
	 *
	 * @return
	 *
	 * @throws ExcecaoSistema
	 */
	public static String getDocumentoXMLComoString(Document pDocumento)
		throws ExcecaoSistema {
		String xml = "";

		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1"); 

			DOMSource source = new DOMSource(pDocumento);
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			transformer.transform(source, result);
			xml = writer.toString();
		} catch (Exception e) {
			throw new ExcecaoSistema("Erro convertendo documento XML para String | pDocumento=" + pDocumento, e);
		}

		return xml;
	}

	/**
	 * -
	 *
	 * @param pDocumento  
	 * @param pClasseObjeto  
	 *
	 * @return  
	 *
	 * @throws ExcecaoSistema  
	 */
	public static Object getDocumentoXMLComoObjeto(Document pDocumento, Class pClasseObjeto)
		throws ExcecaoSistema {
		Object objetoRetorno;

		try {
			JAXBContext context = JAXBContext.newInstance(pClasseObjeto);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			objetoRetorno = unmarshaller.unmarshal(pDocumento);
		} catch (Exception e) {
			throw new ExcecaoSistema("Erro convertendo documento XML para Object | pDocumento=" + pDocumento + " | pClasseObjeto=" +
				pClasseObjeto, e);
		}

		return objetoRetorno;
	}

	/**
	 * -
	 *
	 * @param pXML
	 *
	 * @return
	 *
	 * @throws ExcecaoSistema
	 */
	public static Document getDocumentoXML(String pXML)
		throws ExcecaoSistema {
		String xml;
		DocumentBuilderFactory fabrica = null;
		Document documento = null;
		DocumentBuilder construtor = null;

		try {
			fabrica = DocumentBuilderFactory.newInstance();
			construtor = fabrica.newDocumentBuilder();

			xml = pXML;
			if (xml.indexOf("<?xml") != 0) {
				xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>" + xml;
			}

			ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes());
			documento = construtor.parse(bais);
		} catch (Exception e) {
			throw new ExcecaoSistema("Erro obtendo documento XML | pXML=" + pXML, e);
		}

		return documento;
	}

	/**
	 * -
	 *
	 * @param pObjeto A classe deve utilizar as anota��es XmlRootElement, XmlElement e XmlTransient para definir a
	 * 		  estrutura do xml
	 * @param pClasseObjeto
	 *
	 * @return
	 *
	 * @throws ExcecaoSistema
	 */
	public static Document getDocumentoXML(Object pObjeto, Class pClasseObjeto)
		throws ExcecaoSistema {
		Document documento;

		try {
			JAXBContext context = JAXBContext.newInstance(pClasseObjeto);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			marshaller.marshal(pObjeto, documento);
		} catch (Exception e) {
			throw new ExcecaoSistema("Erro obtendo documento XML | pObjeto=" + pObjeto + " | pClasseObjeto=" + pClasseObjeto, e);
		}

		return documento;
	}

	/**
	 * -
	 *
	 * @param pDocumentoXML
	 * @param pNmElemento
	 * @param pNuIndiceElemento
	 *
	 * @return
	 *
	 * @throws ExcecaoSistema
	 */
	public static String getValorElementoXML(Document pDocumentoXML, String pNmElemento, int pNuIndiceElemento)
		throws ExcecaoSistema {
		NodeList elementos = null;
		Node elemento = null;
		String valor = null;

		elementos = pDocumentoXML.getElementsByTagName(pNmElemento);

		if (elementos != null) {
			elemento = elementos.item(pNuIndiceElemento);

			if (elemento != null) {
				Node fc = elemento.getFirstChild();

				if (fc != null) {
					valor = fc.getNodeValue();
				} else {
					throw new ExcecaoSistema("O elemento " + pNmElemento + " do documento XML n�o tem filho");
				}
			} else {
				throw new ExcecaoSistema("O elemento " + pNmElemento + " do documento XML n�o existe no �ndice " +
					pNuIndiceElemento);
			}
		} else {
			throw new ExcecaoSistema("O documento XML n�o tem o elemento " + pNmElemento);
		}

		return valor;
	}

	/**
	 * -
	 *
	 * @param pDocumentoXML
	 * @param pNmElemento
	 * @param pNuIndiceElemento
	 * @param pNmAtributo
	 *
	 * @return
	 *
	 * @throws ExcecaoSistema
	 */
	public static String getValorAtributoElementoXML(Document pDocumentoXML, String pNmElemento, int pNuIndiceElemento,
		String pNmAtributo) throws ExcecaoSistema {
		NodeList elementos = null;
		Node elemento = null;
		Node atributo = null;
		NamedNodeMap atributos = null;
		String valor = null;

		elementos = pDocumentoXML.getElementsByTagName(pNmElemento);

		if (elementos != null) {
			elemento = elementos.item(pNuIndiceElemento);

			if (elemento != null) {
				atributos = elemento.getAttributes();
				atributo = atributos.getNamedItem(pNmAtributo);

				if (atributo != null) {
					valor = atributo.getNodeValue();
				} else {
					throw new ExcecaoSistema("O elemento " + pNmElemento + " do documento XML n�o tem o atributo " + pNmAtributo);
				}
			} else {
				throw new ExcecaoSistema("O elemento " + pNmElemento + " do documento XML n�o existe no �ndice " +
					pNuIndiceElemento);
			}
		} else {
			throw new ExcecaoSistema("O documento XML n�o tem o elemento " + pNmElemento);
		}

		return valor;
	}

	/**
	 * M�todo que gera um elemento XML com o seu valor.
	 *
	 * @param pNmElemento
	 * @param pVlElemento
	 *
	 * @return
	 */
	public static String gerarElementoXML(String pNmElemento, String pVlElemento) {
		StringBuilder resposta = new StringBuilder((pNmElemento.length() * 2) + pVlElemento.length() + 6);
		resposta.append('<');
		resposta.append(pNmElemento);
		resposta.append('>');
		resposta.append(pVlElemento);
		resposta.append("</");
		resposta.append(pNmElemento);
		resposta.append(">\n");

		return resposta.toString();
	}

	/**
	 * -
	 *
	 * @param pClasse
	 *
	 * @return
	 */
	public static String getNmClasseSemPacote(Class pClasse) {
		String resultado = null;

		resultado = BibliotecaFuncoesPrincipal.getNmClasseSemPacote(pClasse.getName());

		return resultado;
	}

	/**
	 * -
	 *
	 * @param pNmCompletoClasse
	 *
	 * @return
	 */
	public static String getNmClasseSemPacote(String pNmCompletoClasse) {
		ArrayList array = null;
		String resultado = null;

		array = BibliotecaFuncoesPrincipal.split(pNmCompletoClasse, ".");
		resultado = array.get(array.size() - 1).toString();

		return resultado;
	}

	/**
	 * Retorna uma colecao de tokens separados pelo "pSeparador".
	 *
	 * @param pConteudo pConteudo Contem as chaves que devem ser separados
	 * @param pSeparador pSeparador    Sequ�ncia de caracteres que separam as chaves
	 *
	 * @return ArrayList Colecao de chaves encontradas.
	 */
	public static ArrayList<String> split(String pConteudo, String pSeparador) {
		ArrayList<String> lista = new ArrayList<String>();
		int posAtual = 0;
		int posSeparador = 0;
		boolean inConcluido = false;

		while (!inConcluido) {
			posSeparador = pConteudo.indexOf(pSeparador, posAtual);

			if (posSeparador == -1) {
				lista.add(pConteudo.substring(posAtual));
				inConcluido = true;
			} else {
				lista.add(pConteudo.substring(posAtual, posSeparador));
			}

			posAtual = posSeparador + pSeparador.length();
		}

		return lista;
	}

	/**
	 * Retorna uma colecao com os primeiros "pQtMaxTokens" tokens separados por "pSeparador"
	 *
	 * @param pConteudo pConteudo Contem as chaves que devem ser separados
	 * @param pSeparador pSeparador    Sequ�ncia de caracteres que separam as chaves
	 * @param pQtMaxTokens pQtMaxTokens Quantidade maxima de tokens que se deseja retornar
	 *
	 * @return ArrayList Colecao de chaves encontradas.
	 */
	public static ArrayList splitComRestricao(String pConteudo, String pSeparador, int pQtMaxTokens) {
		ArrayList lista = new ArrayList();
		int posAtual = 0;
		int posSeparador = 0;
		int contador = 0;
		boolean inConcluido = false;

		while (!inConcluido) {
			posSeparador = pConteudo.indexOf(pSeparador, posAtual);

			if (posSeparador == -1) {
				lista.add(pConteudo.substring(posAtual));
				inConcluido = true;
			} else {
				lista.add(pConteudo.substring(posAtual, posSeparador));
			}

			posAtual = posSeparador + pSeparador.length();

			contador++;

			if (contador == pQtMaxTokens) {
				break;
			}
		}

		return lista;
	}

	/**
	 * Retorna uma colecao de tokens separados por "pSeparador" Caso a quantidade de tokens encontrada seja diferente da
	 * requerida, uma excecao sera levantada
	 *
	 * @param pConteudo pConteudo Contem os tokens que devem ser separados
	 * @param pSeparador pSeparador    Sequ�ncia de caracteres que separam as chaves
	 * @param pQtTokens ptQtTokens Numero de tokens que deve existir em pConteudo
	 *
	 * @return ArrayList Colecao de chaves encontradas.
	 *
	 * @exception ExcecaoParametroInvalido Caso o numero de chaves encontradas seja menor que o numero requerido
	 */
	public static ArrayList splitComCondicao(String pConteudo, String pSeparador, int pQtTokens)
		throws ExcecaoParametroInvalido {
		ArrayList lista = new ArrayList();
		int posAtual = 0;
		int posSeparador = 0;
		int contador = 0;
		boolean inConcluido = false;

		while (!inConcluido) {
			posSeparador = pConteudo.indexOf(pSeparador, posAtual);

			if (posSeparador == -1) {
				lista.add(pConteudo.substring(posAtual));
				inConcluido = true;
			} else {
				lista.add(pConteudo.substring(posAtual, posSeparador));
			}

			posAtual = posSeparador + pSeparador.length();

			contador++;
		}

		if (contador != pQtTokens) {
			throw new ExcecaoParametroInvalido("O numero de chaves encontradas � menor que o requisitado!");
		}

		return lista;
	}

	/**
	 * unto each string in <var>strings</var>, prepend the string Prefix and return the resulting list of strings.
	 *
	 * @param pPrefix The string to be prepended
	 * @param pStrings The strings unto which to prepend
	 *
	 * @return An array of strings that all have <var>prefix</var>  prepended.
	 */
	public static String[] adicionarPrefixo(String pPrefix, String[] pStrings) {
		synchronized (pStrings) {
			String[] list = new String[pStrings.length];

			for (int i = 0; i < list.length; i++) {
				list[i] = pPrefix + pStrings[i];
			}

			return list;
		}
	}

	// addPrefix
	/**
	 * unto each string in <var>strings</var>, append the string <var>suffix</var> and return the resulting list of
	 * strings.
	 *
	 * @param pSuffix The string to be appended
	 * @param pStrings The strings unto which to append
	 *
	 * @return An array of strings that all have suffix appended.
	 */
	public static String[] adicionarSufixo(String pSuffix, String[] pStrings) {
		synchronized (pStrings) {
			String[] list = new String[pStrings.length];

			for (int i = 0; i < list.length; i++) {
				list[i] = pStrings[i] + pSuffix;
			}

			return list;
		}
	}

	// addSuffix
	/**
	 * remove occurrences of character CHAR from  string STR.
	 *
	 * @param pChar The character to be removed.
	 * @param pStr The string from which to remove them
	 *
	 * @return string with CHARs removed
	 */
	public static String eliminarCaractere(char pChar, String pStr) {
		char[] s = pStr.toCharArray();
		int padds = 0;

		for (int i = 0; i < s.length; i++) {
			if (s[i] == pChar) {
				padds++;
			}
		}

		char[] n = new char[s.length - padds];
		int j = 0;

		for (int i = 0; i < s.length; i++) {
			if (s[i] != pChar) {
				n[j++] = s[i];
			}
		}

		return new String(n);
	}

	/**
	 * number of occurrences of character CHAR before location loc in string str.
	 *
	 * @param pChar character whose occurrences should be counted
	 * @param pStr the string in which to do this
	 * @param pLoc the offset in str at which to start.
	 *
	 * @return number of occurrences.
	 */
	public static int numAntesPosicao(char pChar, String pStr, int pLoc) {
		char[] c = pStr.toCharArray();
		int ix = 0;

		for (int i = 0; i < Math.min(pLoc, c.length); i++) { // M.S. corrected

			if (c[i] == pChar) {
				ix++;
			}
		}

		return ix;
	}

	/**
	 * return list of positions of character CHAR inside string str.
	 *
	 * @param pChar the character whose positions are sought
	 * @param pStr the string in which to find them
	 *
	 * @return a (possibly empty) list of integers that lists the positions at which CHAR was found.
	 */
	public static int[] posicoes(char pChar, String pStr) {
		char[] c = pStr.toCharArray();
		int ix = 0;

		for (int i = 0; i < c.length; i++) {
			if (c[i] == pChar) {
				ix++;
			}
		}

		int[] res = new int[ix];
		ix = 0;

		for (int i = 0; i < c.length; i++) {
			if (c[i] == pChar) {
				res[ix++] = i;
			}
		}

		return res;
	}

	/**
	 * removes all whitespace and 'unprintables characters' from String str, and returns new one.
	 *
	 * @param pStr The string on which  to operate
	 *
	 * @return a string that doesn't have the whitespace nor unprintables
	 */
	public static String removerBrancos(String pStr) {
		StringBuffer buf = new StringBuffer();
		char[] c = pStr.toCharArray();

		for (int i = 0; i < c.length; i++) {
			if (c[i] > ' ') {
				buf.append(c[i]);
			}
		}

		return new String(buf);
	}

	/**
	 * Removes 'control characters' except line feed, carriage return and tab.
	 *
	 * @param pStr The string on which to operate
	 *
	 * @return a string
	 */
	public static String removerCaracteresNaoImprimiveis(String pStr) {
		StringBuffer buf = new StringBuffer();
		char[] c = pStr.toCharArray();

		for (int i = 0; i < c.length; i++) {
			if ((c[i] == '\n') || (c[i] == '\r') || (c[i] == '\t') || (c[i] >= 32)) {
				buf.append(c[i]);
			}
		}

		return buf.toString();
	}

	/**
	 * Removes 'control characters'.
	 *
	 * @param pStr The string on which to operate
	 *
	 * @return a string
	 */
	public static String removerCaracteresControle(String pStr) {
		String resultado;
		resultado = pStr.replaceAll("\\p{Cntrl}", "");

		return resultado;
	}

	/**
	 * Este m�todo garante que a sa�da tera apenas caracteres unicode v�lidos em XML conforme especificado pelo padr�o XML
	 * 1.0. Para refer�ncia, consulte <a href="http://www.w3.org/TR/2000/REC-xml-20001006#NT-Char">o padr�o</a>.  Esse m�todo ir�
	 * retornar vazio se a entrada for nulo ou vazio.
	 *
	 * @param pStr A String da qual que se deseja remover os caracteres n�o v�lidos.
	 *
	 * @return A String , sem os caracteres n�o v�lidos.
	 */
	public static String removerCaracteresUNICODEInvalidos(String pStr) {
		StringBuffer buf = new StringBuffer();
		char atual;

		if ((pStr == null) || (pStr.equals(""))) {
			return "";
		}

		for (int i = 0; i < pStr.length(); i++) {
			atual = pStr.charAt(i);

			if ((atual == 0x9) || (atual == 0xA) || (atual == 0xD) || ((atual >= 0x20) && (atual <= 0xD7FF)) ||
					((atual >= 0xE000) && (atual <= 0xFFFD)) || ((atual >= 0x10000) && (atual <= 0x10FFFF))) {
				buf.append(atual);
			}
		}

		return buf.toString();
	}

	/**
	 * Este m�todo garante que a sa�da ter� apenas caracteres unicode v�lidos em XML conforme especificado pelo padr�o XML
	 * 1.0, substituindo os caracteres inv�lidos por pStrSubstituicao. Para refer�ncia, consulte <a
	 * href="http://www.w3.org/TR/2000/REC-xml-20001006#NT-Char">o padr�o</a>.  Esse m�todo ir� retornar vazio se a entrada for
	 * nulo ou vazio.
	 *
	 * @param pStr
	 * @param pStrSubstituicao
	 *
	 * @return
	 */
	public static String substituirCaracteresUNICODEInvalidos(String pStr, String pStrSubstituicao) {
		StringBuffer buf = new StringBuffer();
		char atual;

		if ((pStr == null) || (pStr.equals(""))) {
			return "";
		}

		for (int i = 0; i < pStr.length(); i++) {
			atual = pStr.charAt(i);

			if ((atual == 0x9) || (atual == 0xA) || (atual == 0xD) || ((atual >= 0x20) && (atual <= 0xD7FF)) ||
					((atual >= 0xE000) && (atual <= 0xFFFD)) || ((atual >= 0x10000) && (atual <= 0x10FFFF))) {
				buf.append(atual);
			} else {
				buf.append(pStrSubstituicao);
			}
		}

		return buf.toString();
	}

	/**
	 * -
	 *
	 * @param pStr
	 *
	 * @return
	 */
	public static String substituirCaracteresComAcento(String pStr) {
		StringBuffer buf = new StringBuffer();
		char[] c = pStr.toCharArray();

		for (int i = 0; i < c.length; i++) {
			if (c[i] == '�') {
				buf.append('A');
			} else if (c[i] == '�') {
				buf.append('A');
			} else if (c[i] == '�') {
				buf.append('A');
			} else if (c[i] == '�') {
				buf.append('A');
			} else if (c[i] == '�') {
				buf.append('A');
			} else if (c[i] == '�') {
				buf.append('a');
			} else if (c[i] == '�') {
				buf.append('a');
			} else if (c[i] == '�') {
				buf.append('a');
			} else if (c[i] == '�') {
				buf.append('a');
			} else if (c[i] == '�') {
				buf.append('a');
			} else if (c[i] == '�') {
				buf.append('E');
			} else if (c[i] == '�') {
				buf.append('E');
			} else if (c[i] == '�') {
				buf.append('E');
			} else if (c[i] == '�') {
				buf.append('E');
			} else if (c[i] == '�') {
				buf.append('e');
			} else if (c[i] == '�') {
				buf.append('e');
			} else if (c[i] == '�') {
				buf.append('e');
			} else if (c[i] == '�') {
				buf.append('e');
			} else if (c[i] == '�') {
				buf.append('I');
			} else if (c[i] == '�') {
				buf.append('I');
			} else if (c[i] == '�') {
				buf.append('I');
			} else if (c[i] == '�') {
				buf.append('I');
			} else if (c[i] == '�') {
				buf.append('i');
			} else if (c[i] == '�') {
				buf.append('i');
			} else if (c[i] == '�') {
				buf.append('i');
			} else if (c[i] == '�') {
				buf.append('i');
			} else if (c[i] == '�') {
				buf.append('O');
			} else if (c[i] == '�') {
				buf.append('O');
			} else if (c[i] == '�') {
				buf.append('O');
			} else if (c[i] == '�') {
				buf.append('O');
			} else if (c[i] == '�') {
				buf.append('O');
			} else if (c[i] == '�') {
				buf.append('o');
			} else if (c[i] == '�') {
				buf.append('o');
			} else if (c[i] == '�') {
				buf.append('o');
			} else if (c[i] == '�') {
				buf.append('o');
			} else if (c[i] == '�') {
				buf.append('o');
			} else if (c[i] == '�') {
				buf.append('U');
			} else if (c[i] == '�') {
				buf.append('U');
			} else if (c[i] == '�') {
				buf.append('U');
			} else if (c[i] == '�') {
				buf.append('U');
			} else if (c[i] == '�') {
				buf.append('u');
			} else if (c[i] == '�') {
				buf.append('u');
			} else if (c[i] == '�') {
				buf.append('u');
			} else if (c[i] == '�') {
				buf.append('u');
			} else if (c[i] == '�') {
				buf.append('C');
			} else if (c[i] == '�') {
				buf.append('c');
			} else {
				buf.append(c[i]);
			}
		}

		return new String(buf);
	}

	/**
	 * Opposite of split; concatenates STRINGLIST using DELIMITER as the separator. The separator is only added between
	 * strings, so there will be no separator at the beginning or end.
	 *
	 * @param pStringList The list of strings that will to be put together
	 * @param pDelimiter The string to put between the strings of stringList
	 *
	 * @return string that has DELIMITER put between each of the elements of stringList
	 */
	public static String join(String[] pStringList, String pDelimiter) {
		int len = pStringList.length;
		StringBuffer buf = new StringBuffer(len * 20);

		synchronized (pStringList) {
			for (int i = 0; i < (len - 1); i++) {
				buf.append(pStringList[i]);
				buf.append(pDelimiter);
			}

			if (len > 0) {
				buf.append(pStringList[len - 1]);
			}
		}

		return buf.toString();
	}

	/**
	 * Make one string out of stringList by putting spaces between each element. Same as join(stringList, " ");<p></p>
	 *
	 * @param pStringList the list of strings that will be put together
	 *
	 * @return a string that has ' ' put between each of the elements of stringList.
	 *
	 * @see #join(String[],String) join(String[],String)
	 */
	public static String join(String[] pStringList) {
		return join(pStringList, " ");
	}

	/**
	 * In string <var>string</var>, replace all occurrences of <var>from</var> by <var>to</var> and return the resulting
	 * string.<p>If string <var>from</var> is empty, this will be considered to match no single occurrence of it in the
	 * target string, hence no replacements will be made. Note that <var>to</var> cannot be null. It can be the empty string,
	 * resulting in deletion of the substring; see also method delete(String,String);</p>
	 *  <p></p>
	 *
	 * @param pString The string in which the replacements will be made
	 * @param pFrom String that, when it occurs in string, will be replaced
	 * @param pTo The replacement of from in string
	 *
	 * @return A new string
	 *
	 * @see #delete(String,String)
	 */
	public static String substituir(String pString, String pFrom, String pTo) {
		if (pFrom.equals("")) {
			return pString;
		}

		StringBuffer buf = new StringBuffer(2 * pString.length());

		int previndex = 0;
		int index = 0;
		int flen = pFrom.length();

		while (true) {
			index = pString.indexOf(pFrom, previndex);

			if (index == -1) {
				buf.append(pString.substring(previndex));

				break;
			}

			buf.append(pString.substring(previndex, index) + pTo);
			previndex = index + flen;
		}

		return buf.toString();
	}

	/**
	 * -
	 *
	 * @param pString
	 * @param pFrom
	 * @param pTo
	 *
	 * @return
	 */
	public static String substituir(String pString, String[] pFrom, String pTo) {
		StringBuffer buf;
		String temp = pString;

		int previndex = 0;
		int index = 0;
		int flen = 0;

		for (int i = 0; i < pFrom.length; i++) {
			buf = new StringBuffer(2 * temp.length());

			if (pFrom[i].equals("")) {
				continue;
			}

			previndex = 0;
			index = 0;
			flen = pFrom[i].length();

			while (true) {
				index = temp.indexOf(pFrom[i], previndex);

				if (index == -1) {
					buf.append(temp.substring(previndex));

					break;
				}

				buf.append(temp.substring(previndex, index) + pTo);
				previndex = index + flen;
			}

			temp = buf.toString();
		}

		return temp;
	}

	/**
	 * -
	 *
	 * @param pString
	 * @param pCampoSubstituicao
	 * @param pValoresSubstituicao
	 *
	 * @return
	 */
	public static String substituir(String pString, String pCampoSubstituicao, String[] pValoresSubstituicao) {
		int indiceCampoSeparador = -1;
		StringBuffer sBuffer = new StringBuffer();

		for (int i = 0; i < pValoresSubstituicao.length; i++) {
			indiceCampoSeparador = pString.indexOf(pCampoSubstituicao);

			if (indiceCampoSeparador == -1) {
				sBuffer.append(pString);

				break;
			} else {
				sBuffer.append(BibliotecaFuncoesPrincipal.substituir(pString.substring(0,
							indiceCampoSeparador + pCampoSubstituicao.length()), pCampoSubstituicao, pValoresSubstituicao[i]));
				pString = pString.substring(indiceCampoSeparador + pCampoSubstituicao.length(), pString.length());

				if (i == (pValoresSubstituicao.length - 1)) {
					sBuffer.append(pString);
				}
			}
		}

		return String.valueOf(sBuffer);
	}

	/**
	 * -
	 *
	 * @param pString
	 * @param pRegexpFrom
	 * @param pTo
	 * @param pN
	 *
	 * @return
	 */
	public static String substituirNth(String pString, String pRegexpFrom, String pTo, int pN) {
		Pattern p = Pattern.compile(pRegexpFrom);
		Matcher m = p.matcher(pString);

		StringBuffer sb = new StringBuffer();

		int i = 0;

		while (m.find()) {
			if (pN == i) {
				m.appendReplacement(sb, pTo);

				break;
			}
			i++;
		}

		m.appendTail(sb);

		return sb.toString();
	}

	/**
	 * Delete all occurrences of substrings <var>delete</var> from <var>string</var>. Same as replace(string, from, "")<p></p>
	 *
	 * @param string The string from which substrings will be deleted.
	 * @param delete The substrings that are to be deleted.
	 *
	 * @return new string.
	 *
	 * @see #replace(String, String, String)
	 */
	public static String deletar(String string, String delete) {
		return substituir(string, delete, "");
	}

	/**
	 * Opposit string.
	 *
	 * @param str string
	 * @param pos positions of chars to be removed (must be ordered from lowest to highest and position can occur only once)
	 *
	 * @return new string from which the chars are removed
	 */
	public static String removerPosicoes(String str, int[] pos) {
		char[] n = new char[str.length() - pos.length];
		char[] s = str.toCharArray();
		int shift = 0;

		for (int i = 0; i < s.length; i++) {
			if ((shift < pos.length) && (i == pos[shift])) {
				shift++;
			} else {
				n[i - shift] = s[i];
			}
		}

		return new String(n);
	}

	/**
	 * analogous to java.lang.String.indexOf(string), but finding not the first occurrence, but the Nth one. Returns the
	 * offset of the string found, or -1 if not found.
	 *
	 * @param s The string to be searched through
	 * @param pFind The string to find
	 * @param n The Nth occurrence. If n==0, this is equivalent to java.lang.String.indexOf(string).
	 *
	 * @return The offset of the found string, or -1 if no string found.
	 */
	public static int nthIndexOf(String s, String pFind, int n) {
		return nthIndexOf(s, pFind, n, 0);
	}

	/**
	 * analogous to java.lang.String.indexOf(string, fromIndex), but finding not the first occurrence, but the Nth one,
	 * starting at from. Returns the offset of the string found, or -1 if not found.
	 *
	 * @param s The string to be searched through
	 * @param pFind The string to find
	 * @param n The Nth occurrence. If n==0, this is equivalent to java.lang.String.indexOf(string)
	 * @param from The position to start at.
	 *
	 * @return The offset of the found string, or -1 if no string found.
	 */
	public static int nthIndexOf(String s, String pFind, int n, int from) {
		int f = 0;
		int i = 0;
		int len = pFind.length();

		for (f = s.indexOf(pFind, f + from); (i < n) && (f != -1); f = s.indexOf(pFind, f + len)) {
			i++;
		}

		return f;
	}

	/**
	 * Turn a string into a the same string starting with uppercase, rest all lower case. E.g. "aBc" => "Abc"
	 *
	 * @param string The string to be operated on
	 *
	 * @return The capitalized string, or the same one if it was null or empty
	 */
	public static String primeiraLetraMaiuscula(String string) {
		if ((string == null) || string.equals("")) {
			return string;
		}

		return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
	}

	/**
	 * -
	 *
	 * @param pString
	 *
	 * @return
	 */
	public static int getQtLetrasMaiusculas(String pString) {
		int tamanho = pString.length();
		int quantidade = 0;
		char letra = 0;

		for (int i = 0; i < tamanho; i++) {
			letra = pString.charAt(i);

			if (Character.isUpperCase(letra)) {
				quantidade++;
			}
		}

		return quantidade;
	}

	/**
	 * -
	 *
	 * @param pString
	 *
	 * @return
	 */
	public static int getQtLetrasMinusculas(String pString) {
		int tamanho = pString.length();
		int quantidade = 0;
		char letra = 0;

		for (int i = 0; i < tamanho; i++) {
			letra = pString.charAt(i);

			if (Character.isLowerCase(letra)) {
				quantidade++;
			}
		}

		return quantidade;
	}

	/**
	 * -
	 *
	 * @param pNomePessoaFisica
	 *
	 * @return
	 */
	public static String comprimirNomePessoaFisica(String pNomePessoaFisica) {
		// Recebendo a String sem os possiveis espa�os em branco no inicio e no final da string String nomePessoaFisica = pNomePessoaFisica.trim();
		ArrayList nomesPessoas = null;
		ArrayList nomesInvalidos = new ArrayList();
		String nomeComprimido = null;
		String strPrimeiroNomePessoa = "";
		String strPenultimoNomePessoa = "";

		nomesInvalidos.add("de");
		nomesInvalidos.add("do");
		nomesInvalidos.add("da");
		nomesInvalidos.add("e");

		if (pNomePessoaFisica != null) {
			nomesPessoas = split(pNomePessoaFisica, " ");
			nomeComprimido = "";

			// Formatando o primeiro nome da pessoa
			strPrimeiroNomePessoa = nomesPessoas.get(0).toString();

			nomesPessoas.set(0, strPrimeiroNomePessoa);

			// Percorrendo nomesPessoas (do segundo ao pen�ltimo) para retirar os nomes inv�lidos : de, do, etc..
			String strNomePessoa = null;
			String strNomeInvalido = null;

			for (int i = 1; i < (nomesPessoas.size() - 2); i++) {
				for (int j = 0; j < (nomesInvalidos.size() - 1); j++) {
					strNomePessoa = nomesPessoas.get(i).toString();
					strNomeInvalido = nomesInvalidos.get(j).toString();

					if (strNomePessoa.equalsIgnoreCase(strNomeInvalido)) {
						nomesPessoas.remove(i);
					}
				}
			}

			/* Abreviando os nomes entre o primeiro e o �ltimo nome
			   verifica se o �ltimo nome eh "Filho", "Neto" ou "J�nior"
			   se for, o penultimo nome n�o ser� abreviado, do contr�rio somente o �ltimo e o primeiro n�o s�o abreviados
			 */
			String strUltimoNomePessoa = nomesPessoas.get(nomesPessoas.size() - 1).toString();

			if (strUltimoNomePessoa.equalsIgnoreCase("Filho") || strUltimoNomePessoa.equalsIgnoreCase("Junior") ||
					strUltimoNomePessoa.equalsIgnoreCase("Neto")) {
				// Percorre as posi��es de nomesPessoas do segundo at� o ante-pen�ltimo nome
				for (int i = 1; i < (nomesPessoas.size() - 2); i++) {
					// A posi��o de nomesPessoas vai ser trocada pela primeira letra do nome anterior + "." 
					if (!nomesPessoas.get(i).equals("")) {
						nomesPessoas.set(i, nomesPessoas.get(i).toString().substring(0, 1) + ".");
					}
				}

				strPenultimoNomePessoa = nomesPessoas.get(nomesPessoas.size() - 2).toString();

				nomesPessoas.set(nomesPessoas.size() - 2, strPenultimoNomePessoa);
				nomesPessoas.set(nomesPessoas.size() - 1, strUltimoNomePessoa);
			} else {
				// Percorre as posi��es de nomesPessoas do segundo at� o pen�ltimo nome
				for (int i = 1; i < (nomesPessoas.size() - 1); i++) {
					// A posi��o de nomesPessoas vai ser trocada pela primeira letra do nome anterior + "." 
					if (!nomesPessoas.get(i).equals("")) {
						nomesPessoas.set(i, nomesPessoas.get(i).toString().substring(0, 1) + ".");
					}
				}

				nomesPessoas.set(nomesPessoas.size() - 1, strUltimoNomePessoa);
			}

			// Precorre nomesPessoas e concatena suas posi��es num String de retorno
			for (int i = 0; i < nomesPessoas.size(); i++) {
				if (!nomesPessoas.get(i).equals("")) {
					nomeComprimido = nomeComprimido + " " + nomesPessoas.get(i);
				}
			}

			nomeComprimido = nomeComprimido.trim();
		}

		return nomeComprimido;
	}

	/**
	 * -
	 *
	 * @param string
	 *
	 * @return
	 */
	public static int getQtDigitos(String string) {
		int tamanho = string.length();
		int quantidade = 0;
		char letra = 0;

		for (int i = 0; i < tamanho; i++) {
			letra = string.charAt(i);

			if (Character.isDigit(letra)) {
				quantidade++;
			}
		}

		return quantidade;
	}

	/**
	 * Completa o n�mero passado como par�metro com 'pQtZeros' zeros a esquerda
	 *
	 * @param pNumero N�mero a ser modificado
	 * @param pTmFormato
	 *
	 * @return String
	 */
	public static String completarNumeroComZerosEsquerda(long pNumero, int pTmFormato) {
		DecimalFormat formato = null;
		String zeros = "";

		for (int i = 0; i < pTmFormato; i++) {
			zeros = zeros + "0";
		}

		formato = new DecimalFormat(zeros);

		return formato.format(pNumero);
	}

	/**
	 * -
	 *
	 * @param pString
	 * @param pTmFormato
	 *
	 * @return
	 */
	public static String completarNumeroComZerosEsquerda(String pString, int pTmFormato) {
		int contador = pString.length();

		for (int i = contador; i < pTmFormato; i++) {
			pString = "0" + pString;
		}

		return pString;
	}

	/**
	 * -
	 *
	 * @param pString
	 * @param pTmFormato
	 *
	 * @return
	 */
	public static String completarNumeroComZerosDireita(String pString, int pTmFormato) {
		int contador = pString.length();
		String zeros = "";
		String retorno = "";

		for (int i = contador; i < pTmFormato; i++) {
			zeros = zeros + "0";
		}

		retorno = pString + zeros;

		return retorno;
	}

	/**
	 * -
	 *
	 * @param pString
	 * @param pTmFormato
	 *
	 * @return
	 */
	public static String completarStringComBrancosDireita(String pString, int pTmFormato) {
		int contador = pString.length();

		for (int i = contador; i < pTmFormato; i++) {
			pString = pString + " ";
		}

		return pString;
	}

	/**
	 * -
	 *
	 * @param pString
	 *
	 * @return
	 */
	public static String removerZerosDireitaNumero(String pString) {
		int contador = pString.length();
		StringBuffer buf = new StringBuffer(pString);
		char[] c = pString.toCharArray();

		for (int i = contador - 1; i > -1; i--) {
			if (c[i] == '0') {
				buf.deleteCharAt(i);
			} else {
				break;
			}
		}

		return new String(buf);
	}

	/**
	 * -
	 *
	 * @param pArrayBytes
	 *
	 * @return
	 */
	public static String getArrayBytesComoString(byte[] pArrayBytes) {
		int tamArrayBytes = pArrayBytes.length;

		ByteArrayOutputStream baos = new ByteArrayOutputStream(tamArrayBytes);
		baos.write(pArrayBytes, 0, tamArrayBytes);

		return baos.toString();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static String getNmLocalhost() {
		return Constantes.NM_LOCALHOST;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static String getNuIPLocalhost() {
		return Constantes.NU_IP_LOCALHOST;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static byte[] getNuIPRawLocalhost() {
		return Constantes.NU_IP_RAW_LOCALHOST;
	}

	/**
	 * -
	 *
	 * @param pPath
	 *
	 * @return
	 */
	public static String corrigirPathFileSystem(String pPath) {
		String retorno = "";

		retorno = BibliotecaFuncoesPrincipal.substituir(pPath, "/", File.separator);
		retorno = BibliotecaFuncoesPrincipal.substituir(retorno, "\\", File.separator);

		return retorno;
	}

	/**
	 * encode plaintext data to a base 64 string
	 *
	 * @param plain the text to convert. If plain is longer than 76 characters this method returns null (see RFC2045).
	 *
	 * @return the encoded text (or null if string was longer than 76 chars).
	 */
	public static String codificar(String plain) {
		if (plain.length() > 76) {
			return null;
		}

		//int maxturns;
		StringBuffer sb = new StringBuffer();

		//the encode buffer
		byte[] enc = new byte[3];
		boolean end = false;

		for (int i = 0, j = 0; !end; i++) {
			//char _ch = plain.charAt(i);
			if (i == (plain.length() - 1)) {
				end = true;
			}

			enc[j++] = (byte) plain.charAt(i);

			if ((j == 3) || end) {
				int res;

				//this is a bit inefficient at the end point
				//worth it for the small decrease in code size?
				res = (enc[0] << 16) + (enc[1] << 8) + enc[2];

				int b;
				int lowestbit = 18 - (j * 6);

				for (int toshift = 18; toshift >= lowestbit; toshift -= 6) {
					b = res >>> toshift;
					b &= 63;

					if ((b >= 0) && (b < 26)) {
						sb.append((char) (b + 65));
					}

					if ((b >= 26) && (b < 52)) {
						sb.append((char) (b + 71));
					}

					if ((b >= 52) && (b < 62)) {
						sb.append((char) (b - 4));
					}

					if (b == 62) {
						sb.append('+');
					}

					if (b == 63) {
						sb.append('/');
					}

					if ((sb.length() % 76) == 0) {
						sb.append('\n');
					}
				}

				//now set the end chars to be pad character if there 
				//was less than integral input (ie: less than 24 bits)
				if (end) {
					if (j == 1) {
						sb.append("==");
					}

					if (j == 2) {
						sb.append('=');
					}
				}

				enc[0] = 0;
				enc[1] = 0;
				enc[2] = 0;
				j = 0;
			}
		}

		return sb.toString();
	}

	/**
	 * Decode a Base 64 encoded String. <br>
	 * This method uses a naive String to byte interpretation, it simply gets each char of the String and calls it a byte. <br>
	 * Since we should be dealing with Base64 encoded Strings that is a reasonable assumption. <br>
	 * We don't try to stop the converion when we find the "=" end of data padding char. <br>
	 * We simply add zero bytes to the unencode buffer.
	 *
	 * @param encoded
	 *
	 * @return
	 */
	public static String decodificar(String encoded) {
		StringBuffer sb = new StringBuffer();
		int maxturns;

		//work out how long to loop for.
		if ((encoded.length() % 3) == 0) {
			maxturns = encoded.length();
		} else {
			maxturns = encoded.length() + (3 - (encoded.length() % 3));
		}

		//tells us whether to include the char in the unencode
		boolean skip;

		//the unencode buffer
		byte[] unenc = new byte[4];
		byte b;

		for (int i = 0, j = 0; i < maxturns; i++) {
			skip = false;

			//get the byte to convert or 0
			if (i < encoded.length()) {
				b = (byte) encoded.charAt(i);
			} else {
				b = 0;
			}

			//test and convert first capital letters, lowercase, digits then '+' and '/'
			if ((b >= 65) && (b < 91)) {
				unenc[j] = (byte) (b - 65);
			} else if ((b >= 97) && (b < 123)) {
				unenc[j] = (byte) (b - 71);
			} else if ((b >= 48) && (b < 58)) {
				unenc[j] = (byte) (b + 4);
			} else if (b == '+') {
				unenc[j] = 62;
			} else if (b == '/') {
				unenc[j] = 63;
			}
			//if we find "=" then data has finished, we're not really dealing with this now
			else if (b == '=') {
				unenc[j] = 0;
			} else {
				char c = (char) b;

				if ((c == '\n') || (c == '\r') || (c == ' ') || (c == '\t')) {
					skip = true;
				} else {
					//could throw an exception here? it's input we don't understand.
					;
				}
			}

			//once the array has boiled convert the bytes back into chars
			if (!skip && (++j == 4)) {
				//shift the 6 bit bytes into a single 4 octet word
				int res = (unenc[0] << 18) + (unenc[1] << 12) + (unenc[2] << 6) + unenc[3];
				byte c;
				int k = 16;

				//shift each octet down to read it as char and add to StringBuffer
				while (k >= 0) {
					c = (byte) (res >> k);

					if (c > 0) {
						sb.append((char) c);
					}

					k -= 8;
				}

				//reset j and the unencode buffer
				j = 0;
				unenc[0] = 0;
				unenc[1] = 0;
				unenc[2] = 0;
				unenc[3] = 0;
			}
		}

		return sb.toString();
	}

	/**
	 * Encode plaintext data to a base 64 String. Utilizada pelo SCA
	 *
	 * @param plain
	 *
	 * @return
	 */
	public static String codificar2(String plain) {
		String retorno = null;

		retorno = BibliotecaFuncoesPrincipal.codificar(Calendar.getInstance().get(Calendar.SECOND) + "|" + plain);

		return retorno;
	}

	/**
	 * Decode a Base 64 encoded String. Utilizada pelo SCA
	 *
	 * @param encoded
	 *
	 * @return
	 */
	public static String decodificar2(String encoded) {
		String aux = null;
		String retorno = null;

		aux = BibliotecaFuncoesPrincipal.decodificar(encoded);

		if (aux.indexOf("|") > -1) {
			retorno = aux.substring(aux.indexOf("|") + 1);
		}

		return retorno;
	}

	/**
	 * -
	 *
	 * @param pString
	 *
	 * @return
	 *
	 * @throws NoSuchAlgorithmException
	 */
	public static String criptografarComMD5(String pString)
		throws NoSuchAlgorithmException {
		String retorno = BibliotecaFuncoesPrincipal.criptografar("MD5", pString);

		return retorno;
	}

	/**
	 * -
	 *
	 * @param pString
	 *
	 * @return
	 *
	 * @throws NoSuchAlgorithmException
	 */
	public static String criptografarComSHA(String pString)
		throws NoSuchAlgorithmException {
		String retorno = BibliotecaFuncoesPrincipal.criptografar("SHA", pString);

		return retorno;
	}

	/**
	 * -
	 *
	 * @param pNmAlgoritmo
	 * @param pString
	 *
	 * @return
	 *
	 * @throws NoSuchAlgorithmException
	 */
	private static String criptografar(String pNmAlgoritmo, String pString)
		throws NoSuchAlgorithmException {
		byte[] buf = pString.getBytes();
		StringBuffer hexString = new StringBuffer();
		MessageDigest algorithm = null;

		// Use the MD5 algorithm.
		algorithm = MessageDigest.getInstance(pNmAlgoritmo);

		algorithm.reset();
		algorithm.update(buf);

		byte[] digest = algorithm.digest();
		String auxStr;

		for (int i = 0; i < digest.length; i++) {
			auxStr = Integer.toHexString(0xFF & digest[i]);

			if (auxStr.length() == 1) {
				auxStr = "0" + auxStr;
			}

			hexString.append(auxStr);
		}

		return hexString.toString();
	}

	/**
	 * -
	 *
	 * @param pString
	 *
	 * @return
	 *
	 * @throws ExcecaoSistema
	 */
	public static byte[] compactar(String pString) throws ExcecaoSistema {
		byte[] bytes = null;

		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			GZIPOutputStream gzipos = new GZIPOutputStream(baos);
			OutputStreamWriter osw = new OutputStreamWriter(gzipos);

			osw.write(pString);
			osw.close();

			bytes = baos.toByteArray();
		} catch (IOException e) {
			throw new ExcecaoSistema("Erro compactando String", e);
		}

		return bytes;
	}

	/**
	 * -
	 *
	 * @param pBytes
	 *
	 * @return
	 *
	 * @throws ExcecaoSistema
	 */
	public static String descompactar(byte[] pBytes) throws ExcecaoSistema {
		String resultado = "";
		byte[] buf = null;
		byte[] bufTemp = null;

		int c = 0;
		int x = 0;

		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(pBytes);
			GZIPInputStream gzipis = new GZIPInputStream(bais);
			InputStreamReader isr = new InputStreamReader(gzipis);

			x = 0;
			buf = new byte[1];

			while ((c = isr.read()) != -1) {
				if (x >= buf.length) {
					bufTemp = new byte[buf.length * 2];
					System.arraycopy(buf, 0, bufTemp, 0, buf.length);
					buf = bufTemp;
				}

				buf[x] = new Integer(c).byteValue();
				x++;
			}

			bufTemp = new byte[x];
			System.arraycopy(buf, 0, bufTemp, 0, x);
			resultado = new String(bufTemp);
		} catch (IOException e) {
			throw new ExcecaoSistema("Erro descompactando String", e);
		}

		return resultado;
	}

	/**
	 * -
	 *
	 * @param pArquivoEntrada
	 *
	 * @return
	 *
	 * @throws ExcecaoSistema
	 */
	public static Arquivo compactarArquivo(Arquivo pArquivoEntrada)
		throws ExcecaoSistema {
		int cont;

		// Foi declarado um buffer com valor 2048, logo o arquivo ser� lido de 2 em 2 KB.
		byte[] dados = new byte[2048];

		// Streams de entrada e sa�da.
		BufferedInputStream bisEntrada = null;
		FileInputStream fisEntrada = null;
		FileOutputStream fosSaida = null;
		ZipOutputStream zosSaida = null;
		Arquivo arquivoSaida = null;

		// Utilizado para gravar o arquivo de forma comprimida. 
		ZipEntry entry = null;

		try {
			arquivoSaida = new Arquivo(pArquivoEntrada.getNmCompletoArquivoSemExtensao() + ".zip");

			fosSaida = arquivoSaida.getFileOutputStream();
			zosSaida = new ZipOutputStream(new BufferedOutputStream(fosSaida));

			fisEntrada = pArquivoEntrada.getFileInputStream();
			bisEntrada = new BufferedInputStream(fisEntrada, 2048);
			entry = new ZipEntry(pArquivoEntrada.getNmArquivo());
			zosSaida.putNextEntry(entry);

			while ((cont = bisEntrada.read(dados, 0, 2048)) != -1) {
				zosSaida.write(dados, 0, cont);
			}

			bisEntrada.close();
			fisEntrada.close();

			zosSaida.close();
			fosSaida.close();

			arquivoSaida.fechar();
		} catch (Exception e) {
			throw new ExcecaoSistema("Erro compactando arquivo [pArquivoEntrada = " + pArquivoEntrada.getNmCompletoArquivo() + "]",
				e);
		}

		return arquivoSaida;
	}

	/**
	 * -
	 *
	 * @param pNmCompletoDiretorioEntrada
	 * @param pArquivoSaida
	 *
	 * @throws ExcecaoSistema
	 */
	public static void compactarArquivosDiretorio(String pNmCompletoDiretorioEntrada, Arquivo pArquivoSaida)
		throws ExcecaoSistema {
		// Contadores. 
		int cont;

		// Foi declarado um buffer com valor 2048, logo o arquivo ser� lido de 2 em 2 KB.
		byte[] dados = new byte[2048];

		// Lista dos arquivos a serem compactados. 
		String[] arquivosEntrada;
		File diretorioEntrada = null;
		Arquivo arquivoEntrada = null;

		// Streams de entrada e sa�da.
		BufferedInputStream bisEntrada = null;
		FileInputStream fisEntrada = null;
		FileOutputStream fosSaida = null;
		ZipOutputStream zosSaida = null;

		// Usado para gravar o arquivo de forma comprimida. 
		ZipEntry entry = null;

		try {
			fosSaida = new FileOutputStream(pArquivoSaida.getNmCompletoArquivo());
			zosSaida = new ZipOutputStream(new BufferedOutputStream(fosSaida));

			diretorioEntrada = new File(pNmCompletoDiretorioEntrada); // Todos os arquivos do diret�rio
			arquivosEntrada = diretorioEntrada.list();

			for (int i = 0; i < arquivosEntrada.length; i++) {
				arquivoEntrada = new Arquivo(pNmCompletoDiretorioEntrada + File.separator + arquivosEntrada[i]);

				if (arquivoEntrada.existe() &&
						!(arquivoEntrada.getNmCompletoArquivo()).equals(pArquivoSaida.getNmCompletoArquivo())) {
					fisEntrada = arquivoEntrada.getFileInputStream();
					bisEntrada = new BufferedInputStream(fisEntrada, 2048);
					entry = new ZipEntry(arquivoEntrada.getNmArquivo());
					zosSaida.putNextEntry(entry);

					while ((cont = bisEntrada.read(dados, 0, 2048)) != -1) {
						zosSaida.write(dados, 0, cont);
					}

					bisEntrada.close();
					fisEntrada.close();

					arquivoEntrada.fechar();
				}
			}

			zosSaida.close();
			fosSaida.close();
		} catch (Exception e) {
			throw new ExcecaoSistema("Erro compactando arquivos do diret�rio [pNmCompletoDiretorioEntrada = " +
				pNmCompletoDiretorioEntrada + "]", e);
		}
	}

	/**
	 * -
	 *
	 * @param pArquivoEntrada
	 * @param pQtKbytes
	 * @param pQtPartes
	 *
	 * @throws ExcecaoGenerica
	 * @throws ExcecaoSistema
	 */
	public static void dividirArquivoCompactado(Arquivo pArquivoEntrada, long pQtKbytes, int pQtPartes)
		throws ExcecaoGenerica {
		int qtPartes = 0;
		long qtBytesParte = 0;
		long qtBytesArquivo = pArquivoEntrada.getTamanhoArquivo();
		FileInputStream fisEntrada = null;
		FileOutputStream[] fosArquivosSaida = null;
		byte[] buffer = null;

		try {
			if (pQtKbytes > 0) {
				qtBytesParte = pQtKbytes * 1024;

				if ((qtBytesArquivo % qtBytesParte) > 0L) {
					qtPartes = (int) ((qtBytesArquivo / qtBytesParte) + 1L);
				} else {
					qtPartes = (int) (qtBytesArquivo / qtBytesParte);
				}
			} else if (pQtPartes > 0) {
				qtPartes = pQtPartes;
				qtBytesParte = (int) ((qtBytesArquivo / qtPartes) + 1L);
			} else {
				throw new ExcecaoParametroInvalido("Informe pQtKbytes ou pQtPartes [pQtKbytes = " + pQtKbytes + " | pQtPartes = " +
					pQtPartes + "]");
			}

			String[] arquivosSaida = new String[qtPartes];

			for (int a = 0; a < arquivosSaida.length; a++) {
				arquivosSaida[a] = pArquivoEntrada.getNmCompletoArquivoSemExtensao() + ".zip." +
					BibliotecaFuncoesPrincipal.completarNumeroComZerosEsquerda(a + 1, 3);
			}

			fisEntrada = pArquivoEntrada.getFileInputStream();
			buffer = new byte[1024];
			fosArquivosSaida = new FileOutputStream[arquivosSaida.length];

			for (int a = 0; a < fosArquivosSaida.length; a++) {
				fosArquivosSaida[a] = new FileOutputStream(arquivosSaida[a]);

				int lido;

				for (long escrito = 0L; (escrito < qtBytesParte) && ((lido = fisEntrada.read(buffer)) > 0);) {
					escrito += lido;
					fosArquivosSaida[a].write(buffer, 0, lido);
				}
			}
		} catch (Exception e) {
			throw new ExcecaoSistema("Erro dividindo arquivo compactado [pArquivoEntrada = " +
				pArquivoEntrada.getNmCompletoArquivo() + "]", e);
		} finally {
			if (fisEntrada != null) {
				try {
					fisEntrada.close();
				} catch (Exception e) {
				}

				fisEntrada = null;
			}

			if (fosArquivosSaida != null) {
				for (int a = 0; a < fosArquivosSaida.length; a++) {
					try {
						fosArquivosSaida[a].close();
					} catch (Exception e) {
					}

					fosArquivosSaida[a] = null;
				}

				fosArquivosSaida = null;
			}
		}
	}

	/**
	 * Deleta todos os arquivos e subdiret�rios dentro do diret�rio. Retorna true se todas as remo��es foram realizadas com
	 * sucesso. Se a remo��o falhar, o m�todo para e retorna false.
	 *
	 * @param pDir
	 *
	 * @return
	 */
	public boolean apagarDiretorio(File pDir) {
		if (pDir.isDirectory()) {
			String[] children = pDir.list();

			for (int i = 0; i < children.length; i++) {
				boolean success = apagarDiretorio(new File(pDir, children[i]));

				if (!success) {
					return false;
				}
			}
		}

		// O diret�rio est� limpo, logo � poss�vel delet�-lo.
		return pDir.delete();
	}

	/**
	 * -
	 *
	 * @param pArquivoEntrada
	 *
	 * @return
	 *
	 * @throws ExcecaoSistema
	 */
	public static Arquivo[] descompactarArquivo(Arquivo pArquivoEntrada)
		throws ExcecaoSistema {
		InputStream is = null;
		ZipInputStream zis = null;
		ZipEntry ze = null;
		FileOutputStream fos = null;
		File arquivoRetorno = null;
		File diretorioRetorno = null;
		Arquivo[] arrayRetorno = null;
		ArrayList arrayAux = null;

		try {
			is = new BufferedInputStream(pArquivoEntrada.getFileInputStream());
			zis = new ZipInputStream(is);
			fos = null;
			arrayAux = new ArrayList();

			while ((ze = zis.getNextEntry()) != null) {
				if (ze.isDirectory()) {
					diretorioRetorno = new File(pArquivoEntrada.getNmPasta() + "/" + ze.getName());
					diretorioRetorno.mkdirs();
				} else {
					arquivoRetorno = new File(pArquivoEntrada.getNmPasta() + "/" + ze.getName());
					diretorioRetorno = arquivoRetorno.getParentFile();

					if (!diretorioRetorno.isDirectory()) {
						diretorioRetorno.mkdirs();
					}
					fos = new FileOutputStream(arquivoRetorno);

					byte[] b = new byte[512];
					int len = 0;

					while ((len = zis.read(b)) != -1) {
						fos.write(b, 0, len);
					}

					fos.close();
					arrayAux.add(new Arquivo(arquivoRetorno));
				}
			}

			zis.close();

			arrayRetorno = new Arquivo[arrayAux.size()];

			for (int i = 0; i < arrayRetorno.length; i++) {
				arrayRetorno[i] = (Arquivo) arrayAux.get(i);
			}
		} catch (Exception e) {
			throw new ExcecaoSistema("Erro decompactando arquivo [pArquivoEntrada = " + pArquivoEntrada + "]", e);
		}

		return arrayRetorno;
	}

	/**
	 * -
	 *
	 * @param pString
	 *
	 * @return
	 */
	public static StringBuffer getStringComoStringBuffer(String pString) {
		StringBuffer resultado = null;
		char[] chars = null;
		int tamanho = 0;

		resultado = new StringBuffer(0);

		chars = pString.toCharArray();
		tamanho = chars.length;

		for (int i = 0; i < tamanho; i++) {
			resultado.append(chars[i]);
		}

		return resultado;
	}

	/**
	 * -
	 *
	 * @param pString
	 * @param pQtMaxCaracteres
	 *
	 * @return
	 */
	public static StringBuffer getStringComoStringBuffer(String pString, int pQtMaxCaracteres) {
		StringBuffer resultado = null;
		char[] chars = null;
		int tamanho = 0;

		resultado = new StringBuffer(0);

		chars = pString.toCharArray();
		tamanho = chars.length;

		if (pQtMaxCaracteres < tamanho) {
			tamanho = pQtMaxCaracteres;
		}

		for (int i = 0; i < tamanho; i++) {
			resultado.append(chars[i]);
		}

		return resultado;
	}

	/**
	 * -
	 *
	 * @param t
	 *
	 * @return
	 */
	public static String getStackTrace(Throwable t) {
		CharArrayWriter ch = new CharArrayWriter();
		PrintWriter pw = new PrintWriter(ch, true);
		t.printStackTrace(pw);

		return (ch.toString()).trim();
	}

	/**
	 * -
	 *
	 * @param pTpLog
	 * @param pNmClasse
	 * @param pTxLog
	 */
	private static void registrarLogStdOut(String pTpLog, String pNmClasse, String pTxLog) {
		if (pNmClasse != null) {
			System.out.println("[sfi] [" + pTpLog + "]" + " => " + pTxLog + " (" + pNmClasse + ")");
		} else {
			System.out.println("[sfi] [" + pTpLog + "]" + " => " + pTxLog);
		}
	}

	/**
	 * -
	 *
	 * @param pNmClasse
	 * @param pTxLog
	 */
	private static void registrarLogStdErr(String pNmClasse, String pTxLog) {
		System.err.println("[sfi] [erro]" + " => " + pTxLog + " (" + pNmClasse + ")");
	}

	/**
	 * Utilizado para registrar logs de informação do sistema
	 *
	 * @param pNmClasse pNmClasse    Nome da classe (this.getClass().getName())
	 * @param pTxLog pTxLog        Texto do log
	 */
	public static void registrarLogInformacao(String pNmClasse, String pTxLog) {
		ArrayList tokens = null;

		if (pNmClasse != null) {
			tokens = BibliotecaFuncoesPrincipal.split(pNmClasse, ".");

			if ((tokens.size() >= 9) && (tokens.get(5) != null) &&
					BibliotecaFuncoesPrincipal.isAreaFuncional((String) tokens.get(5)) && (tokens.get(8) != null) &&
					(tokens.get(8).toString().indexOf("Fachada") == -1) && (tokens.get(8).toString().indexOf("Constantes") == -1)) {
				// N�o registra log se for classe de algum sistema
				return;
			}
		}

		BibliotecaFuncoesPrincipal.registrarLogStdOut("informação", pNmClasse, pTxLog);
	}

	/**
	 * Utilizado para registrar logs de trace do framework
	 *
	 * @param pNmClasse pNmClasse    Nome da classe (this.getClass().getName())
	 * @param pTxLog pTxLog        Texto do log
	 */
	public static void registrarLogTrace(String pNmClasse, String pTxLog) {
		if (!Parametros.getInstancia().isTraceAtivado()) {
			return;
		}

		ArrayList tokens = BibliotecaFuncoesPrincipal.split(pNmClasse, ".");

		if ((tokens.size() >= 6) && (tokens.get(5) != null) && BibliotecaFuncoesPrincipal.isAreaFuncional((String) tokens.get(5))) {
			// N�o registra log se for classe de algum sistema
			return;
		}

		String dh = "";
		Date dtHoje = BibliotecaFuncoesDataHora.getDataHoje();
		dh = "[" + BibliotecaFuncoesDataHora.getDataComoString(dtHoje) + " "
				+ BibliotecaFuncoesDataHora.getHoraComoStringComMilis(dtHoje) + "]";
		BibliotecaFuncoesPrincipal.registrarLogStdOut("trace", pNmClasse, dh + " " + pTxLog);
	}

	/**
	 * Utilizado para registrar logs de trace dos sistemas
	 *
	 * @param pCdSistema pNmClasse    Nome da classe (this.getClass().getName())
	 * @param pNmClasse pTxLog        Texto do log
	 * @param pTxLog
	 */
	public static void registrarLogTrace(String pCdSistema, String pNmClasse, String pTxLog) {
		if (Parametros.getInstancia().isTraceAtivado(pCdSistema)) {
			String dh = "";
			Date dtHoje = BibliotecaFuncoesDataHora.getDataHoje();
			dh = "[" + BibliotecaFuncoesDataHora.getDataComoString(dtHoje) + " " +
				BibliotecaFuncoesDataHora.getHoraComoStringComMilis(dtHoje) + "]";
			BibliotecaFuncoesPrincipal.registrarLogStdOut("trace " + pCdSistema.toLowerCase(), pNmClasse,
				dh + " [Thread=" + Thread.currentThread().getName() + "] " + pTxLog);
		}
	}

	/**
	 * Utilizado para registrar logs de erro do sistema
	 *
	 * @param pNmClasse pNmClasse    Nome da classe (this.getClass().getName())
	 * @param pTxLog pTxLog        Texto do log
	 */
	public static void registrarLogErro(String pNmClasse, String pTxLog) {
		BibliotecaFuncoesPrincipal.registrarLogStdErr(pNmClasse, pTxLog);
	}

	/**
	 * Utilizado pela classe Job
	 *
	 * @param pNmClasse pNmClasse    Nome da classe (this.getClass().getName())
	 * @param pTxLog pTxLog        Texto do log
	 */
	public static void registrarLogJob(String pNmClasse, String pTxLog) {
		String log = BibliotecaFuncoesPrincipal.getTxLogJob(pNmClasse, pTxLog);
		
		System.out.println(log);
	}
	
	/**
	 * Utilizado pela classe Job
	 *
	 * @param pNmClasse pNmClasse    Nome da classe (this.getClass().getName())
	 * @param pTxLog pTxLog        Texto do log
	 *
	 * @return
	 */
	public static String getTxLogJob(String pNmClasse, String pTxLog) {
		String log = "";
		Date dtHoje = BibliotecaFuncoesDataHora.getDataHoje();

		log = "[sfi] [job] " + "[" + BibliotecaFuncoesDataHora.getDataComoString(dtHoje);
		log = log + " " + BibliotecaFuncoesDataHora.getHoraComoStringComMilis(dtHoje) + "]";
		log = log + " " + pTxLog;

		return log;
	}

	/**
	 * -
	 *
	 * @param pSgArea
	 *
	 * @return
	 */
	public static boolean isAreaFuncional(String pSgArea) {
		for (int i = 0; i < Constantes.SG_AREAS_FUNCIONAIS.length; i++) {
			if (Constantes.SG_AREAS_FUNCIONAIS[i].equalsIgnoreCase(pSgArea)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param pNmCompletoClasse
	 *
	 * @return Sigla do sistema
	 */
	public static String extrairSgSistema(String pNmCompletoClasse) {
		ArrayList array = BibliotecaFuncoesPrincipal.split(pNmCompletoClasse, ".");

		return (String) array.get(6);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param pNmCompletoClasse
	 *
	 * @return Sigla da �rea funcional
	 */
	public static String extrairSgAreaFuncional(String pNmCompletoClasse) {
		ArrayList array = BibliotecaFuncoesPrincipal.split(pNmCompletoClasse, ".");

		return (String) array.get(5);
	}

	/**
	 * -
	 *
	 * @param pSgSistema
	 *
	 * @return
	 */
	public static String getSgAreaFuncional(String pSgSistema) {
		String sgAreaFuncional = null;

		sgAreaFuncional = (String) Constantes.SG_AREAS_FUNCIONAIS_POR_SISTEMA.get(pSgSistema);

		if (sgAreaFuncional == null) {
			sgAreaFuncional = "[N�o dispon�vel]";
		}

		return sgAreaFuncional;
	}

	/**
	 * -
	 * 
	 * @param pCdSistema
	 * @return
	 */
	public static String getNmContextoWebPorSistema(String pCdSistema) {
		String nmContextoWeb = aNmContextoWebPorSistema.get(pCdSistema);

		if (nmContextoWeb == null) {
			String sgSfi = Constantes.NM_CONTEXTO_WEB;
			String sgArea = BibliotecaFuncoesPrincipal.getSgAreaFuncional(pCdSistema.toUpperCase()).toLowerCase();
			String cdSistema = pCdSistema.toLowerCase();

			StringBuilder sbNmParam = new StringBuilder(sgSfi.length() + sgArea.length() + cdSistema.length() + 2);
			sbNmParam.append(sgSfi);
			sbNmParam.append('_');
			sbNmParam.append(sgArea);
			sbNmParam.append('_');
			sbNmParam.append(cdSistema);

			nmContextoWeb = sbNmParam.toString();

			aNmContextoWebPorSistema.put(pCdSistema, nmContextoWeb);
		}

		return nmContextoWeb;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static String getNuVersaoSistema() {
		String nuVersao = "[N�o dispon�vel]";
		Arquivo arqVersaoSistema = null;
		InputStream is = null;
		Properties propriedades = null;

		try {
			arqVersaoSistema = new Arquivo(Constantes.NM_PATH_CONFIG + File.separator + "versao_sistema.properties");

			if (arqVersaoSistema.existe()) {
				is = arqVersaoSistema.getFileInputStream();
			} else {
				is = BibliotecaFuncoesPrincipal.class.getResourceAsStream("versao_sistema.properties");
			}

			propriedades = new Properties();
			propriedades.load(is);

			nuVersao = propriedades.getProperty("nu_versao_sistema");

			if (nuVersao == null) {
				is = BibliotecaFuncoesPrincipal.class.getResourceAsStream("versao_sistema.properties");

				propriedades = new Properties();
				propriedades.load(is);

				nuVersao = propriedades.getProperty("nu_versao_sistema");
			}
		} catch (Exception e) {
			BibliotecaFuncoesPrincipal.registrarLogInformacao(BibliotecaFuncoesPrincipal.class.getName(),
				"Erro obtendo vers�o do sistema [nu_versao_sistema]. Erro: [" + e.getClass().getName() + " | " + e.getMessage() +
				"]");
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException ex) {
					// Ignorar;
				}
			}
		}

		return nuVersao;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static String getNuVersaoFramework() {
		String nuVersao = "[N�o dispon�vel]";
		InputStream is = null;
		Properties propriedades = null;

		try {
			is = BibliotecaFuncoesPrincipal.class.getResourceAsStream("versao_sistema.properties");
			propriedades = new Properties();
			propriedades.load(is);

			nuVersao = propriedades.getProperty("nu_versao_sistema");
		} catch (Exception e) {
			BibliotecaFuncoesPrincipal.registrarLogInformacao(BibliotecaFuncoesPrincipal.class.getName(),
				"Erro obtendo vers�o do framework [nu_versao_sistema]. Erro: [" + e.getClass().getName() + " | " + e.getMessage() +
				"]");
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException ex) {
					// Ignorar;
				}
			}
		}

		return nuVersao;
	}

	/**
	 * -
	 *
	 * @param pSgSistema
	 *
	 * @return
	 */
	public static String getNmPathConfigSistema(String pSgSistema) {
		String path = "[N�o dispon�vel]";
		String sgAreaFuncional = BibliotecaFuncoesPrincipal.getSgAreaFuncional(pSgSistema);

		if (!sgAreaFuncional.equals("[N�o dispon�vel]")) {
			path = BibliotecaFuncoesPrincipal.getNmPathConfigSistema(sgAreaFuncional, pSgSistema);
		}

		return path;
	}

	/**
	 * -
	 *
	 * @param pSgAreaFuncional
	 * @param pSgSistema
	 *
	 * @return
	 */
	public static String getNmPathConfigSistema(String pSgAreaFuncional, String pSgSistema) {
		String path = "[N�o dispon�vel]";

		try {
			if (Parametros.getInstancia().isSfiArquivosExclusivoAtivado(pSgSistema)) {
				path = Constantes.NM_PATH_BASE + File.separator + "sfi_" + pSgAreaFuncional.toLowerCase() + "_" +
					pSgSistema.toLowerCase() + "_arquivos" + File.separator + "config" + File.separator + "sistemas" +
					File.separator + pSgAreaFuncional.toLowerCase() + "_" + pSgSistema.toLowerCase();
			} else {
				path = Constantes.NM_PATH_CONFIG + File.separator + "sistemas" + File.separator + pSgAreaFuncional.toLowerCase() +
					"_" + pSgSistema.toLowerCase();
			}
		} catch (Exception e) {
		}

		return path;
	}

	/**
	 * <p>Serializes an <code>Object</code> to the specified stream.</p>
	 *  <p>The stream will be closed once the object is written. This avoids the need for a finally clause, and maybe also
	 * exception handling, in the application code.</p>
	 *  <p>The stream passed in is not buffered internally within this method. This is the responsibility of your
	 * application if desired.</p>
	 *
	 * @param pObj the object to serialize to bytes, may be null
	 * @param pOutputStream the stream to write to, must not be null
	 *
	 * @throws IOException (runtime) if the serialization fails
	 * @throws IllegalArgumentException if <code>outputStream</code> is <code>null</code>
	 */
	public static void serializar(Serializable pObj, OutputStream pOutputStream)
		throws IOException {
		if (pOutputStream == null) {
			throw new IllegalArgumentException("pOutputStream n�o pode ser null | Classe: " +
				BibliotecaFuncoesPrincipal.class.getName() + " | M�todo: serializar");
		}

		ObjectOutputStream out = null;

		try {
			// stream closed in the finally
			out = new ObjectOutputStream(pOutputStream);
			out.writeObject(pObj);
		} catch (IOException ex) {
			throw ex;
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException ex) {
				// ignore;
			}
		}
	}
	
	/**
	 * <p>Serializes an <code>Object</code> to a byte array for storage/serialization.</p>
	 *
	 * @param pObj the object to serialize to bytes
	 *
	 * @return a byte[] with the converted Serializable
	 *
	 * @throws IOException (runtime) if the serialization fails
	 */
	public static byte[] serializar(Serializable pObj)
		throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream(512);
		BibliotecaFuncoesPrincipal.serializar(pObj, baos);
		
		return baos.toByteArray();
	}
	
	/**
	 * <p>Deserializes an <code>Object</code> from the specified stream.</p>
	 *  <p>The stream will be closed once the object is written. This avoids the need for a finally clause, and maybe also
	 * exception handling, in the application code.</p>
	 *  <p>The stream passed in is not buffered internally within this method. This is the responsibility of your
	 * application if desired.</p>
	 *
	 * @param pInputStream the serialized object input stream, must not be null
	 *
	 * @return the deserialized object
	 *
	 * @throws IOException (runtime) if the serialization fails
	 * @throws ClassNotFoundException
	 * @throws IllegalArgumentException if <code>inputStream</code> is <code>null</code>
	 */
	public static Object desserializar(InputStream pInputStream)
		throws IOException, ClassNotFoundException {
		if (pInputStream == null) {
			throw new IllegalArgumentException("pInputStream n�o pode ser null | Classe: " +
				BibliotecaFuncoesPrincipal.class.getName() + " | M�todo: desserializar");
		}
		
		ObjectInputStream in = null;
		
		try {
			// stream closed in the finally
			in = new ObjectInputStream(pInputStream);
			
			return in.readObject();
		} catch (IOException ex) {
			throw ex;
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				// ignore
			}
		}
	}
	
	/**
	 * <p>Deserializes a single <code>Object</code> from an array of bytes.</p>
	 *
	 * @param pObjectData the serialized object, must not be null
	 *
	 * @return the deserialized object
	 *
	 * @throws IOException (runtime) if the serialization fails
	 * @throws ClassNotFoundException
	 * @throws IllegalArgumentException if <code>objectData</code> is <code>null</code>
	 */
	public static Object desserializar(byte[] pObjectData)
		throws IOException, ClassNotFoundException {
		if (pObjectData == null) {
			throw new IllegalArgumentException("pObjectData n�o pode ser null | Classe: " +
				BibliotecaFuncoesPrincipal.class.getName() + " | M�todo: desserializar");
		}
		
		ByteArrayInputStream bais = new ByteArrayInputStream(pObjectData);
		
		return BibliotecaFuncoesPrincipal.desserializar(bais);
	}
	
	/**
	 * <p>Deep clone an <code>Object</code> using serialization.</p>
	 *  <p>This is many times slower than writing clone methods by hand on all objects in your object graph. However, for
	 * complex object graphs, or for those that don't support deep cloning this can be a simple alternative implementation. Of
	 * course all the objects must be <code>Serializable</code>.</p>
	 *
	 * @param pObjeto the<code>Serializable</code> object to clone
	 *
	 * @return the cloned object
	 *
	 * @throws IOException (runtime) if the serialization fails
	 * @throws ClassNotFoundException
	 */
	public static Object clone(Serializable pObjeto) throws IOException, ClassNotFoundException {
		return BibliotecaFuncoesPrincipal.desserializar(BibliotecaFuncoesPrincipal.serializar(pObjeto));
	}
	
	/**
	 * M�todo recursivo que ordena uma colecao de VOs
	 *
	 * @param pColecaoVOGenerico Uma colecao formada por VOGenerico
	 * @param pNmAtributoOrdenacao Atributo do VO usado para Ordena��o
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public static Collection ordenarColecaoVOGenerico(Collection pColecaoVOGenerico, String pNmAtributoOrdenacao)
		throws ExcecaoParametroInvalido {
		return ordenarColecaoVOGenerico(pColecaoVOGenerico, pNmAtributoOrdenacao, false);
	}
	
	/**
	 * M�todo recursivo que ordena uma colecao de VOs
	 *
	 * @param pColecaoVOGenerico Uma colecao formada por VOGenerico
	 * @param pNmAtributoOrdenacao Atributo do VO usado para Ordena��o
	 * @param pInAceitaValorNulo Indica permissao para utilizar valor nulo
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public static Collection ordenarColecaoVOGenerico(Collection pColecaoVOGenerico, String pNmAtributoOrdenacao,
		boolean pInAceitaValorNulo) throws ExcecaoParametroInvalido {
		ArrayList colecaoVO = null;
		Object[] arrayAtributosOrdenacao = null;
		VOGenerico voAtual = null;
		ArrayList retorno = new ArrayList();
		boolean isAtributoOrdenacaoString = false;
		
		try {
			colecaoVO = new ArrayList(pColecaoVOGenerico);
			
			if ((colecaoVO != null) && !colecaoVO.isEmpty()) {
				// cria um array contendo apenas os atributos de ordenacao
				// de cada VOGenerico da colecao
				arrayAtributosOrdenacao = new Object[colecaoVO.size()];
				
				for (int i = 0; i < colecaoVO.size(); i++) {
					voAtual = (VOGenerico) colecaoVO.get(i);
					arrayAtributosOrdenacao[i] = voAtual.getAtributo(pNmAtributoOrdenacao);
					
					if (arrayAtributosOrdenacao[i] == null) {
						if (pInAceitaValorNulo) {
							arrayAtributosOrdenacao[i] = "";
						} else {
							throw new ExcecaoParametroInvalido(
								"A cole��o possui um ou v�rios atributos de ordena��o com valor nulo.");
						}
					}
					
					if (arrayAtributosOrdenacao[i] instanceof String) {
						isAtributoOrdenacaoString = true;
					}
				}
				
				if (isAtributoOrdenacaoString) {
					for (int i = 0; i < arrayAtributosOrdenacao.length; i++) {
						// Se o atributo de ordenacao for uma string, transforma
						// o mesmo em uppercase
						arrayAtributosOrdenacao[i] = ((String) arrayAtributosOrdenacao[i]).toUpperCase();
						((VOGenerico) colecaoVO.get(i)).excluirAtributo(pNmAtributoOrdenacao);
						((VOGenerico) colecaoVO.get(i)).incluirAtributo(pNmAtributoOrdenacao, arrayAtributosOrdenacao[i]);
					}
				}
				
				// ordena o array dos atributos de ordenacao
				Arrays.sort(arrayAtributosOrdenacao);
				
				// Constroi uma nova colecao contendo todos os
				// VOGenericos ordenados
				for (int i = 0; i < arrayAtributosOrdenacao.length; i++) {
					for (int j = 0; j < colecaoVO.size(); j++) {
						voAtual = (VOGenerico) colecaoVO.get(j);
						
						if (arrayAtributosOrdenacao[i].equals(voAtual.getAtributo(pNmAtributoOrdenacao))) {
							retorno.add(voAtual);
							colecaoVO.remove(j);
							
							break;
						}
					}
				}
			}
		} catch (ClassCastException e) {
			throw new ExcecaoParametroInvalido("A cole��o tem que ser composta de objetos VOGenerico", e);
		} catch (NullPointerException npe) {
			throw new ExcecaoParametroInvalido("A cole��o possui um ou v�rios atributos de ordena��o com valor nulo.", npe);
		}
		
		return retorno;
	}
	
	/**
	 * -
	 *
	 * @param pQtMiliSegundos
	 */
	public static void delay(int pQtMiliSegundos) {
		try {
			Thread.sleep(pQtMiliSegundos);
		} catch(InterruptedException e) {
		}
	}
	
}
