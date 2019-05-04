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

    public static LogicaUsuario getInstancia(){
        return instancia;
    }     
    
    public List<Usuario> getUsuarios(){
         return usuarios;
     }
    
    public void iniciateUsersList() {
        Usuario u;
        this.usuarios = new ArrayList<Usuario>();
        for (int x = 0; x < 4; x++) {            
            if(x <= 2){
                u = new UsuCompania();
                u.nombre = "nombreUsuComp " + x;
                u.nombreCompleto = "NombreComplUsuComp " + x;
                u.contrasenia = "pass" + x;
                ((UsuCompania)u).compania = new Compania();
                this.usuarios.add(u);
            }else{
                u = new UsuAeropuerto();
                u.nombre = "nombreUsuComp " + x;
                u.nombreCompleto = "NombreComplUsuComp " + x;
                u.contrasenia = "pass" + x;
                this.usuarios.add(u);
            }
        }
    }
    
    public Usuario buscarUsuario (String nombre, String contrasenia){
        boolean existe = false;
        int i = 0;
        Usuario usu = null;
        
        while(!existe){
            if(usuarios.get(i).nombre.equals(nombre) 
                    && usuarios.get(i).contrasenia.equals(contrasenia)){
                existe= true;
                usu= usuarios.get(i);      
            }
            i++;
        }
        return usu;
    }
}
