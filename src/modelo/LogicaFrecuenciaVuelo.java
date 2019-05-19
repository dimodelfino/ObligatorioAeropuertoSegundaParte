/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import vistas.DiaSemanaEnum;

/**
 *
 * @author dmoreno
 */
public class LogicaFrecuenciaVuelo {

    private final ArrayList<FrecuenciaDeVuelo> frecuencias = new ArrayList<>();
    private static final LogicaFrecuenciaVuelo instancia = new LogicaFrecuenciaVuelo();

    public static LogicaFrecuenciaVuelo getInstancia() {
        return instancia;
    }

    public ArrayList<FrecuenciaDeVuelo> getFrecuencias() {
        return frecuencias;
    }

    public void iniciateFrecuenciaVueloList() {
        Compania c = LogicaCompania.getInstancia().getCompanias().get(0);
        Aeropuerto origen = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("Carrasco");
        Aeropuerto destino = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("Ezeiza");
        Estado eOrigen = new Estado(origen);
        Estado eDestino = new Estado(destino); 
        ArrayList <DiaSemanaEnum> d = new ArrayList <>();
        d.add(DiaSemanaEnum.S);
        d.add(DiaSemanaEnum.D);        
        FrecuenciaDeVuelo fv = new FrecuenciaDeVuelo("Test", eOrigen, eDestino, "1:2 Am", "5:8", c, d);
        this.frecuencias.add(fv);
        Compania c1 = LogicaCompania.getInstancia().getCompanias().get(1);
        Aeropuerto origen1 = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("Barajas");
        Aeropuerto destino1 = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("JFK");
        Estado eOrigen1 = new Estado(origen1);
        Estado eDestino1 = new Estado(destino1); 
        ArrayList <DiaSemanaEnum> d1 = new ArrayList <>();
        d1.add(DiaSemanaEnum.X);
        d1.add(DiaSemanaEnum.M);
        FrecuenciaDeVuelo fv1 = new FrecuenciaDeVuelo("Test1", eOrigen1, eDestino1, "2:3 Pm", "6:9", c1, d1);
        this.frecuencias.add(fv1);
        Compania c2 = LogicaCompania.getInstancia().getCompanias().get(2);
        Aeropuerto origen2 = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("La Guardia");
        Aeropuerto destino2 = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("Barajas");
        Estado eOrigen2 = new Estado(origen2);
        Estado eDestino2 = new Estado(destino2); 
        ArrayList <DiaSemanaEnum> d2 = new ArrayList <>();
        d2.add(DiaSemanaEnum.J);
        d2.add(DiaSemanaEnum.V);        
        FrecuenciaDeVuelo fv2 = new FrecuenciaDeVuelo("Test2", eOrigen2, eDestino2, "3:4 Pm", "7:0", c2, d2);
        this.frecuencias.add(fv2);
        Compania c3 = LogicaCompania.getInstancia().getCompanias().get(0);
        Aeropuerto origen3 = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("Guarulos");
        Aeropuerto destino3 = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre("Carrasco");
        Estado eOrigen3 = new Estado(origen3);
        Estado eDestino3 = new Estado(destino3); 
        ArrayList<DiaSemanaEnum> d3 = new ArrayList <>();
        d3.add(DiaSemanaEnum.L);
        FrecuenciaDeVuelo fv3 = new FrecuenciaDeVuelo("Test3", eOrigen3, eDestino3, "04:05 Pm", "08:00", c3, d3);        
        this.frecuencias.add(fv3);
    }

    public boolean GuardarFrecuencia(FrecuenciaDeVuelo fv) {
        boolean agregado = false;
        int cantidadFrecuencias = frecuencias.size();
        this.frecuencias.add(fv);
        if ((cantidadFrecuencias + 1) == frecuencias.size()) {
            agregado = true;
        }        
        return agregado;
    }
}
