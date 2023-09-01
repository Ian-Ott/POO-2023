package ar.edu.unlu.poo.password;

import java.util.ArrayList;

public class Contenido {
    private int longitud = 8;
    private ArrayList<Object> contrasenias = new ArrayList<>();

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setContrasenias(ArrayList<Object> contrasenias) {
        this.contrasenias = contrasenias;
    }

    public ArrayList<Object> getContrasenias() {
        return contrasenias;
    }
}
