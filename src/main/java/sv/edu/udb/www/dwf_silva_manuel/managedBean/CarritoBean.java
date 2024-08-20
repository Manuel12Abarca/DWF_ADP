package sv.edu.udb.www.dwf_silva_manuel.managedBean;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import sv.edu.udb.www.dwf_silva_manuel.entity.Producto;
import sv.edu.udb.www.dwf_silva_manuel.managedBean.ProductoEnCarrito;

@ManagedBean(name = "carritoBean")
@SessionScoped
public class CarritoBean implements Serializable {
    private List<ProductoEnCarrito> productosEnCarrito;

    public CarritoBean() {
        productosEnCarrito = new ArrayList<>();
    }

    public List<ProductoEnCarrito> getProductosEnCarrito() {
        return productosEnCarrito;
    }

    public void agregarAlCarrito(Producto producto) {
        for (ProductoEnCarrito item : productosEnCarrito) {
            if (item.getProducto().equals(producto)) {
                item.setCantidad(item.getCantidad() + 1);
                return;
            }
        }
        productosEnCarrito.add(new ProductoEnCarrito(producto, 1));
    }

    public void eliminarDelCarrito(ProductoEnCarrito productoEnCarrito) {
        productosEnCarrito.remove(productoEnCarrito);
    }

    public double getTotalCarrito() {
        double total = 0.0;
        for (ProductoEnCarrito item : productosEnCarrito) {
            total += item.getTotal();
        }
        return total;
    }

    public String procesarPago() {
        // Implementar lógica para procesar el pago
        return "detallesPago"; // Nombre de la página de pago
    }

    public String seguirComprando() {
        return "index"; // Nombre de la página de inicio
    }
}
