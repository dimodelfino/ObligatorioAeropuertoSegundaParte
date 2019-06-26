/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Compania;
import modelo.DiaSemanaEnum;
import modelo.FrecuenciaDeVuelo;
import persistencia.IMapeador;
import persistencia.Persistencia;

/**
 *
 * @author Maria.Etcheverry
 */
public class MapeadorFrecuenciaVuelo implements IMapeador {

    private FrecuenciaDeVuelo fv;

    private MapeadorFrecuenciaVuelo() {
    }

    private MapeadorFrecuenciaVuelo(FrecuenciaDeVuelo fv) {
        this.fv = fv;
    }

    public void setFrecuenciaDeVuelo(FrecuenciaDeVuelo fv) {
        this.fv = fv;
    }

    @Override
    public int getOid() {
        return fv.getOid();
    }

    @Override
    public void setOid(int oid) {
        fv.setOid(oid);
    }

    @Override
    public String columnaOid() {
        return "idFrecuenciaVuelo";
    }

    @Override
    public ArrayList<String> sqlInsertar() {
        ArrayList<String> sqls = new ArrayList();
        String sql = "INSERT INTO frecuenciaavuelo VALUES(";
        sql += getOid() + ",";
        sql += "'" + fv.numero + "',";
        sql += "'" + fv.diasSemana + "',";
        //TO DO AGREGAR AEROPUERTO ORIGEN , ESTADO
        //sql+= "'" + AERO ORIGEN + "',";
        //TO DO AGREGAR AEROPUERTO DESTINO, ESTADO
        //sql+= "'" + AERO DESTINO + "',";
        sql += "'" + fv.horaPartida + "',";
        sql += "'" + fv.duracionEstimada + "',";
        // TO DO AGREGAR COMPANIA         
        //sql+= "'" + COMPANIA + "')";
        sqls.add(sql);
//        sqls.addAll(generarEstados());
        return sqls;
    }
    
    //TODO COMO HACER PARA CREAR LOS ESTADOS Y ASIGNARSELOS A LA FRECUENCIA DE VUELO
    
    
//      private ArrayList<String> generarEstados() {
//        ArrayList<String> resultado = new ArrayList<>();
//        int nro = 1;
//        for () {
//            String sql = "INSERT INTO Estado values (";
//            sql += getOid() + ",";
//            sql += nro + ",";
//            sql += l.getCantidad() + ",";
//            sql += "'" + l.getProducto() + "')";
//            resultado.add(sql);
//            nro++;
//        }
//        return resultado;
//    }
      
      

    @Override
    public ArrayList<String> sqlActualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> sqlBorrar() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add("DELETE FROM Estado WHERE idFrecuenciaVuelo =" + getOid());
        sqls.add("DELETE FROM frecuenciavuelo WHERE idFrecuenciaVuelo = " + getOid());
        return sqls;
    }

    @Override
    public String sqlCargarTodos() {
        return "SELECT * FROM frecuenciavuelo fv, compania c, estado e "
                + "WHERE fv.idFrecuenciaVuelo = e.idFrecuenciaVuelo "
                + "AND fv.idCompania = c.idCompania";
    }

    @Override
    public String sqlBuscar(String condicion) {
        String sql = "SELECT * FROM frecuenciavuelo,  compania c, estado e "
                + "WHERE fv.idFrecuenciaVuelo = e.idFrecuenciaVuelo "
                + "AND fv.idCompania = c.idCompania";
        if (condicion != null && !condicion.isEmpty()) {
            sql += " AND " + condicion;
        }
        return sql;
    }

    @Override
    public void inicializarObjeto() {
        fv = new FrecuenciaDeVuelo();
    }

    @Override
    public void cargarDatos(ResultSet rs) throws SQLException {
        fv.numero = rs.getString("numero");
        fv.horaPartida = rs.getString("horaPartida");
        fv.diasSemana = convertirDiaSemanaEnum(rs.getString("diaSemana"));
        fv.duracionEstimada = rs.getString("duracionEstimada");
    }

    public ArrayList<DiaSemanaEnum> convertirDiaSemanaEnum(String diasSemana) {
        ArrayList<DiaSemanaEnum> result = new ArrayList();
        for (int i = 0; i < diasSemana.length(); i++) {
            char c = diasSemana.charAt(i);
            String s = Character.toString(c);
            DiaSemanaEnum diaSemana = getDiasSemanaEnum(s);
            if (diaSemana != null) {
                result.add(diaSemana);
            }
        }
        return result;
    }

    public DiaSemanaEnum getDiasSemanaEnum(String diasSemana) {
        DiaSemanaEnum result = null;
        switch (diasSemana) {
            case "Lunes":
                result = DiaSemanaEnum.L;
                break;
            case "Martes":
                result = DiaSemanaEnum.M;
                break;
            case "Miercoles":
                result = DiaSemanaEnum.X;
                break;
            case "Jueves":
                result = DiaSemanaEnum.J;
                break;
            case "Viernes":
                result = DiaSemanaEnum.V;
                break;
            case "Sabado":
                result = DiaSemanaEnum.S;
                break;
            case "Domingo":
                result = DiaSemanaEnum.D;
                break;
        }
        return result;
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        MapeadorEstado me = new MapeadorEstado();
        MapeadorCompania mc = new MapeadorCompania();
       // Estadol aeropuertoOrigen = (Estadol)Persistencia.getInstancia().buscar( me, "WHERE idEstado=" + rs.getInt("aeropuertoOrigen"));
        //Estadol aeropuertoDestino = (Estadol)Persistencia.getInstancia().buscar(me, "WHERE idEstado=" + rs.getInt("aeropuertoDestino"));
        Compania c = (Compania)Persistencia.getInstancia().buscar(mc, "WHERE idCompania=" + rs.getInt("compania"));
//        fv.aeropuertoOrigen= aeropuertoOrigen;
//        fv.aeropuertoDestino= aeropuertoDestino;
        fv.compania= c;
    }

    @Override
    public Object getObjeto() {
        return fv;
    }
}
