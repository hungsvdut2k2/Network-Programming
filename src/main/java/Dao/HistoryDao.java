package Dao;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HistoryDao {
    public Connection conn = null;
    PreparedStatement pstm = null;
    public String addHistory(int userId, int corpusId) throws InvalidKeySpecException, NoSuchAlgorithmException, SQLException {
        if(conn == null){
            conn = ConnectDatabase.getConnectDatabase();
        }
        assert conn != null;
        String query = "INSERT INTO test.history (userId, corpusId) VALUES(?,?)";

        pstm = (PreparedStatement) conn.prepareStatement(query);
        pstm.setInt(1, userId);
        pstm.setInt(2, corpusId);
        pstm.executeUpdate();
        pstm.close();
        conn.close();
        return "OK";
    }

    public static void main(String[] args) throws SQLException, InvalidKeySpecException, NoSuchAlgorithmException {
        HistoryDao historyDao = new HistoryDao();
        System.out.println(historyDao.addHistory(1, 506));
    }
}
