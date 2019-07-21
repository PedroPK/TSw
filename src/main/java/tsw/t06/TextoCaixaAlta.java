package tsw.t06;

public class TextoCaixaAlta extends TipoDado {

	private String aTexto;

	public TextoCaixaAlta(Object pTexto) throws ExcecaoCampoInvalido {
		try {

			this.aTexto = pTexto.toString().trim();;

		} catch (Exception e) {
			throw new ExcecaoCampoInvalido("Texto Caixa Alta", pTexto, "Erro construindo objeto 'TextoCaixaAlta'", e);
		}
	}

	public static String toString(TextoCaixaAlta pTexto) {
		if (pTexto == null) {
			return null;
		} else {
			return pTexto.toString();
		}
	}

	public static TextoCaixaAlta fromString(String pTexto) throws ExcecaoCampoInvalido {
		if (pTexto == null) {
			return null;
		} else {
			return new TextoCaixaAlta(pTexto);
		}
	}

	/**
	 * Utilizado dentro da JSP
	 * 
	 * @param	Object	pObjeto	Objeto a ser convertido para HTML
	 * @param	boolean	pIsTable	Se 'true' e pObjeto.toString igual a null ou "", retorna &nbsp;
	 * @return	String	HTML
	 * @exception	ExcecaoCampoInvalido	
	 */
	public static String toHTMLComMascara(Object pObjeto, boolean pIsTable) throws ExcecaoCampoInvalido {
		String retorno;
		
		if (pObjeto == null || pObjeto.toString().trim().equals("")) {
			if (pIsTable)
				return "&nbsp;";
			else
				return "";
		} else {
			TextoCaixaAlta tipo = new TextoCaixaAlta(pObjeto);
			retorno = tipo.toString();
			retorno = BibliotecaFuncoesPrincipal.substituir(retorno, "\"", "&quot;");
			
			return retorno;
		}
	}

	public String toString() {
		return this.aTexto.toUpperCase();
	}

	public String toStringComMascara() {
		return this.toString();
	}

	public static void main(String[] args) {
		String teste01 = "Alexandre";
		String teste02 = "Alexandre01";
		String teste03 = "01234";
		TextoCaixaAlta texto;

		try {
			System.out.println("\nTeste 01");
			texto = TextoCaixaAlta.fromString(teste01);
			System.out.println(texto.toStringComMascara());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			System.out.println("\nTeste 02");
			texto = TextoCaixaAlta.fromString(teste02);
			System.out.println(texto.toStringComMascara());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			System.out.println("\nTeste 03");
			texto = TextoCaixaAlta.fromString(teste03);
			System.out.println(texto.toStringComMascara());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}