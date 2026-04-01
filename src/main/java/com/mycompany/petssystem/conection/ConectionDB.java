package com.mycompany.petssystem.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionDB {
    
    //atributos
    
    private static final String USER;
    private static final String PASSWORD;
    private static final String DATABASE;
    private static final String PORT;
    private static final String SERVER;
    private static final String URL;
    
    //Objeto para conexion
    private Connection con;
    
    static{
        USER = "root";
        PASSWORD = "";
        DATABASE = "pets_poo";
        PORT = "3306";
        SERVER = "localhost";
        URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DATABASE;
    }
    
    //metodos de orden
    
    private static Connection getDbConection() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASSWORD);
        
    }
    
    public static Connection getConection()throws SQLException{
        return getDbConection();
    }
    
    
}
