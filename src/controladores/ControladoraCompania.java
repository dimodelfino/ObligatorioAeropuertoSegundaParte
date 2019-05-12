/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import modelo.Aeropuerto;
import modelo.Compania;
import modelo.Estado;
import modelo.FachadaModelo;
import modelo.FrecuenciaDeVuelo;
import modelo.LogicaAeropuerto;
import vistas.DiaSemanaEnum;

/**
 *
 * @author dmoreno
 */
public class ControladoraCompania {

    private static ControladoraCompania instancia = new ControladoraCompania();
    private static int contador = 0000;

    public static ControladoraCompania getInstancia() {
        return instancia;
    }

    public void IngresoFrecuenciaVuelo(String aeroOrigen, String aeroDestino, DiaSemanaEnum diaSemana, String horaPartida,
            String minutosPartida, String horaDuracion, String minutosDuracion,
            String amPm, Compania c) {
        String numeroFrecuencia = this.generarNumeroFrecuencia(c);
        Aeropuerto origen = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre(aeroOrigen);
        Aeropuerto destino = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre(aeroDestino);
        String partida = horaPartida + ":" + minutosPartida + " " + amPm;
        String duracion = horaDuracion + ":" + minutosDuracion;
        Estado eOrigen = new Estado(origen);
        Estado eDestino = new Estado(destino);       
        FrecuenciaDeVuelo fv = new FrecuenciaDeVuelo(numeroFrecuencia, eOrigen, eDestino, partida, duracion, c, diaSemana);
        FachadaModelo.getInstancia().agregarFrecuencia(fv);
    }

    public String generarNumeroFrecuencia(Compania c) {
        String alias = c.alias + contador++;
        return alias;
    }
}
