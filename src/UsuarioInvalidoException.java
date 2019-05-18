/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author majuetcheverry
 */
public class UsuarioInvalidoException extends Exception{
    private String nombre;
    
    public UsuarioInvalidoException (String nombre) {
        this.nombre = nombre ;
    }
    
    @Override
    public String getMessage() {
        return "El nombre de usuario ingresado: " + nombre + ", no es correcto";
    }
    
}