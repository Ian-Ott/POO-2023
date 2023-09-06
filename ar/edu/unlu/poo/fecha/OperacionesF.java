package ar.edu.unlu.poo.fecha;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OperacionesF {
    Fecha elegida = new Fecha();
    public LocalDate fecha_transformada (String fecha, int formato){
        if (formato == 1){
            return LocalDate.parse(fecha,DateTimeFormatter.ofPattern("dd-MM-yyyy") );
        }else if (formato == 2){
            return LocalDate.parse(fecha,DateTimeFormatter.ofPattern("MM-dd-yyyy") );
        }
        return null;
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
