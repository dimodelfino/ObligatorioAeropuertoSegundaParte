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
public class Nacional implements ITipoAeropuerto {
    
    int oId;

   @Override
    public int CalcularArancelPartida(String estado, Vuelo v, int minRetraso) {
        return 50;
    }

    @Override
    public int CalcularArancelLlegada(Aeropuerto aeroOrigen) {
         int arancel = 70;
        if(aeroOrigen.tipo.getClass().getName().contains("Nacional")){
            arancel = 40;
        }
        return arancel;
    }
}
