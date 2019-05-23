/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import modelo.FachadaModelo;
import modelo.LogicaFrecuenciaVuelo;
import modelo.Vuelo;
import vistas.AplicacionMonitoreo;

/**
 *
 * @author dmoreno
 */
public class ControladoraMonitoreo implements Observer{
    
    private AplicacionMonitoreo vista;
    
    public ControladoraMonitoreo(AplicacionMonitoreo apM){        
        this.vista = apM;
        LogicaFrecuenciaVuelo.getInstancia().addObserver(this);
    }

    public ArrayList<Vuelo> getVuelosPorAeropuerto(String nomAero, String origDest) {
        return FachadaModelo.getInstancia().getVuelosPorAeropuerto(nomAero, origDest);
    } 
    
    public ArrayList<Vuelo> getVuelosPorAeropuertoMonitoreo(String nomAero, String origDest) {
        return FachadaModelo.getInstancia().getVuelosPorAeropuertoMonitoreo(nomAero, origDest);
    } 
    
    @Override
    public void update(Observable o, Object arg) {
        if(o == LogicaFrecuenciaVuelo.getInstancia()){
            vista.actualizarListas();
        }
    }
    
}
