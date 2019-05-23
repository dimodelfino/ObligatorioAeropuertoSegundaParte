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
import java.util.Collection;
import java.util.Date;
import utilities.ExceptionCompania;
import vistas.DiaSemanaEnum;

/**
 *
 * @author dmoreno
 */
public class FachadaModelo {

    private static FachadaModelo instancia = new FachadaModelo();

    public static FachadaModelo getInstancia() {
        return instancia;
    }

    public boolean agregarFrecuencia(String num, String origen, String destino, String hrPartida, String duracionEst, Compania c, ArrayList<DiaSemanaEnum> diasSem) throws ExceptionCompania{

        Aeropuerto Aorigen = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre(origen);
        Aeropuerto Adestino = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre(destino);
        Estado eOrigen = new Estado(Aorigen);
        Estado eDestino = new Estado(Adestino);
        FrecuenciaDeVuelo fv = new FrecuenciaDeVuelo(num, eOrigen, eDestino, hrPartida, duracionEst, c, diasSem);
        existeFrecuencia(fv);
        return LogicaFrecuenciaVuelo.getInstancia().GuardarFrecuencia(fv);
    }

    public boolean existeFrecuencia(FrecuenciaDeVuelo fv) throws utilities.ExceptionCompania{
        boolean ret = false;
        int i = 0;
        ArrayList<DiaSemanaEnum> auxFrec;
        ArrayList<DiaSemanaEnum> auxIteracion;
        while (!ret && i < this.getFrecuencias().size()) {
            auxFrec = new ArrayList<>(fv.diasSemana);
            auxIteracion = this.getFrecuencias().get(i).diasSemana;
            
            auxFrec.retainAll(auxIteracion);
            FrecuenciaDeVuelo frecIteracion =this.getFrecuencias().get(i);
            if (fv.aeropuertoDestino.aeropuerto.nombre.equals(frecIteracion.aeropuertoDestino.aeropuerto.nombre)
                    && fv.aeropuertoOrigen.aeropuerto.nombre.equals(frecIteracion.aeropuertoOrigen.aeropuerto.nombre)
                    && fv.compania.nombre.equals(frecIteracion.compania.nombre)
                    && auxFrec.size() != 0) {
                fv.diasSemana.removeAll(auxFrec);  
                if(fv.diasSemana.size() == 0){
                    throw new utilities.ExceptionCompania("Ya existe una frecuencia con los datos ingresados. Intente nuevamente.");
                }
                frecIteracion.diasSemana.addAll(fv.diasSemana);
                ret = true;
            }
            i++;                  
        }
        return ret;
    }
    
    public Collection<DiaSemanaEnum> compareArrayListDias(ArrayList<DiaSemanaEnum> arrFrec, ArrayList<DiaSemanaEnum> arrItera){
       Collection<DiaSemanaEnum> resultado = new ArrayList<>();
        arrItera.removeAll(arrFrec);
        return resultado;
  
    }

    public Aeropuerto BuscarAeropuertoPorNomber(String aerop) {
        return LogicaAeropuerto.getInstancia().buscarAeropuertoNombre(aerop);
    }

    public ArrayList<FrecuenciaDeVuelo> getFrecuencias() {
        return LogicaFrecuenciaVuelo.getInstancia().getFrecuencias();
    }

    public ArrayList<Vuelo> getVuelos() {
        return LogicaVuelo.getInstancia().getVuelos();
    }

    public void actualizarFrecuencias(ArrayList<FrecuenciaDeVuelo> frecuencias) {
        LogicaFrecuenciaVuelo.getInstancia().setFrecuencias(frecuencias);
    }

    public void agregarVuelo(FrecuenciaDeVuelo fv) {
        LogicaVuelo.getInstancia().crearVuelo(fv);
    }

    public void agregarPartidaVuelo(Vuelo partida) {
        LogicaVuelo.getInstancia().agregarPartidaVuelo(partida);
    }

    public void agregarLlegadaVuelo(Vuelo arribo) {
        LogicaVuelo.getInstancia().agregarLlegadaVuelo(arribo);
    }

