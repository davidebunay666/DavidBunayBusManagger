/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.Objects;

/**
 *
 * @author David
 */
public class Parada {
    private String codigo;
    private String ubicacion;
    private String paradaTuristica;

    public Parada(String codigo, String ubicacion,String paradaTuristica) {
        this.codigo = codigo;
        this.ubicacion = ubicacion;
        this.paradaTuristica=paradaTuristica;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getUbicacion() {
        return ubicacion;
    }
     public String getParadaTuristica() {
        return paradaTuristica;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Parada other = (Parada) obj;
        return true;
    }
    
    
}
