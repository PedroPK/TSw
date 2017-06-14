package tsw.t13;

public interface iTriangulo {
	
	/**
	 * Metodos de Validacao
	 */
	public void validarTamanhoLado(Double pTamanhoLado);
	
	public void validarTresLadosTriangulo();
	
	public boolean isTamanhoLadoValido(Double pTamanhoLado);
	
	/**
	 * Metodos de Situacao
	 */
	public boolean isEquilatero();
	
	public boolean isIsosceles();
	
	public boolean isEscaleno();
	
	public boolean isTrianguloValido();
	
	public boolean isTresLadosValidos();
	
	public boolean isTrianguloRetangulo();
	
}