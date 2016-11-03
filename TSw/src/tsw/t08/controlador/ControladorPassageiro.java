package tsw.t08.controlador;

import java.util.Collection;
import java.util.Date;

import tsw.t08.entidades.Passageiro;
import tsw.t08.persistencia.IPassageiroDAO;
import tsw.t08.persistencia.PassageiroDAO;
import tsw.util.BibliotecaFuncoes;

public class ControladorPassageiro implements IControladorPassageiro {
	
	public void inserirPassageiro(
		String	pNome,
		String	pCPF,
		String	pEMail,
		String	pDataNascimento,
		String	pIsPortadorNecessidadesEspeciais
	) {
		boolean isPortadorNecessidadesEspeciais = false;
		if ( 
				BibliotecaFuncoes.isStringValida(pIsPortadorNecessidadesEspeciais)		&&
				pIsPortadorNecessidadesEspeciais.equalsIgnoreCase(Boolean.TRUE.toString())
		) {
			isPortadorNecessidadesEspeciais = true;
		}
		
		Date dtNascimento = null;
		if ( BibliotecaFuncoes.isDataValida(pDataNascimento) ) {
			dtNascimento = BibliotecaFuncoes.getData(pDataNascimento);
		}
		
		Passageiro passageiro = 
			new Passageiro(
					pNome,
					pCPF,
					pEMail,
					dtNascimento,
					isPortadorNecessidadesEspeciais
			);
		
		IPassageiroDAO passageiroDAO = new PassageiroDAO();
		passageiroDAO.inserir(passageiro);
	}
	
	public void inserir(Passageiro pPassageiro) {
		IPassageiroDAO passageiroDAO = new PassageiroDAO();
		passageiroDAO.inserir(pPassageiro);
	}
	
	public Passageiro consultar(Object pChavePrimaria) {
		IPassageiroDAO passageiroDAO = new PassageiroDAO();
		Passageiro registro = passageiroDAO.consultar(pChavePrimaria);
		return registro;
	}
	
	public Collection<Passageiro> consultar() {
		IPassageiroDAO passageiroDAO = new PassageiroDAO();
		return passageiroDAO.consultar();
	}
	
}