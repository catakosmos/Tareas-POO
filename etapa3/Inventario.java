import java.util.ArrayList;
public class Inventario {
    private ArrayList<Item> Inv;

    public Inventario() {
        Inv = new ArrayList<>();
    }
    public void agregarItem(Item item) {
        Inv.add(item);
    }

    public void mostrarInventario() {
        System.out.println("Inventario:");
        for (Item item : Inv) {
            System.out.println(item.getID() + ". " + item.getNombre() + " - Cantidad: " + item.getCantidad());
        }
    }

    public Item ObtenerItem(int ID){
        for (Item item : Inv) {
            if(item.getID() == ID){
                return item;
            }
        }
        return null;
    }

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


}