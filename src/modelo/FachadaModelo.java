/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Mapeadores.MapeadorFrecuenciaVuelo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import persistencia.BaseDatos;
import persistencia.Persistencia;
import utilities.ExceptionCompania;
import utilities.ExceptionFrecuenciaVuelo;
import utilities.Utils;

/**
 *
 * @author dmoreno
 */
public class FachadaModelo {

    private static FachadaModelo instancia = new FachadaModelo();    
    private final BaseDatos bd = BaseDatos.getInstancia();
    
    private void conectar(){
        bd.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/aeropuerto", "root", "admin");
        //bd.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3307/Aeropuerto", "root", "root");
    }
    
    private void desconectar(){
        bd.desconectar();
    }
    
    public static FachadaModelo getInstancia() {
        return instancia;
    }

    //Instancia una FrecuenciaDeVuelo, valida si existe y la envia a LogicaFrecuenciaVuelo a agregarse a su lista
    public void agregarFrecuencia(String num, String origen, String destino, String hrPartida, String duracionEst, Compania c, ArrayList<DiaSemanaEnum> diasSem) throws ExceptionCompania {
        Aeropuerto aOrigen = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre(origen);
        Aeropuerto aDestino = LogicaAeropuerto.getInstancia().buscarAeropuertoNombre(destino);
        FrecuenciaDeVuelo fv = new FrecuenciaDeVuelo(num, aOrigen, EstadoEnum.Pendiente, aDestino, EstadoEnum.Pendiente, hrPartida, duracionEst, c, diasSem);
        if (!existeFrecuencia(fv)) {
            LogicaFrecuenciaVuelo.getInstancia().GuardarFrecuencia(fv);
        }       
    }

