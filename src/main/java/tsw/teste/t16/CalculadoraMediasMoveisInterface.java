package tsw.teste.t16;

import java.math.BigDecimal;
import java.util.List;

public interface CalculadoraMediasMoveisInterface {
	
	/**
	 * Este m�todo ir� calcular a M�dia Movel simples (sem pesos e pondera��es).
	 * 
	 * O C�lculo da M�dia � feito sobre uma Lista de Valores
	 * 
	 * Al�m da Lista, h� um par�metro para determinar a quantidade de valores deve ser utilizada.
	 * Esta quantidade indica de tr�s para frente quantos valores devem ser utilizados no c�lculo.
	 * Ex:
	 * 		- Lista de Valores:		01		02		03		04		05		06		07		08
	 * 		- Quantidade de Valores:		3
	 * 		= Resultado: Dever�o ser ultilizados apenas os �ltimos 3 valores, no caso 06, 07 e 08.
	 * 			-=-	Valor gerado	=	(06	+	07	+	08)		/		03		=	07
	 * 
	 * @param pLista				Lista de Valores a serem utilizados no C�lculo da M�dia M�vel
	 * @param pQuantidadeValores	Quantidade de Valores (a contar dos �ltimos) a serem utilizados no C�lculo da M�dia M�vel
	 * 
	 * @return	M�dia M�vel
	 */
	public BigDecimal calcular(
		List<BigDecimal>	pLista, 
		int					pQuantidadeValores
	);
	
}