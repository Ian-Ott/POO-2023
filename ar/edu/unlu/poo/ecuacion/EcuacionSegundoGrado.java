package ar.edu.unlu.poo.ecuacion;

import java.util.ArrayList;

import static java.lang.Math.*;

public class EcuacionSegundoGrado {
   Coeficientes valores = null;
    public void Establecer_valores(int a, int b, int c){
        if (valores != null){
            System.out.println("Los valores ya estan establecidos y no se pueden cambiar");
            return;
        }
        valores = new Coeficientes();
        valores.setA(a);
        valores.setB(b);
        valores.setC(c);
    }

    public ArrayList<Integer> calcular_raiz(){
        Integer raiz1 = 0;
        Integer raiz2 = 0;
        int aAUX = valores.getA();
        int bAUX = valores.getB();
        int cAUX = valores.getC();
        ArrayList<Integer> raices = new ArrayList<>();
        if (valores == null){
            return null;
        } else {
            double calculo = (pow(bAUX, 2)) - (4 * aAUX * cAUX);
            if ((calculo != 0 )) {
                raiz1 = (int) (((-bAUX) + sqrt(calculo)));
                raiz1 = raiz1 / (2 * aAUX);
                raiz2 = (int) (((-bAUX) - sqrt(calculo)));
                raiz2 = raiz2 / (2 * aAUX);
                raices.add(raiz1);
                raices.add(raiz2);
                valores.setRaices(raices);
            }else {
                raiz1 = (int) ((-bAUX + sqrt(calculo)) / (2 * aAUX));
                raices.add(raiz1);
                valores.setRaices(raices);
            }
        }
        return raices;
    }

    public ArrayList<Integer> calcular_y(ArrayList<Integer> raices){
        if (raices.isEmpty()){return null;}
        int aAUX = valores.getA();
        int bAUX = valores.getB();
        int cAUX = valores.getC();
        ArrayList<Integer> y = new ArrayList<>();
        Integer resultado = 0;
        for(int i = 0; i < raices.size();i++){
            resultado = (int) ((pow(raices.get(i), 2)));
            resultado = (resultado * aAUX);
            resultado = resultado + (bAUX * raices.get(i));
            resultado = resultado + cAUX;
            y.add(resultado);
        }
        return y;
    }

}
