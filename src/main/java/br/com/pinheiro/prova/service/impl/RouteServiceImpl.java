package br.com.pinheiro.prova.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pinheiro.prova.dao.RouteDao;
import br.com.pinheiro.prova.model.Route;
import br.com.pinheiro.prova.service.RouteService;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteDao dao;
	
	@Transactional
	public void add(Route route) {
		getDao().add(route);
	}

	@Transactional
	public void edit(Route route) {
		getDao().edit(route);
	}

	@Transactional
	public void delete(int id) {
		getDao().delete(id);
	}

	@Transactional
	public Route find(int id) {
		return getDao().find(id);
	}

	@Transactional
	public List<Route> getAll() {
		return getDao().getAll();
	}

	public RouteDao getDao() {
		return dao;
	}

}
