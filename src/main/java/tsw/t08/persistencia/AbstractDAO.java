package tsw.t08.persistencia;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import tsw.t08.entidades.Entidade;
import tsw.util.UtilJPA;

public abstract class AbstractDAO implements InterfaceDAO {
	
	/**
	 * M�todos para Inserir uma Entidade 
	 */
	public void inserir(Entidade pEntidade) {
		inserir(pEntidade, UtilJPA.getEntityManager(), true);
	}
	
	public void inserir(Entidade pEntidade, EntityManager pEntityManager, boolean pFecharEntityManager) {
		EntityTransaction transacao = pEntityManager.getTransaction();
		transacao.begin();
		
		pEntityManager.persist(pEntidade);
		
		transacao.commit();
		
		if ( pFecharEntityManager ) {
			pEntityManager.close();
		}
	}
	
	/**
	 * M�todos para Alterar uma Entidade
	 */
	public void alterar(Entidade pEntidade) {
		alterar(pEntidade, UtilJPA.getEntityManager(), true);
	}
	
	public void alterar(Entidade pEntidade, EntityManager pEntityManager, boolean pFecharEntityManager) {
		EntityTransaction transacao = pEntityManager.getTransaction();
		transacao.begin();
		
		pEntityManager.merge(pEntidade);
		
		transacao.commit();
		
		if ( pFecharEntityManager ) {
			pEntityManager.close();
		}
	}
	
	/**
	 * M�todos para Excluir uma Entidade
	 */
	public void excluirPorObjeto(Entidade pEntidade) {
		excluirPorObjeto(pEntidade, UtilJPA.getEntityManager(), true);
	}
	public void excluirPorObjeto(
		Entidade		pEntidade, 
		EntityManager	pEntityManager, 
		boolean			pFecharEntityManager
	) {
		EntityTransaction transacao = pEntityManager.getTransaction();
		transacao.begin();
		
		Object registro = pEntityManager.find(pEntidade.getClass(), pEntidade.getChavePrimaria());
		pEntityManager.remove(registro);
		
		transacao.commit();
		
		if ( pFecharEntityManager ) {
			pEntityManager.close();
		}
	}
	
	/**
	 * TODO Vai dar erro!
	 * 
	 * @param pClasse
	 * @param pEntidade
	 * @param pEntityManager
	 * @param pFecharEntityManager
	 */
	public void excluirPorObjetoSemConsultarAntes(
		Entidade		pEntidade, 
		EntityManager	pEntityManager, 
		boolean			pFecharEntityManager
	) {
		EntityTransaction transacao = pEntityManager.getTransaction();
		transacao.begin();
		
		pEntityManager.remove(pEntidade);
		
		transacao.commit();
		
		if ( pFecharEntityManager ) {
			pEntityManager.close();
		}
	}
	
	/**
	 * M�todos para Exclusão por Chave Primária
	 */
	public void excluirPorChavePrimaria(Class pClasse, Object pChavePrimaria) {
		excluirPorChavePrimaria(pClasse, pChavePrimaria, UtilJPA.getEntityManager(), true);
	}
	public void excluirPorChavePrimaria(
		Class			pClasse, 
		Object			pChavePrimaria, 
		EntityManager	pEntityManager, 
		boolean			pFecharEntityManager
	) {
		EntityTransaction transacao = pEntityManager.getTransaction();
		transacao.begin();
		
		Object registro = pEntityManager.find(pClasse, pChavePrimaria);
		pEntityManager.remove(registro);
		
		transacao.commit();
		if ( pFecharEntityManager ) {
			pEntityManager.close();
		}
	}
	public void excluirPorChavePrimaria(
		Class				pClasse, 
		Object				pChavePrimaria, 
		EntityManager		pEntityManager, 
		EntityTransaction	pTransacao,
		boolean				pFecharEntityManager
	) {
		EntityTransaction transacao = pEntityManager.getTransaction();
		transacao.begin();
		
		Object registro = pEntityManager.find(pClasse, pChavePrimaria);
		pEntityManager.remove(registro);
		
		transacao.commit();
		if ( pFecharEntityManager ) {
			pEntityManager.close();
		}
	}
	
	/**
	 * M�todos para Consultar uma Entidade por Chave-Primária
	 */
	public Entidade consultarPorChavePrimaria(Class pClasse, Object pPrimaryKey) {
		return consultarPorChavePrimaria(pClasse, pPrimaryKey, UtilJPA.getEntityManager(), true);
	}
	public Entidade consultarPorChavePrimaria(Class pClasse, Object pPrimaryKey, EntityManager pEntityManager, boolean pFecharEntityManager) {
		Entidade registro = (Entidade) pEntityManager.find(pClasse, pPrimaryKey);
		
		if ( pFecharEntityManager ) {
			pEntityManager.close();
		}
		
		return registro;
	}
	
	/*
	 * (non-Javadoc)
	 * @see br.unibratec.persistencia.InterfaceDAO#consultarPorObjeto(br.unibratec.entidades.Entidade)
	 */
	public Entidade consultarPorObjeto(Entidade pEntidade) {
		return consultarPorObjeto(pEntidade, UtilJPA.getEntityManager(), true);
	}
	public Entidade consultarPorObjeto(Entidade pEntidade, EntityManager pEntityManager, boolean pFecharEntityManager) {
		Entidade registro = (Entidade) pEntityManager.find(pEntidade.getClass(), pEntidade.getChavePrimaria());
		
		if ( pFecharEntityManager ) {
			pEntityManager.close();
		}
		
		return registro;
	}
	
	@SuppressWarnings("unchecked")
	public Collection consultarNamedQuery(String pNamedQuery, Class pTipoRetorno) {
		EntityManager manager = UtilJPA.getEntityManager();
		TypedQuery<Entidade> typedQuery = manager.createNamedQuery(pNamedQuery, pTipoRetorno);
		Collection<Entidade> resultSet = typedQuery.getResultList();
		
		return resultSet;
	}
	
}