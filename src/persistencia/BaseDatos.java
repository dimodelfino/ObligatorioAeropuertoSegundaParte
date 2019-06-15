/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author dmoreno
 */
public class BaseDatos {

    private static BaseDatos instancia = new BaseDatos();
    private Connection conexion;
    private Statement stmt;

    public static BaseDatos getInstancia() {
        return instancia;
    }

    private BaseDatos() {
    }

    public void conectar(String driver, String url, String usr, String pass) {
        try {
           // TODO QUE ES EL DRIVER??
           
           Class.forName(driver);
            conexion = DriverManager.getConnection(url, usr, pass);
            stmt = conexion.createStatement();
            System.out.println("Conectado");
        } catch (Exception ex) {
            System.out.println("No se pudo conectar correctamente: " + ex.getMessage());
        }
    }

    public void desconectar() {
        try {
           // TODO ES NECESARIO CERRAR EL STATEMENT??
           //stmt.close();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al desconectar: " + ex.getMessage());
        }
    }

    // Para INSERT, UPDATE, DELETE (devuelve la cantidad de filas que cambiaron)
    public int ejecutar(String sql) {
        try {
            return stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error al modificar: " + ex.getMessage());
            System.out.println("SQL: " + sql);
            return -1;
        }
    }

    // Para SELECT, deuelve un result set con los datos
    public ResultSet consultar(String sql) {
        try {
            return stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Error al consultar: " + ex.getMessage());
            System.out.println("SQL: " + sql);
            return null;
        }
    }

    public boolean transaccion(ArrayList<String> sqls) {
        try {
            conexion.setAutoCommit(false);
            for (String sql : sqls) {
                if (ejecutar(sql) == -1) {
                    System.out.println("Rollback");
                    conexion.rollback();
                    return false;
                }
            }
            conexion.commit();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en transacción: " + e.getMessage());
            return false;
        } finally {
            try {
                conexion.setAutoCommit(true);
            } catch (SQLException ex) {
                System.out.println("Error crítico: " + ex.getMessage());
            }
        }
    }

}
