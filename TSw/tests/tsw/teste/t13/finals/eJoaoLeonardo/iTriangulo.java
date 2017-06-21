package tsw.teste.t13.finals.eJoaoLeonardo;

public interface iTriangulo {

	/**
	 * M�todos de Valida��o
	 */
	public void validarTamanhoLado(Double ptamanhoLado);

	public void validarTodosOsLados();

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
