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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.reservainteligente.dtos.AirCompanyDto;
import com.api.reservainteligente.entities.AirCompany;
import com.api.reservainteligente.entities.Manager;
import com.api.reservainteligente.response.Response;
import com.api.reservainteligente.services.AirCompanyService;

@RestController
@RequestMapping(value = "/aircompany")
public class AirCompanyController {

	private static final Logger log = LoggerFactory.getLogger(ManagerController.class);
	
	@Autowired
	private AirCompanyService airCompanyService;
	
	public AirCompanyController() {
	}
	
	/**Action responsável pelo registro de novas AirCompanys
	 * 
	 * @param airCompanyDto
	 * @param result
	 * @return response
	 */
	@PostMapping
	public ResponseEntity<Response<AirCompanyDto>> register(
			@Valid @RequestBody AirCompanyDto airCompanyDto, 
			BindingResult result){
		
		log.info("Cadastrando nova AirCompany");
		Response<AirCompanyDto> response = new Response<AirCompanyDto>();
		
		airCompanyService.isNewCnpj(airCompanyDto.getCnpj(), result);
		
		if(result.hasErrors()) {
			log.info("Erro ao salvar AirCompany com CNPJ {}", airCompanyDto.getCnpj());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		AirCompany airCompany = AirCompany.getInstance(airCompanyDto);
		airCompanyService.persist(airCompany);
		response.getMessages().add("AirCompany salva com sucesso");
		response.setData(AirCompanyDto.getInstance(airCompany));
		return ResponseEntity.ok(response);
	}
	
	/**Action responsável por excluir uma AirCompany
	 * 
	 * @param id
	 * @return ResponseEntity<Response<String>>
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Response<String>> exclude(@PathVariable("id") Long id){
		log.info("Excluindo AirCompany de ID {}", id);
		Response<String> response = new Response<String>();
		Optional<AirCompany> airCompany = airCompanyService.findById(id);
		
		if(!airCompany.isPresent()) {
			log.info("Erro ao excluir AirCompany de ID {}", id);
			response.getErrors().add("AirCompany não encontrada com ID " + id);
			return ResponseEntity.badRequest().body(response);
		}

		airCompanyService.remove(id);
		response.getMessages().add("AirCompany removida com sucesso.");
		return ResponseEntity.ok(response);
	}
}
