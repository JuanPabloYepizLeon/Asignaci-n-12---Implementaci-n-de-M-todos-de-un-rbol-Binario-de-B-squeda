
package package1.asignacion12_arbolesbinariosdebusqueda;

/**
 * 
 * @author E5
 */
public class Estudiante implements Comparable<Estudiante>{

    private String nombre;
    private int calificacion;
    
    
    public Estudiante(String nombre, int calificacion){
        if(calificacion < 0 || calificacion > 100){
        throw new IllegalArgumentException("Calificacion debe estar entre o y 100");
    
        }
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return nombre + ": " + calificacion;
    }
    
    
    
    
    
    
    @Override
    public int compareTo(Estudiante otro) {
        return Integer.compare(this.calificacion, otro.calificacion);
    }

    int getCalificacion() {
        return calificacion;
    }
    
}
