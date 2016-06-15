package br.com.pinheiro.prova.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.pinheiro.prova.model.Route;
import br.com.pinheiro.prova.service.RouteService;

@Controller
public class RouteWebController {

	@Autowired
	private RouteService service;

	@RequestMapping("/index")
	public String setupForm(Map<String, Object> map) {
		Route route = new Route();
		map.put("route", route);
		map.put("routes", getService().getAll());
		return "route";
	}
	
	@RequestMapping(value="/route.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Route route, BindingResult result, @RequestParam String action, Map<String, Object> map){
		Route routeResult = new Route();
		switch(action.toLowerCase()){
		case "add":
			getService().add(route);
			routeResult = route;
			break;
		case "edit":
			getService().edit(route);
			routeResult = route;
			break;
		case "delete":
			getService().delete(route.getId());
			routeResult = route;
			break;
		case "search":
			Route searchedRoute= getService().find(route.getId());
			routeResult = searchedRoute !=null ? searchedRoute : new Route();
			break;
		}
		map.put("route", routeResult);
		map.put("routes", getService().getAll());
		return "student";
	}

	public RouteService getService() {
		return service;
	}

}
