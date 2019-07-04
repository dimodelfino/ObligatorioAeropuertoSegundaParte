/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author alumnoFI
 */
public class Usuario {
    public String nombre;
    public String nombreCompleto;
    public String contrasenia;
    private int oId;
    
    public int getOid(){
        return this.oId;
    }
    
    public void setOid (int oId){
        this.oId = oId;
    }
}
