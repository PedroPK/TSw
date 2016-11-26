package tsw.teste.t08;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import tsw.t08.controlador.ControladorPassageiro;
import tsw.t08.entidades.Passageiro;
import tsw.t08.persistencia.IPassageiroDAO;
import tsw.util.BibliotecaFuncoes;

public class ControladorPassageiroTest {
	
	@Test
	public void testarInclusaoPassageiro() {
		Passageiro passageiro = UtilTeste.instancializarNovoPassageiro();
		
		IPassageiroDAO mockDAO = UtilTeste.getMockPassageiroDAO();
		UtilTeste.prepararMockConsultarPassageiroPorChavePrimaria(
			passageiro, 
			(Passageiro) BibliotecaFuncoes.clone(passageiro), 
			mockDAO);
		ControladorPassageiro controlador = new ControladorPassageiro(mockDAO);
		
		controlador.inserir(passageiro);
		Passageiro passageiroConsultado = 
			controlador.consultar(passageiro.getChavePrimaria());
		
		assertEquals(passageiro.getChavePrimaria(), passageiroConsultado.getChavePrimaria());
		verify(mockDAO).inserir(passageiro);
		verify(mockDAO, times(1) ).inserir(passageiro);
		verify(mockDAO, atLeast(1)).inserir(passageiro);
		verify(mockDAO, atMost(1)).inserir(passageiro);
	}

}