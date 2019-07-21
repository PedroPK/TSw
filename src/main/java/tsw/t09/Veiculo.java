package tsw.t09;

public class Veiculo {
	
	private int aVelocidade;
	private int aQtPassageiros;
	
	public int getVelocidade() {
		return aVelocidade;
	}
	public void setVelocidade(int pVelocidade) {
		this.aVelocidade = pVelocidade;
	}
	public int getQtPassageiros() {
		return aQtPassageiros;
	}
	public void setQtPassageiros(int pQtPassageiros) {
		this.aQtPassageiros = pQtPassageiros;
	}
	
	public void print() {
		System.out.println("Velocidade: " + this.aVelocidade);
		System.out.println("Quantidade de Passageiros: " + this.aQtPassageiros);
	}
	
}
