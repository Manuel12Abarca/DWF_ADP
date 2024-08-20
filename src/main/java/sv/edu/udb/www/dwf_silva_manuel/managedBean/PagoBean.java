package sv.edu.udb.www.dwf_silva_manuel.managedBean;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import java.io.Serializable;
import jakarta.inject.Inject;

@ManagedBean(name = "pagoBean")
@ViewScoped
public class PagoBean implements Serializable {
    private String nombreTarjeta;
    private String numeroTarjeta;
    private String fechaExpiracion;
    private String codigoSeguridad;

    @Inject
    private CarritoBean carritoBean; // Inyecta el CarritoBean

    // Getters y Setters
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

    // Método para realizar el pago
    public String realizarPago() {
        // Validar que los campos no sean nulos
        if (nombreTarjeta == null || numeroTarjeta == null || fechaExpiracion == null || codigoSeguridad == null) {
            // Redirigir a una página de error si algún campo es nulo
            return "error?faces-redirect=true";
        }

        // Procesar el pago (lógica aquí)

        // Vaciar el carrito
        carritoBean.procesarPago();

        // Redirigir a la página de confirmación de compra
        return "confirmacionCompra?faces-redirect=true";
    }
}
