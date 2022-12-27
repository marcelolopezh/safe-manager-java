package com.home.safe.manager.safe.manager.repositories;

import com.home.safe.manager.safe.manager.domain.Cuenta;
import com.home.safe.manager.safe.manager.domain.Transaccion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CuentaRepository extends CrudRepository<Cuenta, Long> {
    List<Cuenta> findAll();
    Optional<Cuenta> findById(Long id);
    void deleteById(Long id);
}
