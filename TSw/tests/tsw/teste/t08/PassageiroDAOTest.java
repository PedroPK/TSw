package tsw.teste.t08;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Test;

import tsw.t08.entidades.Passageiro;
import tsw.t08.persistencia.PassageiroDAO;
import tsw.util.BibliotecaFuncoes;

/**
 * Depend�ncias do Mockito:
 *  - Byte-Buddy
 *  - Objenesis
 *  - http://central.maven.org/maven2/org/mockito/mockito-core/2.0.28-beta/mockito-core-2.0.28-beta.pom
 *  
 * @author pedro.f-santos
 *
 */
public class PassageiroDAOTest {

	@Test
	public void testarInserirDAO() {
		Passageiro ticoSantaCruz = UtilTeste.instancializarNovoPassageiro();
		
		Passageiro tico = 
			/* Equivalente a invocar as instru��es abaoxp
			 * 
			 * PassageiroDAO dao = new PassageiroDAO();
			 *dao.inserir(ticoSantaCruz);
			 */
			(Passageiro) BibliotecaFuncoes.clone(ticoSantaCruz);
		
		PassageiroDAO daoFalso = UtilTeste.getMockPassageiroDAO();
		UtilTeste.prepararMockConsultarPassageiro(ticoSantaCruz, tico, daoFalso);
		
		Passageiro passageiro = daoFalso.consultar(ticoSantaCruz);
		
		assertEquals(ticoSantaCruz.getChavePrimaria(), passageiro.getChavePrimaria());
	}

}