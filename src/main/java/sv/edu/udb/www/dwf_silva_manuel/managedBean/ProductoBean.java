package sv.edu.udb.www.dwf_silva_manuel.managedBean;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean(name = "productoBean")
@SessionScoped
public class ProductoBean implements Serializable {
    private List<Producto> productos;
    private List<Producto> productosFiltrados;
    private String searchQuery;

    public ProductoBean() {
        productos = new ArrayList<>();
        productos.add(new Producto("Taladro", "Taladro eléctrico de 500W", 50.0, "taladro.jpg"));
        productos.add(new Producto("Martillo", "Martillo de acero forjado", 25.0, "martillo.jpg"));
        productos.add(new Producto("Destornillador", "Juego de destornilladores", 15.0, "desarmadores.jpg"));
        productos.add(new Producto("Cierra", "Cierra manual de 30 cm", 30.0, "cierra.jpg"));
        productos.add(new Producto("Alicate", "Alicate de corte y agarre", 20.0, "alicate.jpg"));
        productos.add(new Producto("Sierra Circular", "Sierra circular de 7 1/4\"", 90.0, "cierracircular.jpg"));
        productos.add(new Producto("Lijadora", "Lijadora orbital de 200W", 40.0, "lijadora.jpg"));
        productos.add(new Producto("Esmeril", "Esmeril angular de 4\"", 60.0, "esmeril.jpg"));
        productos.add(new Producto("Aspiradora", "Aspiradora de taller 1200W", 70.0, "aspiradora.jpg"));
        productos.add(new Producto("Llave Inglesa", "Llave inglesa ajustable de 12\"", 18.0, "llaveinglesa.jpg"));
        productos.add(new Producto("Pincel", "Pincel de cerdas sintéticas de 2\"", 5.0, "broca.jpg"));
        productos.add(new Producto("Martillo de Goma", "Martillo de goma de 24 oz", 15.0, "martillodegoma.jpg"));
        productos.add(new Producto("Cinta Métrica", "Cinta métrica de 5 metros", 10.0, "cintametrica.jpg"));
        productos.add(new Producto("Nivel", "Nivel de burbuja de 24\"", 20.0, "nivel.jpg"));
        productos.add(new Producto("Destornillador Eléctrico", "Destornillador eléctrico recargable", 55.0, "destornilladorE.jpg"));
        productos.add(new Producto("Sierra de Calar", "Sierra de calar con velocidad variable", 65.0, "cierracalar.jpg"));
        productos.add(new Producto("Brocas", "Juego de brocas para metal y madera", 25.0, "brocas.jpg"));
        productos.add(new Producto("Trépano", "Trépano manual para perforaciones pequeñas", 22.0, "teprano.jpg"));
        productos.add(new Producto("Gato Hidráulico", "Gato hidráulico para levantamiento de hasta 2 toneladas", 90.0, "gato.jpg"));
        productos.add(new Producto("Cinta Adhesiva", "Cinta adhesiva transparente de 50mm x 25m", 7.0, "cinta.jpg"));
        productos.add(new Producto("Cúter", "Cúter retráctil con hoja de repuesto", 8.0, "cuter.jpg"));
        productos.add(new Producto("Escuadra", "Escuadra de 90 grados de 12\"", 12.0, "cuadra.jpg"));
        productos.add(new Producto("Pala", "Pala de mano con mango de madera", 30.0, "pala.jpg"));
        productos.add(new Producto("Destornillador de Precisión", "Juego de destornilladores de precisión", 18.0, "destornilladorP.jpg"));
        productos.add(new Producto("Compresora", "Compresora de aire de 2 HP", 120.0, "compresora.jpg"));
        productos.add(new Producto("Carretilla", "Carretilla de jardín de 100L", 40.0, "carretilla.jpg"));
        productos.add(new Producto("Linterna LED", "Linterna LED recargable", 20.0, "linterna.jpg"));
        productos.add(new Producto("Corta Césped", "Corta césped manual de 16\"", 75.0, "cortacesped.jpg"));
        productos.add(new Producto("Raspador", "Raspador de pintura de acero inoxidable", 12.0, "espatula.jpg"));
        productos.add(new Producto("Guantes de Trabajo", "Guantes de trabajo de cuero", 15.0, "guantes.jpg"));
        productos.add(new Producto("Alicate de Presión", "Alicate de presión con ajuste de presión", 25.0, "alicatepresion.jpg"));
        productos.add(new Producto("Juego de Llaves", "Juego de llaves de vaso de 1/4\" y 1/2\"", 40.0, "llaves.jpg"));

        // Inicialmente, todos los productos se muestran
        productosFiltrados = new ArrayList<>(productos);
    }

    // Método para buscar productos basado en la consulta
    public void buscarProductos() {
        if (searchQuery == null || searchQuery.isEmpty()) {
            productosFiltrados = productos; // Mostrar todos los productos
        } else {
            productosFiltrados = productos.stream()
                    .filter(p -> p.getNombre().toLowerCase().contains(searchQuery.toLowerCase()))
                    .collect(Collectors.toList());
        }
    }



    // Getters y Setters
    public List<Producto> getProductosFiltrados() {
        return productosFiltrados;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
