package com.ashraf.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashraf.library.entity.Client;
import com.ashraf.library.services.ClientService;


@CrossOrigin(origins = "https://nationallibrary-13f4b.web.app", maxAge = 3600)
@RestController
public class ClientRestController {

	private ClientService clientService;
	
	// quick and dirty use constructor injection for employeeDao
	@Autowired
	public ClientRestController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@GetMapping("/clients")
	public List<Client> findAll(){

		return clientService.findAll();
	}
	
	@GetMapping("/clients/{id}")
	public Client getClient(@PathVariable int id){
		
		return clientService.findClient(id);
	}
	
	@PostMapping("/clients")
	public Client save(@RequestBody Client client){
		System.out.println(client);
		return clientService.save(client);
	}
	
}
