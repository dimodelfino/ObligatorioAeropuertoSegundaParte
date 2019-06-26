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
    //public FrecuenciaDeVuelo fVuelo;
    public String numero;
    public String fechaPartida;
    public String horaRealPartida;
    public String horaRealLlegada;
    public String estado;
    public int arancelPartida;
    public int arancelLlegada;
    public int oId;
    
     @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
        FrecuenciaDeVuelo fVuelo = FachadaModelo.getInstancia().buscarFrecuencia(numero);
        String result = dateFormat.format(date) + " -- " + numero + " -- " + fVuelo.aeropuertoDestino.nombre + " -- " + fVuelo.horaPartida;
        if(horaRealPartida != null){
            result = numero + " -- " + fVuelo.aeropuertoOrigen.nombre + " -- " + fVuelo.horaPartida + " -- " + estado;
        }else if (horaRealPartida != null && horaRealLlegada != null){
            
        }       
        return result;
    }
        
}
