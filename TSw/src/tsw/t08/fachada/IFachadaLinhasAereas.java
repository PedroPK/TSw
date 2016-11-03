package tsw.t08.fachada;

import java.util.Collection;

import tsw.t08.entidades.Passageiro;

public interface IFachadaLinhasAereas {

	public void inserirPassageiro(
		String	pNome,
		String	pCPF,
		String	pEMail,
		String	pData,
		String	pIsPortadorNecessidadesEspeciais
	);
	
	public void inserir(Passageiro pPassageiro);
	public void consultarPassageiro(Object pChavePrimariaPassageiro);
	
	public Collection<Passageiro> consultar();
	
}