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
public class Regional implements ITipoAeropuerto {

    @Override
    public int CalcularArancelPartida(String estado, Vuelo v, int minRetraso) {
        int arancel = 100;
        if(estado == "Retrasado"){
            arancel = 200;
        }
        return arancel;
    }

    @Override
    public int CalcularArancelLlegada(Aeropuerto aeroOrigen) {
        int arancel = 70;
        if(aeroOrigen.tipo.getClass().getName().contains("Internacional")){
            arancel = 100;
        }
        return arancel;
    }
}
