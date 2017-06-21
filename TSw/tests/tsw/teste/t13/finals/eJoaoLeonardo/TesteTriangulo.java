package tsw.teste.t13.finals.eJoaoLeonardo;
// email: prof.pcfs@gmail.com

//Assunt: TSw - 2017.1 - Prova Final - [JOÃO LEONARDO MARQUES DE ABREU E SILVA]

public class TesteTriangulo {
	public static void main(String[] args) {
		Triangulo t1 = new Triangulo(1.0, 2.0, 3.0);
		System.out.println("validarTamanhoLado");
		System.out.println("----------------------");
		t1.validarTamanhoLado(null);
		System.out.println("\n");

		Triangulo t2 = new Triangulo(1.0, 2.0, 3.0);
		System.out.println("validarTodosOsLados");
		System.out.println("----------------------");
		t2.validarTodosOsLados();
		System.out.println("\n");

		Triangulo t3 = new Triangulo(1.0, 2.0, 3.0);
		System.out.println("isTamanhoLadoValido");
		System.out.println("----------------------");
		Double pTamanhoLado = null;
		System.out.println(t3.isTamanhoLadoValido(pTamanhoLado));
		System.out.println("\n");

		Triangulo t4 = new Triangulo(1.0, 2.0, 3.0);
		System.out.println("isEquilatero");
		System.out.println("----------------------");
		System.out.println(t4.isEquilatero());
		System.out.println("\n");

		Triangulo t5 = new Triangulo(1.0, 2.0, 3.0);
		System.out.println("isIsosceles");
		System.out.println("----------------------");
		System.out.println(t5.isIsosceles());
		System.out.println("\n");

		Triangulo t6 = new Triangulo(1.0, 2.0, 3.0);
		System.out.println("isEscaleno");
		System.out.println("----------------------");
		System.out.println(t6.isEscaleno());
		System.out.println("\n");

		Triangulo t7 = new Triangulo(1.0, 2.0, 3.0);
		System.out.println("isTrianguloValido");
		System.out.println("----------------------");
		System.out.println(t7.isTrianguloValido());
		System.out.println("\n");

		Triangulo t8 = new Triangulo(1.0, 2.0, 3.0);
		System.out.println("isTresLadosValidos");
		System.out.println("----------------------");
		System.out.println(t8.isTresLadosValidos());
		System.out.println("\n");

		Triangulo t9 = new Triangulo(1.0, 2.0, 3.0);
		System.out.println("isTrianguloRetangulo");
		System.out.println("----------------------");
		System.out.println(t9.isTrianguloRetangulo());
	}
}