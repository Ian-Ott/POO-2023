package ar.edu.unlu.poo.juegoPalabras;

import java.util.ArrayList;

public class Jugador {
    //private int num_jugador;
    private int puntuacionTotal;
    ArrayList<String> palabras = new ArrayList<>();

    /*public void setNum_jugador(int num_jugador) {
        this.num_jugador = num_jugador;
    }

    public int getNum_jugador() {
        return num_jugador;
    }*/

    public void setPalabras(String palabra) {
        palabras.add(palabra);
    }

    public ArrayList<String> getPalabras() {
        return palabras;
    }

    public void setPuntuacionTotal(int puntuacionTotal) {
        this.puntuacionTotal = puntuacionTotal;
    }

    public int getPuntuacionTotal() {
        return puntuacionTotal;
    }
}
