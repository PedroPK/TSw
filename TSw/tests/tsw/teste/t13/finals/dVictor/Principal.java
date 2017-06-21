package tsw.teste.t13.finals.dVictor;


public class Principal {
	public static void main(String[] args) throws Exception{
		Triangulo triangulo = new Triangulo(10.0,10.0,10.0);
		//triangulo.isEquilatero();
		//triangulo.isEscaleno();
		//triangulo.isIsosceles();
		
		System.out.println("isoceles :" +triangulo.isIsosceles());//dois lados iguais
		System.out.println("Equilatero :" + triangulo.isEquilatero());//tres lados iguais
		System.out.println("Escaleno :" + triangulo.isEscaleno());//tres lados diferentes
		System.out.println("Validar Lado :" + triangulo.isTamanhoLadoValido(null));
		
		
	}
}
