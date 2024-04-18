public class Main {
    public static void main(String[] args) {
        MascotaVirtual mascota = new MascotaVirtual("Garfield");
        System.out.println("Mascota Virtual");
        mascota.mostrarAtributos();

        Comida comida = new Comida("Queso", 20, 0);
        mascota.comer(comida);
        mascota.mostrarAtributos();
        
        Juguete juguete = new Juguete("Pelota", 0, 30);
        mascota.jugar(juguete);
        mascota.mostrarAtributos();
    }    
}
