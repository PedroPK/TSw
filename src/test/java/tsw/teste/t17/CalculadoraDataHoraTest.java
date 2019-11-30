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
		// Arrange
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
		// Arrange
		LocalDate	primeiroJaneiro2019				=	LocalDate.of(2019, 01, 01);
		LocalDate	trintaEUmJaneiro2019				=	LocalDate.of(2019, 01, 31);
		CalculadoraDataHoraInterface calculadora	=	new CalculadoraDataHora();
		
		// Act
		int diasEntre = calculadora.calcularDiasEntre(primeiroJaneiro2019, trintaEUmJaneiro2019);
		
		// Assert
		int expectedResponse = 30;
		assertEquals(expectedResponse, diasEntre);
	}
	
	@Test
	public void testCalcularDiasEntre_01Janeiro2019_01Fevereiro2019() {
		// Arrange
		LocalDate	primeiroJaneiro2019				=	LocalDate.of(2019, 01, 01);
		LocalDate	primeiroFevereiro2019			=	LocalDate.of(2019, 02, 01);
		CalculadoraDataHoraInterface calculadora	=	new CalculadoraDataHora();
		
		// Act
		int diasEntre = calculadora.calcularDiasEntre(primeiroJaneiro2019, primeiroFevereiro2019);
		
		// Assert
		int expectedResponse = 31;
		assertEquals(expectedResponse, diasEntre);
	}
	
	@Test
	public void testCalcularDiasEntre_01Fevereiro2020_28Fevereiro2020() {
		// Arrange
		LocalDate	primeiroFevereiro2020			=	LocalDate.of(2020, 02, 01);
		LocalDate	vinteOitoFevereiro2020			=	LocalDate.of(2020, 02, 28);
		CalculadoraDataHoraInterface calculadora	=	new CalculadoraDataHora();
		
		// Act
		int diasEntre = calculadora.calcularDiasEntre(primeiroFevereiro2020, vinteOitoFevereiro2020);
		
		// Assert
		int expectedResponse = 27;
		assertEquals(expectedResponse, diasEntre);
	}
	
	@Test
	public void testCalcularDiasEntre_01Fevereiro2020_29Fevereiro2020_AnoBissexto() {
		// Arrange
		LocalDate	primeiroFevereiro2020			=	LocalDate.of(2020, 02, 01);
		LocalDate	vinteNoveFevereiro2020			=	LocalDate.of(2020, 02, 29);
		CalculadoraDataHoraInterface calculadora	=	new CalculadoraDataHora();
		
		// Act
		int diasEntre = calculadora.calcularDiasEntre(primeiroFevereiro2020, vinteNoveFevereiro2020);
		
		// Assert
		int expectedResponse = 28;
		assertEquals(expectedResponse, diasEntre);
	}
	
	@Test
	public void testCalcularDiasEntre_01Fevereiro2020_01Marco2020_AnoBissexto() {
		// Arrange
		LocalDate	primeiroFevereiro2020			=	LocalDate.of(2020, 02, 01);
		LocalDate	primeiroMarcoo2020				=	LocalDate.of(2020, 03, 01);
		CalculadoraDataHoraInterface calculadora	=	new CalculadoraDataHora();
		
		// Act
		int diasEntre = calculadora.calcularDiasEntre(primeiroFevereiro2020, primeiroMarcoo2020);
		
		// Assert
		int expectedResponse = 29;
		assertEquals(expectedResponse, diasEntre);
	}
	
	@Test
	public void testCalcularHorasEntre() {
		fail("Not yet implemented");
	}

}
