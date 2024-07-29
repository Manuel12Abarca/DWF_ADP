package sv.edu.udb.www.dwf_silva_manuel.managedBean;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import java.io.Serializable;
import jakarta.faces.context.FacesContext;
import java.io.IOException;

@ManagedBean(name = "compraBean")
@SessionScoped
public class CompraBean implements Serializable {
    private String nombreTarjeta;
    private String numeroTarjeta;
    private String fechaExpiracion;
    private String codigoSeguridad;

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

    public void confirmarCompra() {
        // Implementa la lógica para confirmar la compra
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("confirmacionCompra.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
