package ar.edu.unlu.poo.listadetareas;

import ar.edu.unlu.poo.lista.Nodo;

import java.time.LocalDate;

public class ListaDeTareasConRecordatorio {
    NodoTareaConRecordatorio prioridad = null;
    //la tarea con mas prioridad es el primer elemento de la lista
    // y mientras mas se recorra la lista menos prioridad tiene esa tarea

    public boolean es_vacia(){
        return prioridad == null;
    }
    public void agregar_tarea(String descripcion, LocalDate fecha, EstadoTarea estado, LocalDate recordatorio){
        NodoTareaConRecordatorio nuevo_nodo = new NodoTareaConRecordatorio();
        nuevo_nodo.setDescripcion(descripcion);
        nuevo_nodo.setFechaLimite(fecha);
        nuevo_nodo.setRecordatorio(recordatorio);
        if (estado == EstadoTarea.INCOMPLETA && fecha.isBefore(LocalDate.now())){
            estado = EstadoTarea.VENCIDA;
        }
        nuevo_nodo.setEstado(estado);
        if (prioridad == null){
            prioridad = nuevo_nodo;
        }else {
            NodoTareaConRecordatorio nodoAUX = prioridad;
            while(nodoAUX.getSiguiente() != null){
                nodoAUX = nodoAUX.getSiguiente();
            }
            nodoAUX.setSiguiente(nuevo_nodo);
        }
        if (nuevo_nodo.getRecordatorio().isAfter(LocalDate.now()) || nuevo_nodo.getRecordatorio().isEqual(LocalDate.now())){
            if (nuevo_nodo.getEstado() == EstadoTarea.INCOMPLETA){
            cambiar_prioridad(1, longitud());
            }
        }
    }

    public void cambiar_descripcion(String descripcion, int pos){
        NodoTareaConRecordatorio nodoAux = prioridad;
        int i = 1;
        if (pos == 1){
            nodoAux.setDescripcion(descripcion);
        } else{
            while(pos != i){
                nodoAux = nodoAux.getSiguiente();
                i++;
            }
            nodoAux.setDescripcion(descripcion);
        }
    }

    /*public void cambiar_estado(String estado, int pos){
        NodoTarea nodoAux = prioridad;
        int i = 1;
        if (pos == 1){
            nodoAux.setEstado(estado);
        } else{
            while(pos != i){
                nodoAux = nodoAux.getSiguiente();
                i++;
            }
            nodoAux.setEstado(estado);
        }
    } capaz sirve para el punto 12*/

    public void cambiar_prioridad(int pos_prioridad, int pos){
        NodoTareaConRecordatorio nodoAux = prioridad;
        NodoTareaConRecordatorio nueva_prioridad = prioridad;
        if(pos == 1){
            prioridad = nueva_prioridad.getSiguiente();
            for (int i = 0; i < pos_prioridad - 1;i++){
                nodoAux = nodoAux.getSiguiente();
            }
            nueva_prioridad.setSiguiente(nodoAux.getSiguiente());
            nodoAux.setSiguiente(nueva_prioridad);
        } else{
            for (int i = 0; i < pos - 2; i++){
                nodoAux = nodoAux.getSiguiente();
            }
            nueva_prioridad = nodoAux.getSiguiente();
            //tengo la tarea a la que se quiere cambiar su prioridad
            nodoAux.setSiguiente(nueva_prioridad.getSiguiente());
            //ahora busco la nueva posicion de la tarea que se le queria cambiar la posicion
            nodoAux = prioridad;
            if(pos_prioridad == 1){
                nueva_prioridad.setSiguiente(nodoAux);
                prioridad = nueva_prioridad;
            }else{
                for (int i = 0; i < pos_prioridad - 2;i++){
                    nodoAux = nodoAux.getSiguiente();
                }
                nueva_prioridad.setSiguiente(nodoAux.getSiguiente());
                nodoAux.setSiguiente(nueva_prioridad);
            }
        }
    }

    public boolean esta_vencida(int pos){
        NodoTareaConRecordatorio nodoAux = prioridad;
        int i = 1;
        if (pos == 1){
            return nodoAux.getEstado().equals(EstadoTarea.VENCIDA);
        } else{
            while(pos != i){
                nodoAux = nodoAux.getSiguiente();
                i++;
            }
            return nodoAux.getEstado().equals(EstadoTarea.VENCIDA);
        }
    }

    public boolean esta_completa (int pos){
        NodoTareaConRecordatorio nodoAux = prioridad;
        int i = 1;
        if(pos == 1){
            return nodoAux.getEstado().equals(EstadoTarea.COMPLETA);
        } else{
            while(pos != i){
                nodoAux = nodoAux.getSiguiente();
                i++;
            }
            return nodoAux.getEstado().equals(EstadoTarea.COMPLETA);
        }
    }
    public int longitud(){
        int longitud = 0;
        NodoTareaConRecordatorio nodoAux = prioridad;
        while(nodoAux != null){
            longitud++;
            nodoAux = nodoAux.getSiguiente();
        }
        return longitud;
    }
    public String toString() {
        String acumulador = "";
        Integer i = 1;
        NodoTareaConRecordatorio nodoAux = prioridad;
        if (prioridad == null) {
            acumulador = "No hay tareas";
        } else {
            while (nodoAux != null) {
                if (nodoAux.getEstado().equals(EstadoTarea.VENCIDA)){
                    acumulador += "\n " + i + "- (vencida)" + nodoAux.getDescripcion() + " | Fecha limite: " + nodoAux.getFechaLimite() + " | Fecha recordatorio: " + nodoAux.getRecordatorio();
                } else if ( nodoAux.getEstado().equals(EstadoTarea.COMPLETA)) {
                    acumulador += "\n " + i + "- (completa)" + nodoAux.getDescripcion()+ " | Fecha limite: " + nodoAux.getFechaLimite() + " | Fecha recordatorio: " + nodoAux.getRecordatorio();
                }
                else if (nodoAux.getRecordatorio().isAfter(LocalDate.now()) || nodoAux.getRecordatorio().isEqual(LocalDate.now())){
                    acumulador += "\n " + i + "- (por vencer)" + nodoAux.getDescripcion()+ " | Fecha limite: " + nodoAux.getFechaLimite() + " | Fecha recordatorio: " + nodoAux.getRecordatorio();
                }
                else {
                    acumulador += "\n " + i + "-" + nodoAux.getDescripcion()+ " | Fecha limite: " + nodoAux.getFechaLimite() + " | Fecha recordatorio: " + nodoAux.getRecordatorio();
                }
                i++;
                nodoAux = nodoAux.getSiguiente();
            }
        }
        return acumulador;
    }
}
