package tsw.t02;

public class SomadorConcreto implements Somador {
	
	public double somar(double pValor01, double pValor02 ) {
		double resultado = pValor01 + pValor02;
		
		return resultado;
	}
	
}