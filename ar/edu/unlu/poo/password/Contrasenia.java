package ar.edu.unlu.poo.password;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ar.edu.unlu.poo.password.caracteres.*;
import static java.lang.Math.*;

public class Contrasenia {
    Contenido contenido = new Contenido();


    public void cambiar_longitud(){
        System.out.println("Seleccione la longitud que desea para la contrasenia");
        int longitud = 0;
        Scanner sc = new Scanner(System.in);
        while(longitud < 8 || longitud > 32){
            System.out.println("Seleccione una longitud:");
            longitud = sc.nextInt();
            if (longitud <= 7 || longitud > 32){
                System.out.println("OPCION INCORRECTA: Seleccione una longitud entre 8-32");
            }
        }
        contenido.setLongitud(longitud);
    }

    public boolean es_fuerte(String contrasenia){
        int cantidad_mayus = 0;
        int cantidad_minus = 0;
        int cantidad_numeros = 0;
        boolean resultado = false;
        for (int i = 0; i < mayusculas.length; i++) {
            if (contrasenia.contains(mayusculas[i])){
                cantidad_mayus++;
            }
        }
        for (int i = 0; i < minusculas.length; i++) {
            if (contrasenia.contains(minusculas[i])){
                cantidad_minus++;
            }
        }
        for (int i = 0; i < numeros.length; i++) {
            if (contrasenia.contains(numeros[i])){
                cantidad_numeros++;
            }
        }
        if (cantidad_mayus > 2 && cantidad_minus > 1 && cantidad_numeros >= 2){
            resultado = true;
        }
        return resultado;
    }

    public ArrayList<String> generar_contrasenias(){
        int eleccion;
        String acumulador = "";
        ArrayList<String> contraseniasAux = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < contenido.getLongitud(); j++){
                eleccion = (int) (Math.random() * 3 + 1);
                if (eleccion == 1){
                    acumulador += mayusculas[(int) (random() * mayusculas.length)];
                } else if(eleccion == 2){
                    acumulador += minusculas[(int) (random() * minusculas.length)];
                } else {
                    acumulador += numeros[(int) (random() * numeros.length)];
                }
            }
                contraseniasAux.add(acumulador);
                acumulador = "";
        }
        return contraseniasAux;
    }
    public  void regenerarContraseniaDebil(ArrayList<String> contraseniasAUX){
        for (int i = 0; i < contraseniasAUX.size(); i++){
            if(!es_fuerte(contraseniasAUX.get(i))){
                contraseniasAUX.set(i, regenerar());
            }
        }
        System.out.println("\nContrasenias debiles regeneradas (si ninguna era debil quedan exactamente igual)");
    }

    private String regenerar(){
        double eleccion;
        String nueva_Contrasenia = "";
        for (int i = 0; i < contenido.getLongitud(); i++){
            eleccion = (int) (Math.random() * 3 + 1);
                if (eleccion == 1){
                    nueva_Contrasenia += mayusculas[(int) (random() * mayusculas.length)];
                } else if(eleccion == 2){
                    nueva_Contrasenia += minusculas[(int) (random() * minusculas.length)];
                } else {
                    nueva_Contrasenia += numeros[(int) (random() * numeros.length)];
            }
        }
        return nueva_Contrasenia;
    }
    public void mostrar_contrasenias(ArrayList<String> contraseniasAux) {
        Integer i = 1;
        if (contraseniasAux.isEmpty()) {
            System.out.println("\nNo hay contrasenias");
        } else {
            for (int j = 0; j < contraseniasAux.size(); j++){
                if (es_fuerte(contraseniasAux.get(j))){
                    System.out.println("\n" + i + "- " + contraseniasAux.get(j) + " - Fuerte");
                }else {
                    System.out.println("\n" + i + "- " + contraseniasAux.get(j) + "- Debil");
                }
                i++;
            }
        }
    }
}
