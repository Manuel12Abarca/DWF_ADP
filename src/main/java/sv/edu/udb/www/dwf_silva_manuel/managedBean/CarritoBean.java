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

    // Getters y Setters
    public List<ProductoEnCarrito> getProductosEnCarrito() {
        return productosEnCarrito;
    }

    public double getTotalCarrito() {
        calcularTotalCarrito();
        return totalCarrito;
    }

    // Agregar producto al carrito
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

    // Eliminar producto del carrito
    public void eliminarDelCarrito(ProductoEnCarrito productoEnCarrito) {
        productosEnCarrito.remove(productoEnCarrito);
        calcularTotalCarrito();
    }

    // Aumentar cantidad de producto
    public void aumentarCantidad(ProductoEnCarrito productoEnCarrito) {
        productoEnCarrito.setCantidad(productoEnCarrito.getCantidad() + 1);
        calcularTotalCarrito();
    }

    // Disminuir cantidad de producto
    public void disminuirCantidad(ProductoEnCarrito productoEnCarrito) {
        if (productoEnCarrito.getCantidad() > 1) {
            productoEnCarrito.setCantidad(productoEnCarrito.getCantidad() - 1);
            calcularTotalCarrito();
        }
    }

    // Calcular el total del carrito
    private void calcularTotalCarrito() {
        totalCarrito = 0;
        for (ProductoEnCarrito productoEnCarrito : productosEnCarrito) {
            totalCarrito += productoEnCarrito.getTotal();
        }
    }

    // Procesar el pago y vaciar el carrito
    public String procesarPago() {
        // Vaciar el carrito
        productosEnCarrito.clear();
        totalCarrito = 0;

        // Retornar el nombre de la página de confirmación de compra
        return "confirmacionCompra?faces-redirect=true";
    }

    // Redirigir a la página de inicio para seguir comprando
    public String seguirComprando() {
        return "index?faces-redirect=true";
    }
}
