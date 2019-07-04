/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Compania;
import persistencia.IMapeador;

/**
 *
 * @author dmoreno
 */
public class MapeadorCompania implements IMapeador {

    private Compania c;

    public MapeadorCompania() {

    }

    public MapeadorCompania(Compania comp) {
        this.c = comp;
    }

    public void setCompania(Compania comp) {
        this.c = comp;
    }

    @Override
    public int getOid() {
        return c.getoId();
    }

    @Override
    public void setOid(int oid) {
        c.setOid(oid);
    }

    @Override
    public String columnaOid() {
        return "idCompania";
    }

    @Override
    public ArrayList<String> sqlInsertar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> sqlActualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> sqlBorrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String sqlCargarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String sqlBuscar(String condicion) {
        String sql = "SELECT * FROM compania";
        if (condicion != null && !condicion.isEmpty()) {
            sql += "WHERE " + condicion;
        }
        return sql;
    }

    @Override
    public void inicializarObjeto() {
        c = new Compania();
    }

    @Override
    public void cargarDatos(ResultSet rs) throws SQLException {
        c.alias = rs.getString("alias");
        c.nombre = rs.getString("nombre");
        c.setOid(rs.getInt("idCompania"));
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        //Vacio porque no necesita cargarse datos.
    }

    @Override
    public Object getObjeto() {
        return c;
    }

}
