package tsw.teste.t13.finals.cDiogoRocha;

public interface iTriangulo {
	// Metodos de Valida��o
	public void validarTamanhoLado(Double pTamanhoLado);
	public void validarTodosOsLados();
	public boolean istamanhoValido(Double pTamanhoLado);
	
	//Metodos de Situa��o
	public boolean isEquilatero();
	public boolean isIsosceles();
	public boolean isEscaleno();
	public boolean isTrianguloValido();
	public boolean isTresLadosValidos();
	public boolean isTrianguloRetangulo();
}
