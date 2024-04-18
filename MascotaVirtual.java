public class MascotaVirtual {
    // Atributos
    private String nombre;
    private double edad;
    private int salud;
    private int energia;
    private int felicidad;
    private Estado estado;

    // Constructor
    public MascotaVirtual(String nombre) {
        this.nombre = nombre;
        this.edad = 0;                  
        this.salud = 100;
        this.energia = 100;
        this.felicidad = 100;
        this.estado = Estado.NEUTRAL;   // Podría ser normal
    }

    // Métodos para obtener y modificar los atributos
    public String getNombre() {
        return nombre;
    }

    public double getEdad() {
        return edad;
    }

    public int getSalud() {
        return salud;
    }

    public int getEnergia() {
        return energia;
    }

    public int getFelicidad() {
        return felicidad;
    }

    public Estado getEstado() {
        return estado;
    }

    // Método para mostrar atributos

    public void mostrarAtributos() {
        System.out.println("Atributos");
        System.out.println("---------");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Salud: " + salud);
        System.out.println("Energía: " + energia);
        System.out.println("Felicidad: " + felicidad);
        System.out.println("Estado: " + estado.getDescripcion());
    }

    // Método para simular el paso del tiempo
    public void pasarTiempo() {
        edad += 0.5;
        salud -= 5;
        energia -= 5;
        felicidad -= 5;
        
        // Actualizar el estado
        actualizarEstado();
    }

    // Método para actualizar el estado de la mascota
    private void actualizarEstado() {
    // Inicializar el estado como neutro por defecto
    Estado nuevoEstado = Estado.NEUTRAL;

    // Verificar las condiciones para cada estado
    if (salud <= 0 || energia <= 0 || edad >= 15) {
        nuevoEstado = Estado.MUERTO;
    } else if (edad > 5 && salud <= 30 && energia <= 30) {
        nuevoEstado = Estado.ENOJADO;
    } else if (energia <= 15) {
        nuevoEstado = Estado.CANSADO;
    } else if (felicidad <= 20) {
        nuevoEstado = Estado.TRISTE;
    } else if (felicidad >= 60) {
        nuevoEstado = Estado.FELIZ;
    } else if (salud <= 20 && edad <= 5) {
        nuevoEstado = Estado.HAMBRIENTO;
    }
    // Actualizar el estado de la mascota
    estado = nuevoEstado;
}

    // Método para dormir
    public void dormir() {
        energia = 100;
        salud += 15;
        felicidad += 15;

        // Asegurarse de que los valores no superen 100
        if (salud > 100)
            salud = 100;
        if (felicidad > 100)
            felicidad = 100;
        
        actualizarEstado();
    }

    // Método para comer
    public void comer(Comida comida) {
    // Incrementar la salud y la energía de la mascota según la comida
    salud += comida.getSaludAumento();
    if (salud > 100) {
        salud = 100; 
    }
    energia += comida.getEnergiaAumento();
    if (energia > 100) {
        energia = 100;
    }

    actualizarEstado();
}

    // Método para que jugar
    public void jugar(Juguete juguete) {
    // Incrementar la felicidad de la mascota según el juguete
    felicidad += juguete.getFelicidadAumento();
    if (felicidad > 100) {
        felicidad = 100; 
    }
    // Actualizar el estado de la mascota después de jugar
    actualizarEstado();
}

}
/* 
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
*/
