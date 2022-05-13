package com.keferdev.crudspringboot.service;

import java.util.List;
import java.util.Optional;

import com.keferdev.crudspringboot.interfaceService.iPersonaService;
import com.keferdev.crudspringboot.interfaces.IPersona;
import com.keferdev.crudspringboot.modelo.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements iPersonaService {

    @Autowired
    private IPersona data;

    @Override
    public List<Persona> listar() {
         return (List<Persona>)data.findAll();
    }

    @Override
    public Optional<Persona> listarId(int id) {

        return data.findById(id);
    }

    @Override
    public int save(Persona p) {
        int respuesta=0;
        Persona persona = data.save(p);
        if (!persona.equals(null)) {
            respuesta = 1;
        }
        return respuesta;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
    
}
