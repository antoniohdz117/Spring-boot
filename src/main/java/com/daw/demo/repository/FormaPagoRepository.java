package com.daw.demo.repository;

import com.daw.demo.model.FormaPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FormaPagoRepository extends JpaRepository<FormaPago, Integer> {

}
