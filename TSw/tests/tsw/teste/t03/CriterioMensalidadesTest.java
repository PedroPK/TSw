package tsw.teste.t03;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tsw.excecoes.ParametroInvalidoException;
import tsw.t03.CriterioMensalidadesADS;
import tsw.t03.interfaces.CriterioMensalidades;

public class CriterioMensalidadesTest {
	
	private CriterioMensalidades aCriterioMensalidades;
	
	@Before
	public void instanciarCriterioMensalidadesADS() {
		this.aCriterioMensalidades = new CriterioMensalidadesADS();
	}
	
	@Test
	public void definirMensalidadeADSNullTest() {
		try {
			this.aCriterioMensalidades.definirMensalidade(null);
			
			Assert.fail();
		} catch ( ParametroInvalidoException pie ) {
			// Testes executados com Sucesso
		}
		
	}
	
	//@Test
	public void definirMensalidadeADSNegativoTest() {
		try {
			this.aCriterioMensalidades.definirMensalidade(new Double(-1) );
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	//@Test
	public void definirMensalidadeADSMaiorQueDezTest() {
		try {
			this.aCriterioMensalidades.definirMensalidade( new Double(10.1) );
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	//@Test
	public void definirMensalidadeADSMenorQueSeteTest() {
		try {
			this.aCriterioMensalidades.definirMensalidade( new Double(6.99) );
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	//@Test
	public void definirMensalidadeADSIgualSeteTest() {
		try {
			this.aCriterioMensalidades.definirMensalidade( new Double(7.0) );
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	//@Test
	public void definirMensalidadeADSMaiorQueSeteTest() {
		try {
			this.aCriterioMensalidades.definirMensalidade( new Double(7.1) );
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	//@Test
	public void definirMensalidadeADSMenorQueOitoTest() {
		try {
			this.aCriterioMensalidades.definirMensalidade( new Double(7.99) );
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	//@Test
	public void definirMensalidadeADSIgualOitoTest() {
		try {
			this.aCriterioMensalidades.definirMensalidade( new Double(8.0) );
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
	
	//@Test
	public void definirMensalidadeADSMaiorQueOitoTest() {
		try {
			this.aCriterioMensalidades.definirMensalidade( new Double(8.1) );
		} catch ( ParametroInvalidoException pie ) {
			Assert.fail();
		}
	}
}