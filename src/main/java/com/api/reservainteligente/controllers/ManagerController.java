package com.api.reservainteligente.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.reservainteligente.dtos.ManagerDto;
import com.api.reservainteligente.entities.Manager;
import com.api.reservainteligente.response.Response;
import com.api.reservainteligente.services.ManagerService;

@RestController
@RequestMapping(value = "/api/manager")
public class ManagerController {

	private static final Logger log = LoggerFactory.getLogger(ManagerController.class);

	@Autowired
	private ManagerService managerService;
	
	public ManagerController() {
	}
	
	@PostMapping
	public ResponseEntity<Response<ManagerDto>> register(
			@Valid @RequestBody ManagerDto managerDto, 
			BindingResult result){
		
		log.info("Cadastrando novo Manager");
		Response<ManagerDto> response = new Response<ManagerDto>();
		
		managerService.isValidManager(managerDto.getCpf(), managerDto.getEmail(), result);
		
		if(result.hasErrors()) {
			log.info("Erro ao salvar Manager com CPF {}", managerDto.getCpf());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Manager manager = Manager.getInstace(managerDto);
		managerService.persist(manager);
		response.setData(ManagerDto.getInstace(manager));
		return ResponseEntity.ok(response);
	}
	
}
