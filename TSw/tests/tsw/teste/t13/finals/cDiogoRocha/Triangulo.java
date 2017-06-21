package tsw.teste.t13.finals.cDiogoRocha;


public class Triangulo implements iTriangulo {
	private Double lado1, lado2, lado3;
	
	public boolean isToLong() {
		if(lado1 > 9999999999.0 && lado2 < 10 || lado2 > 9999999999.0 && lado1 < 10)
			return true;
		else 
			return false;
	}
	
	public boolean pegarLadosNegativos() {
		if(lado1 < 0 || lado2 < 0 || lado3 < 0) 
			return true;
		else 
			return false;
	}
	
	public boolean pegarLadosVazios() {
		if(lado1 == null || lado2 == null || lado3 == null)
			return true;
		else
			return false;
	}


	public void setarTamanhos(Double lado1, Double lado2, Double lado3) {
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
	}
	
	public void verificarTriangulo() {
		validarTodosOsLados();
	}
	
	@Override
	public void validarTamanhoLado(Double pTamanhoLado) {
		istamanhoValido(pTamanhoLado);
	}
	
	@Override
	public void validarTodosOsLados() {
		validarTamanhoLado(lado1);
		validarTamanhoLado(lado2);
		validarTamanhoLado(lado3);
	}
	
	@Override
	public boolean istamanhoValido(Double pTamanhoLado) {
		if(pTamanhoLado <= 0)
			return false;
		else
			return true;
	}
	
	@Override
	public boolean isEquilatero() {
		if (lado1.equals(lado2) && lado1.equals(lado3))
			return true;
		else
			return false;
	}
	
	@Override
	public boolean isIsosceles() {
		if ((lado1.equals(lado2) ) || (lado1.equals(lado3)))
			return true;
		else
			return false;
	}
	
	
	@Override
	public boolean isEscaleno() {
		if (!lado1.equals(lado2) && !lado2.equals(lado3) && !lado3.equals(lado1))
			return true;
		else 
			return false;
	}
	
	@Override
	public boolean isTrianguloValido() {
		if ((lado1 < lado2 + lado3) && (lado2 < lado1 + lado3) && (lado3 < lado1 + lado2))
			return true;
		else
		return false;
	}
	
	@Override
	public boolean isTresLadosValidos() {
		try {
			validarTodosOsLados();
		} catch(Exception ex) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean isTrianguloRetangulo() {
	        if((Math.pow(lado1,2)+Math.pow(lado2,2)) == Math.pow(lado3,2))
	            return true;
	        if((Math.pow(lado2,2)+Math.pow(lado1,2)) == Math.pow(lado3,2))
	            return true;
	        if((Math.pow(lado3,2)+Math.pow(lado2,2)) == Math.pow(lado1,2))
	            return true;
	        else
	            return false;
	}
	

}
