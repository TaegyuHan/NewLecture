package co.kr.rlandboot3project.anorymous.auth.util;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Base64;

public class KeyGenerator {

    public static void main(String[] args) {
        // 키 생성하기
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512); // HS512 알고리즘에 적합한 키 생성

        System.out.println("Algorithm: " + key.getAlgorithm()); // 알고리즘 출력
        // 0AN1ESGiftOQvY1b9vCKG60bNapuPQHw8nk0iwQ4XPNAPKTJ9F4Jd+Bok7DWcjcGwPkggCbtYvV1hUiWVJYCqA==

        String base64Key = Base64.getEncoder().encodeToString(key.getEncoded()); // Base64로 인코딩하여 출력
        System.out.println("Generated Key: " + base64Key);
    }
}
