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
        this.vista = apC;
    }

    public boolean IngresoFrecuenciaVuelo(String aeroOrigen, String aeroDestino, ArrayList<DiaSemanaEnum> diaSemana, String horaPartida,
            String minutosPartida, String horaDuracion, String minutosDuracion,
            String amPm, Compania c) {
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
        if(o == LogicaFrecuenciaVuelo.getInstancia()){
            vista.actualizarListas();
        }
    }

}
