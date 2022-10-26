package crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import crypto.aes.AESCryptoUtil;
import crypto.digest.SHA256DigestUtil;
import crypto.rsa.RSACryptoUtil;


public class CryptoDemo {

    public CryptoDemo() throws NoSuchAlgorithmException, NoSuchPaddingException {
        // rsaCryptoUtil = new RSACryptoUtil();
        aesCryptoUtil = new AESCryptoUtil();
        sha256DigestUtil = new SHA256DigestUtil();
    }

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException {
        CryptoDemo demo = new CryptoDemo();
        demo.entrypoint();
    }

    private void entrypoint() {
        // doRSA();
        doAES();
        // doSign();
        // doSignWithSignature();
    }

    private void doSignWithSignature() {
        String message = "Wish you a good day!";

        try {
             String sign = rsaCryptoUtil.sign01(message);
             System.out.println("===> SIGN: \n" + sign);

            boolean result = rsaCryptoUtil.verify01(message, sign);
            System.out.println("===> SIGN VERIFY: \n" + result);
        } catch (SignatureException | NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    private SHA256DigestUtil sha256DigestUtil;

    private void doSign() {
        String message = "Wish you a good day!";

        // Sign = digest + crypto
        String sign;
        try {
            String messageHash = sha256DigestUtil.digest(message);
            sign = rsaCryptoUtil.sign(messageHash);
            System.out.println("===> SIGN: \n" + sign);
        } catch (BadPaddingException | IllegalBlockSizeException | InvalidKeyException e) {
            e.printStackTrace();
            return;
        }

        // Verify Sign = digest + decrypto
        try {
            String messageHash = sha256DigestUtil.digest(message);
            boolean result = rsaCryptoUtil.verify(sign, messageHash);
            System.out.println("===> SIGN VERIFY: \n" + result);
        } catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }

    private AESCryptoUtil aesCryptoUtil;

    private void doAES() {
        String message = "123456789012";
        String keyphrase = "password02";
        try {
            String encrypted = aesCryptoUtil.encrypt(message, keyphrase);
            System.out.println("==> Encrypted: \n" + encrypted);

            String decrypted = aesCryptoUtil.decrypt(encrypted, keyphrase);
            System.out.println("==> Decrypted: \n" + decrypted);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException
                | IllegalBlockSizeException | InvalidAlgorithmParameterException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    private RSACryptoUtil rsaCryptoUtil;

    private void doRSA() {
        String message = "I Love You!";
        try {
            String encrypted = rsaCryptoUtil.encrypt(message);
            System.out.println("==> Encrypted: \n" + encrypted);

            String decrypted = rsaCryptoUtil.decrypt(encrypted);
            System.out.println("==> Decrypted: \n" + decrypted);
        } catch (BadPaddingException | IllegalBlockSizeException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }
}
