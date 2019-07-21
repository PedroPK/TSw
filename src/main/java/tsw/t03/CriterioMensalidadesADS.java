package tsw.t03;

import tsw.excecoes.ParametroInvalidoException;
import tsw.t03.interfaces.CriterioMensalidades;

public class CriterioMensalidadesADS implements CriterioMensalidades {
	
	public CriterioMensalidadesADS() {}
	
	/**
	 * Se a nota do aluno for:
	 * 	 - Entre 7,0 e 8,0  - o desconto será de 10%
	 *   - Entre 8,0 e 9,0  - o desconto será de 20%
	 *   - Entre 9,0 e 10,0 - o desconto será de 50%
	 *   - Se for 10,0		- o desconto será de 100%
	 *  
	 * @param pNota
	 * 
	 * @return	Double		Valor da Mensalidade
	 */
	public Double definirMensalidade(Double pNota)
	throws ParametroInvalidoException {
		// TODO Auto-generated method stub
		return null;
	}

}
