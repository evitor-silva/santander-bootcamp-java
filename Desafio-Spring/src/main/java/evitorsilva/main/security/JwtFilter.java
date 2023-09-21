package evitorsilva.main.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String authHead = request.getHeader("Authorization");
        Algorithm algorithm = Algorithm.HMAC256("baeldung");

        var tka = JWT.require(algorithm)
                .build()
                .verify(authHead)
                .getSubject();

        System.out.println(tka);

        if (authHead == null) {
            filterChain.doFilter(request, response);
            return;
        }
    }
    /*
     * private boolean validateToken(String authToken) {
     * 
     * try {
     * JWT.require(Algorithm.HMAC512("dsf"))
     * .build()
     * .verify(authToken)
     * .getSubject();
     * 
     * return true;
     * } catch (SignatureException e) {
     * LOGGER.info("Invalid JWT signature: " + e.getMessage());
     * LOGGER.debug("Exception " + e.getMessage(), e);
     * return false;
     * }
     * }
     */

}
