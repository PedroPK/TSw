package tsw.teste.t08;

import org.junit.Test;

import tsw.t08.entidades.Passageiro;
import tsw.t08.persistencia.PassageiroDAO;
import tsw.util.BibliotecaFuncoes;

public class PassageiroDAOTest {

	@Test
	public void testarInserir() {
		Passageiro ticoSantaCruz = new Passageiro();
		ticoSantaCruz.setNome("Tico Santa Cruz");
		ticoSantaCruz.setCPF("123.456.789-0");
		ticoSantaCruz.setEMail("tico.revoltado@detonaltas.com.br");
		ticoSantaCruz.setIsPortadorNecessidadesEspeciais(true);
		ticoSantaCruz.setDataNascimento( BibliotecaFuncoes.getData("01/02/1980") );
		
		PassageiroDAO dao = new PassageiroDAO();
		dao.inserir(ticoSantaCruz);
		
		Passageiro tico = dao.consultar(ticoSantaCruz);
		
		
	}
}