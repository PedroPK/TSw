/*
 * Este arquivo é propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informação nele contida pode ser
 * reproduzida, mostrada ou revelada sem permissão escrita da Sefaz-PE.
 */
package tsw.t06;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 
 */
public final class BibliotecaFuncoesDataHora {
	//~ Atributos/inicializadores estaticos ----------------------------------------------------------------------------------------

	private static final ThreadLocal<FormatoData> FORMATO_DATA = new ThreadLocal<FormatoData>();

	//~ Metodos --------------------------------------------------------------------------------------------------------------------

	/**
	 * -
	 *
	 * @return  
	 */
	private static FormatoData getFormatoData() {
		FormatoData formatoData = FORMATO_DATA.get();

		if (formatoData == null) {
			formatoData = new FormatoData();
			FORMATO_DATA.set(formatoData);
		}

		return formatoData;
	}

	/**
	 * -
	 *
	 * @param pData
	 *
	 * @return
	 */
	public static String getDataComoString(java.util.Date pData) {
		return getFormatoData().getDataComoString().format(pData);
	}

	/**
	 * -
	 *
	 * @param pData
	 *
	 * @return
	 */
	public static String getDataComoStringMesAno(java.util.Date pData) {
		return getFormatoData().getDataComoStringMesAno().format(pData);
	}

	/**
	 * -
	 *
	 * @param pData
	 *
	 * @return
	 */
	public static String getDataComoStringAnoMes(java.util.Date pData) {
		return getFormatoData().getDataComoStringAnoMes().format(pData);
	}

	/**
	 * -
	 *
	 * @param pData
	 *
	 * @return
	 */
	public static String getDataComoStringDiaMes(java.util.Date pData) {
		return getFormatoData().getDataComoStringDiaMes().format(pData);
	}

	/**
	 * -
	 *
	 * @param pData
	 *
	 * @return
	 */
	public static String getDataComoStringMesDia(java.util.Date pData) {
		return getFormatoData().getDataComoStringMesDia().format(pData);
	}

	/**
	 * -
	 *
	 * @param pData
	 *
	 * @return
	 */
	public static String getDataComoStringInvertida(java.util.Date pData) {
		return getFormatoData().getDataComoStringInvertida().format(pData);
	}

	/**
	 * -
	 *
	 * @param pData
	 *
	 * @return
	 */
	public static String getDataComoStringInvertidaComHifen(java.util.Date pData) {
		return getFormatoData().getDataComoStringInvertidaComHifen().format(pData);
	}

	/**
	 * -
	 *
	 * @param pData
	 *
	 * @return
	 */
	public static String getDiaComoString(java.util.Date pData) {
		return getFormatoData().getDiaComoString().format(pData);
	}

	/**
	 * -
	 *
	 * @param pData
	 *
	 * @return
	 */
	public static String getMesComoString(java.util.Date pData) {
		return getFormatoData().getMesComoString().format(pData);
	}

	/**
	 * -
	 *
	 * @param pData
	 *
	 * @return
	 */
	public static String getAnoComoString(java.util.Date pData) {
		return getFormatoData().getAnoComoString().format(pData);
	}

	/**
	 * -
	 *
	 * @param pDataHora
	 *
	 * @return
	 */
	public static String getDataHoraComoString(java.util.Date pDataHora) {
		return getFormatoData().getDataHoraComoString().format(pDataHora);
	}
	
	/**
	 * -
	 *
	 * @param pDataHora
	 *
	 * @return
	 */
	public static String getDataHoraComoStringComMilis(java.util.Date pDataHora) {
		return getFormatoData().getDataHoraComoStringComMilis().format(pDataHora);
	}

	/**
	 * -
	 *
	 * @param pData
	 *
	 * @return
	 */
	public static String getDataHoraComoStringInvertida(java.util.Date pData) {
		return getFormatoData().getDataHoraComoStringInvertida().format(pData);
	}

	/**
	 * -
	 *
	 * @param pHora
	 *
	 * @return
	 */
	public static String getHoraComoString(java.util.Date pHora) {
		return getFormatoData().getHoraComoString().format(pHora);
	}

	/**
	 * -
	 *
	 * @param pHora
	 *
	 * @return
	 */
	public static String getHoraComoStringComMilis(java.util.Date pHora) {
		return getFormatoData().getHoraComoStringComMilis().format(pHora);
	}

	/**
	 * -
	 *
	 * @param pHora
	 *
	 * @return
	 */
	public static String getHoraComoStringSemSegundos(java.util.Date pHora) {
		return getFormatoData().getHoraComoStringSemSegundos().format(pHora);
	}

	/**
	 * -
	 *
	 * @param pHora
	 *
	 * @return
	 */
	public static String getHoraComoStringSemMascara(java.util.Date pHora) {
		return getFormatoData().getHoraComoStringSemMascara().format(pHora);
	}

	/**
	 * -
	 *
	 * @param pHora
	 *
	 * @return
	 */
	public static String getHoraComoStringSemSegundosSemMascara(java.util.Date pHora) {
		return getFormatoData().getHoraComoStringSemSegundosSemMascara().format(pHora);
	}

	/**
	 * Converte um java.sql.Timestamp para uma String no formato "dd/MM/yyyy HH:mm:ss"
	 *
	 * @param pTimestamp Timestamp
	 *
	 * @return
	 */
	public static String getTimestampComoString(Timestamp pTimestamp) {
		return getDataHoraComoString(pTimestamp);
	}

	/**
	 * Converte um java.sql.Timestamp para uma String no formato "yyyyMMddHHmmssSSSSSS"
	 *
	 * @param pTimestamp Timestamp
	 *
	 * @return
	 */
	public static String getTimestampComoStringComNanos(Timestamp pTimestamp) {
		String ts = getTimestampComoString(pTimestamp);
		ts = ts + "." + BibliotecaFuncoesPrincipal.completarNumeroComZerosEsquerda((pTimestamp.getNanos() / 1000), 6);

		return ts;
	}

	/**
	 * Converte um java.sql.Timestamp para uma String no formato "yyyyMMddHHmmssSSSSSS"
	 *
	 * @param pTimestamp Timestamp
	 *
	 * @return
	 */
	public static String getTimestampComoStringInvertida(java.sql.Timestamp pTimestamp) {
		String ts = getDataHoraComoStringInvertida(pTimestamp);
		ts = ts + BibliotecaFuncoesPrincipal.completarNumeroComZerosEsquerda((pTimestamp.getNanos() / 1000), 6);

		return ts;
	}

	/**
	 * Converte um java.sql.Timestamp para uma String no formato "yyyyMMddHHmmss"
	 *
	 * @param pTimestamp Timestamp
	 *
	 * @return
	 */
	public static String getTimestampComoStringInvertidaSemNanos(java.sql.Timestamp pTimestamp) {
		return getDataHoraComoStringInvertida(pTimestamp);
	}

	/**
	 * Converte um java.sql.Timestamp para uma String no formato "dd/MM/aaaa"
	 *
	 * @param pTimestamp Timestamp
	 *
	 * @return
	 *
	 * @exception ParseException
	 */
	public static String getTimestampComoDataString(Timestamp pTimestamp)
		throws ParseException {
		return getDataComoString(pTimestamp);
	}

	/**
	 * Converte um java.sql.Timestamp para uma String no formato "aaaaMMdd"
	 *
	 * @param pTimestamp Timestamp
	 *
	 * @return
	 *
	 * @exception ParseException
	 */
	public static String getTimestampComoDataStringInvertida(Timestamp pTimestamp)
		throws ParseException {
		return getDataComoStringInvertida(pTimestamp);
	}

	/**
	 * Converte um java.sql.Timestamp para uma String no formato "hh:mm:ss"
	 *
	 * @param pTimestamp Timestamp
	 *
	 * @return
	 *
	 * @exception ParseException
	 */
	public static String getTimestampComoHoraString(Timestamp pTimestamp)
		throws ParseException {
		return getHoraComoString(pTimestamp);
	}

	/**
	 * Converte um java.sql.Timestamp para uma String no formato "hhmmss"
	 *
	 * @param pTimestamp Timestamp
	 *
	 * @return
	 *
	 * @exception ParseException
	 */
	public static String getTimestampComoHoraStringSemMascara(Timestamp pTimestamp)
		throws ParseException {
		return getHoraComoStringSemMascara(pTimestamp);
	}

	/**
	 * Converte um java.sql.Timestamp para uma String no formato "hh:mm"
	 *
	 * @param pTimestamp Timestamp
	 *
	 * @return
	 *
	 * @exception ParseException
	 */
	public static String getTimestampComoHoraStringSemSegundos(Timestamp pTimestamp)
		throws ParseException {
		return getHoraComoStringSemSegundos(pTimestamp);
	}

