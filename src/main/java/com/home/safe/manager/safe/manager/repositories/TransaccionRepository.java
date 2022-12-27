package com.home.safe.manager.safe.manager.repositories;

import com.home.safe.manager.safe.manager.domain.Transaccion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransaccionRepository extends CrudRepository<Transaccion, Long> {
    List<Transaccion> findAll();
    Optional<Transaccion> findById(Long id);
    void deleteById(Long id);
}
