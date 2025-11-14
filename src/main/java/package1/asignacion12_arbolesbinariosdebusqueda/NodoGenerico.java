
package package1.asignacion12_arbolesbinariosdebusqueda;
/**
 * La clase generica que nos representa al nodo dentro del arbol de busqueda
 * cada uno de los nodos hace referencia al izquierdo y al derecho
 * @author E5
 * @param <T> Tipo de dato para almacenar
 */
public class NodoGenerico <T>{
    /**
     * Dato que almacena al nodo
     * Hijo izquierdo referencia
     * Hijo derecho referencia
     */
    T dato;
    NodoGenerico<T> izq;
    NodoGenerico<T> der;

    /**
     * El contructor que inicia con un dato el nodo, sus hijos se establecen
     * como null
     * @param dato el valor del nodo 
     */
    public NodoGenerico(T dato) {
        this.dato = dato;
        this.izq = null;
        this.der = null;
}
}
