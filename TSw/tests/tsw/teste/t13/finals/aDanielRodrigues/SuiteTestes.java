package tsw.teste.t13.finals.aDanielRodrigues;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tsw.teste.t01.OrdenadorTest;
import tsw.teste.t02.CalculadoraTest;

/**
 * Pontuação: 100%
 * 
 * @author pedro.f-santos
 *
 */
@RunWith(Suite.class)
@SuiteClasses(
	value={
		TrianguloEquilateroTests.class,
		TrianguloEscalenoTests.class,
		TrianguloIsoscelesTests.class
	}
)
public class SuiteTestes {}