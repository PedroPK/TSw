package tsw.teste.t17;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface CalculadoraDataHoraInterface {
	
	public int calcularDiasEntre(LocalDate pData01, LocalDate pData02);
	
	public int calcularHorasEntre(LocalDateTime pDataHora01, LocalDateTime pDataHora02);
	
	
	
}