import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.jetbrains.annotations.TestOnly;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    void testJwt(){
        Map<String,Object> map = new HashMap<>();
        map.put("id","1");
        map.put("username","ShangLin");
        String token = JWT.create()
                .withClaim("user",map)
                .withExpiresAt(
                        new Date(System.currentTimeMillis()+1000*60*60*3)
                ).sign(Algorithm.HMAC256("ShangLin"));
        System.out.println(token);
    }

    @Test
    void testJwtVerifier(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoiMSIsInVzZXJuYW1lIjoiU2hhbmdMaW4ifSwiZXhwIjoxNzMyNDQ5ODkyfQ.bdysu0ITh_2Y7S3GrZftBdmk3Bt6eoUgWWy8r6aYqzs";
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("ShangLin")).build();
        DecodedJWT jwt = jwtVerifier.verify(token);
        System.out.println(jwt.getClaim("user").asMap());
    }
}
