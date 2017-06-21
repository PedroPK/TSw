package tsw.teste.t13.finals.dVictor;


public class Triangulo implements iTriangulo {
	 private Double a; 
	 private Double b;
	 private Double c;
	 
	 public Double getA(){
		return this.a;
	 }
	 public void setA(Double a){
		this.a = a;
	 }
	 
	 
	 
	 
	 public Double getB(){
		return this.b;
	 }
	 public void setB(Double b){
		this.b = b;
	 }
		 
	 
	 
	 public Double getC(){
		return this.a;
	 }
	 public void setC(Double c){
		this.c = c;
	 }
	 
	 
	 
	
	public Triangulo(Double a, Double b, Double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public Triangulo(){}

	
	public void validarTamanhoLado(Double pTamanhoLado) throws Exception{
		if(pTamanhoLado < 0.0)
			throw new Exception("Tamanho do lado nao pode ser menor que 0.0");
		if(pTamanhoLado.equals(null))
			throw new Exception("Voce deve informar um valor");
	}
	public void validarTodosOsLados()throws Exception{
		if(a < 0.0 && b < 0.0 && c < 0.0)
			throw new Exception("Tamanho do lado nao pode ser menor que 0.0");
		if(a.equals(null) || b.equals(null) || c.equals(null))
			throw new Exception("Voce deve informar um valor");
	}
	public boolean isTamanhoLadoValido(Double pTamanhoLado) throws Exception{
		boolean resul = false;
		if(pTamanhoLado > 0.0){
			resul = true;
			//throw new Exception("Tamanho do lado nao pode ser menor que 0.0");
		}	
		else if(!pTamanhoLado.equals(null)){
			resul = true;
			//throw new Exception("Voce deve informar um valor");
		}	
		return resul;
	}
	
	
	
	/* Métodos de Situaçao */
	
	public boolean isEquilatero(){// tres lados iguais
		boolean resul = false;
		if(a.equals(b) && b.equals(c) && c.equals(a)){
			resul = true;
		}
		else if(!a.equals("") || !b.equals("") || !c.equals(""))
			resul = true;
		else if(a > 0.0 || b > 0.0 || c > 0.0)
			resul = true;
		return resul;
	}
	
	
	
	
	public boolean isIsosceles(){//dois lados iguais
		boolean resul = false;
		if(a.equals(b) && !b.equals(c))
			resul = true;
		else if(!a.equals("") || !b.equals("") || !c.equals(""))
			resul = true;
		else if(a > 0.0 || b > 0.0 || c > 0.0)
			resul = true;
		return resul;		
	}
	
	
	
	
	public boolean isEscaleno(){//tres lados diferente
		boolean resul = false;
		if(!a.equals(b) && !b.equals(c) && !c.equals(a))
			resul = true;
		else if(!a.equals("") || !b.equals("") || !c.equals(""))
			resul = true;
		else if(a > 0.0 || b > 0.0 || c > 0.0)
			resul = true;
		return resul;
	}
	
	
	
	
	
	public boolean isTrianguloValido(){
		boolean resul = false;
		if(!a.equals("") || !b.equals("") || !c.equals(""))
			resul = true;
		return resul;
	}
	
	
	
	public boolean isTresLadosvalidos(){
		boolean resul = false;		
		if(!a.equals("") || !b.equals("") || !c.equals(""))
			resul = true;
		else if(a > 0.0 || b > 0.0 || c > 0.0)
			resul = true;
		return resul;
	}
	public boolean isTrianguloRetangulo(){
		boolean resul = false;		
		if(!a.equals("") || !b.equals("") || !c.equals(""))
			resul = true;
		return resul;
	}
}
