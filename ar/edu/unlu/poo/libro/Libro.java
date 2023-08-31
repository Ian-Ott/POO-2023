package ar.edu.unlu.poo.libro;

public class Libro {
    private String titulo;
    private String autor;
    private int cant_paginas;
    private int ejemplares;
    private int ejemplares_prestados = 0;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo(){return titulo;}

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setCant_paginas(int cant_paginas) {
        this.cant_paginas = cant_paginas;
    }

    public int getCant_paginas() {
        return cant_paginas;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares_prestados(int ejemplares_prestados) {
        this.ejemplares_prestados = ejemplares_prestados;
    }

    public int getEjemplares_prestados() {
        return ejemplares_prestados;
    }
}
