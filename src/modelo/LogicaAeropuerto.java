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
public class LogicaAeropuerto {

    private static List<Aeropuerto> aeropuertos;
    private static LogicaAeropuerto instancia = new LogicaAeropuerto();

    public static LogicaAeropuerto getInstancia() {
        return instancia;
    }

    public List<Aeropuerto> getAeropuertos() {
        return aeropuertos;
    }

    public void iniciateAirportsList() {
        this.aeropuertos = new ArrayList<Aeropuerto>();

        Aeropuerto a = new Aeropuerto();
        a.nombre = "Carrasco";
        Aeropuerto b = new Aeropuerto();
        b.nombre = "Ezeiza";
        Aeropuerto c = new Aeropuerto();
        c.nombre = "Barajas";
        Aeropuerto d = new Aeropuerto();
        d.nombre = "Guarulos";
        Aeropuerto e = new Aeropuerto();
        e.nombre = "JFK";
        Aeropuerto f = new Aeropuerto();
        f.nombre = "La Guardia";

        this.aeropuertos.add(a);
        this.aeropuertos.add(b);
        this.aeropuertos.add(c);
        this.aeropuertos.add(d);
        this.aeropuertos.add(e);
        this.aeropuertos.add(f);

    }

    public Aeropuerto buscarAeropuertoNombre(String aeropuertoNom) {
        Aeropuerto a = null;
        boolean existe = false;
        int i = 0;
        while (!existe) {
            if (aeropuertos.get(i).nombre == aeropuertoNom) {
                a = aeropuertos.get(i);
                existe = true;
            }
            i++;
        }
        return a;
    }

}
