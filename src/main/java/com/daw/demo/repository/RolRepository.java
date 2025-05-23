package com.daw.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public class RolRepository {


    @Repository
    public interface rolRepository<Rol> extends JpaRepository<Rol, Integer> {

        // Consulta por tipo de rol
        Rol findByTipoRol(Character tipoRol);

        // Consulta para verificar existencia por tipo de rol
        boolean existsByTipoRol(Character tipoRol);
    }
}
