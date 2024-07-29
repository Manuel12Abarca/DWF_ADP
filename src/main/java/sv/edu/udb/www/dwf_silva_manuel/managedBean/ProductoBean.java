package sv.edu.udb.www.dwf_silva_manuel.managedBean;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "productoBean")
@SessionScoped
public class ProductoBean implements Serializable {
    private List<Producto> productos;

    public ProductoBean() {
        productos = new ArrayList<>();
        productos.add(new Producto("Aspirina", "Indicada para el alivio del dolor leve a moderado y como antiinflamatorio. No debe ser utilizada en menores de 12 años.", 10.0, "aspirina.jpg"));
        productos.add(new Producto("Ibuprofeno", "Alivia el dolor, reduce la fiebre y combate la inflamación. Indicaciones para adultos y niños mayores de 12 años.", 15.0, "ibu.png"));
        productos.add(new Producto("Paracetamol", "Alivia el dolor leve a moderado y reduce la fiebre. Uso recomendado para adultos y niños mayores de 6 años.", 5.0, "para.jpg"));
        productos.add(new Producto("Omeprazol", "Tratamiento para el alivio de la acidez y otros problemas gástricos. Apto para adultos.", 20.0, "Omeprazol.jpg"));
        productos.add(new Producto("Algodón", "Ideal para uso en curaciones, limpieza y cuidado personal. Hipoalergénico y seguro para toda la familia.", 3.0, "algodon.jpeg"));
        productos.add(new Producto("Vitamina C", "Suplemento alimenticio para reforzar el sistema inmunológico. Recomendado para todas las edades.", 8.0, "vitamina.jpeg"));
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
