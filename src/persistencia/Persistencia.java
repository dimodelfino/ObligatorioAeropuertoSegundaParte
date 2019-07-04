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
public class Persistencia {
     
    private static Persistencia instancia = new Persistencia();

    private BaseDatos bd = BaseDatos.getInstancia();

    private Persistencia() {
    }

    public static Persistencia getInstancia() {
        return instancia;
    }

    public int proximoOid() {
        ResultSet rs = bd.consultar("SELECT * FROM oid");
        try {
            if (!rs.next()) {
                System.out.println("No hay OID");
                return -1;
            }
            int oid = rs.getInt("oid");
            String sql = "UPDATE oid SET oid=" + (oid + 1);
            if (bd.ejecutar(sql) == -1) {
                System.out.println("No se pudo actualizar el siguiente OID");
            }
            return oid;
        } catch (SQLException ex) {
            System.out.println("Error al obtener el oid:" + ex.getMessage());
            return -1;
        }
    }

    public void guardar(IMapeador m) {
     
        if (m.getOid() == 0) {
            insertar(m);
        } else {
            actualizar(m);
        }
    }

    private void insertar(IMapeador m) {
        int oid = proximoOid();
        if (oid == -1) {
            System.out.println("OID inválido");
            // TODO TIRAR EXCEPCION 
        } 
        m.setOid(oid);
        if (!bd.transaccion(m.sqlInsertar())) {
            m.setOid(0);
            System.out.println("Error al insertar");
        }
    }

    private void actualizar(IMapeador m) {
        ArrayList<String> sqls = m.sqlActualizar();
        if (!bd.transaccion(sqls)) {
            System.out.println("Error al actualizar");
        }
    }

    public void borrar(IMapeador m) {
        ArrayList<String> sqls = m.sqlBorrar();
        if (!bd.transaccion(sqls)) {
            System.out.println("Error al borrar");
        } else {
            m.setOid(0);
        }
    }

    public Object cargarTodos(IMapeador m) {
        return buscar(m, "");
    }

    public Object buscar(IMapeador m, String condicion) {

        ArrayList<Object> resultado = new ArrayList();
        String sql = m.sqlBuscar(condicion);

        ResultSet rs = bd.consultar(sql);
        if (rs == null) {
            return new ArrayList<>();
        }
        try {
            int oidActual, oidAnterior = -1;
            while (rs.next()) {
                oidActual = rs.getInt(m.columnaOid());
                if (oidActual != oidAnterior) {
                    oidAnterior = oidActual;
                    m.inicializarObjeto();
                    m.setOid(oidActual);
                    m.cargarDatos(rs);
                    Object nuevo = m.getObjeto(); 
                    resultado.add(nuevo); 
                }
                m.leerComponente(rs); 
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar: " + ex.getMessage());
            ex.printStackTrace();
        }
        return resultado;
    }        
}
