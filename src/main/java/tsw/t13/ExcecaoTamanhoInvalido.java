package tsw.t13;

public class ExcecaoTamanhoInvalido extends IllegalArgumentException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcecaoTamanhoInvalido() {
		super ("O valor informado é inválido para o lado de um triângulo");
	}
	
	public ExcecaoTamanhoInvalido(Double pTamanho) {
		super ("O valor informado (" + pTamanho + ") é inválido para o lado de um triângulo");
	}
	
}
