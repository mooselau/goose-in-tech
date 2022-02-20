package crypto.aes;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.lang3.RandomStringUtils;


public class AESKeyUtil {

    public static final int IV_LENGTH = 16;
    public static final int SALT_LENGTH = 8;
    private static final String PBKDF2 = "PBKDF2WithHmacSHA256";

    public static SecretKey generateKeyFromPassword(String password, String salt) throws NoSuchAlgorithmException,
            InvalidKeySpecException {
        // Use PBKDF2 to generate Key based on given password
        SecretKeyFactory factory = SecretKeyFactory.getInstance(PBKDF2);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
        return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
    }

    public static String randomSalt() {
        return RandomStringUtils.random(SALT_LENGTH, true, true);
    }

    public static void main(String[] args) {
        System.out.println(RandomStringUtils.random(8, true, true));
    }

    public static byte[] generateIv() {
        byte[] iv = new byte[IV_LENGTH];
        new SecureRandom().nextBytes(iv);
        return iv;
    }
}
