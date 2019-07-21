package tsw.t09;

public class Carro extends Veiculo {
	
	private int aMarcha;
	
	public int getMarcha() {
		return aMarcha;
	}

	public void setMarcha(int pMarcha) {
		this.aMarcha = pMarcha;
	}
	
	//@Override
	public void setVelocidade(int pVelocidade) {
		super.setVelocidade(pVelocidade);
		
		if ( pVelocidade < 10 ) {
			this.aMarcha = 1;
		} else {
			if ( pVelocidade < 20 ) {
				this.aMarcha = 2;
			} else {
				if ( pVelocidade < 40 ) {
					this.aMarcha = 3;
				} else {
					if ( pVelocidade < 60 ) {
						this.aMarcha = 4;
					} else {
						this.aMarcha = 5;
					}
				}
			}
		}
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("Marcha: " + this.aMarcha);
	}

	
	
}