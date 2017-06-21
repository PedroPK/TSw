package tsw.teste.t13.finals.bSilvioCedrim;

public class TamanhoInvalidoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4595518691261735954L;

	public static final String TAMANHO_INVALIDO_MSG = "O lado %s não é valido";

	public TamanhoInvalidoException(Double tamanho) {
		super(String.format(TAMANHO_INVALIDO_MSG, String.valueOf(tamanho)));
	}
	
	 
}
