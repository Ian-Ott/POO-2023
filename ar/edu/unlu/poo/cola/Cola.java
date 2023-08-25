package ar.edu.unlu.poo.cola;

public class Cola {
    private Nodo frente = null;
    private Nodo finalCola = null;

    public boolean es_vacia(){
        return frente == null;
    }
    public void encolar(Object dato){
        Nodo nodoAux = new Nodo();
        nodoAux = frente;
        nodoAux.setDato(dato);
        if (es_vacia()){
            frente = nodoAux;
        }else {
            finalCola.setSiguiente(nodoAux);
        }
        finalCola = nodoAux;
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
