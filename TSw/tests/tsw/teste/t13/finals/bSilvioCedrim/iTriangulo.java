package tsw.teste.t13.finals.bSilvioCedrim;

public interface iTriangulo {

	/**
	 * Valida��o
	 * @throws TamanhoInvalidoException 
	 */
	
	public void validarTamanhoLado(Double pTamanhoLado) throws TamanhoInvalidoException;
	
	public void validarTodosOsLados();
	
	public boolean isTamanhoLadoValido(Double pTamanhoLado);
	
	/**
	 * Situa��o
	 */
	public boolean isEquilatero();
	
	public boolean isIsosceles();
	
	public boolean isTrianguloRetangulo();

	public boolean isEscaleno();
	
	public boolean isTrianguloValido();
	
	public boolean isTresLadosValidos();
	
	
	
}
