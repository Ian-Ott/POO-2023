package ar.edu.unlu.poo.password;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contraseña {
    Contenido contenido = null;
    ArrayList<String> numeros = new ArrayList<>(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9"));
    ArrayList<String> minusculas = new ArrayList<>(List.of("a","b", "c", "d", "e", "f" , "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u","v", "w", "x", "y", "z"));
    ArrayList <String> mayusculas = new ArrayList<>(List.of("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));



    public void cambiar_longitud(){
        System.out.println("Seleccione la longitud que desea para la contrasenia");
        int longitud = 0;
        Scanner sc = new Scanner(System.in);
        while(longitud < 8 || longitud > 32){
            System.out.println("Seleccione una longitud:");
            longitud = sc.nextInt();
            if (longitud <= 0 || longitud > 13){
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
        for (int i = 0; i < mayusculas.size(); i++) {
            if (contrasenia.contains(mayusculas.get(i))){
                cantidad_mayus++;
            }
        }
        for (int i = 0; i < minusculas.size(); i++) {
            if (contrasenia.contains(minusculas.get(i))){
                cantidad_minus++;
            }
        }
        for (int i = 0; i < numeros.size(); i++) {
            if (contrasenia.contains(numeros.get(i))){
                cantidad_numeros++;
            }
        }
        if (cantidad_mayus > 2 && cantidad_minus > 1 && cantidad_numeros >= 2){
            resultado = true;
        }
        return resultado;
    }

    /*public void generar_contraseñas(){

    }*/
}
