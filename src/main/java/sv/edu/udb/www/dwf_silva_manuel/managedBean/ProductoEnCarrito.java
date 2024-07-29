package sv.edu.udb.www.dwf_silva_manuel.managedBean;

public class ProductoEnCarrito {
    private Producto producto;

    public ProductoEnCarrito(Producto producto) {
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
