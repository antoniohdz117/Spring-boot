package com.daw.demo.repository;

import com.daw.demo.model.ComputadoraxComponente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ComputadoraxComponenteRepository  extends JpaRepository<ComputadoraxComponente, Integer> {


}