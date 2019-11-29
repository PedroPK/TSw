package tsw.t16;

import java.math.BigDecimal;
import java.util.List;

public interface CalculadoraMediasMoveisInterface {
	
	/**
	 * Este método irá calcular a Média Movel simples (sem pesos e ponderações).
	 * 
	 * O Cálculo da Média é feito sobre uma Lista de Valores
	 * 
	 * Além da Lista, há um parâmetro para determinar a quantidade de valores deve ser utilizada.
	 * Esta quantidade indica de trás para frente quantos valores devem ser utilizados no cálculo.
	 * Ex:
	 * 		- Lista de Valores:		01		02		03		04		05		06		07		08
	 * 		- Quantidade de Valores:		3
	 * 		= Resultado: Deverão ser ultilizados apenas os últimos 3 valores, no caso 06, 07 e 08.
	 * 			-=-	Valor gerado	=	(06	+	07	+	08)		/		03		=	07
	 * 
	 * @param pLista
	 * @param pQuantidadeValores
	 * @return
	 */
	public BigDecimal calcular(
		List<BigDecimal>	pLista, 
		int					pQuantidadeValores
	);
	
}