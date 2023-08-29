package ar.edu.unlu.poo.cola;

public class Cola {
    private Nodo frente = null;
    private Nodo finalCola = null;

    public boolean es_vacia(){
        return frente == null;
    }
    public void encolar(Object dato){
        Nodo nuevo_nodo = new Nodo();
        nuevo_nodo.setDato(dato);
        if (es_vacia()){
            frente = nuevo_nodo;
        }else {
            finalCola.setSiguiente(nuevo_nodo);
        }
        finalCola = nuevo_nodo;
    }

    public Object desencolar(){
        if (es_vacia()){return null;}
        Nodo nodoAux = frente;
        Object dato = nodoAux.getDato();
        frente = nodoAux.getSiguiente();
        return dato;
    }

    public int longitud(){
        int l = 0;
        Nodo nodoAux = frente;
        while(nodoAux != null){
            l++;
            nodoAux = nodoAux.getSiguiente();
        }
        return l;
    }
}
