/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

<<<<<<< HEAD
import java.util.ArrayList;
=======
import modelo.Aeropuerto;
>>>>>>> 5a548fb15c108bf1eecca0ddc02eff0b15e9b359
import modelo.Compania;
import modelo.FachadaModelo;
import vistas.DiaSemanaEnum;

/**
 *
 * @author dmoreno
 */
public class ControladoraCompania {

    private static ControladoraCompania instancia = new ControladoraCompania();
    private static int contador = 0;

    public static ControladoraCompania getInstancia() {
        return instancia;
    }
    

    public boolean IngresoFrecuenciaVuelo(String aeroOrigen, String aeroDestino, ArrayList <DiaSemanaEnum> diaSemana, String horaPartida,
            String minutosPartida, String horaDuracion, String minutosDuracion,
            String amPm, Compania c) {
        String numeroFrecuencia = this.generarNumeroFrecuencia(c);        
        String partida = horaPartida + ":" + minutosPartida + " " + amPm;
        String duracion = horaDuracion + ":" + minutosDuracion;                
        return FachadaModelo.getInstancia().agregarFrecuencia(numeroFrecuencia, aeroOrigen, aeroDestino, partida, duracion, c, diaSemana);
    }

    public String generarNumeroFrecuencia(Compania c) {
        String alias = c.alias + contador++;
        return alias;
    }

}
