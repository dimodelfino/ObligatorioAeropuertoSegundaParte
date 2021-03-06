/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Vuelo;
import persistencia.IMapeador;

/**
 *
 * @author Maria.Etcheverry
 */
public class MapeadorVuelo implements IMapeador {

    private Vuelo v;

    public MapeadorVuelo() {
    }

    public MapeadorVuelo(Vuelo vuel) {
        this.v = vuel;
    }

    public void setVuelo(Vuelo vuel) {
        this.v = vuel;
    }

    @Override
    public int getOid() {
        return v.oId;
    }

    @Override
    public void setOid(int oid) {
        v.oId = oid;
    }

    @Override
    public String columnaOid() {
        return "idVuelo";
    }

    @Override
    public ArrayList<String> sqlInsertar() {
        ArrayList<String> sqls = new ArrayList();
        String sql = "INSERT INTO aeropuerto.vuelos VALUES(";        
        sql += "'" + v.numero + "', ";
        sql += "'" + v.fechaPartida + "', ";        
        sql += "'" + v.horaRealPartida + "', ";
        sql += "'" + v.horaRealLlegada + "', ";
        sql += "'" + v.estado + "', ";
        sql += "'" + v.arancelPartida + "', ";
        sql += "'" + v.arancelLlegada + "', ";    
        sql += v.oId + ", ";
        sql += "'" + v.getOidFrecVuelo() + "')";
        sqls.add(sql);
        return sqls;
    }

    @Override
    public ArrayList<String> sqlActualizar() {
        ArrayList<String> sqls = new ArrayList();
        String sql = " UPDATE aeropuerto.vuelos SET ";                          
        sql += " horaRealPartida = '" + v.horaRealPartida + "',";
        sql += " horaRealLlegada = '" + v.horaRealLlegada + "',";
        sql += " estado = '" + v.estado + "',";
        sql += " arancelPartida = " + v.arancelPartida + ",";
        sql += " arancelLlegada = " + v.arancelLlegada;         
        sql += " WHERE idVuelo = " + v.oId;
        sqls.add(sql);
        return sqls;
    }

    @Override
    public ArrayList<String> sqlBorrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String sqlCargarTodos() {
        return "SELECT * FROM aeropuerto.vuelos v, aeropuerto.frecuenciadevuelo fv WHERE v.idFrecuenciaVuelo = fv.idFrecuenciaVuelo "
                + " ORDER BY fv.idFrecuenciaVuelo";
    }

    @Override
    public String sqlBuscar(String condicion) {
        String sql = "SELECT * FROM aeropuerto.vuelos v ";
        if (condicion != null && !condicion.isEmpty()) {
            sql += condicion;
        }        
        return sql;
    }

    @Override
    public void inicializarObjeto() {
        v = new Vuelo();
    }

    @Override
    public void cargarDatos(ResultSet rs) throws SQLException {
        v.numero = rs.getString("numero");
        v.fechaPartida = rs.getString("fechaPartida");
        v.horaRealPartida = rs.getString("horaRealPartida");
        v.horaRealLlegada = rs.getString("horaRealLlegada");
        v.estado = rs.getString("estado");
        v.arancelPartida = rs.getInt("arancelPartida");
        v.arancelLlegada = rs.getInt("arancelLlegada");  
        v.setOidFrecVuelo(rs.getInt("idFrecuenciaVuelo"));
        v.oId = rs.getInt("idVuelo");
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        //Vacio porque no necesita cargarse datos.
    }

    @Override
    public Object getObjeto() {
        return v;
    }

}
