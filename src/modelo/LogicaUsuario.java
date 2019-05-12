/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dmoreno
 */
public class LogicaUsuario {

    private List<Usuario> usuarios;
    private static LogicaUsuario instancia = new LogicaUsuario();

    public static LogicaUsuario getInstancia() {
        return instancia;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void iniciateUsersList() {

        this.usuarios = new ArrayList<Usuario>();
        Usuario a = new UsuCompania();
        a.nombre = "Diego";
        a.nombreCompleto = "Diego Moreno";
        a.contrasenia = "Diego123";
        ((UsuCompania) a).compania = LogicaCompania.getInstancia().getCompanias().get(0);
        this.usuarios.add(a);

        Usuario b = new UsuCompania();
        b.nombre = "Maju";
        b.nombreCompleto = "Maju Etcheverry";
        b.contrasenia = "Maju123";
        ((UsuCompania) b).compania = LogicaCompania.getInstancia().getCompanias().get(1);
        this.usuarios.add(b);

        Usuario c = new UsuAeropuerto();
        c.nombre = "Moriana";
        c.nombreCompleto = "Moriana Pi";
        c.contrasenia = "Moriana123";
        ((UsuAeropuerto) c).aeropuerto = LogicaAeropuerto.getInstancia().getAeropuertos().get(0);
        this.usuarios.add(c);

        Usuario d = new UsuAeropuerto();
        d.nombre = "Ale";
        d.nombreCompleto = "Alejandro Horne";
        d.contrasenia = "Ale123";
        ((UsuAeropuerto) d).aeropuerto = LogicaAeropuerto.getInstancia().getAeropuertos().get(1);
        this.usuarios.add(d);
    }

    public Usuario buscarUsuario(String nombre, String contrasenia) {
        boolean existe = false;
        int i = 0;
        Usuario usu = null;

        while (!existe) {
            if (this.usuarios.get(i).nombre.equals(nombre)
                    && this.usuarios.get(i).contrasenia.equals(contrasenia)) {
                existe = true;
                usu = usuarios.get(i);
            }
            i++;
        }
        return usu;
    }
}
