package cat.urv.deim.models;

import cat.urv.deim.exceptions.ElementNoTrobat;

public interface ILlistaPelicules extends ILlistaGenerica<Pelicula> {

    //Funció que busca quantes pelis hi ha d'un any en concret
    public int comptarPeliculesAny(int any);

    //Funció que ens diu l'any en què va sortir una peli
    public int buscarAnyPelicula(String titol) throws ElementNoTrobat;

    //Funció que retorna la pelicula segons el titol
    public Pelicula buscarPelicula(String titol) throws ElementNoTrobat;

    //Mètode per a obtenir un array amb tots els elements
    public Pelicula[] elements();
}