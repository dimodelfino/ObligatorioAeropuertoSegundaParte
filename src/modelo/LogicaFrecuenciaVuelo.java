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
import utilities.ExceptionFrecuenciaVuelo;
import utilities.Utils;

/**
 *
 * @author dmoreno
 */
public class LogicaFrecuenciaVuelo extends Observable {

    //private ArrayList<FrecuenciaDeVuelo> frecuencias = new ArrayList<>();
    private static LogicaFrecuenciaVuelo instancia = null;

    public static LogicaFrecuenciaVuelo getInstancia() {
        if (instancia == null) {
            instancia = new LogicaFrecuenciaVuelo();
        }
        return instancia;
    }

    public ArrayList<FrecuenciaDeVuelo> getFrecuencias() {
        BaseDatos bd = BaseDatos.getInstancia();
        bd.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/aeropuerto", "root", "admin");
        MapeadorFrecuenciaVuelo mfv = new MapeadorFrecuenciaVuelo();
        Object frecuencias = Persistencia.getInstancia().cargarTodos(mfv);
        bd.desconectar();
        return (ArrayList) frecuencias;
    }

    public void actualizarDiasSemana(FrecuenciaDeVuelo fv, ArrayList<DiaSemanaEnum> dias) throws ExceptionCompania {
        BaseDatos bd = BaseDatos.getInstancia();
        bd.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/aeropuerto", "root", "admin");
        MapeadorFrecuenciaVuelo mfv = new MapeadorFrecuenciaVuelo();
        mfv.setFrecuenciaDeVuelo(fv);
        FrecuenciaDeVuelo frec = (FrecuenciaDeVuelo) Persistencia.getInstancia().buscar(mfv, "");
        frec.diasSemana.addAll(dias);
        mfv.setFrecuenciaDeVuelo(frec);
        Persistencia.getInstancia().guardar(mfv);
        bd.desconectar();
        notificarObservadores();
    }

    //Crea Frecuencias de prueba 
//    public void iniciateFrecuenciaVueloList() {
//        Compania c = LogicaCompania.getInstancia().getCompanias().get(0);
//        Aeropuerto origen = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("Carrasco");
//        Aeropuerto destino = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("Ezeiza");
//        ArrayList<DiaSemanaEnum> d = new ArrayList<>();
//        d.add(DiaSemanaEnum.S);
//        d.add(DiaSemanaEnum.D);
//        d.add(DiaSemanaEnum.L);
//        d.add(DiaSemanaEnum.M);
//        d.add(DiaSemanaEnum.X);
//        d.add(DiaSemanaEnum.J);
//        d.add(DiaSemanaEnum.V);
//        FrecuenciaDeVuelo fv = new FrecuenciaDeVuelo("LAN 1", origen, EstadoEnum.Pendiente, destino, EstadoEnum.Pendiente, "01:20:00 AM", "05:08:00", c, d);
//        getInstancia().frecuencias.add(fv);
//
//        Compania c1 = LogicaCompania.getInstancia().getCompanias().get(1);
//        Aeropuerto origen1 = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("JFK");
//        Aeropuerto destino1 = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("Carrasco");
//        ArrayList<DiaSemanaEnum> d1 = new ArrayList<>();
//        d1.add(DiaSemanaEnum.S);
//        d1.add(DiaSemanaEnum.D);
//        d1.add(DiaSemanaEnum.L);
//        d1.add(DiaSemanaEnum.M);
//        d1.add(DiaSemanaEnum.X);
//        d1.add(DiaSemanaEnum.J);
//        d1.add(DiaSemanaEnum.V);
//        FrecuenciaDeVuelo fv1 = new FrecuenciaDeVuelo("AAR 2", origen1, EstadoEnum.Aprobado, destino1, EstadoEnum.Pendiente, "02:03:00 PM", "06:09:00", c1, d1);
//        getInstancia().frecuencias.add(fv1);
//
//        Compania c2 = LogicaCompania.getInstancia().getCompanias().get(2);
//        Aeropuerto origen2 = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("Carrasco");
//        Aeropuerto destino2 = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("La Guardia");
//        ArrayList<DiaSemanaEnum> d2 = new ArrayList<>();
//        d2.add(DiaSemanaEnum.S);
//        d2.add(DiaSemanaEnum.D);
//        d2.add(DiaSemanaEnum.L);
//        d2.add(DiaSemanaEnum.M);
//        d2.add(DiaSemanaEnum.X);
//        d2.add(DiaSemanaEnum.J);
//        d2.add(DiaSemanaEnum.V);
//        FrecuenciaDeVuelo fv2 = new FrecuenciaDeVuelo("PLU 3", origen2, EstadoEnum.Aprobado, destino2, EstadoEnum.Aprobado, "03:40:00 PM", "07:00:00", c2, d2);
//        getInstancia().frecuencias.add(fv2);
//
//        Compania c3 = LogicaCompania.getInstancia().getCompanias().get(3);
//        Aeropuerto origen3 = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("Carrasco");
//        Aeropuerto destino3 = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("Guarulos");
//        ArrayList<DiaSemanaEnum> d3 = new ArrayList<>();
//        d3.add(DiaSemanaEnum.S);
//        d3.add(DiaSemanaEnum.D);
//        d3.add(DiaSemanaEnum.L);
//        d3.add(DiaSemanaEnum.M);
//        d3.add(DiaSemanaEnum.X);
//        d3.add(DiaSemanaEnum.J);
//        d3.add(DiaSemanaEnum.V);
//        FrecuenciaDeVuelo fv3 = new FrecuenciaDeVuelo("AFR 4", origen3, EstadoEnum.Aprobado, destino3, EstadoEnum.Aprobado, "04:05:00 PM", "08:00:00", c3, d3);
//        getInstancia().frecuencias.add(fv3);
//        notificarObservadores();
//    }
    //Guarda una frecuencia en la lista de frecuencias.
    public void GuardarFrecuencia(FrecuenciaDeVuelo fv) throws ExceptionCompania {
        BaseDatos bd = BaseDatos.getInstancia();
        bd.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/aeropuerto", "root", "admin");
        MapeadorFrecuenciaVuelo mfv = new MapeadorFrecuenciaVuelo();
        mfv.setFrecuenciaDeVuelo(fv);
        Persistencia.getInstancia().guardar(mfv);
        bd.desconectar();
        notificarObservadores();
    }

