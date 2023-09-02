package ar.edu.unlu.poo.fecha;

import java.time.LocalDate;

public class Fecha {
    private LocalDate fecha_det = null;

    public void setFecha_det(LocalDate fecha_det) {
        this.fecha_det = fecha_det;
    }

    public LocalDate getFecha_det() {
        return fecha_det;
    }
}
