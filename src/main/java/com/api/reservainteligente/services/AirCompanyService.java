package com.api.reservainteligente.services;

import java.util.Optional;

import org.springframework.validation.BindingResult;

import com.api.reservainteligente.dtos.AirCompanyDto;
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
	 * Retorna uma AirCompany dado um CNPJ
	 *  
	 * @param cnpj
	 * @return Optional<AirCompany>
	 */
	Optional<AirCompany> findByCnpj(String cnpj);
	
	/**
	 * Persiste uma AirCompany na base de dados.
	 * 
	 * @param airCompany
	 */
	AirCompany persist(AirCompany airCompany);
	
	/**
	 * Remove uma AirCompany dado um ID
	 * 
	 * @param id
	 */
	void remove(Long id);

	/**
	 * 
	 * @param airCompanyDto
	 * @param result
	 * @return AirCompany
	 */
	AirCompany getInstanceOfAirCompanyWhenUpdate(AirCompanyDto airCompanyDto, BindingResult result);

	/**
	 * Verifica se o CNPJ já existe na base de dados.
	 * 
	 * @param airCompanyCnpj
	 * @param result
	 */
	void isNewCnpj(Long airCompanyId, String airCompanyCnpj, BindingResult result);
	
	/**
	 * Verifica se a Air Company existe na base de dados
	 * 
	 * @param idAirCompany
	 * @param result
	 */
	Optional<AirCompany> isValidAirCompany(Long idAirCompany, BindingResult result);
}
