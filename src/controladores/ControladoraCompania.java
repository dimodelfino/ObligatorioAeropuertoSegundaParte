/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.ArrayList;
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

    public void iniciateFrecuenciaVueloList() {
        Compania c = new Compania();
        this.IngresoFrecuenciaVuelo("Carrasco", "Ezeiza", DiaSemanaEnum.M, "1", "2", "5", "8", "Am", c);
        this.IngresoFrecuenciaVuelo("Barajas", "JFK", DiaSemanaEnum.X, "2", "3", "6", "9", "Pm", c);
        this.IngresoFrecuenciaVuelo("La Guardia", "Barajas", DiaSemanaEnum.J, "3", "4", "7", "0", "Am", c);
        this.IngresoFrecuenciaVuelo("Guarulos", "Carrasco", DiaSemanaEnum.L, "4", "5", "8", "1", "Pm", c);

    }

    public boolean IngresoFrecuenciaVuelo(String aeroOrigen, String aeroDestino, DiaSemanaEnum diaSemana, String horaPartida,
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
        return FachadaModelo.getInstancia().agregarFrecuencia(fv);
    }

    public String generarNumeroFrecuencia(Compania c) {
        String alias = c.alias + contador++;
        return alias;
    }

}
