package ar.edu.unlu.poo.listadetareas;

import java.time.LocalDate;

public class NodoTareaConRecordatorio {
    private String descripcion;
    private EstadoTarea estado;
    private LocalDate fechaLimite = null;
    private LocalDate recordatorio = null;
    private NodoTareaConRecordatorio siguiente = null;
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

    public void setSiguiente(NodoTareaConRecordatorio siguiente) {
        this.siguiente = siguiente;
    }

    public NodoTareaConRecordatorio getSiguiente() {
        return siguiente;
    }

}
