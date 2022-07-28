package com.conurets.hcm.security.factory;

import com.conurets.hcm.base.cache.PreferenceCache;
import com.conurets.hcm.base.util.APConstants;
import com.conurets.hcm.base.util.HCMDateUtil;
import com.conurets.hcm.base.util.HCMUtil;
import com.conurets.hcm.security.model.CustomUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Component
public class JwtFactory implements Serializable {
    /**
     * getUsernameFromToken
     *
     * @param token
     * @return
     */
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    /**
     * getExpirationDateFromToken
     *
     * @param token
     * @return
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    /**
     * getClaimFromToken
     *
     * @param token
     * @param claimsResolver
     * @param <T>
     * @return
     */
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);

        return claimsResolver.apply(claims);
    }

    /**
     * getAllClaimsFromToken
     *
     * @param token
     * @return
     */
    private Claims getAllClaimsFromToken(String token) {
        String secret = PreferenceCache.getProperty(APConstants.JWT_SECRET);
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    /**
     * isTokenExpired
     *
     * @param token
     * @return
     */
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);

        return expiration.before(HCMDateUtil.getCurrentDate());
    }

    /**
     * generateToken
     *
     * @param userDetails
     * @return
     */
    public String generateToken(CustomUserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();

        return generateToken(claims, userDetails.getUsername());
    }

    /**
     * generateToken
     *
     * @param claims
     * @param subject
     * @return
     */
    private String generateToken(Map<String, Object> claims, String subject) {
        //String strSecret = PreferenceCache.getProperty(APConstants.JWT_SECRET);
        String strSecret = PreferenceCache.getProperty("conurets.hcm.jwt.secret");

        int iExpiration = HCMUtil.stringToInteger(PreferenceCache.getProperty(APConstants.JWT_EXPIRATION));
        String strIssuer = PreferenceCache.getProperty(APConstants.JWT_ISSUER);

        Date issuedAt = new Date(System.currentTimeMillis());
        Date expirationDate = new Date(System.currentTimeMillis() + iExpiration * 1000);

        /*logger.info("secret={}, expiration={}, issuer={}",
                strSecret, iExpiration, strIssuer);*/

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(issuedAt)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, strSecret)
                .compact();
    }

    /**
     * validateToken
     *
     * @param token
     * @param userDetails
     * @return
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);

        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
