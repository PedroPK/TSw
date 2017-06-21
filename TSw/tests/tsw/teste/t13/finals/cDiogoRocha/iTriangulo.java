package tsw.teste.t13.finals.cDiogoRocha;

public interface iTriangulo {
	// Metodos de Validação
	public void validarTamanhoLado(Double pTamanhoLado);
	public void validarTodosOsLados();
	public boolean istamanhoValido(Double pTamanhoLado);
	
	//Metodos de Situação
	public boolean isEquilatero();
	public boolean isIsosceles();
	public boolean isEscaleno();
	public boolean isTrianguloValido();
	public boolean isTresLadosValidos();
	public boolean isTrianguloRetangulo();
}
