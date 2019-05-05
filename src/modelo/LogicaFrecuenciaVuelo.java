/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dmoreno
 */
public class LogicaFrecuenciaVuelo {
    
    private List<LogicaFrecuenciaVuelo> frecuencias;
    private static LogicaFrecuenciaVuelo instancia = new LogicaFrecuenciaVuelo();

    public static LogicaFrecuenciaVuelo getInstancia(){
        return instancia;
    }     
    
    public List<LogicaFrecuenciaVuelo> getFrecuencias(){
         return frecuencias;
     }

    public void GuardarFrecuencia(LogicaFrecuenciaVuelo fv){
        
    }
//    public bool ingresarFrecuencia(String partida, float duracion, String aeropuertoOrigen, String aeropuertoDestino, String diasSemana){
//        
//         
//    }
//    
}
