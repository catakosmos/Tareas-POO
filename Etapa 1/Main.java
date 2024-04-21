import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Mascota Pet=new Mascota("Garfield");
        Pet.ActualizarEstado();
        System.out.println("Atributos");
        System.out.println("---------");
        Pet.PrintAtributo();
        System.out.println();
    }
}
