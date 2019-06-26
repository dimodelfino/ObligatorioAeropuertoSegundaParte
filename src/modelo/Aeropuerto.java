/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.strategy.ITipoAeropuerto;

/**
 *
 * @author dmoreno
 */
public class Aeropuerto {

    public String nombre;
    public ITipoAeropuerto tipo;
    private int oid;

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public Aeropuerto() {
    }

    public Aeropuerto(String nombre, String tipo, int oid, ITipoAeropuerto t) {
        this.nombre = nombre;
        this.tipo = t;
        this.oid = oid;
    }

}
