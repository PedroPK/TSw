package tsw.t13;

public interface iTriangulo {
	
	/**
	 * Getter's and Setter's
	 * @return
	 */
	public void validarTamanhoLado(Double pTamanhoLado);
	
	public void validarTresLadosTriangulo();
	
	public boolean isTamanhoLadoValido(Double pTamanhoLado);
	
	/**
	 * M�todos de Situa��o
	 */
	public boolean isEquilatero();
	
	public boolean isIsosceles();
	
	public boolean isEscaleno();
	
	public boolean isTrianguloValido();
	
	public boolean isTresLadosValidos();
	
	public boolean isTrianguloRetangulo();
	
}