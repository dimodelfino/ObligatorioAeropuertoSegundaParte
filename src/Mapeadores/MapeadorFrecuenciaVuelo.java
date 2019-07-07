/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.FrecuenciaDeVuelo;
import modelo.LogicaAeropuerto;
import modelo.LogicaCompania;
import modelo.Vuelo;
import persistencia.IMapeador;
import persistencia.Persistencia;
import utilities.Utils;

/**
 *
 * @author Maria.Etcheverry
 */
public class MapeadorFrecuenciaVuelo implements IMapeador {

    private FrecuenciaDeVuelo fv;

    public MapeadorFrecuenciaVuelo() {
    }

    public MapeadorFrecuenciaVuelo(FrecuenciaDeVuelo fv) {
        this.fv = fv;
    }

    public void setFrecuenciaDeVuelo(FrecuenciaDeVuelo fv) {
        this.fv = fv;
    }

    @Override
    public int getOid() {
        return fv.getOid();
    }

    @Override
    public void setOid(int oid) {
        fv.setOid(oid);
    }

    @Override
    public String columnaOid() {
        return "idFrecuenciaVuelo";
    }

    @Override
    public ArrayList<String> sqlInsertar() {
        ArrayList<String> sqls = new ArrayList();
        String sql = "INSERT INTO frecuenciaDeVuelo VALUES(";
        sql += "'" + fv.numero + "',";
        sql += fv.aeropuertoOrigen.getOid() + ",";
        sql += fv.aeropuertoDestino.getOid() + ",";
        sql += "'" + fv.estadoOrigen + "',";
        sql += "'" + fv.estadoDestino + "',";
        sql += "'" + fv.horaPartida + "',";
        sql += "'" + fv.duracionEstimada + "',";
        sql += fv.compania.getoId() + ",";
        sql += "'" + fv.diasSemana + "',";
        sql += getOid() + ")";
        sqls.add(sql);
        return sqls;
    }

    @Override
    public ArrayList<String> sqlActualizar() {
        ArrayList<String> sqls = new ArrayList();
        String sql = "UPDATE aeropuerto.frecuenciaDeVuelo SET ";
        sql += "estadoOrigen = '" + fv.estadoOrigen + "',";
        sql += "estadoDestino = '" + fv.estadoDestino + "',";
        sql += "diaSemana = '" + fv.diasSemana + "'";
        sql += " WHERE idFrecuenciaVuelo = " + fv.getOid() + ";";
        sqls.add(sql);
        return sqls;
    }

    @Override
    public ArrayList<String> sqlBorrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String sqlCargarTodos() {
        return "SELECT * FROM aeropuerto.frecuenciadevuelo fv " +
                "LEFT JOIN aeropuerto.vuelos v  ON v.idFrecuenciaVuelo = fv.idFrecuenciaVuelo"  +
                "ORDER BY  fv.idFrecuenciaVuelo, v.idFrecuenciaVuelo";
        
        
        
        
//        return "SELECT * FROM aeropuerto.frecuenciadevuelo fv " +
//               "LEFT JOIN aeropuerto.vuelos v " +
//               "ON v.idFrecuenciaVuelo = fv.idFrecuenciaVuelo "+
//               "UNION SELECT * FROM aeropuerto.frecuenciadevuelo fv " +
//               "RIGHT JOIN aeropuerto.vuelos v " + 
//               "ON v.idFrecuenciaVuelo = fv.idFrecuenciaVuelo";
    }

    @Override
    public String sqlBuscar(String condicion) {
        String sql = "SELECT * FROM aeropuerto.frecuenciadevuelo fv " +
                "LEFT JOIN aeropuerto.vuelos v  ON v.idFrecuenciaVuelo = fv.idFrecuenciaVuelo ";                             
        if (condicion != null && !condicion.isEmpty()) {
            sql += condicion;
        }
        sql += " ORDER BY  fv.idFrecuenciaVuelo, v.idFrecuenciaVuelo";
        System.out.println("Sql Buscar: " + sql);
        return sql;
    }

    @Override
    public void inicializarObjeto() {
        fv = new FrecuenciaDeVuelo();
    }

    @Override
    public void cargarDatos(ResultSet rs) throws SQLException {
        //inicializarObjeto();
        fv.numero = rs.getString("numero");
        fv.horaPartida = rs.getString("horaPartida");
        fv.diasSemana = Utils.convertirDiaSemanaEnum(rs.getString("diaSemana"));
        fv.duracionEstimada = rs.getString("duracionEstimada");
        fv.estadoOrigen = Utils.getEstadoEnum(rs.getString("estadoOrigen"));
        fv.estadoDestino = Utils.getEstadoEnum(rs.getString("estadoDestino"));
        fv.aeropuertoOrigen = LogicaAeropuerto.getInstancia().buscarAeropuertoOid(rs.getInt("idAeropuertoOrigen"));
        fv.aeropuertoDestino = LogicaAeropuerto.getInstancia().buscarAeropuertoOid(rs.getInt("idAeropuertoDestino"));
        fv.compania = LogicaCompania.getInstancia().buscarCompaniaOid(rs.getInt("idCompania"));
        fv.setOid(rs.getInt("idFrecuenciaVuelo"));
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
//        MapeadorVuelo mv = new MapeadorVuelo();
//        fv.vuelos.addAll((ArrayList<Vuelo>)Persistencia.getInstancia().buscar(mv, "WHERE idFrecuenciaVuelo = " + fv.getOid()));
//        
        int idVuelo = rs.getInt("idVuelo");
        if (idVuelo != 0) {
            Vuelo v = new Vuelo(rs.getString("numero"), rs.getString("fechaPartida"), rs.getString("horaRealPartida"),
                    rs.getString("horaRealLlegada"), rs.getString("estado"), rs.getInt("arancelPartida"),
                    rs.getInt("arancelLlegada"), idVuelo, rs.getInt("idFrecuenciaVuelo"));
            fv.vuelos.add(v);
        }
    }

    @Override
    public Object getObjeto() {
        return fv;
    }
}
