public class Main {
    public static void main(String[] args) {
        System.out.println("=== TECNIHOGAR - SISTEMA DE GESTION DE ORDENES ===");
        
        // Crear ordenes de prueba polimorficas
        OrdenServicio diag = new Diagnostico("ORD-01", "Juan Perez", "Zona 10", 1.0, Zona.METROPOLITANA);
        OrdenServicio inst = new Instalacion("ORD-02", "Maria Lopez", "Carretera a El Salvador", 2.5, Zona.PERIFERICA, 4);
        OrdenServicio ac = new MantenimientoAC("ORD-03", "Carlos Gomez", "Zona 14", 2.0, Zona.METROPOLITANA, 12000);

        System.out.println("Costo Diagnostico: Q" + diag.calcularCostoBase());
        System.out.println("Costo Instalacion: Q" + inst.calcularCostoBase());
        System.out.println("Costo Mantenimiento A/C: Q" + ac.calcularCostoBase());
        
        System.out.println("\nPruebas ejecutadas con exito.");
    }
}