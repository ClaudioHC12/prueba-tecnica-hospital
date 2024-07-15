package com.pruebatecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pruebatecnica.entity.Cita;
import com.pruebatecnica.service.CitaService;

@Controller
@RequestMapping("/citas")
public class CitaController {
    @Autowired
    private CitaService citaService;

    @GetMapping
    public String listCitas(Model model) {
        model.addAttribute("citas", citaService.getCitas());
        return "citas/list";
    }

    @GetMapping("/new")
    public String newCitaForm(Model model) {
        model.addAttribute("cita", new Cita());
        return "citas/new";
    }

    @PostMapping
    public String saveCita(@ModelAttribute Cita cita, Model model) {
        try {
            citaService.saveCita(cita);
            return "redirect:/citas";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "citas/new";
        }
    }
}
