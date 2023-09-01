package ar.edu.unlu.poo.password;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.Math.*;

public class Contrasenia {
    Contenido contenido = new Contenido();
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

    public void generar_contrasenias(){
        int eleccion;
        String acumulador = "";
        ArrayList<String> contraseniasAux = contenido.getContrasenias();
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < contenido.getLongitud(); j++){
                eleccion = (int) (Math.random() * 3 + 1);
                if (eleccion == 1){
                    acumulador += mayusculas.get((int) (random() * 25));
                } else if(eleccion == 2){
                    acumulador += minusculas.get((int) (random() * 25));
                } else {
                    acumulador += numeros.get((int) (random() * 9));
                }
            }
                contraseniasAux.add(acumulador);
                acumulador = "";
        }
    }
    public  void regenerarContraseniaDebil(){
        ArrayList<String> contraseniasAUX = contenido.getContrasenias();
        for (int i = 0; i < contraseniasAUX.size(); i++){
            if(!es_fuerte(contraseniasAUX.get(i))){
                contraseniasAUX.set(i, regenerar());
            }
        }
        System.out.println("\nContrasenias debiles regeneradas");
    }

    private String regenerar(){
        double eleccion = (random() * 3 + 1);
        String nueva_Contrasenia = "";
        for (int i = 0; i < contenido.getLongitud(); i++){
                if (eleccion == 1){
                    nueva_Contrasenia += mayusculas.get((int) (random() * 25));
                } else if(eleccion == 2){
                    nueva_Contrasenia += minusculas.get((int) (random() * 25));
                } else {
                    nueva_Contrasenia += numeros.get((int) (random() * 9));
            }
        }
        return nueva_Contrasenia;
    }
    public String toString() {
        String acumulador = "";
        Integer i = 1;
        ArrayList<String> contraseniasAux = contenido.getContrasenias();
        if (contenido == null) {
            acumulador = "\nNo hay contrasenias";
        } else {
            for (int j = 0; j < contraseniasAux.size(); i++){
                if (es_fuerte(contraseniasAux.get(j))){
                acumulador += "\n" + i + "- " + contraseniasAux.get(j) + " - Fuerte";
                }else {
                    acumulador += "\n" + i + "- " + contraseniasAux.get(j) + "- Debil";
                }
                i++;
            }
        }
        return acumulador;
    }
}
