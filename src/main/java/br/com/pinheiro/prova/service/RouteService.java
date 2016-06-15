package br.com.pinheiro.prova.service;

import java.util.List;

import br.com.pinheiro.prova.model.Route;

public interface RouteService {

	public void add(Route route);

	public void edit(Route route);

	public void delete(int id);

	public Route find(int id);

	public List<Route> getAll();
}
