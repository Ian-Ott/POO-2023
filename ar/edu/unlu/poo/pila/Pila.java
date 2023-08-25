package ar.edu.unlu.poo.pila;

public class Pila {
    private Nodo tope = null;

    public void apilar(Object dato){
        Nodo nuevo_nodo = new Nodo();
        nuevo_nodo.setDato(dato);
        nuevo_nodo.setSiguiente(tope);
        tope = nuevo_nodo;
    }

    public Object desapilar(){
        if(es_vacia()){return null;}
        Nodo tope_Aux = tope;
        Object dato = tope_Aux.getDato();
        tope = tope.getSiguiente();
        return dato;
    }

    //funciona igual que desapilar solo que devuelve el tope actual sin desapilarlo de la pila
    public Object tope(){
        Nodo tope_Aux = tope;
        return tope_Aux.getDato();
    }

    public Boolean es_vacia(){
        return tope.getDato() == null;
    }

    public int longitud(){
        int l = 0;
        Nodo nodoAux = tope;
        while(nodoAux != null){
            l++;
            nodoAux = nodoAux.getSiguiente();
        }
        return l;
    }
}
