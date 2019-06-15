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

    public ArrayList<String> sqlInsertar();

    public ArrayList<String> sqlActualizar();

    public ArrayList<String> sqlBorrar();

    public String sqlCargarTodos();

    public String sqlBuscar(String condicion);

    public void inicializarObjeto();

    public void cargarDatos(ResultSet rs) throws SQLException;

    public void leerComponente(ResultSet rs) throws SQLException;

    public Object getObjeto();

}
