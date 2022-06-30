package modelo;
public class Ventas {
    private int id;
    private int idProducto;
    private int cantidad;
    private double totalVenta;

    public Ventas(int id, int idProducto, int cantidad, double totalVenta) {
        this.id = id;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.totalVenta = totalVenta;
    }

    public Ventas(int idProducto, int cantidad, double totalVenta) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.totalVenta = totalVenta;
    }

    public Ventas() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    @Override
    public String toString() {
        return "Ventas{" + "id=" + id + ", idProducto=" + idProducto + ", cantidad=" + cantidad + ", totalVenta=" + totalVenta + '}';
    }
    
    
}
