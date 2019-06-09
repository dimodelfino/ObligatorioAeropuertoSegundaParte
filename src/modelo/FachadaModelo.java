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

    //Instancia una FrecuenciaDeVuelo, valida si existe y la envia a LogicaFrecuenciaVuelo a agregarse a su lista
    public boolean agregarFrecuencia(String num, String origen, String destino, String hrPartida, String duracionEst, Compania c, ArrayList<DiaSemanaEnum> diasSem) throws ExceptionCompania {
        boolean result = false;
        Aeropuerto Aorigen = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre(origen);
        Aeropuerto Adestino = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre(destino);
        Estado eOrigen = new Estado(Aorigen);
        Estado eDestino = new Estado(Adestino);
        FrecuenciaDeVuelo fv = new FrecuenciaDeVuelo(num, eOrigen, eDestino, hrPartida, duracionEst, c, diasSem);
        if (!existeFrecuencia(fv)) {
            result = LogicaFrecuenciaVuelo.getInstancia().GuardarFrecuencia(fv);
        }
        return result;
    }

    public boolean existeFrecuencia(FrecuenciaDeVuelo fv) throws utilities.ExceptionCompania {
        boolean ret = false;
        int i = 0;
        while (i < this.getFrecuencias().size() && !ret) {
            FrecuenciaDeVuelo frecIteracion = this.getFrecuencias().get(i);
            if ((frecIteracion.aeropuertoOrigen.estado != EstadoEnum.Rechazado
                    && frecIteracion.aeropuertoDestino.estado != EstadoEnum.Rechazado)
                    && fv.aeropuertoDestino.aeropuerto.nombre.equals(frecIteracion.aeropuertoDestino.aeropuerto.nombre)
                    && fv.aeropuertoOrigen.aeropuerto.nombre.equals(frecIteracion.aeropuertoOrigen.aeropuerto.nombre)
                    && fv.compania.nombre.equals(frecIteracion.compania.nombre)) {

                ArrayList<DiaSemanaEnum> auxDiasSemanaFrecuenciaVieja = (ArrayList<DiaSemanaEnum>) frecIteracion.diasSemana.clone();
                ArrayList<DiaSemanaEnum> auxDiasSemanaFrecuenciaNueva = (ArrayList<DiaSemanaEnum>) new ArrayList<>(fv.diasSemana).clone();
                auxDiasSemanaFrecuenciaVieja.retainAll(auxDiasSemanaFrecuenciaNueva);

                if (auxDiasSemanaFrecuenciaVieja.size() == 0) {
                    LogicaFrecuenciaVuelo.getInstancia().actualizarDiasSemana(i, fv.diasSemana);
                    //frecIteracion.diasSemana.addAll(fv.diasSemana);
                    ret = true;
                } else {
                    auxDiasSemanaFrecuenciaNueva.removeAll(auxDiasSemanaFrecuenciaVieja);
                    if (auxDiasSemanaFrecuenciaNueva.size() == 0) {
                        throw new utilities.ExceptionCompania("Ya existe una frecuencia con los datos ingresados. Intente nuevamente.");
                    } else {
                        LogicaFrecuenciaVuelo.getInstancia().actualizarDiasSemana(i, auxDiasSemanaFrecuenciaNueva);
                        //frecIteracion.diasSemana.addAll(auxDiasSemanaFrecuenciaNueva);
                        ret = true;
                    }
                }
            }
            i++;
        }
        return ret;
    }

    //Recibe un nombre de aeropuerto y devuelve si existe
    public Aeropuerto BuscarAeropuertoPorNomber(String aerop) {
        return LogicaAeropuerto.getInstancia().buscarAeropuertoNombre(aerop);
    }

    //Devuelve la lista de FrecuenciaDeVuelo de LogicaFrecuencia
    public ArrayList<FrecuenciaDeVuelo> getFrecuencias() {
        return LogicaFrecuenciaVuelo.getInstancia().getFrecuencias();
    }

    //Devuelve la lista de Vuelos de LogicaVuelo
    public ArrayList<Vuelo> getVuelos() {
        return LogicaVuelo.getInstancia().getVuelos();
    }

    //Recibe una lista de FrecuenciaDeVuelo actualizada y la agrega a la lista de LogicaFrecuenciaVuelo
    public void actualizarFrecuencias(ArrayList<FrecuenciaDeVuelo> frecuencias) {
        LogicaFrecuenciaVuelo.getInstancia().setFrecuencias(frecuencias);
    }

    //Recibe una FrecuenciaDeVuelo y la agrega a LogicaVuelo
    public void agregarVuelo(FrecuenciaDeVuelo fv) {
        LogicaVuelo.getInstancia().crearVuelo(fv);
    }

    //Recibe un Vuelo y lo agrega a LogicaVuelo
    public void agregarPartidaVuelo(Vuelo partida) {
        LogicaVuelo.getInstancia().agregarPartidaVuelo(partida);
    }

    //Recibe un Vuelo y le agrega los datos necesarios de su aterrizaje
    public void agregarLlegadaVuelo(Vuelo arribo) {
        LogicaVuelo.getInstancia().agregarLlegadaVuelo(arribo);
    }

    //Recibe un nombre de aeropuerto y si es de origen o destino. Devuelve una lista de vuelos que tenga ese aeropuerto
    //como origen o destino dependiendo del atributo origDest
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

    //Recibe un nombre de aeropuerto y si es de origen o destino. Devuelve una lista de vuelos que tenga ese aeropuerto
    //como origen o destino dependiendo del atributo origDest Y que tengan en su frecuencia de vuelo el dia de hoy.
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

    //Verifica si ya hay un vuelo con la frecuencia de vuelo pasada por parametro que haya despegado/aterrizado el dia de hoy
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

    //Devuelve lista de vuelos del dia de hoy que tengan el nombre de aeropuerto (nomAero) como origen/destino, dependiendo de origDest
    public ArrayList<String> getVuelosPorAeropuertoMonitoreo(String nomAero, String origDest) {
        ArrayList<Vuelo> v = FachadaModelo.getInstancia().getVuelos();
        ArrayList<String> vuelosFiltrados = new ArrayList<>();
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
                             && vuel.fVuelo.aeropuertoDestino.estado.equals(EstadoEnum.Aprobado)
                            && vuel.fVuelo.aeropuertoOrigen.estado.equals(EstadoEnum.Aprobado) 
                            /*&& vuel.horaRealPartida != null && vuel.horaRealLlegada == null && vuel.fechaPartida.equals(fch)*/) {
                        vuelosFiltrados.add("Num: " + vuel.fVuelo.numero + " - Comp: " + vuel.fVuelo.compania.nombre
                                + " - Aerop: " + vuel.fVuelo.aeropuertoOrigen.aeropuerto.nombre + " - Est: " + vuel.estado);
                    }
                } else {
                    if (vuel.fVuelo.aeropuertoDestino.aeropuerto.nombre.equals(nomAero) && vuel.fVuelo.diasSemana.contains(hoy)
                            && vuel.horaRealPartida != null && vuel.horaRealLlegada != null && vuel.fVuelo.aeropuertoDestino.estado.equals(EstadoEnum.Aprobado)
                            && vuel.fVuelo.aeropuertoOrigen.estado.equals(EstadoEnum.Aprobado) && vuel.fechaPartida.equals(fch)) {
                        vuelosFiltrados.add("Num: " + vuel.fVuelo.numero + " - Comp: " + vuel.fVuelo.compania.nombre
                                + " - Aerop: " + vuel.fVuelo.aeropuertoDestino.aeropuerto.nombre + " - Est:" + vuel.estado);
                    }
                }
            }
        }
        return vuelosFiltrados;
    }

    //Devuelve el DiaSemanaEnum equivalente al ind de dia de la semana que se le pase por parametro
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
