package tsw.t08.persistencia;

import java.util.Collection;

import tsw.t08.entidades.Passageiro;

public interface IPassageiroDAO extends InterfaceDAO {
	
	public Passageiro consultar(Object pChavePrimaria);
	
	public Collection<Passageiro> consultar();
	
}