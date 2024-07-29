package sv.edu.udb.www.dwf_silva_manuel.managedBean;



import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import sv.edu.udb.www.dwf_silva_manuel.managedBean.Producto;
import java.io.Serializable;

@ManagedBean(name = "medicamentoBean")
@SessionScoped
public class MedicamentoBean extends ProductoBean implements Serializable {
    // Agrega lógica específica de medicamentos si es necesario
}
