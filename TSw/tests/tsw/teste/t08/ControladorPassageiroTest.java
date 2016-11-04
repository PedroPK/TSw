package tsw.teste.t08;

import static org.junit.Assert.*;
import org.junit.Test;

import tsw.t08.controlador.ControladorPassageiro;
import tsw.t08.entidades.Passageiro;
import tsw.t08.persistencia.PassageiroDAO;
import tsw.util.BibliotecaFuncoes;

public class ControladorPassageiroTest {
	
	@Test
	public void testarInclusaoPassageiro() {
		Passageiro passageiro = UtilTeste.instancializarNovoPassageiro();
		
		PassageiroDAO mockDAO = UtilTeste.getMockPassageiroDAO();
		UtilTeste.prepararMockConsultarPassageiroPorChavePrimaria(
			passageiro, 
			(Passageiro) BibliotecaFuncoes.clone(passageiro), 
			mockDAO);
		ControladorPassageiro controlador = new ControladorPassageiro(mockDAO);
		
		controlador.inserir(passageiro);
		Passageiro passageiroConsultado = 
			controlador.consultar(passageiro.getChavePrimaria());
		
		assertEquals(passageiro.getChavePrimaria(), passageiroConsultado.getChavePrimaria());
	}

}