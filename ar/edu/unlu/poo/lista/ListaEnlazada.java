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

    /*public String toString() {
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
    public boolean es_vacia(){
        return (primero == null);
    }
*/
    public int longitud(){
        int longitud = 0;
        Nodo nodoAux = primero;
        if (primero != null){
            longitud++;
        }
        while(nodoAux != null){
            longitud++;
            nodoAux = nodoAux.getSiguiente();
        }
        return longitud;
    }

    public void eliminar(int pos){

        Nodo nodoAux = primero;
        if(pos == 1) {
            nodoAux.setDato(nodoAux.getSiguiente());
        }else{
            for (int i = 0; i < pos - 2; i++){
                nodoAux = nodoAux.getSiguiente();
            }
            Nodo nodoTemp = nodoAux.getSiguiente();
            nodoAux.setSiguiente(nodoTemp.getSiguiente());
        }
    }

    public Object recuperar(int pos){
        Nodo nodoAux = primero;
        for (int i = 0; i < pos - 1; i++){
            nodoAux = nodoAux.getSiguiente();
        }
        return nodoAux.getDato();
    }

    public void insertar(Object dato, int pos){
        Nodo nodoAux = primero;
        Nodo nuevo_nodo = new Nodo();
        nuevo_nodo.setDato(dato);
        if (pos == 1){
            nuevo_nodo.setSiguiente(primero);
            primero = nuevo_nodo;
        }else{
        for (int i = 0; i < pos - 2; i++){
            nodoAux = nodoAux.getSiguiente();
        }
        nuevo_nodo.setSiguiente(nodoAux.getSiguiente());
        nodoAux.setSiguiente(nuevo_nodo);
        }
    }
}