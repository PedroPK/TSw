package tsw.excecoes;

public class ColecaoVaziaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1337115179426071287L;

	public ColecaoVaziaException() {
		super("A Coleção está vazia!");
	}
	
}
