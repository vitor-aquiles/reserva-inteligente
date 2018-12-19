package com.api.reservainteligente.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.reservainteligente.entities.AirCompany;

public interface AirCompanyRepository extends JpaRepository<AirCompany, Long>{

	Optional<AirCompany> findByCnpj(String airCompanyCnpj);

}
