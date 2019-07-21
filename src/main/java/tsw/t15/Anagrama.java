package tsw.t15;

public class Anagrama {
	
	public static boolean areAnagramas(String pStringOne, String pStringTwo) {
		boolean response = true;
		
		if ( !pStringOne.equals(pStringTwo) ) {
			response = false;
		}
		
		return response;
	}
	
}