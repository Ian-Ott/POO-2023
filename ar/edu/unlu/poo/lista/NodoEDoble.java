package ar.edu.unlu.poo.lista;

public class NodoEDoble {
    private Object dato;
    private NodoEDoble anterior = null;
    private NodoEDoble siguiente = null;

    public void setDato(Object dato){this.dato = dato;}

    public Object getDato(){return dato;}

    public void setAnterior(NodoEDoble nodo){this.anterior = nodo;}

    public NodoEDoble getAnterior(){return anterior;}

    public void setSiguiente(NodoEDoble nodo){this.siguiente = nodo;}

    public NodoEDoble getSiguiente(){return siguiente;}
}