    // Valida si existe o no una frecuencia con los mismos datos
    public boolean existeFrecuencia(FrecuenciaDeVuelo fv) throws utilities.ExceptionCompania {
        boolean ret = false;
        int i = 0;
        ArrayList<FrecuenciaDeVuelo> frecuencias = this.getFrecuencias();
        while (i < frecuencias.size() && !ret) {
            FrecuenciaDeVuelo frecIteracion = frecuencias.get(i);
            if ((frecIteracion.estadoOrigen != EstadoEnum.Rechazado
                    && frecIteracion.estadoDestino != EstadoEnum.Rechazado)
                    && fv.aeropuertoDestino.nombre.equals(frecIteracion.aeropuertoDestino.nombre)
                    && fv.aeropuertoOrigen.nombre.equals(frecIteracion.aeropuertoOrigen.nombre)
                    && fv.compania.nombre.equals(frecIteracion.compania.nombre)) {

                ArrayList<DiaSemanaEnum> auxDiasSemanaFrecuenciaVieja = (ArrayList<DiaSemanaEnum>) frecIteracion.diasSemana.clone();
                ArrayList<DiaSemanaEnum> auxDiasSemanaFrecuenciaNueva = (ArrayList<DiaSemanaEnum>) new ArrayList<>(fv.diasSemana).clone();
                auxDiasSemanaFrecuenciaVieja.retainAll(auxDiasSemanaFrecuenciaNueva);
                if (auxDiasSemanaFrecuenciaVieja.size() == 0) {
                    LogicaFrecuenciaVuelo.getInstancia().actualizarDiasSemana(frecIteracion, fv.diasSemana);
                    ret = true;
                } else {
                    auxDiasSemanaFrecuenciaNueva.removeAll(auxDiasSemanaFrecuenciaVieja);
                    if (auxDiasSemanaFrecuenciaNueva.size() == 0) {
                        throw new utilities.ExceptionCompania("Ya existe una frecuencia con los datos ingresados. Intente nuevamente.");
                    } else {
                        LogicaFrecuenciaVuelo.getInstancia().actualizarDiasSemana(frecIteracion, auxDiasSemanaFrecuenciaNueva);
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

    //Recibe un vuelo y la agrega a la frecuencia
    public void agregarVuelo(Vuelo v) throws ExceptionCompania{
        FrecuenciaDeVuelo fv = buscarFrecuencia(v.numero);
        LogicaVuelo.getInstancia().crearVuelo(fv, v);
        //actualizarFrecuenciaDeVuelo(fvActualizada);
    }

    public FrecuenciaDeVuelo buscarFrecuencia(String numero) {
        FrecuenciaDeVuelo frecuencia = null;
        conectar();        
        MapeadorFrecuenciaVuelo mfv = new MapeadorFrecuenciaVuelo();        
        ArrayList<FrecuenciaDeVuelo> frec = (ArrayList<FrecuenciaDeVuelo>) Persistencia.getInstancia().buscar(mfv, " WHERE fv.numero = '" + numero + "'");       
        desconectar();
        if(frec.size() != 0){
            frecuencia = frec.get(0);
        }
        return frecuencia;
    }

//    public void actualizarFrecuenciaDeVuelo(FrecuenciaDeVuelo fv) throws ExceptionCompania{
//        LogicaFrecuenciaVuelo.getInstancia().actualizarFrecuencia(fv);
//    }

    //Recibe un Vuelo y le agrega los datos necesarios de su aterrizaje
    public void agregarLlegadaVuelo(Vuelo arribo) throws ExceptionCompania{
        FrecuenciaDeVuelo fv = buscarFrecuencia(arribo.numero);
        LogicaVuelo.getInstancia().agregarLlegadaVuelo(fv, arribo);
        //actualizarFrecuenciaDeVuelo(fvActualizada);
    }

    //Recibe un nombre de aeropuerto y si es de origen o destino. Devuelve una lista de vuelos de la fecha actual que tenga ese aeropuerto
    //como origen o destino dependiendo del atributo origDest
    public ArrayList<Vuelo> getVuelosPorAeropuerto(String nomAero, String origDest) {
        ArrayList<Vuelo> v = LogicaFrecuenciaVuelo.getInstancia().getVuelosPorAeropuerto(nomAero, origDest);
        ArrayList<Vuelo> vuelosFiltrados = new ArrayList<>();
        if (v != null && v.size() != 0) {
            for (Vuelo vuel : v) {
                String horaPartida = vuel.horaRealPartida;
                String horaLlegada = vuel.horaRealLlegada;
                if (horaPartida != null) {
                    if(horaLlegada == null|| "null".equals(horaLlegada)){
                        vuelosFiltrados.add(vuel);
                    }                    
                }
            }
        }
        return vuelosFiltrados;
    }

    //Recibe un nombre de aeropuerto y si es de origen o destino. Devuelve una lista de vuelos que no hayan partido
    //todavia el dia de la consulta, que tenga ese aeropuerto como origen o destino dependiendo del atributo origDest     
    //Y que tengan en su frecuencia de vuelo el dia de hoy. Los vuelos no estan guardados en ninguna frecuencia
    public ArrayList<Vuelo> getVuelosDiarios(String nomAero, String origDest) {
        ArrayList<Vuelo> vuelosAux = new ArrayList<Vuelo>();
        Calendar calendar = Calendar.getInstance();
        int dia = calendar.get(Calendar.DAY_OF_WEEK);
        DiaSemanaEnum hoy = Utils.getDiaSemana(dia);
        ArrayList<FrecuenciaDeVuelo> frecuencias = FachadaModelo.getInstancia().getFrecuencias();
        for (FrecuenciaDeVuelo frec : frecuencias) {
            if (frec.aeropuertoOrigen.nombre.equals(nomAero) && frec.diasSemana.contains(hoy)
                    && frec.estadoOrigen.equals(EstadoEnum.Aprobado) && frec.estadoDestino.equals(EstadoEnum.Aprobado)
                    && !vueloYaPartio(frec)) {
                Vuelo v = new Vuelo();
                v.numero = frec.numero;
                v.estado = "En Hora";                
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
        ArrayList<Vuelo> vuelos = f.vuelos;
        while (!partio && vuelos.size() > 0 && i < vuelos.size()) {
            String fecha_String = vuelos.get(i).fechaPartida.trim();
            if (vuelos.get(i).fechaPartida != null && fecha_String.equals(fch)) {
                partio = true;
            }
            i++;
        }
        return partio;
    }

    //Devuelve lista de vuelos del dia de hoy que tengan el nombre de aeropuerto (nomAero) como origen/destino, dependiendo de origDest
    public ArrayList<String> getVuelosPorAeropuertoMonitoreo(String nomAero, String origDest) {
        ArrayList<Vuelo> v = LogicaFrecuenciaVuelo.getInstancia().getVuelosPorAeropuerto(nomAero, origDest);
        ArrayList<String> vuelosFiltrados = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        Date fechaHoy = new Date();
        calendar.setTime(fechaHoy);
        DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        String fch = fecha.format(fechaHoy);

        if (v != null && v.size() > 0) {
            for (Vuelo vuel : v) {
                FrecuenciaDeVuelo fv = buscarFrecuencia(vuel.numero);
                if (origDest.equals("Origen")) {
                    if (vuel.horaRealLlegada == null) {
                        vuelosFiltrados.add("Num: " + vuel.numero + " - Comp: " + fv.compania.nombre
                                + " - Aerop: " + fv.aeropuertoOrigen.nombre + " - Est: " + vuel.estado);
                    }
                } else {
                    if (vuel.horaRealPartida != null /*&& vuel.horaRealLlegada != null */
                            && vuel.fechaPartida.equals(fch)) {
                        vuelosFiltrados.add("Num: " + vuel.numero + " - Comp: " + fv.compania.nombre
                                + " - Aerop: " + fv.aeropuertoDestino.nombre + " - Est:" + vuel.estado);
                    }
                }
            }
        }
        vuelosFiltrados.addAll(getVuelosDiariosString(nomAero, origDest));
        return vuelosFiltrados;
    }

    public ArrayList<String> getVuelosDiariosString(String nomAero, String origDest) {
        ArrayList<Vuelo> vuelos = getVuelosDiarios(nomAero, origDest);
        ArrayList<String> vuelosFiltrados = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        Date fechaHoy = new Date();
        calendar.setTime(fechaHoy);
        DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        String fch = fecha.format(fechaHoy);
        for (Vuelo vuel : vuelos) {
            FrecuenciaDeVuelo fv = buscarFrecuencia(vuel.numero);
            if (origDest.equals("Origen")) {
                vuelosFiltrados.add("Num: " + vuel.numero + " - Comp: " + fv.compania.nombre
                        + " - Aerop: " + fv.aeropuertoOrigen.nombre + " - Est: " + vuel.estado);
            } else {
                if (vuel.horaRealPartida != null /*&& vuel.horaRealLlegada != null */
                        && vuel.fechaPartida.equals(fch)) {
                    vuelosFiltrados.add("Num: " + vuel.numero + " - Comp: " + fv.compania.nombre
                            + " - Aerop: " + fv.aeropuertoDestino.nombre + " - Est:" + vuel.estado);
                }
            }
        }
        return vuelosFiltrados;
    }

    public Usuario buscarUsuario(String nombre, String contrasenia) {
        return LogicaUsuario.getInstancia().buscarUsuario(nombre, contrasenia);
    }

    public void aprobarEstadoFrecuencia(FrecuenciaDeVuelo f, String origDest) throws ExceptionCompania{               
            if (origDest.equals("Destino")) {
                if (f.estadoDestino.equals(EstadoEnum.Pendiente)) {
                    f.estadoDestino = EstadoEnum.Aprobado;
                }
            } else {
                if (f.estadoOrigen.equals(EstadoEnum.Pendiente)) {
                    f.estadoOrigen = EstadoEnum.Aprobado;
                }
            }        
        LogicaFrecuenciaVuelo.getInstancia().actualizarFrecuencia(f);
    }

    public void rechazarEstadoFrecuencia(FrecuenciaDeVuelo frec, String origDest) throws ExceptionCompania{
        if (origDest.equals("Origen")) {
            if (frec.estadoOrigen.equals(EstadoEnum.Pendiente)) {
                frec.estadoOrigen = EstadoEnum.Rechazado;
            }
        } else {
            if (frec.estadoOrigen.equals(EstadoEnum.Aprobado)) {
                frec.estadoDestino = EstadoEnum.Rechazado;
            }
        }
       LogicaFrecuenciaVuelo.getInstancia().actualizarFrecuencia(frec);
    }

    public List<Aeropuerto> getAeropuertos() {
        return LogicaAeropuerto.getInstancia().getAeropuertos();
    }

    public ArrayList<String> getVuelosString(FrecuenciaDeVuelo fv) {
        return LogicaFrecuenciaVuelo.getInstancia().getVuelosString(fv);
    }
    
    public String generarNumeroFrecuencia(Compania c) {
        int cantFrecuencias = LogicaFrecuenciaVuelo.getInstancia().getFrecuencias().size()+1;
        String alias = c.alias + " " + cantFrecuencias;
        return alias;
    }

}
