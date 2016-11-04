package tsw.teste.t08;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import tsw.t08.entidades.Passageiro;
import tsw.t08.persistencia.PassageiroDAO;
import tsw.util.BibliotecaFuncoes;

public class UtilTeste {
	
	public static Passageiro instancializarNovoPassageiro() {
		Passageiro ticoSantaCruz = new Passageiro();
		ticoSantaCruz.setNome("Tico Santa Cruz");
		ticoSantaCruz.setCPF("123.456.789-0");
		ticoSantaCruz.setEMail("tico.revoltado@detonaltas.com.br");
		ticoSantaCruz.setIsPortadorNecessidadesEspeciais(true);
		ticoSantaCruz.setDataNascimento( BibliotecaFuncoes.getData("01/02/1980") );
		return ticoSantaCruz;
	}
	
	public static PassageiroDAO getMockPassageiroDAO() {
		PassageiroDAO daoFalso = mock(PassageiroDAO.class);
		return daoFalso;
	}
	
	public static void prepararMockConsultarPassageiro(
		Passageiro		pPassageiroConsultado, 
		Passageiro		pPassageiroRetornado,
		PassageiroDAO	pMockDAOFalso
	) {
		when(pMockDAOFalso.consultar(pPassageiroConsultado)).thenReturn(pPassageiroRetornado);
	}
	
	public static void prepararMockConsultarPassageiroPorChavePrimaria(
			Passageiro		pPassageiroConsultado, 
			Passageiro		pPassageiroRetornado,
			PassageiroDAO	pMockDAOFalso
		) {
			when(pMockDAOFalso.consultar(pPassageiroConsultado.getChavePrimaria())).thenReturn(pPassageiroRetornado);
		}
	
}