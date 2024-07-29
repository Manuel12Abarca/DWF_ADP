package sv.edu.udb.www.dwf_silva_manuel.managedBean;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.faces.context.FacesContext;
import java.io.IOException;

@ManagedBean(name = "carritoBean")
@SessionScoped
public class CarritoBean implements Serializable {
    private List<ProductoEnCarrito> productosEnCarrito;
    private double totalCarrito;
    private double totalCarritoPrePago; // Para mantener el total antes del pago

    public CarritoBean() {
        productosEnCarrito = new ArrayList<>();
        totalCarrito = 0.0;
        totalCarritoPrePago = 0.0;
    }

    public List<ProductoEnCarrito> getProductosEnCarrito() {
        return productosEnCarrito;
    }

    public void agregarAlCarrito(Producto producto) {
        productosEnCarrito.add(new ProductoEnCarrito(producto));
        recalcularTotalCarrito();
    }

    public void eliminarDelCarrito(ProductoEnCarrito productoEnCarrito) {
        productosEnCarrito.remove(productoEnCarrito);
        recalcularTotalCarrito();
    }

    private void recalcularTotalCarrito() {
        totalCarrito = 0.0;
        for (ProductoEnCarrito item : productosEnCarrito) {
            totalCarrito += item.getProducto().getPrecio();
        }
    }

    public void procesarPago() {
        try {
            // Calcular el total antes de limpiar el carrito
            totalCarritoPrePago = totalCarrito;

            // Limpiar la lista de productos en el carrito
            productosEnCarrito.clear();
            recalcularTotalCarrito(); // Reinicializa el total del carrito a 0

            // Redirigir a la página de confirmación
            FacesContext.getCurrentInstance().getExternalContext().redirect("registroCompra.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void seguirComprando() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getTotalCarrito() {
        // Devuelve el total calculado antes del pago si la página actual es registroCompra.xhtml
        String currentPage = FacesContext.getCurrentInstance().getViewRoot().getViewId();
        if (currentPage != null && currentPage.contains("registroCompra.xhtml")) {
            return totalCarritoPrePago;
        }
        return totalCarrito;
    }

    public void setTotalCarrito(double totalCarrito) {
        this.totalCarrito = totalCarrito;
    }
}
