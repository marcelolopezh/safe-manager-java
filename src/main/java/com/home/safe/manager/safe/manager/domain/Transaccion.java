package com.home.safe.manager.safe.manager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaccion {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;
    public BigDecimal monto;
    public String tipoOperacion;
    public LocalDateTime fechaTransaccion;
    public String usuario;
    public BigDecimal montoAcumulado;
    @ManyToOne
    @JoinColumn(name="cuenta_id", nullable = false)
    @JsonIgnore
    public Cuenta cuenta;


    public LocalDateTime getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDateTime fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public BigDecimal getMontoAcumulado() {
        return montoAcumulado;
    }

    public void setMontoAcumulado(BigDecimal montoAcumulado) {
        this.montoAcumulado = montoAcumulado;
    }
}