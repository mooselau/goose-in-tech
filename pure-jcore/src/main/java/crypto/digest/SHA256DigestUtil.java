package crypto.digest;

import static java.nio.charset.StandardCharsets.UTF_8;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class SHA256DigestUtil {

    private MessageDigest messageDigest;
    private static final String SHA256_ALGORITHM = "SHA-256";

    public SHA256DigestUtil() throws NoSuchAlgorithmException {
        messageDigest = MessageDigest.getInstance(SHA256_ALGORITHM);
    }

    public String digest(String message) {
        byte[] messageBytes = message.getBytes(UTF_8);
        byte[] messageHashBytes = messageDigest.digest(messageBytes);
        return new String(messageHashBytes, UTF_8);
    }
}
