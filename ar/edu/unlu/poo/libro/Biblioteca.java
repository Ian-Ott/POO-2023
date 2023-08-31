package ar.edu.unlu.poo.libro;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> libros = new ArrayList<Libro>();

    public void agregar_libro(String titulo, String autor, int cant_paginas, int ejemplares){
        Libro nuevo_libro = new Libro();
        libros.add(nuevo_libro);
        nuevo_libro.setTitulo(titulo);
        nuevo_libro.setAutor(autor);
        nuevo_libro.setCant_paginas(cant_paginas);
        nuevo_libro.setEjemplares(ejemplares);
    }

    public void mostrar_descripcion(String titulo, String autor){
        //devolver boolean para comprobar si se encontro el libro?
        Libro libroAux;
        for (int i = 0; i < libros.size(); i++){
            libroAux = libros.get(i);
            if (libroAux.getTitulo().equals(titulo) && libroAux.getAutor().equals(autor)){
                System.out.println("El libro " + libroAux.getTitulo() + " creado por el autor " + libroAux.getAutor() + " tiene " + libroAux.getCant_paginas() + " paginas, quedan " + libroAux.getEjemplares() + " disponibles y se prestaron " + libroAux.getEjemplares_prestados() + ".");
            }
        }
    }

    public int prestamosRealizados(String titulo, String autor){
        Libro libroAux;
        int cantidad_prestados = 0;
        for (int i = 0; i < libros.size(); i++){
            libroAux = libros.get(i);
            if (libroAux.getTitulo().equals(titulo) && libroAux.getAutor().equals(autor)){
                cantidad_prestados = libroAux.getEjemplares_prestados();
            }
        }
        return cantidad_prestados;
    }

    public void prestar_libro(String titulo, String autor){
        //tal vez tambien poner boolean
        Libro libroAux;
        for (int i = 0; i < libros.size(); i++){
            libroAux = libros.get(i);
            if (libroAux.getTitulo().equals(titulo) && libroAux.getAutor().equals(autor)){
                if (libroAux.getEjemplares() == 1){
                    System.out.println("No se puede prestar el libro debido a que solo queda un ejemplar disponible");
                }else {
                    libroAux.setEjemplares(libroAux.getEjemplares() - 1);
                    libroAux.setEjemplares_prestados(libroAux.getEjemplares_prestados() + 1);
                    System.out.println("Se presto el libro correctamente");
                }
            }
        }

    }

    public boolean libro1_tieneMasPags(String titulo1, String autor1, String titulo2, String autor2){
        Libro libro1 = new Libro();
        Libro libro2 = new Libro();
        Libro libroAux;
        for (int i = 0; i < libros.size(); i++){
            libroAux = libros.get(i);
            if(libroAux.getTitulo().equals(titulo1) && libroAux.getAutor().equals(autor1)){
                libro1 = libroAux;
            } else if (libroAux.getTitulo().equals(titulo2) && libroAux.getAutor().equals(autor2)){
                libro2 = libroAux;
            }
        }
         return libro1.getCant_paginas() > libro2.getCant_paginas();
    }

    public int total_prestamos(){
        Libro libroAux;
        int total = 0;
        for (int i = 0; i < libros.size(); i++){
            libroAux = libros.get(i);
            total += libroAux.getEjemplares_prestados();
        }
        return total;
    }

    public String toString(){
        Libro libroAux;
        String acumulador = "";
        int j = 1;
        if (libros.isEmpty()){
            return "<No hay libros Agregados>";
        }
        for (int i = 0; i < libros.size(); i++){
            libroAux = libros.get(i);
            acumulador += "\n"+ j +"- El libro " + libroAux.getTitulo() + " creado por el autor " + libroAux.getAutor() + " tiene " + libroAux.getCant_paginas() + " paginas, quedan " + libroAux.getEjemplares() + " disponibles y se prestaron " + libroAux.getEjemplares_prestados() + ".";
            j++;
        }
        return acumulador;
    }
}
