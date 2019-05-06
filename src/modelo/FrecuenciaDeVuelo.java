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

    public int numero;
    public String horaPartida;
    public float duracionEstimada;
    public LogicaEstado aeropuertoOrigen;
    public LogicaEstado aeropuertoDestino;
    public LogicaCompania compania;
    public DiaSemanaEnum diasSemana;

}
