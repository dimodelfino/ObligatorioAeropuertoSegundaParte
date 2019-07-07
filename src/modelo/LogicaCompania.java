/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Mapeadores.MapeadorCompania;
import java.util.ArrayList;
import java.util.List;
import persistencia.BaseDatos;
import persistencia.Persistencia;

/**
 *
 * @author dmoreno
 */
public class LogicaCompania {

    //private static List<Compania> companias;
    private static LogicaCompania instancia = new LogicaCompania();
    private final BaseDatos bd = BaseDatos.getInstancia();
    
    private void conectar(){
        bd.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/aeropuerto", "root", "admin");
        //bd.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3307/Aeropuerto", "root", "root");
    }
    
    private void desconectar(){
        bd.desconectar();
    }

    public static LogicaCompania getInstancia() {
        return instancia;
    }

    public List<Compania> getCompanias() {
        conectar();
        MapeadorCompania mc = new MapeadorCompania();
        Object aeropList = Persistencia.getInstancia().cargarTodos(mc);
        desconectar();
        return (ArrayList) aeropList;
    }

    //Busca companias por oId
    public Compania buscarCompaniaOid(int oId) {
        ArrayList<Compania> comp = null;                
        conectar();
        MapeadorCompania mc = new MapeadorCompania();
        comp = (ArrayList<Compania>) Persistencia.getInstancia().buscar(mc, " WHERE idCompania = '" + oId + "'");
        desconectar();         
        return comp.get(0);       
    }
}


