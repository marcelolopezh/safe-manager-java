package com.home.safe.manager.safe.manager.services;

import com.home.safe.manager.safe.manager.domain.Cuenta;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CuentaService {
    Optional<Cuenta> obtenerCuenta(Long id);
    ResponseEntity crearCuenta(Cuenta cuenta);

    List<Cuenta> obtenerCuentas();
}
