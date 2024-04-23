public abstract class Item {
    private String nombre;
    private int Cantidad;
    private int Id;

    public Item(String nombre, int cantidad, int id) {
        this.Id = id;
        this.nombre = nombre;
        this.Cantidad = cantidad;
    }

    public Item(int cantidadInicial) {
        this.Cantidad = cantidadInicial;
    }

    public int getCantidad() {
        return this.Cantidad;
    }

    public void setCantidad(int cantidad) {
        this.Cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getID(){
        return  Id;
    }

    public void reducirCantidad(){
        Cantidad--;
    }
    abstract void usar(Mascota pet);
}

class Comida extends Item{
    public Comida(String nombre, int cantidad,int id) {
        super(nombre, cantidad, id);
    }

    public void usar(Mascota pet){
        System.out.println("Dando de comer :" + this.getNombre() + "...");
        pet.AumentarEnergia(20);
        pet.AumentarSalud(20);
        reducirCantidad();
    }
}

class Medicina extends Item{
    public Medicina(String nombre, int cantidad,int id) {
        super(nombre, cantidad, id);
    }

    public void usar(Mascota pet){
        System.out.println("Aplicando medicamento " + this.getNombre() + "...");
        pet.AumentarSalud(40);
        reducirCantidad();
    }
}

class Juguete extends Item{
    public Juguete(String nombre, int cantidad,int id) {
        super(nombre, cantidad, id);
    }

    public void usar(Mascota pet){
        System.out.println("Usando Juguete :" + this.getNombre() + "...");
        pet.AumentarFelicidad(30);
        reducirCantidad();
    }
}




