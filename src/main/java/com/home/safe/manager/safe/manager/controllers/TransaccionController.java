package com.home.safe.manager.safe.manager.controllers;


import com.home.safe.manager.safe.manager.domain.DatosTransaccion;
import com.home.safe.manager.safe.manager.domain.Transaccion;
import com.home.safe.manager.safe.manager.services.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaccion")
public class TransaccionController {

    @Autowired
    TransaccionService transaccionService;

    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public ResponseEntity<?> crearTransaccion(@RequestBody DatosTransaccion datosTransaccion) {
        Transaccion transaccion = transaccionService.crearTransaccion(datosTransaccion);
        return new ResponseEntity(transaccion, HttpStatus.OK);
    }

    @GetMapping("/obtener-ascendente")
    public ResponseEntity obtenerTransacciones(){
        try{
            return new ResponseEntity(transaccionService.getTransacciones(),HttpStatus.OK);
        }catch (Exception error){
            return(new ResponseEntity(error,HttpStatus.BAD_GATEWAY));
        }
    }

    @GetMapping("/obtener-descendente")
    public ResponseEntity obtenerTransaccionesDescendente(){
        try{
            return new ResponseEntity(transaccionService.getTransaccionesDescendente(),HttpStatus.OK);
        }catch (Exception error){
            return(new ResponseEntity(error,HttpStatus.BAD_GATEWAY));
        }
    }
}
