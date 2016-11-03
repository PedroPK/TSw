package tsw.teste.t06;

import static org.junit.Assert.*;

import org.junit.Test;

import tsw.t06.ConstantesPLOServico05;
import tsw.t06.ExcecaoAtributoInvalido;
import tsw.t06.ExcecaoParametroInvalido;
import tsw.t06.ExcecaoValorNuloNaoPermitido;
import tsw.t06.UtilServico05;
import tsw.t06.VOBloqueioDotacao;

public class CodigoAnoSequencialTest {
	
	@Test
	public void getCdAnoSequencialZeroZero() {
		assertEquals("", "");
	}
	
	@Test
	public void getNumeroDocumentoReferenciaTestSq1Digito() {
		try {
			VOBloqueioDotacao voBD = 
				new VOBloqueioDotacao(
						Short.valueOf("2016"), 
						ConstantesPLOServico05.UM_INTEGER);
			
			String numeroDocumentoReferencia = 
				UtilServico05.getNumeroDocumentoReferencia(voBD);
			
			assertEquals("20160000000001", numeroDocumentoReferencia);
		} catch (ExcecaoParametroInvalido e) {
			fail();
		} catch (NumberFormatException e) {
			fail();
		} catch (ExcecaoAtributoInvalido e) {
			fail();
		}
	}
	
	@Test
	public void getNumeroDocumentoReferenciaTestSq2Digitos() {
		try {
			VOBloqueioDotacao voBD = 
				new VOBloqueioDotacao(
						Short.valueOf("2016"), 
						Integer.valueOf(10));
			
			String numeroDocumentoReferencia = 
				UtilServico05.getNumeroDocumentoReferencia(voBD);
			
			assertEquals("20160000000010", numeroDocumentoReferencia);
		} catch (ExcecaoParametroInvalido e) {
			fail();
		} catch (NumberFormatException e) {
			fail();
		} catch (ExcecaoAtributoInvalido e) {
			fail();
		}
	}
	
	@Test
	public void getNumeroDocumentoReferenciaTestSq10Digitos() {
		try {
			VOBloqueioDotacao voBD = 
				new VOBloqueioDotacao(
						Short.valueOf("2016"), 
						Integer.valueOf(1234567890));
			
			String numeroDocumentoReferencia = 
				UtilServico05.getNumeroDocumentoReferencia(voBD);
			
			assertEquals("20161234567890", numeroDocumentoReferencia);
		} catch (ExcecaoParametroInvalido e) {
			fail();
		} catch (NumberFormatException e) {
			fail();
		} catch (ExcecaoAtributoInvalido e) {
			fail();
		}
	}
	
	@Test
	public void getNumeroDocumentoReferenciaTestVONulo() {
		try {
			VOBloqueioDotacao voBD = null;
			
			String numeroDocumentoReferencia = 
				UtilServico05.getNumeroDocumentoReferencia(voBD);
			
			assertEquals("", numeroDocumentoReferencia);
		} catch (NumberFormatException e) {
			fail();
		}
	}
	
	@Test
	public void getNumeroDocumentoReferenciaTestExercicioNulo() {
		try {
			VOBloqueioDotacao voBD = new VOBloqueioDotacao();
			voBD.setNuBloqueioDotacao(ConstantesPLOServico05.UM_INTEGER);
			
			String numeroDocumentoReferencia = 
				UtilServico05.getNumeroDocumentoReferencia(voBD);
			
			assertEquals("", numeroDocumentoReferencia);
		} catch (NumberFormatException e) {
			fail();
		} catch (ExcecaoValorNuloNaoPermitido e) {
			fail();
		} catch (ExcecaoParametroInvalido e) {
			fail();
		}
	}
	
	@Test
	public void getNumeroDocumentoReferenciaTestNumeroBloqueioNulo() {
		try {
			VOBloqueioDotacao voBD = new VOBloqueioDotacao();
			voBD.setCtbDtAnoExercicio(Short.valueOf("2016"));
			
			String numeroDocumentoReferencia = 
				UtilServico05.getNumeroDocumentoReferencia(voBD);
			
			assertEquals("", numeroDocumentoReferencia);
		} catch (NumberFormatException e) {
			fail();
		} catch (ExcecaoValorNuloNaoPermitido e) {
			fail();
		} catch (ExcecaoParametroInvalido e) {
			fail();
		}
	}
	
	@Test
	public void getNumeroDocumentoReferenciaTestVOExercicioENumeroBloqueioNulo() {
		try {
			VOBloqueioDotacao voBD = new VOBloqueioDotacao();
			
			String numeroDocumentoReferencia = 
				UtilServico05.getNumeroDocumentoReferencia(voBD);
			
			assertEquals("", numeroDocumentoReferencia);
		} catch (NumberFormatException e) {
			fail();
		}
	}
	
}