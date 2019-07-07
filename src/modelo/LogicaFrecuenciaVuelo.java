/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Mapeadores.MapeadorAeropuerto;
import Mapeadores.MapeadorFrecuenciaVuelo;
import Mapeadores.MapeadorVuelo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observable;
import persistencia.BaseDatos;
import persistencia.Persistencia;
import utilities.ExceptionCompania;
import utilities.Utils;

/**
 *
 * @author dmoreno
 */
public class LogicaFrecuenciaVuelo extends Observable {
    
    private static LogicaFrecuenciaVuelo instancia = null;
    private final BaseDatos bd = BaseDatos.getInstancia();
    
    private void conectar(){
        //bd.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/aeropuerto", "root", "admin");
        bd.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3307/Aeropuerto", "root", "root");
    }
    
    private void desconectar(){
        bd.desconectar();
    }

    public static LogicaFrecuenciaVuelo getInstancia() {
        if (instancia == null) {
            instancia = new LogicaFrecuenciaVuelo();
        }
        return instancia;
    }

    public ArrayList<FrecuenciaDeVuelo> getFrecuencias() {        
        conectar();        
        MapeadorFrecuenciaVuelo mfv = new MapeadorFrecuenciaVuelo();
        Object frecuencias = Persistencia.getInstancia().cargarTodos(mfv);
        desconectar();
        return (ArrayList) frecuencias;
    }

    public void actualizarDiasSemana(FrecuenciaDeVuelo fv, ArrayList<DiaSemanaEnum> dias) throws ExceptionCompania {        
        conectar();
        MapeadorFrecuenciaVuelo mfv = new MapeadorFrecuenciaVuelo();
        mfv.setFrecuenciaDeVuelo(fv);
        FrecuenciaDeVuelo frec = (FrecuenciaDeVuelo) Persistencia.getInstancia().buscar(mfv, "");
        frec.diasSemana.addAll(dias);
        mfv.setFrecuenciaDeVuelo(frec);
        Persistencia.getInstancia().guardar(mfv);
        desconectar();
        notificarObservadores();
    }

  
    //Guarda una frecuencia en la lista de frecuencias.
    public void GuardarFrecuencia(FrecuenciaDeVuelo fv) throws ExceptionCompania {
        conectar();
        MapeadorFrecuenciaVuelo mfv = new MapeadorFrecuenciaVuelo();
        mfv.setFrecuenciaDeVuelo(fv);
        Persistencia.getInstancia().guardar(mfv);
        desconectar();
        notificarObservadores();
    }

    public void actualizarFrecuencia(FrecuenciaDeVuelo fv) throws ExceptionCompania {
        conectar();
        MapeadorFrecuenciaVuelo mfv = new MapeadorFrecuenciaVuelo();
        mfv.setFrecuenciaDeVuelo(fv);
        Persistencia.getInstancia().guardar(mfv);
        desconectar();
        notificarObservadores();
    }

    //Devuelve lista de frecuencias por aeropuerto
    public ArrayList<FrecuenciaDeVuelo> frecuenciaPorAeropuerto(String nomAero, String origDest) {
        ArrayList<FrecuenciaDeVuelo> frecuenciasFiltradas = new ArrayList<>();
        conectar();
        MapeadorAeropuerto ma = new MapeadorAeropuerto();
        ArrayList<Aeropuerto> aero = (ArrayList<Aeropuerto>)Persistencia.getInstancia().buscar(ma, " nombre = \"" + nomAero + "\"");
        MapeadorFrecuenciaVuelo mfv = new MapeadorFrecuenciaVuelo();            
        if (origDest.equals("Origen")) {                        
            frecuenciasFiltradas = (ArrayList<FrecuenciaDeVuelo>)Persistencia.getInstancia().buscar(
                    mfv, " WHERE estadoOrigen = \"Pendiente\" AND idAeropuertoOrigen = " + aero.get(0).getOid());                         
        } else {
            frecuenciasFiltradas = (ArrayList<FrecuenciaDeVuelo>)Persistencia.getInstancia().buscar(
                    mfv, " WHERE estadoOrigen = \"Aprobado\" AND estadoDestino = \"pendiente\" AND idAeropuertoDestino = " + aero.get(0).getOid());                        
        }
        desconectar();           
        return frecuenciasFiltradas;
    }

