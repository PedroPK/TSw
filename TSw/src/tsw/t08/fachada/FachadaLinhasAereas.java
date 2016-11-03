package tsw.t08.fachada;

import java.util.Collection;

import tsw.t08.controlador.ControladorPassageiro;
import tsw.t08.controlador.IControladorPassageiro;
import tsw.t08.entidades.Passageiro;

public class FachadaLinhasAereas implements IFachadaLinhasAereas {
	
	public void inserirPassageiro(
		String	pNome,
		String	pCPF,
		String	pEMail,
		String	pDataNascimento,
		String	pIsPortadorNecessidadesEspeciais
	)  {
		IControladorPassageiro controladorPassageiro = new ControladorPassageiro();
		controladorPassageiro.inserirPassageiro(pNome, pCPF, pEMail, pDataNascimento, pIsPortadorNecessidadesEspeciais);
	}
	
	public void inserir(Passageiro pPassageiro) {
		IControladorPassageiro controladorPassageiro = new ControladorPassageiro();
		controladorPassageiro.inserir(pPassageiro);
	}
	
	public void consultarPassageiro(Object pChavePrimariaPassageiro) {
		IControladorPassageiro controladorPassageiro = new ControladorPassageiro();
		controladorPassageiro.consultar(pChavePrimariaPassageiro);
	}
	
	public Collection<Passageiro> consultar() {
		IControladorPassageiro controladorPassageiro = new ControladorPassageiro();
		return controladorPassageiro.consultar();
	}
	
}