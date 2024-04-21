import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Mascota Pet=new Mascota("Garfield");
        Pet.ActualizarEstado();
        System.out.println("Mascota Virtual");
        Pet.PrintAtributo();
        System.out.println();

        Comida Queso=new Comida("Queso",1,1);
        Medicina Jarabe=new Medicina("Jarabe",1,2);
        Juguete Pelota=new Juguete("Pelota",1,3);

        Queso.usar(Pet);
        Pet.ActualizarEstado();
        Pet.PrintAtributo();

        Jarabe.usar(Pet);
        Pet.ActualizarEstado();
        Pet.PrintAtributo();

        Pelota.usar(Pet);
        Pet.ActualizarEstado();
        Pet.PrintAtributo();



    }
}
