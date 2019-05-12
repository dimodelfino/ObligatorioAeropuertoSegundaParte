/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dmoreno
 */
public class LogicaFrecuenciaVuelo {

    private ArrayList<FrecuenciaDeVuelo> frecuencias = new ArrayList<FrecuenciaDeVuelo>();
    private static LogicaFrecuenciaVuelo instancia = new LogicaFrecuenciaVuelo();

    public static LogicaFrecuenciaVuelo getInstancia() {
        return instancia;
    }

    public ArrayList<FrecuenciaDeVuelo> getFrecuencias() {
        return frecuencias;
    }

    

    public boolean GuardarFrecuencia(FrecuenciaDeVuelo fv) {
        boolean agregado = false;
        int cantidadFrecuencias = frecuencias.size();
        this.frecuencias.add(fv);
        if ((cantidadFrecuencias + 1) == frecuencias.size()) {
            agregado = true;
        }
        return agregado;
    }
}
