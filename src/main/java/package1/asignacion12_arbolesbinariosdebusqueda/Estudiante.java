
package package1.asignacion12_arbolesbinariosdebusqueda;

/**
 * La clase en donde se implementan tanto el nombre como la calificacion 
 * del estudiante para que se ordene en el arbol de busqueda
 * @author E5
 */
public class Estudiante implements Comparable<Estudiante>{

    /**
     * Nombre del estudiante
     */
    private String nombre;
    /**
     * Calificacion del estudiante
     */
    private int calificacion;
    
    
    /**
     * El contructor para validar la calificacion encontrada dentro del rango
     * @param nombre del estudiante
     * @param calificacion del estudiante
     */
    public Estudiante(String nombre, int calificacion){
        if(calificacion < 0 || calificacion > 100){
        throw new IllegalArgumentException("Calificacion debe estar entre o y 100");
    
        }
        this.nombre = nombre;
        this.calificacion = calificacion;
    }
    
    /**
     * Representacion en formato texto del estudiante
     * @return nombre y calificacion del estudiante
     */
    @Override
    public String toString() {
        return nombre + ": " + calificacion;
    }    
    /**
     * Los estudiantes se comparan por su calificacion
     * @param otro estudiante a comparar
     * @return el entero que nos indica el orden
     */
    @Override
    public int compareTo(Estudiante otro) {
        return Integer.compare(this.calificacion, otro.calificacion);
    }
    
    /**
     * Obtenemos
     * @return la calificacion del estudiante
     */
    int getCalificacion() {
        return calificacion;    
    }
    
}
