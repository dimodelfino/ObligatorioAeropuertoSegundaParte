/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import modelo.LogicaAeropuerto;
import modelo.LogicaCompania;
import modelo.LogicaFrecuenciaVuelo;
import modelo.LogicaUsuario;
import modelo.LogicaVuelo;
import modelo.Vuelo;

/**
 *
 * @author dmoreno
 */
public class ObligatorioAeropuerto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LogicaCompania.getInstancia().iniciateCompanyList();        
        LogicaAeropuerto.getInstancia().iniciateAirportsList();        
        LogicaUsuario.getInstancia().iniciateUsersList();        
        LogicaFrecuenciaVuelo.getInstancia().iniciateFrecuenciaVueloList();
        LogicaVuelo.getInstancia().iniciatListaVuelos();
        new MenuPrincipal().setVisible(true);


        Date hoy = new Date();
        Date salidaVuelo;
        Calendar cal = Calendar.getInstance();
        System.out.println("Cal solo: " + cal);
        cal.setTime(hoy);                                
        System.out.println("Cal con hora: " + cal);
        DateFormat formato = new SimpleDateFormat("hh:mm:ss a");        
                
        cal.add(Calendar.DATE, -4);  
        System.out.println("Cal con 4 das mas: " + cal);
        salidaVuelo = cal.getTime();
        System.out.println("Cal get time: " + cal);
        String horaActual = formato.format(hoy);
        System.out.println("hora actual: " + horaActual);
        
        //System.out.println(LogicaCompania.getInstancia().getCompanias().get(3).nombre);
        //System.out.println(LogicaAeropuerto.getInstancia().getAeropuertos().get(3).nombre);
        //System.out.println(LogicaUsuario.getInstancia().getUsuarios().get(3).nombre);
        //System.out.println(LogicaFrecuenciaVuelo.getInstancia().getFrecuencias().get(2).numero);
        //System.out.println(LogicaFrecuenciaVuelo.getInstancia().getFrecuencias().get(2).aeropuertoDestino.aeropuerto.nombre);        
        //System.out.println(LogicaFrecuenciaVuelo.getInstancia().getFrecuencias());
    }
}
