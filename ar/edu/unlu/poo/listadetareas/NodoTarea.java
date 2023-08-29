package ar.edu.unlu.poo.listadetareas;
import java.time.LocalDate;

enum EstadoTarea{
    COMPLETA, INCOMPLETA, VENCIDA;
}
public class NodoTarea {
    String descripcion;
    EstadoTarea estado;
    LocalDate fechaLimite = null;
    NodoTarea siguiente = null;
    public void setDescripcion(String descripcion){this.descripcion = descripcion;}

    public String getDescripcion(){return descripcion;}

    public void setEstado(EstadoTarea estado){this.estado = estado;}

    public EstadoTarea getEstado(){return estado;}

    public void setFechaLimite(LocalDate fechalimite){this.fechaLimite = fechalimite;}

    public LocalDate getFechaLimite(){return fechaLimite;}

    public void setSiguiente(NodoTarea siguiente) {
        this.siguiente = siguiente;
    }

    public NodoTarea getSiguiente() {
        return siguiente;
    }


}
