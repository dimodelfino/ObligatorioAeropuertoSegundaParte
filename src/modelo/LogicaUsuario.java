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

    //Crea usuarios de prueba
    public void iniciateUsersList() {

        this.usuarios = new ArrayList<>();
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
        
        Usuario e = new UsuCompania();
        e.nombre = "Alberto";
        e.nombreCompleto = "Alberto Moreno";
        e.contrasenia = "Alberto123";
        ((UsuCompania) e).compania = LogicaCompania.getInstancia().getCompanias().get(2);
        this.usuarios.add(e);
        
        Usuario f = new UsuCompania();
        f.nombre = "Laura";
        f.nombreCompleto = "Laura Delfino";
        f.contrasenia = "Laura123";
        ((UsuCompania) f).compania = LogicaCompania.getInstancia().getCompanias().get(3);
        this.usuarios.add(f);
        
        Usuario g = new UsuCompania();
        g.nombre = "Coral";
        g.nombreCompleto = "Coral Gonzalez";
        g.contrasenia = "Coral123";
        ((UsuCompania) g).compania = LogicaCompania.getInstancia().getCompanias().get(4);
        this.usuarios.add(g);

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
        
        Usuario h = new UsuAeropuerto();
        h.nombre = "Juan";
        h.nombreCompleto = "Juan Rodriguez";
        h.contrasenia = "Juan123";
        ((UsuAeropuerto) h).aeropuerto = LogicaAeropuerto.getInstancia().getAeropuertos().get(2);
        this.usuarios.add(h);
        
        Usuario i = new UsuAeropuerto();
        i.nombre = "Sandra";
        i.nombreCompleto = "Sandra Press";
        i.contrasenia = "Sandra123";
        ((UsuAeropuerto) i).aeropuerto = LogicaAeropuerto.getInstancia().getAeropuertos().get(3);
        this.usuarios.add(i);
        
        Usuario j = new UsuAeropuerto();
        j.nombre = "Alicia";
        j.nombreCompleto = "Alicia Moreno";
        j.contrasenia = "Alicia123";
        ((UsuAeropuerto) j).aeropuerto = LogicaAeropuerto.getInstancia().getAeropuertos().get(4);
        this.usuarios.add(j);
        
        Usuario k = new UsuAeropuerto();
        k.nombre = "Ana";
        k.nombreCompleto = "Ana Milovan";
        k.contrasenia = "Ana123";
        ((UsuAeropuerto) k).aeropuerto = LogicaAeropuerto.getInstancia().getAeropuertos().get(5);
        this.usuarios.add(k);
    }

    //Busca Usuarios por nombre
    public Usuario buscarUsuario(String nombre, String contrasenia) {                
         boolean existe = false;
        int i = 0;
        Usuario usu = null;

        while (!existe && i<this.usuarios.size()) {
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
