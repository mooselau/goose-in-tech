package crypto.aes;

import static crypto.aes.AESKeyUtil.IV_LENGTH;
import static crypto.aes.AESKeyUtil.SALT_LENGTH;
import static crypto.aes.AESKeyUtil.generateIv;
import static crypto.aes.AESKeyUtil.generateKeyFromPassword;
import static crypto.aes.AESKeyUtil.randomSalt;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;


/**
 * AES Algorithm: Text + Secret Key => Cipher => Cipher Text
 * Documentation: https://www.baeldung.com/java-aes-encryption-decryption
 */
public class AESCryptoUtil {

    public static final String ALGORITHM = "AES/CBC/PKCS5Padding";

    private Cipher aesCipher;

    public AESCryptoUtil() throws NoSuchPaddingException, NoSuchAlgorithmException {
        aesCipher = Cipher.getInstance(ALGORITHM);
    }

    private void initEncryption(SecretKey secretKey, IvParameterSpec iv)
            throws InvalidKeyException, InvalidAlgorithmParameterException {
        aesCipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
    }

    private void initDecryption(SecretKey secretKey, IvParameterSpec iv)
            throws InvalidKeyException, InvalidAlgorithmParameterException {
        aesCipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
    }

    public String encrypt(String secretMessage, String password)
            throws NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException,
            IllegalBlockSizeException, InvalidAlgorithmParameterException, InvalidKeyException {
        // prepare parameters
        String salt = randomSalt();
        byte[] iv = generateIv();
        SecretKey secretKey = generateKeyFromPassword(password, salt);
        initEncryption(secretKey, new IvParameterSpec(iv));
        // encrypt
        byte[] cipherText = aesCipher.doFinal(secretMessage.getBytes());
        // adding iv, salt
        byte[] finalCipherBytes = ByteBuffer.allocate(cipherText.length + iv.length + salt.getBytes().length)
                .put(iv).put(salt.getBytes()).put(cipherText).array();
        return HexBin.encode(finalCipherBytes);
        // return Base64.getEncoder().encodeToString(finalCipherBytes);
    }

    public String decrypt(String encryptedMessage, String password) throws InvalidAlgorithmParameterException,
            InvalidKeyException, InvalidKeySpecException, NoSuchAlgorithmException, BadPaddingException,
            IllegalBlockSizeException {
        // prepare parameters
        // byte[] decoded = Base64.getDecoder().decode(encryptedMessage);
        byte[] decoded = HexBin.decode(encryptedMessage);
        ByteBuffer bb = ByteBuffer.wrap(decoded);
        // getting iv, salt from bytes
        byte[] iv = new byte[IV_LENGTH];
        bb.get(iv);
        byte[] saltBytes = new byte[SALT_LENGTH];
        bb.get(saltBytes);
        String salt = new String(saltBytes);
        byte[] encrypted = new byte[bb.remaining()];
        bb.get(encrypted);
        SecretKey secretKey = generateKeyFromPassword(password, salt);
        initDecryption(secretKey, new IvParameterSpec(iv));
        // decrypt
        byte[] decrypted = aesCipher.doFinal(encrypted);
        return new String(decrypted, UTF_8);
    }

}
