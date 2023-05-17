package BO;

import Bean.User;
import Dao.Authentication;
import Dao.UserDao;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

public class UserBO {
    UserDao userdao = new UserDao();

    public Boolean login(String username, String password) throws SQLException {
        User user = userdao.getUser(username);
        return Authentication.verifyPassword(password, user.getPasswordHash());
    }

    public Boolean register(String username, String password) throws SQLException, InvalidKeySpecException, NoSuchAlgorithmException {
        userdao.addUser(username, password);
        return true;
    }
}

