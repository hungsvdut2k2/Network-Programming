package Dao;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import org.mindrot.jbcrypt.BCrypt;

public class Authentication {
    public static String encodePassword(String password) {
        // Generate a salt
        String salt = BCrypt.gensalt();

        // Hash the password with the salt
        if (salt != null) {
            // Hash the password with the salt
            String hashedPassword = BCrypt.hashpw(password, salt);
            return hashedPassword;
        } else {
            // Handle the error condition appropriately
            throw new IllegalArgumentException("Salt cannot be null");
        }
    }
    public static boolean verifyPassword(String password, String hashedPassword) {
        // Verify the password
        return BCrypt.checkpw(password, hashedPassword);
    }

}
