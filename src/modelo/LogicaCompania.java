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
    
    public static LogicaCompania getInstancia(){
        return instancia;
    }
    
    public List<Compania> getCompanias(){
         return companias;
     }

    public void iniciateCompanyList() {
        Compania c = new Compania();
        this.companias = new ArrayList<Compania>();
        for (int x = 0; x < 4; x++) {
            c.nombre = "comp " + x;   
            c.alias = "C.O.M " + x;
            this.companias.add(c);
        }
    }

}
