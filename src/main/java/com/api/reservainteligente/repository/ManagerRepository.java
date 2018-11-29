package com.api.reservainteligente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.api.reservainteligente.entities.Manager;

@Transactional(readOnly = true)
public interface ManagerRepository extends JpaRepository<Manager, Integer>{

	Manager findByEmail(String email);
	
	Manager findByCpf(String cpf);
}
