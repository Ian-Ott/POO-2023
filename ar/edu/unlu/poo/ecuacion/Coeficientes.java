package ar.edu.unlu.poo.ecuacion;

import java.util.ArrayList;

public class Coeficientes {
    private int a;
    private int b;
    private int c;
    private ArrayList<Integer> raices = new ArrayList<>();

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getB() {
        return b;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getC() {
        return c;
    }

    public void setRaices(ArrayList<Integer> raices) {
        this.raices = raices;
    }

    public ArrayList<Integer> getRaices() {
        return raices;
    }
}
