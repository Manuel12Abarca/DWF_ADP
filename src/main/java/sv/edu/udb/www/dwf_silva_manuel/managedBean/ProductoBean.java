package sv.edu.udb.www.dwf_silva_manuel.managedBean;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import sv.edu.udb.www.dwf_silva_manuel.entity.Producto;

@ManagedBean(name = "productoBean")
@SessionScoped
public class ProductoBean implements Serializable {
    private List<Producto> productos;

    public ProductoBean() {
        productos = new ArrayList<>();
        productos.add(new Producto("Taladro", "Taladro eléctrico de 500W", 50.0, "taladro.jpg"));
        productos.add(new Producto("Martillo", "Martillo de acero forjado", 25.0, "martillo.jpg"));
        productos.add(new Producto("Destornillador", "Juego de destornilladores", 15.0, "desarmadores.jpg"));
        productos.add(new Producto("Cierra", "Cierra manual de 30 cm", 30.0, "cierra.jpg"));
        productos.add(new Producto("Alicate", "Alicate de corte y agarre", 20.0, "alicate.jpg"));
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
