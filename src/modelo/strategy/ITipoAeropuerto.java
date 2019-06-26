/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.strategy;

import modelo.Aeropuerto;
import modelo.Vuelo;

/**
 *
 * @author dmoreno
 */
public interface ITipoAeropuerto {

    public int CalcularArancelPartida(String estado, Vuelo v, int minRetraso);
    
    public int CalcularArancelLlegada(Aeropuerto aeroOrigen);
}
