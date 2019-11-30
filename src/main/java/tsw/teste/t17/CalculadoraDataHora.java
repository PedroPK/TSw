package tsw.teste.t17;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CalculadoraDataHora implements CalculadoraDataHoraInterface {

	@Override
	public int calcularDiasEntre(LocalDate pData01, LocalDate pData02) {
		long response = ChronoUnit.DAYS.between(pData01, pData02);
		
		return (int) response;
	}

	@Override
	public int calcularHorasEntre(LocalDateTime pDataHora01, LocalDateTime pDataHora02) {
		long response = ChronoUnit.DAYS.between(pDataHora01, pDataHora02);
		
		return 0;
	}

}
