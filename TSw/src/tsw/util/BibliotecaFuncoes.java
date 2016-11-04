package tsw.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import tsw.t06.BibliotecaFuncoesPrincipal;

public class BibliotecaFuncoes {
	
	public static boolean isStringValida(String pString) {
		boolean resposta = false;
		
		if ( pString != null && pString.trim().length() > 0 ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isDataValida(String pData) {
		boolean resposta = false;
		
		if ( isStringValida(pData) ) {
			try {
				new SimpleDateFormat("dd/MM/yyyy").parse(pData);
				resposta = true;
			} catch (ParseException e) {
				resposta = false;
				e.printStackTrace();
			}
		}
		
		return resposta;
	}
	public static Date getData(String pData) {
		Date data = null;
		
		if ( isDataValida(pData) ) {
			try {
				data = new SimpleDateFormat("dd/MM/yyyy").parse(pData);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		return data;
	}
	
	public static boolean isColecaoValida(Collection pColecao) {
		boolean resposta = false;
		if ( pColecao != null && !pColecao.isEmpty() ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isColecaoValida(Collection pColecao, int pIndice) {
		boolean resposta = false;
		
		if ( isColecaoValida(pColecao) && pColecao.size() > pIndice ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isArrayValido(Object[] pArray) {
		boolean resposta = false;
		if ( pArray != null && pArray.length > 0 ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isArrayValido(Object[] pArray, int pIndice) {
		boolean resposta = false;
		
		if ( isArrayValido(pArray) && pArray.length > pIndice ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	
	public static String getBooleanComoSimOuNao(boolean pBoolean) {
		String resposta = "Não";
		if ( pBoolean ) {
			resposta = "Sim";
		}
		
		return resposta;
	}
	
	public static Object clone(Serializable pObjeto) {
		Object retorno = null;
		try {
			retorno = desserializar(BibliotecaFuncoesPrincipal.serializar(pObjeto));
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}
	
	public static Object desserializar(byte[] pObjectData)
	throws IOException, ClassNotFoundException {
		if ( pObjectData == null ) {
			throw new IllegalArgumentException("pObjectData n�o pode ser null | Classe: " +
				BibliotecaFuncoesPrincipal.class.getName() + " | M�todo: desserializar");
		}
		
		ByteArrayInputStream bais = new ByteArrayInputStream(pObjectData);
		
		return BibliotecaFuncoesPrincipal.desserializar(bais);
	}
	
}