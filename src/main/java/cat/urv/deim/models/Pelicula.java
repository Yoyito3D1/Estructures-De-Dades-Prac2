package cat.urv.deim.models;

public class Pelicula implements Comparable<Pelicula> {
    private final int idP;
    private final String titol;
    private final int any;

    public Pelicula(int idP, String titol, int any) {
        this.idP = idP;
        this.titol = titol;
        this.any = any;
    }

    public int getID() { return this.idP; }

    public String getTitol() { return this.titol; }

    public int getAny() { return this.any; }

    // Comparem amb tres criteris, primer el títol, després l'any i per últim l'id
    @Override
    public int compareTo(Pelicula peliculaAComparar) {
        // Comparar títols
        int comparacio = this.titol.compareTo(peliculaAComparar.getTitol());
        if (comparacio != 0) { return comparacio; }
        // Comparar anys
        comparacio = Integer.compare(this.any, peliculaAComparar.getAny());
        if (comparacio != 0) { return comparacio; }

        // Comparar IDs
        comparacio = Integer.compare(this.idP, peliculaAComparar.getID());
        return comparacio;
    }
}
