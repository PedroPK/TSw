package tsw.t06;

public class CodigoAnoSequencial {
	
	public String getCdAnoSequencial10Digitos( short pAno, short pSequencial ) {
		String resposta = "";
		
		
		
		return resposta = "";
	}
	
	/**
	 * O Número do Documento de Referência deve ter um Total de 14 Dígitos
	 * Deve ser composto de
	 *  - Exercício 
	 *  - Numero de Bloqueio de Dotacao para Contingenciamento, completado com Zeros a esquerda até completar 10 dígitos
	 *  
	 * @param pVOBloqueioDotacao
	 * 
	 * @return	Número do Documento de Referência
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