package dao;

import db.Conexion;
import modelo.Usuarios;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuariosDAO {
    Conexion cn = new Conexion();
    Connection com;
    PreparedStatement stm;
    ResultSet rs;
    Usuarios usuario;
    private final static String SQL_INSERT = "INSERT INTO usuarios (nombre, apellidos, contrasena, usuario_generado) VALUES (?,?,?,?)";
    private final static String SQL_SELECT = "SELECT id, nombre, apellidos, contrasena, usuario_generado FROM usuarios";
    private final static String SQL_USER_BY_ID = "SELECT id, nombre, apellidos, usuario_generado, contrasena FROM usuario where id=?";
    private final static String SQL_DELETE = "DELETE from usuario where id=?";
    private final static String SQL_UPDATE = "UPDATE usuarios SET nombre=?,apellidos=?,contrasena=?,usuario_generado=? WHERE id=?";
    
    public List<Usuarios> listar (){
        List<Usuarios> usuarios = new ArrayList<>();
        try {
            com = cn.getConnection();
            stm = com.prepareStatement(SQL_SELECT);
            rs = stm.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String contrasena = rs.getString("contrasena");
                String usuarioGenerado = rs.getString("usuario_generado");
                usuario = new Usuarios(id, nombre, apellidos, contrasena, usuarioGenerado);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return usuarios;
    }
    
    public void insertarUsuario(Usuarios usr){
        try {
            com = cn.getConnection();
            stm = com.prepareStatement(SQL_INSERT);
            stm.setString(1,usr.getNombre());
            stm.setString(2,usr.getApellidos());
            stm.setString(3,usr.getContrasena());
            String usuario_generado = 
                    String.valueOf(usr.getNombre().charAt(0))+
                    String.valueOf(usr.getNombre().charAt(1))+
                    String.valueOf(usr.getNombre().charAt(2))+
                    String.valueOf(usr.getApellidos().charAt(0))+
                    String.valueOf(usr.getApellidos().charAt(1))+
                    String.valueOf(usr.getApellidos().charAt(2))+
                    "@gmail.com";
            stm.setString(4,usuario_generado);
            stm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean actualizarUsuario(Usuarios usr){
        boolean rowUpdate=false;
        try {
            com = cn.getConnection();
            stm = com.prepareStatement(SQL_UPDATE);
            stm.setString(1,usr.getNombre());
            stm.setString(2,usr.getApellidos());
            stm.setString(3,usr.getContrasena());
            String usuario_generado = 
                    String.valueOf(usr.getNombre().charAt(0))+
                    String.valueOf(usr.getNombre().charAt(1))+
                    String.valueOf(usr.getNombre().charAt(2))+
                    String.valueOf(usr.getApellidos().charAt(0))+
                    String.valueOf(usr.getApellidos().charAt(1))+
                    String.valueOf(usr.getApellidos().charAt(2))+
                    "@gmail.com";
            stm.setString(4,usuario_generado);
            stm.setString(5,String.valueOf(usr.getId()));
            rowUpdate = stm.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowUpdate;
    }
    
    public Usuarios seleccionarPorId(int id){
        Usuarios usr = null;
        try {
            com = cn.getConnection();
            stm = com.prepareStatement(SQL_USER_BY_ID);
            rs = stm.executeQuery();
            while(rs.next()){
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String contrasena = rs.getString("contrasena");
                String usuarioGenerado = rs.getString("usuario_generado");
                usr = new Usuarios(id, nombre, apellidos, contrasena, usuarioGenerado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return usr;
    }

}