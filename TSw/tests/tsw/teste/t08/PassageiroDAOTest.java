package tsw.teste.t08;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Test;

import tsw.t08.entidades.Passageiro;
import tsw.t08.persistencia.PassageiroDAO;
import tsw.util.BibliotecaFuncoes;

public class PassageiroDAOTest {

	@Test
	public void testarInserirDAO() {
		Passageiro ticoSantaCruz = new Passageiro();
		ticoSantaCruz.setNome("Tico Santa Cruz");
		ticoSantaCruz.setCPF("123.456.789-0");
		ticoSantaCruz.setEMail("tico.revoltado@detonaltas.com.br");
		ticoSantaCruz.setIsPortadorNecessidadesEspeciais(true);
		ticoSantaCruz.setDataNascimento( BibliotecaFuncoes.getData("01/02/1980") );
		
		
		try {
			Passageiro tico = 
				/* Equivalente a invocar as instruções abaoxp
				 * 
				 * PassageiroDAO dao = new PassageiroDAO();
				 *dao.inserir(ticoSantaCruz);
				 */
				(Passageiro) BibliotecaFuncoes.clone(ticoSantaCruz);
			
			PassageiroDAO daoFalso = mock(PassageiroDAO.class);
			when(daoFalso.consultar(ticoSantaCruz)).thenReturn(tico);
			
			Passageiro passageiro = daoFalso.consultar(ticoSantaCruz);
			
			assertEquals(ticoSantaCruz.getChavePrimaria(), passageiro.getChavePrimaria());
		} catch (ClassNotFoundException e) {
			fail();
		} catch (IOException e) {
			fail();
		}
	}
	
}