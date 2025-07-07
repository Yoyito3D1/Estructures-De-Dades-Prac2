package cat.urv.deim.models;

import cat.urv.deim.exceptions.ElementNoTrobat;

public class LlistaDoblementEncadenadaOrdenada<E extends Comparable<E>> implements ILlistaGenerica<E> {
    private Node<E> primer;
    private Node<E> ultim;
    private int elements;

    //Mètode per inserir un element a la llista. No importa la posició on s'afegeix l'element
    public void inserir(E element) {
        Node<E> nouNode = new Node<>(element);
        // Cas cua buida
        if (primer == null) {
            primer = nouNode;
            ultim = nouNode;

        // Cas elementAAfegir < elementCapLlista
        } else if (element.compareTo(primer.getElement()) < 0) {
            nouNode.setSeguent(primer);
            primer.setAnterior(nouNode);
            primer = nouNode;

        // Cas elementAAfegir > elementCapLlista
        } else if (element.compareTo(ultim.getElement()) > 0) {
            nouNode.setAnterior(ultim);
            ultim.setSeguent(nouNode);
            ultim = nouNode;

        } else {
            // Cas cercar posició a la llista
            Node<E> auxiliar = primer.getSeguent();
            while (auxiliar != null && element.compareTo(auxiliar.getElement()) > 0) {
                auxiliar = auxiliar.getSeguent();
            }
            // Si entra aquí és un node duplicat i no el guardarem.
            if (auxiliar != null && element.compareTo(auxiliar.getElement()) == 0) { return; }

            //Recomanat per un warning
            assert auxiliar != null;
            nouNode.setAnterior(auxiliar.getAnterior());
            nouNode.setSeguent(auxiliar);
            auxiliar.getAnterior().setSeguent(nouNode);
            auxiliar.setAnterior(nouNode);
        }
        elements++;
    }

    //Mètode per a esborrar un element de la llista
    public void esborrar(E e) throws ElementNoTrobat {
        Node<E> actual = primer;
        Node<E> anterior = null;
        boolean elementTrobat = false;

        while (actual != null && !elementTrobat) {
            if (actual.getElement().equals(e)) {
                elementTrobat = true;
            } else {
                anterior = actual;
                actual = actual.getSeguent();
            }
        }
        if (!elementTrobat) { throw new ElementNoTrobat("element " + e + " no es troba a la llista.");}

        // Cas esborrar primer element
        if (anterior == null) {
            primer = actual.getSeguent();
            if (primer != null) { primer.setAnterior(null); }
        } else {
            anterior.setSeguent(actual.getSeguent());
            if (actual.getSeguent() != null) { actual.getSeguent().setAnterior(anterior); }
            else { ultim = anterior; }
        }
        elements--;
    }

    //Mètode per a comprovar si un element està a la llista
    public boolean buscar(E e) {
        Node<E> nodeActual = primer.getSeguent();
        int comparat;
        while (nodeActual != null) {
            comparat = nodeActual.getElement().compareTo(e);
            if (comparat == 0) { return true; }
            else if (comparat > 0) { return false; }
            else { nodeActual = nodeActual.getSeguent(); }
        }
        return false; // Element no trobat
    }

    //Mètode per a comprovar si la llista té elements
    public boolean esBuida() { return elements == 0; }

    //Mètode per a obtenir el nombre elements de la llista
    public int longitud() { return elements; }

    //Mètode per a obtenir un array amb tots els elements
    public Object[] elements() {
        Object[] array = new Object[elements];
        int i = 0;
        Node<E> node = primer;
        while (node != null) {
            array[i] = node.getElement();
            node = node.getSeguent();
            i++;
        }
        return array;
    }
}
