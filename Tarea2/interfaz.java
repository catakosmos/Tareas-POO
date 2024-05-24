import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interfaz extends JFrame {

    private Mascota mascota;
    private JProgressBar saludBar;
    private JProgressBar energiaBar;
    private JProgressBar felicidadBar;
    private JLabel estadoLabel;
    private JLabel nombreLabel;
    private JLabel edadLabel;
    private JLabel mascotaLabel;
    // Componentes del inventario
    private DefaultTableModel inventarioTableModel;
    private JTable inventarioTable;
    // Inventario
    private Inventario inventario;

    public interfaz() {
        super("M45C0T4");

        // Crear una nueva mascota
        mascota = new Mascota("Garfield");
        inventario = new Inventario();

        // Configurar las barras de progreso para mostrar la salud, energía y felicidad
        saludBar = new JProgressBar(0, 100);
        saludBar.setStringPainted(true);
        energiaBar = new JProgressBar(0, 100);
        energiaBar.setStringPainted(true);
        felicidadBar = new JProgressBar(0, 100);
        felicidadBar.setStringPainted(true);

        // Etiquetas para mostrar el nombre, la edad y el estado de la mascota
        nombreLabel = new JLabel("Nombre: " + mascota.getNombre());
        edadLabel = new JLabel("Edad: " + mascota.getEdad());
        estadoLabel = new JLabel("Estado: " + mascota.EstadoActual());

        // Crear un JLabel para la imagen de la mascota
        mascotaLabel = new JLabel();
        ImageIcon mascotaIcon = new ImageIcon("mascota.png");
        mascotaLabel.setIcon(mascotaIcon);

        // Configurar la tabla del inventario
        String[] columnas = {"Alimentos", "Medicina", "Juguetes"};
        inventarioTableModel = new DefaultTableModel(columnas, 0);
        inventarioTable = new JTable(inventarioTableModel);

        // Crear el panel de estadísticas
        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new GridLayout(0, 2));
        statsPanel.add(nombreLabel);
        statsPanel.add(edadLabel);
        statsPanel.add(new JLabel("Salud:"));
        statsPanel.add(saludBar);
        statsPanel.add(new JLabel("Energía:"));
        statsPanel.add(energiaBar);
        statsPanel.add(new JLabel("Felicidad:"));
        statsPanel.add(felicidadBar);
        statsPanel.add(estadoLabel);

        // Panel del inventario
        JPanel inventoryPanel = new JPanel(new BorderLayout());
        inventoryPanel.add(new JScrollPane(inventarioTable), BorderLayout.CENTER);

        // Crear el panel principal
        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("background.jpg"); // Reemplaza con la ruta a tu imagen de fondo
                g.drawImage(background.getImage(), 0, 0, null);
            }
        };

        // Agregar el panel de estadísticas y la imagen de la mascota al panel principal
        mainPanel.add(statsPanel, BorderLayout.WEST);
        mainPanel.add(inventoryPanel, BorderLayout.SOUTH);
        mainPanel.add(mascotaLabel, BorderLayout.CENTER);

        // Agregar el panel principal a la ventana
        add(mainPanel);

        // Establecer el tamaño y la visibilidad de la ventana
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Actualizar la interfaz de usuario periódicamente para reflejar los cambios en la mascota
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarInterfaz();
            }
        });
        timer.start();
    }

    // Método para agregar un elemento al inventario
    public void agregarAlInventario(Item item) {
        inventario.agregarItem(item);
        actualizarInventario();
    }
    // Método para actualizar la tabla del inventario
    private void actualizarInventario() {
        inventarioTableModel.setRowCount(0); // Limpiar la tabla
        for (Item item : inventario.getInventario()) {
            Object[] rowData = {item.getNombre(), item.getCantidad()};
            inventarioTableModel.addRow(rowData);
        }
    }

    private void actualizarInterfaz() {
        // Actualizar las barras de progreso con los valores actuales de la mascota
        saludBar.setValue(mascota.getSalud());
        energiaBar.setValue(mascota.getEnergia());
        felicidadBar.setValue(mascota.getFelicidad());

        // Actualizar las etiquetas
        nombreLabel.setText("Nombre: " + mascota.getNombre());
        edadLabel.setText("Edad: " + mascota.getEdad());
        estadoLabel.setText("Estado: " + mascota.EstadoActual());

        // Cambiar la imagen de la mascota según el estado
        Estado estado = mascota.EstadoActual();
        String imagenPath = "";

        switch (estado) {
            case Feliz:
                imagenPath = "feliz.png";
                break;
            case Triste:
                imagenPath = "triste.png";
                break;
            case Hambriento:
                imagenPath = "hambriento.png";
                break;
            case Enojado:
                imagenPath = "enojado.png";
                break;
            case Cansado:
                imagenPath = "cansado.png";
                break;
            case Muerto:
                imagenPath = "muerto.png";
                break;
            default:
                imagenPath = "mascota.png";
                break;
        }

        ImageIcon mascotaIcon = new ImageIcon(imagenPath);
        mascotaLabel.setIcon(mascotaIcon);
    }

    public static void main(String[] args) {
        // Ejecutar la aplicación
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new interfaz();
            }
        });
    }
