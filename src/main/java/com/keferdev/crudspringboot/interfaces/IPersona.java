package com.keferdev.crudspringboot.interfaces;

import com.keferdev.crudspringboot.modelo.Persona;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersona extends CrudRepository<Persona, Integer>{
    
}
