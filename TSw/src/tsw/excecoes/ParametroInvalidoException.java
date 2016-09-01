package tsw.excecoes;

public class ParametroInvalidoException extends Exception {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = -6369223205982481058L;

	public ParametroInvalidoException() {
		super("Um dos parâmetros passados é inválido");
	}
	
	public ParametroInvalidoException(String pMensagem) {
		super(pMensagem);
	}
	
}
