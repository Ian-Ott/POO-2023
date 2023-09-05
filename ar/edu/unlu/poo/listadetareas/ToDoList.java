package ar.edu.unlu.poo.listadetareas;

import java.time.LocalDate;

public class ToDoList {
    NodoToDoList prioridad = null;
    //la tarea con mas prioridad es el primer elemento de la lista
    // y mientras mas se recorra la lista menos prioridad tiene esa tarea
    public boolean es_vacia(){
        return prioridad == null;
    }

    public void agregar_tarea(String descripcion, LocalDate fecha, EstadoTarea estado, LocalDate recordatorio, String colaborador){
        NodoToDoList nuevo_nodo = new NodoToDoList();
        nuevo_nodo.setDescripcion(descripcion);
        nuevo_nodo.setFechaLimite(fecha);
        nuevo_nodo.setRecordatorio(recordatorio);
        if (estado != EstadoTarea.COMPLETA){
            nuevo_nodo.setColaborador("");
        }else {
            nuevo_nodo.setColaborador(colaborador);
            nuevo_nodo.setFechaFinalizacion(LocalDate.now());
        }
        if (estado == EstadoTarea.INCOMPLETA && fecha.isBefore(LocalDate.now())){
            estado = EstadoTarea.VENCIDA;
        }
        nuevo_nodo.setEstado(estado);
        if (prioridad == null){
            prioridad = nuevo_nodo;
        }else {
            NodoToDoList nodoAUX = prioridad;
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
        NodoToDoList nodoAux = prioridad;
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

    //ANTIGUO COMPLETAR TAREAS LO DEJO COMENTADO
    /*public void tarea_realizada(int pos){
        NodoToDoList nodoAux = prioridad;
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
    }*/


    public void cambiar_prioridad(int pos_prioridad, int pos){
        NodoToDoList nodoAux = prioridad;
        NodoToDoList nueva_prioridad = prioridad;
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
        NodoToDoList nodoAux = prioridad;
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
        NodoToDoList nodoAux = prioridad;
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
        NodoToDoList nodoAux = prioridad;
        while(nodoAux != null){
            longitud++;
            nodoAux = nodoAux.getSiguiente();
        }
        return longitud;
    }
    public String toString() {
        String acumulador = "";
        Integer i = 1;
        NodoToDoList nodoAux = prioridad;
        if (prioridad == null) {
            acumulador = "No hay tareas";
        } else {
            while (nodoAux != null) {
                if (nodoAux.getEstado().equals(EstadoTarea.VENCIDA)){
                    acumulador += "\n " + i + "- (vencida)" + nodoAux.getDescripcion() + " | Fecha de vencimiento: " + nodoAux.getFechaLimite() + " | Fecha de recordatorio: " + nodoAux.getRecordatorio();
                } else if ( nodoAux.getEstado().equals(EstadoTarea.COMPLETA)) {
                    acumulador += "\n " + i + "- (completa)" + nodoAux.getDescripcion()+ " | Fecha de vencimiento: " + nodoAux.getFechaLimite() + " | Fecha de recordatorio: " + nodoAux.getRecordatorio() + "\n || Fecha de finalizacion: " + nodoAux.getFechaFinalizacion() + " | Colaborador: " + nodoAux.getColaborador() + "||";
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

    public ToDoList lista_ordenadaNoVencidas(){
        ToDoList lista_ordenada = new ToDoList();
        if (prioridad == null){
            return null;
        }else {
            NodoToDoList nodoAUX = prioridad;
            while(nodoAUX.getSiguiente() != null){
                if (nodoAUX.getFechaLimite().isAfter(LocalDate.now())){
                    lista_ordenada.agregar_noVencidas(nodoAUX);
                }
                nodoAUX = nodoAUX.getSiguiente();
            }
        }
        return lista_ordenada;
    }

    private void agregar_noVencidas(NodoToDoList nodoAux){
        //deja el mismo orden de prioridad que tenia la lista anterior
        NodoToDoList nuevo_nodo = new NodoToDoList();
        nuevo_nodo.setDescripcion(nodoAux.getDescripcion());
        nuevo_nodo.setRecordatorio(nodoAux.getRecordatorio());
        nuevo_nodo.setEstado(nodoAux.getEstado());
        nuevo_nodo.setFechaLimite(nodoAux.getFechaLimite());
        if (prioridad == null){
            prioridad = nuevo_nodo;
        }else {
            NodoToDoList nodoAUX = prioridad;
            while(nodoAUX.getSiguiente() != null){
                nodoAUX = nodoAUX.getSiguiente();
            }
            nodoAUX.setSiguiente(nuevo_nodo);
        }
    }
    public void buscar_porDescripcion(String descripcion){
        NodoToDoList nodoAux = prioridad;
        int i = 1;
        if (prioridad == null){
            System.out.println("<No hay tareas>");
        }
        while(nodoAux != null){
            if (nodoAux.getDescripcion().equals(descripcion)){
                if (nodoAux.getEstado().equals(EstadoTarea.VENCIDA)){
                    System.out.println("\n " + i + "- (vencida)" + nodoAux.getDescripcion() + " | Fecha de vencimiento: " + nodoAux.getFechaLimite() + " | Fecha de recordatorio: " + nodoAux.getRecordatorio());
                } else if ( nodoAux.getEstado().equals(EstadoTarea.COMPLETA)) {
                    System.out.println("\n " + i + "- (completa)" + nodoAux.getDescripcion() + " | Fecha de vencimiento: " + nodoAux.getFechaLimite() + " | Fecha de recordatorio: " + nodoAux.getRecordatorio() + "\n || Fecha de finalizacion: " + nodoAux.getFechaFinalizacion() + " | Colaborador: " + nodoAux.getColaborador() + "||");
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
    public ToDoList lista_ordenada_porFecha(){
        ToDoList lista_ordenada = new ToDoList();
        if (prioridad == null){
            return null;
        }else {
            NodoToDoList nodoAUX = prioridad;
            while(nodoAUX.getSiguiente() != null){
                if (nodoAUX.getFechaLimite().isAfter(LocalDate.now())){
                    lista_ordenada.agregar_ordenFecha(nodoAUX);
                }
                nodoAUX = nodoAUX.getSiguiente();
            }
        }
        return lista_ordenada;
    }

    private void agregar_ordenFecha(NodoToDoList nodoAux){
        NodoToDoList nuevo_nodo = new NodoToDoList();
        nuevo_nodo.setDescripcion(nodoAux.getDescripcion());
        nuevo_nodo.setRecordatorio(nodoAux.getRecordatorio());
        nuevo_nodo.setEstado(nodoAux.getEstado());
        nuevo_nodo.setFechaLimite(nodoAux.getFechaLimite());
        if (prioridad == null){
            prioridad = nuevo_nodo;
        }else {
            NodoToDoList nodoAUX = prioridad;
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

    //CAMBIOS EN ESTE:
    public void tarea_realizada_MOD(int pos, String colaborador){
        NodoToDoList nodoAux = prioridad;
        int i = 1;
        if (pos == 1){
            if (nodoAux.getEstado() != EstadoTarea.COMPLETA){
            nodoAux.setEstado(EstadoTarea.COMPLETA);
            nodoAux.setColaborador(colaborador);
            nodoAux.setFechaFinalizacion(LocalDate.now());
            }else {
                System.out.println("<Tarea ya realizada anterioremente>");
            }
        } else{
            while(pos != i){
                nodoAux = nodoAux.getSiguiente();
                i++;
            }
            if (nodoAux.getEstado() != EstadoTarea.COMPLETA){
            nodoAux.setEstado(EstadoTarea.COMPLETA);
            nodoAux.setColaborador(colaborador);
            nodoAux.setFechaFinalizacion(LocalDate.now());
            }else {
                System.out.println("<Tarea ya realizada anterioremente>");
            }
        }
    }
    //NUEVAS FUNCIONES:
    public void mostrar_realizadasPorColaborador(String colaborador){
        NodoToDoList nodoAux = prioridad;
        int i = 1;
        if (prioridad == null){
            System.out.println("<No hay tareas realizadas por el colaborador>");
        }
        while(nodoAux != null){
            if (nodoAux.getColaborador().equals(colaborador) && nodoAux.getEstado().equals(EstadoTarea.COMPLETA)){
                    System.out.println("\n " + i + "- (completa)" + nodoAux.getDescripcion() + " | Fecha de vencimiento: " + nodoAux.getFechaLimite() + " | Fecha de recordatorio: " + nodoAux.getRecordatorio() + "\n || Fecha de finalizacion: " + nodoAux.getFechaFinalizacion() + " | Colaborador: " + nodoAux.getColaborador() + "||");
            }
            i++;
            nodoAux = nodoAux.getSiguiente();
        }
    }
}