    public ArrayList<Vuelo> getVuelosPorAeropuerto(String nomAero, String origDest) {
        ArrayList<Vuelo> v = FachadaModelo.getInstancia().getVuelos();
        ArrayList<Vuelo> vuelosFiltrados = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        int dia = calendar.get(Calendar.DAY_OF_WEEK);
        DiaSemanaEnum hoy = getDiaSemana(dia);
        if (v != null && v.size() != 0) {
            for (Vuelo vuel : v) {
                if (origDest.equals("Origen")) {
                    if (vuel.fVuelo.aeropuertoOrigen.aeropuerto.nombre.equals(nomAero) && vuel.fVuelo.diasSemana.contains(hoy)
                            && vuel.horaRealPartida == null) {
                        vuelosFiltrados.add(vuel);
                    }
                } else {
                    if (vuel.fVuelo.aeropuertoDestino.aeropuerto.nombre.equals(nomAero) && vuel.fVuelo.diasSemana.contains(hoy)
                            && vuel.horaRealPartida != null && vuel.horaRealLlegada == null) {
                        vuelosFiltrados.add(vuel);
                    }
                }
            }
        }
        return vuelosFiltrados;
    }

    public ArrayList<Vuelo> getVuelosDiarios(String nomAero, String origDest) {
        ArrayList<Vuelo> vuelosAux = new ArrayList<Vuelo>();
        Calendar calendar = Calendar.getInstance();
        int dia = calendar.get(Calendar.DAY_OF_WEEK);
        DiaSemanaEnum hoy = getDiaSemana(dia);

        for (FrecuenciaDeVuelo frec : FachadaModelo.getInstancia().getFrecuencias()) {
            if (frec.aeropuertoOrigen.aeropuerto.nombre.equals(nomAero) && frec.diasSemana.contains(hoy)
                    && frec.aeropuertoOrigen.estado.equals(EstadoEnum.Aprobado) && frec.aeropuertoDestino.estado.equals(EstadoEnum.Aprobado)
                    && !vueloYaPartio(frec)) {
                Vuelo v = new Vuelo();
                v.fVuelo = frec;
                vuelosAux.add(v);
            }
        }
        return vuelosAux;
    }

    public boolean vueloYaPartio(FrecuenciaDeVuelo f) {
        boolean partio = false;
        int i = 0;
        Calendar cal = Calendar.getInstance();
        Date hoy = new Date();
        cal.setTime(hoy);
        DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        String fch = fecha.format(hoy);
        ArrayList<Vuelo> vuelos = FachadaModelo.getInstancia().getVuelos();
        while (!partio && vuelos.size() != 0 && i < vuelos.size()) {
            FrecuenciaDeVuelo frec = vuelos.get(i).fVuelo;
            String fecha_String = vuelos.get(i).fechaPartida;
            if (frec.equals(f) && fecha_String.equals(fch)) {
                partio = true;
            }
            i++;
        }
        return partio;
    }

    public ArrayList<Vuelo> getVuelosPorAeropuertoMonitoreo(String nomAero, String origDest) {
        ArrayList<Vuelo> v = FachadaModelo.getInstancia().getVuelos();
        ArrayList<Vuelo> vuelosFiltrados = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        int dia = calendar.get(Calendar.DAY_OF_WEEK);
        DiaSemanaEnum hoy = getDiaSemana(dia);

        Date fechaHoy = new Date();
        calendar.setTime(fechaHoy);
        DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        String fch = fecha.format(fechaHoy);

        if (v != null) {
            for (Vuelo vuel : v) {
                if (origDest.equals("Origen")) {
                    if (vuel.fVuelo.aeropuertoOrigen.aeropuerto.nombre.equals(nomAero) && vuel.fVuelo.diasSemana.contains(hoy)
                            && vuel.horaRealPartida != null && vuel.horaRealLlegada == null && vuel.fVuelo.aeropuertoDestino.estado.equals(EstadoEnum.Aprobado)
                            && vuel.fVuelo.aeropuertoOrigen.estado.equals(EstadoEnum.Aprobado) && vuel.fechaPartida.equals(fch)) {
                        vuelosFiltrados.add(vuel);
                    }
                } else {
                    if (vuel.fVuelo.aeropuertoDestino.aeropuerto.nombre.equals(nomAero) && vuel.fVuelo.diasSemana.contains(hoy)
                            && vuel.horaRealPartida != null && vuel.horaRealLlegada != null && vuel.fVuelo.aeropuertoDestino.estado.equals(EstadoEnum.Aprobado)
                            && vuel.fVuelo.aeropuertoOrigen.estado.equals(EstadoEnum.Aprobado) && vuel.fechaPartida.equals(fch)) {
                        vuelosFiltrados.add(vuel);
                    }
                }
            }
        }
        return vuelosFiltrados;
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

}
