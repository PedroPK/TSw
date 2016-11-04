package tsw.t08.controlador;

import java.util.Collection;
import java.util.Date;

import tsw.t08.entidades.Passageiro;
import tsw.t08.persistencia.IPassageiroDAO;
import tsw.t08.persistencia.PassageiroDAO;
import tsw.util.BibliotecaFuncoes;

public class ControladorPassageiro implements IControladorPassageiro {
	
	// Atributos
	
	private IPassageiroDAO aPassageiroDAO;
	
	// Controladores
	
	public ControladorPassageiro() {}
	
	public ControladorPassageiro(PassageiroDAO pPassageiroDAO) {
		this.aPassageiroDAO = pPassageiroDAO;
	}
	
	// Métodos
	
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
		
		preValidarDAO();
		aPassageiroDAO.inserir(passageiro);
	}
	
	public void inserir(Passageiro pPassageiro) {
		preValidarDAO();
		aPassageiroDAO.inserir(pPassageiro);
	}
	
	public Passageiro consultar(Object pChavePrimaria) {
		preValidarDAO();
		Passageiro registro = aPassageiroDAO.consultar(pChavePrimaria);
		return registro;
	}
	
	public Collection<Passageiro> consultar() {
		preValidarDAO();
		return aPassageiroDAO.consultar();
	}
	
	/**
	 * Valida se o DAO está inicializado.
	 * Caso negativo, irá inicializa-lo
	 */
	private void preValidarDAO() {
		if ( this.aPassageiroDAO == null ) {
			aPassageiroDAO = new PassageiroDAO();
		}
	}
	
}