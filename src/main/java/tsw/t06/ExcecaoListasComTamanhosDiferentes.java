package tsw.t06;


import java.util.List;

public class ExcecaoListasComTamanhosDiferentes extends ExcecaoGenerica {
	
	
	public ExcecaoListasComTamanhosDiferentes(List pFirstList, List pSecondList) {
		super("As Listas não têm a mesma quantidade de Objetos ( " + pFirstList.size() + " e " + pSecondList.size() + " respectivamente).");
		this.setCdSistema(ConstantesPLO.SG_SISTEMA_ORC_PLO);
		this.setCamposSubstituicaoMensagemPrincipal(new String[] {String.valueOf(pFirstList.size()), String.valueOf(pSecondList.size())});
	}
	
}

