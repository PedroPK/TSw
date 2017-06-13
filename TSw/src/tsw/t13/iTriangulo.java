package tsw.t13;

public interface iTriangulo {
	
	/**
	 * Getter's and Setter's
	 * @return
	 */
	public double getLadoA();
	public void setLadoA(Double pLadoA);
	
	public double getLadoB();
	public void setLadoB(Double pLadoB);
	
	public double getLadoC();
	public void setLadoTres(Double pLadoC);
	
	public void validarTamanhoLado(Double pTamanhoLado);
	
	public void validarTresLadosTriangulo();
	
	public boolean isTamanhoLadoValido(Double pTamanhoLado);
	
	/**
	 * Métodos de Situação
	 */
	public boolean isEquilatero();
	
	public boolean isIsoceles();
	
	public boolean isEscaleno();
	
	public boolean isTrianguloValido();
	
	public boolean isTresLadosValidos();
	
	public boolean isTrianguloRetangulo();
	
}