	/**
	 * -
	 *
	 * @param pData
	 *
	 * @return
	 *
	 * @throws ParseException
	 */
	public static Date getStringComoData(String pData)
		throws ParseException {
		return getStringComoData(pData, true);
	}

	/**
	 * Converte uma string no formato "dd/MM/aaaa" para um tipo java.sql.Date
	 *
	 * @param pData Data no formato "dd/MM/aaaa"
	 * @param pInValidarLimitesAno
	 *
	 * @return
	 *
	 * @exception ParseException
	 */
	public static Date getStringComoData(String pData, boolean pInValidarLimitesAno)
		throws ParseException {
		java.util.Date dt = null;
		GregorianCalendar calendar = new GregorianCalendar();
		int posDia = 0;
		int posMes = 0;
		int posAno = 0;
		int dia = 0;
		int mes = 0;
		int ano = 0;
		int anoAtual = 0;

		anoAtual = calendar.get(GregorianCalendar.YEAR);

		FormatoData formatoData = getFormatoData();

		try {
			dt = formatoData.getDataComoString().parse(pData);

			posDia = 0;
			posMes = 3;
			posAno = 6;
			dia = Integer.parseInt(pData.substring(posDia, 2));
			mes = Integer.parseInt(pData.substring(posMes, 5));
			ano = Integer.parseInt(pData.substring(posAno, 10));
		} catch (Exception e) {
			try {
				dt = formatoData.getDataComoStringInvertidaComHifen().parse(pData);

				posDia = 8;
				posMes = 5;
				posAno = 0;
				ano = Integer.parseInt(pData.substring(posAno, 4));
				mes = Integer.parseInt(pData.substring(posMes, 7));
				dia = Integer.parseInt(pData.substring(posDia, 10));
			} catch (Exception ex) {
				dt = formatoData.getDataComoStringInvertida().parse(pData);

				posDia = 6;
				posMes = 4;
				posAno = 0;

				if (pData.length() >= 4) {
					ano = Integer.parseInt(pData.substring(posAno, 4));
				}

				if (pData.length() >= 6) {
					mes = Integer.parseInt(pData.substring(posMes, 6));
				}

				if (pData.length() >= 8) {
					dia = Integer.parseInt(pData.substring(posDia, 8));
				}
			}
		}

		if (pInValidarLimitesAno) {
			if (ano < 1900) {
				throw new ParseException("Ano inválido (" + pData + ") - não pode ser menor que 1900", posAno);
			}

			if (ano > (anoAtual + 100)) {
				throw new ParseException("Ano inválido (" + pData + ") - não pode ser maior que " + (anoAtual + 100), posAno);
			}
		}

		if ((mes < 1) || (mes > 12)) {
			throw new ParseException("Mês inválido (" + pData + ") - não pode ser menor que 1 nem maior que 12", posMes);
		}

		if (dia < 1) {
			throw new ParseException("Dia inválido (" + pData + ") - não pode ser menor que 1", posDia);
		}

		if (((mes == 1) && (dia > 31)) || ((mes == 2) && (dia > 29) && (calendar.isLeapYear(ano))) //ano bissexto
				 ||((mes == 2) && (dia > 28) && (!calendar.isLeapYear(ano))) || ((mes == 3) && (dia > 31)) ||
				((mes == 4) && (dia > 30)) || ((mes == 5) && (dia > 31)) || ((mes == 6) && (dia > 30)) ||
				((mes == 7) && (dia > 31)) || ((mes == 8) && (dia > 31)) || ((mes == 9) && (dia > 30)) ||
				((mes == 10) && (dia > 31)) || ((mes == 11) && (dia > 30)) || ((mes == 12) && (dia > 31))) {
			throw new ParseException("Dia inválido (" + dia + ") para o mês " + mes, posDia);
		}

		return new Date(dt.getTime());
	}

	/**
	 * Converte uma string para um tipo java.sql.Date
	 *
	 * @param pDataHora Data-hora no formato "dd/MM/aaaa hh:mm:ss"
	 *
	 * @return
	 *
	 * @exception ParseException
	 */
	public static Date getStringComoDataHora(String pDataHora)
		throws ParseException {
		java.util.Date dt = null;
		boolean isConvertido = false;
		GregorianCalendar calendar = new GregorianCalendar();
		int posDia = 0;
		int posMes = 0;
		int posAno = 0;
		int dia = 0;
		int mes = 0;
		int ano = 0;
		int anoAtual = 0;

		anoAtual = calendar.get(GregorianCalendar.YEAR);

		FormatoData formatoData = getFormatoData();

		if (pDataHora.length() <= 10) {
			if (!isConvertido) {
				try {
					dt = formatoData.getDataComoString().parse(pDataHora);
					isConvertido = true;

					posDia = 0;
					posMes = 3;
					posAno = 6;
					dia = Integer.parseInt(pDataHora.substring(posDia, 2));
					mes = Integer.parseInt(pDataHora.substring(posMes, 5));
					ano = Integer.parseInt(pDataHora.substring(posAno, 10));
				} catch (Exception e) {
				}
			}

			if (!isConvertido) {
				try {
					dt = formatoData.getDataComoStringInvertidaComHifen().parse(pDataHora);
					isConvertido = true;

					posDia = 8;
					posMes = 5;
					posAno = 0;
					ano = Integer.parseInt(pDataHora.substring(posAno, 4));
					mes = Integer.parseInt(pDataHora.substring(posMes, 7));
					dia = Integer.parseInt(pDataHora.substring(posDia, 10));
				} catch (Exception e) {
				}
			}

			if (!isConvertido) {
				try {
					dt = formatoData.getDataComoStringInvertida().parse(pDataHora);
					isConvertido = true;

					posDia = 6;
					posMes = 4;
					posAno = 0;
					ano = Integer.parseInt(pDataHora.substring(posAno, 4));
					mes = Integer.parseInt(pDataHora.substring(posMes, 6));
					dia = Integer.parseInt(pDataHora.substring(posDia, 8));
				} catch (Exception e) {
				}
			}
		} else {
			try {
				dt = formatoData.getDataHoraComoString().parse(pDataHora);
				isConvertido = true;

				posDia = 0;
				posMes = 3;
				posAno = 6;
				dia = Integer.parseInt(pDataHora.substring(posDia, 2));
				mes = Integer.parseInt(pDataHora.substring(posMes, 5));
				ano = Integer.parseInt(pDataHora.substring(posAno, 10));
			} catch (Exception e) {
			}

			if (!isConvertido) {
				try {
					SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
					dt = formatador.parse(pDataHora);
					isConvertido = true;

					posDia = 0;
					posMes = 3;
					posAno = 6;
					dia = Integer.parseInt(pDataHora.substring(posDia, 2));
					mes = Integer.parseInt(pDataHora.substring(posMes, 5));
					ano = Integer.parseInt(pDataHora.substring(posAno, 10));
				} catch (Exception e) {
				}
			}

			if (!isConvertido) {
				try {
					SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
					dt = formatador.parse(pDataHora);
					isConvertido = true;

					posDia = 8;
					posMes = 5;
					posAno = 0;
					ano = Integer.parseInt(pDataHora.substring(posAno, 4));
					mes = Integer.parseInt(pDataHora.substring(posMes, 7));
					dia = Integer.parseInt(pDataHora.substring(posDia, 10));
				} catch (Exception e) {
				}
			}

			if (!isConvertido) {
				try {
					SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss.SSSSSS");
					dt = formatador.parse(pDataHora);
					isConvertido = true;

					posDia = 8;
					posMes = 5;
					posAno = 0;
					ano = Integer.parseInt(pDataHora.substring(posAno, 4));
					mes = Integer.parseInt(pDataHora.substring(posMes, 7));
					dia = Integer.parseInt(pDataHora.substring(posDia, 10));
				} catch (Exception e) {
				}
			}

			if (!isConvertido) {
				try {
					SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
					dt = formatador.parse(pDataHora);
					isConvertido = true;

					posDia = 8;
					posMes = 5;
					posAno = 0;
					ano = Integer.parseInt(pDataHora.substring(posAno, 4));
					mes = Integer.parseInt(pDataHora.substring(posMes, 7));
					dia = Integer.parseInt(pDataHora.substring(posDia, 10));
				} catch (Exception e) {
				}
			}

			if (!isConvertido) {
				try {
					SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd-HH.mm");
					dt = formatador.parse(pDataHora);
					isConvertido = true;

					posDia = 8;
					posMes = 5;
					posAno = 0;
					ano = Integer.parseInt(pDataHora.substring(posAno, 4));
					mes = Integer.parseInt(pDataHora.substring(posMes, 7));
					dia = Integer.parseInt(pDataHora.substring(posDia, 10));
				} catch (Exception e) {
				}
			}

			if (!isConvertido) {
				try {
					SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss.SSSSSS");
					dt = formatador.parse(pDataHora);
					isConvertido = true;

					posDia = 8;
					posMes = 5;
					posAno = 0;
					ano = Integer.parseInt(pDataHora.substring(posAno, 4));
					mes = Integer.parseInt(pDataHora.substring(posMes, 7));
					dia = Integer.parseInt(pDataHora.substring(posDia, 10));
				} catch (Exception e) {
				}
			}

			if (!isConvertido) {
				try {
					SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
					dt = formatador.parse(pDataHora);
					isConvertido = true;

					posDia = 8;
					posMes = 5;
					posAno = 0;
					ano = Integer.parseInt(pDataHora.substring(posAno, 4));
					mes = Integer.parseInt(pDataHora.substring(posMes, 7));
					dia = Integer.parseInt(pDataHora.substring(posDia, 10));
				} catch (Exception e) {
				}
			}

			if (!isConvertido) {
				try {
					SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-ddHH:mm");
					dt = formatador.parse(pDataHora);
					isConvertido = true;

					posDia = 8;
					posMes = 5;
					posAno = 0;
					ano = Integer.parseInt(pDataHora.substring(posAno, 4));
					mes = Integer.parseInt(pDataHora.substring(posMes, 7));
					dia = Integer.parseInt(pDataHora.substring(posDia, 10));
				} catch (Exception e) {
				}
			}

			if (!isConvertido) {
				try {
					SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSSSS");
					dt = formatador.parse(pDataHora);
					isConvertido = true;

					posDia = 8;
					posMes = 5;
					posAno = 0;
					ano = Integer.parseInt(pDataHora.substring(posAno, 4));
					mes = Integer.parseInt(pDataHora.substring(posMes, 7));
					dia = Integer.parseInt(pDataHora.substring(posDia, 10));
				} catch (Exception e) {
				}
			}

			if (!isConvertido) {
				try {
					SimpleDateFormat formatador = new SimpleDateFormat("yyyyMMddHHmmssSSSSSS");
					dt = formatador.parse(pDataHora);
					isConvertido = true;

					posDia = 6;
					posMes = 4;
					posAno = 0;
					ano = Integer.parseInt(pDataHora.substring(posAno, 4));
					mes = Integer.parseInt(pDataHora.substring(posMes, 6));
					dia = Integer.parseInt(pDataHora.substring(posDia, 8));
				} catch (Exception e) {
				}
			}

			if (!isConvertido) {
				try {
					SimpleDateFormat formatador = new SimpleDateFormat("yyyyMMddHHmmss");
					dt = formatador.parse(pDataHora);
					isConvertido = true;

					posDia = 6;
					posMes = 4;
					posAno = 0;
					ano = Integer.parseInt(pDataHora.substring(posAno, 4));
					mes = Integer.parseInt(pDataHora.substring(posMes, 6));
					dia = Integer.parseInt(pDataHora.substring(posDia, 8));
				} catch (Exception e) {
				}
			}

			if (!isConvertido) {
				try {
					SimpleDateFormat formatador = new SimpleDateFormat("yyyyMMddHHmm");
					dt = formatador.parse(pDataHora);
					isConvertido = true;

					posDia = 6;
					posMes = 4;
					posAno = 0;
					ano = Integer.parseInt(pDataHora.substring(posAno, 4));
					mes = Integer.parseInt(pDataHora.substring(posMes, 6));
					dia = Integer.parseInt(pDataHora.substring(posDia, 8));
				} catch (Exception e) {
				}
			}
		}

		if (!isConvertido) {
			throw new ParseException("Data-hora inválida (" + pDataHora + ")", 0);
		}

		if (ano < 1900) {
			throw new ParseException("Ano inválido (" + pDataHora + ") - não pode ser menor que 1900", posAno);
		}

		if (ano > (anoAtual + 100)) {
			throw new ParseException("Ano inválido (" + pDataHora + ") - não pode ser maior que " + (anoAtual + 100), posAno);
		}

		if ((mes < 1) || (mes > 12)) {
			throw new ParseException("Mês inválido (" + pDataHora + ") - não pode ser menor que 1 nem maior que 12", posMes);
		}

		if (dia < 1) {
			throw new ParseException("Dia inválido (" + pDataHora + ") - não pode ser menor que 1", posDia);
		}

		if (((mes == 1) && (dia > 31)) || ((mes == 2) && (dia > 29) && (calendar.isLeapYear(ano))) //ano bissexto
				 ||((mes == 2) && (dia > 28) && (!calendar.isLeapYear(ano))) || ((mes == 3) && (dia > 31)) ||
				((mes == 4) && (dia > 30)) || ((mes == 5) && (dia > 31)) || ((mes == 6) && (dia > 30)) ||
				((mes == 7) && (dia > 31)) || ((mes == 8) && (dia > 31)) || ((mes == 9) && (dia > 30)) ||
				((mes == 10) && (dia > 31)) || ((mes == 11) && (dia > 30)) || ((mes == 12) && (dia > 31))) {
			throw new ParseException("Dia inválido (" + dia + ") para o mês " + mes, posDia);
		}

		return new Date(dt.getTime());
	}