    public void actualizarFrecuencia(FrecuenciaDeVuelo fv) throws ExceptionCompania {
        BaseDatos bd = BaseDatos.getInstancia();
        bd.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/aeropuerto", "root", "admin");
        MapeadorFrecuenciaVuelo mfv = new MapeadorFrecuenciaVuelo();
        mfv.setFrecuenciaDeVuelo(fv);
        Persistencia.getInstancia().guardar(mfv);
        bd.desconectar();
    }

    //Devuelve lista de frecuencias por aeropuerto
    public ArrayList<FrecuenciaDeVuelo> frecuenciaPorAeropuerto(String nomAero, String origDest) {
        ArrayList<FrecuenciaDeVuelo> frecuenciasFiltradas = new ArrayList<>();
        BaseDatos bd = BaseDatos.getInstancia();
        bd.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/aeropuerto", "root", "admin");
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
        bd.desconectar();           
        return frecuenciasFiltradas;
    }

    //Devuelve una lista de todos los vuelos origen o destino que contienen la lista de frecuencias de cierto aeropuerto    
    public ArrayList<Vuelo> getVuelosPorAeropuerto(String nomAero, String origDest) {
        ArrayList<Vuelo> vuelos = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        int dia = calendar.get(Calendar.DAY_OF_WEEK);
        DiaSemanaEnum hoy = Utils.getDiaSemana(dia);
        BaseDatos bd = BaseDatos.getInstancia();
        bd.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/aeropuerto", "root", "admin");
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
            bd.desconectar();      
            for (FrecuenciaDeVuelo v : frecuencias){
                vuelos.addAll(v.vuelos);
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
        BaseDatos bd = BaseDatos.getInstancia();
        bd.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/aeropuerto", "root", "admin");
        MapeadorVuelo mv = new MapeadorVuelo();
        vuelosDeFrec= (ArrayList<Vuelo>) Persistencia.getInstancia().buscar(mv, " idFrecuenciaVuelo = " + oidFrec);
        bd.desconectar();
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
