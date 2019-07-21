package tsw.t02;

public class CalculadoraConcreta implements Calculadora {
	
	public double somar(String pValor01, String pValor02 ) {
		double resultado =
			Double.valueOf(pValor01)
			+ 
			Double.valueOf(pValor02);
		
		return resultado;
	}
	
	public double dividir(String pDividendo, String pDivisor) {
		return 
			Double.valueOf(pDividendo)
			/
			Double.valueOf(pDivisor);
	}
	
}