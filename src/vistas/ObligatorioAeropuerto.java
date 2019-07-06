/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;


import java.util.Calendar;
import java.util.GregorianCalendar;
import modelo.LogicaAeropuerto;
import modelo.LogicaCompania;
import modelo.LogicaFrecuenciaVuelo;
import modelo.LogicaUsuario;
import modelo.LogicaVuelo;

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
        LogicaVuelo.getInstancia().iniciateListaVuelos();
        new MenuPrincipal().setVisible(true);  
                                
    }
}
