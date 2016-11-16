/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Datos.Parada;

/**
 *
 * @author David
 */
public class Linea {
    private Parada parada;
    private int numeroLinea;
    
    public Linea(Parada parada, int numLinea){
        this.numeroLinea=numLinea;
        this.parada=parada;
    }

    public Parada getParada() {
        return parada;
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }
    
    
    
    
    
}
