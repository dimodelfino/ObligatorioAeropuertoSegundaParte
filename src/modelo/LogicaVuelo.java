/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dmoreno
 */
public class LogicaVuelo {

    private static LogicaVuelo instancia = new LogicaVuelo();
    private static List<Vuelo> vuelos;

    public static LogicaVuelo getInstancia() {
        return instancia;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void iniciatListaVuelos() {
        this.vuelos = new ArrayList<>();                
        Date hoy = new Date();
        Date salidaVuelo;
        Calendar cal = Calendar.getInstance();
        cal.setTime(hoy);                        
        String formatoFechaString = "hh:mm:ss a";
        DateFormat formato = new SimpleDateFormat(formatoFechaString);        
        
        Vuelo a = new Vuelo();
        cal.add(Calendar.DATE, -4);  
        salidaVuelo = cal.getTime();
        String formattedDate= formato.format(hoy);
        a.fechaPartida = (Date)salidaVuelo;        
        a.horaRealPartida = "";
        a.horaRealLlegada = formattedDate;
        
        Vuelo b = new Vuelo();
        //b.nombre = "Ezeiza";
        Vuelo c = new Vuelo();
        //c.nombre = "Barajas";
        Vuelo d = new Vuelo();
        //d.nombre = "Guarulos";
        Vuelo e = new Vuelo();
        //e.nombre = "JFK";
        Vuelo f = new Vuelo();
        //f.nombre = "La Guardia";

        this.vuelos.add(a);
        this.vuelos.add(b);
        this.vuelos.add(c);
        this.vuelos.add(d);
        this.vuelos.add(e);
        this.vuelos.add(f);
    }
}
