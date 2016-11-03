package tsw.t08.persistencia;

import java.util.Collection;

import tsw.t08.entidades.Passageiro;

public class PassageiroDAO extends AbstractDAO implements IPassageiroDAO {
	
	public static final String NAMED_QUERY_CONSULTAR_TODOS_PASSAGEIROS = "CONSULTAR_TODOS_PASSAGEIROS";
	
	public Passageiro consultar(Object pChavePrimaria) {
		Passageiro registro = 
			(Passageiro) super.consultarPorChavePrimaria(
							Passageiro.class, 
							pChavePrimaria);
		
		return registro;
	}
	
	public Collection<Passageiro> consultar() {
		return 
			super.consultarNamedQuery(
				NAMED_QUERY_CONSULTAR_TODOS_PASSAGEIROS, 
				Passageiro.class);
	}
	
}