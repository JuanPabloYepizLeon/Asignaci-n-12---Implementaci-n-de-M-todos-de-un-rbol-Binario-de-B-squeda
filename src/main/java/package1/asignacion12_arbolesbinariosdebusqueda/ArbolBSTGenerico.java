package package1.asignacion12_arbolesbinariosdebusqueda;

import package1.asignacion12_arbolesbinariosdebusqueda.NodoGenerico;
/**
 * La clase que implementa un arbol binario (BST) generico, nos permite insertar elementos
 * de cualquier tipo que implemente el comparable
 * @author E5
 * @param <T> generico 
 */
public class ArbolBSTGenerico < T extends Comparable<T>>{
    
    /**
     * onstructor que inicialia el arbol vacio
     */
    NodoGenerico<T> raiz;
    
    /**
     * Constructor que inicialia el arbol vacio
     */
    public ArbolBSTGenerico() {
        raiz = null;
    }
    /**
     * Metodo publico 
     * @param dato en el arbol que llama al metodo recursivo insertarRec
     */
    public void insertar(T dato) {
        raiz = insertarRec(raiz, dato);
    }

    /**
     * Insertamos de manera recursiva(BST)
     * @param nodo actual en el que se evalua la insercion
     * @param dato a insertar
     * @return El nodo que se actualiza despues de la insercion
     */
    private NodoGenerico<T> insertarRec(NodoGenerico<T> nodo, T dato) {
        /**
         * Caso base, dado el caso que el nodo sea null creamos uno nuevo con el dato
         */
        if (nodo == null) {
            return new NodoGenerico<>(dato);
        }
        /**
         * Comparamos el dato de insertar con el nodo actual
         */
        int comp = dato.compareTo(nodo.dato);

        if (comp < 0) {
            /**
             * El menor va hacia el subarbol izquierda
             */
            nodo.izq = insertarRec((NodoGenerico<T>) nodo.izq, dato);
        } else if (comp > 0) {
            /**
             * El mayor va hacia el subarbol derecho
             */
            nodo.der = insertarRec((NodoGenerico<T>) nodo.der, dato);
        } else {
            /**
             * De ser iguales no estan permitidos los duplicados
             */
            System.out.println("Dato repetido: " + dato);
        }
        /**
         * Retornamos nodo para mantener la estructura
         */
        return nodo;  
    }
    /**
     * Metodo publico para recorrer el arbol inorder
     * ademas imprimimos los datos de menor a mayor
     */
    public void inorden() {
        inordenRec(raiz);
    }
    /**
     * Recorrido en inorder
     * @param nodo izquierda nodo derecha
     */
    private void inordenRec(NodoGenerico<T> nodo) {
        if (nodo == null) return;
        /**
         *Caso base (no recorremos nada) 
         */

        /**
         *Recorremos el subarbol 
         * Imprimimos el dato obtenido actualmente
         * recorremos al subarbol derecho
         */
        inordenRec((NodoGenerico<T>) nodo.izq);
        System.out.println(nodo.dato);
        inordenRec((NodoGenerico<T>) nodo.der);
    }
    /**
     * Devuelve
     * @return a la raiz del arbol
     */
    public NodoGenerico<T> getRaiz() {
        return raiz;
    }
}
