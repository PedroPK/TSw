package tsw.t02;

public class CalculadoraConcreta implements Calculadora {
	
	public double somar(double pValor01, double pValor02 ) {
		double resultado = pValor01 + pValor02;
		
		return resultado;
	}

	public double dividir(double pDividendo, double pDivisor) {
		return pDividendo / pDivisor;
	}
	
	
	
}