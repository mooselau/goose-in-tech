package crypto;

import java.util.HashMap;
import java.util.Map;
import crypto.jwt.JWTCryptoUtil;


public class JWTDemo {

    public static void main(String[] args) {
        JWTDemo demo = new JWTDemo();
        demo.entrypoint();
    }

    JWTCryptoUtil jwtUtil = new JWTCryptoUtil();

    /**
     * 1. encrypt key info, like userId, expireTime, as jwt token;
     * 2. decrypt key info from jwt token;
     */
    public void entrypoint() {
        // claims stored in Map
        Map<String, Object> claimsMap = new HashMap<>();
        claimsMap.put("iss", "pure-jcore");
        long time = System.currentTimeMillis();
        claimsMap.put("exp", time);
        claimsMap.put("usr", "a1b2c3");

        String token = jwtUtil.encryptAsToken(claimsMap);

        p(token);

        jwtUtil.verifyToken(token);
    }

    private void p(String msg) {
        System.out.println(msg);
    }

}
