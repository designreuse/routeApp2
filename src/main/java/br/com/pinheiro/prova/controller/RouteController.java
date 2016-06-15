package br.com.pinheiro.prova.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.pinheiro.prova.model.Route;
import br.com.pinheiro.prova.service.RouteService;

@Controller
@RequestMapping("/route")
public class RouteController {
	
	@Autowired
	private RouteService service;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/list", method = RequestMethod.GET, headers = "Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<Route>> list() {
		return new ResponseEntity<>(getService().getAll(), HttpStatus.ACCEPTED);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void add(Route route) {
		getService().add(route);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/edit", method = RequestMethod.PUT, headers = "Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void edit(Route route) {
		getService().edit(route);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/remove", method = RequestMethod.DELETE, headers = "Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void remove(Route route) {
		getService().delete(route.getId());
	}
	
	public RouteService getService() {
		return service;
	}

}
