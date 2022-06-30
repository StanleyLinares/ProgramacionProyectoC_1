package dao;

import db.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Productos;
import modelo.Ventas;

public class VentasDAO {

    Conexion cn = new Conexion();
    Connection com;
    PreparedStatement stm;
    ResultSet rs;
    Ventas venta;
    private final static String SQL_INSERT = "INSERT INTO ventas (id_producto, cantidad, total_venta) VALUES (?,?,?)";
    private final static String SQL_SELECT = "SELECT id, id_producto, cantidad, total_venta FROM ventas";
    
    public List<Ventas> listar(){
        List<Ventas> ventas = new ArrayList<>();
        try {
            com = cn.getConnection();
            stm = com.prepareStatement(SQL_SELECT);
            rs = stm.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                int idProducto = rs.getInt("id_producto");
                int cantidad = rs.getInt("cantidad");
                double totalVenta = rs.getDouble("total_venta");
                venta = new Ventas(id, idProducto, cantidad, totalVenta);
                ventas.add(venta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return ventas;
    }

    public int generarVenta(Ventas vt) {
        int rpta = 0;
        int stock = 0;
        double precio = 0;
        double tVenta = 0;
        String count = "SELECT COUNT(*) AS contador FROM productos WHERE id= '" + vt.getIdProducto() + "'";
        try {
            com = cn.getConnection();
            stm = com.prepareStatement(count);
            rs = stm.executeQuery();
            ProductosDAO pdao = new ProductosDAO();
            List<Productos> productos = pdao.listar();
            if(productos.size()>(vt.getIdProducto()-1)){
                stock = productos.get(vt.getIdProducto()-1).getStock();
                precio = productos.get(vt.getIdProducto()-1).getPrecio();
            }
            while (rs.next()) {
                rpta = rs.getInt("contador");
            }
            if (rpta != 0 && vt.getCantidad()<=stock) {
                stm = com.prepareStatement(SQL_INSERT);
                stm.setInt(1, vt.getIdProducto());
                stm.setInt(2, vt.getCantidad());
                tVenta = vt.getCantidad()*precio;
                stm.setDouble(3,tVenta);
                stm.executeUpdate();
                this.actualizarStock(vt.getCantidad(),stock,vt.getIdProducto());
                rpta = 1;
            } else {
                rpta = 0;
            }
        } catch (SQLException ex) {
        }
        return rpta;
    }
    
    private void actualizarStock(int cantidad, int stock, int idProducto){
        String SQL_UPDATE = "UPDATE productos SET stock =? WHERE id=?";
        try {
            com = cn.getConnection();
            stm = com.prepareStatement(SQL_UPDATE);
            stm.setInt(1,(stock-cantidad));
            stm.setInt(2, (idProducto));
            stm.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    
}
