package Dao;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.*;
import java.util.Base64;

import Bean.User;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class UserDao {
    public Connection conn = null;
    PreparedStatement pstm = null;
    public UserDao() {

    }

    public User getUser(String username) throws SQLException {
        System.out.println(username);
        if(conn == null){
            conn = ConnectDatabase.getConnectDatabase();
        }
        assert conn != null;
        String query = "SELECT * FROM test.User WHERE username=?";

        pstm = (PreparedStatement) conn.prepareStatement(query);
        pstm.setString(1, username);
        ResultSet rs = pstm.executeQuery();

        User user = new User();
        while (rs.next()) {
            int id = Integer.parseInt(rs.getString("userId"));
            String passwordHash = rs.getString("passwordHash");
            user.setUserId(id);
            user.setUsername(username);
            user.setPasswordHash(passwordHash);
            return user;
        }
        return null;
    }
    public String addUser(String username, String password) throws InvalidKeySpecException, NoSuchAlgorithmException, SQLException {
        String passwordHash = Authentication.encodePassword(password);
        if(conn == null){
            conn = ConnectDatabase.getConnectDatabase();
        }
        assert conn != null;
        String query = "INSERT INTO test.User (username, passwordHash) VALUES(?,?)";

        PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(query);
        pstm.setString(1, username);
        pstm.setString(2, passwordHash);
        pstm.executeUpdate();
        pstm.close();
        conn.close();
        return passwordHash;
    }
    public static void main(String[] args) throws SQLException, InvalidKeySpecException, NoSuchAlgorithmException {
        UserDao userdao = new UserDao();
//        String ph = userdao.addUser("tienhung", "1234567");
//        System.out.println(ph);
        User user1 = userdao.getUser("tienhung");
        String ph = user1.getPasswordHash();
        System.out.println(Authentication.verifyPassword("1234567", ph));
//        User user2 = userdao.getUser("sang");
    }
}
