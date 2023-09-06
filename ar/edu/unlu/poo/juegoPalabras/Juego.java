package ar.edu.unlu.poo.juegoPalabras;

import java.util.ArrayList;

public class Juego {
    Jugador jugador1 = new Jugador();
    Jugador jugador2 = new Jugador();
    PalabrasPermitidas diccionario = new PalabrasPermitidas();
    public void agregar_palabras(String palabra, int jugador){
        boolean palabra_valida = false;
        ArrayList<String> diccionarioAux = diccionario.getDiccionario();
        int puntaje_consegido = 0;
        int puntaje_total = 0;
        palabra = palabra.toLowerCase();
        if (jugador == 1) {
            for (int i = 0; i < diccionarioAux.size(); i++) {
                if (palabra.equals(diccionarioAux.get(i))) {
                    palabra_valida = true;
                    puntaje_consegido += palabra.length();
                    puntaje_consegido += cantidad_letrasEspeciales(palabra);
                    jugador1.setPalabras(palabra);
                    puntaje_total = puntaje_consegido + jugador1.getPuntuacionTotal();
                    jugador1.setPuntuacionTotal(puntaje_total);
                }
            }
        } else if (jugador == 2) {
            for (int i = 0; i < diccionarioAux.size(); i++) {
                if (palabra.equals(diccionarioAux.get(i))) {
                    palabra_valida = true;
                    puntaje_consegido += palabra.length();
                    puntaje_consegido += cantidad_letrasEspeciales(palabra);
                    jugador2.setPalabras(palabra);
                    puntaje_total = puntaje_consegido + jugador2.getPuntuacionTotal();
                    jugador2.setPuntuacionTotal(puntaje_total);
                }
            }
        }
        if (!palabra_valida){
            System.out.println("La palabra "+ palabra + " no es valida. No se suman puntos");
        }else {
            System.out.println("La palabra "+ palabra + " es valida. El jugador " + jugador + " suma " + puntaje_consegido + " puntos.");
        }
    }


    public int puntaje(int jugador){
        int puntaje_jugador = 0;
        if (jugador == 1){
            puntaje_jugador = jugador1.getPuntuacionTotal();
        } else if (jugador == 2) {
            puntaje_jugador = jugador2.getPuntuacionTotal();
        }
        return puntaje_jugador;
    }

    public int puntaje_masAlto (){
        int ganador;
        if (jugador1.getPuntuacionTotal() > jugador2.getPuntuacionTotal()){
            System.out.println("\nEl jugador 1 tiene mayor puntuacion con " + jugador1.getPuntuacionTotal() + " puntos totales.");
            ganador = 1;
        } else if (jugador2.getPuntuacionTotal() > jugador1.getPuntuacionTotal()) {
            System.out.println("\nEl jugador 2 tiene mayor puntuacion con " + jugador2.getPuntuacionTotal() + " puntos totales.");
            ganador = 2;
        }else {
            System.out.println("\nAmbos jugadores tienen la misma puntuacion");
            ganador = 0;
        }
        return ganador;
    }
    public int cantidad_letrasEspeciales(String palabra){
        int puntaje = 0;
        if (palabra.contains("q")) {
            puntaje += 1;
        }
        if (palabra.contains("k")) {
            puntaje += 1;
        }
        if (palabra.contains("z")) {
            puntaje += 1;
        }
        if (palabra.contains("x")) {
            puntaje += 1;
        }
        if (palabra.contains("y")) {
            puntaje += 1;
        }
        if (palabra.contains("w")) {
            puntaje += 1;
            }
        return puntaje;
    }

    public  void agregar_palabrasAlDiccionario(String palabra_nueva){
        ArrayList<String> diccionarioAux = diccionario.getDiccionario();
        if (diccionarioAux.isEmpty()){
            diccionario.setDiccionario(palabra_nueva);
        }else {
            for (int i = 0; i < diccionarioAux.size();i++){
                if (diccionarioAux.get(i).equals(palabra_nueva)){
                    System.out.println("La palabra ya estaba en el diccionario");
                    return;
                }
            }
            diccionario.setDiccionario(palabra_nueva);
        }
    }
}

