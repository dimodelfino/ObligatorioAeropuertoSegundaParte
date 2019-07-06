/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Mapeadores.MapeadorFrecuenciaVuelo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observable;
import persistencia.BaseDatos;
import persistencia.Persistencia;
import utilities.Utils;

/**
 *
 * @author dmoreno
 */
public class LogicaFrecuenciaVuelo extends Observable {

    private ArrayList<FrecuenciaDeVuelo> frecuencias = new ArrayList<>();
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
        return (ArrayList)frecuencias;        
    }

    public void setFrecuencias(ArrayList<FrecuenciaDeVuelo> frecuenci) {
        this.frecuencias = frecuenci;
        notificarObservadores();
    }

    public void actualizarDiasSemana(int indice, ArrayList<DiaSemanaEnum> dias) {
        this.frecuencias.get(indice).diasSemana.addAll(dias);
        notificarObservadores();
    }

    //Crea Frecuencias de prueba 
    public void iniciateFrecuenciaVueloList() {
        Compania c = LogicaCompania.getInstancia().getCompanias().get(0);
        Aeropuerto origen = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("Carrasco");
        Aeropuerto destino = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("Ezeiza");
        ArrayList<DiaSemanaEnum> d = new ArrayList<>();
        d.add(DiaSemanaEnum.S);
        d.add(DiaSemanaEnum.D);
        d.add(DiaSemanaEnum.L);
        d.add(DiaSemanaEnum.M);
        d.add(DiaSemanaEnum.X);
        d.add(DiaSemanaEnum.J);
        d.add(DiaSemanaEnum.V);
        FrecuenciaDeVuelo fv = new FrecuenciaDeVuelo("LAN 1", origen, EstadoEnum.Pendiente, destino, EstadoEnum.Pendiente, "01:20:00 AM", "05:08:00", c, d);
        getInstancia().frecuencias.add(fv);

        Compania c1 = LogicaCompania.getInstancia().getCompanias().get(1);
        Aeropuerto origen1 = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("JFK");
        Aeropuerto destino1 = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("Carrasco");
        ArrayList<DiaSemanaEnum> d1 = new ArrayList<>();
        d1.add(DiaSemanaEnum.S);
        d1.add(DiaSemanaEnum.D);
        d1.add(DiaSemanaEnum.L);
        d1.add(DiaSemanaEnum.M);
        d1.add(DiaSemanaEnum.X);
        d1.add(DiaSemanaEnum.J);
        d1.add(DiaSemanaEnum.V);
        FrecuenciaDeVuelo fv1 = new FrecuenciaDeVuelo("AAR 2", origen1, EstadoEnum.Aprobado, destino1, EstadoEnum.Pendiente, "02:03:00 PM", "06:09:00", c1, d1);
        getInstancia().frecuencias.add(fv1);

        Compania c2 = LogicaCompania.getInstancia().getCompanias().get(2);
        Aeropuerto origen2 = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("Carrasco");
        Aeropuerto destino2 = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("La Guardia");
        ArrayList<DiaSemanaEnum> d2 = new ArrayList<>();
        d2.add(DiaSemanaEnum.S);
        d2.add(DiaSemanaEnum.D);
        d2.add(DiaSemanaEnum.L);
        d2.add(DiaSemanaEnum.M);
        d2.add(DiaSemanaEnum.X);
        d2.add(DiaSemanaEnum.J);
        d2.add(DiaSemanaEnum.V);
        FrecuenciaDeVuelo fv2 = new FrecuenciaDeVuelo("PLU 3", origen2, EstadoEnum.Aprobado, destino2, EstadoEnum.Aprobado, "03:40:00 PM", "07:00:00", c2, d2);
        getInstancia().frecuencias.add(fv2);

        Compania c3 = LogicaCompania.getInstancia().getCompanias().get(3);
        Aeropuerto origen3 = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("Carrasco");
        Aeropuerto destino3 = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("Guarulos");
        ArrayList<DiaSemanaEnum> d3 = new ArrayList<>();
        d3.add(DiaSemanaEnum.S);
        d3.add(DiaSemanaEnum.D);
        d3.add(DiaSemanaEnum.L);
        d3.add(DiaSemanaEnum.M);
        d3.add(DiaSemanaEnum.X);
        d3.add(DiaSemanaEnum.J);
        d3.add(DiaSemanaEnum.V);
        FrecuenciaDeVuelo fv3 = new FrecuenciaDeVuelo("AFR 4", origen3, EstadoEnum.Aprobado, destino3, EstadoEnum.Aprobado, "04:05:00 PM", "08:00:00", c3, d3);
        getInstancia().frecuencias.add(fv3);
        notificarObservadores();
    }

    //Guarda una frecuencia en la lista de frecuencias.
    public boolean GuardarFrecuencia(FrecuenciaDeVuelo fv) {
        boolean agregado = false;
        int cantidadFrecuencias = getInstancia().frecuencias.size();
        getInstancia().frecuencias.add(fv);
        if ((cantidadFrecuencias + 1) == getInstancia().frecuencias.size()) {
            agregado = true;
        }
        notificarObservadores();
        return agregado;
    }

    public void actualizarFrecuencia(FrecuenciaDeVuelo fv) {
        boolean existe = false;
        int i = 0;
        while (i < frecuencias.size() && !existe) {
            if (frecuencias.get(i).numero == fv.numero) {
                frecuencias.set(i, fv);
                existe = true;
            }
            i++;
        }
    }

    //Devuelve lista de frecuencias por aeropuerto
    public ArrayList<FrecuenciaDeVuelo> frecuenciaPorAeropuerto(String nomAero, String origDest) {
        ArrayList<FrecuenciaDeVuelo> frecuenciasDeVuelo = this.frecuencias;
        ArrayList<FrecuenciaDeVuelo> frecuenciasFiltradas = new ArrayList<>();

        for (FrecuenciaDeVuelo frec : frecuenciasDeVuelo) {
            if (origDest.equals("Origen")) {
                if (frec.estadoOrigen.equals(EstadoEnum.Pendiente)
                        && frec.aeropuertoOrigen.nombre.equals(nomAero)) {
                    frecuenciasFiltradas.add(frec);
                }
            } else {
                if (frec.estadoDestino.equals(EstadoEnum.Pendiente) && frec.estadoOrigen.equals(EstadoEnum.Aprobado)
                        && frec.aeropuertoDestino.nombre.equals(nomAero)) {
                    frecuenciasFiltradas.add(frec);
                }
            }
        }
        return frecuenciasFiltradas;
    }

    //Devuelve una lista de todos los vuelos origen o destino que contienen la lista de frecuencias de cierto aeropuerto    
    public ArrayList<Vuelo> getVuelosPorAeropuerto(String nomAero, String origDest) {
        ArrayList<Vuelo> vuelos = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        int dia = calendar.get(Calendar.DAY_OF_WEEK);
        DiaSemanaEnum hoy = Utils.getDiaSemana(dia);
        for (FrecuenciaDeVuelo frec : frecuencias) {
            if (origDest == "Origen") {
                if (nomAero.equals(frec.aeropuertoOrigen.nombre) && frec.diasSemana.contains(hoy)
                        && frec.estadoDestino.equals(EstadoEnum.Aprobado) && frec.estadoOrigen.equals(EstadoEnum.Aprobado) && frec.vuelos.size() > 0) {
                    vuelos.addAll(frec.vuelos);
                }
            } else {
                if (frec.aeropuertoDestino.nombre.equals(nomAero) && frec.diasSemana.contains(hoy)
                        && frec.estadoDestino.equals(EstadoEnum.Aprobado) && frec.estadoOrigen.equals(EstadoEnum.Aprobado) && frec.vuelos.size() > 0) {
                    vuelos.addAll(frec.vuelos);
                }
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
        int i = 0;
        boolean encontrado = false;

        while (!encontrado && i < frecuencias.size()) {
            if (frecuencias.get(i).getOid() == oidFrec) {
                vuelosDeFrec = frecuencias.get(i).vuelos;
                encontrado = true;
            }
        }
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
