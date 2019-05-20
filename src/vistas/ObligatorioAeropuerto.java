/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.util.Calendar;
import java.util.Date;
import modelo.LogicaAeropuerto;
import modelo.LogicaCompania;
import modelo.LogicaFrecuenciaVuelo;
import modelo.LogicaUsuario;

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
        new MenuPrincipal().setVisible(true);
        
        
        //System.out.println(LogicaCompania.getInstancia().getCompanias().get(3).nombre);
        //System.out.println(LogicaAeropuerto.getInstancia().getAeropuertos().get(3).nombre);
        //System.out.println(LogicaUsuario.getInstancia().getUsuarios().get(3).nombre);
        //System.out.println(LogicaFrecuenciaVuelo.getInstancia().getFrecuencias().get(2).numero);
        //System.out.println(LogicaFrecuenciaVuelo.getInstancia().getFrecuencias().get(2).aeropuertoDestino.aeropuerto.nombre);        
        //System.out.println(LogicaFrecuenciaVuelo.getInstancia().getFrecuencias());
    }
}
