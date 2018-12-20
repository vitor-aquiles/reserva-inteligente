package com.api.reservainteligente.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.api.reservainteligente.dtos.ManagerDto;
import com.api.reservainteligente.entities.AirCompany;
import com.api.reservainteligente.entities.Manager;
import com.api.reservainteligente.repository.ManagerRepository;
import com.api.reservainteligente.services.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService{

	private static final Logger log = LoggerFactory.getLogger(ManagerServiceImpl.class);
	
	@Autowired
	private ManagerRepository managerRepository;

	@Override
	public Optional<Manager> findById(Long id) {
		log.info("Buscando Manager com ID {}", id);
		return managerRepository.findById(id);
	}
	
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
		Manager mg = managerRepository.save(manager);
		return mg;
	}
	
	@Override
	public void remove(Long id) {
		log.info("Excluindo Manager de ID {}", id);
		managerRepository.deleteById(id);
	}

	@Override
	public Manager getInstanceOfManagerWhenUpdate(ManagerDto managerDto, BindingResult result) {
		log.info("Validando Manager de ID {}");
		Manager manager = null;
		Optional<Manager> managerTarget = managerRepository.findById(managerDto.getId());
		isNewCpf(managerDto.getId(), managerDto.getCpf(), result);
		
		if (!managerTarget.isPresent()) {
				result.addError(new ObjectError("manager", "Manager inexistente."));
		}		
		if(!result.hasErrors()) {
			manager = managerTarget.get();
			manager.setName(managerDto.getName());
			manager.setEmail(managerDto.getEmail());
			manager.setPassword(managerDto.getPassword());
			manager.setCpf(managerDto.getCpf());
			manager.setProfile(managerDto.getProfile());
			manager.setAirCompany(new AirCompany());
			manager.getAirCompany().setId(managerDto.getIdAirCompany());
		}
		return manager;
	}

	@Override
	public void isNewCpf(Long managerId, String managerCpf, BindingResult result) {
		Optional<Manager> manager = managerRepository.findByCpf(managerCpf);
		if(manager.isPresent() && manager.get().getId() != managerId) {
			result.addError(new ObjectError("airCompany", "CPF já cadastrado."));
		}
	}
}
