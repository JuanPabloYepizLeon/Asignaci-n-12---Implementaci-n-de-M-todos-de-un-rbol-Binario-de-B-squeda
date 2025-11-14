package package1.asignacion12_arbolesbinariosdebusqueda;

/**
 * Nodo.java
 * Nodo para el arbol binario de busqueda de enteros
 * @author E5
 */
public class Nodo {
    /**
     * Valor tipo entero almacenado en el nodo
     */
    private int valor;
    /**
     * Hijo izquierdo su referencia
     */
    private Nodo izquierdo;
    /**
     * Hijo derecho su referencia
     */
    private Nodo derecho;

    /**
     * Constructor que inicializa el nodo con un valor
     * @param valor Valor entero a almacenar en el nodo
     */
    public Nodo(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }

    /**
     * Obtiene los valores
     * @return almacenados en el nodo
     */
    public int getValor() {
        return valor;
    }
    /**
     * Establece
     * @param valor nuevo para el nodo
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * Obtiene la referencia
     * @return hijo izquierdo
     */
    public Nodo getIzquierdo() {
        return izquierdo;
    }

    /**
     * Asigna como hijo
     * @param izquierdo (nodo)
     */
    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    /**
     * Obtiene la referencia
     * @return hijo derecho
     */
    public Nodo getDerecho() {
        return derecho;
    }
    
    /**
     *Asigna como hijo
     * @param derecho (nodo)
     */
    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }
   
}
