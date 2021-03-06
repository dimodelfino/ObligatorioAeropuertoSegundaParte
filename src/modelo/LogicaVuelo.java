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
import utilities.ExceptionCompania;

/**
 *
 * @author dmoreno
 */
public class LogicaVuelo extends Observable {

    private static LogicaVuelo instancia = null;
    private final BaseDatos bd = BaseDatos.getInstancia();
    
    private void conectar(){
        
        bd.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/aeropuerto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
        //bd.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3307/Aeropuerto", "root", "root");
    }
    
    private void desconectar(){
        bd.desconectar();
    }
    
    public static LogicaVuelo getInstancia() {
        if (instancia == null) {
            instancia = new LogicaVuelo();
        }
        return instancia;
    }

    //Crea y guarda un vuelo con el numero de frecuencia de vuelo pasada por parametro       
    public void crearVuelo(FrecuenciaDeVuelo fv, Vuelo v) throws ExceptionCompania {                
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
        v.setOidFrecVuelo(fv.getOid());
        conectar();
        MapeadorVuelo mv = new MapeadorVuelo();
        mv.setVuelo(v);
        Persistencia.getInstancia().guardar(mv);        
        desconectar();
        notificarObservadores();        
    }

    //Agrega los datos necesarios al vuelo cuando aterriza.
    public FrecuenciaDeVuelo agregarLlegadaVuelo(FrecuenciaDeVuelo fv, Vuelo arribo) throws ExceptionCompania {
        boolean encontro = false;
        int i = 0;
        Date hoy = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(hoy);
        DateFormat formato = new SimpleDateFormat("hh:mm:ss a");
        String horaActual = formato.format(hoy);        
        arribo.horaRealLlegada = horaActual;
        arribo.estado = "Aterrizo";
        arribo.arancelLlegada = fv.aeropuertoDestino.tipo.CalcularArancelLlegada(fv.aeropuertoOrigen);
        conectar();
        MapeadorVuelo mv = new MapeadorVuelo();
        mv.setVuelo(arribo);
        Persistencia.getInstancia().guardar(mv);        
        desconectar();
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

    public void notificarObservadores() {
        setChanged();
        notifyObservers();
    }
}
