package package1.asignacion12_arbolesbinariosdebusqueda;

/**
 * @author E5
 */
public class Asignacion12_ArbolesBinariosDeBusqueda {

    public static void main(String[] args) {
        System.out.println("=================================") ;
        System.out.println(" DEMOSTRACION ARBOL BST") ;
        System.out.println("=================================\n") ;
        
        // PARTE 1: Pruebas basicas del BST
        pruebasBST();
        
        // PARTE 2: Sistema de gestion de estudiantes
        pruebaGestorEstudiantes();
         
    }

    private static void pruebasBST() {
        System.out.println("--- PRUEBAS BST BASICO - - -\n") ;

        ArbolBST arbol = new ArbolBST();

        // Insertar valores
        System.out.println("Insertando valores: 50 , 30 , 70 , 20 , 40 , 60 , 80") ;
        int[] valores = {50 , 30 , 70 , 20 , 40 , 60 , 80};
        for (int valor : valores) {
            arbol.insertar(valor);
        }

        // Mostrar recorridos
        System.out.println("\n RECORRIDOS:");
        arbol.inorden();
        arbol.preorden();
        arbol.postorden();

        // Busquedas
        System.out.println("\n BUSQUEDAS:");
        System.out.println("Buscar 40: " + arbol.buscar(40));
        System.out.println("Buscar 100: " + arbol.buscar(100));

        // Informacion del arbol
        System.out.println("\n INFORMACION DEL ARBOL:");
        System.out.println("Altura: " + arbol.altura());
        System.out.println("Total nodos: " + arbol.contarNodos());
        System.out.println("Minimo:" + arbol.encontrarMinimo());    
        System.out.println("Maximo:" + arbol.encontrarMaximo());

        // Eliminaciones
        System.out.println("\n ELIMINACIONES:");
        System.out.println("Eliminando 20 (sin hijos )...");
        arbol.eliminar(20);
        arbol.inorden();

        System.out.println("\n Eliminando 30 (con hijos )...");
        arbol.eliminar(30);
        arbol.inorden();

        System.out.println("\n Eliminando 50 ( raiz )...");
        arbol.eliminar(50);
        arbol.inorden();
    }
    
    private static void pruebaGestorEstudiantes() {
        System.out.println("\n\n- - - SISTEMA GESTOR DE ESTUDIANTES - - -\n");

        GestorEstudiantes gestor = new GestorEstudiantes();

        // Agregar estudiantes
        gestor.agregarEstudiante("Ana Garcia ", 95);
        gestor.agregarEstudiante("Carlos Lopez", 78);
        gestor.agregarEstudiante("Maria Rodriguez", 88);
        gestor.agregarEstudiante("Juan Martinez", 65);
        gestor.agregarEstudiante("Laura Sanchez", 92);
        gestor.agregarEstudiante("Pedro Gomez", 58);
        gestor.agregarEstudiante("Sofia Torres", 85);

        // Mostrar todos
        gestor.mostrarEstudiantes();

        // Estudiantes en rango
        gestor.estudiantesEnRango(80, 95);

        // Estadisticas
        System.out.println("\n ESTADISTICAS:");
        System.out.println("Promedio: " + gestor.promedioCalificaciones());
        System.out.println("Mejor estudiante :" +gestor.mejorEstudiante());
        System.out.println("Aprobados :" +gestor.contarAprobados());
    }
        
}
