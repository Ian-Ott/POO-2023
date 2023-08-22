package ar.edu.unlu.poo.lista;

public class ListaEnlazadaDoble {
    private NodoEDoble primero = null;

    public void agregar(Object dato){
        NodoEDoble nuevoNodo = new NodoEDoble();
        nuevoNodo.setDato(dato);
        if (primero == null){
            primero = nuevoNodo;
        }else{
            NodoEDoble nodoAux = primero;
            while(nodoAux.getSiguiente() != null){
                nodoAux = nodoAux.getSiguiente();
            }
            nuevoNodo.setAnterior(nodoAux);
            nodoAux.setSiguiente(nuevoNodo);
        }
    }

    public String toString(){
        String acumulador = "";
        Integer i = 1;
        NodoEDoble nodoAux = primero;
        if(primero == null){
            acumulador = "lista vacia";
        }else {
            while (nodoAux != null){
                acumulador += "\n Nodo" + i + " " + nodoAux.getDato();
                i++;
                nodoAux = nodoAux.getSiguiente();
            }

        }
        return acumulador;
    }

    public boolean es_vacia(){return (primero == null);}

    public int longitud(){
        int longitud = 0;
        NodoEDoble nodoAux = primero;
        if (primero != null){
            longitud++;
        }
        while(nodoAux != null){
            longitud++;
            nodoAux = nodoAux.getSiguiente();
        }
        return longitud;
    }

    public void  eliminar(int pos){
        NodoEDoble nodoAux = primero;
        if (pos == 1){
            nodoAux.setDato(nodoAux.getSiguiente());
            nodoAux.setAnterior(null);
        }else {
            for (int i = 0; i < pos - 2; i++){
                nodoAux = nodoAux.getSiguiente();
            }
            NodoEDoble nodoTemp = nodoAux.getSiguiente();
            nodoAux.setSiguiente(nodoTemp.getSiguiente());
            nodoAux = nodoAux.getSiguiente();
            nodoAux.setAnterior(nodoTemp.getAnterior());
        }
    }
    public Object recuperar(int pos){
        NodoEDoble nodoAux = primero;
        for (int i = 0; i < pos - 1; i++){
            nodoAux = nodoAux.getSiguiente();
        }
        return nodoAux.getDato();
    }
    public void insertar(Object dato, int pos){
        NodoEDoble nodoAux = primero;
        NodoEDoble nuevo_nodo = new NodoEDoble();
        nuevo_nodo.setDato(dato);
        if (pos == 1){
            nuevo_nodo.setSiguiente(primero);
            nuevo_nodo.setAnterior(null);
            primero = nuevo_nodo;
        }else{
            for (int i = 0; i < pos - 2; i++){
                nodoAux = nodoAux.getSiguiente();
            }
            nuevo_nodo.setAnterior(nodoAux);
            nuevo_nodo.setSiguiente(nodoAux.getSiguiente());
            nodoAux.setSiguiente(nuevo_nodo);
        }
    }
}
