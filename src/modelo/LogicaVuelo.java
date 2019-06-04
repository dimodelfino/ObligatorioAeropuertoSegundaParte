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
import java.util.Observable;

/**
 *
 * @author dmoreno
 */
public class LogicaVuelo extends Observable{

    private static LogicaVuelo instancia = null;    
    private static ArrayList<Vuelo> vuelos = new ArrayList<>();

    public static LogicaVuelo getInstancia() {
        if (instancia == null) {
            instancia = new LogicaVuelo();
        }
        return instancia;
    }

    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }

    //Crea y guarda un vuelo con la frecuencia de vuelo pasada por parametro
    public void crearVuelo(FrecuenciaDeVuelo fv) {
        Vuelo v = new Vuelo();
        v.fVuelo = fv;        
        Date hoy = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(hoy);
        DateFormat formato = new SimpleDateFormat("hh:mm:ss a");
        DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        String horaActual = formato.format(hoy);
        v.horaRealPartida = horaActual;
        v.fechaPartida = (String) fecha.format(hoy);
        String e = this.calcularEstado(v.fVuelo.horaPartida, horaActual);
        v.estado = e;
        this.vuelos.add(v);    
        notificarObservadores();
    }

    //Agrega los datos necesarios al vuelo cuando despega.
    public void agregarPartidaVuelo(Vuelo partida) {
        boolean encontro = false;
        int i = 0;
        Date hoy = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(hoy);
        DateFormat formato = new SimpleDateFormat("hh:mm:ss a");
        DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        String horaActual = formato.format(hoy);
        while (!encontro && vuelos.size() != 0 && i < vuelos.size()) {
            if (vuelos.get(i).equals(partida)) {
                Vuelo variable = vuelos.get(i);
                variable.horaRealPartida = horaActual;
                variable.fechaPartida = (String) fecha.format(hoy);
                String e = this.calcularEstado(variable.fVuelo.horaPartida, horaActual);
                variable.estado = e;
                vuelos.set(i, variable);
                encontro = true;
            }
            i++;
        }
        notificarObservadores();
    }

    //Agrega los datos necesarios al vuelo cuando aterriza.
    public void agregarLlegadaVuelo(Vuelo arribo) {
        boolean encontro = false;
        int i = 0;
        Date hoy = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(hoy);
        DateFormat formato = new SimpleDateFormat("hh:mm:ss a");
        String horaActual = formato.format(hoy);

        while (!encontro && !vuelos.isEmpty() && i < vuelos.size()) {
            if (vuelos.get(i).equals(arribo)) {
                Vuelo vue = vuelos.get(i);
                vue.horaRealLlegada = horaActual;
                vue.estado = "Aterrizo";
                encontro = true;
                vuelos.set(i, vue);                
            }
            i++;
        }
        notificarObservadores();
    }

    //Calcula el estado (Adelantado, Retrasado, En hora) dependiendo de la hora real
    public String calcularEstado(String horaSalidaFrecuencia, String horaRealSalida) {

        String[] horaSalidaFrec;
        String[] horaReal;

        horaSalidaFrec = horaSalidaFrecuencia.split(":");
        horaReal = horaRealSalida.split(":");

        int soloHoraSupuestaSalida = Integer.parseInt(horaSalidaFrec[0]);
        int minutoSupuestaHoraSalida = Integer.parseInt(horaSalidaFrec[1]);
        int soloHoraRealSalida = Integer.parseInt(horaReal[0]);
        int minutoRealSalida = Integer.parseInt(horaReal[1]);

        String result = "Adelantado";
        if (soloHoraSupuestaSalida < soloHoraRealSalida) {
            result = "Retrasado";
        } else if (soloHoraSupuestaSalida == soloHoraRealSalida && ((minutoSupuestaHoraSalida - 5) <= minutoRealSalida) && ((minutoSupuestaHoraSalida + 5) >= minutoRealSalida)) {
            result = "En hora";
        }        
        return result;
    }

    public void iniciatListaVuelos() {
        this.vuelos = new ArrayList<>();
        Date hoy = new Date();
        Date salidaVuelo;
        Calendar cal = Calendar.getInstance();
        cal.setTime(hoy);
        DateFormat formato = new SimpleDateFormat("hh:mm:ss a");

        Vuelo a = new Vuelo();        
        salidaVuelo = cal.getTime();
        String horaActual = formato.format(hoy);
        a.fVuelo = LogicaFrecuenciaVuelo.getInstancia().getFrecuencias().get(3);
        a.fechaPartida = "21/05/2019";
        a.horaRealPartida = horaActual;
        a.horaRealLlegada = "22:10:00 AM";
        a.estado = "VUELO TEST";        
        this.vuelos.add(a);
        notificarObservadores();
    }
    
    public void notificarObservadores(){
        setChanged();
        notifyObservers();
    }
}
