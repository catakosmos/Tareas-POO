import java.util.ArrayList;
import java.util.Iterator;

public class Inventario {
    private ArrayList<Item> items;

    public Inventario() {
        this.items = new ArrayList<>();
    }

    public void agregarItem(Item item) {
        this.items.add(item);
    }

    public Item obtenerItemPorId(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void eliminarItemPorId(int id) {
        items.removeIf(item -> item.getId() == id);
    }

    public void mostrarInventario() {
        System.out.println("Acciones");
        System.out.println("--------");
        System.out.println("0: Dormir");
        int index = 1;
        for (Item item : items) {
            System.out.println(index + ": " + item.getNombre() + ", cantidad " + item.getCantidad());
            index++;
        }
    }
}
