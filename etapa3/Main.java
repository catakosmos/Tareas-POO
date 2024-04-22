import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner Scanner = new Scanner(System.in);
        Mascota Pet=new Mascota("Garfield");
        Inventario Inv=new Inventario();
        Pet.ActualizarEstado();
        Inv.agregarItem(new Juguete("Pelota",4,1));
        Inv.agregarItem(new Comida("Queso",5,2));
        Inv.agregarItem(new Comida("Pan",3,3));
        Inv.agregarItem(new Medicina("Jarabe",4,4));
        while (Pet.EstadoActual() != Estado.Muerto){
            System.out.println("Mascota Virtual");
            Pet.PrintAtributo();
            System.out.println();
            Inv.mostrarInventario();
            System.out.println("Seleccione un elemento del inventario : " );
            int Opcion = Scanner.nextInt();
            if(Opcion==0){
                Pet.Dormir();
                Pet.PasarTiempo();
            }else if(Inv.ObtenerItem(Opcion)==null){
                System.out.println("No queda este item");
            }else{
                Inv.Usaritem(Inv.ObtenerItem(Opcion),Pet);
                Pet.PasarTiempo();
            }


        }
    }
}
