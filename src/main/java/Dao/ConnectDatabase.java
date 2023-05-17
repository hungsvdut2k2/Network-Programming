package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabase {
    public static Connection getConnectDatabase() {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(getConnectDatabase());
    }
}
