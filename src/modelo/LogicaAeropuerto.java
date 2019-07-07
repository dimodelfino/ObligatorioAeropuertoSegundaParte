/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Mapeadores.MapeadorAeropuerto;
import modelo.strategy.Nacional;
import modelo.strategy.Internacional;
import modelo.strategy.Regional;
import java.util.ArrayList;
import java.util.List;
import persistencia.BaseDatos;
import persistencia.Persistencia;

/**
 *
 * @author dmoreno
 */
public class LogicaAeropuerto {

    private static LogicaAeropuerto instancia = new LogicaAeropuerto();
    private final BaseDatos bd = BaseDatos.getInstancia();

    private void conectar() {
        bd.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/aeropuerto", "root", "admin");
        //bd.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3307/Aeropuerto", "root", "root");
    }

    private void desconectar() {
        bd.desconectar();
    }

    public static LogicaAeropuerto getInstancia() {
        return instancia;
    }

    public List<Aeropuerto> getAeropuertos() {
        conectar();
        MapeadorAeropuerto ma = new MapeadorAeropuerto();
        Object aeropList = Persistencia.getInstancia().cargarTodos(ma);
        desconectar();
        return (ArrayList) aeropList;
    }

    //Busca aeropuertos por nombre
    public Aeropuerto buscarAeropuertoNombre(String aeropuertoNom) {
        ArrayList<Aeropuerto> a = null;
        conectar();
        MapeadorAeropuerto ma = new MapeadorAeropuerto();
        a = (ArrayList<Aeropuerto>) Persistencia.getInstancia().buscar(ma, " WHERE nombre = '" + aeropuertoNom + "'");
        desconectar();
        return a.get(0);
    }

    //Busca aeropuertos por oId
    public Aeropuerto buscarAeropuertoOid(int oId) {
        ArrayList<Aeropuerto> a = null;                
        conectar();
        MapeadorAeropuerto ma = new MapeadorAeropuerto();
        a = (ArrayList<Aeropuerto>) Persistencia.getInstancia().buscar(ma, " WHERE idAeropuerto = '" + oId + "'");
        desconectar();         
        return a.get(0);
    }
}
