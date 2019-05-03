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
public class LogicaAeropuerto {    
    private static List<Aeropuerto> aeropuertos;
    private static LogicaAeropuerto instancia = new LogicaAeropuerto();
    
     public static LogicaAeropuerto getInstancia(){
        return instancia;
    }
     
     public List<Aeropuerto> getAeropuertos(){
         return aeropuertos;
     }

    public void iniciateAirportsList() {   
        this.aeropuertos = new ArrayList<Aeropuerto>();
        for (int x = 0; x < 4; x++) {
            Aeropuerto a = new Aeropuerto();
            a.nombre = "aerop " + x;              
            this.aeropuertos.add(a);
        }
    }
    
}
