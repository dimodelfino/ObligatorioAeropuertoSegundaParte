/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import modelo.Compania;
import modelo.FachadaModelo;
import modelo.LogicaFrecuenciaVuelo;
import modelo.LogicaVuelo;
import utilities.ExceptionCompania;
import vistas.AplicacionCompania;
import vistas.DiaSemanaEnum;

/**
 *
 * @author dmoreno
 */
public class ControladoraCompania implements Observer{

    private static int contador = 5;
    private AplicacionCompania vista;

    public ControladoraCompania(AplicacionCompania apC) {
        LogicaFrecuenciaVuelo.getInstancia().addObserver(this);
        LogicaVuelo.getInstancia().addObserver(this);
        this.vista = apC;
    }
    
    
    public boolean ValidaIngresaFrecuencia(String aeroOrigen, String aeroDestino, ArrayList<DiaSemanaEnum> diaSemana, String horaPartida,
            String minutosPartida, String horaDuracion, String minutosDuracion,
            String amPm, Compania c) throws utilities.ExceptionCompania{
        boolean ingreso = false;
        if (!aeroOrigen.equals(aeroDestino)) {
            if (diaSemana.size() == 0 || amPm == null || (horaPartida.equals("00") && minutosPartida.equals("00")) || (horaDuracion.equals("00") && minutosDuracion.equals("00"))) {                
                throw new utilities.ExceptionCompania("Debe ingresar todos los datos.");
            } else {                    
                if (this.IngresoFrecuenciaVuelo(aeroOrigen, aeroDestino, diaSemana, horaPartida, minutosPartida, horaDuracion, minutosDuracion, amPm, c)) {
                    ingreso = true;                
                }                
            }
        } else {            
             throw new utilities.ExceptionCompania("El Aeropuerto de origen y el de destino no pueden ser iguales.");
        }
        return ingreso;
    }
    

    public boolean IngresoFrecuenciaVuelo(String aeroOrigen, String aeroDestino, ArrayList<DiaSemanaEnum> diaSemana, String horaPartida,
            String minutosPartida, String horaDuracion, String minutosDuracion,
            String amPm, Compania c) throws ExceptionCompania{
        
        String numeroFrecuencia = this.generarNumeroFrecuencia(c);
        String partida = horaPartida + ":" + minutosPartida + ":00" + " " + amPm;
        String duracion = horaDuracion + ":" + minutosDuracion + ":00";
        return FachadaModelo.getInstancia().agregarFrecuencia(numeroFrecuencia, aeroOrigen, aeroDestino, partida, duracion, c, diaSemana);
    }

    public String generarNumeroFrecuencia(Compania c) {
        String alias = c.alias + contador++;
        return alias;
    }

    @Override
    public void update(Observable o, Object arg1) {
        if(o == LogicaFrecuenciaVuelo.getInstancia() || o == LogicaVuelo.getInstancia()){
            vista.actualizarListas();
        }
    }

}
