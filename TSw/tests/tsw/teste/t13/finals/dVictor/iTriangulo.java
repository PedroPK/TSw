package tsw.teste.t13.finals.dVictor;


public interface iTriangulo {
	void validarTamanhoLado(Double pTamanhoLado)throws Exception;
	void validarTodosOsLados()throws Exception;
	boolean isTamanhoLadoValido(Double pTamanhoLado) throws Exception;
	
/* M�todos de Situa�ao */
	
	boolean isEquilatero();
	boolean isIsosceles();
	boolean isEscaleno();
	boolean isTrianguloValido();
	boolean isTresLadosvalidos();
	boolean isTrianguloRetangulo();
}
