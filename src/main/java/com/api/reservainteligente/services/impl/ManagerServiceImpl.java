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
		return findByEmail(email);
	}

	@Override
	public Manager findByCpf(String cpf) {
		log.info("Buscando Manager com CPF {}", cpf);
		return findByCpf(cpf);
	}

	@Override
	public void persist(Manager manager) {
		log.info("Salvando Manager {}", manager.getName());
		persist(manager);
	}

	@Override
	public void isValidManager(String cpf, BindingResult result) {
		log.info("Verificando Manager com CPF {}", cpf);
		Manager manager = findByCpf(cpf);
		if(manager != null) {
			result.addError(new ObjectError("manager", "CPF já cadastrado."));
		}
	}
}
