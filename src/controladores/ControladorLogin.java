/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;
import java.util.Observable;
import java.util.Observer;
import modelo.Usuario;
import modelo.LogicaUsuario;


/**
 *
 * @author alumnoFI
 */
public class ControladorLogin {
    
    private IVistaLogIn vista;
    
    public ControladorLogin (IVistaLogIn l){
        this.vista=l;
    }
    
    public void autenticar(String nombre, String contrasenia) throws utilities.ExceptionLogin{
        Usuario usu = LogicaUsuario.getInstancia().buscarUsuario(nombre, contrasenia);
        if(usu != null){
            vista.ingresar(usu);
        }else{
         throw new utilities.ExceptionLogin();
        }
    }  
}
