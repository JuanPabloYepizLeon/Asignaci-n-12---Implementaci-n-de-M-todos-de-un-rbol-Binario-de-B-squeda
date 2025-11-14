
package package1.asignacion12_arbolesbinariosdebusqueda;

import package1.asignacion12_arbolesbinariosdebusqueda.NodoGenerico;

/**
 *
 * @author E5
 */
public class GestorEstudiantes {
     private ArbolBSTGenerico<Estudiante> arbol;

    public GestorEstudiantes() {
        arbol = new ArbolBSTGenerico<>();
    }

    public void agregarEstudiante(String nombre, int calificacion) {
        Estudiante estudiante = new Estudiante(nombre, calificacion);
        arbol.insertar(estudiante);
        System.out.println("Estudiante agregado: " + estudiante);
    }

    public void mostrarEstudiantes() {
        System.out.println("\n=== Estudiantes ordenados por calificacion ===");
        arbol.inorden();
    }

    public void estudiantesEnRango(int min, int max) {
        System.out.println("\nEstudiantes con calificacion entre " + min + " y " + max + ":");
        estudiantesEnRango(arbol.raiz, min, max);
    }

    private void estudiantesEnRango(NodoGenerico<Estudiante> nodo, int min, int max) {
        if (nodo == null) return;

        int cal = nodo.dato.getCalificacion();

        if (cal >= min)
            estudiantesEnRango(nodo.izq, min, max);

        if (cal >= min && cal <= max)
            System.out.println(nodo.dato);

        if (cal <= max)
            estudiantesEnRango(nodo.der, min, max);
    }

    public double promedioCalificaciones() {
        SumaContador sc = new SumaContador();
        promedio(arbol.raiz, sc);

        if (sc.contador == 0) return 0;
        return (double) sc.suma / sc.contador;
    }

    private void promedio(NodoGenerico<Estudiante> nodo, SumaContador sc) {
        if (nodo == null) return;

        promedio(nodo.izq, sc);
        sc.suma += nodo.dato.getCalificacion();
        sc.contador++;
        promedio(nodo.der, sc);
    }

    private static class SumaContador {
        int suma = 0;
        int contador = 0;
    }

    public Estudiante mejorEstudiante() {
        NodoGenerico<Estudiante> actual = arbol.raiz;

        if (actual == null) return null;

        while (actual.der != null)
            actual = actual.der;

        return actual.dato;
    }

    public int contarAprobados() {
        return contarAprobados(arbol.raiz);
    }

    private int contarAprobados(NodoGenerico<Estudiante> nodo) {
        if (nodo == null) return 0;

        int cuenta = contarAprobados(nodo.izq);

        if (nodo.dato.getCalificacion() >= 70)
            cuenta++;

        cuenta += contarAprobados(nodo.der);
        return cuenta;
    }
}
