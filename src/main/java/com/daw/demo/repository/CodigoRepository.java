package com.daw.demo.repository;

import com.daw.demo.model.Codigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodigoRepository extends JpaRepository<Codigo, Integer> {

}
