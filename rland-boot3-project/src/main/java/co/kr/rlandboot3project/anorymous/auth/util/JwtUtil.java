package co.kr.rlandboot3project.anorymous.auth.util;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import java.security.Key;
import java.util.List;

public class JwtUtil {

    private final Key secretKey;

    public JwtUtil(@Value("rland.jwt.secret") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.secretKey = Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean validateToken(String token) {
        return false;
    }

    public String extractUsername(String token) {
        return null;
    }

    public List<String> extractRoles(String token) {
        return null;
    }
}