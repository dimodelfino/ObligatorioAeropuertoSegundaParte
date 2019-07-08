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
import java.util.Date;
import java.util.Set;
import persistencia.BaseDatos;
import persistencia.Persistencia;
import utilities.ExceptionCompania;

/**
 *
 * @author dmoreno
 */
public class FrecuenciaDeVuelo implements Runnable {

    public String numero;
    public Aeropuerto aeropuertoOrigen;
    public EstadoEnum estadoOrigen;
    public Aeropuerto aeropuertoDestino;
    public EstadoEnum estadoDestino;
    public String horaPartida;
    public String duracionEstimada;
    public Compania compania;
    public ArrayList<DiaSemanaEnum> diasSemana = new ArrayList<>();
    private int oid;
    public ArrayList<Vuelo> vuelos = new ArrayList<>();
    private Thread thread;
    public int tiempoEspera = 15;
    private final BaseDatos bd = BaseDatos.getInstancia();

    private void conectar() {
        //bd.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/aeropuerto", "root", "admin");
        bd.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3307/Aeropuerto", "root", "root");
    }

    private void desconectar() {
        bd.desconectar();
    }

    public FrecuenciaDeVuelo() {
        if (estadoOrigen == EstadoEnum.Pendiente || estadoDestino == EstadoEnum.Pendiente) {
            iniciateThread();
        }
    }

    public FrecuenciaDeVuelo(String num, Aeropuerto origen, EstadoEnum estadoOrigen, Aeropuerto destino, EstadoEnum estadoDestino, String hrPartida, String duracionEst, Compania c, ArrayList<DiaSemanaEnum> diasSem) {
        numero = num;
        aeropuertoOrigen = origen;
        this.estadoOrigen = estadoOrigen;
        aeropuertoDestino = destino;
        this.estadoDestino = estadoDestino;
        horaPartida = hrPartida;
        duracionEstimada = duracionEst;
        compania = c;
        diasSemana = diasSem;
        if (this.estadoOrigen == EstadoEnum.Pendiente || (this.estadoOrigen == EstadoEnum.Aprobado && this.estadoDestino == EstadoEnum.Pendiente)) {
            iniciateThread();
        }
    }

    public FrecuenciaDeVuelo(String num, Aeropuerto origen, EstadoEnum estadoOrigen, Aeropuerto destino, EstadoEnum estadoDestino, String hrPartida, String duracionEst, Compania c, ArrayList<DiaSemanaEnum> diasSem, int oId, int tiempoE) {
        numero = num;
        aeropuertoOrigen = origen;
        this.estadoOrigen = estadoOrigen;
        aeropuertoDestino = destino;
        this.estadoDestino = estadoDestino;
        horaPartida = hrPartida;
        duracionEstimada = duracionEst;
        compania = c;
        diasSemana = diasSem;
        this.oid = oId;
        tiempoEspera = tiempoE;
//        if (this.estadoOrigen == EstadoEnum.Pendiente || (this.estadoOrigen == EstadoEnum.Aprobado && this.estadoDestino == EstadoEnum.Pendiente)) {
//            iniciateThread();
//        }
    }

    private void iniciateThread() {
        thread = new Thread(this);
        thread.start();
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    @Override
    public String toString() {
        String result = "Numero: " + numero + " || Segundos Restantes: " + tiempoEspera + " || Origen: " + aeropuertoOrigen.nombre
                + " || Estado: " + estadoOrigen.toString()
                + " || Destino: " + aeropuertoDestino.nombre
                + " || Estado: " + estadoDestino.toString()
                + " || Dias: " + diasSemana + " || Partida: " + horaPartida + " || Duracion: " + duracionEstimada;
        return result;
    }

    public String toStringVuelo(Vuelo v) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String result = dateFormat.format(date) + " -- " + numero + " -- " + aeropuertoDestino.nombre + " -- " + horaPartida;
        if (v.horaRealPartida != null) {
            result = numero + " -- " + aeropuertoOrigen.nombre + " -- " + horaPartida + " -- " + v.estado;
        } else if (v.horaRealPartida != null && v.horaRealLlegada != null) {

        }
        return result;
    }

    @Override
    public void run() {
        boolean origenAprobado = false;
        boolean finalizarThread = false;
        while (!finalizarThread) {
            try {
                Thread.currentThread().sleep(1000);
                conectar();
                MapeadorFrecuenciaVuelo mfv = new MapeadorFrecuenciaVuelo();
                mfv.setFrecuenciaDeVuelo(this);
                ArrayList<FrecuenciaDeVuelo> frec = (ArrayList<FrecuenciaDeVuelo>) Persistencia.getInstancia().buscar(mfv, " WHERE fv.numero = '" + this.numero + "'");
                desconectar();                
                if (frec.get(0).tiempoEspera % 10 == 0) {
                    conectar();
                    mfv.setFrecuenciaDeVuelo(frec.get(0));
                    try {
                        Persistencia.getInstancia().guardar(mfv);
                    } catch (ExceptionCompania x) {
                        System.out.println(x);
                    }
                    desconectar();
                    LogicaFrecuenciaVuelo.getInstancia().notificarObservadores();
                }
                frec.get(0).tiempoEspera--;
                conectar();
                mfv.setFrecuenciaDeVuelo(frec.get(0));
                try {
                    Persistencia.getInstancia().guardar(mfv);
                } catch (ExceptionCompania x) {
                    System.out.println("Thread error: " + x);
                }
                desconectar();
                if (frec.get(0).estadoOrigen == EstadoEnum.Aprobado) {
                    if (!origenAprobado) {
                        tiempoEspera = 15;
                        origenAprobado = true;
                    }
                    if (frec.get(0).estadoDestino == EstadoEnum.Aprobado || frec.get(0).estadoDestino == EstadoEnum.Rechazado) {
                        tiempoEspera = 0;
                        finalizarThread = true;
                        thread.interrupt();
                    } else if (tiempoEspera == 0) {
                        frec.get(0).estadoDestino = EstadoEnum.Rechazado;
                        System.out.println("Oid Frecuencia: " + frec.get(0).oid);
                        conectar();
                        mfv.setFrecuenciaDeVuelo(frec.get(0));
                        try {
                            Persistencia.getInstancia().guardar(mfv);
                        } catch (ExceptionCompania x) {
                            System.out.println("Thread error: " + x);
                        }
                        desconectar();
                        finalizarThread = true;
                        thread.interrupt();
                    }
                } else if (frec.get(0).estadoOrigen == EstadoEnum.Rechazado && frec.get(0).estadoDestino == EstadoEnum.Pendiente || frec.get(0).tiempoEspera == 0) {
                    frec.get(0).estadoOrigen = EstadoEnum.Rechazado;
                    conectar();
                    mfv.setFrecuenciaDeVuelo(frec.get(0));
                    try {
                        Persistencia.getInstancia().guardar(mfv);
                    } catch (ExceptionCompania x) {
                        System.out.println("Thread error: " + x);
                    }
                    desconectar();
                    tiempoEspera = 0;
                    finalizarThread = true;
                    thread.interrupt();
                }
            } catch (InterruptedException ex) {
                System.out.println("ERROR ON THREAD");
            }
        }
        LogicaFrecuenciaVuelo.getInstancia().notificarObservadores();
    }
}
