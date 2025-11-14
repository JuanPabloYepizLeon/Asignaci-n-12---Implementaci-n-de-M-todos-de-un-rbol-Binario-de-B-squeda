
package package1.asignacion12_arbolesbinariosdebusqueda;
/**
 * 
 * @author E5
 * @param <T> 
 */
public class NodoGenerico <T>{
    T dato;
    NodoGenerico<T> izq;
    NodoGenerico<T> der;

    public NodoGenerico(T dato) {
        this.dato = dato;
        this.izq = null;
        this.der = null;
}
}
