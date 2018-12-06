package com.api.reservainteligente.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.api.reservainteligente.entities.Manager;

@Transactional(readOnly = true)
public interface ManagerRepository extends JpaRepository<Manager, Long>{

	Manager getManagerById(Long id);
	
	Optional<Manager> findById(Long id);

	Optional<Manager> findByEmail(String email);
	
	Optional<Manager> findByCpf(String cpf);
	
	Optional<Manager> findByCpfOrEmail(String cpf, String email);
}
