package tsw.t08.controlador;

import java.util.Collection;

import tsw.t08.entidades.Passageiro;

public interface IControladorPassageiro {
	
	public void inserirPassageiro(
		String	pNome,
		String	pCPF,
		String	pEMail,
		String	pDataNascimento,
		String	pIsPortadorNecessidadesEspeciais
	);
	
	public void inserir(Passageiro pPassageiro);
	public Passageiro consultar(Object pChavePrimaria);
	
	public Collection<Passageiro> consultar();
	
}