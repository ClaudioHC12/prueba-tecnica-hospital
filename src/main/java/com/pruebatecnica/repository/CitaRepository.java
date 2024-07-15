package com.pruebatecnica.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.entity.Cita;
import com.pruebatecnica.entity.Consultorio;
import com.pruebatecnica.entity.Doctor;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByConsultorioAndHorarioConsulta(Consultorio consultorio, LocalDateTime horarioConsulta);
    List<Cita> findByDoctorAndHorarioConsulta(Doctor doctor, LocalDateTime horarioConsulta);
    List<Cita> findByNombrePacienteAndHorarioConsultaBetween(String nombrePaciente, LocalDateTime start, LocalDateTime end);
    long countByDoctorAndHorarioConsultaBetween(Doctor doctor, LocalDateTime start, LocalDateTime end);
}
