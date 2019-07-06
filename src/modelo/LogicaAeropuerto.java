/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.strategy.Nacional;
import modelo.strategy.Internacional;
import modelo.strategy.Regional;
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

    //Crea aerpuertos de prueba
    public void iniciateAirportsList() {
        this.aeropuertos = new ArrayList<Aeropuerto>();
        Aeropuerto a = new Aeropuerto();
        a.nombre = "Carrasco";
        a.tipo = new Internacional();
        a.setOid(1);
        Aeropuerto b = new Aeropuerto();
        b.nombre = "Ezeiza";
        b.tipo = new Regional();
        b.setOid(2);
        Aeropuerto c = new Aeropuerto();
        c.nombre = "Barajas";
        c.tipo = new Nacional();
        c.setOid(3);
        Aeropuerto d = new Aeropuerto();
        d.nombre = "Guarulos";
        d.tipo = new Internacional();
        d.setOid(4);
        Aeropuerto e = new Aeropuerto();
        e.nombre = "JFK";
        e.tipo = new Regional();
        e.setOid(5);
        Aeropuerto f = new Aeropuerto();
        f.nombre = "La Guardia";
        f.tipo = new Nacional();
        f.setOid(6);
        this.aeropuertos.add(a);
        this.aeropuertos.add(b);
        this.aeropuertos.add(c);
        this.aeropuertos.add(d);
        this.aeropuertos.add(e);
        this.aeropuertos.add(f);
    }

    //Busca aeropuertos por nombre
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
    
    //Busca aeropuertos por oId
    public Aeropuerto buscarAeropuertoOid(int oId) {
        Aeropuerto a = null;
        boolean existe = false;
        int i = 0;
        while (!existe) {
            if (aeropuertos.get(i).getOid() == oId) {
                a = aeropuertos.get(i);
                existe = true;
            }
            i++;
        }
        return a;
    }

}
