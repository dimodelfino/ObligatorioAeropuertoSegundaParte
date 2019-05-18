/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;
import modelo.Usuario;
import modelo.LogicaUsuario;
import utilities.UsuarioInvalidoException;


/**
 *
 * @author alumnoFI
 */
public class ControladorLogin {
    
    private IVistaLogIn vista;
    
    public ControladorLogin (IVistaLogIn l){
        this.vista=l;
    }
    
    public void autenticar(String nombre, String contrasenia) throws utilities.UsuarioInvalidoException{
        Usuario usu = LogicaUsuario.getInstancia().buscarUsuario(nombre, contrasenia);
        vista.ingresar(usu);
    }
    
}
