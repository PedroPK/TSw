package tsw.t05;

public class Palindromo {
	
	public static boolean isPalindromo(String pFrase) {
		String fraseTratada = 
			pFrase.toUpperCase().replace(" ", "").replace("-", "");
		
		for ( int i = 0; i < fraseTratada.length(); i++) {
			if ( fraseTratada.charAt(i) != 
					fraseTratada.charAt(fraseTratada.length() -1 - i)
			) {
				return false;
			}
		}
		
		return true;
	}
	
}