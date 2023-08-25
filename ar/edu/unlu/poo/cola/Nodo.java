package ar.edu.unlu.poo.cola;

public class Nodo {
    private Object dato;
    private Nodo siguiente = null;

    public void setDato(Object dato){
        this.dato = dato;
    }

    public Object getDato(){
        return dato;
    }

    public void setSiguiente(Nodo nodo){
        this.siguiente = nodo;
    }
    public Nodo getSiguiente(){
        return siguiente;
    }
}
