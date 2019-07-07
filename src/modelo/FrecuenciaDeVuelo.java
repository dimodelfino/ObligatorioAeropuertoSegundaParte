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
import persistencia.BaseDatos;

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
    private int tiempoEspera = 15;
    private final BaseDatos bd = BaseDatos.getInstancia();
    
    private void conectar(){
        bd.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/aeropuerto", "root", "admin");
        //bd.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3307/Aeropuerto", "root", "root");
    }
    
    private void desconectar(){
        bd.desconectar();
    }       

    public FrecuenciaDeVuelo() {
//        if(estadoOrigen == EstadoEnum.Pendiente || estadoDestino == EstadoEnum.Pendiente){
//           iniciateThread();
//        }
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
//        if(estadoOrigen == EstadoEnum.Pendiente || estadoDestino == EstadoEnum.Pendiente){
//           iniciateThread();
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
        return "Numero: " + numero + " || Segundos Restantes: " + tiempoEspera + " || Origen: " + aeropuertoOrigen.nombre 
                + " || Estado: " + estadoOrigen.toString()
                + " || Destino: " + aeropuertoDestino.nombre
                + " || Estado: " + estadoDestino.toString()
                + " || Dias: " + diasSemana + " || Partida: " + horaPartida + " || Duracion: " + duracionEstimada;
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
        while ((this.estadoOrigen == EstadoEnum.Pendiente || this.estadoDestino == EstadoEnum.Pendiente) && !finalizarThread) {
            try {
                Thread.currentThread().sleep(1000);
                if(tiempoEspera % 5 == 0){
                 LogicaFrecuenciaVuelo.getInstancia().notificarObservadores();   
                }                
                tiempoEspera--;
                if (this.estadoOrigen == EstadoEnum.Aprobado) {
                    if (!origenAprobado) {
                        tiempoEspera = 15;
                        origenAprobado = true;
                    }
                    if (this.estadoDestino == EstadoEnum.Aprobado || this.estadoDestino == EstadoEnum.Rechazado) {
                        tiempoEspera = 0;                        
                        finalizarThread = true;
                        thread.interrupt();
                    }else if(tiempoEspera == 0){
                        this.estadoDestino = EstadoEnum.Rechazado;
                        System.out.println("Oid Frecuencia: " + this.oid);
                        conectar();
                        MapeadorFrecuenciaVuelo mfv = new MapeadorFrecuenciaVuelo();                        
                        desconectar();
                        finalizarThread = true;
                        thread.interrupt();
                    }
                } else if (this.estadoOrigen == EstadoEnum.Rechazado || tiempoEspera == 0) {
                    this.estadoOrigen = EstadoEnum.Rechazado;
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