    //Devuelve una lista de todos los vuelos origen o destino que contienen la lista de frecuencias de cierto aeropuerto    
    public ArrayList<Vuelo> getVuelosPorAeropuerto(String nomAero, String origDest) {
        ArrayList<Vuelo> vuelos = null;
        Calendar calendar = Calendar.getInstance();
        int dia = calendar.get(Calendar.DAY_OF_WEEK);
        DiaSemanaEnum hoy = Utils.getDiaSemana(dia);
        conectar();
        MapeadorAeropuerto ma = new MapeadorAeropuerto();
        ArrayList<Aeropuerto> aero = (ArrayList<Aeropuerto>)Persistencia.getInstancia().buscar(ma, " nombre = " + "\"" + nomAero + "\"");
        MapeadorFrecuenciaVuelo mfv = new MapeadorFrecuenciaVuelo();  
        ArrayList <FrecuenciaDeVuelo> frecuencias;

            if (origDest == "Origen") {
                frecuencias = (ArrayList <FrecuenciaDeVuelo>)Persistencia.getInstancia().buscar(
                        mfv, " idAeropuertoOrigen = " + aero.get(0).getOid()+ " AND estadoDestino = \"Aprobado\" AND estadoOrigen = \"Aprobado\" ");
                for(FrecuenciaDeVuelo frec : frecuencias){
                    if(!frec.diasSemana.contains(hoy)){
                        frecuencias.remove(frec);                   
                    }
                }
            } else {
                 frecuencias = (ArrayList <FrecuenciaDeVuelo>)Persistencia.getInstancia().buscar(
                        mfv, " WHERE idAeropuertoDestino = " + aero.get(0).getOid()+ " AND estadoDestino = \"Aprobado\" AND estadoOrigen = \"Aprobado\" ");
                for(FrecuenciaDeVuelo frec : frecuencias){
                    if(!frec.diasSemana.contains(hoy)){
                        frecuencias.remove(frec);                   
                    }    
                }
            }
            desconectar();      
            for (FrecuenciaDeVuelo v : frecuencias){
                if(!v.vuelos.isEmpty()){
                    vuelos = new ArrayList<>();
                    vuelos.addAll(v.vuelos);
                }                                      
            }
        return vuelos;
    }

    public DiaSemanaEnum getDiaSemana(int dia) {
        DiaSemanaEnum diaSemana = DiaSemanaEnum.D;

        switch (dia) {
            case Calendar.MONDAY:
                diaSemana = DiaSemanaEnum.L;
                break;
            case Calendar.TUESDAY:
                diaSemana = DiaSemanaEnum.M;
                break;
            case Calendar.WEDNESDAY:
                diaSemana = DiaSemanaEnum.X;
                break;
            case Calendar.THURSDAY:
                diaSemana = DiaSemanaEnum.J;
                break;
            case Calendar.FRIDAY:
                diaSemana = DiaSemanaEnum.V;
                break;
            case Calendar.SATURDAY:
                diaSemana = DiaSemanaEnum.S;
                break;
        }
        return diaSemana;
    }

    public ArrayList<Vuelo> getVuelosPorOidFrecuencia(int oidFrec) {
        ArrayList<Vuelo> vuelosDeFrec = null;
        conectar();
        MapeadorVuelo mv = new MapeadorVuelo();
        vuelosDeFrec= (ArrayList<Vuelo>) Persistencia.getInstancia().buscar(mv, " idFrecuenciaVuelo = " + oidFrec);
        desconectar();
        return vuelosDeFrec;
    }

    public ArrayList<String> getVuelosString(FrecuenciaDeVuelo fv) {
        ArrayList<String> vuelos = new ArrayList<>();
        String horaLlegada = "";
        if (fv != null && fv.vuelos.size() != 0) {
            for (Vuelo v : fv.vuelos) {
                if (v.horaRealLlegada == null) {
                    horaLlegada = "En vuelo";
                } else {
                    horaLlegada = v.horaRealLlegada;
                }
                vuelos.add("Fecha Partida: " + v.fechaPartida + " || Hora Partda: " + v.horaRealPartida
                        + " || Hora Llegada: " + horaLlegada + " || Costo Despegue: " + v.arancelPartida + " || Costo Aterrizaje: " + v.arancelLlegada);
            }
        }
        return vuelos;
    }

    public void notificarObservadores() {
        setChanged();
        notifyObservers();
    }
}
