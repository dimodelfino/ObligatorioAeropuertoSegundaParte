package controladores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
import modelo.EstadoEnum;
import modelo.FachadaModelo;
import modelo.FrecuenciaDeVuelo;
import modelo.LogicaFrecuenciaVuelo;
import modelo.LogicaVuelo;
import modelo.Vuelo;
import vistas.AplicacionAeropuerto;
import vistas.DiaSemanaEnum;

/**
 *
 * @author majuetcheverry
 */
public class ControladoraAeropuerto implements Observer{


    public AplicacionAeropuerto vista;
    
    public ControladoraAeropuerto (AplicacionAeropuerto vistApAero){     
        this.vista = vistApAero;
        LogicaFrecuenciaVuelo.getInstancia().addObserver(this);
        LogicaVuelo.getInstancia().addObserver(this);
    }

    public ArrayList<FrecuenciaDeVuelo> frecuenciasPorAeropuerto(String nomAero, String origDest) {
        ArrayList<FrecuenciaDeVuelo> f = FachadaModelo.getInstancia().getFrecuencias();
        ArrayList<FrecuenciaDeVuelo> frecuenciasFiltradas = new ArrayList<>();

        for (FrecuenciaDeVuelo frec : f) {
            if (origDest.equals("Origen")) {
                if (frec.aeropuertoOrigen.estado.equals(EstadoEnum.Pendiente)
                        && frec.aeropuertoOrigen.aeropuerto.nombre.equals(nomAero)) {
                    frecuenciasFiltradas.add(frec);
                }
            } else {
                if (frec.aeropuertoDestino.estado.equals(EstadoEnum.Pendiente) && frec.aeropuertoOrigen.estado.equals(EstadoEnum.Aprobado)
                        && frec.aeropuertoDestino.aeropuerto.nombre.equals(nomAero)) {
                    frecuenciasFiltradas.add(frec);
                }
            }
        }
        return frecuenciasFiltradas;
    }

    public DiaSemanaEnum getDiaSemana(int dia) {
        DiaSemanaEnum diaSemana = DiaSemanaEnum.D;

        switch (dia) {
            case Calendar.MONDAY:
                diaSemana = DiaSemanaEnum.L;
                break;
            case Calendar.TUESDAY:
                diaSemana = DiaSemanaEnum.M;
                break;
            case Calendar.WEDNESDAY:
                diaSemana = DiaSemanaEnum.X;
                break;
            case Calendar.THURSDAY:
                diaSemana = DiaSemanaEnum.J;
                break;
            case Calendar.FRIDAY:
                diaSemana = DiaSemanaEnum.V;
                break;
            case Calendar.SATURDAY:
                diaSemana = DiaSemanaEnum.S;
                break;
        }
        return diaSemana;
    }

    public void aprobarEstadoFrecuencia(FrecuenciaDeVuelo f, String origDest) {
        ArrayList<FrecuenciaDeVuelo> frecuencias = FachadaModelo.getInstancia().getFrecuencias();

        for (FrecuenciaDeVuelo frecuen : frecuencias) {
            if (origDest.equals("Destino")) {
                if (frecuen.equals(f) && frecuen.aeropuertoDestino.estado.equals(EstadoEnum.Pendiente)) {
                    frecuen.aeropuertoDestino.estado = EstadoEnum.Aprobado;
                }
            } else {
                if (frecuen.equals(f) && frecuen.aeropuertoOrigen.estado.equals(EstadoEnum.Pendiente)) {
                    frecuen.aeropuertoOrigen.estado = EstadoEnum.Aprobado;
                }
            }
        }
        FachadaModelo.getInstancia().actualizarFrecuencias(frecuencias);        
    }

    public void rechazarEstadoFrecuencia(FrecuenciaDeVuelo frec, String origDest) {
        ArrayList<FrecuenciaDeVuelo> frecuencias = FachadaModelo.getInstancia().getFrecuencias();

        for (FrecuenciaDeVuelo frecuen : frecuencias) {
            if (origDest.equals("Origen")) {
                if (frecuen.equals(frec) && frecuen.aeropuertoOrigen.estado.equals(EstadoEnum.Pendiente)) {
                    frecuen.aeropuertoOrigen.estado = EstadoEnum.Rechazado;
                }
            } else {
                if (frecuen.equals(frec) && frecuen.aeropuertoOrigen.estado.equals(EstadoEnum.Aprobado)) {
                    frecuen.aeropuertoDestino.estado = EstadoEnum.Rechazado;
                }
            }
        }
        FachadaModelo.getInstancia().actualizarFrecuencias(frecuencias);        
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
            vista.actualizarListas();
        }
    }
}
