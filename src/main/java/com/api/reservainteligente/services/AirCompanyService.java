package com.api.reservainteligente.services;

import java.util.Optional;

import org.springframework.validation.BindingResult;

import com.api.reservainteligente.entities.AirCompany;

public interface AirCompanyService {

	/**
	 * Retorna uma AirCompany dado um ID
	 *  
	 * @param id
	 * @return Optional<AirCompany>
	 */
	Optional<AirCompany> findById(Long id);

	/**
	 * Persiste uma AirCompany na base de dados.
	 * 
	 * @param airCompany
	 */
	AirCompany persist(AirCompany airCompany);
	
	/**
	 * Verifica se o CNPJ já existe na base de dados.
	 * 
	 * @param airCompanyCnpj
	 * @param result
	 */
	void isNewCnpj(String airCompanyCnpj, BindingResult result);

	/**
	 * Remove uma AirCompany dado um ID
	 * 
	 * @param id
	 */
	void remove(Long id);

	
}
