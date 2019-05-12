/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author majuetcheverry
 */
public class Estado {
    public Aeropuerto aeropuerto;
    public EstadoEnum estado;  
    
    public Estado (Aeropuerto a){
        aeropuerto = a;
        estado = EstadoEnum.Pendiente;
    }
    
    
}
