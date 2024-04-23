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
        String archivoCSV = args[0];
        Mascota mascota = null;
        Inventario inventario = new Inventario();
        
        try {Scanner scanner = new Scanner(new File(archivoCSV))){
            boolean primeraLinea = true;

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(","); // Asumimos que el CSV usa comas como separador

                if (primeraLinea) {
                    // La primera línea define el nombre de la mascota
                    mascota = new Mascota(partes[0].trim());
                    primeraLinea = false;
                } else {
                    // Otras líneas representan los elementos del inventario
                    String tipo = partes[0].trim();
                    String nombre = partes[1].trim();
                    int cantidad = Integer.parseInt(partes[2].trim());
                    int id = Integer.parseInt(partes[3].trim());

                    // Crear el objeto adecuado y agregar al inventario
                    if (tipo.equalsIgnoreCase("comida")) {
                        inventario.agregarItem(new Comida(nombre, cantidad, id));
                    } else if (tipo.equalsIgnoreCase("medicina")) {
                        inventario.agregarItem(new Medicina(nombre, cantidad, id));
                    } else if (tipo.equalsIgnoreCase("juguete")) {
                        inventario.agregarItem(new Juguete(nombre, cantidad, id));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + archivoCSV);
            return;
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
                Item item = Inv.ObtenerItem(indice); // Usar el índice correcto
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
