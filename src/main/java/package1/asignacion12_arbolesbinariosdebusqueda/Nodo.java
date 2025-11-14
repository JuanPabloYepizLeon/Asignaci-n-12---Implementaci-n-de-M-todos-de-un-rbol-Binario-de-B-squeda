package package1.asignacion12_arbolesbinariosdebusqueda;

/**
 * Nodo.java
 * Nodo para el arbol binario de busqueda de enteros
 * @author E5
 */
public class Nodo {
    private int valor;
    private Nodo izquierdo;
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

    // Getters y Setters
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }
   
}
