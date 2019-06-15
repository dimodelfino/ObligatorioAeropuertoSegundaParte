package controladores;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import modelo.FachadaModelo;
import modelo.FrecuenciaDeVuelo;
import modelo.LogicaFrecuenciaVuelo;
import modelo.LogicaVuelo;
import modelo.Vuelo;
import modelo.DiaSemanaEnum;

/**
 *
 * @author majuetcheverry
 */
public class ControladoraAeropuerto implements Observer{


    public IVistaAeropuerto vista;
    
    public ControladoraAeropuerto (IVistaAeropuerto vistApAero){     
        this.vista = vistApAero;
        LogicaFrecuenciaVuelo.getInstancia().addObserver(this);
        LogicaVuelo.getInstancia().addObserver(this);
    }

    public ArrayList<FrecuenciaDeVuelo> frecuenciasPorAeropuerto(String nomAero, String origDest) {
       return LogicaFrecuenciaVuelo.getInstancia().frecuenciaPorAeropuerto(nomAero, origDest);
    }
    

    public DiaSemanaEnum getDiaSemana(int dia) {
        return LogicaFrecuenciaVuelo.getInstancia().getDiaSemana(dia);
    }

    public void aprobarEstadoFrecuencia(FrecuenciaDeVuelo f, String origDest) {
        
        FachadaModelo.getInstancia().aprobarEstadoFrecuencia (f, origDest);

         
    }

    public void rechazarEstadoFrecuencia(FrecuenciaDeVuelo frec, String origDest) {
        FachadaModelo.getInstancia().rechazarEstadoFrecuencia(frec, origDest);
       
    }

    public void agregregarVuelo(FrecuenciaDeVuelo fv) {
        FachadaModelo.getInstancia().agregarVuelo(fv);       
    }

    public ArrayList<Vuelo> getVuelosPorAeropuerto(String nomAero, String origDest) {
        return FachadaModelo.getInstancia().getVuelosPorAeropuerto(nomAero, origDest);
    }
    
    public ArrayList<Vuelo> getVuelosDiarios(String nomAero, String origDest) {
        return FachadaModelo.getInstancia().getVuelosDiarios(nomAero, origDest);
    }    

    public void partioVuelo(Vuelo partida) {
        FachadaModelo.getInstancia().agregarPartidaVuelo(partida);        
    }
    
    public void arriboVuelo(Vuelo arribo){
    FachadaModelo.getInstancia().agregarLlegadaVuelo(arribo);   
    }

    @Override
    public void update(Observable o, Object arg1) {
        if(o == LogicaFrecuenciaVuelo.getInstancia() || o == LogicaVuelo.getInstancia()){
         
            vista.actualizarFrecuenciasPendientesDestino();
            vista.actualizarFrecuenciasPendientesOrigen();
            vista.actualizarVuelosDiarioPartidas();
            vista.actualizarVuelosDiariosArribos();
        }
    }
}
