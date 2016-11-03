package tsw.t07.alunos.HugoQueiroz_LeonardoMarques.boliche;

import java.util.ArrayList;
import java.util.List;

public class Partida {
	
	private int totalPinos = 10;
	private int spJogadas = 2;
	private int stJogadas = 1;
	
	private List<List<Integer>> rodadas;
	
	public Partida() {
		this.rodadas = new ArrayList<List<Integer>>();
	}
	
	private boolean verificaRodada(int i) {
		try {
			this.rodadas.get(i);
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		} 
	}

	public void adicionaJogo(int rodada, int pinosDerrubados) {
		int index = rodada - 1;
		
		if (!existeRodada(index)) {
			this.rodadas.add(index, new ArrayList<Integer>());
		}
		this.rodadas.get(index).add(pinosDerrubados);
	}
	
	private int somaRodada(List<Integer> rodada) {
		int soma = 0;
		for (Integer pinosDerrubados : rodada) {
			soma += pinosDerrubados;
		}
		return soma;
	}

	public Integer pegarTotal() {
		if (this.rodadas.size() <= 0) return 0;
		
		int soma = 0;
		int totalRodadas = this.rodadas.size();
		
		for (int i = 0; i < totalRodadas; i++) {
			List<Integer> rodada = this.rodadas.get(i);
			
			somaDaRodada(rodada);

			if (checkSpares(rodada)) {
				int indexRodada = i + 1;
				
				if (indexRodada < totalRodadas) {
					List<Integer> proximaRodada = this.rodadas.get(indexRodada);
					soma += proximaRodada.get(0);
				}
			}
			
			
			if (checkStrike(rodada)) {
				int indexRodada = i + 1;
				
				if (indexRodada < totalRodadas) {
					List<Integer> proximaRodada = this.rodadas.get(indexRodada);
					
					soma += proximaRodada.get(0) + proximaRodada.get(1);
				}
			}
		}
		
		return soma;
	}

	private boolean testeStrike(List<Integer> rodada) {
		if (rodada != null && rodada.size() == stJogadas) {
			return rodada.get(0) == totalPinos;
		}
		
		return false;
	}

	private boolean testeSpares(List<Integer> rodada) {
		if (rodada != null && rodada.size() == spJogadas) {
			int total = rodada.get(0) + rodada.get(1);
			return total == totalPinos;
		}
		
		return false;
	}
}