	/**
	 * Converte uma string no formato "hh:mm:ss" para um tipo java.sql.Time
	 *
	 * @param pHora Hora no formato "hh:mm:ss"
	 *
	 * @return
	 *
	 * @exception ParseException
	 */
	public static Time getStringComoHora(String pHora)
		throws ParseException {
		java.util.Date dt = null;
		SimpleDateFormat formatador = null;

		if (pHora.length() == 5) {
			formatador = new SimpleDateFormat("HH:mm");
		} else if (pHora.length() == 6) {
			formatador = new SimpleDateFormat("HHmmss");
		} else {
			formatador = new SimpleDateFormat("HH:mm:ss");
		}

		dt = formatador.parse(pHora);

		return new Time(dt.getTime());
	}

	/**
	 * Converte uma string nos formatos "dd/MM/aaaa hh:mm:ss" ou "dd/MM/aaaa hh:mm" para um tipo java.sql.Timestamp
	 *
	 * @param pTimestamp Data no formato "dd/MM/aaaa hh:mm:ss"
	 *
	 * @return
	 *
	 * @exception ParseException
	 */
	public static Timestamp getStringComoTimestamp(String pTimestamp)
		throws ParseException {
		java.util.Date dt = null;
		SimpleDateFormat formatador = null;
		String strNanos = null;
		int nanos = 0;
		boolean isConvertido = false;
		Timestamp tstamp = null;

		try {
			formatador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
			dt = formatador.parse(pTimestamp);
			isConvertido = true;
		} catch (Exception e) {
		}

		if (!isConvertido) {
			try {
				formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSSSSS");
				dt = formatador.parse(pTimestamp);
				isConvertido = true;
			} catch (Exception e) {
			}
		}

		if (!isConvertido) {
			try {
				formatador = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss.SSSSSS");
				dt = formatador.parse(pTimestamp);
				isConvertido = true;
			} catch (Exception e) {
			}
		}

		if (!isConvertido) {
			try {
				formatador = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss.SSSSSS");
				dt = formatador.parse(pTimestamp);
				isConvertido = true;
			} catch (Exception e) {
			}
		}

		if (!isConvertido) {
			try {
				formatador = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss.SSSSSS");
				dt = formatador.parse(pTimestamp);
				isConvertido = true;
			} catch (Exception e) {
			}
		}

		if (!isConvertido) {
			try {
				formatador = new SimpleDateFormat("yyyyMMddHHmmssSSSSSS");
				dt = formatador.parse(pTimestamp);
				isConvertido = true;
			} catch (Exception e) {
			}
		}

		if (!isConvertido) {
			dt = BibliotecaFuncoesDataHora.getStringComoDataHora(pTimestamp);
		} else {
			if (pTimestamp.lastIndexOf('.') >= 0) {
				strNanos = pTimestamp.substring(pTimestamp.lastIndexOf('.') + 1);
				dt = BibliotecaFuncoesDataHora.getStringComoDataHora(pTimestamp.substring(0, pTimestamp.lastIndexOf('.')));
			} else {
				strNanos = pTimestamp.substring(14);
				dt = BibliotecaFuncoesDataHora.getStringComoDataHora(pTimestamp.substring(0, 14));
			}
			strNanos = BibliotecaFuncoesPrincipal.completarNumeroComZerosDireita(strNanos, 6);
			strNanos = strNanos.substring(0, 6);

			nanos = (Integer.parseInt(strNanos)) * 1000;
		}

		tstamp = new Timestamp(dt.getTime());
		tstamp.setNanos(nanos);

		return tstamp;
	}

	/**
	 * -
	 *
	 * @param pLong Data no formato long
	 * @param pNanos Parte dos nanosegundos da data
	 *
	 * @return
	 *
	 * @exception ParseException
	 */
	public static Timestamp getStringComoTimestamp(String pLong, String pNanos)
		throws ParseException {
		Timestamp timeStamp = null;

		timeStamp = new Timestamp(Long.parseLong(pLong));
		timeStamp.setNanos(Integer.parseInt(pNanos));

		return timeStamp;
	}

