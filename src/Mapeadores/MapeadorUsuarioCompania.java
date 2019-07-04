/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.LogicaCompania;
import modelo.UsuCompania;
import persistencia.IMapeador;

/**
 *
 * @author dmoreno
 */
public class MapeadorUsuarioCompania implements IMapeador{
    
    private UsuCompania uc;
    
    public MapeadorUsuarioCompania(){
        
    }
    
    public MapeadorUsuarioCompania (UsuCompania uComp){
        this.uc = uComp;
    }
    
    public void setUsuCompania(UsuCompania usComp){
        this.uc = usComp;
    }

    @Override
    public int getOid() {
        return uc.getOid();
    }

    @Override
    public void setOid(int oid) {
        uc.setOid(oid);
    }

    @Override
    public String columnaOid() {
        return "idUsuCompania";
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
        String sql = "SELECT * FROM usuariocompania";
        if (condicion != null && !condicion.isEmpty()) {
            sql += "WHERE " + condicion;
        }        
        return sql;
    }

    @Override
    public void inicializarObjeto() {
        uc = new UsuCompania();
    }

    @Override
    public void cargarDatos(ResultSet rs) throws SQLException {
        uc.contrasenia = rs.getString("contrasenia");
        uc.nombre = rs.getString("nombre");
        uc.nombreCompleto = rs.getString("nombreCompleto");
        uc.compania = LogicaCompania.getInstancia().buscarCompaniaOid(rs.getInt("idCompania"));
        uc.setOid(rs.getInt("idUsuCompania"));
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        //Vacio porque no necesita cargarse datos.
    }

    @Override
    public Object getObjeto() {
        return uc;
    }
    
}
