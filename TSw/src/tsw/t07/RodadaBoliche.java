package tsw.t07;

public class RodadaBoliche {
	
	// Atributos
	
	private byte aJogada01 = -1;
	private byte aJogada02 = -1;
	
	private byte aJogada03 = -1;
	private boolean aIsDecimaRodada = false;
	
	// Métodos
	
	public short getJogada01() {
		return aJogada01;
	}
	public void setJogada01(byte pJogada01) {
		this.aJogada01 = pJogada01;
	}
	public byte getJogada02() {
		return aJogada02;
	}
	public void setJogada02(byte pJogada02) {
		this.aJogada02 = pJogada02;
	}
	
	public void adicionarJogada(byte pQtPinosDerrubados) {
		// 1ª Jogada
		if ( this.aJogada01 == -1 ) {
			this.aJogada01 = pQtPinosDerrubados;
		} else {
			// 2ª Jogada
			if ( this.aJogada02 == -1 ) {
				this.aJogada02 = pQtPinosDerrubados;
			} else {
				// 3ª Jogada, se for a 10ª Rodada
				if ( this.aIsDecimaRodada && this.aJogada03 == -1 ) {
					this.aJogada03 = pQtPinosDerrubados;
				}
			}
		}
	}
	
	public byte getPontuacaoRodada() {
		byte resposta = 0;
		
		if ( this.aJogada01 != -1 ) {
			resposta = this.aJogada01;
		}
		
		if ( this.aJogada02 != -1 ) {
			resposta = (byte) (resposta + this.aJogada02);
		}
		
		if ( this.aIsDecimaRodada && this.aJogada03 != -1 ) {
			resposta = (byte) (resposta + this.aJogada03);
		}
		
		return resposta;
	}
	
	public boolean isRodadaCompletada() {
		boolean resposta = false;
		// Se não for a 10ª  Rodada
		if ( !this.aIsDecimaRodada ) {
			resposta = 
				this.aJogada01 != -1	&&
				this.aJogada02 != -1
			;
		} else {
			// Se for a 10ª Rodada
			resposta = 
				this.aJogada01 != -1	&&
				this.aJogada02 != -1	&&
				this.aJogada03 != -1
			;
		}
		
		return resposta;
	}
	
}