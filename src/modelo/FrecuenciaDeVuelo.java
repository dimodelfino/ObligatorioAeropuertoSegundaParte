/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import vistas.DiaSemanaEnum;

/**
 *
 * @author dmoreno
 */
public class FrecuenciaDeVuelo {

    public String numero;
    public Estado aeropuertoOrigen;
    public Estado aeropuertoDestino;
    public String horaPartida;
    public String duracionEstimada;
    public Compania compania;
    public ArrayList<DiaSemanaEnum> diasSemana = new ArrayList<>();

    public FrecuenciaDeVuelo() {};
    
    public FrecuenciaDeVuelo(String num, Estado origen, Estado destino, String hrPartida, String duracionEst, Compania c, ArrayList<DiaSemanaEnum> diasSem) {

        numero = num;
        aeropuertoOrigen = origen;
        aeropuertoDestino = destino;
        horaPartida = hrPartida;
        duracionEstimada = duracionEst;
        compania = c;
        diasSemana = diasSem;
    }

    @Override
    public String toString() {

        return numero + " || " + aeropuertoOrigen.aeropuerto.nombre + " || " + aeropuertoOrigen.estado + " || " + aeropuertoDestino.aeropuerto.nombre
                + " || " + aeropuertoDestino.estado + " || " + diasSemana + " || " + horaPartida + " || " + duracionEstimada;
    }
}
