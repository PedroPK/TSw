package tsw.teste.t13.finals.eJoaoLeonardo;

public class Triangulo implements iTriangulo {

	private Double l1;
	private Double l2;
	private Double l3;

	public Triangulo(Double l1, Double l2, Double l3) {
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;

	}

	@Override
	public void validarTamanhoLado(Double pTamanhoLado) {

	}

	@Override
	public void validarTodosOsLados() {
		if ((l1 < l2 + l3) && (l2 < l1 + l3) && (l3 < l1 + l2)) {
			System.out.println("Todos os Lados Estão Validados");
		} else {
			System.out.println("Todos os Lados não são Válidos");
		}
	}

	@Override
	public boolean isTamanhoLadoValido(Double pTamanhoLado) {
		if ((l1 != 0) && (l2 != 0) && (l3 != 0)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isEquilatero() {

		if (l1 == l2 && l1 == l3) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isIsosceles() {

		if ((l1 == l2) || (l1 == l3)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean isEscaleno() {

		if ((l1 == l2 && l1 == l3) && ((l1 == l2) || (l1 == l3))) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public boolean isTrianguloValido() {
		if ((l1 < l2 + l3) && (l2 < l1 + l3) && (l3 < l1 + l2)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean isTresLadosValidos() {
		if (l1 == 0 || l2 == 0 || l3 == 0) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public boolean isTrianguloRetangulo() {

		return false;
	}

}
