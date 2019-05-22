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

/**
 *
 * @author dmoreno
 */
public class LogicaVuelo {

    private static LogicaVuelo instancia = new LogicaVuelo();
    //Borrar la pRTE = new ArrayList<>()
    private static ArrayList<Vuelo> vuelos = new ArrayList<>();

    public static LogicaVuelo getInstancia() {
        return instancia;
    }

    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }

    public void crearVuelo(FrecuenciaDeVuelo fv) {
        Vuelo v = new Vuelo();
        v.fVuelo = fv;
        this.vuelos.add(v);
    }

    public void agregarPartidaVuelo(Vuelo partida) {
        boolean encontro = false;
        int i = 0;
        Date hoy = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(hoy);
        DateFormat formato = new SimpleDateFormat("hh:mm:ss a");
        DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        String horaActual = formato.format(hoy);
        while (!encontro && !vuelos.isEmpty() && i < vuelos.size()) {
            if (vuelos.get(i).equals(partida)) {
                Vuelo variable = vuelos.get(i);
                variable.horaRealPartida = horaActual;
                variable.fechaPartida = (String) fecha.format(hoy);
                String e = this.calcularEstado(variable.fVuelo.horaPartida, horaActual);
                variable.estado = e;
                vuelos.set(i, variable);
                //vuelos.add(i, variable);
                encontro = true;
            }
            i++;
        }
    }

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
                encontro = true;
                vuelos.set(i, vue);
              //  vuelos.add(i, vue);
            }
            i++;
        }
    }

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
        if (soloHoraSupuestaSalida < soloHoraRealSalida ) {
            result = "Retrasado";}
        else if(soloHoraSupuestaSalida == soloHoraRealSalida && ((minutoSupuestaHoraSalida - 5)<= minutoRealSalida) && ((minutoSupuestaHoraSalida + 5)>= minutoRealSalida)){
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
      //  cal.add(Calendar.DATE, -4);
        salidaVuelo = cal.getTime();
        String horaActual = formato.format(hoy);
        a.fVuelo = LogicaFrecuenciaVuelo.getInstancia().getFrecuencias().get(3);
        a.fechaPartida = "21/05/2019";        
        a.horaRealPartida = horaActual;
        //a.horaRealLlegada = "";
        a.estado = "En hora";

        Vuelo b = new Vuelo();
        cal.add(Calendar.DATE, -3);
        salidaVuelo = cal.getTime();
        // String horaActual = formato.format(hoy);
        a.fVuelo = LogicaFrecuenciaVuelo.getInstancia().getFrecuencias().get(2);
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

//        this.vuelos.add(b);
//        this.vuelos.add(c);
//        this.vuelos.add(d);
//        this.vuelos.add(e);
//        this.vuelos.add(f);
    }
}
