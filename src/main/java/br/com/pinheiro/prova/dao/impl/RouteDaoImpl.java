package br.com.pinheiro.prova.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.pinheiro.prova.dao.RouteDao;
import br.com.pinheiro.prova.model.Route;

@Repository
public class RouteDaoImpl implements RouteDao {

	@PersistenceContext(unitName = "routeAppPU")
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public void add(Route route) {
		getEntityManager().persist(route);
	}

	@Override
	public void edit(Route route) {
		getEntityManager().merge(route);
	}

	@Override
	public void delete(int id) {
		getEntityManager().remove(find(id));
	}

	@Override
	public Route find(int id) {
		return getEntityManager().find(Route.class, id);
	}

	@Override
	public List<Route> getAll() {
		String sql = "FROM Route";
		Query query = getEntityManager().createQuery(sql);
		List<Route> lista = query.getResultList();
		return lista;
	}

}
