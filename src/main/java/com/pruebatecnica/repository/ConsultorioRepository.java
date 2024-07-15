package com.pruebatecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.entity.Consultorio;

@Repository
public interface ConsultorioRepository extends JpaRepository<Consultorio, Long> {
}
