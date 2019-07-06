/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Mapeadores.MapeadorVuelo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Observable;
import persistencia.BaseDatos;
import persistencia.Persistencia;

/**
 *
 * @author dmoreno
 */
public class LogicaVuelo extends Observable {

    private static LogicaVuelo instancia = null;
    //private static ArrayList<Vuelo> vuelos = new ArrayList<>();

    public static LogicaVuelo getInstancia() {
        if (instancia == null) {
            instancia = new LogicaVuelo();
        }
        return instancia;
    }

//    public ArrayList<Vuelo> getVuelos() {
//        return vuelos;
//    }
    //Crea y guarda un vuelo con el numero de frecuencia de vuelo pasada por parametro       
    public FrecuenciaDeVuelo crearVuelo(FrecuenciaDeVuelo fv, Vuelo v) {
        Date hoy = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(hoy);
        DateFormat formato = new SimpleDateFormat("hh:mm:ss a");
        DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        String horaActual = formato.format(hoy);
        v.horaRealPartida = horaActual;
        v.fechaPartida = (String) fecha.format(hoy);
        String e = this.calcularEstado(fv.horaPartida);
        v.estado = e;
        v.arancelPartida = fv.aeropuertoOrigen.tipo.CalcularArancelPartida(v.estado, v, calcularMinutosRetraso(fv.horaPartida, horaActual));
        fv.vuelos.add(v);
        notificarObservadores();
        return fv;
    }

    //Agrega los datos necesarios al vuelo cuando aterriza.
    public FrecuenciaDeVuelo agregarLlegadaVuelo(FrecuenciaDeVuelo fv, Vuelo arribo) {
        boolean encontro = false;
        int i = 0;
        Date hoy = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(hoy);
        DateFormat formato = new SimpleDateFormat("hh:mm:ss a");
        String horaActual = formato.format(hoy);

        while (!encontro && i < fv.vuelos.size()) {
            if (fv.vuelos.get(i).equals(arribo)) {
                Vuelo vue = fv.vuelos.get(i);
                vue.horaRealLlegada = horaActual;
                vue.estado = "Aterrizo";
                vue.arancelLlegada = fv.aeropuertoDestino.tipo.CalcularArancelLlegada(fv.aeropuertoOrigen);
                fv.vuelos.set(i, vue);
                encontro = true;
            }
            i++;
        }
        notificarObservadores();
        return fv;
    }

    public int calcularMinutosRetraso(String horaEstimadaSalida, String horaRealSalida) {
        int minutosRetrasado;
        String[] horaSalidaEstimada;
        String stringHoraEstimadaSalida = horaEstimadaSalida;
        horaSalidaEstimada = stringHoraEstimadaSalida.split(":");

        String[] horaSalidaReal;
        String stringHoraRealSalida = horaRealSalida;
        horaSalidaReal = stringHoraRealSalida.split(":");

        int soloHoraSalidaEstimada = Integer.parseInt(horaSalidaEstimada[0]);
        int soloMinutosSalidaEstimada = Integer.parseInt(horaSalidaEstimada[1]);
        String amPmEstimado = horaSalidaEstimada[2];

        int soloHoraSalidaReal = Integer.parseInt(horaSalidaReal[0]);
        int soloMinutosSalidaReal = Integer.parseInt(horaSalidaReal[1]);
        String amPmReal = horaSalidaReal[2];

        Calendar salidaHoraEstimada = new GregorianCalendar();
        salidaHoraEstimada.set(Calendar.MINUTE, soloMinutosSalidaEstimada);
        salidaHoraEstimada.set(Calendar.HOUR, soloHoraSalidaEstimada);

        Calendar salidaHoraReal = new GregorianCalendar();
        salidaHoraReal.set(Calendar.MINUTE, soloMinutosSalidaReal);
        salidaHoraReal.set(Calendar.HOUR, soloHoraSalidaReal);

        if (amPmEstimado.contains("AM")) {
            salidaHoraEstimada.set(Calendar.AM_PM, Calendar.AM);
        } else {
            salidaHoraEstimada.set(Calendar.AM_PM, Calendar.PM);
        }
        if (amPmReal.contains("AM")) {
            salidaHoraReal.set(Calendar.AM_PM, Calendar.AM);
        } else {
            salidaHoraReal.set(Calendar.AM_PM, Calendar.PM);
        }
        long timeDifInMilliSec = salidaHoraReal.getTimeInMillis() - salidaHoraEstimada.getTimeInMillis();
        long timeDifMinutes = timeDifInMilliSec / (60 * 1000);
        minutosRetrasado = (int) timeDifMinutes;
        return minutosRetrasado;
    }

    //Calcula el estado (Adelantado, Retrasado, En hora) dependiendo de la hora real
    public String calcularEstado(String horaSalidaFrecuencia) {
        String result = "En hora";

        String[] horaSalidaFrec;
        String stringHoraEstimadaSalida = horaSalidaFrecuencia;
        horaSalidaFrec = stringHoraEstimadaSalida.split(":");

        int soloHoraSupuestaSalida = Integer.parseInt(horaSalidaFrec[0]);
        int minutoSupuestaHoraSalida = Integer.parseInt(horaSalidaFrec[1]);
        String amPm = horaSalidaFrec[2].toLowerCase();

        Calendar salidaHoraEstimadaMenosCinco = new GregorianCalendar();
        salidaHoraEstimadaMenosCinco.set(Calendar.MINUTE, minutoSupuestaHoraSalida - 5);
        salidaHoraEstimadaMenosCinco.set(Calendar.HOUR, soloHoraSupuestaSalida);

        Calendar salidaHoraEstimadaMasCinco = new GregorianCalendar();
        salidaHoraEstimadaMasCinco.set(Calendar.MINUTE, minutoSupuestaHoraSalida + 5);
        salidaHoraEstimadaMasCinco.set(Calendar.HOUR, soloHoraSupuestaSalida);

        if (amPm.contains("am")) {
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
        return result;
    }

    public void iniciateListaVuelos() {
        Date hoy = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(hoy);
        DateFormat formato = new SimpleDateFormat("hh:mm:ss a");

        FrecuenciaDeVuelo fv = LogicaFrecuenciaVuelo.getInstancia().getFrecuencias().get(3);
        Vuelo a = new Vuelo();
        String horaActual = formato.format(hoy);
        a.numero = fv.numero;
        a.fechaPartida = "23/06/2019";
        a.horaRealPartida = horaActual;
        a.horaRealLlegada = "22:10:00 AM";
        a.estado = "VUELO TEST";
        a.arancelPartida = fv.aeropuertoOrigen.tipo.CalcularArancelPartida(horaActual, a, calcularMinutosRetraso(fv.horaPartida, horaActual));
        a.arancelLlegada = fv.aeropuertoDestino.tipo.CalcularArancelLlegada(fv.aeropuertoOrigen);
        a.oId = 0;
        a.setOidFrecVuelo(26);
        fv.vuelos.add(a);
        
        BaseDatos bd = BaseDatos.getInstancia();        
        bd.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3307/aeropuerto", "root", "root");
        MapeadorVuelo mv = new MapeadorVuelo();
        mv.setVuelo(a);
        Persistencia.getInstancia().guardar(mv);
        bd.desconectar();
        
        notificarObservadores();
    }        

    public void notificarObservadores() {
        setChanged();
        notifyObservers();
    }
}
