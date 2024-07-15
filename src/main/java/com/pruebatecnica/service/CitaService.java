package com.pruebatecnica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebatecnica.entity.Cita;

@Service
public interface CitaService {

    public boolean isCitaValid(Cita cita);
    public Cita saveCita(Cita cita);
    public List<Cita> getCitas();

}
