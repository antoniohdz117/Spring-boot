package com.daw.demo.repository;


import com.daw.demo.model.Componente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponenteRepository extends JpaRepository<Componente, Integer> {


}
