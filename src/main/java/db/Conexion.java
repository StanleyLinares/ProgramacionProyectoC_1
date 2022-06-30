package db;

import java.sql.*;

public class Conexion {
    Connection com;
    private static final String JDBC_URL = "jdbc:mysql://localhost/bd_login?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "";

    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
        } catch (Exception ex) {
            System.err.println("Error"+ex);
        }
    }
    
    public Connection getConnection(){
        return com;
    }
    
}
