
public class Mascota {
    private String nombre;
    private float edad;
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
        System.out.println("Atributos");
        System.out.println("---------");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Edad: " + this.edad);
        System.out.println("Salud: " + this.salud);
        System.out.println("Energía: " + this.energia);
        System.out.println("Felicidad: " + this.felicidad);
        System.out.println("Estado: " + this.estado.getStrEstado());
        System.out.println();
    }

    public void AumentarFelicidad(int Valor){
        felicidad = felicidad + Valor;
        if(felicidad>100){
            felicidad=100;
        }
    }

    public void AumentarSalud(int Valor){
        salud = salud + Valor;
        if(salud>100){
            salud=100;
        }
    }

    public void AumentarEnergia(int Valor){
        energia += Valor;
        if(energia>100){
            energia=100;
        }
    }

    public void Dormir(){
        System.out.println(nombre + " ha dormido como un tronco");
        this.AumentarEnergia(100);
        this.AumentarFelicidad(15);
        this.AumentarSalud(15);
    }

    public void PasarTiempo(){
        if(edad<=5 && salud <=10){
            felicidad-=20;
            salud -=5;
            energia -=5;

        }else if(edad>5 && edad<=10 && salud<=50){
            felicidad-=20;
            salud -=5;
            energia -=10;
        }else if(edad>10 && salud <=50){
            felicidad-=30;
            salud -=5;
            energia -=20;
        }else{
            felicidad-=5;
            salud -=5;
            energia -=5;
        }
        edad +=0.5;
    }

}
