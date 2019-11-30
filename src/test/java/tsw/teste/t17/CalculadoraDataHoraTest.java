package tsw.teste.t17;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.Test;

public class CalculadoraDataHoraTest {
	
	@Test
	public void testCalcularDiasEntre_01Janeiro2019_02Janeiro2019() {
		// Arrange
		LocalDate	primeiroJaneiro2019				=	LocalDate.of(2019, 01, 01);
		LocalDate	trintaJaneiro2019				=	LocalDate.of(2019, 01, 02);
		CalculadoraDataHoraInterface calculadora	=	new CalculadoraDataHora();
		
		// Act
		int diasEntre = calculadora.calcularDiasEntre(primeiroJaneiro2019, trintaJaneiro2019);
		
		// Assert
		int expectedResponse = 1;
		assertEquals(expectedResponse, diasEntre);
	}
	
	@Test
	public void testCalcularDiasEntre_01Janeiro2019_30Janeiro2019() {
		// Arranje
		LocalDate	primeiroJaneiro2019				=	LocalDate.of(2019, 01, 01);
		LocalDate	trintaJaneiro2019				=	LocalDate.of(2019, 01, 30);
		CalculadoraDataHoraInterface calculadora	=	new CalculadoraDataHora();
		
		// Act
		int diasEntre = calculadora.calcularDiasEntre(primeiroJaneiro2019, trintaJaneiro2019);
		
		// Assert
		int expectedResponse = 29;
		assertEquals(expectedResponse, diasEntre);
	}
	
	@Test
	public void testCalcularDiasEntre_01Janeiro2019_31Janeiro2019() {
		// Arranje
		LocalDate	primeiroJaneiro2019				=	LocalDate.of(2019, 01, 01);
		LocalDate	trintaJaneiro2019				=	LocalDate.of(2019, 01, 31);
		CalculadoraDataHoraInterface calculadora	=	new CalculadoraDataHora();
		
		// Act
		int diasEntre = calculadora.calcularDiasEntre(primeiroJaneiro2019, trintaJaneiro2019);
		
		// Assert
		int expectedResponse = 30;
		assertEquals(expectedResponse, diasEntre);
	}
	
	@Test
	public void testCalcularDiasEntre_01Janeiro2019_01Fevereiro2019() {
		// Arranje
		LocalDate	primeiroJaneiro2019				=	LocalDate.of(2019, 01, 01);
		LocalDate	trintaJaneiro2019				=	LocalDate.of(2019, 02, 01);
		CalculadoraDataHoraInterface calculadora	=	new CalculadoraDataHora();
		
		// Act
		int diasEntre = calculadora.calcularDiasEntre(primeiroJaneiro2019, trintaJaneiro2019);
		
		// Assert
		int expectedResponse = 31;
		assertEquals(expectedResponse, diasEntre);
	}
	
	@Test
	public void testCalcularHorasEntre() {
		fail("Not yet implemented");
	}

}
