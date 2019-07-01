/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author dmoreno
 */
public class Compania {
    public String nombre;
    public String alias;   
    private int oId;
    
    public int getoId(){
        return this.oId;
    }
    
    public void setOid(int oid){
        this.oId = oid;
    }
}