	/**
	 * Converte uma string nos formatos "MM/aaaa" para um tipo java.sql.Date
	 *
	 * @param pData Data no formato "MM/aaaa"
	 *
	 * @return
	 *
	 * @exception ParseException
	 */
	public static Date getStringComoPrimeiraDataMes(String pData)
		throws ParseException {
		java.util.Date dt = null;
		GregorianCalendar calendar = new GregorianCalendar();
		int posMes = 0;
		int posAno = 0;
		int mes = 0;
		int ano = 0;
		int anoAtual = 0;

		anoAtual = calendar.get(GregorianCalendar.YEAR);

		dt = getFormatoData().getDataComoString().parse("01/" + pData);

		posMes = 0;
		posAno = 3;

		if (pData.length() >= 2) {
			mes = Integer.parseInt(pData.substring(posMes, 2));
		}

		if (pData.length() >= 7) {
			ano = Integer.parseInt(pData.substring(posAno, 7));
		}

		if (ano < 1900) {
			throw new ParseException("Ano inválido (" + pData + ") - não pode ser menor que 1900", posAno);
		}

		if (ano > (anoAtual + 100)) {
			throw new ParseException("Ano inválido (" + pData + ") - não pode ser maior que " + (anoAtual + 100), posAno);
		}

		if ((mes < 1) || (mes > 12)) {
			throw new ParseException("Mês inválido (" + pData + ") - não pode ser menor que 1 nem maior que 12", posMes);
		}

		return new Date(dt.getTime());
	}

	/**
	 * Converte uma string nos formatos "MM/aaaa" para um tipo java.sql.Date
	 *
	 * @param pData Data no formato "MM/aaaa"
	 *
	 * @return
	 *
	 * @exception ParseException
	 */
	public static Date getStringComoUltimaDataMes(String pData)
		throws ParseException {
		java.util.Date dt = null;
		GregorianCalendar calendar = new GregorianCalendar();
		int maxDay = 0;
		int posMes = 0;
		int posAno = 0;
		int mes = 0;
		int ano = 0;
		int anoAtual = 0;

		anoAtual = calendar.get(GregorianCalendar.YEAR);

		dt = getFormatoData().getDataComoString().parse("01/" + pData);
		calendar.setTime(new Date(dt.getTime()));
		maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, maxDay);
		dt = calendar.getTime();

		posMes = 0;
		posAno = 3;

		if (pData.length() >= 2) {
			mes = Integer.parseInt(pData.substring(posMes, 2));
		}

		if (pData.length() >= 7) {
			ano = Integer.parseInt(pData.substring(posAno, 7));
		}

		if (ano < 1900) {
			throw new ParseException("Ano inválido (" + pData + ") - não pode ser menor que 1900", posAno);
		}

		if (ano > (anoAtual + 100)) {
			throw new ParseException("Ano inválido (" + pData + ") - não pode ser maior que " + (anoAtual + 100), posAno);
		}

		if ((mes < 1) || (mes > 12)) {
			throw new ParseException("Mês inválido (" + pData + ") - não pode ser menor que 1 nem maior que 12", posMes);
		}

