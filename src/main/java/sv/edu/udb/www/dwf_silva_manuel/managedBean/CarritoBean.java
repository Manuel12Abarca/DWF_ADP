package sv.edu.udb.www.dwf_silva_manuel.managedBean;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "carritoBean")
@SessionScoped
public class CarritoBean implements Serializable {
    private List<ProductoEnCarrito> productosEnCarrito;
    private double totalCarrito;

    public CarritoBean() {
        productosEnCarrito = new ArrayList<>();
    }

    public List<ProductoEnCarrito> getProductosEnCarrito() {
        return productosEnCarrito;
    }

    public double getTotalCarrito() {
        calcularTotalCarrito();
        return totalCarrito;
    }

    public void agregarAlCarrito(Producto producto) {
        for (ProductoEnCarrito productoEnCarrito : productosEnCarrito) {
            if (productoEnCarrito.getProducto().equals(producto)) {
                productoEnCarrito.setCantidad(productoEnCarrito.getCantidad() + 1);
                calcularTotalCarrito();
                return;
            }
        }
        productosEnCarrito.add(new ProductoEnCarrito(producto, 1));
        calcularTotalCarrito();
    }

    public void eliminarDelCarrito(ProductoEnCarrito productoEnCarrito) {
        productosEnCarrito.remove(productoEnCarrito);
        calcularTotalCarrito();
    }

    public void aumentarCantidad(ProductoEnCarrito productoEnCarrito) {
        productoEnCarrito.setCantidad(productoEnCarrito.getCantidad() + 1);
        calcularTotalCarrito();
    }

    public void disminuirCantidad(ProductoEnCarrito productoEnCarrito) {
        if (productoEnCarrito.getCantidad() > 1) {
            productoEnCarrito.setCantidad(productoEnCarrito.getCantidad() - 1);
            calcularTotalCarrito();
        }
    }

    private void calcularTotalCarrito() {
        totalCarrito = 0;
        for (ProductoEnCarrito productoEnCarrito : productosEnCarrito) {
            totalCarrito += productoEnCarrito.getTotal();
        }
    }

    public void vaciarCarrito() {
        productosEnCarrito.clear();
        totalCarrito = 0;
    }

    public String procesarPago() {
        // Vaciar el carrito al realizar el pago
        vaciarCarrito();
        return "confirmacionCompra?faces-redirect=true";
    }

    public String seguirComprando() {
        return "index?faces-redirect=true";
    }
}
