package com.api.reservainteligente.services;

import java.util.Optional;

import org.springframework.validation.BindingResult;

import com.api.reservainteligente.entities.Manager;

public interface ManagerService {
	
	/** Busca um Manager por Email
	 * 
	 * @param email
	 * @return manager
	 */
	Optional<Manager> findByEmail(String email);
	
	
	/** Busca um Manager por CPF
	 * 
	 * @param email
	 * @return manager
	 */
	Optional<Manager> findByCpf(String cpf);
	
	
	/** Busca um Manager por CPF ou Email
	 * 
	 * @param email
	 * @return manager
	 */
	Optional<Manager> findByCpfOrEmail(String cpf, String email);
	
	
	/** Salva um Manager na base de dados
	 * 
	 * @param manager
	 * @return 
	 */
	Manager persist(Manager manager);
	
	
	/** Verifica se o Manager já existe
	 * 
	 * @param manager
	 * @param result
	 */
	void isValidManager(String cpf, String email, BindingResult result);
}
