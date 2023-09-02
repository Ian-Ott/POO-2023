import ar.edu.unlu.poo.cola.Cola;
import ar.edu.unlu.poo.ecuacion.EcuacionSegundoGrado;
import ar.edu.unlu.poo.fecha.OperacionesF;
import ar.edu.unlu.poo.libro.Biblioteca;
import ar.edu.unlu.poo.lista.ListaEnlazada;
import ar.edu.unlu.poo.lista.ListaEnlazadaDoble;

import ar.edu.unlu.poo.listadetareas.EstadoTarea;
import ar.edu.unlu.poo.listadetareas.ListaDeTareas;
import ar.edu.unlu.poo.listadetareas.ListaDeTareasConRecordatorio;
import ar.edu.unlu.poo.password.Contrasenia;
import ar.edu.unlu.poo.pila.Pila;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejemplos_ejercicios {
    public static void main(String[] args){
        menu();
        int opcion = seleccionar_opcion();
        switch (opcion){
            case 1:
                ejemplo_1();
                break;
            case 2:
                ejemplo_2();
                break;
            case 3:
                ejemplo_3();
                break;
            case 4:
                ejemplo_4();
                break;
            case 5:
                ejemplo_5();
                break;
            case 6:
                ejemplo_6();
                break;
            case 7:
                ejemplo_7();
                break;
            case 8:
                ejemplo_8();
                break;
            case 9:
                ejemplo_9();
                break;
            case 10:
                ejemplo_10();
                break;
            case 11:
                //ejemplo_11();
                break;
            case 12:
                //ejemplo_12();
                break;
            case 13:
                //ejemplo_13();
                break;
        }

    }

    private static void menu(){
        System.out.println("POO 2023-Ejemplos de los ejercicios del TP 1: ");
        System.out.println("-Parte uno: Introduccion a la Programacion orientada a objetos y Java:");
        System.out.println("1-Ejercicio 1 - Lista Enlazada");
        System.out.println("2-Ejercicio 2 - Lista Enlazada Doble");
        System.out.println("3-Ejercicio 3 - Pila");
        System.out.println("4-Ejercicio 4 - Cola");
        System.out.println("5-Ejercicio 5 - Lista De Tareas");
        System.out.println("-Parte dos: Ligas, Asociaciones y Relaciones entre Clases:");
        System.out.println("6-Ejercicio 6 - Libro");
        System.out.println("7-Ejercicio 7 - Ecuacion De 2do Grado");
        System.out.println("8-Ejercicio 8 - Contrasenia");
        System.out.println("9-Ejercicio 9 - Fechas");
        System.out.println("10-Ejercicio 10 - Extension Lista De Tareas");
        System.out.println("11-Ejercicio 11 - Juego De Palabras");
        System.out.println("12-Ejercicio 12 - Administrador De Tareas");
        System.out.println("13-Ejercicio 13 - Extension ToDoList");
    }

    private static int seleccionar_opcion() {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        while(opcion <= 0 || opcion > 13){
            System.out.println("Seleccione una opcion:");
            opcion = sc.nextInt();
            if (opcion <= 0 || opcion > 13){
                menu();
                System.out.println("OPCION INCORRECTA: Seleccione un numero entre 1-13");
            }
        }
        return opcion;
    }

    private static void ejemplo_1(){
        System.out.println("Ejemplo de Lista enlazada");

        ListaEnlazada lista = new ListaEnlazada();

        if (lista.es_vacia()){
            System.out.println("La lista esta vacia");
        }

        System.out.println("Agrego elementos a la lista...");
        lista.agregar(123);
        lista.agregar(4);
        lista.agregar("hola");
        lista.agregar("mundo");
        lista.agregar(5);
        lista.agregar(2);

        if (!lista.es_vacia()){
            System.out.println("La lista no esta vacia.\nContenido de la lista: " + lista);
        }else {
            System.out.println("Error al agregar");
        }

        System.out.println("\nLa longitud de la lista es de " + lista.longitud());

        lista.eliminar(3);
        lista.eliminar(6);
        System.out.println("\nEliminados los elementos de la posicion 3 y 6");
        System.out.println("Contenido de la lista: " + lista);
        System.out.println("como la posicion 6 no existe en la lista no se elimina ningun elemento.");

        System.out.println("Recupero elemento de la posicion 2: " + lista.recuperar(2));
        System.out.println("Recupero elemento de la posicion 5: " + lista.recuperar(5));

        System.out.println("inserto elementos en la posicion 1 y 6:");
        lista.insertar(25, 1);
        lista.insertar("dato", 6);
        System.out.println("Contenido de la lista: " + lista);
        System.out.println("Pregunta:¿Cuántos objetos están involucrados?");
        System.out.println("Respuesta: La cantidad de objetos involucrados es 2 los cuales son el nodo al primer dato (aunque pueden haber mas) y la lista en si");
    }

    private static void ejemplo_2(){
        System.out.println("Ejemplo de Lista Enlazada Doble");

        ListaEnlazadaDoble lista = new ListaEnlazadaDoble();

        if (lista.es_vacia()){
            System.out.println("La lista esta vacia");
        }

        System.out.println("Agrego elementos a la lista...");
        lista.agregar(456);
        lista.agregar(7);
        lista.agregar("mensaje");
        lista.agregar("string");
        lista.agregar(8);
        lista.agregar(4);

        if (!lista.es_vacia()){
            System.out.println("La lista no esta vacia.\nContenido de la lista: " + lista);
        }else {
            System.out.println("Error al agregar");
        }

        System.out.println("\nLa longitud de la lista es de " + lista.longitud());

        lista.eliminar(1);
        lista.eliminar(4);
        System.out.println("\nEliminados los elementos de la posicion 1 y 4");
        System.out.println("Contenido de la lista: " + lista);

        System.out.println("Recupero elemento de la posicion 1: " + lista.recuperar(1));
        System.out.println("Recupero elemento de la posicion 7: " + lista.recuperar(7));

        System.out.println("inserto elementos en la posicion 1 y 4:");
        lista.insertar("nuevo elemento", 1);
        lista.insertar("27", 4);
        System.out.println("Contenido de la lista: " + lista);

        System.out.println("Pregunta: ¿La interfaz debe ser la misma?");
        System.out.println("La interfaz no necesariamente debe ser la misma porque se podrian agregar funciones que recorran la lista desde el ultimo elemento pero se puede usar la misma interfaz que la anterior para que funcione la lista de igual manera");
    }

    private static void ejemplo_3(){
        System.out.println("Ejemplo de Pila:");
        System.out.println("La interfaz implementada fue la siguiente: ");

        Pila pila = new Pila();

        if (pila.es_vacia()){
            System.out.println("La pila esta vacia");
        }

        System.out.println("Agrego elementos a la Pila...");
        pila.apilar(10);
        pila.apilar(9);
        pila.apilar("8");
        pila.apilar("7");
        pila.apilar(6);
        pila.apilar(5);

        if (!pila.es_vacia()){
            System.out.println("La Pila no esta vacia.\n ");
            System.out.println(pila_mostrar(pila));
        }else {
            System.out.println("Error al apilar");
        }

        System.out.println("\nLa longitud de la pila es de " + pila.longitud());

        pila.desapilar();
        System.out.println("\nSe desapilo un elemento:");
        System.out.println("Recupero elemento del tope: " + pila.tope());

        System.out.println(" " + pila_mostrar(pila));

        pila.desapilar();
        System.out.println("\nSe desapilo otro elemento: ");
        System.out.println("Recupero elemento del tope: " + pila.tope());

        System.out.println("\n " + pila_mostrar(pila));

        System.out.println("Pregunta: ¿cuantos objetos estan involucrados en la solucion? responsabilidades de cada objeto involucrado.");
        System.out.println("Respuesta: La cantidad de objetos involucrados es 3 los cuales son el nodo al primer dato (aunque pueden haber mas), el tope y la pila.");
        System.out.println("La responsabilidad del primer nodo es la de contener la base de la pila y conectar al resto de nodos. La resposnabilidad del tope es parecida solo que este contiene el dato del tope de la pila por el cual se realizan las operaciones principales. Mientras que la pila en si misma se responsabiliza por realizar las operaciones clave para que funcione la pila como debe");

    }
    public static String pila_mostrar(Pila pila){
        String acumulador = "";
        Object dato_actual;
        Integer i = pila.longitud();
        if (pila.es_vacia()){
            return "<La pila esta vacia>";
        }
        Pila Paux = new Pila();
        System.out.println("Contenido de la pila: ");
        while(!pila.es_vacia()){
            dato_actual = pila.desapilar();
            acumulador += "\n Nodo " + i + ": " + dato_actual;
            Paux.apilar(dato_actual);
            i = i - 1;
        }
        while(!Paux.es_vacia()){
            dato_actual = Paux.desapilar();
            pila.apilar(dato_actual);
        }
        return acumulador;
    }

    private static void ejemplo_4(){
        System.out.println("Ejemplo de Cola:");
        System.out.println("La interfaz implementada fue la siguiente: ");

        Cola cola = new Cola();

        if (cola.es_vacia()){
            System.out.println("La cola esta vacia");
        }

        System.out.println("Agrego elementos a la Cola...");
        cola.encolar(2);
        cola.encolar(4);
        cola.encolar(8);
        cola.encolar("16");
        cola.encolar(32);
        cola.encolar(64);


        if (!cola.es_vacia()){
            System.out.println("La Cola no esta vacia.\n ");
            System.out.println(cola_mostrar(cola));
        }else {
            System.out.println("Error al encolar");
        }

        System.out.println("\nLa longitud de la cola es de " + cola.longitud());

        cola.desencolar();
        System.out.println("\nSe desencolo un elemento:");

        System.out.println(" " + cola_mostrar(cola));

        cola.desencolar();
        System.out.println("\nSe desencolo otro elemento: ");

        System.out.println("\n " + cola_mostrar(cola));

        System.out.println("Pregunta: ¿cuantos objetos estan involucrados en la solucion? responsabilidades de cada objeto involucrado.");
        System.out.println("Respuesta: La cantidad de objetos involucrados es 3 los cuales son el nodo que contiene el frente , el nodo que contiene el final y la cola.");
        System.out.println("La responsabilidad del frente es la de contener al nodo que debe ser desencolado (primer nodo). La resposnabilidad del final es que contiene el ultimo elemento encolado para encolar elementos por este nodo. Mientras que la cola en si misma se responsabiliza por realizar las operaciones clave para que funcione la cola (encolar, desapilar, etc");
    }

    private static String cola_mostrar(Cola cola) {
        String acumulador = "";
        Object dato_actual;
        Integer i = 1;
        if (cola.es_vacia()){
            return "<La cola esta vacia>";
        }
        Cola Caux = new Cola();
        System.out.println("Contenido de la cola: ");
        while(!cola.es_vacia()){
            dato_actual = cola.desencolar();
            acumulador += "\n Nodo " + i + ": " + dato_actual;
            Caux.encolar(dato_actual);
            i = i + 1;
        }
        while(!Caux.es_vacia()){
            dato_actual = Caux.desencolar();
            cola.encolar(dato_actual);
        }
        return acumulador;
    }

    private static void ejemplo_5() {
        System.out.println("Ejemplo de Lista de tareas:");

        ListaDeTareas listaT = new ListaDeTareas();

        if (listaT.es_vacia()) {
            System.out.println("\nLa lista de tareas esta vacia");
        }

        System.out.println("\nAgrego tareas a la lista...");
        listaT.agregar_tarea("completar el ejercicio 5", LocalDate.of(2023, 8, 30), EstadoTarea.INCOMPLETA);
        listaT.agregar_tarea("Ir al supermercado mañana", LocalDate.of(2023, 9, 7), EstadoTarea.INCOMPLETA);
        listaT.agregar_tarea("Consultar repuesto del auto", LocalDate.of(2023, 9, 5), EstadoTarea.COMPLETA);
        listaT.agregar_tarea("Ir al cine a ver la nueva pelicula de marvel", LocalDate.of(2023, 9, 5), EstadoTarea.INCOMPLETA);


        if (!listaT.es_vacia()) {
            System.out.println("La lista de tareas no esta vacia.\nContenido de la lista de tareas(en orden de prioridad): " + listaT);
        } else {
            System.out.println("Error al agregar");
        }

        System.out.println("\nCompruebo cuales tareas estan completas: ");
        for (int i = 1; i <= 4; i++) {
            System.out.print("\n" + i + "-");
            if (listaT.esta_completa(i)) {
                System.out.print("Esta completa");
            } else {
                System.out.print("Esta incompleta");
            }
        }

        System.out.print("\nCompruebo cuales tareas estan vencidas: ");
        for (int i = 1; i <= 4; i++) {
            System.out.print("\n" + i + "-");
            if (listaT.esta_vencida(i)) {
                System.out.print("Esta vencida");
            } else {
                System.out.print("No esta vencida");
            }
        }

        System.out.println("\nLe cambio la descripcion a la primera tarea: ");
        listaT.cambiar_descripcion("Entregar el TP1 de POO", 1);
        System.out.println("contenido de la lista de tareas (en orden de prioridad): " + listaT);

        System.out.println("\nLe cambio la prioridad a la ultima tarea: ");
        listaT.cambiar_prioridad(1, 4);
        System.out.println("contenido de la lista de tareas: " + listaT);
        System.out.println("\n ahora vuelvo las tareas a su prioridad original: ");
        listaT.cambiar_prioridad(4, 1);
        System.out.println("contenido de la lista de tareas: " + listaT);

    }

    private static void ejemplo_6(){
        System.out.println("\nEjemplo de Biblioteca: ");
        Biblioteca biblioteca = new Biblioteca();

        System.out.println("\nagrego libros a la biblioteca... ");
        biblioteca.agregar_libro("La odisea", "Homero", 448, 10);
        biblioteca.agregar_libro("Frankenstein", "Mary Shelley", 304, 1);

        System.out.println("\nContenido de la biblioteca: " + biblioteca);

        System.out.println("\nPido prestado dos libros de la odisea: ");
        biblioteca.prestar_libro("La odisea", "Homero");
        biblioteca.prestar_libro("La odisea", "Homero");

        System.out.println("\nPido prestado un libro de frankestein: ");
        biblioteca.prestar_libro("Frankenstein", "Mary Shelley");

        System.out.println("\nCompruebo los prestamos realizados con el libro la odisea: " + biblioteca.prestamosRealizados("La odisea", "Homero"));

        System.out.println("\nComparo la cantidad de paginas del libro la odisea con el de frankestein: ");
        if (biblioteca.libro1_tieneMasPags("La odisea" , "Homero", "Frankenstein", "Mary Shelley")){
            System.out.println("La odisea tiene mas cantidad de paginas que Frankenstein");
        }else {
            System.out.println("Frankenstein tiene mas cantidad de paginas que frankenstein");
        }
        System.out.println("\nPido prestado un libro mas de la odisea y compruebo la cantidad total de prestamos que realizo la biblioteca: ");
        biblioteca.prestar_libro("La odisea", "Homero");
        System.out.println("\nLa cantidad de prestamos totales que realizo la biblioteca fue de " + biblioteca.total_prestamos());

        System.out.println("\nMuestro como quedo la descripcion de La odisea: ");
        biblioteca.mostrar_descripcion("La odisea", "Homero");

    }

    public static void ejemplo_7(){
        System.out.println("Ejemplos de Ecuaciones: ");
        System.out.println("\nCreo y agrego los valores de la ecuacion... ");
        EcuacionSegundoGrado ecuacion = new EcuacionSegundoGrado();
        int a = 2;
        int b = 4;
        int c = 2;
        ecuacion.Establecer_valores(a,b,c);
        System.out.println("Los valores agregados fueron: a =" + a + " ,b =" + b + " ,c =" + c);

        System.out.println("\n calculo las raices...");
        ArrayList <Integer> raices = ecuacion.calcular_raiz();
        int j = 0;
        for (int i = 0; i < raices.size(); i++){
            j++;
            System.out.println("X" + j + "=" + raices.get(i));
        }

        System.out.println("\n calculo la y...");
        ArrayList<Integer> y = ecuacion.calcular_y(raices);
        j = 0;
        for (int i = 0; i < y.size(); i++){
            j++;
            System.out.println("y" + j + "=" + y.get(i));
        }
        System.out.println("\nCambio los valores de los coeficientes...");
        ecuacion.Establecer_valores(3,6,9);

        System.out.println("\n Pruebo con otros valores (creando una nueva ecuacion)...");
        EcuacionSegundoGrado ecuacion2 = new EcuacionSegundoGrado();
        a = 1;
        b = 2;
        c = -3;
        ecuacion2.Establecer_valores(a,b,c);
        System.out.println("Los valores agregados fueron: a =" + a + " ,b =" + b + " ,c =" + c);

        System.out.println("\n calculo las raices...");
        ArrayList <Integer> raices2 = ecuacion2.calcular_raiz();
        j = 0;
        for (int i = 0; i < raices2.size(); i++){
            j++;
            System.out.println("X" + j + "=" + raices2.get(i));
        }

        System.out.println("\n calculo la y...");
        ArrayList<Integer> y2 = ecuacion2.calcular_y(raices2);
        j = 0;
        for (int i = 0; i < y2.size(); i++){
            j++;
            System.out.println("y" + j + "=" + y2.get(i));
        }
    }

    public static void ejemplo_8(){
        System.out.println("Ejemplos del generador de contrasenias (esta limitado a generar 10 contrasenias pero se le puede cambiar el limite): ");
        System.out.println("\nGenero contrasenias por su longitud por defecto...");
        Contrasenia conjunto1 = new Contrasenia();
        ArrayList<String> contrasenias;
        contrasenias = conjunto1.generar_contrasenias();
        System.out.println("\nContrasenias generadas: ");
        conjunto1.mostrar_contrasenias(contrasenias);

        System.out.println("\nGenero otro conjunto de contrasenias y solicito longitud al usuario: ");
        Contrasenia conjunto2 = new Contrasenia();
        ArrayList <String> contrasenias2;
        conjunto2.cambiar_longitud();
        contrasenias2 = conjunto2.generar_contrasenias();
        System.out.println("\nContrasenias generadas: ");
        conjunto2.mostrar_contrasenias(contrasenias2);


        System.out.println("\nRegenero las contrasenias debiles del nuevo conjunto...");
        conjunto2.regenerarContraseniaDebil(contrasenias2);
        System.out.println("\nContrasenias regeneradas: ");
        conjunto2.mostrar_contrasenias(contrasenias2);
    }
    public static void ejemplo_9(){
        System.out.println("Ejemplos de las operaciones con fechas: ");
        System.out.println("Establezco una fecha como determinada...");
        OperacionesF fecha_determinada = new OperacionesF();
        fecha_determinada.establecer_fecha(LocalDate.parse("2023-08-13"));

        String fecha = fecha_determinada.fecha_transformada(1);
        System.out.println("\n Muestro la fecha transformada a string (formato: dd-MM-yyyy): " + fecha);

        fecha = fecha_determinada.fecha_transformada(2);
        System.out.println("ahora muestro la fecha con otro formato (MM-dd-yyyy): " + fecha);
        System.out.println("\nCompruebo si la fecha es menor a 14-8-2023: ");
        if (fecha_determinada.fecha_menor(LocalDate.parse("2023-08-14"))){
            System.out.println("\nLa "+ fecha_determinada + " es menor");
        }else{
            System.out.println("La fecha no es menor.");
        }


        System.out.println("Compruebo si la fecha es mayor a 30-7-2023: ");
        if (fecha_determinada.fecha_mayor(LocalDate.parse("2023-07-30"))){
            System.out.println("\nLa "+ fecha_determinada + " es mayor");
        }else{
            System.out.println("La fecha no es mayor.");
        }

        System.out.println("\nCompruebo si la fecha esta entre las fechas: 12-8-2023 y 15-9-2023");
        if (fecha_determinada.entre_fechas(LocalDate.parse("2023-08-12"), LocalDate.parse("2023-09-15"))){
            System.out.println("\n La " + fecha_determinada + " esta entre esas dos fechas");
        } else {
            System.out.println("\n La  " + fecha_determinada + " no esta entre esas dos fechas");
        }
    }

    private static void ejemplo_10() {
        System.out.println("Ejemplo de Lista de tareas con recordatorios:");

        ListaDeTareasConRecordatorio listaT_Mod = new ListaDeTareasConRecordatorio();

        if (listaT_Mod.es_vacia()) {
            System.out.println("\nLa lista de tareas esta vacia");
        }

        System.out.println("\nAgrego tareas a la lista...");
        listaT_Mod.agregar_tarea("completar el ejercicio 5", LocalDate.of(2023, 8, 30), EstadoTarea.INCOMPLETA, LocalDate.of(2023, 8, 28));
        listaT_Mod.agregar_tarea("Ir al supermercado mañana", LocalDate.of(2023, 9, 7), EstadoTarea.INCOMPLETA, LocalDate.of(2023, 9,6));
        listaT_Mod.agregar_tarea("Consultar repuesto del auto", LocalDate.of(2023, 9, 5), EstadoTarea.COMPLETA, LocalDate.of(2023, 9, 3));
        listaT_Mod.agregar_tarea("Ir al cine a ver la nueva pelicula de marvel", LocalDate.of(2023, 9, 5), EstadoTarea.INCOMPLETA, LocalDate.of(2023, 9, 4));
        listaT_Mod.agregar_tarea("Estudiar para el parcial de POO", LocalDate.of(2023, 11, 1), EstadoTarea.INCOMPLETA, LocalDate.of(2023, 10, 18));


        if (!listaT_Mod.es_vacia()) {
            System.out.println("La lista de tareas no esta vacia.\nContenido de la lista de tareas(en orden de prioridad): " + listaT_Mod);
        } else {
            System.out.println("Error al agregar");
        }

        System.out.println("\nCompruebo que el resto de funciones siguen andando con las nuevas modificaciones...");
        System.out.println("\nCompruebo cuales tareas estan completas: ");
        for (int i = 1; i <= 4; i++) {
            System.out.print("\n" + i + "-");
            if (listaT_Mod.esta_completa(i)) {
                System.out.print("Esta completa");
            } else {
                System.out.print("Esta incompleta");
            }
        }

        System.out.print("\nCompruebo cuales tareas estan vencidas: ");
        for (int i = 1; i <= 4; i++) {
            System.out.print("\n" + i + "-");
            if (listaT_Mod.esta_vencida(i)) {
                System.out.print("Esta vencida");
            } else {
                System.out.print("No esta vencida");
            }
        }

        System.out.println("\nLe cambio la descripcion a la primera tarea: ");
        listaT_Mod.cambiar_descripcion("Entregar el TP de POO", 1);
        System.out.println("contenido de la lista de tareas (en orden de prioridad): " + listaT_Mod);

        System.out.println("\nLe cambio la prioridad a la ultima tarea: ");
        listaT_Mod.cambiar_prioridad(1, 4);
        System.out.println("contenido de la lista de tareas: " + listaT_Mod);
        System.out.println("\n ahora vuelvo las tareas a su prioridad original: ");
        listaT_Mod.cambiar_prioridad(4, 1);
        System.out.println("contenido de la lista de tareas: " + listaT_Mod);

    }
}