		return (new Date(dt.getTime()));
	}

	/**
	 * -
	 *
	 * @param pCdMes
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public static String getMesAnterior(String pCdMes)
		throws ExcecaoParametroInvalido {
		if (pCdMes.equals(Constantes.CD_MES_JANEIRO)) {
			return Constantes.CD_MES_DEZEMBRO;
		} else if (pCdMes.equals(Constantes.CD_MES_FEVEREIRO)) {
			return Constantes.CD_MES_JANEIRO;
		} else if (pCdMes.equals(Constantes.CD_MES_MARCO)) {
			return Constantes.CD_MES_FEVEREIRO;
		} else if (pCdMes.equals(Constantes.CD_MES_ABRIL)) {
			return Constantes.CD_MES_MARCO;
		} else if (pCdMes.equals(Constantes.CD_MES_MAIO)) {
			return Constantes.CD_MES_ABRIL;
		} else if (pCdMes.equals(Constantes.CD_MES_JUNHO)) {
			return Constantes.CD_MES_MAIO;
		} else if (pCdMes.equals(Constantes.CD_MES_JULHO)) {
			return Constantes.CD_MES_JUNHO;
		} else if (pCdMes.equals(Constantes.CD_MES_AGOSTO)) {
			return Constantes.CD_MES_JULHO;
		} else if (pCdMes.equals(Constantes.CD_MES_SETEMBRO)) {
			return Constantes.CD_MES_AGOSTO;
		} else if (pCdMes.equals(Constantes.CD_MES_OUTUBRO)) {
			return Constantes.CD_MES_SETEMBRO;
		} else if (pCdMes.equals(Constantes.CD_MES_NOVEMBRO)) {
			return Constantes.CD_MES_OUTUBRO;
		} else if (pCdMes.equals(Constantes.CD_MES_DEZEMBRO)) {
			return Constantes.CD_MES_NOVEMBRO;
		} else {
			throw new ExcecaoParametroInvalido("Codigo de Mês inválido (" + pCdMes + ")");
		}
	}

	/**
	 * -
	 *
	 * @param pCdMes
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public static String getMesPosterior(String pCdMes)
		throws ExcecaoParametroInvalido {
		if (pCdMes.equals(Constantes.CD_MES_JANEIRO)) {
			return Constantes.CD_MES_FEVEREIRO;
		} else if (pCdMes.equals(Constantes.CD_MES_FEVEREIRO)) {
			return Constantes.CD_MES_MARCO;
		} else if (pCdMes.equals(Constantes.CD_MES_MARCO)) {
			return Constantes.CD_MES_ABRIL;
		} else if (pCdMes.equals(Constantes.CD_MES_ABRIL)) {
			return Constantes.CD_MES_MAIO;
		} else if (pCdMes.equals(Constantes.CD_MES_MAIO)) {
			return Constantes.CD_MES_JUNHO;
		} else if (pCdMes.equals(Constantes.CD_MES_JUNHO)) {
			return Constantes.CD_MES_JULHO;
		} else if (pCdMes.equals(Constantes.CD_MES_JULHO)) {
			return Constantes.CD_MES_AGOSTO;
		} else if (pCdMes.equals(Constantes.CD_MES_AGOSTO)) {
			return Constantes.CD_MES_SETEMBRO;
		} else if (pCdMes.equals(Constantes.CD_MES_SETEMBRO)) {
			return Constantes.CD_MES_OUTUBRO;
		} else if (pCdMes.equals(Constantes.CD_MES_OUTUBRO)) {
			return Constantes.CD_MES_NOVEMBRO;
		} else if (pCdMes.equals(Constantes.CD_MES_NOVEMBRO)) {
			return Constantes.CD_MES_DEZEMBRO;
		} else if (pCdMes.equals(Constantes.CD_MES_DEZEMBRO)) {
			return Constantes.CD_MES_JANEIRO;
		} else {
			throw new ExcecaoParametroInvalido("Codigo de Mês inválido (" + pCdMes + ")");
		}
	}

	/**
	 * Retorna o nome do mes por extenso dado sua representação númerica
	 *
	 * @param pNuMes Número que representa o mes do ano
	 *
	 * @return
	 *
	 * @exception ExcecaoParametroInvalido Caso número do mes não esteja entre os valores 1 e 12
	 */
	public static String getNmMes(String pNuMes) throws ExcecaoParametroInvalido {
		return BibliotecaFuncoesDataHora.getNmMes(Integer.valueOf(pNuMes).intValue());
	}

	/**
	 * Retorna o nome do mes por extenso dado sua representação númerica
	 *
	 * @param pNuMes Número que representa o mes do ano
	 *
	 * @return
	 *
	 * @exception ExcecaoParametroInvalido Caso número do mes não esteja entre os valores 1 e 12
	 */
	public static String getNmMes(int pNuMes) throws ExcecaoParametroInvalido {
		String retorno = "";
		String nuMes = "";

		try {
			nuMes = BibliotecaFuncoesPrincipal.completarNumeroComZerosEsquerda(pNuMes, 2);
			retorno = DominioMes.getInstancia().getDescricaoChave(nuMes);
		} catch (ExcecaoParametroInvalido e) {
			throw new ExcecaoParametroInvalido("Apenas números positivos entre 1 e 12 correspondem a meses do ano válidos");
		}

		return retorno;
	}

	/**
	 * Retorna o nome do dia por extenso dado sua representação númerica
	 *
	 * @param pNuDia Número que representa o dia da semana
	 *
	 * @return
	 *
	 * @exception ExcecaoParametroInvalido Caso número do dia não esteja entre os valores 1 e 7
	 */
	public static String getNmDia(int pNuDia) throws ExcecaoParametroInvalido {
		String retorno = "";

		try {
			retorno = DominioDiaSemana.getInstancia().getDescricaoChave("" + pNuDia);
		} catch (ExcecaoParametroInvalido e) {
			throw new ExcecaoParametroInvalido("Apenas números positivos entre 1 e 7 correspondem a dias da semana válidos", e);
		}

		return retorno;
	}

	/**
	 * -
	 *
	 * @param pDataInicial
	 * @param pDataFinal
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public static boolean isPeriodoValido(java.util.Date pDataInicial, java.util.Date pDataFinal)
		throws ExcecaoParametroInvalido {
		Calendar dataInicial = null;
		Calendar dataFinal = null;

		if ((pDataInicial == null) && (pDataFinal == null)) {
			return false;
		}

		if ((pDataInicial == null) || (pDataFinal == null)) {
			return true;
		}

		dataInicial = Calendar.getInstance();
		dataFinal = Calendar.getInstance();

		dataInicial.setTime(pDataInicial);
		dataFinal.setTime(pDataFinal);

		if (dataInicial.equals(dataFinal)) {
			return true;
		} else if (dataFinal.after(dataInicial)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * -
	 *
	 * @param pDataComparacao
	 * @param pDataReferencia
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public static int compararDatas(java.util.Date pDataComparacao, java.util.Date pDataReferencia)
		throws ExcecaoParametroInvalido {
		int comparacao = 0;
		int resultado = 0;

		comparacao = pDataComparacao.compareTo(pDataReferencia);

		if (comparacao == 0) {
			resultado = Constantes.CD_IGUAL;
		} else if (comparacao > 0) {
			resultado = Constantes.CD_MAIOR;
		} else if (comparacao < 0) {
			resultado = Constantes.CD_MENOR;
		}

		return resultado;
	}

	/**
	 * -
	 *
	 * @param pDataComparacao
	 * @param pDataReferencia
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public static int compararDatasSemHoras(java.util.Date pDataComparacao, java.util.Date pDataReferencia)
		throws ExcecaoParametroInvalido {
		int comparacao = 0;
		int resultado = 0;

		String dataReferencia = BibliotecaFuncoesDataHora.getDataComoStringInvertida(pDataReferencia);
		String dataComparacao = BibliotecaFuncoesDataHora.getDataComoStringInvertida(pDataComparacao);

		comparacao = dataComparacao.compareTo(dataReferencia);

		if (comparacao == 0) {
			resultado = Constantes.CD_IGUAL;
		} else if (comparacao > 0) {
			resultado = Constantes.CD_MAIOR;
		} else if (comparacao < 0) {
			resultado = Constantes.CD_MENOR;
		}

		return resultado;
	}

	/**
	 * -
	 *
	 * @param pDataInicio
	 * @param pDataFim
	 * @param pDataComparacao
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public static boolean isDataDentroPeriodo(java.util.Date pDataInicio, java.util.Date pDataFim, java.util.Date pDataComparacao)
		throws ExcecaoParametroInvalido {
		boolean resultado = false;

		if (((pDataComparacao.compareTo(pDataInicio) == 0) || (pDataComparacao.compareTo(pDataInicio) > 0)) &&
				((pDataComparacao.compareTo(pDataFim) == 0) || (pDataComparacao.compareTo(pDataFim) < 0))) {
			resultado = true;
		}

		return resultado;
	}

	/**
	 * -
	 *
	 * @param pDataComparacao
	 * @param pDataReferencia
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public static int compararAnos(java.util.Date pDataComparacao, java.util.Date pDataReferencia)
		throws ExcecaoParametroInvalido {
		int comparacao = 0;
		int resultado = 0;
		String anoReferencia = BibliotecaFuncoesDataHora.getAnoComoString(pDataReferencia);
		String anoComparacao = BibliotecaFuncoesDataHora.getAnoComoString(pDataComparacao);

		comparacao = anoComparacao.compareTo(anoReferencia);

		if (comparacao == 0) {
			resultado = Constantes.CD_IGUAL;
		} else if (comparacao > 0) {
			resultado = Constantes.CD_MAIOR;
		} else if (comparacao < 0) {
			resultado = Constantes.CD_MENOR;
		}

		return resultado;
	}

	/**
	 * Retorna a data de hoje como java.sql.Date
	 *
	 * @return
	 */
	public static Time getHoraAtual() {
		java.util.Date dt = new java.util.Date();

		return new Time(dt.getTime());
	}

	/**
	 * Retorna a data de hoje como java.sql.Date
	 *
	 * @return
	 */
	public static String getHoraAtualComoString() {
		Time hora;
		String strHora;

		hora = BibliotecaFuncoesDataHora.getHoraAtual();
		strHora = BibliotecaFuncoesDataHora.getHoraComoString(hora);

		return strHora;
	}

	/**
	 * Retorna a data de hoje como java.sql.Date
	 *
	 * @return
	 */
	public static Date getDataHoje() {
		java.util.Date dt = new java.util.Date();

		return new Date(dt.getTime());
	}

	/**
	 * Retorna a data de hoje com horas zeradas como java.sql.Date
	 *
	 * @return
	 */
	public static Date getDataHojeSemHoras() {
		java.util.Date dt = new java.util.Date();
		Date dtRetorno = new Date(dt.getTime());

		dtRetorno = BibliotecaFuncoesDataHora.limparTimeZone(dtRetorno);

		return dtRetorno;
	}

	/**
	 * Retorna a data de hoje com horas zeradas como java.sql.Date
	 *
	 * @return
	 */
	public static String getDataHojeComoString() {
		Date data;
		String strData;

		data = BibliotecaFuncoesDataHora.getDataHoje();
		strData = BibliotecaFuncoesDataHora.getDataComoString(data);

		return strData;
	}

	/**
	 * Retorna a data  por extenso
	 *
	 * @param pData
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public static String getDataPorExtensoSemDiaSemana(Date pData)
		throws ExcecaoParametroInvalido {
		String data = "";
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(pData);

		data = (calendar.get(Calendar.DAY_OF_MONTH)) + " de ";
		data = data + BibliotecaFuncoesDataHora.getNmMes(calendar.get(Calendar.MONTH) + 1) + " de ";
		data = data + calendar.get(Calendar.YEAR);

		return data;
	}

	/**
	 * Retorna a data  por extenso
	 *
	 * @param pData
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public static String getDataPorExtenso(Date pData)
		throws ExcecaoParametroInvalido {
		String data = "";
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(pData);

		data = BibliotecaFuncoesDataHora.getNmDia(calendar.get(Calendar.DAY_OF_WEEK)) + ", ";
		data = data + (calendar.get(Calendar.DAY_OF_MONTH)) + " de ";
		data = data + BibliotecaFuncoesDataHora.getNmMes(calendar.get(Calendar.MONTH) + 1) + " de ";
		data = data + calendar.get(Calendar.YEAR);

		return data;
	}

	/**
	 * Retorna a data de hoje por extenso
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public static String getDataHojePorExtenso() throws ExcecaoParametroInvalido {
		return BibliotecaFuncoesDataHora.getDataPorExtenso(BibliotecaFuncoesDataHora.getDataHoje());
	}

	/**
	 * Retorna a data de amanhã como java.sql.Date
	 *
	 * @return
	 */
	public static Date getDataAmanha() {
		java.util.Date dt = null;
		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DATE, 1);
		dt = calendar.getTime();

		return (new Date(dt.getTime()));
	}

	/**
	 * Retorna a data de amanhã com horas zeradas como java.sql.Date
	 *
	 * @return
	 */
	public static Date getDataAmanhaSemHoras() {
		java.util.Date dt = null;
		Date dtRetorno = null;
		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DATE, 1);
		dt = calendar.getTime();

		dtRetorno = new Date(dt.getTime());
		dtRetorno = BibliotecaFuncoesDataHora.limparTimeZone(dtRetorno);

		return dtRetorno;
	}

	/**
	 * Retorna a data anterior a que foi passada como parametro
	 *
	 * @param pDataAtual
	 *
	 * @return
	 */
	public static Date getDataAnterior(Date pDataAtual) {
		java.util.Date dt = null;
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(pDataAtual);
		calendar.add(Calendar.DATE, -1);
		dt = calendar.getTime();

		return (new Date(dt.getTime()));
	}

	/**
	 * Retorna a data anterior a que foi passada como parametro com horas zeradas como java.sql.Date
	 *
	 * @param pDataAtual
	 *
	 * @return
	 */
	public static Date getDataAnteriorSemHoras(Date pDataAtual) {
		java.util.Date dt = null;
		Date dtRetorno = null;
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(pDataAtual);
		calendar.add(Calendar.DATE, -1);
		dt = calendar.getTime();

		dtRetorno = new Date(dt.getTime());
		dtRetorno = BibliotecaFuncoesDataHora.limparTimeZone(dtRetorno);

		return dtRetorno;
	}

	/**
	 * Retorna a data que foi passada como parametro com o TimeZone setado para zero
	 *
	 * @param pData
	 *
	 * @return
	 */
	public static Date limparTimeZone(Date pData) {
		Calendar calendar = Calendar.getInstance();

		java.util.Date dt = null;

		calendar.setTime(pData);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		dt = calendar.getTime();

		return (new Date(dt.getTime()));
	}

	/**
	 * Converte uma string no formato "aaaa-MM-dd" para um tipo java.sql.Date
	 *
	 * @param pData Data no formato "aaaa-MM-dd"
	 *
	 * @return
	 *
	 * @exception ParseException
	 */
	public static Date getStringInvertidaComoData(String pData)
		throws ParseException {
		java.util.Date dt = null;

		try {
			dt = getFormatoData().getDataComoStringInvertidaComHifen().parse(pData);
		} catch (Exception e) {
			dt = getFormatoData().getDataComoStringInvertida().parse(pData);
		}

		return new Date(dt.getTime());
	}

	/**
	 * -
	 *
	 * @param pDataReferencia
	 * @param pCampo
	 * @param pQtDeslocamento
	 *
	 * @return
	 */
	public static Date deslocarData(Date pDataReferencia, int pCampo, int pQtDeslocamento) {
		Calendar calendario = Calendar.getInstance();
		Date resultado = null;

		calendario.setTime(pDataReferencia);
		calendario.add(pCampo, pQtDeslocamento);

		resultado = new Date(calendario.getTime().getTime());

		return resultado;
	}

	/**
	 * -
	 *
	 * @param pDataReferencia
	 * @param pQtSegundos
	 *
	 * @return
	 */
	public static Date avancarDataComQtSegundos(Date pDataReferencia, int pQtSegundos) {
		return BibliotecaFuncoesDataHora.deslocarData(pDataReferencia, Calendar.SECOND, pQtSegundos);
	}

	/**
	 * -
	 *
	 * @param pDataReferencia
	 * @param pQtSegundos
	 *
	 * @return
	 */
	public static Date retrocederDataComQtSegundos(Date pDataReferencia, int pQtSegundos) {
		return BibliotecaFuncoesDataHora.deslocarData(pDataReferencia, Calendar.SECOND, -pQtSegundos);
	}

	/**
	 * -
	 *
	 * @param pDataReferencia
	 * @param pQtMinutos
	 *
	 * @return
	 */
	public static Date avancarDataComQtMinutos(Date pDataReferencia, int pQtMinutos) {
		return BibliotecaFuncoesDataHora.deslocarData(pDataReferencia, Calendar.MINUTE, pQtMinutos);
	}

	/**
	 * -
	 *
	 * @param pDataReferencia
	 * @param pQtMinutos
	 *
	 * @return
	 */
	public static Date retrocederDataComQtMinutos(Date pDataReferencia, int pQtMinutos) {
		return BibliotecaFuncoesDataHora.deslocarData(pDataReferencia, Calendar.MINUTE, -pQtMinutos);
	}

	/**
	 * -
	 *
	 * @param pDataReferencia
	 * @param pQtDias
	 *
	 * @return
	 */
	public static Date avancarDataComQtDias(Date pDataReferencia, int pQtDias) {
		return BibliotecaFuncoesDataHora.deslocarData(pDataReferencia, Calendar.DATE, pQtDias);
	}

	/**
	 * -
	 *
	 * @param pDataReferencia
	 * @param pQtDias
	 *
	 * @return
	 */
	public static Date retrocederDataComQtDias(Date pDataReferencia, int pQtDias) {
		return BibliotecaFuncoesDataHora.deslocarData(pDataReferencia, Calendar.DATE, -pQtDias);
	}

	/**
	 * -
	 *
	 * @param pDataReferencia
	 * @param pQtMeses
	 *
	 * @return
	 */
	public static Date avancarDataComQtMeses(Date pDataReferencia, int pQtMeses) {
		return BibliotecaFuncoesDataHora.deslocarData(pDataReferencia, Calendar.MONTH, pQtMeses);
	}

	/**
	 * -
	 *
	 * @param pDataReferencia
	 * @param pQtMeses
	 *
	 * @return
	 */
	public static Date retrocederDataComQtMeses(Date pDataReferencia, int pQtMeses) {
		return BibliotecaFuncoesDataHora.deslocarData(pDataReferencia, Calendar.MONTH, -pQtMeses);
	}

	/**
	 * -
	 *
	 * @param pDataReferencia
	 * @param pQtAnos
	 *
	 * @return
	 */
	public static Date retrocederDataComQtAnos(Date pDataReferencia, int pQtAnos) {
		return BibliotecaFuncoesDataHora.deslocarData(pDataReferencia, Calendar.YEAR, -pQtAnos);
	}

	/**
	 * -
	 *
	 * @param pDataReferencia
	 * @param pQtAnos
	 *
	 * @return
	 */
	public static Date avancarDataComQtAnos(Date pDataReferencia, int pQtAnos) {
		return BibliotecaFuncoesDataHora.deslocarData(pDataReferencia, Calendar.YEAR, pQtAnos);
	}

	/**
	 * -
	 *
	 * @param pData
	 *
	 * @return
	 */
	public static Date getDataComHoraInicialDia(Date pData) {
		Calendar calendario = Calendar.getInstance();

		calendario.setTime(pData);
		calendario.set(Calendar.HOUR_OF_DAY, 0);
		calendario.set(Calendar.MINUTE, 0);
		calendario.set(Calendar.SECOND, 0);
		calendario.set(Calendar.MILLISECOND, 0);

		return new Date(calendario.getTime().getTime());
	}

	/**
	 * -
	 *
	 * @param pData
	 *
	 * @return
	 */
	public static Date getDataComHoraFinalDia(Date pData) {
		Calendar calendario = Calendar.getInstance();

		calendario.setTime(pData);
		calendario.set(Calendar.HOUR_OF_DAY, 23);
		calendario.set(Calendar.MINUTE, 59);
		calendario.set(Calendar.SECOND, 59);
		calendario.set(Calendar.MILLISECOND, 999);

		return new Date(calendario.getTime().getTime());
	}

	/**
	 * -
	 *
	 * @param pTimestamp
	 *
	 * @return
	 *
	 * @throws ParseException
	 */
	public static boolean isHoraInicialDia(Timestamp pTimestamp)
		throws ParseException {
		String hora;

		if (pTimestamp == null) {
			return false;
		}

		hora = BibliotecaFuncoesDataHora.getTimestampComoHoraString(pTimestamp);

		if (hora.equals("00:00:00")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * -
	 *
	 * @param pHora
	 *
	 * @return
	 */
	public static boolean isHoraInicialDia(Time pHora) {
		String hora;

		if (pHora == null) {
			return false;
		}

		hora = BibliotecaFuncoesDataHora.getHoraComoString(pHora);

		if (hora.equals("00:00:00")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * -
	 *
	 * @param pTimestamp
	 *
	 * @return
	 *
	 * @throws ParseException
	 */
	public static boolean isHoraFinalDia(Timestamp pTimestamp)
		throws ParseException {
		String hora;

		if (pTimestamp == null) {
			return false;
		}

		hora = BibliotecaFuncoesDataHora.getTimestampComoHoraString(pTimestamp);

		if (hora.equals("23:59:59")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * -
	 *
	 * @param pHora
	 *
	 * @return
	 */
	public static boolean isHoraFinalDia(Time pHora) {
		String hora;

		if (pHora == null) {
			return false;
		}

		hora = BibliotecaFuncoesDataHora.getHoraComoString(pHora);

		if (hora.equals("23:59:59")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method getQtMeses. Retorna a quantidade de meses entre duas datas.
	 *
	 * @param pData1
	 * @param pData2
	 *
	 * @return int
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public static int getQtMeses(Date pData1, Date pData2)
		throws ExcecaoParametroInvalido {
		// verifica se os parametros sao validos
		if (pData1 == null) {
			throw new ExcecaoParametroInvalido("Parâmetro Inválido! pData1 = null");
		}

		if (pData2 == null) {
			throw new ExcecaoParametroInvalido("Parâmetro Inválido! pData2 = null");
		}

		int inComparacao = BibliotecaFuncoesDataHora.compararDatasSemHoras(pData1, pData2);
		int retorno;

		String dtMenor = "";
		String dtMaior = "";

		if (inComparacao == Constantes.CD_IGUAL) {
			return 0;
		} else if (inComparacao == Constantes.CD_MENOR) {
			dtMenor = BibliotecaFuncoesDataHora.getDataComoString(pData1);
			dtMaior = BibliotecaFuncoesDataHora.getDataComoString(pData2);
		} else if (inComparacao == Constantes.CD_MAIOR) {
			dtMenor = BibliotecaFuncoesDataHora.getDataComoString(pData2);
			dtMaior = BibliotecaFuncoesDataHora.getDataComoString(pData1);
		}

		int mes1 = Integer.parseInt(dtMenor.substring(3, 5));
		int ano1 = Integer.parseInt(dtMenor.substring(6));

		int mes2 = Integer.parseInt(dtMaior.substring(3, 5));
		int ano2 = Integer.parseInt(dtMaior.substring(6));

		if (ano2 == ano1) {
			retorno = mes2 - mes1;
		} else {
			int qtMesesFimAno1 = 12 - mes1;
			int qtMesesInicioAno2 = mes2;
			retorno = qtMesesFimAno1 + ((ano2 - ano1 - 1) * 12) + qtMesesInicioAno2;
		}

		return retorno;
	}

	/**
	 * -
	 *
	 * @param pDataInicial
	 * @param pDataFinal
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 */
	public static int getQtDias(Date pDataInicial, Date pDataFinal)
		throws ExcecaoGenerica {
		int qtDias;

		qtDias = (int) ((pDataFinal.getTime() - pDataInicial.getTime()) / (1000 * 60 * 60 * 24));

		return qtDias;
	}

	/**
	 * -
	 *
	 * @param pDataInicial
	 * @param pDataFinal
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 */
	public static int getQtMinutos(Date pDataInicial, Date pDataFinal)
		throws ExcecaoGenerica {
		int qtMinutos;

		qtMinutos = (int) ((pDataFinal.getTime() - pDataInicial.getTime()) / (1000 * 60));

		return qtMinutos;
	}

	/**
	 * -
	 *
	 * @param pDataInicial
	 * @param pDataFinal
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 */
	public static String getDuracao(java.util.Date pDataInicial, java.util.Date pDataFinal)
		throws ExcecaoGenerica {
		long duracao;
		int qtHoras;
		int qtMinutos;
		int qtSegundos;
		String resultado;

		duracao = pDataFinal.getTime() - pDataInicial.getTime();
		qtHoras = (int) (duracao / (1000 * 60 * 60));

		duracao = (duracao % (1000 * 60 * 60));
		qtMinutos = (int) (duracao / (1000 * 60));

		duracao = (duracao % (1000 * 60));
		qtSegundos = (int) (duracao / 1000);

		resultado = BibliotecaFuncoesPrincipal.completarNumeroComZerosEsquerda(qtHoras, 2) + ":" +
			BibliotecaFuncoesPrincipal.completarNumeroComZerosEsquerda(qtMinutos, 2) + ":" +
			BibliotecaFuncoesPrincipal.completarNumeroComZerosEsquerda(qtSegundos, 2);

		return resultado;
	}

	/**
	 * -
	 *
	 * @param pDataHoraInicial
	 * @param pDataHoraFinal
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 */
	public static int getQtMinutos(Timestamp pDataHoraInicial, Timestamp pDataHoraFinal)
		throws ExcecaoGenerica {
		int qtMinutos;

		qtMinutos = (int) ((pDataHoraFinal.getTime() - pDataHoraInicial.getTime()) / (1000 * 60));

		return qtMinutos;
	}

	/**
	 * -
	 *
	 * @param pDataHoraInicial
	 * @param pDataHoraFinal
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 */
	public static int getQtSegundos(Timestamp pDataHoraInicial, Timestamp pDataHoraFinal)
		throws ExcecaoGenerica {
		int qtSegundos;

		qtSegundos = (int) ((pDataHoraFinal.getTime() - pDataHoraInicial.getTime()) / (1000));

		return qtSegundos;
	}

	/**
	 * -
	 *
	 * @param pData
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 *
	 * @deprecated Usar os métodos na FachadaTGE.
	 */
	public static Date getProximoDiaUtil(Date pData) throws ExcecaoGenerica {
		// Declara variáveis
		Date retorno = null;

		retorno = BibliotecaFuncoesDataHora.avancarDataComQtDias(pData, 1);

		while (!isDiaFimSemana(retorno)) {
			retorno = BibliotecaFuncoesDataHora.avancarDataComQtDias(pData, 1);
		}

		return retorno;
	}

	/**
	 * -
	 *
	 * @param pDate
	 *
	 * @return
	 */
	public static boolean isDiaFimSemana(Date pDate) {
		Calendar calendario = Calendar.getInstance();

		// Cria calendário
		calendario.setTime(pDate);

		// Retorna verdadeiro se o dia for sábado ou domingo
		return ((calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) ||
			(calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY));
	}

	/**
	 * Integração com TGE não disponível
	 *
	 * @param pDataInicial
	 * @param pDataFinal
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 */
	public static int getQtDiasUteis(Date pDataInicial, Date pDataFinal)
		throws ExcecaoGenerica {
		int qtDiasUteis;

		qtDiasUteis = (int) ((pDataFinal.getTime() - pDataInicial.getTime()) / (1000 * 60 * 60 * 24));

		return qtDiasUteis;
	}

	/**
	 * -
	 *
	 * @param pData
	 * @param pMes
	 *
	 * @return
	 */
	public boolean isDataPertencenteAoMes(Date pData, String pMes) {
		boolean retorno = false;
		String strMes = "";

		if (pData != null) {
			strMes = BibliotecaFuncoesDataHora.getMesComoString(pData);

			if (strMes.equals(pMes)) {
				retorno = true;
			}
		}

		return retorno;
	}

	/**
	 * -
	 *
	 * @param pData
	 * @param pAno
	 *
	 * @return
	 */
	public boolean isDataPertencenteAoAno(Date pData, String pAno) {
		boolean retorno = false;
		String strAno = "";

		if (pData != null) {
			strAno = BibliotecaFuncoesDataHora.getAnoComoString(pData);

			if (strAno.equals(pAno)) {
				retorno = true;
			}
		}

		return retorno;
	}

	/**
	 * Utilizado dentro da JSP
	 *
	 * @param pDtMes Número inteiro relativo ao mês: 1-Janeiro, 2-Fevereiro, etc...
	 *
	 * @return Constante que representa a chave do mês: Constantes.CD_MES_JANEIRO, Constantes.CD_MES_FEVEREIRO, etc...
	 */
	public static String getIntComoCdMes(int pDtMes) {
		String retorno = "";

		if (pDtMes == 1) {
			retorno = Constantes.CD_MES_JANEIRO;
		} else if (pDtMes == 2) {
			retorno = Constantes.CD_MES_FEVEREIRO;
		} else if (pDtMes == 3) {
			retorno = Constantes.CD_MES_MARCO;
		} else if (pDtMes == 4) {
			retorno = Constantes.CD_MES_ABRIL;
		} else if (pDtMes == 5) {
			retorno = Constantes.CD_MES_MAIO;
		} else if (pDtMes == 6) {
			retorno = Constantes.CD_MES_JUNHO;
		} else if (pDtMes == 7) {
			retorno = Constantes.CD_MES_JULHO;
		} else if (pDtMes == 8) {
			retorno = Constantes.CD_MES_AGOSTO;
		} else if (pDtMes == 9) {
			retorno = Constantes.CD_MES_SETEMBRO;
		} else if (pDtMes == 10) {
			retorno = Constantes.CD_MES_OUTUBRO;
		} else if (pDtMes == 11) {
			retorno = Constantes.CD_MES_NOVEMBRO;
		} else if (pDtMes == 12) {
			retorno = Constantes.CD_MES_DEZEMBRO;
		}

		return retorno;
	}

	/**
	 * Utilizado dentro da JSP
	 *
	 * @param pCdMes Constante que representa a chave do mês: Constantes.CD_MES_JANEIRO, Constantes.CD_MES_FEVEREIRO, etc...
	 *
	 * @return Número inteiro relativo ao mês: 1-Janeiro, 2-Fevereiro, etc...
	 */
	public static int getCdMesComoInt(String pCdMes) {
		int retorno = 0;

		if (pCdMes.equals(Constantes.CD_MES_JANEIRO)) {
			retorno = 1;
		} else if (pCdMes.equals(Constantes.CD_MES_FEVEREIRO)) {
			retorno = 2;
		} else if (pCdMes.equals(Constantes.CD_MES_MARCO)) {
			retorno = 3;
		} else if (pCdMes.equals(Constantes.CD_MES_ABRIL)) {
			retorno = 4;
		} else if (pCdMes.equals(Constantes.CD_MES_MAIO)) {
			retorno = 5;
		} else if (pCdMes.equals(Constantes.CD_MES_JUNHO)) {
			retorno = 6;
		} else if (pCdMes.equals(Constantes.CD_MES_JULHO)) {
			retorno = 7;
		} else if (pCdMes.equals(Constantes.CD_MES_AGOSTO)) {
			retorno = 8;
		} else if (pCdMes.equals(Constantes.CD_MES_SETEMBRO)) {
			retorno = 9;
		} else if (pCdMes.equals(Constantes.CD_MES_OUTUBRO)) {
			retorno = 10;
		} else if (pCdMes.equals(Constantes.CD_MES_NOVEMBRO)) {
			retorno = 11;
		} else if (pCdMes.equals(Constantes.CD_MES_DEZEMBRO)) {
			retorno = 12;
		}

		return retorno;
	}

	/**
	 * Retorna o dia da semana para tipo java.sql.Date
	 *
	 * @param pData Data no formato "dd/MM/aaaa"
	 *
	 * @return
	 *
	 * @exception ExcecaoParametroInvalido
	 */
	public static int getNuDiaSemana(Date pData) throws ExcecaoParametroInvalido {
		int nuDia = 0;
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(pData);
		nuDia = calendar.get(Calendar.DAY_OF_WEEK);

		return nuDia;
	}

	/**
	 * Retorna a descricao do dia da semana para tipo java.sql.Date
	 *
	 * @param pData Data no formato "dd/MM/aaaa"
	 *
	 * @return
	 *
	 * @exception ExcecaoParametroInvalido
	 */
	public static String getNmDiaSemana(Date pData) throws ExcecaoParametroInvalido {
		int nuDia = 0;
		String nmDia = "";

		nuDia = BibliotecaFuncoesDataHora.getNuDiaSemana(pData);
		nmDia = getNmDia(nuDia);

		return nmDia;
	}

	//~ Classes Internas -----------------------------------------------------------------------------------------------------------

	/**
	 * 
	  */
	private static final class FormatoData {
		//~ Atributos de instancia -------------------------------------------------------------------------------------------------

		private SimpleDateFormat anoComoString;
		private SimpleDateFormat dataComoString;
		private SimpleDateFormat dataComoStringAnoMes;
		private SimpleDateFormat dataComoStringDiaMes;
		private SimpleDateFormat dataComoStringInvertida;
		private SimpleDateFormat dataComoStringInvertidaComHifen;
		private SimpleDateFormat dataComoStringMesAno;
		private SimpleDateFormat dataComoStringMesDia;
		private SimpleDateFormat dataHoraComoString;
		private SimpleDateFormat dataHoraComoStringComMilis;
		private SimpleDateFormat dataHoraComoStringInvertida;
		private SimpleDateFormat diaComoString;
		private SimpleDateFormat horaComoString;
		private SimpleDateFormat horaComoStringComMilis;
		private SimpleDateFormat horaComoStringSemMascara;
		private SimpleDateFormat horaComoStringSemSegundos;
		private SimpleDateFormat horaComoStringSemSegundosSemMascara;
		private SimpleDateFormat mesComoString;

		//~ Metodos ----------------------------------------------------------------------------------------------------------------

		/**
		 * -
		 *
		 * @return  
		 */
		protected SimpleDateFormat getDataComoString() {
			SimpleDateFormat formatador = this.dataComoString;

			if (formatador == null) {
				this.dataComoString = formatador = new SimpleDateFormat("dd/MM/yyyy");
			}

			return formatador;
		}

		/**
		 * -
		 *
		 * @return  
		 */
		protected SimpleDateFormat getDataComoStringInvertida() {
			SimpleDateFormat formatador = this.dataComoStringInvertida;

			if (formatador == null) {
				this.dataComoStringInvertida = formatador = new SimpleDateFormat("yyyyMMdd");
			}

			return formatador;
		}

		/**
		 * -
		 *
		 * @return  
		 */
		protected SimpleDateFormat getHoraComoStringComMilis() {
			SimpleDateFormat formatador = this.horaComoStringComMilis;

			if (formatador == null) {
				this.horaComoStringComMilis = formatador = new SimpleDateFormat("HH:mm:ss:SSS");
			}

			return formatador;
		}

		/**
		 * -
		 *
		 * @return  
		 */
		protected SimpleDateFormat getDataComoStringMesAno() {
			SimpleDateFormat formatador = this.dataComoStringMesAno;

			if (formatador == null) {
				this.dataComoStringMesAno = formatador = new SimpleDateFormat("MM/yyyy");
			}

			return formatador;
		}

		/**
		 * -
		 *
		 * @return  
		 */
		protected SimpleDateFormat getDataComoStringAnoMes() {
			SimpleDateFormat formatador = this.dataComoStringAnoMes;

			if (formatador == null) {
				this.dataComoStringAnoMes = formatador = new SimpleDateFormat("yyyyMM");
			}

			return formatador;
		}

		/**
		 * -
		 *
		 * @return  
		 */
		protected SimpleDateFormat getDataComoStringDiaMes() {
			SimpleDateFormat formatador = this.dataComoStringDiaMes;

			if (formatador == null) {
				this.dataComoStringDiaMes = formatador = new SimpleDateFormat("dd/MM");
			}

			return formatador;
		}

		/**
		 * -
		 *
		 * @return  
		 */
		protected SimpleDateFormat getDataComoStringMesDia() {
			SimpleDateFormat formatador = this.dataComoStringMesDia;

			if (formatador == null) {
				this.dataComoStringMesDia = formatador = new SimpleDateFormat("MMdd");
			}

			return formatador;
		}

		/**
		 * -
		 *
		 * @return  
		 */
		protected SimpleDateFormat getDiaComoString() {
			SimpleDateFormat formatador = this.diaComoString;

			if (formatador == null) {
				this.diaComoString = formatador = new SimpleDateFormat("dd");
			}

			return formatador;
		}

		/**
		 * -
		 *
		 * @return  
		 */
		protected SimpleDateFormat getMesComoString() {
			SimpleDateFormat formatador = this.mesComoString;

			if (formatador == null) {
				this.mesComoString = formatador = new SimpleDateFormat("MM");
			}

			return formatador;
		}

		/**
		 * -
		 *
		 * @return  
		 */
		protected SimpleDateFormat getAnoComoString() {
			SimpleDateFormat formatador = this.anoComoString;

			if (formatador == null) {
				this.anoComoString = formatador = new SimpleDateFormat("yyyy");
			}

			return formatador;
		}

		/**
		 * -
		 *
		 * @return  
		 */
		protected SimpleDateFormat getDataHoraComoString() {
			SimpleDateFormat formatador = this.dataHoraComoString;

			if (formatador == null) {
				this.dataHoraComoString = formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			}

			return formatador;
		}
		
		/**
		 * -
		 *
		 * @return  
		 */
		protected SimpleDateFormat getDataHoraComoStringComMilis() {
			SimpleDateFormat formatador = this.dataHoraComoStringComMilis;

			if (formatador == null) {
				this.dataHoraComoStringComMilis = formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS");
			}

			return formatador;
		}

		/**
		 * -
		 *
		 * @return  
		 */
		protected SimpleDateFormat getDataHoraComoStringInvertida() {
			SimpleDateFormat formatador = this.dataHoraComoStringInvertida;

			if (formatador == null) {
				this.dataHoraComoStringInvertida = formatador = new SimpleDateFormat("yyyyMMddHHmmss");
			}

			return formatador;
		}

		/**
		 * -
		 *
		 * @return  
		 */
		protected SimpleDateFormat getHoraComoString() {
			SimpleDateFormat formatador = this.horaComoString;

			if (formatador == null) {
				this.horaComoString = formatador = new SimpleDateFormat("HH:mm:ss");
			}

			return formatador;
		}

		/**
		 * -
		 *
		 * @return  
		 */
		protected SimpleDateFormat getHoraComoStringSemSegundos() {
			SimpleDateFormat formatador = this.horaComoStringSemSegundos;

			if (formatador == null) {
				this.horaComoStringSemSegundos = formatador = new SimpleDateFormat("HH:mm");
			}

			return formatador;
		}

		/**
		 * -
		 *
		 * @return  
		 */
		protected SimpleDateFormat getHoraComoStringSemMascara() {
			SimpleDateFormat formatador = this.horaComoStringSemMascara;

			if (formatador == null) {
				this.horaComoStringSemMascara = formatador = new SimpleDateFormat("HHmmss");
			}

			return formatador;
		}

		/**
		 * -
		 *
		 * @return  
		 */
		protected SimpleDateFormat getHoraComoStringSemSegundosSemMascara() {
			SimpleDateFormat formatador = this.horaComoStringSemSegundosSemMascara;

			if (formatador == null) {
				this.horaComoStringSemSegundosSemMascara = formatador = new SimpleDateFormat("HHmm");
			}

			return formatador;
		}

		/**
		 * -
		 *
		 * @return  
		 */
		protected SimpleDateFormat getDataComoStringInvertidaComHifen() {
			SimpleDateFormat formatador = this.dataComoStringInvertidaComHifen;

			if (formatador == null) {
				this.dataComoStringInvertidaComHifen = formatador = new SimpleDateFormat("yyyy-MM-dd");
			}

			return formatador;
		}
	}
}
