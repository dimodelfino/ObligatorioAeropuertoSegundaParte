/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;
import modelo.FachadaModelo;
import modelo.FrecuenciaDeVuelo;
import vistas.DiaSemanaEnum;

/**
 *
 * @author dmoreno
 */
public class ControladoraCompania {
    
     private static ControladoraCompania instancia = new ControladoraCompania();

    public static ControladoraCompania getInstancia(){
        return instancia;
    } 
    
    //FALTAN AGREGAR ATRIBUTOS A LA FRECUENCIA
    public void IngresoFrecuenciaVuelo(DiaSemanaEnum diaSemana, String horaPartida,
            String minutosPartida, String horaDuracion, String minutosDuracion,
            String amPm) {
        String partida = horaPartida + ":" + minutosPartida;
        String duracion = horaDuracion + ":" + minutosDuracion;
        FrecuenciaDeVuelo fv = new FrecuenciaDeVuelo();
        fv.diasSemana = diaSemana;  
        fv.horaPartida = partida;
        fv.duracionEstimada = duracion;
        fv.amPm = amPm;
        FachadaModelo.getInstancia().agregarFrecuencia(fv);            
    }
         
}
