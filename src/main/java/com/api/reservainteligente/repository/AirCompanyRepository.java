package com.api.reservainteligente.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.api.reservainteligente.entities.AirCompany;

@Transactional(readOnly = true)
public interface AirCompanyRepository extends JpaRepository<AirCompany, Long>{

	Optional<AirCompany> findByCnpj(String airCompanyCnpj);

}
