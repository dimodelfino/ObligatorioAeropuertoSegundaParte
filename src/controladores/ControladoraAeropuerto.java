package controladores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
import modelo.EstadoEnum;
import modelo.FachadaModelo;
import modelo.FrecuenciaDeVuelo;
import modelo.LogicaFrecuenciaVuelo;
import modelo.Vuelo;
import vistas.AplicacionAeropuerto;
import vistas.DiaSemanaEnum;

/**
 *
 * @author majuetcheverry
 */
public class ControladoraAeropuerto implements Observer{


    public AplicacionAeropuerto vista;
    
    public ControladoraAeropuerto (AplicacionAeropuerto vistApAero){     
        this.vista = vistApAero;
        LogicaFrecuenciaVuelo.getInstancia().addObserver(this);
    }

    public ArrayList<FrecuenciaDeVuelo> frecuenciasPorAeropuerto(String nomAero, String origDest) {
        ArrayList<FrecuenciaDeVuelo> f = FachadaModelo.getInstancia().getFrecuencias();
        ArrayList<FrecuenciaDeVuelo> frecuenciasFiltradas = new ArrayList<>();

        for (FrecuenciaDeVuelo frec : f) {
            if (origDest.equals("Origen")) {
                if (frec.aeropuertoOrigen.estado.equals(EstadoEnum.Pendiente)
                        && frec.aeropuertoOrigen.aeropuerto.nombre.equals(nomAero)) {
                    frecuenciasFiltradas.add(frec);
                }
            } else {
                if (frec.aeropuertoDestino.estado.equals(EstadoEnum.Pendiente) && frec.aeropuertoOrigen.estado.equals(EstadoEnum.Aprobado)
                        && frec.aeropuertoDestino.aeropuerto.nombre.equals(nomAero)) {
                    frecuenciasFiltradas.add(frec);
                }
            }
        }
        return frecuenciasFiltradas;
    }

    public ArrayList<FrecuenciaDeVuelo> frecuenciasAprobadas(String nomAero, String origDest) {
        ArrayList<FrecuenciaDeVuelo> f = FachadaModelo.getInstancia().getFrecuencias();
        ArrayList<FrecuenciaDeVuelo> frecuenciasFiltradasAprobadas = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        int dia = calendar.get(Calendar.DAY_OF_WEEK);
        DiaSemanaEnum hoy = getDiaSemana(dia);

        for (FrecuenciaDeVuelo frec : f) {
            if (origDest.equals("Origen")) {
                if (frec.aeropuertoOrigen.estado.equals(EstadoEnum.Aprobado) && frec.aeropuertoDestino.estado.equals(EstadoEnum.Aprobado)
                        && frec.aeropuertoOrigen.aeropuerto.nombre.equals(nomAero) && frec.diasSemana.contains(hoy)) {
                    frecuenciasFiltradasAprobadas.add(frec);
                }
            } else {
                if (frec.aeropuertoOrigen.estado.equals(EstadoEnum.Aprobado) && frec.aeropuertoDestino.estado.equals(EstadoEnum.Aprobado)
                        && frec.aeropuertoDestino.aeropuerto.nombre.equals(nomAero) && frec.diasSemana.contains(hoy)) {
                    frecuenciasFiltradasAprobadas.add(frec);
                }
            }
        }
        return frecuenciasFiltradasAprobadas;
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

    public void aprobarEstadoFrecuencia(FrecuenciaDeVuelo f, String origDest) {
        ArrayList<FrecuenciaDeVuelo> frecuencias = FachadaModelo.getInstancia().getFrecuencias();

        for (FrecuenciaDeVuelo frecuen : frecuencias) {
            if (origDest.equals("Destino")) {
                if (frecuen.equals(f) && frecuen.aeropuertoDestino.estado.equals(EstadoEnum.Pendiente)) {
                    frecuen.aeropuertoDestino.estado = EstadoEnum.Aprobado;
                }
            } else {
                if (frecuen.equals(f) && frecuen.aeropuertoOrigen.estado.equals(EstadoEnum.Pendiente)) {
                    frecuen.aeropuertoOrigen.estado = EstadoEnum.Aprobado;
                }
            }
        }
        FachadaModelo.getInstancia().actualizarFrecuencias(frecuencias);
        actualizarListas();
    }

    public void rechazarEstadoFrecuencia(FrecuenciaDeVuelo frec, String origDest) {
        ArrayList<FrecuenciaDeVuelo> frecuencias = FachadaModelo.getInstancia().getFrecuencias();

        for (FrecuenciaDeVuelo frecuen : frecuencias) {
            if (origDest.equals("Origen")) {
                if (frecuen.equals(frec) && frecuen.aeropuertoOrigen.estado.equals(EstadoEnum.Pendiente)) {
                    frecuen.aeropuertoOrigen.estado = EstadoEnum.Rechazado;
                }
            } else {
                if (frecuen.equals(frec) && frecuen.aeropuertoOrigen.estado.equals(EstadoEnum.Aprobado)) {
                    frecuen.aeropuertoDestino.estado = EstadoEnum.Rechazado;
                }
            }
        }
        FachadaModelo.getInstancia().actualizarFrecuencias(frecuencias);
        actualizarListas();
    }

    public void agregregarVuelo(FrecuenciaDeVuelo fv) {
        FachadaModelo.getInstancia().agregarVuelo(fv);
        actualizarListas();
    }

    public ArrayList<Vuelo> getVuelosPorAeropuerto(String nomAero, String origDest) {
        ArrayList<Vuelo> v = FachadaModelo.getInstancia().getVuelos();
        ArrayList<Vuelo> vuelosFiltrados = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        int dia = calendar.get(Calendar.DAY_OF_WEEK);
        DiaSemanaEnum hoy = getDiaSemana(dia);
        if (v != null) {
            for (Vuelo vuel : v) {
                if (origDest.equals("Origen")) {
                    if (vuel.fVuelo.aeropuertoOrigen.aeropuerto.nombre.equals(nomAero) && vuel.fVuelo.diasSemana.contains(hoy)
                            && vuel.horaRealPartida == null) {
                        vuelosFiltrados.add(vuel);
                    }
                } else {
                    if (vuel.fVuelo.aeropuertoDestino.aeropuerto.nombre.equals(nomAero) && vuel.fVuelo.diasSemana.contains(hoy)
                            && vuel.horaRealPartida != null && vuel.horaRealLlegada ==null) {
                        vuelosFiltrados.add(vuel);
                    }
                }
            }
        }
        return vuelosFiltrados;
    }

    public void partioVuelo(Vuelo partida) {
        FachadaModelo.getInstancia().agregarPartidaVuelo(partida);
        actualizarListas();
    }
    
    public void arriboVuelo(Vuelo arribo){
    FachadaModelo.getInstancia().agregarLlegadaVuelo(arribo);
    actualizarListas();
    }
    
    public void actualizarListas(){
        vista.actualizarListas();
    }
    
    public void cerrar(){
        LogicaFrecuenciaVuelo.getInstancia().deleteObserver(this);
    }

    @Override
    public void update(Observable o, Object arg1) {
        if(o == LogicaFrecuenciaVuelo.getInstancia()){
            actualizarListas();
        }
    }
}
