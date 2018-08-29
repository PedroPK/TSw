package tsw.teste.t08;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tsw.t08.entidades.Passageiro;
import tsw.t08.persistencia.IPassageiroDAO;
import tsw.util.BibliotecaFuncoes;

/**
 * Dependencias do Mockito:
 *  - Byte-Buddy
 *  	= Vers„o em uso: 1.8.11
 *  - Objenesis
 *  	= http://central.maven.org/maven2/org/mockito/mockito-core/2.0.28-beta/mockito-core-2.0.28-beta.pom
 *  	= Vers„o em uso: 2.6
 *  
 * @author pedro.f-santos
 *
 */
public class PassageiroDAOTest {

	@Test
	public void testarInserirDAO() {
		Passageiro passageiroInstancializado = UtilTeste.instancializarNovoPassageiro();
		
		Passageiro passageiroInserido = 
			/* A Serializacao do m√©todo Clone() equivalente a invocar as instrucoes abaixo
			 * 
			 * PassageiroDAO dao = new PassageiroDAO();
			 * dao.inserir(passageiroInstancializado);
			 */
			(Passageiro) BibliotecaFuncoes.clone(passageiroInstancializado);
		
		IPassageiroDAO daoFalsoMockado = UtilTeste.getMockPassageiroDAO();
		UtilTeste.prepararMockConsultarPassageiro(passageiroInstancializado, passageiroInserido, daoFalsoMockado);
		
		Passageiro passageiroConsultado = daoFalsoMockado.consultar(passageiroInstancializado);
		
		assertEquals(passageiroInstancializado.getChavePrimaria(), passageiroConsultado.getChavePrimaria());
	}
	
	@Test void testarExclusaoDAO() {
		Passageiro passageiroInstancializado = UtilTeste.instancializarNovoPassageiro();
	}

}