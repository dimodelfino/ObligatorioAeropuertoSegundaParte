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
public class Internacional implements ITipoAeropuerto {

    @Override
    public int CalcularArancelPartida(String estado, Vuelo v, int minRetraso) {
        int arancel = 300;

        if (estado == "Retrasado") {
            arancel += (50 * minRetraso);
        }
        return arancel;
    }

    @Override
    public int CalcularArancelLlegada(Aeropuerto aeroOrigen) {
        return 300;
    }
}
