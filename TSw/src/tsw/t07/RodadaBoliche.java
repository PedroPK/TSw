package tsw.t07;

public class RodadaBoliche {
	
	// Atributos
	
	private byte aJogada01 = -1;
	private byte aJogada02 = -1;
	
	private byte aBonus = -1;
	
	private byte aJogada03 = -1;
	private boolean aIsDecimaRodada = false;
	
	private RodadaBoliche aRodadaAnterior;
	
	// Métodos
	
	public byte getJogada01() {
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
	
	public byte getBonus() {
		return this.aBonus;
	}
	public void setBonus( byte pBonus ) {
		this.aBonus = pBonus;
	}
	
	public RodadaBoliche getRodadaAnterior() {
		return this.aRodadaAnterior;
	}
	public void setRodadaAnterior(RodadaBoliche pRodadaAnterior) {
		this.aRodadaAnterior = pRodadaAnterior;
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
		
		// Verificar se a Rodada anterior tem Bonus a receber desta Rodada
		if ( 
				this.aRodadaAnterior != null && 
				(
					this.aRodadaAnterior.isSpare()	||
					this.aRodadaAnterior.isStrike()
				)
		) {
			if ( this.aRodadaAnterior.isSpare() ) {
				this.aRodadaAnterior.setBonus(aJogada01);
			}
			
			if ( this.aRodadaAnterior.isStrike() ) {
				this.aRodadaAnterior.setBonus(this.getPontuacaoRodada());
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
		
		if ( this.aBonus != -1 ) {
			resposta = (byte) (resposta + this.aBonus);
		}
		
		return resposta;
	}
	
	public boolean isRodadaCompletada() {
		boolean resposta = false;
		// Se não for a 10ª  Rodada
		if ( !this.aIsDecimaRodada ) {
			resposta = 
				(this.aJogada01 != -1	&&
				 this.aJogada02 != -1)
				||
				(this.aJogada01 == 10	&&
				 this.aJogada02 == -1)
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
	
	public boolean isSpare() {
		boolean resposta = false;
		
		if ( 
				this.aJogada01 != 10 &&
				(this.aJogada01 + this.aJogada02) == 10
		) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public boolean isStrike() {
		boolean resposta = false;
		
		if (  this.aJogada01 == 10 ) {
			resposta = true;
		}
		
		return resposta;
	}
	
}