package com.api.reservainteligente.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.api.reservainteligente.entities.AirCompany;
import com.api.reservainteligente.repository.AirCompanyRepository;
import com.api.reservainteligente.services.AirCompanyService;

public class AirCompanyServiceImpl implements AirCompanyService{
	
	private static final Logger log = LoggerFactory.getLogger(AirCompanyServiceImpl.class);
	
	@Autowired
	private AirCompanyRepository airCompanyRepository;
	
	@Override
	public Optional<AirCompany> findById(Long id) {
		log.info("Buscando AirCompany de ID {} ", id);
		return airCompanyRepository.findById(id);
	}
	
	@Override
	public AirCompany persist(AirCompany airCompany) {
		log.info("Cadastrando AirCompany de CNPJ {} ", airCompany.getCnpj());
		return airCompanyRepository.save(airCompany);
	}

	@Override
	public void isNewCnpj(String airCompanyCnpj, BindingResult result) {
		Optional<AirCompany> airCompany = airCompanyRepository.findByCnpj(airCompanyCnpj);
		if(airCompany.isPresent()) {
			result.addError(new ObjectError("airCompany", "CNPJ já cadastrado."));
		}
	}

	@Override
	public void remove(Long id) {
		log.info("Removendo AirCompany de ID {} ", id);
		airCompanyRepository.deleteById(id);
	}

}
