package com.api.reservainteligente.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	/**Action responsável pelo registro de novos Managers
	 * 
	 * @param managerDto
	 * @param result
	 * @return ResponseEntity<Response<ManagerDto>> 
	 */
	@PostMapping
	public ResponseEntity<Response<ManagerDto>> register(
			@Valid @RequestBody ManagerDto managerDto, 
			BindingResult result){
		
		log.info("Cadastrando novo Manager");
		Response<ManagerDto> response = new Response<ManagerDto>();
		
		managerService.isNewCpf(managerDto.getCpf(), result);
		
		if(result.hasErrors()) {
			log.info("Erro ao salvar Manager com CPF {}", managerDto.getCpf());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Manager manager = Manager.getInstace(managerDto);
		managerService.persist(manager);
		response.getMessages().add("Manager salvo com sucesso");
		response.setData(ManagerDto.getInstace(manager));
		return ResponseEntity.ok(response);
	}
	
	/**Action responsável por excluir um Manager
	 * 
	 * @param id
	 * @return ResponseEntity<Response<String>>
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Response<String>> exclude(@PathVariable("id") Long id){
		log.info("Excluindo Manager de ID {}", id);
		Response<String> response = new Response<String>();
		Optional<Manager> manager = managerService.findById(id);
		
		if(!manager.isPresent()) {
			log.info("Erro ao excluir Manager de ID {}", id);
			response.getErrors().add("Manager não encontrado com ID " + id);
			return ResponseEntity.badRequest().body(response);
		}

		managerService.remove(id);
		response.getMessages().add("Manager removido com sucesso.");
		return ResponseEntity.ok(response);
	}
	
	/**Action responsável por alterar um Manager
	 * 
	 * @param id
	 * @param managerDto
	 * @param result
	 * @return ResponseEntity<Response<ManagerDto>>
	 */
	@PutMapping(value = "/{managerId}")
	public ResponseEntity<Response<ManagerDto>> update(
			@PathVariable("managerId") Long managerId, 
			@Valid @RequestBody ManagerDto managerDto,
			BindingResult result){
		
		log.info("Atualizando Manager de ID {}", managerId);
		Response<ManagerDto> response = new Response<ManagerDto>();
		managerDto.setId(managerId);
		Manager manager = managerService.getInstanceOfManagerWhenUpdate(managerDto, result);
				
		if (manager == null) {
			log.info("Erro ao atualizar Manager");
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		managerService.persist(manager);
		response.setData(ManagerDto.getInstace(manager));
		return ResponseEntity.ok(response);
	}
	
}
