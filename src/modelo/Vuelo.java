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
    
    public String numero;
    public String fechaPartida;
    public String horaRealPartida;
    public String horaRealLlegada;
    public String estado;
    public int arancelPartida;
    public int arancelLlegada;
    public int oId;
    private int oIdFrecuenciaVuelo;
    
    public Vuelo(){
        
    }
    
    public Vuelo(String numero, String fechaPartida, String horaRealPartida, String horaRealLlegada, String estado, int arancelPartida, int arancelLlegada, int oId, int idFrecuenciaVuelo){
        this.numero = numero;
        this.fechaPartida = fechaPartida;
        this.horaRealPartida = horaRealPartida;
        this.horaRealLlegada = horaRealLlegada;
        this.estado = estado;
        this.arancelPartida = arancelPartida;
        this.arancelLlegada = arancelLlegada;
        this.oId = oId;
        this.oIdFrecuenciaVuelo = idFrecuenciaVuelo;
    }
    
    public int getOidFrecVuelo(){
        return this.oIdFrecuenciaVuelo;
    }
    
    public void setOidFrecVuelo(int oidFrecV){
        this.oIdFrecuenciaVuelo = oidFrecV;
    }
    
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
