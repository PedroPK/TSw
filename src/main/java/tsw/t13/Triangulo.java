package tsw.t13;

public class Triangulo implements iTriangulo {
	
	private Double aLadoA;
	private Double aLadoB;
	private Double aLadoC;
	
	public Triangulo() {
		super();
	}
	
	public Triangulo(double a, double b, double c) {
		this.aLadoA =	Double.valueOf(	a	);
		this.aLadoB =	Double.valueOf(	b	);
		this.aLadoC =	Double.valueOf(	c	);
		
		this.validarTresLadosTriangulo();
	}
	
	public Triangulo(Double pLadoA, Double pLadoB, Double pLadoC) {
		super();
		this.aLadoA = pLadoA;
		this.aLadoB = pLadoB;
		this.aLadoC = pLadoC;
		
		this.validarTresLadosTriangulo();
	}
	
	/**
	 * Getter's and Setter's
	 */
	public double getLadoA() {
		return aLadoA;
	}
	public void setLadoA(Double pLadoA) {
		validarTamanhoLado(pLadoA);
		this.aLadoA = pLadoA;
	}
	
	public double getLadoB() {
		return aLadoB;
	}
	public void setLadoB(Double pLadoB) {
		validarTamanhoLado(pLadoB);
		this.aLadoB = pLadoB;
	}
	public double getLadoC() {
		return aLadoC;
	}
	public void setLadoC(Double pLadoC) {
		validarTamanhoLado(pLadoC);
		this.aLadoC = pLadoC;
	}
	
	/**
	 * Validations
	 */
	
	public void validarTamanhoLado(Double pTamanhoLado) {
		if ( isTamanhoLadoValido(pTamanhoLado) ) {
			throw new ExcecaoTamanhoInvalido();
		}
	}
	public boolean isTamanhoLadoValido(Double pTamanhoLado) {
		return pTamanhoLado != null && pTamanhoLado.doubleValue() > 0;
	}
	
	public void validarTresLadosTriangulo() {
		if ( 
				!isTamanhoLadoValido(this.aLadoA)	||
				!isTamanhoLadoValido(this.aLadoB)	||
				!isTamanhoLadoValido(this.aLadoC)
		) {
			throw new ExcecaoTamanhoInvalido();
		}
		
		if ( 
				this.aLadoA + this.aLadoB <= this.aLadoC	||
				this.aLadoB + this.aLadoC <= this.aLadoA	||
				this.aLadoC + this.aLadoA <= this.aLadoB
		) {
			throw new ExcecaoTamanhoInvalido();
		}
	}
	
	/**
	 * Situation
	 */
	
	public boolean isEquilatero() {
		boolean resposta = true;
		
		if ( !this.isTresLadosValidos() ) {
			resposta = false;
		}
		
		if ( resposta &&
				(
					this.aLadoA.doubleValue()		!=		this.aLadoB.doubleValue()	||
					this.aLadoB.doubleValue()	!=		this.aLadoC.doubleValue()
				)
		) {
			resposta = false;
		}
		
		return resposta;
	}
	
	public boolean isIsosceles() {
		boolean resposta = true;
		
		if ( !this.isTresLadosValidos() ) {
			resposta = false;
		}
		
		if ( resposta &&
				!(
					this.aLadoA.doubleValue()	==		this.aLadoB.doubleValue()	||
					this.aLadoB.doubleValue()	==		this.aLadoC.doubleValue()	||
					this.aLadoC.doubleValue()	==		this.aLadoA.doubleValue()
				)
		) {
			resposta = false;
		}
		
		return resposta;
	}
	
	public boolean isEscaleno() {
		boolean resposta = true;
		
		if ( !this.isTresLadosValidos() ) {
			resposta = false;
		}
		
		if ( resposta &&
				(
					this.aLadoA.doubleValue()	==		this.aLadoB.doubleValue()
					||
					this.aLadoB.doubleValue()	==		this.aLadoC.doubleValue()
					||
					this.aLadoC.doubleValue()	==		this.aLadoA.doubleValue()
				)
		) {
			resposta = false;
		}
		
		return resposta;
	}
	
	public boolean isTrianguloValido() {
		boolean resposta = isTresLadosValidos();
		
		if ( resposta &&
				this.aLadoA.doubleValue() + this.aLadoB.doubleValue() > this.aLadoC.doubleValue() 
		) {
			resposta = false;
		}
		
		if ( resposta &&
				this.aLadoB.doubleValue() + this.aLadoC.doubleValue() > this.aLadoA.doubleValue()
		) {
			resposta = false;
		}
		
		if ( resposta &&
				this.aLadoA.doubleValue() + this.aLadoC.doubleValue() > this.aLadoB.doubleValue() 
		) {
			resposta = false;
		}
		
		return resposta;
	}
	
	public boolean isTresLadosValidos() {
		boolean resposta = true;
		
		if ( !isTamanhoLadoValido(this.aLadoA) ) {
			resposta = false;
		}
		
		if ( !isTamanhoLadoValido(this.aLadoB) ) {
			resposta = false;
		}
		
		if ( !isTamanhoLadoValido(this.aLadoC) ) {
			resposta = false;
		}
		return resposta;
	}
	
	public boolean isTrianguloRetangulo() {
		boolean resposta = isTresLadosValidos();
		
		if ( resposta	&&
				!(
					(
						this.aLadoA * this.aLadoA +
						this.aLadoB * this.aLadoB 
						==
						this.aLadoC * this.aLadoC
					)
					||
					(
						this.aLadoB * this.aLadoB +
						this.aLadoC * this.aLadoC 
						==
						this.aLadoA * this.aLadoA
					)
					||
					(
						this.aLadoC * this.aLadoC +
						this.aLadoA * this.aLadoA 
						==
						this.aLadoB * this.aLadoB
					)
				)
		) {
			resposta = false;
		}
		
		return resposta;
	}
	
}
