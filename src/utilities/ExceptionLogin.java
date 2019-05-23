/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author majuetcheverry
 */
public class ExceptionLogin extends Exception {
    
    public ExceptionLogin () {}
   
     @Override
    public String getMessage() {
        return "Login Invalido";
    }

}
