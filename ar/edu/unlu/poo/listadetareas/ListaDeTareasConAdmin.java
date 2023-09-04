package ar.edu.unlu.poo.listadetareas;

import java.time.LocalDate;

public class ListaDeTareasConAdmin {
    //AVISO: Esta tarea reutilizara el NodoTareaConRecordatorio
    // ya que no son necesarias modificaciones en el nodo
    NodoTareaConRecordatorio prioridad = null;
    //la tarea con mas prioridad es el primer elemento de la lista
    // y mientras mas se recorra la lista menos prioridad tiene esa tarea

    public boolean es_vacia(){
        return prioridad == null;
    }

    //Esta funcion pide el ejercicio 12 pero ya esta creada desde el ejercicio 5 para probar las anteriores listas de tareas
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

    public void tarea_realizada(int pos){
        NodoTareaConRecordatorio nodoAux = prioridad;
        int i = 1;
        if (pos == 1){
            nodoAux.setEstado(EstadoTarea.COMPLETA);
        } else{
            while(pos != i){
                nodoAux = nodoAux.getSiguiente();
                i++;
            }
            nodoAux.setEstado(EstadoTarea.COMPLETA);
        }
    }

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
                    acumulador += "\n " + i + "- (vencida)" + nodoAux.getDescripcion() + " | Fecha de vencimiento: " + nodoAux.getFechaLimite() + " | Fecha de recordatorio: " + nodoAux.getRecordatorio();
                } else if ( nodoAux.getEstado().equals(EstadoTarea.COMPLETA)) {
                    acumulador += "\n " + i + "- (completa)" + nodoAux.getDescripcion()+ " | Fecha de vencimiento: " + nodoAux.getFechaLimite() + " | Fecha de recordatorio: " + nodoAux.getRecordatorio();
                }
                else if (nodoAux.getRecordatorio().isAfter(LocalDate.now()) || nodoAux.getRecordatorio().isEqual(LocalDate.now())){
                    acumulador += "\n " + i + "- (por vencer)" + nodoAux.getDescripcion()+ " | Fecha de vencimiento: " + nodoAux.getFechaLimite() + " | Fecha de recordatorio: " + nodoAux.getRecordatorio();
                }
                else {
                    acumulador += "\n " + i + "-" + nodoAux.getDescripcion()+ " | Fecha de vencimiento: " + nodoAux.getFechaLimite() + " | Fecha de recordatorio: " + nodoAux.getRecordatorio();
                }
                i++;
                nodoAux = nodoAux.getSiguiente();
            }
        }
        return acumulador;
    }

    public ListaDeTareasConAdmin lista_ordenadaNoVencidas(){
        ListaDeTareasConAdmin lista_ordenada = new ListaDeTareasConAdmin();
        if (prioridad == null){
            return null;
        }else {
            NodoTareaConRecordatorio nodoAUX = prioridad;
            while(nodoAUX.getSiguiente() != null){
                if (nodoAUX.getFechaLimite().isAfter(LocalDate.now())){
                    lista_ordenada.agregar_noVencidas(nodoAUX);
                }
                nodoAUX = nodoAUX.getSiguiente();
            }
        }
        return lista_ordenada;
    }

    private void agregar_noVencidas(NodoTareaConRecordatorio nodoAux){
        //deja el mismo orden de prioridad que tenia la lista anterior
        NodoTareaConRecordatorio nuevo_nodo = new NodoTareaConRecordatorio();
        nuevo_nodo.setDescripcion(nodoAux.getDescripcion());
        nuevo_nodo.setRecordatorio(nodoAux.getRecordatorio());
        nuevo_nodo.setEstado(nodoAux.getEstado());
        nuevo_nodo.setFechaLimite(nodoAux.getFechaLimite());
        if (prioridad == null){
            prioridad = nuevo_nodo;
        }else {
            NodoTareaConRecordatorio nodoAUX = prioridad;
            while(nodoAUX.getSiguiente() != null){
                nodoAUX = nodoAUX.getSiguiente();
            }
            nodoAUX.setSiguiente(nuevo_nodo);
        }
    }
    public void buscar_porDescripcion(String descripcion){
        NodoTareaConRecordatorio nodoAux = prioridad;
        int i = 1;
        if (prioridad == null){
            System.out.println("<No hay tareas>");
        }
        while(nodoAux != null){
            if (nodoAux.getDescripcion().equals(descripcion)){
                if (nodoAux.getEstado().equals(EstadoTarea.VENCIDA)){
                    System.out.println("\n " + i + "- (vencida)" + nodoAux.getDescripcion() + " | Fecha de vencimiento: " + nodoAux.getFechaLimite() + " | Fecha de recordatorio: " + nodoAux.getRecordatorio());
                } else if ( nodoAux.getEstado().equals(EstadoTarea.COMPLETA)) {
                    System.out.println("\n " + i + "- (completa)" + nodoAux.getDescripcion() + " | Fecha de vencimiento: " + nodoAux.getFechaLimite() + " | Fecha de recordatorio: " + nodoAux.getRecordatorio());
                }
                else if (nodoAux.getRecordatorio().isAfter(LocalDate.now()) || nodoAux.getRecordatorio().isEqual(LocalDate.now())){
                    System.out.println("\n " + i + "- (por vencer)" + nodoAux.getDescripcion() + " | Fecha de vencimiento: " + nodoAux.getFechaLimite() + " | Fecha de recordatorio: " + nodoAux.getRecordatorio());
                }
                else {
                    System.out.println("\n " + i + "-" + nodoAux.getDescripcion() + " | Fecha de vencimiento: " + nodoAux.getFechaLimite()+ " | Fecha de recordatorio: " + nodoAux.getRecordatorio());
                }
                return;
            }
            i++;
            nodoAux = nodoAux.getSiguiente();
        }
    }

    //hacerlo parecido al agregar solo que compare si la fecha es mayor o menor
    public ListaDeTareasConAdmin lista_ordenada_porFecha(){
        ListaDeTareasConAdmin lista_ordenada = new ListaDeTareasConAdmin();
        if (prioridad == null){
            return null;
        }else {
            NodoTareaConRecordatorio nodoAUX = prioridad;
            while(nodoAUX.getSiguiente() != null){
                if (nodoAUX.getFechaLimite().isAfter(LocalDate.now())){
                    lista_ordenada.agregar_ordenFecha(nodoAUX);
                }
                nodoAUX = nodoAUX.getSiguiente();
            }
        }
        return lista_ordenada;
    }

    private void agregar_ordenFecha(NodoTareaConRecordatorio nodoAux){
        NodoTareaConRecordatorio nuevo_nodo = new NodoTareaConRecordatorio();
        nuevo_nodo.setDescripcion(nodoAux.getDescripcion());
        nuevo_nodo.setRecordatorio(nodoAux.getRecordatorio());
        nuevo_nodo.setEstado(nodoAux.getEstado());
        nuevo_nodo.setFechaLimite(nodoAux.getFechaLimite());
        if (prioridad == null){
            prioridad = nuevo_nodo;
        }else {
            NodoTareaConRecordatorio nodoAUX = prioridad;
            if(nuevo_nodo.getFechaLimite().isBefore(nodoAUX.getFechaLimite())){
                nuevo_nodo.setSiguiente(nodoAUX);
                prioridad = nuevo_nodo;
            }else{
            while(nodoAUX.getSiguiente() != null){
                if (nuevo_nodo.getFechaLimite().isBefore(nodoAUX.getSiguiente().getFechaLimite())){
                    nuevo_nodo.setSiguiente(nodoAUX.getSiguiente());
                    nodoAUX.setSiguiente(nuevo_nodo);
                    return;
                }
                nodoAUX = nodoAUX.getSiguiente();
            }
            nodoAUX.setSiguiente(nuevo_nodo);
            }
        }
    }
}
