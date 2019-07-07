/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Aeropuerto;
import persistencia.IMapeador;
import utilities.Utils;

/**
 *
 * @author dmoreno
 */
public class MapeadorAeropuerto implements IMapeador{
    
    private Aeropuerto a;

    public MapeadorAeropuerto(){
        
    }
    
    public MapeadorAeropuerto(Aeropuerto aerop){
        this.a = aerop;
    }
    
    public void setAeropuerto(Aeropuerto aerop){
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
        String sql = "SELECT * FROM aeropuerto.aeropuerto ";
        if (condicion != null && !condicion.isEmpty()) {
            sql += condicion;
        }        
        return sql;
    }

    @Override
    public void inicializarObjeto() {
        a = new Aeropuerto();
    }

    @Override
    public void cargarDatos(ResultSet rs) throws SQLException {
        a.nombre = rs.getString("nombre");
        a.tipo = Utils.getTipoAeropuerto(rs.getString("tipo"));
        a.setOid(rs.getInt("idAeropuerto"));
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        //Vacio porque aeropuerto no necesita agregar datos.
    }

    @Override
    public Object getObjeto() {
        return a;
    }
    
}
