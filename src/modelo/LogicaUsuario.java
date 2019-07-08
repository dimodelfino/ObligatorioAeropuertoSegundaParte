/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Mapeadores.MapeadorUsuarioAeropuerto;
import Mapeadores.MapeadorUsuarioCompania;
import java.util.ArrayList;
import java.util.List;
import persistencia.BaseDatos;
import persistencia.Persistencia;

/**
 *
 * @author dmoreno
 */
public class LogicaUsuario {

    //private List<Usuario> usuarios;
    private static LogicaUsuario instancia = new LogicaUsuario();
    private final BaseDatos bd = BaseDatos.getInstancia();

    private void conectar() {
        //bd.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/aeropuerto", "root", "admin");
        bd.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3307/Aeropuerto", "root", "root");
    }

    private void desconectar() {
        bd.desconectar();
    }

    public static LogicaUsuario getInstancia() {
        return instancia;
    }

    public List<Usuario> getUsuarios() {
        conectar();
        MapeadorUsuarioAeropuerto mua = new MapeadorUsuarioAeropuerto();
        List usuAerop = (List)Persistencia.getInstancia().cargarTodos(mua);
        desconectar();
        conectar();
        MapeadorUsuarioCompania muc = new MapeadorUsuarioCompania();
        List usuComp = (List)Persistencia.getInstancia().cargarTodos(muc);
        desconectar();
        usuAerop.addAll(usuComp);
        return usuAerop;
    }

    //Busca Usuarios por nombre
    public Usuario buscarUsuario(String nombre, String contrasenia) {
        ArrayList<Usuario> usu = null;
        Usuario u = null;
        conectar();
        MapeadorUsuarioAeropuerto mua = new MapeadorUsuarioAeropuerto();
        usu = (ArrayList<Usuario>) Persistencia.getInstancia().buscar(mua, " WHERE nombre = '" + nombre + "'" + " AND contrasenia = '" + contrasenia + "'");
        desconectar();
        conectar();
        MapeadorUsuarioCompania muc = new MapeadorUsuarioCompania();
        usu.addAll((ArrayList<Usuario>) Persistencia.getInstancia().buscar(muc, " WHERE nombre = '" + nombre + "'" + " AND contrasenia = '" + contrasenia + "'"));
        desconectar();
        if(!usu.isEmpty()){
            u = usu.get(0);
        }
        return u;        
    }
}
