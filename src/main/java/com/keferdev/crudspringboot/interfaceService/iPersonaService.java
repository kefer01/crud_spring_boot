package com.keferdev.crudspringboot.interfaceService;

import java.util.List;
import java.util.Optional;

import com.keferdev.crudspringboot.modelo.Persona;

public interface iPersonaService {
    public List<Persona> listar();
    public Optional<Persona> listarId(int id);
    public int save(Persona p);
    public void delete(int id);
}
