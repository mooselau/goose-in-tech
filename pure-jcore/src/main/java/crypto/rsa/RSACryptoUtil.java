package crypto.rsa;

import static crypto.rsa.RSAKeyUtil.getKeyPairFromFile;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


public class RSACryptoUtil {

    private final Cipher cryptoCipher;
    private final KeyPair keyPair;

    public static final String RSA_ALGORITHM = "RSA";

    public RSACryptoUtil() throws NoSuchPaddingException, NoSuchAlgorithmException {
        cryptoCipher = Cipher.getInstance(RSA_ALGORITHM);
        keyPair = getKeyPairFromFile();
        assert keyPair != null;
    }

    /**
     * *************************
     * Encryption & Decryption *
     * *************************
     */
    private void initEncryption() throws InvalidKeyException {
        // NOTE: USE PUBLIC KEY to encrypt message
        cryptoCipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
    }

    private void initDecryption() throws InvalidKeyException {
        // NOTE: USE PRIVATE KEY to decrypt message
        cryptoCipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
    }

    public String encrypt(String secret) throws BadPaddingException, IllegalBlockSizeException,
            InvalidKeyException {
        return encrypt(secret.getBytes());
    }

    private String encrypt(byte[] secretBytes) throws BadPaddingException, IllegalBlockSizeException,
            InvalidKeyException {
        initEncryption();
        byte[] encrypted = cryptoCipher.doFinal(secretBytes);
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public String decrypt(String encryptedSecret)
            throws BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        byte[] encrypted = Base64.getDecoder().decode(encryptedSecret);
        byte[] decrypted = decrypt(encrypted);
        return new String(decrypted, UTF_8);
    }

    private byte[] decrypt(byte[] encryptedBytes)
            throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        initDecryption();
        return cryptoCipher.doFinal(encryptedBytes);
    }

    /**
     * ******************************
     * LOW-LEVEL Signature & Verify *
     * ******************************
     */
    private void initDigitalSignature() throws InvalidKeyException {
        // NOTE: Differently, HERE we use PRIVATE key to sign!
        cryptoCipher.init(Cipher.ENCRYPT_MODE, keyPair.getPrivate());
    }

    private void initVerifySignature() throws InvalidKeyException {
        // NOTE: Differently, HERE we use PUBLIC key to verify sign!
        cryptoCipher.init(Cipher.DECRYPT_MODE, keyPair.getPublic());
    }

    public String sign(String messageHash)
            throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        initDigitalSignature();
        byte[] encrypted = cryptoCipher.doFinal(messageHash.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public boolean verify(String encryptedHash, String messageHash)
            throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        initVerifySignature();
        // received message hash
        byte[] encryptedHashBytes = Base64.getDecoder().decode(encryptedHash);
        byte[] hash = cryptoCipher.doFinal(encryptedHashBytes);
        // self-calculated message hash
        byte[] selfHash = messageHash.getBytes();
        return Arrays.equals(hash, selfHash);
    }

    /**
     * *******************************
     * HIGH-LEVEL Signature & Verify *
     * *******************************
     */
    private Signature signature;
    public static final String RSA_SIGN_ALGORITHM = "SHA256withRSA";

    private void initSignature01() throws InvalidKeyException, NoSuchAlgorithmException {
        signature = Signature.getInstance(RSA_SIGN_ALGORITHM);
        signature.initSign(keyPair.getPrivate());
    }

    private void initVerifySignature01() throws InvalidKeyException, NoSuchAlgorithmException {
        signature = Signature.getInstance(RSA_SIGN_ALGORITHM);
        signature.initVerify(keyPair.getPublic());
    }

    public String sign01(String message) throws SignatureException, NoSuchAlgorithmException, InvalidKeyException {
        initSignature01();
        signature.update(message.getBytes());
        byte[] signBytes = signature.sign();
        return Base64.getEncoder().encodeToString(signBytes);
    }

    public boolean verify01(String message, String sign)
            throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        initVerifySignature01();
        signature.update(message.getBytes());
        byte[] decoded = Base64.getDecoder().decode(sign);
        return signature.verify(decoded);
    }

}
