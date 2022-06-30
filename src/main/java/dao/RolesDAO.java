package dao;

import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Roles;
import modelo.Usuarios;

public class RolesDAO {

    int id;
    Integer rol;
    String getIdSql = "";
    String getRolSql = "";
    Connection com;
    PreparedStatement stm;
    Conexion cn = new Conexion();
    ResultSet rs = null;
    private final static String SQL_INSERT = "INSERT INTO roles (id_usr, rol) VALUES (?,?)";

    public RolesDAO() {
    }

    public int asignarRol(Usuarios usr) {
        Integer rol = 3;
        getIdSql = "SELECT  id FROM usuarios WHERE usuario_generado= '" + usr.getUsuarioGenerado() + "'";
        try {
            com = cn.getConnection();
            stm = com.prepareStatement(getIdSql);
            rs = stm.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
            getRolSql = "SELECT rol FROM roles WHERE id_usr= '" + id + "'";
            stm = com.prepareStatement(getRolSql);
            rs = stm.executeQuery();
            while (rs.next()) {
                rol = rs.getInt("rol");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return rol;
    }

    public void nuevoRol(Roles rol) {
        int rpta = 0;
        String sql = "SELECT COUNT(*) AS contador FROM roles WHERE id_usr= '" + rol.getIdUsr() + "'";
        try {
            com = cn.getConnection();
            stm = com.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                rpta = rs.getInt("contador");
            }
            if (rpta == 0) {
                stm = com.prepareStatement(SQL_INSERT);
                stm.setInt(1, rol.getIdUsr());
                stm.setInt(2, rol.getRol());
                stm.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }
}
