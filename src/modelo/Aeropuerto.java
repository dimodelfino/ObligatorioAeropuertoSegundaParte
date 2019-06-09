/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author dmoreno
 */
public class Aeropuerto {
    public String nombre;
    public String tipo;  
    private int oid;
    
    public int getOid(){
    return oid;
    }
    
    public void setOid(int oid){
        this.oid = oid;
    }
    
    public Aeropuerto (){};
    
    public Aeropuerto (String nombre, String tipo, int oid){
        this.nombre= nombre;
        this.tipo=tipo;
        this.oid=oid;
    }

}
