/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import modelo.LogicaAeropuerto;
import modelo.LogicaCompania;
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
        LogicaAeropuerto.getInstancia().iniciateAirportsList();
//        System.out.println(LogicaAeropuerto.getInstancia().getAeropuertos().get(3).nombre);
        
        LogicaUsuario.getInstancia().iniciateUsersList();
        //System.out.println(LogicaUsuario.getInstancia().getUsuarios().get(3).nombre);
        
        LogicaCompania.getInstancia().iniciateCompanyList();
        //System.out.println(LogicaCompania.getInstancia().getCompanias().get(3).nombre);
    new MenuPrincipal().setVisible(true);
    }
}
