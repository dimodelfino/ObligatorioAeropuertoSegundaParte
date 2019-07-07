/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import modelo.Aeropuerto;
import modelo.Compania;
import modelo.FachadaModelo;
import modelo.LogicaFrecuenciaVuelo;
import modelo.LogicaVuelo;
import utilities.ExceptionCompania;
import modelo.DiaSemanaEnum;
import modelo.FrecuenciaDeVuelo;

/**
 *
 * @author dmoreno
 */
public class ControladoraCompania implements Observer{
    
    private IVistaCompania vista;

    public ControladoraCompania(IVistaCompania apC) {
        LogicaFrecuenciaVuelo.getInstancia().addObserver(this);
        LogicaVuelo.getInstancia().addObserver(this);
        vista = apC;
    }
    
    
    public void ValidaIngresaFrecuencia(String aeroOrigen, String aeroDestino, ArrayList<DiaSemanaEnum> diaSemana, String horaPartida,
            String minutosPartida, String horaDuracion, String minutosDuracion,
            String amPm, Compania c) throws utilities.ExceptionCompania{        
        if (!aeroOrigen.equals(aeroDestino)) {
            if (diaSemana.size() == 0 || amPm == null || (horaPartida.equals("00") && minutosPartida.equals("00")) || (horaDuracion.equals("00") && minutosDuracion.equals("00"))) {                
                throw new utilities.ExceptionCompania("Debe ingresar todos los datos.");
            } else {                    
                this.IngresoFrecuenciaVuelo(aeroOrigen, aeroDestino, diaSemana, horaPartida, minutosPartida, horaDuracion, minutosDuracion, amPm, c);                    
            }
        } else {            
             throw new utilities.ExceptionCompania("El Aeropuerto de origen y el de destino no pueden ser iguales.");
        }        
    }
    

    public void IngresoFrecuenciaVuelo(String aeroOrigen, String aeroDestino, ArrayList<DiaSemanaEnum> diaSemana, String horaPartida,
            String minutosPartida, String horaDuracion, String minutosDuracion,
            String amPm, Compania c) throws ExceptionCompania{
        
        String numeroFrecuencia = this.generarNumeroFrecuencia(c);
        String partida = horaPartida + ":" + minutosPartida + ":00" + " " + amPm;
        String duracion = horaDuracion + ":" + minutosDuracion + ":00";
        FachadaModelo.getInstancia().agregarFrecuencia(numeroFrecuencia, aeroOrigen, aeroDestino, partida, duracion, c, diaSemana);
    }

    public String generarNumeroFrecuencia(Compania c) {        
        return FachadaModelo.getInstancia().generarNumeroFrecuencia(c);
    }
    
    public List<Aeropuerto> getAeropuertos(){
        return FachadaModelo.getInstancia().getAeropuertos();
    }
    
     public ArrayList<FrecuenciaDeVuelo> getFrecuencias(){
         return FachadaModelo.getInstancia().getFrecuencias();
     }
     
     public ArrayList<String> getVuelosString(FrecuenciaDeVuelo fv){
         return FachadaModelo.getInstancia().getVuelosString(fv);
     }

    @Override
    public void update(Observable o, Object arg1) {
        if(o == LogicaFrecuenciaVuelo.getInstancia() || o == LogicaVuelo.getInstancia()){
            vista.actualizarFrecuencias();
            vista.actualizarVuelosPorFrecuencia();
        }
    }
}
