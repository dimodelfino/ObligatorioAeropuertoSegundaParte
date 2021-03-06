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
import modelo.LogicaVuelo;

/**
 *
 * @author dmoreno
 */
public class ControladoraMonitoreo implements Observer{
    
    private IVistaMonitoreo vista;
    
    public ControladoraMonitoreo(IVistaMonitoreo apM){        
        this.vista = apM;
        LogicaFrecuenciaVuelo.getInstancia().addObserver(this);
        LogicaVuelo.getInstancia().addObserver(this);
    }
    
    public ArrayList<String> getVuelosPorAeropuertoMonitoreo(String nomAero, String origDest) {
        return FachadaModelo.getInstancia().getVuelosPorAeropuertoMonitoreo(nomAero, origDest);
    } 
    
    @Override
    public void update(Observable o, Object arg) {
        if(o == LogicaFrecuenciaVuelo.getInstancia() || o == LogicaVuelo.getInstancia()){
            vista.actualizarPartidas();
            vista.actualizarArribos();
        }
    }
    
}
