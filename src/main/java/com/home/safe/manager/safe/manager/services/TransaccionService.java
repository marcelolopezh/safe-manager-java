package com.home.safe.manager.safe.manager.services;

import com.home.safe.manager.safe.manager.domain.DatosTransaccion;
import com.home.safe.manager.safe.manager.domain.Transaccion;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TransaccionService {
    Transaccion crearTransaccion(DatosTransaccion datosTransaccion);
    List<Transaccion> getTransacciones();

    List<Transaccion> getTransaccionesDescendente();
}
