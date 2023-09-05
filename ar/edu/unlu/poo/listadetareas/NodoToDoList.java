package ar.edu.unlu.poo.listadetareas;

import java.time.LocalDate;

public class NodoToDoList {
    private String descripcion;
    private EstadoTarea estado;
    private LocalDate fechaLimite = null;
    private LocalDate recordatorio = null;
    private NodoToDoList siguiente = null;
    //Nuevo:
    private String colaborador;
    private LocalDate fechaFinalizacion = null;
    public void setDescripcion(String descripcion){this.descripcion = descripcion;}

    public String getDescripcion(){return descripcion;}

    public void setEstado(EstadoTarea estado){this.estado = estado;}

    public EstadoTarea getEstado(){return estado;}

    public void setFechaLimite(LocalDate fechalimite){this.fechaLimite = fechalimite;}

    public LocalDate getFechaLimite(){return fechaLimite;}

    public void setRecordatorio(LocalDate recordatorio) {
        this.recordatorio = recordatorio;
    }
    public LocalDate getRecordatorio() {
        return recordatorio;
    }

    public void setSiguiente(NodoToDoList siguiente) {
        this.siguiente = siguiente;
    }

    public NodoToDoList getSiguiente() {
        return siguiente;
    }

    public void setColaborador(String colaborador) {
        this.colaborador = colaborador;
    }

    public String getColaborador() {
        return colaborador;
    }

    public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public LocalDate getFechaFinalizacion() {
        return fechaFinalizacion;
    }
}
