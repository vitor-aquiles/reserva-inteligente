package com.api.reservainteligente.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.api.reservainteligente.entities.Manager;
import com.api.reservainteligente.repository.ManagerRepository;
import com.api.reservainteligente.services.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService{

	private static final Logger log = LoggerFactory.getLogger(ManagerServiceImpl.class);
	
	@Autowired
	private ManagerRepository managerRepository;

	@Override
	public Manager findByEmail(String email) {
		log.info("Buscando Manager com Email {}", email);
		return managerRepository.findByEmail(email);
	}

	@Override
	public Manager findByCpf(String cpf) {
		log.info("Buscando Manager com CPF {}", cpf);
		return managerRepository.findByCpf(cpf);
	}
	
	@Override
	public Manager findByCpfOrEmail(String cpf, String email) {
		log.info("Buscando Manager por CPF ou Email");
		return managerRepository.findByCpfOrEmail(cpf, email);
	}

	@Override
	public Manager persist(Manager manager) {
		log.info("Salvando Manager {}", manager.getName());
		return managerRepository.save(manager);
	}

	@Override
	public void isValidManager(String cpf, String email, BindingResult result) {
		log.info("Verificando Manager com CPF ou Email{}");
		managerRepository.findByCpfOrEmail(cpf, email);
		Manager manager = null;
		/*if(manager == null) {
			return;
		}*/
		result.addError(new ObjectError("manager", "CPF e/ou Email já cadastrado(s)."));
	}

}
