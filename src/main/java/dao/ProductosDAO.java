package dao;

import db.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Productos;

public class ProductosDAO {

    Conexion cn = new Conexion();
    Connection com;
    PreparedStatement stm;
    ResultSet rs;
    Productos producto;
    private final static String SQL_INSERT = "INSERT INTO productos (nombre, descripcion, precio, stock) VALUES (?,?,?,?)";
    private final static String SQL_SELECT = "SELECT id, nombre, descripcion, precio, stock FROM productos";
    private final static String SQL_UPDATE = "UPDATE productos SET nombre=?,descripcion=?,precio=?,stock=? WHERE id=?";
    private final static String SQL_UPDATESTOCK = "UPDATE productos SET stock=? WHERE id=?";

    public List<Productos> listar() {
        List<Productos> productos = new ArrayList<>();
        try {
            com = cn.getConnection();
            stm = com.prepareStatement(SQL_SELECT);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                producto = new Productos(id, nombre, descripcion, precio, stock);
                productos.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return productos;
    }

    public void insertarProducto(Productos producto) {
        try {
            com = cn.getConnection();
            stm = com.prepareStatement(SQL_INSERT);
            stm.setString(1, producto.getNombre());
            stm.setString(2, producto.getDescripcion());
            stm.setDouble(3, producto.getPrecio());
            stm.setInt(4, producto.getStock());
            stm.executeUpdate();

        } catch (SQLException ex) {
        }
    }

    public void actualizarStock(Productos producto) {
        try {
            com = cn.getConnection();
            stm = com.prepareStatement(SQL_UPDATESTOCK);
            stm.setInt(1, producto.getStock());
            stm.setInt(2, producto.getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public String obtenerNombre(int idProducto) {
        String nombre = "";
        String sql = "SELECT nombre FROM productos WHERE id = '" + idProducto + "'";
        try {
            com = cn.getConnection();
            stm = com.prepareStatement(SQL_SELECT);
            rs = stm.executeQuery();
            nombre = rs.getString("nombre");            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return nombre;
    }

}
