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
import persistencia.IMapeador;
import utilities.Utils;

/**
 *
 * @author Maria.Etcheverry
 */
public class MapeadorFrecuenciaVuelo implements IMapeador {

    private FrecuenciaDeVuelo fv;

    private MapeadorFrecuenciaVuelo() {
    }

    private MapeadorFrecuenciaVuelo(FrecuenciaDeVuelo fv) {
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
        sql += getOid() + ",";
        sql += "'" + fv.numero + "',";
        sql += fv.aeropuertoOrigen.getOid() + ",";
        sql += "'" + fv.estadoOrigen + "',";
        sql += fv.aeropuertoDestino.getOid() + ",";
        sql += "'" + fv.estadoDestino + "',";
        sql += "'" + fv.horaPartida + "',";
        sql += "'" + fv.duracionEstimada + "',";
        sql += fv.compania.getoId() + ",";
        sql += "'" + fv.diasSemana + "',";
        sqls.add(sql);
        return sqls;
    }

    @Override
    public ArrayList<String> sqlActualizar() {
        ArrayList<String> sqls = new ArrayList();
        String sql = "UPDATE frecuenciaDeVuelo SET(";
        sql += "estadoOrigen = '" + fv.estadoOrigen + "',";
        sql += "estadoDestino = '" + fv.estadoDestino + "',";
        sql += "diaSemana = '" + fv.diasSemana + "',";
        sql += "WHERE idFrecuenciaDeVuelo = " + fv.getOid() + ")";
        sqls.add(sql);
        return sqls;
    }

    @Override
    public ArrayList<String> sqlBorrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String sqlCargarTodos() {        
        return "SELECT * FROM frecuenciavuelo fv, Vuelo v "                               
                + "AND fv.idFrecuenciaVuelo = v.idFrecuenciaVuelo";                                
    }

    @Override
    public String sqlBuscar(String condicion) {
        String sql = "SELECT * FROM frecuenciavuelo,  compania c, Vuelo v, Aeropuerto a "
                + "WHERE fv.idCompania = c.idCompania "
                + "AND fv.aeropuertoOrigen = a.idAeropuerto "
                + "AND fv.aeropuertoDestino = a.idAeropuerto "
                + "AND fv.idFrecuenciaVuelo = v.ididFrecuenciaVuelo";
        if (condicion != null && !condicion.isEmpty()) {
            sql += " AND " + condicion;
        }
        return sql;
    }

    @Override
    public void inicializarObjeto() {
        fv = new FrecuenciaDeVuelo();
    }

    @Override
    public void cargarDatos(ResultSet rs) throws SQLException {
        fv.numero = rs.getString("numero");
        fv.horaPartida = rs.getString("horaPartida");
        fv.diasSemana = Utils.convertirDiaSemanaEnum(rs.getString("diaSemana"));
        fv.duracionEstimada = rs.getString("duracionEstimada");        
        fv.estadoOrigen = Utils.getEstadoEnum(rs.getString("estadoOrigen"));        
        fv.estadoOrigen = Utils.getEstadoEnum(rs.getString("estadoDestino"));
        fv.aeropuertoOrigen = LogicaAeropuerto.getInstancia().buscarAeropuertoOid(rs.getInt("idAeropuertoOrigen"));
        fv.aeropuertoOrigen = LogicaAeropuerto.getInstancia().buscarAeropuertoOid(rs.getInt("idAeropuertoDestino"));
        fv.compania = LogicaCompania.getInstancia().buscarCompaniaOid(rs.getInt("idCompania"));
    }   
   
    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
                
        //MapeadorCompania mc = new MapeadorCompania();
        // Estadol aeropuertoOrigen = (Estadol)Persistencia.getInstancia().buscar( me, "WHERE idEstado=" + rs.getInt("aeropuertoOrigen"));
        //Estadol aeropuertoDestino = (Estadol)Persistencia.getInstancia().buscar(me, "WHERE idEstado=" + rs.getInt("aeropuertoDestino"));
        //Compania c = (Compania) Persistencia.getInstancia().buscar(mc, "WHERE idCompania=" + rs.getInt("compania"));
        //fv.aeropuertoOrigen= aeropuertoOrigen;
//        fv.aeropuertoDestino= aeropuertoDestino;
        //fv.compania = c;
    }

    @Override
    public Object getObjeto() {
        return fv;
    }
}
