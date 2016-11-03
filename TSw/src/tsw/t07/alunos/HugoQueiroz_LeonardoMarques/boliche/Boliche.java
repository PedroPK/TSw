package tsw.t07.alunos.HugoQueiroz_LeonardoMarques.boliche;

import java.util.ArrayList;

public class Boliche {

	public Object testar(ArrayList<Integer> partidas) {
		if (partidas != null && partidas.size() == 2) {
			int sum = 0;
			for (Integer partida : partidas) {
				sum += partida;
			}
			
			return sum == 10;
		}
		return false;
	}
}

