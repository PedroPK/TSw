package tsw.teste.t13.finals.eJoaoLeonardo;

public interface iTriangulo {

	/**
	 * Métodos de Validação
	 */
	public void validarTamanhoLado(Double ptamanhoLado);

	public void validarTodosOsLados();

	public boolean isTamanhoLadoValido(Double pTamanhoLado);

	/**
	 * Métodos de Situação
	 */
	public boolean isEquilatero();

	public boolean isIsosceles();

	public boolean isEscaleno();

	public boolean isTrianguloValido();

	public boolean isTresLadosValidos();

	public boolean isTrianguloRetangulo();

}
