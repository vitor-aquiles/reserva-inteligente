package com.api.reservainteligente.services;

import java.util.Optional;

import org.springframework.validation.BindingResult;

import com.api.reservainteligente.entities.Manager;

public interface ManagerService {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Manager getManagerById(Long id);
	
	/** Busca um Manager por Id.
	 * 
	 * @param id
	 * @return manager
	 */
	Optional<Manager> findById(Long id);
	
	/** Busca um Manager por Email.
	 * 
	 * @param email
	 * @return manager
	 */
	Optional<Manager> findByEmail(String email);
	
	
	/** Busca um Manager por CPF.
	 * 
	 * @param email
	 * @return manager
	 */
	Optional<Manager> findByCpf(String cpf);
	
	
	/** Busca um Manager por CPF ou Email.
	 * 
	 * @param email
	 * @return manager
	 */
	Optional<Manager> findByCpfOrEmail(String cpf, String email);
	
	
	/** Salva um Manager na base de dados.
	 * 
	 * @param manager
	 * @return 
	 */
	Manager persist(Manager manager);
	
	/** Exclui um Manager da base de dados.
	 * 
	 * @param manager 
	 */
	void remove(Long id);
	
	/** Verifica através de um cpf se o Manager já existe.
	 * Caso exista, adiciona um Error ao result.
	 * 
	 * @param cpf
	 * @param result
	 */
	void isValidManagerByCpf(String cpf, BindingResult result);
	
	/** Verifica no momento do update de um Manager, 
	 * se o CPF informado já está associado a outro Manager.
	 * Caso exista, adiciona um Error ao result.
	 * 
	 * @param managerId
	 * @param managerToCpf
	 * @param result
	 */
	void isNewCpf(Long managerId, String managerToCpf, BindingResult result);
}
