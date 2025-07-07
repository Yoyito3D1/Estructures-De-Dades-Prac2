package cat.urv.deim.models;

import cat.urv.deim.exceptions.ElementNoTrobat;

public class LlistaPelicules implements ILlistaPelicules {
    private final LlistaDoblementEncadenada<Pelicula> pelis;

    public LlistaPelicules() {
        pelis = new LlistaDoblementEncadenada<>();
    }

    //Mètode per insertar un element a la llista. No importa la posició on s'afegeix l'element
    public void inserir(Pelicula e) {
        pelis.inserir(e);
    }

    //Mètode per a esborrar un element de la llista
    public void esborrar(Pelicula e) throws ElementNoTrobat { pelis.esborrar(e); }

    //Mètode per a comprovar si un element està a la llista
    public boolean buscar(Pelicula pelicula) {
        return pelis.buscar(pelicula);
    }

    //Mètode per a comprovar si la llista té elements
    public boolean esBuida() { return pelis.esBuida(); }

    //Mètode per a obtenir el nombre d'elements de la llista
    public int longitud() {
        return pelis.longitud();
    }

    //Funcio que busca quantes películes hi ha d'un any en concret
    public int comptarPeliculesAny(int any) {
        int comptador = 0;
        for(int i = 0; i< longitud(); i++) {
            Pelicula peliAux = elements()[i];
            if(peliAux.getAny() == any) comptador++;
        }
        return comptador;
    }

    //Funció que ens diu l'any en que va sortir una película
    public int buscarAnyPelicula(String titol) throws ElementNoTrobat {
        Pelicula peliAux = buscarPelicula(titol);
        return peliAux.getAny();
    }

    //Funció que retorna la pelicula segons el titol
    public Pelicula buscarPelicula(String titol) throws ElementNoTrobat {
        boolean condicio = false;
        int i = 0;
        Pelicula peliBuscada = null;

        while(!condicio && i < longitud()) {
            Pelicula peliAux = elements()[i];
            if(peliAux.getTitol().equalsIgnoreCase(titol)) {
                peliBuscada = peliAux;
                condicio = true;
            }
            i++;
        }
        if(!condicio) { throw new ElementNoTrobat("Error: Peli no trobada!"); }
        return peliBuscada;
    }

    //Mètode per a obtenir un array amb tots els elements
    public Pelicula[] elements() {
        Pelicula[] pelicules = new Pelicula[longitud()];
        Object[] elements = pelis.elements();
        for (int i = 0; i < longitud(); i++) {
            pelicules[i] = (Pelicula) elements[i];
        }
        return pelicules;
    }
}
