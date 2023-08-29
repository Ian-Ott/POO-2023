import ar.edu.unlu.poo.cola.Cola;
import ar.edu.unlu.poo.lista.ListaEnlazada;
import ar.edu.unlu.poo.lista.ListaEnlazadaDoble;

import ar.edu.unlu.poo.pila.Pila;

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
                //ejemplo_6();
                break;
            case 7:
                //ejemplo_7();
                break;
            case 8:
                //ejemplo_8();
                break;
            case 9:
                //ejemplo_9();
                break;
            case 10:
                //ejemplo_10();
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

    private static void ejemplo_5(){
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
}
