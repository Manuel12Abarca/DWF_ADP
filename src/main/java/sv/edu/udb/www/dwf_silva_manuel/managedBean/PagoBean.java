package sv.edu.udb.www.dwf_silva_manuel.managedBean;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class PagoBean {

    public String realizarPago() {
        // Lógica para procesar el pago
        // Si el pago es exitoso, retornar "confirmacionCompra"
        return "confirmacionCompra";
    }
}

