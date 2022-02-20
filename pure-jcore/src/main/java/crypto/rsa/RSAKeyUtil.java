package crypto.rsa;

import static crypto.rsa.RSACryptoUtil.RSA_ALGORITHM;
import static utils.FileIOUtil.outputToFile;
import static utils.FileIOUtil.readFromFile;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


public class RSAKeyUtil {

    private static final String KEYFILE_PATH = "./purejava/src/main/resources/";

    private static final String PRIVATE_KEY_FILE_SELF_MAKE = "private.key";
    private static final String PRIVATE_KEY_FILE_FROM_OUTSIDE = "private_key.der";
    private static final String PUBLIC_KEY_FILE_SELF_MAKE = "public.key";
    private static final String PUBLIC_KEY_FILE_FROM_OUTSIDE = "public_key.der";

    // switch to use self make keys or keys from outside
    private static final String PRIVATE_KEY_FILE = PRIVATE_KEY_FILE_FROM_OUTSIDE;
    private static final String PUBLIC_KEY_FILE = PUBLIC_KEY_FILE_FROM_OUTSIDE;

    public static KeyPair getKeyPairFromFile() {
        try {
            // init KeyFactory
            KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
            // read Public Key
            byte[] pubKeyBytes = readFromFile(KEYFILE_PATH + PUBLIC_KEY_FILE);
            assert pubKeyBytes != null;
            /* X509EncodedKeySpec is for Public Key */
            EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(pubKeyBytes);
            PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
            // read Private Key
            byte[] priKeyBytes = readFromFile(KEYFILE_PATH + PRIVATE_KEY_FILE);
            assert priKeyBytes != null;
            /* PKCS8EncodedKeySpec is for Private Key, NOTE X509EncodedKeySpec is a wrong type for Private Key, DON'T
            Use */
            EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(priKeyBytes);
            PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);
            // Return as keypair
            return new KeyPair(publicKey, privateKey);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Use Java to generate RSA keypair (self-make)
     */
    public static void generateKeyPair() throws NoSuchAlgorithmException {
        // generate keypair
        KeyPairGenerator generator = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        generator.initialize(2048);
        KeyPair pair = generator.generateKeyPair();
        // export pub & private key
        PublicKey pubKey = pair.getPublic();
        PrivateKey privateKey = pair.getPrivate();
        outputToFile(pubKey.getEncoded(), KEYFILE_PATH + PUBLIC_KEY_FILE_SELF_MAKE);
        outputToFile(privateKey.getEncoded(), KEYFILE_PATH + PRIVATE_KEY_FILE_SELF_MAKE);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        RSAKeyUtil.generateKeyPair();
    }
}
