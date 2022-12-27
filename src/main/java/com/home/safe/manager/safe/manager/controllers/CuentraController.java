package com.home.safe.manager.safe.manager.controllers;

import com.home.safe.manager.safe.manager.domain.Cuenta;
import com.home.safe.manager.safe.manager.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuenta")
public class CuentraController {
    @Autowired
    CuentaService cuentaService;

    @PostMapping("/crear")
    public ResponseEntity crearCuenta(@RequestBody Cuenta cuenta){
        return cuentaService.crearCuenta(cuenta);
    }
}
