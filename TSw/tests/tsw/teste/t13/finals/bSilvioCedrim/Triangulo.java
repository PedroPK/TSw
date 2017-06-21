package tsw.teste.t13.finals.bSilvioCedrim;

public class Triangulo implements iTriangulo{
	
	private Double tamanhoA;
	
	private Double tamanhoB;
	
	private Double tamanhoC;
	

	public Triangulo(Double tamanhoA, Double tamanhoB, Double tamanhoC) {
		this.tamanhoA = tamanhoA;
		this.tamanhoB = tamanhoB;
		this.tamanhoC = tamanhoC;
	}
	
	

	public Double getTamanhoA() {
		return tamanhoA;
	}

	public void setTamanhoA(Double tamanhoA) {
		this.tamanhoA = tamanhoA;
	}

	public Double getTamanhoB() {
		return tamanhoB;
	}

	public void setTamanhoB(Double tamanhoB) {
		this.tamanhoB = tamanhoB;
	}

	public Double getTamanhoC() {
		return tamanhoC;
	}

	public void setTamanhoC(Double tamanhoC) {
		this.tamanhoC = tamanhoC;
	}


	@Override
	public void validarTamanhoLado(Double pTamanhoLado){
		if(!isTamanhoLadoValido(pTamanhoLado)){
			throw new TamanhoInvalidoException(pTamanhoLado);
		}
		
	}

	@Override
	public void validarTodosOsLados() {
		if(!isTamanhoLadoValido(this.tamanhoA)){
			throw new TamanhoInvalidoException(tamanhoA);
		}
		if(!isTamanhoLadoValido(this.tamanhoB)){
			throw new TamanhoInvalidoException(tamanhoB);
		}
		if(!isTamanhoLadoValido(this.tamanhoC)){
			throw new TamanhoInvalidoException(tamanhoC);
		}
	}

	@Override
	public boolean isTamanhoLadoValido(Double pTamanhoLado) {
		if(pTamanhoLado > 0.0){
			return true;
		}
		return false;
	}

	@Override
	public boolean isEquilatero() {
		if(this.tamanhoA.equals(this.tamanhoB) && this.tamanhoB.equals(this.tamanhoC)){
			return true;
		}
		return false;
	}

	@Override
	public boolean isIsosceles() {
		if(this.tamanhoA.equals(this.tamanhoB) 
				|| this.tamanhoB.equals(this.tamanhoC) 
				|| this.tamanhoC.equals(this.tamanhoA)){
			return true;
		}
		return false;
	}

	@Override
	public boolean isTrianguloRetangulo() {
		if(validarRetangulo()){
			return true;
		}
		return false;
	}
	
	public boolean validarRetangulo(){
		if(Math.pow(this.tamanhoA, 2) == (Math.pow(this.tamanhoB, 2) + Math.pow(this.tamanhoC,2))
				|| Math.pow(this.tamanhoB, 2) == (Math.pow(this.tamanhoC, 2) + Math.pow(this.tamanhoA,2))
				|| Math.pow(this.tamanhoC, 2) == (Math.pow(this.tamanhoA, 2) + Math.pow(this.tamanhoB,2))){
			return true;
		}
		return false;
	}

	@Override
	public boolean isEscaleno() {
		if(!this.tamanhoA.equals(this.tamanhoB) 
				&& !this.tamanhoB.equals(this.tamanhoC) 
				&& !this.tamanhoA.equals(this.tamanhoC)){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isTrianguloValido() {
		if(isTresLadosValidos()){
			return true;
		}
		return false;
	}

	@Override
	public boolean isTresLadosValidos() {
		
		if(this.isTamanhoLadoValido(this.tamanhoA)
				&& this.isTamanhoLadoValido(this.tamanhoB)
				&& this.isTamanhoLadoValido(this.tamanhoC)){
			return true;
		}
		
		return false;
	}
	
	

}
