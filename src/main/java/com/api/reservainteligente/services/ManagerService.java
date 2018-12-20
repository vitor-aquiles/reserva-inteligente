package com.api.reservainteligente.services;

import java.util.Optional;

import org.springframework.validation.BindingResult;

import com.api.reservainteligente.dtos.ManagerDto;
import com.api.reservainteligente.entities.Manager;

public interface ManagerService {
	
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
	
	/** Verifica se os dados enviados na Action de Update são válidos.
	 * Caso sim, retorna o Manager de ID correspondente.
	 * 
	 * 
	 * @param cpf
	 * @param result
	 * 
	 * @return Manager
	 */
	Manager getInstanceOfManagerWhenUpdate(ManagerDto managerDto, BindingResult result);
	
	/**Verifica se o CPF já existe na base de dados.
	 * 
	 * @param managerCpf
	 * @param result
	 */
	void isNewCpf(Long managerId, String managerCpf, BindingResult result);

}
