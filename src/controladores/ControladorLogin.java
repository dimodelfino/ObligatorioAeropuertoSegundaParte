/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import modelo.Usuario;
import modelo.LogicaUsuario;
import modelo.UsuAeropuerto;
import modelo.UsuCompania;
import vistas.TipoVentanaEnum;

/**
 *
 * @author alumnoFI
 */
public class ControladorLogin {

    private IVistaLogIn vista;

    public ControladorLogin(IVistaLogIn l) {
        this.vista = l;
    }

    public void autenticar(String nombre, String contrasenia, TipoVentanaEnum tipoVent) throws utilities.ExceptionLogin {
        Usuario usu = LogicaUsuario.getInstancia().buscarUsuario(nombre, contrasenia);
        if (usu != null && checkTipoVentanaUsuario(usu, tipoVent)) {
            vista.ingresar(usu);
        } else {
            throw new utilities.ExceptionLogin();
        }
    }

    public boolean checkTipoVentanaUsuario(Usuario usu, TipoVentanaEnum vent) {
        boolean result = false;
        if (vent == TipoVentanaEnum.Compania) {
            if (usu.getClass() == UsuCompania.class) {
                result = true;
            }
        } else {
            if (usu.getClass() == UsuAeropuerto.class) {
                result = true;
            }
        }
        return result;
    }
}
