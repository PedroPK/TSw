package tsw.t07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class JogoBoliche {
	
	// Atributos
	
	private List<RodadaBoliche> aRodadas = new ArrayList<RodadaBoliche>();
	private byte aIndiceRodadaAtual = 0;
	
	// Métodos
	
	public byte getPontuacao() {
		byte resposta = 0;
		
		for (	byte indiceRodadas = 0;
					indiceRodadas <= this.aIndiceRodadaAtual	&&
					indiceRodadas < 10;
				indiceRodadas = (byte) (indiceRodadas + 1)
		) {
			RodadaBoliche rodadaAtual = this.aRodadas.get(indiceRodadas); 
			if ( rodadaAtual != null ) {
				resposta = (byte) (resposta + rodadaAtual.getPontuacaoRodada());
			} else {
				break;
			}
		}
		
		return resposta;
	}
	
	public void inserirJogada(byte pQtPinosDerrubados) {
		// Verifica se a Coleção de Rodadas já foi inicializada
		if ( this.aRodadas == null ) {
			this.aRodadas = new ArrayList<RodadaBoliche>();
		}
		
		// Inicializa a Rodada Atual, em caso de necessidade
		if ( this.aRodadas.size() == 0 ) {
			this.aRodadas.add(this.aIndiceRodadaAtual, new RodadaBoliche());
		}
		
		// Se a Rodada atual já tiver sido completada, irá passar para a Próxima
		if ( this.aRodadas.get(this.aIndiceRodadaAtual) != null &&
				this.aRodadas.get(this.aIndiceRodadaAtual).isRodadaCompletada() 
		) {
			this.aIndiceRodadaAtual = (byte) (this.aIndiceRodadaAtual + 1);
			
			// Inicializa a Rodada Atual, 
			this.aRodadas.add(this.aIndiceRodadaAtual, new RodadaBoliche());
		}
		
		// Se a Rodada ainda não tiver sido inicializada, será aqui
		if ( this.aRodadas.get(this.aIndiceRodadaAtual) == null ) {
			this.aRodadas.add(this.aIndiceRodadaAtual, new RodadaBoliche());
		}
		
		// Se for a 2ª Rodada em diante, associar as Rodadas atuais com as anteriores
		if ( this.aIndiceRodadaAtual > 0 ) {
			this.aRodadas.get(this.aIndiceRodadaAtual).setRodadaAnterior(this.aRodadas.get(this.aIndiceRodadaAtual - 1));
		}
		
		RodadaBoliche rodadaAtual = this.aRodadas.get(this.aIndiceRodadaAtual);
		rodadaAtual.adicionarJogada(pQtPinosDerrubados);
	}
	
	public boolean isJogoCompletado() {
		boolean resposta = true;
		
		if ( this.aIndiceRodadaAtual < 9 ) {
			resposta = false;
		} else {
			for (byte indiceRodadas = 0; indiceRodadas < 10; indiceRodadas = (byte) (indiceRodadas + 1)) {
				if ( this.aRodadas.get(indiceRodadas) == null ) {
					resposta = false;
					break;
				} else {
					if ( !this.aRodadas.get(indiceRodadas).isRodadaCompletada() ) {
						resposta = false;
						break;
					}
				}
			}
		}
		
		return resposta;
	}
	
}