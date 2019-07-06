/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Mapeadores.MapeadorCompania;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import persistencia.BaseDatos;
import persistencia.Persistencia;

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
        a.setOid(7);
        this.companias.add(a);
        Compania b = new Compania();
        b.nombre = "Aerolineas Argentinas ";
        b.alias = "AAR ";
        b.setOid(8);
        this.companias.add(b);
        Compania c = new Compania();
        c.nombre = "PLUNA ";
        c.alias = "PLU ";
        c.setOid(9);
        this.companias.add(c);
        Compania d = new Compania();
        d.nombre = "Air France ";
        d.alias = "AFR ";
        d.setOid(10);
        this.companias.add(d);
        Compania e = new Compania();
        e.nombre = "Jet Blue ";
        e.alias = "JBL ";
        e.setOid(11);
        this.companias.add(e);        
    }        
    
    
    //Busca companias por oId
    public Compania buscarCompaniaOid(int oId) {
        Compania c = null;
        boolean existe = false;
        int i = 0;
        while (!existe && i<companias.size()) {
            if (companias.get(i).getoId() == oId) {
                c = companias.get(i);
                existe = true;
            }
            i++;
        }
        return c;
    }
}


