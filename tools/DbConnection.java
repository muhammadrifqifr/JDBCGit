package tools;

import java.sql.*;
import java.sql.DriverManager; // DriverManager = sebuah class yang mengelola driver
import java.sql.Connection;    // Connection = interface yang menyediakan method untuk menghubungi db
                              
public class DbConnection {
    private Connection con;
        public Connection getConnection(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // register driver yang akan digunakan
                this.con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_jdbctest", "root", "amartekrifqi");
            } catch (Exception e){
                System.out.println("Error + " + e.getMessage());
            }
            return con;    
        }
}
