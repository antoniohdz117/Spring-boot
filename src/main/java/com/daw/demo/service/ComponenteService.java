package com.daw.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ComponenteService {

    private final ComponenteRepository ComponenteRepository;

    public <ComponenteRepository> ComponenteService(ComponenteRepository componenteRepository) {
        this.ComponenteRepository = componenteRepository;
    }

    public <Componente> List<Componente> getAll() {
        return componenteRepository.findAll();
    }

    public <Componente> Optional<Componente> getById(Long id) {
        return componenteRepository.findById(id);
    }

    public <Componente> Componente save(Componente componente) {
        return componenteRepository.save(componente);
    }

    public void delete(Long id) {
        componenteRepository.deleteById(id);
    }

    public Componente update(Long id, Componente componente) {
        SimpleJpaRepository componenteRepository;
        if (componenteRepository.existsById(id)) {
            componente.setIdComponente(id);
            return componenteRepository.save(componente);
        } else {
            throw new RuntimeException("Componente no encontrado con ID: " + id);
        }
    }
}