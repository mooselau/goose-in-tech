package crypto.jwt;

import java.util.Map;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;


public class JWTCryptoUtil {

    private String secret;
    private Algorithm hmac256;

    public JWTCryptoUtil() {
        secret = "secret";
        hmac256 = Algorithm.HMAC256(secret);
    }

    public String encryptAsToken(Map<String, Object> map) {
        return JWT.create().withPayload(map).sign(hmac256);
    }

    public void verifyToken(String jwtToken) {
        JWTVerifier verifier = JWT.require(hmac256).build();
        DecodedJWT jwt = verifier.verify(jwtToken);

        String header = jwt.getHeader();
        String payload = jwt.getPayload();
        String sign = jwt.getSignature();

        p("MAIN: " + String.format("Header[%s], Payload[%s], Sign[%s]", header, payload, sign));

        printTokenInfo(jwt.getClaims());
    }

    private void printTokenInfo(Map<String, Claim> map) {
        for (Map.Entry<String, Claim> entry : map.entrySet()) {
            p(String.format("Claim[%s, %s]", entry.getKey(), entry.getValue().toString()));
        }
    }

    private void p(String msg) {
        System.out.println(msg);
    }
}
