package ar.edu.unlu.poo.listadetareas;
import java.time.LocalDate;

public class NodoTarea {
    String descripcion;
    String estado;

    LocalDate fechaLimite = null;
    NodoTarea siguiente = null;
    public void setDescripcion(String descripcion){this.descripcion = descripcion;}

    public String getDescripcion(){return descripcion;}

    public void setEstado(String estado){this.estado = estado;}

    public String getEstado(){return estado;}

    public void setFechaLimite(LocalDate fechalimite){this.fechaLimite = fechalimite;}

    public LocalDate getFechaLimite(){return fechaLimite;}

    public void setSiguiente(NodoTarea siguiente) {
        this.siguiente = siguiente;
    }

    public NodoTarea getSiguiente() {
        return siguiente;
    }
}
