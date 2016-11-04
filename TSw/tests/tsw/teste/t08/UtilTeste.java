package tsw.teste.t08;

import tsw.t08.entidades.Passageiro;
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
	
}