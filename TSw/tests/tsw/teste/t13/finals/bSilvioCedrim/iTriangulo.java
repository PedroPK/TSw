package tsw.teste.t13.finals.bSilvioCedrim;

public interface iTriangulo {

	/**
	 * Validação
	 * @throws TamanhoInvalidoException 
	 */
	
	public void validarTamanhoLado(Double pTamanhoLado) throws TamanhoInvalidoException;
	
	public void validarTodosOsLados();
	
	public boolean isTamanhoLadoValido(Double pTamanhoLado);
	
	/**
	 * Situação
	 */
	public boolean isEquilatero();
	
	public boolean isIsosceles();
	
	public boolean isTrianguloRetangulo();

	public boolean isEscaleno();
	
	public boolean isTrianguloValido();
	
	public boolean isTresLadosValidos();
	
	
	
}
