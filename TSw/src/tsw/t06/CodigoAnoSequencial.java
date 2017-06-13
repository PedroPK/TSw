package tsw.t06;

public class CodigoAnoSequencial {
	
	public String getCdAnoSequencial10Digitos( short pAno, short pSequencial ) {
		String resposta = "";
		
		return resposta;
	}
	
	/**
	 * O N�mero do Documento de Refer�ncia deve ter um Total de 14 D�gitos
	 * Deve ser composto de
	 *  - Exerc�cio 
	 *  - Numero de Bloqueio de Dotacao para Contingenciamento, completado com Zeros a esquerda at� completar 10 d�gitos
	 *  
	 * @param pVOBloqueioDotacao
	 * 
	 * @return	N�mero do Documento de Refer�ncia
	 */
	public static String getNumeroDocumentoReferencia(VOBloqueioDotacao pVOBloqueioDotacao) {
		String numeroDocumentoReferencia = "";
		
			if (	pVOBloqueioDotacao != null							&&
					pVOBloqueioDotacao.getCtbDtAnoExercicio() != null	&&
					pVOBloqueioDotacao.getNuBloqueioDotacao() != null
			) {
				numeroDocumentoReferencia =
					new StringBuffer()
							.append(pVOBloqueioDotacao.getCtbDtAnoExercicio())
							.append(
									BibliotecaFuncoesPrincipal.completarNumeroComZerosEsquerda(
										pVOBloqueioDotacao.getNuBloqueioDotacao().toString(),
										10
									)
							)
					.toString();
			}
		return numeroDocumentoReferencia;
	}
	
}