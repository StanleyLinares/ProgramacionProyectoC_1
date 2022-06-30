package dao;

import db.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.LogUsr;

public class LogUsrDAO {
    
    Conexion cn = new Conexion();
    Connection com;
    PreparedStatement stm;
    ResultSet rs;
    private final static String SQL_INSERT = "INSERT INTO log_usr (id_usr, hora_login) VALUES (?,?)";
    private final static String SQL_UPDATE = "UPDATE log_usr SET hora_logout=? WHERE id=?";
    private final static String SQL_SELECT = "SELECT id, id_usr, hora_login, hora_logout FROM log_usr";
    
    public List<LogUsr> listar() {
        List<LogUsr> logUsrs = new ArrayList<>();
        try {
            com = cn.getConnection();
            stm = com.prepareStatement(SQL_SELECT);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int idUsr = rs.getInt("id_usr");
                Object horaLogin = rs.getObject("hora_login");
                Object horaLogout = rs.getObject("hora_logout");
                LogUsr logUsr = new LogUsr(id, idUsr, horaLogin, horaLogout);
                logUsrs.add(logUsr);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return logUsrs;
    }
    
    public void horaLogin (int idUsr){
        try {
            com = cn.getConnection();
            stm = com.prepareStatement(SQL_INSERT);
            stm.setInt(1, idUsr);
            java.util.Date date = new java.util.Date(); 
            java.sql.Timestamp horaLogin = new java.sql.Timestamp(date.getTime());
            stm.setTimestamp(2, horaLogin);
            stm.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    
    public void horaLogout (){
        List<LogUsr> logUsrs = this.listar();
        int posicion = logUsrs.size();
        java.util.Date date = new java.util.Date(); 
        java.sql.Timestamp horaLogout = new java.sql.Timestamp(date.getTime());
        try {
            com = cn.getConnection();
            stm = com.prepareStatement(SQL_UPDATE);
            stm.setTimestamp(1, horaLogout);
            stm.setInt(2, posicion);
            stm.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    
}
