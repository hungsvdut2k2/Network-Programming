package Dao;

import java.sql.Connection;
import java.sql.Statement;
import Bean.User;

public class UserDao {
    public Connection conn = null;
    public Statement stmt = null;

    public User getUser(String username, String password){
        if(conn == null){
            conn = ConnectDatabase.getConnectDatabase();
        }
        if(conn != null){
            return "Ok"
        }
        return "Not ok";
    }
}
