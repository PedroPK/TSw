package tsw.t13;

public class ExcecaoTamanhoInvalido extends IllegalArgumentException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcecaoTamanhoInvalido() {
		super ("O valor informado � inv�lido para o lado de um tri�ngulo");
	}
	
	public ExcecaoTamanhoInvalido(Double pTamanho) {
		super ("O valor informado (" + pTamanho + ") � inv�lido para o lado de um tri�ngulo");
	}
	
}
