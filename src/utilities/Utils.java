/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.ArrayList;
import java.util.Calendar;
import modelo.DiaSemanaEnum;
import modelo.EstadoEnum;

/**
 *
 * @author dmoreno
 */
public class Utils {
    
     //Devuelve el DiaSemanaEnum equivalente al ind de dia de la semana que se le pase por parametro
    public static DiaSemanaEnum getDiaSemana(int dia) {
        DiaSemanaEnum diaSemana = DiaSemanaEnum.D;

        switch (dia) {
            case Calendar.MONDAY:
                diaSemana = DiaSemanaEnum.L;
                break;
            case Calendar.TUESDAY:
                diaSemana = DiaSemanaEnum.M;
                break;
            case Calendar.WEDNESDAY:
                diaSemana = DiaSemanaEnum.X;
                break;
            case Calendar.THURSDAY:
                diaSemana = DiaSemanaEnum.J;
                break;
            case Calendar.FRIDAY:
                diaSemana = DiaSemanaEnum.V;
                break;
            case Calendar.SATURDAY:
                diaSemana = DiaSemanaEnum.S;
                break;
        }
        return diaSemana;
    }
    
     //Recibe String con los dias de la semana y devuelve ArrayList de tipo DiaSemanaEnum
    public static ArrayList<DiaSemanaEnum> getDiaSemanaEnum(String diaSemana) {
        ArrayList<DiaSemanaEnum> result = new ArrayList<>();
        switch (diaSemana) {
            case "Lunes":
                result.add(DiaSemanaEnum.L);
                break;
            case "Martes":
                result.add(DiaSemanaEnum.M);
                break;
            case "Miercoles":
                result.add(DiaSemanaEnum.X);
                break;
            case "Jueves":
                result.add(DiaSemanaEnum.J);
                break;
            case "Viernes":
                result.add(DiaSemanaEnum.V);
                break;
            case "Sabado":
                result.add(DiaSemanaEnum.S);
                break;
            case "Domingo":
                result.add(DiaSemanaEnum.D);
                break;
        }
        return result;
    }
    
   public static EstadoEnum getEstadoEnum(String estado){
       EstadoEnum e = EstadoEnum.Rechazado;
       if(estado == "Aprobado"){
           e = EstadoEnum.Aprobado;
       }else if(estado == "Pendiente"){
           e = EstadoEnum.Pendiente; 
       }       
       return e;
   }
   
    public static ArrayList<DiaSemanaEnum> convertirDiaSemanaEnum(String diasSemana) {
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
    
     public static DiaSemanaEnum getDiasSemanaEnum(String diasSemana) {
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

}
