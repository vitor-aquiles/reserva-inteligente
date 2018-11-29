package com.api.reservainteligente.services;

import org.springframework.validation.BindingResult;

import com.api.reservainteligente.entities.Manager;

public interface ManagerService {
	
	/** Busca um Manager por Email
	 * 
	 * @param email
	 * @return manager
	 */
	Manager findByEmail(String email);
	
	/** Busca um Manager por CPF
	 * 
	 * @param email
	 * @return manager
	 */
	Manager findByCpf(String cpf);
	
	/** Salva um Manager na base de dados
	 * 
	 * @param manager
	 */
	void persist(Manager manager);
	
	/** Verifica se o Manager já existe
	 * 
	 * @param manager
	 * @param result
	 */
	void isValidManager(String cpf, BindingResult result);
}
