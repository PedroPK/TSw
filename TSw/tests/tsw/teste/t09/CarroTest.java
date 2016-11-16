package tsw.teste.t09;

import org.junit.Assert;
import org.junit.Test;

import tsw.t09.Carro;
import tsw.t09.Veiculo;

public class CarroTest {
	
	@Test
	public void testarHerancaExecutandoMetodoSubclasseOverride() {
		Veiculo veiculo = new Carro();
		veiculo.setVelocidade(45);
		veiculo.print();
		System.out.println("");
		
		Carro carro = (Carro) veiculo;
		carro.print();
		
		Assert.assertEquals(4, carro.getMarcha());
	}
	
}