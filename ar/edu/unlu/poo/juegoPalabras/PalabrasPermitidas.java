package ar.edu.unlu.poo.juegoPalabras;

import java.util.ArrayList;

public class PalabrasPermitidas {
    //puse para que se puedan cargar las palabras porque asi lo piden
    // sino yo lo habia implementado de otra manera
    private ArrayList<String> diccionario = new ArrayList<>();

    public void setDiccionario(String palabra) {
        diccionario.add(palabra);
    }

    public ArrayList<String> getDiccionario() {
        return diccionario;
    }
}
