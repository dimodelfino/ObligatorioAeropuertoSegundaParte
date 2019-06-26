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
        
        
        
         String result = "En hora";

        String[] horaSalidaFrec;
        String stringHoraEstimadaSalida = "01:35:00 AM";
        horaSalidaFrec = stringHoraEstimadaSalida.split(":");

        int soloHoraSupuestaSalida = Integer.parseInt(horaSalidaFrec[0]);
        int minutoSupuestaHoraSalida = Integer.parseInt(horaSalidaFrec[1]);
        String amPm = horaSalidaFrec[2];

        Calendar salidaHoraEstimadaMenosCinco = new GregorianCalendar();
        salidaHoraEstimadaMenosCinco.set(Calendar.MINUTE, minutoSupuestaHoraSalida - 5);
        salidaHoraEstimadaMenosCinco.set(Calendar.HOUR, soloHoraSupuestaSalida);

        Calendar salidaHoraEstimadaMasCinco = new GregorianCalendar();
        salidaHoraEstimadaMasCinco.set(Calendar.MINUTE, minutoSupuestaHoraSalida + 5);
        salidaHoraEstimadaMasCinco.set(Calendar.HOUR, soloHoraSupuestaSalida);

        if (amPm.contains("AM")) {
            salidaHoraEstimadaMenosCinco.set(Calendar.AM_PM, Calendar.AM);
            salidaHoraEstimadaMasCinco.set(Calendar.AM_PM, Calendar.AM);
        } else {
            salidaHoraEstimadaMenosCinco.set(Calendar.AM_PM, Calendar.PM);
            salidaHoraEstimadaMasCinco.set(Calendar.AM_PM, Calendar.PM);
        }
        Calendar horaActual = new GregorianCalendar();

        if (salidaHoraEstimadaMenosCinco.getTime().after(horaActual.getTime())) {
            result = "Adelantado";
        } else if (salidaHoraEstimadaMasCinco.getTime().before(horaActual.getTime())) {
            result = "Retrasado";
        }
        
        System.out.println("result "+result);
        System.out.println("before " + salidaHoraEstimadaMenosCinco.getTime().after(horaActual.getTime()));
        System.out.println("after " + salidaHoraEstimadaMasCinco.getTime().before(horaActual.getTime()));
        System.out.println("hora actual " + horaActual.getTime());        
        System.out.println("menos cinco " + salidaHoraEstimadaMenosCinco.getTime());
        System.out.println("mas cinco " + salidaHoraEstimadaMasCinco.getTime());
    }
}
