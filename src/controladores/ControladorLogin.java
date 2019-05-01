/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;
import modelo.LogicaUsuario;
import vistas.Login;

/**
 *
 * @author alumnoFI
 */
public class ControladorLogin {
    
    private IVistaLogIn vista;
    
    public ControladorLogin (Login l){
        this.vista=l;
    }
    
    public void autenticar(String nombre, String contrasenia){
        LogicaUsuario usu = new LogicaUsuario( );
        
        
    }
    
}
