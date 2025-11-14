package package1.asignacion12_arbolesbinariosdebusqueda;

import package1.asignacion12_arbolesbinariosdebusqueda.NodoGenerico;
/**
 * 
 * @author E5
 * @param <T> 
 */
public class ArbolBSTGenerico < T extends Comparable<T>>{
    
    NodoGenerico<T> raiz;

    public ArbolBSTGenerico() {
        raiz = null;
    }

    public void insertar(T dato) {
        raiz = insertarRec(raiz, dato);
    }

    private NodoGenerico<T> insertarRec(NodoGenerico<T> nodo, T dato) {
        if (nodo == null) {
            return new NodoGenerico<>(dato);
        }
        int comp = dato.compareTo(nodo.dato);

        if (comp < 0) {
            nodo.izq = insertarRec((NodoGenerico<T>) nodo.izq, dato);
        } else if (comp > 0) {
            nodo.der = insertarRec((NodoGenerico<T>) nodo.der, dato);
        } else {
            System.out.println("Dato repetido: " + dato);
        }

        return nodo;
    }

    public void inorden() {
        inordenRec(raiz);
    }

    private void inordenRec(NodoGenerico<T> nodo) {
        if (nodo == null) return;

        inordenRec((NodoGenerico<T>) nodo.izq);
        System.out.println(nodo.dato);
        inordenRec((NodoGenerico<T>) nodo.der);
    }

    public NodoGenerico<T> getRaiz() {
        return raiz;
    }
}
