
public class Mascota {
    private String nombre;
    private int edad;
    private int salud;
    private int energia;
    private int felicidad;
    private Estado estado;
    
    //constructor
    public Mascota(String nombre){
        this.nombre=nombre;
        this.edad=0;
        this.salud=100;
        this.energia=100;
        this.felicidad=50;
    }
    //metodo para actualizar el estado de la mascota
    public void ActualizarEstado(){
        if (salud <= 0 || energia <= 0 || edad >= 15) {
            estado = Estado.Muerto;
        } else if (felicidad >= 60) {
            estado = Estado.Feliz;
        } else if (felicidad <= 20) {
            estado = Estado.Triste;
        } else if (edad <= 5 && salud <= 20) {
            estado = Estado.Hambriento;
        } else if (edad <= 10 && salud <= 50) {
            estado = Estado.Hambriento;
        } else if (edad > 5 && salud <= 30 && energia <= 30) {
            estado = Estado.Enojado;
        } else if (energia <= 15) {
            estado = Estado.Cansado;
        } else {
            estado = Estado.Neutro;
        }
    }
    public void PrintAtributo(){
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Edad: " + this.edad);
        System.out.println("Salud: " + this.salud);
        System.out.println("Energía: " + this.energia);
        System.out.println("Felicidad: " + this.felicidad);
        System.out.println("Estado: " + this.estado.getStrEstado());
    }

}
