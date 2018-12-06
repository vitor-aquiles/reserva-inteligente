package com.api.reservainteligente.services.impl;

import java.util.Optional;

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
	public Optional<Manager> findByEmail(String email) {
		log.info("Buscando Manager com Email {}", email);
		return managerRepository.findByEmail(email);
	}

	@Override
	public Optional<Manager> findByCpf(String cpf) {
		log.info("Buscando Manager com CPF {}", cpf);
		return managerRepository.findByCpf(cpf);
	}
	
	@Override
	public Optional<Manager> findByCpfOrEmail(String cpf, String email) {
		log.info("Buscando Manager por CPF ou Email");
		return managerRepository.findByCpfOrEmail(cpf, email);
	}

	@Override
	public Manager persist(Manager manager) {
		log.info("Salvando Manager {}", manager.getName());
		return managerRepository.save(manager);
	}

	@Override
	public void isValidManager(String cpf, BindingResult result) {
		log.info("Verificando Manager com CPF {}");
		Optional<Manager> manager = findByCpf(cpf);
		if(manager.isPresent()) {
			result.addError(new ObjectError("manager", "CPF já cadastrado."));
		}
		//findByCpfOrEmail(cpf, email);
		/*if(manager == null) {
			return;
		}*/
	}

}
