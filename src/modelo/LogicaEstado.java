/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.List;

/**
 *
 * @author dmoreno
 */
public class LogicaEstado {
    private List<Estado> estados;
    private static LogicaEstado instancia = new LogicaEstado();

    public static LogicaEstado getInstancia(){
        return instancia;
    }     
    
    public List<Estado> getEstados(){
         return estados;
     }
  
    
}
