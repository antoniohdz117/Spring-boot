package com.daw.demo.repository;

import com.daw.demo.model.Computadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputadoraRepository extends JpaRepository<Computadora, Integer> {

}
