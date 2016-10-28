package tsw.t07;

public class JogoBoliche {
	
	// Atributos
	
	private RodadaBoliche[] aRodadas = new RodadaBoliche[10];
	private byte aIndiceRodadaAtual = 0;
	
	
	
	// Métodos
	
	public byte getPontuacao() {
		byte resposta = 0;
		
		
		
		for (	byte indiceRodadas = 0;
					indiceRodadas <= this.aIndiceRodadaAtual	&&
					indiceRodadas < 10;
				indiceRodadas = (byte) (indiceRodadas + 1)
		) {
			RodadaBoliche rodadaAtual = this.aRodadas[indiceRodadas]; 
			if ( rodadaAtual != null ) {
				rodadaAtual.getPontuacaoRodada();
			} else {
				break;
			}
		}
		
		return resposta;
	}
	
	public void inserirJogada(byte pQtPinosDerrubados) {
		if ( this.aRodadas[this.aIndiceRodadaAtual] != null &&
				this.aRodadas[this.aIndiceRodadaAtual].isRodadaCompletada() 
		) {
			this.aIndiceRodadaAtual = (byte) (this.aIndiceRodadaAtual + 1);
		}
		
		if ( this.aRodadas[this.aIndiceRodadaAtual] == null ) {
			this.aRodadas[this.aIndiceRodadaAtual] = new RodadaBoliche();
		}
		
		RodadaBoliche rodadaAtual = this.aRodadas[this.aIndiceRodadaAtual];
		rodadaAtual.adicionarJogada(pQtPinosDerrubados);
	}
	
	public boolean isJogoCompletado() {
		
	}
	
}
