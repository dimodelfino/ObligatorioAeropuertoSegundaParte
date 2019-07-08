/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.LogicaAeropuerto;
import modelo.UsuAeropuerto;
import persistencia.IMapeador;

/**
 *
 * @author dmoreno
 */
public class MapeadorUsuarioAeropuerto implements IMapeador{
    
    private UsuAeropuerto ua;
    
    public MapeadorUsuarioAeropuerto(){
        
    }
    
    public MapeadorUsuarioAeropuerto(UsuAeropuerto usuAero){
        this.ua = usuAero;
    }
    
    public void setUsuarioAeropuerto(UsuAeropuerto usuAero){
        this.ua = usuAero;
    }

    @Override
    public int getOid() {
        return ua.getOid();
    }

    @Override
    public void setOid(int oid) {
        ua.setOid(oid);
    }

    @Override
    public String columnaOid() {
        return "oId";
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
        String sql = "SELECT * FROM usuarioaeropuerto ";
        if (condicion != null && !condicion.isEmpty()) {
            sql += condicion;
        }    
        System.out.println(sql);
        return sql;
    }

    @Override
    public void inicializarObjeto() {
        this.ua = new UsuAeropuerto();
    }

    @Override
    public void cargarDatos(ResultSet rs) throws SQLException {
        ua.contrasenia = rs.getString("contrasenia");
        ua.nombre = rs.getString("nombre");
        ua.nombreCompleto = rs.getString("nombreCompleto");        
        ua.aeropuerto = LogicaAeropuerto.getInstancia().buscarAeropuertoOid(rs.getInt("idAeropuerto"));
        ua.setOid(rs.getInt("oId"));
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        //Vacio porque no necesita cargarse datos.
    }

    @Override
    public Object getObjeto() {
        return ua;
    }
    
}
