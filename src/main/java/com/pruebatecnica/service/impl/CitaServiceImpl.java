package com.pruebatecnica.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.entity.Cita;
import com.pruebatecnica.repository.CitaRepository;
import com.pruebatecnica.service.CitaService;

@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Override
    public boolean isCitaValid(Cita cita) {
        if (!citaRepository.findByConsultorioAndHorarioConsulta(cita.getConsultorio(), cita.getHorarioConsulta()).isEmpty()) {
            return false;
        }
        if (!citaRepository.findByDoctorAndHorarioConsulta(cita.getDoctor(), cita.getHorarioConsulta()).isEmpty()) {
            return false;
        }
        LocalDateTime startOfDay = cita.getHorarioConsulta().toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1);
        LocalDateTime twoHoursBefore = cita.getHorarioConsulta().minusHours(2);
        LocalDateTime twoHoursAfter = cita.getHorarioConsulta().plusHours(2);
        if (!citaRepository.findByNombrePacienteAndHorarioConsultaBetween(cita.getNombrePaciente(), twoHoursBefore, twoHoursAfter).isEmpty()) {
            return false;
        }
        if (citaRepository.countByDoctorAndHorarioConsultaBetween(cita.getDoctor(), startOfDay, endOfDay) >= 8) {
            return false;
        }
        return true;
    }

    @Override
    public Cita saveCita(Cita cita) {
        if (isCitaValid(cita)) {
            return citaRepository.save(cita);
        } else {
            throw new IllegalArgumentException("Cita no válida");
        }
    }

    @Override
    public List<Cita> getCitas() {
        return citaRepository.findAll();
    }

}
