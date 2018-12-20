package com.api.reservainteligente.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.api.reservainteligente.dtos.AirCompanyDto;
import com.api.reservainteligente.entities.AirCompany;
import com.api.reservainteligente.repository.AirCompanyRepository;
import com.api.reservainteligente.services.AirCompanyService;

@Service
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
	public Optional<AirCompany> findByCnpj(String airCompanyCnpj) {
		log.info("Buscando AirCompany de CNPJ {} ", airCompanyCnpj);
		return airCompanyRepository.findByCnpj(airCompanyCnpj);
	}
	
	@Override
	public AirCompany persist(AirCompany airCompany) {
		log.info("Cadastrando AirCompany de CNPJ {} ", airCompany.getCnpj());
		return airCompanyRepository.save(airCompany);
	}

	@Override
	public void remove(Long id) {
		log.info("Removendo AirCompany de ID {} ", id);
		airCompanyRepository.deleteById(id);
	}

	@Override
	public AirCompany getInstanceOfAirCompanyWhenUpdate(AirCompanyDto airCompanyDto, BindingResult result) {
		log.info("Validando Air Company");
		AirCompany airCompany = null;
		Optional<AirCompany> airCompanyTarget = airCompanyRepository.findById(airCompanyDto.getId());
		isNewCnpj(airCompanyDto.getId(), airCompanyDto.getCnpj(), result);
		
		if (!airCompanyTarget.isPresent()) {
				result.addError(new ObjectError("airCompany", "Air Company inexistente."));
		}
		if(!result.hasErrors()) {
			airCompany = airCompanyTarget.get();
			airCompany.setCompanyName(airCompanyDto.getCompanyName());
			airCompany.setCnpj(airCompanyDto.getCnpj());
		}
		return airCompany;
	}

	@Override
	public void isNewCnpj(Long airCompanyDtoId, String airCompanyDtoCnpj, BindingResult result) {
		Optional<AirCompany> airCompany = airCompanyRepository.findByCnpj(airCompanyDtoCnpj);
		if(airCompany.isPresent() && airCompany.get().getId() != airCompanyDtoId) {
			result.addError(new ObjectError("airCompany", "CNPJ já cadastrado."));
		}
	}

	@Override
	public Optional<AirCompany> isValidAirCompany(Long idAirCompany, BindingResult result) {
		Optional<AirCompany> airCompany = airCompanyRepository.findById(idAirCompany);
		if(!airCompany.isPresent()) {
			result.addError(new ObjectError("airCompany", "Air Company inexistente."));
		}
		return airCompany;
	}
}
