package br.com.pinheiro.prova.dao;

import java.util.List;

import br.com.pinheiro.prova.model.Route;

public interface RouteDao {

	public void add(Route route);

	public void edit(Route route);

	public void delete(int id);

	public Route find(int id);

	public List<Route> getAll();

}
