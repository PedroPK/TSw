package tsw.teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tsw.teste.t01.OrdenadorTest;
import tsw.teste.t02.CalculadoraTest;

@RunWith(Suite.class)
@SuiteClasses(
	value={
		OrdenadorTest.class,
		CalculadoraTest.class
	}
)
public class SuiteTestes {}