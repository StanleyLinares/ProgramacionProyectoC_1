package dao;

import db.Conexion;
import modelo.Usuarios;
import java.sql.*;

public class LoginDAO {
    int rpta = 0;
    String sql = "";
    Connection com;
    PreparedStatement stm;
    Conexion cn = new Conexion();
    ResultSet rs = null;

    public LoginDAO() {
    }
    
    public int validar(Usuarios usr){
        sql = "SELECT COUNT(id) AS contador FROM usuarios WHERE usuario_generado= '"+usr.getUsuarioGenerado()+"' AND contrasena= '"+usr.getContrasena()+"'";
        try {
            com = cn.getConnection();
            stm = com.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next()){
                rpta=rs.getInt("contador");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return rpta;
    }
    
    public int getId (Usuarios usr){
        sql = "SELECT id FROM usuarios WHERE usuario_generado='"+usr.getUsuarioGenerado()+"'";
        try {
            com = cn.getConnection();
            stm = com.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next()){
                rpta=rs.getInt("id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return rpta;
    }
    
}

