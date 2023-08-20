package ar.edu.unlu.poo.lista;

public class ListaEnlazada {
    private Nodo primero = null;

    public void agregar(Object dato) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setDato(dato);
        if (primero == null) {
            primero = nuevoNodo;
        } else {
            Nodo nodoAux = primero;
            while (nodoAux.getSiguiente() != null) {
                nodoAux = nodoAux.getSiguiente();
            }
            nodoAux.setSiguiente(nuevoNodo);
        }

    }

    public String toString() {
        String acumulador = "";
        Integer i = 1;
        Nodo nodoAux = primero;
        if (primero == null) {
            acumulador = "lista vacia";
        } else {
            while (nodoAux != null) {
                acumulador += "\nNodo " + i + " " + nodoAux.getDato();
                i++;
                nodoAux = nodoAux.getSiguiente();
            }

        }
        return acumulador;
    }
}