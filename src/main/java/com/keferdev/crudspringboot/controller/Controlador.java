package com.keferdev.crudspringboot.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.keferdev.crudspringboot.interfaceService.iPersonaService;
import com.keferdev.crudspringboot.modelo.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private iPersonaService service;

    @GetMapping(value = "/listar")
    public String listar(Model model){
        List<Persona> personas = service.listar();
        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/nuevo")
    public String agregar(Model model) {
        model.addAttribute("persona", new Persona());
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Persona per, Model model){
        service.save(per);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Persona> persona = service.listarId(id);
        model.addAttribute("persona", persona);
        return "formulario";
    }

    @GetMapping("eliminar/{id}")
    public String eliminar(@PathVariable int id, Model model){
        service.delete(id);
        return "redirect:/listar";
    }
}
