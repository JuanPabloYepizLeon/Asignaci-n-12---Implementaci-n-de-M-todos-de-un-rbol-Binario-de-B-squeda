
package package1.asignacion12_arbolesbinariosdebusqueda;

import package1.asignacion12_arbolesbinariosdebusqueda.NodoGenerico;

/**
 * La clase que gestiona al arbol permitiendonos agregar a los estudiantes 
 * para mostrarlos de forma ordenada, calcular sus promedios,buscarlos segun sea 
 * el rango, conatar a quienes hayan aprobamos y finalmente mostrar al estudiante
 * mas destacado
 * @author E5
 */
public class GestorEstudiantes {
    /**
     * Arbol almacen de objetos del estudiante
     */
     private ArbolBSTGenerico<Estudiante> arbol;

    /**
     * Constructor que inicia con el arbol vacio
     */
    public GestorEstudiantes() {
        arbol = new ArbolBSTGenerico<>();
    }

    /**
     * Agregamos un estudiante nuevo
     * @param nombre del estudiante
     * @param calificacion numerica
     */
    public void agregarEstudiante(String nombre, int calificacion) {
        Estudiante estudiante = new Estudiante(nombre, calificacion);
        arbol.insertar(estudiante);
        System.out.println("Estudiante agregado: " + estudiante);
    }
    
    /**
     * Orden de estudiantes califeicaciones (inorder)
     */
    public void mostrarEstudiantes() {
        System.out.println("\n=== Estudiantes ordenados por calificacion ===");
        arbol.inorden();
    }
    /**
     * Las calificaciones que estan dentro dle rango
     * @param min la calificacion minima
     * @param max la calificacion maxima
     */
    public void estudiantesEnRango(int min, int max) {
        System.out.println("\nEstudiantes con calificacion entre " + min + " y " + max + ":");
        estudiantesEnRango(arbol.raiz, min, max);
    }

    /**
     * Busqueda recursiva del rango
     * @param nodo que se esta evaluando
     * @param min rango minimo de calificacion
     * @param max rango maximo de calificacion
     */
    private void estudiantesEnRango(NodoGenerico<Estudiante> nodo, int min, int max) {
        if (nodo == null) return;
        
        int cal = nodo.dato.getCalificacion();
        /**
         * Sea mayor o igual al minimo se dirige hacia el subarbol izquierdo
         */
        if (cal >= min)
            estudiantesEnRango(nodo.izq, min, max);

        /**
         * Si se encuentra dentro del rango se imprime
         */
        if (cal >= min && cal <= max)
            System.out.println(nodo.dato);
        
        /**
         * Sea menor o igual al maximo se dirige hacia el subarbol derecho
         */
        if (cal <= max)
            estudiantesEnRango(nodo.der, min, max);
    }

    /**
     * Se calcula el rpomedio total 
     * @return double como el promedio
     */
    public double promedioCalificaciones() {
        SumaContador sc = new SumaContador();
        promedio(arbol.raiz, sc);

        if (sc.contador == 0) return 0;
        return (double) sc.suma / sc.contador;
    }

    /**
     * Recorremos el arbol
     * @param nodo actual que se encuentra en proceso
     * @param sc acumulador para almacenar  la suma y la cantidad
     */
    private void promedio(NodoGenerico<Estudiante> nodo, SumaContador sc) {
        if (nodo == null) return;
    
        /**
         * se dirige a la izquierda
         * procesa el nodo
         * se incrementa el contador
         * se dirige hacia la derecha
         */
        promedio(nodo.izq, sc);
        sc.suma += nodo.dato.getCalificacion();
        sc.contador++;
        promedio(nodo.der, sc);
    }

    /**
     * Almacenamos la suma y el contador en esta clase auxiliar
     */
    private static class SumaContador {
        int suma = 0;
        int contador = 0;
    }

    /**
     * Obtenemos al estudiante con la calificacion mas alta
     * En nuestro (BST) donde encontramos el extremo derecho
     * @return la mejor calificacion del estudiante
     */
    public Estudiante mejorEstudiante() {
        NodoGenerico<Estudiante> actual = arbol.raiz;

        if (actual == null) return null;

        /**
         * Se avanza hacia el nodo de la derecha
         */
        while (actual.der != null)
            actual = actual.der;

        return actual.dato;
    }

    /**
     * Contamos los estudiantes
     * @return verificar a los aprobados
     */
    public int contarAprobados() {
        return contarAprobados(arbol.raiz);
    }

    /**
     * Se recorre el arbol de forma recursiva
     * @param nodo actual del arbol evaluado
     * @return numero de estudiantes del subarbol aprobados
     */
    private int contarAprobados(NodoGenerico<Estudiante> nodo) {
        if (nodo == null) return 0;

        int cuenta = contarAprobados(nodo.izq);

        if (nodo.dato.getCalificacion() >= 70)
            cuenta++;

        cuenta += contarAprobados(nodo.der);
        return cuenta;
    }
}
