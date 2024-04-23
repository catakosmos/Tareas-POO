import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Asegúrate de que se pase el argumento del archivo CSV
        if (args.length == 0) {
            System.out.println("Por favor, proporciona un archivo CSV como argumento.");
            return;
        }

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(args[0]));
            // Procesar líneas del archivo CSV
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                System.out.println("Línea: " + linea);
                // Procesar la línea del archivo CSV...
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } finally {
            if (scanner != null) {
                scanner.close(); // Cerrar el scanner manualmente
            }
        }

        Mascota Pet=new Mascota("Garfield");
        Inventario Inv=new Inventario();
        Pet.ActualizarEstado();

        Inv.agregarItem(new Juguete("Pelota",4,1));
        Inv.agregarItem(new Comida("Queso",5,2));
        Inv.agregarItem(new Comida("Pan",3,3));
        Inv.agregarItem(new Medicina("Jarabe",4,4));
        
        // Crear un nuevo Scanner para la entrada estándar
        Scanner inputScanner = new Scanner(System.in); 
        
        while (Pet.EstadoActual() != Estado.Muerto){
            System.out.println("Mascota Virtual");
            Pet.PrintAtributo();
            Inv.mostrarInventario();
            
            System.out.println("Seleccione un elemento del inventario (0 para dormir, x para salir): ");
            String opcion = inputScanner.nextLine();

            if (opcion.equals("x")) {
                System.out.println("Fin de la simulación.");
                break; // Salir del bucle
            }
            int indice = -1;
            try {
                indice = Integer.parseInt(opcion);
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida, intente de nuevo.");
                continue;
            }

            if (indice == 0) {
                Pet.Dormir();
                Pet.PasarTiempo();

            }
            else {
                Item item = Inv.ObtenerItem(indice - 1); // Usar el índice correcto
                if (item == null) {
                    System.out.println("El ítem seleccionado no existe o no tiene más cantidad.");
                }
                else{
                    Inv.Usaritem(item, Pet); // Usar el método correcto para usar el ítem
                    Pet.PasarTiempo();
                    }
                }
        }
    }
}
