/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
    public DiaSemanaEnum diasSemana;
    
    
    public FrecuenciaDeVuelo (String num, Estado origen, Estado destino, String hrPartida, String duracionEst, Compania c, DiaSemanaEnum diasSem){
        numero = num;
        aeropuertoOrigen = origen;
        aeropuertoDestino = destino;
        horaPartida = hrPartida;
        duracionEstimada = duracionEst;
        compania = c;
        diasSemana = diasSem;   
    }
}
