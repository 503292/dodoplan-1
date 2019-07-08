package com.maksym.dodoplan.service.impl;

import com.maksym.dodoplan.service.TokenService;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Slf4j
@Service(value = "tokenService")
public class JwtTokenServiceImpl implements TokenService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private final byte[] secret;
    private final String userIdClaim = "userIdClaim";
    private final Long allowedClockSkewSeconds;
    private final JwtParser jwtParser;

    public JwtTokenServiceImpl(@Value("${security.token.secret}") String secret,
                                @Value("${security.token.expire}") Long allowedClockSkewSeconds) {
        this.secret = secret.getBytes(StandardCharsets.UTF_8);
        this.allowedClockSkewSeconds = allowedClockSkewSeconds;
        jwtParser = Jwts.parser()
                .setSigningKey(this.secret)
                .setAllowedClockSkewSeconds(this.allowedClockSkewSeconds);
    }

    @Override
    public Long parseToken(String token) {
        try {
            Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);
            final Claims body = claimsJws.getBody();
            return body.get(userIdClaim, Long.class);
        } catch (ExpiredJwtException e) {
            log.debug("JWT token has expired: {}", e.getMessage());
            throw new CredentialsExpiredException("JWT is not valid", e);
        } catch (JwtException e) {
            log.debug("JWT is not valid: {}", e.getMessage());
            throw new BadCredentialsException("JWT is not valid", e);
        }

    }

    @Override
    public String createToken(Long id) {
        String token = Jwts.builder()
                .claim(userIdClaim, id)
                .signWith(SignatureAlgorithm.HS256, secret).compact();
        log.info(token);
        return token;
    }
}
