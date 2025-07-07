package cat.urv.deim.models;

import cat.urv.deim.exceptions.ElementNoTrobat;

public class LlistaPeliculesOrdenada extends LlistaPelicules {
    private final LlistaDoblementEncadenadaOrdenada<Pelicula> llistaOrdre;

    public LlistaPeliculesOrdenada() {
        llistaOrdre = new LlistaDoblementEncadenadaOrdenada<>();
    }

    public void inserir(Pelicula e) {
        llistaOrdre.inserir(e);
    }

    public void esborrar(Pelicula e) throws ElementNoTrobat {
        llistaOrdre.esborrar(e);
    }

    //Mètode per a comprovar si un element està a la llista
    public boolean buscar(Pelicula pelicula) {
        return llistaOrdre.buscar(pelicula);
    }

    //Mètode per a comprovar si la llista té elements
    public boolean esBuida() { return llistaOrdre.esBuida(); }

    //Mètode per a obtenir el nombre d'elements de la llista
    public int longitud() {
        return llistaOrdre.longitud();
    }

    //Mètode per a obtenir un array amb tots els elements
    public Pelicula[] elements() {
        Pelicula[] pelicules = new Pelicula[longitud()];
        Object[] elements = llistaOrdre.elements();
        for (int i = 0; i < longitud(); i++) {
            pelicules[i] = (Pelicula) elements[i];
        }
        return pelicules;
    }
}