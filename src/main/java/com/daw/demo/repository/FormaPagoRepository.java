package com.daw.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public class FormaPagoRepository {


    @Repository
    public interface formaPagoRepository<FormaPago> extends JpaRepository<FormaPago, Integer> {


        List<FormaPago> findByTipoPago(String tipoPago);

        List<FormaPago> findByNombreTitularContainingIgnoreCase(String nombre);
    }
}
