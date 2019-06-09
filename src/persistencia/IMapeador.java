/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dmoreno
 */
public interface IMapeador {        

    int getOid();
    void setOid(int oid);
    String columnaOid();

 
    ArrayList<String> sqlInsertar();    
    ArrayList<String> sqlActualizar(); 
    ArrayList<String> sqlBorrar();
    String sqlCargarTodos(); 
    String sqlBuscar(String condicion);

    void inicializarObjeto();
    void cargarDatos(ResultSet rs)  throws SQLException;
    void leerComponente(ResultSet rs) throws SQLException;
    Object getObjeto(); 
    
}
