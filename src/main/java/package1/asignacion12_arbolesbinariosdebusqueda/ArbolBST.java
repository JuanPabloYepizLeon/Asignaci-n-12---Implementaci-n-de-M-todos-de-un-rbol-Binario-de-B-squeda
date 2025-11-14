package package1.asignacion12_arbolesbinariosdebusqueda;

/**
 * ArbolBST.java
 * Implementacion de un arbol binario de busqueda (enteros)
 * con insercion, busqueda, eliminacion, recorridos y consultas
 * @author E5
 */
public class ArbolBST {
    private Nodo raiz;

    /**
     * Constructor que inicializa un arbol vacio
     */
    public ArbolBST(Nodo raiz) {
        this.raiz = null;
    }
    
    /**
     * Inserta un nuevo valor en el arbol
     * @param valor El valor a insertar
     */
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }
    
    /**
     * Metodo recursivo auxiliar para insertar
     * @param nodo El nodo actual
     * @param valor El valor a insertar
     * @return El nodo actualizado
     */
    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }
        if (valor < nodo.getValor()) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), valor));
        } else if (valor > nodo.getValor()) {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), valor));
        } else {
            System.out.println("Valor duplicado no insertado: "+valor);
        }
        return nodo;
    }
    
    /**
     * Busca un valor en el arbol
     * @param valor El valor a buscar
     * @return true si el valor existe, false en caso contrario
     */
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }
    
    /**
     * Metodo recursivo auxiliar para buscar
     * @param nodo El nodo actual
     * @param valor El valor a buscar
     * @return true si se encuentra, false en caso contrario
     */
    private boolean buscarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return false;
        }
        if (valor == nodo.getValor()) {
            return true;
        } else if (valor < nodo.getValor()) {
            return buscarRecursivo(nodo.getIzquierdo(), valor);
        } else {
            return buscarRecursivo(nodo.getDerecho(), valor);
        }
    }
    
    /**
     * Elimina un valor del arbol
     * @param valor El valor a eliminar
     */
    public void eliminar(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }
    
    /**
     * Metodo recursivo auxiliar para eliminar
     * @param nodo El nodo actual
     * @param valor El valor a eliminar
     * @return El nodo actualizado
     */
    private Nodo eliminarRecursivo(Nodo nodo, int valor) {
        // Caso 1: Arbol vacio
        if (nodo == null) {
            return null;
        }
        // Buscar el nodo a eliminar
        if (valor < nodo.getValor()) {
            // Buscar en subarbol izquierdo
            nodo.setIzquierdo(eliminarRecursivo(nodo.getIzquierdo(), valor));
        } else if (valor > nodo.getValor()) {
            // Buscar en subarbol derecho
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), valor));
        } else {
            // Nodo encontrado
            // Caso 2: Nodo sin hijos(hoja)
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                return null;
            }
            // Caso 3: Nodo con un solo hijo
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            } else if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }
            // Caso 4: Nodo con dos hijos
            int sucesorValor = encontrarMinimoValor(nodo.getDerecho());
            nodo.setValor(sucesorValor);
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), sucesorValor));
        }
        return nodo;
    }
    
    /**
     * Encuentra el valor minimo en un subarbol
     * @param nodo La raiz del subarbol
     * @return El valor minimo
     */
    private int encontrarMinimoValor(Nodo nodo) {
        Nodo actual = nodo;
        while (actual.getIzquierdo() != null) {            
            actual = actual.getIzquierdo();
        }
        return actual.getValor();
    }
    
    /**
     * Realiza un recorrido inorden (Izq-Raiz-Der)
     * Imprime los valores en orden ascendente
     */
    public void inorden() {
        System.out.println("Recorrido Inorden: ");
        inordenRecursivo(raiz);
        System.out.println();
    }
    
    /**
     * Metodo recursivo auxiliar para inorden
     * @param nodo El nodo actual
     */
    private void inordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            inordenRecursivo(nodo.getIzquierdo());
            System.out.println(nodo.getValor()+ " ");
            inordenRecursivo(nodo.getDerecho());
        }
    }
    
    /**
     * Realiza un recorrido preorden (Raiz-Izq-Der)
     * Util para copiar el arbol
     */
    public void preorden() {
        System.out.println("Recorrido Preorden: ");
        preordenRecursivo(raiz);
        System.out.println();
    }
    
    /**
     * Metodo recursivo auxiliar para preorden
     * @param nodo El nodo actual
     */
    private void preordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.println(nodo.getValor()+" ");
            preordenRecursivo(nodo.getIzquierdo());
            preordenRecursivo(nodo.getDerecho());
        }
    }
    
    /**
     * Realiza un recorrido postorden (Izq-Der-Raiz)
     */
    public void postorden() {
        System.out.println("Recorrido Postorden: ");
        postordenRecursivo(raiz);
        System.out.println();
    }
    
    /**
     * Metodo recursivo auxiliar para postorden
     * @param nodo El nodo actual
     */
    private void postordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            postordenRecursivo(nodo.getIzquierdo());
            postordenRecursivo(nodo.getDerecho());
            System.out.println(nodo.getValor()+" ");
        }
    }
}
