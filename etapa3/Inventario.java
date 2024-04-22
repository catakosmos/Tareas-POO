import java.util.ArrayList;
import java.util.Iterator;
public class Inventario {
    private ArrayList<Item> Inv;        // lista dinámica

    public Inventario() {                // constructor inicializa la instancia de inventario con el array vacío de ítems
        this.Inv = new ArrayList<>();
    }
    public void agregarItem(Item item) {        // método para añadir un objeto ítem al array
        this.Inv.add(item);
    }

    public void mostrarInventario() {            // imprime el inventario ID:Nombre - Cantidad
        System.out.println("Inventario:");
        for (Item item : Inv) {
            System.out.println(item.getID() + ": " + item.getNombre() + " - Cantidad: " + item.getCantidad());
        }
    }

    public Item ObtenerItem(int ID){            // busca un ítem con un for loop 
        for (Item item : Inv) {
            if(item.getID() == ID){
                return item;
            }
        }
        return null;                            // si no encuentra ninguno, retorna null
    }
    
    public void eliminarItemPorId(int ID) {        // elimina del inventario todos los ítems con el ID especificado
        items.removeIf(item -> item.getID() == ID);
    } 

    // Método para usar un ítem con una mascota
    public boolean usarItemConMascota (int ID, Mascota mascota){
        Item item = ObtenerItem(ID);
        if (item != null && item.getCantidad() > 0) {
            // usa el ítem basado en su tipo
            if (item instanceof Comida){
                mascota.aumentarSalud(20);
                mascota.aumentarEnergia(20);
            }
            else if (item instanceof Medicina){
                mascota.aumentarSalud(40);
            }
            else if (item instanceof Juguete){
                mascota.aumentarFelicidad(30);
            }
            // disminuir cantidad del item
            item.reducirCantidad(1);

            // eliminar del inventario si la cantidad llega a 0
            if (item.getCantidad()==0){
                eliminarItemPorId(ID);
            }
            return true; // el ítem se usó con éxito
        }
        return false; // no se puede utilizar el ítem
    }
        
    /*
    public void Usaritem(Item item, Mascota Pet){
        if(item == null){
            System.out.println("No queda este item");
        }else{
            item.usar(Pet);
            if(item.getCantidad()==0){
                Inv.remove(item);
            }
        }
    }
    */

}
