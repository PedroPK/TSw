package tsw.t06;

public class ExcecaoListaNulaVaziaOuElementosTodosNulos extends ExcecaoGenerica {
	
	
	public ExcecaoListaNulaVaziaOuElementosTodosNulos(String pNmLista) {
		super("A Lista é Nula/Vazia ou todos os seus Elementos são Nulos.");
		this.setCdSistema(ConstantesPLO.SG_SISTEMA_ORC_PLO);
		this.setCamposSubstituicaoMensagemPrincipal(new String[] {pNmLista});
	}
	
}

