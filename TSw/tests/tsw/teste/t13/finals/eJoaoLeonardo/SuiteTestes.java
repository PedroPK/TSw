package tsw.teste.t13.finals.eJoaoLeonardo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tsw.teste.t01.OrdenadorTest;
import tsw.teste.t02.CalculadoraTest;

@RunWith(Suite.class)
@SuiteClasses(
	value={
		TrianguloTestV01.class,
		TrianguloTestV02.class
	}
)
public class SuiteTestes {}