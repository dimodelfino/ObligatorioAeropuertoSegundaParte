/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Observable;
import vistas.DiaSemanaEnum;

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
        return frecuencias;
    }

    public void setFrecuencias(ArrayList<FrecuenciaDeVuelo> frecuenci) {
        this.frecuencias = frecuenci;
        notificarObservadores();
    }

    //Crea Frecuencias de prueba 
    public void iniciateFrecuenciaVueloList() {
        Compania c = LogicaCompania.getInstancia().getCompanias().get(0);
        Aeropuerto origen = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("Carrasco");
        Aeropuerto destino = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("Ezeiza");
        Estado eOrigen = new Estado(origen);       
        Estado eDestino = new Estado(destino);       
        ArrayList<DiaSemanaEnum> d = new ArrayList<>();
        d.add(DiaSemanaEnum.S);
        d.add(DiaSemanaEnum.D);
        d.add(DiaSemanaEnum.L);
        d.add(DiaSemanaEnum.M);
        d.add(DiaSemanaEnum.X);
        d.add(DiaSemanaEnum.J);
        d.add(DiaSemanaEnum.V);
        FrecuenciaDeVuelo fv = new FrecuenciaDeVuelo("LAN 1", eOrigen, eDestino, "01:20:00 AM", "05:08:00", c, d);
        getInstancia().frecuencias.add(fv);

        Compania c1 = LogicaCompania.getInstancia().getCompanias().get(1);
        Aeropuerto origen1 = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("JFK");
        Aeropuerto destino1 = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("Carrasco");
        Estado eOrigen1 = new Estado(origen1);
        Estado eDestino1 = new Estado(destino1);
        eOrigen1.estado = EstadoEnum.Aprobado;
        ArrayList<DiaSemanaEnum> d1 = new ArrayList<>();
        d1.add(DiaSemanaEnum.S);
        d1.add(DiaSemanaEnum.D);
        d1.add(DiaSemanaEnum.L);
        d1.add(DiaSemanaEnum.M);
        d1.add(DiaSemanaEnum.X);
        d1.add(DiaSemanaEnum.J);
        d1.add(DiaSemanaEnum.V);
        FrecuenciaDeVuelo fv1 = new FrecuenciaDeVuelo("AAR 2", eOrigen1, eDestino1, "02:03:00 PM", "06:09:00", c1, d1);
        getInstancia().frecuencias.add(fv1);

        Compania c2 = LogicaCompania.getInstancia().getCompanias().get(2);
        Aeropuerto origen2 = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("Carrasco");
        Aeropuerto destino2 = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("La Guardia");
        Estado eOrigen2 = new Estado(origen2);
        eOrigen2.estado = EstadoEnum.Aprobado;
        Estado eDestino2 = new Estado(destino2);
        eDestino2.estado = EstadoEnum.Aprobado;
        ArrayList<DiaSemanaEnum> d2 = new ArrayList<>();
        d2.add(DiaSemanaEnum.S);
        d2.add(DiaSemanaEnum.D);
        d2.add(DiaSemanaEnum.L);
        d2.add(DiaSemanaEnum.M);
        d2.add(DiaSemanaEnum.X);
        d2.add(DiaSemanaEnum.J);
        d2.add(DiaSemanaEnum.V);
        FrecuenciaDeVuelo fv2 = new FrecuenciaDeVuelo("PLU 3", eOrigen2, eDestino2, "03:40:00 PM", "07:00:00", c2, d2);
        getInstancia().frecuencias.add(fv2);

        Compania c3 = LogicaCompania.getInstancia().getCompanias().get(3);
        Aeropuerto origen3 = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("Carrasco");
        Aeropuerto destino3 = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("Guarulos");
        Estado eOrigen3 = new Estado(origen3);
        eOrigen3.estado = EstadoEnum.Aprobado;
        Estado eDestino3 = new Estado(destino3);
        eDestino3.estado = EstadoEnum.Aprobado;
        ArrayList<DiaSemanaEnum> d3 = new ArrayList<>();
        d3.add(DiaSemanaEnum.S);
        d3.add(DiaSemanaEnum.D);
        d3.add(DiaSemanaEnum.L);
        d3.add(DiaSemanaEnum.M);
        d3.add(DiaSemanaEnum.X);
        d3.add(DiaSemanaEnum.J);
        d3.add(DiaSemanaEnum.V);
        FrecuenciaDeVuelo fv3 = new FrecuenciaDeVuelo("AFR 4", eOrigen3, eDestino3, "04:05:00 PM", "08:00:00", c3, d3);
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
        
    public void notificarObservadores(){
        setChanged();
        notifyObservers();
    }
}
