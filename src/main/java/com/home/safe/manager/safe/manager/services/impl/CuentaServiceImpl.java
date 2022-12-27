package com.home.safe.manager.safe.manager.services.impl;


import com.home.safe.manager.safe.manager.domain.Cuenta;
import com.home.safe.manager.safe.manager.repositories.CuentaRepository;
import com.home.safe.manager.safe.manager.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaServiceImpl implements CuentaService {
    @Autowired
    CuentaRepository cuentaRepository;

    @Override
    public Optional<Cuenta> obtenerCuenta(Long id) {
        return cuentaRepository.findById(id);
    }

    @Override
    public ResponseEntity crearCuenta(Cuenta cuenta) {
        return new ResponseEntity(cuentaRepository.save(cuenta), HttpStatus.OK);
    }

    @Override
    public List<Cuenta> obtenerCuentas() {
        return cuentaRepository.findAll();
    }
}
