/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dmoreno
 */
public class LogicaFrecuenciaVuelo {
    
    private List<FrecuenciaDeVuelo> frecuencias = new ArrayList <FrecuenciaDeVuelo>();
    private static LogicaFrecuenciaVuelo instancia = new LogicaFrecuenciaVuelo();

    public static LogicaFrecuenciaVuelo getInstancia(){
        return instancia;
    }     
    
    public List<FrecuenciaDeVuelo> getFrecuencias(){
         return frecuencias;
     }

    public void GuardarFrecuencia(FrecuenciaDeVuelo fv){
        this.frecuencias.add(fv);
    } 
}
