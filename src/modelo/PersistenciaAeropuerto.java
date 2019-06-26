/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.IMapeador;

/**
 *
 * @author dmoreno
 */
public class PersistenciaAeropuerto implements IMapeador {

    private Aeropuerto a;

    public PersistenciaAeropuerto() {
    }

    ;
    
    public PersistenciaAeropuerto(Aeropuerto aerop) {
        this.a = aerop;
    }

    public void setAeropuerto(Aeropuerto aerop) {
        this.a = aerop;
    }

    @Override
    public int getOid() {
        return a.getOid();
    }

    @Override
    public void setOid(int oid) {
        a.setOid(oid);
    }

    @Override
    public String columnaOid() {
        return "idAeropuerto";
    }

    @Override
    public ArrayList<String> sqlInsertar() {
        ArrayList<String> sqls = new ArrayList();
        String sql = "INSERT INTO aeropuerto values (";
        sql += a.nombre + "',";
        sql += a.tipo + ",";
        sqls.add(sql);
        return sqls;
    }

    @Override
    public ArrayList<String> sqlActualizar() {
        ArrayList<String> sqls = new ArrayList();
        String sql = "UPDATE aeropuerto SET ";
        sql += "nombre=" + a.nombre + ",";
        sql += "tipo=" + a.tipo;
        sql += "WHERE idAeropuerto = " + a.getOid();
        sqls.add(sql);
        return sqls;
    }

    @Override
    public ArrayList<String> sqlBorrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String sqlCargarTodos() {
        return "SELECT * FROM aeropuerto";
    }

    @Override
    public String sqlBuscar(String condicion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inicializarObjeto() {
        a = new Aeropuerto();
    }

    @Override
    public void cargarDatos(ResultSet rs) throws SQLException {
        a.nombre = rs.getString("nombre");
       // a.tipo = rs.getString("tipo");
        a.setOid(rs.getInt("idAeropuerto"));
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getObjeto() {
        return a;
    }
}
