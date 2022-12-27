package com.home.safe.manager.safe.manager.services.impl;

import com.home.safe.manager.safe.manager.domain.Cuenta;
import com.home.safe.manager.safe.manager.domain.DatosTransaccion;
import com.home.safe.manager.safe.manager.domain.Transaccion;
import com.home.safe.manager.safe.manager.repositories.TransaccionRepository;
import com.home.safe.manager.safe.manager.services.CuentaService;
import com.home.safe.manager.safe.manager.services.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Collections.reverse;

@Service
public class TransaccionServiceImpl implements TransaccionService {
    @Autowired
    TransaccionRepository transaccionRepository;

    @Autowired
    CuentaService cuentaService;

    public static final Long id = 1L;
    public LocalDateTime localDateTime;
    public static final String RETIRO = "RETIRO";
    public static final String DEPOSITO = "DEPÓSITO";

    @Override
    public Transaccion crearTransaccion(DatosTransaccion datosTransaccion) {
        Transaccion transaccion = new Transaccion();
        Cuenta cuenta = cuentaService.obtenerCuenta(id).get();

        transaccion.setMonto(datosTransaccion.getMonto());
        transaccion.setFechaTransaccion(LocalDateTime.now());
        transaccion.setTipoOperacion(datosTransaccion.getTipoTransaccion());
        transaccion.setCuenta(cuenta);
        transaccion.setUsuario(datosTransaccion.getUsuario());

        if(RETIRO.equalsIgnoreCase(datosTransaccion.getTipoTransaccion())){
            transaccion.setMontoAcumulado(cuenta.getSaldo().subtract(transaccion.getMonto()));
            cuenta.setSaldo(cuenta.getSaldo().subtract(datosTransaccion.getMonto()));
        }

        if(DEPOSITO.equalsIgnoreCase(datosTransaccion.getTipoTransaccion())){
            transaccion.setMontoAcumulado(cuenta.getSaldo().add(transaccion.getMonto()));
            cuenta.setSaldo(cuenta.getSaldo().add(datosTransaccion.getMonto()));
        }

        //update cuenta
        cuentaService.crearCuenta(cuenta);


        Transaccion transaccionDB = transaccionRepository.save(transaccion);
        return transaccionDB;
    }

    public List<Transaccion> getTransaccionesDescendente(){
        List<Transaccion> listTransaccion = transaccionRepository.findAll();
        reverse(listTransaccion);
        return listTransaccion;
    }

    public List<Transaccion> getTransacciones(){
        return transaccionRepository.findAll();
    }
}
