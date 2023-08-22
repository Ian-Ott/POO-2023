package ar.edu.unlu.poo.pila;

public class Pila {
    private Nodo tope = null;

    public void apilar(Pila pila,Object dato){
        Nodo nuevo_nodo = new Nodo();
        nuevo_nodo.setDato(dato);
        nuevo_nodo.setSiguiente(tope);
        tope = nuevo_nodo;
    }

    public Object desapilar(Pila pila){
        Nodo tope_Aux = tope; //tal vez se puede dejar el codigo sin usar auxiliar
        Object dato = tope_Aux.getDato();
        tope = tope.getSiguiente();
        return dato;
    }

    //funciona igual que desapilar solo que devuelve el tope actual sin desapilarlo de la pila
    public Object tope(){
        Nodo tope_Aux = tope;
        return tope_Aux.getDato();
    }

    public Boolean es_vacia(Pila pila){
        return tope.getDato() == null;
    }

    public int longitud(Pila pila){
        int l = 0;
        Object X;
        Pila Paux = new Pila();
        while(!es_vacia(pila)){
            X = desapilar(pila);
            apilar(Paux, X);
            l++;
        }
        while(!es_vacia(Paux)){
            X = desapilar(Paux);
            apilar(pila, X);
        }
        return l;
    }

    public String toString(){
        return null;
    }
}
