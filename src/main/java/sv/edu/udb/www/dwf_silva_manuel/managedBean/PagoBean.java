package sv.edu.udb.www.dwf_silva_manuel.managedBean;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import java.io.Serializable;
import jakarta.faces.context.FacesContext;
import jakarta.faces.application.NavigationHandler;

@ManagedBean(name = "pagoBean")
@ViewScoped
public class PagoBean implements Serializable {
    private String nombreTarjeta;
    private String numeroTarjeta;
    private String fechaExpiracion;
    private String codigoSeguridad;

    // Inyecta el carritoBean
    private CarritoBean carritoBean;

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public String realizarPago() {
        // Implementar lógica para procesar el pago

        // Vaciar el carrito después de realizar el pago
        carritoBean.vaciarCarrito();

        // Redirigir a la página de confirmación de compra
        FacesContext context = FacesContext.getCurrentInstance();
        NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
        navigationHandler.handleNavigation(context, null, "confirmacionCompra?faces-redirect=true");

        return null; // No redirige automáticamente aquí, ya que se maneja la redirección en el NavigationHandler
    }

    public String cancelar() {
        // Redirigir a la página de inicio
        FacesContext context = FacesContext.getCurrentInstance();
        NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
        navigationHandler.handleNavigation(context, null, "index?faces-redirect=true");

        return null; // No redirige automáticamente aquí, ya que se maneja la redirección en el NavigationHandler
    }
}
