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
public class LogicaCompania {

    private static List<Compania> companias;
    private static LogicaCompania instancia = new LogicaCompania();

    public static LogicaCompania getInstancia() {
        return instancia;
    }

    public List<Compania> getCompanias() {
        return companias;
    }

    //Crea Compañias de prueba
    public void iniciateCompanyList() {
        this.companias = new ArrayList<>();
        Compania a = new Compania();
        a.nombre = "LAN ";
        a.alias = "LAN ";
        this.companias.add(a);
        Compania b = new Compania();
        b.nombre = "Aerolineas Argentinas ";
        b.alias = "AAR ";
        this.companias.add(b);
        Compania c = new Compania();
        c.nombre = "PLUNA ";
        c.alias = "PLU ";
        this.companias.add(c);
        Compania d = new Compania();
        d.nombre = "Air France ";
        d.alias = "AFR ";
        this.companias.add(d);
        Compania e = new Compania();
        e.nombre = "Jet Blue ";
        e.alias = "JBL ";
        this.companias.add(e);
    }        
}


