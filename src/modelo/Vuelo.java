/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author dmoreno
 */
public class Vuelo {
    public FrecuenciaDeVuelo fVuelo;
    public String fechaPartida;
    public String horaRealPartida;
    public String horaRealLlegada;
    public String estado;
    
    
     @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
        String result = dateFormat.format(date) + " -- " + fVuelo.numero + " -- " + fVuelo.aeropuertoDestino.aeropuerto.nombre + " -- " + fVuelo.horaPartida;
        if(horaRealPartida != null){
            result = fVuelo.numero + " -- " + fVuelo.aeropuertoOrigen.aeropuerto.nombre + " -- " + fVuelo.horaPartida + " -- " + estado;
        }else if (horaRealPartida != null && horaRealLlegada != null){
            
        }       
        return result;
    }
}
