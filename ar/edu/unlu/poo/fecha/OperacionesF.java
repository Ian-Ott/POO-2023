package ar.edu.unlu.poo.fecha;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OperacionesF {
    Fecha elegida = new Fecha();
    public String fecha_transformada (int formato){
        LocalDate fechaAux = elegida.getFecha_det();
        String acumulador = "";
        if (formato == 1){
            acumulador += "Fecha: " + fechaAux.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }else if (formato == 2){
            acumulador += "Fecha: " + fechaAux.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        }
        return acumulador;
    }

    public void establecer_fecha(LocalDate fecha){
        elegida.setFecha_det(fecha);
    }
    public boolean fecha_menor(LocalDate fecha1){
        boolean resultado = false;
        LocalDate fechaAux = elegida.getFecha_det();
        if (fechaAux.isBefore(fecha1)){
            resultado = true;
        }
        return resultado;
    }

    public boolean fecha_mayor(LocalDate fecha1){
        boolean resultado = false;
        LocalDate fechaAux = elegida.getFecha_det();
        if (fechaAux.isAfter(fecha1)){
            resultado = true;
        }
        return resultado;
    }

    public boolean entre_fechas(LocalDate fecha1, LocalDate fecha2){
        LocalDate fechaAux = elegida.getFecha_det();
        boolean resultado = false;
        if (fecha1.isBefore(fechaAux) && fecha2.isAfter(fechaAux)){
            resultado = true;
        } else if (fecha2.isBefore(fechaAux) && fecha1.isAfter(fechaAux)) {
            resultado = true;
        }
        return resultado;
    }
    public String toString(){
        LocalDate fechaAux = elegida.getFecha_det();
        String acumulador = "";
        acumulador += "Fecha: " + fechaAux.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))  + " (dd-MM-yyyy)";
        return acumulador;
    }

}
