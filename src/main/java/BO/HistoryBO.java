package BO;

import Dao.HistoryDao;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

public class HistoryBO {
    HistoryDao historyDao = new HistoryDao();
    public Boolean addUser(int userId, int corpusId) throws SQLException, InvalidKeySpecException, NoSuchAlgorithmException {
       String returnedValue = historyDao.addHistory(userId, corpusId);
       if(returnedValue != null) {
           return true;
       }
       return false;
    }
}
